package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqd implements zzbsq, zzbua {
    private static final Object zzgje = new Object();
    private static int zzgjf = 0;
    private final zzcqi zzgjg;

    public zzcqd(zzcqi zzcqi) {
        this.zzgjg = zzcqi;
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void onAdLoaded() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvp)).booleanValue() && zzaph()) {
            this.zzgjg.zzbl(true);
            zzapg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsq
    public final void onAdFailedToLoad(int i) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvp)).booleanValue() && zzaph()) {
            this.zzgjg.zzbl(false);
            zzapg();
        }
    }

    private static void zzapg() {
        synchronized (zzgje) {
            zzgjf++;
        }
    }

    private static boolean zzaph() {
        boolean z;
        synchronized (zzgje) {
            z = zzgjf < ((Integer) zzwg.zzpw().zzd(zzaav.zzcvq)).intValue();
        }
        return z;
    }
}
