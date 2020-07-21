package com.google.android.gms.internal.vision;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzdc {
    public static <T> zzcz<T> zza(zzcz<T> zzcz) {
        if ((zzcz instanceof zzde) || (zzcz instanceof zzdb)) {
            return zzcz;
        }
        if (zzcz instanceof Serializable) {
            return new zzdb(zzcz);
        }
        return new zzde(zzcz);
    }

    public static <T> zzcz<T> zze(@NullableDecl T t) {
        return new zzdd(t);
    }
}
