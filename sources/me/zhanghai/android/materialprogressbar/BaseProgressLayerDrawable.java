package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable;
import me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable;
import me.zhanghai.android.materialprogressbar.TintableDrawable;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

class BaseProgressLayerDrawable<ProgressDrawableType extends IntrinsicPaddingDrawable & ShowBackgroundDrawable & TintableDrawable, BackgroundDrawableType extends IntrinsicPaddingDrawable & ShowBackgroundDrawable & TintableDrawable> extends LayerDrawable implements IntrinsicPaddingDrawable, MaterialProgressDrawable, ShowBackgroundDrawable, TintableDrawable {
    private float mBackgroundAlpha;
    private BackgroundDrawableType mBackgroundDrawable = getDrawable(0);
    private ProgressDrawableType mProgressDrawable;
    private ProgressDrawableType mSecondaryProgressDrawable;

    public BaseProgressLayerDrawable(Drawable[] drawableArr, Context context) {
        super(drawableArr);
        this.mBackgroundAlpha = ThemeUtils.getFloatFromAttrRes(16842803, 0.0f, context);
        setId(0, 16908288);
        setId(1, 16908303);
        this.mSecondaryProgressDrawable = getDrawable(1);
        setId(2, 16908301);
        this.mProgressDrawable = getDrawable(2);
        setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, -16777216, context));
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public boolean getShowBackground() {
        return this.mBackgroundDrawable.getShowBackground();
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public void setShowBackground(boolean z) {
        if (this.mBackgroundDrawable.getShowBackground() != z) {
            this.mBackgroundDrawable.setShowBackground(z);
            this.mSecondaryProgressDrawable.setShowBackground(!z);
        }
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public boolean getUseIntrinsicPadding() {
        return this.mBackgroundDrawable.getUseIntrinsicPadding();
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public void setUseIntrinsicPadding(boolean z) {
        this.mBackgroundDrawable.setUseIntrinsicPadding(z);
        this.mSecondaryProgressDrawable.setUseIntrinsicPadding(z);
        this.mProgressDrawable.setUseIntrinsicPadding(z);
    }

    @Override // me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTint(int i) {
        int alphaComponent = ColorUtils.setAlphaComponent(i, Math.round(((float) Color.alpha(i)) * this.mBackgroundAlpha));
        this.mBackgroundDrawable.setTint(alphaComponent);
        this.mSecondaryProgressDrawable.setTint(alphaComponent);
        this.mProgressDrawable.setTint(i);
    }

    @Override // me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTintList(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (colorStateList != null) {
            if (!colorStateList.isOpaque()) {
                Log.w(getClass().getSimpleName(), "setTintList() called with a non-opaque ColorStateList, its original alpha will be discarded");
            }
            colorStateList2 = colorStateList.withAlpha(Math.round(this.mBackgroundAlpha * 255.0f));
        } else {
            colorStateList2 = null;
        }
        this.mBackgroundDrawable.setTintList(colorStateList2);
        this.mSecondaryProgressDrawable.setTintList(colorStateList2);
        this.mProgressDrawable.setTintList(colorStateList);
    }

    @Override // me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mBackgroundDrawable.setTintMode(mode);
        this.mSecondaryProgressDrawable.setTintMode(mode);
        this.mProgressDrawable.setTintMode(mode);
    }
}
