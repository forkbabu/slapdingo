package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.SplitCharacter;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PdfChunk {
    private static final float ITALIC_ANGLE = 0.21256f;
    private static final String TABSTOP = "TABSTOP";
    public static final float UNDERLINE_OFFSET = -0.33333334f;
    public static final float UNDERLINE_THICKNESS = 0.06666667f;
    private static final HashSet<String> keysAttributes = new HashSet<>();
    private static final HashSet<String> keysNoStroke = new HashSet<>();
    private static final char[] singleSpace = {' '};
    protected IAccessibleElement accessibleElement;
    protected HashMap<String, Object> attributes;
    protected BaseFont baseFont;
    protected boolean changeLeading;
    protected String encoding;
    protected PdfFont font;
    protected Image image;
    protected float imageScalePercentage;
    protected float leading;
    protected boolean newlineSplit;
    protected HashMap<String, Object> noStroke;
    protected float offsetX;
    protected float offsetY;
    protected SplitCharacter splitCharacter;
    protected String value;

    public static boolean noPrint(int i) {
        return (i >= 8203 && i <= 8207) || (i >= 8234 && i <= 8238) || i == 173;
    }

    static {
        keysAttributes.add(Chunk.ACTION);
        keysAttributes.add(Chunk.UNDERLINE);
        keysAttributes.add(Chunk.REMOTEGOTO);
        keysAttributes.add(Chunk.LOCALGOTO);
        keysAttributes.add(Chunk.LOCALDESTINATION);
        keysAttributes.add(Chunk.GENERICTAG);
        keysAttributes.add(Chunk.NEWPAGE);
        keysAttributes.add(Chunk.IMAGE);
        keysAttributes.add(Chunk.BACKGROUND);
        keysAttributes.add(Chunk.PDFANNOTATION);
        keysAttributes.add(Chunk.SKEW);
        keysAttributes.add(Chunk.HSCALE);
        keysAttributes.add(Chunk.SEPARATOR);
        keysAttributes.add(Chunk.TAB);
        keysAttributes.add(Chunk.TABSETTINGS);
        keysAttributes.add(Chunk.CHAR_SPACING);
        keysAttributes.add(Chunk.WORD_SPACING);
        keysAttributes.add(Chunk.LINEHEIGHT);
        keysNoStroke.add(Chunk.SUBSUPSCRIPT);
        keysNoStroke.add(Chunk.SPLITCHARACTER);
        keysNoStroke.add(Chunk.HYPHENATION);
        keysNoStroke.add(Chunk.TEXTRENDERMODE);
    }

    PdfChunk(String str, PdfChunk pdfChunk) {
        this.value = "";
        this.encoding = "Cp1252";
        this.attributes = new HashMap<>();
        this.noStroke = new HashMap<>();
        this.imageScalePercentage = 1.0f;
        this.changeLeading = false;
        this.leading = 0.0f;
        this.accessibleElement = null;
        this.value = str;
        this.font = pdfChunk.font;
        HashMap<String, Object> hashMap = pdfChunk.attributes;
        this.attributes = hashMap;
        this.noStroke = pdfChunk.noStroke;
        this.baseFont = pdfChunk.baseFont;
        this.changeLeading = pdfChunk.changeLeading;
        this.leading = pdfChunk.leading;
        Object[] objArr = (Object[]) hashMap.get(Chunk.IMAGE);
        if (objArr == null) {
            this.image = null;
        } else {
            this.image = (Image) objArr[0];
            this.offsetX = ((Float) objArr[1]).floatValue();
            this.offsetY = ((Float) objArr[2]).floatValue();
            this.changeLeading = ((Boolean) objArr[3]).booleanValue();
        }
        this.encoding = this.font.getFont().getEncoding();
        SplitCharacter splitCharacter2 = (SplitCharacter) this.noStroke.get(Chunk.SPLITCHARACTER);
        this.splitCharacter = splitCharacter2;
        if (splitCharacter2 == null) {
            this.splitCharacter = DefaultSplitCharacter.DEFAULT;
        }
        this.accessibleElement = pdfChunk.accessibleElement;
    }

    PdfChunk(Chunk chunk, PdfAction pdfAction) {
        this.value = "";
        this.encoding = "Cp1252";
        this.attributes = new HashMap<>();
        this.noStroke = new HashMap<>();
        this.imageScalePercentage = 1.0f;
        this.changeLeading = false;
        this.leading = 0.0f;
        this.accessibleElement = null;
        this.value = chunk.getContent();
        Font font2 = chunk.getFont();
        float size = font2.getSize();
        size = size == -1.0f ? 12.0f : size;
        this.baseFont = font2.getBaseFont();
        int style = font2.getStyle();
        style = style == -1 ? 0 : style;
        if (this.baseFont == null) {
            this.baseFont = font2.getCalculatedBaseFont(false);
        } else {
            if ((style & 1) != 0) {
                this.attributes.put(Chunk.TEXTRENDERMODE, new Object[]{2, new Float(size / 30.0f), null});
            }
            if ((style & 2) != 0) {
                this.attributes.put(Chunk.SKEW, new float[]{0.0f, ITALIC_ANGLE});
            }
        }
        this.font = new PdfFont(this.baseFont, size);
        HashMap<String, Object> attributes2 = chunk.getAttributes();
        if (attributes2 != null) {
            for (Map.Entry<String, Object> entry : attributes2.entrySet()) {
                String key = entry.getKey();
                if (keysAttributes.contains(key)) {
                    this.attributes.put(key, entry.getValue());
                } else if (keysNoStroke.contains(key)) {
                    this.noStroke.put(key, entry.getValue());
                }
            }
            if ("".equals(attributes2.get(Chunk.GENERICTAG))) {
                this.attributes.put(Chunk.GENERICTAG, chunk.getContent());
            }
        }
        if (font2.isUnderlined()) {
            this.attributes.put(Chunk.UNDERLINE, Utilities.addToArray((Object[][]) this.attributes.get(Chunk.UNDERLINE), new Object[]{null, new float[]{0.0f, 0.06666667f, 0.0f, -0.33333334f, 0.0f}}));
        }
        if (font2.isStrikethru()) {
            this.attributes.put(Chunk.UNDERLINE, Utilities.addToArray((Object[][]) this.attributes.get(Chunk.UNDERLINE), new Object[]{null, new float[]{0.0f, 0.06666667f, 0.0f, 0.33333334f, 0.0f}}));
        }
        if (pdfAction != null) {
            this.attributes.put(Chunk.ACTION, pdfAction);
        }
        this.noStroke.put(Chunk.COLOR, font2.getColor());
        this.noStroke.put(Chunk.ENCODING, this.font.getFont().getEncoding());
        Float f = (Float) this.attributes.get(Chunk.LINEHEIGHT);
        if (f != null) {
            this.changeLeading = true;
            this.leading = f.floatValue();
        }
        Object[] objArr = (Object[]) this.attributes.get(Chunk.IMAGE);
        if (objArr == null) {
            this.image = null;
        } else {
            this.attributes.remove(Chunk.HSCALE);
            this.image = (Image) objArr[0];
            this.offsetX = ((Float) objArr[1]).floatValue();
            this.offsetY = ((Float) objArr[2]).floatValue();
            this.changeLeading = ((Boolean) objArr[3]).booleanValue();
        }
        Float f2 = (Float) this.attributes.get(Chunk.HSCALE);
        if (f2 != null) {
            this.font.setHorizontalScaling(f2.floatValue());
        }
        this.encoding = this.font.getFont().getEncoding();
        SplitCharacter splitCharacter2 = (SplitCharacter) this.noStroke.get(Chunk.SPLITCHARACTER);
        this.splitCharacter = splitCharacter2;
        if (splitCharacter2 == null) {
            this.splitCharacter = DefaultSplitCharacter.DEFAULT;
        }
        this.accessibleElement = chunk;
    }

    PdfChunk(Chunk chunk, PdfAction pdfAction, TabSettings tabSettings) {
        this(chunk, pdfAction);
        if (tabSettings != null && this.attributes.get(Chunk.TABSETTINGS) == null) {
            this.attributes.put(Chunk.TABSETTINGS, tabSettings);
        }
    }

    public int getUnicodeEquivalent(int i) {
        return this.baseFont.getUnicodeEquivalent(i);
    }

    /* access modifiers changed from: protected */
    public int getWord(String str, int i) {
        int length = str.length();
        while (i < length && Character.isLetter(str.charAt(i))) {
            i++;
        }
        return i;
    }

    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013a, code lost:
        if (r6 != '\r') goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013c, code lost:
        r1 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013e, code lost:
        if (r1 >= r5) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0142, code lost:
        if (r12[r1] != '\n') goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0144, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0146, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0147, code lost:
        r1 = r21.value.substring(r14 + r9);
        r2 = r21.value.substring(0, r9);
        r21.value = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015c, code lost:
        if (r2.length() >= 1) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015e, code lost:
        r21.value = " ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0167, code lost:
        return new com.itextpdf.text.pdf.PdfChunk(r1, r21);
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r10v4, types: [int, boolean] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfChunk split(float r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 0
            r0.newlineSplit = r1
            com.itextpdf.text.Image r2 = r0.image
            java.lang.String r3 = ""
            r4 = 0
            if (r2 == 0) goto L_0x002f
            float r1 = r2.getScaledWidth()
            int r1 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r1 <= 0) goto L_0x002e
            com.itextpdf.text.pdf.PdfChunk r1 = new com.itextpdf.text.pdf.PdfChunk
            java.lang.String r2 = "￼"
            r1.<init>(r2, r0)
            r0.value = r3
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.attributes = r2
            r0.image = r4
            com.itextpdf.text.pdf.PdfFont r2 = com.itextpdf.text.pdf.PdfFont.getDefaultFont()
            r0.font = r2
            return r1
        L_0x002e:
            return r4
        L_0x002f:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.noStroke
            java.lang.String r5 = "HYPHENATION"
            java.lang.Object r2 = r2.get(r5)
            com.itextpdf.text.pdf.HyphenationEvent r2 = (com.itextpdf.text.pdf.HyphenationEvent) r2
            java.lang.String r5 = r0.value
            int r5 = r5.length()
            java.lang.String r6 = r0.value
            char[] r12 = r6.toCharArray()
            com.itextpdf.text.pdf.PdfFont r6 = r0.font
            com.itextpdf.text.pdf.BaseFont r13 = r6.getFont()
            int r6 = r13.getFontType()
            r14 = 2
            r7 = 0
            r8 = -1
            r15 = 10
            r11 = 32
            r10 = 1
            if (r6 != r14) goto L_0x00d9
            int r6 = r13.getUnicodeEquivalent(r11)
            if (r6 == r11) goto L_0x00d9
            r6 = 0
            r9 = 0
            r14 = -1
        L_0x0062:
            if (r9 >= r5) goto L_0x00d5
            char r4 = r12[r9]
            int r11 = r13.getUnicodeEquivalent(r4)
            char r11 = (char) r11
            if (r11 != r15) goto L_0x008f
            r0.newlineSplit = r10
            java.lang.String r2 = r0.value
            int r3 = r9 + 1
            java.lang.String r2 = r2.substring(r3)
            java.lang.String r3 = r0.value
            java.lang.String r1 = r3.substring(r1, r9)
            r0.value = r1
            int r1 = r1.length()
            if (r1 >= r10) goto L_0x0089
            java.lang.String r1 = "\u0001"
            r0.value = r1
        L_0x0089:
            com.itextpdf.text.pdf.PdfChunk r1 = new com.itextpdf.text.pdf.PdfChunk
            r1.<init>(r2, r0)
            return r1
        L_0x008f:
            float r4 = r0.getCharWidth(r4)
            float r4 = r4 + r7
            r7 = 32
            if (r11 != r7) goto L_0x009f
            int r6 = r9 + 1
            r17 = r4
            r18 = r6
            goto L_0x00a3
        L_0x009f:
            r17 = r6
            r18 = r8
        L_0x00a3:
            int r6 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ad
            r6 = r17
            r8 = r18
            goto L_0x016a
        L_0x00ad:
            com.itextpdf.text.SplitCharacter r6 = r0.splitCharacter
            r8 = 0
            com.itextpdf.text.pdf.PdfChunk[] r11 = new com.itextpdf.text.pdf.PdfChunk[r10]
            r11[r1] = r0
            r19 = 32
            r7 = r8
            r8 = r9
            r20 = r9
            r9 = r5
            r1 = 1
            r10 = r12
            r1 = 32
            boolean r6 = r6.isSplitCharacter(r7, r8, r9, r10, r11)
            if (r6 == 0) goto L_0x00c8
            int r9 = r20 + 1
            r14 = r9
        L_0x00c8:
            int r9 = r20 + 1
            r7 = r4
            r6 = r17
            r8 = r18
            r1 = 0
            r4 = 0
            r10 = 1
            r11 = 32
            goto L_0x0062
        L_0x00d5:
            r20 = r9
            goto L_0x016a
        L_0x00d9:
            r1 = 32
            r4 = 0
            r9 = 0
            r13 = -1
        L_0x00de:
            if (r9 >= r5) goto L_0x0168
            char r6 = r12[r9]
            r10 = 13
            if (r6 == r10) goto L_0x0137
            if (r6 != r15) goto L_0x00e9
            goto L_0x0137
        L_0x00e9:
            boolean r10 = com.itextpdf.text.Utilities.isSurrogatePair(r12, r9)
            if (r10 == 0) goto L_0x00fe
            char r11 = r12[r9]
            int r17 = r9 + 1
            char r14 = r12[r17]
            int r11 = com.itextpdf.text.Utilities.convertToUtf32(r11, r14)
            float r11 = r0.getCharWidth(r11)
            goto L_0x0102
        L_0x00fe:
            float r11 = r0.getCharWidth(r6)
        L_0x0102:
            float r7 = r7 + r11
            r14 = r7
            if (r6 != r1) goto L_0x010c
            int r4 = r9 + 1
            r17 = r4
            r4 = r14
            goto L_0x010e
        L_0x010c:
            r17 = r8
        L_0x010e:
            if (r10 == 0) goto L_0x0112
            int r9 = r9 + 1
        L_0x0112:
            r19 = r9
            int r6 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x011f
            r6 = r4
            r14 = r13
            r8 = r17
            r9 = r19
            goto L_0x016a
        L_0x011f:
            com.itextpdf.text.SplitCharacter r6 = r0.splitCharacter
            r7 = 0
            r11 = 0
            r8 = r19
            r9 = r5
            r10 = r12
            boolean r6 = r6.isSplitCharacter(r7, r8, r9, r10, r11)
            if (r6 == 0) goto L_0x0130
            int r6 = r19 + 1
            r13 = r6
        L_0x0130:
            int r9 = r19 + 1
            r7 = r14
            r8 = r17
            r14 = 2
            goto L_0x00de
        L_0x0137:
            r1 = 1
            r0.newlineSplit = r1
            if (r6 != r10) goto L_0x0146
            int r1 = r9 + 1
            if (r1 >= r5) goto L_0x0146
            char r1 = r12[r1]
            if (r1 != r15) goto L_0x0146
            r14 = 2
            goto L_0x0147
        L_0x0146:
            r14 = 1
        L_0x0147:
            java.lang.String r1 = r0.value
            int r14 = r14 + r9
            java.lang.String r1 = r1.substring(r14)
            java.lang.String r2 = r0.value
            r3 = 0
            java.lang.String r2 = r2.substring(r3, r9)
            r0.value = r2
            int r2 = r2.length()
            r3 = 1
            if (r2 >= r3) goto L_0x0162
            java.lang.String r2 = " "
            r0.value = r2
        L_0x0162:
            com.itextpdf.text.pdf.PdfChunk r2 = new com.itextpdf.text.pdf.PdfChunk
            r2.<init>(r1, r0)
            return r2
        L_0x0168:
            r6 = r4
            r14 = r13
        L_0x016a:
            if (r9 != r5) goto L_0x016e
            r1 = 0
            return r1
        L_0x016e:
            if (r14 >= 0) goto L_0x017a
            java.lang.String r1 = r0.value
            r0.value = r3
            com.itextpdf.text.pdf.PdfChunk r2 = new com.itextpdf.text.pdf.PdfChunk
            r2.<init>(r1, r0)
            return r2
        L_0x017a:
            if (r8 <= r14) goto L_0x018f
            com.itextpdf.text.SplitCharacter r15 = r0.splitCharacter
            r16 = 0
            r17 = 0
            r18 = 1
            char[] r19 = com.itextpdf.text.pdf.PdfChunk.singleSpace
            r20 = 0
            boolean r1 = r15.isSplitCharacter(r16, r17, r18, r19, r20)
            if (r1 == 0) goto L_0x018f
            r14 = r8
        L_0x018f:
            if (r2 == 0) goto L_0x01f6
            if (r8 < 0) goto L_0x01f6
            if (r8 >= r9) goto L_0x01f6
            java.lang.String r1 = r0.value
            int r1 = r0.getWord(r1, r8)
            if (r1 <= r8) goto L_0x01f6
            java.lang.String r3 = r0.value
            java.lang.String r3 = r3.substring(r8, r1)
            com.itextpdf.text.pdf.PdfFont r4 = r0.font
            com.itextpdf.text.pdf.BaseFont r4 = r4.getFont()
            com.itextpdf.text.pdf.PdfFont r5 = r0.font
            float r5 = r5.size()
            float r6 = r22 - r6
            java.lang.String r3 = r2.getHyphenatedWordPre(r3, r4, r5, r6)
            java.lang.String r2 = r2.getHyphenatedWordPost()
            int r4 = r3.length()
            if (r4 <= 0) goto L_0x01f6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = r0.value
            java.lang.String r1 = r2.substring(r1)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r0.value
            r5 = 0
            java.lang.String r4 = r4.substring(r5, r8)
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r0.trim(r2)
            r0.value = r2
            com.itextpdf.text.pdf.PdfChunk r2 = new com.itextpdf.text.pdf.PdfChunk
            r2.<init>(r1, r0)
            return r2
        L_0x01f6:
            java.lang.String r1 = r0.value
            java.lang.String r1 = r1.substring(r14)
            java.lang.String r2 = r0.value
            r3 = 0
            java.lang.String r2 = r2.substring(r3, r14)
            java.lang.String r2 = r0.trim(r2)
            r0.value = r2
            com.itextpdf.text.pdf.PdfChunk r2 = new com.itextpdf.text.pdf.PdfChunk
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfChunk.split(float):com.itextpdf.text.pdf.PdfChunk");
    }

    /* access modifiers changed from: package-private */
    public PdfChunk truncate(float f) {
        float f2;
        Image image2 = this.image;
        if (image2 == null) {
            float f3 = 0.0f;
            int i = 1;
            if (f < this.font.width()) {
                String substring = this.value.substring(1);
                this.value = this.value.substring(0, 1);
                return new PdfChunk(substring, this);
            }
            int length = this.value.length();
            int i2 = 0;
            boolean z = false;
            while (i2 < length) {
                z = Utilities.isSurrogatePair(this.value, i2);
                if (z) {
                    f2 = getCharWidth(Utilities.convertToUtf32(this.value, i2));
                } else {
                    f2 = getCharWidth(this.value.charAt(i2));
                }
                f3 += f2;
                if (f3 > f) {
                    break;
                }
                if (z) {
                    i2++;
                }
                i2++;
            }
            if (i2 == length) {
                return null;
            }
            if (i2 != 0) {
                i = i2;
            } else if (z) {
                i = 2;
            }
            String substring2 = this.value.substring(i);
            this.value = this.value.substring(0, i);
            return new PdfChunk(substring2, this);
        } else if (image2.getScaledWidth() <= f) {
            return null;
        } else {
            if (this.image.isScaleToFitLineWhenOverflow()) {
                setImageScalePercentage(f / this.image.getWidth());
                return null;
            }
            PdfChunk pdfChunk = new PdfChunk("", this);
            this.value = "";
            this.attributes.remove(Chunk.IMAGE);
            this.image = null;
            this.font = PdfFont.getDefaultFont();
            return pdfChunk;
        }
    }

    /* access modifiers changed from: package-private */
    public PdfFont font() {
        return this.font;
    }

    /* access modifiers changed from: package-private */
    public BaseColor color() {
        return (BaseColor) this.noStroke.get(Chunk.COLOR);
    }

    /* access modifiers changed from: package-private */
    public float width() {
        return width(this.value);
    }

    /* access modifiers changed from: package-private */
    public float width(String str) {
        if (isAttribute(Chunk.SEPARATOR)) {
            return 0.0f;
        }
        if (isImage()) {
            return getImageWidth();
        }
        float width = this.font.width(str);
        if (isAttribute(Chunk.CHAR_SPACING)) {
            width += ((float) str.length()) * ((Float) getAttribute(Chunk.CHAR_SPACING)).floatValue();
        }
        if (!isAttribute(Chunk.WORD_SPACING)) {
            return width;
        }
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = str.indexOf(32, i2 + 1);
            if (i2 < 0) {
                return width + (((float) i) * ((Float) getAttribute(Chunk.WORD_SPACING)).floatValue());
            }
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public float height() {
        if (isImage()) {
            return getImageHeight();
        }
        return this.font.size();
    }

    public boolean isNewlineSplit() {
        return this.newlineSplit;
    }

    public float getWidthCorrected(float f, float f2) {
        Image image2 = this.image;
        if (image2 != null) {
            return image2.getScaledWidth() + f;
        }
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.value.indexOf(32, i2 + 1);
            if (i2 < 0) {
                return this.font.width(this.value) + (((float) this.value.length()) * f) + (((float) i) * f2);
            }
            i++;
        }
    }

    public float getTextRise() {
        Float f = (Float) getAttribute(Chunk.SUBSUPSCRIPT);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public float trimLastSpace() {
        BaseFont font2 = this.font.getFont();
        if (font2.getFontType() != 2 || font2.getUnicodeEquivalent(32) == 32) {
            if (this.value.length() <= 1 || !this.value.endsWith(" ")) {
                return 0.0f;
            }
            String str = this.value;
            this.value = str.substring(0, str.length() - 1);
            return this.font.width(32);
        } else if (this.value.length() <= 1 || !this.value.endsWith("\u0001")) {
            return 0.0f;
        } else {
            String str2 = this.value;
            this.value = str2.substring(0, str2.length() - 1);
            return this.font.width(1);
        }
    }

    public float trimFirstSpace() {
        BaseFont font2 = this.font.getFont();
        if (font2.getFontType() != 2 || font2.getUnicodeEquivalent(32) == 32) {
            if (this.value.length() <= 1 || !this.value.startsWith(" ")) {
                return 0.0f;
            }
            this.value = this.value.substring(1);
            return this.font.width(32);
        } else if (this.value.length() <= 1 || !this.value.startsWith("\u0001")) {
            return 0.0f;
        } else {
            this.value = this.value.substring(1);
            return this.font.width(1);
        }
    }

    /* access modifiers changed from: package-private */
    public Object getAttribute(String str) {
        if (this.attributes.containsKey(str)) {
            return this.attributes.get(str);
        }
        return this.noStroke.get(str);
    }

    /* access modifiers changed from: package-private */
    public boolean isAttribute(String str) {
        if (this.attributes.containsKey(str)) {
            return true;
        }
        return this.noStroke.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public boolean isStroked() {
        return !this.attributes.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean isSeparator() {
        return isAttribute(Chunk.SEPARATOR);
    }

    /* access modifiers changed from: package-private */
    public boolean isHorizontalSeparator() {
        if (isAttribute(Chunk.SEPARATOR)) {
            return !((Boolean) ((Object[]) getAttribute(Chunk.SEPARATOR))[1]).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isTab() {
        return isAttribute(Chunk.TAB);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public void adjustLeft(float f) {
        Object[] objArr = (Object[]) this.attributes.get(Chunk.TAB);
        if (objArr != null) {
            this.attributes.put(Chunk.TAB, new Object[]{objArr[0], objArr[1], objArr[2], new Float(f)});
        }
    }

    static TabStop getTabStop(PdfChunk pdfChunk, float f) {
        Object[] objArr = (Object[]) pdfChunk.attributes.get(Chunk.TAB);
        if (objArr == null) {
            return null;
        }
        Float f2 = (Float) objArr[0];
        if (Float.isNaN(f2.floatValue())) {
            return TabSettings.getTabStopNewInstance(f, (TabSettings) pdfChunk.attributes.get(Chunk.TABSETTINGS));
        }
        return TabStop.newInstance(f, f2.floatValue());
    }

    /* access modifiers changed from: package-private */
    public TabStop getTabStop() {
        return (TabStop) this.attributes.get(TABSTOP);
    }

    /* access modifiers changed from: package-private */
    public void setTabStop(TabStop tabStop) {
        this.attributes.put(TABSTOP, tabStop);
    }

    /* access modifiers changed from: package-private */
    public boolean isImage() {
        return this.image != null;
    }

    /* access modifiers changed from: package-private */
    public Image getImage() {
        return this.image;
    }

    /* access modifiers changed from: package-private */
    public float getImageHeight() {
        return this.image.getScaledHeight() * this.imageScalePercentage;
    }

    /* access modifiers changed from: package-private */
    public float getImageWidth() {
        return this.image.getScaledWidth() * this.imageScalePercentage;
    }

    public float getImageScalePercentage() {
        return this.imageScalePercentage;
    }

    public void setImageScalePercentage(float f) {
        this.imageScalePercentage = f;
    }

    /* access modifiers changed from: package-private */
    public void setImageOffsetX(float f) {
        this.offsetX = f;
    }

    /* access modifiers changed from: package-private */
    public float getImageOffsetX() {
        return this.offsetX;
    }

    /* access modifiers changed from: package-private */
    public void setImageOffsetY(float f) {
        this.offsetY = f;
    }

    /* access modifiers changed from: package-private */
    public float getImageOffsetY() {
        return this.offsetY;
    }

    /* access modifiers changed from: package-private */
    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    /* access modifiers changed from: package-private */
    public boolean isSpecialEncoding() {
        return this.encoding.equals("UnicodeBigUnmarked") || this.encoding.equals(BaseFont.IDENTITY_H);
    }

    /* access modifiers changed from: package-private */
    public String getEncoding() {
        return this.encoding;
    }

    /* access modifiers changed from: package-private */
    public int length() {
        return this.value.length();
    }

    /* access modifiers changed from: package-private */
    public int lengthUtf32() {
        if (!BaseFont.IDENTITY_H.equals(this.encoding)) {
            return this.value.length();
        }
        int length = this.value.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (Utilities.isSurrogateHigh(this.value.charAt(i))) {
                i++;
            }
            i2++;
            i++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean isExtSplitCharacter(int i, int i2, int i3, char[] cArr, PdfChunk[] pdfChunkArr) {
        return this.splitCharacter.isSplitCharacter(i, i2, i3, cArr, pdfChunkArr);
    }

    /* access modifiers changed from: package-private */
    public String trim(String str) {
        BaseFont font2 = this.font.getFont();
        if (font2.getFontType() != 2 || font2.getUnicodeEquivalent(32) == 32) {
            while (true) {
                if (!str.endsWith(" ") && !str.endsWith("\t")) {
                    break;
                }
                str = str.substring(0, str.length() - 1);
            }
        } else {
            while (str.endsWith("\u0001")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public boolean changeLeading() {
        return this.changeLeading;
    }

    public float getLeading() {
        return this.leading;
    }

    /* access modifiers changed from: package-private */
    public float getCharWidth(int i) {
        if (noPrint(i)) {
            return 0.0f;
        }
        if (isAttribute(Chunk.CHAR_SPACING)) {
            return this.font.width(i) + (((Float) getAttribute(Chunk.CHAR_SPACING)).floatValue() * this.font.getHorizontalScaling());
        }
        if (isImage()) {
            return getImageWidth();
        }
        return this.font.width(i);
    }
}
