package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.DocumentFont;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.UByte;
import kotlin.text.Typography;

public class TextRenderInfo {
    private double[] fontMatrix = null;
    private final GraphicsState gs;
    private final Collection<MarkedContentInfo> markedContentInfos;
    private final PdfString string;
    private String text = null;
    private final Matrix textToUserSpaceTransformMatrix;
    private Float unscaledWidth = null;

    TextRenderInfo(PdfString pdfString, GraphicsState graphicsState, Matrix matrix, Collection<MarkedContentInfo> collection) {
        this.string = pdfString;
        this.textToUserSpaceTransformMatrix = matrix.multiply(graphicsState.ctm);
        this.gs = graphicsState;
        this.markedContentInfos = new ArrayList(collection);
        this.fontMatrix = graphicsState.font.getFontMatrix();
    }

    private TextRenderInfo(TextRenderInfo textRenderInfo, PdfString pdfString, float f) {
        this.string = pdfString;
        this.textToUserSpaceTransformMatrix = new Matrix(f, 0.0f).multiply(textRenderInfo.textToUserSpaceTransformMatrix);
        GraphicsState graphicsState = textRenderInfo.gs;
        this.gs = graphicsState;
        this.markedContentInfos = textRenderInfo.markedContentInfos;
        this.fontMatrix = graphicsState.font.getFontMatrix();
    }

    public String getText() {
        if (this.text == null) {
            this.text = decode(this.string);
        }
        return this.text;
    }

    public PdfString getPdfString() {
        return this.string;
    }

    public boolean hasMcid(int i) {
        return hasMcid(i, false);
    }

