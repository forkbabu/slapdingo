package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbo implements zzddz<Bundle> {
    private final Bundle zzgtb;

    public zzdbo(Bundle bundle) {
        this.zzgtb = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        bundle.putBundle("content_info", this.zzgtb);
    }
}
