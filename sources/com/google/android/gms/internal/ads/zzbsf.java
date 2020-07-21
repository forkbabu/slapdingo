package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbsf implements zzela<zzbsg> {
    private final zzelj<zzdkk> zzfos;
    private final zzelj<String> zzfrk;

    private zzbsf(zzelj<zzdkk> zzelj, zzelj<String> zzelj2) {
        this.zzfos = zzelj;
        this.zzfrk = zzelj2;
    }

    public static zzbsf zzs(zzelj<zzdkk> zzelj, zzelj<String> zzelj2) {
        return new zzbsf(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbsg(this.zzfos.get(), this.zzfrk.get());
    }
}
