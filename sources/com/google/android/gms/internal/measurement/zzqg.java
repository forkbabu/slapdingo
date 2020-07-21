package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzqg implements zzdv<zzqf> {
    private static zzqg zza = new zzqg();
    private final zzdv<zzqf> zzb;

    public static boolean zzb() {
        return ((zzqf) zza.zza()).zza();
    }

    private zzqg(zzdv<zzqf> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzqg() {
        this(zzdu.zza(new zzqi()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzqf zza() {
        return this.zzb.zza();
    }
}
