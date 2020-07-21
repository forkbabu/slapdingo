package com.github.clans.fab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.TextView;

public class Label extends TextView {
    /* access modifiers changed from: private */
    public static final Xfermode PORTER_DUFF_CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private Drawable mBackgroundDrawable;
    /* access modifiers changed from: private */
    public int mColorNormal;
    private int mColorPressed;
    private int mColorRipple;
    /* access modifiers changed from: private */
    public int mCornerRadius;
    /* access modifiers changed from: private */
    public FloatingActionButton mFab;
    GestureDetector mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
        /* class com.github.clans.fab.Label.AnonymousClass2 */

        public boolean onDown(MotionEvent motionEvent) {
            Label.this.onActionDown();
            if (Label.this.mFab != null) {
                Label.this.mFab.onActionDown();
            }
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Label.this.onActionUp();
            if (Label.this.mFab != null) {
                Label.this.mFab.onActionUp();
            }
            return super.onSingleTapUp(motionEvent);
        }
    });
    private boolean mHandleVisibilityChanges = true;
    private Animation mHideAnimation;
    /* access modifiers changed from: private */
    public int mRawHeight;
    /* access modifiers changed from: private */
    public int mRawWidth;
    /* access modifiers changed from: private */
    public int mShadowColor;
    /* access modifiers changed from: private */
    public int mShadowRadius;
    /* access modifiers changed from: private */
    public int mShadowXOffset;
    /* access modifiers changed from: private */
    public int mShadowYOffset;
    private Animation mShowAnimation;
    private boolean mShowShadow = true;
    private boolean mUsingStyle;

    public Label(Context context) {
        super(context);
    }

    public Label(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Label(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(calculateMeasuredWidth(), calculateMeasuredHeight());
    }

    private int calculateMeasuredWidth() {
        if (this.mRawWidth == 0) {
            this.mRawWidth = getMeasuredWidth();
        }
        return getMeasuredWidth() + calculateShadowWidth();
    }

    private int calculateMeasuredHeight() {
        if (this.mRawHeight == 0) {
            this.mRawHeight = getMeasuredHeight();
        }
        return getMeasuredHeight() + calculateShadowHeight();
    }

    /* access modifiers changed from: package-private */
    public int calculateShadowWidth() {
        if (this.mShowShadow) {
            return this.mShadowRadius + Math.abs(this.mShadowXOffset);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int calculateShadowHeight() {
        if (this.mShowShadow) {
            return this.mShadowRadius + Math.abs(this.mShadowYOffset);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void updateBackground() {
        LayerDrawable layerDrawable;
        if (this.mShowShadow) {
            layerDrawable = new LayerDrawable(new Drawable[]{new Shadow(), createFillDrawable()});
            layerDrawable.setLayerInset(1, this.mShadowRadius + Math.abs(this.mShadowXOffset), this.mShadowRadius + Math.abs(this.mShadowYOffset), this.mShadowRadius + Math.abs(this.mShadowXOffset), this.mShadowRadius + Math.abs(this.mShadowYOffset));
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{createFillDrawable()});
        }
        setBackgroundCompat(layerDrawable);
    }

    private Drawable createFillDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, createRectDrawable(this.mColorPressed));
        stateListDrawable.addState(new int[0], createRectDrawable(this.mColorNormal));
        if (Util.hasLollipop()) {
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.mColorRipple}), stateListDrawable, null);
            setOutlineProvider(new ViewOutlineProvider() {
                /* class com.github.clans.fab.Label.AnonymousClass1 */

                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            setClipToOutline(true);
            this.mBackgroundDrawable = rippleDrawable;
            return rippleDrawable;
        }
        this.mBackgroundDrawable = stateListDrawable;
        return stateListDrawable;
    }

    private Drawable createRectDrawable(int i) {
        int i2 = this.mCornerRadius;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    private void setShadow(FloatingActionButton floatingActionButton) {
        this.mShadowColor = floatingActionButton.getShadowColor();
        this.mShadowRadius = floatingActionButton.getShadowRadius();
        this.mShadowXOffset = floatingActionButton.getShadowXOffset();
        this.mShadowYOffset = floatingActionButton.getShadowYOffset();
        this.mShowShadow = floatingActionButton.hasShadow();
    }

    private void setBackgroundCompat(Drawable drawable) {
        if (Util.hasJellyBean()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void playShowAnimation() {
        if (this.mShowAnimation != null) {
            this.mHideAnimation.cancel();
            startAnimation(this.mShowAnimation);
        }
    }

    private void playHideAnimation() {
        if (this.mHideAnimation != null) {
            this.mShowAnimation.cancel();
            startAnimation(this.mHideAnimation);
        }
    }

    /* access modifiers changed from: package-private */
    public void onActionDown() {
        if (this.mUsingStyle) {
            this.mBackgroundDrawable = getBackground();
        }
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{16842919});
        } else if (Util.hasLollipop()) {
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable2;
                rippleDrawable.setState(new int[]{16842910, 16842919});
                rippleDrawable.setHotspot((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
                rippleDrawable.setVisible(true, true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onActionUp() {
        if (this.mUsingStyle) {
            this.mBackgroundDrawable = getBackground();
        }
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[0]);
        } else if (Util.hasLollipop()) {
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable2;
                rippleDrawable.setState(new int[0]);
                rippleDrawable.setHotspot((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
                rippleDrawable.setVisible(true, true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setFab(FloatingActionButton floatingActionButton) {
        this.mFab = floatingActionButton;
        setShadow(floatingActionButton);
    }

    /* access modifiers changed from: package-private */
    public void setShowShadow(boolean z) {
        this.mShowShadow = z;
    }

    /* access modifiers changed from: package-private */
    public void setCornerRadius(int i) {
        this.mCornerRadius = i;
    }

    /* access modifiers changed from: package-private */
    public void setColors(int i, int i2, int i3) {
        this.mColorNormal = i;
        this.mColorPressed = i2;
        this.mColorRipple = i3;
    }

    /* access modifiers changed from: package-private */
    public void show(boolean z) {
        if (z) {
            playShowAnimation();
        }
        setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void hide(boolean z) {
        if (z) {
            playHideAnimation();
        }
        setVisibility(4);
    }

    /* access modifiers changed from: package-private */
    public void setShowAnimation(Animation animation) {
        this.mShowAnimation = animation;
    }

    /* access modifiers changed from: package-private */
    public void setHideAnimation(Animation animation) {
        this.mHideAnimation = animation;
    }

    /* access modifiers changed from: package-private */
    public void setUsingStyle(boolean z) {
        this.mUsingStyle = z;
    }

    /* access modifiers changed from: package-private */
    public void setHandleVisibilityChanges(boolean z) {
        this.mHandleVisibilityChanges = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isHandleVisibilityChanges() {
        return this.mHandleVisibilityChanges;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        FloatingActionButton floatingActionButton = this.mFab;
        if (floatingActionButton == null || floatingActionButton.getOnClickListener() == null || !this.mFab.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            onActionUp();
            this.mFab.onActionUp();
        } else if (action == 3) {
            onActionUp();
            this.mFab.onActionUp();
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    private class Shadow extends Drawable {
        private Paint mErase;
        private Paint mPaint;

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        private Shadow() {
            this.mPaint = new Paint(1);
            this.mErase = new Paint(1);
            init();
        }

        private void init() {
            Label.this.setLayerType(1, null);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(Label.this.mColorNormal);
            this.mErase.setXfermode(Label.PORTER_DUFF_CLEAR);
            if (!Label.this.isInEditMode()) {
                this.mPaint.setShadowLayer((float) Label.this.mShadowRadius, (float) Label.this.mShadowXOffset, (float) Label.this.mShadowYOffset, Label.this.mShadowColor);
            }
        }

        public void draw(Canvas canvas) {
            RectF rectF = new RectF((float) (Label.this.mShadowRadius + Math.abs(Label.this.mShadowXOffset)), (float) (Label.this.mShadowRadius + Math.abs(Label.this.mShadowYOffset)), (float) Label.this.mRawWidth, (float) Label.this.mRawHeight);
            canvas.drawRoundRect(rectF, (float) Label.this.mCornerRadius, (float) Label.this.mCornerRadius, this.mPaint);
            canvas.drawRoundRect(rectF, (float) Label.this.mCornerRadius, (float) Label.this.mCornerRadius, this.mErase);
        }
    }
}
