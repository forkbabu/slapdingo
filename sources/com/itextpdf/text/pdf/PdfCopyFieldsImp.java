package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfDocument;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

@Deprecated
class PdfCopyFieldsImp extends PdfWriter {
    protected static final HashMap<PdfName, Integer> fieldKeys = new HashMap<>();
    private static final PdfName iTextTag = new PdfName("_iTextTag_");
    protected static final HashMap<PdfName, Integer> widgetKeys = new HashMap<>();
    private static final Integer zero = 0;
    protected Counter COUNTER;
    private ArrayList<String> calculationOrder;
    private ArrayList<Object> calculationOrderRefs;
    boolean closing;
    HashMap<String, Object> fieldTree;
    ArrayList<AcroFields> fields;
    RandomAccessFileOrArray file;
    PdfDictionary form;
    private boolean hasSignature;
    private HashSet<Object> mergedRadioButtons;
    Document nd;
    private boolean needAppearances;
    ArrayList<PdfDictionary> pageDics;
    ArrayList<PdfIndirectReference> pageRefs;
    HashMap<PdfReader, IntHashtable> pages2intrefs;
    ArrayList<PdfReader> readers;
    HashMap<PdfReader, IntHashtable> readers2intrefs;
    PdfDictionary resources;
    private HashMap<PdfArray, ArrayList<Integer>> tabOrder;
    HashMap<PdfReader, IntHashtable> visited;

