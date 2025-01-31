package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzry {
    private final int zzbtu;
    private final zzro zzbtw;
    private String zzbub;
    private String zzbuc;
    private final boolean zzbud = false;
    private final int zzbue;
    private final int zzbuf;

    public zzry(int i, int i2, int i3) {
        this.zzbtu = i;
        if (i2 > 64 || i2 < 0) {
            this.zzbue = 64;
        } else {
            this.zzbue = i2;
        }
        if (i3 <= 0) {
            this.zzbuf = 1;
        } else {
            this.zzbuf = i3;
        }
        this.zzbtw = new zzrz(this.zzbue);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0107, code lost:
        if (r2.size() < r16.zzbtu) goto L_0x010b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0113 A[LOOP:0: B:1:0x0012->B:64:0x0113, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0117 A[EDGE_INSN: B:75:0x0117->B:65:0x0117 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(java.util.ArrayList<java.lang.String> r17, java.util.ArrayList<com.google.android.gms.internal.ads.zzrp> r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            com.google.android.gms.internal.ads.zzsb r2 = new com.google.android.gms.internal.ads.zzsb
            r2.<init>(r1)
            java.util.Collections.sort(r0, r2)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r4 = 0
        L_0x0012:
            int r5 = r18.size()
            java.lang.String r6 = ""
            if (r4 >= r5) goto L_0x0117
            java.lang.Object r5 = r0.get(r4)
            com.google.android.gms.internal.ads.zzrp r5 = (com.google.android.gms.internal.ads.zzrp) r5
            int r5 = r5.zzmr()
            r7 = r17
            java.lang.Object r5 = r7.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.text.Normalizer$Form r8 = java.text.Normalizer.Form.NFKC
            java.lang.String r5 = java.text.Normalizer.normalize(r5, r8)
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r8)
            java.lang.String r8 = "\n"
            java.lang.String[] r5 = r5.split(r8)
            int r8 = r5.length
            if (r8 == 0) goto L_0x010f
            r8 = 0
        L_0x0042:
            int r10 = r5.length
            if (r8 >= r10) goto L_0x010f
            r10 = r5[r8]
            java.lang.String r11 = "'"
            int r11 = r10.indexOf(r11)
            r12 = -1
            if (r11 == r12) goto L_0x00aa
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            r12 = 1
            r13 = 0
        L_0x0057:
            int r14 = r12 + 2
            int r15 = r11.length()
            if (r14 > r15) goto L_0x009d
            char r15 = r11.charAt(r12)
            r3 = 39
            if (r15 != r3) goto L_0x009a
            int r3 = r12 + -1
            char r3 = r11.charAt(r3)
            r13 = 32
            if (r3 == r13) goto L_0x0094
            int r3 = r12 + 1
            char r15 = r11.charAt(r3)
            r9 = 115(0x73, float:1.61E-43)
            if (r15 == r9) goto L_0x0083
            char r3 = r11.charAt(r3)
            r9 = 83
            if (r3 != r9) goto L_0x0094
        L_0x0083:
            int r3 = r11.length()
            if (r14 == r3) goto L_0x008f
            char r3 = r11.charAt(r14)
            if (r3 != r13) goto L_0x0094
        L_0x008f:
            r11.insert(r12, r13)
            r12 = r14
            goto L_0x0097
        L_0x0094:
            r11.setCharAt(r12, r13)
        L_0x0097:
            r3 = 1
            r13 = 1
            goto L_0x009b
        L_0x009a:
            r3 = 1
        L_0x009b:
            int r12 = r12 + r3
            goto L_0x0057
        L_0x009d:
            if (r13 == 0) goto L_0x00a4
            java.lang.String r3 = r11.toString()
            goto L_0x00a5
        L_0x00a4:
            r3 = 0
        L_0x00a5:
            if (r3 == 0) goto L_0x00aa
            r1.zzbuc = r3
            r10 = r3
        L_0x00aa:
            r3 = 1
            java.lang.String[] r9 = com.google.android.gms.internal.ads.zzrs.zzd(r10, r3)
            int r10 = r9.length
            int r11 = r1.zzbuf
            if (r10 < r11) goto L_0x010b
            r10 = 0
        L_0x00b5:
            int r11 = r9.length
            if (r10 >= r11) goto L_0x0101
            r12 = r6
            r11 = 0
        L_0x00ba:
            int r13 = r1.zzbuf
            if (r11 >= r13) goto L_0x00ef
            int r13 = r10 + r11
            int r14 = r9.length
            if (r13 < r14) goto L_0x00c5
            r11 = 0
            goto L_0x00f0
        L_0x00c5:
            if (r11 <= 0) goto L_0x00d1
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r14 = " "
            java.lang.String r12 = r12.concat(r14)
        L_0x00d1:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r13 = r9[r13]
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r14 = r13.length()
            if (r14 == 0) goto L_0x00e6
            java.lang.String r12 = r12.concat(r13)
            goto L_0x00ec
        L_0x00e6:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r12)
            r12 = r13
        L_0x00ec:
            int r11 = r11 + 1
            goto L_0x00ba
        L_0x00ef:
            r11 = 1
        L_0x00f0:
            if (r11 == 0) goto L_0x0101
            r2.add(r12)
            int r11 = r2.size()
            int r12 = r1.zzbtu
            if (r11 < r12) goto L_0x00fe
            goto L_0x0109
        L_0x00fe:
            int r10 = r10 + 1
            goto L_0x00b5
        L_0x0101:
            int r9 = r2.size()
            int r10 = r1.zzbtu
            if (r9 < r10) goto L_0x010b
        L_0x0109:
            r9 = 0
            goto L_0x0111
        L_0x010b:
            int r8 = r8 + 1
            goto L_0x0042
        L_0x010f:
            r3 = 1
            r9 = 1
        L_0x0111:
            if (r9 == 0) goto L_0x0117
            int r4 = r4 + 1
            goto L_0x0012
        L_0x0117:
            com.google.android.gms.internal.ads.zzrt r3 = new com.google.android.gms.internal.ads.zzrt
            r3.<init>()
            r1.zzbub = r6
            java.util.Iterator r0 = r2.iterator()
        L_0x0122:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x013e
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzro r4 = r1.zzbtw     // Catch:{ IOException -> 0x0138 }
            byte[] r2 = r4.zzbs(r2)     // Catch:{ IOException -> 0x0138 }
            r3.write(r2)     // Catch:{ IOException -> 0x0138 }
            goto L_0x0122
        L_0x0138:
            r0 = move-exception
            java.lang.String r2 = "Error while writing hash to byteStream"
            com.google.android.gms.internal.ads.zzaxv.zzc(r2, r0)
        L_0x013e:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzry.zza(java.util.ArrayList, java.util.ArrayList):java.lang.String");
    }
}
