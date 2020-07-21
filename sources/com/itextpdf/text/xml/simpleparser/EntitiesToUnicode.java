package com.itextpdf.text.xml.simpleparser;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.xml.xmp.PdfProperties;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

public class EntitiesToUnicode {
    private static final Map<String, Character> MAP;

    static {
        HashMap hashMap = new HashMap();
        MAP = hashMap;
        hashMap.put("nbsp", Character.valueOf(Typography.nbsp));
        MAP.put("iexcl", (char) 161);
        MAP.put("cent", Character.valueOf(Typography.cent));
        MAP.put("pound", Character.valueOf(Typography.pound));
        MAP.put("curren", (char) 164);
        MAP.put("yen", (char) 165);
        MAP.put("brvbar", (char) 166);
        MAP.put("sect", Character.valueOf(Typography.section));
        MAP.put("uml", (char) 168);
        MAP.put("copy", Character.valueOf(Typography.copyright));
        MAP.put("ordf", (char) 170);
        MAP.put("laquo", Character.valueOf(Typography.leftGuillemete));
        MAP.put("not", (char) 172);
        MAP.put("shy", (char) 173);
        MAP.put("reg", Character.valueOf(Typography.registered));
        MAP.put("macr", (char) 175);
        MAP.put("deg", Character.valueOf(Typography.degree));
        MAP.put("plusmn", Character.valueOf(Typography.plusMinus));
        MAP.put("sup2", (char) 178);
        MAP.put("sup3", (char) 179);
        MAP.put("acute", (char) 180);
        MAP.put("micro", (char) 181);
        MAP.put("para", Character.valueOf(Typography.paragraph));
        MAP.put("middot", Character.valueOf(Typography.middleDot));
        MAP.put("cedil", (char) 184);
        MAP.put("sup1", (char) 185);
        MAP.put("ordm", (char) 186);
        MAP.put("raquo", Character.valueOf(Typography.rightGuillemete));
        MAP.put("frac14", (char) 188);
        MAP.put("frac12", Character.valueOf(Typography.half));
        MAP.put("frac34", (char) 190);
        MAP.put("iquest", (char) 191);
        MAP.put("Agrave", (char) 192);
        MAP.put("Aacute", (char) 193);
        MAP.put("Acirc", (char) 194);
        MAP.put("Atilde", Character.valueOf(Barcode128.DEL));
        MAP.put("Auml", Character.valueOf(Barcode128.FNC3));
        MAP.put("Aring", Character.valueOf(Barcode128.FNC2));
        MAP.put("AElig", Character.valueOf(Barcode128.SHIFT));
        MAP.put("Ccedil", Character.valueOf(Barcode128.CODE_C));
        MAP.put("Egrave", (char) 200);
        MAP.put("Eacute", (char) 201);
        MAP.put("Ecirc", Character.valueOf(Barcode128.FNC1));
        MAP.put("Euml", Character.valueOf(Barcode128.STARTA));
        MAP.put("Igrave", Character.valueOf(Barcode128.STARTB));
        MAP.put("Iacute", Character.valueOf(Barcode128.STARTC));
        MAP.put("Icirc", (char) 206);
        MAP.put("Iuml", (char) 207);
        MAP.put("ETH", (char) 208);
        MAP.put("Ntilde", (char) 209);
        MAP.put("Ograve", (char) 210);
        MAP.put("Oacute", (char) 211);
        MAP.put("Ocirc", (char) 212);
        MAP.put("Otilde", (char) 213);
        MAP.put("Ouml", (char) 214);
        MAP.put("times", Character.valueOf(Typography.times));
        MAP.put("Oslash", (char) 216);
        MAP.put("Ugrave", (char) 217);
        MAP.put("Uacute", (char) 218);
        MAP.put("Ucirc", (char) 219);
        MAP.put("Uuml", (char) 220);
        MAP.put("Yacute", (char) 221);
        MAP.put("THORN", (char) 222);
        MAP.put("szlig", (char) 223);
        MAP.put("agrave", (char) 224);
        MAP.put("aacute", (char) 225);
        MAP.put("acirc", (char) 226);
        MAP.put("atilde", (char) 227);
        MAP.put("auml", (char) 228);
        MAP.put("aring", (char) 229);
        MAP.put("aelig", (char) 230);
        MAP.put("ccedil", (char) 231);
        MAP.put("egrave", (char) 232);
        MAP.put("eacute", (char) 233);
        MAP.put("ecirc", (char) 234);
        MAP.put("euml", (char) 235);
        MAP.put("igrave", (char) 236);
        MAP.put("iacute", (char) 237);
        MAP.put("icirc", (char) 238);
        MAP.put("iuml", (char) 239);
        MAP.put("eth", (char) 240);
        MAP.put("ntilde", (char) 241);
        MAP.put("ograve", (char) 242);
        MAP.put("oacute", (char) 243);
        MAP.put("ocirc", (char) 244);
        MAP.put("otilde", (char) 245);
        MAP.put("ouml", (char) 246);
        MAP.put("divide", (char) 247);
        MAP.put("oslash", (char) 248);
        MAP.put("ugrave", (char) 249);
        MAP.put("uacute", (char) 250);
        MAP.put("ucirc", (char) 251);
        MAP.put("uuml", (char) 252);
        MAP.put("yacute", (char) 253);
        MAP.put("thorn", (char) 254);
        MAP.put("yuml", (char) 255);
        MAP.put("fnof", (char) 402);
        MAP.put("Alpha", (char) 913);
        MAP.put("Beta", (char) 914);
        MAP.put(ExifInterface.TAG_GAMMA, (char) 915);
        MAP.put("Delta", (char) 916);
        MAP.put("Epsilon", (char) 917);
        MAP.put("Zeta", (char) 918);
        MAP.put("Eta", (char) 919);
        MAP.put("Theta", (char) 920);
        MAP.put("Iota", (char) 921);
        MAP.put("Kappa", (char) 922);
        MAP.put("Lambda", (char) 923);
        MAP.put("Mu", (char) 924);
        MAP.put("Nu", (char) 925);
        MAP.put("Xi", (char) 926);
        MAP.put("Omicron", (char) 927);
        MAP.put("Pi", (char) 928);
        MAP.put("Rho", (char) 929);
        MAP.put("Sigma", (char) 931);
        MAP.put("Tau", (char) 932);
        MAP.put("Upsilon", (char) 933);
        MAP.put("Phi", (char) 934);
        MAP.put("Chi", (char) 935);
        MAP.put("Psi", (char) 936);
        MAP.put("Omega", (char) 937);
        MAP.put("alpha", (char) 945);
        MAP.put("beta", (char) 946);
        MAP.put("gamma", (char) 947);
        MAP.put("delta", (char) 948);
        MAP.put("epsilon", (char) 949);
        MAP.put("zeta", (char) 950);
        MAP.put("eta", (char) 951);
        MAP.put("theta", (char) 952);
        MAP.put("iota", (char) 953);
        MAP.put("kappa", (char) 954);
        MAP.put("lambda", (char) 955);
        MAP.put("mu", (char) 956);
        MAP.put("nu", (char) 957);
        MAP.put("xi", (char) 958);
        MAP.put("omicron", (char) 959);
        MAP.put("pi", (char) 960);
        MAP.put("rho", (char) 961);
        MAP.put("sigmaf", (char) 962);
        MAP.put("sigma", (char) 963);
        MAP.put("tau", (char) 964);
        MAP.put("upsilon", (char) 965);
        MAP.put("phi", (char) 966);
        MAP.put("chi", (char) 967);
        MAP.put("psi", (char) 968);
        MAP.put("omega", (char) 969);
        MAP.put("thetasym", (char) 977);
        MAP.put("upsih", (char) 978);
        MAP.put("piv", (char) 982);
        MAP.put("bull", Character.valueOf(Typography.bullet));
        MAP.put("hellip", Character.valueOf(Typography.ellipsis));
        MAP.put("prime", Character.valueOf(Typography.prime));
        MAP.put("Prime", Character.valueOf(Typography.doublePrime));
        MAP.put("oline", (char) 8254);
        MAP.put("frasl", (char) 8260);
        MAP.put("weierp", (char) 8472);
        MAP.put("image", (char) 8465);
        MAP.put("real", (char) 8476);
        MAP.put("trade", Character.valueOf(Typography.tm));
        MAP.put("alefsym", (char) 8501);
        MAP.put("larr", (char) 8592);
        MAP.put("uarr", (char) 8593);
        MAP.put("rarr", (char) 8594);
        MAP.put("darr", (char) 8595);
        MAP.put("harr", (char) 8596);
        MAP.put("crarr", (char) 8629);
        MAP.put("lArr", (char) 8656);
        MAP.put("uArr", (char) 8657);
        MAP.put("rArr", (char) 8658);
        MAP.put("dArr", (char) 8659);
        MAP.put("hArr", (char) 8660);
        MAP.put("forall", (char) 8704);
        MAP.put(PdfProperties.PART, (char) 8706);
        MAP.put("exist", (char) 8707);
        MAP.put("empty", (char) 8709);
        MAP.put("nabla", (char) 8711);
        MAP.put("isin", (char) 8712);
        MAP.put("notin", (char) 8713);
        MAP.put("ni", (char) 8715);
        MAP.put("prod", (char) 8719);
        MAP.put("sum", (char) 8721);
        MAP.put("minus", (char) 8722);
        MAP.put("lowast", (char) 8727);
        MAP.put("radic", (char) 8730);
        MAP.put("prop", (char) 8733);
        MAP.put("infin", (char) 8734);
        MAP.put("ang", (char) 8736);
        MAP.put("and", (char) 8743);
        MAP.put("or", (char) 8744);
        MAP.put("cap", (char) 8745);
        MAP.put("cup", (char) 8746);
        MAP.put("int", (char) 8747);
        MAP.put("there4", (char) 8756);
        MAP.put("sim", (char) 8764);
        MAP.put("cong", (char) 8773);
        MAP.put("asymp", Character.valueOf(Typography.almostEqual));
        MAP.put("ne", Character.valueOf(Typography.notEqual));
        MAP.put("equiv", (char) 8801);
        MAP.put("le", Character.valueOf(Typography.lessOrEqual));
        MAP.put("ge", Character.valueOf(Typography.greaterOrEqual));
        MAP.put(HtmlTags.SUB, (char) 8834);
        MAP.put(HtmlTags.SUP, (char) 8835);
        MAP.put("nsub", (char) 8836);
        MAP.put("sube", (char) 8838);
        MAP.put("supe", (char) 8839);
        MAP.put("oplus", (char) 8853);
        MAP.put("otimes", (char) 8855);
        MAP.put("perp", (char) 8869);
        MAP.put("sdot", (char) 8901);
        MAP.put("lceil", (char) 8968);
        MAP.put("rceil", (char) 8969);
        MAP.put("lfloor", (char) 8970);
        MAP.put("rfloor", (char) 8971);
        MAP.put("lang", (char) 9001);
        MAP.put("rang", (char) 9002);
        MAP.put("loz", (char) 9674);
        MAP.put("spades", (char) 9824);
        MAP.put("clubs", (char) 9827);
        MAP.put("hearts", (char) 9829);
        MAP.put("diams", (char) 9830);
        MAP.put("quot", Character.valueOf(Typography.quote));
        MAP.put("amp", Character.valueOf(Typography.amp));
        MAP.put("apos", '\'');
        MAP.put("lt", Character.valueOf(Typography.less));
        MAP.put("gt", Character.valueOf(Typography.greater));
        MAP.put("OElig", (char) 338);
        MAP.put("oelig", (char) 339);
        MAP.put("Scaron", (char) 352);
        MAP.put("scaron", (char) 353);
        MAP.put("Yuml", (char) 376);
        MAP.put("circ", (char) 710);
        MAP.put("tilde", (char) 732);
        MAP.put("ensp", (char) 8194);
        MAP.put("emsp", (char) 8195);
        MAP.put("thinsp", (char) 8201);
        MAP.put("zwnj", (char) 8204);
        MAP.put("zwj", (char) 8205);
        MAP.put("lrm", (char) 8206);
        MAP.put("rlm", (char) 8207);
        MAP.put("ndash", Character.valueOf(Typography.ndash));
        MAP.put("mdash", Character.valueOf(Typography.mdash));
        MAP.put("lsquo", Character.valueOf(Typography.leftSingleQuote));
        MAP.put("rsquo", Character.valueOf(Typography.rightSingleQuote));
        MAP.put("sbquo", Character.valueOf(Typography.lowSingleQuote));
        MAP.put("ldquo", Character.valueOf(Typography.leftDoubleQuote));
        MAP.put("rdquo", Character.valueOf(Typography.rightDoubleQuote));
        MAP.put("bdquo", Character.valueOf(Typography.lowDoubleQuote));
        MAP.put("dagger", Character.valueOf(Typography.f63dagger));
        MAP.put("Dagger", Character.valueOf(Typography.doubleDagger));
        MAP.put("permil", (char) 8240);
        MAP.put("lsaquo", (char) 8249);
        MAP.put("rsaquo", (char) 8250);
        MAP.put("euro", Character.valueOf(Typography.euro));
    }

