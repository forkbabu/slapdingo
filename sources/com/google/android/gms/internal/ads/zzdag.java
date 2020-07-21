package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdag implements zzela<zzdae> {
    private final zzelj<zzbqk> zzexq;
    private final zzelj<zzdlv> zzeza;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<String> zzgrz;
    private final zzelj<String> zzgsj;

    private zzdag(zzelj<String> zzelj, zzelj<String> zzelj2, zzelj<zzbqk> zzelj3, zzelj<zzdlv> zzelj4, zzelj<zzdla> zzelj5) {
        this.zzgrz = zzelj;
        this.zzgsj = zzelj2;
        this.zzexq = zzelj3;
        this.zzeza = zzelj4;
        this.zzfnz = zzelj5;
    }

    public static zzdag zzh(zzelj<String> zzelj, zzelj<String> zzelj2, zzelj<zzbqk> zzelj3, zzelj<zzdlv> zzelj4, zzelj<zzdla> zzelj5) {
        return new zzdag(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdae(this.zzgrz.get(), this.zzgsj.get(), this.zzexq.get(), this.zzeza.get(), this.zzfnz.get());
    }
}
