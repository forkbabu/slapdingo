package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcke implements zzela<Set<zzbyg<zzdpa>>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<String> zzgdu;
    private final zzelj<Map<zzdor, zzckj>> zzgdv;

    public zzcke(zzelj<String> zzelj, zzelj<Context> zzelj2, zzelj<Executor> zzelj3, zzelj<Map<zzdor, zzckj>> zzelj4) {
        this.zzgdu = zzelj;
        this.zzere = zzelj2;
        this.zzerc = zzelj3;
        this.zzgdv = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        Set set;
        String str = this.zzgdu.get();
        Context context = this.zzere.get();
        Executor executor = this.zzerc.get();
        Map<zzdor, zzckj> map = this.zzgdv.get();
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcte)).booleanValue()) {
            zztm zztm = new zztm(new zztr(context));
            zztm.zza(new zzckg(str));
            set = Collections.singleton(new zzbyg(new zzckh(zztm, map), executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzelg.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
