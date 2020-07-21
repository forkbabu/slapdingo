package com.thekhaeng.pushdownanim;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.ArrayList;
import java.util.List;

public class PushDownAnimList implements PushDown {
    private final List<PushDownAnim> pushDownList = new ArrayList();

    PushDownAnimList(View... viewArr) {
        for (View view : viewArr) {
            PushDownAnim pushDownAnimTo = PushDownAnim.setPushDownAnimTo(view);
            pushDownAnimTo.setOnTouchEvent(null);
            this.pushDownList.add(pushDownAnimTo);
        }
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDownAnimList setScale(float f) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            pushDownAnim.setScale(f);
        }
        return this;
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDown setScale(int i, float f) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            pushDownAnim.setScale(i, f);
        }
        return this;
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDownAnimList setDurationPush(long j) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            pushDownAnim.setDurationPush(j);
        }
        return this;
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDownAnimList setDurationRelease(long j) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            pushDownAnim.setDurationRelease(j);
        }
        return this;
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDownAnimList setInterpolatorPush(AccelerateDecelerateInterpolator accelerateDecelerateInterpolator) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            pushDownAnim.setInterpolatorPush(accelerateDecelerateInterpolator);
        }
        return this;
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDownAnimList setInterpolatorRelease(AccelerateDecelerateInterpolator accelerateDecelerateInterpolator) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            pushDownAnim.setInterpolatorRelease(accelerateDecelerateInterpolator);
        }
        return this;
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDownAnimList setOnClickListener(View.OnClickListener onClickListener) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            if (onClickListener != null) {
                pushDownAnim.setOnClickListener(onClickListener);
            }
        }
        return this;
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDown setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            if (onLongClickListener != null) {
                pushDownAnim.setOnLongClickListener(onLongClickListener);
            }
        }
        return this;
    }

    @Override // com.thekhaeng.pushdownanim.PushDown
    public PushDownAnimList setOnTouchEvent(View.OnTouchListener onTouchListener) {
        for (PushDownAnim pushDownAnim : this.pushDownList) {
            if (onTouchListener != null) {
                pushDownAnim.setOnTouchEvent(onTouchListener);
            }
        }
        return this;
    }
}
