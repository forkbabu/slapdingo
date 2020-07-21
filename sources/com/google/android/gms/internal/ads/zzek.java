package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzek extends zzcu<Integer, Long> {
    public long zzyj;
    public long zzyk;

    public zzek() {
        this.zzyj = -1;
        this.zzyk = -1;
    }

    public zzek(String str) {
        this();
        zzam(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzyj));
        hashMap.put(1, Long.valueOf(this.zzyk));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzyj = ((Long) zzan.get(0)).longValue();
            this.zzyk = ((Long) zzan.get(1)).longValue();
        }
    }
}
