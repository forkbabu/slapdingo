package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzpo implements zzdv<zzpn> {
    private static zzpo zza = new zzpo();
    private final zzdv<zzpn> zzb;

    public static boolean zzb() {
        return ((zzpn) zza.zza()).zza();
    }

    private zzpo(zzdv<zzpn> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzpo() {
        this(zzdu.zza(new zzpq()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzpn zza() {
        return this.zzb.zza();
    }
}
