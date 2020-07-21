package com.itextpdf.text.pdf;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.xmp.XMPError;
import org.opencv.videoio.Videoio;

public class Barcode128 extends Barcode {
    private static final byte[][] BARS = {new byte[]{2, 1, 2, 2, 2, 2}, new byte[]{2, 2, 2, 1, 2, 2}, new byte[]{2, 2, 2, 2, 2, 1}, new byte[]{1, 2, 1, 2, 2, 3}, new byte[]{1, 2, 1, 3, 2, 2}, new byte[]{1, 3, 1, 2, 2, 2}, new byte[]{1, 2, 2, 2, 1, 3}, new byte[]{1, 2, 2, 3, 1, 2}, new byte[]{1, 3, 2, 2, 1, 2}, new byte[]{2, 2, 1, 2, 1, 3}, new byte[]{2, 2, 1, 3, 1, 2}, new byte[]{2, 3, 1, 2, 1, 2}, new byte[]{1, 1, 2, 2, 3, 2}, new byte[]{1, 2, 2, 1, 3, 2}, new byte[]{1, 2, 2, 2, 3, 1}, new byte[]{1, 1, 3, 2, 2, 2}, new byte[]{1, 2, 3, 1, 2, 2}, new byte[]{1, 2, 3, 2, 2, 1}, new byte[]{2, 2, 3, 2, 1, 1}, new byte[]{2, 2, 1, 1, 3, 2}, new byte[]{2, 2, 1, 2, 3, 1}, new byte[]{2, 1, 3, 2, 1, 2}, new byte[]{2, 2, 3, 1, 1, 2}, new byte[]{3, 1, 2, 1, 3, 1}, new byte[]{3, 1, 1, 2, 2, 2}, new byte[]{3, 2, 1, 1, 2, 2}, new byte[]{3, 2, 1, 2, 2, 1}, new byte[]{3, 1, 2, 2, 1, 2}, new byte[]{3, 2, 2, 1, 1, 2}, new byte[]{3, 2, 2, 2, 1, 1}, new byte[]{2, 1, 2, 1, 2, 3}, new byte[]{2, 1, 2, 3, 2, 1}, new byte[]{2, 3, 2, 1, 2, 1}, new byte[]{1, 1, 1, 3, 2, 3}, new byte[]{1, 3, 1, 1, 2, 3}, new byte[]{1, 3, 1, 3, 2, 1}, new byte[]{1, 1, 2, 3, 1, 3}, new byte[]{1, 3, 2, 1, 1, 3}, new byte[]{1, 3, 2, 3, 1, 1}, new byte[]{2, 1, 1, 3, 1, 3}, new byte[]{2, 3, 1, 1, 1, 3}, new byte[]{2, 3, 1, 3, 1, 1}, new byte[]{1, 1, 2, 1, 3, 3}, new byte[]{1, 1, 2, 3, 3, 1}, new byte[]{1, 3, 2, 1, 3, 1}, new byte[]{1, 1, 3, 1, 2, 3}, new byte[]{1, 1, 3, 3, 2, 1}, new byte[]{1, 3, 3, 1, 2, 1}, new byte[]{3, 1, 3, 1, 2, 1}, new byte[]{2, 1, 1, 3, 3, 1}, new byte[]{2, 3, 1, 1, 3, 1}, new byte[]{2, 1, 3, 1, 1, 3}, new byte[]{2, 1, 3, 3, 1, 1}, new byte[]{2, 1, 3, 1, 3, 1}, new byte[]{3, 1, 1, 1, 2, 3}, new byte[]{3, 1, 1, 3, 2, 1}, new byte[]{3, 3, 1, 1, 2, 1}, new byte[]{3, 1, 2, 1, 1, 3}, new byte[]{3, 1, 2, 3, 1, 1}, new byte[]{3, 3, 2, 1, 1, 1}, new byte[]{3, 1, 4, 1, 1, 1}, new byte[]{2, 2, 1, 4, 1, 1}, new byte[]{4, 3, 1, 1, 1, 1}, new byte[]{1, 1, 1, 2, 2, 4}, new byte[]{1, 1, 1, 4, 2, 2}, new byte[]{1, 2, 1, 1, 2, 4}, new byte[]{1, 2, 1, 4, 2, 1}, new byte[]{1, 4, 1, 1, 2, 2}, new byte[]{1, 4, 1, 2, 2, 1}, new byte[]{1, 1, 2, 2, 1, 4}, new byte[]{1, 1, 2, 4, 1, 2}, new byte[]{1, 2, 2, 1, 1, 4}, new byte[]{1, 2, 2, 4, 1, 1}, new byte[]{1, 4, 2, 1, 1, 2}, new byte[]{1, 4, 2, 2, 1, 1}, new byte[]{2, 4, 1, 2, 1, 1}, new byte[]{2, 2, 1, 1, 1, 4}, new byte[]{4, 1, 3, 1, 1, 1}, new byte[]{2, 4, 1, 1, 1, 2}, new byte[]{1, 3, 4, 1, 1, 1}, new byte[]{1, 1, 1, 2, 4, 2}, new byte[]{1, 2, 1, 1, 4, 2}, new byte[]{1, 2, 1, 2, 4, 1}, new byte[]{1, 1, 4, 2, 1, 2}, new byte[]{1, 2, 4, 1, 1, 2}, new byte[]{1, 2, 4, 2, 1, 1}, new byte[]{4, 1, 1, 2, 1, 2}, new byte[]{4, 2, 1, 1, 1, 2}, new byte[]{4, 2, 1, 2, 1, 1}, new byte[]{2, 1, 2, 1, 4, 1}, new byte[]{2, 1, 4, 1, 2, 1}, new byte[]{4, 1, 2, 1, 2, 1}, new byte[]{1, 1, 1, 1, 4, 3}, new byte[]{1, 1, 1, 3, 4, 1}, new byte[]{1, 3, 1, 1, 4, 1}, new byte[]{1, 1, 4, 1, 1, 3}, new byte[]{1, 1, 4, 3, 1, 1}, new byte[]{4, 1, 1, 1, 1, 3}, new byte[]{4, 1, 1, 3, 1, 1}, new byte[]{1, 1, 3, 1, 4, 1}, new byte[]{1, 1, 4, 1, 3, 1}, new byte[]{3, 1, 1, 1, 4, 1}, new byte[]{4, 1, 1, 1, 3, 1}, new byte[]{2, 1, 1, 4, 1, 2}, new byte[]{2, 1, 1, 2, 1, 4}, new byte[]{2, 1, 1, 2, 3, 2}};
    private static final byte[] BARS_STOP = {2, 3, 3, 1, 1, 1, 2};
    public static final char CODE_A = 200;
    public static final char CODE_AB_TO_C = 'c';
    public static final char CODE_AC_TO_B = 'd';
    public static final char CODE_BC_TO_A = 'e';
    public static final char CODE_C = 199;
    public static final char DEL = 195;
    public static final char FNC1 = 202;
    public static final char FNC1_INDEX = 'f';
    public static final char FNC2 = 197;
    public static final char FNC3 = 196;
    public static final char FNC4 = 200;
    public static final char SHIFT = 198;
    public static final char STARTA = 203;
    public static final char STARTB = 204;
    public static final char STARTC = 205;
    public static final char START_A = 'g';
    public static final char START_B = 'h';
    public static final char START_C = 'i';
    private static final IntHashtable ais;
    private Barcode128CodeSet codeSet = Barcode128CodeSet.AUTO;

