package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdmi {
    private zzdmh zzhcd = null;
    private zzdmh zzhce = null;
    private zzdmh zzhcf = null;
    private zzdmh zzhcg = null;
    private zzdmh zzhch = null;
    private zzdmh zzhci = null;
    private zzdmh zzhcj = null;
    private zzdmh zzhck = null;

    public final void zza(zzdmh zzdmh) {
        this.zzhcg = zzdmh;
    }

    public final void onAdClosed() {
        zzdmh zzdmh = this.zzhcg;
        if (zzdmh != null) {
            zzdmh.execute();
        }
    }
}
