package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Paragraph extends Phrase implements Indentable, Spaceable, IAccessibleElement {
    private static final long serialVersionUID = 7852314969733375514L;
    protected HashMap<PdfName, PdfObject> accessibleAttributes = null;
    protected int alignment = -1;
    private float extraParagraphSpace = 0.0f;
    private float firstLineIndent = 0.0f;

    /* renamed from: id  reason: collision with root package name */
    protected AccessibleElementId f44id = null;
    protected float indentationLeft;
    protected float indentationRight;
    protected boolean keeptogether = false;
    protected float paddingTop;
    protected PdfName role = PdfName.P;
    protected float spacingAfter;
    protected float spacingBefore;

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Phrase
    public int type() {
        return 12;
    }

    public Paragraph() {
    }

    public Paragraph(float f) {
        super(f);
    }

    public Paragraph(Chunk chunk) {
        super(chunk);
    }

    public Paragraph(float f, Chunk chunk) {
        super(f, chunk);
    }

    public Paragraph(String str) {
        super(str);
    }

    public Paragraph(String str, Font font) {
        super(str, font);
    }

    public Paragraph(float f, String str) {
        super(f, str);
    }

    public Paragraph(float f, String str, Font font) {
        super(f, str, font);
    }

    public Paragraph(Phrase phrase) {
        super(phrase);
        if (phrase instanceof Paragraph) {
            Paragraph paragraph = (Paragraph) phrase;
            setAlignment(paragraph.alignment);
            setIndentationLeft(paragraph.getIndentationLeft());
            setIndentationRight(paragraph.getIndentationRight());
            setFirstLineIndent(paragraph.getFirstLineIndent());
            setSpacingAfter(paragraph.getSpacingAfter());
            setSpacingBefore(paragraph.getSpacingBefore());
            setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
            setRole(paragraph.role);
            this.f44id = paragraph.getId();
            if (paragraph.accessibleAttributes != null) {
                this.accessibleAttributes = new HashMap<>(paragraph.accessibleAttributes);
            }
        }
    }

    public Paragraph cloneShallow(boolean z) {
        Paragraph paragraph = new Paragraph();
        populateProperties(paragraph, z);
        return paragraph;
    }

    /* access modifiers changed from: protected */
    public void populateProperties(Paragraph paragraph, boolean z) {
        paragraph.setFont(getFont());
        paragraph.setAlignment(getAlignment());
        paragraph.setLeading(getLeading(), this.multipliedLeading);
        paragraph.setIndentationLeft(getIndentationLeft());
        paragraph.setIndentationRight(getIndentationRight());
        paragraph.setFirstLineIndent(getFirstLineIndent());
        paragraph.setSpacingAfter(getSpacingAfter());
        if (z) {
            paragraph.setSpacingBefore(getSpacingBefore());
        }
        paragraph.setExtraParagraphSpace(getExtraParagraphSpace());
        paragraph.setRole(this.role);
        paragraph.f44id = getId();
        if (this.accessibleAttributes != null) {
            paragraph.accessibleAttributes = new HashMap<>(this.accessibleAttributes);
        }
        paragraph.setTabSettings(getTabSettings());
        paragraph.setKeepTogether(getKeepTogether());
    }

    public List<Element> breakUp() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = iterator();
        Paragraph paragraph = null;
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Element element = (Element) it2.next();
            if (element.type() == 14 || element.type() == 23 || element.type() == 12) {
                if (paragraph != null && paragraph.size() > 0) {
                    paragraph.setSpacingAfter(0.0f);
                    arrayList.add(paragraph);
                    paragraph = cloneShallow(false);
                }
                if (arrayList.size() == 0) {
                    int type = element.type();
                    if (type == 12) {
                        ((Paragraph) element).setSpacingBefore(getSpacingBefore());
                    } else if (type == 14) {
                        ListItem firstItem = ((List) element).getFirstItem();
                        if (firstItem != null) {
                            firstItem.setSpacingBefore(getSpacingBefore());
                        }
                    } else if (type == 23) {
                        ((PdfPTable) element).setSpacingBefore(getSpacingBefore());
                    }
                }
                arrayList.add(element);
            } else {
                if (paragraph == null) {
                    if (arrayList.size() != 0) {
                        z = false;
                    }
                    paragraph = cloneShallow(z);
                }
                paragraph.add(element);
            }
        }
        if (paragraph != null && paragraph.size() > 0) {
            arrayList.add(paragraph);
        }
        if (arrayList.size() != 0) {
            Element element2 = (Element) arrayList.get(arrayList.size() - 1);
            int type2 = element2.type();
            if (type2 == 12) {
                ((Paragraph) element2).setSpacingAfter(getSpacingAfter());
            } else if (type2 == 14) {
                ListItem lastItem = ((List) element2).getLastItem();
                if (lastItem != null) {
                    lastItem.setSpacingAfter(getSpacingAfter());
                }
            } else if (type2 == 23) {
                ((PdfPTable) element2).setSpacingAfter(getSpacingAfter());
            }
        }
        return arrayList;
    }

    @Override // com.itextpdf.text.TextElementArray, com.itextpdf.text.Phrase
    public boolean add(Element element) {
        if (element instanceof List) {
            List list = (List) element;
            list.setIndentationLeft(list.getIndentationLeft() + this.indentationLeft);
            list.setIndentationRight(this.indentationRight);
            return super.add((Element) list);
        } else if (element instanceof Image) {
            super.addSpecial(element);
            return true;
        } else if (!(element instanceof Paragraph)) {
            return super.add(element);
        } else {
            super.addSpecial(element);
            return true;
        }
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setFirstLineIndent(float f) {
        this.firstLineIndent = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public void setKeepTogether(boolean z) {
        this.keeptogether = z;
    }

    public boolean getKeepTogether() {
        return this.keeptogether;
    }

    public int getAlignment() {
        return this.alignment;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return this.indentationRight;
    }

    public float getFirstLineIndent() {
        return this.firstLineIndent;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    @Deprecated
    public float spacingBefore() {
        return getSpacingBefore();
    }

    @Deprecated
    public float spacingAfter() {
        return this.spacingAfter;
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
        if (this.f44id == null) {
            this.f44id = new AccessibleElementId();
        }
        return this.f44id;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.f44id = accessibleElementId;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getPaddingTop() {
        return this.paddingTop;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }
}
