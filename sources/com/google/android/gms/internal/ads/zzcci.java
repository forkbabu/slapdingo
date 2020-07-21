package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcci implements zzela<zzccj> {
    private final zzelj<zzccb> zzfwr;

    private zzcci(zzelj<zzccb> zzelj) {
        this.zzfwr = zzelj;
    }

    public static zzcci zzz(zzelj<zzccb> zzelj) {
        return new zzcci(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzccj(this.zzfwr.get());
    }
}
