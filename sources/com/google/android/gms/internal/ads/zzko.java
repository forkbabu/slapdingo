package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzko {
    public int height;
    public int number;
    public int type;
    public int width;
    public zzjl zzagz;
    public int zzahd;
    public byte[] zzahe;
    public int zzahg;
    public int zzahh;
    /* access modifiers changed from: private */
    public String zzahn;
    public String zzard;
    public int zzare;
    public boolean zzarf;
    public byte[] zzarg;
    public zzkh zzarh;
    public byte[] zzari;
    public int zzarj;
    public int zzark;
    public int zzarl;
    public boolean zzarm;
    public int zzarn;
    public int zzaro;
    public int zzarp;
    public int zzarq;
    public int zzarr;
    public float zzars;
    public float zzart;
    public float zzaru;
    public float zzarv;
    public float zzarw;
    public float zzarx;
    public float zzary;
    public float zzarz;
    public float zzasa;
    public float zzasb;
    public int zzasc;
    public long zzasd;
    public long zzase;
    public boolean zzasf;
    public boolean zzasg;
    public zzke zzash;
    public int zzasi;

    private zzko() {
        this.width = -1;
        this.height = -1;
        this.zzarj = -1;
        this.zzark = -1;
        this.zzarl = 0;
        this.zzahe = null;
        this.zzahd = -1;
        this.zzarm = false;
        this.zzarn = -1;
        this.zzaro = -1;
        this.zzarp = -1;
        this.zzarq = 1000;
        this.zzarr = 200;
        this.zzars = -1.0f;
        this.zzart = -1.0f;
        this.zzaru = -1.0f;
        this.zzarv = -1.0f;
        this.zzarw = -1.0f;
        this.zzarx = -1.0f;
        this.zzary = -1.0f;
        this.zzarz = -1.0f;
        this.zzasa = -1.0f;
        this.zzasb = -1.0f;
        this.zzahg = 1;
        this.zzasc = -1;
        this.zzahh = 8000;
        this.zzasd = 0;
        this.zzase = 0;
        this.zzasg = true;
        this.zzahn = "eng";
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x034f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzjz r43, int r44) throws com.google.android.gms.internal.ads.zzht {
        /*
            r42 = this;
            r0 = r42
            java.lang.String r1 = r0.zzard
            int r2 = r1.hashCode()
            r4 = 4
            r5 = 8
            r6 = 1
            r7 = 2
            r8 = 0
            r9 = 3
            r10 = -1
            switch(r2) {
                case -2095576542: goto L_0x014a;
                case -2095575984: goto L_0x0140;
                case -1985379776: goto L_0x0135;
                case -1784763192: goto L_0x012a;
                case -1730367663: goto L_0x011f;
                case -1482641358: goto L_0x0114;
                case -1482641357: goto L_0x0109;
                case -1373388978: goto L_0x00fe;
                case -933872740: goto L_0x00f3;
                case -538363189: goto L_0x00e8;
                case -538363109: goto L_0x00dd;
                case -425012669: goto L_0x00d1;
                case -356037306: goto L_0x00c5;
                case 62923557: goto L_0x00b9;
                case 62923603: goto L_0x00ad;
                case 62927045: goto L_0x00a1;
                case 82338133: goto L_0x0096;
                case 82338134: goto L_0x008b;
                case 99146302: goto L_0x007f;
                case 444813526: goto L_0x0073;
                case 542569478: goto L_0x0067;
                case 725957860: goto L_0x005b;
                case 855502857: goto L_0x0050;
                case 1422270023: goto L_0x0044;
                case 1809237540: goto L_0x0039;
                case 1950749482: goto L_0x002d;
                case 1950789798: goto L_0x0021;
                case 1951062397: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0154
        L_0x0015:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 11
            goto L_0x0155
        L_0x0021:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 21
            goto L_0x0155
        L_0x002d:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 16
            goto L_0x0155
        L_0x0039:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 2
            goto L_0x0155
        L_0x0044:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 24
            goto L_0x0155
        L_0x0050:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 7
            goto L_0x0155
        L_0x005b:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 23
            goto L_0x0155
        L_0x0067:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 19
            goto L_0x0155
        L_0x0073:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 9
            goto L_0x0155
        L_0x007f:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 26
            goto L_0x0155
        L_0x008b:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 1
            goto L_0x0155
        L_0x0096:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 0
            goto L_0x0155
        L_0x00a1:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 18
            goto L_0x0155
        L_0x00ad:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 15
            goto L_0x0155
        L_0x00b9:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 12
            goto L_0x0155
        L_0x00c5:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 20
            goto L_0x0155
        L_0x00d1:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 25
            goto L_0x0155
        L_0x00dd:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 6
            goto L_0x0155
        L_0x00e8:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 4
            goto L_0x0155
        L_0x00f3:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 27
            goto L_0x0155
        L_0x00fe:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 8
            goto L_0x0155
        L_0x0109:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 14
            goto L_0x0155
        L_0x0114:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 13
            goto L_0x0155
        L_0x011f:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 10
            goto L_0x0155
        L_0x012a:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 17
            goto L_0x0155
        L_0x0135:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 22
            goto L_0x0155
        L_0x0140:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 3
            goto L_0x0155
        L_0x014a:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 5
            goto L_0x0155
        L_0x0154:
            r1 = -1
        L_0x0155:
            java.lang.String r2 = "application/dvbsubs"
            java.lang.String r11 = "application/pgs"
            java.lang.String r12 = "application/vobsub"
            java.lang.String r13 = "application/x-subrip"
            java.lang.String r14 = "audio/raw"
            java.lang.String r16 = "video/x-unknown"
            java.lang.String r15 = "audio/x-unknown"
            java.lang.String r3 = "MatroskaExtractor"
            r17 = 0
            switch(r1) {
                case 0: goto L_0x030f;
                case 1: goto L_0x030c;
                case 2: goto L_0x0309;
                case 3: goto L_0x02fb;
                case 4: goto L_0x02fb;
                case 5: goto L_0x02fb;
                case 6: goto L_0x02e7;
                case 7: goto L_0x02d3;
                case 8: goto L_0x02b6;
                case 9: goto L_0x02b3;
                case 10: goto L_0x029e;
                case 11: goto L_0x0259;
                case 12: goto L_0x024d;
                case 13: goto L_0x0242;
                case 14: goto L_0x023f;
                case 15: goto L_0x023a;
                case 16: goto L_0x0237;
                case 17: goto L_0x0234;
                case 18: goto L_0x0231;
                case 19: goto L_0x0231;
                case 20: goto L_0x022e;
                case 21: goto L_0x0225;
                case 22: goto L_0x01d4;
                case 23: goto L_0x019e;
                case 24: goto L_0x019b;
                case 25: goto L_0x0191;
                case 26: goto L_0x018e;
                case 27: goto L_0x0172;
                default: goto L_0x016a;
            }
        L_0x016a:
            com.google.android.gms.internal.ads.zzht r1 = new com.google.android.gms.internal.ads.zzht
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x0172:
            byte[] r1 = new byte[r4]
            byte[] r3 = r0.zzari
            byte r4 = r3[r8]
            r1[r8] = r4
            byte r4 = r3[r6]
            r1[r6] = r4
            byte r4 = r3[r7]
            r1[r7] = r4
            byte r3 = r3[r9]
            r1[r9] = r3
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r3 = r1
            r1 = r2
            goto L_0x0313
        L_0x018e:
            r1 = r11
            goto L_0x0311
        L_0x0191:
            byte[] r1 = r0.zzari
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r3 = r1
            r1 = r12
            goto L_0x0313
        L_0x019b:
            r1 = r13
            goto L_0x0311
        L_0x019e:
            int r1 = r0.zzasc
            int r1 = com.google.android.gms.internal.ads.zzpo.zzbq(r1)
            if (r1 != 0) goto L_0x01cd
            int r1 = r0.zzasc
            int r4 = r15.length()
            int r4 = r4 + 60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r5.append(r1)
            r5.append(r15)
            java.lang.String r1 = r5.toString()
            android.util.Log.w(r3, r1)
        L_0x01ca:
            r1 = r15
            goto L_0x0311
        L_0x01cd:
            r25 = r1
            r1 = r14
            r3 = r17
            goto L_0x0315
        L_0x01d4:
            com.google.android.gms.internal.ads.zzpi r1 = new com.google.android.gms.internal.ads.zzpi
            byte[] r4 = r0.zzari
            r1.<init>(r4)
            boolean r1 = zzb(r1)
            if (r1 == 0) goto L_0x020e
            int r1 = r0.zzasc
            int r1 = com.google.android.gms.internal.ads.zzpo.zzbq(r1)
            if (r1 != 0) goto L_0x01cd
            int r1 = r0.zzasc
            int r4 = r15.length()
            int r4 = r4 + 60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r5.append(r1)
            r5.append(r15)
            java.lang.String r1 = r5.toString()
            android.util.Log.w(r3, r1)
            goto L_0x01ca
        L_0x020e:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
            int r4 = r15.length()
            if (r4 == 0) goto L_0x021b
            java.lang.String r1 = r1.concat(r15)
            goto L_0x0221
        L_0x021b:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r1)
            r1 = r4
        L_0x0221:
            android.util.Log.w(r3, r1)
            goto L_0x01ca
        L_0x0225:
            byte[] r1 = r0.zzari
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r14 = "audio/x-flac"
            goto L_0x0255
        L_0x022e:
            java.lang.String r14 = "audio/vnd.dts.hd"
            goto L_0x023c
        L_0x0231:
            java.lang.String r14 = "audio/vnd.dts"
            goto L_0x023c
        L_0x0234:
            java.lang.String r14 = "audio/true-hd"
            goto L_0x023c
        L_0x0237:
            java.lang.String r14 = "audio/eac3"
            goto L_0x023c
        L_0x023a:
            java.lang.String r14 = "audio/ac3"
        L_0x023c:
            r1 = r14
            goto L_0x0311
        L_0x023f:
            java.lang.String r14 = "audio/mpeg"
            goto L_0x0244
        L_0x0242:
            java.lang.String r14 = "audio/mpeg-L2"
        L_0x0244:
            r1 = r14
            r3 = r17
            r25 = -1
            r30 = 4096(0x1000, float:5.74E-42)
            goto L_0x0317
        L_0x024d:
            byte[] r1 = r0.zzari
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r14 = "audio/mp4a-latm"
        L_0x0255:
            r3 = r1
            r1 = r14
            goto L_0x0313
        L_0x0259:
            r15 = 5760(0x1680, float:8.071E-42)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r9)
            byte[] r3 = r0.zzari
            r1.add(r3)
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r3 = r3.order(r4)
            long r6 = r0.zzasd
            java.nio.ByteBuffer r3 = r3.putLong(r6)
            byte[] r3 = r3.array()
            r1.add(r3)
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r5 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r3 = r3.order(r5)
            long r5 = r0.zzase
            java.nio.ByteBuffer r3 = r3.putLong(r5)
            byte[] r3 = r3.array()
            r1.add(r3)
            java.lang.String r3 = "audio/opus"
            r25 = -1
            r30 = 5760(0x1680, float:8.071E-42)
            goto L_0x02ac
        L_0x029e:
            r15 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = r0.zzari
            java.util.List r1 = zzd(r1)
            java.lang.String r3 = "audio/vorbis"
            r25 = -1
            r30 = 8192(0x2000, float:1.14794E-41)
        L_0x02ac:
            r41 = r3
            r3 = r1
            r1 = r41
            goto L_0x0317
        L_0x02b3:
            r1 = r16
            goto L_0x0311
        L_0x02b6:
            com.google.android.gms.internal.ads.zzpi r1 = new com.google.android.gms.internal.ads.zzpi
            byte[] r5 = r0.zzari
            r1.<init>(r5)
            java.util.List r1 = zza(r1)
            if (r1 == 0) goto L_0x02ca
            java.lang.String r3 = "video/wvc1"
        L_0x02c5:
            r25 = -1
            r30 = -1
            goto L_0x02ac
        L_0x02ca:
            java.lang.String r5 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r3, r5)
            r3 = r1
            r1 = r16
            goto L_0x0313
        L_0x02d3:
            com.google.android.gms.internal.ads.zzpi r1 = new com.google.android.gms.internal.ads.zzpi
            byte[] r3 = r0.zzari
            r1.<init>(r3)
            com.google.android.gms.internal.ads.zzpw r1 = com.google.android.gms.internal.ads.zzpw.zzi(r1)
            java.util.List<byte[]> r3 = r1.zzagy
            int r1 = r1.zzasi
            r0.zzasi = r1
            java.lang.String r1 = "video/hevc"
            goto L_0x0313
        L_0x02e7:
            com.google.android.gms.internal.ads.zzpi r1 = new com.google.android.gms.internal.ads.zzpi
            byte[] r3 = r0.zzari
            r1.<init>(r3)
            com.google.android.gms.internal.ads.zzpq r1 = com.google.android.gms.internal.ads.zzpq.zzg(r1)
            java.util.List<byte[]> r3 = r1.zzagy
            int r1 = r1.zzasi
            r0.zzasi = r1
            java.lang.String r1 = "video/avc"
            goto L_0x0313
        L_0x02fb:
            byte[] r1 = r0.zzari
            if (r1 != 0) goto L_0x0302
            r1 = r17
            goto L_0x0306
        L_0x0302:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x0306:
            java.lang.String r3 = "video/mp4v-es"
            goto L_0x02c5
        L_0x0309:
            java.lang.String r1 = "video/mpeg2"
            goto L_0x0311
        L_0x030c:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            goto L_0x0311
        L_0x030f:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
        L_0x0311:
            r3 = r17
        L_0x0313:
            r25 = -1
        L_0x0315:
            r30 = -1
        L_0x0317:
            boolean r5 = r0.zzasg
            r5 = r5 | r8
            boolean r6 = r0.zzasf
            if (r6 == 0) goto L_0x0320
            r6 = 2
            goto L_0x0321
        L_0x0320:
            r6 = 0
        L_0x0321:
            r5 = r5 | r6
            boolean r6 = com.google.android.gms.internal.ads.zzpe.zzbe(r1)
            if (r6 == 0) goto L_0x034f
            java.lang.String r18 = java.lang.Integer.toString(r44)
            r20 = 0
            r21 = -1
            int r2 = r0.zzahg
            int r6 = r0.zzahh
            com.google.android.gms.internal.ads.zzjl r7 = r0.zzagz
            java.lang.String r8 = r0.zzahn
            r19 = r1
            r22 = r30
            r23 = r2
            r24 = r6
            r26 = r3
            r27 = r7
            r28 = r5
            r29 = r8
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r6 = 1
            goto L_0x04d2
        L_0x034f:
            boolean r4 = com.google.android.gms.internal.ads.zzpe.zzbf(r1)
            if (r4 == 0) goto L_0x047e
            int r2 = r0.zzarl
            if (r2 != 0) goto L_0x0369
            int r2 = r0.zzarj
            if (r2 != r10) goto L_0x035f
            int r2 = r0.width
        L_0x035f:
            r0.zzarj = r2
            int r2 = r0.zzark
            if (r2 != r10) goto L_0x0367
            int r2 = r0.height
        L_0x0367:
            r0.zzark = r2
        L_0x0369:
            int r2 = r0.zzarj
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r10) goto L_0x0381
            int r5 = r0.zzark
            if (r5 == r10) goto L_0x0381
            int r6 = r0.height
            int r6 = r6 * r2
            float r2 = (float) r6
            int r6 = r0.width
            int r6 = r6 * r5
            float r5 = (float) r6
            float r2 = r2 / r5
            r36 = r2
            goto L_0x0383
        L_0x0381:
            r36 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0383:
            boolean r2 = r0.zzarm
            if (r2 == 0) goto L_0x0452
            float r2 = r0.zzars
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzart
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzaru
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzarv
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzarw
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzarx
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzary
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzarz
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzasa
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0442
            float r2 = r0.zzasb
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x03c5
            goto L_0x0442
        L_0x03c5:
            r2 = 25
            byte[] r2 = new byte[r2]
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r2)
            r4.put(r8)
            float r5 = r0.zzars
            r6 = 1195593728(0x47435000, float:50000.0)
            float r5 = r5 * r6
            r7 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzart
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzaru
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarv
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarw
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarx
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzary
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzarz
            float r5 = r5 * r6
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzasa
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r0.zzasb
            float r5 = r5 + r7
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            int r5 = r0.zzarq
            short r5 = (short) r5
            r4.putShort(r5)
            int r5 = r0.zzarr
            short r5 = (short) r5
            r4.putShort(r5)
            goto L_0x0444
        L_0x0442:
            r2 = r17
        L_0x0444:
            com.google.android.gms.internal.ads.zzpt r4 = new com.google.android.gms.internal.ads.zzpt
            int r5 = r0.zzarn
            int r6 = r0.zzarp
            int r7 = r0.zzaro
            r4.<init>(r5, r6, r7, r2)
            r39 = r4
            goto L_0x0454
        L_0x0452:
            r39 = r17
        L_0x0454:
            java.lang.String r26 = java.lang.Integer.toString(r44)
            r28 = 0
            r29 = -1
            int r2 = r0.width
            int r4 = r0.height
            r33 = -1082130432(0xffffffffbf800000, float:-1.0)
            r35 = -1
            byte[] r5 = r0.zzahe
            int r6 = r0.zzahd
            com.google.android.gms.internal.ads.zzjl r7 = r0.zzagz
            r27 = r1
            r31 = r2
            r32 = r4
            r34 = r3
            r37 = r5
            r38 = r6
            r40 = r7
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            r6 = 2
            goto L_0x04d2
        L_0x047e:
            boolean r4 = r13.equals(r1)
            if (r4 == 0) goto L_0x049e
            java.lang.String r18 = java.lang.Integer.toString(r44)
            r20 = 0
            r21 = -1
            java.lang.String r2 = r0.zzahn
            com.google.android.gms.internal.ads.zzjl r3 = r0.zzagz
            r19 = r1
            r22 = r5
            r23 = r2
            r24 = r3
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r18, r19, r20, r21, r22, r23, r24)
        L_0x049c:
            r6 = 3
            goto L_0x04d2
        L_0x049e:
            boolean r4 = r12.equals(r1)
            if (r4 != 0) goto L_0x04b9
            boolean r4 = r11.equals(r1)
            if (r4 != 0) goto L_0x04b9
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x04b1
            goto L_0x04b9
        L_0x04b1:
            com.google.android.gms.internal.ads.zzht r1 = new com.google.android.gms.internal.ads.zzht
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x04b9:
            java.lang.String r18 = java.lang.Integer.toString(r44)
            r20 = 0
            r21 = -1
            java.lang.String r2 = r0.zzahn
            com.google.android.gms.internal.ads.zzjl r4 = r0.zzagz
            r19 = r1
            r22 = r3
            r23 = r2
            r24 = r4
            com.google.android.gms.internal.ads.zzhq r1 = com.google.android.gms.internal.ads.zzhq.zza(r18, r19, r20, r21, r22, r23, r24)
            goto L_0x049c
        L_0x04d2:
            int r2 = r0.number
            r3 = r43
            com.google.android.gms.internal.ads.zzke r2 = r3.zzc(r2, r6)
            r0.zzash = r2
            r2.zze(r1)
            return
            switch-data {-2095576542->0x014a, -2095575984->0x0140, -1985379776->0x0135, -1784763192->0x012a, -1730367663->0x011f, -1482641358->0x0114, -1482641357->0x0109, -1373388978->0x00fe, -933872740->0x00f3, -538363189->0x00e8, -538363109->0x00dd, -425012669->0x00d1, -356037306->0x00c5, 62923557->0x00b9, 62923603->0x00ad, 62927045->0x00a1, 82338133->0x0096, 82338134->0x008b, 99146302->0x007f, 444813526->0x0073, 542569478->0x0067, 725957860->0x005b, 855502857->0x0050, 1422270023->0x0044, 1809237540->0x0039, 1950749482->0x002d, 1950789798->0x0021, 1951062397->0x0015, }
            switch-data {0->0x030f, 1->0x030c, 2->0x0309, 3->0x02fb, 4->0x02fb, 5->0x02fb, 6->0x02e7, 7->0x02d3, 8->0x02b6, 9->0x02b3, 10->0x029e, 11->0x0259, 12->0x024d, 13->0x0242, 14->0x023f, 15->0x023a, 16->0x0237, 17->0x0234, 18->0x0231, 19->0x0231, 20->0x022e, 21->0x0225, 22->0x01d4, 23->0x019e, 24->0x019b, 25->0x0191, 26->0x018e, 27->0x0172, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzko.zza(com.google.android.gms.internal.ads.zzjz, int):void");
    }

    private static List<byte[]> zza(zzpi zzpi) throws zzht {
        try {
            zzpi.zzbl(16);
            if (zzpi.zzix() != 826496599) {
                return null;
            }
            byte[] bArr = zzpi.data;
            for (int position = zzpi.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzht("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzht("Error parsing FourCC VC1 codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) throws zzht {
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzht("Error parsing vorbis codec private");
                    }
                    throw new zzht("Error parsing vorbis codec private");
                }
                throw new zzht("Error parsing vorbis codec private");
            }
            throw new zzht("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzht("Error parsing vorbis codec private");
        }
    }

    private static boolean zzb(zzpi zzpi) throws zzht {
        try {
            int zziv = zzpi.zziv();
            if (zziv == 1) {
                return true;
            }
            if (zziv == 65534) {
                zzpi.zzbk(24);
                return zzpi.readLong() == zzkn.zzapf.getMostSignificantBits() && zzpi.readLong() == zzkn.zzapf.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzht("Error parsing MS/ACM codec private");
        }
    }

    /* synthetic */ zzko(zzkm zzkm) {
        this();
    }
}
