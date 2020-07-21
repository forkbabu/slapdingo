package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.utils.Platform;

public class AlbumsSpinner {
    private static final int MAX_SHOWN_COUNT = 6;
    /* access modifiers changed from: private */
    public CursorAdapter mAdapter;
    /* access modifiers changed from: private */
    public ListPopupWindow mListPopupWindow;
    /* access modifiers changed from: private */
    public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private TextView mSelected;

    public AlbumsSpinner(Context context) {
        ListPopupWindow listPopupWindow = new ListPopupWindow(context, null, R.attr.listPopupWindowStyle);
        this.mListPopupWindow = listPopupWindow;
        listPopupWindow.setModal(true);
        float f = context.getResources().getDisplayMetrics().density;
        this.mListPopupWindow.setContentWidth((int) (216.0f * f));
        this.mListPopupWindow.setHorizontalOffset((int) (16.0f * f));
        this.mListPopupWindow.setVerticalOffset((int) (f * -48.0f));
        this.mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.zhihu.matisse.internal.ui.widget.AlbumsSpinner.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlbumsSpinner.this.onItemSelected(adapterView.getContext(), i);
                if (AlbumsSpinner.this.mOnItemSelectedListener != null) {
                    AlbumsSpinner.this.mOnItemSelectedListener.onItemSelected(adapterView, view, i, j);
                }
            }
        });
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
    }

    public void setSelection(Context context, int i) {
        this.mListPopupWindow.setSelection(i);
        onItemSelected(context, i);
    }

    /* access modifiers changed from: private */
    public void onItemSelected(Context context, int i) {
        this.mListPopupWindow.dismiss();
        Cursor cursor = this.mAdapter.getCursor();
        cursor.moveToPosition(i);
        String displayName = Album.valueOf(cursor).getDisplayName(context);
        if (this.mSelected.getVisibility() == 0) {
            this.mSelected.setText(displayName);
        } else if (Platform.hasICS()) {
            this.mSelected.setAlpha(0.0f);
            this.mSelected.setVisibility(0);
            this.mSelected.setText(displayName);
            this.mSelected.animate().alpha(1.0f).setDuration((long) context.getResources().getInteger(17694722)).start();
        } else {
            this.mSelected.setVisibility(0);
            this.mSelected.setText(displayName);
        }
    }

    public void setAdapter(CursorAdapter cursorAdapter) {
        this.mListPopupWindow.setAdapter(cursorAdapter);
        this.mAdapter = cursorAdapter;
    }

    public void setSelectedTextView(TextView textView) {
        this.mSelected = textView;
        Drawable drawable = textView.getCompoundDrawables()[2];
        TypedArray obtainStyledAttributes = this.mSelected.getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.album_element_color});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        this.mSelected.setVisibility(8);
        this.mSelected.setOnClickListener(new View.OnClickListener() {
            /* class com.zhihu.matisse.internal.ui.widget.AlbumsSpinner.AnonymousClass2 */

            public void onClick(View view) {
                int i;
                int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.album_item_height);
                ListPopupWindow access$300 = AlbumsSpinner.this.mListPopupWindow;
                if (AlbumsSpinner.this.mAdapter.getCount() > 6) {
                    i = dimensionPixelSize * 6;
                } else {
                    i = dimensionPixelSize * AlbumsSpinner.this.mAdapter.getCount();
                }
                access$300.setHeight(i);
                AlbumsSpinner.this.mListPopupWindow.show();
            }
        });
        TextView textView2 = this.mSelected;
        textView2.setOnTouchListener(this.mListPopupWindow.createDragToOpenListener(textView2));
    }

    public void setPopupAnchorView(View view) {
        this.mListPopupWindow.setAnchorView(view);
    }
}
