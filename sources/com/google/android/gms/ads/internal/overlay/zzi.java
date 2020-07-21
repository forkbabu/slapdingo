package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzbfn;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzi {
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdnx;
    public final Context zzvr;

    public zzi(zzbfn zzbfn) throws zzg {
        this.zzdnx = zzbfn.getLayoutParams();
        ViewParent parent2 = zzbfn.getParent();
        this.zzvr = zzbfn.zzaau();
        if (parent2 == null || !(parent2 instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent2;
        this.parent = viewGroup;
        this.index = viewGroup.indexOfChild(zzbfn.getView());
        this.parent.removeView(zzbfn.getView());
        zzbfn.zzax(true);
    }
}
