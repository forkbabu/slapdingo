package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzehe implements zzehm {
    private zzehm[] zzigk;

    zzehe(zzehm... zzehmArr) {
        this.zzigk = zzehmArr;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    public final boolean zze(Class<?> cls) {
        for (zzehm zzehm : this.zzigk) {
            if (zzehm.zze(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    public final zzehj zzf(Class<?> cls) {
        zzehm[] zzehmArr = this.zzigk;
        for (zzehm zzehm : zzehmArr) {
            if (zzehm.zze(cls)) {
                return zzehm.zzf(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
