package com.itextpdf.text.pdf.parser;

public class GlyphTextRenderListener extends GlyphRenderListener implements TextExtractionStrategy {
    private final TextExtractionStrategy delegate;

    public GlyphTextRenderListener(TextExtractionStrategy textExtractionStrategy) {
        super(textExtractionStrategy);
        this.delegate = textExtractionStrategy;
    }

    @Override // com.itextpdf.text.pdf.parser.TextExtractionStrategy
    public String getResultantText() {
        return this.delegate.getResultantText();
    }
}
