package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzmv implements zzdv<zzmy> {
    private static zzmv zza = new zzmv();
    private final zzdv<zzmy> zzb;

    public static boolean zzb() {
        return ((zzmy) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmy) zza.zza()).zzb();
    }

    private zzmv(zzdv<zzmy> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzmv() {
        this(zzdu.zza(new zzmx()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzmy zza() {
        return this.zzb.zza();
    }
}
