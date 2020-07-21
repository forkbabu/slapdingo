package com.itextpdf.text.pdf;

import java.util.List;

public class NumberArray extends PdfArray {
    public NumberArray(float... fArr) {
        for (float f : fArr) {
            add(new PdfNumber(f));
        }
    }

    public NumberArray(List<PdfNumber> list) {
        for (PdfNumber pdfNumber : list) {
            add(pdfNumber);
        }
    }
}
