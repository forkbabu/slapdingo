package com.itextpdf.text.pdf;

import java.util.HashMap;
import java.util.HashSet;

class PageResources {
    protected PdfDictionary colorDictionary = new PdfDictionary();
    protected PdfDictionary extGStateDictionary = new PdfDictionary();
    protected PdfDictionary fontDictionary = new PdfDictionary();
    protected HashSet<PdfName> forbiddenNames;
    protected int[] namePtr = {0};
    protected PdfDictionary originalResources;
    protected PdfDictionary patternDictionary = new PdfDictionary();
    protected PdfDictionary propertyDictionary = new PdfDictionary();
    protected PdfDictionary shadingDictionary = new PdfDictionary();
    protected HashMap<PdfName, PdfName> usedNames;
    protected PdfDictionary xObjectDictionary = new PdfDictionary();

    PageResources() {
    }

    /* access modifiers changed from: package-private */
    public void setOriginalResources(PdfDictionary pdfDictionary, int[] iArr) {
        if (iArr != null) {
            this.namePtr = iArr;
        }
        this.forbiddenNames = new HashSet<>();
        this.usedNames = new HashMap<>();
        if (pdfDictionary != null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            this.originalResources = pdfDictionary2;
            pdfDictionary2.merge(pdfDictionary);
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName));
                if (pdfObject != null && pdfObject.isDictionary()) {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) pdfObject;
                    for (PdfName pdfName2 : pdfDictionary3.getKeys()) {
                        this.forbiddenNames.add(pdfName2);
                    }
                    PdfDictionary pdfDictionary4 = new PdfDictionary();
                    pdfDictionary4.merge(pdfDictionary3);
                    this.originalResources.put(pdfName, pdfDictionary4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PdfName translateName(PdfName pdfName) {
        if (this.forbiddenNames == null) {
            return pdfName;
        }
        PdfName pdfName2 = this.usedNames.get(pdfName);
        if (pdfName2 == null) {
            do {
                StringBuilder sb = new StringBuilder();
                sb.append("Xi");
                int[] iArr = this.namePtr;
                int i = iArr[0];
                iArr[0] = i + 1;
                sb.append(i);
                pdfName2 = new PdfName(sb.toString());
            } while (this.forbiddenNames.contains(pdfName2));
            this.usedNames.put(pdfName, pdfName2);
        }
        return pdfName2;
    }

    /* access modifiers changed from: package-private */
    public PdfName addFont(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName translateName = translateName(pdfName);
        this.fontDictionary.put(translateName, pdfIndirectReference);
        return translateName;
    }

    /* access modifiers changed from: package-private */
    public PdfName addXObject(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName translateName = translateName(pdfName);
        this.xObjectDictionary.put(translateName, pdfIndirectReference);
        return translateName;
    }

    /* access modifiers changed from: package-private */
    public PdfName addColor(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName translateName = translateName(pdfName);
        this.colorDictionary.put(translateName, pdfIndirectReference);
        return translateName;
    }

    /* access modifiers changed from: package-private */
    public void addDefaultColor(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            this.colorDictionary.remove(pdfName);
        } else {
            this.colorDictionary.put(pdfName, pdfObject);
        }
    }

    /* access modifiers changed from: package-private */
    public void addDefaultColor(PdfDictionary pdfDictionary) {
        this.colorDictionary.merge(pdfDictionary);
    }

    /* access modifiers changed from: package-private */
    public void addDefaultColorDiff(PdfDictionary pdfDictionary) {
        this.colorDictionary.mergeDifferent(pdfDictionary);
    }

    /* access modifiers changed from: package-private */
    public PdfName addShading(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName translateName = translateName(pdfName);
        this.shadingDictionary.put(translateName, pdfIndirectReference);
        return translateName;
    }

    /* access modifiers changed from: package-private */
    public PdfName addPattern(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName translateName = translateName(pdfName);
        this.patternDictionary.put(translateName, pdfIndirectReference);
        return translateName;
    }

    /* access modifiers changed from: package-private */
    public PdfName addExtGState(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName translateName = translateName(pdfName);
        this.extGStateDictionary.put(translateName, pdfIndirectReference);
        return translateName;
    }

    /* access modifiers changed from: package-private */
    public PdfName addProperty(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName translateName = translateName(pdfName);
        this.propertyDictionary.put(translateName, pdfIndirectReference);
        return translateName;
    }

    /* access modifiers changed from: package-private */
    public PdfDictionary getResources() {
        PdfResources pdfResources = new PdfResources();
        PdfDictionary pdfDictionary = this.originalResources;
        if (pdfDictionary != null) {
            pdfResources.putAll(pdfDictionary);
        }
        pdfResources.add(PdfName.FONT, this.fontDictionary);
        pdfResources.add(PdfName.XOBJECT, this.xObjectDictionary);
        pdfResources.add(PdfName.COLORSPACE, this.colorDictionary);
        pdfResources.add(PdfName.PATTERN, this.patternDictionary);
        pdfResources.add(PdfName.SHADING, this.shadingDictionary);
        pdfResources.add(PdfName.EXTGSTATE, this.extGStateDictionary);
        pdfResources.add(PdfName.PROPERTIES, this.propertyDictionary);
        return pdfResources;
    }

    /* access modifiers changed from: package-private */
    public boolean hasResources() {
        return this.fontDictionary.size() > 0 || this.xObjectDictionary.size() > 0 || this.colorDictionary.size() > 0 || this.patternDictionary.size() > 0 || this.shadingDictionary.size() > 0 || this.extGStateDictionary.size() > 0 || this.propertyDictionary.size() > 0;
    }
}
