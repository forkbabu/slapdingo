package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzmd implements zzdv<zzmg> {
    private static zzmd zza = new zzmd();
    private final zzdv<zzmg> zzb;

    public static boolean zzb() {
        return ((zzmg) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmg) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzmg) zza.zza()).zzc();
    }

    private zzmd(zzdv<zzmg> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzmd() {
        this(zzdu.zza(new zzmf()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzmg zza() {
        return this.zzb.zza();
    }
}
