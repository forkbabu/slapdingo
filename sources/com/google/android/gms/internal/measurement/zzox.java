package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzox implements zzdv<zzpa> {
    private static zzox zza = new zzox();
    private final zzdv<zzpa> zzb;

    public static boolean zzb() {
        return ((zzpa) zza.zza()).zza();
    }

    private zzox(zzdv<zzpa> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzox() {
        this(zzdu.zza(new zzoz()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzpa zza() {
        return this.zzb.zza();
    }
}
