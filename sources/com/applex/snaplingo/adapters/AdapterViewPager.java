package com.applex.snaplingo.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.applex.snaplingo.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class AdapterViewPager extends PagerAdapter {
    private int bool;
    private Context context;
    private OnClickListener mListener;
    /* access modifiers changed from: private */
    public ArrayList<String> models;

    public interface OnClickListener {
        void onClickListener(int i);
    }

    public AdapterViewPager(ArrayList<String> arrayList, Context context2, int i) {
        this.models = arrayList;
        this.context = context2;
        this.bool = i;
    }

    public void onClickListener(OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, final int i) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_page, viewGroup, false);
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.item_page);
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.applex.snaplingo.adapters.AdapterViewPager.AnonymousClass1 */

            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = imageView.getMeasuredHeight();
                Picasso.get().load(Uri.parse((String) AdapterViewPager.this.models.get(i))).resize(imageView.getMeasuredWidth(), measuredHeight).placeholder(R.drawable.image_background_grey).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).priority(Picasso.Priority.LOW).centerInside().into(imageView);
                return true;
            }
        });
        viewGroup.addView(inflate, 0);
        imageView.setOnClickListener(new View.OnClickListener(i) {
            /* class com.applex.snaplingo.adapters.$$Lambda$AdapterViewPager$3I5nJJ6dy2v1SSifpL4dKWd34 */
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AdapterViewPager.this.lambda$instantiateItem$0$AdapterViewPager(this.f$1, view);
            }
        });
        return inflate;
    }

    public /* synthetic */ void lambda$instantiateItem$0$AdapterViewPager(int i, View view) {
        this.mListener.onClickListener(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.models.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }
}
