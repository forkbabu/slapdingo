package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

abstract class BaseIndeterminateProgressDrawable extends BaseProgressDrawable implements Animatable {
    protected Animator[] mAnimators;

    public BaseIndeterminateProgressDrawable(Context context) {
        setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, -16777216, context));
    }

    @Override // me.zhanghai.android.materialprogressbar.BaseDrawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    public void start() {
        if (!isStarted()) {
            for (Animator animator : this.mAnimators) {
                animator.start();
            }
            invalidateSelf();
        }
    }

    private boolean isStarted() {
        for (Animator animator : this.mAnimators) {
            if (animator.isStarted()) {
                return true;
            }
        }
        return false;
    }

    public void stop() {
        for (Animator animator : this.mAnimators) {
            animator.end();
        }
    }

    public boolean isRunning() {
        for (Animator animator : this.mAnimators) {
            if (animator.isRunning()) {
                return true;
            }
        }
        return false;
    }
}
