package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzlq implements zzdv<zzlp> {
    private static zzlq zza = new zzlq();
    private final zzdv<zzlp> zzb;

    public static boolean zzb() {
        return ((zzlp) zza.zza()).zza();
    }

    private zzlq(zzdv<zzlp> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzlq() {
        this(zzdu.zza(new zzls()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzlp zza() {
        return this.zzb.zza();
    }
}
