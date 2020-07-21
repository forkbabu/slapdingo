package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfString;

public class PdfCollection extends PdfDictionary {
    public static final int CUSTOM = 3;
    public static final int DETAILS = 0;
    public static final int HIDDEN = 2;
    public static final int TILE = 1;

    public PdfCollection(int i) {
        super(PdfName.COLLECTION);
        if (i == 1) {
            put(PdfName.VIEW, PdfName.T);
        } else if (i == 2) {
            put(PdfName.VIEW, PdfName.H);
        } else if (i != 3) {
            put(PdfName.VIEW, PdfName.D);
        } else {
            put(PdfName.VIEW, PdfName.C);
        }
    }

    public void setInitialDocument(String str) {
        put(PdfName.D, new PdfString(str, null));
    }

    public void setSchema(PdfCollectionSchema pdfCollectionSchema) {
        put(PdfName.SCHEMA, pdfCollectionSchema);
    }

    public PdfCollectionSchema getSchema() {
        return (PdfCollectionSchema) get(PdfName.SCHEMA);
    }

    public void setSort(PdfCollectionSort pdfCollectionSort) {
        put(PdfName.SORT, pdfCollectionSort);
    }
}
