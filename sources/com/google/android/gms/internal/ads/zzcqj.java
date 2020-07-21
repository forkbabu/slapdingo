package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqj implements zzela<zzcqg> {
    private final zzelj<zzcqf> zzgju;

    private zzcqj(zzelj<zzcqf> zzelj) {
        this.zzgju = zzelj;
    }

    public static zzcqj zzah(zzelj<zzcqf> zzelj) {
        return new zzcqj(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcqg(this.zzgju.get());
    }
}
