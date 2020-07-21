package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzmf implements zzmg {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;
    private static final zzcw<Long> zzc;

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.service.configurable_service_limits", true);
        zzb = zzdf.zza("measurement.client.configurable_service_limits", true);
        zzc = zzdf.zza("measurement.id.service.configurable_service_limits", 0L);
    }
}
