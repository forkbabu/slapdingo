package com.itextpdf.text.pdf;

import java.io.IOException;

public class PdfPSXObject extends PdfTemplate {
    protected PdfPSXObject() {
    }

    public PdfPSXObject(PdfWriter pdfWriter) {
        super(pdfWriter);
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate
    public PdfStream getFormXObject(int i) throws IOException {
        PdfStream pdfStream = new PdfStream(this.content.toByteArray());
        pdfStream.put(PdfName.TYPE, PdfName.XOBJECT);
        pdfStream.put(PdfName.SUBTYPE, PdfName.PS);
        pdfStream.flateCompress(i);
        return pdfStream;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfTemplate
    public PdfContentByte getDuplicate() {
        PdfPSXObject pdfPSXObject = new PdfPSXObject();
        pdfPSXObject.writer = this.writer;
        pdfPSXObject.pdf = this.pdf;
        pdfPSXObject.thisReference = this.thisReference;
        pdfPSXObject.pageResources = this.pageResources;
        pdfPSXObject.separator = this.separator;
        return pdfPSXObject;
    }
}
