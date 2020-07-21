package com.itextpdf.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

public class BarcodeEAN extends Barcode {
    private static final byte[][] BARS = {new byte[]{3, 2, 1, 1}, new byte[]{2, 2, 2, 1}, new byte[]{2, 1, 2, 2}, new byte[]{1, 4, 1, 1}, new byte[]{1, 1, 3, 2}, new byte[]{1, 2, 3, 1}, new byte[]{1, 1, 1, 4}, new byte[]{1, 3, 1, 2}, new byte[]{1, 2, 1, 3}, new byte[]{3, 1, 1, 2}};
    private static final int EVEN = 1;
    private static final int[] GUARD_EAN13 = {0, 2, 28, 30, 56, 58};
    private static final int[] GUARD_EAN8 = {0, 2, 20, 22, 40, 42};
    private static final int[] GUARD_EMPTY = new int[0];
    private static final int[] GUARD_UPCA = {0, 2, 4, 6, 28, 30, 52, 54, 56, 58};
    private static final int[] GUARD_UPCE = {0, 2, 28, 30, 32};
    private static final int ODD = 0;
    private static final byte[][] PARITY13 = {new byte[]{0, 0, 0, 0, 0, 0}, new byte[]{0, 0, 1, 0, 1, 1}, new byte[]{0, 0, 1, 1, 0, 1}, new byte[]{0, 0, 1, 1, 1, 0}, new byte[]{0, 1, 0, 0, 1, 1}, new byte[]{0, 1, 1, 0, 0, 1}, new byte[]{0, 1, 1, 1, 0, 0}, new byte[]{0, 1, 0, 1, 0, 1}, new byte[]{0, 1, 0, 1, 1, 0}, new byte[]{0, 1, 1, 0, 1, 0}};
    private static final byte[][] PARITY2 = {new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{1, 0}, new byte[]{1, 1}};
    private static final byte[][] PARITY5 = {new byte[]{1, 1, 0, 0, 0}, new byte[]{1, 0, 1, 0, 0}, new byte[]{1, 0, 0, 1, 0}, new byte[]{1, 0, 0, 0, 1}, new byte[]{0, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1}, new byte[]{0, 1, 0, 1, 0}, new byte[]{0, 1, 0, 0, 1}, new byte[]{0, 0, 1, 0, 1}};
    private static final byte[][] PARITYE = {new byte[]{1, 1, 1, 0, 0, 0}, new byte[]{1, 1, 0, 1, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0}, new byte[]{1, 1, 0, 0, 0, 1}, new byte[]{1, 0, 1, 1, 0, 0}, new byte[]{1, 0, 0, 1, 1, 0}, new byte[]{1, 0, 0, 0, 1, 1}, new byte[]{1, 0, 1, 0, 1, 0}, new byte[]{1, 0, 1, 0, 0, 1}, new byte[]{1, 0, 0, 1, 0, 1}};
    private static final float[] TEXTPOS_EAN13 = {6.5f, 13.5f, 20.5f, 27.5f, 34.5f, 41.5f, 53.5f, 60.5f, 67.5f, 74.5f, 81.5f, 88.5f};
    private static final float[] TEXTPOS_EAN8 = {6.5f, 13.5f, 20.5f, 27.5f, 39.5f, 46.5f, 53.5f, 60.5f};
    private static final int TOTALBARS_EAN13 = 59;
    private static final int TOTALBARS_EAN8 = 43;
    private static final int TOTALBARS_SUPP2 = 13;
    private static final int TOTALBARS_SUPP5 = 31;
    private static final int TOTALBARS_UPCE = 33;

