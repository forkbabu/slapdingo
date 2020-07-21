package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzey extends zzcu<Integer, Long> {
    public Long zzzh;
    public Long zzzi;

    public zzey() {
    }

    public zzey(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzzh = (Long) zzan.get(0);
            this.zzzi = (Long) zzan.get(1);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcu
    public final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzzh);
        hashMap.put(1, this.zzzi);
        return hashMap;
    }
}
