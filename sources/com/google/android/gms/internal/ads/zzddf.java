package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzddf implements zzdrx {
    private final String zzdfo;

    zzddf(String str) {
        this.zzdfo = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        String valueOf = String.valueOf(this.zzdfo);
        zzaxv.zzfb(valueOf.length() != 0 ? "Error calling adapter: ".concat(valueOf) : new String("Error calling adapter: "));
        return null;
    }
}
