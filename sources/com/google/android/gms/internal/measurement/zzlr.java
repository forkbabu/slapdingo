package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public final class zzlr implements zzdv<zzlu> {
    private static zzlr zza = new zzlr();
    private final zzdv<zzlu> zzb;

    public static boolean zzb() {
        return ((zzlu) zza.zza()).zza();
    }

    private zzlr(zzdv<zzlu> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public zzlr() {
        this(zzdu.zza(new zzlt()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzlu zza() {
        return this.zzb.zza();
    }
}
