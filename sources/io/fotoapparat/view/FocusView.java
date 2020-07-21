package io.fotoapparat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.fotoapparat.hardware.metering.FocalRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000f\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u001c\u0010\u0019\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lio/fotoapparat/view/FocusView;", "Landroid/widget/FrameLayout;", "Lio/fotoapparat/view/FocalPointSelector;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusMeteringListener", "Lkotlin/Function1;", "Lio/fotoapparat/hardware/metering/FocalRequest;", "", "gestureDetectorListener", "io/fotoapparat/view/FocusView$gestureDetectorListener$1", "Lio/fotoapparat/view/FocusView$gestureDetectorListener$1;", "tapDetector", "Landroid/view/GestureDetector;", "visualFeedbackCircle", "Lio/fotoapparat/view/FeedbackCircleView;", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setFocalPointListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: FocusView.kt */
public final class FocusView extends FrameLayout implements FocalPointSelector {
    /* access modifiers changed from: private */
    public Function1<? super FocalRequest, Unit> focusMeteringListener;
    private final FocusView$gestureDetectorListener$1 gestureDetectorListener;
    private final GestureDetector tapDetector;
    /* access modifiers changed from: private */
    public final FeedbackCircleView visualFeedbackCircle;

    public FocusView(Context context) {
        this(context, null, 0, 6, null);
    }

    public FocusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.visualFeedbackCircle = new FeedbackCircleView(context, attributeSet, i);
        setClipToPadding(false);
        setClipChildren(false);
        addView(this.visualFeedbackCircle);
        this.gestureDetectorListener = new FocusView$gestureDetectorListener$1(this);
        this.tapDetector = new GestureDetector(context, this.gestureDetectorListener);
    }

    @Override // io.fotoapparat.view.FocalPointSelector
    public void setFocalPointListener(Function1<? super FocalRequest, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.focusMeteringListener = function1;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, NotificationCompat.CATEGORY_EVENT);
        this.tapDetector.onTouchEvent(motionEvent);
        return true;
    }
}
