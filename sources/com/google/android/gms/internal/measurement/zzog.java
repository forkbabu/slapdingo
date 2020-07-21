package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzog implements zzod {
    private static final zzcw<Boolean> zza = new zzdf(zzcx.zza("com.google.android.gms.measurement")).zza("measurement.ga.ga_app_id", false);

    @Override // com.google.android.gms.internal.measurement.zzod
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzod
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
