package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcsn implements zzcam {
    private zzbtc zzfud = null;
    private final zzdkk zzfue;
    private final zzaox zzglr;
    private final boolean zzgls;

    zzcsn(zzdkk zzdkk, zzaox zzaox, boolean z) {
        this.zzfue = zzdkk;
        this.zzglr = zzaox;
        this.zzgls = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza(boolean z, Context context) throws zzcap {
        boolean z2;
        try {
            if (this.zzgls) {
                z2 = this.zzglr.zzaa(ObjectWrapper.wrap(context));
            } else {
                z2 = this.zzglr.zzz(ObjectWrapper.wrap(context));
            }
            if (!z2) {
                throw new zzcap("Adapter failed to show.");
            } else if (this.zzfud != null && this.zzfue.zzhac == 2) {
                this.zzfud.onAdImpression();
            }
        } catch (Throwable th) {
            throw new zzcap(th);
        }
    }

    public final void zza(zzbtc zzbtc) {
        this.zzfud = zzbtc;
    }
}
