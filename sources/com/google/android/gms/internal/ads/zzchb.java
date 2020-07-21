package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzchb implements Callable<zzcgr> {
    /* access modifiers changed from: private */
    public final zzbfv zzbpw;
    /* access modifiers changed from: private */
    public final zzbbd zzdpd;
    /* access modifiers changed from: private */
    public final zzeg zzemz;
    /* access modifiers changed from: private */
    public final Executor zzflp;
    /* access modifiers changed from: private */
    public final zza zzgar;
    /* access modifiers changed from: private */
    public final Context zzvr;

    public zzchb(Context context, Executor executor, zzeg zzeg, zzbbd zzbbd, zza zza, zzbfv zzbfv) {
        this.zzvr = context;
        this.zzflp = executor;
        this.zzemz = zzeg;
        this.zzdpd = zzbbd;
        this.zzgar = zza;
        this.zzbpw = zzbfv;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzcgr call() throws Exception {
        zzcgr zzcgr = new zzcgr(this);
        zzcgr.zzamz();
        return zzcgr;
    }
}
