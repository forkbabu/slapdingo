package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzehc implements zzeik {
    private static final zzehm zzigj = new zzehb();
    private final zzehm zzigi;

    public zzehc() {
        this(new zzehe(zzegc.zzbfl(), zzbgl()));
    }

    private zzehc(zzehm zzehm) {
        this.zzigi = (zzehm) zzegd.zza(zzehm, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.ads.zzeik
    public final <T> zzeih<T> zzg(Class<T> cls) {
        zzeij.zzi(cls);
        zzehj zzf = this.zzigi.zzf(cls);
        if (zzf.zzbgq()) {
            if (zzegb.class.isAssignableFrom(cls)) {
                return zzehr.zza(zzeij.zzbhg(), zzefr.zzbet(), zzf.zzbgr());
            }
            return zzehr.zza(zzeij.zzbhe(), zzefr.zzbeu(), zzf.zzbgr());
        } else if (zzegb.class.isAssignableFrom(cls)) {
            if (zza(zzf)) {
                return zzehp.zza(cls, zzf, zzehv.zzbgw(), zzegv.zzbgj(), zzeij.zzbhg(), zzefr.zzbet(), zzehk.zzbgt());
            }
            return zzehp.zza(cls, zzf, zzehv.zzbgw(), zzegv.zzbgj(), zzeij.zzbhg(), (zzefq<?>) null, zzehk.zzbgt());
        } else if (zza(zzf)) {
            return zzehp.zza(cls, zzf, zzehv.zzbgv(), zzegv.zzbgi(), zzeij.zzbhe(), zzefr.zzbeu(), zzehk.zzbgs());
        } else {
            return zzehp.zza(cls, zzf, zzehv.zzbgv(), zzegv.zzbgi(), zzeij.zzbhf(), (zzefq<?>) null, zzehk.zzbgs());
        }
    }

    private static boolean zza(zzehj zzehj) {
        return zzehj.zzbgp() == zzegb.zze.zziew;
    }

    private static zzehm zzbgl() {
        try {
            return (zzehm) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzigj;
        }
    }
}
