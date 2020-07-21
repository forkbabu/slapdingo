package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzfo extends zzgm {
    private static final zzgl<zzcy> zzaaw = new zzgl<>();
    private final Context zzaau;
    private zzby.zza zzaax = null;

    public zzfo(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2, Context context, zzby.zza zza2) {
        super(zzex, str, str2, zza, i, 27);
        this.zzaau = context;
        this.zzaax = zza2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    @Override // com.google.android.gms.internal.ads.zzgm
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcx() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzgl<com.google.android.gms.internal.ads.zzcy> r0 = com.google.android.gms.internal.ads.zzfo.zzaaw
            android.content.Context r1 = r8.zzaau
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.zzas(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcy r1 = (com.google.android.gms.internal.ads.zzcy) r1     // Catch:{ all -> 0x011e }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r1.zznw     // Catch:{ all -> 0x011e }
            boolean r4 = com.google.android.gms.internal.ads.zzfg.zzar(r4)     // Catch:{ all -> 0x011e }
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = r1.zznw     // Catch:{ all -> 0x011e }
            java.lang.String r5 = "E"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x011e }
            if (r4 != 0) goto L_0x0036
            java.lang.String r1 = r1.zznw     // Catch:{ all -> 0x011e }
            java.lang.String r4 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == 0) goto L_0x00ea
            com.google.android.gms.internal.ads.zzby$zza r1 = r8.zzaax     // Catch:{ all -> 0x011e }
            java.lang.String r1 = zza(r1)     // Catch:{ all -> 0x011e }
            boolean r1 = com.google.android.gms.internal.ads.zzfg.zzar(r1)     // Catch:{ all -> 0x011e }
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x011e }
            goto L_0x0082
        L_0x0048:
            com.google.android.gms.internal.ads.zzby$zza r1 = r8.zzaax     // Catch:{ all -> 0x011e }
            java.lang.String r4 = zza(r1)     // Catch:{ all -> 0x011e }
            boolean r4 = com.google.android.gms.internal.ads.zzfg.zzar(r4)     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x006a
            if (r1 == 0) goto L_0x006a
            boolean r4 = r1.zzy()     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzby$zzb r1 = r1.zzz()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcb r1 = r1.zzad()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcb r4 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011e }
            if (r1 != r4) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x011e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzex r1 = r8.zzwf     // Catch:{ all -> 0x011e }
            boolean r1 = r1.zzcn()     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011e }
            goto L_0x0082
        L_0x0080:
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011e }
        L_0x0082:
            java.lang.reflect.Method r4 = r8.zzabl     // Catch:{ all -> 0x011e }
            r5 = 0
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x011e }
            android.content.Context r7 = r8.zzaau     // Catch:{ all -> 0x011e }
            r6[r2] = r7     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcb r7 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011e }
            if (r1 != r7) goto L_0x0091
            r2 = 1
        L_0x0091:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x011e }
            r6[r3] = r2     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzaav.zzcql     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzaar r7 = com.google.android.gms.internal.ads.zzwg.zzpw()     // Catch:{ all -> 0x011e }
            java.lang.Object r2 = r7.zzd(r2)     // Catch:{ all -> 0x011e }
            r7 = 2
            r6[r7] = r2     // Catch:{ all -> 0x011e }
            java.lang.Object r2 = r4.invoke(r5, r6)     // Catch:{ all -> 0x011e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcy r4 = new com.google.android.gms.internal.ads.zzcy     // Catch:{ all -> 0x011e }
            r4.<init>(r2)     // Catch:{ all -> 0x011e }
            java.lang.String r2 = r4.zznw     // Catch:{ all -> 0x011e }
            boolean r2 = com.google.android.gms.internal.ads.zzfg.zzar(r2)     // Catch:{ all -> 0x011e }
            if (r2 != 0) goto L_0x00c1
            java.lang.String r2 = r4.zznw     // Catch:{ all -> 0x011e }
            java.lang.String r5 = "E"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x00e7
        L_0x00c1:
            int[] r2 = com.google.android.gms.internal.ads.zzfn.zzaav     // Catch:{ all -> 0x011e }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x011e }
            r1 = r2[r1]     // Catch:{ all -> 0x011e }
            if (r1 == r3) goto L_0x00db
            if (r1 == r7) goto L_0x00ce
            goto L_0x00e7
        L_0x00ce:
            java.lang.String r1 = r8.zzcy()     // Catch:{ all -> 0x011e }
            boolean r2 = com.google.android.gms.internal.ads.zzfg.zzar(r1)     // Catch:{ all -> 0x011e }
            if (r2 != 0) goto L_0x00e7
            r4.zznw = r1     // Catch:{ all -> 0x011e }
            goto L_0x00e7
        L_0x00db:
            com.google.android.gms.internal.ads.zzby$zza r1 = r8.zzaax     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzby$zzc r1 = r1.zzab()     // Catch:{ all -> 0x011e }
            java.lang.String r1 = r1.zzag()     // Catch:{ all -> 0x011e }
            r4.zznw = r1     // Catch:{ all -> 0x011e }
        L_0x00e7:
            r0.set(r4)     // Catch:{ all -> 0x011e }
        L_0x00ea:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcy r1 = (com.google.android.gms.internal.ads.zzcy) r1     // Catch:{ all -> 0x011e }
            monitor-exit(r0)     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzcf$zza$zza r2 = r8.zzabb
            monitor-enter(r2)
            if (r1 == 0) goto L_0x0119
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r8.zzabb     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zznw     // Catch:{ all -> 0x011b }
            r0.zzv(r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r8.zzabb     // Catch:{ all -> 0x011b }
            long r3 = r1.zznx     // Catch:{ all -> 0x011b }
            r0.zzt(r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r8.zzabb     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zzny     // Catch:{ all -> 0x011b }
            r0.zzx(r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r8.zzabb     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zznz     // Catch:{ all -> 0x011b }
            r0.zzy(r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r8.zzabb     // Catch:{ all -> 0x011b }
            java.lang.String r1 = r1.zzoa     // Catch:{ all -> 0x011b }
            r0.zzz(r1)     // Catch:{ all -> 0x011b }
        L_0x0119:
            monitor-exit(r2)     // Catch:{ all -> 0x011b }
            return
        L_0x011b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011b }
            throw r0
        L_0x011e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfo.zzcx():void");
    }

    private static String zza(zzby.zza zza) {
        if (zza == null || !zza.zzaa() || zzfg.zzar(zza.zzab().zzag())) {
            return null;
        }
        return zza.zzab().zzag();
    }

    private final String zzcy() {
        try {
            if (this.zzwf.zzcq() != null) {
                this.zzwf.zzcq().get();
            }
            zzcf.zza zzcp = this.zzwf.zzcp();
            if (zzcp == null || !zzcp.zzak()) {
                return null;
            }
            return zzcp.zzag();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
