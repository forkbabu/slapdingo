package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzmj implements zzdv<zzmm> {
    private static zzmj zza = new zzmj();
    private final zzdv<zzmm> zzb;

    public static boolean zzb() {
        return ((zzmm) zza.zza()).zza();
    }

    private zzmj(zzdv<zzmm> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzmj() {
        this(zzdu.zza(new zzml()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzmm zza() {
        return this.zzb.zza();
    }
}
