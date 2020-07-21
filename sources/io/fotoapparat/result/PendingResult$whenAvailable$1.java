package io.fotoapparat.result;

import io.fotoapparat.exception.UnableToDecodeBitmapException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "run"}, k = 3, mv = {1, 1, 13})
/* compiled from: PendingResult.kt */
final class PendingResult$whenAvailable$1 implements Runnable {
    final /* synthetic */ Function1 $callback;
    final /* synthetic */ PendingResult this$0;

    PendingResult$whenAvailable$1(PendingResult pendingResult, Function1 function1) {
        this.this$0 = pendingResult;
        this.$callback = function1;
    }

    public final void run() {
        try {
            final Object access$getResultUnsafe$p = this.this$0.getResultUnsafe();
            PendingResultKt.notifyOnMainThread(new Function0<Unit>(this) {
                /* class io.fotoapparat.result.PendingResult$whenAvailable$1.AnonymousClass1 */
                final /* synthetic */ PendingResult$whenAvailable$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    this.this$0.$callback.invoke(access$getResultUnsafe$p);
                }
            });
        } catch (UnableToDecodeBitmapException unused) {
            this.this$0.logger.log("Couldn't decode bitmap from byte array");
            PendingResultKt.notifyOnMainThread(new Function0<Unit>(this) {
                /* class io.fotoapparat.result.PendingResult$whenAvailable$1.AnonymousClass2 */
                final /* synthetic */ PendingResult$whenAvailable$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    this.this$0.$callback.invoke(null);
                }
            });
        } catch (InterruptedException unused2) {
            this.this$0.logger.log("Couldn't deliver pending result: Camera stopped before delivering result.");
        } catch (CancellationException unused3) {
            this.this$0.logger.log("Couldn't deliver pending result: Camera operation was cancelled.");
        } catch (ExecutionException unused4) {
            this.this$0.logger.log("Couldn't deliver pending result: Operation failed internally.");
            PendingResultKt.notifyOnMainThread(new Function0<Unit>(this) {
                /* class io.fotoapparat.result.PendingResult$whenAvailable$1.AnonymousClass3 */
                final /* synthetic */ PendingResult$whenAvailable$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    this.this$0.$callback.invoke(null);
                }
            });
        }
    }
}
