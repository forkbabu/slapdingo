package com.itextpdf.text.pdf;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.fonts.FontsResourceAnchor;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

class Type1Font extends BaseFont {
    private static final int[] PFB_TYPES = {1, 2, 1};
    private static FontsResourceAnchor resourceAnchor;
    private int Ascender = 800;
    private int CapHeight = 700;
    private HashMap<Object, Object[]> CharMetrics = new HashMap<>();
    private String CharacterSet;
    private int Descender = -200;
    private String EncodingScheme = "FontSpecific";
    private String FamilyName;
    private String FontName;
    private String FullName;
    private boolean IsFixedPitch = false;
    private float ItalicAngle = 0.0f;
    private HashMap<String, Object[]> KernPairs = new HashMap<>();
    private int StdHW;
    private int StdVW = 80;
    private int UnderlinePosition = -100;
    private int UnderlineThickness = 50;
    private String Weight = "";
    private int XHeight = 480;
    private boolean builtinFont = false;
    private String fileName;
    private int llx = -50;
    private int lly = -200;
    protected byte[] pfb;
    private int urx = 1000;
    private int ury = 900;

    /* JADX WARNING: Can't wrap try/catch for region: R(11:18|19|(2:20|(1:97)(1:41))|22|(2:24|25)|26|27|28|29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d8, code lost:
        r4 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c5 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00db A[SYNTHETIC, Splitter:B:37:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fe A[SYNTHETIC, Splitter:B:48:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0198 A[SYNTHETIC, Splitter:B:91:0x0198] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Type1Font(java.lang.String r4, java.lang.String r5, boolean r6, byte[] r7, byte[] r8, boolean r9) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r3 = this;
            r3.<init>()
            java.lang.String r0 = ""
            r3.Weight = r0
            r0 = 0
            r3.ItalicAngle = r0
            r0 = 0
            r3.IsFixedPitch = r0
            r1 = -50
            r3.llx = r1
            r1 = -200(0xffffffffffffff38, float:NaN)
            r3.lly = r1
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.urx = r2
            r2 = 900(0x384, float:1.261E-42)
            r3.ury = r2
            r2 = -100
            r3.UnderlinePosition = r2
            r2 = 50
            r3.UnderlineThickness = r2
            java.lang.String r2 = "FontSpecific"
            r3.EncodingScheme = r2
            r2 = 700(0x2bc, float:9.81E-43)
            r3.CapHeight = r2
            r2 = 480(0x1e0, float:6.73E-43)
            r3.XHeight = r2
            r2 = 800(0x320, float:1.121E-42)
            r3.Ascender = r2
            r3.Descender = r1
            r1 = 80
            r3.StdVW = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3.CharMetrics = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3.KernPairs = r1
            r3.builtinFont = r0
            if (r6 == 0) goto L_0x0060
            if (r7 == 0) goto L_0x0060
            if (r8 == 0) goto L_0x0052
            goto L_0x0060
        L_0x0052:
            com.itextpdf.text.DocumentException r4 = new com.itextpdf.text.DocumentException
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r6 = "two.byte.arrays.are.needed.if.the.type1.font.is.embedded"
            java.lang.String r5 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r6, r5)
            r4.<init>(r5)
            throw r4
        L_0x0060:
            if (r6 == 0) goto L_0x0066
            if (r7 == 0) goto L_0x0066
            r3.pfb = r8
        L_0x0066:
            r3.encoding = r5
            r3.embedded = r6
            r3.fileName = r4
            r3.fontType = r0
            java.util.HashMap r6 = com.itextpdf.text.pdf.Type1Font.BuiltinFonts14
            boolean r6 = r6.containsKey(r4)
            java.lang.String r8 = ".afm"
            r1 = 0
            r2 = 1
            if (r6 == 0) goto L_0x0102
            r3.embedded = r0
            r3.builtinFont = r2
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]
            com.itextpdf.text.pdf.fonts.FontsResourceAnchor r7 = com.itextpdf.text.pdf.Type1Font.resourceAnchor     // Catch:{ all -> 0x00fb }
            if (r7 != 0) goto L_0x008d
            com.itextpdf.text.pdf.fonts.FontsResourceAnchor r7 = new com.itextpdf.text.pdf.fonts.FontsResourceAnchor     // Catch:{ all -> 0x00fb }
            r7.<init>()     // Catch:{ all -> 0x00fb }
            com.itextpdf.text.pdf.Type1Font.resourceAnchor = r7     // Catch:{ all -> 0x00fb }
        L_0x008d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r7.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r9 = "com/itextpdf/text/pdf/fonts/"
            r7.append(r9)     // Catch:{ all -> 0x00fb }
            r7.append(r4)     // Catch:{ all -> 0x00fb }
            r7.append(r8)     // Catch:{ all -> 0x00fb }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00fb }
            com.itextpdf.text.pdf.fonts.FontsResourceAnchor r8 = com.itextpdf.text.pdf.Type1Font.resourceAnchor     // Catch:{ all -> 0x00fb }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x00fb }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x00fb }
            java.io.InputStream r7 = com.itextpdf.text.io.StreamUtil.getResourceStream(r7, r8)     // Catch:{ all -> 0x00fb }
            if (r7 == 0) goto L_0x00e6
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00e3 }
            r4.<init>()     // Catch:{ all -> 0x00e3 }
        L_0x00b6:
            int r8 = r7.read(r6)     // Catch:{ all -> 0x00e3 }
            if (r8 >= 0) goto L_0x00df
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x00e3 }
            if (r7 == 0) goto L_0x00c5
            r7.close()     // Catch:{ Exception -> 0x00c5 }
        L_0x00c5:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r6 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x00d8 }
            r6.<init>(r4)     // Catch:{ all -> 0x00d8 }
            r3.process(r6)     // Catch:{ all -> 0x00d5 }
            r6.close()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x0162
        L_0x00d2:
            goto L_0x0162
        L_0x00d5:
            r4 = move-exception
            r1 = r6
            goto L_0x00d9
        L_0x00d8:
            r4 = move-exception
        L_0x00d9:
            if (r1 == 0) goto L_0x00de
            r1.close()     // Catch:{ Exception -> 0x00de }
        L_0x00de:
            throw r4
        L_0x00df:
            r4.write(r6, r0, r8)
            goto L_0x00b6
        L_0x00e3:
            r4 = move-exception
            r1 = r7
            goto L_0x00fc
        L_0x00e6:
            java.lang.String r5 = "1.not.found.as.resource"
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r0] = r4
            java.lang.String r4 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r5, r6)
            java.io.PrintStream r5 = java.lang.System.err
            r5.println(r4)
            com.itextpdf.text.DocumentException r5 = new com.itextpdf.text.DocumentException
            r5.<init>(r4)
            throw r5
        L_0x00fb:
            r4 = move-exception
        L_0x00fc:
            if (r1 == 0) goto L_0x0101
            r1.close()     // Catch:{ Exception -> 0x0101 }
        L_0x0101:
            throw r4
        L_0x0102:
            java.lang.String r6 = r4.toLowerCase()
            boolean r6 = r6.endsWith(r8)
            if (r6 == 0) goto L_0x012b
            if (r7 != 0) goto L_0x0117
            com.itextpdf.text.pdf.RandomAccessFileOrArray r6 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0124 }
            boolean r7 = com.itextpdf.text.Document.plainRandomAccess     // Catch:{ all -> 0x0124 }
            r6.<init>(r4, r9, r7)     // Catch:{ all -> 0x0124 }
            r1 = r6
            goto L_0x011d
        L_0x0117:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r4 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0124 }
            r4.<init>(r7)     // Catch:{ all -> 0x0124 }
            r1 = r4
        L_0x011d:
            r3.process(r1)     // Catch:{ all -> 0x0124 }
            r1.close()
            goto L_0x0162
        L_0x0124:
            r4 = move-exception
            if (r1 == 0) goto L_0x012a
            r1.close()     // Catch:{ Exception -> 0x012a }
        L_0x012a:
            throw r4
        L_0x012b:
            java.lang.String r6 = r4.toLowerCase()
            java.lang.String r8 = ".pfm"
            boolean r6 = r6.endsWith(r8)
            if (r6 == 0) goto L_0x019c
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0195 }
            r6.<init>()     // Catch:{ all -> 0x0195 }
            if (r7 != 0) goto L_0x0147
            com.itextpdf.text.pdf.RandomAccessFileOrArray r7 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0195 }
            boolean r8 = com.itextpdf.text.Document.plainRandomAccess     // Catch:{ all -> 0x0195 }
            r7.<init>(r4, r9, r8)     // Catch:{ all -> 0x0195 }
            r1 = r7
            goto L_0x014d
        L_0x0147:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r4 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0195 }
            r4.<init>(r7)     // Catch:{ all -> 0x0195 }
            r1 = r4
        L_0x014d:
            com.itextpdf.text.pdf.Pfm2afm.convert(r1, r6)     // Catch:{ all -> 0x0195 }
            r1.close()     // Catch:{ all -> 0x0195 }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r4 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0195 }
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x0195 }
            r4.<init>(r6)     // Catch:{ all -> 0x0195 }
            r3.process(r4)     // Catch:{ all -> 0x0191 }
            r4.close()
        L_0x0162:
            java.lang.String r4 = r3.EncodingScheme
            java.lang.String r4 = r4.trim()
            r3.EncodingScheme = r4
            java.lang.String r6 = "AdobeStandardEncoding"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x017c
            java.lang.String r4 = r3.EncodingScheme
            java.lang.String r6 = "StandardEncoding"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x017e
        L_0x017c:
            r3.fontSpecific = r0
        L_0x017e:
            java.lang.String r4 = r3.encoding
            java.lang.String r6 = "#"
            boolean r4 = r4.startsWith(r6)
            if (r4 != 0) goto L_0x018d
            java.lang.String r4 = " "
            com.itextpdf.text.pdf.PdfEncodings.convertToBytes(r4, r5)
        L_0x018d:
            r3.createEncoding()
            return
        L_0x0191:
            r5 = move-exception
            r1 = r4
            r4 = r5
            goto L_0x0196
        L_0x0195:
            r4 = move-exception
        L_0x0196:
            if (r1 == 0) goto L_0x019b
            r1.close()     // Catch:{ Exception -> 0x019b }
        L_0x019b:
            throw r4
        L_0x019c:
            com.itextpdf.text.DocumentException r5 = new com.itextpdf.text.DocumentException
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r0] = r4
            java.lang.String r4 = "1.is.not.an.afm.or.pfm.font.file"
            java.lang.String r4 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r4, r6)
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Type1Font.<init>(java.lang.String, java.lang.String, boolean, byte[], byte[], boolean):void");
    }

    /* access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public int getRawWidth(int i, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = this.CharMetrics.get(Integer.valueOf(i));
        } else if (str.equals(BaseFont.notdef)) {
            return 0;
        } else {
            objArr = this.CharMetrics.get(str);
        }
        if (objArr != null) {
            return ((Integer) objArr[1]).intValue();
        }
        return 0;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public int getKerning(int i, int i2) {
        String unicodeToName;
        Object[] objArr;
        String unicodeToName2 = GlyphList.unicodeToName(i);
        if (unicodeToName2 == null || (unicodeToName = GlyphList.unicodeToName(i2)) == null || (objArr = this.KernPairs.get(unicodeToName2)) == null) {
            return 0;
        }
        for (int i3 = 0; i3 < objArr.length; i3 += 2) {
            if (unicodeToName.equals(objArr[i3])) {
                return ((Integer) objArr[i3 + 1]).intValue();
            }
        }
        return 0;
    }

    public void process(RandomAccessFileOrArray randomAccessFileOrArray) throws DocumentException, IOException {
        boolean z;
        Object[] objArr;
        while (true) {
            String readLine = randomAccessFileOrArray.readLine();
            if (readLine == null) {
                z = false;
                break;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ,\n\r\t\f");
            if (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken.equals("FontName")) {
                    this.FontName = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (nextToken.equals("FullName")) {
                    this.FullName = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (nextToken.equals("FamilyName")) {
                    this.FamilyName = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (nextToken.equals("Weight")) {
                    this.Weight = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (nextToken.equals("ItalicAngle")) {
                    this.ItalicAngle = Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("IsFixedPitch")) {
                    this.IsFixedPitch = stringTokenizer.nextToken().equals(PdfBoolean.TRUE);
                } else if (nextToken.equals("CharacterSet")) {
                    this.CharacterSet = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (nextToken.equals("FontBBox")) {
                    this.llx = (int) Float.parseFloat(stringTokenizer.nextToken());
                    this.lly = (int) Float.parseFloat(stringTokenizer.nextToken());
                    this.urx = (int) Float.parseFloat(stringTokenizer.nextToken());
                    this.ury = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("UnderlinePosition")) {
                    this.UnderlinePosition = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("UnderlineThickness")) {
                    this.UnderlineThickness = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("EncodingScheme")) {
                    this.EncodingScheme = stringTokenizer.nextToken("ÿ").substring(1);
                } else if (nextToken.equals("CapHeight")) {
                    this.CapHeight = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("XHeight")) {
                    this.XHeight = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("Ascender")) {
                    this.Ascender = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("Descender")) {
                    this.Descender = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("StdHW")) {
                    this.StdHW = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("StdVW")) {
                    this.StdVW = (int) Float.parseFloat(stringTokenizer.nextToken());
                } else if (nextToken.equals("StartCharMetrics")) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            while (true) {
                String readLine2 = randomAccessFileOrArray.readLine();
                if (readLine2 == null) {
                    break;
                }
                StringTokenizer stringTokenizer2 = new StringTokenizer(readLine2);
                if (stringTokenizer2.hasMoreTokens()) {
                    if (stringTokenizer2.nextToken().equals("EndCharMetrics")) {
                        z = false;
                        break;
                    }
                    Integer num = -1;
                    Integer valueOf = Integer.valueOf((int) ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    int[] iArr = null;
                    StringTokenizer stringTokenizer3 = new StringTokenizer(readLine2, ";");
                    String str = "";
                    while (stringTokenizer3.hasMoreTokens()) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(stringTokenizer3.nextToken());
                        if (stringTokenizer4.hasMoreTokens()) {
                            String nextToken2 = stringTokenizer4.nextToken();
                            if (nextToken2.equals("C")) {
                                num = Integer.valueOf(stringTokenizer4.nextToken());
                            } else if (nextToken2.equals("WX")) {
                                valueOf = Integer.valueOf((int) Float.parseFloat(stringTokenizer4.nextToken()));
                            } else if (nextToken2.equals("N")) {
                                str = stringTokenizer4.nextToken();
                            } else if (nextToken2.equals("B")) {
                                iArr = new int[]{Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken())};
                            }
                        }
                    }
                    Object[] objArr2 = {num, valueOf, str, iArr};
                    if (num.intValue() >= 0) {
                        this.CharMetrics.put(num, objArr2);
                    }
                    this.CharMetrics.put(str, objArr2);
                }
            }
            if (!z) {
                if (!this.CharMetrics.containsKey("nonbreakingspace") && (objArr = this.CharMetrics.get("space")) != null) {
                    this.CharMetrics.put("nonbreakingspace", objArr);
                }
                while (true) {
                    String readLine3 = randomAccessFileOrArray.readLine();
                    if (readLine3 == null) {
                        break;
                    }
                    StringTokenizer stringTokenizer5 = new StringTokenizer(readLine3);
                    if (stringTokenizer5.hasMoreTokens()) {
                        String nextToken3 = stringTokenizer5.nextToken();
                        if (!nextToken3.equals("EndFontMetrics")) {
                            if (nextToken3.equals("StartKernPairs")) {
                                z = true;
                                break;
                            }
                        } else {
                            return;
                        }
                    }
                }
                if (z) {
                    while (true) {
                        String readLine4 = randomAccessFileOrArray.readLine();
                        if (readLine4 == null) {
                            break;
                        }
                        StringTokenizer stringTokenizer6 = new StringTokenizer(readLine4);
                        if (stringTokenizer6.hasMoreTokens()) {
                            String nextToken4 = stringTokenizer6.nextToken();
                            if (nextToken4.equals("KPX")) {
                                String nextToken5 = stringTokenizer6.nextToken();
                                String nextToken6 = stringTokenizer6.nextToken();
                                Integer valueOf2 = Integer.valueOf((int) Float.parseFloat(stringTokenizer6.nextToken()));
                                Object[] objArr3 = this.KernPairs.get(nextToken5);
                                if (objArr3 == null) {
                                    this.KernPairs.put(nextToken5, new Object[]{nextToken6, valueOf2});
                                } else {
                                    int length = objArr3.length;
                                    Object[] objArr4 = new Object[(length + 2)];
                                    System.arraycopy(objArr3, 0, objArr4, 0, length);
                                    objArr4[length] = nextToken6;
                                    objArr4[length + 1] = valueOf2;
                                    this.KernPairs.put(nextToken5, objArr4);
                                }
                            } else if (nextToken4.equals("EndKernPairs")) {
                                z = false;
                                break;
                            }
                        }
                    }
                    if (!z) {
                        randomAccessFileOrArray.close();
                        return;
                    }
                    throw new DocumentException(MessageLocalization.getComposedMessage("missing.endkernpairs.in.1", this.fileName));
                }
                throw new DocumentException(MessageLocalization.getComposedMessage("missing.endfontmetrics.in.1", this.fileName));
            }
            throw new DocumentException(MessageLocalization.getComposedMessage("missing.endcharmetrics.in.1", this.fileName));
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("missing.startcharmetrics.in.1", this.fileName));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.itextpdf.text.pdf.PdfStream, com.itextpdf.text.pdf.RandomAccessFileOrArray] */
    @Override // com.itextpdf.text.pdf.BaseFont
    public PdfStream getFullFontStream() throws DocumentException {
        RandomAccessFileOrArray randomAccessFileOrArray;
        ? r1 = 0;
        if (this.builtinFont || !this.embedded) {
            return r1;
        }
        try {
            String str = this.fileName.substring(0, this.fileName.length() - 3) + "pfb";
            if (this.pfb == null) {
                randomAccessFileOrArray = new RandomAccessFileOrArray(str, true, Document.plainRandomAccess);
            } else {
                randomAccessFileOrArray = new RandomAccessFileOrArray(this.pfb);
            }
            byte[] bArr = new byte[(((int) randomAccessFileOrArray.length()) - 18)];
            int[] iArr = new int[3];
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                if (randomAccessFileOrArray.read() != 128) {
                    throw new DocumentException(MessageLocalization.getComposedMessage("start.marker.missing.in.1", str));
                } else if (randomAccessFileOrArray.read() == PFB_TYPES[i]) {
                    int read = randomAccessFileOrArray.read() + (randomAccessFileOrArray.read() << 8) + (randomAccessFileOrArray.read() << 16) + (randomAccessFileOrArray.read() << 24);
                    iArr[i] = read;
                    while (read != 0) {
                        int read2 = randomAccessFileOrArray.read(bArr, i2, read);
                        if (read2 >= 0) {
                            i2 += read2;
                            read -= read2;
                        } else {
                            throw new DocumentException(MessageLocalization.getComposedMessage("premature.end.in.1", str));
                        }
                    }
                    i++;
                } else {
                    throw new DocumentException(MessageLocalization.getComposedMessage("incorrect.segment.type.in.1", str));
                }
            }
            BaseFont.StreamFont streamFont = new BaseFont.StreamFont(bArr, iArr, this.compressionLevel);
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
            return streamFont;
        } catch (Exception e) {
            throw new DocumentException(e);
        } catch (Throwable th) {
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private PdfDictionary getFontDescriptor(PdfIndirectReference pdfIndirectReference) {
        if (this.builtinFont) {
            return null;
        }
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfNumber(this.Ascender));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfNumber(this.CapHeight));
        pdfDictionary.put(PdfName.DESCENT, new PdfNumber(this.Descender));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfRectangle((float) this.llx, (float) this.lly, (float) this.urx, (float) this.ury));
        pdfDictionary.put(PdfName.FONTNAME, new PdfName(this.FontName));
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfNumber(this.ItalicAngle));
        pdfDictionary.put(PdfName.STEMV, new PdfNumber(this.StdVW));
        if (pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTFILE, pdfIndirectReference);
        }
        int i = 0;
        if (this.IsFixedPitch) {
            i = 1;
        }
        int i2 = i | (this.fontSpecific ? 4 : 32);
        if (this.ItalicAngle < 0.0f) {
            i2 |= 64;
        }
        if (this.FontName.indexOf("Caps") >= 0 || this.FontName.endsWith("SC")) {
            i2 |= 131072;
        }
        if (this.Weight.equals("Bold")) {
            i2 |= 262144;
        }
        pdfDictionary.put(PdfName.FLAGS, new PdfNumber(i2));
        return pdfDictionary;
    }

    private PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, int i, int i2, byte[] bArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE1);
        pdfDictionary.put(PdfName.BASEFONT, new PdfName(this.FontName));
        boolean z = this.encoding.equals("Cp1252") || this.encoding.equals(BaseFont.MACROMAN);
        if (!this.fontSpecific || this.specialMap != null) {
            int i3 = i;
            while (true) {
                if (i3 > i2) {
                    break;
                } else if (!this.differences[i3].equals(BaseFont.notdef)) {
                    i = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                pdfDictionary.put(PdfName.ENCODING, this.encoding.equals("Cp1252") ? PdfName.WIN_ANSI_ENCODING : PdfName.MAC_ROMAN_ENCODING);
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.ENCODING);
                PdfArray pdfArray = new PdfArray();
                boolean z2 = true;
                for (int i4 = i; i4 <= i2; i4++) {
                    if (bArr[i4] != 0) {
                        if (z2) {
                            pdfArray.add(new PdfNumber(i4));
                            z2 = false;
                        }
                        pdfArray.add(new PdfName(this.differences[i4]));
                    } else {
                        z2 = true;
                    }
                }
                pdfDictionary2.put(PdfName.DIFFERENCES, pdfArray);
                pdfDictionary.put(PdfName.ENCODING, pdfDictionary2);
            }
        }
        if (this.specialMap != null || this.forceWidthsOutput || !this.builtinFont || (!this.fontSpecific && !z)) {
            pdfDictionary.put(PdfName.FIRSTCHAR, new PdfNumber(i));
            pdfDictionary.put(PdfName.LASTCHAR, new PdfNumber(i2));
            PdfArray pdfArray2 = new PdfArray();
            while (i <= i2) {
                if (bArr[i] == 0) {
                    pdfArray2.add(new PdfNumber(0));
                } else {
                    pdfArray2.add(new PdfNumber(this.widths[i]));
                }
                i++;
            }
            pdfDictionary.put(PdfName.WIDTHS, pdfArray2);
        }
        if (!this.builtinFont && pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    /* access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.BaseFont
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        int i = 0;
        int intValue = ((Integer) objArr[0]).intValue();
        int intValue2 = ((Integer) objArr[1]).intValue();
        byte[] bArr = (byte[]) objArr[2];
        if (!(((Boolean) objArr[3]).booleanValue() && this.subset) || !this.embedded) {
            intValue2 = bArr.length - 1;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = 1;
            }
        } else {
            i = intValue;
        }
        PdfIndirectReference pdfIndirectReference2 = null;
        PdfStream fullFontStream = getFullFontStream();
        if (fullFontStream != null) {
            pdfIndirectReference2 = pdfWriter.addToBody(fullFontStream).getIndirectReference();
        }
        PdfDictionary fontDescriptor = getFontDescriptor(pdfIndirectReference2);
        if (fontDescriptor != null) {
            pdfIndirectReference2 = pdfWriter.addToBody(fontDescriptor).getIndirectReference();
        }
        pdfWriter.addToBody(getFontBaseType(pdfIndirectReference2, i, intValue2, bArr), pdfIndirectReference);
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public float getFontDescriptor(int i, float f) {
        int i2;
        switch (i) {
            case 1:
            case 9:
                i2 = this.Ascender;
                break;
            case 2:
                i2 = this.CapHeight;
                break;
            case 3:
            case 10:
                i2 = this.Descender;
                break;
            case 4:
                return this.ItalicAngle;
            case 5:
                i2 = this.llx;
                break;
            case 6:
                i2 = this.lly;
                break;
            case 7:
                i2 = this.urx;
                break;
            case 8:
                i2 = this.ury;
                break;
            case 11:
            default:
                return 0.0f;
            case 12:
                i2 = this.urx - this.llx;
                break;
            case 13:
                i2 = this.UnderlinePosition;
                break;
            case 14:
                i2 = this.UnderlineThickness;
                break;
        }
        return (((float) i2) * f) / 1000.0f;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setFontDescriptor(int i, float f) {
        if (i != 1) {
            if (i != 3) {
                if (i != 9) {
                    if (i != 10) {
                        return;
                    }
                }
            }
            this.Descender = (int) f;
            return;
        }
        this.Ascender = (int) f;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String getPostscriptFontName() {
        return this.FontName;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.FullName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.FullName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public String[][] getFamilyFontName() {
        return new String[][]{new String[]{"", "", "", this.FamilyName}};
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean hasKernPairs() {
        return !this.KernPairs.isEmpty();
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public void setPostscriptFontName(String str) {
        this.FontName = str;
    }

    @Override // com.itextpdf.text.pdf.BaseFont
    public boolean setKerning(int i, int i2, int i3) {
        String unicodeToName;
        String unicodeToName2 = GlyphList.unicodeToName(i);
        if (unicodeToName2 == null || (unicodeToName = GlyphList.unicodeToName(i2)) == null) {
            return false;
        }
        Object[] objArr = this.KernPairs.get(unicodeToName2);
        if (objArr == null) {
            this.KernPairs.put(unicodeToName2, new Object[]{unicodeToName, Integer.valueOf(i3)});
            return true;
        }
        for (int i4 = 0; i4 < objArr.length; i4 += 2) {
            if (unicodeToName.equals(objArr[i4])) {
                objArr[i4 + 1] = Integer.valueOf(i3);
                return true;
            }
        }
        int length = objArr.length;
        Object[] objArr2 = new Object[(length + 2)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[length] = unicodeToName;
        objArr2[length + 1] = Integer.valueOf(i3);
        this.KernPairs.put(unicodeToName2, objArr2);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.BaseFont
    public int[] getRawCharBBox(int i, String str) {
        Object[] objArr;
        if (str == null) {
            objArr = this.CharMetrics.get(Integer.valueOf(i));
        } else if (str.equals(BaseFont.notdef)) {
            return null;
        } else {
            objArr = this.CharMetrics.get(str);
        }
        if (objArr != null) {
            return (int[]) objArr[3];
        }
        return null;
    }
}
