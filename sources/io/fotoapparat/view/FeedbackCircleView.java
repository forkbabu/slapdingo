package io.fotoapparat.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.fotoapparat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/fotoapparat/view/FeedbackCircleView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animatorSet", "Landroid/animation/AnimatorSet;", "inner", "Landroid/widget/ImageView;", "outer", "newAnimator", "Landroid/animation/Animator;", "kotlin.jvm.PlatformType", "id", "target", "Landroid/view/View;", "showAt", "", "x", "", "y", "showAt$fotoapparat_release", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: FeedbackCircleView.kt */
public final class FeedbackCircleView extends FrameLayout {
    private final AnimatorSet animatorSet;
    private final ImageView inner;
    private final ImageView outer;

    public FeedbackCircleView(Context context) {
        this(context, null, 0, 6, null);
    }

    public FeedbackCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedbackCircleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedbackCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        ImageView imageView = new ImageView(context, attributeSet, i);
        imageView.setImageResource(R.drawable.focus_inner);
        context.getResources();
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setAlpha(0.0f);
        this.inner = imageView;
        ImageView imageView2 = new ImageView(context, attributeSet, i);
        imageView2.setImageResource(R.drawable.focus_outer);
        context.getResources();
        imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView2.setAlpha(0.0f);
        this.outer = imageView2;
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(newAnimator(R.animator.focus_outer, this.outer), newAnimator(R.animator.focus_inner, this.inner));
        this.animatorSet = animatorSet2;
        Resources resources = context.getResources();
        setLayoutParams(new ViewGroup.LayoutParams(resources.getDimensionPixelSize(R.dimen.focus_diameter), resources.getDimensionPixelSize(R.dimen.focus_diameter)));
        setClipToPadding(false);
        setClipChildren(false);
        addView(this.outer);
        addView(this.inner);
    }

    public final void showAt$fotoapparat_release(float f, float f2) {
        setTranslationX(f);
        setTranslationY(f2);
        this.animatorSet.cancel();
        this.animatorSet.start();
    }

    private final Animator newAnimator(int i, View view) {
        Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), i);
        loadAnimator.setTarget(view);
        return loadAnimator;
    }
}
