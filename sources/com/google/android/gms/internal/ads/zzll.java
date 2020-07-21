package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzll implements zzjx, zzkc {
    private static final zzjy zzapc = new zzlk();
    private static final int zzazr = zzpo.zzbk("qt  ");
    private long zzaih;
    private final zzpi zzapj = new zzpi(zzph.zzbjk);
    private final zzpi zzapk = new zzpi(4);
    private int zzaqy;
    private int zzaqz;
    private zzjz zzarc;
    private final zzpi zzaxj = new zzpi(16);
    private final Stack<zzks> zzaxl = new Stack<>();
    private int zzaxn;
    private int zzaxo;
    private long zzaxp;
    private int zzaxq;
    private zzpi zzaxr;
    private zzln[] zzazs;
    private boolean zzazt;

    @Override // com.google.android.gms.internal.ads.zzkc
    public final boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final boolean zza(zzjw zzjw) throws IOException, InterruptedException {
        return zzlm.zze(zzjw);
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void zza(zzjz zzjz) {
        this.zzarc = zzjz;
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void zzc(long j, long j2) {
        this.zzaxl.clear();
        this.zzaxq = 0;
        this.zzaqz = 0;
        this.zzaqy = 0;
        if (j == 0) {
            zzha();
            return;
        }
        zzln[] zzlnArr = this.zzazs;
        if (zzlnArr != null) {
            for (zzln zzln : zzlnArr) {
                zzlq zzlq = zzln.zzazv;
                int zzec = zzlq.zzec(j2);
                if (zzec == -1) {
                    zzec = zzlq.zzed(j2);
                }
                zzln.zzawy = zzec;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x0196 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ac A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjx
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjw r24, com.google.android.gms.internal.ads.zzkd r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
        L_0x0006:
            int r3 = r0.zzaxn
            r4 = -1
            r5 = 8
            r6 = 1
            if (r3 == 0) goto L_0x0198
            r8 = 262144(0x40000, double:1.295163E-318)
            r10 = 2
            if (r3 == r6) goto L_0x0115
            if (r3 != r10) goto L_0x010f
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r5 = -1
        L_0x001d:
            com.google.android.gms.internal.ads.zzln[] r14 = r0.zzazs
            int r15 = r14.length
            if (r3 >= r15) goto L_0x003b
            r14 = r14[r3]
            int r15 = r14.zzawy
            com.google.android.gms.internal.ads.zzlq r11 = r14.zzazv
            int r11 = r11.zzawu
            if (r15 == r11) goto L_0x0038
            com.google.android.gms.internal.ads.zzlq r11 = r14.zzazv
            long[] r11 = r11.zzaon
            r14 = r11[r15]
            int r11 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0038
            r5 = r3
            r12 = r14
        L_0x0038:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x003b:
            if (r5 != r4) goto L_0x003e
            return r4
        L_0x003e:
            r3 = r14[r5]
            com.google.android.gms.internal.ads.zzke r4 = r3.zzazw
            int r5 = r3.zzawy
            com.google.android.gms.internal.ads.zzlq r11 = r3.zzazv
            long[] r11 = r11.zzaon
            r12 = r11[r5]
            com.google.android.gms.internal.ads.zzlq r11 = r3.zzazv
            int[] r11 = r11.zzaom
            r11 = r11[r5]
            com.google.android.gms.internal.ads.zzlp r14 = r3.zzazk
            int r14 = r14.zzbab
            if (r14 != r6) goto L_0x005b
            r14 = 8
            long r12 = r12 + r14
            int r11 = r11 + -8
        L_0x005b:
            long r14 = r24.getPosition()
            long r14 = r12 - r14
            int r10 = r0.zzaqz
            long r6 = (long) r10
            long r14 = r14 + r6
            r6 = 0
            int r10 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r10 < 0) goto L_0x010b
            int r6 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0071
            goto L_0x010b
        L_0x0071:
            int r2 = (int) r14
            r1.zzah(r2)
            com.google.android.gms.internal.ads.zzlp r2 = r3.zzazk
            int r2 = r2.zzasi
            if (r2 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzpi r2 = r0.zzapk
            byte[] r2 = r2.data
            r6 = 0
            r2[r6] = r6
            r7 = 1
            r2[r7] = r6
            r7 = 2
            r2[r7] = r6
            com.google.android.gms.internal.ads.zzlp r2 = r3.zzazk
            int r2 = r2.zzasi
            com.google.android.gms.internal.ads.zzlp r6 = r3.zzazk
            int r6 = r6.zzasi
            r7 = 4
            int r6 = 4 - r6
        L_0x0093:
            int r7 = r0.zzaqz
            if (r7 >= r11) goto L_0x00e8
            int r7 = r0.zzaqy
            if (r7 != 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzpi r7 = r0.zzapk
            byte[] r7 = r7.data
            r1.readFully(r7, r6, r2)
            com.google.android.gms.internal.ads.zzpi r7 = r0.zzapk
            r8 = 0
            r7.zzbk(r8)
            com.google.android.gms.internal.ads.zzpi r7 = r0.zzapk
            int r7 = r7.zziz()
            r0.zzaqy = r7
            com.google.android.gms.internal.ads.zzpi r7 = r0.zzapj
            r7.zzbk(r8)
            com.google.android.gms.internal.ads.zzpi r7 = r0.zzapj
            r9 = 4
            r4.zza(r7, r9)
            int r7 = r0.zzaqz
            int r7 = r7 + r9
            r0.zzaqz = r7
            int r11 = r11 + r6
            goto L_0x0093
        L_0x00c2:
            r8 = 0
            int r7 = r4.zza(r1, r7, r8)
            int r8 = r0.zzaqz
            int r8 = r8 + r7
            r0.zzaqz = r8
            int r8 = r0.zzaqy
            int r8 = r8 - r7
            r0.zzaqy = r8
            goto L_0x0093
        L_0x00d2:
            int r2 = r0.zzaqz
            if (r2 >= r11) goto L_0x00e8
            int r2 = r11 - r2
            r6 = 0
            int r2 = r4.zza(r1, r2, r6)
            int r6 = r0.zzaqz
            int r6 = r6 + r2
            r0.zzaqz = r6
            int r6 = r0.zzaqy
            int r6 = r6 - r2
            r0.zzaqy = r6
            goto L_0x00d2
        L_0x00e8:
            r20 = r11
            com.google.android.gms.internal.ads.zzlq r1 = r3.zzazv
            long[] r1 = r1.zzbaf
            r17 = r1[r5]
            com.google.android.gms.internal.ads.zzlq r1 = r3.zzazv
            int[] r1 = r1.zzayd
            r19 = r1[r5]
            r21 = 0
            r22 = 0
            r16 = r4
            r16.zza(r17, r19, r20, r21, r22)
            int r1 = r3.zzawy
            r4 = 1
            int r1 = r1 + r4
            r3.zzawy = r1
            r1 = 0
            r0.zzaqz = r1
            r0.zzaqy = r1
            return r1
        L_0x010b:
            r4 = 1
            r2.position = r12
            return r4
        L_0x010f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0115:
            long r3 = r0.zzaxp
            int r6 = r0.zzaxq
            long r6 = (long) r6
            long r3 = r3 - r6
            long r6 = r24.getPosition()
            long r6 = r6 + r3
            com.google.android.gms.internal.ads.zzpi r10 = r0.zzaxr
            if (r10 == 0) goto L_0x0175
            byte[] r8 = r10.data
            int r9 = r0.zzaxq
            int r4 = (int) r3
            r1.readFully(r8, r9, r4)
            int r3 = r0.zzaxo
            int r4 = com.google.android.gms.internal.ads.zzkt.zzasp
            if (r3 != r4) goto L_0x0158
            com.google.android.gms.internal.ads.zzpi r3 = r0.zzaxr
            r3.zzbk(r5)
            int r4 = r3.readInt()
            int r5 = com.google.android.gms.internal.ads.zzll.zzazr
            if (r4 != r5) goto L_0x0141
        L_0x013f:
            r3 = 1
            goto L_0x0155
        L_0x0141:
            r4 = 4
            r3.zzbl(r4)
        L_0x0145:
            int r4 = r3.zziu()
            if (r4 <= 0) goto L_0x0154
            int r4 = r3.readInt()
            int r5 = com.google.android.gms.internal.ads.zzll.zzazr
            if (r4 != r5) goto L_0x0145
            goto L_0x013f
        L_0x0154:
            r3 = 0
        L_0x0155:
            r0.zzazt = r3
            goto L_0x017d
        L_0x0158:
            java.util.Stack<com.google.android.gms.internal.ads.zzks> r3 = r0.zzaxl
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x017d
            java.util.Stack<com.google.android.gms.internal.ads.zzks> r3 = r0.zzaxl
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzks r3 = (com.google.android.gms.internal.ads.zzks) r3
            com.google.android.gms.internal.ads.zzkv r4 = new com.google.android.gms.internal.ads.zzkv
            int r5 = r0.zzaxo
            com.google.android.gms.internal.ads.zzpi r8 = r0.zzaxr
            r4.<init>(r5, r8)
            r3.zza(r4)
            goto L_0x017d
        L_0x0175:
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x017f
            int r4 = (int) r3
            r1.zzah(r4)
        L_0x017d:
            r3 = 0
            goto L_0x0187
        L_0x017f:
            long r8 = r24.getPosition()
            long r8 = r8 + r3
            r2.position = r8
            r3 = 1
        L_0x0187:
            r0.zzeb(r6)
            if (r3 == 0) goto L_0x0193
            int r3 = r0.zzaxn
            r4 = 2
            if (r3 == r4) goto L_0x0193
            r7 = 1
            goto L_0x0194
        L_0x0193:
            r7 = 0
        L_0x0194:
            if (r7 == 0) goto L_0x0006
            r3 = 1
            return r3
        L_0x0198:
            r3 = 1
            int r6 = r0.zzaxq
            if (r6 != 0) goto L_0x01c2
            com.google.android.gms.internal.ads.zzpi r6 = r0.zzaxj
            byte[] r6 = r6.data
            r7 = 0
            boolean r6 = r1.zza(r6, r7, r5, r3)
            if (r6 != 0) goto L_0x01ab
            r6 = 0
            goto L_0x02aa
        L_0x01ab:
            r0.zzaxq = r5
            com.google.android.gms.internal.ads.zzpi r3 = r0.zzaxj
            r3.zzbk(r7)
            com.google.android.gms.internal.ads.zzpi r3 = r0.zzaxj
            long r6 = r3.zziw()
            r0.zzaxp = r6
            com.google.android.gms.internal.ads.zzpi r3 = r0.zzaxj
            int r3 = r3.readInt()
            r0.zzaxo = r3
        L_0x01c2:
            long r6 = r0.zzaxp
            r8 = 1
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x01de
            com.google.android.gms.internal.ads.zzpi r3 = r0.zzaxj
            byte[] r3 = r3.data
            r1.readFully(r3, r5, r5)
            int r3 = r0.zzaxq
            int r3 = r3 + r5
            r0.zzaxq = r3
            com.google.android.gms.internal.ads.zzpi r3 = r0.zzaxj
            long r6 = r3.zzja()
            r0.zzaxp = r6
        L_0x01de:
            int r3 = r0.zzaxo
            int r6 = com.google.android.gms.internal.ads.zzkt.zzatq
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkt.zzats
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkt.zzatt
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkt.zzatu
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkt.zzatv
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkt.zzaue
            if (r3 != r6) goto L_0x01f9
            goto L_0x01fb
        L_0x01f9:
            r6 = 0
            goto L_0x01fc
        L_0x01fb:
            r6 = 1
        L_0x01fc:
            if (r6 == 0) goto L_0x0228
            long r5 = r24.getPosition()
            long r7 = r0.zzaxp
            long r5 = r5 + r7
            int r3 = r0.zzaxq
            long r7 = (long) r3
            long r5 = r5 - r7
            java.util.Stack<com.google.android.gms.internal.ads.zzks> r3 = r0.zzaxl
            com.google.android.gms.internal.ads.zzks r7 = new com.google.android.gms.internal.ads.zzks
            int r8 = r0.zzaxo
            r7.<init>(r8, r5)
            r3.add(r7)
            long r7 = r0.zzaxp
            int r3 = r0.zzaxq
            long r9 = (long) r3
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0222
            r0.zzeb(r5)
            goto L_0x0225
        L_0x0222:
            r23.zzha()
        L_0x0225:
            r3 = 1
            goto L_0x02a9
        L_0x0228:
            int r3 = r0.zzaxo
            int r6 = com.google.android.gms.internal.ads.zzkt.zzaug
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzatr
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzauh
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzaui
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzavb
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzavc
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzavd
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzauf
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzave
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzavf
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzavg
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzavh
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzavi
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzaud
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzasp
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkt.zzavp
            if (r3 != r6) goto L_0x026b
            goto L_0x026d
        L_0x026b:
            r6 = 0
            goto L_0x026e
        L_0x026d:
            r6 = 1
        L_0x026e:
            if (r6 == 0) goto L_0x02a3
            int r3 = r0.zzaxq
            if (r3 != r5) goto L_0x0276
            r6 = 1
            goto L_0x0277
        L_0x0276:
            r6 = 0
        L_0x0277:
            com.google.android.gms.internal.ads.zzpb.checkState(r6)
            long r6 = r0.zzaxp
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x0285
            r6 = 1
            goto L_0x0286
        L_0x0285:
            r6 = 0
        L_0x0286:
            com.google.android.gms.internal.ads.zzpb.checkState(r6)
            com.google.android.gms.internal.ads.zzpi r3 = new com.google.android.gms.internal.ads.zzpi
            long r6 = r0.zzaxp
            int r7 = (int) r6
            r3.<init>(r7)
            r0.zzaxr = r3
            com.google.android.gms.internal.ads.zzpi r3 = r0.zzaxj
            byte[] r3 = r3.data
            com.google.android.gms.internal.ads.zzpi r6 = r0.zzaxr
            byte[] r6 = r6.data
            r7 = 0
            java.lang.System.arraycopy(r3, r7, r6, r7, r5)
            r3 = 1
            r0.zzaxn = r3
            goto L_0x02a9
        L_0x02a3:
            r3 = 1
            r5 = 0
            r0.zzaxr = r5
            r0.zzaxn = r3
        L_0x02a9:
            r6 = 1
        L_0x02aa:
            if (r6 != 0) goto L_0x0006
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzll.zza(com.google.android.gms.internal.ads.zzjw, com.google.android.gms.internal.ads.zzkd):int");
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final long getDurationUs() {
        return this.zzaih;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final long zzdz(long j) {
        zzln[] zzlnArr = this.zzazs;
        long j2 = LongCompanionObject.MAX_VALUE;
        for (zzln zzln : zzlnArr) {
            zzlq zzlq = zzln.zzazv;
            int zzec = zzlq.zzec(j);
            if (zzec == -1) {
                zzec = zzlq.zzed(j);
            }
            long j3 = zzlq.zzaon[zzec];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void zzha() {
        this.zzaxn = 0;
        this.zzaxq = 0;
    }

    private final void zzeb(long j) throws zzht {
        zzme zzme;
        zzkb zzkb;
        zzlp zza;
        while (!this.zzaxl.isEmpty() && this.zzaxl.peek().zzasm == j) {
            zzks pop = this.zzaxl.pop();
            if (pop.type == zzkt.zzatq) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                long j3 = LongCompanionObject.MAX_VALUE;
                zzme zzme2 = null;
                zzkb zzkb2 = new zzkb();
                zzkv zzaq = pop.zzaq(zzkt.zzavp);
                if (!(zzaq == null || (zzme2 = zzku.zza(zzaq, this.zzazt)) == null)) {
                    zzkb2.zzb(zzme2);
                }
                int i = 0;
                while (i < pop.zzaso.size()) {
                    zzks zzks = pop.zzaso.get(i);
                    if (zzks.type == zzkt.zzats && (zza = zzku.zza(zzks, pop.zzaq(zzkt.zzatr), -9223372036854775807L, (zzjl) null, this.zzazt)) != null) {
                        zzlq zza2 = zzku.zza(zza, zzks.zzar(zzkt.zzatt).zzar(zzkt.zzatu).zzar(zzkt.zzatv), zzkb2);
                        if (zza2.zzawu != 0) {
                            zzln zzln = new zzln(zza, zza2, this.zzarc.zzc(i, zza.type));
                            zzhq zzu = zza.zzahr.zzu(zza2.zzayb + 30);
                            if (zza.type == 1) {
                                if (zzkb2.zzgs()) {
                                    zzu = zzu.zzb(zzkb2.zzahj, zzkb2.zzahk);
                                }
                                if (zzme2 != null) {
                                    zzu = zzu.zza(zzme2);
                                }
                            }
                            zzln.zzazw.zze(zzu);
                            zzme = zzme2;
                            zzkb = zzkb2;
                            j2 = Math.max(j2, zza.zzaih);
                            arrayList.add(zzln);
                            long j4 = zza2.zzaon[0];
                            if (j4 < j3) {
                                j3 = j4;
                            }
                            i++;
                            zzkb2 = zzkb;
                            zzme2 = zzme;
                        }
                    }
                    zzme = zzme2;
                    zzkb = zzkb2;
                    i++;
                    zzkb2 = zzkb;
                    zzme2 = zzme;
                }
                this.zzaih = j2;
                this.zzazs = (zzln[]) arrayList.toArray(new zzln[arrayList.size()]);
                this.zzarc.zzgr();
                this.zzarc.zza(this);
                this.zzaxl.clear();
                this.zzaxn = 2;
            } else if (!this.zzaxl.isEmpty()) {
                this.zzaxl.peek().zza(pop);
            }
        }
        if (this.zzaxn != 2) {
            zzha();
        }
    }
}
