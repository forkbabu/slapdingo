package io.fotoapparat.log;

import io.fotoapparat.log.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/fotoapparat/log/CompositeLogger;", "Lio/fotoapparat/log/Logger;", "loggers", "", "(Ljava/util/List;)V", "log", "", "message", "", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: CompositeLogger.kt */
public final class CompositeLogger implements Logger {
    private final List<Logger> loggers;

    public CompositeLogger(List<? extends Logger> list) {
        Intrinsics.checkParameterIsNotNull(list, "loggers");
        this.loggers = list;
    }

    @Override // io.fotoapparat.log.Logger
    public void recordMethod() {
        Logger.DefaultImpls.recordMethod(this);
    }

    @Override // io.fotoapparat.log.Logger
    public void log(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        for (Logger logger : this.loggers) {
            logger.log(str);
        }
    }
}
