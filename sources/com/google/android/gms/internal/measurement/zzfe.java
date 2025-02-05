package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzfe {
    @NullableDecl
    public static <T> T zza(Iterator<? extends T> it2, @NullableDecl T t) {
        if (it2.hasNext()) {
            return it2.next();
        }
        return null;
    }
}
