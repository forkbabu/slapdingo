package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzpp implements zzdv<zzps> {
    private static zzpp zza = new zzpp();
    private final zzdv<zzps> zzb;

    public static boolean zzb() {
        return ((zzps) zza.zza()).zza();
    }

    private zzpp(zzdv<zzps> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzpp() {
        this(zzdu.zza(new zzpr()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzps zza() {
        return this.zzb.zza();
    }
}
