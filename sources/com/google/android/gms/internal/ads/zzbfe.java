package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbfe extends zzbes implements zzoy<zzok> {
    private String url;
    private ByteBuffer zzamc;
    private final zzbdc zzeij;
    private boolean zzeks;
    private final zzbfb zzeky = new zzbfb();
    private final zzbek zzekz = new zzbek();
    private boolean zzela;
    private final Object zzelb = new Object();
    private boolean zzelc;

    public zzbfe(zzbdb zzbdb, zzbdc zzbdc) {
        super(zzbdb);
        this.zzeij = zzbdc;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.google.android.gms.internal.ads.zzoy
    public final /* bridge */ /* synthetic */ void zzc(zzok zzok, int i) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzoy
    public final /* bridge */ /* synthetic */ void zze(zzok zzok) {
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zzaar() {
        return this.zzelc;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbes
    public final String zzfn(String str) {
        String valueOf = String.valueOf(super.zzfn(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    private final void zzzb() {
        int zzaap = (int) this.zzeky.zzaap();
        int zzq = (int) this.zzekz.zzq(this.zzamc);
        int position = this.zzamc.position();
        int round = Math.round(((float) zzq) * (((float) position) / ((float) zzaap)));
        boolean z = round > 0;
        int zzaam = zzbdy.zzaam();
        int zzaan = zzbdy.zzaan();
        String str = this.url;
        zza(str, zzfn(str), position, zzaap, (long) round, (long) zzq, z, zzaam, zzaan);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c2, code lost:
        if (r21.zzamc.remaining() > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c4, code lost:
        zzzb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cb, code lost:
        if (r21.zzeks != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cd, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d5, code lost:
        if ((r12 - r16) < r4) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d7, code lost:
        zzzb();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e3, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ed, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010a, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010b, code lost:
        r1 = r21.zzamc.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0130, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0136, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0137, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return true;
     */
    @Override // com.google.android.gms.internal.ads.zzbes
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfm(java.lang.String r22) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            r9.url = r10
            java.lang.String r11 = r21.zzfn(r22)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zzor r0 = new com.google.android.gms.internal.ads.zzor     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = r9.zzecc     // Catch:{ Exception -> 0x013c }
            r3 = 0
            com.google.android.gms.internal.ads.zzbdc r1 = r9.zzeij     // Catch:{ Exception -> 0x013c }
            int r5 = r1.zzehk     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzbdc r1 = r9.zzeij     // Catch:{ Exception -> 0x013c }
            int r6 = r1.zzehm     // Catch:{ Exception -> 0x013c }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzbdc r1 = r9.zzeij     // Catch:{ Exception -> 0x013c }
            boolean r1 = r1.zzehq     // Catch:{ Exception -> 0x013c }
            if (r1 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzbdt r1 = new com.google.android.gms.internal.ads.zzbdt     // Catch:{ Exception -> 0x0032 }
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0032 }
            r3 = 0
            r1.<init>(r2, r0, r3, r3)     // Catch:{ Exception -> 0x0032 }
            r0 = r1
            goto L_0x0035
        L_0x0032:
            r0 = move-exception
            goto L_0x013f
        L_0x0035:
            android.net.Uri r1 = android.net.Uri.parse(r22)
            com.google.android.gms.internal.ads.zzop r2 = new com.google.android.gms.internal.ads.zzop
            r2.<init>(r1)
            r0.zza(r2)
            java.lang.ref.WeakReference r1 = r9.zzekk
            java.lang.Object r1 = r1.get()
            com.google.android.gms.internal.ads.zzbdb r1 = (com.google.android.gms.internal.ads.zzbdb) r1
            if (r1 == 0) goto L_0x004e
            r1.zza(r11, r9)
        L_0x004e:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzld()
            long r2 = r1.currentTimeMillis()
            com.google.android.gms.internal.ads.zzaag<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzaav.zzcly
            com.google.android.gms.internal.ads.zzaar r5 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r4 = r5.zzd(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            com.google.android.gms.internal.ads.zzaag<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzaav.zzclx
            com.google.android.gms.internal.ads.zzaar r7 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r6 = r7.zzd(r6)
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            com.google.android.gms.internal.ads.zzbdc r8 = r9.zzeij
            int r8 = r8.zzehj
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)
            r9.zzamc = r8
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]
            r16 = r2
        L_0x0086:
            java.nio.ByteBuffer r14 = r9.zzamc
            int r14 = r14.remaining()
            int r14 = java.lang.Math.min(r14, r8)
            int r14 = r0.read(r15, r13, r14)
            r8 = -1
            if (r14 != r8) goto L_0x00a9
            r8 = 1
            r9.zzelc = r8
            com.google.android.gms.internal.ads.zzbek r0 = r9.zzekz
            java.nio.ByteBuffer r1 = r9.zzamc
            long r0 = r0.zzq(r1)
            int r1 = (int) r0
            long r0 = (long) r1
            r9.zzc(r10, r11, r0)
        L_0x00a7:
            r1 = 1
            goto L_0x00c8
        L_0x00a9:
            java.lang.Object r8 = r9.zzelb
            monitor-enter(r8)
            boolean r13 = r9.zzeks     // Catch:{ all -> 0x0131 }
            if (r13 != 0) goto L_0x00b9
            java.nio.ByteBuffer r13 = r9.zzamc     // Catch:{ all -> 0x0131 }
            r18 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x013a }
            goto L_0x00bb
        L_0x00b9:
            r18 = r12
        L_0x00bb:
            monitor-exit(r8)     // Catch:{ all -> 0x013a }
            java.nio.ByteBuffer r8 = r9.zzamc     // Catch:{ Exception -> 0x0136 }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x0136 }
            if (r8 > 0) goto L_0x00c9
            r21.zzzb()     // Catch:{ Exception -> 0x0136 }
            goto L_0x00a7
        L_0x00c8:
            return r1
        L_0x00c9:
            boolean r8 = r9.zzeks     // Catch:{ Exception -> 0x0136 }
            if (r8 != 0) goto L_0x010b
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0136 }
            long r19 = r12 - r16
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00dc
            r21.zzzb()     // Catch:{ Exception -> 0x0136 }
            r16 = r12
        L_0x00dc:
            long r12 = r12 - r2
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r6
            int r8 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r8 > 0) goto L_0x00eb
            r12 = r18
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x0086
        L_0x00eb:
            java.lang.String r12 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = " sec"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r0)
            throw r1
        L_0x010b:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException
            java.nio.ByteBuffer r1 = r9.zzamc
            int r1 = r1.limit()
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Precache abort at "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = " bytes"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0131:
            r0 = move-exception
            r18 = r12
        L_0x0134:
            monitor-exit(r8)
            throw r0
        L_0x0136:
            r0 = move-exception
            r12 = r18
            goto L_0x013f
        L_0x013a:
            r0 = move-exception
            goto L_0x0134
        L_0x013c:
            r0 = move-exception
            r18 = r12
        L_0x013f:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = java.lang.String.valueOf(r22)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzaxv.zzfd(r1)
            r9.zza(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfe.zzfm(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbes
    public final void abort() {
        this.zzeks = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzelb) {
            if (this.zzamc != null && !this.zzela) {
                this.zzamc.flip();
                this.zzela = true;
            }
            this.zzeks = true;
        }
        return this.zzamc;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.ads.zzop] */
    @Override // com.google.android.gms.internal.ads.zzoy
    public final /* synthetic */ void zza(zzok zzok, zzop zzop) {
        zzok zzok2 = zzok;
        if (zzok2 instanceof zzor) {
            this.zzeky.zza((zzor) zzok2);
        }
    }
}
