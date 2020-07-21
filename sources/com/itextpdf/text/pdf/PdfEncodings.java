package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.HashMap;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.text.Typography;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

public class PdfEncodings {
    static HashMap<String, ExtraEncoding> extraEncodings = new HashMap<>();
    static final IntHashtable pdfEncoding = new IntHashtable();
    static final char[] pdfEncodingByteToChar = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', Typography.less, '=', Typography.greater, '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, '[', '\\', ']', '^', '_', '`', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX, Barcode128.START_A, Barcode128.START_B, Barcode128.START_C, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', 127, Typography.bullet, Typography.f63dagger, Typography.doubleDagger, Typography.ellipsis, Typography.mdash, Typography.ndash, 402, 8260, 8249, 8250, 8722, 8240, Typography.lowDoubleQuote, Typography.leftDoubleQuote, Typography.rightDoubleQuote, Typography.leftSingleQuote, Typography.rightSingleQuote, Typography.lowSingleQuote, Typography.tm, 64257, 64258, 321, 338, 352, 376, 381, 305, 322, 339, 353, 382, 65533, Typography.euro, 161, Typography.cent, Typography.pound, 164, 165, 166, Typography.section, 168, Typography.copyright, 170, Typography.leftGuillemete, 172, 173, Typography.registered, 175, Typography.degree, Typography.plusMinus, 178, 179, 180, 181, Typography.paragraph, Typography.middleDot, 184, 185, 186, Typography.rightGuillemete, 188, Typography.half, 190, 191, 192, 193, 194, Barcode128.DEL, Barcode128.FNC3, Barcode128.FNC2, Barcode128.SHIFT, Barcode128.CODE_C, 200, 201, Barcode128.FNC1, Barcode128.STARTA, Barcode128.STARTB, Barcode128.STARTC, 206, 207, 208, 209, 210, 211, 212, 213, 214, Typography.times, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};
    static final IntHashtable winansi = new IntHashtable();
    static final char[] winansiByteToChar = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', Typography.quote, '#', Typography.dollar, '%', Typography.amp, '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', Typography.less, '=', Typography.greater, '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, '[', '\\', ']', '^', '_', '`', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX, Barcode128.START_A, Barcode128.START_B, Barcode128.START_C, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', 127, Typography.euro, 65533, Typography.lowSingleQuote, 402, Typography.lowDoubleQuote, Typography.ellipsis, Typography.f63dagger, Typography.doubleDagger, 710, 8240, 352, 8249, 338, 65533, 381, 65533, 65533, Typography.leftSingleQuote, Typography.rightSingleQuote, Typography.leftDoubleQuote, Typography.rightDoubleQuote, Typography.bullet, Typography.ndash, Typography.mdash, 732, Typography.tm, 353, 8250, 339, 65533, 382, 376, Typography.nbsp, 161, Typography.cent, Typography.pound, 164, 165, 166, Typography.section, 168, Typography.copyright, 170, Typography.leftGuillemete, 172, 173, Typography.registered, 175, Typography.degree, Typography.plusMinus, 178, 179, 180, 181, Typography.paragraph, Typography.middleDot, 184, 185, 186, Typography.rightGuillemete, 188, Typography.half, 190, 191, 192, 193, 194, Barcode128.DEL, Barcode128.FNC3, Barcode128.FNC2, Barcode128.SHIFT, Barcode128.CODE_C, 200, 201, Barcode128.FNC1, Barcode128.STARTA, Barcode128.STARTB, Barcode128.STARTC, 206, 207, 208, 209, 210, 211, 212, 213, 214, Typography.times, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255};

