package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzpf implements zzpg {
    private static final zzcw<Boolean> zza;
    private static final zzcw<Double> zzb;
    private static final zzcw<Long> zzc;
    private static final zzcw<Long> zzd;
    private static final zzcw<String> zze;

    @Override // com.google.android.gms.internal.measurement.zzpg
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpg
    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpg
    public final long zzc() {
        return zzc.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpg
    public final long zzd() {
        return zzd.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpg
    public final String zze() {
        return zze.zzc();
    }

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.test.boolean_flag", false);
        zzb = zzdf.zza("measurement.test.double_flag", -3.0d);
        zzc = zzdf.zza("measurement.test.int_flag", -2L);
        zzd = zzdf.zza("measurement.test.long_flag", -1L);
        zze = zzdf.zza("measurement.test.string_flag", "---");
    }
}
