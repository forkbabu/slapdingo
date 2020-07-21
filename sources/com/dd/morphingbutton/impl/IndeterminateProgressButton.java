package com.dd.morphingbutton.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.dd.morphingbutton.MorphingAnimation;
import com.dd.morphingbutton.MorphingButton;
import com.dd.morphingbutton.R;

public class IndeterminateProgressButton extends MorphingButton {
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    /* access modifiers changed from: private */
    public boolean mIsRunning;
    private ProgressBar mProgressBar;
    private int mProgressCornerRadius;

    public IndeterminateProgressButton(Context context) {
        super(context);
        init(context);
    }

    public IndeterminateProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public IndeterminateProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.mColor1 = resources.getColor(R.color.mb_gray);
        this.mColor2 = resources.getColor(R.color.mb_blue);
        this.mColor3 = resources.getColor(R.color.mb_gray);
        this.mColor4 = resources.getColor(R.color.mb_blue);
        if (Build.VERSION.SDK_INT <= 18) {
            setLayerType(1, null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mAnimationInProgress && this.mIsRunning) {
            if (this.mProgressBar == null) {
                this.mProgressBar = new ProgressBar(this);
                setupProgressBarBounds();
                this.mProgressBar.setColorScheme(this.mColor1, this.mColor2, this.mColor3, this.mColor4);
                this.mProgressBar.start();
            }
            this.mProgressBar.draw(canvas);
        }
    }

    @Override // com.dd.morphingbutton.MorphingButton
    public void morph(MorphingButton.Params params) {
        this.mIsRunning = false;
        super.morph(params);
    }

    public void morphToProgress(int i, int i2, int i3, int i4, int i5, int i6) {
        morphToProgress(i, i2, i3, i4, i5, i, i6, i, i6);
    }

    public void morphToProgress(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        morphToProgress(i, i2, i3, i4, i5, i6, i7, i6, i7);
    }

    public void morphToProgress(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mProgressCornerRadius = i2;
        this.mColor1 = i6;
        this.mColor2 = i7;
        this.mColor3 = i8;
        this.mColor4 = i9;
        morph(MorphingButton.Params.create().duration(i5).cornerRadius(this.mProgressCornerRadius).width(i3).height(i4).color(i).colorPressed(i).animationListener(new MorphingAnimation.Listener() {
            /* class com.dd.morphingbutton.impl.IndeterminateProgressButton.AnonymousClass1 */

            @Override // com.dd.morphingbutton.MorphingAnimation.Listener
            public void onAnimationEnd() {
                boolean unused = IndeterminateProgressButton.this.mIsRunning = true;
                IndeterminateProgressButton.this.invalidate();
            }
        }));
    }

    private void setupProgressBarBounds() {
        double measuredHeight = (double) getMeasuredHeight();
        this.mProgressBar.setBounds(0, (int) (measuredHeight - ((double) getHeight())), getMeasuredWidth(), getMeasuredHeight(), this.mProgressCornerRadius);
    }

    public static class ProgressBar {
        private static final int ANIMATION_DURATION_MS = 2000;
        private static final int COLOR1 = -1291845632;
        private static final int COLOR2 = Integer.MIN_VALUE;
        private static final int COLOR3 = 1291845632;
        private static final int COLOR4 = 436207616;
        private static final int FINISH_ANIMATION_DURATION_MS = 1000;
        private static final Interpolator INTERPOLATOR = new AccelerateDecelerateInterpolator();
        private RectF mBounds = new RectF();
        private final RectF mClipRect = new RectF();
        private int mColor1;
        private int mColor2;
        private int mColor3;
        private int mColor4;
        private int mCornerRadius;
        private long mFinishTime;
        private final Paint mPaint = new Paint();
        private View mParent;
        private boolean mRunning;
        private long mStartTime;
        private float mTriggerPercentage;

        public ProgressBar(View view) {
            this.mParent = view;
            this.mColor1 = COLOR1;
            this.mColor2 = Integer.MIN_VALUE;
            this.mColor3 = COLOR3;
            this.mColor4 = COLOR4;
        }

        /* access modifiers changed from: package-private */
        public void setColorScheme(int i, int i2, int i3, int i4) {
            this.mColor1 = i;
            this.mColor2 = i2;
            this.mColor3 = i3;
            this.mColor4 = i4;
        }

