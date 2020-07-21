package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzpj implements zzdv<zzpm> {
    private static zzpj zza = new zzpj();
    private final zzdv<zzpm> zzb;

    public static boolean zzb() {
        return ((zzpm) zza.zza()).zza();
    }

    private zzpj(zzdv<zzpm> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzpj() {
        this(zzdu.zza(new zzpl()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzpm zza() {
        return this.zzb.zza();
    }
}
