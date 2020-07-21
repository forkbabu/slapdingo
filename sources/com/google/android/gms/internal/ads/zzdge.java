package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdge implements zzela<zzdgc> {
    private final zzelj<Context> zzere;
    private final zzelj<zzaqq> zzesg;
    private final zzelj<ScheduledExecutorService> zzfkv;

    public zzdge(zzelj<zzaqq> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<Context> zzelj3) {
        this.zzesg = zzelj;
        this.zzfkv = zzelj2;
        this.zzere = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdgc(this.zzesg.get(), this.zzfkv.get(), this.zzere.get());
    }
}
