package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;

public class ListBody implements IAccessibleElement {
    protected HashMap<PdfName, PdfObject> accessibleAttributes = null;

    /* renamed from: id  reason: collision with root package name */
    private AccessibleElementId f43id = null;
    protected ListItem parentItem = null;
    protected PdfName role = PdfName.LBODY;

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    protected ListBody(ListItem listItem) {
        this.parentItem = listItem;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfObject getAccessibleAttribute(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.accessibleAttributes;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public HashMap<PdfName, PdfObject> getAccessibleAttributes() {
        return this.accessibleAttributes;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        if (this.f43id == null) {
            this.f43id = new AccessibleElementId();
        }
        return this.f43id;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.f43id = accessibleElementId;
    }
}
