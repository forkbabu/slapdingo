package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtt;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvi<AdT, AdapterT, ListenerT extends zzbtt> implements zzela<zzcve<AdT, AdapterT, ListenerT>> {
    private final zzelj<zzcqu<AdapterT, ListenerT>> zzfjz;
    private final zzelj<zzdvi> zzfnr;
    private final zzelj<zzdou> zzfoc;
    private final zzelj<zzcqw<AdT, AdapterT, ListenerT>> zzgnp;

    private zzcvi(zzelj<zzdou> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzcqu<AdapterT, ListenerT>> zzelj3, zzelj<zzcqw<AdT, AdapterT, ListenerT>> zzelj4) {
        this.zzfoc = zzelj;
        this.zzfnr = zzelj2;
        this.zzfjz = zzelj3;
        this.zzgnp = zzelj4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbtt> zzcvi<AdT, AdapterT, ListenerT> zze(zzelj<zzdou> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzcqu<AdapterT, ListenerT>> zzelj3, zzelj<zzcqw<AdT, AdapterT, ListenerT>> zzelj4) {
        return new zzcvi<>(zzelj, zzelj2, zzelj3, zzelj4);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcve(this.zzfoc.get(), this.zzfnr.get(), this.zzfjz.get(), this.zzgnp.get());
    }
}
