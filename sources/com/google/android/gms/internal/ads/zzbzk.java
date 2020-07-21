package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbzk {
    private final zzbfn zzdfp;
    private final zzcam zzftw;

    public zzbzk(zzcam zzcam) {
        this(zzcam, null);
    }

    public zzbzk(zzcam zzcam, zzbfn zzbfn) {
        this.zzftw = zzcam;
        this.zzdfp = zzbfn;
    }

    public final zzcam zzakf() {
        return this.zzftw;
    }

    public final zzbfn zzagz() {
        return this.zzdfp;
    }

    public final View zzakg() {
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn != null) {
            return zzbfn.getWebView();
        }
        return null;
    }

    public final View zzakh() {
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn == null) {
            return null;
        }
        return zzbfn.getWebView();
    }

    public Set<zzbyg<zzbsl>> zza(zzcaq zzcaq) {
        return Collections.singleton(zzbyg.zzb(zzcaq, zzbbf.zzedm));
    }

    public final zzbyg<zzbwd> zzb(Executor executor) {
        return new zzbyg<>(new zzbzm(this.zzdfp), executor);
    }
}
