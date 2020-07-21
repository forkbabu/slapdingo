package com.itextpdf.text.xml;

import com.itextpdf.text.xml.xmp.XmpWriter;
import kotlin.UByte;

public class XMLUtil {
    public static boolean isValidCharacterValue(int i) {
        return i == 9 || i == 10 || i == 13 || (i >= 32 && i <= 55295) || ((i >= 57344 && i <= 65533) || (i >= 65536 && i <= 1114111));
    }

    public static String escapeXML(String str, boolean z) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : charArray) {
            if (c == '\"') {
                stringBuffer.append("&quot;");
            } else if (c == '<') {
                stringBuffer.append("&lt;");
            } else if (c == '>') {
                stringBuffer.append("&gt;");
            } else if (c == '&') {
                stringBuffer.append("&amp;");
            } else if (c == '\'') {
                stringBuffer.append("&apos;");
            } else if (isValidCharacterValue(c)) {
                if (!z || c <= 127) {
                    stringBuffer.append((char) c);
                } else {
                    stringBuffer.append("&#");
                    stringBuffer.append((int) c);
                    stringBuffer.append(';');
                }
            }
        }
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: char} */
    /* JADX WARN: Multi-variable type inference failed */
    public static String unescapeXML(String str) {
        int i;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < length) {
            char c = charArray[i2];
            if (c == '&' && (i = findInArray(';', charArray, i2 + 3)) > -1) {
                String str2 = new String(charArray, i2 + 1, (i - i2) - 1);
                if (str2.startsWith("#")) {
                    String substring = str2.substring(1);
                    if (isValidCharacterValue(substring)) {
                        c = (char) Integer.parseInt(substring);
                        i2 = i;
                    } else {
                        i2 = i + 1;
                    }
                } else {
                    int unescape = unescape(str2);
                    if (unescape > 0) {
                        i2 = i;
                        c = unescape;
                    }
                }
            }
            stringBuffer.append((char) c);
            i = i2;
            i2 = i + 1;
        }
        return stringBuffer.toString();
    }

    public static int unescape(String str) {
        if ("apos".equals(str)) {
            return 39;
        }
        if ("quot".equals(str)) {
            return 34;
        }
        if ("lt".equals(str)) {
            return 60;
        }
        if ("gt".equals(str)) {
            return 62;
        }
        return "amp".equals(str) ? 38 : -1;
    }

    public static boolean isValidCharacterValue(String str) {
        try {
            return isValidCharacterValue(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static int findInArray(char c, char[] cArr, int i) {
        while (i < cArr.length) {
            if (cArr[i] == ';') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String getEncodingName(byte[] bArr) {
        byte b = bArr[0] & UByte.MAX_VALUE;
        byte b2 = bArr[1] & UByte.MAX_VALUE;
        if (b == 254 && b2 == 255) {
            return XmpWriter.UTF16BE;
        }
        if (b == 255 && b2 == 254) {
            return XmpWriter.UTF16LE;
        }
        byte b3 = bArr[2] & UByte.MAX_VALUE;
        if (b == 239 && b2 == 187 && b3 == 191) {
            return XmpWriter.UTF8;
        }
        byte b4 = bArr[3] & UByte.MAX_VALUE;
        if (b == 0 && b2 == 0 && b3 == 0 && b4 == 60) {
            return "ISO-10646-UCS-4";
        }
        if (b == 60 && b2 == 0 && b3 == 0 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 0 && b3 == 60 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 60 && b3 == 0 && b4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (b == 0 && b2 == 60 && b3 == 0 && b4 == 63) {
            return XmpWriter.UTF16BE;
        }
        if (b == 60 && b2 == 0 && b3 == 63 && b4 == 0) {
            return XmpWriter.UTF16LE;
        }
        if (b == 76 && b2 == 111 && b3 == 167 && b4 == 148) {
            return "CP037";
        }
        return XmpWriter.UTF8;
    }
}
