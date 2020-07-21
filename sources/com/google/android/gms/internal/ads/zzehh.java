package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzehh implements zzehi {
    zzehh() {
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final Map<?, ?> zzan(Object obj) {
        return (zzehf) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final zzehg<?, ?> zzao(Object obj) {
        zzehd zzehd = (zzehd) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final Map<?, ?> zzap(Object obj) {
        return (zzehf) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final boolean zzaq(Object obj) {
        return !((zzehf) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final Object zzar(Object obj) {
        ((zzehf) obj).zzbcz();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final Object zzas(Object obj) {
        return zzehf.zzbgm().zzbgn();
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final Object zzf(Object obj, Object obj2) {
        zzehf zzehf = (zzehf) obj;
        zzehf zzehf2 = (zzehf) obj2;
        if (!zzehf2.isEmpty()) {
            if (!zzehf.isMutable()) {
                zzehf = zzehf.zzbgn();
            }
            zzehf.zza(zzehf2);
        }
        return zzehf;
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final int zzb(int i, Object obj, Object obj2) {
        zzehf zzehf = (zzehf) obj;
        zzehd zzehd = (zzehd) obj2;
        if (zzehf.isEmpty()) {
            return 0;
        }
        Iterator it2 = zzehf.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
