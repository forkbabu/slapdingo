package com.google.android.gms.internal.measurement;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public class zzfb<K, V> extends zzew<K, V> implements zzfg<K, V> {
    private final transient zzey<V> zza;

    zzfb(zzeu<K, zzey<V>> zzeu, int i, @NullableDecl Comparator<? super V> comparator) {
        super(zzeu, i);
        zzey<V> zzey;
        if (comparator == null) {
            zzey = zzft.zza;
        } else {
            zzey = zzfd.zza(comparator);
        }
        this.zza = zzey;
    }
}
