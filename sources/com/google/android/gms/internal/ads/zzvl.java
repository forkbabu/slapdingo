package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzvl extends zzxd {
    private final AppEventListener zzbnt;

    public zzvl(AppEventListener appEventListener) {
        this.zzbnt = appEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxe
    public final void onAppEvent(String str, String str2) {
        this.zzbnt.onAppEvent(str, str2);
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnt;
    }
}
