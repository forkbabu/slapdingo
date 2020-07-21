package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzmp implements zzdv<zzms> {
    private static zzmp zza = new zzmp();
    private final zzdv<zzms> zzb;

    public static boolean zzb() {
        return ((zzms) zza.zza()).zza();
    }

    private zzmp(zzdv<zzms> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzmp() {
        this(zzdu.zza(new zzmr()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzms zza() {
        return this.zzb.zza();
    }
}
