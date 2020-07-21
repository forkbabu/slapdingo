package io.fotoapparat.log;

import io.fotoapparat.hardware.ExecutorKt;
import io.fotoapparat.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lio/fotoapparat/log/BackgroundThreadLogger;", "Lio/fotoapparat/log/Logger;", "logger", "(Lio/fotoapparat/log/Logger;)V", "log", "", "message", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: BackgroundThreadLogger.kt */
public final class BackgroundThreadLogger implements Logger {
    /* access modifiers changed from: private */
    public final Logger logger;

    public BackgroundThreadLogger(Logger logger2) {
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.logger = logger2;
    }

    @Override // io.fotoapparat.log.Logger
    public void recordMethod() {
        Logger.DefaultImpls.recordMethod(this);
    }

    @Override // io.fotoapparat.log.Logger
    public void log(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        ExecutorKt.executeLoggingThread(new BackgroundThreadLogger$log$1(this, str));
    }
}
