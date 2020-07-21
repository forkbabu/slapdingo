package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzpl implements zzpm {
    private static final zzcw<Boolean> zza = new zzdf(zzcx.zza("com.google.android.gms.measurement")).zza("measurement.experiment.enable_experiment_reporting", true);

    @Override // com.google.android.gms.internal.measurement.zzpm
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
