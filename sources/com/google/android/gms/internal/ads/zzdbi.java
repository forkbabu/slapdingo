package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbi implements zzela<zzdbe> {
    private final zzelj<zzame> zzesg;
    private final zzelj<zzaxx> zzexy;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<ApplicationInfo> zzggq;

    private zzdbi(zzelj<zzame> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<zzaxx> zzelj3, zzelj<ApplicationInfo> zzelj4, zzelj<zzdla> zzelj5) {
        this.zzesg = zzelj;
        this.zzfkv = zzelj2;
        this.zzexy = zzelj3;
        this.zzggq = zzelj4;
        this.zzfnz = zzelj5;
    }

    public static zzdbi zzi(zzelj<zzame> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<zzaxx> zzelj3, zzelj<ApplicationInfo> zzelj4, zzelj<zzdla> zzelj5) {
        return new zzdbi(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdbe(this.zzesg.get(), this.zzfkv.get(), this.zzexy.get(), this.zzggq.get(), this.zzfnz.get());
    }
}
