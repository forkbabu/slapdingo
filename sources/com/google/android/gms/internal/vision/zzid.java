package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzid implements zzia {
    zzid() {
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Map<?, ?> zzl(Object obj) {
        return (zzib) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final zzhy<?, ?> zzq(Object obj) {
        zzhz zzhz = (zzhz) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Map<?, ?> zzm(Object obj) {
        return (zzib) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final boolean zzn(Object obj) {
        return !((zzib) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzo(Object obj) {
        ((zzib) obj).zzdq();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzp(Object obj) {
        return zzib.zzhd().zzhe();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzc(Object obj, Object obj2) {
        zzib zzib = (zzib) obj;
        zzib zzib2 = (zzib) obj2;
        if (!zzib2.isEmpty()) {
            if (!zzib.isMutable()) {
                zzib = zzib.zzhe();
            }
            zzib.zza(zzib2);
        }
        return zzib;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final int zzb(int i, Object obj, Object obj2) {
        zzib zzib = (zzib) obj;
        zzhz zzhz = (zzhz) obj2;
        if (zzib.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzib.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
