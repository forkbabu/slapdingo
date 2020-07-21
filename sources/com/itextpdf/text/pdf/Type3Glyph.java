package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;

public final class Type3Glyph extends PdfContentByte {
    private boolean colorized;
    private PageResources pageResources;

    private Type3Glyph() {
        super(null);
    }

    Type3Glyph(PdfWriter pdfWriter, PageResources pageResources2, float f, float f2, float f3, float f4, float f5, boolean z) {
        super(pdfWriter);
        this.pageResources = pageResources2;
        this.colorized = z;
        if (z) {
            this.content.append(f).append(" 0 d0\n");
        } else {
            this.content.append(f).append(" 0 ").append(f2).append(' ').append(f3).append(' ').append(f4).append(' ').append(f5).append(" d1\n");
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PageResources getPageResources() {
        return this.pageResources;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6, boolean z) throws DocumentException {
        if (this.colorized || (image.isMask() && (image.getBpc() == 1 || image.getBpc() > 255))) {
            super.addImage(image, f, f2, f3, f4, f5, f6, z);
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("not.colorized.typed3.fonts.only.accept.mask.images", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        Type3Glyph type3Glyph = new Type3Glyph();
        type3Glyph.writer = this.writer;
        type3Glyph.pdf = this.pdf;
        type3Glyph.pageResources = this.pageResources;
        type3Glyph.colorized = this.colorized;
        return type3Glyph;
    }
}
