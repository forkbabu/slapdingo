package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzow implements zzdv<zzov> {
    private static zzow zza = new zzow();
    private final zzdv<zzov> zzb;

    public static long zzb() {
        return ((zzov) zza.zza()).zza();
    }

    private zzow(zzdv<zzov> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzow() {
        this(zzdu.zza(new zzoy()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzov zza() {
        return this.zzb.zza();
    }
}
