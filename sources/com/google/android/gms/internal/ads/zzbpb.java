package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbpb {
    protected final zzdkw zzfkn;
    protected final zzdkk zzfol;
    private final zzbtf zzfoz;
    private final zzbtv zzfpa;
    private final zzdim zzfpb;
    private final zzbsg zzfpc;
    private final zzbuz zzfpd;

    protected zzbpb(zzbpa zzbpa) {
        this.zzfkn = zzbpa.zzfkn;
        this.zzfol = zzbpa.zzfol;
        this.zzfoz = zzbpa.zzfoz;
        this.zzfpa = zzbpa.zzfpa;
        this.zzfpb = zzbpa.zzfpb;
        this.zzfpc = zzbpa.zzfpc;
        this.zzfpd = zzbpa.zzfpd;
    }

    public final zzbtf zzaig() {
        return this.zzfoz;
    }

    public void zzahr() {
        this.zzfpa.onAdLoaded();
    }

    public final zzbsg zzaih() {
        return this.zzfpc;
    }

    public void destroy() {
        this.zzfoz.zzcc(null);
    }

    public final zzdim zzaii() {
        return this.zzfpb;
    }

    public final zzbvy zzaij() {
        return this.zzfpd.zzaij();
    }
}
