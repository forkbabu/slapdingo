package com.dd.morphingbutton.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.dd.morphingbutton.IProgress;
import com.dd.morphingbutton.MorphingButton;

public class LinearProgressButton extends MorphingButton implements IProgress {
    public static final int MAX_PROGRESS = 100;
    public static final int MIN_PROGRESS = 0;
    private Paint mPaint;
    private int mProgress;
    private int mProgressColor;
    private int mProgressCornerRadius;
    private RectF mRectF;

    public LinearProgressButton(Context context) {
        super(context);
    }

    public LinearProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinearProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (!this.mAnimationInProgress && (i = this.mProgress) > 0 && i <= 100) {
            if (this.mPaint == null) {
                Paint paint = new Paint();
                this.mPaint = paint;
                paint.setAntiAlias(true);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mProgressColor);
            }
            if (this.mRectF == null) {
                this.mRectF = new RectF();
            }
            this.mRectF.right = (float) ((getWidth() / 100) * this.mProgress);
            this.mRectF.bottom = (float) getHeight();
            RectF rectF = this.mRectF;
            int i2 = this.mProgressCornerRadius;
            canvas.drawRoundRect(rectF, (float) i2, (float) i2, this.mPaint);
        }
    }

    @Override // com.dd.morphingbutton.MorphingButton
    public void morph(MorphingButton.Params params) {
        super.morph(params);
        this.mProgress = 0;
        this.mPaint = null;
        this.mRectF = null;
    }

    @Override // com.dd.morphingbutton.IProgress
    public void setProgress(int i) {
        this.mProgress = i;
        invalidate();
    }

    public void morphToProgress(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mProgressCornerRadius = i3;
        this.mProgressColor = i2;
        morph(MorphingButton.Params.create().duration(i6).cornerRadius(this.mProgressCornerRadius).width(i4).height(i5).color(i).colorPressed(i));
    }
}
