package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zznz implements zzdv<zzoc> {
    private static zznz zza = new zznz();
    private final zzdv<zzoc> zzb;

    public static boolean zzb() {
        return ((zzoc) zza.zza()).zza();
    }

    private zznz(zzdv<zzoc> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zznz() {
        this(zzdu.zza(new zzob()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzoc zza() {
        return this.zzb.zza();
    }
}