    public BarcodeEAN() {
        try {
            this.x = 0.8f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = this.size;
            this.barHeight = this.size * 3.0f;
            this.guardBars = true;
            this.codeType = 1;
            this.code = "";
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static int calculateEANParity(String str) {
        int i = 3;
        int i2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += (str.charAt(length) - '0') * i;
            i ^= 2;
        }
        return (10 - (i2 % 10)) % 10;
    }

    public static String convertUPCAtoUPCE(String str) {
        if (str.length() == 12 && (str.startsWith("0") || str.startsWith("1"))) {
            if (str.substring(3, 6).equals("000") || str.substring(3, 6).equals("100") || str.substring(3, 6).equals("200")) {
                if (str.substring(6, 8).equals("00")) {
                    return str.substring(0, 1) + str.substring(1, 3) + str.substring(8, 11) + str.substring(3, 4) + str.substring(11);
                }
            } else if (str.substring(4, 6).equals("00")) {
                if (str.substring(6, 9).equals("000")) {
                    return str.substring(0, 1) + str.substring(1, 4) + str.substring(9, 11) + ExifInterface.GPS_MEASUREMENT_3D + str.substring(11);
                }
            } else if (str.substring(5, 6).equals("0")) {
                if (str.substring(6, 10).equals("0000")) {
                    return str.substring(0, 1) + str.substring(1, 5) + str.substring(10, 11) + "4" + str.substring(11);
                }
            } else if (str.charAt(10) >= '5' && str.substring(6, 10).equals("0000")) {
                return str.substring(0, 1) + str.substring(1, 6) + str.substring(10, 11) + str.substring(11);
            }
        }
        return null;
    }

    public static byte[] getBarsEAN13(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[59];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        byte[] bArr2 = PARITY13[iArr[0]];
        int i2 = 0;
        int i3 = 3;
        while (i2 < bArr2.length) {
            int i4 = i2 + 1;
            byte[] bArr3 = BARS[iArr[i4]];
            if (bArr2[i2] == 0) {
                int i5 = i3 + 1;
                bArr[i3] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i3 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i3 + 1;
                bArr[i3] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i3 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
            i2 = i4;
        }
        int i11 = i3 + 1;
        bArr[i3] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        int i13 = i12 + 1;
        bArr[i12] = 1;
        int i14 = i13 + 1;
        bArr[i13] = 1;
        int i15 = i14 + 1;
        bArr[i14] = 1;
        for (int i16 = 7; i16 < 13; i16++) {
            byte[] bArr4 = BARS[iArr[i16]];
            int i17 = i15 + 1;
            bArr[i15] = bArr4[0];
            int i18 = i17 + 1;
            bArr[i17] = bArr4[1];
            int i19 = i18 + 1;
            bArr[i18] = bArr4[2];
            i15 = i19 + 1;
            bArr[i19] = bArr4[3];
        }
        int i20 = i15 + 1;
        bArr[i15] = 1;
        bArr[i20] = 1;
        bArr[i20 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsEAN8(String str) {
        int i;
        int length = str.length();
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = str.charAt(i2) - '0';
        }
        byte[] bArr = new byte[43];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        int i3 = 0;
        int i4 = 3;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            byte[] bArr2 = BARS[iArr[i3]];
            int i5 = i4 + 1;
            bArr[i4] = bArr2[0];
            int i6 = i5 + 1;
            bArr[i5] = bArr2[1];
            int i7 = i6 + 1;
            bArr[i6] = bArr2[2];
            i4 = i7 + 1;
            bArr[i7] = bArr2[3];
            i3++;
        }
        int i8 = i4 + 1;
        bArr[i4] = 1;
        int i9 = i8 + 1;
        bArr[i8] = 1;
        int i10 = i9 + 1;
        bArr[i9] = 1;
        int i11 = i10 + 1;
        bArr[i10] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        for (i = 4; i < 8; i++) {
            byte[] bArr3 = BARS[iArr[i]];
            int i13 = i12 + 1;
            bArr[i12] = bArr3[0];
            int i14 = i13 + 1;
            bArr[i13] = bArr3[1];
            int i15 = i14 + 1;
            bArr[i14] = bArr3[2];
            i12 = i15 + 1;
            bArr[i15] = bArr3[3];
        }
        int i16 = i12 + 1;
        bArr[i12] = 1;
        bArr[i16] = 1;
        bArr[i16 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsUPCE(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[33];
        byte b = iArr[0] != 0 ? (byte) 1 : 0;
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        int i2 = length - 1;
        byte[] bArr2 = PARITYE[iArr[i2]];
        int i3 = 3;
        for (int i4 = 1; i4 < i2; i4++) {
            byte[] bArr3 = BARS[iArr[i4]];
            if (bArr2[i4 - 1] == b) {
                int i5 = i3 + 1;
                bArr[i3] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i3 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i3 + 1;
                bArr[i3] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i3 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
        }
        int i11 = i3 + 1;
        bArr[i3] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        int i13 = i12 + 1;
        bArr[i12] = 1;
        int i14 = i13 + 1;
        bArr[i13] = 1;
        bArr[i14] = 1;
        bArr[i14 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsSupplemental2(String str) {
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[13];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = PARITY2[((iArr[0] * 10) + iArr[1]) % 4];
        int i2 = 3;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (i3 == 1) {
                int i4 = i2 + 1;
                bArr[i2] = 1;
                i2 = i4 + 1;
                bArr[i4] = 1;
            }
            byte[] bArr3 = BARS[iArr[i3]];
            if (bArr2[i3] == 0) {
                int i5 = i2 + 1;
                bArr[i2] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i2 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i2 + 1;
                bArr[i2] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i2 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
        }
        return bArr;
    }

    public static byte[] getBarsSupplemental5(String str) {
        int[] iArr = new int[5];
        for (int i = 0; i < 5; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[31];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = PARITY5[((((iArr[0] + iArr[2]) + iArr[4]) * 3) + ((iArr[1] + iArr[3]) * 9)) % 10];
        int i2 = 3;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (i3 != 0) {
                int i4 = i2 + 1;
                bArr[i2] = 1;
                i2 = i4 + 1;
                bArr[i4] = 1;
            }
            byte[] bArr3 = BARS[iArr[i3]];
            if (bArr2[i3] == 0) {
                int i5 = i2 + 1;
                bArr[i2] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i2 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i2 + 1;
                bArr[i2] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i2 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
        }
        return bArr;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8 = this.barHeight;
        if (this.font != null) {
            if (this.baseline <= 0.0f) {
                f7 = (-this.baseline) + this.size;
            } else {
                f7 = this.baseline - this.font.getFontDescriptor(3, this.size);
            }
            f8 += f7;
        }
        switch (this.codeType) {
            case 1:
                f = this.x * 95.0f;
                if (this.font != null) {
                    f2 = this.font.getWidthPoint(this.code.charAt(0), this.size);
                    f += f2;
                    break;
                }
                break;
            case 2:
                f4 = this.x;
                f3 = 67.0f;
                f = f4 * f3;
                break;
            case 3:
                f = this.x * 95.0f;
                if (this.font != null) {
                    f6 = this.font.getWidthPoint(this.code.charAt(0), this.size);
                    f5 = this.font.getWidthPoint(this.code.charAt(11), this.size);
                    f2 = f6 + f5;
                    f += f2;
                    break;
                }
                break;
            case 4:
                f = this.x * 51.0f;
                if (this.font != null) {
                    f6 = this.font.getWidthPoint(this.code.charAt(0), this.size);
                    f5 = this.font.getWidthPoint(this.code.charAt(7), this.size);
                    f2 = f6 + f5;
                    f += f2;
                    break;
                }
                break;
            case 5:
                f4 = this.x;
                f3 = 20.0f;
                f = f4 * f3;
                break;
            case 6:
                f4 = this.x;
                f3 = 47.0f;
                f = f4 * f3;
                break;
            default:
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.type", new Object[0]));
        }
        return new Rectangle(f, f8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f5  */
    @Override // com.itextpdf.text.pdf.Barcode
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle placeBarcode(com.itextpdf.text.pdf.PdfContentByte r18, com.itextpdf.text.BaseColor r19, com.itextpdf.text.BaseColor r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            com.itextpdf.text.Rectangle r3 = r17.getBarcodeSize()
            com.itextpdf.text.pdf.BaseFont r4 = r0.font
            r5 = 3
            r6 = 0
            if (r4 == 0) goto L_0x0029
            float r4 = r0.baseline
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x001c
            float r4 = r0.barHeight
            float r7 = r0.baseline
            float r4 = r4 - r7
            goto L_0x002a
        L_0x001c:
            com.itextpdf.text.pdf.BaseFont r4 = r0.font
            float r7 = r0.size
            float r4 = r4.getFontDescriptor(r5, r7)
            float r4 = -r4
            float r7 = r0.baseline
            float r7 = r7 + r4
            goto L_0x002b
        L_0x0029:
            r4 = 0
        L_0x002a:
            r7 = 0
        L_0x002b:
            int r8 = r0.codeType
            r9 = 0
            r10 = 1
            if (r8 == r10) goto L_0x0037
            if (r8 == r5) goto L_0x0037
            r5 = 4
            if (r8 == r5) goto L_0x0037
            goto L_0x004b
        L_0x0037:
            com.itextpdf.text.pdf.BaseFont r5 = r0.font
            if (r5 == 0) goto L_0x004b
            com.itextpdf.text.pdf.BaseFont r5 = r0.font
            java.lang.String r8 = r0.code
            char r8 = r8.charAt(r9)
            float r11 = r0.size
            float r5 = r5.getWidthPoint(r8, r11)
            float r5 = r5 + r6
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            r8 = 0
            int[] r11 = com.itextpdf.text.pdf.BarcodeEAN.GUARD_EMPTY
            int r12 = r0.codeType
            switch(r12) {
                case 1: goto L_0x008f;
                case 2: goto L_0x0086;
                case 3: goto L_0x006c;
                case 4: goto L_0x0063;
                case 5: goto L_0x005c;
                case 6: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0097
        L_0x0055:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsSupplemental5(r8)
            goto L_0x0097
        L_0x005c:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsSupplemental2(r8)
            goto L_0x0097
        L_0x0063:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsUPCE(r8)
            int[] r11 = com.itextpdf.text.pdf.BarcodeEAN.GUARD_UPCE
            goto L_0x0097
        L_0x006c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r11 = "0"
            r8.append(r11)
            java.lang.String r11 = r0.code
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            byte[] r8 = getBarsEAN13(r8)
            int[] r11 = com.itextpdf.text.pdf.BarcodeEAN.GUARD_UPCA
            goto L_0x0097
        L_0x0086:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsEAN8(r8)
            int[] r11 = com.itextpdf.text.pdf.BarcodeEAN.GUARD_EAN8
            goto L_0x0097
        L_0x008f:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsEAN13(r8)
            int[] r11 = com.itextpdf.text.pdf.BarcodeEAN.GUARD_EAN13
        L_0x0097:
            com.itextpdf.text.pdf.BaseFont r12 = r0.font
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 == 0) goto L_0x00ab
            float r12 = r0.baseline
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ab
            boolean r12 = r0.guardBars
            if (r12 == 0) goto L_0x00ab
            float r12 = r0.baseline
            float r12 = r12 / r13
            goto L_0x00ac
        L_0x00ab:
            r12 = 0
        L_0x00ac:
            if (r19 == 0) goto L_0x00b1
            r18.setColorFill(r19)
        L_0x00b1:
            r9 = r5
            r14 = 0
            r15 = 1
        L_0x00b4:
            int r10 = r8.length
            if (r14 >= r10) goto L_0x00ee
            byte r10 = r8[r14]
            float r10 = (float) r10
            float r6 = r0.x
            float r10 = r10 * r6
            if (r15 == 0) goto L_0x00e1
            int r6 = java.util.Arrays.binarySearch(r11, r14)
            if (r6 < 0) goto L_0x00d5
            float r6 = r7 - r12
            float r13 = r0.inkSpreading
            float r13 = r10 - r13
            r16 = r8
            float r8 = r0.barHeight
            float r8 = r8 + r12
            r1.rectangle(r9, r6, r13, r8)
            goto L_0x00e3
        L_0x00d5:
            r16 = r8
            float r6 = r0.inkSpreading
            float r6 = r10 - r6
            float r8 = r0.barHeight
            r1.rectangle(r9, r7, r6, r8)
            goto L_0x00e3
        L_0x00e1:
            r16 = r8
        L_0x00e3:
            r15 = r15 ^ 1
            float r9 = r9 + r10
            int r14 = r14 + 1
            r8 = r16
            r6 = 0
            r13 = 1073741824(0x40000000, float:2.0)
            goto L_0x00b4
        L_0x00ee:
            r18.fill()
            com.itextpdf.text.pdf.BaseFont r6 = r0.font
            if (r6 == 0) goto L_0x023f
            if (r2 == 0) goto L_0x00fa
            r1.setColorFill(r2)
        L_0x00fa:
            r18.beginText()
            com.itextpdf.text.pdf.BaseFont r2 = r0.font
            float r6 = r0.size
            r1.setFontAndSize(r2, r6)
            int r2 = r0.codeType
            r6 = 8
            switch(r2) {
                case 1: goto L_0x0201;
                case 2: goto L_0x01da;
                case 3: goto L_0x018b;
                case 4: goto L_0x013c;
                case 5: goto L_0x010d;
                case 6: goto L_0x010d;
                default: goto L_0x010b;
            }
        L_0x010b:
            goto L_0x023c
        L_0x010d:
            r9 = 0
        L_0x010e:
            java.lang.String r2 = r0.code
            int r2 = r2.length()
            if (r9 >= r2) goto L_0x023c
            java.lang.String r2 = r0.code
            int r5 = r9 + 1
            java.lang.String r2 = r2.substring(r9, r5)
            com.itextpdf.text.pdf.BaseFont r6 = r0.font
            float r7 = r0.size
            float r6 = r6.getWidthPoint(r2, r7)
            r7 = 1089470464(0x40f00000, float:7.5)
            int r9 = r9 * 9
            float r8 = (float) r9
            float r8 = r8 + r7
            float r7 = r0.x
            float r8 = r8 * r7
            r7 = 1073741824(0x40000000, float:2.0)
            float r6 = r6 / r7
            float r8 = r8 - r6
            r1.setTextMatrix(r8, r4)
            r1.showText(r2)
            r9 = r5
            goto L_0x010e
        L_0x013c:
            r2 = 0
            r1.setTextMatrix(r2, r4)
            java.lang.String r2 = r0.code
            r7 = 0
            r8 = 1
            java.lang.String r2 = r2.substring(r7, r8)
            r1.showText(r2)
            r10 = 1
        L_0x014c:
            r2 = 7
            if (r10 >= r2) goto L_0x0176
            java.lang.String r2 = r0.code
            int r7 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r7)
            com.itextpdf.text.pdf.BaseFont r8 = r0.font
            float r9 = r0.size
            float r8 = r8.getWidthPoint(r2, r9)
            float[] r9 = com.itextpdf.text.pdf.BarcodeEAN.TEXTPOS_EAN13
            int r10 = r10 + -1
            r9 = r9[r10]
            float r10 = r0.x
            float r9 = r9 * r10
            float r9 = r9 + r5
            r10 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r10
            float r9 = r9 - r8
            r1.setTextMatrix(r9, r4)
            r1.showText(r2)
            r10 = r7
            goto L_0x014c
        L_0x0176:
            float r7 = r0.x
            r8 = 1112276992(0x424c0000, float:51.0)
            float r7 = r7 * r8
            float r5 = r5 + r7
            r1.setTextMatrix(r5, r4)
            java.lang.String r4 = r0.code
            java.lang.String r2 = r4.substring(r2, r6)
            r1.showText(r2)
            goto L_0x023c
        L_0x018b:
            r2 = 0
            r1.setTextMatrix(r2, r4)
            java.lang.String r2 = r0.code
            r6 = 0
            r7 = 1
            java.lang.String r2 = r2.substring(r6, r7)
            r1.showText(r2)
            r10 = 1
        L_0x019b:
            r2 = 11
            if (r10 >= r2) goto L_0x01c4
            java.lang.String r2 = r0.code
            int r6 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r6)
            com.itextpdf.text.pdf.BaseFont r7 = r0.font
            float r8 = r0.size
            float r7 = r7.getWidthPoint(r2, r8)
            float[] r8 = com.itextpdf.text.pdf.BarcodeEAN.TEXTPOS_EAN13
            r8 = r8[r10]
            float r9 = r0.x
            float r8 = r8 * r9
            float r8 = r8 + r5
            r9 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r9
            float r8 = r8 - r7
            r1.setTextMatrix(r8, r4)
            r1.showText(r2)
            r10 = r6
            goto L_0x019b
        L_0x01c4:
            float r6 = r0.x
            r7 = 1119748096(0x42be0000, float:95.0)
            float r6 = r6 * r7
            float r5 = r5 + r6
            r1.setTextMatrix(r5, r4)
            java.lang.String r4 = r0.code
            r5 = 12
            java.lang.String r2 = r4.substring(r2, r5)
            r1.showText(r2)
            goto L_0x023c
        L_0x01da:
            r9 = 0
        L_0x01db:
            if (r9 >= r6) goto L_0x023c
            java.lang.String r2 = r0.code
            int r5 = r9 + 1
            java.lang.String r2 = r2.substring(r9, r5)
            com.itextpdf.text.pdf.BaseFont r7 = r0.font
            float r8 = r0.size
            float r7 = r7.getWidthPoint(r2, r8)
            float[] r8 = com.itextpdf.text.pdf.BarcodeEAN.TEXTPOS_EAN8
            r8 = r8[r9]
            float r9 = r0.x
            float r8 = r8 * r9
            r9 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r9
            float r8 = r8 - r7
            r1.setTextMatrix(r8, r4)
            r1.showText(r2)
            r9 = r5
            goto L_0x01db
        L_0x0201:
            r2 = 0
            r1.setTextMatrix(r2, r4)
            java.lang.String r2 = r0.code
            r6 = 0
            r7 = 1
            java.lang.String r2 = r2.substring(r6, r7)
            r1.showText(r2)
            r10 = 1
        L_0x0211:
            r2 = 13
            if (r10 >= r2) goto L_0x023c
            java.lang.String r2 = r0.code
            int r6 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r6)
            com.itextpdf.text.pdf.BaseFont r7 = r0.font
            float r8 = r0.size
            float r7 = r7.getWidthPoint(r2, r8)
            float[] r8 = com.itextpdf.text.pdf.BarcodeEAN.TEXTPOS_EAN13
            int r10 = r10 + -1
            r8 = r8[r10]
            float r9 = r0.x
            float r8 = r8 * r9
            float r8 = r8 + r5
            r9 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r9
            float r8 = r8 - r7
            r1.setTextMatrix(r8, r4)
            r1.showText(r2)
            r10 = r6
            goto L_0x0211
        L_0x023c:
            r18.endText()
        L_0x023f:
            return r3
            switch-data {1->0x008f, 2->0x0086, 3->0x006c, 4->0x0063, 5->0x005c, 6->0x0055, }
            switch-data {1->0x0201, 2->0x01da, 3->0x018b, 4->0x013c, 5->0x010d, 6->0x010d, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BarcodeEAN.placeBarcode(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.BaseColor, com.itextpdf.text.BaseColor):com.itextpdf.text.Rectangle");
    }
}
