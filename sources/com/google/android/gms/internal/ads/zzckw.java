package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzckw {
    private final Map<String, String> zzcyg = new ConcurrentHashMap();
    private final /* synthetic */ zzckx zzgek;

    zzckw(zzckx zzckx) {
        this.zzgek = zzckx;
    }

    /* access modifiers changed from: private */
    public final zzckw zzaoh() {
        this.zzcyg.putAll(this.zzgek.zzgel);
        return this;
    }

    public final zzckw zza(zzdkm zzdkm) {
        this.zzcyg.put("gqi", zzdkm.zzdrt);
        return this;
    }

    public final zzckw zzd(zzdkk zzdkk) {
        this.zzcyg.put("aai", zzdkk.zzdjb);
        return this;
    }

    public final zzckw zzq(String str, String str2) {
        this.zzcyg.put(str, str2);
        return this;
    }

    public final void zzaoi() {
        this.zzgek.executor.execute(new zzckz(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaoj() {
        this.zzgek.zzgeh.zzn(this.zzcyg);
    }
}
