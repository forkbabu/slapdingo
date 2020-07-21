package com.dd.morphingbutton;

import android.graphics.drawable.GradientDrawable;

public class StrokeGradientDrawable {
    private int mColor;
    private GradientDrawable mGradientDrawable;
    private float mRadius;
    private int mStrokeColor;
    private int mStrokeWidth;

    public StrokeGradientDrawable(GradientDrawable gradientDrawable) {
        this.mGradientDrawable = gradientDrawable;
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeWidth(int i) {
        this.mStrokeWidth = i;
        this.mGradientDrawable.setStroke(i, getStrokeColor());
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
        this.mGradientDrawable.setStroke(getStrokeWidth(), i);
    }

    public void setCornerRadius(float f) {
        this.mRadius = f;
        this.mGradientDrawable.setCornerRadius(f);
    }

    public void setColor(int i) {
        this.mColor = i;
        this.mGradientDrawable.setColor(i);
    }

    public int getColor() {
        return this.mColor;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public GradientDrawable getGradientDrawable() {
        return this.mGradientDrawable;
    }
}
