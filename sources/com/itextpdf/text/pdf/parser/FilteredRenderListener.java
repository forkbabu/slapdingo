package com.itextpdf.text.pdf.parser;

public class FilteredRenderListener implements RenderListener {
    private final RenderListener delegate;
    private final RenderFilter[] filters;

    public FilteredRenderListener(RenderListener renderListener, RenderFilter... renderFilterArr) {
        this.delegate = renderListener;
        this.filters = renderFilterArr;
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        RenderFilter[] renderFilterArr = this.filters;
        int length = renderFilterArr.length;
        int i = 0;
        while (i < length) {
            if (renderFilterArr[i].allowText(textRenderInfo)) {
                i++;
            } else {
                return;
            }
        }
        this.delegate.renderText(textRenderInfo);
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
        this.delegate.beginTextBlock();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
        this.delegate.endTextBlock();
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
        RenderFilter[] renderFilterArr = this.filters;
        int length = renderFilterArr.length;
        int i = 0;
        while (i < length) {
            if (renderFilterArr[i].allowImage(imageRenderInfo)) {
                i++;
            } else {
                return;
            }
        }
        this.delegate.renderImage(imageRenderInfo);
    }
}
