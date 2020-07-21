package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvd implements zzela<zzcva> {
    private final zzelj<zzcwh> zzgnl;

    private zzcvd(zzelj<zzcwh> zzelj) {
        this.zzgnl = zzelj;
    }

    public static zzcvd zzai(zzelj<zzcwh> zzelj) {
        return new zzcvd(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcva(this.zzgnl.get());
    }
}
