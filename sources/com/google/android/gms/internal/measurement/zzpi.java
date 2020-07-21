package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzpi implements zzdv<zzph> {
    private static zzpi zza = new zzpi();
    private final zzdv<zzph> zzb;

    public static boolean zzb() {
        return ((zzph) zza.zza()).zza();
    }

    private zzpi(zzdv<zzph> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzpi() {
        this(zzdu.zza(new zzpk()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzph zza() {
        return this.zzb.zza();
    }
}
