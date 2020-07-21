package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Rectangle2D;

public class TextMarginFinder implements RenderListener {
    private Rectangle2D.Float textRectangle = null;

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        Rectangle2D.Float floatR = this.textRectangle;
        if (floatR == null) {
            this.textRectangle = textRenderInfo.getDescentLine().getBoundingRectange();
        } else {
            floatR.add(textRenderInfo.getDescentLine().getBoundingRectange());
        }
        this.textRectangle.add(textRenderInfo.getAscentLine().getBoundingRectange());
    }

    public float getLlx() {
        return this.textRectangle.x;
    }

    public float getLly() {
        return this.textRectangle.y;
    }

    public float getUrx() {
        return this.textRectangle.x + this.textRectangle.width;
    }

    public float getUry() {
        return this.textRectangle.y + this.textRectangle.height;
    }

    public float getWidth() {
        return this.textRectangle.width;
    }

    public float getHeight() {
        return this.textRectangle.height;
    }
}
