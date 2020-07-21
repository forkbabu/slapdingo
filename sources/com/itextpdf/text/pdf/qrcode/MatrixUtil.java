package com.itextpdf.text.pdf.qrcode;

import org.spongycastle.crypto.tls.CipherSuite;

public final class MatrixUtil {
    private static final int[][] HORIZONTAL_SEPARATION_PATTERN = {new int[]{0, 0, 0, 0, 0, 0, 0, 0}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, -1}, new int[]{6, 30, 54, 78, 102, 126, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA}, new int[]{6, 24, 50, 76, 102, 128, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA}, new int[]{6, 28, 54, 80, 106, 132, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256}, new int[]{6, 32, 58, 84, 110, 136, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256}, new int[]{6, 26, 54, 82, 110, 138, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256}, new int[]{6, 30, 58, 86, 114, 142, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256}};
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    private static final int[][] VERTICAL_SEPARATION_PATTERN = {new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}};

    public static int findMSBSet(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    private static boolean isEmpty(int i) {
        return i == -1;
    }

    private static boolean isValidValue(int i) {
        return i == -1 || i == 0 || i == 1;
    }

    private MatrixUtil() {
    }

    public static void clearMatrix(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    public static void buildMatrix(BitVector bitVector, ErrorCorrectionLevel errorCorrectionLevel, int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(i, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i2, byteMatrix);
        maybeEmbedVersionInfo(i, byteMatrix);
        embedDataBits(bitVector, i2, byteMatrix);
    }

    public static void embedBasicPatterns(int i, ByteMatrix byteMatrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(i, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i, ByteMatrix byteMatrix) throws WriterException {
        BitVector bitVector = new BitVector();
        makeTypeInfoBits(errorCorrectionLevel, i, bitVector);
        for (int i2 = 0; i2 < bitVector.size(); i2++) {
            int at = bitVector.at((bitVector.size() - 1) - i2);
            int[][] iArr = TYPE_INFO_COORDINATES;
            byteMatrix.set(iArr[i2][0], iArr[i2][1], at);
            if (i2 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i2) - 1, 8, at);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i2 - 8), at);
            }
        }
    }

    public static void maybeEmbedVersionInfo(int i, ByteMatrix byteMatrix) throws WriterException {
        if (i >= 7) {
            BitVector bitVector = new BitVector();
            makeVersionInfoBits(i, bitVector);
            int i2 = 17;
            for (int i3 = 0; i3 < 6; i3++) {
                for (int i4 = 0; i4 < 3; i4++) {
                    int at = bitVector.at(i2);
                    i2--;
                    byteMatrix.set(i3, (byteMatrix.getHeight() - 11) + i4, at);
                    byteMatrix.set((byteMatrix.getHeight() - 11) + i4, i3, at);
                }
            }
        }
    }

    public static void embedDataBits(BitVector bitVector, int i, ByteMatrix byteMatrix) throws WriterException {
        int i2;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i3 = 0;
        int i4 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = width - i5;
                    if (isEmpty(byteMatrix.get(i6, height))) {
                        if (i3 < bitVector.size()) {
                            i2 = bitVector.at(i3);
                            i3++;
                        } else {
                            i2 = 0;
                        }
                        if (i != -1 && MaskUtil.getDataMaskBit(i, i6, height)) {
                            i2 ^= 1;
                        }
                        byteMatrix.set(i6, height, i2);
                    }
                }
                height += i4;
            }
            i4 = -i4;
            height += i4;
            width -= 2;
        }
        if (i3 != bitVector.size()) {
            throw new WriterException("Not all bits consumed: " + i3 + '/' + bitVector.size());
        }
    }

    public static int calculateBCHCode(int i, int i2) {
        int findMSBSet = findMSBSet(i2);
        int i3 = i << (findMSBSet - 1);
        while (findMSBSet(i3) >= findMSBSet) {
            i3 ^= i2 << (findMSBSet(i3) - findMSBSet);
        }
        return i3;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i, BitVector bitVector) throws WriterException {
        if (QRCode.isValidMaskPattern(i)) {
            int bits = (errorCorrectionLevel.getBits() << 3) | i;
            bitVector.appendBits(bits, 5);
            bitVector.appendBits(calculateBCHCode(bits, TYPE_INFO_POLY), 10);
            BitVector bitVector2 = new BitVector();
            bitVector2.appendBits(TYPE_INFO_MASK_PATTERN, 15);
            bitVector.xor(bitVector2);
            if (bitVector.size() != 15) {
                throw new WriterException("should not happen but we got: " + bitVector.size());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    public static void makeVersionInfoBits(int i, BitVector bitVector) throws WriterException {
        bitVector.appendBits(i, 6);
        bitVector.appendBits(calculateBCHCode(i, VERSION_INFO_POLY), 12);
        if (bitVector.size() != 18) {
            throw new WriterException("should not happen but we got: " + bitVector.size());
        }
    }

    private static void embedTimingPatterns(ByteMatrix byteMatrix) throws WriterException {
        int i = 8;
        while (i < byteMatrix.getWidth() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (isValidValue(byteMatrix.get(i, 6))) {
                if (isEmpty(byteMatrix.get(i, 6))) {
                    byteMatrix.set(i, 6, i3);
                }
                if (isValidValue(byteMatrix.get(6, i))) {
                    if (isEmpty(byteMatrix.get(6, i))) {
                        byteMatrix.set(6, i, i3);
                    }
                    i = i2;
                } else {
                    throw new WriterException();
                }
            } else {
                throw new WriterException();
            }
        }
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) != 0) {
            byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static void embedHorizontalSeparationPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = HORIZONTAL_SEPARATION_PATTERN;
        if (iArr[0].length == 8 && iArr.length == 1) {
            int i3 = 0;
            while (i3 < 8) {
                int i4 = i + i3;
                if (isEmpty(byteMatrix.get(i4, i2))) {
                    byteMatrix.set(i4, i2, HORIZONTAL_SEPARATION_PATTERN[0][i3]);
                    i3++;
                } else {
                    throw new WriterException();
                }
            }
            return;
        }
        throw new WriterException("Bad horizontal separation pattern");
    }

    private static void embedVerticalSeparationPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = VERTICAL_SEPARATION_PATTERN;
        if (iArr[0].length == 1 && iArr.length == 7) {
            int i3 = 0;
            while (i3 < 7) {
                int i4 = i2 + i3;
                if (isEmpty(byteMatrix.get(i, i4))) {
                    byteMatrix.set(i, i4, VERTICAL_SEPARATION_PATTERN[i3][0]);
                    i3++;
                } else {
                    throw new WriterException();
                }
            }
            return;
        }
        throw new WriterException("Bad vertical separation pattern");
    }

    private static void embedPositionAdjustmentPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = POSITION_ADJUSTMENT_PATTERN;
        if (iArr[0].length == 5 && iArr.length == 5) {
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = 0;
                while (i4 < 5) {
                    int i5 = i + i4;
                    int i6 = i2 + i3;
                    if (isEmpty(byteMatrix.get(i5, i6))) {
                        byteMatrix.set(i5, i6, POSITION_ADJUSTMENT_PATTERN[i3][i4]);
                        i4++;
                    } else {
                        throw new WriterException();
                    }
                }
            }
            return;
        }
        throw new WriterException("Bad position adjustment");
    }

    private static void embedPositionDetectionPattern(int i, int i2, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = POSITION_DETECTION_PATTERN;
        if (iArr[0].length == 7 && iArr.length == 7) {
            for (int i3 = 0; i3 < 7; i3++) {
                int i4 = 0;
                while (i4 < 7) {
                    int i5 = i + i4;
                    int i6 = i2 + i3;
                    if (isEmpty(byteMatrix.get(i5, i6))) {
                        byteMatrix.set(i5, i6, POSITION_DETECTION_PATTERN[i3][i4]);
                        i4++;
                    } else {
                        throw new WriterException();
                    }
                }
            }
            return;
        }
        throw new WriterException("Bad position detection pattern");
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) throws WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        int length2 = HORIZONTAL_SEPARATION_PATTERN[0].length;
        int i = length2 - 1;
        embedHorizontalSeparationPattern(0, i, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - length2, i, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - length2, byteMatrix);
        int length3 = VERTICAL_SEPARATION_PATTERN.length;
        embedVerticalSeparationPattern(length3, 0, byteMatrix);
        embedVerticalSeparationPattern((byteMatrix.getHeight() - length3) - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(length3, byteMatrix.getHeight() - length3, byteMatrix);
    }

    private static void maybeEmbedPositionAdjustmentPatterns(int i, ByteMatrix byteMatrix) throws WriterException {
        if (i >= 2) {
            int i2 = i - 1;
            int[][] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
            int[] iArr2 = iArr[i2];
            int length = iArr[i2].length;
            for (int i3 = 0; i3 < length; i3++) {
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr2[i3];
                    int i6 = iArr2[i4];
                    if (!(i6 == -1 || i5 == -1 || !isEmpty(byteMatrix.get(i6, i5)))) {
                        embedPositionAdjustmentPattern(i6 - 2, i5 - 2, byteMatrix);
                    }
                }
            }
        }
    }
}
