package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzhj implements Handler.Callback, zzmy, zzna, zzoh {
    private final Handler handler;
    private int repeatMode = 0;
    private int state;
    private final zzhv[] zzaeh;
    private final zzoe zzaei;
    private final Handler zzaek;
    private final zzib zzaen;
    private final zzic zzaeo;
    private boolean zzaeq;
    private boolean zzaeu;
    private zzia zzaev;
    private zzhw zzaez;
    private zzhl zzafa;
    private final zzhy[] zzafe;
    private final zzhu zzaff;
    private final zzpn zzafg;
    private final HandlerThread zzafh;
    private final zzhe zzafi;
    private zzhv zzafj;
    private zzpf zzafk;
    private zznb zzafl;
    private zzhv[] zzafm;
    private boolean zzafn;
    private boolean zzafo;
    private int zzafp;
    private int zzafq;
    private long zzafr;
    private int zzafs;
    private zzho zzaft;
    private long zzafu;
    private zzhm zzafv;
    private zzhm zzafw;
    private zzhm zzafx;

    public zzhj(zzhv[] zzhvArr, zzoe zzoe, zzhu zzhu, boolean z, int i, Handler handler2, zzhl zzhl, zzhe zzhe) {
        this.zzaeh = zzhvArr;
        this.zzaei = zzoe;
        this.zzaff = zzhu;
        this.zzaeq = z;
        this.zzaek = handler2;
        this.state = 1;
        this.zzafa = zzhl;
        this.zzafi = zzhe;
        this.zzafe = new zzhy[zzhvArr.length];
        for (int i2 = 0; i2 < zzhvArr.length; i2++) {
            zzhvArr[i2].setIndex(i2);
            this.zzafe[i2] = zzhvArr[i2].zzdy();
        }
        this.zzafg = new zzpn();
        this.zzafm = new zzhv[0];
        this.zzaen = new zzib();
        this.zzaeo = new zzic();
        zzoe.zza(this);
        this.zzaez = zzhw.zzahs;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzafh = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.zzafh.getLooper(), this);
    }

    public final void zza(zznb zznb, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zznb).sendToTarget();
    }

    public final void zzg(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzia zzia, int i, long j) {
        this.handler.obtainMessage(3, new zzho(zzia, i, j)).sendToTarget();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzhf... zzhfArr) {
        if (this.zzafn) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzafp++;
        this.handler.obtainMessage(11, zzhfArr).sendToTarget();
    }

    public final synchronized void zzb(zzhf... zzhfArr) {
        if (this.zzafn) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.zzafp;
        this.zzafp = i + 1;
        this.handler.obtainMessage(11, zzhfArr).sendToTarget();
        while (this.zzafq <= i) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final synchronized void release() {
        if (!this.zzafn) {
            this.handler.sendEmptyMessage(6);
            while (!this.zzafn) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            this.zzafh.quit();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzb(zzia zzia, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzia, obj)).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void zza(zzmz zzmz) {
        this.handler.obtainMessage(8, zzmz).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzoh
    public final void zzeo() {
        this.handler.sendEmptyMessage(10);
    }

    /* JADX DEBUG: Additional 1 move instruction added to help type inference */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.google.android.gms.internal.ads.zzmy, java.lang.Object, com.google.android.gms.internal.ads.zzna, com.google.android.gms.internal.ads.zzhj] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v33, types: [com.google.android.gms.internal.ads.zzia] */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.google.android.gms.internal.ads.zzia] */
    /* JADX WARN: Type inference failed for: r2v63, types: [com.google.android.gms.internal.ads.zzia] */
    /* JADX WARN: Type inference failed for: r2v71, types: [com.google.android.gms.internal.ads.zzia] */
    /* JADX WARN: Type inference failed for: r2v72, types: [com.google.android.gms.internal.ads.zzia] */
    /* JADX WARN: Type inference failed for: r7v18, types: [com.google.android.gms.internal.ads.zzia] */
    /* JADX WARN: Type inference failed for: r2v82, types: [com.google.android.gms.internal.ads.zzia] */
    /* JADX WARN: Type inference failed for: r3v55, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v100, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v106, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v107, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r6v24, types: [com.google.android.gms.internal.ads.zzia] */
    /* JADX WARN: Type inference failed for: r1v146, types: [com.google.android.gms.internal.ads.zzhm] */
    /* JADX WARN: Type inference failed for: r3v90, types: [com.google.android.gms.internal.ads.zzhm] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:479:0x089e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:480:0x089f, code lost:
        r1 = r0;
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x08a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x08a4, code lost:
        r1 = r0;
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:483:0x08a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x08a9, code lost:
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r0);
        ((com.google.android.gms.internal.ads.zzhj) r34).zzaek.obtainMessage(8, com.google.android.gms.internal.ads.zzhb.zza(r0)).sendToTarget();
        zzes();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:485:0x08c3, code lost:
        return true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x054d  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0550  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x058b  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x059d  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x05b9 A[LOOP:7: B:314:0x05b9->B:318:0x05cb, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x07d1  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x08a8 A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* JADX WARNING: Unknown variable types count: 16 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            r34 = this;
            r8 = r34
            r1 = r35
            r10 = 1
            int r2 = r1.what     // Catch:{ zzhb -> 0x08e0, IOException -> 0x08c4, RuntimeException -> 0x08a8 }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x0867;
                case 1: goto L_0x083a;
                case 2: goto L_0x0462;
                case 3: goto L_0x03ab;
                case 4: goto L_0x038a;
                case 5: goto L_0x0386;
                case 6: goto L_0x036f;
                case 7: goto L_0x0213;
                case 8: goto L_0x01df;
                case 9: goto L_0x01cc;
                case 10: goto L_0x00d9;
                case 11: goto L_0x009b;
                case 12: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            return r9
        L_0x0019:
            int r1 = r1.arg1     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            r8.repeatMode = r1     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafx     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafx     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
        L_0x0026:
            if (r2 == 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafw     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.zzhm r4 = r8.zzafv     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r2 != r4) goto L_0x0035
            r4 = 1
            goto L_0x0036
        L_0x0035:
            r4 = 0
        L_0x0036:
            com.google.android.gms.internal.ads.zzia r11 = r8.zzaev     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            int r12 = r2.zzafz     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            com.google.android.gms.internal.ads.zzic r13 = r8.zzaeo     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            com.google.android.gms.internal.ads.zzib r14 = r8.zzaen     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            int r11 = r11.zza(r12, r13, r14, r1)     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            com.google.android.gms.internal.ads.zzhm r12 = r2.zzagl     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r12 == 0) goto L_0x0061
            if (r11 == r5) goto L_0x0061
            com.google.android.gms.internal.ads.zzhm r12 = r2.zzagl     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            int r12 = r12.zzafz     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r12 != r11) goto L_0x0061
            com.google.android.gms.internal.ads.zzhm r2 = r2.zzagl     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            com.google.android.gms.internal.ads.zzhm r11 = r8.zzafw     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r2 != r11) goto L_0x0056
            r11 = 1
            goto L_0x0057
        L_0x0056:
            r11 = 0
        L_0x0057:
            r3 = r3 | r11
            com.google.android.gms.internal.ads.zzhm r11 = r8.zzafv     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r2 != r11) goto L_0x005e
            r11 = 1
            goto L_0x005f
        L_0x005e:
            r11 = 0
        L_0x005f:
            r4 = r4 | r11
            goto L_0x0036
        L_0x0061:
            com.google.android.gms.internal.ads.zzhm r5 = r2.zzagl     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r5 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzhm r5 = r2.zzagl     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            zza(r5)     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            r2.zzagl = r6     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
        L_0x006c:
            int r5 = r2.zzafz     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            boolean r5 = r8.zzt(r5)     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            r2.zzagi = r5     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r4 != 0) goto L_0x0078
            r8.zzafv = r2     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
        L_0x0078:
            if (r3 != 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafx     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r2 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafx     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            int r2 = r2.zzafz     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzafa     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            long r3 = r3.zzagb     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            long r3 = r8.zza(r2, r3)     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            com.google.android.gms.internal.ads.zzhl r5 = new com.google.android.gms.internal.ads.zzhl     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            r5.<init>(r2, r3)     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            r8.zzafa = r5     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
        L_0x0091:
            int r2 = r8.state     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            if (r2 != r15) goto L_0x009a
            if (r1 == 0) goto L_0x009a
            r8.setState(r7)     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
        L_0x009a:
            return r10
        L_0x009b:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            com.google.android.gms.internal.ads.zzhf[] r1 = (com.google.android.gms.internal.ads.zzhf[]) r1     // Catch:{ zzhb -> 0x08a3, IOException -> 0x089e, RuntimeException -> 0x08a8 }
            int r2 = r1.length     // Catch:{ all -> 0x00c8 }
        L_0x00a0:
            if (r9 >= r2) goto L_0x00b0
            r3 = r1[r9]     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.internal.ads.zzhg r4 = r3.zzaee     // Catch:{ all -> 0x00c8 }
            int r5 = r3.zzaef     // Catch:{ all -> 0x00c8 }
            java.lang.Object r3 = r3.zzaeg     // Catch:{ all -> 0x00c8 }
            r4.zza(r5, r3)     // Catch:{ all -> 0x00c8 }
            int r9 = r9 + 1
            goto L_0x00a0
        L_0x00b0:
            com.google.android.gms.internal.ads.zznb r1 = r8.zzafl     // Catch:{ all -> 0x00c8 }
            if (r1 == 0) goto L_0x00b9
            android.os.Handler r1 = r8.handler     // Catch:{ all -> 0x00c8 }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00c8 }
        L_0x00b9:
            monitor-enter(r34)
            int r1 = r8.zzafq     // Catch:{ all -> 0x00c4 }
            int r1 = r1 + r10
            r8.zzafq = r1     // Catch:{ all -> 0x00c4 }
            r34.notifyAll()     // Catch:{ all -> 0x00c4 }
            monitor-exit(r34)     // Catch:{ all -> 0x00c4 }
            return r10
        L_0x00c4:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00c4 }
            throw r1
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            monitor-enter(r34)
            int r2 = r8.zzafq     // Catch:{ all -> 0x00d5 }
            int r2 = r2 + r10
            r8.zzafq = r2     // Catch:{ all -> 0x00d5 }
            r34.notifyAll()     // Catch:{ all -> 0x00d5 }
            monitor-exit(r34)     // Catch:{ all -> 0x00d5 }
            throw r1
        L_0x00d5:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)
            throw r1
        L_0x00d9:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            if (r1 == 0) goto L_0x01cb
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            r2 = 1
        L_0x00e0:
            if (r1 == 0) goto L_0x01cb
            boolean r3 = r1.zzagj
            if (r3 != 0) goto L_0x00e8
            goto L_0x01cb
        L_0x00e8:
            boolean r3 = r1.zzex()
            if (r3 != 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafw
            if (r1 != r3) goto L_0x00f3
            r2 = 0
        L_0x00f3:
            com.google.android.gms.internal.ads.zzhm r1 = r1.zzagl
            goto L_0x00e0
        L_0x00f6:
            if (r2 == 0) goto L_0x0194
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafw
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            if (r2 == r3) goto L_0x0100
            r2 = 1
            goto L_0x0101
        L_0x0100:
            r2 = 0
        L_0x0101:
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            com.google.android.gms.internal.ads.zzhm r3 = r3.zzagl
            zza(r3)
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            r3.zzagl = r6
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            r8.zzafv = r3
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            r8.zzafw = r3
            com.google.android.gms.internal.ads.zzhv[] r3 = r8.zzaeh
            int r3 = r3.length
            boolean[] r3 = new boolean[r3]
            com.google.android.gms.internal.ads.zzhm r4 = r8.zzafx
            com.google.android.gms.internal.ads.zzhl r5 = r8.zzafa
            long r11 = r5.zzagb
            long r4 = r4.zza(r11, r2, r3)
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzafa
            long r11 = r2.zzagb
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzafa
            r2.zzagb = r4
            r8.zzdq(r4)
        L_0x0132:
            com.google.android.gms.internal.ads.zzhv[] r2 = r8.zzaeh
            int r2 = r2.length
            boolean[] r2 = new boolean[r2]
            r4 = 0
            r5 = 0
        L_0x0139:
            com.google.android.gms.internal.ads.zzhv[] r11 = r8.zzaeh
            int r11 = r11.length
            if (r4 >= r11) goto L_0x0185
            com.google.android.gms.internal.ads.zzhv[] r11 = r8.zzaeh
            r11 = r11[r4]
            int r12 = r11.getState()
            if (r12 == 0) goto L_0x014a
            r12 = 1
            goto L_0x014b
        L_0x014a:
            r12 = 0
        L_0x014b:
            r2[r4] = r12
            com.google.android.gms.internal.ads.zzhm r12 = r8.zzafx
            com.google.android.gms.internal.ads.zznk[] r12 = r12.zzagf
            r12 = r12[r4]
            if (r12 == 0) goto L_0x0157
            int r5 = r5 + 1
        L_0x0157:
            boolean r13 = r2[r4]
            if (r13 == 0) goto L_0x0182
            com.google.android.gms.internal.ads.zznk r13 = r11.zzea()
            if (r12 == r13) goto L_0x0179
            com.google.android.gms.internal.ads.zzhv r13 = r8.zzafj
            if (r11 != r13) goto L_0x0172
            if (r12 != 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzpn r12 = r8.zzafg
            com.google.android.gms.internal.ads.zzpf r13 = r8.zzafk
            r12.zza(r13)
        L_0x016e:
            r8.zzafk = r6
            r8.zzafj = r6
        L_0x0172:
            zza(r11)
            r11.disable()
            goto L_0x0182
        L_0x0179:
            boolean r12 = r3[r4]
            if (r12 == 0) goto L_0x0182
            long r12 = r8.zzafu
            r11.zzdm(r12)
        L_0x0182:
            int r4 = r4 + 1
            goto L_0x0139
        L_0x0185:
            android.os.Handler r3 = r8.zzaek
            com.google.android.gms.internal.ads.zzog r1 = r1.zzagm
            android.os.Message r1 = r3.obtainMessage(r14, r1)
            r1.sendToTarget()
            r8.zza(r2, r5)
            goto L_0x01c0
        L_0x0194:
            r8.zzafv = r1
            com.google.android.gms.internal.ads.zzhm r1 = r1.zzagl
        L_0x0198:
            if (r1 == 0) goto L_0x01a0
            r1.release()
            com.google.android.gms.internal.ads.zzhm r1 = r1.zzagl
            goto L_0x0198
        L_0x01a0:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            r1.zzagl = r6
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            boolean r1 = r1.zzagj
            if (r1 == 0) goto L_0x01c0
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            long r1 = r1.zzaga
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafv
            long r4 = r8.zzafu
            long r11 = r3.zzev()
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r1, r4)
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafv
            r3.zzb(r1, r9)
        L_0x01c0:
            r34.zzeu()
            r34.zzer()
            android.os.Handler r1 = r8.handler
            r1.sendEmptyMessage(r7)
        L_0x01cb:
            return r10
        L_0x01cc:
            java.lang.Object r1 = r1.obj
            com.google.android.gms.internal.ads.zzmz r1 = (com.google.android.gms.internal.ads.zzmz) r1
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            if (r2 == 0) goto L_0x01de
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            com.google.android.gms.internal.ads.zzmz r2 = r2.zzagd
            if (r2 == r1) goto L_0x01db
            goto L_0x01de
        L_0x01db:
            r34.zzeu()
        L_0x01de:
            return r10
        L_0x01df:
            java.lang.Object r1 = r1.obj
            com.google.android.gms.internal.ads.zzmz r1 = (com.google.android.gms.internal.ads.zzmz) r1
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            if (r2 == 0) goto L_0x0212
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            com.google.android.gms.internal.ads.zzmz r2 = r2.zzagd
            if (r2 == r1) goto L_0x01ee
            goto L_0x0212
        L_0x01ee:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            r1.zzagj = r10
            r1.zzex()
            long r2 = r1.zzaga
            long r2 = r1.zzb(r2, r9)
            r1.zzaga = r2
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            if (r1 != 0) goto L_0x020f
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            r8.zzafw = r1
            long r1 = r1.zzaga
            r8.zzdq(r1)
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafw
            r8.zzb(r1)
        L_0x020f:
            r34.zzeu()
        L_0x0212:
            return r10
        L_0x0213:
            java.lang.Object r1 = r1.obj
            android.util.Pair r1 = (android.util.Pair) r1
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            java.lang.Object r3 = r1.first
            com.google.android.gms.internal.ads.zzia r3 = (com.google.android.gms.internal.ads.zzia) r3
            r8.zzaev = r3
            java.lang.Object r1 = r1.second
            if (r2 != 0) goto L_0x0282
            int r3 = r8.zzafs
            if (r3 <= 0) goto L_0x0252
            com.google.android.gms.internal.ads.zzho r3 = r8.zzaft
            android.util.Pair r3 = r8.zza(r3)
            int r4 = r8.zzafs
            r8.zzafs = r9
            r8.zzaft = r6
            if (r3 != 0) goto L_0x023a
            r8.zza(r1, r4)
            goto L_0x036e
        L_0x023a:
            com.google.android.gms.internal.ads.zzhl r7 = new com.google.android.gms.internal.ads.zzhl
            java.lang.Object r11 = r3.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Long r3 = (java.lang.Long) r3
            long r14 = r3.longValue()
            r7.<init>(r11, r14)
            r8.zzafa = r7
            goto L_0x0283
        L_0x0252:
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzafa
            long r3 = r3.zzaga
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x0282
            com.google.android.gms.internal.ads.zzia r3 = r8.zzaev
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0267
            r8.zza(r1, r9)
            goto L_0x036e
        L_0x0267:
            android.util.Pair r3 = r8.zzb(r9, r12)
            com.google.android.gms.internal.ads.zzhl r4 = new com.google.android.gms.internal.ads.zzhl
            java.lang.Object r7 = r3.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Long r3 = (java.lang.Long) r3
            long r14 = r3.longValue()
            r4.<init>(r7, r14)
            r8.zzafa = r4
        L_0x0282:
            r4 = 0
        L_0x0283:
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            if (r3 == 0) goto L_0x028a
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            goto L_0x028c
        L_0x028a:
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafv
        L_0x028c:
            if (r3 == 0) goto L_0x036b
            com.google.android.gms.internal.ads.zzia r7 = r8.zzaev
            java.lang.Object r11 = r3.zzage
            int r7 = r7.zzc(r11)
            if (r7 != r5) goto L_0x02f0
            int r6 = r3.zzafz
            com.google.android.gms.internal.ads.zzia r7 = r8.zzaev
            int r2 = r8.zza(r6, r2, r7)
            if (r2 != r5) goto L_0x02a7
            r8.zza(r1, r4)
            goto L_0x036e
        L_0x02a7:
            com.google.android.gms.internal.ads.zzia r6 = r8.zzaev
            com.google.android.gms.internal.ads.zzic r7 = r8.zzaeo
            r6.zza(r2, r7, r9)
            android.util.Pair r2 = r8.zzb(r9, r12)
            java.lang.Object r6 = r2.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r11 = r2.longValue()
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            com.google.android.gms.internal.ads.zzic r7 = r8.zzaeo
            r2.zza(r6, r7, r10)
            com.google.android.gms.internal.ads.zzic r2 = r8.zzaeo
            java.lang.Object r2 = r2.zzage
            r3.zzafz = r5
        L_0x02cf:
            com.google.android.gms.internal.ads.zzhm r7 = r3.zzagl
            if (r7 == 0) goto L_0x02e3
            com.google.android.gms.internal.ads.zzhm r3 = r3.zzagl
            java.lang.Object r7 = r3.zzage
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x02df
            r7 = r6
            goto L_0x02e0
        L_0x02df:
            r7 = -1
        L_0x02e0:
            r3.zzafz = r7
            goto L_0x02cf
        L_0x02e3:
            long r2 = r8.zza(r6, r11)
            com.google.android.gms.internal.ads.zzhl r5 = new com.google.android.gms.internal.ads.zzhl
            r5.<init>(r6, r2)
            r8.zzafa = r5
            goto L_0x036b
        L_0x02f0:
            boolean r2 = r8.zzt(r7)
            r3.zzc(r7, r2)
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafw
            if (r3 != r2) goto L_0x02fd
            r2 = 1
            goto L_0x02fe
        L_0x02fd:
            r2 = 0
        L_0x02fe:
            com.google.android.gms.internal.ads.zzhl r11 = r8.zzafa
            int r11 = r11.zzafz
            if (r7 == r11) goto L_0x0317
            com.google.android.gms.internal.ads.zzhl r11 = r8.zzafa
            com.google.android.gms.internal.ads.zzhl r12 = new com.google.android.gms.internal.ads.zzhl
            long r13 = r11.zzaga
            r12.<init>(r7, r13)
            long r13 = r11.zzagb
            r12.zzagb = r13
            long r13 = r11.zzagc
            r12.zzagc = r13
            r8.zzafa = r12
        L_0x0317:
            com.google.android.gms.internal.ads.zzhm r11 = r3.zzagl
            if (r11 == 0) goto L_0x036b
            com.google.android.gms.internal.ads.zzhm r11 = r3.zzagl
            com.google.android.gms.internal.ads.zzia r12 = r8.zzaev
            com.google.android.gms.internal.ads.zzic r13 = r8.zzaeo
            com.google.android.gms.internal.ads.zzib r14 = r8.zzaen
            int r15 = r8.repeatMode
            int r7 = r12.zza(r7, r13, r14, r15)
            if (r7 == r5) goto L_0x034e
            java.lang.Object r12 = r11.zzage
            com.google.android.gms.internal.ads.zzia r13 = r8.zzaev
            com.google.android.gms.internal.ads.zzic r14 = r8.zzaeo
            com.google.android.gms.internal.ads.zzic r13 = r13.zza(r7, r14, r10)
            java.lang.Object r13 = r13.zzage
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x034e
            boolean r3 = r8.zzt(r7)
            r11.zzc(r7, r3)
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafw
            if (r11 != r3) goto L_0x034a
            r3 = 1
            goto L_0x034b
        L_0x034a:
            r3 = 0
        L_0x034b:
            r2 = r2 | r3
            r3 = r11
            goto L_0x0317
        L_0x034e:
            if (r2 != 0) goto L_0x0364
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafx
            int r2 = r2.zzafz
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzafa
            long r5 = r3.zzagb
            long r5 = r8.zza(r2, r5)
            com.google.android.gms.internal.ads.zzhl r3 = new com.google.android.gms.internal.ads.zzhl
            r3.<init>(r2, r5)
            r8.zzafa = r3
            goto L_0x036b
        L_0x0364:
            r8.zzafv = r3
            r3.zzagl = r6
            zza(r11)
        L_0x036b:
            r8.zzb(r1, r4)
        L_0x036e:
            return r10
        L_0x036f:
            r8.zzi(r10)
            com.google.android.gms.internal.ads.zzhu r1 = r8.zzaff
            r1.zzfb()
            r8.setState(r10)
            monitor-enter(r34)
            r8.zzafn = r10     // Catch:{ all -> 0x0382 }
            r34.notifyAll()     // Catch:{ all -> 0x0382 }
            monitor-exit(r34)     // Catch:{ all -> 0x0382 }
            return r10
        L_0x0382:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x0382 }
            throw r1
        L_0x0386:
            r34.zzes()
            return r10
        L_0x038a:
            java.lang.Object r1 = r1.obj
            com.google.android.gms.internal.ads.zzhw r1 = (com.google.android.gms.internal.ads.zzhw) r1
            com.google.android.gms.internal.ads.zzpf r2 = r8.zzafk
            if (r2 == 0) goto L_0x0399
            com.google.android.gms.internal.ads.zzpf r2 = r8.zzafk
            com.google.android.gms.internal.ads.zzhw r1 = r2.zzb(r1)
            goto L_0x039f
        L_0x0399:
            com.google.android.gms.internal.ads.zzpn r2 = r8.zzafg
            com.google.android.gms.internal.ads.zzhw r1 = r2.zzb(r1)
        L_0x039f:
            r8.zzaez = r1
            android.os.Handler r2 = r8.zzaek
            android.os.Message r1 = r2.obtainMessage(r11, r1)
            r1.sendToTarget()
            return r10
        L_0x03ab:
            java.lang.Object r1 = r1.obj
            com.google.android.gms.internal.ads.zzho r1 = (com.google.android.gms.internal.ads.zzho) r1
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            if (r2 != 0) goto L_0x03bc
            int r2 = r8.zzafs
            int r2 = r2 + r10
            r8.zzafs = r2
            r8.zzaft = r1
            goto L_0x0447
        L_0x03bc:
            android.util.Pair r2 = r8.zza(r1)
            if (r2 != 0) goto L_0x03e0
            com.google.android.gms.internal.ads.zzhl r1 = new com.google.android.gms.internal.ads.zzhl
            r1.<init>(r9, r3)
            r8.zzafa = r1
            android.os.Handler r2 = r8.zzaek
            android.os.Message r1 = r2.obtainMessage(r15, r10, r9, r1)
            r1.sendToTarget()
            com.google.android.gms.internal.ads.zzhl r1 = new com.google.android.gms.internal.ads.zzhl
            r1.<init>(r9, r12)
            r8.zzafa = r1
            r8.setState(r15)
            r8.zzi(r9)
            goto L_0x0447
        L_0x03e0:
            long r3 = r1.zzagq
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03e8
            r1 = 1
            goto L_0x03e9
        L_0x03e8:
            r1 = 0
        L_0x03e9:
            java.lang.Object r3 = r2.first
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzafa     // Catch:{ all -> 0x0448 }
            int r2 = r2.zzafz     // Catch:{ all -> 0x0448 }
            if (r3 != r2) goto L_0x0424
            r6 = 1000(0x3e8, double:4.94E-321)
            long r11 = r4 / r6
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzafa     // Catch:{ all -> 0x0448 }
            long r13 = r2.zzagb     // Catch:{ all -> 0x0448 }
            long r13 = r13 / r6
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x0424
            com.google.android.gms.internal.ads.zzhl r2 = new com.google.android.gms.internal.ads.zzhl
            r2.<init>(r3, r4)
            r8.zzafa = r2
            android.os.Handler r2 = r8.zzaek
            if (r1 == 0) goto L_0x0419
            r1 = 1
            goto L_0x041a
        L_0x0419:
            r1 = 0
        L_0x041a:
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzafa
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)
            r1.sendToTarget()
            goto L_0x0447
        L_0x0424:
            long r6 = r8.zza(r3, r4)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x042e
            r2 = 1
            goto L_0x042f
        L_0x042e:
            r2 = 0
        L_0x042f:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzhl r2 = new com.google.android.gms.internal.ads.zzhl
            r2.<init>(r3, r6)
            r8.zzafa = r2
            android.os.Handler r2 = r8.zzaek
            if (r1 == 0) goto L_0x043d
            r1 = 1
            goto L_0x043e
        L_0x043d:
            r1 = 0
        L_0x043e:
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzafa
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)
            r1.sendToTarget()
        L_0x0447:
            return r10
        L_0x0448:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzhl r6 = new com.google.android.gms.internal.ads.zzhl
            r6.<init>(r3, r4)
            r8.zzafa = r6
            android.os.Handler r3 = r8.zzaek
            if (r1 == 0) goto L_0x0457
            r1 = 1
            goto L_0x0458
        L_0x0457:
            r1 = 0
        L_0x0458:
            com.google.android.gms.internal.ads.zzhl r4 = r8.zzafa
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r4)
            r1.sendToTarget()
            throw r2
        L_0x0462:
            long r5 = android.os.SystemClock.elapsedRealtime()
            com.google.android.gms.internal.ads.zzia r1 = r8.zzaev
            if (r1 != 0) goto L_0x0472
            com.google.android.gms.internal.ads.zznb r1 = r8.zzafl
            r1.zzhy()
            r14 = r5
            goto L_0x06c9
        L_0x0472:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            if (r1 != 0) goto L_0x047b
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzafa
            int r1 = r1.zzafz
            goto L_0x04b9
        L_0x047b:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            int r1 = r1.zzafz
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            boolean r2 = r2.zzagi
            if (r2 != 0) goto L_0x04c6
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            boolean r2 = r2.zzew()
            if (r2 == 0) goto L_0x04c6
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            com.google.android.gms.internal.ads.zzic r7 = r8.zzaeo
            com.google.android.gms.internal.ads.zzic r2 = r2.zza(r1, r7, r9)
            long r14 = r2.zzaih
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x049c
            goto L_0x04c6
        L_0x049c:
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafx
            if (r2 == 0) goto L_0x04ad
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            int r2 = r2.index
            com.google.android.gms.internal.ads.zzhm r7 = r8.zzafx
            int r7 = r7.index
            int r2 = r2 - r7
            r7 = 100
            if (r2 == r7) goto L_0x04c6
        L_0x04ad:
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            com.google.android.gms.internal.ads.zzic r7 = r8.zzaeo
            com.google.android.gms.internal.ads.zzib r14 = r8.zzaen
            int r15 = r8.repeatMode
            int r1 = r2.zza(r1, r7, r14, r15)
        L_0x04b9:
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            int r2 = r2.zzff()
            if (r1 < r2) goto L_0x04c9
            com.google.android.gms.internal.ads.zznb r1 = r8.zzafl
            r1.zzhy()
        L_0x04c6:
            r14 = r5
            goto L_0x0599
        L_0x04c9:
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            if (r2 != 0) goto L_0x04d3
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzafa
            long r3 = r2.zzagb
        L_0x04d1:
            r14 = r5
            goto L_0x0528
        L_0x04d3:
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            com.google.android.gms.internal.ads.zzic r7 = r8.zzaeo
            r2.zza(r1, r7, r9)
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            com.google.android.gms.internal.ads.zzib r7 = r8.zzaen
            r2.zza(r9, r7, r9)
            if (r1 == 0) goto L_0x04e4
            goto L_0x04d1
        L_0x04e4:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            long r1 = r1.zzev()
            com.google.android.gms.internal.ads.zzia r7 = r8.zzaev
            com.google.android.gms.internal.ads.zzhm r14 = r8.zzafv
            int r14 = r14.zzafz
            com.google.android.gms.internal.ads.zzic r15 = r8.zzaeo
            com.google.android.gms.internal.ads.zzic r7 = r7.zza(r14, r15, r9)
            long r14 = r7.zzaih
            long r1 = r1 + r14
            long r14 = r8.zzafu
            long r1 = r1 - r14
            com.google.android.gms.internal.ads.zzia r7 = r8.zzaev
            r14 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r18 = java.lang.Math.max(r3, r1)
            r1 = r34
            r2 = r7
            r3 = r14
            r14 = r5
            r4 = r16
            r6 = r18
            android.util.Pair r1 = r1.zza(r2, r3, r4, r6)
            if (r1 == 0) goto L_0x0599
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            r1 = r2
        L_0x0528:
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            if (r2 != 0) goto L_0x0533
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x0530:
            r23 = r5
            goto L_0x0549
        L_0x0533:
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            long r5 = r2.zzev()
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            com.google.android.gms.internal.ads.zzhm r7 = r8.zzafv
            int r7 = r7.zzafz
            com.google.android.gms.internal.ads.zzic r11 = r8.zzaeo
            com.google.android.gms.internal.ads.zzic r2 = r2.zza(r7, r11, r9)
            long r12 = r2.zzaih
            long r5 = r5 + r12
            goto L_0x0530
        L_0x0549:
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            if (r2 != 0) goto L_0x0550
            r29 = 0
            goto L_0x0557
        L_0x0550:
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            int r2 = r2.index
            int r2 = r2 + r10
            r29 = r2
        L_0x0557:
            boolean r31 = r8.zzt(r1)
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            com.google.android.gms.internal.ads.zzic r5 = r8.zzaeo
            r2.zza(r1, r5, r10)
            com.google.android.gms.internal.ads.zzhm r2 = new com.google.android.gms.internal.ads.zzhm
            com.google.android.gms.internal.ads.zzhv[] r5 = r8.zzaeh
            com.google.android.gms.internal.ads.zzhy[] r6 = r8.zzafe
            com.google.android.gms.internal.ads.zzoe r7 = r8.zzaei
            com.google.android.gms.internal.ads.zzhu r11 = r8.zzaff
            com.google.android.gms.internal.ads.zznb r12 = r8.zzafl
            com.google.android.gms.internal.ads.zzic r13 = r8.zzaeo
            java.lang.Object r13 = r13.zzage
            r20 = r2
            r21 = r5
            r22 = r6
            r25 = r7
            r26 = r11
            r27 = r12
            r28 = r13
            r30 = r1
            r32 = r3
            r20.<init>(r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            if (r1 == 0) goto L_0x058f
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            r1.zzagl = r2
        L_0x058f:
            r8.zzafv = r2
            com.google.android.gms.internal.ads.zzmz r1 = r2.zzagd
            r1.zza(r8, r3)
            r8.zzh(r10)
        L_0x0599:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            if (r1 == 0) goto L_0x05b2
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            boolean r1 = r1.zzew()
            if (r1 == 0) goto L_0x05a6
            goto L_0x05b2
        L_0x05a6:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafv
            if (r1 == 0) goto L_0x05b5
            boolean r1 = r8.zzaeu
            if (r1 != 0) goto L_0x05b5
            r34.zzeu()
            goto L_0x05b5
        L_0x05b2:
            r8.zzh(r9)
        L_0x05b5:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            if (r1 == 0) goto L_0x06c9
        L_0x05b9:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafw
            if (r1 == r2) goto L_0x05f6
            long r1 = r8.zzafu
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            com.google.android.gms.internal.ads.zzhm r3 = r3.zzagl
            long r3 = r3.zzagh
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x05f6
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            r1.release()
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            com.google.android.gms.internal.ads.zzhm r1 = r1.zzagl
            r8.zzb(r1)
            com.google.android.gms.internal.ads.zzhl r1 = new com.google.android.gms.internal.ads.zzhl
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafx
            int r2 = r2.zzafz
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            long r3 = r3.zzaga
            r1.<init>(r2, r3)
            r8.zzafa = r1
            r34.zzer()
            android.os.Handler r1 = r8.zzaek
            r2 = 5
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzafa
            android.os.Message r1 = r1.obtainMessage(r2, r3)
            r1.sendToTarget()
            goto L_0x05b9
        L_0x05f6:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafw
            boolean r1 = r1.zzagi
            if (r1 == 0) goto L_0x0620
            r1 = 0
        L_0x05fd:
            com.google.android.gms.internal.ads.zzhv[] r2 = r8.zzaeh
            int r2 = r2.length
            if (r1 >= r2) goto L_0x06c9
            com.google.android.gms.internal.ads.zzhv[] r2 = r8.zzaeh
            r2 = r2[r1]
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafw
            com.google.android.gms.internal.ads.zznk[] r3 = r3.zzagf
            r3 = r3[r1]
            if (r3 == 0) goto L_0x061d
            com.google.android.gms.internal.ads.zznk r4 = r2.zzea()
            if (r4 != r3) goto L_0x061d
            boolean r3 = r2.zzeb()
            if (r3 == 0) goto L_0x061d
            r2.zzec()
        L_0x061d:
            int r1 = r1 + 1
            goto L_0x05fd
        L_0x0620:
            r1 = 0
        L_0x0621:
            com.google.android.gms.internal.ads.zzhv[] r2 = r8.zzaeh
            int r2 = r2.length
            if (r1 >= r2) goto L_0x0643
            com.google.android.gms.internal.ads.zzhv[] r2 = r8.zzaeh
            r2 = r2[r1]
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafw
            com.google.android.gms.internal.ads.zznk[] r3 = r3.zzagf
            r3 = r3[r1]
            com.google.android.gms.internal.ads.zznk r4 = r2.zzea()
            if (r4 != r3) goto L_0x06c9
            if (r3 == 0) goto L_0x0640
            boolean r2 = r2.zzeb()
            if (r2 != 0) goto L_0x0640
            goto L_0x06c9
        L_0x0640:
            int r1 = r1 + 1
            goto L_0x0621
        L_0x0643:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafw
            com.google.android.gms.internal.ads.zzhm r1 = r1.zzagl
            if (r1 == 0) goto L_0x06c9
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafw
            com.google.android.gms.internal.ads.zzhm r1 = r1.zzagl
            boolean r1 = r1.zzagj
            if (r1 == 0) goto L_0x06c9
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafw
            com.google.android.gms.internal.ads.zzog r1 = r1.zzagm
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafw
            com.google.android.gms.internal.ads.zzhm r2 = r2.zzagl
            r8.zzafw = r2
            com.google.android.gms.internal.ads.zzog r2 = r2.zzagm
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafw
            com.google.android.gms.internal.ads.zzmz r3 = r3.zzagd
            long r3 = r3.zzhp()
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0670
            r3 = 1
            goto L_0x0671
        L_0x0670:
            r3 = 0
        L_0x0671:
            r4 = 0
        L_0x0672:
            com.google.android.gms.internal.ads.zzhv[] r5 = r8.zzaeh
            int r5 = r5.length
            if (r4 >= r5) goto L_0x06c9
            com.google.android.gms.internal.ads.zzhv[] r5 = r8.zzaeh
            r5 = r5[r4]
            com.google.android.gms.internal.ads.zzof r6 = r1.zzbhq
            com.google.android.gms.internal.ads.zzod r6 = r6.zzbf(r4)
            if (r6 == 0) goto L_0x06c6
            if (r3 != 0) goto L_0x06c3
            boolean r6 = r5.zzed()
            if (r6 != 0) goto L_0x06c6
            com.google.android.gms.internal.ads.zzof r6 = r2.zzbhq
            com.google.android.gms.internal.ads.zzod r6 = r6.zzbf(r4)
            com.google.android.gms.internal.ads.zzhx[] r7 = r1.zzbhs
            r7 = r7[r4]
            com.google.android.gms.internal.ads.zzhx[] r11 = r2.zzbhs
            r11 = r11[r4]
            if (r6 == 0) goto L_0x06c3
            boolean r7 = r11.equals(r7)
            if (r7 == 0) goto L_0x06c3
            int r7 = r6.length()
            com.google.android.gms.internal.ads.zzhq[] r11 = new com.google.android.gms.internal.ads.zzhq[r7]
            r12 = 0
        L_0x06a8:
            if (r12 >= r7) goto L_0x06b3
            com.google.android.gms.internal.ads.zzhq r13 = r6.zzbc(r12)
            r11[r12] = r13
            int r12 = r12 + 1
            goto L_0x06a8
        L_0x06b3:
            com.google.android.gms.internal.ads.zzhm r6 = r8.zzafw
            com.google.android.gms.internal.ads.zznk[] r6 = r6.zzagf
            r6 = r6[r4]
            com.google.android.gms.internal.ads.zzhm r7 = r8.zzafw
            long r12 = r7.zzev()
            r5.zza(r11, r6, r12)
            goto L_0x06c6
        L_0x06c3:
            r5.zzec()
        L_0x06c6:
            int r4 = r4 + 1
            goto L_0x0672
        L_0x06c9:
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            r2 = 10
            if (r1 != 0) goto L_0x06d7
            r34.zzet()
            r8.zza(r14, r2)
            goto L_0x0839
        L_0x06d7:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzpp.beginSection(r1)
            r34.zzer()
            com.google.android.gms.internal.ads.zzhm r1 = r8.zzafx
            com.google.android.gms.internal.ads.zzmz r1 = r1.zzagd
            com.google.android.gms.internal.ads.zzhl r4 = r8.zzafa
            long r4 = r4.zzagb
            r1.zzef(r4)
            com.google.android.gms.internal.ads.zzhv[] r1 = r8.zzafm
            int r4 = r1.length
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x06f0:
            if (r5 >= r4) goto L_0x0727
            r11 = r1[r5]
            long r12 = r8.zzafu
            long r2 = r8.zzafr
            r11.zzb(r12, r2)
            if (r7 == 0) goto L_0x0705
            boolean r2 = r11.zzfd()
            if (r2 == 0) goto L_0x0705
            r7 = 1
            goto L_0x0706
        L_0x0705:
            r7 = 0
        L_0x0706:
            boolean r2 = r11.isReady()
            if (r2 != 0) goto L_0x0715
            boolean r2 = r11.zzfd()
            if (r2 == 0) goto L_0x0713
            goto L_0x0715
        L_0x0713:
            r2 = 0
            goto L_0x0716
        L_0x0715:
            r2 = 1
        L_0x0716:
            if (r2 != 0) goto L_0x071b
            r11.zzee()
        L_0x071b:
            if (r6 == 0) goto L_0x0721
            if (r2 == 0) goto L_0x0721
            r6 = 1
            goto L_0x0722
        L_0x0721:
            r6 = 0
        L_0x0722:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x06f0
        L_0x0727:
            if (r6 != 0) goto L_0x072c
            r34.zzet()
        L_0x072c:
            com.google.android.gms.internal.ads.zzpf r1 = r8.zzafk
            if (r1 == 0) goto L_0x0751
            com.google.android.gms.internal.ads.zzpf r1 = r8.zzafk
            com.google.android.gms.internal.ads.zzhw r1 = r1.zzfr()
            com.google.android.gms.internal.ads.zzhw r2 = r8.zzaez
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0751
            r8.zzaez = r1
            com.google.android.gms.internal.ads.zzpn r2 = r8.zzafg
            com.google.android.gms.internal.ads.zzpf r3 = r8.zzafk
            r2.zza(r3)
            android.os.Handler r2 = r8.zzaek
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
        L_0x0751:
            com.google.android.gms.internal.ads.zzia r1 = r8.zzaev
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafx
            int r2 = r2.zzafz
            com.google.android.gms.internal.ads.zzic r3 = r8.zzaeo
            com.google.android.gms.internal.ads.zzic r1 = r1.zza(r2, r3, r9)
            long r1 = r1.zzaih
            if (r7 == 0) goto L_0x0782
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0772
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzafa
            long r3 = r3.zzagb
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0782
        L_0x0772:
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafx
            boolean r3 = r3.zzagi
            if (r3 == 0) goto L_0x0782
            r3 = 4
            r8.setState(r3)
            r34.zzeq()
            r4 = 2
            goto L_0x0802
        L_0x0782:
            int r3 = r8.state
            r4 = 2
            if (r3 != r4) goto L_0x07e7
            com.google.android.gms.internal.ads.zzhv[] r3 = r8.zzafm
            int r3 = r3.length
            if (r3 <= 0) goto L_0x07d5
            if (r6 == 0) goto L_0x07d3
            boolean r1 = r8.zzafo
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            boolean r2 = r2.zzagj
            if (r2 != 0) goto L_0x079b
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            long r2 = r2.zzaga
            goto L_0x07a3
        L_0x079b:
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            com.google.android.gms.internal.ads.zzmz r2 = r2.zzagd
            long r2 = r2.zzhq()
        L_0x07a3:
            r5 = -9223372036854775808
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x07bf
            com.google.android.gms.internal.ads.zzhm r2 = r8.zzafv
            boolean r2 = r2.zzagi
            if (r2 == 0) goto L_0x07b1
            r1 = 1
            goto L_0x07cf
        L_0x07b1:
            com.google.android.gms.internal.ads.zzia r2 = r8.zzaev
            com.google.android.gms.internal.ads.zzhm r3 = r8.zzafv
            int r3 = r3.zzafz
            com.google.android.gms.internal.ads.zzic r5 = r8.zzaeo
            com.google.android.gms.internal.ads.zzic r2 = r2.zza(r3, r5, r9)
            long r2 = r2.zzaih
        L_0x07bf:
            com.google.android.gms.internal.ads.zzhu r5 = r8.zzaff
            com.google.android.gms.internal.ads.zzhm r6 = r8.zzafv
            long r11 = r8.zzafu
            long r6 = r6.zzev()
            long r11 = r11 - r6
            long r2 = r2 - r11
            boolean r1 = r5.zzc(r2, r1)
        L_0x07cf:
            if (r1 == 0) goto L_0x07d3
            r1 = 1
            goto L_0x07d9
        L_0x07d3:
            r1 = 0
            goto L_0x07d9
        L_0x07d5:
            boolean r1 = r8.zzdr(r1)
        L_0x07d9:
            if (r1 == 0) goto L_0x0802
            r1 = 3
            r8.setState(r1)
            boolean r1 = r8.zzaeq
            if (r1 == 0) goto L_0x0802
            r34.zzep()
            goto L_0x0802
        L_0x07e7:
            int r3 = r8.state
            r5 = 3
            if (r3 != r5) goto L_0x0802
            com.google.android.gms.internal.ads.zzhv[] r3 = r8.zzafm
            int r3 = r3.length
            if (r3 <= 0) goto L_0x07f2
            goto L_0x07f6
        L_0x07f2:
            boolean r6 = r8.zzdr(r1)
        L_0x07f6:
            if (r6 != 0) goto L_0x0802
            boolean r1 = r8.zzaeq
            r8.zzafo = r1
            r8.setState(r4)
            r34.zzeq()
        L_0x0802:
            int r1 = r8.state
            if (r1 != r4) goto L_0x0813
            com.google.android.gms.internal.ads.zzhv[] r1 = r8.zzafm
            int r2 = r1.length
        L_0x0809:
            if (r9 >= r2) goto L_0x0813
            r3 = r1[r9]
            r3.zzee()
            int r9 = r9 + 1
            goto L_0x0809
        L_0x0813:
            boolean r1 = r8.zzaeq
            if (r1 == 0) goto L_0x081c
            int r1 = r8.state
            r2 = 3
            if (r1 == r2) goto L_0x0820
        L_0x081c:
            int r1 = r8.state
            if (r1 != r4) goto L_0x0826
        L_0x0820:
            r1 = 10
            r8.zza(r14, r1)
            goto L_0x0836
        L_0x0826:
            com.google.android.gms.internal.ads.zzhv[] r1 = r8.zzafm
            int r1 = r1.length
            if (r1 == 0) goto L_0x0831
            r1 = 1000(0x3e8, double:4.94E-321)
            r8.zza(r14, r1)
            goto L_0x0836
        L_0x0831:
            android.os.Handler r1 = r8.handler
            r1.removeMessages(r4)
        L_0x0836:
            com.google.android.gms.internal.ads.zzpp.endSection()
        L_0x0839:
            return r10
        L_0x083a:
            r4 = 2
            int r1 = r1.arg1
            if (r1 == 0) goto L_0x0841
            r1 = 1
            goto L_0x0842
        L_0x0841:
            r1 = 0
        L_0x0842:
            r8.zzafo = r9
            r8.zzaeq = r1
            if (r1 != 0) goto L_0x084f
            r34.zzeq()
            r34.zzer()
            goto L_0x0866
        L_0x084f:
            int r1 = r8.state
            r2 = 3
            if (r1 != r2) goto L_0x085d
            r34.zzep()
            android.os.Handler r1 = r8.handler
            r1.sendEmptyMessage(r4)
            goto L_0x0866
        L_0x085d:
            int r1 = r8.state
            if (r1 != r4) goto L_0x0866
            android.os.Handler r1 = r8.handler
            r1.sendEmptyMessage(r4)
        L_0x0866:
            return r10
        L_0x0867:
            r4 = 2
            java.lang.Object r2 = r1.obj
            com.google.android.gms.internal.ads.zznb r2 = (com.google.android.gms.internal.ads.zznb) r2
            int r1 = r1.arg1
            if (r1 == 0) goto L_0x0872
            r1 = 1
            goto L_0x0873
        L_0x0872:
            r1 = 0
        L_0x0873:
            android.os.Handler r3 = r8.zzaek
            r3.sendEmptyMessage(r9)
            r8.zzi(r10)
            com.google.android.gms.internal.ads.zzhu r3 = r8.zzaff
            r3.zzfa()
            if (r1 == 0) goto L_0x088e
            com.google.android.gms.internal.ads.zzhl r1 = new com.google.android.gms.internal.ads.zzhl
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r9, r5)
            r8.zzafa = r1
        L_0x088e:
            r8.zzafl = r2
            com.google.android.gms.internal.ads.zzhe r1 = r8.zzafi
            r2.zza(r1, r10, r8)
            r8.setState(r4)
            android.os.Handler r1 = r8.handler
            r1.sendEmptyMessage(r4)
            return r10
        L_0x089e:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08c8
        L_0x08a3:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08e4
        L_0x08a8:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.zzaek
            com.google.android.gms.internal.ads.zzhb r1 = com.google.android.gms.internal.ads.zzhb.zza(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzes()
            return r10
        L_0x08c4:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08c8:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Source error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.zzaek
            com.google.android.gms.internal.ads.zzhb r1 = com.google.android.gms.internal.ads.zzhb.zza(r1)
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzes()
            return r10
        L_0x08e0:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08e4:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Renderer error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.zzaek
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzes()
            return r10
            switch-data {0->0x0867, 1->0x083a, 2->0x0462, 3->0x03ab, 4->0x038a, 5->0x0386, 6->0x036f, 7->0x0213, 8->0x01df, 9->0x01cc, 10->0x00d9, 11->0x009b, 12->0x0019, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhj.handleMessage(android.os.Message):boolean");
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzaek.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzh(boolean z) {
        if (this.zzaeu != z) {
            this.zzaeu = z;
            this.zzaek.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzep() throws zzhb {
        this.zzafo = false;
        this.zzafg.start();
        for (zzhv zzhv : this.zzafm) {
            zzhv.start();
        }
    }

    private final void zzeq() throws zzhb {
        this.zzafg.stop();
        for (zzhv zzhv : this.zzafm) {
            zza(zzhv);
        }
    }

    private final void zzer() throws zzhb {
        long j;
        zzhm zzhm = this.zzafx;
        if (zzhm != null) {
            long zzhp = zzhm.zzagd.zzhp();
            if (zzhp != -9223372036854775807L) {
                zzdq(zzhp);
            } else {
                zzhv zzhv = this.zzafj;
                if (zzhv == null || zzhv.zzfd()) {
                    this.zzafu = this.zzafg.zzgb();
                } else {
                    long zzgb = this.zzafk.zzgb();
                    this.zzafu = zzgb;
                    this.zzafg.zzel(zzgb);
                }
                zzhp = this.zzafu - this.zzafx.zzev();
            }
            this.zzafa.zzagb = zzhp;
            this.zzafr = SystemClock.elapsedRealtime() * 1000;
            if (this.zzafm.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzafx.zzagd.zzhq();
            }
            zzhl zzhl = this.zzafa;
            if (j == Long.MIN_VALUE) {
                j = this.zzaev.zza(this.zzafx.zzafz, this.zzaeo, false).zzaih;
            }
            zzhl.zzagc = j;
        }
    }

    private final void zza(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long zza(int i, long j) throws zzhb {
        zzhm zzhm;
        zzeq();
        this.zzafo = false;
        setState(2);
        zzhm zzhm2 = this.zzafx;
        if (zzhm2 == null) {
            zzhm zzhm3 = this.zzafv;
            if (zzhm3 != null) {
                zzhm3.release();
            }
            zzhm = null;
        } else {
            zzhm = null;
            while (zzhm2 != null) {
                if (zzhm2.zzafz != i || !zzhm2.zzagj) {
                    zzhm2.release();
                } else {
                    zzhm = zzhm2;
                }
                zzhm2 = zzhm2.zzagl;
            }
        }
        zzhm zzhm4 = this.zzafx;
        if (!(zzhm4 == zzhm && zzhm4 == this.zzafw)) {
            for (zzhv zzhv : this.zzafm) {
                zzhv.disable();
            }
            this.zzafm = new zzhv[0];
            this.zzafk = null;
            this.zzafj = null;
            this.zzafx = null;
        }
        if (zzhm != null) {
            zzhm.zzagl = null;
            this.zzafv = zzhm;
            this.zzafw = zzhm;
            zzb(zzhm);
            if (this.zzafx.zzagk) {
                j = this.zzafx.zzagd.zzeg(j);
            }
            zzdq(j);
            zzeu();
        } else {
            this.zzafv = null;
            this.zzafw = null;
            this.zzafx = null;
            zzdq(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final void zzdq(long j) throws zzhb {
        long j2;
        zzhm zzhm = this.zzafx;
        if (zzhm == null) {
            j2 = 60000000;
        } else {
            j2 = zzhm.zzev();
        }
        long j3 = j + j2;
        this.zzafu = j3;
        this.zzafg.zzel(j3);
        for (zzhv zzhv : this.zzafm) {
            zzhv.zzdm(this.zzafu);
        }
    }

    private final void zzes() {
        zzi(true);
        this.zzaff.onStopped();
        setState(1);
    }

    private final void zzi(boolean z) {
        this.handler.removeMessages(2);
        this.zzafo = false;
        this.zzafg.stop();
        this.zzafk = null;
        this.zzafj = null;
        this.zzafu = 60000000;
        zzhv[] zzhvArr = this.zzafm;
        for (zzhv zzhv : zzhvArr) {
            try {
                zza(zzhv);
                zzhv.disable();
            } catch (zzhb | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzafm = new zzhv[0];
        zzhm zzhm = this.zzafx;
        if (zzhm == null) {
            zzhm = this.zzafv;
        }
        zza(zzhm);
        this.zzafv = null;
        this.zzafw = null;
        this.zzafx = null;
        zzh(false);
        if (z) {
            zznb zznb = this.zzafl;
            if (zznb != null) {
                zznb.zzhz();
                this.zzafl = null;
            }
            this.zzaev = null;
        }
    }

    private static void zza(zzhv zzhv) throws zzhb {
        if (zzhv.getState() == 2) {
            zzhv.stop();
        }
    }

    private final boolean zzdr(long j) {
        if (j == -9223372036854775807L || this.zzafa.zzagb < j) {
            return true;
        }
        return this.zzafx.zzagl != null && this.zzafx.zzagl.zzagj;
    }

    private final void zzet() throws IOException {
        zzhm zzhm = this.zzafv;
        if (zzhm != null && !zzhm.zzagj) {
            zzhm zzhm2 = this.zzafw;
            if (zzhm2 == null || zzhm2.zzagl == this.zzafv) {
                zzhv[] zzhvArr = this.zzafm;
                int length = zzhvArr.length;
                int i = 0;
                while (i < length) {
                    if (zzhvArr[i].zzeb()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzafv.zzagd.zzhn();
            }
        }
    }

    private final void zza(Object obj, int i) {
        this.zzafa = new zzhl(0, 0);
        zzb(obj, i);
        this.zzafa = new zzhl(0, -9223372036854775807L);
        setState(4);
        zzi(false);
    }

    private final void zzb(Object obj, int i) {
        this.zzaek.obtainMessage(6, new zzhn(this.zzaev, obj, this.zzafa, i)).sendToTarget();
    }

    private final int zza(int i, zzia zzia, zzia zzia2) {
        int zzff = zzia.zzff();
        int i2 = -1;
        for (int i3 = 0; i3 < zzff && i2 == -1; i3++) {
            i = zzia.zza(i, this.zzaeo, this.zzaen, this.repeatMode);
            i2 = zzia2.zzc(zzia.zza(i, this.zzaeo, true).zzage);
        }
        return i2;
    }

    private final boolean zzt(int i) {
        this.zzaev.zza(i, this.zzaeo, false);
        if (this.zzaev.zza(0, this.zzaen, false).zzaid || this.zzaev.zza(i, this.zzaeo, this.zzaen, this.repeatMode) != -1) {
            return false;
        }
        return true;
    }

    private final Pair<Integer, Long> zza(zzho zzho) {
        zzia zzia = zzho.zzaev;
        if (zzia.isEmpty()) {
            zzia = this.zzaev;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzia, zzho.zzagp, zzho.zzagq);
            zzia zzia2 = this.zzaev;
            if (zzia2 == zzia) {
                return zzb;
            }
            int zzc = zzia2.zzc(zzia.zza(((Integer) zzb.first).intValue(), this.zzaeo, true).zzage);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzia, this.zzaev);
            if (zza == -1) {
                return null;
            }
            this.zzaev.zza(zza, this.zzaeo, false);
            return zzb(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhr(this.zzaev, zzho.zzagp, zzho.zzagq);
        }
    }

    private final Pair<Integer, Long> zzb(int i, long j) {
        return zzb(this.zzaev, i, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzb(zzia zzia, int i, long j) {
        return zza(zzia, i, j, 0);
    }

    private final Pair<Integer, Long> zza(zzia zzia, int i, long j, long j2) {
        zzpb.zzc(i, 0, zzia.zzfe());
        zzia.zza(i, this.zzaen, false, j2);
        if (j == -9223372036854775807L) {
            j = this.zzaen.zzaig;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.zzaen.zzaii + j;
        long j4 = zzia.zza(0, this.zzaeo, false).zzaih;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private final void zzeu() {
        long j;
        if (!this.zzafv.zzagj) {
            j = 0;
        } else {
            j = this.zzafv.zzagd.zzhm();
        }
        if (j == Long.MIN_VALUE) {
            zzh(false);
            return;
        }
        long zzev = this.zzafu - this.zzafv.zzev();
        boolean zzdt = this.zzaff.zzdt(j - zzev);
        zzh(zzdt);
        if (zzdt) {
            this.zzafv.zzagd.zzee(zzev);
        }
    }

    private static void zza(zzhm zzhm) {
        while (zzhm != null) {
            zzhm.release();
            zzhm = zzhm.zzagl;
        }
    }

    private final void zzb(zzhm zzhm) throws zzhb {
        if (this.zzafx != zzhm) {
            boolean[] zArr = new boolean[this.zzaeh.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzhv[] zzhvArr = this.zzaeh;
                if (i < zzhvArr.length) {
                    zzhv zzhv = zzhvArr[i];
                    zArr[i] = zzhv.getState() != 0;
                    zzod zzbf = zzhm.zzagm.zzbhq.zzbf(i);
                    if (zzbf != null) {
                        i2++;
                    }
                    if (zArr[i] && (zzbf == null || (zzhv.zzed() && zzhv.zzea() == this.zzafx.zzagf[i]))) {
                        if (zzhv == this.zzafj) {
                            this.zzafg.zza(this.zzafk);
                            this.zzafk = null;
                            this.zzafj = null;
                        }
                        zza(zzhv);
                        zzhv.disable();
                    }
                    i++;
                } else {
                    this.zzafx = zzhm;
                    this.zzaek.obtainMessage(3, zzhm.zzagm).sendToTarget();
                    zza(zArr, i2);
                    return;
                }
            }
        }
    }

    private final void zza(boolean[] zArr, int i) throws zzhb {
        this.zzafm = new zzhv[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhv[] zzhvArr = this.zzaeh;
            if (i2 < zzhvArr.length) {
                zzhv zzhv = zzhvArr[i2];
                zzod zzbf = this.zzafx.zzagm.zzbhq.zzbf(i2);
                if (zzbf != null) {
                    int i4 = i3 + 1;
                    this.zzafm[i3] = zzhv;
                    if (zzhv.getState() == 0) {
                        zzhx zzhx = this.zzafx.zzagm.zzbhs[i2];
                        boolean z = this.zzaeq && this.state == 3;
                        boolean z2 = !zArr[i2] && z;
                        int length = zzbf.length();
                        zzhq[] zzhqArr = new zzhq[length];
                        for (int i5 = 0; i5 < length; i5++) {
                            zzhqArr[i5] = zzbf.zzbc(i5);
                        }
                        zzhv.zza(zzhx, zzhqArr, this.zzafx.zzagf[i2], this.zzafu, z2, this.zzafx.zzev());
                        zzpf zzdz = zzhv.zzdz();
                        if (zzdz != null) {
                            if (this.zzafk == null) {
                                this.zzafk = zzdz;
                                this.zzafj = zzhv;
                                zzdz.zzb(this.zzaez);
                            } else {
                                throw zzhb.zza(new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzhv.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zznn] */
    @Override // com.google.android.gms.internal.ads.zznm
    public final /* synthetic */ void zza(zzmz zzmz) {
        this.handler.obtainMessage(9, zzmz).sendToTarget();
    }
}
