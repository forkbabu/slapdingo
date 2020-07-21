package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcwg implements zzela<zzcwh> {
    private final zzelj<zzcix> zzgnl;

    private zzcwg(zzelj<zzcix> zzelj) {
        this.zzgnl = zzelj;
    }

    public static zzcwg zzaj(zzelj<zzcix> zzelj) {
        return new zzcwg(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcwh(this.zzgnl.get());
    }
}
