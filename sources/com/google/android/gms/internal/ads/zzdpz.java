package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdpz {
    private final Executor executor;
    private final zzdqf zzhic;
    private final zzdqf zzhid;
    private Task<zzcf.zza> zzhie;
    private Task<zzcf.zza> zzhif;
    private final Context zzvr;
    private final zzdpm zzvv;
    private final zzdpn zzyq;

    private zzdpz(Context context, Executor executor2, zzdpm zzdpm, zzdpn zzdpn, zzdqd zzdqd, zzdqg zzdqg) {
        this.zzvr = context;
        this.executor = executor2;
        this.zzvv = zzdpm;
        this.zzyq = zzdpn;
        this.zzhic = zzdqd;
        this.zzhid = zzdqg;
    }

    public static zzdpz zza(Context context, Executor executor2, zzdpm zzdpm, zzdpn zzdpn) {
        zzdpz zzdpz = new zzdpz(context, executor2, zzdpm, zzdpn, new zzdqd(), new zzdqg());
        if (zzdpz.zzyq.zzauu()) {
            zzdpz.zzhie = zzdpz.zzd(new zzdqc(zzdpz));
        } else {
            zzdpz.zzhie = Tasks.forResult(zzdpz.zzhic.zzave());
        }
        zzdpz.zzhif = zzdpz.zzd(new zzdqb(zzdpz));
        return zzdpz;
    }

    public final zzcf.zza zzava() {
        return zza(this.zzhie, this.zzhic.zzave());
    }

    public final zzcf.zza zzcp() {
        return zza(this.zzhif, this.zzhid.zzave());
    }

    private final Task<zzcf.zza> zzd(Callable<zzcf.zza> callable) {
        return Tasks.call(this.executor, callable).addOnFailureListener(this.executor, new zzdqe(this));
    }

    private static zzcf.zza zza(Task<zzcf.zza> task, zzcf.zza zza) {
        if (!task.isSuccessful()) {
            return zza;
        }
        return task.getResult();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzvv.zza(2025, -1, exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzavb() throws Exception {
        return this.zzhid.zzck(this.zzvr);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcf.zza zzavc() throws Exception {
        return this.zzhic.zzck(this.zzvr);
    }
}
