package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzjf implements zzjg {
    zzjf() {
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final Map<?, ?> zza(Object obj) {
        return (zzjd) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final zzje<?, ?> zzb(Object obj) {
        zzjb zzjb = (zzjb) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final Map<?, ?> zzc(Object obj) {
        return (zzjd) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final boolean zzd(Object obj) {
        return !((zzjd) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final Object zze(Object obj) {
        ((zzjd) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final Object zzf(Object obj) {
        return zzjd.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final Object zza(Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjd zzjd2 = (zzjd) obj2;
        if (!zzjd2.isEmpty()) {
            if (!zzjd.zzd()) {
                zzjd = zzjd.zzb();
            }
            zzjd.zza(zzjd2);
        }
        return zzjd;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final int zza(int i, Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjb zzjb = (zzjb) obj2;
        if (zzjd.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzjd.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
