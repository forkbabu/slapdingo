package com.itextpdf.text.pdf.qrcode;

public final class MaskUtil {
    private MaskUtil() {
    }

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        for (int i2 = 0; i2 < height - 1; i2++) {
            int i3 = 0;
            while (i3 < width - 1) {
                byte b = array[i2][i3];
                int i4 = i3 + 1;
                if (b == array[i2][i4]) {
                    int i5 = i2 + 1;
                    if (b == array[i5][i3] && b == array[i5][i4]) {
                        i += 3;
                    }
                }
                i3 = i4;
            }
        }
        return i;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        int i;
        int i2;
        int i3;
        int i4;
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        for (int i6 = 0; i6 < height; i6++) {
            for (int i7 = 0; i7 < width; i7++) {
                int i8 = i7 + 6;
                if (i8 < width && array[i6][i7] == 1 && array[i6][i7 + 1] == 0 && array[i6][i7 + 2] == 1 && array[i6][i7 + 3] == 1 && array[i6][i7 + 4] == 1 && array[i6][i7 + 5] == 0 && array[i6][i8] == 1 && (((i3 = i7 + 10) < width && array[i6][i7 + 7] == 0 && array[i6][i7 + 8] == 0 && array[i6][i7 + 9] == 0 && array[i6][i3] == 0) || (i7 - 4 >= 0 && array[i6][i7 - 1] == 0 && array[i6][i7 - 2] == 0 && array[i6][i7 - 3] == 0 && array[i6][i4] == 0))) {
                    i5 += 40;
                }
                int i9 = i6 + 6;
                if (i9 < height && array[i6][i7] == 1 && array[i6 + 1][i7] == 0 && array[i6 + 2][i7] == 1 && array[i6 + 3][i7] == 1 && array[i6 + 4][i7] == 1 && array[i6 + 5][i7] == 0 && array[i9][i7] == 1 && (((i = i6 + 10) < height && array[i6 + 7][i7] == 0 && array[i6 + 8][i7] == 0 && array[i6 + 9][i7] == 0 && array[i][i7] == 0) || (i6 - 4 >= 0 && array[i6 - 1][i7] == 0 && array[i6 - 2][i7] == 0 && array[i6 - 3][i7] == 0 && array[i2][i7] == 0))) {
                    i5 += 40;
                }
            }
        }
        return i5;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                if (array[i2][i3] == 1) {
                    i++;
                }
            }
        }
        return (Math.abs((int) (((((double) i) / ((double) (byteMatrix.getHeight() * byteMatrix.getWidth()))) * 100.0d) - 50.0d)) / 5) * 10;
    }

    public static boolean getDataMaskBit(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (QRCode.isValidMaskPattern(i)) {
            switch (i) {
                case 0:
                    i3 += i2;
                case 1:
                    i4 = i3 & 1;
                    break;
                case 2:
                    i4 = i2 % 3;
                    break;
                case 3:
                    i4 = (i3 + i2) % 3;
                    break;
                case 4:
                    i7 = i3 >>> 1;
                    i6 = i2 / 3;
                    i5 = i7 + i6;
                    i4 = i5 & 1;
                    break;
                case 5:
                    int i8 = i3 * i2;
                    i4 = (i8 & 1) + (i8 % 3);
                    break;
                case 6:
                    int i9 = i3 * i2;
                    i5 = (i9 & 1) + (i9 % 3);
                    i4 = i5 & 1;
                    break;
                case 7:
                    i7 = (i3 * i2) % 3;
                    i6 = (i3 + i2) & 1;
                    i5 = i7 + i6;
                    i4 = i5 & 1;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid mask pattern: " + i);
            }
            if (i4 == 0) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Invalid mask pattern");
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        byte b = -1;
        int i = 0;
        for (int i2 = 0; i2 < height; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < width; i4++) {
                byte b2 = z ? array[i2][i4] : array[i4][i2];
                if (b2 == b) {
                    i3++;
                    if (i3 == 5) {
                        i += 3;
                    } else if (i3 > 5) {
                        i++;
                    }
                } else {
                    b = b2;
                    i3 = 1;
                }
            }
        }
        return i;
    }
}
