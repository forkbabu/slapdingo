package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.BidiLine;
import com.itextpdf.text.pdf.BidiOrder;
import java.util.HashMap;
import org.opencv.videoio.Videoio;

public class ArabicLigaturizer implements LanguageProcessor {
    private static final char ALEF = 1575;
    private static final char ALEFHAMZA = 1571;
    private static final char ALEFHAMZABELOW = 1573;
    private static final char ALEFMADDA = 1570;
    private static final char ALEFMAKSURA = 1609;
    private static final char DAMMA = 1615;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGITS_MASK = 224;
    private static final int DIGITS_RESERVED = 160;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final int DIGIT_TYPE_MASK = 256;
    private static final char FARSIYEH = 1740;
    private static final char FATHA = 1614;
    private static final char HAMZA = 1569;
    private static final char HAMZAABOVE = 1620;
    private static final char HAMZABELOW = 1621;
    private static final char KASRA = 1616;
    private static final char LAM = 1604;
    private static final char LAM_ALEF = 65275;
    private static final char LAM_ALEFHAMZA = 65271;
    private static final char LAM_ALEFHAMZABELOW = 65273;
    private static final char LAM_ALEFMADDA = 65269;
    private static final char MADDA = 1619;
    private static final char SHADDA = 1617;
    private static final char TATWEEL = 1600;
    private static final char WAW = 1608;
    private static final char WAWHAMZA = 1572;
    private static final char YEH = 1610;
    private static final char YEHHAMZA = 1574;
    private static final char ZWJ = 8205;
    public static final int ar_composedtashkeel = 4;
    public static final int ar_lig = 8;
    public static final int ar_nothing = 0;
    public static final int ar_novowel = 1;
    private static final char[][] chartable;
    private static final HashMap<Character, char[]> maptable = new HashMap<>();
    private static final HashMap<Character, Character> reverseLigatureMapTable = new HashMap<>();
    protected int options = 0;
    protected int runDirection = 3;

