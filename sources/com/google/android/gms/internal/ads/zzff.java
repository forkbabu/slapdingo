package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzff extends zzcu<Integer, Long> {
    public Long zzaaa;
    public Long zzaab;
    public Long zzaac;
    public Long zzaad;

    public zzff() {
    }

    public zzff(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzaaa = (Long) zzan.get(0);
            this.zzaab = (Long) zzan.get(1);
            this.zzaac = (Long) zzan.get(2);
            this.zzaad = (Long) zzan.get(3);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaaa);
        hashMap.put(1, this.zzaab);
        hashMap.put(2, this.zzaac);
        hashMap.put(3, this.zzaad);
        return hashMap;
    }
}
