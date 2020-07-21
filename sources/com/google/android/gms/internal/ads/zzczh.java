package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczh implements zzela<zzczg> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzdvf<String>> zzgro;

    private zzczh(zzelj<zzdvf<String>> zzelj, zzelj<Executor> zzelj2) {
        this.zzgro = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzczh zzaw(zzelj<zzdvf<String>> zzelj, zzelj<Executor> zzelj2) {
        return new zzczh(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzczg(this.zzgro.get(), this.zzerc.get());
    }
}
