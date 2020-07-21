package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbmb implements zzela<Set<zzbyg<zzbtd>>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzblu> zzfmj;
    private final zzelj<JSONObject> zzfmk;

    private zzbmb(zzelj<zzblu> zzelj, zzelj<Executor> zzelj2, zzelj<JSONObject> zzelj3) {
        this.zzfmj = zzelj;
        this.zzerc = zzelj2;
        this.zzfmk = zzelj3;
    }

    public static zzbmb zzb(zzelj<zzblu> zzelj, zzelj<Executor> zzelj2, zzelj<JSONObject> zzelj3) {
        return new zzbmb(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        Set set;
        zzblu zzblu = this.zzfmj.get();
        Executor executor = this.zzerc.get();
        if (this.zzfmk.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbyg(zzblu, executor));
        }
        return (Set) zzelg.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
