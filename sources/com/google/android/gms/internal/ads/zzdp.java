package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdp implements zzdw {
    private static zzdp zzvq;
    private final Context zzvr;
    private final zzdrb zzvs;
    private final zzdrm zzvt;
    private final zzew zzvu;
    /* access modifiers changed from: private */
    public final zzdpm zzvv;
    private final Executor zzvw;
    private final zzgo zzvx;
    private final zzdrh zzvy;
    private volatile long zzvz = 0;
    /* access modifiers changed from: private */
    public final Object zzwa = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzwb;

    public static synchronized zzdp zza(String str, Context context, boolean z) {
        zzdp zzdp;
        synchronized (zzdp.class) {
            if (zzvq == null) {
                zzdpn zzauw = zzdpn.zzauv().zzha(str).zzbq(z).zzauw();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzdp zza = zza(context, zzdpm.zza(context, newCachedThreadPool), zzauw, newCachedThreadPool);
                zzvq = zza;
                zza.zzbr();
                zzvq.zzbu();
            }
            zzdp = zzvq;
        }
        return zzdp;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(int i, int i2, int i3) {
    }

    static zzdp zza(Context context, zzdpm zzdpm, zzdpn zzdpn) {
        return zza(context, zzdpm, zzdpn, Executors.newCachedThreadPool());
    }

    private static zzdp zza(Context context, zzdpm zzdpm, zzdpn zzdpn, Executor executor) {
        zzdpz zza = zzdpz.zza(context, executor, zzdpm, zzdpn);
        zzev zzev = new zzev(context);
        zzew zzew = new zzew(zzdpn, zza, new zzfi(context, zzev), zzev);
        zzgo zzavl = new zzdqp(context, zzdpm).zzavl();
        zzdpk zzdpk = new zzdpk();
        return new zzdp(context, zzdpm, new zzdrb(context, zzavl), new zzdrm(context, zzew, zzdpm, zzdpk), zzew, executor, zzdpk, zzavl);
    }

    private zzdp(Context context, zzdpm zzdpm, zzdrb zzdrb, zzdrm zzdrm, zzew zzew, Executor executor, zzdpk zzdpk, zzgo zzgo) {
        this.zzvr = context;
        this.zzvv = zzdpm;
        this.zzvs = zzdrb;
        this.zzvt = zzdrm;
        this.zzvu = zzew;
        this.zzvw = executor;
        this.zzvx = zzgo;
        this.zzvy = new zzds(this, zzdpk);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzbr() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdrc zzeg = this.zzvs.zzeg(zzdrk.zzhjs);
        if (zzeg == null || zzeg.zza()) {
            this.zzvv.zzg(4013, System.currentTimeMillis() - currentTimeMillis);
        } else {
            this.zzvt.zzb(zzeg);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbs() {
        this.zzvw.execute(new zzdr(this));
    }

    /* access modifiers changed from: private */
    public final void zzbt() {
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        zzdrc zzeg = this.zzvs.zzeg(zzdrk.zzhjs);
        if (zzeg != null) {
            String zzdh = zzeg.zzavv().zzdh();
            str = zzeg.zzavv().zzdi();
            str2 = zzdh;
        } else {
            str2 = null;
            str = null;
        }
        try {
            zzdrf zza = zzdpv.zza(this.zzvr, 1, this.zzvx, str2, str, "1", this.zzvv);
            if (zza.zzhjq != null) {
                if (zza.zzhjq.length != 0) {
                    zzgq zza2 = zzgq.zza(zzeer.zzu(zza.zzhjq), zzefo.zzber());
                    boolean z = false;
                    if (!zza2.zzdd().zzdh().isEmpty() && !zza2.zzdd().zzdi().isEmpty()) {
                        if (zza2.zzdf().toByteArray().length != 0) {
                            zzdrc zzeg2 = this.zzvs.zzeg(zzdrk.zzhjs);
                            if (zzeg2 != null) {
                                zzgr zzavv = zzeg2.zzavv();
                                if (zzavv != null) {
                                    if (zza2.zzdd().zzdh().equals(zzavv.zzdh())) {
                                        if (!zza2.zzdd().zzdi().equals(zzavv.zzdi())) {
                                        }
                                    }
                                }
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        this.zzvv.zzg(5010, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    } else if (!this.zzvs.zza(zza2, this.zzvy)) {
                        this.zzvv.zzg(4009, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    } else {
                        this.zzvt.zzb(this.zzvs.zzeg(zzdrk.zzhjs));
                        this.zzvz = System.currentTimeMillis() / 1000;
                        return;
                    }
                }
            }
            this.zzvv.zzg(5009, System.currentTimeMillis() - currentTimeMillis);
        } catch (zzegl e) {
            this.zzvv.zza(4002, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zza(MotionEvent motionEvent) {
        zzdpp zzawa = this.zzvt.zzawa();
        if (zzawa != null) {
            try {
                zzawa.zza(null, motionEvent);
            } catch (zzdrj e) {
                this.zzvv.zza(e.zzavz(), -1, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view, Activity activity) {
        zzbu();
        zzdpp zzawa = this.zzvt.zzawa();
        if (zzawa == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza = zzawa.zza(context, null, str, view, activity);
        this.zzvv.zza(5000, System.currentTimeMillis() - currentTimeMillis, zza, null);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final void zzb(View view) {
        this.zzvu.zzc(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zza(Context context, View view, Activity activity) {
        zzbu();
        zzdpp zzawa = this.zzvt.zzawa();
        if (zzawa == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb = zzawa.zzb(context, null, view, activity);
        this.zzvv.zza(5002, System.currentTimeMillis() - currentTimeMillis, zzb, null);
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdw
    public final String zzb(Context context) {
        zzbu();
        zzdpp zzawa = this.zzvt.zzawa();
        if (zzawa == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzv = zzawa.zzv(context, null);
        this.zzvv.zza(5001, System.currentTimeMillis() - currentTimeMillis, zzv, null);
        return zzv;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzbu() {
        /*
            r6 = this;
            boolean r0 = r6.zzwb
            if (r0 != 0) goto L_0x0033
            java.lang.Object r0 = r6.zzwa
            monitor-enter(r0)
            boolean r1 = r6.zzwb     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0030 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r6.zzvz     // Catch:{ all -> 0x0030 }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzdrm r1 = r6.zzvt     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzdrc r1 = r1.zzawb()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzfg(r3)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
        L_0x002b:
            r6.zzbs()     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.zzbu():void");
    }
}
