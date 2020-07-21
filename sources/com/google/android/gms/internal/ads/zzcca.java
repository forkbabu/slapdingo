package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcca implements zzela<zzccb> {
    private final zzelj<zzcck> zzfvp;

    private zzcca(zzelj<zzcck> zzelj) {
        this.zzfvp = zzelj;
    }

    public static zzcca zzy(zzelj<zzcck> zzelj) {
        return new zzcca(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzccb(this.zzfvp.get());
    }
}
