package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbnj {
    private final View view;
    private final zzbfn zzdfp;
    private final zzdkj zzfmu;
    private final zzboy zzfni;

    public zzbnj(View view2, zzbfn zzbfn, zzboy zzboy, zzdkj zzdkj) {
        this.view = view2;
        this.zzdfp = zzbfn;
        this.zzfni = zzboy;
        this.zzfmu = zzdkj;
    }

    public final zzbfn zzagz() {
        return this.zzdfp;
    }

    public final View zzahk() {
        return this.view;
    }

    public final zzboy zzaht() {
        return this.zzfni;
    }

    public final zzdkj zzahu() {
        return this.zzfmu;
    }

    public zzbtv zza(Set<zzbyg<zzbua>> set) {
        return new zzbtv(set);
    }
}
