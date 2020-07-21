package com.itextpdf.text.pdf.events;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfPageEventForwarder implements PdfPageEvent {
    protected ArrayList<PdfPageEvent> events = new ArrayList<>();

    public void addPageEvent(PdfPageEvent pdfPageEvent) {
        this.events.add(pdfPageEvent);
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onOpenDocument(PdfWriter pdfWriter, Document document) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onOpenDocument(pdfWriter, document);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onStartPage(PdfWriter pdfWriter, Document document) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onStartPage(pdfWriter, document);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onEndPage(PdfWriter pdfWriter, Document document) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onEndPage(pdfWriter, document);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onCloseDocument(PdfWriter pdfWriter, Document document) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onCloseDocument(pdfWriter, document);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onParagraph(PdfWriter pdfWriter, Document document, float f) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onParagraph(pdfWriter, document, f);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onParagraphEnd(PdfWriter pdfWriter, Document document, float f) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onParagraphEnd(pdfWriter, document, f);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onChapter(PdfWriter pdfWriter, Document document, float f, Paragraph paragraph) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onChapter(pdfWriter, document, f, paragraph);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onChapterEnd(PdfWriter pdfWriter, Document document, float f) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onChapterEnd(pdfWriter, document, f);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onSection(PdfWriter pdfWriter, Document document, float f, int i, Paragraph paragraph) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onSection(pdfWriter, document, f, i, paragraph);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onSectionEnd(PdfWriter pdfWriter, Document document, float f) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onSectionEnd(pdfWriter, document, f);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPageEvent
    public void onGenericTag(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        Iterator<PdfPageEvent> it2 = this.events.iterator();
        while (it2.hasNext()) {
            it2.next().onGenericTag(pdfWriter, document, rectangle, str);
        }
    }
}
