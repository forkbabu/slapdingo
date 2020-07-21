package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zznb implements zzdv<zzne> {
    private static zznb zza = new zznb();
    private final zzdv<zzne> zzb;

    public static boolean zzb() {
        return ((zzne) zza.zza()).zza();
    }

    private zznb(zzdv<zzne> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zznb() {
        this(zzdu.zza(new zznd()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzne zza() {
        return this.zzb.zza();
    }
}
