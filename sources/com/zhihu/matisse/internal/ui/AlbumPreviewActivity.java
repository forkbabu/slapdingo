package com.zhihu.matisse.internal.ui;

import android.database.Cursor;
import android.os.Bundle;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.SelectionSpec;
import com.zhihu.matisse.internal.model.AlbumMediaCollection;
import com.zhihu.matisse.internal.ui.adapter.PreviewPagerAdapter;
import java.util.ArrayList;

public class AlbumPreviewActivity extends BasePreviewActivity implements AlbumMediaCollection.AlbumMediaCallbacks {
    public static final String EXTRA_ALBUM = "extra_album";
    public static final String EXTRA_ITEM = "extra_item";
    private AlbumMediaCollection mCollection = new AlbumMediaCollection();
    private boolean mIsAlreadySetPosition;

    @Override // com.zhihu.matisse.internal.model.AlbumMediaCollection.AlbumMediaCallbacks
    public void onAlbumMediaReset() {
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.zhihu.matisse.internal.ui.BasePreviewActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!SelectionSpec.getInstance().hasInited) {
            setResult(0);
            finish();
            return;
        }
        this.mCollection.onCreate(this, this);
        this.mCollection.load((Album) getIntent().getParcelableExtra("extra_album"));
        Item item = (Item) getIntent().getParcelableExtra(EXTRA_ITEM);
        if (this.mSpec.countable) {
            this.mCheckView.setCheckedNum(this.mSelectedCollection.checkedNumOf(item));
        } else {
            this.mCheckView.setChecked(this.mSelectedCollection.isSelected(item));
        }
        updateSize(item);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.mCollection.onDestroy();
    }

    @Override // com.zhihu.matisse.internal.model.AlbumMediaCollection.AlbumMediaCallbacks
    public void onAlbumMediaLoad(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(Item.valueOf(cursor));
        }
        if (!arrayList.isEmpty()) {
            PreviewPagerAdapter previewPagerAdapter = (PreviewPagerAdapter) this.mPager.getAdapter();
            previewPagerAdapter.addAll(arrayList);
            previewPagerAdapter.notifyDataSetChanged();
            if (!this.mIsAlreadySetPosition) {
                this.mIsAlreadySetPosition = true;
                int indexOf = arrayList.indexOf((Item) getIntent().getParcelableExtra(EXTRA_ITEM));
                this.mPager.setCurrentItem(indexOf, false);
                this.mPreviousPos = indexOf;
            }
        }
    }
}
