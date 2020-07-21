package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzki extends zzko {
    private final /* synthetic */ zzkd zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzki(zzkd zzkd) {
        super(zzkd, null);
        this.zza = zzkd;
    }

    @Override // com.google.android.gms.internal.measurement.zzko, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzkf(this.zza, null);
    }

    /* synthetic */ zzki(zzkd zzkd, zzkg zzkg) {
        this(zzkd);
    }
}