    static {
        IntHashtable intHashtable = new IntHashtable();
        ais = intHashtable;
        intHashtable.put(0, 20);
        ais.put(1, 16);
        ais.put(2, 16);
        ais.put(10, -1);
        ais.put(11, 9);
        ais.put(12, 8);
        ais.put(13, 8);
        ais.put(15, 8);
        ais.put(17, 8);
        ais.put(20, 4);
        ais.put(21, -1);
        ais.put(22, -1);
        ais.put(23, -1);
        ais.put(240, -1);
        ais.put(241, -1);
        ais.put(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, -1);
        ais.put(251, -1);
        ais.put(252, -1);
        ais.put(30, -1);
        for (int i = 3100; i < 3700; i++) {
            ais.put(i, 10);
        }
        ais.put(37, -1);
        for (int i2 = 3900; i2 < 3940; i2++) {
            ais.put(i2, -1);
        }
        ais.put(400, -1);
        ais.put(401, -1);
        ais.put(402, 20);
        ais.put(403, -1);
        for (int i3 = 410; i3 < 416; i3++) {
            ais.put(i3, 16);
        }
        ais.put(420, -1);
        ais.put(421, -1);
        ais.put(422, 6);
        ais.put(423, -1);
        ais.put(424, 6);
        ais.put(425, 6);
        ais.put(426, 6);
        ais.put(7001, 17);
        ais.put(7002, -1);
        for (int i4 = 7030; i4 < 7040; i4++) {
            ais.put(i4, -1);
        }
        ais.put(Videoio.CV_CAP_PROP_ANDROID_FLASH_MODE, 18);
        ais.put(Videoio.CV_CAP_PROP_ANDROID_FOCUS_MODE, -1);
        ais.put(Videoio.CV_CAP_PROP_ANDROID_WHITE_BALANCE, -1);
        ais.put(Videoio.CV_CAP_PROP_ANDROID_ANTIBANDING, -1);
        ais.put(Videoio.CV_CAP_PROP_ANDROID_FOCAL_LENGTH, 10);
        ais.put(Videoio.CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_NEAR, 22);
        ais.put(Videoio.CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_OPTIMAL, -1);
        ais.put(Videoio.CV_CAP_PROP_ANDROID_FOCUS_DISTANCE_FAR, -1);
        ais.put(8018, 22);
        ais.put(8020, -1);
        ais.put(8100, 10);
        ais.put(8101, 14);
        ais.put(8102, 6);
        for (int i5 = 90; i5 < 100; i5++) {
            ais.put(i5, -1);
        }
    }

