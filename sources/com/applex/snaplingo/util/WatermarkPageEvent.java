package com.applex.snaplingo.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

class WatermarkPageEvent extends PdfPageEventHelper {
    private Phrase mPhrase;
    private Watermark mWatermark;

    WatermarkPageEvent() {
    }

    @Override // com.itextpdf.text.pdf.PdfPageEventHelper, com.itextpdf.text.pdf.PdfPageEvent
    public void onEndPage(PdfWriter pdfWriter, Document document) {
        ColumnText.showTextAligned(pdfWriter.getDirectContent(), 1, this.mPhrase, (document.getPageSize().getLeft() + document.getPageSize().getRight()) / 1.2f, (document.getPageSize().getTop() + document.getPageSize().getBottom()) / 50.0f, (float) this.mWatermark.getRotationAngle());
    }

    public Watermark getWatermark() {
        return this.mWatermark;
    }

    public void setWatermark(Watermark watermark) {
        this.mWatermark = watermark;
        this.mPhrase = new Phrase(this.mWatermark.getWatermarkText(), new Font(Font.FontFamily.HELVETICA, 15.0f, 0, new GrayColor(0.0f)));
    }
}
