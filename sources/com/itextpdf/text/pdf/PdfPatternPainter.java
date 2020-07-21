package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

public final class PdfPatternPainter extends PdfTemplate {
    BaseColor defaultColor;
    boolean stencil = false;
    float xstep;
    float ystep;

    private PdfPatternPainter() {
        this.type = 3;
    }

    PdfPatternPainter(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.type = 3;
    }

    PdfPatternPainter(PdfWriter pdfWriter, BaseColor baseColor) {
        this(pdfWriter);
        if (baseColor == null) {
            this.defaultColor = BaseColor.GRAY;
        } else {
            this.defaultColor = baseColor;
        }
    }

    public void setXStep(float f) {
        this.xstep = f;
    }

    public void setYStep(float f) {
        this.ystep = f;
    }

    public float getXStep() {
        return this.xstep;
    }

    public float getYStep() {
        return this.ystep;
    }

    public boolean isStencil() {
        return this.stencil;
    }

    public void setPatternMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        setMatrix(f, f2, f3, f4, f5, f6);
    }

    public PdfPattern getPattern() {
        return new PdfPattern(this);
    }

    public PdfPattern getPattern(int i) {
        return new PdfPattern(this, i);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfTemplate
    public PdfContentByte getDuplicate() {
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter();
        pdfPatternPainter.writer = this.writer;
        pdfPatternPainter.pdf = this.pdf;
        pdfPatternPainter.thisReference = this.thisReference;
        pdfPatternPainter.pageResources = this.pageResources;
        pdfPatternPainter.bBox = new Rectangle(this.bBox);
        pdfPatternPainter.xstep = this.xstep;
        pdfPatternPainter.ystep = this.ystep;
        pdfPatternPainter.matrix = this.matrix;
        pdfPatternPainter.stencil = this.stencil;
        pdfPatternPainter.defaultColor = this.defaultColor;
        return pdfPatternPainter;
    }

    public BaseColor getDefaultColor() {
        return this.defaultColor;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setGrayFill(float f) {
        checkNoColor();
        super.setGrayFill(f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void resetGrayFill() {
        checkNoColor();
        super.resetGrayFill();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setGrayStroke(float f) {
        checkNoColor();
        super.setGrayStroke(f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void resetGrayStroke() {
        checkNoColor();
        super.resetGrayStroke();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setRGBColorFillF(float f, float f2, float f3) {
        checkNoColor();
        super.setRGBColorFillF(f, f2, f3);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void resetRGBColorFill() {
        checkNoColor();
        super.resetRGBColorFill();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setRGBColorStrokeF(float f, float f2, float f3) {
        checkNoColor();
        super.setRGBColorStrokeF(f, f2, f3);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void resetRGBColorStroke() {
        checkNoColor();
        super.resetRGBColorStroke();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setCMYKColorFillF(float f, float f2, float f3, float f4) {
        checkNoColor();
        super.setCMYKColorFillF(f, f2, f3, f4);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void resetCMYKColorFill() {
        checkNoColor();
        super.resetCMYKColorFill();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setCMYKColorStrokeF(float f, float f2, float f3, float f4) {
        checkNoColor();
        super.setCMYKColorStrokeF(f, f2, f3, f4);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void resetCMYKColorStroke() {
        checkNoColor();
        super.resetCMYKColorStroke();
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        if (this.stencil && !image.isMask()) {
            checkNoColor();
        }
        super.addImage(image, f, f2, f3, f4, f5, f6);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setCMYKColorFill(int i, int i2, int i3, int i4) {
        checkNoColor();
        super.setCMYKColorFill(i, i2, i3, i4);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setCMYKColorStroke(int i, int i2, int i3, int i4) {
        checkNoColor();
        super.setCMYKColorStroke(i, i2, i3, i4);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setRGBColorFill(int i, int i2, int i3) {
        checkNoColor();
        super.setRGBColorFill(i, i2, i3);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setRGBColorStroke(int i, int i2, int i3) {
        checkNoColor();
        super.setRGBColorStroke(i, i2, i3);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setColorStroke(BaseColor baseColor) {
        checkNoColor();
        super.setColorStroke(baseColor);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setColorFill(BaseColor baseColor) {
        checkNoColor();
        super.setColorFill(baseColor);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        checkNoColor();
        super.setColorFill(pdfSpotColor, f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        checkNoColor();
        super.setColorStroke(pdfSpotColor, f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setPatternFill(PdfPatternPainter pdfPatternPainter) {
        checkNoColor();
        super.setPatternFill(pdfPatternPainter);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setPatternFill(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkNoColor();
        super.setPatternFill(pdfPatternPainter, baseColor, f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f) {
        checkNoColor();
        super.setPatternStroke(pdfPatternPainter, baseColor, f);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setPatternStroke(PdfPatternPainter pdfPatternPainter) {
        checkNoColor();
        super.setPatternStroke(pdfPatternPainter);
    }

    /* access modifiers changed from: package-private */
    public void checkNoColor() {
        if (this.stencil) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("colors.are.not.allowed.in.uncolored.tile.patterns", new Object[0]));
        }
    }
}
