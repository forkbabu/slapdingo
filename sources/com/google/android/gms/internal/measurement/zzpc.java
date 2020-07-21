package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzpc implements zzdv<zzpb> {
    private static zzpc zza = new zzpc();
    private final zzdv<zzpb> zzb;

    public static boolean zzb() {
        return ((zzpb) zza.zza()).zza();
    }

    private zzpc(zzdv<zzpb> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzpc() {
        this(zzdu.zza(new zzpe()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzpb zza() {
        return this.zzb.zza();
    }
}
