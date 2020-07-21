package com.itextpdf.text;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class FontFactoryImp implements FontProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(FontFactoryImp.class);
    private static String[] TTFamilyOrder = {ExifInterface.GPS_MEASUREMENT_3D, "1", "1033", ExifInterface.GPS_MEASUREMENT_3D, "0", "1033", "1", "0", "0", "0", ExifInterface.GPS_MEASUREMENT_3D, "0"};
    public boolean defaultEmbedding = false;
    public String defaultEncoding = "Cp1252";
    private final Hashtable<String, ArrayList<String>> fontFamilies = new Hashtable<>();
    private final Hashtable<String, String> trueTypeFonts = new Hashtable<>();

    public FontFactoryImp() {
        this.trueTypeFonts.put("Courier".toLowerCase(), "Courier");
        this.trueTypeFonts.put("Courier-Bold".toLowerCase(), "Courier-Bold");
        this.trueTypeFonts.put("Courier-Oblique".toLowerCase(), "Courier-Oblique");
        this.trueTypeFonts.put("Courier-BoldOblique".toLowerCase(), "Courier-BoldOblique");
        this.trueTypeFonts.put("Helvetica".toLowerCase(), "Helvetica");
        this.trueTypeFonts.put("Helvetica-Bold".toLowerCase(), "Helvetica-Bold");
        this.trueTypeFonts.put("Helvetica-Oblique".toLowerCase(), "Helvetica-Oblique");
        this.trueTypeFonts.put("Helvetica-BoldOblique".toLowerCase(), "Helvetica-BoldOblique");
        this.trueTypeFonts.put("Symbol".toLowerCase(), "Symbol");
        this.trueTypeFonts.put("Times-Roman".toLowerCase(), "Times-Roman");
        this.trueTypeFonts.put("Times-Bold".toLowerCase(), "Times-Bold");
        this.trueTypeFonts.put("Times-Italic".toLowerCase(), "Times-Italic");
        this.trueTypeFonts.put("Times-BoldItalic".toLowerCase(), "Times-BoldItalic");
        this.trueTypeFonts.put("ZapfDingbats".toLowerCase(), "ZapfDingbats");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Courier");
        arrayList.add("Courier-Bold");
        arrayList.add("Courier-Oblique");
        arrayList.add("Courier-BoldOblique");
        this.fontFamilies.put("Courier".toLowerCase(), arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Helvetica");
        arrayList2.add("Helvetica-Bold");
        arrayList2.add("Helvetica-Oblique");
        arrayList2.add("Helvetica-BoldOblique");
        this.fontFamilies.put("Helvetica".toLowerCase(), arrayList2);
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("Symbol");
        this.fontFamilies.put("Symbol".toLowerCase(), arrayList3);
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Times-Roman");
        arrayList4.add("Times-Bold");
        arrayList4.add("Times-Italic");
        arrayList4.add("Times-BoldItalic");
        this.fontFamilies.put(FontFactory.TIMES.toLowerCase(), arrayList4);
        this.fontFamilies.put("Times-Roman".toLowerCase(), arrayList4);
        ArrayList<String> arrayList5 = new ArrayList<>();
        arrayList5.add("ZapfDingbats");
        this.fontFamilies.put("ZapfDingbats".toLowerCase(), arrayList5);
    }

    @Override // com.itextpdf.text.FontProvider
    public Font getFont(String str, String str2, boolean z, float f, int i, BaseColor baseColor) {
        return getFont(str, str2, z, f, i, baseColor, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0063 A[LOOP:0: B:13:0x002c->B:29:0x0063, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0061 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Font getFont(java.lang.String r15, java.lang.String r16, boolean r17, float r18, int r19, com.itextpdf.text.BaseColor r20, boolean r21) {
        /*
            r14 = this;
            r1 = r14
            r0 = r18
            r2 = r19
            r3 = r20
            if (r15 != 0) goto L_0x0011
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r4.<init>(r5, r0, r2, r3)
            return r4
        L_0x0011:
            java.lang.String r4 = r15.toLowerCase()
            java.util.Hashtable<java.lang.String, java.util.ArrayList<java.lang.String>> r5 = r1.fontFamilies
            java.lang.Object r4 = r5.get(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 == 0) goto L_0x0072
            monitor-enter(r4)
            r5 = 0
            r6 = -1
            if (r2 != r6) goto L_0x0026
            r7 = 0
            goto L_0x0027
        L_0x0026:
            r7 = r2
        L_0x0027:
            java.util.Iterator r8 = r4.iterator()     // Catch:{ all -> 0x006f }
            r9 = 0
        L_0x002c:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x006f }
            r11 = 1
            if (r10 == 0) goto L_0x0065
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x006f }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x006f }
            java.lang.String r10 = r9.toLowerCase()     // Catch:{ all -> 0x006f }
            java.lang.String r12 = "bold"
            int r12 = r10.indexOf(r12)     // Catch:{ all -> 0x006f }
            if (r12 == r6) goto L_0x0047
            r12 = 1
            goto L_0x0048
        L_0x0047:
            r12 = 0
        L_0x0048:
            java.lang.String r13 = "italic"
            int r13 = r10.indexOf(r13)     // Catch:{ all -> 0x006f }
            if (r13 != r6) goto L_0x005b
            java.lang.String r13 = "oblique"
            int r10 = r10.indexOf(r13)     // Catch:{ all -> 0x006f }
            if (r10 == r6) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r10 = r12
            goto L_0x005d
        L_0x005b:
            r10 = r12 | 2
        L_0x005d:
            r12 = r7 & 3
            if (r12 != r10) goto L_0x0063
            r5 = 1
            goto L_0x0067
        L_0x0063:
            r9 = r10
            goto L_0x002c
        L_0x0065:
            r10 = r9
            r9 = r15
        L_0x0067:
            if (r2 == r6) goto L_0x006d
            if (r5 == 0) goto L_0x006d
            int r5 = ~r10     // Catch:{ all -> 0x006f }
            r2 = r2 & r5
        L_0x006d:
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            throw r0
        L_0x0072:
            r9 = r15
        L_0x0073:
            r4 = r16
            r5 = r17
            r6 = r21
            com.itextpdf.text.pdf.BaseFont r4 = r14.getBaseFont(r9, r4, r5, r6)     // Catch:{ DocumentException -> 0x009d, IOException -> 0x0095, NullPointerException -> 0x008d }
            if (r4 != 0) goto L_0x0087
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font     // Catch:{ DocumentException -> 0x009d, IOException -> 0x0095, NullPointerException -> 0x008d }
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED     // Catch:{ DocumentException -> 0x009d, IOException -> 0x0095, NullPointerException -> 0x008d }
            r4.<init>(r5, r0, r2, r3)     // Catch:{ DocumentException -> 0x009d, IOException -> 0x0095, NullPointerException -> 0x008d }
            return r4
        L_0x0087:
            com.itextpdf.text.Font r5 = new com.itextpdf.text.Font
            r5.<init>(r4, r0, r2, r3)
            return r5
        L_0x008d:
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r4.<init>(r5, r0, r2, r3)
            return r4
        L_0x0095:
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r4.<init>(r5, r0, r2, r3)
            return r4
        L_0x009d:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r2 = new com.itextpdf.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.FontFactoryImp.getFont(java.lang.String, java.lang.String, boolean, float, int, com.itextpdf.text.BaseColor, boolean):com.itextpdf.text.Font");
    }

    /* access modifiers changed from: protected */
    public BaseFont getBaseFont(String str, String str2, boolean z, boolean z2) throws IOException, DocumentException {
        BaseFont baseFont;
        String str3;
        try {
            baseFont = BaseFont.createFont(str, str2, z, z2, null, null, true);
        } catch (DocumentException unused) {
            baseFont = null;
        }
        return (baseFont != null || (str3 = this.trueTypeFonts.get(str.toLowerCase())) == null) ? baseFont : BaseFont.createFont(str3, str2, z, z2, null, null);
    }

    public Font getFont(String str, String str2, boolean z, float f, int i) {
        return getFont(str, str2, z, f, i, null);
    }

    public Font getFont(String str, String str2, boolean z, float f) {
        return getFont(str, str2, z, f, -1, null);
    }

    public Font getFont(String str, String str2, boolean z) {
        return getFont(str, str2, z, -1.0f, -1, null);
    }

    public Font getFont(String str, String str2, float f, int i, BaseColor baseColor) {
        return getFont(str, str2, this.defaultEmbedding, f, i, baseColor);
    }

    public Font getFont(String str, String str2, float f, int i) {
        return getFont(str, str2, this.defaultEmbedding, f, i, null);
    }

    public Font getFont(String str, String str2, float f) {
        return getFont(str, str2, this.defaultEmbedding, f, -1, null);
    }

    public Font getFont(String str, float f, BaseColor baseColor) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, -1, baseColor);
    }

    public Font getFont(String str, String str2) {
        return getFont(str, str2, this.defaultEmbedding, -1.0f, -1, null);
    }

    public Font getFont(String str, float f, int i, BaseColor baseColor) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, i, baseColor);
    }

    public Font getFont(String str, float f, int i) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, i, null);
    }

    public Font getFont(String str, float f) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, -1, null);
    }

    public Font getFont(String str) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, -1.0f, -1, null);
    }

    public void registerFamily(String str, String str2, String str3) {
        ArrayList<String> arrayList;
        boolean z;
        if (str3 != null) {
            this.trueTypeFonts.put(str2, str3);
        }
        synchronized (this.fontFamilies) {
            arrayList = this.fontFamilies.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.fontFamilies.put(str, arrayList);
            }
        }
        synchronized (arrayList) {
            if (!arrayList.contains(str2)) {
                int length = str2.length();
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        z = false;
                        break;
                    } else if (arrayList.get(i).length() >= length) {
                        arrayList.add(i, str2);
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    arrayList.add(str2);
                    String lowerCase = str2.toLowerCase();
                    if (lowerCase.endsWith("regular")) {
                        arrayList.add(0, str2.substring(0, lowerCase.substring(0, lowerCase.length() - 7).trim().length()));
                    }
                }
            }
        }
    }

    public void register(String str) {
        register(str, null);
    }

    public void register(String str, String str2) {
        try {
            if (str.toLowerCase().endsWith(".ttf") || str.toLowerCase().endsWith(".otf") || str.toLowerCase().indexOf(".ttc,") > 0) {
                Object[] allFontNames = BaseFont.getAllFontNames(str, "Cp1252", null);
                this.trueTypeFonts.put(((String) allFontNames[0]).toLowerCase(), str);
                if (str2 != null) {
                    String lowerCase = str2.toLowerCase();
                    this.trueTypeFonts.put(lowerCase, str);
                    if (lowerCase.endsWith("regular")) {
                        saveCopyOfRegularFont(lowerCase, str);
                    }
                }
                for (String[] strArr : (String[][]) allFontNames[2]) {
                    String lowerCase2 = strArr[3].toLowerCase();
                    this.trueTypeFonts.put(lowerCase2, str);
                    if (lowerCase2.endsWith("regular")) {
                        saveCopyOfRegularFont(lowerCase2, str);
                    }
                }
                String[][] strArr2 = (String[][]) allFontNames[1];
                String str3 = null;
                int i = 0;
                while (i < TTFamilyOrder.length) {
                    int length = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String[] strArr3 = strArr2[i2];
                        if (TTFamilyOrder[i].equals(strArr3[0]) && TTFamilyOrder[i + 1].equals(strArr3[1]) && TTFamilyOrder[i + 2].equals(strArr3[2])) {
                            str3 = strArr3[3].toLowerCase();
                            i = TTFamilyOrder.length;
                            break;
                        }
                        i2++;
                    }
                    i += 3;
                }
                if (str3 != null) {
                    String str4 = "";
                    String[][] strArr4 = (String[][]) allFontNames[2];
                    for (String[] strArr5 : strArr4) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= TTFamilyOrder.length) {
                                break;
                            }
                            if (TTFamilyOrder[i3].equals(strArr5[0]) && TTFamilyOrder[i3 + 1].equals(strArr5[1]) && TTFamilyOrder[i3 + 2].equals(strArr5[2])) {
                                String str5 = strArr5[3];
                                if (!str5.equals(str4)) {
                                    registerFamily(str3, str5, null);
                                    str4 = str5;
                                    break;
                                }
                            }
                            i3 += 3;
                        }
                    }
                }
            } else if (str.toLowerCase().endsWith(".ttc")) {
                if (str2 != null) {
                    LOGGER.error("You can't define an alias for a true type collection.");
                }
                String[] enumerateTTCNames = BaseFont.enumerateTTCNames(str);
                for (int i4 = 0; i4 < enumerateTTCNames.length; i4++) {
                    register(str + "," + i4);
                }
            } else if (str.toLowerCase().endsWith(".afm") || str.toLowerCase().endsWith(".pfm")) {
                BaseFont createFont = BaseFont.createFont(str, "Cp1252", false);
                String lowerCase3 = createFont.getFullFontName()[0][3].toLowerCase();
                String lowerCase4 = createFont.getFamilyFontName()[0][3].toLowerCase();
                String lowerCase5 = createFont.getPostscriptFontName().toLowerCase();
                registerFamily(lowerCase4, lowerCase3, null);
                this.trueTypeFonts.put(lowerCase5, str);
                this.trueTypeFonts.put(lowerCase3, str);
            }
            if (LOGGER.isLogging(Level.TRACE)) {
                LOGGER.trace(String.format("Registered %s", str));
            }
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean saveCopyOfRegularFont(String str, String str2) {
        String trim = str.substring(0, str.length() - 7).trim();
        if (this.trueTypeFonts.containsKey(trim)) {
            return false;
        }
        this.trueTypeFonts.put(trim, str2);
        return true;
    }

    public int registerDirectory(String str) {
        return registerDirectory(str, false);
    }

    public int registerDirectory(String str, boolean z) {
        int i = 0;
        if (LOGGER.isLogging(Level.DEBUG)) {
            LOGGER.debug(String.format("Registering directory %s, looking for fonts", str));
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list == null) {
                        return 0;
                    }
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < list.length) {
                        try {
                            try {
                                File file2 = new File(str, list[i2]);
                                if (!file2.isDirectory()) {
                                    String path = file2.getPath();
                                    String lowerCase = path.length() < 4 ? null : path.substring(path.length() - 4).toLowerCase();
                                    if (!".afm".equals(lowerCase)) {
                                        if (!".pfm".equals(lowerCase)) {
                                            if (".ttf".equals(lowerCase) || ".otf".equals(lowerCase) || ".ttc".equals(lowerCase)) {
                                                register(path, null);
                                                i3++;
                                            }
                                        }
                                    }
                                    if (new File(path.substring(0, path.length() - 4) + ".pfb").exists()) {
                                        register(path, null);
                                        i3++;
                                    }
                                } else if (z) {
                                    i3 += registerDirectory(file2.getAbsolutePath(), true);
                                }
                            } catch (Exception unused) {
                            }
                            i2++;
                        } catch (Exception unused2) {
                            i = i3;
                            return i;
                        }
                    }
                    return i3;
                }
            }
            return 0;
        } catch (Exception unused3) {
            return i;
        }
    }

    public int registerDirectories() {
        String str = System.getenv("windir");
        String property = System.getProperty("file.separator");
        int i = 0;
        if (!(str == null || property == null)) {
            i = 0 + registerDirectory(str + property + "fonts");
        }
        return i + registerDirectory("/usr/share/X11/fonts", true) + registerDirectory("/usr/X/lib/X11/fonts", true) + registerDirectory("/usr/openwin/lib/X11/fonts", true) + registerDirectory("/usr/share/fonts", true) + registerDirectory("/usr/X11R6/lib/X11/fonts", true) + registerDirectory("/Library/Fonts") + registerDirectory("/System/Library/Fonts");
    }

    public Set<String> getRegisteredFonts() {
        return this.trueTypeFonts.keySet();
    }

    public Set<String> getRegisteredFamilies() {
        return this.fontFamilies.keySet();
    }

    @Override // com.itextpdf.text.FontProvider
    public boolean isRegistered(String str) {
        return this.trueTypeFonts.containsKey(str.toLowerCase());
    }
}