    static {
        for (int i = 128; i < 161; i++) {
            char c = winansiByteToChar[i];
            if (c != 65533) {
                winansi.put(c, i);
            }
        }
        for (int i2 = 128; i2 < 161; i2++) {
            char c2 = pdfEncodingByteToChar[i2];
            if (c2 != 65533) {
                pdfEncoding.put(c2, i2);
            }
        }
        addExtraEncoding("Wingdings", new WingdingsConversion());
        addExtraEncoding("Symbol", new SymbolConversion(true));
        addExtraEncoding("ZapfDingbats", new SymbolConversion(false));
        addExtraEncoding("SymbolTT", new SymbolTTConversion());
        addExtraEncoding("Cp437", new Cp437Conversion());
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    public static final byte[] convertToBytes(String str, String str2) {
        byte[] charToByte;
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        if (str2 == null || str2.length() == 0) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                bArr[i2] = (byte) str.charAt(i2);
            }
            return bArr;
        }
        ExtraEncoding extraEncoding = extraEncodings.get(str2.toLowerCase());
        if (extraEncoding != null && (charToByte = extraEncoding.charToByte(str, str2)) != null) {
            return charToByte;
        }
        IntHashtable intHashtable = null;
        if (str2.equals("Cp1252")) {
            intHashtable = winansi;
        } else if (str2.equals(PdfObject.TEXT_PDFDOCENCODING)) {
            intHashtable = pdfEncoding;
        }
        if (intHashtable != null) {
            char[] charArray = str.toCharArray();
            int length2 = charArray.length;
            byte[] bArr2 = new byte[length2];
            int i3 = 0;
            for (char c : charArray) {
                int i4 = c;
                if (c >= 128) {
                    i4 = c;
                    if (c <= 160 || c > 255) {
                        i4 = intHashtable.get(c);
                    }
                }
                if (i4 != 0) {
                    bArr2[i3] = (byte) i4;
                    i3++;
                }
            }
            if (i3 == length2) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr2, 0, bArr3, 0, i3);
            return bArr3;
        } else if (str2.equals(PdfObject.TEXT_UNICODE)) {
            char[] charArray2 = str.toCharArray();
            int length3 = charArray2.length;
            int i5 = 2;
            byte[] bArr4 = new byte[((charArray2.length * 2) + 2)];
            bArr4[0] = -2;
            bArr4[1] = -1;
            for (i++; i < length3; i++) {
                char c2 = charArray2[i];
                int i6 = i5 + 1;
                bArr4[i5] = (byte) (c2 >> '\b');
                i5 = i6 + 1;
                bArr4[i6] = (byte) (c2 & 255);
            }
            return bArr4;
        } else {
            try {
                CharsetEncoder newEncoder = Charset.forName(str2).newEncoder();
                newEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                ByteBuffer encode = newEncoder.encode(CharBuffer.wrap(str.toCharArray()));
                encode.rewind();
                byte[] bArr5 = new byte[encode.limit()];
                encode.get(bArr5);
                return bArr5;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* JADX DEBUG: Additional 3 move instruction added to help type inference */
    public static final byte[] convertToBytes(char c, String str) {
        byte[] charToByte;
        if (str == null || str.length() == 0) {
            return new byte[]{(byte) c};
        }
        ExtraEncoding extraEncoding = extraEncodings.get(str.toLowerCase());
        if (extraEncoding != null && (charToByte = extraEncoding.charToByte(c, str)) != null) {
            return charToByte;
        }
        IntHashtable intHashtable = null;
        if (str.equals("Cp1252")) {
            intHashtable = winansi;
        } else if (str.equals(PdfObject.TEXT_PDFDOCENCODING)) {
            intHashtable = pdfEncoding;
        }
        if (intHashtable != null) {
            char c2 = c;
            if (c >= 128) {
                c2 = c;
                if (c <= 160 || c > 255) {
                    c2 = intHashtable.get(c);
                }
            }
            return c2 != 0 ? new byte[]{(byte) c2} : new byte[0];
        } else if (str.equals(PdfObject.TEXT_UNICODE)) {
            return new byte[]{-2, -1, (byte) (c >> '\b'), (byte) (c & 255)};
        } else {
            try {
                CharsetEncoder newEncoder = Charset.forName(str).newEncoder();
                newEncoder.onUnmappableCharacter(CodingErrorAction.IGNORE);
                ByteBuffer encode = newEncoder.encode(CharBuffer.wrap(new char[]{c}));
                encode.rewind();
                byte[] bArr = new byte[encode.limit()];
                encode.get(bArr);
                return bArr;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public static final String convertToString(byte[] bArr, String str) {
        String byteToChar;
        if (bArr == null) {
            return "";
        }
        int i = 0;
        if (str == null || str.length() == 0) {
            char[] cArr = new char[bArr.length];
            while (i < bArr.length) {
                cArr[i] = (char) (bArr[i] & UByte.MAX_VALUE);
                i++;
            }
            return new String(cArr);
        }
        ExtraEncoding extraEncoding = extraEncodings.get(str.toLowerCase());
        if (extraEncoding != null && (byteToChar = extraEncoding.byteToChar(bArr, str)) != null) {
            return byteToChar;
        }
        char[] cArr2 = null;
        if (str.equals("Cp1252")) {
            cArr2 = winansiByteToChar;
        } else if (str.equals(PdfObject.TEXT_PDFDOCENCODING)) {
            cArr2 = pdfEncodingByteToChar;
        }
        if (cArr2 != null) {
            int length = bArr.length;
            char[] cArr3 = new char[length];
            while (i < length) {
                cArr3[i] = cArr2[bArr[i] & UByte.MAX_VALUE];
                i++;
            }
            return new String(cArr3);
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static boolean isPdfDocEncoding(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= 128 && ((charAt <= 160 || charAt > 255) && !pdfEncoding.containsKey(charAt))) {
                return false;
            }
        }
        return true;
    }

    public static void addExtraEncoding(String str, ExtraEncoding extraEncoding) {
        synchronized (extraEncodings) {
            HashMap<String, ExtraEncoding> hashMap = (HashMap) extraEncodings.clone();
            hashMap.put(str.toLowerCase(), extraEncoding);
            extraEncodings = hashMap;
        }
    }

    private static class WingdingsConversion implements ExtraEncoding {
        private static final byte[] table;

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        private WingdingsConversion() {
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            byte b;
            return c == ' ' ? new byte[]{(byte) c} : (c < 9985 || c > 10174 || (b = table[c + 55552]) == 0) ? new byte[0] : new byte[]{b};
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            byte b;
            int i;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i2 = 0;
            for (char c : charArray) {
                if (c == ' ') {
                    i = i2 + 1;
                    bArr[i2] = (byte) c;
                } else {
                    if (c >= 9985 && c <= 10174 && (b = table[c - 9984]) != 0) {
                        i = i2 + 1;
                        bArr[i2] = b;
                    }
                }
                i2 = i;
            }
            if (i2 == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        static {
            byte[] bArr = new byte[CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256];
            // fill-array-data instruction
            bArr[0] = 0;
            bArr[1] = 35;
            bArr[2] = 34;
            bArr[3] = 0;
            bArr[4] = 0;
            bArr[5] = 0;
            bArr[6] = 41;
            bArr[7] = 62;
            bArr[8] = 81;
            bArr[9] = 42;
            bArr[10] = 0;
            bArr[11] = 0;
            bArr[12] = 65;
            bArr[13] = 63;
            bArr[14] = 0;
            bArr[15] = 0;
            bArr[16] = 0;
            bArr[17] = 0;
            bArr[18] = 0;
            bArr[19] = -4;
            bArr[20] = 0;
            bArr[21] = 0;
            bArr[22] = 0;
            bArr[23] = -5;
            bArr[24] = 0;
            bArr[25] = 0;
            bArr[26] = 0;
            bArr[27] = 0;
            bArr[28] = 0;
            bArr[29] = 0;
            bArr[30] = 86;
            bArr[31] = 0;
            bArr[32] = 88;
            bArr[33] = 89;
            bArr[34] = 0;
            bArr[35] = 0;
            bArr[36] = 0;
            bArr[37] = 0;
            bArr[38] = 0;
            bArr[39] = 0;
            bArr[40] = 0;
            bArr[41] = 0;
            bArr[42] = -75;
            bArr[43] = 0;
            bArr[44] = 0;
            bArr[45] = 0;
            bArr[46] = 0;
            bArr[47] = 0;
            bArr[48] = -74;
            bArr[49] = 0;
            bArr[50] = 0;
            bArr[51] = 0;
            bArr[52] = -83;
            bArr[53] = -81;
            bArr[54] = -84;
            bArr[55] = 0;
            bArr[56] = 0;
            bArr[57] = 0;
            bArr[58] = 0;
            bArr[59] = 0;
            bArr[60] = 0;
            bArr[61] = 0;
            bArr[62] = 0;
            bArr[63] = 124;
            bArr[64] = 123;
            bArr[65] = 0;
            bArr[66] = 0;
            bArr[67] = 0;
            bArr[68] = 84;
            bArr[69] = 0;
            bArr[70] = 0;
            bArr[71] = 0;
            bArr[72] = 0;
            bArr[73] = 0;
            bArr[74] = 0;
            bArr[75] = 0;
            bArr[76] = 0;
            bArr[77] = -90;
            bArr[78] = 0;
            bArr[79] = 0;
            bArr[80] = 0;
            bArr[81] = 113;
            bArr[82] = 114;
            bArr[83] = 0;
            bArr[84] = 0;
            bArr[85] = 0;
            bArr[86] = 117;
            bArr[87] = 0;
            bArr[88] = 0;
            bArr[89] = 0;
            bArr[90] = 0;
            bArr[91] = 0;
            bArr[92] = 0;
            bArr[93] = 125;
            bArr[94] = 126;
            bArr[95] = 0;
            bArr[96] = 0;
            bArr[97] = 0;
            bArr[98] = 0;
            bArr[99] = 0;
            bArr[100] = 0;
            bArr[101] = 0;
            bArr[102] = 0;
            bArr[103] = 0;
            bArr[104] = 0;
            bArr[105] = 0;
            bArr[106] = 0;
            bArr[107] = 0;
            bArr[108] = 0;
            bArr[109] = 0;
            bArr[110] = 0;
            bArr[111] = 0;
            bArr[112] = 0;
            bArr[113] = 0;
            bArr[114] = 0;
            bArr[115] = 0;
            bArr[116] = 0;
            bArr[117] = 0;
            bArr[118] = -116;
            bArr[119] = -115;
            bArr[120] = -114;
            bArr[121] = -113;
            bArr[122] = -112;
            bArr[123] = -111;
            bArr[124] = -110;
            bArr[125] = -109;
            bArr[126] = -108;
            bArr[127] = -107;
            bArr[128] = -127;
            bArr[129] = -126;
            bArr[130] = -125;
            bArr[131] = -124;
            bArr[132] = -123;
            bArr[133] = -122;
            bArr[134] = -121;
            bArr[135] = -120;
            bArr[136] = -119;
            bArr[137] = -118;
            bArr[138] = -116;
            bArr[139] = -115;
            bArr[140] = -114;
            bArr[141] = -113;
            bArr[142] = -112;
            bArr[143] = -111;
            bArr[144] = -110;
            bArr[145] = -109;
            bArr[146] = -108;
            bArr[147] = -107;
            bArr[148] = -24;
            bArr[149] = 0;
            bArr[150] = 0;
            bArr[151] = 0;
            bArr[152] = 0;
            bArr[153] = 0;
            bArr[154] = 0;
            bArr[155] = 0;
            bArr[156] = 0;
            bArr[157] = 0;
            bArr[158] = 0;
            bArr[159] = 0;
            bArr[160] = 0;
            bArr[161] = -24;
            bArr[162] = -40;
            bArr[163] = 0;
            bArr[164] = 0;
            bArr[165] = -60;
            bArr[166] = -58;
            bArr[167] = 0;
            bArr[168] = 0;
            bArr[169] = -16;
            bArr[170] = 0;
            bArr[171] = 0;
            bArr[172] = 0;
            bArr[173] = 0;
            bArr[174] = 0;
            bArr[175] = 0;
            bArr[176] = 0;
            bArr[177] = 0;
            bArr[178] = 0;
            bArr[179] = -36;
            bArr[180] = 0;
            bArr[181] = 0;
            bArr[182] = 0;
            bArr[183] = 0;
            bArr[184] = 0;
            bArr[185] = 0;
            bArr[186] = 0;
            bArr[187] = 0;
            bArr[188] = 0;
            bArr[189] = 0;
            bArr[190] = 0;
            table = bArr;
        }
    }

    private static class Cp437Conversion implements ExtraEncoding {
        private static IntHashtable c2b = new IntHashtable();
        private static final char[] table = {Barcode128.CODE_C, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, Barcode128.FNC3, Barcode128.FNC2, 201, 230, Barcode128.SHIFT, 244, 246, 242, 251, 249, 255, 214, 220, Typography.cent, Typography.pound, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, Typography.half, 188, 161, Typography.leftGuillemete, Typography.rightGuillemete, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, Typography.plusMinus, Typography.greaterOrEqual, Typography.lessOrEqual, 8992, 8993, 247, Typography.almostEqual, Typography.degree, 8729, Typography.middleDot, 8730, 8319, 178, 9632, Typography.nbsp};

        private Cp437Conversion() {
        }

        static {
            int i = 0;
            while (true) {
                char[] cArr = table;
                if (i < cArr.length) {
                    c2b.put(cArr[i], i + 128);
                    i++;
                } else {
                    return;
                }
            }
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            int i;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i2 = 0;
            for (char c : charArray) {
                if (c < 128) {
                    i = i2 + 1;
                    bArr[i2] = (byte) c;
                } else {
                    byte b = (byte) c2b.get(c);
                    if (b != 0) {
                        i = i2 + 1;
                        bArr[i2] = b;
                    }
                }
                i2 = i;
            }
            if (i2 == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            if (c < 128) {
                return new byte[]{(byte) c};
            }
            byte b = (byte) c2b.get(c);
            if (b == 0) {
                return new byte[0];
            }
            return new byte[]{b};
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            int i;
            int length = bArr.length;
            char[] cArr = new char[length];
            int i2 = 0;
            for (byte b : bArr) {
                byte b2 = b & UByte.MAX_VALUE;
                if (b2 >= 32) {
                    if (b2 < 128) {
                        i = i2 + 1;
                        cArr[i2] = (char) b2;
                    } else {
                        i = i2 + 1;
                        cArr[i2] = table[b2 + ByteCompanionObject.MIN_VALUE];
                    }
                    i2 = i;
                }
            }
            return new String(cArr, 0, i2);
        }
    }

    private static class SymbolConversion implements ExtraEncoding {
        private static final IntHashtable t1 = new IntHashtable();
        private static final IntHashtable t2 = new IntHashtable();
        private static final char[] table1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', '!', 8704, '#', 8707, '%', Typography.amp, 8715, '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', ':', ';', Typography.less, '=', Typography.greater, '?', 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, '[', 8756, ']', 8869, '_', 773, 945, 946, 967, 948, 949, 981, 947, 951, 953, 966, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, '{', '|', '}', '~', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Typography.euro, 978, Typography.prime, Typography.lessOrEqual, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8592, 8593, 8594, 8595, Typography.degree, Typography.plusMinus, Typography.doublePrime, Typography.greaterOrEqual, Typography.times, 8733, 8706, Typography.bullet, 247, Typography.notEqual, 8801, Typography.almostEqual, Typography.ellipsis, 9474, 9472, 8629, 8501, 8465, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, Typography.registered, Typography.copyright, Typography.tm, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 0, 0, 0, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 0, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 0};
        private static final char[] table2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', 9985, 9986, 9987, 9988, 9742, 9990, 9991, 9992, 9993, 9755, 9758, 9996, 9997, 9998, 9999, 10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 10021, 10022, 10023, 9733, 10025, 10026, 10027, 10028, 10029, 10030, 10031, 10032, 10033, 10034, 10035, 10036, 10037, 10038, 10039, 10040, 10041, 10042, 10043, 10044, 10045, 10046, 10047, 10048, 10049, 10050, 10051, 10052, 10053, 10054, 10055, 10056, 10057, 10058, 10059, 9679, 10061, 9632, 10063, 10064, 10065, 10066, 9650, 9660, 9670, 10070, 9687, 10072, 10073, 10074, 10075, 10076, 10077, 10078, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10081, 10082, 10083, 10084, 10085, 10086, 10087, 9827, 9830, 9829, 9824, 9312, 9313, 9314, 9315, 9316, 9317, 9318, 9319, 9320, 9321, 10102, 10103, 10104, 10105, 10106, 10107, 10108, 10109, 10110, 10111, 10112, 10113, 10114, 10115, 10116, 10117, 10118, 10119, 10120, 10121, 10122, 10123, 10124, 10125, 10126, 10127, 10128, 10129, 10130, 10131, 10132, 8594, 8596, 8597, 10136, 10137, 10138, 10139, 10140, 10141, 10142, 10143, 10144, 10145, 10146, 10147, 10148, 10149, 10150, 10151, 10152, 10153, 10154, 10155, 10156, 10157, 10158, 10159, 0, 10161, 10162, 10163, 10164, 10165, 10166, 10167, 10168, 10169, 10170, 10171, 10172, 10173, 10174, 0};
        private final char[] byteToChar;
        private IntHashtable translation;

        static {
            for (int i = 0; i < 256; i++) {
                char c = table1[i];
                if (c != 0) {
                    t1.put(c, i);
                }
            }
            for (int i2 = 0; i2 < 256; i2++) {
                char c2 = table2[i2];
                if (c2 != 0) {
                    t2.put(c2, i2);
                }
            }
        }

        SymbolConversion(boolean z) {
            if (z) {
                this.translation = t1;
                this.byteToChar = table1;
                return;
            }
            this.translation = t2;
            this.byteToChar = table2;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i = 0;
            for (char c : charArray) {
                byte b = (byte) this.translation.get(c);
                if (b != 0) {
                    bArr[i] = b;
                    i++;
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            byte b = (byte) this.translation.get(c);
            if (b == 0) {
                return new byte[0];
            }
            return new byte[]{b};
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            int length = bArr.length;
            char[] cArr = new char[length];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                cArr[i2] = this.byteToChar[bArr[i] & UByte.MAX_VALUE];
                i++;
                i2++;
            }
            return new String(cArr, 0, i2);
        }
    }

    private static class SymbolTTConversion implements ExtraEncoding {
        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(char c, String str) {
            char c2 = 65280 & c;
            if (c2 != 0 && c2 != 61440) {
                return new byte[0];
            }
            return new byte[]{(byte) c};
        }

        private SymbolTTConversion() {
        }

        @Override // com.itextpdf.text.pdf.ExtraEncoding
        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int length = charArray.length;
            int i = 0;
            for (char c : charArray) {
                char c2 = 65280 & c;
                if (c2 == 0 || c2 == 61440) {
                    bArr[i] = (byte) c;
                    i++;
                }
            }
            if (i == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
    }
}
