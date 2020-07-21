package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbwm implements zzbwx {
    private final String zzdfg;
    private final String zzdfo;

    zzbwm(String str, String str2) {
        this.zzdfo = str;
        this.zzdfg = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzp(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zzdfo, this.zzdfg);
    }
}
