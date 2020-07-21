package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzlx implements zzdv<zzma> {
    private static zzlx zza = new zzlx();
    private final zzdv<zzma> zzb;

    public static boolean zzb() {
        return ((zzma) zza.zza()).zza();
    }

    public static long zzc() {
        return ((zzma) zza.zza()).zzb();
    }

    private zzlx(zzdv<zzma> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzlx() {
        this(zzdu.zza(new zzlz()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzma zza() {
        return this.zzb.zza();
    }
}
