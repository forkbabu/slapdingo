package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzlw {
    private static final zzlt zzbcq = zzlt.zzba("OMX.google.raw.decoder");
    private static final Pattern zzbcr = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zza, List<zzlt>> zzbcs = new HashMap<>();
    private static final SparseIntArray zzbct;
    private static final SparseIntArray zzbcu;
    private static final Map<String, Integer> zzbcv;
    private static int zzbcw = -1;

    public static zzlt zzhi() {
        return zzbcq;
    }

    public static zzlt zzb(String str, boolean z) throws zzma {
        List<zzlt> zzc = zzc(str, z);
        if (zzc.isEmpty()) {
            return null;
        }
        return zzc.get(0);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static final class zza {
        public final String mimeType;
        public final boolean zzbck;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzbck = z;
        }

        public final int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.zzbck ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zza = (zza) obj;
                return TextUtils.equals(this.mimeType, zza.mimeType) && this.zzbck == zza.zzbck;
            }
        }
    }

    private static synchronized List<zzlt> zzc(String str, boolean z) throws zzma {
        synchronized (zzlw.class) {
            zza zza2 = new zza(str, z);
            List<zzlt> list = zzbcs.get(zza2);
            if (list != null) {
                return list;
            }
            List<zzlt> zza3 = zza(zza2, zzpo.SDK_INT >= 21 ? new zzmb(z) : new zzmc());
            if (z && zza3.isEmpty() && 21 <= zzpo.SDK_INT && zzpo.SDK_INT <= 23) {
                zza3 = zza(zza2, new zzmc());
                if (!zza3.isEmpty()) {
                    String str2 = zza3.get(0).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzlt> unmodifiableList = Collections.unmodifiableList(zza3);
            zzbcs.put(zza2, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int zzhj() throws zzma {
        if (zzbcw == -1) {
            int i = 0;
            zzlt zzb = zzb("video/avc", false);
            if (zzb != null) {
                MediaCodecInfo.CodecProfileLevel[] zzhh = zzb.zzhh();
                int length = zzhh.length;
                int i2 = 0;
                while (i < length) {
                    int i3 = zzhh[i].level;
                    int i4 = 9437184;
                    if (i3 == 1 || i3 == 2) {
                        i4 = 25344;
                    } else {
                        switch (i3) {
                            case 8:
                            case 16:
                            case 32:
                                i4 = 101376;
                                continue;
                            case 64:
                                i4 = 202752;
                                continue;
                            case 128:
                            case 256:
                                i4 = 414720;
                                continue;
                            case 512:
                                i4 = 921600;
                                continue;
                            case 1024:
                                i4 = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i4 = 2097152;
                                continue;
                            case 8192:
                                i4 = 2228224;
                                continue;
                            case 16384:
                                i4 = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i4 = -1;
                                continue;
                        }
                    }
                    i2 = Math.max(i4, i2);
                    i++;
                }
                i = Math.max(i2, zzpo.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzbcw = i;
        }
        return zzbcw;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r3.equals("hev1") != false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzbd(java.lang.String r9) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r9.split(r1)
            r2 = 0
            r3 = r1[r2]
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r5) {
                case 3006243: goto L_0x0036;
                case 3006244: goto L_0x002c;
                case 3199032: goto L_0x0023;
                case 3214780: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0040
        L_0x0019:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0023:
            java.lang.String r5 = "hev1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0040
            goto L_0x0041
        L_0x002c:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 3
            goto L_0x0041
        L_0x0036:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0040
            r2 = 2
            goto L_0x0041
        L_0x0040:
            r2 = -1
        L_0x0041:
            if (r2 == 0) goto L_0x004f
            if (r2 == r8) goto L_0x004f
            if (r2 == r7) goto L_0x004a
            if (r2 == r6) goto L_0x004a
            return r0
        L_0x004a:
            android.util.Pair r9 = zza(r9, r1)
            return r9
        L_0x004f:
            int r2 = r1.length
            r3 = 4
            java.lang.String r4 = "Ignoring malformed HEVC codec string: "
            java.lang.String r5 = "MediaCodecUtil"
            if (r2 >= r3) goto L_0x006f
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            if (r1 == 0) goto L_0x0066
            java.lang.String r9 = r4.concat(r9)
            goto L_0x006b
        L_0x0066:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r4)
        L_0x006b:
            android.util.Log.w(r5, r9)
            return r0
        L_0x006f:
            java.util.regex.Pattern r2 = com.google.android.gms.internal.ads.zzlw.zzbcr
            r3 = r1[r8]
            java.util.regex.Matcher r2 = r2.matcher(r3)
            boolean r3 = r2.matches()
            if (r3 != 0) goto L_0x0095
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r1 = r9.length()
            if (r1 == 0) goto L_0x008c
            java.lang.String r9 = r4.concat(r9)
            goto L_0x0091
        L_0x008c:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r4)
        L_0x0091:
            android.util.Log.w(r5, r9)
            return r0
        L_0x0095:
            java.lang.String r9 = r2.group(r8)
            java.lang.String r3 = "1"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x00a3
            r7 = 1
            goto L_0x00ab
        L_0x00a3:
            java.lang.String r3 = "2"
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x00e0
        L_0x00ab:
            java.util.Map<java.lang.String, java.lang.Integer> r9 = com.google.android.gms.internal.ads.zzlw.zzbcv
            r1 = r1[r6]
            java.lang.Object r9 = r9.get(r1)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 != 0) goto L_0x00d6
            java.lang.String r9 = "Unknown HEVC level string: "
            java.lang.String r1 = r2.group(r8)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x00cc
            java.lang.String r9 = r9.concat(r1)
            goto L_0x00d2
        L_0x00cc:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r9)
            r9 = r1
        L_0x00d2:
            android.util.Log.w(r5, r9)
            return r0
        L_0x00d6:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0.<init>(r1, r9)
            return r0
        L_0x00e0:
            java.lang.String r1 = "Unknown HEVC profile string: "
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r2 = r9.length()
            if (r2 == 0) goto L_0x00f1
            java.lang.String r9 = r1.concat(r9)
            goto L_0x00f6
        L_0x00f1:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r1)
        L_0x00f6:
            android.util.Log.w(r5, r9)
            return r0
            switch-data {3006243->0x0036, 3006244->0x002c, 3199032->0x0023, 3214780->0x0019, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlw.zzbd(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x01fd A[Catch:{ Exception -> 0x01f8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.android.gms.internal.ads.zzlt> zza(com.google.android.gms.internal.ads.zzlw.zza r17, com.google.android.gms.internal.ads.zzlz r18) throws com.google.android.gms.internal.ads.zzma {
        /*
            r1 = r17
            r2 = r18
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ae }
            r3.<init>()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r4 = r1.mimeType     // Catch:{ Exception -> 0x02ae }
            int r5 = r18.getCodecCount()     // Catch:{ Exception -> 0x02ae }
            boolean r6 = r18.zzhk()     // Catch:{ Exception -> 0x02ae }
            r8 = 0
        L_0x0014:
            if (r8 >= r5) goto L_0x02ad
            android.media.MediaCodecInfo r9 = r2.getCodecInfoAt(r8)     // Catch:{ Exception -> 0x02ae }
            java.lang.String r10 = r9.getName()     // Catch:{ Exception -> 0x02ae }
            boolean r0 = r9.isEncoder()     // Catch:{ Exception -> 0x02ae }
            java.lang.String r11 = ".secure"
            if (r0 != 0) goto L_0x01af
            if (r6 != 0) goto L_0x0030
            boolean r0 = r10.endsWith(r11)
            if (r0 == 0) goto L_0x0030
            goto L_0x01af
        L_0x0030:
            int r0 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            r13 = 21
            if (r0 >= r13) goto L_0x0068
            java.lang.String r0 = "CIPAACDecoder"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "CIPMP3Decoder"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "CIPVorbisDecoder"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "CIPAMRNBDecoder"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "AACDecoder"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "MP3Decoder"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0068
            goto L_0x01af
        L_0x0068:
            int r0 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            r13 = 18
            if (r0 >= r13) goto L_0x0078
            java.lang.String r0 = "OMX.SEC.MP3.Decoder"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0078
            goto L_0x01af
        L_0x0078:
            int r0 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            if (r0 >= r13) goto L_0x0090
            java.lang.String r0 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0090
            java.lang.String r0 = "a70"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0090
            goto L_0x01af
        L_0x0090:
            int r0 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            r13 = 16
            if (r0 != r13) goto L_0x0118
            java.lang.String r0 = "OMX.qcom.audio.decoder.mp3"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0118
            java.lang.String r0 = "dlxu"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "protou"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "ville"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "villeplus"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "villec2"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzpo.DEVICE
            java.lang.String r14 = "gee"
            boolean r0 = r0.startsWith(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C6602"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C6603"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C6606"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C6616"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "L36h"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "SO-02E"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0118
            goto L_0x01af
        L_0x0118:
            int r0 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            if (r0 != r13) goto L_0x014d
            java.lang.String r0 = "OMX.qcom.audio.decoder.aac"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x014d
            java.lang.String r0 = "C1504"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C1505"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C1604"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = "C1605"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x014d
            goto L_0x01af
        L_0x014d:
            int r0 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            java.lang.String r13 = "jflte"
            r14 = 19
            if (r0 > r14) goto L_0x0198
            java.lang.String r0 = "OMX.SEC.vp8.dec"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = "samsung"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzpo.MANUFACTURER
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = com.google.android.gms.internal.ads.zzpo.DEVICE
            java.lang.String r15 = "d2"
            boolean r0 = r0.startsWith(r15)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzpo.DEVICE
            java.lang.String r15 = "serrano"
            boolean r0 = r0.startsWith(r15)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.startsWith(r13)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzpo.DEVICE
            java.lang.String r15 = "santos"
            boolean r0 = r0.startsWith(r15)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = com.google.android.gms.internal.ads.zzpo.DEVICE
            java.lang.String r15 = "t0"
            boolean r0 = r0.startsWith(r15)
            if (r0 == 0) goto L_0x0198
            goto L_0x01af
        L_0x0198:
            int r0 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            if (r0 > r14) goto L_0x01ad
            java.lang.String r0 = com.google.android.gms.internal.ads.zzpo.DEVICE
            boolean r0 = r0.startsWith(r13)
            if (r0 == 0) goto L_0x01ad
            java.lang.String r0 = "OMX.qcom.video.decoder.vp8"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x01ad
            goto L_0x01af
        L_0x01ad:
            r0 = 1
            goto L_0x01b0
        L_0x01af:
            r0 = 0
        L_0x01b0:
            if (r0 == 0) goto L_0x02a3
            java.lang.String[] r13 = r9.getSupportedTypes()
            int r14 = r13.length
            r15 = 0
        L_0x01b8:
            if (r15 >= r14) goto L_0x02a3
            r12 = r13[r15]
            boolean r0 = r12.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x0299
            android.media.MediaCodecInfo$CodecCapabilities r0 = r9.getCapabilitiesForType(r12)     // Catch:{ Exception -> 0x022e }
            boolean r7 = r2.zza(r4, r0)     // Catch:{ Exception -> 0x022e }
            int r2 = com.google.android.gms.internal.ads.zzpo.SDK_INT     // Catch:{ Exception -> 0x022e }
            r16 = r5
            r5 = 22
            if (r2 > r5) goto L_0x01fa
            java.lang.String r2 = com.google.android.gms.internal.ads.zzpo.MODEL     // Catch:{ Exception -> 0x01f8 }
            java.lang.String r5 = "ODROID-XU3"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01f8 }
            if (r2 != 0) goto L_0x01e6
            java.lang.String r2 = com.google.android.gms.internal.ads.zzpo.MODEL     // Catch:{ Exception -> 0x01f8 }
            java.lang.String r5 = "Nexus 10"
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x01f8 }
            if (r2 == 0) goto L_0x01fa
        L_0x01e6:
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01f8 }
            if (r2 != 0) goto L_0x01f6
            java.lang.String r2 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r2 = r2.equals(r10)     // Catch:{ Exception -> 0x01f8 }
            if (r2 == 0) goto L_0x01fa
        L_0x01f6:
            r2 = 1
            goto L_0x01fb
        L_0x01f8:
            r0 = move-exception
            goto L_0x0231
        L_0x01fa:
            r2 = 0
        L_0x01fb:
            if (r6 == 0) goto L_0x0204
            boolean r5 = r1.zzbck     // Catch:{ Exception -> 0x01f8 }
            if (r5 == r7) goto L_0x0202
            goto L_0x0204
        L_0x0202:
            r5 = 0
            goto L_0x020b
        L_0x0204:
            if (r6 != 0) goto L_0x0214
            boolean r5 = r1.zzbck     // Catch:{ Exception -> 0x01f8 }
            if (r5 != 0) goto L_0x0214
            goto L_0x0202
        L_0x020b:
            com.google.android.gms.internal.ads.zzlt r0 = com.google.android.gms.internal.ads.zzlt.zza(r10, r4, r0, r2, r5)     // Catch:{ Exception -> 0x01f8 }
            r3.add(r0)     // Catch:{ Exception -> 0x01f8 }
            goto L_0x029b
        L_0x0214:
            r5 = 0
            if (r6 != 0) goto L_0x022c
            if (r7 == 0) goto L_0x022c
            java.lang.String r7 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x01f8 }
            java.lang.String r7 = r7.concat(r11)     // Catch:{ Exception -> 0x01f8 }
            r5 = 1
            com.google.android.gms.internal.ads.zzlt r0 = com.google.android.gms.internal.ads.zzlt.zza(r7, r4, r0, r2, r5)     // Catch:{ Exception -> 0x022a }
            r3.add(r0)     // Catch:{ Exception -> 0x022a }
            return r3
        L_0x022a:
            r0 = move-exception
            goto L_0x0232
        L_0x022c:
            r5 = 1
            goto L_0x029b
        L_0x022e:
            r0 = move-exception
            r16 = r5
        L_0x0231:
            r5 = 1
        L_0x0232:
            int r2 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            r7 = 23
            java.lang.String r5 = "MediaCodecUtil"
            if (r2 > r7) goto L_0x0264
            boolean r2 = r3.isEmpty()
            if (r2 != 0) goto L_0x0264
            java.lang.String r0 = java.lang.String.valueOf(r10)
            int r0 = r0.length()
            int r0 = r0 + 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "Skipping codec "
            r2.append(r0)
            r2.append(r10)
            java.lang.String r0 = " (failed to query capabilities)"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.e(r5, r0)
            goto L_0x029b
        L_0x0264:
            java.lang.String r1 = java.lang.String.valueOf(r10)
            int r1 = r1.length()
            int r1 = r1 + 25
            java.lang.String r2 = java.lang.String.valueOf(r12)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to query codec "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " ("
            r2.append(r1)
            r2.append(r12)
            java.lang.String r1 = ")"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.util.Log.e(r5, r1)
            throw r0
        L_0x0299:
            r16 = r5
        L_0x029b:
            int r15 = r15 + 1
            r2 = r18
            r5 = r16
            goto L_0x01b8
        L_0x02a3:
            r16 = r5
            int r8 = r8 + 1
            r2 = r18
            r5 = r16
            goto L_0x0014
        L_0x02ad:
            return r3
        L_0x02ae:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzma r1 = new com.google.android.gms.internal.ads.zzma
            r2 = 0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlw.zza(com.google.android.gms.internal.ads.zzlw$zza, com.google.android.gms.internal.ads.zzlz):java.util.List");
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer num;
        Integer num2;
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
                num2 = valueOf2;
            } else {
                String valueOf3 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf4 = Integer.valueOf(zzbct.get(num2.intValue()));
            if (valueOf4 == null) {
                String valueOf5 = String.valueOf(num2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf5);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf6 = Integer.valueOf(zzbcu.get(num.intValue()));
            if (valueOf6 != null) {
                return new Pair<>(valueOf4, valueOf6);
            }
            String valueOf7 = String.valueOf(num);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf7).length() + 19);
            sb2.append("Unknown AVC level: ");
            sb2.append(valueOf7);
            Log.w("MediaCodecUtil", sb2.toString());
            return null;
        } catch (NumberFormatException unused) {
            String valueOf8 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf8.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf8) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzbct = sparseIntArray;
        sparseIntArray.put(66, 1);
        zzbct.put(77, 2);
        zzbct.put(88, 4);
        zzbct.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzbcu = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        zzbcu.put(11, 4);
        zzbcu.put(12, 8);
        zzbcu.put(13, 16);
        zzbcu.put(20, 32);
        zzbcu.put(21, 64);
        zzbcu.put(22, 128);
        zzbcu.put(30, 256);
        zzbcu.put(31, 512);
        zzbcu.put(32, 1024);
        zzbcu.put(40, 2048);
        zzbcu.put(41, 4096);
        zzbcu.put(42, 8192);
        zzbcu.put(50, 16384);
        zzbcu.put(51, 32768);
        zzbcu.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzbcv = hashMap;
        hashMap.put("L30", 1);
        zzbcv.put("L60", 4);
        zzbcv.put("L63", 16);
        zzbcv.put("L90", 64);
        zzbcv.put("L93", 256);
        zzbcv.put("L120", 1024);
        zzbcv.put("L123", 4096);
        zzbcv.put("L150", 16384);
        zzbcv.put("L153", 65536);
        zzbcv.put("L156", 262144);
        zzbcv.put("L180", 1048576);
        zzbcv.put("L183", 4194304);
        zzbcv.put("L186", 16777216);
        zzbcv.put("H30", 2);
        zzbcv.put("H60", 8);
        zzbcv.put("H63", 32);
        zzbcv.put("H90", 128);
        zzbcv.put("H93", 512);
        zzbcv.put("H120", 2048);
        zzbcv.put("H123", 8192);
        zzbcv.put("H150", 32768);
        zzbcv.put("H153", 131072);
        zzbcv.put("H156", 524288);
        zzbcv.put("H180", 2097152);
        zzbcv.put("H183", 8388608);
        zzbcv.put("H186", 33554432);
    }
}
