package io.fotoapparat.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import io.fotoapparat.hardware.metering.FocalRequest;
import io.fotoapparat.hardware.metering.PointF;
import io.fotoapparat.parameter.Resolution;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"io/fotoapparat/view/FocusView$gestureDetectorListener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: FocusView.kt */
public final class FocusView$gestureDetectorListener$1 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ FocusView this$0;

    FocusView$gestureDetectorListener$1(FocusView focusView) {
        this.this$0 = focusView;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(motionEvent, "e");
        Function1 access$getFocusMeteringListener$p = this.this$0.focusMeteringListener;
        if (access$getFocusMeteringListener$p == null) {
            return super.onSingleTapUp(motionEvent);
        }
        access$getFocusMeteringListener$p.invoke(new FocalRequest(new PointF(motionEvent.getX(), motionEvent.getY()), new Resolution(this.this$0.getWidth(), this.this$0.getHeight())));
        this.this$0.visualFeedbackCircle.showAt$fotoapparat_release(motionEvent.getX() - ((float) (this.this$0.visualFeedbackCircle.getWidth() / 2)), motionEvent.getY() - ((float) (this.this$0.visualFeedbackCircle.getHeight() / 2)));
        this.this$0.performClick();
        return true;
    }
}
