package io.fotoapparat.concurrent;

import androidx.core.app.NotificationCompat;
import io.fotoapparat.concurrent.CameraExecutor;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "T", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
/* compiled from: CameraExecutor.kt */
final class CameraExecutor$execute$future$1<V> implements Callable<T> {
    final /* synthetic */ CameraExecutor.Operation $operation;

    CameraExecutor$execute$future$1(CameraExecutor.Operation operation) {
        this.$operation = operation;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        return this.$operation.getFunction().invoke();
    }
}
