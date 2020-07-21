package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfName;

public class ListLabel extends ListBody {
    protected float indentation = 0.0f;
    protected PdfName role = PdfName.LBL;

    @Deprecated
    public boolean getTagLabelContent() {
        return false;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement, com.itextpdf.text.ListBody
    public boolean isInline() {
        return true;
    }

    @Deprecated
    public void setTagLabelContent(boolean z) {
    }

    protected ListLabel(ListItem listItem) {
        super(listItem);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement, com.itextpdf.text.ListBody
    public PdfName getRole() {
        return this.role;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement, com.itextpdf.text.ListBody
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    public float getIndentation() {
        return this.indentation;
    }

    public void setIndentation(float f) {
        this.indentation = f;
    }
}
