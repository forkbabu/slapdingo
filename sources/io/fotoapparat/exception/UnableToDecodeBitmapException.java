package io.fotoapparat.exception;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/fotoapparat/exception/UnableToDecodeBitmapException;", "Lio/fotoapparat/exception/RecoverableRuntimeException;", "()V", "fotoapparat_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: UnableToDecodeBitmapException.kt */
public final class UnableToDecodeBitmapException extends RecoverableRuntimeException {
    public UnableToDecodeBitmapException() {
        super("Unable to decode bitmap");
    }
}
