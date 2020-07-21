package com.dd.morphingbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.dd.morphingbutton.MorphingAnimation;

public class MorphingButton extends Button {
    protected boolean mAnimationInProgress;
    private int mColor;
    private int mCornerRadius;
    private StrokeGradientDrawable mDrawableNormal;
    private StrokeGradientDrawable mDrawablePressed;
    private int mHeight;
    private Padding mPadding;
    private int mStrokeColor;
    private int mStrokeWidth;
    private int mWidth;

    public MorphingButton(Context context) {
        super(context);
        initView();
    }

    public MorphingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MorphingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mHeight == 0 && this.mWidth == 0 && i != 0 && i2 != 0) {
            this.mHeight = getHeight();
            this.mWidth = getWidth();
        }
    }

    public StrokeGradientDrawable getDrawableNormal() {
        return this.mDrawableNormal;
    }

    public void morph(Params params) {
        if (!this.mAnimationInProgress) {
            this.mDrawablePressed.setColor(params.colorPressed);
            this.mDrawablePressed.setCornerRadius((float) params.cornerRadius);
            this.mDrawablePressed.setStrokeColor(params.strokeColor);
            this.mDrawablePressed.setStrokeWidth(params.strokeWidth);
            if (params.duration == 0) {
                morphWithoutAnimation(params);
            } else {
                morphWithAnimation(params);
            }
            this.mColor = params.color;
            this.mCornerRadius = params.cornerRadius;
            this.mStrokeWidth = params.strokeWidth;
            this.mStrokeColor = params.strokeColor;
        }
    }

    private void morphWithAnimation(final Params params) {
        this.mAnimationInProgress = true;
        setText((CharSequence) null);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(this.mPadding.left, this.mPadding.top, this.mPadding.right, this.mPadding.bottom);
        new MorphingAnimation(MorphingAnimation.Params.create(this).color(this.mColor, params.color).cornerRadius(this.mCornerRadius, params.cornerRadius).strokeWidth(this.mStrokeWidth, params.strokeWidth).strokeColor(this.mStrokeColor, params.strokeColor).height(getHeight(), params.height).width(getWidth(), params.width).duration(params.duration).listener(new MorphingAnimation.Listener() {
            /* class com.dd.morphingbutton.MorphingButton.AnonymousClass1 */

            @Override // com.dd.morphingbutton.MorphingAnimation.Listener
            public void onAnimationEnd() {
                MorphingButton.this.finalizeMorphing(params);
            }
        })).start();
    }

    private void morphWithoutAnimation(Params params) {
        this.mDrawableNormal.setColor(params.color);
        this.mDrawableNormal.setCornerRadius((float) params.cornerRadius);
        this.mDrawableNormal.setStrokeColor(params.strokeColor);
        this.mDrawableNormal.setStrokeWidth(params.strokeWidth);
        if (!(params.width == 0 || params.height == 0)) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = params.width;
            layoutParams.height = params.height;
            setLayoutParams(layoutParams);
        }
        finalizeMorphing(params);
    }

    /* access modifiers changed from: private */
    public void finalizeMorphing(Params params) {
        this.mAnimationInProgress = false;
        if (params.icon != 0 && params.text != null) {
            setIconLeft(params.icon);
            setText(params.text);
        } else if (params.icon != 0) {
            setIcon(params.icon);
        } else if (params.text != null) {
            setText(params.text);
        }
        if (params.animationListener != null) {
            params.animationListener.onAnimationEnd();
        }
    }

    public void blockTouch() {
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.dd.morphingbutton.MorphingButton.AnonymousClass2 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void unblockTouch() {
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.dd.morphingbutton.MorphingButton.AnonymousClass3 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    private void initView() {
        Padding padding = new Padding();
        this.mPadding = padding;
        padding.left = getPaddingLeft();
        this.mPadding.right = getPaddingRight();
        this.mPadding.top = getPaddingTop();
        this.mPadding.bottom = getPaddingBottom();
        Resources resources = getResources();
        int dimension = (int) resources.getDimension(R.dimen.mb_corner_radius_2);
        int color = resources.getColor(R.color.mb_blue);
        int color2 = resources.getColor(R.color.mb_blue_dark);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.mDrawableNormal = createDrawable(color, dimension, 0);
        StrokeGradientDrawable createDrawable = createDrawable(color2, dimension, 0);
        this.mDrawablePressed = createDrawable;
        this.mColor = color;
        this.mStrokeColor = color;
        this.mCornerRadius = dimension;
        stateListDrawable.addState(new int[]{16842919}, createDrawable.getGradientDrawable());
        stateListDrawable.addState(StateSet.WILD_CARD, this.mDrawableNormal.getGradientDrawable());
        setBackgroundCompat(stateListDrawable);
    }

    private StrokeGradientDrawable createDrawable(int i, int i2, int i3) {
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(new GradientDrawable());
        strokeGradientDrawable.getGradientDrawable().setShape(0);
        strokeGradientDrawable.setColor(i);
        strokeGradientDrawable.setCornerRadius((float) i2);
        strokeGradientDrawable.setStrokeColor(i);
        strokeGradientDrawable.setStrokeWidth(i3);
        return strokeGradientDrawable;
    }

    private void setBackgroundCompat(Drawable drawable) {
        if (Build.VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
    }

    public void setIcon(final int i) {
        post(new Runnable() {
            /* class com.dd.morphingbutton.MorphingButton.AnonymousClass4 */

            public void run() {
                int width = (MorphingButton.this.getWidth() / 2) - (MorphingButton.this.getResources().getDrawable(i).getIntrinsicWidth() / 2);
                MorphingButton.this.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
                MorphingButton.this.setPadding(width, 0, 0, 0);
            }
        });
    }

    public void setIconLeft(int i) {
        setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    private class Padding {
        public int bottom;
        public int left;
        public int right;
        public int top;

        private Padding() {
        }
    }

    public static class Params {
        /* access modifiers changed from: private */
        public MorphingAnimation.Listener animationListener;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public int colorPressed;
        /* access modifiers changed from: private */
        public int cornerRadius;
        /* access modifiers changed from: private */
        public int duration;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public int icon;
        /* access modifiers changed from: private */
        public int strokeColor;
        /* access modifiers changed from: private */
        public int strokeWidth;
        /* access modifiers changed from: private */
        public String text;
        /* access modifiers changed from: private */
        public int width;

        private Params() {
        }

        public static Params create() {
            return new Params();
        }

        public Params text(String str) {
            this.text = str;
            return this;
        }

        public Params icon(int i) {
            this.icon = i;
            return this;
        }

        public Params cornerRadius(int i) {
            this.cornerRadius = i;
            return this;
        }

        public Params width(int i) {
            this.width = i;
            return this;
        }

        public Params height(int i) {
            this.height = i;
            return this;
        }

        public Params color(int i) {
            this.color = i;
            return this;
        }

        public Params colorPressed(int i) {
            this.colorPressed = i;
            return this;
        }

        public Params duration(int i) {
            this.duration = i;
            return this;
        }

        public Params strokeWidth(int i) {
            this.strokeWidth = i;
            return this;
        }

        public Params strokeColor(int i) {
            this.strokeColor = i;
            return this;
        }

        public Params animationListener(MorphingAnimation.Listener listener) {
            this.animationListener = listener;
            return this;
        }
    }
}
