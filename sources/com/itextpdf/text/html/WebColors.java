package com.itextpdf.text.html;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;

@Deprecated
public class WebColors extends HashMap<String, int[]> {
    public static final WebColors NAMES;
    private static final long serialVersionUID = 3542523100813372896L;

    static {
        WebColors webColors = new WebColors();
        NAMES = webColors;
        webColors.put("aliceblue", new int[]{240, 248, 255, 255});
        NAMES.put("antiquewhite", new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 235, 215, 255});
        NAMES.put("aqua", new int[]{0, 255, 255, 255});
        NAMES.put("aquamarine", new int[]{127, 255, 212, 255});
        NAMES.put("azure", new int[]{240, 255, 255, 255});
        NAMES.put("beige", new int[]{245, 245, 220, 255});
        NAMES.put("bisque", new int[]{255, 228, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, 255});
        NAMES.put("black", new int[]{0, 0, 0, 255});
        NAMES.put("blanchedalmond", new int[]{255, 235, 205, 255});
        NAMES.put("blue", new int[]{0, 0, 255, 255});
        NAMES.put("blueviolet", new int[]{138, 43, Jpeg.M_APP2, 255});
        NAMES.put("brown", new int[]{CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, 42, 42, 255});
        NAMES.put("burlywood", new int[]{222, 184, 135, 255});
        NAMES.put("cadetblue", new int[]{95, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 255});
        NAMES.put("chartreuse", new int[]{127, 255, 0, 255});
        NAMES.put("chocolate", new int[]{210, 105, 30, 255});
        NAMES.put("coral", new int[]{255, 127, 80, 255});
        NAMES.put("cornflowerblue", new int[]{100, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, Jpeg.M_APPD, 255});
        NAMES.put("cornsilk", new int[]{255, 248, 220, 255});
        NAMES.put("crimson", new int[]{220, 20, 60, 255});
        NAMES.put("cyan", new int[]{0, 255, 255, 255});
        NAMES.put("darkblue", new int[]{0, 0, 139, 255});
        NAMES.put("darkcyan", new int[]{0, 139, 139, 255});
        NAMES.put("darkgoldenrod", new int[]{184, 134, 11, 255});
        NAMES.put("darkgray", new int[]{CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, 255});
        NAMES.put("darkgreen", new int[]{0, 100, 0, 255});
        NAMES.put("darkkhaki", new int[]{CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384, 107, 255});
        NAMES.put("darkmagenta", new int[]{139, 0, 139, 255});
        NAMES.put("darkolivegreen", new int[]{85, 107, 47, 255});
        NAMES.put("darkorange", new int[]{255, 140, 0, 255});
        NAMES.put("darkorchid", new int[]{CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, 50, 204, 255});
        NAMES.put("darkred", new int[]{139, 0, 0, 255});
        NAMES.put("darksalmon", new int[]{233, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 122, 255});
        NAMES.put("darkseagreen", new int[]{143, 188, 143, 255});
        NAMES.put("darkslateblue", new int[]{72, 61, 139, 255});
        NAMES.put("darkslategray", new int[]{47, 79, 79, 255});
        NAMES.put("darkturquoise", new int[]{0, 206, 209, 255});
        NAMES.put("darkviolet", new int[]{CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, 0, Primes.SMALL_FACTOR_LIMIT, 255});
        NAMES.put("deeppink", new int[]{255, 20, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 255});
        NAMES.put("deepskyblue", new int[]{0, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, 255, 255});
        NAMES.put("dimgray", new int[]{105, 105, 105, 255});
        NAMES.put("dodgerblue", new int[]{30, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 255, 255});
        NAMES.put("firebrick", new int[]{CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, 34, 34, 255});
        NAMES.put("floralwhite", new int[]{255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 240, 255});
        NAMES.put("forestgreen", new int[]{34, 139, 34, 255});
        NAMES.put("fuchsia", new int[]{255, 0, 255, 255});
        NAMES.put("gainsboro", new int[]{220, 220, 220, 255});
        NAMES.put("ghostwhite", new int[]{248, 248, 255, 255});
        NAMES.put("gold", new int[]{255, 215, 0, 255});
        NAMES.put("goldenrod", new int[]{218, CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, 32, 255});
        NAMES.put("gray", new int[]{128, 128, 128, 255});
        NAMES.put("green", new int[]{0, 128, 0, 255});
        NAMES.put("greenyellow", new int[]{CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 255, 47, 255});
        NAMES.put("honeydew", new int[]{240, 255, 240, 255});
        NAMES.put("hotpink", new int[]{255, 105, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, 255});
        NAMES.put("indianred", new int[]{205, 92, 92, 255});
        NAMES.put("indigo", new int[]{75, 0, 130, 255});
        NAMES.put("ivory", new int[]{255, 255, 240, 255});
        NAMES.put("khaki", new int[]{240, 230, 140, 255});
        NAMES.put("lavender", new int[]{230, 230, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255});
        NAMES.put("lavenderblush", new int[]{255, 240, 245, 255});
        NAMES.put("lawngreen", new int[]{124, 252, 0, 255});
        NAMES.put("lemonchiffon", new int[]{255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 205, 255});
        NAMES.put("lightblue", new int[]{CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 216, 230, 255});
        NAMES.put("lightcoral", new int[]{240, 128, 128, 255});
        NAMES.put("lightcyan", new int[]{224, 255, 255, 255});
        NAMES.put("lightgoldenrodyellow", new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 210, 255});
        NAMES.put("lightgreen", new int[]{CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, Jpeg.M_APPE, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 255});
        NAMES.put("lightgrey", new int[]{Primes.SMALL_FACTOR_LIMIT, Primes.SMALL_FACTOR_LIMIT, Primes.SMALL_FACTOR_LIMIT, 255});
        NAMES.put("lightpink", new int[]{255, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, 255});
        NAMES.put("lightsalmon", new int[]{255, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 122, 255});
        NAMES.put("lightseagreen", new int[]{32, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 255});
        NAMES.put("lightskyblue", new int[]{135, 206, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255});
        NAMES.put("lightslategray", new int[]{119, 136, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, 255});
        NAMES.put("lightsteelblue", new int[]{CipherSuite.TLS_PSK_WITH_NULL_SHA256, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, 222, 255});
        NAMES.put("lightyellow", new int[]{255, 255, 224, 255});
        NAMES.put("lime", new int[]{0, 255, 0, 255});
        NAMES.put("limegreen", new int[]{50, 205, 50, 255});
        NAMES.put("linen", new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 240, 230, 255});
        NAMES.put("magenta", new int[]{255, 0, 255, 255});
        NAMES.put("maroon", new int[]{128, 0, 0, 255});
        NAMES.put("mediumaquamarine", new int[]{102, 205, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 255});
        NAMES.put("mediumblue", new int[]{0, 0, 205, 255});
        NAMES.put("mediumorchid", new int[]{CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, 85, Primes.SMALL_FACTOR_LIMIT, 255});
        NAMES.put("mediumpurple", new int[]{CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 112, 219, 255});
        NAMES.put("mediumseagreen", new int[]{60, 179, 113, 255});
        NAMES.put("mediumslateblue", new int[]{123, 104, Jpeg.M_APPE, 255});
        NAMES.put("mediumspringgreen", new int[]{0, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 255});
        NAMES.put("mediumturquoise", new int[]{72, 209, 204, 255});
        NAMES.put("mediumvioletred", new int[]{199, 21, 133, 255});
        NAMES.put("midnightblue", new int[]{25, 25, 112, 255});
        NAMES.put("mintcream", new int[]{245, 255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255});
        NAMES.put("mistyrose", new int[]{255, 228, 225, 255});
        NAMES.put("moccasin", new int[]{255, 228, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384, 255});
        NAMES.put("navajowhite", new int[]{255, 222, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 255});
        NAMES.put("navy", new int[]{0, 0, 128, 255});
        NAMES.put("oldlace", new int[]{253, 245, 230, 255});
        NAMES.put("olive", new int[]{128, 128, 0, 255});
        NAMES.put("olivedrab", new int[]{107, 142, 35, 255});
        NAMES.put("orange", new int[]{255, CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, 0, 255});
        NAMES.put("orangered", new int[]{255, 69, 0, 255});
        NAMES.put("orchid", new int[]{218, 112, 214, 255});
        NAMES.put("palegoldenrod", new int[]{Jpeg.M_APPE, 232, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 255});
        NAMES.put("palegreen", new int[]{CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 251, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 255});
        NAMES.put("paleturquoise", new int[]{CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384, Jpeg.M_APPE, Jpeg.M_APPE, 255});
        NAMES.put("palevioletred", new int[]{219, 112, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 255});
        NAMES.put("papayawhip", new int[]{255, 239, 213, 255});
        NAMES.put("peachpuff", new int[]{255, 218, CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, 255});
        NAMES.put("peru", new int[]{205, 133, 63, 255});
        NAMES.put("pink", new int[]{255, 192, 203, 255});
        NAMES.put("plum", new int[]{221, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 221, 255});
        NAMES.put("powderblue", new int[]{CipherSuite.TLS_PSK_WITH_NULL_SHA256, 224, 230, 255});
        NAMES.put("purple", new int[]{128, 0, 128, 255});
        NAMES.put("red", new int[]{255, 0, 0, 255});
        NAMES.put("rosybrown", new int[]{188, 143, 143, 255});
        NAMES.put("royalblue", new int[]{65, 105, 225, 255});
        NAMES.put("saddlebrown", new int[]{139, 69, 19, 255});
        NAMES.put("salmon", new int[]{ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 128, 114, 255});
        NAMES.put("sandybrown", new int[]{244, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 96, 255});
        NAMES.put("seagreen", new int[]{46, 139, 87, 255});
        NAMES.put("seashell", new int[]{255, 245, Jpeg.M_APPE, 255});
        NAMES.put("sienna", new int[]{CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 82, 45, 255});
        NAMES.put("silver", new int[]{192, 192, 192, 255});
        NAMES.put("skyblue", new int[]{135, 206, 235, 255});
        NAMES.put("slateblue", new int[]{106, 90, 205, 255});
        NAMES.put("slategray", new int[]{112, 128, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 255});
        NAMES.put("snow", new int[]{255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 255});
        NAMES.put("springgreen", new int[]{0, 255, 127, 255});
        NAMES.put("steelblue", new int[]{70, 130, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, 255});
        NAMES.put("tan", new int[]{210, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, 140, 255});
        NAMES.put("teal", new int[]{0, 128, 128, 255});
        NAMES.put("thistle", new int[]{216, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, 216, 255});
        NAMES.put("tomato", new int[]{255, 99, 71, 255});
        NAMES.put("transparent", new int[]{255, 255, 255, 0});
        NAMES.put("turquoise", new int[]{64, 224, 208, 255});
        NAMES.put("violet", new int[]{Jpeg.M_APPE, 130, Jpeg.M_APPE, 255});
        NAMES.put("wheat", new int[]{245, 222, 179, 255});
        NAMES.put("white", new int[]{255, 255, 255, 255});
        NAMES.put("whitesmoke", new int[]{245, 245, 245, 255});
        NAMES.put("yellow", new int[]{255, 255, 0, 255});
        NAMES.put("yellowgreen", new int[]{CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 205, 50, 255});
    }

    private static boolean missingHashColorFormat(String str) {
        int length = str.length();
        if (length != 3 && length != 6) {
            return false;
        }
        return str.matches("[0-9a-f]{" + length + "}");
    }

    public static BaseColor getRGBColor(String str) {
        int[] iArr = {0, 0, 0, 255};
        String lowerCase = str.toLowerCase();
        boolean missingHashColorFormat = missingHashColorFormat(lowerCase);
        if (lowerCase.startsWith("#") || missingHashColorFormat) {
            if (!missingHashColorFormat) {
                lowerCase = lowerCase.substring(1);
            }
            if (lowerCase.length() == 3) {
                String substring = lowerCase.substring(0, 1);
                iArr[0] = Integer.parseInt(substring + substring, 16);
                String substring2 = lowerCase.substring(1, 2);
                iArr[1] = Integer.parseInt(substring2 + substring2, 16);
                String substring3 = lowerCase.substring(2);
                iArr[2] = Integer.parseInt(substring3 + substring3, 16);
                return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
            } else if (lowerCase.length() == 6) {
                iArr[0] = Integer.parseInt(lowerCase.substring(0, 2), 16);
                iArr[1] = Integer.parseInt(lowerCase.substring(2, 4), 16);
                iArr[2] = Integer.parseInt(lowerCase.substring(4), 16);
                return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
            } else {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("unknown.color.format.must.be.rgb.or.rrggbb", new Object[0]));
            }
        } else if (lowerCase.startsWith("rgb(")) {
            StringTokenizer stringTokenizer = new StringTokenizer(lowerCase, "rgb(), \t\r\n\f");
            for (int i = 0; i < 3; i++) {
                if (stringTokenizer.hasMoreElements()) {
                    iArr[i] = getRGBChannelValue(stringTokenizer.nextToken());
                    iArr[i] = Math.max(0, iArr[i]);
                    iArr[i] = Math.min(255, iArr[i]);
                }
            }
            return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else if (lowerCase.startsWith("rgba(")) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(lowerCase, "rgba(), \t\r\n\f");
            for (int i2 = 0; i2 < 3; i2++) {
                if (stringTokenizer2.hasMoreElements()) {
                    iArr[i2] = getRGBChannelValue(stringTokenizer2.nextToken());
                    iArr[i2] = Math.max(0, iArr[i2]);
                    iArr[i2] = Math.min(255, iArr[i2]);
                }
            }
            if (stringTokenizer2.hasMoreElements()) {
                iArr[3] = (int) (((double) (Float.parseFloat(stringTokenizer2.nextToken()) * 255.0f)) + 0.5d);
            }
            return new BaseColor(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else if (NAMES.containsKey(lowerCase)) {
            int[] iArr2 = (int[]) NAMES.get(lowerCase);
            return new BaseColor(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        } else {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("color.not.found", lowerCase));
        }
    }

    private static int getRGBChannelValue(String str) {
        if (str.endsWith("%")) {
            return (Integer.parseInt(str.substring(0, str.length() - 1)) * 255) / 100;
        }
        return Integer.parseInt(str);
    }
}
