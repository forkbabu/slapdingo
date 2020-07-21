package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbmw extends zzbpb {
    private final View view;
    private final zzbfn zzdfp;
    private final zzdkj zzfmu;
    private final int zzfmv;
    private final boolean zzfmw;
    private final boolean zzfmx;
    private zzsl zzfnb;
    private final zzbmr zzfnc;

    zzbmw(zzbpa zzbpa, View view2, zzbfn zzbfn, zzdkj zzdkj, int i, boolean z, boolean z2, zzbmr zzbmr) {
        super(zzbpa);
        this.view = view2;
        this.zzdfp = zzbfn;
        this.zzfmu = zzdkj;
        this.zzfmv = i;
        this.zzfmw = z;
        this.zzfmx = z2;
        this.zzfnc = zzbmr;
    }

    public final zzdkj zzahj() {
        return zzdld.zza(this.zzfol.zzgzq, this.zzfmu);
    }

    public final View zzahk() {
        return this.view;
    }

    public final int zzahc() {
        return this.zzfmv;
    }

    public final boolean zzahd() {
        return this.zzfmw;
    }

    public final boolean zzahe() {
        return this.zzfmx;
    }

    public final boolean zzabs() {
        zzbfn zzbfn = this.zzdfp;
        return (zzbfn == null || zzbfn.zzaaz() == null || !this.zzdfp.zzaaz().zzabs()) ? false : true;
    }

    public final boolean zzahl() {
        zzbfn zzbfn = this.zzdfp;
        return zzbfn != null && zzbfn.zzabb();
    }

    public final void zza(zzsa zzsa) {
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn != null) {
            zzbfn.zza(zzsa);
        }
    }

    public final void zza(zzsl zzsl) {
        this.zzfnb = zzsl;
    }

    public final zzsl zzahm() {
        return this.zzfnb;
    }

    public final void zzfd(long j) {
        this.zzfnc.zzfd(j);
    }
}