    static boolean isVowel(char c) {
        return (c >= 1611 && c <= 1621) || c == 1648;
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public boolean isRTL() {
        return true;
    }

    static {
        char[][] cArr = {new char[]{HAMZA, 65152}, new char[]{ALEFMADDA, 65153, 65154}, new char[]{ALEFHAMZA, 65155, 65156}, new char[]{WAWHAMZA, 65157, 65158}, new char[]{ALEFHAMZABELOW, 65159, 65160}, new char[]{YEHHAMZA, 65161, 65162, 65163, 65164}, new char[]{ALEF, 65165, 65166}, new char[]{1576, 65167, 65168, 65169, 65170}, new char[]{1577, 65171, 65172}, new char[]{1578, 65173, 65174, 65175, 65176}, new char[]{1579, 65177, 65178, 65179, 65180}, new char[]{1580, 65181, 65182, 65183, 65184}, new char[]{1581, 65185, 65186, 65187, 65188}, new char[]{1582, 65189, 65190, 65191, 65192}, new char[]{1583, 65193, 65194}, new char[]{1584, 65195, 65196}, new char[]{1585, 65197, 65198}, new char[]{1586, 65199, 65200}, new char[]{1587, 65201, 65202, 65203, 65204}, new char[]{1588, 65205, 65206, 65207, 65208}, new char[]{1589, 65209, 65210, 65211, 65212}, new char[]{1590, 65213, 65214, 65215, 65216}, new char[]{1591, 65217, 65218, 65219, 65220}, new char[]{1592, 65221, 65222, 65223, 65224}, new char[]{1593, 65225, 65226, 65227, 65228}, new char[]{1594, 65229, 65230, 65231, 65232}, new char[]{TATWEEL, TATWEEL, TATWEEL, TATWEEL, TATWEEL}, new char[]{1601, 65233, 65234, 65235, 65236}, new char[]{1602, 65237, 65238, 65239, 65240}, new char[]{1603, 65241, 65242, 65243, 65244}, new char[]{LAM, 65245, 65246, 65247, 65248}, new char[]{1605, 65249, 65250, 65251, 65252}, new char[]{1606, 65253, 65254, 65255, 65256}, new char[]{1607, 65257, 65258, 65259, 65260}, new char[]{WAW, 65261, 65262}, new char[]{ALEFMAKSURA, 65263, 65264, 64488, 64489}, new char[]{YEH, 65265, 65266, 65267, 65268}, new char[]{1649, 64336, 64337}, new char[]{1657, 64358, 64359, 64360, 64361}, new char[]{1658, 64350, 64351, 64352, 64353}, new char[]{1659, 64338, 64339, 64340, 64341}, new char[]{1662, 64342, 64343, 64344, 64345}, new char[]{1663, 64354, 64355, 64356, 64357}, new char[]{1664, 64346, 64347, 64348, 64349}, new char[]{1667, 64374, 64375, 64376, 64377}, new char[]{1668, 64370, 64371, 64372, 64373}, new char[]{1670, 64378, 64379, 64380, 64381}, new char[]{1671, 64382, 64383, 64384, 64385}, new char[]{1672, 64392, 64393}, new char[]{1676, 64388, 64389}, new char[]{1677, 64386, 64387}, new char[]{1678, 64390, 64391}, new char[]{1681, 64396, 64397}, new char[]{1688, 64394, 64395}, new char[]{1700, 64362, 64363, 64364, 64365}, new char[]{1702, 64366, 64367, 64368, 64369}, new char[]{1705, 64398, 64399, 64400, 64401}, new char[]{1709, 64467, 64468, 64469, 64470}, new char[]{1711, 64402, 64403, 64404, 64405}, new char[]{1713, 64410, 64411, 64412, 64413}, new char[]{1715, 64406, 64407, 64408, 64409}, new char[]{1722, 64414, 64415}, new char[]{1723, 64416, 64417, 64418, 64419}, new char[]{1726, 64426, 64427, 64428, 64429}, new char[]{1728, 64420, 64421}, new char[]{1729, 64422, 64423, 64424, 64425}, new char[]{1733, 64480, 64481}, new char[]{1734, 64473, 64474}, new char[]{1735, 64471, 64472}, new char[]{1736, 64475, 64476}, new char[]{1737, 64482, 64483}, new char[]{1739, 64478, 64479}, new char[]{FARSIYEH, 64508, 64509, 64510, 64511}, new char[]{1744, 64484, 64485, 64486, 64487}, new char[]{1746, 64430, 64431}, new char[]{1747, 64432, 64433}};
        chartable = cArr;
        for (char[] cArr2 : cArr) {
            maptable.put(Character.valueOf(cArr2[0]), cArr2);
            int length = cArr2.length;
            if (length != 3) {
                if (length == 5) {
                    reverseLigatureMapTable.put(Character.valueOf(cArr2[4]), Character.valueOf(cArr2[3]));
                }
                if (cArr2[0] != 1591 || cArr2[0] == 1592) {
                    reverseLigatureMapTable.put(Character.valueOf(cArr2[4]), Character.valueOf(cArr2[1]));
                    reverseLigatureMapTable.put(Character.valueOf(cArr2[3]), Character.valueOf(cArr2[1]));
                }
            }
            reverseLigatureMapTable.put(Character.valueOf(cArr2[2]), Character.valueOf(cArr2[1]));
            reverseLigatureMapTable.put(Character.valueOf(cArr2[1]), Character.valueOf(cArr2[0]));
            if (cArr2[0] != 1591) {
            }
            reverseLigatureMapTable.put(Character.valueOf(cArr2[4]), Character.valueOf(cArr2[1]));
            reverseLigatureMapTable.put(Character.valueOf(cArr2[3]), Character.valueOf(cArr2[1]));
        }
    }

    static char charshape(char c, int i) {
        if (c < 1569 || c > 1747) {
            return (c < 65269 || c > 65275) ? c : (char) (c + i);
        }
        char[] cArr = maptable.get(Character.valueOf(c));
        return cArr != null ? cArr[i + 1] : c;
    }

    static int shapecount(char c) {
        if (c >= 1569 && c <= 1747 && !isVowel(c)) {
            char[] cArr = maptable.get(Character.valueOf(c));
            if (cArr != null) {
                return cArr.length - 1;
            }
        } else if (c == 8205) {
            return 4;
        }
        return 1;
    }

    static int ligature(char c, charstruct charstruct2) {
        if (charstruct2.basechar == 0) {
            return 0;
        }
        int i = 2;
        if (isVowel(c)) {
            int i2 = (charstruct2.vowel == 0 || c == 1617) ? 1 : 2;
            switch (c) {
                case 1617:
                    if (charstruct2.mark1 == 0) {
                        charstruct2.mark1 = SHADDA;
                        i = i2;
                        break;
                    } else {
                        return 0;
                    }
                case 1618:
                default:
                    charstruct2.vowel = c;
                    i = i2;
                    break;
                case 1619:
                    if (charstruct2.basechar == 1575) {
                        charstruct2.basechar = ALEFMADDA;
                        break;
                    }
                    i = i2;
                    break;
                case 1620:
                    char c2 = charstruct2.basechar;
                    if (c2 == 1575) {
                        charstruct2.basechar = ALEFHAMZA;
                        break;
                    } else {
                        if (c2 != 1740) {
                            if (c2 == 65275) {
                                charstruct2.basechar = LAM_ALEFHAMZA;
                                break;
                            } else {
                                switch (c2) {
                                    case 1608:
                                        charstruct2.basechar = WAWHAMZA;
                                        break;
                                    case 1609:
                                    case Videoio.CAP_OPENNI2_ASUS /*{ENCODED_INT: 1610}*/:
                                        break;
                                    default:
                                        charstruct2.mark1 = HAMZAABOVE;
                                        i = i2;
                                        break;
                                }
                            }
                        }
                        charstruct2.basechar = YEHHAMZA;
                        break;
                    }
                case 1621:
                    char c3 = charstruct2.basechar;
                    if (c3 != 1575) {
                        if (c3 == 65275) {
                            charstruct2.basechar = LAM_ALEFHAMZABELOW;
                            break;
                        } else {
                            charstruct2.mark1 = HAMZABELOW;
                            i = i2;
                            break;
                        }
                    } else {
                        charstruct2.basechar = ALEFHAMZABELOW;
                        break;
                    }
            }
            if (i == 1) {
                charstruct2.lignum++;
            }
            return i;
        } else if (charstruct2.vowel != 0) {
            return 0;
        } else {
            char c4 = charstruct2.basechar;
            if (c4 == 0) {
                charstruct2.basechar = c;
                charstruct2.numshapes = shapecount(c);
                return 1;
            } else if (c4 != 1604) {
                return 0;
            } else {
                if (c == 1570) {
                    charstruct2.basechar = LAM_ALEFMADDA;
                    charstruct2.numshapes = 2;
                } else if (c == 1571) {
                    charstruct2.basechar = LAM_ALEFHAMZA;
                    charstruct2.numshapes = 2;
                } else if (c == 1573) {
                    charstruct2.basechar = LAM_ALEFHAMZABELOW;
                    charstruct2.numshapes = 2;
                } else if (c != 1575) {
                    return 0;
                } else {
                    charstruct2.basechar = LAM_ALEF;
                    charstruct2.numshapes = 2;
                }
                return 3;
            }
        }
    }

    static void copycstostring(StringBuffer stringBuffer, charstruct charstruct2, int i) {
        if (charstruct2.basechar != 0) {
            stringBuffer.append(charstruct2.basechar);
            charstruct2.lignum--;
            if (charstruct2.mark1 != 0) {
                if ((i & 1) == 0) {
                    stringBuffer.append(charstruct2.mark1);
                    charstruct2.lignum--;
                } else {
                    charstruct2.lignum--;
                }
            }
            if (charstruct2.vowel == 0) {
                return;
            }
            if ((i & 1) == 0) {
                stringBuffer.append(charstruct2.vowel);
                charstruct2.lignum--;
                return;
            }
            charstruct2.lignum--;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r10.charAt(r2) == 1617) goto L_0x004e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void doublelig(java.lang.StringBuffer r10, int r11) {
        /*
            int r0 = r10.length()
            r1 = 0
            r2 = 1
            r3 = r0
            r4 = 0
        L_0x0008:
            if (r2 >= r0) goto L_0x013b
            r5 = r11 & 4
            r6 = 64610(0xfc62, float:9.0538E-41)
            r7 = 64609(0xfc61, float:9.0536E-41)
            r8 = 64608(0xfc60, float:9.0535E-41)
            if (r5 == 0) goto L_0x0052
            char r5 = r10.charAt(r4)
            r9 = 1617(0x651, float:2.266E-42)
            switch(r5) {
                case 1614: goto L_0x0048;
                case 1615: goto L_0x003e;
                case 1616: goto L_0x0037;
                case 1617: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0052
        L_0x0021:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 1612: goto L_0x0030;
                case 1613: goto L_0x0029;
                case 1614: goto L_0x004e;
                case 1615: goto L_0x0044;
                case 1616: goto L_0x0053;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0052
        L_0x0029:
            r5 = 64607(0xfc5f, float:9.0534E-41)
            r6 = 64607(0xfc5f, float:9.0534E-41)
            goto L_0x0053
        L_0x0030:
            r5 = 64606(0xfc5e, float:9.0532E-41)
            r6 = 64606(0xfc5e, float:9.0532E-41)
            goto L_0x0053
        L_0x0037:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0052
            goto L_0x0053
        L_0x003e:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0052
        L_0x0044:
            r6 = 64609(0xfc61, float:9.0536E-41)
            goto L_0x0053
        L_0x0048:
            char r5 = r10.charAt(r2)
            if (r5 != r9) goto L_0x0052
        L_0x004e:
            r6 = 64608(0xfc60, float:9.0535E-41)
            goto L_0x0053
        L_0x0052:
            r6 = 0
        L_0x0053:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x0126
            char r5 = r10.charAt(r4)
            r7 = 65192(0xfea8, float:9.1353E-41)
            r8 = 65188(0xfea4, float:9.1348E-41)
            r9 = 65184(0xfea0, float:9.1342E-41)
            switch(r5) {
                case 65169: goto L_0x0110;
                case 65175: goto L_0x00f9;
                case 65235: goto L_0x00eb;
                case 65247: goto L_0x00c1;
                case 65251: goto L_0x00a4;
                case 65255: goto L_0x0089;
                case 65256: goto L_0x0069;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x0126
        L_0x0069:
            char r5 = r10.charAt(r2)
            r7 = 65198(0xfeae, float:9.1362E-41)
            if (r5 == r7) goto L_0x0081
            r7 = 65200(0xfeb0, float:9.1365E-41)
            if (r5 == r7) goto L_0x0079
            goto L_0x0126
        L_0x0079:
            r5 = 64651(0xfc8b, float:9.0595E-41)
            r6 = 64651(0xfc8b, float:9.0595E-41)
            goto L_0x0126
        L_0x0081:
            r5 = 64650(0xfc8a, float:9.0594E-41)
            r6 = 64650(0xfc8a, float:9.0594E-41)
            goto L_0x0126
        L_0x0089:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x009f
            if (r5 == r8) goto L_0x009a
            if (r5 == r7) goto L_0x0095
            goto L_0x0126
        L_0x0095:
            r6 = 64724(0xfcd4, float:9.0698E-41)
            goto L_0x0126
        L_0x009a:
            r6 = 64723(0xfcd3, float:9.0696E-41)
            goto L_0x0126
        L_0x009f:
            r6 = 64722(0xfcd2, float:9.0695E-41)
            goto L_0x0126
        L_0x00a4:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 65184: goto L_0x00bc;
                case 65188: goto L_0x00b7;
                case 65192: goto L_0x00b2;
                case 65252: goto L_0x00ad;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            goto L_0x0126
        L_0x00ad:
            r6 = 64721(0xfcd1, float:9.0693E-41)
            goto L_0x0126
        L_0x00b2:
            r6 = 64720(0xfcd0, float:9.0692E-41)
            goto L_0x0126
        L_0x00b7:
            r6 = 64719(0xfccf, float:9.069E-41)
            goto L_0x0126
        L_0x00bc:
            r6 = 64718(0xfcce, float:9.0689E-41)
            goto L_0x0126
        L_0x00c1:
            char r5 = r10.charAt(r2)
            switch(r5) {
                case 65182: goto L_0x00e7;
                case 65184: goto L_0x00e3;
                case 65186: goto L_0x00df;
                case 65188: goto L_0x00db;
                case 65190: goto L_0x00d7;
                case 65192: goto L_0x00d3;
                case 65250: goto L_0x00cf;
                case 65252: goto L_0x00ca;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            goto L_0x0126
        L_0x00ca:
            r6 = 64716(0xfccc, float:9.0686E-41)
            goto L_0x0126
        L_0x00cf:
            r6 = 64578(0xfc42, float:9.0493E-41)
            goto L_0x0126
        L_0x00d3:
            r6 = 64715(0xfccb, float:9.0685E-41)
            goto L_0x0126
        L_0x00d7:
            r6 = 64577(0xfc41, float:9.0492E-41)
            goto L_0x0126
        L_0x00db:
            r6 = 64714(0xfcca, float:9.0684E-41)
            goto L_0x0126
        L_0x00df:
            r6 = 64576(0xfc40, float:9.049E-41)
            goto L_0x0126
        L_0x00e3:
            r6 = 64713(0xfcc9, float:9.0682E-41)
            goto L_0x0126
        L_0x00e7:
            r6 = 64575(0xfc3f, float:9.0489E-41)
            goto L_0x0126
        L_0x00eb:
            char r5 = r10.charAt(r2)
            r7 = 65266(0xfef2, float:9.1457E-41)
            if (r5 == r7) goto L_0x00f5
            goto L_0x0126
        L_0x00f5:
            r6 = 64562(0xfc32, float:9.047E-41)
            goto L_0x0126
        L_0x00f9:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x010c
            if (r5 == r8) goto L_0x0108
            if (r5 == r7) goto L_0x0104
            goto L_0x0126
        L_0x0104:
            r6 = 64675(0xfca3, float:9.0629E-41)
            goto L_0x0126
        L_0x0108:
            r6 = 64674(0xfca2, float:9.0628E-41)
            goto L_0x0126
        L_0x010c:
            r6 = 64673(0xfca1, float:9.0626E-41)
            goto L_0x0126
        L_0x0110:
            char r5 = r10.charAt(r2)
            if (r5 == r9) goto L_0x0123
            if (r5 == r8) goto L_0x011f
            if (r5 == r7) goto L_0x011b
            goto L_0x0126
        L_0x011b:
            r6 = 64670(0xfc9e, float:9.0622E-41)
            goto L_0x0126
        L_0x011f:
            r6 = 64669(0xfc9d, float:9.062E-41)
            goto L_0x0126
        L_0x0123:
            r6 = 64668(0xfc9c, float:9.0619E-41)
        L_0x0126:
            if (r6 == 0) goto L_0x012e
            r10.setCharAt(r4, r6)
            int r3 = r3 + -1
            goto L_0x0137
        L_0x012e:
            int r4 = r4 + 1
            char r5 = r10.charAt(r2)
            r10.setCharAt(r4, r5)
        L_0x0137:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x013b:
            r10.setLength(r3)
            return
            switch-data {1614->0x0048, 1615->0x003e, 1616->0x0037, 1617->0x0021, }
            switch-data {1612->0x0030, 1613->0x0029, 1614->0x004e, 1615->0x0044, 1616->0x0053, }
            switch-data {65169->0x0110, 65175->0x00f9, 65235->0x00eb, 65247->0x00c1, 65251->0x00a4, 65255->0x0089, 65256->0x0069, }
            switch-data {65184->0x00bc, 65188->0x00b7, 65192->0x00b2, 65252->0x00ad, }
            switch-data {65182->0x00e7, 65184->0x00e3, 65186->0x00df, 65188->0x00db, 65190->0x00d7, 65192->0x00d3, 65250->0x00cf, 65252->0x00ca, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.languages.ArabicLigaturizer.doublelig(java.lang.StringBuffer, int):void");
    }

    static boolean connects_to_left(charstruct charstruct2) {
        return charstruct2.numshapes > 2;
    }

    static void shape(char[] cArr, StringBuffer stringBuffer, int i) {
        charstruct charstruct2 = new charstruct();
        charstruct charstruct3 = new charstruct();
        int i2 = 0;
        while (i2 < cArr.length) {
            int i3 = i2 + 1;
            char c = cArr[i2];
            if (ligature(c, charstruct3) == 0) {
                int shapecount = shapecount(c);
                int i4 = shapecount == 1 ? 0 : 2;
                if (connects_to_left(charstruct2)) {
                    i4++;
                }
                charstruct3.basechar = charshape(charstruct3.basechar, i4 % charstruct3.numshapes);
                copycstostring(stringBuffer, charstruct2, i);
                charstruct charstruct4 = new charstruct();
                charstruct4.basechar = c;
                charstruct4.numshapes = shapecount;
                charstruct4.lignum++;
                i2 = i3;
                charstruct3 = charstruct4;
                charstruct2 = charstruct3;
            } else {
                i2 = i3;
            }
        }
        charstruct3.basechar = charshape(charstruct3.basechar, (connects_to_left(charstruct2) ? 1 : 0) % charstruct3.numshapes);
        copycstostring(stringBuffer, charstruct2, i);
        copycstostring(stringBuffer, charstruct3, i);
    }

    public static int arabic_shape(char[] cArr, int i, int i2, char[] cArr2, int i3, int i4, int i5) {
        char[] cArr3 = new char[i2];
        for (int i6 = (i2 + i) - 1; i6 >= i; i6--) {
            cArr3[i6 - i] = cArr[i6];
        }
        StringBuffer stringBuffer = new StringBuffer(i2);
        shape(cArr3, stringBuffer, i5);
        if ((i5 & 12) != 0) {
            doublelig(stringBuffer, i5);
        }
        System.arraycopy(stringBuffer.toString().toCharArray(), 0, cArr2, i3, stringBuffer.length());
        return stringBuffer.length();
    }

    public static void processNumbers(char[] cArr, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = i3 & 224;
        if (i5 != 0) {
            int i6 = i3 & 256;
            char c = i6 != 0 ? i6 != 256 ? '0' : 1776 : 1632;
            if (i5 == 32) {
                int i7 = c - '0';
                while (i < i4) {
                    char c2 = cArr[i];
                    if (c2 <= '9' && c2 >= '0') {
                        cArr[i] = (char) (cArr[i] + i7);
                    }
                    i++;
                }
            } else if (i5 == 64) {
                char c3 = (char) (c + '\t');
                int i8 = '0' - c;
                while (i < i4) {
                    char c4 = cArr[i];
                    if (c4 <= c3 && c4 >= c) {
                        cArr[i] = (char) (cArr[i] + i8);
                    }
                    i++;
                }
            } else if (i5 == 96) {
                shapeToArabicDigitsWithContext(cArr, 0, i2, c, false);
            } else if (i5 == 128) {
                shapeToArabicDigitsWithContext(cArr, 0, i2, c, true);
            }
        }
    }

    static void shapeToArabicDigitsWithContext(char[] cArr, int i, int i2, char c, boolean z) {
        char c2 = (char) (c - '0');
        int i3 = i2 + i;
        while (i < i3) {
            char c3 = cArr[i];
            byte direction = BidiOrder.getDirection(c3);
            if (direction != 0) {
                if (direction != 8) {
                    if (direction != 3) {
                        if (direction == 4) {
                            z = true;
                        }
                    }
                } else if (z && c3 <= '9') {
                    cArr[i] = (char) (c3 + c2);
                }
                i++;
            }
            z = false;
            i++;
        }
    }

    public static Character getReverseMapping(char c) {
        return reverseLigatureMapTable.get(Character.valueOf(c));
    }

    static class charstruct {
        char basechar;
        int lignum;
        char mark1;
        int numshapes = 1;
        char vowel;

        charstruct() {
        }
    }

    public ArabicLigaturizer() {
    }

    public ArabicLigaturizer(int i, int i2) {
        this.runDirection = i;
        this.options = i2;
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public String process(String str) {
        return BidiLine.processLTR(str, this.runDirection, this.options);
    }
}
