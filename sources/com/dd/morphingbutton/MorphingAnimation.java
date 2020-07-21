package com.dd.morphingbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.itextpdf.text.html.HtmlTags;

public class MorphingAnimation {
    /* access modifiers changed from: private */
    public Params mParams;

    public interface Listener {
        void onAnimationEnd();
    }

    public static class Params {
        /* access modifiers changed from: private */
        public Listener animationListener;
        /* access modifiers changed from: private */
        public MorphingButton button;
        /* access modifiers changed from: private */
        public int duration;
        /* access modifiers changed from: private */
        public int fromColor;
        /* access modifiers changed from: private */
        public float fromCornerRadius;
        /* access modifiers changed from: private */
        public int fromHeight;
        /* access modifiers changed from: private */
        public int fromStrokeColor;
        /* access modifiers changed from: private */
        public int fromStrokeWidth;
        /* access modifiers changed from: private */
        public int fromWidth;
        /* access modifiers changed from: private */
        public int toColor;
        /* access modifiers changed from: private */
        public float toCornerRadius;
        /* access modifiers changed from: private */
        public int toHeight;
        /* access modifiers changed from: private */
        public int toStrokeColor;
        /* access modifiers changed from: private */
        public int toStrokeWidth;
        /* access modifiers changed from: private */
        public int toWidth;

        private Params(MorphingButton morphingButton) {
            this.button = morphingButton;
        }

        public static Params create(MorphingButton morphingButton) {
            return new Params(morphingButton);
        }

        public Params duration(int i) {
            this.duration = i;
            return this;
        }

        public Params listener(Listener listener) {
            this.animationListener = listener;
            return this;
        }

        public Params color(int i, int i2) {
            this.fromColor = i;
            this.toColor = i2;
            return this;
        }

        public Params cornerRadius(int i, int i2) {
            this.fromCornerRadius = (float) i;
            this.toCornerRadius = (float) i2;
            return this;
        }

        public Params height(int i, int i2) {
            this.fromHeight = i;
            this.toHeight = i2;
            return this;
        }

        public Params width(int i, int i2) {
            this.fromWidth = i;
            this.toWidth = i2;
            return this;
        }

        public Params strokeWidth(int i, int i2) {
            this.fromStrokeWidth = i;
            this.toStrokeWidth = i2;
            return this;
        }

        public Params strokeColor(int i, int i2) {
            this.fromStrokeColor = i;
            this.toStrokeColor = i2;
            return this;
        }
    }

    public MorphingAnimation(Params params) {
        this.mParams = params;
    }

    public void start() {
        StrokeGradientDrawable drawableNormal = this.mParams.button.getDrawableNormal();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(drawableNormal, "cornerRadius", this.mParams.fromCornerRadius, this.mParams.toCornerRadius);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(drawableNormal, "strokeWidth", this.mParams.fromStrokeWidth, this.mParams.toStrokeWidth);
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(drawableNormal, "strokeColor", this.mParams.fromStrokeColor, this.mParams.toStrokeColor);
        ofInt2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(drawableNormal, HtmlTags.COLOR, this.mParams.fromColor, this.mParams.toColor);
        ofInt3.setEvaluator(new ArgbEvaluator());
        ValueAnimator ofInt4 = ValueAnimator.ofInt(this.mParams.fromHeight, this.mParams.toHeight);
        ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.dd.morphingbutton.MorphingAnimation.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = MorphingAnimation.this.mParams.button.getLayoutParams();
                layoutParams.height = intValue;
                MorphingAnimation.this.mParams.button.setLayoutParams(layoutParams);
            }
        });
        ValueAnimator ofInt5 = ValueAnimator.ofInt(this.mParams.fromWidth, this.mParams.toWidth);
        ofInt5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.dd.morphingbutton.MorphingAnimation.AnonymousClass2 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = MorphingAnimation.this.mParams.button.getLayoutParams();
                layoutParams.width = intValue;
                MorphingAnimation.this.mParams.button.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration((long) this.mParams.duration);
        animatorSet.playTogether(ofInt, ofInt2, ofFloat, ofInt3, ofInt4, ofInt5);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            /* class com.dd.morphingbutton.MorphingAnimation.AnonymousClass3 */

            public void onAnimationEnd(Animator animator) {
                if (MorphingAnimation.this.mParams.animationListener != null) {
                    MorphingAnimation.this.mParams.animationListener.onAnimationEnd();
                }
            }
        });
        animatorSet.start();
    }
}
