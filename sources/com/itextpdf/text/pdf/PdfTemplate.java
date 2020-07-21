package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.io.IOException;
import java.util.HashMap;

public class PdfTemplate extends PdfContentByte implements IAccessibleElement {
    public static final int TYPE_IMPORTED = 2;
    public static final int TYPE_PATTERN = 3;
    public static final int TYPE_TEMPLATE = 1;
    protected HashMap<PdfName, PdfObject> accessibleAttributes = null;
    private PdfDictionary additional = null;
    protected Rectangle bBox = new Rectangle(0.0f, 0.0f);
    protected boolean contentTagged = false;
    protected PdfTransparencyGroup group;

    /* renamed from: id  reason: collision with root package name */
    private AccessibleElementId f52id = null;
    protected PdfOCG layer;
    protected PdfArray matrix;
    protected PdfIndirectReference pageReference;
    protected PageResources pageResources;
    protected PdfName role = PdfName.FIGURE;
    protected PdfIndirectReference thisReference;
    protected int type = 1;

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return true;
    }

    protected PdfTemplate() {
        super(null);
    }

    PdfTemplate(PdfWriter pdfWriter) {
        super(pdfWriter);
        PageResources pageResources2 = new PageResources();
        this.pageResources = pageResources2;
        pageResources2.addDefaultColor(pdfWriter.getDefaultColorspace());
        this.thisReference = this.writer.getPdfIndirectReference();
    }

    public static PdfTemplate createTemplate(PdfWriter pdfWriter, float f, float f2) {
        return createTemplate(pdfWriter, f, f2, null);
    }

    static PdfTemplate createTemplate(PdfWriter pdfWriter, float f, float f2, PdfName pdfName) {
        PdfTemplate pdfTemplate = new PdfTemplate(pdfWriter);
        pdfTemplate.setWidth(f);
        pdfTemplate.setHeight(f2);
        pdfWriter.addDirectTemplateSimple(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public boolean isTagged() {
        return super.isTagged() && this.contentTagged;
    }

    public void setWidth(float f) {
        this.bBox.setLeft(0.0f);
        this.bBox.setRight(f);
    }

    public void setHeight(float f) {
        this.bBox.setBottom(0.0f);
        this.bBox.setTop(f);
    }

    public float getWidth() {
        return this.bBox.getWidth();
    }

    public float getHeight() {
        return this.bBox.getHeight();
    }

    public Rectangle getBoundingBox() {
        return this.bBox;
    }

    public void setBoundingBox(Rectangle rectangle) {
        this.bBox = rectangle;
    }

    public void setLayer(PdfOCG pdfOCG) {
        this.layer = pdfOCG;
    }

    public PdfOCG getLayer() {
        return this.layer;
    }

    public void setMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        PdfArray pdfArray = new PdfArray();
        this.matrix = pdfArray;
        pdfArray.add(new PdfNumber(f));
        this.matrix.add(new PdfNumber(f2));
        this.matrix.add(new PdfNumber(f3));
        this.matrix.add(new PdfNumber(f4));
        this.matrix.add(new PdfNumber(f5));
        this.matrix.add(new PdfNumber(f6));
    }

    /* access modifiers changed from: package-private */
    public PdfArray getMatrix() {
        return this.matrix;
    }

    public PdfIndirectReference getIndirectReference() {
        if (this.thisReference == null) {
            this.thisReference = this.writer.getPdfIndirectReference();
        }
        return this.thisReference;
    }

    public void beginVariableText() {
        this.content.append("/Tx BMC ");
    }

    public void endVariableText() {
        this.content.append("EMC ");
    }

    /* access modifiers changed from: package-private */
    public PdfObject getResources() {
        return getPageResources().getResources();
    }

    public PdfStream getFormXObject(int i) throws IOException {
        return new PdfFormXObject(this, i);
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        PdfTemplate pdfTemplate = new PdfTemplate();
        pdfTemplate.writer = this.writer;
        pdfTemplate.pdf = this.pdf;
        pdfTemplate.thisReference = this.thisReference;
        pdfTemplate.pageResources = this.pageResources;
        pdfTemplate.bBox = new Rectangle(this.bBox);
        pdfTemplate.group = this.group;
        pdfTemplate.layer = this.layer;
        PdfArray pdfArray = this.matrix;
        if (pdfArray != null) {
            pdfTemplate.matrix = new PdfArray(pdfArray);
        }
        pdfTemplate.separator = this.separator;
        pdfTemplate.additional = this.additional;
        pdfTemplate.contentTagged = this.contentTagged;
        pdfTemplate.duplicatedFrom = this;
        return pdfTemplate;
    }

    public int getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PageResources getPageResources() {
        return this.pageResources;
    }

    public PdfTransparencyGroup getGroup() {
        return this.group;
    }

    public void setGroup(PdfTransparencyGroup pdfTransparencyGroup) {
        this.group = pdfTransparencyGroup;
    }

    public PdfDictionary getAdditional() {
        return this.additional;
    }

    public void setAdditional(PdfDictionary pdfDictionary) {
        this.additional = pdfDictionary;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PdfIndirectReference getCurrentPage() {
        PdfIndirectReference pdfIndirectReference = this.pageReference;
        return pdfIndirectReference == null ? this.writer.getCurrentPage() : pdfIndirectReference;
    }

    public PdfIndirectReference getPageReference() {
        return this.pageReference;
    }

    public void setPageReference(PdfIndirectReference pdfIndirectReference) {
        this.pageReference = pdfIndirectReference;
    }

    public boolean isContentTagged() {
        return this.contentTagged;
    }

    public void setContentTagged(boolean z) {
        this.contentTagged = z;
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
        if (this.f52id == null) {
            this.f52id = new AccessibleElementId();
        }
        return this.f52id;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.f52id = accessibleElementId;
    }
}
