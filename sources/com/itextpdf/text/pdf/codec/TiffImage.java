package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

public class TiffImage {
    public static int getNumberOfPages(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            return TIFFDirectory.getNumDirectories(randomAccessFileOrArray);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    static int getDpi(TIFFField tIFFField, int i) {
        double d;
        if (tIFFField == null) {
            return 0;
        }
        long[] asRational = tIFFField.getAsRational(0);
        float f = ((float) asRational[0]) / ((float) asRational[1]);
        if (i == 1 || i == 2) {
            d = (double) f;
        } else if (i != 3) {
            return 0;
        } else {
            d = ((double) f) * 2.54d;
        }
        return (int) (d + 0.5d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01cd A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x031b A[SYNTHETIC, Splitter:B:148:0x031b] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084 A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009b A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6 A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1 A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7 A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ba A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d0 A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0107 A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010e A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011c A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012c A[Catch:{ Exception -> 0x034d }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x018a A[ADDED_TO_REGION, Catch:{ Exception -> 0x034d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Image getTiffImage(com.itextpdf.text.pdf.RandomAccessFileOrArray r46, boolean r47, int r48, boolean r49) {
        /*
            r1 = r46
            r2 = r47
            r0 = r48
            r3 = 1
            r4 = 0
            if (r0 < r3) goto L_0x0354
            com.itextpdf.text.pdf.codec.TIFFDirectory r5 = new com.itextpdf.text.pdf.codec.TIFFDirectory     // Catch:{ Exception -> 0x034d }
            int r0 = r0 - r3
            r5.<init>(r1, r0)     // Catch:{ Exception -> 0x034d }
            r0 = 322(0x142, float:4.51E-43)
            boolean r0 = r5.isTagPresent(r0)     // Catch:{ Exception -> 0x034d }
            if (r0 != 0) goto L_0x033e
            r0 = 259(0x103, float:3.63E-43)
            long r6 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x034d }
            int r7 = (int) r6     // Catch:{ Exception -> 0x034d }
            r6 = 32771(0x8003, float:4.5922E-41)
            r8 = 4
            r9 = 3
            r10 = 2
            if (r7 == r10) goto L_0x0032
            if (r7 == r9) goto L_0x0032
            if (r7 == r8) goto L_0x0032
            if (r7 == r6) goto L_0x0032
            com.itextpdf.text.Image r0 = getTiffImageColor(r5, r1)     // Catch:{ Exception -> 0x034d }
            return r0
        L_0x0032:
            r0 = 274(0x112, float:3.84E-43)
            boolean r11 = r5.isTagPresent(r0)     // Catch:{ Exception -> 0x034d }
            r12 = 8
            r13 = 5
            if (r11 == 0) goto L_0x0067
            long r14 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x034d }
            int r0 = (int) r14     // Catch:{ Exception -> 0x034d }
            if (r0 == r9) goto L_0x0060
            if (r0 != r8) goto L_0x0047
            goto L_0x0060
        L_0x0047:
            if (r0 == r13) goto L_0x0059
            if (r0 != r12) goto L_0x004c
            goto L_0x0059
        L_0x004c:
            r11 = 6
            if (r0 == r11) goto L_0x0052
            r11 = 7
            if (r0 != r11) goto L_0x0067
        L_0x0052:
            r0 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            r11 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x0068
        L_0x0059:
            r0 = 1070141403(0x3fc90fdb, float:1.5707964)
            r11 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x0068
        L_0x0060:
            r0 = 1078530011(0x40490fdb, float:3.1415927)
            r11 = 1078530011(0x40490fdb, float:3.1415927)
            goto L_0x0068
        L_0x0067:
            r11 = 0
        L_0x0068:
            r0 = 257(0x101, float:3.6E-43)
            long r14 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x034d }
            int r15 = (int) r14     // Catch:{ Exception -> 0x034d }
            r14 = 256(0x100, float:3.59E-43)
            long r12 = r5.getFieldAsLong(r14)     // Catch:{ Exception -> 0x034d }
            int r13 = (int) r12     // Catch:{ Exception -> 0x034d }
            r12 = 296(0x128, float:4.15E-43)
            boolean r17 = r5.isTagPresent(r12)     // Catch:{ Exception -> 0x034d }
            if (r17 == 0) goto L_0x0084
            long r0 = r5.getFieldAsLong(r12)     // Catch:{ Exception -> 0x034d }
            int r1 = (int) r0     // Catch:{ Exception -> 0x034d }
            goto L_0x0085
        L_0x0084:
            r1 = 2
        L_0x0085:
            r0 = 282(0x11a, float:3.95E-43)
            com.itextpdf.text.pdf.codec.TIFFField r0 = r5.getField(r0)     // Catch:{ Exception -> 0x034d }
            int r0 = getDpi(r0, r1)     // Catch:{ Exception -> 0x034d }
            r12 = 283(0x11b, float:3.97E-43)
            com.itextpdf.text.pdf.codec.TIFFField r12 = r5.getField(r12)     // Catch:{ Exception -> 0x034d }
            int r12 = getDpi(r12, r1)     // Catch:{ Exception -> 0x034d }
            if (r1 != r3) goto L_0x00a6
            if (r12 == 0) goto L_0x00a1
            float r0 = (float) r0     // Catch:{ Exception -> 0x034d }
            float r1 = (float) r12     // Catch:{ Exception -> 0x034d }
            float r0 = r0 / r1
            goto L_0x00a2
        L_0x00a1:
            r0 = 0
        L_0x00a2:
            r12 = r0
            r1 = 0
            r14 = 0
            goto L_0x00a9
        L_0x00a6:
            r1 = r0
            r14 = r12
            r12 = 0
        L_0x00a9:
            r0 = 278(0x116, float:3.9E-43)
            boolean r19 = r5.isTagPresent(r0)     // Catch:{ Exception -> 0x034d }
            if (r19 == 0) goto L_0x00b7
            long r8 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x034d }
            int r0 = (int) r8     // Catch:{ Exception -> 0x034d }
            goto L_0x00b8
        L_0x00b7:
            r0 = r15
        L_0x00b8:
            if (r0 <= 0) goto L_0x00bf
            if (r0 <= r15) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r8 = r0
            goto L_0x00c0
        L_0x00bf:
            r8 = r15
        L_0x00c0:
            r0 = 273(0x111, float:3.83E-43)
            long[] r9 = getArrayLongShort(r5, r0)     // Catch:{ Exception -> 0x034d }
            r0 = 279(0x117, float:3.91E-43)
            long[] r0 = getArrayLongShort(r5, r0)     // Catch:{ Exception -> 0x034d }
            r22 = 0
            if (r0 == 0) goto L_0x00e7
            int r6 = r0.length     // Catch:{ Exception -> 0x034d }
            if (r6 != r3) goto L_0x00fa
            r24 = r0[r4]     // Catch:{ Exception -> 0x034d }
            int r6 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r6 == 0) goto L_0x00e7
            r24 = r0[r4]     // Catch:{ Exception -> 0x034d }
            r26 = r9[r4]     // Catch:{ Exception -> 0x034d }
            long r24 = r24 + r26
            long r26 = r46.length()     // Catch:{ Exception -> 0x034d }
            int r6 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1))
            if (r6 <= 0) goto L_0x00fa
        L_0x00e7:
            if (r15 != r8) goto L_0x00fa
            long[] r0 = new long[r3]     // Catch:{ Exception -> 0x034d }
            long r24 = r46.length()     // Catch:{ Exception -> 0x034d }
            r26 = r11
            r10 = r9[r4]     // Catch:{ Exception -> 0x034d }
            int r11 = (int) r10     // Catch:{ Exception -> 0x034d }
            long r10 = (long) r11     // Catch:{ Exception -> 0x034d }
            long r24 = r24 - r10
            r0[r4] = r24     // Catch:{ Exception -> 0x034d }
            goto L_0x00fc
        L_0x00fa:
            r26 = r11
        L_0x00fc:
            r10 = r0
            r0 = 266(0x10a, float:3.73E-43)
            com.itextpdf.text.pdf.codec.TIFFField r0 = r5.getField(r0)     // Catch:{ Exception -> 0x034d }
            r24 = 1
            if (r0 == 0) goto L_0x010e
            long r27 = r0.getAsLong(r4)     // Catch:{ Exception -> 0x034d }
            r3 = r27
            goto L_0x0110
        L_0x010e:
            r3 = r24
        L_0x0110:
            r28 = 2
            int r0 = (r3 > r28 ? 1 : (r3 == r28 ? 0 : -1))
            r0 = 262(0x106, float:3.67E-43)
            boolean r28 = r5.isTagPresent(r0)     // Catch:{ Exception -> 0x034d }
            if (r28 == 0) goto L_0x0126
            long r28 = r5.getFieldAsLong(r0)     // Catch:{ Exception -> 0x034d }
            int r0 = (r28 > r24 ? 1 : (r28 == r24 ? 0 : -1))
            if (r0 != 0) goto L_0x0126
            r0 = 1
            goto L_0x0127
        L_0x0126:
            r0 = 0
        L_0x0127:
            r28 = 4
            r6 = 2
            if (r7 == r6) goto L_0x017f
            r6 = 3
            if (r7 == r6) goto L_0x0156
            r6 = 4
            if (r7 == r6) goto L_0x013f
            r6 = 32771(0x8003, float:4.5922E-41)
            if (r7 == r6) goto L_0x017f
            r24 = r22
            r31 = r24
            r6 = 0
        L_0x013c:
            r22 = r0
            goto L_0x0188
        L_0x013f:
            r6 = 293(0x125, float:4.1E-43)
            com.itextpdf.text.pdf.codec.TIFFField r6 = r5.getField(r6)     // Catch:{ Exception -> 0x034d }
            if (r6 == 0) goto L_0x014f
            r11 = 0
            long r24 = r6.getAsLong(r11)     // Catch:{ Exception -> 0x034d }
            r31 = r22
            goto L_0x0153
        L_0x014f:
            r24 = r22
            r31 = r24
        L_0x0153:
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x013c
        L_0x0156:
            r0 = r0 | 12
            r6 = 292(0x124, float:4.09E-43)
            com.itextpdf.text.pdf.codec.TIFFField r6 = r5.getField(r6)     // Catch:{ Exception -> 0x034d }
            if (r6 == 0) goto L_0x0181
            r11 = 0
            long r31 = r6.getAsLong(r11)     // Catch:{ Exception -> 0x034d }
            long r24 = r31 & r24
            int r6 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r6 == 0) goto L_0x0170
            r6 = 258(0x102, float:3.62E-43)
            r17 = 258(0x102, float:3.62E-43)
            goto L_0x0172
        L_0x0170:
            r17 = 257(0x101, float:3.6E-43)
        L_0x0172:
            long r24 = r31 & r28
            int r6 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r6 == 0) goto L_0x017a
            r0 = r0 | 2
        L_0x017a:
            r6 = r17
            r24 = r22
            goto L_0x013c
        L_0x017f:
            r0 = r0 | 10
        L_0x0181:
            r24 = r22
            r31 = r24
            r6 = 257(0x101, float:3.6E-43)
            goto L_0x013c
        L_0x0188:
            if (r49 == 0) goto L_0x01b9
            if (r8 != r15) goto L_0x01b9
            r11 = 0
            r2 = r10[r11]     // Catch:{ Exception -> 0x034d }
            int r0 = (int) r2     // Catch:{ Exception -> 0x034d }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x034d }
            r2 = r9[r11]     // Catch:{ Exception -> 0x034d }
            r4 = r46
            r4.seek(r2)     // Catch:{ Exception -> 0x034d }
            r4.readFully(r0)     // Catch:{ Exception -> 0x034d }
            r18 = 0
            r16 = r13
            r17 = r15
            r19 = r6
            r20 = r22
            r21 = r0
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.getInstance(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x034d }
            r2 = 1
            r0.setInverted(r2)     // Catch:{ Exception -> 0x034d }
            r2 = r1
            r23 = r5
            r9 = r12
            r7 = r14
            r10 = r26
            goto L_0x030a
        L_0x01b9:
            r11 = r46
            r23 = r5
            com.itextpdf.text.pdf.codec.CCITTG4Encoder r5 = new com.itextpdf.text.pdf.codec.CCITTG4Encoder     // Catch:{ Exception -> 0x034d }
            r5.<init>(r13)     // Catch:{ Exception -> 0x034d }
            r41 = r1
            r40 = r12
            r1 = r15
            r17 = r31
            r12 = 0
        L_0x01ca:
            int r0 = r9.length     // Catch:{ Exception -> 0x034d }
            if (r12 >= r0) goto L_0x02ed
            r42 = r14
            r43 = r15
            r14 = r10[r12]     // Catch:{ Exception -> 0x034d }
            int r0 = (int) r14     // Catch:{ Exception -> 0x034d }
            byte[] r14 = new byte[r0]     // Catch:{ Exception -> 0x034d }
            r49 = r5
            r15 = r6
            r5 = r9[r12]     // Catch:{ Exception -> 0x034d }
            r11.seek(r5)     // Catch:{ Exception -> 0x034d }
            r11.readFully(r14)     // Catch:{ Exception -> 0x034d }
            int r5 = java.lang.Math.min(r8, r1)     // Catch:{ Exception -> 0x034d }
            com.itextpdf.text.pdf.codec.TIFFFaxDecoder r6 = new com.itextpdf.text.pdf.codec.TIFFFaxDecoder     // Catch:{ Exception -> 0x034d }
            r6.<init>(r3, r13, r5)     // Catch:{ Exception -> 0x034d }
            r6.setRecoverFromImageError(r2)     // Catch:{ Exception -> 0x034d }
            int r0 = r13 + 7
            r16 = 8
            int r0 = r0 / 8
            int r0 = r0 * r5
            r44 = r3
            byte[] r3 = new byte[r0]     // Catch:{ Exception -> 0x034d }
            r4 = 2
            if (r7 == r4) goto L_0x02ba
            r4 = 3
            if (r7 == r4) goto L_0x023e
            r4 = 4
            if (r7 == r4) goto L_0x021e
            r4 = 32771(0x8003, float:4.5922E-41)
            if (r7 == r4) goto L_0x020b
            r4 = r49
            goto L_0x0267
        L_0x020b:
            r4 = r49
            r30 = r9
            r31 = r10
            r10 = r26
            r9 = r40
            r2 = r41
            r11 = 0
            r26 = r7
            r7 = r42
            goto L_0x02cb
        L_0x021e:
            r4 = 32771(0x8003, float:4.5922E-41)
            r36 = 0
            r33 = r6
            r34 = r3
            r35 = r14
            r37 = r5
            r38 = r24
            r33.decodeT6(r34, r35, r36, r37, r38)     // Catch:{ InvalidImageException -> 0x0233 }
        L_0x0230:
            r6 = r49
            goto L_0x0238
        L_0x0233:
            r0 = move-exception
            r6 = r0
            if (r2 == 0) goto L_0x023d
            goto L_0x0230
        L_0x0238:
            r6.fax4Encode(r3, r5)
            r4 = r6
            goto L_0x0267
        L_0x023d:
            throw r6
        L_0x023e:
            r4 = r49
            r34 = 0
            r31 = r6
            r32 = r3
            r33 = r14
            r35 = r5
            r36 = r17
            r31.decode2D(r32, r33, r34, r35, r36)     // Catch:{ RuntimeException -> 0x0250 }
            goto L_0x0264
        L_0x0250:
            r0 = move-exception
            r38 = r0
            long r17 = r17 ^ r28
            r34 = 0
            r31 = r6
            r32 = r3
            r33 = r14
            r35 = r5
            r36 = r17
            r31.decode2D(r32, r33, r34, r35, r36)     // Catch:{ RuntimeException -> 0x0276 }
        L_0x0264:
            r4.fax4Encode(r3, r5)
        L_0x0267:
            r30 = r9
            r31 = r10
            r10 = r26
            r9 = r40
            r2 = r41
            r26 = r7
            r7 = r42
            goto L_0x02d1
        L_0x0276:
            if (r2 == 0) goto L_0x02b9
            r1 = 1
            if (r8 == r1) goto L_0x02b8
            r2 = 0
            r3 = r10[r2]
            int r0 = (int) r3
            byte[] r0 = new byte[r0]
            r2 = r9[r2]
            r11.seek(r2)
            r11.readFully(r0)
            r18 = 0
            r16 = r13
            r17 = r43
            r19 = r15
            r20 = r22
            r21 = r0
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.getInstance(r16, r17, r18, r19, r20, r21)
            r1 = 1
            r0.setInverted(r1)
            r1 = r41
            r2 = r42
            r0.setDpi(r1, r2)
            r1 = r40
            r0.setXYRatio(r1)
            r1 = 5
            r0.setOriginalType(r1)
            r1 = 0
            int r1 = (r26 > r1 ? 1 : (r26 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x02b7
            r1 = r26
            r0.setInitialRotation(r1)
        L_0x02b7:
            return r0
        L_0x02b8:
            throw r38
        L_0x02b9:
            throw r38
        L_0x02ba:
            r4 = r49
            r30 = r9
            r31 = r10
            r10 = r26
            r9 = r40
            r2 = r41
            r26 = r7
            r7 = r42
            r11 = 0
        L_0x02cb:
            r6.decode1D(r3, r14, r11, r5)
            r4.fax4Encode(r3, r5)
        L_0x02d1:
            int r1 = r1 - r8
            int r12 = r12 + 1
            r11 = r46
            r41 = r2
            r5 = r4
            r14 = r7
            r40 = r9
            r6 = r15
            r7 = r26
            r9 = r30
            r15 = r43
            r3 = r44
            r2 = r47
            r26 = r10
            r10 = r31
            goto L_0x01ca
        L_0x02ed:
            r4 = r5
            r7 = r14
            r43 = r15
            r10 = r26
            r9 = r40
            r2 = r41
            byte[] r21 = r4.close()
            r18 = 0
            r19 = 256(0x100, float:3.59E-43)
            r1 = 1
            r20 = r22 & 1
            r16 = r13
            r17 = r43
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.getInstance(r16, r17, r18, r19, r20, r21)
        L_0x030a:
            r0.setDpi(r2, r7)
            r0.setXYRatio(r9)
            r1 = 34675(0x8773, float:4.859E-41)
            r2 = r23
            boolean r3 = r2.isTagPresent(r1)
            if (r3 == 0) goto L_0x0331
            com.itextpdf.text.pdf.codec.TIFFField r1 = r2.getField(r1)     // Catch:{ RuntimeException -> 0x0331 }
            byte[] r1 = r1.getAsBytes()     // Catch:{ RuntimeException -> 0x0331 }
            com.itextpdf.text.pdf.ICC_Profile r1 = com.itextpdf.text.pdf.ICC_Profile.getInstance(r1)     // Catch:{ RuntimeException -> 0x0331 }
            int r2 = r1.getNumComponents()     // Catch:{ RuntimeException -> 0x0331 }
            r3 = 1
            if (r2 != r3) goto L_0x0331
            r0.tagICC(r1)     // Catch:{ RuntimeException -> 0x0331 }
        L_0x0331:
            r1 = 5
            r0.setOriginalType(r1)
            r1 = 0
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x033d
            r0.setInitialRotation(r10)
        L_0x033d:
            return r0
        L_0x033e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "tiles.are.not.supported"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x034d:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x0354:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "the.page.number.must.be.gt.eq.1"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r2, r1)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TiffImage.getTiffImage(com.itextpdf.text.pdf.RandomAccessFileOrArray, boolean, int, boolean):com.itextpdf.text.Image");
    }

    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, boolean z, int i) {
        return getTiffImage(randomAccessFileOrArray, z, i, false);
    }

    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
        return getTiffImage(randomAccessFileOrArray, i, false);
    }

    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, int i, boolean z) {
        return getTiffImage(randomAccessFileOrArray, false, i, z);
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.itextpdf.text.Jpeg} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: com.itextpdf.text.ImgRaw} */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0197 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01a9 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ac A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01bf A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01cb A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01d1 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01d5 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01e6 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x022d A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x027b A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0415 A[SYNTHETIC, Splitter:B:226:0x0415] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0433  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x04d3  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x04da  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b1 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b7 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c0 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c8 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d3 A[Catch:{ Exception -> 0x04f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d4 A[Catch:{ Exception -> 0x04f2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.itextpdf.text.Image getTiffImageColor(com.itextpdf.text.pdf.codec.TIFFDirectory r39, com.itextpdf.text.pdf.RandomAccessFileOrArray r40) {
        /*
            r0 = r39
            r1 = r40
            r2 = 259(0x103, float:3.63E-43)
            long r2 = r0.getFieldAsLong(r2)     // Catch:{ Exception -> 0x04f2 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x04f2 }
            r2 = 32773(0x8005, float:4.5925E-41)
            r4 = 32946(0x80b2, float:4.6167E-41)
            r5 = 6
            r6 = 7
            r7 = 5
            r8 = 8
            r9 = 1
            if (r3 == r9) goto L_0x0032
            if (r3 == r2) goto L_0x0032
            if (r3 == r4) goto L_0x0032
            if (r3 == r7) goto L_0x0032
            if (r3 == r5) goto L_0x0032
            if (r3 == r6) goto L_0x0032
            if (r3 != r8) goto L_0x0026
            goto L_0x0032
        L_0x0026:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = "the.compression.1.is.not.supported"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r3)     // Catch:{ Exception -> 0x04f2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f2 }
            throw r0     // Catch:{ Exception -> 0x04f2 }
        L_0x0032:
            r10 = 262(0x106, float:3.67E-43)
            long r10 = r0.getFieldAsLong(r10)     // Catch:{ Exception -> 0x04f2 }
            int r11 = (int) r10     // Catch:{ Exception -> 0x04f2 }
            r10 = 3
            r12 = 2
            if (r11 == 0) goto L_0x0056
            if (r11 == r9) goto L_0x0056
            if (r11 == r12) goto L_0x0056
            if (r11 == r10) goto L_0x0056
            if (r11 == r7) goto L_0x0056
            if (r3 == r5) goto L_0x0056
            if (r3 != r6) goto L_0x004a
            goto L_0x0056
        L_0x004a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = "the.photometric.1.is.not.supported"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r11)     // Catch:{ Exception -> 0x04f2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f2 }
            throw r0     // Catch:{ Exception -> 0x04f2 }
        L_0x0056:
            r13 = 274(0x112, float:3.84E-43)
            boolean r14 = r0.isTagPresent(r13)     // Catch:{ Exception -> 0x04f2 }
            r15 = 4
            r16 = 0
            if (r14 == 0) goto L_0x0080
            long r13 = r0.getFieldAsLong(r13)     // Catch:{ Exception -> 0x04f2 }
            int r14 = (int) r13     // Catch:{ Exception -> 0x04f2 }
            if (r14 == r10) goto L_0x007c
            if (r14 != r15) goto L_0x006b
            goto L_0x007c
        L_0x006b:
            if (r14 == r7) goto L_0x0078
            if (r14 != r8) goto L_0x0070
            goto L_0x0078
        L_0x0070:
            if (r14 == r5) goto L_0x0074
            if (r14 != r6) goto L_0x0080
        L_0x0074:
            r13 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x0081
        L_0x0078:
            r13 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x0081
        L_0x007c:
            r13 = 1078530011(0x40490fdb, float:3.1415927)
            goto L_0x0081
        L_0x0080:
            r13 = 0
        L_0x0081:
            r14 = 284(0x11c, float:3.98E-43)
            boolean r17 = r0.isTagPresent(r14)     // Catch:{ Exception -> 0x04f2 }
            r2 = 0
            if (r17 == 0) goto L_0x00a3
            long r18 = r0.getFieldAsLong(r14)     // Catch:{ Exception -> 0x04f2 }
            r20 = 2
            int r14 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r14 == 0) goto L_0x0095
            goto L_0x00a3
        L_0x0095:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = "planar.images.are.not.supported"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r2)     // Catch:{ Exception -> 0x04f2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f2 }
            throw r0     // Catch:{ Exception -> 0x04f2 }
        L_0x00a3:
            r14 = 338(0x152, float:4.74E-43)
            boolean r14 = r0.isTagPresent(r14)     // Catch:{ Exception -> 0x04f2 }
            r6 = 277(0x115, float:3.88E-43)
            boolean r18 = r0.isTagPresent(r6)     // Catch:{ Exception -> 0x04f2 }
            if (r18 == 0) goto L_0x00b7
            long r5 = r0.getFieldAsLong(r6)     // Catch:{ Exception -> 0x04f2 }
            int r6 = (int) r5     // Catch:{ Exception -> 0x04f2 }
            goto L_0x00b8
        L_0x00b7:
            r6 = 1
        L_0x00b8:
            r5 = 258(0x102, float:3.62E-43)
            boolean r19 = r0.isTagPresent(r5)     // Catch:{ Exception -> 0x04f2 }
            if (r19 == 0) goto L_0x00c8
            r26 = r11
            long r10 = r0.getFieldAsLong(r5)     // Catch:{ Exception -> 0x04f2 }
            int r5 = (int) r10     // Catch:{ Exception -> 0x04f2 }
            goto L_0x00cb
        L_0x00c8:
            r26 = r11
            r5 = 1
        L_0x00cb:
            if (r5 == r9) goto L_0x00e0
            if (r5 == r12) goto L_0x00e0
            if (r5 == r15) goto L_0x00e0
            if (r5 != r8) goto L_0x00d4
            goto L_0x00e0
        L_0x00d4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = "bits.per.sample.1.is.not.supported"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r5)     // Catch:{ Exception -> 0x04f2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f2 }
            throw r0     // Catch:{ Exception -> 0x04f2 }
        L_0x00e0:
            r10 = 257(0x101, float:3.6E-43)
            long r10 = r0.getFieldAsLong(r10)     // Catch:{ Exception -> 0x04f2 }
            int r11 = (int) r10     // Catch:{ Exception -> 0x04f2 }
            r10 = 256(0x100, float:3.59E-43)
            r27 = r5
            long r4 = r0.getFieldAsLong(r10)     // Catch:{ Exception -> 0x04f2 }
            int r5 = (int) r4     // Catch:{ Exception -> 0x04f2 }
            r4 = 296(0x128, float:4.15E-43)
            boolean r10 = r0.isTagPresent(r4)     // Catch:{ Exception -> 0x04f2 }
            if (r10 == 0) goto L_0x00fe
            long r7 = r0.getFieldAsLong(r4)     // Catch:{ Exception -> 0x04f2 }
            int r4 = (int) r7     // Catch:{ Exception -> 0x04f2 }
            goto L_0x00ff
        L_0x00fe:
            r4 = 2
        L_0x00ff:
            r7 = 282(0x11a, float:3.95E-43)
            com.itextpdf.text.pdf.codec.TIFFField r7 = r0.getField(r7)     // Catch:{ Exception -> 0x04f2 }
            int r7 = getDpi(r7, r4)     // Catch:{ Exception -> 0x04f2 }
            r8 = 283(0x11b, float:3.97E-43)
            com.itextpdf.text.pdf.codec.TIFFField r8 = r0.getField(r8)     // Catch:{ Exception -> 0x04f2 }
            int r4 = getDpi(r8, r4)     // Catch:{ Exception -> 0x04f2 }
            r8 = 266(0x10a, float:3.73E-43)
            com.itextpdf.text.pdf.codec.TIFFField r8 = r0.getField(r8)     // Catch:{ Exception -> 0x04f2 }
            if (r8 == 0) goto L_0x0120
            int r8 = r8.getAsInt(r2)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x0121
        L_0x0120:
            r8 = 1
        L_0x0121:
            if (r8 != r12) goto L_0x0125
            r8 = 1
            goto L_0x0126
        L_0x0125:
            r8 = 0
        L_0x0126:
            r10 = 278(0x116, float:3.9E-43)
            boolean r20 = r0.isTagPresent(r10)     // Catch:{ Exception -> 0x04f2 }
            if (r20 == 0) goto L_0x0136
            r28 = r13
            long r12 = r0.getFieldAsLong(r10)     // Catch:{ Exception -> 0x04f2 }
            int r10 = (int) r12     // Catch:{ Exception -> 0x04f2 }
            goto L_0x0139
        L_0x0136:
            r28 = r13
            r10 = r11
        L_0x0139:
            if (r10 <= 0) goto L_0x0140
            if (r10 <= r11) goto L_0x013e
            goto L_0x0140
        L_0x013e:
            r12 = r10
            goto L_0x0141
        L_0x0140:
            r12 = r11
        L_0x0141:
            r10 = 273(0x111, float:3.83E-43)
            long[] r13 = getArrayLongShort(r0, r10)     // Catch:{ Exception -> 0x04f2 }
            r10 = 279(0x117, float:3.91E-43)
            long[] r10 = getArrayLongShort(r0, r10)     // Catch:{ Exception -> 0x04f2 }
            if (r10 == 0) goto L_0x0168
            int r15 = r10.length     // Catch:{ Exception -> 0x04f2 }
            if (r15 != r9) goto L_0x017b
            r22 = r10[r2]     // Catch:{ Exception -> 0x04f2 }
            r24 = 0
            int r15 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r15 == 0) goto L_0x0168
            r22 = r10[r2]     // Catch:{ Exception -> 0x04f2 }
            r24 = r13[r2]     // Catch:{ Exception -> 0x04f2 }
            long r22 = r22 + r24
            long r24 = r40.length()     // Catch:{ Exception -> 0x04f2 }
            int r15 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r15 <= 0) goto L_0x017b
        L_0x0168:
            if (r11 != r12) goto L_0x017b
            long[] r10 = new long[r9]     // Catch:{ Exception -> 0x04f2 }
            long r22 = r40.length()     // Catch:{ Exception -> 0x04f2 }
            r15 = r10
            r9 = r13[r2]     // Catch:{ Exception -> 0x04f2 }
            int r10 = (int) r9     // Catch:{ Exception -> 0x04f2 }
            long r9 = (long) r10     // Catch:{ Exception -> 0x04f2 }
            long r22 = r22 - r9
            r15[r2] = r22     // Catch:{ Exception -> 0x04f2 }
            r9 = r15
            goto L_0x017c
        L_0x017b:
            r9 = r10
        L_0x017c:
            r10 = 5
            if (r3 == r10) goto L_0x0188
            r15 = 32946(0x80b2, float:4.6167E-41)
            if (r3 == r15) goto L_0x0188
            r10 = 8
            if (r3 != r10) goto L_0x01c3
        L_0x0188:
            r10 = 317(0x13d, float:4.44E-43)
            com.itextpdf.text.pdf.codec.TIFFField r10 = r0.getField(r10)     // Catch:{ Exception -> 0x04f2 }
            if (r10 == 0) goto L_0x01c3
            int r10 = r10.getAsInt(r2)     // Catch:{ Exception -> 0x04f2 }
            r15 = 1
            if (r10 == r15) goto L_0x01a9
            r15 = 2
            if (r10 != r15) goto L_0x019b
            goto L_0x01aa
        L_0x019b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = "illegal.value.for.predictor.in.tiff.file"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r2)     // Catch:{ Exception -> 0x04f2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f2 }
            throw r0     // Catch:{ Exception -> 0x04f2 }
        L_0x01a9:
            r15 = 2
        L_0x01aa:
            if (r10 != r15) goto L_0x01bf
            r15 = r27
            r2 = 8
            if (r15 != r2) goto L_0x01b3
            goto L_0x01c1
        L_0x01b3:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = "1.bit.samples.are.not.supported.for.horizontal.differencing.predictor"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r15)     // Catch:{ Exception -> 0x04f2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f2 }
            throw r0     // Catch:{ Exception -> 0x04f2 }
        L_0x01bf:
            r15 = r27
        L_0x01c1:
            r2 = r10
            goto L_0x01c6
        L_0x01c3:
            r15 = r27
            r2 = 1
        L_0x01c6:
            r29 = 0
            r10 = 5
            if (r3 != r10) goto L_0x01d1
            com.itextpdf.text.pdf.codec.TIFFLZWDecoder r10 = new com.itextpdf.text.pdf.codec.TIFFLZWDecoder     // Catch:{ Exception -> 0x04f2 }
            r10.<init>(r5, r2, r6)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x01d3
        L_0x01d1:
            r10 = r29
        L_0x01d3:
            if (r14 <= 0) goto L_0x01e6
            r22 = r10
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x04f2 }
            r10.<init>()     // Catch:{ Exception -> 0x04f2 }
            r30 = r4
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x04f2 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x04f2 }
            r31 = r10
            goto L_0x01ee
        L_0x01e6:
            r30 = r4
            r22 = r10
            r4 = r29
            r31 = r4
        L_0x01ee:
            r10 = 1
            if (r15 != r10) goto L_0x0207
            if (r6 != r10) goto L_0x0207
            r10 = r26
            r26 = r7
            r7 = 3
            if (r10 == r7) goto L_0x020b
            com.itextpdf.text.pdf.codec.CCITTG4Encoder r7 = new com.itextpdf.text.pdf.codec.CCITTG4Encoder     // Catch:{ Exception -> 0x04f2 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x04f2 }
            r32 = r11
            r33 = r29
            r34 = r33
            r11 = r7
            goto L_0x022a
        L_0x0207:
            r10 = r26
            r26 = r7
        L_0x020b:
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x04f2 }
            r7.<init>()     // Catch:{ Exception -> 0x04f2 }
            r32 = r11
            r11 = 6
            if (r3 == r11) goto L_0x0224
            r11 = 7
            if (r3 == r11) goto L_0x0224
            java.util.zip.DeflaterOutputStream r11 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x04f2 }
            r11.<init>(r7)     // Catch:{ Exception -> 0x04f2 }
            r34 = r7
            r33 = r11
            r11 = r29
            goto L_0x022a
        L_0x0224:
            r34 = r7
            r11 = r29
            r33 = r11
        L_0x022a:
            r7 = 6
            if (r3 != r7) goto L_0x027b
            r2 = 513(0x201, float:7.19E-43)
            boolean r7 = r0.isTagPresent(r2)     // Catch:{ Exception -> 0x04f2 }
            if (r7 == 0) goto L_0x026c
            long r7 = r0.getFieldAsLong(r2)     // Catch:{ Exception -> 0x04f2 }
            int r2 = (int) r7     // Catch:{ Exception -> 0x04f2 }
            long r7 = r40.length()     // Catch:{ Exception -> 0x04f2 }
            int r8 = (int) r7     // Catch:{ Exception -> 0x04f2 }
            int r8 = r8 - r2
            r7 = 514(0x202, float:7.2E-43)
            boolean r11 = r0.isTagPresent(r7)     // Catch:{ Exception -> 0x04f2 }
            if (r11 == 0) goto L_0x0252
            long r7 = r0.getFieldAsLong(r7)     // Catch:{ Exception -> 0x04f2 }
            int r8 = (int) r7     // Catch:{ Exception -> 0x04f2 }
            r7 = 0
            r11 = r9[r7]     // Catch:{ Exception -> 0x04f2 }
            int r7 = (int) r11     // Catch:{ Exception -> 0x04f2 }
            int r8 = r8 + r7
        L_0x0252:
            long r11 = r40.length()     // Catch:{ Exception -> 0x04f2 }
            int r7 = (int) r11     // Catch:{ Exception -> 0x04f2 }
            int r7 = r7 - r2
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ Exception -> 0x04f2 }
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x04f2 }
            long r8 = (long) r2     // Catch:{ Exception -> 0x04f2 }
            r1.seek(r8)     // Catch:{ Exception -> 0x04f2 }
            r1.readFully(r7)     // Catch:{ Exception -> 0x04f2 }
            com.itextpdf.text.Jpeg r1 = new com.itextpdf.text.Jpeg     // Catch:{ Exception -> 0x04f2 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x02e7
        L_0x026c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = "missing.tag.s.for.ojpeg.compression"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r2)     // Catch:{ Exception -> 0x04f2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f2 }
            throw r0     // Catch:{ Exception -> 0x04f2 }
        L_0x027b:
            r7 = 7
            if (r3 != r7) goto L_0x02fb
            int r2 = r9.length     // Catch:{ Exception -> 0x04f2 }
            r7 = 1
            if (r2 > r7) goto L_0x02ee
            r2 = 0
            r7 = r9[r2]     // Catch:{ Exception -> 0x04f2 }
            int r8 = (int) r7     // Catch:{ Exception -> 0x04f2 }
            byte[] r7 = new byte[r8]     // Catch:{ Exception -> 0x04f2 }
            r11 = r13[r2]     // Catch:{ Exception -> 0x04f2 }
            r1.seek(r11)     // Catch:{ Exception -> 0x04f2 }
            r1.readFully(r7)     // Catch:{ Exception -> 0x04f2 }
            r1 = 347(0x15b, float:4.86E-43)
            com.itextpdf.text.pdf.codec.TIFFField r1 = r0.getField(r1)     // Catch:{ Exception -> 0x04f2 }
            if (r1 == 0) goto L_0x02d9
            byte[] r1 = r1.getAsBytes()     // Catch:{ Exception -> 0x04f2 }
            int r2 = r1.length     // Catch:{ Exception -> 0x04f2 }
            r9 = 0
            byte r11 = r1[r9]     // Catch:{ Exception -> 0x04f2 }
            r9 = -1
            if (r11 != r9) goto L_0x02ae
            r9 = 1
            byte r11 = r1[r9]     // Catch:{ Exception -> 0x04f2 }
            r9 = -40
            if (r11 != r9) goto L_0x02ae
            int r2 = r2 + -2
            r9 = 2
            goto L_0x02af
        L_0x02ae:
            r9 = 0
        L_0x02af:
            int r11 = r1.length     // Catch:{ Exception -> 0x04f2 }
            r12 = 2
            int r11 = r11 - r12
            byte r11 = r1[r11]     // Catch:{ Exception -> 0x04f2 }
            r12 = -1
            if (r11 != r12) goto L_0x02c2
            int r11 = r1.length     // Catch:{ Exception -> 0x04f2 }
            r12 = 1
            int r11 = r11 - r12
            byte r11 = r1[r11]     // Catch:{ Exception -> 0x04f2 }
            r12 = -39
            if (r11 != r12) goto L_0x02c2
            int r2 = r2 + -2
        L_0x02c2:
            byte[] r11 = new byte[r2]     // Catch:{ Exception -> 0x04f2 }
            r12 = 0
            java.lang.System.arraycopy(r1, r9, r11, r12, r2)     // Catch:{ Exception -> 0x04f2 }
            int r1 = r8 + r2
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x04f2 }
            r9 = 2
            java.lang.System.arraycopy(r7, r12, r1, r12, r9)     // Catch:{ Exception -> 0x04f2 }
            java.lang.System.arraycopy(r11, r12, r1, r9, r2)     // Catch:{ Exception -> 0x04f2 }
            int r2 = r2 + r9
            int r8 = r8 - r9
            java.lang.System.arraycopy(r7, r9, r1, r2, r8)     // Catch:{ Exception -> 0x04f2 }
            r7 = r1
        L_0x02d9:
            com.itextpdf.text.Jpeg r1 = new com.itextpdf.text.Jpeg     // Catch:{ Exception -> 0x04f2 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x04f2 }
            r2 = 2
            if (r10 != r2) goto L_0x02e6
            r7 = 0
            r1.setColorTransform(r7)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x02e7
        L_0x02e6:
            r7 = 0
        L_0x02e7:
            r2 = r1
            r35 = r4
            r0 = r5
            r1 = r10
            goto L_0x03fd
        L_0x02ee:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = "compression.jpeg.is.only.supported.with.a.single.strip.this.image.has.1.strips"
            int r2 = r9.length     // Catch:{ Exception -> 0x04f2 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r2)     // Catch:{ Exception -> 0x04f2 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x04f2 }
            throw r0     // Catch:{ Exception -> 0x04f2 }
        L_0x02fb:
            r7 = 0
            r20 = r10
            r10 = r32
        L_0x0300:
            int r0 = r13.length     // Catch:{ Exception -> 0x04f2 }
            if (r7 >= r0) goto L_0x03bc
            r35 = r4
            r0 = r5
            r4 = r9[r7]     // Catch:{ Exception -> 0x04f2 }
            int r5 = (int) r4     // Catch:{ Exception -> 0x04f2 }
            byte[] r4 = new byte[r5]     // Catch:{ Exception -> 0x04f2 }
            r5 = r8
            r36 = r9
            r8 = r13[r7]     // Catch:{ Exception -> 0x04f2 }
            r1.seek(r8)     // Catch:{ Exception -> 0x04f2 }
            r1.readFully(r4)     // Catch:{ Exception -> 0x04f2 }
            int r8 = java.lang.Math.min(r12, r10)     // Catch:{ Exception -> 0x04f2 }
            r9 = 1
            if (r3 == r9) goto L_0x032e
            int r9 = r0 * r15
            int r9 = r9 * r6
            r17 = 7
            int r9 = r9 + 7
            r23 = 8
            int r9 = r9 / 8
            int r9 = r9 * r8
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x04f2 }
            goto L_0x0330
        L_0x032e:
            r9 = r29
        L_0x0330:
            if (r5 == 0) goto L_0x0335
            com.itextpdf.text.pdf.codec.TIFFFaxDecoder.reverseBits(r4)     // Catch:{ Exception -> 0x04f2 }
        L_0x0335:
            r1 = 1
            if (r3 == r1) goto L_0x0374
            r1 = 5
            if (r3 == r1) goto L_0x0363
            r37 = r5
            r38 = r13
            r1 = r20
            r5 = r22
            r13 = 8
            if (r3 == r13) goto L_0x0359
            r13 = 32773(0x8005, float:4.5925E-41)
            if (r3 == r13) goto L_0x0352
            r13 = 32946(0x80b2, float:4.6167E-41)
            if (r3 == r13) goto L_0x035c
            goto L_0x0371
        L_0x0352:
            r13 = 32946(0x80b2, float:4.6167E-41)
            decodePackbits(r4, r9)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x0371
        L_0x0359:
            r13 = 32946(0x80b2, float:4.6167E-41)
        L_0x035c:
            inflate(r4, r9)     // Catch:{ Exception -> 0x04f2 }
            applyPredictor(r9, r2, r0, r8, r6)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x0371
        L_0x0363:
            r37 = r5
            r38 = r13
            r1 = r20
            r5 = r22
            r13 = 32946(0x80b2, float:4.6167E-41)
            r5.decode(r4, r9, r8)     // Catch:{ Exception -> 0x04f2 }
        L_0x0371:
            r4 = r9
        L_0x0372:
            r9 = 1
            goto L_0x0380
        L_0x0374:
            r37 = r5
            r38 = r13
            r1 = r20
            r5 = r22
            r13 = 32946(0x80b2, float:4.6167E-41)
            goto L_0x0372
        L_0x0380:
            if (r15 != r9) goto L_0x038b
            if (r6 != r9) goto L_0x038b
            r9 = 3
            if (r1 == r9) goto L_0x038b
            r11.fax4Encode(r4, r8)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x039e
        L_0x038b:
            if (r14 <= 0) goto L_0x03a1
            r19 = r33
            r20 = r35
            r21 = r4
            r22 = r6
            r23 = r15
            r24 = r0
            r25 = r8
            ProcessExtraSamples(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x04f2 }
        L_0x039e:
            r8 = r33
            goto L_0x03a6
        L_0x03a1:
            r8 = r33
            r8.write(r4)     // Catch:{ Exception -> 0x04f2 }
        L_0x03a6:
            int r10 = r10 - r12
            int r7 = r7 + 1
            r20 = r1
            r22 = r5
            r33 = r8
            r4 = r35
            r9 = r36
            r8 = r37
            r13 = r38
            r1 = r40
            r5 = r0
            goto L_0x0300
        L_0x03bc:
            r35 = r4
            r0 = r5
            r1 = r20
            r8 = r33
            r2 = 1
            if (r15 != r2) goto L_0x03e3
            if (r6 != r2) goto L_0x03e3
            r4 = 3
            if (r1 == r4) goto L_0x03e3
            r21 = 0
            r22 = 256(0x100, float:3.59E-43)
            if (r1 != r2) goto L_0x03d4
            r23 = 1
            goto L_0x03d6
        L_0x03d4:
            r23 = 0
        L_0x03d6:
            byte[] r24 = r11.close()     // Catch:{ Exception -> 0x04f2 }
            r19 = r0
            r20 = r32
            com.itextpdf.text.Image r2 = com.itextpdf.text.Image.getInstance(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x04f2 }
            goto L_0x03fd
        L_0x03e3:
            r8.close()     // Catch:{ Exception -> 0x04f2 }
            com.itextpdf.text.ImgRaw r2 = new com.itextpdf.text.ImgRaw     // Catch:{ Exception -> 0x04f2 }
            int r22 = r6 - r14
            byte[] r24 = r34.toByteArray()     // Catch:{ Exception -> 0x04f2 }
            r19 = r2
            r20 = r0
            r21 = r32
            r23 = r15
            r19.<init>(r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x04f2 }
            r4 = 1
            r2.setDeflated(r4)     // Catch:{ Exception -> 0x04f2 }
        L_0x03fd:
            r4 = r26
            r5 = r30
            r2.setDpi(r4, r5)     // Catch:{ Exception -> 0x04f2 }
            r4 = 6
            if (r3 == r4) goto L_0x04c9
            r4 = 7
            if (r3 == r4) goto L_0x04c9
            r3 = 34675(0x8773, float:4.859E-41)
            r4 = r39
            boolean r5 = r4.isTagPresent(r3)     // Catch:{ Exception -> 0x04f2 }
            if (r5 == 0) goto L_0x042b
            com.itextpdf.text.pdf.codec.TIFFField r3 = r4.getField(r3)     // Catch:{ RuntimeException -> 0x042b }
            byte[] r3 = r3.getAsBytes()     // Catch:{ RuntimeException -> 0x042b }
            com.itextpdf.text.pdf.ICC_Profile r3 = com.itextpdf.text.pdf.ICC_Profile.getInstance(r3)     // Catch:{ RuntimeException -> 0x042b }
            int r6 = r6 - r14
            int r5 = r3.getNumComponents()     // Catch:{ RuntimeException -> 0x042b }
            if (r6 != r5) goto L_0x042b
            r2.tagICC(r3)     // Catch:{ RuntimeException -> 0x042b }
        L_0x042b:
            r3 = 320(0x140, float:4.48E-43)
            boolean r3 = r4.isTagPresent(r3)
            if (r3 == 0) goto L_0x04c5
            r3 = 320(0x140, float:4.48E-43)
            com.itextpdf.text.pdf.codec.TIFFField r3 = r4.getField(r3)
            char[] r3 = r3.getAsChars()
            int r4 = r3.length
            byte[] r5 = new byte[r4]
            int r6 = r3.length
            r7 = 3
            int r6 = r6 / r7
            int r7 = r6 * 2
            r8 = 0
        L_0x0446:
            if (r8 >= r6) goto L_0x0469
            int r9 = r8 * 3
            char r10 = r3[r8]
            r11 = 8
            int r10 = r10 >>> r11
            byte r10 = (byte) r10
            r5[r9] = r10
            int r10 = r9 + 1
            int r12 = r8 + r6
            char r12 = r3[r12]
            int r12 = r12 >>> r11
            byte r12 = (byte) r12
            r5[r10] = r12
            int r9 = r9 + 2
            int r10 = r8 + r7
            char r10 = r3[r10]
            int r10 = r10 >>> r11
            byte r10 = (byte) r10
            r5[r9] = r10
            int r8 = r8 + 1
            goto L_0x0446
        L_0x0469:
            r8 = 0
        L_0x046a:
            if (r8 >= r4) goto L_0x0475
            byte r9 = r5[r8]
            if (r9 == 0) goto L_0x0472
            r4 = 0
            goto L_0x0476
        L_0x0472:
            int r8 = r8 + 1
            goto L_0x046a
        L_0x0475:
            r4 = 1
        L_0x0476:
            if (r4 == 0) goto L_0x0497
            r4 = 0
        L_0x0479:
            if (r4 >= r6) goto L_0x0497
            int r8 = r4 * 3
            char r9 = r3[r4]
            byte r9 = (byte) r9
            r5[r8] = r9
            int r9 = r8 + 1
            int r10 = r4 + r6
            char r10 = r3[r10]
            byte r10 = (byte) r10
            r5[r9] = r10
            int r8 = r8 + 2
            int r9 = r4 + r7
            char r9 = r3[r9]
            byte r9 = (byte) r9
            r5[r8] = r9
            int r4 = r4 + 1
            goto L_0x0479
        L_0x0497:
            com.itextpdf.text.pdf.PdfArray r3 = new com.itextpdf.text.pdf.PdfArray
            r3.<init>()
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.INDEXED
            r3.add(r4)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.DEVICERGB
            r3.add(r4)
            com.itextpdf.text.pdf.PdfNumber r4 = new com.itextpdf.text.pdf.PdfNumber
            r7 = 1
            int r6 = r6 - r7
            r4.<init>(r6)
            r3.add(r4)
            com.itextpdf.text.pdf.PdfString r4 = new com.itextpdf.text.pdf.PdfString
            r4.<init>(r5)
            r3.add(r4)
            com.itextpdf.text.pdf.PdfDictionary r4 = new com.itextpdf.text.pdf.PdfDictionary
            r4.<init>()
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.COLORSPACE
            r4.put(r5, r3)
            r2.setAdditional(r4)
        L_0x04c5:
            r3 = 5
            r2.setOriginalType(r3)
        L_0x04c9:
            if (r1 != 0) goto L_0x04cf
            r1 = 1
            r2.setInverted(r1)
        L_0x04cf:
            int r1 = (r28 > r16 ? 1 : (r28 == r16 ? 0 : -1))
            if (r1 == 0) goto L_0x04d8
            r13 = r28
            r2.setInitialRotation(r13)
        L_0x04d8:
            if (r14 <= 0) goto L_0x04f1
            r35.close()
            byte[] r1 = r31.toByteArray()
            r3 = r32
            r4 = 1
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.getInstance(r0, r3, r4, r15, r1)
            r0.makeMask()
            r0.setDeflated(r4)
            r2.setImageMask(r0)
        L_0x04f1:
            return r2
        L_0x04f2:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TiffImage.getTiffImageColor(com.itextpdf.text.pdf.codec.TIFFDirectory, com.itextpdf.text.pdf.RandomAccessFileOrArray):com.itextpdf.text.Image");
    }

    static Image ProcessExtraSamples(DeflaterOutputStream deflaterOutputStream, DeflaterOutputStream deflaterOutputStream2, byte[] bArr, int i, int i2, int i3, int i4) throws IOException {
        if (i2 == 8) {
            int i5 = i3 * i4;
            byte[] bArr2 = new byte[i5];
            int i6 = i5 * i;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i6) {
                int i10 = 0;
                while (i10 < i - 1) {
                    bArr[i8] = bArr[i7 + i10];
                    i10++;
                    i8++;
                }
                i7 += i;
                bArr2[i9] = bArr[i7 - 1];
                i9++;
            }
            deflaterOutputStream.write(bArr, 0, i8);
            deflaterOutputStream2.write(bArr2, 0, i9);
            return null;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("extra.samples.are.not.supported", new Object[0]));
    }

    static long[] getArrayLongShort(TIFFDirectory tIFFDirectory, int i) {
        TIFFField field = tIFFDirectory.getField(i);
        if (field == null) {
            return null;
        }
        if (field.getType() == 4) {
            return field.getAsLongs();
        }
        char[] asChars = field.getAsChars();
        long[] jArr = new long[asChars.length];
        for (int i2 = 0; i2 < asChars.length; i2++) {
            jArr[i2] = (long) asChars[i2];
        }
        return jArr;
    }

    public static void decodePackbits(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (i < bArr2.length) {
            try {
                int i3 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0 && b <= Byte.MAX_VALUE) {
                    int i4 = 0;
                    while (i4 < b + 1) {
                        bArr2[i] = bArr[i3];
                        i4++;
                        i++;
                        i3++;
                    }
                    i2 = i3;
                } else if (b > -1 || b < -127) {
                    i2 = i3 + 1;
                } else {
                    int i5 = i3 + 1;
                    byte b2 = bArr[i3];
                    int i6 = 0;
                    while (i6 < (-b) + 1) {
                        int i7 = i + 1;
                        bArr2[i] = b2;
                        i6++;
                        i = i7;
                    }
                    i2 = i5;
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    public static void inflate(byte[] bArr, byte[] bArr2) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        try {
            inflater.inflate(bArr2);
        } catch (DataFormatException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static void applyPredictor(byte[] bArr, int i, int i2, int i3, int i4) {
        if (i == 2) {
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = ((i5 * i2) + 1) * i4;
                for (int i7 = i4; i7 < i2 * i4; i7++) {
                    bArr[i6] = (byte) (bArr[i6] + bArr[i6 - i4]);
                    i6++;
                }
            }
        }
    }
}