        /* access modifiers changed from: package-private */
        public void start() {
            if (!this.mRunning) {
                this.mTriggerPercentage = 0.0f;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.mRunning = true;
                this.mParent.postInvalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public void draw(Canvas canvas) {
            long j;
            boolean z;
            Path path = new Path();
            RectF rectF = this.mBounds;
            int i = this.mCornerRadius;
            path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CW);
            int height = (int) this.mBounds.height();
            int width = ((int) this.mBounds.width()) / 2;
            int i2 = height / 2;
            int save = canvas.save();
            canvas.clipPath(path);
            if (this.mRunning || this.mFinishTime > 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j2 = this.mStartTime;
                long j3 = (currentAnimationTimeMillis - j2) / 2000;
                float f = ((float) ((currentAnimationTimeMillis - j2) % 2000)) / 20.0f;
                if (!this.mRunning) {
                    long j4 = this.mFinishTime;
                    if (currentAnimationTimeMillis - j4 >= 1000) {
                        this.mFinishTime = 0;
                        return;
                    }
                    j = j3;
                    float f2 = (float) width;
                    float interpolation = INTERPOLATOR.getInterpolation((((float) ((currentAnimationTimeMillis - j4) % 1000)) / 10.0f) / 100.0f) * f2;
                    this.mClipRect.set(f2 - interpolation, 0.0f, f2 + interpolation, (float) height);
                    canvas.saveLayerAlpha(this.mClipRect, 0, 0);
                    z = true;
                } else {
                    j = j3;
                    z = false;
                }
                if (j == 0) {
                    canvas.drawColor(this.mColor1);
                } else if (f >= 0.0f && f < 25.0f) {
                    canvas.drawColor(this.mColor4);
                } else if (f >= 25.0f && f < 50.0f) {
                    canvas.drawColor(this.mColor1);
                } else if (f < 50.0f || f >= 75.0f) {
                    canvas.drawColor(this.mColor3);
                } else {
                    canvas.drawColor(this.mColor2);
                }
                int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i3 >= 0 && f <= 25.0f) {
                    drawCircle(canvas, (float) width, (float) i2, this.mColor1, ((f + 25.0f) * 2.0f) / 100.0f);
                }
                if (i3 >= 0 && f <= 50.0f) {
                    drawCircle(canvas, (float) width, (float) i2, this.mColor2, (f * 2.0f) / 100.0f);
                }
                if (f >= 25.0f && f <= 75.0f) {
                    drawCircle(canvas, (float) width, (float) i2, this.mColor3, ((f - 25.0f) * 2.0f) / 100.0f);
                }
                if (f >= 50.0f && f <= 100.0f) {
                    drawCircle(canvas, (float) width, (float) i2, this.mColor4, ((f - 50.0f) * 2.0f) / 100.0f);
                }
                if (f >= 75.0f && f <= 100.0f) {
                    drawCircle(canvas, (float) width, (float) i2, this.mColor1, ((f - 75.0f) * 2.0f) / 100.0f);
                }
                if (this.mTriggerPercentage > 0.0f && z) {
                    canvas.restoreToCount(save);
                    int save2 = canvas.save();
                    canvas.clipPath(path);
                    drawTrigger(canvas, width, i2);
                    save = save2;
                }
                ViewCompat.postInvalidateOnAnimation(this.mParent);
            } else {
                float f3 = this.mTriggerPercentage;
                if (f3 > 0.0f && ((double) f3) <= 1.0d) {
                    drawTrigger(canvas, width, i2);
                }
            }
            canvas.restoreToCount(save);
        }

        private void drawTrigger(Canvas canvas, int i, int i2) {
            this.mPaint.setColor(this.mColor1);
            float f = (float) i;
            canvas.drawCircle(f, (float) i2, this.mTriggerPercentage * f, this.mPaint);
        }

        private void drawCircle(Canvas canvas, float f, float f2, int i, float f3) {
            this.mPaint.setColor(i);
            canvas.save();
            canvas.translate(f, f2);
            float interpolation = INTERPOLATOR.getInterpolation(f3);
            canvas.scale(interpolation, interpolation);
            canvas.drawCircle(0.0f, 0.0f, f, this.mPaint);
            canvas.restore();
        }

        /* access modifiers changed from: package-private */
        public void setBounds(int i, int i2, int i3, int i4, int i5) {
            this.mBounds.left = (float) i;
            this.mBounds.top = (float) i2;
            this.mBounds.right = (float) i3;
            this.mBounds.bottom = (float) i4;
            this.mCornerRadius = i5;
        }
    }
}
