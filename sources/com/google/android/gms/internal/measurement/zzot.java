package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzot implements zzou {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzou
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.sdk.screen.manual_screen_view_logging", true);
        zzb = zzdf.zza("measurement.sdk.screen.disabling_automatic_reporting", true);
    }
}
