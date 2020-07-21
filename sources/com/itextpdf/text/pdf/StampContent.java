package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.PdfStamperImp;

public class StampContent extends PdfContentByte {
    PageResources pageResources;
    PdfStamperImp.PageStamp ps;

    StampContent(PdfStamperImp pdfStamperImp, PdfStamperImp.PageStamp pageStamp) {
        super(pdfStamperImp);
        this.ps = pageStamp;
        this.pageResources = pageStamp.pageResources;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        ((PdfStamperImp) this.writer).addAnnotation(this.writer.createAnnotation(f, f2, f3, f4, pdfAction, null), this.ps.pageN);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        return new StampContent((PdfStamperImp) this.writer, this.ps);
    }

    /* access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PageResources getPageResources() {
        return this.pageResources;
    }

    /* access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        ((PdfStamperImp) this.writer).addAnnotation(pdfAnnotation, this.ps.pageN);
    }
}
