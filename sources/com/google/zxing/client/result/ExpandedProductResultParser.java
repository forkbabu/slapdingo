package com.google.zxing.client.result;

public final class ExpandedProductResultParser extends ResultParser {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01fb, code lost:
        if (r1.equals("10") != false) goto L_0x0216;
     */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0262  */
    @Override // com.google.zxing.client.result.ResultParser
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.client.result.ExpandedProductParsedResult parse(com.google.zxing.Result r25) {
        /*
            r24 = this;
            com.google.zxing.BarcodeFormat r0 = r25.getBarcodeFormat()
            com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.RSS_EXPANDED
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            java.lang.String r4 = getMassagedText(r25)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r5 = r2
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r3 = 0
        L_0x0023:
            int r1 = r4.length()
            if (r3 >= r1) goto L_0x026d
            java.lang.String r1 = findAIvalue(r3, r4)
            if (r1 != 0) goto L_0x0030
            return r2
        L_0x0030:
            int r18 = r1.length()
            r19 = 2
            int r18 = r18 + 2
            int r3 = r3 + r18
            java.lang.String r2 = findValue(r3, r4)
            int r20 = r2.length()
            int r3 = r3 + r20
            r20 = -1
            r21 = r3
            int r3 = r1.hashCode()
            r22 = r15
            r15 = 1536(0x600, float:2.152E-42)
            r23 = r14
            r14 = 3
            if (r3 == r15) goto L_0x0209
            r15 = 1537(0x601, float:2.154E-42)
            if (r3 == r15) goto L_0x01fe
            r15 = 1567(0x61f, float:2.196E-42)
            if (r3 == r15) goto L_0x01f5
            r15 = 1568(0x620, float:2.197E-42)
            if (r3 == r15) goto L_0x01ea
            r15 = 1570(0x622, float:2.2E-42)
            if (r3 == r15) goto L_0x01df
            r15 = 1572(0x624, float:2.203E-42)
            if (r3 == r15) goto L_0x01d4
            r15 = 1574(0x626, float:2.206E-42)
            if (r3 == r15) goto L_0x01c9
            switch(r3) {
                case 1567966: goto L_0x01be;
                case 1567967: goto L_0x01b3;
                case 1567968: goto L_0x01a7;
                case 1567969: goto L_0x019b;
                case 1567970: goto L_0x018f;
                case 1567971: goto L_0x0183;
                case 1567972: goto L_0x0177;
                case 1567973: goto L_0x016b;
                case 1567974: goto L_0x015f;
                case 1567975: goto L_0x0153;
                default: goto L_0x0070;
            }
        L_0x0070:
            switch(r3) {
                case 1568927: goto L_0x0147;
                case 1568928: goto L_0x013b;
                case 1568929: goto L_0x012f;
                case 1568930: goto L_0x0123;
                case 1568931: goto L_0x0117;
                case 1568932: goto L_0x010b;
                case 1568933: goto L_0x00ff;
                case 1568934: goto L_0x00f3;
                case 1568935: goto L_0x00e7;
                case 1568936: goto L_0x00db;
                default: goto L_0x0073;
            }
        L_0x0073:
            switch(r3) {
                case 1575716: goto L_0x00cf;
                case 1575717: goto L_0x00c3;
                case 1575718: goto L_0x00b7;
                case 1575719: goto L_0x00ab;
                default: goto L_0x0076;
            }
        L_0x0076:
            switch(r3) {
                case 1575747: goto L_0x009f;
                case 1575748: goto L_0x0093;
                case 1575749: goto L_0x0087;
                case 1575750: goto L_0x007b;
                default: goto L_0x0079;
            }
        L_0x0079:
            goto L_0x0214
        L_0x007b:
            java.lang.String r3 = "3933"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 34
            goto L_0x0216
        L_0x0087:
            java.lang.String r3 = "3932"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 33
            goto L_0x0216
        L_0x0093:
            java.lang.String r3 = "3931"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 32
            goto L_0x0216
        L_0x009f:
            java.lang.String r3 = "3930"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 31
            goto L_0x0216
        L_0x00ab:
            java.lang.String r3 = "3923"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 30
            goto L_0x0216
        L_0x00b7:
            java.lang.String r3 = "3922"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 29
            goto L_0x0216
        L_0x00c3:
            java.lang.String r3 = "3921"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 28
            goto L_0x0216
        L_0x00cf:
            java.lang.String r3 = "3920"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 27
            goto L_0x0216
        L_0x00db:
            java.lang.String r3 = "3209"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 26
            goto L_0x0216
        L_0x00e7:
            java.lang.String r3 = "3208"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 25
            goto L_0x0216
        L_0x00f3:
            java.lang.String r3 = "3207"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 24
            goto L_0x0216
        L_0x00ff:
            java.lang.String r3 = "3206"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 23
            goto L_0x0216
        L_0x010b:
            java.lang.String r3 = "3205"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 22
            goto L_0x0216
        L_0x0117:
            java.lang.String r3 = "3204"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 21
            goto L_0x0216
        L_0x0123:
            java.lang.String r3 = "3203"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 20
            goto L_0x0216
        L_0x012f:
            java.lang.String r3 = "3202"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 19
            goto L_0x0216
        L_0x013b:
            java.lang.String r3 = "3201"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 18
            goto L_0x0216
        L_0x0147:
            java.lang.String r3 = "3200"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 17
            goto L_0x0216
        L_0x0153:
            java.lang.String r3 = "3109"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 16
            goto L_0x0216
        L_0x015f:
            java.lang.String r3 = "3108"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 15
            goto L_0x0216
        L_0x016b:
            java.lang.String r3 = "3107"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 14
            goto L_0x0216
        L_0x0177:
            java.lang.String r3 = "3106"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 13
            goto L_0x0216
        L_0x0183:
            java.lang.String r3 = "3105"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 12
            goto L_0x0216
        L_0x018f:
            java.lang.String r3 = "3104"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 11
            goto L_0x0216
        L_0x019b:
            java.lang.String r3 = "3103"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 10
            goto L_0x0216
        L_0x01a7:
            java.lang.String r3 = "3102"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 9
            goto L_0x0216
        L_0x01b3:
            java.lang.String r3 = "3101"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 8
            goto L_0x0216
        L_0x01be:
            java.lang.String r3 = "3100"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 7
            goto L_0x0216
        L_0x01c9:
            java.lang.String r3 = "17"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 6
            goto L_0x0216
        L_0x01d4:
            java.lang.String r3 = "15"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 5
            goto L_0x0216
        L_0x01df:
            java.lang.String r3 = "13"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 4
            goto L_0x0216
        L_0x01ea:
            java.lang.String r3 = "11"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 3
            goto L_0x0216
        L_0x01f5:
            java.lang.String r3 = "10"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            goto L_0x0216
        L_0x01fe:
            java.lang.String r3 = "01"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 1
            goto L_0x0216
        L_0x0209:
            java.lang.String r3 = "00"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0214
            r19 = 0
            goto L_0x0216
        L_0x0214:
            r19 = -1
        L_0x0216:
            switch(r19) {
                case 0: goto L_0x0262;
                case 1: goto L_0x025f;
                case 2: goto L_0x025c;
                case 3: goto L_0x0259;
                case 4: goto L_0x0256;
                case 5: goto L_0x0253;
                case 6: goto L_0x0250;
                case 7: goto L_0x0245;
                case 8: goto L_0x0245;
                case 9: goto L_0x0245;
                case 10: goto L_0x0245;
                case 11: goto L_0x0245;
                case 12: goto L_0x0245;
                case 13: goto L_0x0245;
                case 14: goto L_0x0245;
                case 15: goto L_0x0245;
                case 16: goto L_0x0245;
                case 17: goto L_0x023d;
                case 18: goto L_0x023d;
                case 19: goto L_0x023d;
                case 20: goto L_0x023d;
                case 21: goto L_0x023d;
                case 22: goto L_0x023d;
                case 23: goto L_0x023d;
                case 24: goto L_0x023d;
                case 25: goto L_0x023d;
                case 26: goto L_0x023d;
                case 27: goto L_0x0236;
                case 28: goto L_0x0236;
                case 29: goto L_0x0236;
                case 30: goto L_0x0236;
                case 31: goto L_0x021e;
                case 32: goto L_0x021e;
                case 33: goto L_0x021e;
                case 34: goto L_0x021e;
                default: goto L_0x0219;
            }
        L_0x0219:
            r3 = 0
            r0.put(r1, r2)
            goto L_0x0264
        L_0x021e:
            int r3 = r2.length()
            r15 = 4
            if (r3 >= r15) goto L_0x0227
            r3 = 0
            return r3
        L_0x0227:
            r3 = 0
            java.lang.String r15 = r2.substring(r14)
            r3 = 0
            java.lang.String r17 = r2.substring(r3, r14)
            java.lang.String r16 = r1.substring(r14)
            goto L_0x0266
        L_0x0236:
            r3 = 0
            java.lang.String r16 = r1.substring(r14)
            r15 = r2
            goto L_0x0266
        L_0x023d:
            r3 = 0
            java.lang.String r14 = r1.substring(r14)
            java.lang.String r13 = "LB"
            goto L_0x024c
        L_0x0245:
            r3 = 0
            java.lang.String r14 = r1.substring(r14)
            java.lang.String r13 = "KG"
        L_0x024c:
            r12 = r2
            r15 = r22
            goto L_0x0268
        L_0x0250:
            r3 = 0
            r11 = r2
            goto L_0x0264
        L_0x0253:
            r3 = 0
            r10 = r2
            goto L_0x0264
        L_0x0256:
            r3 = 0
            r9 = r2
            goto L_0x0264
        L_0x0259:
            r3 = 0
            r8 = r2
            goto L_0x0264
        L_0x025c:
            r3 = 0
            r7 = r2
            goto L_0x0264
        L_0x025f:
            r3 = 0
            r5 = r2
            goto L_0x0264
        L_0x0262:
            r3 = 0
            r6 = r2
        L_0x0264:
            r15 = r22
        L_0x0266:
            r14 = r23
        L_0x0268:
            r3 = r21
            r2 = 0
            goto L_0x0023
        L_0x026d:
            r23 = r14
            r22 = r15
            com.google.zxing.client.result.ExpandedProductParsedResult r1 = new com.google.zxing.client.result.ExpandedProductParsedResult
            r3 = r1
            r18 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
            switch-data {1567966->0x01be, 1567967->0x01b3, 1567968->0x01a7, 1567969->0x019b, 1567970->0x018f, 1567971->0x0183, 1567972->0x0177, 1567973->0x016b, 1567974->0x015f, 1567975->0x0153, }
            switch-data {1568927->0x0147, 1568928->0x013b, 1568929->0x012f, 1568930->0x0123, 1568931->0x0117, 1568932->0x010b, 1568933->0x00ff, 1568934->0x00f3, 1568935->0x00e7, 1568936->0x00db, }
            switch-data {1575716->0x00cf, 1575717->0x00c3, 1575718->0x00b7, 1575719->0x00ab, }
            switch-data {1575747->0x009f, 1575748->0x0093, 1575749->0x0087, 1575750->0x007b, }
            switch-data {0->0x0262, 1->0x025f, 2->0x025c, 3->0x0259, 4->0x0256, 5->0x0253, 6->0x0250, 7->0x0245, 8->0x0245, 9->0x0245, 10->0x0245, 11->0x0245, 12->0x0245, 13->0x0245, 14->0x0245, 15->0x0245, 16->0x0245, 17->0x023d, 18->0x023d, 19->0x023d, 20->0x023d, 21->0x023d, 22->0x023d, 23->0x023d, 24->0x023d, 25->0x023d, 26->0x023d, 27->0x0236, 28->0x0236, 29->0x0236, 30->0x0236, 31->0x021e, 32->0x021e, 33->0x021e, 34->0x021e, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ExpandedProductResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.ExpandedProductParsedResult");
    }

    private static String findAIvalue(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String substring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (findAIvalue(i2, substring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
