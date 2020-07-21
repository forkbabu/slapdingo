package com.applex.snaplingo.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.applex.snaplingo.ActivityGrid;
import com.applex.snaplingo.R;
import com.applex.snaplingo.ViewPager;
import com.applex.snaplingo.adapters.ImageGridAdapter;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ImageGridAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private Context mContext;
    private ArrayList<String> mList;
    private OnClickListener mListener;

    public interface OnClickListener {
        void onClickListener(int i);
    }

    public ImageGridAdapter(ArrayList<String> arrayList, Context context) {
        this.mList = arrayList;
        this.mContext = context;
    }

    public void onClickListener(OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid, viewGroup, false), this.mListener);
    }

    public void onBindViewHolder(final ImageViewHolder imageViewHolder, int i) {
        final String str = this.mList.get(i);
        imageViewHolder.image.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.applex.snaplingo.adapters.ImageGridAdapter.AnonymousClass1 */

            public boolean onPreDraw() {
                imageViewHolder.image.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = imageViewHolder.image.getMeasuredHeight();
                Picasso.get().load(Uri.parse(str)).resize(imageViewHolder.image.getMeasuredWidth(), measuredHeight).placeholder(R.drawable.image_background_grey).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).priority(Picasso.Priority.HIGH).centerCrop().into(imageViewHolder.image);
                return true;
            }
        });
        imageViewHolder.image.setOnClickListener(new View.OnClickListener(i) {
            /* class com.applex.snaplingo.adapters.$$Lambda$ImageGridAdapter$OGUAgW0iEs5QzCI7gpDax8ASeKE */
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ImageGridAdapter.this.lambda$onBindViewHolder$0$ImageGridAdapter(this.f$1, view);
            }
        });
        imageViewHolder.count.setText(Integer.toString(i + 1));
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$ImageGridAdapter(int i, View view) {
        Intent intent = new Intent(this.mContext, ViewPager.class);
        intent.putExtra("from", ExifInterface.GPS_MEASUREMENT_2D);
        intent.putExtra("docName", ActivityGrid.document_name);
        intent.putExtra("pos", String.valueOf(i));
        this.mContext.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView count;
        ImageButton delete;
        CardView grid_page;
        ImageView image;

        public ImageViewHolder(View view, OnClickListener onClickListener) {
            super(view);
            this.count = (TextView) view.findViewById(R.id.count);
            this.image = (ImageView) view.findViewById(R.id.grid_image);
            this.delete = (ImageButton) view.findViewById(R.id.delete_image);
            this.grid_page = (CardView) view.findViewById(R.id.grid_page);
            this.delete.setOnClickListener(new View.OnClickListener(onClickListener) {
                /* class com.applex.snaplingo.adapters.$$Lambda$ImageGridAdapter$ImageViewHolder$LO1Va4gy6m58h3EP9xeMmurdvzc */
                public final /* synthetic */ ImageGridAdapter.OnClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ImageGridAdapter.ImageViewHolder.this.lambda$new$0$ImageGridAdapter$ImageViewHolder(this.f$1, view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$ImageGridAdapter$ImageViewHolder(OnClickListener onClickListener, View view) {
            int adapterPosition;
            if (onClickListener != null && (adapterPosition = getAdapterPosition()) != -1) {
                onClickListener.onClickListener(adapterPosition);
            }
        }
    }
}
