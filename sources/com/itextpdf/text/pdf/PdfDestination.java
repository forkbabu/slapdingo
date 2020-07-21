package com.itextpdf.text.pdf;

import java.util.StringTokenizer;

public class PdfDestination extends PdfArray {
    public static final int FIT = 1;
    public static final int FITB = 5;
    public static final int FITBH = 6;
    public static final int FITBV = 7;
    public static final int FITH = 2;
    public static final int FITR = 4;
    public static final int FITV = 3;
    public static final int XYZ = 0;
    private boolean status = false;

    public PdfDestination(PdfDestination pdfDestination) {
        super((PdfArray) pdfDestination);
        this.status = pdfDestination.status;
    }

    public PdfDestination(int i) {
        if (i == 5) {
            add(PdfName.FITB);
        } else {
            add(PdfName.FIT);
        }
    }

    public PdfDestination(int i, float f) {
        super(new PdfNumber(f));
        if (i == 3) {
            addFirst(PdfName.FITV);
        } else if (i == 6) {
            addFirst(PdfName.FITBH);
        } else if (i != 7) {
            addFirst(PdfName.FITH);
        } else {
            addFirst(PdfName.FITBV);
        }
    }

    public PdfDestination(int i, float f, float f2, float f3) {
        super(PdfName.XYZ);
        if (f < 0.0f) {
            add(PdfNull.PDFNULL);
        } else {
            add(new PdfNumber(f));
        }
        if (f2 < 0.0f) {
            add(PdfNull.PDFNULL);
        } else {
            add(new PdfNumber(f2));
        }
        add(new PdfNumber(f3));
    }

    public PdfDestination(int i, float f, float f2, float f3, float f4) {
        super(PdfName.FITR);
        add(new PdfNumber(f));
        add(new PdfNumber(f2));
        add(new PdfNumber(f3));
        add(new PdfNumber(f4));
    }

    public PdfDestination(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        if (stringTokenizer.hasMoreTokens()) {
            add(new PdfName(stringTokenizer.nextToken()));
        }
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if ("null".equals(nextToken)) {
                add(new PdfNull());
            } else {
                try {
                    add(new PdfNumber(nextToken));
                } catch (RuntimeException unused) {
                    add(new PdfNull());
                }
            }
        }
    }

    public boolean hasPage() {
        return this.status;
    }

    public boolean addPage(PdfIndirectReference pdfIndirectReference) {
        if (this.status) {
            return false;
        }
        addFirst(pdfIndirectReference);
        this.status = true;
        return true;
    }
}
