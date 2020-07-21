package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcio implements zzela<zzcip> {
    private final zzelj<zzbfn> zzfno;

    private zzcio(zzelj<zzbfn> zzelj) {
        this.zzfno = zzelj;
    }

    public static zzcio zzaa(zzelj<zzbfn> zzelj) {
        return new zzcio(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcip(this.zzfno.get());
    }
}
