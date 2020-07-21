package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzqh implements zzdv<zzqk> {
    private static zzqh zza = new zzqh();
    private final zzdv<zzqk> zzb;

    public static boolean zzb() {
        return ((zzqk) zza.zza()).zza();
    }

    private zzqh(zzdv<zzqk> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzqh() {
        this(zzdu.zza(new zzqj()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzqk zza() {
        return this.zzb.zza();
    }
}
