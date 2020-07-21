package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzafz {
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzdcw;
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomClickListener zzdcx;
    private NativeCustomTemplateAd zzdcy;

    public zzafz(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzdcw = onCustomTemplateAdLoadedListener;
        this.zzdcx = onCustomClickListener;
    }

    public final zzafa zzso() {
        return new zzaga(this);
    }

    public final zzaez zzsp() {
        if (this.zzdcx == null) {
            return null;
        }
        return new zzagb(this);
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzb(zzaep zzaep) {
        if (this.zzdcy != null) {
            return this.zzdcy;
        }
        zzaeq zzaeq = new zzaeq(zzaep);
        this.zzdcy = zzaeq;
        return zzaeq;
    }
}
