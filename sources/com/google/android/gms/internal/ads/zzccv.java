package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzccv {
    public static final zzccv zzfxs = new zzccx().zzamd();
    private final zzaeu zzfxl;
    private final zzaet zzfxm;
    private final zzafi zzfxn;
    private final zzafh zzfxo;
    private final zzaiw zzfxp;
    private final SimpleArrayMap<String, zzafa> zzfxq;
    private final SimpleArrayMap<String, zzaez> zzfxr;

    public final zzaeu zzalv() {
        return this.zzfxl;
    }

    public final zzaet zzalw() {
        return this.zzfxm;
    }

    public final zzafi zzalx() {
        return this.zzfxn;
    }

    public final zzafh zzaly() {
        return this.zzfxo;
    }

    public final zzaiw zzalz() {
        return this.zzfxp;
    }

    public final zzafa zzgc(String str) {
        return this.zzfxq.get(str);
    }

    public final zzaez zzgd(String str) {
        return this.zzfxr.get(str);
    }

    public final ArrayList<String> zzama() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzfxn != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzfxl != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzfxm != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzfxq.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzfxp != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzamb() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzfxq.size());
        for (int i = 0; i < this.zzfxq.size(); i++) {
            arrayList.add(this.zzfxq.keyAt(i));
        }
        return arrayList;
    }

    private zzccv(zzccx zzccx) {
        this.zzfxl = zzccx.zzfxl;
        this.zzfxm = zzccx.zzfxm;
        this.zzfxn = zzccx.zzfxn;
        this.zzfxq = new SimpleArrayMap<>(zzccx.zzfxq);
        this.zzfxr = new SimpleArrayMap<>(zzccx.zzfxr);
        this.zzfxo = zzccx.zzfxo;
        this.zzfxp = zzccx.zzfxp;
    }
}
