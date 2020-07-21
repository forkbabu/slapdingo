package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzet extends zzcu<Integer, Object> {
    public Long zzym;
    public Boolean zzyn;
    public Boolean zzyo;

    public zzet() {
    }

    public zzet(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzym = (Long) zzan.get(0);
            this.zzyn = (Boolean) zzan.get(1);
            this.zzyo = (Boolean) zzan.get(2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final HashMap<Integer, Object> zzbo() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzym);
        hashMap.put(1, this.zzyn);
        hashMap.put(2, this.zzyo);
        return hashMap;
    }
}
