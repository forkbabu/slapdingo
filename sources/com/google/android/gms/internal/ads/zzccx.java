package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzccx {
    zzaeu zzfxl;
    zzaet zzfxm;
    zzafi zzfxn;
    zzafh zzfxo;
    zzaiw zzfxp;
    final SimpleArrayMap<String, zzafa> zzfxq = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzaez> zzfxr = new SimpleArrayMap<>();

    public final zzccx zzb(zzaeu zzaeu) {
        this.zzfxl = zzaeu;
        return this;
    }

    public final zzccx zzb(zzaet zzaet) {
        this.zzfxm = zzaet;
        return this;
    }

    public final zzccx zzb(zzafi zzafi) {
        this.zzfxn = zzafi;
        return this;
    }

    public final zzccx zza(zzafh zzafh) {
        this.zzfxo = zzafh;
        return this;
    }

    public final zzccx zzb(zzaiw zzaiw) {
        this.zzfxp = zzaiw;
        return this;
    }

    public final zzccx zzb(String str, zzafa zzafa, zzaez zzaez) {
        this.zzfxq.put(str, zzafa);
        this.zzfxr.put(str, zzaez);
        return this;
    }

    public final zzccv zzamd() {
        return new zzccv(this);
    }
}
