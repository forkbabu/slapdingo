package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcpo implements zzela<zzcoy> {
    private final zzelj<Context> zzere;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzasz> zzgir;
    private final zzelj<zzblb> zzgis;
    private final zzelj<zzata> zzgit;
    private final zzelj<HashMap<String, zzcpn>> zzgiu;

    private zzcpo(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<zzasz> zzelj3, zzelj<zzblb> zzelj4, zzelj<zzata> zzelj5, zzelj<HashMap<String, zzcpn>> zzelj6) {
        this.zzere = zzelj;
        this.zzfnr = zzelj2;
        this.zzgir = zzelj3;
        this.zzgis = zzelj4;
        this.zzgit = zzelj5;
        this.zzgiu = zzelj6;
    }

    public static zzcpo zza(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<zzasz> zzelj3, zzelj<zzblb> zzelj4, zzelj<zzata> zzelj5, zzelj<HashMap<String, zzcpn>> zzelj6) {
        return new zzcpo(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcoy(this.zzere.get(), this.zzfnr.get(), this.zzgir.get(), this.zzgis.get(), this.zzgit.get(), this.zzgiu.get());
    }
}
