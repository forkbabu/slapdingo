package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;

public class StringUtils {
    private static final byte[] b = DocWriter.getISOBytes("\\b");
    private static final byte[] f = DocWriter.getISOBytes("\\f");
    private static final byte[] n = DocWriter.getISOBytes("\\n");
    private static final byte[] r = DocWriter.getISOBytes("\\r");
    private static final byte[] t = DocWriter.getISOBytes("\\t");

    private StringUtils() {
    }

    public static byte[] escapeString(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer();
        escapeString(bArr, byteBuffer);
        return byteBuffer.toByteArray();
    }

    public static void escapeString(byte[] bArr, ByteBuffer byteBuffer) {
        byteBuffer.append_i(40);
        for (byte b2 : bArr) {
            if (b2 == 12) {
                byteBuffer.append(f);
            } else if (b2 == 13) {
                byteBuffer.append(r);
            } else if (b2 == 40 || b2 == 41 || b2 == 92) {
                byteBuffer.append_i(92).append_i(b2);
            } else {
                switch (b2) {
                    case 8:
                        byteBuffer.append(b);
                        continue;
                    case 9:
                        byteBuffer.append(t);
                        continue;
                    case 10:
                        byteBuffer.append(n);
                        continue;
                    default:
                        byteBuffer.append_i(b2);
                        continue;
                }
            }
        }
        byteBuffer.append_i(41);
    }

    public static byte[] convertCharsToBytes(char[] cArr) {
        byte[] bArr = new byte[(cArr.length * 2)];
        for (int i = 0; i < cArr.length; i++) {
            int i2 = i * 2;
            bArr[i2] = (byte) (cArr[i] / 256);
            bArr[i2 + 1] = (byte) (cArr[i] % 256);
        }
        return bArr;
    }
}