    public boolean hasMcid(int i, boolean z) {
        Integer mcid;
        if (!z) {
            for (MarkedContentInfo markedContentInfo : this.markedContentInfos) {
                if (markedContentInfo.hasMcid() && markedContentInfo.getMcid() == i) {
                    return true;
                }
            }
        } else if (!(this.markedContentInfos instanceof ArrayList) || (mcid = getMcid()) == null || mcid.intValue() != i) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    public Integer getMcid() {
        Collection<MarkedContentInfo> collection = this.markedContentInfos;
        if (!(collection instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) collection;
        MarkedContentInfo markedContentInfo = arrayList.size() > 0 ? (MarkedContentInfo) arrayList.get(arrayList.size() - 1) : null;
        if (markedContentInfo == null || !markedContentInfo.hasMcid()) {
            return null;
        }
        return Integer.valueOf(markedContentInfo.getMcid());
    }

    /* access modifiers changed from: package-private */
    public float getUnscaledWidth() {
        if (this.unscaledWidth == null) {
            this.unscaledWidth = Float.valueOf(getPdfStringWidth(this.string, false));
        }
        return this.unscaledWidth.floatValue();
    }

    public LineSegment getBaseline() {
        return getUnscaledBaselineWithOffset(this.gs.rise + 0.0f).transformBy(this.textToUserSpaceTransformMatrix);
    }

    public LineSegment getUnscaledBaseline() {
        return getUnscaledBaselineWithOffset(this.gs.rise + 0.0f);
    }

    public LineSegment getAscentLine() {
        return getUnscaledBaselineWithOffset(this.gs.getFont().getFontDescriptor(1, this.gs.getFontSize()) + this.gs.rise).transformBy(this.textToUserSpaceTransformMatrix);
    }

    public LineSegment getDescentLine() {
        return getUnscaledBaselineWithOffset(this.gs.getFont().getFontDescriptor(3, this.gs.getFontSize()) + this.gs.rise).transformBy(this.textToUserSpaceTransformMatrix);
    }

    private LineSegment getUnscaledBaselineWithOffset(float f) {
        String unicodeString = this.string.toUnicodeString();
        return new LineSegment(new Vector(0.0f, f, 1.0f), new Vector(getUnscaledWidth() - ((this.gs.characterSpacing + ((unicodeString.length() <= 0 || unicodeString.charAt(unicodeString.length() + -1) != ' ') ? 0.0f : this.gs.wordSpacing)) * this.gs.horizontalScaling), f, 1.0f));
    }

    public DocumentFont getFont() {
        return this.gs.getFont();
    }

    public float getRise() {
        if (this.gs.rise == 0.0f) {
            return 0.0f;
        }
        return convertHeightFromTextSpaceToUserSpace(this.gs.rise);
    }

    private float convertWidthFromTextSpaceToUserSpace(float f) {
        return new LineSegment(new Vector(0.0f, 0.0f, 1.0f), new Vector(f, 0.0f, 1.0f)).transformBy(this.textToUserSpaceTransformMatrix).getLength();
    }

    private float convertHeightFromTextSpaceToUserSpace(float f) {
        return new LineSegment(new Vector(0.0f, 0.0f, 1.0f), new Vector(0.0f, f, 1.0f)).transformBy(this.textToUserSpaceTransformMatrix).getLength();
    }

    public float getSingleSpaceWidth() {
        return convertWidthFromTextSpaceToUserSpace(getUnscaledFontSpaceWidth());
    }

    public int getTextRenderMode() {
        return this.gs.renderMode;
    }

    public BaseColor getFillColor() {
        return this.gs.fillColor;
    }

    public BaseColor getStrokeColor() {
        return this.gs.strokeColor;
    }

    private float getUnscaledFontSpaceWidth() {
        char c = ' ';
        if (this.gs.font.getWidth(32) == 0) {
            c = Typography.nbsp;
        }
        return getStringWidth(String.valueOf(c));
    }

    private float getStringWidth(String str) {
        float f = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            f += (((((float) this.gs.font.getWidth(charAt)) / 1000.0f) * this.gs.fontSize) + this.gs.characterSpacing + (charAt == ' ' ? this.gs.wordSpacing : 0.0f)) * this.gs.horizontalScaling;
        }
        return f;
    }

    private float getPdfStringWidth(PdfString pdfString, boolean z) {
        if (z) {
            float[] widthAndWordSpacing = getWidthAndWordSpacing(pdfString, z);
            return ((widthAndWordSpacing[0] * this.gs.fontSize) + this.gs.characterSpacing + widthAndWordSpacing[1]) * this.gs.horizontalScaling;
        }
        float f = 0.0f;
        for (PdfString pdfString2 : splitString(pdfString)) {
            f += getPdfStringWidth(pdfString2, true);
        }
        return f;
    }

    public List<TextRenderInfo> getCharacterRenderInfos() {
        ArrayList<TextRenderInfo> arrayList = new ArrayList(this.string.length());
        PdfString[] splitString = splitString(this.string);
        float f = 0.0f;
        for (int i = 0; i < splitString.length; i++) {
            float[] widthAndWordSpacing = getWidthAndWordSpacing(splitString[i], true);
            arrayList.add(new TextRenderInfo(this, splitString[i], f));
            f += ((widthAndWordSpacing[0] * this.gs.fontSize) + this.gs.characterSpacing + widthAndWordSpacing[1]) * this.gs.horizontalScaling;
        }
        for (TextRenderInfo textRenderInfo : arrayList) {
            textRenderInfo.getUnscaledWidth();
        }
        return arrayList;
    }

    private float[] getWidthAndWordSpacing(PdfString pdfString, boolean z) {
        if (z) {
            float[] fArr = new float[2];
            String decode = decode(pdfString);
            fArr[0] = (float) (((double) this.gs.font.getWidth(getCharCode(decode))) * this.fontMatrix[0]);
            fArr[1] = decode.equals(" ") ? this.gs.wordSpacing : 0.0f;
            return fArr;
        }
        throw new UnsupportedOperationException();
    }

    private String decode(PdfString pdfString) {
        byte[] bytes = pdfString.getBytes();
        return this.gs.font.decode(bytes, 0, bytes.length);
    }

    private int getCharCode(String str) {
        try {
            byte[] bytes = str.getBytes(XmpWriter.UTF16BE);
            int i = 0;
            for (int i2 = 0; i2 < bytes.length - 1; i2++) {
                i = (i + (bytes[i2] & UByte.MAX_VALUE)) << 8;
            }
            return bytes.length > 0 ? i + (bytes[bytes.length - 1] & UByte.MAX_VALUE) : i;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    private PdfString[] splitString(PdfString pdfString) {
        ArrayList arrayList = new ArrayList();
        String pdfString2 = pdfString.toString();
        int i = 0;
        while (i < pdfString2.length()) {
            int i2 = i + 1;
            PdfString pdfString3 = new PdfString(pdfString2.substring(i, i2), pdfString.getEncoding());
            if (decode(pdfString3).length() == 0 && i < pdfString2.length() - 1) {
                pdfString3 = new PdfString(pdfString2.substring(i, i + 2), pdfString.getEncoding());
                i = i2;
            }
            arrayList.add(pdfString3);
            i++;
        }
        return (PdfString[]) arrayList.toArray(new PdfString[arrayList.size()]);
    }
}
