package io.fotoapparat.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/fotoapparat/exception/FileSaveException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "cause", "", "(Ljava/lang/Throwable;)V", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: FileSaveException.kt */
public final class FileSaveException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSaveException(Throwable th) {
        super(th);
        Intrinsics.checkParameterIsNotNull(th, "cause");
    }
}
