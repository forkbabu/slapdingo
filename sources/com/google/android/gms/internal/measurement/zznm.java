package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zznm implements zzdv<zznl> {
    private static zznm zza = new zznm();
    private final zzdv<zznl> zzb;

    public static boolean zzb() {
        return ((zznl) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznl) zza.zza()).zzb();
    }

    private zznm(zzdv<zznl> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zznm() {
        this(zzdu.zza(new zzno()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zznl zza() {
        return this.zzb.zza();
    }
}
