package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblk implements zzbsl, zzbtd, zzbua, zzuu {
    private final Executor executor;
    private final View view;
    private final ScheduledExecutorService zzfkm;
    /* access modifiers changed from: private */
    public final zzdkw zzfkn;
    /* access modifiers changed from: private */
    public final zzdkk zzfko;
    /* access modifiers changed from: private */
    public final zzdpd zzfkp;
    private final zzeg zzfkq;
    private final zzabv zzfkr;
    private boolean zzfks;
    private boolean zzfkt;
    private final Context zzvr;

    public zzblk(Context context, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzdkw zzdkw, zzdkk zzdkk, zzdpd zzdpd, View view2, zzeg zzeg, zzabv zzabv) {
        this.zzvr = context;
        this.executor = executor2;
        this.zzfkm = scheduledExecutorService;
        this.zzfkn = zzdkw;
        this.zzfko = zzdkk;
        this.zzfkp = zzdpd;
        this.zzfkq = zzeg;
        this.view = view2;
        this.zzfkr = zzabv;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final synchronized void onAdLoaded() {
        if (this.zzfks) {
            ArrayList arrayList = new ArrayList(this.zzfko.zzdig);
            arrayList.addAll(this.zzfko.zzgzn);
            this.zzfkp.zza(this.zzfkn, this.zzfko, true, null, null, arrayList);
        } else {
            this.zzfkp.zza(this.zzfkn, this.zzfko, this.zzfko.zzgzp);
            this.zzfkp.zza(this.zzfkn, this.zzfko, this.zzfko.zzgzn);
        }
        this.zzfks = true;
    }

    @Override // com.google.android.gms.internal.ads.zzuu
    public final void onAdClicked() {
        zzdpd zzdpd = this.zzfkp;
        zzdkw zzdkw = this.zzfkn;
        zzdkk zzdkk = this.zzfko;
        zzdpd.zza(zzdkw, zzdkk, zzdkk.zzdif);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007c, code lost:
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzbtd
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAdImpression() {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.zzfkt     // Catch:{ all -> 0x007d }
            if (r0 != 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcqz     // Catch:{ all -> 0x007d }
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x007d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x007d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x007d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x007d }
            r1 = 0
            if (r0 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zzeg r0 = r9.zzfkq     // Catch:{ all -> 0x007d }
            com.google.android.gms.internal.ads.zzdw r0 = r0.zzcb()     // Catch:{ all -> 0x007d }
            android.content.Context r2 = r9.zzvr     // Catch:{ all -> 0x007d }
            android.view.View r3 = r9.view     // Catch:{ all -> 0x007d }
            java.lang.String r0 = r0.zza(r2, r3, r1)     // Catch:{ all -> 0x007d }
            r5 = r0
            goto L_0x0029
        L_0x0028:
            r5 = r1
        L_0x0029:
            com.google.android.gms.internal.ads.zzabx<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaci.zzczv     // Catch:{ all -> 0x007d }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x007d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x007d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x007d }
            r8 = 1
            if (r0 != 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzdpd r1 = r9.zzfkp     // Catch:{ all -> 0x007d }
            com.google.android.gms.internal.ads.zzdkw r2 = r9.zzfkn     // Catch:{ all -> 0x007d }
            com.google.android.gms.internal.ads.zzdkk r3 = r9.zzfko     // Catch:{ all -> 0x007d }
            r4 = 0
            r6 = 0
            com.google.android.gms.internal.ads.zzdkk r0 = r9.zzfko     // Catch:{ all -> 0x007d }
            java.util.List<java.lang.String> r7 = r0.zzdig     // Catch:{ all -> 0x007d }
            r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x007d }
            r9.zzfkt = r8     // Catch:{ all -> 0x007d }
            monitor-exit(r9)
            return
        L_0x004b:
            com.google.android.gms.internal.ads.zzabv r0 = r9.zzfkr
            android.content.Context r2 = r9.zzvr
            com.google.android.gms.internal.ads.zzdvf r0 = r0.zzc(r2, r1)
            com.google.android.gms.internal.ads.zzduo r0 = com.google.android.gms.internal.ads.zzduo.zzg(r0)
            com.google.android.gms.internal.ads.zzaag<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzaav.zzcof
            com.google.android.gms.internal.ads.zzaar r2 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledExecutorService r4 = r9.zzfkm
            com.google.android.gms.internal.ads.zzduo r0 = r0.zza(r1, r3, r4)
            com.google.android.gms.internal.ads.zzbln r1 = new com.google.android.gms.internal.ads.zzbln
            r1.<init>(r9, r5)
            java.util.concurrent.Executor r2 = r9.executor
            com.google.android.gms.internal.ads.zzdux.zza(r0, r1, r2)
            r9.zzfkt = r8
        L_0x007b:
            monitor-exit(r9)
            return
        L_0x007d:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblk.onAdImpression():void");
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void zzb(zzatg zzatg, String str, String str2) {
        zzdpd zzdpd = this.zzfkp;
        zzdkw zzdkw = this.zzfkn;
        zzdkk zzdkk = this.zzfko;
        zzdpd.zza(zzdkw, zzdkk, zzdkk.zzdrw, zzatg);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoStarted() {
        zzdpd zzdpd = this.zzfkp;
        zzdkw zzdkw = this.zzfkn;
        zzdkk zzdkk = this.zzfko;
        zzdpd.zza(zzdkw, zzdkk, zzdkk.zzdrv);
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoCompleted() {
        zzdpd zzdpd = this.zzfkp;
        zzdkw zzdkw = this.zzfkn;
        zzdkk zzdkk = this.zzfko;
        zzdpd.zza(zzdkw, zzdkk, zzdkk.zzgzo);
    }
}
