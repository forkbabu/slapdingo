package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zznh {
    private int length;
    private int[] zzaom = new int[1000];
    private long[] zzaon = new long[1000];
    private long[] zzaop = new long[1000];
    private int[] zzayd = new int[1000];
    private int zzbfg = 1000;
    private int[] zzbfh = new int[1000];
    private zzkh[] zzbfi = new zzkh[1000];
    private zzhq[] zzbfj = new zzhq[1000];
    private int zzbfk;
    private int zzbfl;
    private int zzbfm;
    private long zzbfn = Long.MIN_VALUE;
    private long zzbfo = Long.MIN_VALUE;
    private boolean zzbfp = true;
    private boolean zzbfq = true;
    private zzhq zzbfr;

    public final void zzia() {
        this.zzbfk = 0;
        this.zzbfl = 0;
        this.zzbfm = 0;
        this.length = 0;
        this.zzbfp = true;
    }

    public final void zzib() {
        this.zzbfn = Long.MIN_VALUE;
        this.zzbfo = Long.MIN_VALUE;
    }

    public final int zzic() {
        return this.zzbfk + this.length;
    }

    public final synchronized boolean zzid() {
        return this.length != 0;
    }

    public final synchronized zzhq zzie() {
        if (this.zzbfq) {
            return null;
        }
        return this.zzbfr;
    }

    public final synchronized long zzhu() {
        return Math.max(this.zzbfn, this.zzbfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zza(com.google.android.gms.internal.ads.zzhs r5, com.google.android.gms.internal.ads.zzjm r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzhq r9, com.google.android.gms.internal.ads.zzng r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzid()     // Catch:{ all -> 0x00a4 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0024
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzhq r6 = r4.zzbfr
            if (r6 == 0) goto L_0x0022
            if (r7 != 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzhq r6 = r4.zzbfr
            if (r6 == r9) goto L_0x0022
        L_0x001c:
            com.google.android.gms.internal.ads.zzhq r6 = r4.zzbfr
            r5.zzahr = r6
            monitor-exit(r4)
            return r1
        L_0x0022:
            monitor-exit(r4)
            return r2
        L_0x0024:
            if (r7 != 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzhq[] r7 = r4.zzbfj
            int r8 = r4.zzbfl
            r7 = r7[r8]
            if (r7 == r9) goto L_0x002f
            goto L_0x009a
        L_0x002f:
            java.nio.ByteBuffer r5 = r6.zzdd
            r7 = 0
            r8 = 1
            if (r5 != 0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            monitor-exit(r4)
            return r2
        L_0x003c:
            long[] r5 = r4.zzaop
            int r9 = r4.zzbfl
            r0 = r5[r9]
            r6.zzaod = r0
            int[] r5 = r4.zzayd
            int r9 = r4.zzbfl
            r5 = r5[r9]
            r6.setFlags(r5)
            int[] r5 = r4.zzaom
            int r9 = r4.zzbfl
            r5 = r5[r9]
            r10.size = r5
            long[] r5 = r4.zzaon
            int r9 = r4.zzbfl
            r0 = r5[r9]
            r10.zzawn = r0
            com.google.android.gms.internal.ads.zzkh[] r5 = r4.zzbfi
            int r9 = r4.zzbfl
            r5 = r5[r9]
            r10.zzarh = r5
            long r0 = r4.zzbfn
            long r5 = r6.zzaod
            long r5 = java.lang.Math.max(r0, r5)
            r4.zzbfn = r5
            int r5 = r4.length
            int r5 = r5 - r8
            r4.length = r5
            int r5 = r4.zzbfl
            int r5 = r5 + r8
            r4.zzbfl = r5
            int r6 = r4.zzbfk
            int r6 = r6 + r8
            r4.zzbfk = r6
            int r6 = r4.zzbfg
            if (r5 != r6) goto L_0x0084
            r4.zzbfl = r7
        L_0x0084:
            int r5 = r4.length
            if (r5 <= 0) goto L_0x008f
            long[] r5 = r4.zzaon
            int r6 = r4.zzbfl
            r6 = r5[r6]
            goto L_0x0096
        L_0x008f:
            long r5 = r10.zzawn
            int r7 = r10.size
            long r7 = (long) r7
            long r6 = r5 + r7
        L_0x0096:
            r10.zzbff = r6
            monitor-exit(r4)
            return r3
        L_0x009a:
            com.google.android.gms.internal.ads.zzhq[] r6 = r4.zzbfj
            int r7 = r4.zzbfl
            r6 = r6[r7]
            r5.zzahr = r6
            monitor-exit(r4)
            return r1
        L_0x00a4:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznh.zza(com.google.android.gms.internal.ads.zzhs, com.google.android.gms.internal.ads.zzjm, boolean, boolean, com.google.android.gms.internal.ads.zzhq, com.google.android.gms.internal.ads.zzng):int");
    }

    public final synchronized long zzif() {
        if (!zzid()) {
            return -1;
        }
        int i = ((this.zzbfl + this.length) - 1) % this.zzbfg;
        this.zzbfl = (this.zzbfl + this.length) % this.zzbfg;
        this.zzbfk += this.length;
        this.length = 0;
        return this.zzaon[i] + ((long) this.zzaom[i]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzd(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzid()     // Catch:{ all -> 0x005e }
            r1 = -1
            if (r0 == 0) goto L_0x005c
            long[] r0 = r8.zzaop     // Catch:{ all -> 0x005e }
            int r3 = r8.zzbfl     // Catch:{ all -> 0x005e }
            r3 = r0[r3]     // Catch:{ all -> 0x005e }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005c
        L_0x0014:
            long r3 = r8.zzbfo     // Catch:{ all -> 0x005e }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            if (r11 != 0) goto L_0x001e
            monitor-exit(r8)
            return r1
        L_0x001e:
            r11 = 0
            int r0 = r8.zzbfl
            r3 = -1
            r4 = -1
        L_0x0023:
            int r5 = r8.zzbfm
            if (r0 == r5) goto L_0x0040
            long[] r5 = r8.zzaop
            r6 = r5[r0]
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0040
            int[] r5 = r8.zzayd
            r5 = r5[r0]
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0038
            r4 = r11
        L_0x0038:
            int r0 = r0 + 1
            int r5 = r8.zzbfg
            int r0 = r0 % r5
            int r11 = r11 + 1
            goto L_0x0023
        L_0x0040:
            if (r4 != r3) goto L_0x0044
            monitor-exit(r8)
            return r1
        L_0x0044:
            int r9 = r8.zzbfl
            int r9 = r9 + r4
            int r10 = r8.zzbfg
            int r9 = r9 % r10
            r8.zzbfl = r9
            int r10 = r8.zzbfk
            int r10 = r10 + r4
            r8.zzbfk = r10
            int r10 = r8.length
            int r10 = r10 - r4
            r8.length = r10
            long[] r10 = r8.zzaon
            r9 = r10[r9]
            monitor-exit(r8)
            return r9
        L_0x005c:
            monitor-exit(r8)
            return r1
        L_0x005e:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznh.zzd(long, boolean):long");
    }

    public final synchronized boolean zzg(zzhq zzhq) {
        if (zzhq == null) {
            this.zzbfq = true;
            return false;
        }
        this.zzbfq = false;
        if (zzpo.zza(zzhq, this.zzbfr)) {
            return false;
        }
        this.zzbfr = zzhq;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(long r6, int r8, long r9, int r11, com.google.android.gms.internal.ads.zzkh r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzbfp     // Catch:{ all -> 0x00e7 }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.zzbfp = r1
        L_0x000e:
            boolean r0 = r5.zzbfq
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.internal.ads.zzpb.checkState(r0)
            r5.zzei(r6)
            long[] r0 = r5.zzaop
            int r3 = r5.zzbfm
            r0[r3] = r6
            long[] r6 = r5.zzaon
            int r7 = r5.zzbfm
            r6[r7] = r9
            int[] r6 = r5.zzaom
            int r7 = r5.zzbfm
            r6[r7] = r11
            int[] r6 = r5.zzayd
            int r7 = r5.zzbfm
            r6[r7] = r8
            com.google.android.gms.internal.ads.zzkh[] r6 = r5.zzbfi
            int r7 = r5.zzbfm
            r6[r7] = r12
            com.google.android.gms.internal.ads.zzhq[] r6 = r5.zzbfj
            int r7 = r5.zzbfm
            com.google.android.gms.internal.ads.zzhq r8 = r5.zzbfr
            r6[r7] = r8
            int[] r6 = r5.zzbfh
            int r7 = r5.zzbfm
            r6[r7] = r1
            int r6 = r5.length
            int r6 = r6 + r2
            r5.length = r6
            int r7 = r5.zzbfg
            if (r6 != r7) goto L_0x00da
            int r6 = r5.zzbfg
            int r6 = r6 + 1000
            int[] r7 = new int[r6]
            long[] r8 = new long[r6]
            long[] r9 = new long[r6]
            int[] r10 = new int[r6]
            int[] r11 = new int[r6]
            com.google.android.gms.internal.ads.zzkh[] r12 = new com.google.android.gms.internal.ads.zzkh[r6]
            com.google.android.gms.internal.ads.zzhq[] r0 = new com.google.android.gms.internal.ads.zzhq[r6]
            int r2 = r5.zzbfg
            int r3 = r5.zzbfl
            int r2 = r2 - r3
            long[] r3 = r5.zzaon
            int r4 = r5.zzbfl
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)
            long[] r3 = r5.zzaop
            int r4 = r5.zzbfl
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)
            int[] r3 = r5.zzayd
            int r4 = r5.zzbfl
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)
            int[] r3 = r5.zzaom
            int r4 = r5.zzbfl
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)
            com.google.android.gms.internal.ads.zzkh[] r3 = r5.zzbfi
            int r4 = r5.zzbfl
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)
            com.google.android.gms.internal.ads.zzhq[] r3 = r5.zzbfj
            int r4 = r5.zzbfl
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)
            int[] r3 = r5.zzbfh
            int r4 = r5.zzbfl
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)
            int r3 = r5.zzbfl
            long[] r4 = r5.zzaon
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)
            long[] r4 = r5.zzaop
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)
            int[] r4 = r5.zzayd
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)
            int[] r4 = r5.zzaom
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)
            com.google.android.gms.internal.ads.zzkh[] r4 = r5.zzbfi
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)
            com.google.android.gms.internal.ads.zzhq[] r4 = r5.zzbfj
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)
            int[] r4 = r5.zzbfh
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)
            r5.zzaon = r8
            r5.zzaop = r9
            r5.zzayd = r10
            r5.zzaom = r11
            r5.zzbfi = r12
            r5.zzbfj = r0
            r5.zzbfh = r7
            r5.zzbfl = r1
            int r7 = r5.zzbfg
            r5.zzbfm = r7
            int r7 = r5.zzbfg
            r5.length = r7
            r5.zzbfg = r6
            monitor-exit(r5)
            return
        L_0x00da:
            int r6 = r5.zzbfm
            int r6 = r6 + r2
            r5.zzbfm = r6
            int r7 = r5.zzbfg
            if (r6 != r7) goto L_0x00e5
            r5.zzbfm = r1
        L_0x00e5:
            monitor-exit(r5)
            return
        L_0x00e7:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznh.zza(long, int, long, int, com.google.android.gms.internal.ads.zzkh):void");
    }

    public final synchronized void zzei(long j) {
        this.zzbfo = Math.max(this.zzbfo, j);
    }
}
