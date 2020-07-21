package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdga implements zzela<zzdfy> {
    private final zzelj<zzame> zzesg;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<ApplicationInfo> zzggq;
    private final zzelj<Boolean> zzgvv;

    public zzdga(zzelj<zzame> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<Boolean> zzelj3, zzelj<ApplicationInfo> zzelj4) {
        this.zzesg = zzelj;
        this.zzfkv = zzelj2;
        this.zzgvv = zzelj3;
        this.zzggq = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdfy(this.zzesg.get(), this.zzfkv.get(), this.zzgvv.get().booleanValue(), this.zzggq.get());
    }
}
