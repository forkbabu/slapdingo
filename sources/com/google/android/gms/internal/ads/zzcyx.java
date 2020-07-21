package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcyx implements zzdec<zzcyy> {
    private final zzdla zzfpv;
    private final zzdvi zzgri;
    private final View zzgrj;
    private final Context zzvr;

    public zzcyx(zzdvi zzdvi, Context context, zzdla zzdla, ViewGroup viewGroup) {
        this.zzgri = zzdvi;
        this.zzvr = context;
        this.zzfpv = zzdla;
        this.zzgrj = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzcyy> zzaqm() {
        return this.zzgri.zze(new zzcza(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcyy zzaqn() throws Exception {
        Context context = this.zzvr;
        zzvh zzvh = this.zzfpv.zzboz;
        ArrayList arrayList = new ArrayList();
        View view = this.zzgrj;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzcyy(context, zzvh, arrayList);
    }
}
