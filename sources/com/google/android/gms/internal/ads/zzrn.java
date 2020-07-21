package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzrn implements ValueCallback<String> {
    private final /* synthetic */ zzrk zzbtq;

    zzrn(zzrk zzrk) {
        this.zzbtq = zzrk;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        this.zzbtq.zzbtm.zza(this.zzbtq.zzbtj, this.zzbtq.zzbtk, str, this.zzbtq.zzbtl);
    }
}
