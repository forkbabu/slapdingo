package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzhw implements zzie {
    private zzie[] zzza;

    zzhw(zzie... zzieArr) {
        this.zzza = zzieArr;
    }

    @Override // com.google.android.gms.internal.vision.zzie
    public final boolean zza(Class<?> cls) {
        for (zzie zzie : this.zzza) {
            if (zzie.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzie
    public final zzif zzb(Class<?> cls) {
        zzie[] zzieArr = this.zzza;
        for (zzie zzie : zzieArr) {
            if (zzie.zza(cls)) {
                return zzie.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
