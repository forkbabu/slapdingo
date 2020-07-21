package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbro implements zzbtg, zzbua {
    private final zzaqp zzboc;
    private final zzdkk zzfol;
    private final Context zzvr;

    public zzbro(Context context, zzdkk zzdkk, zzaqp zzaqp) {
        this.zzvr = context;
        this.zzfol = zzdkk;
        this.zzboc = zzaqp;
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzca(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzcb(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void onAdLoaded() {
        if (this.zzfol.zzhae != null && this.zzfol.zzhae.zzdoq) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzfol.zzhae.zzdor.isEmpty()) {
                arrayList.add(this.zzfol.zzhae.zzdor);
            }
            this.zzboc.zza(this.zzvr, arrayList);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzcc(Context context) {
        this.zzboc.detach();
    }
}
