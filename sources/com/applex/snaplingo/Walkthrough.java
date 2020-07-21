package com.applex.snaplingo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Walkthrough extends AppCompatActivity {
    private TextView[] dots;
    private IntroPref introPref;
    private LinearLayout layoutDots;
    /* access modifiers changed from: private */
    public int[] layouts;
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        /* class com.applex.snaplingo.Walkthrough.AnonymousClass2 */

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Walkthrough.this.addBottomDots(i);
            if (i == Walkthrough.this.layouts.length - 1) {
                Walkthrough.this.tvNext.setText("Start");
            } else {
                Walkthrough.this.tvNext.setText("Next");
            }
        }
    };
    /* access modifiers changed from: private */
    public TextView tvNext;
    private TextView tvSkip;
    private ViewPager viewPager;
    private MyViewPagerAdapter viewPagerAdapter;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_walkthrough);
        IntroPref introPref2 = new IntroPref(this);
        this.introPref = introPref2;
        if (introPref2.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }
        this.tvNext = (TextView) findViewById(R.id.tvNext);
        this.tvSkip = (TextView) findViewById(R.id.tvSkip);
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        this.layoutDots = (LinearLayout) findViewById(R.id.layoutDots);
        this.layouts = new int[]{R.layout.intro_one, R.layout.intro_two, R.layout.intro_three};
        this.tvSkip.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.Walkthrough.AnonymousClass1 */

            public void onClick(View view) {
                Walkthrough.this.launchHomeScreen();
            }
        });
        this.tvNext.setOnClickListener(new View.OnClickListener() {
            /* class com.applex.snaplingo.$$Lambda$Walkthrough$0_7KY1eYGJCfkQw7NSm3XqdCc2o */

            public final void onClick(View view) {
                Walkthrough.this.lambda$onCreate$0$Walkthrough(view);
            }
        });
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter();
        this.viewPagerAdapter = myViewPagerAdapter;
        this.viewPager.setAdapter(myViewPagerAdapter);
        this.viewPager.addOnPageChangeListener(this.onPageChangeListener);
        addBottomDots(0);
    }

    public /* synthetic */ void lambda$onCreate$0$Walkthrough(View view) {
        int item = getItem(1);
        if (item < this.layouts.length) {
            this.viewPager.setCurrentItem(item);
        } else {
            launchHomeScreen();
        }
    }

    /* access modifiers changed from: private */
    public void addBottomDots(int i) {
        TextView[] textViewArr;
        this.dots = new TextView[this.layouts.length];
        int[] intArray = getResources().getIntArray(R.array.active);
        int[] intArray2 = getResources().getIntArray(R.array.inactive);
        this.layoutDots.removeAllViews();
        int i2 = 0;
        while (true) {
            textViewArr = this.dots;
            if (i2 >= textViewArr.length) {
                break;
            }
            textViewArr[i2] = new TextView(this);
            this.dots[i2].setText(Html.fromHtml("&#8226"));
            this.dots[i2].setTextSize(50.0f);
            this.dots[i2].setTextColor(intArray2[i]);
            this.layoutDots.addView(this.dots[i2]);
            i2++;
        }
        if (textViewArr.length > 0) {
            textViewArr[i].setTextColor(intArray[i]);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        LayoutInflater layoutInflater;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public MyViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater2 = (LayoutInflater) Walkthrough.this.getSystemService("layout_inflater");
            this.layoutInflater = layoutInflater2;
            View inflate = layoutInflater2.inflate(Walkthrough.this.layouts[i], viewGroup, false);
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return Walkthrough.this.layouts.length;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    private int getItem(int i) {
        return this.viewPager.getCurrentItem() + 1;
    }

    /* access modifiers changed from: private */
    public void launchHomeScreen() {
        this.introPref.setIsFirstTimeLaunch(false);
        startActivity(new Intent(this, MainActivity2.class));
        finish();
    }
}
