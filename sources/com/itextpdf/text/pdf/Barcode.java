package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;

public abstract class Barcode {
    public static final int CODABAR = 12;
    public static final int CODE128 = 9;
    public static final int CODE128_RAW = 11;
    public static final int CODE128_UCC = 10;
    public static final int EAN13 = 1;
    public static final int EAN8 = 2;
    public static final int PLANET = 8;
    public static final int POSTNET = 7;
    public static final int SUPP2 = 5;
    public static final int SUPP5 = 6;
    public static final int UPCA = 3;
    public static final int UPCE = 4;
    protected String altText;
    protected float barHeight;
    protected float baseline;
    protected boolean checksumText;
    protected String code = "";
    protected int codeType;
    protected boolean extended;
    protected BaseFont font;
    protected boolean generateChecksum;
    protected boolean guardBars;
    protected float inkSpreading = 0.0f;
    protected float n;
    protected float size;
    protected boolean startStopText;
    protected int textAlignment;
    protected float x;

    public abstract Rectangle getBarcodeSize();

    public abstract Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2);

    public float getX() {
        return this.x;
    }

    public void setX(float f) {
        this.x = f;
    }

    public float getN() {
        return this.n;
    }

    public void setN(float f) {
        this.n = f;
    }

    public BaseFont getFont() {
        return this.font;
    }

    public void setFont(BaseFont baseFont) {
        this.font = baseFont;
    }

    public float getSize() {
        return this.size;
    }

    public void setSize(float f) {
        this.size = f;
    }

    public float getBaseline() {
        return this.baseline;
    }

    public void setBaseline(float f) {
        this.baseline = f;
    }

    public float getBarHeight() {
        return this.barHeight;
    }

    public void setBarHeight(float f) {
        this.barHeight = f;
    }

    public int getTextAlignment() {
        return this.textAlignment;
    }

    public void setTextAlignment(int i) {
        this.textAlignment = i;
    }

    public boolean isGenerateChecksum() {
        return this.generateChecksum;
    }

    public void setGenerateChecksum(boolean z) {
        this.generateChecksum = z;
    }

    public boolean isChecksumText() {
        return this.checksumText;
    }

    public void setChecksumText(boolean z) {
        this.checksumText = z;
    }

    public boolean isStartStopText() {
        return this.startStopText;
    }

    public void setStartStopText(boolean z) {
        this.startStopText = z;
    }

    public boolean isExtended() {
        return this.extended;
    }

    public void setExtended(boolean z) {
        this.extended = z;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public boolean isGuardBars() {
        return this.guardBars;
    }

    public void setGuardBars(boolean z) {
        this.guardBars = z;
    }

    public int getCodeType() {
        return this.codeType;
    }

    public void setCodeType(int i) {
        this.codeType = i;
    }

    public PdfTemplate createTemplateWithBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        PdfTemplate createTemplate = pdfContentByte.createTemplate(0.0f, 0.0f);
        createTemplate.setBoundingBox(placeBarcode(createTemplate, baseColor, baseColor2));
        return createTemplate;
    }

    public Image createImageWithBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        try {
            return Image.getInstance(createTemplateWithBarcode(pdfContentByte, baseColor, baseColor2));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public float getInkSpreading() {
        return this.inkSpreading;
    }

    public void setInkSpreading(float f) {
        this.inkSpreading = f;
    }

    public String getAltText() {
        return this.altText;
    }

    public void setAltText(String str) {
        this.altText = str;
    }
}
