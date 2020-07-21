package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzme;
import java.util.ArrayList;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.i18n.TextBundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzku {
    private static final int zzavq = zzpo.zzbk("meta");
    private static final int zzawe = zzpo.zzbk("vide");
    private static final int zzawf = zzpo.zzbk("soun");
    private static final int zzawg = zzpo.zzbk(TextBundle.TEXT_ENTRY);
    private static final int zzawh = zzpo.zzbk("sbtl");
    private static final int zzawi = zzpo.zzbk("subt");
    private static final int zzawj = zzpo.zzbk("clcp");
    private static final int zzawk = zzpo.zzbk("cenc");

    /* JADX WARNING: Removed duplicated region for block: B:193:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0820 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0821  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzlp zza(com.google.android.gms.internal.ads.zzks r49, com.google.android.gms.internal.ads.zzkv r50, long r51, com.google.android.gms.internal.ads.zzjl r53, boolean r54) throws com.google.android.gms.internal.ads.zzht {
        /*
            r0 = r49
            r15 = r53
            int r1 = com.google.android.gms.internal.ads.zzkt.zzatt
            com.google.android.gms.internal.ads.zzks r1 = r0.zzar(r1)
            int r2 = com.google.android.gms.internal.ads.zzkt.zzauh
            com.google.android.gms.internal.ads.zzkv r2 = r1.zzaq(r2)
            com.google.android.gms.internal.ads.zzpi r2 = r2.zzawl
            r14 = 16
            r2.zzbk(r14)
            int r2 = r2.readInt()
            int r3 = com.google.android.gms.internal.ads.zzku.zzawf
            r4 = 4
            r11 = -1
            if (r2 != r3) goto L_0x0023
            r10 = 1
            goto L_0x0043
        L_0x0023:
            int r3 = com.google.android.gms.internal.ads.zzku.zzawe
            if (r2 != r3) goto L_0x0029
            r10 = 2
            goto L_0x0043
        L_0x0029:
            int r3 = com.google.android.gms.internal.ads.zzku.zzawg
            if (r2 == r3) goto L_0x0042
            int r3 = com.google.android.gms.internal.ads.zzku.zzawh
            if (r2 == r3) goto L_0x0042
            int r3 = com.google.android.gms.internal.ads.zzku.zzawi
            if (r2 == r3) goto L_0x0042
            int r3 = com.google.android.gms.internal.ads.zzku.zzawj
            if (r2 != r3) goto L_0x003a
            goto L_0x0042
        L_0x003a:
            int r3 = com.google.android.gms.internal.ads.zzku.zzavq
            if (r2 != r3) goto L_0x0040
            r10 = 4
            goto L_0x0043
        L_0x0040:
            r10 = -1
            goto L_0x0043
        L_0x0042:
            r10 = 3
        L_0x0043:
            r8 = 0
            if (r10 != r11) goto L_0x0047
            return r8
        L_0x0047:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzaud
            com.google.android.gms.internal.ads.zzkv r2 = r0.zzaq(r2)
            com.google.android.gms.internal.ads.zzpi r2 = r2.zzawl
            r7 = 8
            r2.zzbk(r7)
            int r3 = r2.readInt()
            int r3 = com.google.android.gms.internal.ads.zzkt.zzas(r3)
            if (r3 != 0) goto L_0x0061
            r5 = 8
            goto L_0x0063
        L_0x0061:
            r5 = 16
        L_0x0063:
            r2.zzbl(r5)
            int r5 = r2.readInt()
            r2.zzbl(r4)
            int r6 = r2.getPosition()
            if (r3 != 0) goto L_0x0075
            r12 = 4
            goto L_0x0077
        L_0x0075:
            r12 = 8
        L_0x0077:
            r9 = 0
        L_0x0078:
            if (r9 >= r12) goto L_0x0088
            byte[] r8 = r2.data
            int r20 = r6 + r9
            byte r8 = r8[r20]
            if (r8 == r11) goto L_0x0084
            r6 = 0
            goto L_0x0089
        L_0x0084:
            int r9 = r9 + 1
            r8 = 0
            goto L_0x0078
        L_0x0088:
            r6 = 1
        L_0x0089:
            r20 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 == 0) goto L_0x0097
            r2.zzbl(r12)
        L_0x0095:
            r11 = r8
            goto L_0x00a9
        L_0x0097:
            if (r3 != 0) goto L_0x009e
            long r22 = r2.zziw()
            goto L_0x00a2
        L_0x009e:
            long r22 = r2.zzja()
        L_0x00a2:
            int r3 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
            if (r3 != 0) goto L_0x00a7
            goto L_0x0095
        L_0x00a7:
            r11 = r22
        L_0x00a9:
            r2.zzbl(r14)
            int r3 = r2.readInt()
            int r6 = r2.readInt()
            r2.zzbl(r4)
            int r4 = r2.readInt()
            int r2 = r2.readInt()
            r14 = 65536(0x10000, float:9.18355E-41)
            r13 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x00ce
            if (r6 != r14) goto L_0x00ce
            if (r4 != r13) goto L_0x00ce
            if (r2 != 0) goto L_0x00ce
            r2 = 90
            goto L_0x00e5
        L_0x00ce:
            if (r3 != 0) goto L_0x00d9
            if (r6 != r13) goto L_0x00d9
            if (r4 != r14) goto L_0x00d9
            if (r2 != 0) goto L_0x00d9
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x00e5
        L_0x00d9:
            if (r3 != r13) goto L_0x00e4
            if (r6 != 0) goto L_0x00e4
            if (r4 != 0) goto L_0x00e4
            if (r2 != r13) goto L_0x00e4
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x00e5
        L_0x00e4:
            r2 = 0
        L_0x00e5:
            com.google.android.gms.internal.ads.zzla r14 = new com.google.android.gms.internal.ads.zzla
            r14.<init>(r5, r11, r2)
            int r2 = (r51 > r8 ? 1 : (r51 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x00f7
            long r2 = r14.zzdh
            r26 = r2
            r2 = r50
            goto L_0x00fb
        L_0x00f7:
            r2 = r50
            r26 = r51
        L_0x00fb:
            com.google.android.gms.internal.ads.zzpi r2 = r2.zzawl
            r2.zzbk(r7)
            int r3 = r2.readInt()
            int r3 = com.google.android.gms.internal.ads.zzkt.zzas(r3)
            if (r3 != 0) goto L_0x010d
            r3 = 8
            goto L_0x010f
        L_0x010d:
            r3 = 16
        L_0x010f:
            r2.zzbl(r3)
            long r32 = r2.zziw()
            int r2 = (r26 > r8 ? 1 : (r26 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x011d
            r26 = r8
            goto L_0x0128
        L_0x011d:
            r28 = 1000000(0xf4240, double:4.940656E-318)
            r30 = r32
            long r2 = com.google.android.gms.internal.ads.zzpo.zza(r26, r28, r30)
            r26 = r2
        L_0x0128:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzatu
            com.google.android.gms.internal.ads.zzks r2 = r1.zzar(r2)
            int r3 = com.google.android.gms.internal.ads.zzkt.zzatv
            com.google.android.gms.internal.ads.zzks r2 = r2.zzar(r3)
            int r3 = com.google.android.gms.internal.ads.zzkt.zzaug
            com.google.android.gms.internal.ads.zzkv r1 = r1.zzaq(r3)
            com.google.android.gms.internal.ads.zzpi r1 = r1.zzawl
            r1.zzbk(r7)
            int r3 = r1.readInt()
            int r3 = com.google.android.gms.internal.ads.zzkt.zzas(r3)
            if (r3 != 0) goto L_0x014c
            r4 = 8
            goto L_0x014e
        L_0x014c:
            r4 = 16
        L_0x014e:
            r1.zzbl(r4)
            long r4 = r1.zziw()
            if (r3 != 0) goto L_0x0159
            r3 = 4
            goto L_0x015b
        L_0x0159:
            r3 = 8
        L_0x015b:
            r1.zzbl(r3)
            int r1 = r1.readUnsignedShort()
            int r3 = r1 >> 10
            r3 = r3 & 31
            int r3 = r3 + 96
            char r3 = (char) r3
            int r6 = r1 >> 5
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r9 = 3
            r8.<init>(r9)
            r8.append(r3)
            r8.append(r6)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            java.lang.Long r3 = java.lang.Long.valueOf(r4)
            android.util.Pair r13 = android.util.Pair.create(r3, r1)
            int r1 = com.google.android.gms.internal.ads.zzkt.zzaui
            com.google.android.gms.internal.ads.zzkv r1 = r2.zzaq(r1)
            com.google.android.gms.internal.ads.zzpi r12 = r1.zzawl
            int r22 = r14.f26id
            int r28 = r14.zzahb
            java.lang.Object r1 = r13.second
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11
            r1 = 12
            r12.zzbk(r1)
            int r9 = r12.readInt()
            com.google.android.gms.internal.ads.zzkz r8 = new com.google.android.gms.internal.ads.zzkz
            r8.<init>(r9)
            r6 = 0
        L_0x01b4:
            if (r6 >= r9) goto L_0x07a9
            int r5 = r12.getPosition()
            int r4 = r12.readInt()
            if (r4 <= 0) goto L_0x01c2
            r1 = 1
            goto L_0x01c3
        L_0x01c2:
            r1 = 0
        L_0x01c3:
            java.lang.String r3 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzpb.checkArgument(r1, r3)
            int r1 = r12.readInt()
            int r2 = com.google.android.gms.internal.ads.zzkt.zzasq
            if (r1 == r2) goto L_0x05a2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzasr
            if (r1 == r2) goto L_0x05a2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzauo
            if (r1 == r2) goto L_0x05a2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzava
            if (r1 == r2) goto L_0x05a2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzass
            if (r1 == r2) goto L_0x05a2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzast
            if (r1 == r2) goto L_0x05a2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzasu
            if (r1 == r2) goto L_0x05a2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavz
            if (r1 == r2) goto L_0x05a2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzawa
            if (r1 != r2) goto L_0x01f2
            goto L_0x05a2
        L_0x01f2:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzasx
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzaup
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzatc
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzate
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzatg
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzatj
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzath
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzati
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavn
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavo
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzata
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzatb
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzasy
            if (r1 == r2) goto L_0x030c
            int r2 = com.google.android.gms.internal.ads.zzkt.zzawd
            if (r1 != r2) goto L_0x022c
            goto L_0x030c
        L_0x022c:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzauy
            if (r1 == r2) goto L_0x026a
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavj
            if (r1 == r2) goto L_0x026a
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavk
            if (r1 == r2) goto L_0x026a
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavl
            if (r1 == r2) goto L_0x026a
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavm
            if (r1 != r2) goto L_0x0241
            goto L_0x026a
        L_0x0241:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzawc
            if (r1 != r2) goto L_0x0254
            java.lang.String r1 = java.lang.Integer.toString(r22)
            java.lang.String r2 = "application/x-camera-motion"
            r3 = -1
            r7 = 0
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r1, r2, r7, r3, r15)
            r8.zzahr = r1
            goto L_0x0255
        L_0x0254:
            r7 = 0
        L_0x0255:
            r23 = r4
            r24 = r5
            r37 = r6
            r0 = r8
            r31 = r9
            r19 = r10
            r36 = r11
            r16 = r12
            r48 = r13
            r18 = r14
            goto L_0x0365
        L_0x026a:
            r3 = -1
            r7 = 0
            int r2 = r5 + 8
            r19 = 8
            int r2 = r2 + 8
            r12.zzbk(r2)
            r29 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = com.google.android.gms.internal.ads.zzkt.zzauy
            java.lang.String r24 = "application/ttml+xml"
            if (r1 != r2) goto L_0x0285
            r17 = r7
            r2 = 1
            r7 = 0
            goto L_0x02bf
        L_0x0285:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavj
            if (r1 != r2) goto L_0x029f
            int r1 = r4 + -8
            int r1 = r1 + -8
            byte[] r2 = new byte[r1]
            r7 = 0
            r12.zze(r2, r7, r1)
            java.util.List r1 = java.util.Collections.singletonList(r2)
            java.lang.String r2 = "application/x-quicktime-tx3g"
            r17 = r1
            r24 = r2
            r2 = 1
            goto L_0x02bf
        L_0x029f:
            r7 = 0
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavk
            if (r1 != r2) goto L_0x02ac
            java.lang.String r1 = "application/x-mp4-vtt"
            r24 = r1
        L_0x02a8:
            r2 = 1
        L_0x02a9:
            r17 = 0
            goto L_0x02bf
        L_0x02ac:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavl
            if (r1 != r2) goto L_0x02b3
            r29 = r20
            goto L_0x02a8
        L_0x02b3:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzavm
            if (r1 != r2) goto L_0x0306
            r2 = 1
            r8.zzaww = r2
            java.lang.String r1 = "application/x-mp4-cea-608"
            r24 = r1
            goto L_0x02a9
        L_0x02bf:
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r18 = 0
            r34 = -1
            r35 = 0
            r36 = -1
            r37 = 1
            r2 = r24
            r24 = -1
            r3 = r18
            r18 = r14
            r14 = r4
            r4 = r34
            r38 = r5
            r5 = r35
            r39 = r6
            r6 = r11
            r19 = 0
            r31 = 0
            r7 = r36
            r40 = r8
            r8 = r53
            r31 = r9
            r19 = r10
            r9 = r29
            r0 = r11
            r11 = r17
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11)
            r11 = r40
            r11.zzahr = r1
            r36 = r0
            r0 = r11
            r16 = r12
            r48 = r13
            r23 = r14
            r24 = r38
            goto L_0x0363
        L_0x0306:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x030c:
            r38 = r5
            r39 = r6
            r31 = r9
            r19 = r10
            r0 = r11
            r18 = r14
            r14 = r4
            r11 = r8
            r10 = r38
            int r5 = r10 + 8
            r9 = 8
            int r5 = r5 + r9
            r12.zzbk(r5)
            r2 = 6
            if (r54 == 0) goto L_0x032e
            int r4 = r12.readUnsignedShort()
            r12.zzbl(r2)
            goto L_0x0332
        L_0x032e:
            r12.zzbl(r9)
            r4 = 0
        L_0x0332:
            if (r4 == 0) goto L_0x036f
            r8 = 1
            if (r4 != r8) goto L_0x0339
            r7 = 2
            goto L_0x0371
        L_0x0339:
            r7 = 2
            if (r4 != r7) goto L_0x0358
            r2 = 16
            r12.zzbl(r2)
            long r4 = r12.readLong()
            double r4 = java.lang.Double.longBitsToDouble(r4)
            long r4 = java.lang.Math.round(r4)
            int r2 = (int) r4
            int r4 = r12.zziz()
            r5 = 20
            r12.zzbl(r5)
            goto L_0x0384
        L_0x0358:
            r36 = r0
            r24 = r10
            r0 = r11
            r16 = r12
            r48 = r13
            r23 = r14
        L_0x0363:
            r37 = r39
        L_0x0365:
            r17 = -1
            r25 = 3
            r29 = 0
        L_0x036b:
            r30 = 16
            goto L_0x078c
        L_0x036f:
            r7 = 2
            r8 = 1
        L_0x0371:
            int r5 = r12.readUnsignedShort()
            r12.zzbl(r2)
            int r2 = r12.zziy()
            if (r4 != r8) goto L_0x0383
            r4 = 16
            r12.zzbl(r4)
        L_0x0383:
            r4 = r5
        L_0x0384:
            int r5 = r12.getPosition()
            int r6 = com.google.android.gms.internal.ads.zzkt.zzaup
            if (r1 != r6) goto L_0x0396
            r6 = r39
            int r1 = zza(r12, r10, r14, r11, r6)
            r12.zzbk(r5)
            goto L_0x0398
        L_0x0396:
            r6 = r39
        L_0x0398:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzatc
            java.lang.String r8 = "audio/raw"
            if (r1 != r7) goto L_0x03a1
            java.lang.String r1 = "audio/ac3"
            goto L_0x03ea
        L_0x03a1:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzate
            if (r1 != r7) goto L_0x03a8
            java.lang.String r1 = "audio/eac3"
            goto L_0x03ea
        L_0x03a8:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzatg
            if (r1 != r7) goto L_0x03af
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x03ea
        L_0x03af:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzath
            if (r1 == r7) goto L_0x03e8
            int r7 = com.google.android.gms.internal.ads.zzkt.zzati
            if (r1 != r7) goto L_0x03b8
            goto L_0x03e8
        L_0x03b8:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzatj
            if (r1 != r7) goto L_0x03bf
            java.lang.String r1 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x03ea
        L_0x03bf:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzavn
            if (r1 != r7) goto L_0x03c6
            java.lang.String r1 = "audio/3gpp"
            goto L_0x03ea
        L_0x03c6:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzavo
            if (r1 != r7) goto L_0x03cd
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x03ea
        L_0x03cd:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzata
            if (r1 == r7) goto L_0x03e6
            int r7 = com.google.android.gms.internal.ads.zzkt.zzatb
            if (r1 != r7) goto L_0x03d6
            goto L_0x03e6
        L_0x03d6:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzasy
            if (r1 != r7) goto L_0x03dd
            java.lang.String r1 = "audio/mpeg"
            goto L_0x03ea
        L_0x03dd:
            int r7 = com.google.android.gms.internal.ads.zzkt.zzawd
            if (r1 != r7) goto L_0x03e4
            java.lang.String r1 = "audio/alac"
            goto L_0x03ea
        L_0x03e4:
            r1 = 0
            goto L_0x03ea
        L_0x03e6:
            r1 = r8
            goto L_0x03ea
        L_0x03e8:
            java.lang.String r1 = "audio/vnd.dts.hd"
        L_0x03ea:
            r7 = r1
            r29 = r2
            r17 = r4
            r30 = 0
        L_0x03f1:
            int r1 = r5 - r10
            if (r1 >= r14) goto L_0x0540
            r12.zzbk(r5)
            int r4 = r12.readInt()
            if (r4 <= 0) goto L_0x0400
            r1 = 1
            goto L_0x0401
        L_0x0400:
            r1 = 0
        L_0x0401:
            com.google.android.gms.internal.ads.zzpb.checkArgument(r1, r3)
            int r1 = r12.readInt()
            int r2 = com.google.android.gms.internal.ads.zzkt.zzaty
            if (r1 == r2) goto L_0x04b9
            if (r54 == 0) goto L_0x0414
            int r2 = com.google.android.gms.internal.ads.zzkt.zzasz
            if (r1 != r2) goto L_0x0414
            goto L_0x04b9
        L_0x0414:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzatd
            if (r1 != r2) goto L_0x0438
            int r1 = r5 + 8
            r12.zzbk(r1)
            java.lang.String r1 = java.lang.Integer.toString(r22)
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzie.zza(r12, r1, r0, r15)
            r11.zzahr = r1
        L_0x0427:
            r41 = r3
            r2 = r4
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r10
            r15 = r11
            r11 = 0
            r16 = 2
            goto L_0x04b2
        L_0x0438:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzatf
            if (r1 != r2) goto L_0x044c
            int r1 = r5 + 8
            r12.zzbk(r1)
            java.lang.String r1 = java.lang.Integer.toString(r22)
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzie.zzb(r12, r1, r0, r15)
            r11.zzahr = r1
            goto L_0x0427
        L_0x044c:
            int r2 = com.google.android.gms.internal.ads.zzkt.zzatk
            if (r1 != r2) goto L_0x0488
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r34 = 0
            r35 = -1
            r36 = -1
            r37 = 0
            r38 = 0
            r2 = r7
            r41 = r3
            r3 = r34
            r42 = r4
            r4 = r35
            r43 = r5
            r5 = r36
            r44 = r6
            r6 = r17
            r45 = r7
            r16 = 2
            r7 = r29
            r46 = r8
            r8 = r37
            r9 = r53
            r47 = r10
            r10 = r38
            r15 = r11
            r11 = r0
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r15.zzahr = r1
            goto L_0x04ad
        L_0x0488:
            r41 = r3
            r42 = r4
            r43 = r5
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r10
            r15 = r11
            r16 = 2
            int r2 = com.google.android.gms.internal.ads.zzkt.zzawd
            if (r1 != r2) goto L_0x04ad
            r2 = r42
            byte[] r1 = new byte[r2]
            r5 = r43
            r12.zzbk(r5)
            r11 = 0
            r12.zze(r1, r11, r2)
            r30 = r1
            goto L_0x04b2
        L_0x04ad:
            r2 = r42
            r5 = r43
            r11 = 0
        L_0x04b2:
            r4 = r41
            r7 = r45
            r10 = -1
            goto L_0x0531
        L_0x04b9:
            r41 = r3
            r2 = r4
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r10
            r15 = r11
            r11 = 0
            r16 = 2
            int r3 = com.google.android.gms.internal.ads.zzkt.zzaty
            if (r1 != r3) goto L_0x04d1
            r1 = r5
            r4 = r41
        L_0x04cf:
            r10 = -1
            goto L_0x04fb
        L_0x04d1:
            int r1 = r12.getPosition()
        L_0x04d5:
            int r3 = r1 - r5
            if (r3 >= r2) goto L_0x04f7
            r12.zzbk(r1)
            int r3 = r12.readInt()
            r4 = r41
            if (r3 <= 0) goto L_0x04e6
            r9 = 1
            goto L_0x04e7
        L_0x04e6:
            r9 = 0
        L_0x04e7:
            com.google.android.gms.internal.ads.zzpb.checkArgument(r9, r4)
            int r6 = r12.readInt()
            int r7 = com.google.android.gms.internal.ads.zzkt.zzaty
            if (r6 != r7) goto L_0x04f3
            goto L_0x04cf
        L_0x04f3:
            int r1 = r1 + r3
            r41 = r4
            goto L_0x04d5
        L_0x04f7:
            r4 = r41
            r1 = -1
            goto L_0x04cf
        L_0x04fb:
            if (r1 == r10) goto L_0x052f
            android.util.Pair r1 = zzb(r12, r1)
            java.lang.Object r3 = r1.first
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.second
            r30 = r1
            byte[] r30 = (byte[]) r30
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x052d
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzpa.zze(r30)
            java.lang.Object r6 = r1.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r17 = r1
            r7 = r3
            r29 = r6
            goto L_0x0531
        L_0x052d:
            r7 = r3
            goto L_0x0531
        L_0x052f:
            r7 = r45
        L_0x0531:
            int r5 = r5 + r2
            r3 = r4
            r11 = r15
            r6 = r44
            r8 = r46
            r10 = r47
            r9 = 8
            r15 = r53
            goto L_0x03f1
        L_0x0540:
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r10
            r15 = r11
            r10 = -1
            r11 = 0
            r16 = 2
            com.google.android.gms.internal.ads.zzhq r1 = r15.zzahr
            if (r1 != 0) goto L_0x058a
            r7 = r45
            if (r7 == 0) goto L_0x058a
            r1 = r46
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x055f
            r8 = 2
            goto L_0x0560
        L_0x055f:
            r8 = -1
        L_0x0560:
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r3 = 0
            r4 = -1
            r5 = -1
            if (r30 != 0) goto L_0x056b
            r9 = 0
            goto L_0x0570
        L_0x056b:
            java.util.List r2 = java.util.Collections.singletonList(r30)
            r9 = r2
        L_0x0570:
            r24 = 0
            r2 = r7
            r6 = r17
            r7 = r29
            r17 = -1
            r10 = r53
            r29 = 0
            r11 = r24
            r50 = r13
            r13 = r12
            r12 = r0
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r15.zzahr = r1
            goto L_0x0591
        L_0x058a:
            r50 = r13
            r17 = -1
            r29 = 0
            r13 = r12
        L_0x0591:
            r48 = r50
            r36 = r0
            r16 = r13
            r23 = r14
            r0 = r15
            r37 = r44
            r24 = r47
        L_0x059e:
            r25 = 3
            goto L_0x036b
        L_0x05a2:
            r47 = r5
            r44 = r6
            r15 = r8
            r31 = r9
            r19 = r10
            r0 = r11
            r50 = r13
            r18 = r14
            r17 = -1
            r29 = 0
            r14 = r4
            r13 = r12
            r4 = r3
            r12 = r47
            int r5 = r12 + 8
            r11 = 8
            int r5 = r5 + r11
            r13.zzbk(r5)
            r10 = 16
            r13.zzbl(r10)
            int r6 = r13.readUnsignedShort()
            int r7 = r13.readUnsignedShort()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 50
            r13.zzbl(r3)
            int r3 = r13.getPosition()
            int r5 = com.google.android.gms.internal.ads.zzkt.zzauo
            r9 = r44
            if (r1 != r5) goto L_0x05e6
            int r1 = zza(r13, r12, r14, r15, r9)
            r13.zzbk(r3)
        L_0x05e6:
            r2 = 0
            r5 = 0
            r23 = 0
            r24 = 1065353216(0x3f800000, float:1.0)
            r30 = 0
            r34 = -1
        L_0x05f0:
            int r8 = r3 - r12
            if (r8 >= r14) goto L_0x073d
            r13.zzbk(r3)
            int r8 = r13.getPosition()
            int r10 = r13.readInt()
            if (r10 != 0) goto L_0x0609
            int r36 = r13.getPosition()
            int r11 = r36 - r12
            if (r11 == r14) goto L_0x073d
        L_0x0609:
            if (r10 <= 0) goto L_0x060d
            r11 = 1
            goto L_0x060e
        L_0x060d:
            r11 = 0
        L_0x060e:
            com.google.android.gms.internal.ads.zzpb.checkArgument(r11, r4)
            int r11 = r13.readInt()
            r36 = r0
            int r0 = com.google.android.gms.internal.ads.zzkt.zzatw
            if (r11 != r0) goto L_0x063b
            if (r2 != 0) goto L_0x061f
            r0 = 1
            goto L_0x0620
        L_0x061f:
            r0 = 0
        L_0x0620:
            com.google.android.gms.internal.ads.zzpb.checkState(r0)
            int r8 = r8 + 8
            r13.zzbk(r8)
            com.google.android.gms.internal.ads.zzpq r0 = com.google.android.gms.internal.ads.zzpq.zzg(r13)
            java.util.List<byte[]> r2 = r0.zzagy
            int r8 = r0.zzasi
            r15.zzasi = r8
            if (r5 != 0) goto L_0x0638
            float r0 = r0.zzbjp
            r24 = r0
        L_0x0638:
            java.lang.String r0 = "video/avc"
            goto L_0x0658
        L_0x063b:
            int r0 = com.google.android.gms.internal.ads.zzkt.zzatx
            if (r11 != r0) goto L_0x0664
            if (r2 != 0) goto L_0x0643
            r0 = 1
            goto L_0x0644
        L_0x0643:
            r0 = 0
        L_0x0644:
            com.google.android.gms.internal.ads.zzpb.checkState(r0)
            int r8 = r8 + 8
            r13.zzbk(r8)
            com.google.android.gms.internal.ads.zzpw r0 = com.google.android.gms.internal.ads.zzpw.zzi(r13)
            java.util.List<byte[]> r2 = r0.zzagy
            int r0 = r0.zzasi
            r15.zzasi = r0
            java.lang.String r0 = "video/hevc"
        L_0x0658:
            r37 = r1
            r23 = r2
            r41 = r4
            r4 = 2
            r8 = 1
            r11 = 3
            r2 = r0
            goto L_0x0730
        L_0x0664:
            int r0 = com.google.android.gms.internal.ads.zzkt.zzawb
            if (r11 != r0) goto L_0x067b
            if (r2 != 0) goto L_0x066c
            r0 = 1
            goto L_0x066d
        L_0x066c:
            r0 = 0
        L_0x066d:
            com.google.android.gms.internal.ads.zzpb.checkState(r0)
            int r0 = com.google.android.gms.internal.ads.zzkt.zzavz
            if (r1 != r0) goto L_0x0677
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x0679
        L_0x0677:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
        L_0x0679:
            r2 = r0
            goto L_0x0689
        L_0x067b:
            int r0 = com.google.android.gms.internal.ads.zzkt.zzasv
            if (r11 != r0) goto L_0x068f
            if (r2 != 0) goto L_0x0683
            r0 = 1
            goto L_0x0684
        L_0x0683:
            r0 = 0
        L_0x0684:
            com.google.android.gms.internal.ads.zzpb.checkState(r0)
            java.lang.String r2 = "video/3gpp"
        L_0x0689:
            r37 = r1
            r41 = r4
        L_0x068d:
            r4 = 2
            goto L_0x06c7
        L_0x068f:
            int r0 = com.google.android.gms.internal.ads.zzkt.zzaty
            if (r11 != r0) goto L_0x06ac
            if (r2 != 0) goto L_0x0697
            r0 = 1
            goto L_0x0698
        L_0x0697:
            r0 = 0
        L_0x0698:
            com.google.android.gms.internal.ads.zzpb.checkState(r0)
            android.util.Pair r0 = zzb(r13, r8)
            java.lang.Object r2 = r0.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.second
            byte[] r0 = (byte[]) r0
            java.util.List r23 = java.util.Collections.singletonList(r0)
            goto L_0x0689
        L_0x06ac:
            int r0 = com.google.android.gms.internal.ads.zzkt.zzaux
            if (r11 != r0) goto L_0x06cb
            int r8 = r8 + 8
            r13.zzbk(r8)
            int r0 = r13.zziz()
            int r5 = r13.zziz()
            float r0 = (float) r0
            float r5 = (float) r5
            float r24 = r0 / r5
            r37 = r1
            r41 = r4
            r4 = 2
            r5 = 1
        L_0x06c7:
            r8 = 1
            r11 = 3
            goto L_0x0730
        L_0x06cb:
            int r0 = com.google.android.gms.internal.ads.zzkt.zzavx
            if (r11 != r0) goto L_0x06fe
            int r0 = r8 + 8
        L_0x06d1:
            int r11 = r0 - r8
            if (r11 >= r10) goto L_0x06f6
            r13.zzbk(r0)
            int r11 = r13.readInt()
            r37 = r1
            int r1 = r13.readInt()
            r41 = r4
            int r4 = com.google.android.gms.internal.ads.zzkt.zzavy
            if (r1 != r4) goto L_0x06f0
            byte[] r1 = r13.data
            int r11 = r11 + r0
            byte[] r8 = java.util.Arrays.copyOfRange(r1, r0, r11)
            goto L_0x06fb
        L_0x06f0:
            int r0 = r0 + r11
            r1 = r37
            r4 = r41
            goto L_0x06d1
        L_0x06f6:
            r37 = r1
            r41 = r4
            r8 = 0
        L_0x06fb:
            r30 = r8
            goto L_0x068d
        L_0x06fe:
            r37 = r1
            r41 = r4
            int r0 = com.google.android.gms.internal.ads.zzkt.zzavw
            if (r11 != r0) goto L_0x068d
            int r0 = r13.readUnsignedByte()
            r11 = 3
            r13.zzbl(r11)
            if (r0 != 0) goto L_0x072e
            int r0 = r13.readUnsignedByte()
            if (r0 == 0) goto L_0x0729
            r8 = 1
            if (r0 == r8) goto L_0x0725
            r4 = 2
            if (r0 == r4) goto L_0x0722
            if (r0 == r11) goto L_0x071f
            goto L_0x0730
        L_0x071f:
            r34 = 3
            goto L_0x0730
        L_0x0722:
            r34 = 2
            goto L_0x0730
        L_0x0725:
            r4 = 2
            r34 = 1
            goto L_0x0730
        L_0x0729:
            r4 = 2
            r8 = 1
            r34 = 0
            goto L_0x0730
        L_0x072e:
            r4 = 2
            r8 = 1
        L_0x0730:
            int r3 = r3 + r10
            r0 = r36
            r1 = r37
            r4 = r41
            r10 = 16
            r11 = 8
            goto L_0x05f0
        L_0x073d:
            r36 = r0
            r4 = 2
            r8 = 1
            r11 = 3
            if (r2 == 0) goto L_0x077f
            java.lang.String r1 = java.lang.Integer.toString(r22)
            r3 = 0
            r0 = -1
            r5 = -1
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = 0
            r25 = 2
            r4 = r0
            r0 = 1
            r8 = r10
            r37 = r9
            r9 = r23
            r23 = 16
            r10 = r28
            r0 = 8
            r35 = 3
            r11 = r24
            r24 = r12
            r12 = r30
            r48 = r50
            r0 = r13
            r25 = 3
            r13 = r34
            r23 = r14
            r30 = 16
            r14 = r16
            r16 = r0
            r0 = r15
            r15 = r53
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.zzahr = r1
            goto L_0x078c
        L_0x077f:
            r48 = r50
            r37 = r9
            r24 = r12
            r16 = r13
            r23 = r14
            r0 = r15
            goto L_0x059e
        L_0x078c:
            int r5 = r24 + r23
            r1 = r16
            r1.zzbk(r5)
            int r6 = r37 + 1
            r15 = r53
            r8 = r0
            r12 = r1
            r14 = r18
            r10 = r19
            r9 = r31
            r11 = r36
            r13 = r48
            r7 = 8
            r0 = r49
            goto L_0x01b4
        L_0x07a9:
            r0 = r8
            r19 = r10
            r48 = r13
            r18 = r14
            r29 = 0
            int r1 = com.google.android.gms.internal.ads.zzkt.zzaue
            r2 = r49
            com.google.android.gms.internal.ads.zzks r1 = r2.zzar(r1)
            if (r1 == 0) goto L_0x0817
            int r2 = com.google.android.gms.internal.ads.zzkt.zzauf
            com.google.android.gms.internal.ads.zzkv r1 = r1.zzaq(r2)
            if (r1 != 0) goto L_0x07c5
            goto L_0x0817
        L_0x07c5:
            com.google.android.gms.internal.ads.zzpi r1 = r1.zzawl
            r2 = 8
            r1.zzbk(r2)
            int r2 = r1.readInt()
            int r2 = com.google.android.gms.internal.ads.zzkt.zzas(r2)
            int r3 = r1.zziz()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r9 = 0
        L_0x07dd:
            if (r9 >= r3) goto L_0x0810
            r6 = 1
            if (r2 != r6) goto L_0x07e7
            long r7 = r1.zzja()
            goto L_0x07eb
        L_0x07e7:
            long r7 = r1.zziw()
        L_0x07eb:
            r4[r9] = r7
            if (r2 != r6) goto L_0x07f4
            long r7 = r1.readLong()
            goto L_0x07f9
        L_0x07f4:
            int r7 = r1.readInt()
            long r7 = (long) r7
        L_0x07f9:
            r5[r9] = r7
            short r7 = r1.readShort()
            if (r7 != r6) goto L_0x0808
            r7 = 2
            r1.zzbl(r7)
            int r9 = r9 + 1
            goto L_0x07dd
        L_0x0808:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0810:
            android.util.Pair r1 = android.util.Pair.create(r4, r5)
            r2 = r1
            r1 = 0
            goto L_0x081c
        L_0x0817:
            r1 = 0
            android.util.Pair r2 = android.util.Pair.create(r1, r1)
        L_0x081c:
            com.google.android.gms.internal.ads.zzhq r3 = r0.zzahr
            if (r3 != 0) goto L_0x0821
            return r1
        L_0x0821:
            com.google.android.gms.internal.ads.zzlp r1 = new com.google.android.gms.internal.ads.zzlp
            int r16 = r18.f26id
            r3 = r48
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            com.google.android.gms.internal.ads.zzhq r5 = r0.zzahr
            int r6 = r0.zzaww
            com.google.android.gms.internal.ads.zzlo[] r7 = r0.zzawv
            int r0 = r0.zzasi
            java.lang.Object r8 = r2.first
            r28 = r8
            long[] r28 = (long[]) r28
            java.lang.Object r2 = r2.second
            r29 = r2
            long[] r29 = (long[]) r29
            r15 = r1
            r17 = r19
            r18 = r3
            r20 = r32
            r22 = r26
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r0
            r15.<init>(r16, r17, r18, r20, r22, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzku.zza(com.google.android.gms.internal.ads.zzks, com.google.android.gms.internal.ads.zzkv, long, com.google.android.gms.internal.ads.zzjl, boolean):com.google.android.gms.internal.ads.zzlp");
    }

    public static zzlq zza(zzlp zzlp, zzks zzks, zzkb zzkb) throws zzht {
        zzkw zzkw;
        boolean z;
        int i;
        int i2;
        long j;
        int i3;
        int[] iArr;
        int i4;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        zzlp zzlp2;
        int[] iArr3;
        int i5;
        boolean z2;
        long[] jArr3;
        long[] jArr4;
        int[] iArr4;
        int i6;
        int i7;
        int i8;
        int i9;
        zzkv zzaq = zzks.zzaq(zzkt.zzavf);
        if (zzaq != null) {
            zzkw = new zzky(zzaq);
        } else {
            zzkv zzaq2 = zzks.zzaq(zzkt.zzavg);
            if (zzaq2 != null) {
                zzkw = new zzlb(zzaq2);
            } else {
                throw new zzht("Track has no sample table size information");
            }
        }
        int zzgw = zzkw.zzgw();
        if (zzgw == 0) {
            return new zzlq(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzkv zzaq3 = zzks.zzaq(zzkt.zzavh);
        if (zzaq3 == null) {
            zzaq3 = zzks.zzaq(zzkt.zzavi);
            z = true;
        } else {
            z = false;
        }
        zzpi zzpi = zzaq3.zzawl;
        zzpi zzpi2 = zzks.zzaq(zzkt.zzave).zzawl;
        zzpi zzpi3 = zzks.zzaq(zzkt.zzavb).zzawl;
        zzkv zzaq4 = zzks.zzaq(zzkt.zzavc);
        zzpi zzpi4 = null;
        zzpi zzpi5 = zzaq4 != null ? zzaq4.zzawl : null;
        zzkv zzaq5 = zzks.zzaq(zzkt.zzavd);
        zzpi zzpi6 = zzaq5 != null ? zzaq5.zzawl : null;
        zzkx zzkx = new zzkx(zzpi2, zzpi, z);
        zzpi3.zzbk(12);
        int zziz = zzpi3.zziz() - 1;
        int zziz2 = zzpi3.zziz();
        int zziz3 = zzpi3.zziz();
        if (zzpi6 != null) {
            zzpi6.zzbk(12);
            i = zzpi6.zziz();
        } else {
            i = 0;
        }
        int i10 = -1;
        if (zzpi5 != null) {
            zzpi5.zzbk(12);
            i2 = zzpi5.zziz();
            if (i2 > 0) {
                i10 = zzpi5.zziz() - 1;
                zzpi4 = zzpi5;
            }
        } else {
            zzpi4 = zzpi5;
            i2 = 0;
        }
        long j2 = 0;
        if (!(zzkw.zzgy() && "audio/raw".equals(zzlp.zzahr.zzagw) && zziz == 0 && i == 0 && i2 == 0)) {
            long[] jArr5 = new long[zzgw];
            iArr = new int[zzgw];
            jArr = new long[zzgw];
            iArr2 = new int[zzgw];
            int i11 = i10;
            long j3 = 0;
            j = 0;
            int i12 = 0;
            i4 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = i;
            int i17 = zziz3;
            int i18 = zziz2;
            int i19 = zziz;
            int i20 = i2;
            while (i12 < zzgw) {
                while (i14 == 0) {
                    zzpb.checkState(zzkx.zzgz());
                    j3 = zzkx.zzawn;
                    i14 = zzkx.zzawm;
                    i17 = i17;
                    i18 = i18;
                }
                if (zzpi6 != null) {
                    while (i13 == 0 && i16 > 0) {
                        i13 = zzpi6.zziz();
                        i15 = zzpi6.readInt();
                        i16--;
                    }
                    i13--;
                }
                jArr5[i12] = j3;
                iArr[i12] = zzkw.zzgx();
                if (iArr[i12] > i4) {
                    i4 = iArr[i12];
                }
                jArr[i12] = j + ((long) i15);
                iArr2[i12] = zzpi4 == null ? 1 : 0;
                if (i12 == i11) {
                    iArr2[i12] = 1;
                    i20--;
                    if (i20 > 0) {
                        i11 = zzpi4.zziz() - 1;
                    }
                }
                j += (long) i17;
                int i21 = i18 - 1;
                if (i21 != 0 || i19 <= 0) {
                    i8 = i17;
                    i9 = i21;
                } else {
                    i9 = zzpi3.zziz();
                    i8 = zzpi3.zziz();
                    i19--;
                }
                j3 += (long) iArr[i12];
                i14--;
                i12++;
                zzgw = zzgw;
                jArr5 = jArr5;
                i11 = i11;
                i15 = i15;
                i18 = i9;
                i17 = i8;
                zzkw = zzkw;
            }
            i3 = zzgw;
            zzpb.checkArgument(i13 == 0);
            while (i16 > 0) {
                zzpb.checkArgument(zzpi6.zziz() == 0);
                zzpi6.readInt();
                i16--;
            }
            if (i20 == 0 && i18 == 0) {
                i7 = i14;
                if (i7 == 0 && i19 == 0) {
                    zzlp2 = zzlp;
                    jArr2 = jArr5;
                }
            } else {
                i7 = i14;
            }
            zzlp2 = zzlp;
            int i22 = zzlp2.f27id;
            StringBuilder sb = new StringBuilder(215);
            sb.append("Inconsistent stbl box for track ");
            sb.append(i22);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i20);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i18);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i7);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i19);
            Log.w("AtomParsers", sb.toString());
            jArr2 = jArr5;
        } else {
            zzlp2 = zzlp;
            i3 = zzgw;
            long[] jArr6 = new long[zzkx.length];
            int i23 = zzkx.length;
            int[] iArr5 = new int[i23];
            while (zzkx.zzgz()) {
                jArr6[zzkx.index] = zzkx.zzawn;
                iArr5[zzkx.index] = zzkx.zzawm;
            }
            int zzgx = zzkw.zzgx();
            long j4 = (long) zziz3;
            int i24 = 8192 / zzgx;
            int i25 = 0;
            for (int i26 = 0; i26 < i23; i26++) {
                i25 += zzpo.zzf(iArr5[i26], i24);
            }
            long[] jArr7 = new long[i25];
            int[] iArr6 = new int[i25];
            long[] jArr8 = new long[i25];
            int[] iArr7 = new int[i25];
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            while (i27 < i23) {
                int i31 = iArr5[i27];
                long j5 = jArr6[i27];
                int i32 = i31;
                while (i32 > 0) {
                    int min = Math.min(i24, i32);
                    jArr7[i29] = j5;
                    iArr6[i29] = zzgx * min;
                    i30 = Math.max(i30, iArr6[i29]);
                    jArr8[i29] = ((long) i28) * j4;
                    iArr7[i29] = 1;
                    j5 += (long) iArr6[i29];
                    i28 += min;
                    i32 -= min;
                    i29++;
                    i23 = i23;
                    iArr5 = iArr5;
                }
                i27++;
                jArr6 = jArr6;
            }
            zzlf zzlf = new zzlf(jArr7, iArr6, i30, jArr8, iArr7);
            jArr2 = zzlf.zzaon;
            iArr = zzlf.zzaom;
            i4 = zzlf.zzayb;
            jArr = zzlf.zzayc;
            iArr2 = zzlf.zzayd;
            j = 0;
        }
        if (zzlp2.zzbad == null || zzkb.zzgs()) {
            zzpo.zza(jArr, 1000000, zzlp2.zzdg);
            return new zzlq(jArr2, iArr, i4, jArr, iArr2);
        }
        if (zzlp2.zzbad.length == 1 && zzlp2.type == 1 && jArr.length >= 2) {
            long j6 = zzlp2.zzbae[0];
            long zza = zzpo.zza(zzlp2.zzbad[0], zzlp2.zzdg, zzlp2.zzbaa) + j6;
            if (jArr[0] <= j6 && j6 < jArr[1] && jArr[jArr.length - 1] < zza && zza <= j) {
                long j7 = j - zza;
                long zza2 = zzpo.zza(j6 - jArr[0], (long) zzlp2.zzahr.zzahh, zzlp2.zzdg);
                long zza3 = zzpo.zza(j7, (long) zzlp2.zzahr.zzahh, zzlp2.zzdg);
                if (!(zza2 == 0 && zza3 == 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    zzkb.zzahj = (int) zza2;
                    zzkb.zzahk = (int) zza3;
                    zzpo.zza(jArr, 1000000, zzlp2.zzdg);
                    return new zzlq(jArr2, iArr, i4, jArr, iArr2);
                }
            }
        }
        if (zzlp2.zzbad.length == 1) {
            char c = 0;
            if (zzlp2.zzbad[0] == 0) {
                int i33 = 0;
                while (i33 < jArr.length) {
                    jArr[i33] = zzpo.zza(jArr[i33] - zzlp2.zzbae[c], 1000000, zzlp2.zzdg);
                    i33++;
                    c = 0;
                }
                return new zzlq(jArr2, iArr, i4, jArr, iArr2);
            }
        }
        boolean z3 = zzlp2.type == 1;
        boolean z4 = false;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        while (i35 < zzlp2.zzbad.length) {
            long j8 = zzlp2.zzbae[i35];
            if (j8 != -1) {
                i6 = i4;
                long zza4 = zzpo.zza(zzlp2.zzbad[i35], zzlp2.zzdg, zzlp2.zzbaa);
                int zzb = zzpo.zzb(jArr, j8, true, true);
                int zzb2 = zzpo.zzb(jArr, j8 + zza4, z3, false);
                i34 += zzb2 - zzb;
                z4 |= i36 != zzb;
                i36 = zzb2;
            } else {
                i6 = i4;
            }
            i35++;
            i4 = i6;
        }
        boolean z5 = z4 | (i34 != i3);
        long[] jArr9 = z5 ? new long[i34] : jArr2;
        int[] iArr8 = z5 ? new int[i34] : iArr;
        int i37 = z5 ? 0 : i4;
        int[] iArr9 = z5 ? new int[i34] : iArr2;
        long[] jArr10 = new long[i34];
        int i38 = i37;
        int i39 = 0;
        int i40 = 0;
        while (i39 < zzlp2.zzbad.length) {
            long j9 = zzlp2.zzbae[i39];
            long j10 = zzlp2.zzbad[i39];
            if (j9 != -1) {
                i5 = i39;
                int zzb3 = zzpo.zzb(jArr, j9, true, true);
                int zzb4 = zzpo.zzb(jArr, zzpo.zza(j10, zzlp2.zzdg, zzlp2.zzbaa) + j9, z3, false);
                if (z5) {
                    int i41 = zzb4 - zzb3;
                    jArr3 = jArr9;
                    jArr4 = jArr2;
                    System.arraycopy(jArr4, zzb3, jArr3, i40, i41);
                    System.arraycopy(iArr, zzb3, iArr8, i40, i41);
                    z2 = z3;
                    iArr4 = iArr9;
                    System.arraycopy(iArr2, zzb3, iArr4, i40, i41);
                } else {
                    jArr3 = jArr9;
                    z2 = z3;
                    iArr4 = iArr9;
                    jArr4 = jArr2;
                }
                int i42 = i38;
                while (zzb3 < zzb4) {
                    jArr10[i40] = zzpo.zza(j2, 1000000, zzlp2.zzbaa) + zzpo.zza(jArr[zzb3] - j9, 1000000, zzlp2.zzdg);
                    if (z5 && iArr8[i40] > i42) {
                        i42 = iArr[zzb3];
                    }
                    i40++;
                    zzb3++;
                    j9 = j9;
                    zzb4 = zzb4;
                    iArr4 = iArr4;
                }
                iArr3 = iArr4;
                i38 = i42;
            } else {
                z2 = z3;
                jArr3 = jArr9;
                iArr3 = iArr9;
                i5 = i39;
                jArr4 = jArr2;
            }
            j2 += j10;
            i39 = i5 + 1;
            jArr2 = jArr4;
            jArr9 = jArr3;
            z3 = z2;
            iArr9 = iArr3;
        }
        boolean z6 = false;
        for (int i43 = 0; i43 < iArr9.length && !z6; i43++) {
            z6 |= (iArr9[i43] & 1) != 0;
        }
        if (z6) {
            return new zzlq(jArr9, iArr8, i38, jArr10, iArr9);
        }
        throw new zzht("The edited sample sequence does not contain a sync sample.");
    }

    public static zzme zza(zzkv zzkv, boolean z) {
        if (z) {
            return null;
        }
        zzpi zzpi = zzkv.zzawl;
        zzpi.zzbk(8);
        while (zzpi.zziu() >= 8) {
            int position = zzpi.getPosition();
            int readInt = zzpi.readInt();
            if (zzpi.readInt() == zzkt.zzavq) {
                zzpi.zzbk(position);
                int i = position + readInt;
                zzpi.zzbl(12);
                while (true) {
                    if (zzpi.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzpi.getPosition();
                    int readInt2 = zzpi.readInt();
                    if (zzpi.readInt() == zzkt.zzavr) {
                        zzpi.zzbk(position2);
                        int i2 = position2 + readInt2;
                        zzpi.zzbl(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpi.getPosition() < i2) {
                            zzme.zza zzd = zzli.zzd(zzpi);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzme(arrayList);
                        }
                    } else {
                        zzpi.zzbl(readInt2 - 8);
                    }
                }
                return null;
            }
            zzpi.zzbl(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzb(zzpi zzpi, int i) {
        zzpi.zzbk(i + 8 + 4);
        zzpi.zzbl(1);
        zzc(zzpi);
        zzpi.zzbl(2);
        int readUnsignedByte = zzpi.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzpi.zzbl(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzpi.zzbl(zzpi.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzpi.zzbl(2);
        }
        zzpi.zzbl(1);
        zzc(zzpi);
        int readUnsignedByte2 = zzpi.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = "video/mp4v-es";
        } else if (readUnsignedByte2 == 33) {
            str = "video/avc";
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (readUnsignedByte2 == 165) {
                    str = "audio/ac3";
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384 /*{ENCODED_INT: 169}*/:
                                case CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256 /*{ENCODED_INT: 172}*/:
                                    return Pair.create("audio/vnd.dts", null);
                                case CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256 /*{ENCODED_INT: 170}*/:
                                case CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384 /*{ENCODED_INT: 171}*/:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzpi.zzbl(12);
        zzpi.zzbl(1);
        int zzc = zzc(zzpi);
        byte[] bArr = new byte[zzc];
        zzpi.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zza(zzpi zzpi, int i, int i2, zzkz zzkz, int i3) {
        int position = zzpi.getPosition();
        while (true) {
            boolean z = false;
            if (position - i >= i2) {
                return 0;
            }
            zzpi.zzbk(position);
            int readInt = zzpi.readInt();
            zzpb.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzpi.readInt() == zzkt.zzauk) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzlo zzlo = null;
                boolean z2 = false;
                while (i4 - position < readInt) {
                    zzpi.zzbk(i4);
                    int readInt2 = zzpi.readInt();
                    int readInt3 = zzpi.readInt();
                    if (readInt3 == zzkt.zzauq) {
                        num = Integer.valueOf(zzpi.readInt());
                    } else if (readInt3 == zzkt.zzaul) {
                        zzpi.zzbl(4);
                        z2 = zzpi.readInt() == zzawk;
                    } else if (readInt3 == zzkt.zzaum) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzlo = null;
                                break;
                            }
                            zzpi.zzbk(i5);
                            int readInt4 = zzpi.readInt();
                            if (zzpi.readInt() == zzkt.zzaun) {
                                zzpi.zzbl(6);
                                boolean z3 = zzpi.readUnsignedByte() == 1;
                                int readUnsignedByte = zzpi.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpi.zze(bArr, 0, 16);
                                zzlo = new zzlo(z3, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                    }
                    i4 += readInt2;
                }
                if (z2) {
                    zzpb.checkArgument(num != null, "frma atom is mandatory");
                    if (zzlo != null) {
                        z = true;
                    }
                    zzpb.checkArgument(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzlo);
                }
                if (pair != null) {
                    zzkz.zzawv[i3] = (zzlo) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            position += readInt;
        }
    }

    private static int zzc(zzpi zzpi) {
        int readUnsignedByte = zzpi.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzpi.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
