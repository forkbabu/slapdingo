package com.itextpdf.text.pdf;

import com.itextpdf.text.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfFormField extends PdfAnnotation {
    public static final int FF_COMB = 16777216;
    public static final int FF_COMBO = 131072;
    public static final int FF_DONOTSCROLL = 8388608;
    public static final int FF_DONOTSPELLCHECK = 4194304;
    public static final int FF_EDIT = 262144;
    public static final int FF_FILESELECT = 1048576;
    public static final int FF_MULTILINE = 4096;
    public static final int FF_MULTISELECT = 2097152;
    public static final int FF_NO_EXPORT = 4;
    public static final int FF_NO_TOGGLE_TO_OFF = 16384;
    public static final int FF_PASSWORD = 8192;
    public static final int FF_PUSHBUTTON = 65536;
    public static final int FF_RADIO = 32768;
    public static final int FF_RADIOSINUNISON = 33554432;
    public static final int FF_READ_ONLY = 1;
    public static final int FF_REQUIRED = 2;
    public static final int FF_RICHTEXT = 33554432;
    public static final PdfName IF_SCALE_ALWAYS = PdfName.A;
    public static final PdfName IF_SCALE_ANAMORPHIC = PdfName.A;
    public static final PdfName IF_SCALE_BIGGER = PdfName.B;
    public static final PdfName IF_SCALE_NEVER = PdfName.N;
    public static final PdfName IF_SCALE_PROPORTIONAL = PdfName.P;
    public static final PdfName IF_SCALE_SMALLER = PdfName.S;
    public static final int MK_CAPTION_ABOVE = 3;
    public static final int MK_CAPTION_BELOW = 2;
    public static final int MK_CAPTION_LEFT = 5;
    public static final int MK_CAPTION_OVERLAID = 6;
    public static final int MK_CAPTION_RIGHT = 4;
    public static final int MK_NO_CAPTION = 1;
    public static final int MK_NO_ICON = 0;
    public static final boolean MULTILINE = true;
    public static final boolean PASSWORD = true;
    public static final boolean PLAINTEXT = false;
    public static final int Q_CENTER = 1;
    public static final int Q_LEFT = 0;
    public static final int Q_RIGHT = 2;
    public static final boolean SINGLELINE = false;
    static PdfName[] mergeTarget = {PdfName.FONT, PdfName.XOBJECT, PdfName.COLORSPACE, PdfName.PATTERN};
    protected ArrayList<PdfFormField> kids;
    protected PdfFormField parent;

    public PdfFormField(PdfWriter pdfWriter, float f, float f2, float f3, float f4, PdfAction pdfAction) {
        super(pdfWriter, f, f2, f3, f4, pdfAction);
        put(PdfName.TYPE, PdfName.ANNOT);
        put(PdfName.SUBTYPE, PdfName.WIDGET);
        this.annotation = true;
    }

    protected PdfFormField(PdfWriter pdfWriter) {
        super(pdfWriter, null);
        this.form = true;
        this.annotation = false;
        this.role = PdfName.FORM;
    }

    public void setWidget(Rectangle rectangle, PdfName pdfName) {
        put(PdfName.TYPE, PdfName.ANNOT);
        put(PdfName.SUBTYPE, PdfName.WIDGET);
        put(PdfName.RECT, new PdfRectangle(rectangle));
        this.annotation = true;
        if (pdfName != null && !pdfName.equals(HIGHLIGHT_INVERT)) {
            put(PdfName.H, pdfName);
        }
    }

    public static PdfFormField createEmpty(PdfWriter pdfWriter) {
        return new PdfFormField(pdfWriter);
    }

    public void setButton(int i) {
        put(PdfName.FT, PdfName.BTN);
        if (i != 0) {
            put(PdfName.FF, new PdfNumber(i));
        }
    }

    protected static PdfFormField createButton(PdfWriter pdfWriter, int i) {
        PdfFormField pdfFormField = new PdfFormField(pdfWriter);
        pdfFormField.setButton(i);
        return pdfFormField;
    }

    public static PdfFormField createPushButton(PdfWriter pdfWriter) {
        return createButton(pdfWriter, 65536);
    }

    public static PdfFormField createCheckBox(PdfWriter pdfWriter) {
        return createButton(pdfWriter, 0);
    }

    public static PdfFormField createRadioButton(PdfWriter pdfWriter, boolean z) {
        return createButton(pdfWriter, (z ? 16384 : 0) + 32768);
    }

    public static PdfFormField createTextField(PdfWriter pdfWriter, boolean z, boolean z2, int i) {
        PdfFormField pdfFormField = new PdfFormField(pdfWriter);
        pdfFormField.put(PdfName.FT, PdfName.TX);
        int i2 = 0;
        int i3 = z ? 4096 : 0;
        if (z2) {
            i2 = 8192;
        }
        pdfFormField.put(PdfName.FF, new PdfNumber(i3 + i2));
        if (i > 0) {
            pdfFormField.put(PdfName.MAXLEN, new PdfNumber(i));
        }
        return pdfFormField;
    }

    protected static PdfFormField createChoice(PdfWriter pdfWriter, int i, PdfArray pdfArray, int i2) {
        PdfFormField pdfFormField = new PdfFormField(pdfWriter);
        pdfFormField.put(PdfName.FT, PdfName.CH);
        pdfFormField.put(PdfName.FF, new PdfNumber(i));
        pdfFormField.put(PdfName.OPT, pdfArray);
        if (i2 > 0) {
            pdfFormField.put(PdfName.TI, new PdfNumber(i2));
        }
        return pdfFormField;
    }

    public static PdfFormField createList(PdfWriter pdfWriter, String[] strArr, int i) {
        return createChoice(pdfWriter, 0, processOptions(strArr), i);
    }

    public static PdfFormField createList(PdfWriter pdfWriter, String[][] strArr, int i) {
        return createChoice(pdfWriter, 0, processOptions(strArr), i);
    }

    public static PdfFormField createCombo(PdfWriter pdfWriter, boolean z, String[] strArr, int i) {
        return createChoice(pdfWriter, (z ? 262144 : 0) + 131072, processOptions(strArr), i);
    }

    public static PdfFormField createCombo(PdfWriter pdfWriter, boolean z, String[][] strArr, int i) {
        return createChoice(pdfWriter, (z ? 262144 : 0) + 131072, processOptions(strArr), i);
    }

    protected static PdfArray processOptions(String[] strArr) {
        PdfArray pdfArray = new PdfArray();
        for (String str : strArr) {
            pdfArray.add(new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        return pdfArray;
    }

    protected static PdfArray processOptions(String[][] strArr) {
        PdfArray pdfArray = new PdfArray();
        for (String[] strArr2 : strArr) {
            PdfArray pdfArray2 = new PdfArray(new PdfString(strArr2[0], PdfObject.TEXT_UNICODE));
            pdfArray2.add(new PdfString(strArr2[1], PdfObject.TEXT_UNICODE));
            pdfArray.add(pdfArray2);
        }
        return pdfArray;
    }

    public static PdfFormField createSignature(PdfWriter pdfWriter) {
        PdfFormField pdfFormField = new PdfFormField(pdfWriter);
        pdfFormField.put(PdfName.FT, PdfName.SIG);
        return pdfFormField;
    }

    public PdfFormField getParent() {
        return this.parent;
    }

    public void addKid(PdfFormField pdfFormField) {
        pdfFormField.parent = this;
        if (this.kids == null) {
            this.kids = new ArrayList<>();
        }
        this.kids.add(pdfFormField);
    }

    public ArrayList<PdfFormField> getKids() {
        return this.kids;
    }

    public int setFieldFlags(int i) {
        int i2;
        PdfNumber pdfNumber = (PdfNumber) get(PdfName.FF);
        if (pdfNumber == null) {
            i2 = 0;
        } else {
            i2 = pdfNumber.intValue();
        }
        put(PdfName.FF, new PdfNumber(i | i2));
        return i2;
    }

    public void setValueAsString(String str) {
        put(PdfName.V, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setValueAsName(String str) {
        put(PdfName.V, new PdfName(str));
    }

    public void setValue(PdfSignature pdfSignature) {
        put(PdfName.V, pdfSignature);
    }

    public void setRichValue(String str) {
        put(PdfName.RV, new PdfString(str));
    }

    public void setDefaultValueAsString(String str) {
        put(PdfName.DV, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setDefaultValueAsName(String str) {
        put(PdfName.DV, new PdfName(str));
    }

    public void setFieldName(String str) {
        if (str != null) {
            put(PdfName.T, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
    }

    public void setUserName(String str) {
        put(PdfName.TU, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setMappingName(String str) {
        put(PdfName.TM, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setQuadding(int i) {
        put(PdfName.Q, new PdfNumber(i));
    }

    static void mergeResources(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfStamperImp pdfStamperImp) {
        int i = 0;
        while (true) {
            PdfName[] pdfNameArr = mergeTarget;
            if (i < pdfNameArr.length) {
                PdfName pdfName = pdfNameArr[i];
                PdfDictionary asDict = pdfDictionary2.getAsDict(pdfName);
                if (asDict != null) {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.getPdfObject(pdfDictionary.get(pdfName), pdfDictionary);
                    if (pdfDictionary3 == null) {
                        pdfDictionary3 = new PdfDictionary();
                    }
                    pdfDictionary3.mergeDifferent(asDict);
                    pdfDictionary.put(pdfName, pdfDictionary3);
                    if (pdfStamperImp != 0) {
                        pdfStamperImp.markUsed(pdfDictionary3);
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    static void mergeResources(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        mergeResources(pdfDictionary, pdfDictionary2, null);
    }

    @Override // com.itextpdf.text.pdf.PdfAnnotation
    public void setUsed() {
        this.used = true;
        if (this.parent != null) {
            put(PdfName.PARENT, this.parent.getIndirectReference());
        }
        if (this.kids != null) {
            PdfArray pdfArray = new PdfArray();
            for (int i = 0; i < this.kids.size(); i++) {
                pdfArray.add(this.kids.get(i).getIndirectReference());
            }
            put(PdfName.KIDS, pdfArray);
        }
        if (this.templates != null) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            Iterator it2 = this.templates.iterator();
            while (it2.hasNext()) {
                mergeResources(pdfDictionary, (PdfDictionary) ((PdfTemplate) it2.next()).getResources());
            }
            put(PdfName.DR, pdfDictionary);
        }
    }

    public static PdfAnnotation shallowDuplicate(PdfAnnotation pdfAnnotation) {
        PdfAnnotation pdfAnnotation2;
        if (pdfAnnotation.isForm()) {
            pdfAnnotation2 = new PdfFormField(pdfAnnotation.writer);
            PdfFormField pdfFormField = (PdfFormField) pdfAnnotation2;
            PdfFormField pdfFormField2 = (PdfFormField) pdfAnnotation;
            pdfFormField.parent = pdfFormField2.parent;
            pdfFormField.kids = pdfFormField2.kids;
        } else {
            pdfAnnotation2 = pdfAnnotation.writer.createAnnotation(null, (PdfName) pdfAnnotation.get(PdfName.SUBTYPE));
        }
        pdfAnnotation2.merge(pdfAnnotation);
        pdfAnnotation2.form = pdfAnnotation.form;
        pdfAnnotation2.annotation = pdfAnnotation.annotation;
        pdfAnnotation2.templates = pdfAnnotation.templates;
        return pdfAnnotation2;
    }
}
