package com.itextpdf.text.pdf.parser;

public class GlyphRenderListener implements RenderListener {
    private final RenderListener delegate;

    public GlyphRenderListener(RenderListener renderListener) {
        this.delegate = renderListener;
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
        this.delegate.beginTextBlock();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        for (TextRenderInfo textRenderInfo2 : textRenderInfo.getCharacterRenderInfos()) {
            this.delegate.renderText(textRenderInfo2);
        }
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
        this.delegate.endTextBlock();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
        this.delegate.renderImage(imageRenderInfo);
    }
}
