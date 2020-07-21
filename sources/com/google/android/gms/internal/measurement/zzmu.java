package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzmu implements zzdv<zzmt> {
    private static zzmu zza = new zzmu();
    private final zzdv<zzmt> zzb;

    public static boolean zzb() {
        return ((zzmt) zza.zza()).zza();
    }

    private zzmu(zzdv<zzmt> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzmu() {
        this(zzdu.zza(new zzmw()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzmt zza() {
        return this.zzb.zza();
    }
}