    static {
        widgetKeys.put(PdfName.SUBTYPE, 1);
        widgetKeys.put(PdfName.CONTENTS, 1);
        widgetKeys.put(PdfName.RECT, 1);
        widgetKeys.put(PdfName.NM, 1);
        widgetKeys.put(PdfName.M, 1);
        widgetKeys.put(PdfName.F, 1);
        widgetKeys.put(PdfName.BS, 1);
        widgetKeys.put(PdfName.BORDER, 1);
        widgetKeys.put(PdfName.AP, 1);
        widgetKeys.put(PdfName.AS, 1);
        widgetKeys.put(PdfName.C, 1);
        widgetKeys.put(PdfName.A, 1);
        widgetKeys.put(PdfName.STRUCTPARENT, 1);
        widgetKeys.put(PdfName.OC, 1);
        widgetKeys.put(PdfName.H, 1);
        widgetKeys.put(PdfName.MK, 1);
        widgetKeys.put(PdfName.DA, 1);
        widgetKeys.put(PdfName.Q, 1);
        widgetKeys.put(PdfName.P, 1);
        fieldKeys.put(PdfName.AA, 1);
        fieldKeys.put(PdfName.FT, 1);
        fieldKeys.put(PdfName.TU, 1);
        fieldKeys.put(PdfName.TM, 1);
        fieldKeys.put(PdfName.FF, 1);
        fieldKeys.put(PdfName.V, 1);
        fieldKeys.put(PdfName.DV, 1);
        fieldKeys.put(PdfName.DS, 1);
        fieldKeys.put(PdfName.RV, 1);
        fieldKeys.put(PdfName.OPT, 1);
        fieldKeys.put(PdfName.MAXLEN, 1);
        fieldKeys.put(PdfName.TI, 1);
        fieldKeys.put(PdfName.I, 1);
        fieldKeys.put(PdfName.LOCK, 1);
        fieldKeys.put(PdfName.SV, 1);
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public Counter getCounter() {
        return this.COUNTER;
    }

    PdfCopyFieldsImp(OutputStream outputStream) throws DocumentException {
        this(outputStream, 0);
    }

    PdfCopyFieldsImp(OutputStream outputStream, char c) throws DocumentException {
        super(new PdfDocument(), outputStream);
        this.readers = new ArrayList<>();
        this.readers2intrefs = new HashMap<>();
        this.pages2intrefs = new HashMap<>();
        this.visited = new HashMap<>();
        this.fields = new ArrayList<>();
        this.fieldTree = new HashMap<>();
        this.pageRefs = new ArrayList<>();
        this.pageDics = new ArrayList<>();
        this.resources = new PdfDictionary();
        this.closing = false;
        this.calculationOrder = new ArrayList<>();
        this.needAppearances = false;
        this.mergedRadioButtons = new HashSet<>();
        this.COUNTER = CounterFactory.getCounter(PdfCopyFields.class);
        this.pdf.addWriter(this);
        if (c != 0) {
            super.setPdfVersion(c);
        }
        Document document = new Document();
        this.nd = document;
        document.addDocListener(this.pdf);
    }

    /* access modifiers changed from: package-private */
    public void addDocument(PdfReader pdfReader, List<Integer> list) throws DocumentException, IOException {
        if (this.readers2intrefs.containsKey(pdfReader) || !pdfReader.isTampered()) {
            PdfReader pdfReader2 = new PdfReader(pdfReader);
            pdfReader2.selectPages(list);
            if (pdfReader2.getNumberOfPages() != 0) {
                pdfReader2.setTampered(false);
                addDocument(pdfReader2);
                return;
            }
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("the.document.was.reused", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void addDocument(PdfReader pdfReader) throws DocumentException, IOException {
        if (pdfReader.isOpenedWithFullPermissions()) {
            openDoc();
            if (this.readers2intrefs.containsKey(pdfReader)) {
                pdfReader = new PdfReader(pdfReader);
            } else if (!pdfReader.isTampered()) {
                pdfReader.consolidateNamedDestinations();
                pdfReader.setTampered(true);
            } else {
                throw new DocumentException(MessageLocalization.getComposedMessage("the.document.was.reused", new Object[0]));
            }
            pdfReader.shuffleSubsetNames();
            this.readers2intrefs.put(pdfReader, new IntHashtable());
            this.readers.add(pdfReader);
            int numberOfPages = pdfReader.getNumberOfPages();
            IntHashtable intHashtable = new IntHashtable();
            for (int i = 1; i <= numberOfPages; i++) {
                intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), 1);
                pdfReader.releasePage(i);
            }
            this.pages2intrefs.put(pdfReader, intHashtable);
            this.visited.put(pdfReader, new IntHashtable());
            AcroFields acroFields = pdfReader.getAcroFields();
            if (!acroFields.isGenerateAppearances()) {
                this.needAppearances = true;
            }
            this.fields.add(acroFields);
            updateCalculationOrder(pdfReader);
            return;
        }
        throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
    }

    private static String getCOName(PdfReader pdfReader, PRIndirectReference pRIndirectReference) {
        PdfObject pdfObject;
        String str = "";
        while (pRIndirectReference != null && (pdfObject = PdfReader.getPdfObject(pRIndirectReference)) != null && pdfObject.type() == 6) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            PdfString asString = pdfDictionary.getAsString(PdfName.T);
            if (asString != null) {
                str = asString.toUnicodeString() + "." + str;
            }
            pRIndirectReference = (PRIndirectReference) pdfDictionary.get(PdfName.PARENT);
        }
        return str.endsWith(".") ? str.substring(0, str.length() - 1) : str;
    }

    /* access modifiers changed from: protected */
    public void updateCalculationOrder(PdfReader pdfReader) {
        PdfArray asArray;
        PdfDictionary asDict = pdfReader.getCatalog().getAsDict(PdfName.ACROFORM);
        if (asDict != null && (asArray = asDict.getAsArray(PdfName.CO)) != null && asArray.size() != 0) {
            AcroFields acroFields = pdfReader.getAcroFields();
            for (int i = 0; i < asArray.size(); i++) {
                PdfObject pdfObject = asArray.getPdfObject(i);
                if (pdfObject != null && pdfObject.isIndirect()) {
                    String cOName = getCOName(pdfReader, (PRIndirectReference) pdfObject);
                    if (acroFields.getFieldItem(cOName) != null) {
                        String str = "." + cOName;
                        if (!this.calculationOrder.contains(str)) {
                            this.calculationOrder.add(str);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void propagate(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        if (pdfObject != null && !(pdfObject instanceof PdfIndirectReference)) {
            int type = pdfObject.type();
            if (type == 5) {
                ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
                while (listIterator.hasNext()) {
                    PdfObject next = listIterator.next();
                    if (next == null || !next.isIndirect()) {
                        propagate(next, null, z);
                    } else {
                        PRIndirectReference pRIndirectReference = (PRIndirectReference) next;
                        if (!isVisited(pRIndirectReference) && !isPage(pRIndirectReference)) {
                            propagate(PdfReader.getPdfObjectRelease(pRIndirectReference), getNewReference(pRIndirectReference), z);
                        }
                    }
                }
            } else if (type == 6 || type == 7) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                for (PdfName pdfName : pdfDictionary.getKeys()) {
                    if (!z || (!pdfName.equals(PdfName.PARENT) && !pdfName.equals(PdfName.KIDS))) {
                        PdfObject pdfObject2 = pdfDictionary.get(pdfName);
                        if (pdfObject2 == null || !pdfObject2.isIndirect()) {
                            propagate(pdfObject2, null, z);
                        } else {
                            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfObject2;
                            if (!setVisited(pRIndirectReference2) && !isPage(pRIndirectReference2)) {
                                propagate(PdfReader.getPdfObjectRelease(pRIndirectReference2), getNewReference(pRIndirectReference2), z);
                            }
                        }
                    }
                }
            } else if (type == 10) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("reference.pointing.to.reference", new Object[0]));
            }
        }
    }

    private void adjustTabOrder(PdfArray pdfArray, PdfIndirectReference pdfIndirectReference, PdfNumber pdfNumber) {
        int intValue = pdfNumber.intValue();
        ArrayList<Integer> arrayList = this.tabOrder.get(pdfArray);
        if (arrayList == null) {
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            int size = pdfArray.size() - 1;
            for (int i = 0; i < size; i++) {
                arrayList2.add(zero);
            }
            arrayList2.add(Integer.valueOf(intValue));
            this.tabOrder.put(pdfArray, arrayList2);
            pdfArray.add(pdfIndirectReference);
            return;
        }
        int size2 = arrayList.size() - 1;
        int i2 = size2;
        while (true) {
            if (i2 < 0) {
                break;
            } else if (arrayList.get(i2).intValue() <= intValue) {
                int i3 = i2 + 1;
                arrayList.add(i3, Integer.valueOf(intValue));
                pdfArray.add(i3, pdfIndirectReference);
                size2 = -2;
                break;
            } else {
                i2--;
            }
        }
        if (size2 != -2) {
            arrayList.add(0, Integer.valueOf(intValue));
            pdfArray.add(0, pdfIndirectReference);
        }
    }

    /* access modifiers changed from: protected */
    public PdfArray branchForm(HashMap<String, Object> hashMap, PdfIndirectReference pdfIndirectReference, String str) throws IOException {
        boolean z;
        PdfIndirectReference pdfIndirectReference2;
        PdfIndirectReference pdfIndirectReference3 = pdfIndirectReference;
        PdfArray pdfArray = new PdfArray();
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            PdfIndirectReference pdfIndirectReference4 = getPdfIndirectReference();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfIndirectReference3 != null) {
                pdfDictionary.put(PdfName.PARENT, pdfIndirectReference3);
            }
            pdfDictionary.put(PdfName.T, new PdfString(key, PdfObject.TEXT_UNICODE));
            String str2 = str + "." + key;
            int indexOf = this.calculationOrder.indexOf(str2);
            if (indexOf >= 0) {
                this.calculationOrderRefs.set(indexOf, pdfIndirectReference4);
            }
            if (value instanceof HashMap) {
                pdfDictionary.put(PdfName.KIDS, branchForm((HashMap) value, pdfIndirectReference4, str2));
                pdfArray.add(pdfIndirectReference4);
                addToBody(pdfDictionary, pdfIndirectReference4);
            } else {
                ArrayList arrayList = (ArrayList) value;
                pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(0));
                int i = 1;
                if (arrayList.size() == 3) {
                    pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(2));
                    PdfDictionary pdfDictionary2 = this.pageDics.get(((Integer) arrayList.get(1)).intValue() - 1);
                    PdfArray asArray = pdfDictionary2.getAsArray(PdfName.ANNOTS);
                    if (asArray == null) {
                        asArray = new PdfArray();
                        pdfDictionary2.put(PdfName.ANNOTS, asArray);
                    }
                    pdfDictionary.remove(iTextTag);
                    adjustTabOrder(asArray, pdfIndirectReference4, (PdfNumber) pdfDictionary.get(iTextTag));
                    pdfIndirectReference2 = null;
                    z = false;
                } else {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) arrayList.get(0);
                    PdfObject asName = pdfDictionary3.getAsName(PdfName.V);
                    PdfArray pdfArray2 = new PdfArray();
                    int i2 = 1;
                    while (i2 < arrayList.size()) {
                        PdfDictionary pdfDictionary4 = this.pageDics.get(((Integer) arrayList.get(i2)).intValue() - i);
                        PdfArray asArray2 = pdfDictionary4.getAsArray(PdfName.ANNOTS);
                        if (asArray2 == null) {
                            asArray2 = new PdfArray();
                            pdfDictionary4.put(PdfName.ANNOTS, asArray2);
                        }
                        PdfDictionary pdfDictionary5 = new PdfDictionary();
                        pdfDictionary5.merge((PdfDictionary) arrayList.get(i2 + 1));
                        pdfDictionary5.put(PdfName.PARENT, pdfIndirectReference4);
                        PdfNumber pdfNumber = (PdfNumber) pdfDictionary5.get(iTextTag);
                        pdfDictionary5.remove(iTextTag);
                        if (PdfCopy.isCheckButton(pdfDictionary3)) {
                            PdfName asName2 = pdfDictionary5.getAsName(PdfName.AS);
                            if (!(asName == null || asName2 == null)) {
                                pdfDictionary5.put(PdfName.AS, asName);
                            }
                        } else if (PdfCopy.isRadioButton(pdfDictionary3)) {
                            PdfName asName3 = pdfDictionary5.getAsName(PdfName.AS);
                            if (!(asName == null || asName3 == null || asName3.equals(getOffStateName(pdfDictionary5)))) {
                                if (!this.mergedRadioButtons.contains(arrayList)) {
                                    this.mergedRadioButtons.add(arrayList);
                                    pdfDictionary5.put(PdfName.AS, asName);
                                } else {
                                    pdfDictionary5.put(PdfName.AS, getOffStateName(pdfDictionary5));
                                }
                            }
                        }
                        PdfIndirectReference indirectReference = addToBody(pdfDictionary5).getIndirectReference();
                        adjustTabOrder(asArray2, indirectReference, pdfNumber);
                        pdfArray2.add(indirectReference);
                        propagate(pdfDictionary5, null, false);
                        i2 += 2;
                        i = 1;
                    }
                    pdfIndirectReference2 = null;
                    z = false;
                    pdfDictionary.put(PdfName.KIDS, pdfArray2);
                }
                pdfArray.add(pdfIndirectReference4);
                addToBody(pdfDictionary, pdfIndirectReference4);
                propagate(pdfDictionary, pdfIndirectReference2, z);
            }
            pdfIndirectReference3 = pdfIndirectReference;
        }
        return pdfArray;
    }

    /* access modifiers changed from: protected */
    public PdfName getOffStateName(PdfDictionary pdfDictionary) {
        return PdfName.Off;
    }

    /* access modifiers changed from: protected */
    public void createAcroForms() throws IOException {
        if (!this.fieldTree.isEmpty()) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            this.form = pdfDictionary;
            pdfDictionary.put(PdfName.DR, this.resources);
            propagate(this.resources, null, false);
            if (this.needAppearances) {
                this.form.put(PdfName.NEEDAPPEARANCES, PdfBoolean.PDFTRUE);
            }
            this.form.put(PdfName.DA, new PdfString("/Helv 0 Tf 0 g "));
            this.tabOrder = new HashMap<>();
            this.calculationOrderRefs = new ArrayList<>(this.calculationOrder);
            this.form.put(PdfName.FIELDS, branchForm(this.fieldTree, null, ""));
            if (this.hasSignature) {
                this.form.put(PdfName.SIGFLAGS, new PdfNumber(3));
            }
            PdfArray pdfArray = new PdfArray();
            for (int i = 0; i < this.calculationOrderRefs.size(); i++) {
                Object obj = this.calculationOrderRefs.get(i);
                if (obj instanceof PdfIndirectReference) {
                    pdfArray.add((PdfIndirectReference) obj);
                }
            }
            if (pdfArray.size() > 0) {
                this.form.put(PdfName.CO, pdfArray);
            }
        }
    }

    @Override // com.itextpdf.text.DocListener, com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.DocWriter
    public void close() {
        if (this.closing) {
            super.close();
            return;
        }
        this.closing = true;
        try {
            closeIt();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public void closeIt() throws IOException {
        for (int i = 0; i < this.readers.size(); i++) {
            this.readers.get(i).removeFields();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.readers.size()) {
                break;
            }
            PdfReader pdfReader = this.readers.get(i2);
            for (int i3 = 1; i3 <= pdfReader.getNumberOfPages(); i3++) {
                this.pageRefs.add(getNewReference(pdfReader.getPageOrigRef(i3)));
                this.pageDics.add(pdfReader.getPageN(i3));
            }
            i2++;
        }
        mergeFields();
        createAcroForms();
        for (int i4 = 0; i4 < this.readers.size(); i4++) {
            PdfReader pdfReader2 = this.readers.get(i4);
            for (int i5 = 1; i5 <= pdfReader2.getNumberOfPages(); i5++) {
                PdfDictionary pageN = pdfReader2.getPageN(i5);
                PdfIndirectReference newReference = getNewReference(pdfReader2.getPageOrigRef(i5));
                pageN.put(PdfName.PARENT, this.root.addPageRef(newReference));
                propagate(pageN, newReference, false);
            }
        }
        for (Map.Entry<PdfReader, IntHashtable> entry : this.readers2intrefs.entrySet()) {
            PdfReader key = entry.getKey();
            try {
                RandomAccessFileOrArray safeFile = key.getSafeFile();
                this.file = safeFile;
                safeFile.reOpen();
                IntHashtable value = entry.getValue();
                int[] orderedKeys = value.toOrderedKeys();
                for (int i6 = 0; i6 < orderedKeys.length; i6++) {
                    addToBody(PdfReader.getPdfObjectRelease(new PRIndirectReference(key, orderedKeys[i6])), value.get(orderedKeys[i6]));
                }
            } finally {
                try {
                    this.file.close();
                } catch (Exception unused) {
                }
            }
        }
        this.pdf.close();
    }

    /* access modifiers changed from: package-private */
    public void addPageOffsetToField(Map<String, AcroFields.Item> map, int i) {
        if (i != 0) {
            for (AcroFields.Item item : map.values()) {
                for (int i2 = 0; i2 < item.size(); i2++) {
                    item.forcePage(i2, item.getPage(i2).intValue() + i);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void createWidgets(ArrayList<Object> arrayList, AcroFields.Item item) {
        for (int i = 0; i < item.size(); i++) {
            arrayList.add(item.getPage(i));
            PdfDictionary merged = item.getMerged(i);
            PdfObject pdfObject = merged.get(PdfName.DR);
            if (pdfObject != null) {
                PdfFormField.mergeResources(this.resources, (PdfDictionary) PdfReader.getPdfObject(pdfObject));
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            for (PdfName pdfName : merged.getKeys()) {
                if (widgetKeys.containsKey(pdfName)) {
                    pdfDictionary.put(pdfName, merged.get(pdfName));
                }
            }
            pdfDictionary.put(iTextTag, new PdfNumber(item.getTabOrder(i).intValue() + 1));
            arrayList.add(pdfDictionary);
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeField(String str, AcroFields.Item item) {
        HashMap<String, Object> hashMap = this.fieldTree;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (stringTokenizer.hasMoreTokens()) {
            while (true) {
                String nextToken = stringTokenizer.nextToken();
                Object obj = hashMap.get(nextToken);
                if (stringTokenizer.hasMoreTokens()) {
                    if (obj == null) {
                        HashMap<String, Object> hashMap2 = new HashMap<>();
                        hashMap.put(nextToken, hashMap2);
                        hashMap = hashMap2;
                    } else if (obj instanceof HashMap) {
                        hashMap = (HashMap) obj;
                    } else {
                        return;
                    }
                } else if (!(obj instanceof HashMap)) {
                    int i = 0;
                    i = 0;
                    PdfDictionary merged = item.getMerged(0);
                    if (obj == null) {
                        PdfDictionary pdfDictionary = new PdfDictionary();
                        if (PdfName.SIG.equals(merged.get(PdfName.FT))) {
                            this.hasSignature = true;
                        }
                        for (PdfName pdfName : merged.getKeys()) {
                            if (fieldKeys.containsKey(pdfName)) {
                                pdfDictionary.put(pdfName, merged.get(pdfName));
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(pdfDictionary);
                        createWidgets(arrayList, item);
                        hashMap.put(nextToken, arrayList);
                        return;
                    }
                    ArrayList arrayList2 = (ArrayList) obj;
                    PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList2.get(0);
                    PdfName pdfName2 = (PdfName) pdfDictionary2.get(PdfName.FT);
                    PdfName pdfName3 = (PdfName) merged.get(PdfName.FT);
                    if (pdfName2 != null && pdfName2.equals(pdfName3)) {
                        PdfObject pdfObject = pdfDictionary2.get(PdfName.FF);
                        int intValue = (pdfObject == null || !pdfObject.isNumber()) ? 0 : ((PdfNumber) pdfObject).intValue();
                        PdfObject pdfObject2 = merged.get(PdfName.FF);
                        if (pdfObject2 != null && pdfObject2.isNumber()) {
                            i = ((PdfNumber) pdfObject2).intValue();
                        }
                        if (pdfName2.equals(PdfName.BTN)) {
                            int i2 = intValue ^ i;
                            if ((i2 & 65536) == 0) {
                                if ((intValue & 65536) == 0 && (32768 & i2) != 0) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (pdfName2.equals(PdfName.CH) && ((intValue ^ i) & 131072) != 0) {
                            return;
                        }
                        createWidgets(arrayList2, item);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeWithMaster(Map<String, AcroFields.Item> map) {
        for (Map.Entry<String, AcroFields.Item> entry : map.entrySet()) {
            mergeField(entry.getKey(), entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeFields() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.size(); i2++) {
            Map<String, AcroFields.Item> fields2 = this.fields.get(i2).getFields();
            addPageOffsetToField(fields2, i);
            mergeWithMaster(fields2);
            i += this.readers.get(i2).getNumberOfPages();
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectReference getPageReference(int i) {
        return this.pageRefs.get(i - 1);
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        try {
            PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
            if (this.form != null) {
                catalog.put(PdfName.ACROFORM, addToBody(this.form).getIndirectReference());
            }
            return catalog;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference getNewReference(PRIndirectReference pRIndirectReference) {
        return new PdfIndirectReference(0, getNewObjectNumber(pRIndirectReference.getReader(), pRIndirectReference.getNumber(), 0));
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        IntHashtable intHashtable = this.readers2intrefs.get(pdfReader);
        int i3 = intHashtable.get(i);
        if (i3 != 0) {
            return i3;
        }
        int indirectReferenceNumber = getIndirectReferenceNumber();
        intHashtable.put(i, indirectReferenceNumber);
        return indirectReferenceNumber;
    }

    /* access modifiers changed from: protected */
    public boolean setVisited(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.visited.get(pRIndirectReference.getReader());
        if (intHashtable == null || intHashtable.put(pRIndirectReference.getNumber(), 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isVisited(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.visited.get(pRIndirectReference.getReader());
        if (intHashtable != null) {
            return intHashtable.containsKey(pRIndirectReference.getNumber());
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isVisited(PdfReader pdfReader, int i, int i2) {
        return this.readers2intrefs.get(pdfReader).containsKey(i);
    }

    /* access modifiers changed from: protected */
    public boolean isPage(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.pages2intrefs.get(pRIndirectReference.getReader());
        if (intHashtable != null) {
            return intHashtable.containsKey(pRIndirectReference.getNumber());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        return this.file;
    }

    public void openDoc() {
        if (!this.nd.isOpen()) {
            this.nd.open();
        }
    }
}
