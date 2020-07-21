package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzok implements zzdv<zzoj> {
    private static zzok zza = new zzok();
    private final zzdv<zzoj> zzb;

    public static boolean zzb() {
        return ((zzoj) zza.zza()).zza();
    }

    private zzok(zzdv<zzoj> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzok() {
        this(zzdu.zza(new zzom()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzoj zza() {
        return this.zzb.zza();
    }
}
