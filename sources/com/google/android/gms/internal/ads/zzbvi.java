package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbvi implements zzbvx {
    private final String zzdfg;
    private final String zzdfo;

    zzbvi(String str, String str2) {
        this.zzdfo = str;
        this.zzdfg = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzbvx
    public final void zzq(Object obj) {
        ((zzcxa) obj).onAppEvent(this.zzdfo, this.zzdfg);
    }
}
