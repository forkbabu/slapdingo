package com.google.android.gms.common.util;

import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.PdfWriter;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class Hex {
    private static final char[] zzho = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzhp = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX};

    public static String bytesToStringUppercase(byte[] bArr) {
        return bytesToStringUppercase(bArr, false);
    }

    public static String bytesToStringUppercase(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        int i = 0;
        while (i < length && (!z || i != length - 1 || (bArr[i] & UByte.MAX_VALUE) != 0)) {
            sb.append(zzho[(bArr[i] & 240) >>> 4]);
            sb.append(zzho[bArr[i] & BidiOrder.B]);
            i++;
        }
        return sb.toString();
    }

    public static String bytesToStringLowercase(byte[] bArr) {
        char[] cArr = new char[(bArr.length << 1)];
        int i = 0;
        for (byte b : bArr) {
            byte b2 = b & UByte.MAX_VALUE;
            int i2 = i + 1;
            char[] cArr2 = zzhp;
            cArr[i] = cArr2[b2 >>> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & BidiOrder.B];
        }
        return new String(cArr);
    }

    public static byte[] stringToBytes(String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            int i = 0;
            while (i < length) {
                int i2 = i + 2;
                bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, i2), 16);
                i = i2;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string has odd number of characters");
    }
}
