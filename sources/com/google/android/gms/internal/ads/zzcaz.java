package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcaz implements zzela<zzcaw> {
    private final zzelj<zzccv> zzfnq;
    private final zzelj<Map<String, zzcqt<zzbph>>> zzfpe;
    private final zzelj<zzbpc<zzbnc>> zzful;
    private final zzelj<Map<String, zzcqt<zzccd>>> zzfun;
    private final zzelj<Map<String, zzcsu<zzccd>>> zzfuo;

    public zzcaz(zzelj<Map<String, zzcqt<zzbph>>> zzelj, zzelj<Map<String, zzcqt<zzccd>>> zzelj2, zzelj<Map<String, zzcsu<zzccd>>> zzelj3, zzelj<zzbpc<zzbnc>> zzelj4, zzelj<zzccv> zzelj5) {
        this.zzfpe = zzelj;
        this.zzfun = zzelj2;
        this.zzfuo = zzelj3;
        this.zzful = zzelj4;
        this.zzfnq = zzelj5;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcaw(this.zzfpe.get(), this.zzfun.get(), this.zzfuo.get(), this.zzful, this.zzfnq.get());
    }
}