    public static char decodeEntity(String str) {
        if (str.startsWith("#x")) {
            try {
                return (char) Integer.parseInt(str.substring(2), 16);
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else if (str.startsWith("#")) {
            try {
                return (char) Integer.parseInt(str.substring(1));
            } catch (NumberFormatException unused2) {
                return 0;
            }
        } else {
            Character ch = MAP.get(str);
            if (ch == null) {
                return 0;
            }
            return ch.charValue();
        }
    }

    public static String decodeString(String str) {
        int indexOf = str.indexOf(38);
        if (indexOf == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf));
        while (true) {
            int indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                stringBuffer.append(str.substring(indexOf));
                return stringBuffer.toString();
            }
            int indexOf3 = str.indexOf(38, indexOf + 1);
            while (true) {
                indexOf = indexOf3;
                if (indexOf == -1 || indexOf >= indexOf2) {
                    char decodeEntity = decodeEntity(str.substring(indexOf + 1, indexOf2));
                    int i = indexOf2 + 1;
                } else {
                    stringBuffer.append(str.substring(indexOf, indexOf));
                    indexOf3 = str.indexOf(38, indexOf + 1);
                }
            }
            char decodeEntity2 = decodeEntity(str.substring(indexOf + 1, indexOf2));
            int i2 = indexOf2 + 1;
            if (str.length() < i2) {
                return stringBuffer.toString();
            }
            if (decodeEntity2 == 0) {
                stringBuffer.append(str.substring(indexOf, i2));
            } else {
                stringBuffer.append(decodeEntity2);
            }
            indexOf = str.indexOf(38, indexOf2);
            if (indexOf == -1) {
                stringBuffer.append(str.substring(i2));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(i2, indexOf));
        }
    }
}
