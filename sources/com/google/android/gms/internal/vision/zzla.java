package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzla implements zzcz<zzkz> {
    private static zzla zzahf = new zzla();
    private final zzcz<zzkz> zzahc;

    public static boolean zzjq() {
        return ((zzkz) zzahf.get()).zzjq();
    }

    public static boolean zzjr() {
        return ((zzkz) zzahf.get()).zzjr();
    }

    private zzla(zzcz<zzkz> zzcz) {
        this.zzahc = zzdc.zza(zzcz);
    }

    public zzla() {
        this(zzdc.zze(new zzlb()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.vision.zzcz
    public final /* synthetic */ zzkz get() {
        return this.zzahc.get();
    }
}