    public Barcode128() {
        try {
            this.x = 0.8f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = this.size;
            this.barHeight = this.size * 3.0f;
            this.textAlignment = 1;
            this.codeType = 9;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* renamed from: com.itextpdf.text.pdf.Barcode128$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet[] r0 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.itextpdf.text.pdf.Barcode128.AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet = r0
                com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r1 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.A     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.itextpdf.text.pdf.Barcode128.AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r1 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.B     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.itextpdf.text.pdf.Barcode128.AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r1 = com.itextpdf.text.pdf.Barcode128.Barcode128CodeSet.C     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Barcode128.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Barcode128CodeSet {
        A,
        B,
        C,
        AUTO;

        public char getStartSymbol() {
            int i = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$Barcode128$Barcode128CodeSet[ordinal()];
            if (i != 1) {
                return i != 3 ? Barcode128.START_B : Barcode128.START_C;
            }
            return Barcode128.START_A;
        }
    }

    public void setCodeSet(Barcode128CodeSet barcode128CodeSet) {
        this.codeSet = barcode128CodeSet;
    }

    public Barcode128CodeSet getCodeSet() {
        return this.codeSet;
    }

    public static String removeFNC1(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= ' ' && charAt <= '~') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String getHumanReadableUCCEAN(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String valueOf = String.valueOf((char) FNC1);
        while (true) {
            try {
                if (str.startsWith(valueOf)) {
                    str = str.substring(1);
                } else {
                    int i = 2;
                    int i2 = 0;
                    while (true) {
                        if (i >= 5) {
                            break;
                        } else if (str.length() < i) {
                            break;
                        } else {
                            i2 = ais.get(Integer.parseInt(str.substring(0, i)));
                            if (i2 != 0) {
                                break;
                            }
                            i++;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        break;
                    }
                    stringBuffer.append('(');
                    stringBuffer.append(str.substring(0, i));
                    stringBuffer.append(')');
                    str = str.substring(i);
                    if (i2 > 0) {
                        int i3 = i2 - i;
                        if (str.length() <= i3) {
                            break;
                        }
                        stringBuffer.append(removeFNC1(str.substring(0, i3)));
                        str = str.substring(i3);
                    } else {
                        int indexOf = str.indexOf(XMPError.BADRDF);
                        if (indexOf < 0) {
                            break;
                        }
                        stringBuffer.append(str.substring(0, indexOf));
                        str = str.substring(indexOf + 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
        stringBuffer.append(removeFNC1(str));
        return stringBuffer.toString();
    }

    static boolean isNextDigits(String str, int i, int i2) {
        int length = str.length();
        loop0:
        while (i < length && i2 > 0) {
            if (str.charAt(i) == 202) {
                i++;
            } else {
                int min = Math.min(2, i2);
                if (i + min > length) {
                    return false;
                }
                while (true) {
                    int i3 = min - 1;
                    if (min <= 0) {
                        continue;
                        break;
                    }
                    int i4 = i + 1;
                    char charAt = str.charAt(i);
                    if (charAt < '0' || charAt > '9') {
                        return false;
                    }
                    i2--;
                    i = i4;
                    min = i3;
                }
                return false;
            }
        }
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    static String getPackedRawDigits(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder("");
        int i3 = i;
        while (i2 > 0) {
            if (str.charAt(i3) == 202) {
                sb.append(FNC1_INDEX);
                i3++;
            } else {
                i2 -= 2;
                int i4 = i3 + 1;
                sb.append((char) (((str.charAt(i3) - '0') * 10) + (str.charAt(i4) - '0')));
                i3 = i4 + 1;
            }
        }
        return ((char) (i3 - i)) + sb.toString();
    }

    public static String getRawText(String str, boolean z, Barcode128CodeSet barcode128CodeSet) {
        int i;
        char c;
        String str2;
        String str3;
        String str4;
        int i2;
        int charAt;
        String str5;
        String str6;
        String str7;
        int i3;
        int length = str.length();
        if (length == 0) {
            String str8 = "" + barcode128CodeSet.getStartSymbol();
            if (!z) {
                return str8;
            }
            return str8 + FNC1_INDEX;
        }
        int i4 = 0;
        while (i4 < length) {
            char charAt2 = str.charAt(i4);
            if (charAt2 <= 127 || charAt2 == 202) {
                i4++;
            } else {
                throw new RuntimeException(MessageLocalization.getComposedMessage("there.are.illegal.characters.for.barcode.128.in.1", str));
            }
        }
        char charAt3 = str.charAt(0);
        if ((barcode128CodeSet == Barcode128CodeSet.AUTO || barcode128CodeSet == Barcode128CodeSet.C) && isNextDigits(str, 0, 2)) {
            String str9 = HtmlTags.I;
            if (z) {
                str9 = str9 + FNC1_INDEX;
            }
            String packedRawDigits = getPackedRawDigits(str, 0, 2);
            i = packedRawDigits.charAt(0) + 0;
            str2 = str9 + packedRawDigits.substring(1);
            c = START_C;
        } else {
            if (charAt3 < ' ') {
                String str10 = "g";
                if (z) {
                    str10 = str10 + FNC1_INDEX;
                }
                str2 = str10 + ((char) (charAt3 + '@'));
                c = START_A;
            } else {
                String str11 = "h";
                if (z) {
                    str11 = str11 + FNC1_INDEX;
                }
                if (charAt3 == 202) {
                    str2 = str11 + FNC1_INDEX;
                } else {
                    str2 = str11 + ((char) (charAt3 - ' '));
                }
                c = START_B;
            }
            i = 1;
        }
        if (barcode128CodeSet == Barcode128CodeSet.AUTO || c == barcode128CodeSet.getStartSymbol()) {
            while (i < length) {
                switch (c) {
                    case 'g':
                        if (barcode128CodeSet == Barcode128CodeSet.AUTO && isNextDigits(str, i, 4)) {
                            String packedRawDigits2 = getPackedRawDigits(str, i, 4);
                            charAt = i + packedRawDigits2.charAt(0);
                            str5 = (str2 + CODE_AB_TO_C) + packedRawDigits2.substring(1);
                            c = START_C;
                            break;
                        } else {
                            int i5 = i + 1;
                            char charAt4 = str.charAt(i);
                            if (charAt4 == 202) {
                                str3 = str2 + FNC1_INDEX;
                            } else if (charAt4 > '_') {
                                str4 = (str2 + CODE_AC_TO_B) + ((char) (charAt4 - ' '));
                                i2 = i5;
                                c = START_B;
                                break;
                            } else if (charAt4 < ' ') {
                                str3 = str2 + ((char) (charAt4 + '@'));
                            } else {
                                str3 = str2 + ((char) (charAt4 - ' '));
                            }
                            i = i5;
                            break;
                        }
                        break;
                    case 'h':
                        if (barcode128CodeSet == Barcode128CodeSet.AUTO && isNextDigits(str, i, 4)) {
                            String packedRawDigits3 = getPackedRawDigits(str, i, 4);
                            charAt = i + packedRawDigits3.charAt(0);
                            str5 = (str2 + CODE_AB_TO_C) + packedRawDigits3.substring(1);
                            c = START_C;
                            break;
                        } else {
                            int i6 = i + 1;
                            char charAt5 = str.charAt(i);
                            if (charAt5 == 202) {
                                str6 = str2 + FNC1_INDEX;
                            } else if (charAt5 < ' ') {
                                str7 = (str2 + CODE_BC_TO_A) + ((char) (charAt5 + '@'));
                                i3 = i6;
                                c = START_A;
                                break;
                            } else {
                                str6 = str2 + ((char) (charAt5 - ' '));
                            }
                            i = i6;
                            break;
                        }
                        break;
                    case 'i':
                        if (!isNextDigits(str, i, 2)) {
                            int i7 = i + 1;
                            char charAt6 = str.charAt(i);
                            if (charAt6 != 202) {
                                if (charAt6 >= ' ') {
                                    str4 = (str2 + CODE_AC_TO_B) + ((char) (charAt6 - ' '));
                                    i2 = i7;
                                    c = START_B;
                                    break;
                                } else {
                                    str7 = (str2 + CODE_BC_TO_A) + ((char) (charAt6 + '@'));
                                    i3 = i7;
                                    c = START_A;
                                    break;
                                }
                            } else {
                                str2 = str2 + FNC1_INDEX;
                                i = i7;
                                break;
                            }
                        } else {
                            String packedRawDigits4 = getPackedRawDigits(str, i, 2);
                            i += packedRawDigits4.charAt(0);
                            str2 = str2 + packedRawDigits4.substring(1);
                            break;
                        }
                }
                if (barcode128CodeSet != Barcode128CodeSet.AUTO && c != barcode128CodeSet.getStartSymbol()) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("there.are.illegal.characters.for.barcode.128.in.1", str));
                }
            }
            return str2;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("there.are.illegal.characters.for.barcode.128.in.1", str));
    }

    public static String getRawText(String str, boolean z) {
        return getRawText(str, z, Barcode128CodeSet.AUTO);
    }

    public static byte[] getBarsCode128Raw(String str) {
        int indexOf = str.indexOf(65535);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        int charAt = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            charAt += str.charAt(i) * i;
        }
        String str2 = str + ((char) (charAt % 103));
        byte[] bArr = new byte[(((str2.length() + 1) * 6) + 7)];
        int i2 = 0;
        while (i2 < str2.length()) {
            System.arraycopy(BARS[str2.charAt(i2)], 0, bArr, i2 * 6, 6);
            i2++;
        }
        System.arraycopy(BARS_STOP, 0, bArr, i2 * 6, 7);
        return bArr;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        float f;
        String str;
        float f2;
        String str2;
        boolean z = true;
        float f3 = 0.0f;
        if (this.font != null) {
            if (this.baseline > 0.0f) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            if (this.codeType == 11) {
                int indexOf = this.code.indexOf(65535);
                if (indexOf < 0) {
                    str2 = "";
                } else {
                    str2 = this.code.substring(indexOf + 1);
                }
            } else if (this.codeType == 10) {
                str2 = getHumanReadableUCCEAN(this.code);
            } else {
                str2 = removeFNC1(this.code);
            }
            BaseFont baseFont = this.font;
            if (this.altText != null) {
                str2 = this.altText;
            }
            f3 = baseFont.getWidthPoint(str2, this.size);
            f = f2;
        } else {
            f = 0.0f;
        }
        if (this.codeType == 11) {
            int indexOf2 = this.code.indexOf(65535);
            if (indexOf2 >= 0) {
                str = this.code.substring(0, indexOf2);
            } else {
                str = this.code;
            }
        } else {
            String str3 = this.code;
            if (this.codeType != 10) {
                z = false;
            }
            str = getRawText(str3, z, this.codeSet);
        }
        return new Rectangle(Math.max((((float) ((str.length() + 2) * 11)) * this.x) + (this.x * 2.0f), f3), this.barHeight + f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e7  */
    @Override // com.itextpdf.text.pdf.Barcode
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle placeBarcode(com.itextpdf.text.pdf.PdfContentByte r12, com.itextpdf.text.BaseColor r13, com.itextpdf.text.BaseColor r14) {
        /*
            r11 = this;
            int r0 = r11.codeType
            r1 = 65535(0xffff, float:9.1834E-41)
            r2 = 10
            r3 = 11
            r4 = 1
            if (r0 != r3) goto L_0x001f
            java.lang.String r0 = r11.code
            int r0 = r0.indexOf(r1)
            if (r0 >= 0) goto L_0x0017
            java.lang.String r0 = ""
            goto L_0x0030
        L_0x0017:
            java.lang.String r5 = r11.code
            int r0 = r0 + r4
            java.lang.String r0 = r5.substring(r0)
            goto L_0x0030
        L_0x001f:
            int r0 = r11.codeType
            if (r0 != r2) goto L_0x002a
            java.lang.String r0 = r11.code
            java.lang.String r0 = getHumanReadableUCCEAN(r0)
            goto L_0x0030
        L_0x002a:
            java.lang.String r0 = r11.code
            java.lang.String r0 = removeFNC1(r0)
        L_0x0030:
            com.itextpdf.text.pdf.BaseFont r5 = r11.font
            r6 = 0
            if (r5 == 0) goto L_0x0044
            com.itextpdf.text.pdf.BaseFont r5 = r11.font
            java.lang.String r7 = r11.altText
            if (r7 == 0) goto L_0x003d
            java.lang.String r0 = r11.altText
        L_0x003d:
            float r7 = r11.size
            float r5 = r5.getWidthPoint(r0, r7)
            goto L_0x0045
        L_0x0044:
            r5 = 0
        L_0x0045:
            int r7 = r11.codeType
            r8 = 0
            if (r7 != r3) goto L_0x005c
            java.lang.String r2 = r11.code
            int r1 = r2.indexOf(r1)
            if (r1 < 0) goto L_0x0059
            java.lang.String r2 = r11.code
            java.lang.String r1 = r2.substring(r8, r1)
            goto L_0x006b
        L_0x0059:
            java.lang.String r1 = r11.code
            goto L_0x006b
        L_0x005c:
            java.lang.String r1 = r11.code
            int r7 = r11.codeType
            if (r7 != r2) goto L_0x0064
            r2 = 1
            goto L_0x0065
        L_0x0064:
            r2 = 0
        L_0x0065:
            com.itextpdf.text.pdf.Barcode128$Barcode128CodeSet r7 = r11.codeSet
            java.lang.String r1 = getRawText(r1, r2, r7)
        L_0x006b:
            int r2 = r1.length()
            r7 = 2
            int r2 = r2 + r7
            int r2 = r2 * 11
            float r2 = (float) r2
            float r3 = r11.x
            float r2 = r2 * r3
            float r3 = r11.x
            r9 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 * r9
            float r2 = r2 + r3
            int r3 = r11.textAlignment
            if (r3 == 0) goto L_0x0098
            if (r3 == r7) goto L_0x008f
            int r3 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x008c
            float r5 = r5 - r2
            float r5 = r5 / r9
            goto L_0x0094
        L_0x008c:
            float r2 = r2 - r5
            float r2 = r2 / r9
            goto L_0x0099
        L_0x008f:
            int r3 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0096
            float r5 = r5 - r2
        L_0x0094:
            r2 = 0
            goto L_0x009a
        L_0x0096:
            float r2 = r2 - r5
            goto L_0x0099
        L_0x0098:
            r2 = 0
        L_0x0099:
            r5 = 0
        L_0x009a:
            com.itextpdf.text.pdf.BaseFont r3 = r11.font
            if (r3 == 0) goto L_0x00bb
            float r3 = r11.baseline
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x00aa
            float r3 = r11.barHeight
            float r7 = r11.baseline
            float r3 = r3 - r7
            goto L_0x00bc
        L_0x00aa:
            com.itextpdf.text.pdf.BaseFont r3 = r11.font
            r6 = 3
            float r7 = r11.size
            float r3 = r3.getFontDescriptor(r6, r7)
            float r6 = -r3
            float r3 = r11.baseline
            float r3 = r3 + r6
            r10 = r6
            r6 = r3
            r3 = r10
            goto L_0x00bc
        L_0x00bb:
            r3 = 0
        L_0x00bc:
            byte[] r1 = getBarsCode128Raw(r1)
            if (r13 == 0) goto L_0x00c5
            r12.setColorFill(r13)
        L_0x00c5:
            int r13 = r1.length
            if (r8 >= r13) goto L_0x00e0
            byte r13 = r1[r8]
            float r13 = (float) r13
            float r7 = r11.x
            float r13 = r13 * r7
            if (r4 == 0) goto L_0x00da
            float r7 = r11.inkSpreading
            float r7 = r13 - r7
            float r9 = r11.barHeight
            r12.rectangle(r5, r6, r7, r9)
        L_0x00da:
            r4 = r4 ^ 1
            float r5 = r5 + r13
            int r8 = r8 + 1
            goto L_0x00c5
        L_0x00e0:
            r12.fill()
            com.itextpdf.text.pdf.BaseFont r13 = r11.font
            if (r13 == 0) goto L_0x00ff
            if (r14 == 0) goto L_0x00ec
            r12.setColorFill(r14)
        L_0x00ec:
            r12.beginText()
            com.itextpdf.text.pdf.BaseFont r13 = r11.font
            float r14 = r11.size
            r12.setFontAndSize(r13, r14)
            r12.setTextMatrix(r2, r3)
            r12.showText(r0)
            r12.endText()
        L_0x00ff:
            com.itextpdf.text.Rectangle r12 = r11.getBarcodeSize()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Barcode128.placeBarcode(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.BaseColor, com.itextpdf.text.BaseColor):com.itextpdf.text.Rectangle");
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public void setCode(String str) {
        if (getCodeType() != 10 || !str.startsWith("(")) {
            super.setCode(str);
            return;
        }
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i >= 0) {
            int indexOf = str.indexOf(41, i);
            if (indexOf >= 0) {
                String substring = str.substring(i + 1, indexOf);
                if (substring.length() >= 2) {
                    int parseInt = Integer.parseInt(substring);
                    int i2 = ais.get(parseInt);
                    if (i2 != 0) {
                        String valueOf = String.valueOf(parseInt);
                        if (valueOf.length() == 1) {
                            valueOf = "0" + valueOf;
                        }
                        int indexOf2 = str.indexOf(40, indexOf);
                        int length = indexOf2 < 0 ? str.length() : indexOf2;
                        sb.append(valueOf);
                        sb.append(str.substring(indexOf + 1, length));
                        if (i2 < 0) {
                            if (indexOf2 >= 0) {
                                sb.append(FNC1);
                            }
                        } else if (((length - indexOf) - 1) + valueOf.length() != i2) {
                            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.ai.length.1", valueOf));
                        }
                        i = indexOf2;
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("ai.not.found.1", substring));
                    }
                } else {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("ai.too.short.1", substring));
                }
            } else {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("badly.formed.ucc.string.1", str));
            }
        }
        super.setCode(sb.toString());
    }
}
