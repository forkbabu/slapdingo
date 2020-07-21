package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzew implements zzdrl {
    private final zzfi zzxm;
    private final zzdpn zzyq;
    private final zzdpz zzyr;
    private final zzev zzys;

    zzew(zzdpn zzdpn, zzdpz zzdpz, zzfi zzfi, zzev zzev) {
        this.zzyq = zzdpn;
        this.zzyr = zzdpz;
        this.zzxm = zzfi;
        this.zzys = zzev;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(View view) {
        this.zzxm.zze(view);
    }

    private final Map<String, Object> zzcd() {
        HashMap hashMap = new HashMap();
        zzcf.zza zzcp = this.zzyr.zzcp();
        hashMap.put("v", this.zzyq.zzaut());
        hashMap.put("gms", Boolean.valueOf(this.zzyq.zzcn()));
        hashMap.put("int", zzcp.zzag());
        hashMap.put("up", Boolean.valueOf(this.zzys.zzcc()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzdrl
    public final Map<String, Object> zzce() {
        Map<String, Object> zzcd = zzcd();
        zzcf.zza zzava = this.zzyr.zzava();
        zzcd.put("gai", Boolean.valueOf(this.zzyq.zzauu()));
        zzcd.put("did", zzava.zzam());
        zzcd.put("dst", Integer.valueOf(zzava.zzan().zzw()));
        zzcd.put("doo", Boolean.valueOf(zzava.zzao()));
        return zzcd;
    }

    @Override // com.google.android.gms.internal.ads.zzdrl
    public final Map<String, Object> zzcf() {
        return zzcd();
    }

    @Override // com.google.android.gms.internal.ads.zzdrl
    public final Map<String, Object> zzcg() {
        Map<String, Object> zzcd = zzcd();
        zzcd.put("lts", Long.valueOf(this.zzxm.zzcv()));
        return zzcd;
    }
}
