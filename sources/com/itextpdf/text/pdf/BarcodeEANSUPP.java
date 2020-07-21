package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;

public class BarcodeEANSUPP extends Barcode {
    protected Barcode ean;
    protected Barcode supp;

    public BarcodeEANSUPP(Barcode barcode, Barcode barcode2) {
        this.n = 8.0f;
        this.ean = barcode;
        this.supp = barcode2;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle getBarcodeSize() {
        Rectangle barcodeSize = this.ean.getBarcodeSize();
        barcodeSize.setRight(barcodeSize.getWidth() + this.supp.getBarcodeSize().getWidth() + this.n);
        return barcodeSize;
    }

    @Override // com.itextpdf.text.pdf.Barcode
    public Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        if (this.supp.getFont() != null) {
            this.supp.setBarHeight((this.ean.getBarHeight() + this.supp.getBaseline()) - this.supp.getFont().getFontDescriptor(2, this.supp.getSize()));
        } else {
            this.supp.setBarHeight(this.ean.getBarHeight());
        }
        Rectangle barcodeSize = this.ean.getBarcodeSize();
        pdfContentByte.saveState();
        this.ean.placeBarcode(pdfContentByte, baseColor, baseColor2);
        pdfContentByte.restoreState();
        pdfContentByte.saveState();
        pdfContentByte.concatCTM(1.0f, 0.0f, 0.0f, 1.0f, barcodeSize.getWidth() + this.n, barcodeSize.getHeight() - this.ean.getBarHeight());
        this.supp.placeBarcode(pdfContentByte, baseColor, baseColor2);
        pdfContentByte.restoreState();
        return getBarcodeSize();
    }
}
