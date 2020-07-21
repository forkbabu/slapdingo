package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

public class PdfCopy extends PdfWriter {
    protected static Counter COUNTER = CounterFactory.getCounter(PdfCopy.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfCopy.class);
    private static final PdfName annotId = new PdfName("iTextAnnotId");
    private static int annotIdCnt = 0;
    protected static final HashSet<PdfName> fieldKeys = new HashSet<>();
    private static final PdfName iTextTag = new PdfName("_iTextTag_");
    protected static final HashSet<PdfName> widgetKeys = new HashSet<>();
    private static final Integer zero = 0;
    private PdfIndirectReference acroForm;
    private ArrayList<String> calculationOrder;
    private ArrayList<Object> calculationOrderRefs;
    private int currentStructArrayNumber = 0;
    protected HashSet<PdfObject> disableIndirects;
    protected PdfArray fieldArray;
    protected HashSet<PdfTemplate> fieldTemplates;
    private HashMap<String, Object> fieldTree;
    protected ArrayList<AcroFields> fields;
    private boolean hasSignature;
    protected ArrayList<ImportedPage> importedPages;
    protected HashMap<PdfReader, HashMap<RefKey, IndirectReferences>> indirectMap;
    protected LinkedHashMap<RefKey, PdfIndirectObject> indirectObjects;
    protected HashMap<RefKey, IndirectReferences> indirects;
    protected boolean mergeFields = false;
    private boolean mergeFieldsInternalCall = false;
    private HashMap<Integer, PdfIndirectObject> mergedMap;
    private HashSet<Object> mergedRadioButtons = new HashSet<>();
    private HashSet<PdfIndirectObject> mergedSet;
    private HashMap<Object, PdfString> mergedTextFields = new HashMap<>();
    protected int[] namePtr = {0};
    private boolean needAppearances = false;
    protected HashMap<PdfObject, PdfObject> parentObjects;
    protected PdfReader reader;
    private HashSet<PdfReader> readersWithImportedStructureTreeRootKids = new HashSet<>();
    private PdfDictionary resources;
    /* access modifiers changed from: private */
    public boolean rotateContents = true;
    protected ArrayList<PdfIndirectObject> savedObjects;
    private PdfStructTreeController structTreeController = null;
    protected PRIndirectReference structTreeRootReference;
    private HashMap<PdfArray, ArrayList<Integer>> tabOrder;
    private HashMap<RefKey, PdfIndirectObject> unmergedIndirectRefsMap;
    private HashMap<Integer, PdfIndirectObject> unmergedMap;
    protected boolean updateRootKids = false;

    public PdfIndirectReference add(PdfOutline pdfOutline) {
        return null;
    }

    /* access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectReference add(PdfPage pdfPage, PdfContents pdfContents) throws PdfException {
        return null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfAnnotations, com.itextpdf.text.pdf.PdfWriter
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
    }

    static {
        widgetKeys.add(PdfName.SUBTYPE);
        widgetKeys.add(PdfName.CONTENTS);
        widgetKeys.add(PdfName.RECT);
        widgetKeys.add(PdfName.NM);
        widgetKeys.add(PdfName.M);
        widgetKeys.add(PdfName.F);
        widgetKeys.add(PdfName.BS);
        widgetKeys.add(PdfName.BORDER);
        widgetKeys.add(PdfName.AP);
        widgetKeys.add(PdfName.AS);
        widgetKeys.add(PdfName.C);
        widgetKeys.add(PdfName.A);
        widgetKeys.add(PdfName.STRUCTPARENT);
        widgetKeys.add(PdfName.OC);
        widgetKeys.add(PdfName.H);
        widgetKeys.add(PdfName.MK);
        widgetKeys.add(PdfName.DA);
        widgetKeys.add(PdfName.Q);
        widgetKeys.add(PdfName.P);
        widgetKeys.add(PdfName.TYPE);
        widgetKeys.add(annotId);
        fieldKeys.add(PdfName.AA);
        fieldKeys.add(PdfName.FT);
        fieldKeys.add(PdfName.TU);
        fieldKeys.add(PdfName.TM);
        fieldKeys.add(PdfName.FF);
        fieldKeys.add(PdfName.V);
        fieldKeys.add(PdfName.DV);
        fieldKeys.add(PdfName.DS);
        fieldKeys.add(PdfName.RV);
        fieldKeys.add(PdfName.OPT);
        fieldKeys.add(PdfName.MAXLEN);
        fieldKeys.add(PdfName.TI);
        fieldKeys.add(PdfName.I);
        fieldKeys.add(PdfName.LOCK);
        fieldKeys.add(PdfName.SV);
    }

    static class IndirectReferences {
        boolean hasCopied = false;
        PdfIndirectReference theRef;

        IndirectReferences(PdfIndirectReference pdfIndirectReference) {
            this.theRef = pdfIndirectReference;
        }

        /* access modifiers changed from: package-private */
        public void setCopied() {
            this.hasCopied = true;
        }

        /* access modifiers changed from: package-private */
        public void setNotCopied() {
            this.hasCopied = false;
        }

        /* access modifiers changed from: package-private */
        public boolean getCopied() {
            return this.hasCopied;
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectReference getRef() {
            return this.theRef;
        }

        public String toString() {
            String str = this.hasCopied ? " Copied" : "";
            return getRef() + str;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public Counter getCounter() {
        return COUNTER;
    }

    protected static class ImportedPage {
        PdfIndirectReference annotsIndirectReference;
        PdfArray mergedFields;
        int pageNumber;
        PdfReader reader;

        ImportedPage(PdfReader pdfReader, int i, boolean z) {
            this.pageNumber = i;
            this.reader = pdfReader;
            if (z) {
                this.mergedFields = new PdfArray();
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImportedPage)) {
                return false;
            }
            ImportedPage importedPage = (ImportedPage) obj;
            if (this.pageNumber != importedPage.pageNumber || !this.reader.equals(importedPage.reader)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return Integer.toString(this.pageNumber);
        }
    }

    public PdfCopy(Document document, OutputStream outputStream) throws DocumentException {
        super(new PdfDocument(), outputStream);
        document.addDocListener(this.pdf);
        this.pdf.addWriter(this);
        this.indirectMap = new HashMap<>();
        this.parentObjects = new HashMap<>();
        this.disableIndirects = new HashSet<>();
        this.indirectObjects = new LinkedHashMap<>();
        this.savedObjects = new ArrayList<>();
        this.importedPages = new ArrayList<>();
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void setPageEvent(PdfPageEvent pdfPageEvent) {
        throw new UnsupportedOperationException();
    }

    public boolean isRotateContents() {
        return this.rotateContents;
    }

    public void setRotateContents(boolean z) {
        this.rotateContents = z;
    }

    public void setMergeFields() {
        this.mergeFields = true;
        this.resources = new PdfDictionary();
        this.fields = new ArrayList<>();
        this.calculationOrder = new ArrayList<>();
        this.fieldTree = new LinkedHashMap();
        this.unmergedMap = new HashMap<>();
        this.unmergedIndirectRefsMap = new HashMap<>();
        this.mergedMap = new HashMap<>();
        this.mergedSet = new HashSet<>();
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        if (!this.mergeFields || this.mergeFieldsInternalCall) {
            boolean z = this.mergeFields;
            if (z) {
                this.importedPages.add(new ImportedPage(pdfReader, i, z));
            }
            PdfStructTreeController pdfStructTreeController = this.structTreeController;
            if (pdfStructTreeController != null) {
                pdfStructTreeController.reader = null;
            }
            this.disableIndirects.clear();
            this.parentObjects.clear();
            return getImportedPageImpl(pdfReader, i);
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "getImportedPage"));
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i, boolean z) throws BadPdfFormatException {
        if (!this.mergeFields || this.mergeFieldsInternalCall) {
            this.updateRootKids = false;
            if (!z) {
                boolean z2 = this.mergeFields;
                if (z2) {
                    this.importedPages.add(new ImportedPage(pdfReader, i, z2));
                }
                return getImportedPageImpl(pdfReader, i);
            }
            PdfStructTreeController pdfStructTreeController = this.structTreeController;
            if (pdfStructTreeController == null) {
                this.structTreeController = new PdfStructTreeController(pdfReader, this);
            } else if (pdfReader != pdfStructTreeController.reader) {
                this.structTreeController.setReader(pdfReader);
            }
            ImportedPage importedPage = new ImportedPage(pdfReader, i, this.mergeFields);
            int checkStructureTreeRootKids = checkStructureTreeRootKids(importedPage);
            if (checkStructureTreeRootKids == -1) {
                clearIndirects(pdfReader);
                this.updateRootKids = true;
            } else if (checkStructureTreeRootKids == 0) {
                this.updateRootKids = false;
            } else if (checkStructureTreeRootKids == 1) {
                this.updateRootKids = true;
            }
            this.importedPages.add(importedPage);
            this.disableIndirects.clear();
            this.parentObjects.clear();
            return getImportedPageImpl(pdfReader, i);
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "getImportedPage"));
    }

    private void clearIndirects(PdfReader pdfReader) {
        HashMap<RefKey, IndirectReferences> hashMap = this.indirectMap.get(pdfReader);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<RefKey, IndirectReferences> entry : hashMap.entrySet()) {
            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(new RefKey(entry.getValue().theRef));
            if (pdfIndirectObject == null) {
                arrayList.add(entry.getKey());
            } else if (pdfIndirectObject.object.isArray() || pdfIndirectObject.object.isDictionary() || pdfIndirectObject.object.isStream()) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            hashMap.remove((RefKey) it2.next());
        }
    }

    private int checkStructureTreeRootKids(ImportedPage importedPage) {
        boolean z;
        if (this.importedPages.size() == 0) {
            return 1;
        }
        Iterator<ImportedPage> it2 = this.importedPages.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().reader.equals(importedPage.reader)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            return 1;
        }
        ArrayList<ImportedPage> arrayList = this.importedPages;
        ImportedPage importedPage2 = arrayList.get(arrayList.size() - 1);
        if (!importedPage2.reader.equals(importedPage.reader) || importedPage.pageNumber <= importedPage2.pageNumber) {
            return -1;
        }
        if (this.readersWithImportedStructureTreeRootKids.contains(importedPage.reader)) {
            return 0;
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public void structureTreeRootKidsForReaderImported(PdfReader pdfReader) {
        this.readersWithImportedStructureTreeRootKids.add(pdfReader);
    }

    /* access modifiers changed from: protected */
    public void fixStructureTreeRoot(HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        HashMap<PdfName, PdfObject> hashMap = new HashMap<>(hashSet2.size());
        Iterator<PdfName> it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            PdfName next = it2.next();
            PdfObject pdfObject = this.structureTreeRoot.classes.get(next);
            if (pdfObject != null) {
                hashMap.put(next, pdfObject);
            }
        }
        this.structureTreeRoot.classes = hashMap;
        PdfArray asArray = this.structureTreeRoot.getAsArray(PdfName.K);
        if (asArray != null) {
            int i = 0;
            while (i < asArray.size()) {
                if (!hashSet.contains(new RefKey((PdfIndirectReference) asArray.getPdfObject(i)))) {
                    asArray.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfImportedPage getImportedPageImpl(PdfReader pdfReader, int i) {
        if (this.currentPdfReaderInstance == null) {
            this.currentPdfReaderInstance = super.getPdfReaderInstance(pdfReader);
        } else if (this.currentPdfReaderInstance.getReader() != pdfReader) {
            this.currentPdfReaderInstance = super.getPdfReaderInstance(pdfReader);
        }
        return this.currentPdfReaderInstance.getImportedPage(i);
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference copyIndirect(PRIndirectReference pRIndirectReference, boolean z, boolean z2) throws IOException, BadPdfFormatException {
        PdfIndirectReference pdfIndirectReference;
        PdfObject pdfObjectRelease;
        RefKey refKey = new RefKey(pRIndirectReference);
        IndirectReferences indirectReferences = this.indirects.get(refKey);
        PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pRIndirectReference);
        if (z && z2 && (pdfObjectRelease2 instanceof PdfDictionary) && ((PdfDictionary) pdfObjectRelease2).contains(PdfName.PG)) {
            return null;
        }
        if (indirectReferences != null) {
            pdfIndirectReference = indirectReferences.getRef();
            if (indirectReferences.getCopied()) {
                return pdfIndirectReference;
            }
        } else {
            pdfIndirectReference = this.body.getPdfIndirectReference();
            indirectReferences = new IndirectReferences(pdfIndirectReference);
            this.indirects.put(refKey, indirectReferences);
        }
        if (!(pdfObjectRelease2 == null || !pdfObjectRelease2.isDictionary() || (pdfObjectRelease = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease2).get(PdfName.TYPE))) == null)) {
            if (PdfName.PAGE.equals(pdfObjectRelease)) {
                return pdfIndirectReference;
            }
            if (PdfName.CATALOG.equals(pdfObjectRelease)) {
                LOGGER.warn(MessageLocalization.getComposedMessage("make.copy.of.catalog.dictionary.is.forbidden", new Object[0]));
                return null;
            }
        }
        indirectReferences.setCopied();
        if (pdfObjectRelease2 != null) {
            this.parentObjects.put(pdfObjectRelease2, pRIndirectReference);
        }
        PdfObject copyObject = copyObject(pdfObjectRelease2, z, z2);
        if (this.disableIndirects.contains(pdfObjectRelease2)) {
            indirectReferences.setNotCopied();
        }
        if (copyObject != null) {
            addToBody(copyObject, pdfIndirectReference);
            return pdfIndirectReference;
        }
        this.indirects.remove(refKey);
        return null;
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference copyIndirect(PRIndirectReference pRIndirectReference) throws IOException, BadPdfFormatException {
        return copyIndirect(pRIndirectReference, false, false);
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* access modifiers changed from: protected */
    public PdfDictionary copyDictionary(PdfDictionary pdfDictionary, boolean z, boolean z2) throws IOException, BadPdfFormatException {
        PdfObject pdfObject;
        PdfDictionary pdfDictionary2 = new PdfDictionary(pdfDictionary.size());
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TYPE));
        if (z) {
            if (!z2 || !pdfDictionary.contains(PdfName.PG)) {
                this.structTreeController.addRole(pdfDictionary.getAsName(PdfName.S));
                this.structTreeController.addClass(pdfDictionary);
            } else {
                this.disableIndirects.add(pdfDictionary);
                PdfObject pdfObject2 = pdfDictionary;
                while (this.parentObjects.containsKey(pdfObject2) && !this.disableIndirects.contains(pdfObject2)) {
                    PdfObject pdfObject3 = this.parentObjects.get(pdfObject2);
                    this.disableIndirects.add(pdfObject3);
                    pdfObject2 = pdfObject3;
                }
                return null;
            }
        }
        PdfStructTreeController pdfStructTreeController = this.structTreeController;
        if (!(pdfStructTreeController == null || pdfStructTreeController.reader == null || (!pdfDictionary.contains(PdfName.STRUCTPARENTS) && !pdfDictionary.contains(PdfName.STRUCTPARENT)))) {
            PdfName pdfName = PdfName.STRUCTPARENT;
            if (pdfDictionary.contains(PdfName.STRUCTPARENTS)) {
                pdfName = PdfName.STRUCTPARENTS;
            }
            PdfObject pdfObject4 = pdfDictionary.get(pdfName);
            pdfDictionary2.put(pdfName, new PdfNumber(this.currentStructArrayNumber));
            int i = this.currentStructArrayNumber;
            this.currentStructArrayNumber = i + 1;
            this.structTreeController.copyStructTreeForPage((PdfNumber) pdfObject4, i);
        }
        for (PdfName pdfName2 : pdfDictionary.getKeys()) {
            PdfObject pdfObject5 = pdfDictionary.get(pdfName2);
            PdfStructTreeController pdfStructTreeController2 = this.structTreeController;
            if (pdfStructTreeController2 == null || pdfStructTreeController2.reader == null || (!pdfName2.equals(PdfName.STRUCTPARENTS) && !pdfName2.equals(PdfName.STRUCTPARENT))) {
                if (!PdfName.PAGE.equals(pdfObjectRelease)) {
                    if (!this.tagged || !pdfObject5.isIndirect() || !isStructTreeRootReference((PRIndirectReference) pdfObject5)) {
                        pdfObject = copyObject(pdfObject5, z, z2);
                    } else {
                        pdfObject = this.structureTreeRoot.getReference();
                    }
                    if (pdfObject != null) {
                        pdfDictionary2.put(pdfName2, pdfObject);
                    }
                } else if (!pdfName2.equals(PdfName.B) && !pdfName2.equals(PdfName.PARENT)) {
                    this.parentObjects.put(pdfObject5, pdfDictionary);
                    PdfObject copyObject = copyObject(pdfObject5, z, z2);
                    if (copyObject != null) {
                        pdfDictionary2.put(pdfName2, copyObject);
                    }
                }
            }
        }
        return pdfDictionary2;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary copyDictionary(PdfDictionary pdfDictionary) throws IOException, BadPdfFormatException {
        return copyDictionary(pdfDictionary, false, false);
    }

    /* access modifiers changed from: protected */
    public PdfStream copyStream(PRStream pRStream) throws IOException, BadPdfFormatException {
        PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null);
        for (PdfName pdfName : pRStream.getKeys()) {
            PdfObject pdfObject = pRStream.get(pdfName);
            this.parentObjects.put(pdfObject, pRStream);
            PdfObject copyObject = copyObject(pdfObject);
            if (copyObject != null) {
                pRStream2.put(pdfName, copyObject);
            }
        }
        return pRStream2;
    }

    /* access modifiers changed from: protected */
    public PdfArray copyArray(PdfArray pdfArray, boolean z, boolean z2) throws IOException, BadPdfFormatException {
        PdfArray pdfArray2 = new PdfArray(pdfArray.size());
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            PdfObject next = listIterator.next();
            this.parentObjects.put(next, pdfArray);
            PdfObject copyObject = copyObject(next, z, z2);
            if (copyObject != null) {
                pdfArray2.add(copyObject);
            }
        }
        return pdfArray2;
    }

    /* access modifiers changed from: protected */
    public PdfArray copyArray(PdfArray pdfArray) throws IOException, BadPdfFormatException {
        return copyArray(pdfArray, false, false);
    }

    /* access modifiers changed from: protected */
    public PdfObject copyObject(PdfObject pdfObject, boolean z, boolean z2) throws IOException, BadPdfFormatException {
        if (pdfObject == null) {
            return PdfNull.PDFNULL;
        }
        switch (pdfObject.type) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 8:
                return pdfObject;
            case 5:
                return copyArray((PdfArray) pdfObject, z, z2);
            case 6:
                return copyDictionary((PdfDictionary) pdfObject, z, z2);
            case 7:
                return copyStream((PRStream) pdfObject);
            case 9:
            default:
                if (pdfObject.type < 0) {
                    String pdfLiteral = ((PdfLiteral) pdfObject).toString();
                    if (pdfLiteral.equals(PdfBoolean.TRUE) || pdfLiteral.equals(PdfBoolean.FALSE)) {
                        return new PdfBoolean(pdfLiteral);
                    }
                    return new PdfLiteral(pdfLiteral);
                }
                PrintStream printStream = System.out;
                printStream.println("CANNOT COPY type " + pdfObject.type);
                return null;
            case 10:
                if (z || z2) {
                    return copyIndirect((PRIndirectReference) pdfObject, z, z2);
                }
                return copyIndirect((PRIndirectReference) pdfObject);
        }
    }

    /* access modifiers changed from: protected */
    public PdfObject copyObject(PdfObject pdfObject) throws IOException, BadPdfFormatException {
        return copyObject(pdfObject, false, false);
    }

    /* access modifiers changed from: protected */
    public int setFromIPage(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReaderInstance pdfReaderInstance = pdfImportedPage.getPdfReaderInstance();
        this.currentPdfReaderInstance = pdfReaderInstance;
        PdfReader reader2 = pdfReaderInstance.getReader();
        this.reader = reader2;
        setFromReader(reader2);
        return pageNumber;
    }

    /* access modifiers changed from: protected */
    public void setFromReader(PdfReader pdfReader) {
        this.reader = pdfReader;
        HashMap<RefKey, IndirectReferences> hashMap = this.indirectMap.get(pdfReader);
        this.indirects = hashMap;
        if (hashMap == null) {
            HashMap<RefKey, IndirectReferences> hashMap2 = new HashMap<>();
            this.indirects = hashMap2;
            this.indirectMap.put(pdfReader, hashMap2);
        }
    }

    public void addPage(PdfImportedPage pdfImportedPage) throws IOException, BadPdfFormatException {
        if (!this.mergeFields || this.mergeFieldsInternalCall) {
            int fromIPage = setFromIPage(pdfImportedPage);
            PdfDictionary pageN = this.reader.getPageN(fromIPage);
            PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(fromIPage);
            this.reader.releasePage(fromIPage);
            RefKey refKey = new RefKey(pageOrigRef);
            IndirectReferences indirectReferences = this.indirects.get(refKey);
            if (indirectReferences != null && !indirectReferences.getCopied()) {
                this.pageReferences.add(indirectReferences.getRef());
                indirectReferences.setCopied();
            }
            PdfIndirectReference currentPage = getCurrentPage();
            if (indirectReferences == null) {
                indirectReferences = new IndirectReferences(currentPage);
                this.indirects.put(refKey, indirectReferences);
            }
            indirectReferences.setCopied();
            if (this.tagged) {
                this.structTreeRootReference = (PRIndirectReference) this.reader.getCatalog().get(PdfName.STRUCTTREEROOT);
            }
            PdfDictionary copyDictionary = copyDictionary(pageN);
            if (this.mergeFields) {
                ArrayList<ImportedPage> arrayList = this.importedPages;
                ImportedPage importedPage = arrayList.get(arrayList.size() - 1);
                importedPage.annotsIndirectReference = this.body.getPdfIndirectReference();
                copyDictionary.put(PdfName.ANNOTS, importedPage.annotsIndirectReference);
            }
            this.root.addPage(copyDictionary);
            pdfImportedPage.setCopied();
            this.currentPageNumber++;
            this.pdf.setPageCount(this.currentPageNumber);
            this.structTreeRootReference = null;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "addPage"));
    }

    public void addPage(Rectangle rectangle, int i) throws DocumentException {
        if (!this.mergeFields || this.mergeFieldsInternalCall) {
            PdfPage pdfPage = new PdfPage(new PdfRectangle(rectangle, i), new HashMap(), new PageResources().getResources(), 0);
            pdfPage.put(PdfName.TABS, getTabs());
            this.root.addPage(pdfPage);
            this.currentPageNumber++;
            this.pdf.setPageCount(this.currentPageNumber);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "addPage"));
    }

    public void addDocument(PdfReader pdfReader, List<Integer> list) throws DocumentException, IOException {
        if (!this.indirectMap.containsKey(pdfReader)) {
            pdfReader.selectPages(list, false);
            addDocument(pdfReader);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("document.1.has.already.been.added", pdfReader.toString()));
    }

    public void copyDocumentFields(PdfReader pdfReader) throws DocumentException, IOException {
        PdfStructTreeController pdfStructTreeController;
        PdfArray asArray;
        if (!this.document.isOpen()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        } else if (this.indirectMap.containsKey(pdfReader)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("document.1.has.already.been.added", pdfReader.toString()));
        } else if (!pdfReader.isOpenedWithFullPermissions()) {
            throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
        } else if (this.mergeFields) {
            HashMap<RefKey, IndirectReferences> hashMap = new HashMap<>();
            this.indirects = hashMap;
            this.indirectMap.put(pdfReader, hashMap);
            pdfReader.consolidateNamedDestinations();
            pdfReader.shuffleSubsetNames();
            if (this.tagged && PdfStructTreeController.checkTagged(pdfReader)) {
                this.structTreeRootReference = (PRIndirectReference) pdfReader.getCatalog().get(PdfName.STRUCTTREEROOT);
                PdfStructTreeController pdfStructTreeController2 = this.structTreeController;
                if (pdfStructTreeController2 == null) {
                    this.structTreeController = new PdfStructTreeController(pdfReader, this);
                } else if (pdfReader != pdfStructTreeController2.reader) {
                    this.structTreeController.setReader(pdfReader);
                }
            }
            ArrayList<PdfObject> arrayList = new ArrayList();
            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                PdfDictionary pageNRelease = pdfReader.getPageNRelease(i);
                if (pageNRelease != null && pageNRelease.contains(PdfName.ANNOTS) && (asArray = pageNRelease.getAsArray(PdfName.ANNOTS)) != null && asArray.size() > 0) {
                    if (this.importedPages.size() >= i) {
                        this.indirectMap.get(pdfReader).put(new RefKey(pdfReader.pageRefs.getPageOrigRef(i)), new IndirectReferences((PdfIndirectReference) this.pageReferences.get(i - 1)));
                        for (int i2 = 0; i2 < asArray.size(); i2++) {
                            PdfDictionary asDict = asArray.getAsDict(i2);
                            if (asDict != null) {
                                PdfName pdfName = annotId;
                                int i3 = annotIdCnt + 1;
                                annotIdCnt = i3;
                                asDict.put(pdfName, new PdfNumber(i3));
                                arrayList.add(asArray.getPdfObject(i2));
                            }
                        }
                    } else {
                        throw new DocumentException(MessageLocalization.getComposedMessage("there.are.not.enough.imported.pages.for.copied.fields", new Object[0]));
                    }
                }
            }
            for (PdfObject pdfObject : arrayList) {
                copyObject(pdfObject);
            }
            if (this.tagged && (pdfStructTreeController = this.structTreeController) != null) {
                pdfStructTreeController.attachStructTreeRootKids(null);
            }
            AcroFields acroFields = pdfReader.getAcroFields();
            if (!acroFields.isGenerateAppearances()) {
                this.needAppearances = true;
            }
            this.fields.add(acroFields);
            updateCalculationOrder(pdfReader);
            this.structTreeRootReference = null;
        } else {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.can.be.only.used.in.mergeFields.mode.please.use.addDocument", "copyDocumentFields"));
        }
    }

    public void addDocument(PdfReader pdfReader) throws DocumentException, IOException {
        PdfArray asArray;
        if (this.document.isOpen()) {
            if (this.indirectMap.containsKey(pdfReader)) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("document.1.has.already.been.added", pdfReader.toString()));
            } else if (pdfReader.isOpenedWithFullPermissions()) {
                if (this.mergeFields) {
                    pdfReader.consolidateNamedDestinations();
                    pdfReader.shuffleSubsetNames();
                    for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                        PdfDictionary pageNRelease = pdfReader.getPageNRelease(i);
                        if (!(pageNRelease == null || !pageNRelease.contains(PdfName.ANNOTS) || (asArray = pageNRelease.getAsArray(PdfName.ANNOTS)) == null)) {
                            for (int i2 = 0; i2 < asArray.size(); i2++) {
                                PdfDictionary asDict = asArray.getAsDict(i2);
                                if (asDict != null) {
                                    PdfName pdfName = annotId;
                                    int i3 = annotIdCnt + 1;
                                    annotIdCnt = i3;
                                    asDict.put(pdfName, new PdfNumber(i3));
                                }
                            }
                        }
                    }
                    AcroFields acroFields = pdfReader.getAcroFields();
                    if (!acroFields.isGenerateAppearances()) {
                        this.needAppearances = true;
                    }
                    this.fields.add(acroFields);
                    updateCalculationOrder(pdfReader);
                }
                boolean z = this.tagged && PdfStructTreeController.checkTagged(pdfReader);
                this.mergeFieldsInternalCall = true;
                for (int i4 = 1; i4 <= pdfReader.getNumberOfPages(); i4++) {
                    addPage(getImportedPage(pdfReader, i4, z));
                }
                this.mergeFieldsInternalCall = false;
            } else {
                throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
            }
        } else {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) throws IOException {
        return addToBody(pdfObject, pdfIndirectReference, false);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        PdfIndirectObject pdfIndirectObject;
        PdfNumber asNumber;
        if (z) {
            updateReferences(pdfObject);
        }
        if ((this.tagged || this.mergeFields) && this.indirectObjects != null && (pdfObject.isArray() || pdfObject.isDictionary() || pdfObject.isStream() || pdfObject.isNull())) {
            RefKey refKey = new RefKey(pdfIndirectReference);
            pdfIndirectObject = this.indirectObjects.get(refKey);
            if (pdfIndirectObject == null) {
                pdfIndirectObject = new PdfIndirectObject(pdfIndirectReference, pdfObject, this);
                this.indirectObjects.put(refKey, pdfIndirectObject);
            }
        } else {
            pdfIndirectObject = super.addToBody(pdfObject, pdfIndirectReference);
        }
        if (this.mergeFields && pdfObject.isDictionary() && (asNumber = ((PdfDictionary) pdfObject).getAsNumber(annotId)) != null) {
            if (z) {
                this.mergedMap.put(Integer.valueOf(asNumber.intValue()), pdfIndirectObject);
                this.mergedSet.add(pdfIndirectObject);
            } else {
                this.unmergedMap.put(Integer.valueOf(asNumber.intValue()), pdfIndirectObject);
                this.unmergedIndirectRefsMap.put(new RefKey(pdfIndirectObject.number, pdfIndirectObject.generation), pdfIndirectObject);
            }
        }
        return pdfIndirectObject;
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public void cacheObject(PdfIndirectObject pdfIndirectObject) {
        if ((this.tagged || this.mergeFields) && this.indirectObjects != null) {
            this.savedObjects.add(pdfIndirectObject);
            RefKey refKey = new RefKey(pdfIndirectObject.number, pdfIndirectObject.generation);
            if (!this.indirectObjects.containsKey(refKey)) {
                this.indirectObjects.put(refKey, pdfIndirectObject);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public void flushTaggedObjects() throws IOException {
        try {
            fixTaggedStructure();
        } catch (ClassCastException unused) {
        } catch (Throwable th) {
            flushIndirectObjects();
            throw th;
        }
        flushIndirectObjects();
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public void flushAcroFields() throws IOException, BadPdfFormatException {
        PdfArray asArray;
        if (this.mergeFields) {
            try {
                Iterator<ImportedPage> it2 = this.importedPages.iterator();
                while (it2.hasNext()) {
                    ImportedPage next = it2.next();
                    PdfDictionary pageN = next.reader.getPageN(next.pageNumber);
                    if (!(pageN == null || (asArray = pageN.getAsArray(PdfName.ANNOTS)) == null)) {
                        if (asArray.size() != 0) {
                            for (AcroFields.Item item : next.reader.getAcroFields().getFields().values()) {
                                Iterator<PdfIndirectReference> it3 = item.widget_refs.iterator();
                                while (it3.hasNext()) {
                                    asArray.arrayList.remove(it3.next());
                                }
                            }
                            this.indirects = this.indirectMap.get(next.reader);
                            Iterator<PdfObject> it4 = asArray.arrayList.iterator();
                            while (it4.hasNext()) {
                                next.mergedFields.add(copyObject(it4.next()));
                            }
                        }
                    }
                }
                for (PdfReader pdfReader : this.indirectMap.keySet()) {
                    pdfReader.removeFields();
                }
                mergeFields();
                createAcroForms();
                if (this.tagged) {
                    return;
                }
            } catch (ClassCastException unused) {
                if (this.tagged) {
                    return;
                }
            } catch (Throwable th) {
                if (!this.tagged) {
                    flushIndirectObjects();
                }
                throw th;
            }
            flushIndirectObjects();
        }
    }

    /* access modifiers changed from: protected */
    public void fixTaggedStructure() throws IOException {
        PdfObject pdfObject;
        boolean z;
        PdfDictionary kDict;
        PdfIndirectReference pdfIndirectReference;
        HashMap<Integer, PdfIndirectReference> numTree = this.structureTreeRoot.getNumTree();
        HashSet<RefKey> hashSet = new HashSet<>();
        ArrayList<PdfIndirectReference> arrayList = new ArrayList<>();
        if (this.mergeFields && (pdfIndirectReference = this.acroForm) != null) {
            arrayList.add(pdfIndirectReference);
            hashSet.add(new RefKey(this.acroForm));
        }
        Iterator it2 = this.pageReferences.iterator();
        while (it2.hasNext()) {
            PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) it2.next();
            arrayList.add(pdfIndirectReference2);
            hashSet.add(new RefKey(pdfIndirectReference2));
        }
        int size = numTree.size() - 1;
        int i = 0;
        while (true) {
            Object obj = null;
            if (size < 0) {
                break;
            }
            PdfIndirectReference pdfIndirectReference3 = numTree.get(Integer.valueOf(size));
            if (pdfIndirectReference3 != null) {
                RefKey refKey = new RefKey(pdfIndirectReference3);
                PdfObject pdfObject2 = this.indirectObjects.get(refKey).object;
                if (pdfObject2.isDictionary()) {
                    PdfDictionary pdfDictionary = (PdfDictionary) pdfObject2;
                    if (!this.pageReferences.contains(pdfDictionary.get(PdfName.PG)) && ((kDict = PdfStructTreeController.getKDict(pdfDictionary)) == null || !this.pageReferences.contains(kDict.get(PdfName.PG)))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        hashSet.add(refKey);
                        arrayList.add(pdfIndirectReference3);
                    } else {
                        numTree.remove(Integer.valueOf(size));
                    }
                } else if (pdfObject2.isArray()) {
                    hashSet.add(refKey);
                    arrayList.add(pdfIndirectReference3);
                    PdfArray pdfArray = (PdfArray) pdfObject2;
                    int i2 = i + 1;
                    PdfIndirectReference pdfIndirectReference4 = (PdfIndirectReference) this.pageReferences.get(i);
                    arrayList.add(pdfIndirectReference4);
                    hashSet.add(new RefKey(pdfIndirectReference4));
                    for (int i3 = 0; i3 < pdfArray.size(); i3++) {
                        PdfIndirectReference pdfIndirectReference5 = (PdfIndirectReference) pdfArray.getDirectObject(i3);
                        if (!pdfIndirectReference5.equals(obj)) {
                            RefKey refKey2 = new RefKey(pdfIndirectReference5);
                            hashSet.add(refKey2);
                            arrayList.add(pdfIndirectReference5);
                            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(refKey2);
                            if (pdfIndirectObject.object.isDictionary()) {
                                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfIndirectObject.object;
                                PdfIndirectReference pdfIndirectReference6 = (PdfIndirectReference) pdfDictionary2.get(PdfName.PG);
                                if (pdfIndirectReference6 != null && !this.pageReferences.contains(pdfIndirectReference6) && !pdfIndirectReference6.equals(pdfIndirectReference4)) {
                                    pdfDictionary2.put(PdfName.PG, pdfIndirectReference4);
                                    PdfArray asArray = pdfDictionary2.getAsArray(PdfName.K);
                                    if (asArray != null && asArray.getDirectObject(0).isNumber()) {
                                        asArray.remove(0);
                                    }
                                }
                            }
                            obj = pdfIndirectReference5;
                        }
                    }
                    i = i2;
                }
            }
            size--;
        }
        HashSet<PdfName> hashSet2 = new HashSet<>();
        findActives(arrayList, hashSet, hashSet2);
        fixPgKey(findActiveParents(hashSet), hashSet);
        fixStructureTreeRoot(hashSet, hashSet2);
        for (Map.Entry<RefKey, PdfIndirectObject> entry : this.indirectObjects.entrySet()) {
            if (!hashSet.contains(entry.getKey())) {
                entry.setValue(null);
            } else if (entry.getValue().object.isArray()) {
                removeInactiveReferences((PdfArray) entry.getValue().object, hashSet);
            } else if (entry.getValue().object.isDictionary() && (pdfObject = ((PdfDictionary) entry.getValue().object).get(PdfName.K)) != null && pdfObject.isArray()) {
                removeInactiveReferences((PdfArray) pdfObject, hashSet);
            }
        }
    }

    private void removeInactiveReferences(PdfArray pdfArray, HashSet<RefKey> hashSet) {
        int i = 0;
        while (i < pdfArray.size()) {
            PdfObject pdfObject = pdfArray.getPdfObject(i);
            if ((pdfObject.type() == 0 && !hashSet.contains(new RefKey((PdfIndirectReference) pdfObject))) || (pdfObject.isDictionary() && containsInactivePg((PdfDictionary) pdfObject, hashSet))) {
                pdfArray.remove(i);
                i--;
            }
            i++;
        }
    }

    private boolean containsInactivePg(PdfDictionary pdfDictionary, HashSet<RefKey> hashSet) {
        PdfObject pdfObject = pdfDictionary.get(PdfName.PG);
        return pdfObject != null && !hashSet.contains(new RefKey((PdfIndirectReference) pdfObject));
    }

    private ArrayList<PdfIndirectReference> findActiveParents(HashSet<RefKey> hashSet) {
        PdfObject pdfObject;
        ArrayList<PdfIndirectReference> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList(hashSet);
        for (int i = 0; i < arrayList2.size(); i++) {
            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(arrayList2.get(i));
            if (pdfIndirectObject != null && pdfIndirectObject.object.isDictionary() && (pdfObject = ((PdfDictionary) pdfIndirectObject.object).get(PdfName.P)) != null && pdfObject.type() == 0) {
                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfObject;
                RefKey refKey = new RefKey(pdfIndirectReference);
                if (!hashSet.contains(refKey)) {
                    hashSet.add(refKey);
                    arrayList2.add(refKey);
                    arrayList.add(pdfIndirectReference);
                }
            }
        }
        return arrayList;
    }

    private void fixPgKey(ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet) {
        PdfDictionary pdfDictionary;
        PdfObject pdfObject;
        PdfArray asArray;
        PdfObject pdfObject2;
        Iterator<PdfIndirectReference> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(new RefKey(it2.next()));
            if (pdfIndirectObject != null && pdfIndirectObject.object.isDictionary() && (pdfObject = (pdfDictionary = (PdfDictionary) pdfIndirectObject.object).get(PdfName.PG)) != null && !hashSet.contains(new RefKey((PdfIndirectReference) pdfObject)) && (asArray = pdfDictionary.getAsArray(PdfName.K)) != null) {
                int i = 0;
                while (true) {
                    if (i >= asArray.size()) {
                        break;
                    }
                    PdfObject pdfObject3 = asArray.getPdfObject(i);
                    if (pdfObject3.type() == 0) {
                        PdfIndirectObject pdfIndirectObject2 = this.indirectObjects.get(new RefKey((PdfIndirectReference) pdfObject3));
                        if (pdfIndirectObject2 != null && pdfIndirectObject2.object.isDictionary() && (pdfObject2 = ((PdfDictionary) pdfIndirectObject2.object).get(PdfName.PG)) != null && hashSet.contains(new RefKey((PdfIndirectReference) pdfObject2))) {
                            pdfDictionary.put(PdfName.PG, pdfObject2);
                            break;
                        }
                    } else {
                        asArray.remove(i);
                        i--;
                    }
                    i++;
                }
            }
        }
    }

    private void findActives(ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        for (int i = 0; i < arrayList.size(); i++) {
            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(new RefKey(arrayList.get(i)));
            if (!(pdfIndirectObject == null || pdfIndirectObject.object == null)) {
                int type = pdfIndirectObject.object.type();
                if (type == 0) {
                    findActivesFromReference((PdfIndirectReference) pdfIndirectObject.object, arrayList, hashSet);
                } else if (type == 5) {
                    findActivesFromArray((PdfArray) pdfIndirectObject.object, arrayList, hashSet, hashSet2);
                } else if (type == 6 || type == 7) {
                    findActivesFromDict((PdfDictionary) pdfIndirectObject.object, arrayList, hashSet, hashSet2);
                }
            }
        }
    }

    private void findActivesFromReference(PdfIndirectReference pdfIndirectReference, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet) {
        RefKey refKey = new RefKey(pdfIndirectReference);
        PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(refKey);
        if ((pdfIndirectObject == null || !pdfIndirectObject.object.isDictionary() || !containsInactivePg((PdfDictionary) pdfIndirectObject.object, hashSet)) && !hashSet.contains(refKey)) {
            hashSet.add(refKey);
            arrayList.add(pdfIndirectReference);
        }
    }

    private void findActivesFromArray(PdfArray pdfArray, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        Iterator<PdfObject> it2 = pdfArray.iterator();
        while (it2.hasNext()) {
            PdfObject next = it2.next();
            int type = next.type();
            if (type == 0) {
                findActivesFromReference((PdfIndirectReference) next, arrayList, hashSet);
            } else if (type == 5) {
                findActivesFromArray((PdfArray) next, arrayList, hashSet, hashSet2);
            } else if (type == 6 || type == 7) {
                findActivesFromDict((PdfDictionary) next, arrayList, hashSet, hashSet2);
            }
        }
    }

    private void findActivesFromDict(PdfDictionary pdfDictionary, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        if (!containsInactivePg(pdfDictionary, hashSet)) {
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject = pdfDictionary.get(pdfName);
                if (!pdfName.equals(PdfName.P)) {
                    if (!pdfName.equals(PdfName.C)) {
                        int type = pdfObject.type();
                        if (type == 0) {
                            findActivesFromReference((PdfIndirectReference) pdfObject, arrayList, hashSet);
                        } else if (type == 5) {
                            findActivesFromArray((PdfArray) pdfObject, arrayList, hashSet, hashSet2);
                        } else if (type == 6 || type == 7) {
                            findActivesFromDict((PdfDictionary) pdfObject, arrayList, hashSet, hashSet2);
                        }
                    } else if (pdfObject.isArray()) {
                        Iterator<PdfObject> it2 = ((PdfArray) pdfObject).iterator();
                        while (it2.hasNext()) {
                            PdfObject next = it2.next();
                            if (next.isName()) {
                                hashSet2.add((PdfName) next);
                            }
                        }
                    } else if (pdfObject.isName()) {
                        hashSet2.add((PdfName) pdfObject);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void flushIndirectObjects() throws IOException {
        Iterator<PdfIndirectObject> it2 = this.savedObjects.iterator();
        while (it2.hasNext()) {
            PdfIndirectObject next = it2.next();
            this.indirectObjects.remove(new RefKey(next.number, next.generation));
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry<RefKey, PdfIndirectObject> entry : this.indirectObjects.entrySet()) {
            if (entry.getValue() != null) {
                writeObjectToBody(entry.getValue());
            } else {
                hashSet.add(entry.getKey());
            }
        }
        Iterator it3 = new ArrayList(this.body.xrefs).iterator();
        while (it3.hasNext()) {
            PdfWriter.PdfBody.PdfCrossReference pdfCrossReference = (PdfWriter.PdfBody.PdfCrossReference) it3.next();
            if (hashSet.contains(new RefKey(pdfCrossReference.getRefnum(), 0))) {
                this.body.xrefs.remove(pdfCrossReference);
            }
        }
        this.indirectObjects = null;
    }

    private void writeObjectToBody(PdfIndirectObject pdfIndirectObject) throws IOException {
        PdfDictionary pdfDictionary;
        PdfNumber asNumber;
        PdfIndirectObject pdfIndirectObject2;
        PdfNumber asNumber2;
        PdfNumber asNumber3;
        boolean z = false;
        if (this.mergeFields) {
            updateAnnotationReferences(pdfIndirectObject.object);
            if (pdfIndirectObject.object.isDictionary() || pdfIndirectObject.object.isStream()) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfIndirectObject.object;
                if (this.unmergedIndirectRefsMap.containsKey(new RefKey(pdfIndirectObject.number, pdfIndirectObject.generation)) && (asNumber3 = pdfDictionary2.getAsNumber(annotId)) != null && this.mergedMap.containsKey(Integer.valueOf(asNumber3.intValue()))) {
                    z = true;
                }
                if (!(!this.mergedSet.contains(pdfIndirectObject) || (asNumber = pdfDictionary2.getAsNumber(annotId)) == null || (pdfIndirectObject2 = this.unmergedMap.get(Integer.valueOf(asNumber.intValue()))) == null || !pdfIndirectObject2.object.isDictionary() || (asNumber2 = ((PdfDictionary) pdfIndirectObject2.object).getAsNumber(PdfName.STRUCTPARENT)) == null)) {
                    pdfDictionary2.put(PdfName.STRUCTPARENT, asNumber2);
                }
            }
        }
        if (!z) {
            PdfNumber pdfNumber = null;
            if (!this.mergeFields || !pdfIndirectObject.object.isDictionary()) {
                pdfDictionary = null;
            } else {
                PdfDictionary pdfDictionary3 = (PdfDictionary) pdfIndirectObject.object;
                PdfNumber asNumber4 = pdfDictionary3.getAsNumber(annotId);
                if (asNumber4 != null) {
                    pdfDictionary3.remove(annotId);
                }
                pdfNumber = asNumber4;
                pdfDictionary = pdfDictionary3;
            }
            this.body.add(pdfIndirectObject.object, pdfIndirectObject.number, pdfIndirectObject.generation, true);
            if (pdfNumber != null) {
                pdfDictionary.put(annotId, pdfNumber);
            }
        }
    }

    private void updateAnnotationReferences(PdfObject pdfObject) {
        PdfNumber asNumber;
        PdfIndirectObject pdfIndirectObject;
        PdfNumber asNumber2;
        PdfIndirectObject pdfIndirectObject2;
        if (pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i = 0; i < pdfArray.size(); i++) {
                PdfObject pdfObject2 = pdfArray.getPdfObject(i);
                if (pdfObject2 == null || pdfObject2.type() != 0) {
                    updateAnnotationReferences(pdfObject2);
                } else {
                    PdfIndirectObject pdfIndirectObject3 = this.unmergedIndirectRefsMap.get(new RefKey((PdfIndirectReference) pdfObject2));
                    if (!(pdfIndirectObject3 == null || !pdfIndirectObject3.object.isDictionary() || (asNumber2 = ((PdfDictionary) pdfIndirectObject3.object).getAsNumber(annotId)) == null || (pdfIndirectObject2 = this.mergedMap.get(Integer.valueOf(asNumber2.intValue()))) == null)) {
                        pdfArray.set(i, pdfIndirectObject2.getIndirectReference());
                    }
                }
            }
        } else if (pdfObject.isDictionary() || pdfObject.isStream()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject3 = pdfDictionary.get(pdfName);
                if (pdfObject3 == null || pdfObject3.type() != 0) {
                    updateAnnotationReferences(pdfObject3);
                } else {
                    PdfIndirectObject pdfIndirectObject4 = this.unmergedIndirectRefsMap.get(new RefKey((PdfIndirectReference) pdfObject3));
                    if (!(pdfIndirectObject4 == null || !pdfIndirectObject4.object.isDictionary() || (asNumber = ((PdfDictionary) pdfIndirectObject4.object).getAsNumber(annotId)) == null || (pdfIndirectObject = this.mergedMap.get(Integer.valueOf(asNumber.intValue()))) == null)) {
                        pdfDictionary.put(pdfName, pdfIndirectObject.getIndirectReference());
                    }
                }
            }
        }
    }

    private void updateCalculationOrder(PdfReader pdfReader) {
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
        return str.endsWith(".") ? str.substring(0, str.length() - 2) : str;
    }

    private void mergeFields() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.size(); i2++) {
            AcroFields acroFields = this.fields.get(i2);
            Map<String, AcroFields.Item> fields2 = acroFields.getFields();
            if (i < this.importedPages.size() && this.importedPages.get(i).reader == acroFields.reader) {
                addPageOffsetToField(fields2, i);
                i += acroFields.reader.getNumberOfPages();
            }
            mergeWithMaster(fields2);
        }
    }

    private void addPageOffsetToField(Map<String, AcroFields.Item> map, int i) {
        if (i != 0) {
            for (AcroFields.Item item : map.values()) {
                for (int i2 = 0; i2 < item.size(); i2++) {
                    item.forcePage(i2, item.getPage(i2).intValue() + i);
                }
            }
        }
    }

    private void mergeWithMaster(Map<String, AcroFields.Item> map) {
        for (Map.Entry<String, AcroFields.Item> entry : map.entrySet()) {
            mergeField(entry.getKey(), entry.getValue());
        }
    }

    private void mergeField(String str, AcroFields.Item item) {
        HashMap<String, Object> hashMap = this.fieldTree;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (stringTokenizer.hasMoreTokens()) {
            while (true) {
                String nextToken = stringTokenizer.nextToken();
                Object obj = hashMap.get(nextToken);
                if (stringTokenizer.hasMoreTokens()) {
                    if (obj == null) {
                        HashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                        hashMap.put(nextToken, linkedHashMap);
                        hashMap = linkedHashMap;
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
                            if (fieldKeys.contains(pdfName)) {
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

    private void createWidgets(ArrayList<Object> arrayList, AcroFields.Item item) {
        for (int i = 0; i < item.size(); i++) {
            arrayList.add(item.getPage(i));
            PdfDictionary merged = item.getMerged(i);
            PdfObject pdfObject = merged.get(PdfName.DR);
            if (pdfObject != null) {
                PdfFormField.mergeResources(this.resources, (PdfDictionary) PdfReader.getPdfObject(pdfObject));
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            for (PdfName pdfName : merged.getKeys()) {
                if (widgetKeys.contains(pdfName)) {
                    pdfDictionary.put(pdfName, merged.get(pdfName));
                }
            }
            pdfDictionary.put(iTextTag, new PdfNumber(item.getTabOrder(i).intValue() + 1));
            arrayList.add(pdfDictionary);
        }
    }

    private PdfObject propagate(PdfObject pdfObject) throws IOException {
        if (pdfObject == null) {
            return new PdfNull();
        }
        if (pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i = 0; i < pdfArray.size(); i++) {
                pdfArray.set(i, propagate(pdfArray.getPdfObject(i)));
            }
            return pdfArray;
        } else if (!pdfObject.isDictionary() && !pdfObject.isStream()) {
            return pdfObject.isIndirect() ? addToBody(propagate(PdfReader.getPdfObject(pdfObject))).getIndirectReference() : pdfObject;
        } else {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                pdfDictionary.put(pdfName, propagate(pdfDictionary.get(pdfName)));
            }
            return pdfDictionary;
        }
    }

    private void createAcroForms() throws IOException, BadPdfFormatException {
        if (this.fieldTree.isEmpty()) {
            Iterator<ImportedPage> it2 = this.importedPages.iterator();
            while (it2.hasNext()) {
                ImportedPage next = it2.next();
                if (next.mergedFields.size() > 0) {
                    addToBody(next.mergedFields, next.annotsIndirectReference);
                }
            }
            return;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.DR, propagate(this.resources));
        if (this.needAppearances) {
            pdfDictionary.put(PdfName.NEEDAPPEARANCES, PdfBoolean.PDFTRUE);
        }
        pdfDictionary.put(PdfName.DA, new PdfString("/Helv 0 Tf 0 g "));
        this.tabOrder = new HashMap<>();
        this.calculationOrderRefs = new ArrayList<>(this.calculationOrder);
        pdfDictionary.put(PdfName.FIELDS, branchForm(this.fieldTree, null, ""));
        if (this.hasSignature) {
            pdfDictionary.put(PdfName.SIGFLAGS, new PdfNumber(3));
        }
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < this.calculationOrderRefs.size(); i++) {
            Object obj = this.calculationOrderRefs.get(i);
            if (obj instanceof PdfIndirectReference) {
                pdfArray.add((PdfIndirectReference) obj);
            }
        }
        if (pdfArray.size() > 0) {
            pdfDictionary.put(PdfName.CO, pdfArray);
        }
        this.acroForm = addToBody(pdfDictionary).getIndirectReference();
        Iterator<ImportedPage> it3 = this.importedPages.iterator();
        while (it3.hasNext()) {
            ImportedPage next2 = it3.next();
            addToBody(next2.mergedFields, next2.annotsIndirectReference);
        }
    }

    private void updateReferences(PdfObject pdfObject) {
        if (pdfObject.isDictionary() || pdfObject.isStream()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject2 = pdfDictionary.get(pdfName);
                if (pdfObject2.isIndirect()) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject2;
                    IndirectReferences indirectReferences = this.indirectMap.get(pRIndirectReference.getReader()).get(new RefKey(pRIndirectReference));
                    if (indirectReferences != null) {
                        pdfDictionary.put(pdfName, indirectReferences.getRef());
                    }
                } else {
                    updateReferences(pdfObject2);
                }
            }
        } else if (pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i = 0; i < pdfArray.size(); i++) {
                PdfObject pdfObject3 = pdfArray.getPdfObject(i);
                if (pdfObject3.isIndirect()) {
                    PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfObject3;
                    IndirectReferences indirectReferences2 = this.indirectMap.get(pRIndirectReference2.getReader()).get(new RefKey(pRIndirectReference2));
                    if (indirectReferences2 != null) {
                        pdfArray.set(i, indirectReferences2.getRef());
                    }
                } else {
                    updateReferences(pdfObject3);
                }
            }
        }
    }

    private PdfArray branchForm(HashMap<String, Object> hashMap, PdfIndirectReference pdfIndirectReference, String str) throws IOException, BadPdfFormatException {
        Iterator<Map.Entry<String, Object>> it2;
        boolean z;
        Iterator<Map.Entry<String, Object>> it3;
        PdfIndirectReference pdfIndirectReference2 = pdfIndirectReference;
        PdfArray pdfArray = new PdfArray();
        Iterator<Map.Entry<String, Object>> it4 = hashMap.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry<String, Object> next = it4.next();
            String key = next.getKey();
            Object value = next.getValue();
            PdfIndirectReference pdfIndirectReference3 = getPdfIndirectReference();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfIndirectReference2 != null) {
                pdfDictionary.put(PdfName.PARENT, pdfIndirectReference2);
            }
            pdfDictionary.put(PdfName.T, new PdfString(key, PdfObject.TEXT_UNICODE));
            String str2 = str + "." + key;
            int indexOf = this.calculationOrder.indexOf(str2);
            if (indexOf >= 0) {
                this.calculationOrderRefs.set(indexOf, pdfIndirectReference3);
            }
            int i = 1;
            if (value instanceof HashMap) {
                pdfDictionary.put(PdfName.KIDS, branchForm((HashMap) value, pdfIndirectReference3, str2));
                pdfArray.add(pdfIndirectReference3);
                addToBody((PdfObject) pdfDictionary, pdfIndirectReference3, true);
                it2 = it4;
            } else {
                ArrayList arrayList = (ArrayList) value;
                pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(0));
                if (arrayList.size() == 3) {
                    pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(2));
                    int intValue = ((Integer) arrayList.get(1)).intValue();
                    pdfDictionary.remove(iTextTag);
                    pdfDictionary.put(PdfName.TYPE, PdfName.ANNOT);
                    adjustTabOrder(this.importedPages.get(intValue - 1).mergedFields, pdfIndirectReference3, (PdfNumber) pdfDictionary.get(iTextTag));
                    it2 = it4;
                    z = true;
                } else {
                    PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList.get(0);
                    PdfArray pdfArray2 = new PdfArray();
                    int i2 = 1;
                    while (i2 < arrayList.size()) {
                        PdfArray pdfArray3 = this.importedPages.get(((Integer) arrayList.get(i2)).intValue() - i).mergedFields;
                        PdfDictionary pdfDictionary3 = new PdfDictionary();
                        pdfDictionary3.merge((PdfDictionary) arrayList.get(i2 + 1));
                        pdfDictionary3.put(PdfName.PARENT, pdfIndirectReference3);
                        PdfNumber pdfNumber = (PdfNumber) pdfDictionary3.get(iTextTag);
                        pdfDictionary3.remove(iTextTag);
                        if (isTextField(pdfDictionary2)) {
                            PdfString asString = pdfDictionary2.getAsString(PdfName.V);
                            PdfObject directObject = pdfDictionary3.getDirectObject(PdfName.AP);
                            if (!(asString == null || directObject == null)) {
                                if (!this.mergedTextFields.containsKey(arrayList)) {
                                    this.mergedTextFields.put(arrayList, asString);
                                } else {
                                    try {
                                        TextField textField = new TextField(this, null, null);
                                        it3 = it4;
                                        try {
                                            this.fields.get(0).decodeGenericDictionary(pdfDictionary3, textField);
                                            Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary3.getAsArray(PdfName.RECT));
                                            if (textField.getRotation() == 90 || textField.getRotation() == 270) {
                                                normalizedRectangle = normalizedRectangle.rotate();
                                            }
                                            textField.setBox(normalizedRectangle);
                                            textField.setText(this.mergedTextFields.get(arrayList).toUnicodeString());
                                            ((PdfDictionary) directObject).put(PdfName.N, textField.getAppearance().getIndirectReference());
                                        } catch (DocumentException unused) {
                                        }
                                    } catch (DocumentException unused2) {
                                    }
                                }
                            }
                            it3 = it4;
                        } else {
                            it3 = it4;
                            if (isCheckButton(pdfDictionary2)) {
                                PdfObject asName = pdfDictionary2.getAsName(PdfName.V);
                                PdfName asName2 = pdfDictionary3.getAsName(PdfName.AS);
                                if (!(asName == null || asName2 == null)) {
                                    pdfDictionary3.put(PdfName.AS, asName);
                                }
                            } else if (isRadioButton(pdfDictionary2)) {
                                PdfObject asName3 = pdfDictionary2.getAsName(PdfName.V);
                                PdfName asName4 = pdfDictionary3.getAsName(PdfName.AS);
                                if (!(asName3 == null || asName4 == null || asName4.equals(getOffStateName(pdfDictionary3)))) {
                                    if (!this.mergedRadioButtons.contains(arrayList)) {
                                        this.mergedRadioButtons.add(arrayList);
                                        pdfDictionary3.put(PdfName.AS, asName3);
                                    } else {
                                        pdfDictionary3.put(PdfName.AS, getOffStateName(pdfDictionary3));
                                    }
                                }
                            }
                        }
                        pdfDictionary3.put(PdfName.TYPE, PdfName.ANNOT);
                        PdfIndirectReference indirectReference = addToBody((PdfObject) pdfDictionary3, getPdfIndirectReference(), true).getIndirectReference();
                        adjustTabOrder(pdfArray3, indirectReference, pdfNumber);
                        pdfArray2.add(indirectReference);
                        i2 += 2;
                        it4 = it3;
                        i = 1;
                    }
                    it2 = it4;
                    z = true;
                    pdfDictionary.put(PdfName.KIDS, pdfArray2);
                }
                pdfArray.add(pdfIndirectReference3);
                addToBody(pdfDictionary, pdfIndirectReference3, z);
            }
            pdfIndirectReference2 = pdfIndirectReference;
            it4 = it2;
        }
        return pdfArray;
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
    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        try {
            PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
            buildStructTreeRootForTagged(catalog);
            if (this.fieldArray != null) {
                addFieldResources(catalog);
            } else if (this.mergeFields && this.acroForm != null) {
                catalog.put(PdfName.ACROFORM, this.acroForm);
            }
            return catalog;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isStructTreeRootReference(PdfIndirectReference pdfIndirectReference) {
        if (pdfIndirectReference == null || this.structTreeRootReference == null || pdfIndirectReference.number != this.structTreeRootReference.number || pdfIndirectReference.generation != this.structTreeRootReference.generation) {
            return false;
        }
        return true;
    }

    private void addFieldResources(PdfDictionary pdfDictionary) throws IOException {
        if (this.fieldArray != null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary.put(PdfName.ACROFORM, pdfDictionary2);
            pdfDictionary2.put(PdfName.FIELDS, this.fieldArray);
            pdfDictionary2.put(PdfName.DA, new PdfString("/Helv 0 Tf 0 g "));
            if (!this.fieldTemplates.isEmpty()) {
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                pdfDictionary2.put(PdfName.DR, pdfDictionary3);
                Iterator<PdfTemplate> it2 = this.fieldTemplates.iterator();
                while (it2.hasNext()) {
                    PdfFormField.mergeResources(pdfDictionary3, (PdfDictionary) it2.next().getResources());
                }
                PdfDictionary asDict = pdfDictionary3.getAsDict(PdfName.FONT);
                if (asDict == null) {
                    asDict = new PdfDictionary();
                    pdfDictionary3.put(PdfName.FONT, asDict);
                }
                if (!asDict.contains(PdfName.HELV)) {
                    PdfDictionary pdfDictionary4 = new PdfDictionary(PdfName.FONT);
                    pdfDictionary4.put(PdfName.BASEFONT, PdfName.HELVETICA);
                    pdfDictionary4.put(PdfName.ENCODING, PdfName.WIN_ANSI_ENCODING);
                    pdfDictionary4.put(PdfName.NAME, PdfName.HELV);
                    pdfDictionary4.put(PdfName.SUBTYPE, PdfName.TYPE1);
                    asDict.put(PdfName.HELV, addToBody(pdfDictionary4).getIndirectReference());
                }
                if (!asDict.contains(PdfName.ZADB)) {
                    PdfDictionary pdfDictionary5 = new PdfDictionary(PdfName.FONT);
                    pdfDictionary5.put(PdfName.BASEFONT, PdfName.ZAPFDINGBATS);
                    pdfDictionary5.put(PdfName.NAME, PdfName.ZADB);
                    pdfDictionary5.put(PdfName.SUBTYPE, PdfName.TYPE1);
                    asDict.put(PdfName.ZADB, addToBody(pdfDictionary5).getIndirectReference());
                }
            }
        }
    }

    @Override // com.itextpdf.text.DocListener, com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.DocWriter
    public void close() {
        if (this.open) {
            this.pdf.close();
            super.close();
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void freeReader(PdfReader pdfReader) throws IOException {
        if (!this.mergeFields) {
            PdfArray asArray = pdfReader.trailer.getAsArray(PdfName.ID);
            if (asArray != null) {
                this.originalFileID = asArray.getAsString(0).getBytes();
            }
            this.indirectMap.remove(pdfReader);
            this.currentPdfReaderInstance = null;
            super.freeReader(pdfReader);
            return;
        }
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("it.is.not.possible.to.free.reader.in.merge.fields.mode", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public PdfName getOffStateName(PdfDictionary pdfDictionary) {
        return PdfName.Off;
    }

    static Integer getFlags(PdfDictionary pdfDictionary) {
        PdfNumber asNumber;
        if (PdfName.BTN.equals(pdfDictionary.getAsName(PdfName.FT)) && (asNumber = pdfDictionary.getAsNumber(PdfName.FF)) != null) {
            return Integer.valueOf(asNumber.intValue());
        }
        return null;
    }

    static boolean isCheckButton(PdfDictionary pdfDictionary) {
        Integer flags = getFlags(pdfDictionary);
        return flags == null || ((flags.intValue() & 65536) == 0 && (flags.intValue() & 32768) == 0);
    }

    static boolean isRadioButton(PdfDictionary pdfDictionary) {
        Integer flags = getFlags(pdfDictionary);
        return (flags == null || (flags.intValue() & 65536) != 0 || (flags.intValue() & 32768) == 0) ? false : true;
    }

    static boolean isTextField(PdfDictionary pdfDictionary) {
        return PdfName.TX.equals(pdfDictionary.getAsName(PdfName.FT));
    }

    public PageStamp createPageStamp(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReader reader2 = pdfImportedPage.getPdfReaderInstance().getReader();
        if (!isTagged()) {
            return new PageStamp(reader2, reader2.getPageN(pageNumber), this);
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("creating.page.stamp.not.allowed.for.tagged.reader", new Object[0]));
    }

    public static class PageStamp {
        PdfCopy cstp;
        StampContent over;
        PdfDictionary pageN;
        PageResources pageResources;
        PdfReader reader;
        StampContent under;

        PageStamp(PdfReader pdfReader, PdfDictionary pdfDictionary, PdfCopy pdfCopy) {
            this.pageN = pdfDictionary;
            this.reader = pdfReader;
            this.cstp = pdfCopy;
        }

        public PdfContentByte getUnderContent() {
            if (this.under == null) {
                if (this.pageResources == null) {
                    this.pageResources = new PageResources();
                    this.pageResources.setOriginalResources(this.pageN.getAsDict(PdfName.RESOURCES), this.cstp.namePtr);
                }
                this.under = new StampContent(this.cstp, this.pageResources);
            }
            return this.under;
        }

        public PdfContentByte getOverContent() {
            if (this.over == null) {
                if (this.pageResources == null) {
                    this.pageResources = new PageResources();
                    this.pageResources.setOriginalResources(this.pageN.getAsDict(PdfName.RESOURCES), this.cstp.namePtr);
                }
                this.over = new StampContent(this.cstp, this.pageResources);
            }
            return this.over;
        }

        public void alterContents() throws IOException {
            PdfArray pdfArray;
            if (this.over != null || this.under != null) {
                PdfObject pdfObject = PdfReader.getPdfObject(this.pageN.get(PdfName.CONTENTS), this.pageN);
                if (pdfObject == null) {
                    pdfArray = new PdfArray();
                    this.pageN.put(PdfName.CONTENTS, pdfArray);
                } else if (pdfObject.isArray()) {
                    pdfArray = (PdfArray) pdfObject;
                } else if (pdfObject.isStream()) {
                    pdfArray = new PdfArray();
                    pdfArray.add(this.pageN.get(PdfName.CONTENTS));
                    this.pageN.put(PdfName.CONTENTS, pdfArray);
                } else {
                    pdfArray = new PdfArray();
                    this.pageN.put(PdfName.CONTENTS, pdfArray);
                }
                ByteBuffer byteBuffer = new ByteBuffer();
                if (this.under != null) {
                    byteBuffer.append(PdfContents.SAVESTATE);
                    applyRotation(this.pageN, byteBuffer);
                    byteBuffer.append(this.under.getInternalBuffer());
                    byteBuffer.append(PdfContents.RESTORESTATE);
                }
                if (this.over != null) {
                    byteBuffer.append(PdfContents.SAVESTATE);
                }
                PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
                pdfStream.flateCompress(this.cstp.getCompressionLevel());
                pdfArray.addFirst(this.cstp.addToBody(pdfStream).getIndirectReference());
                byteBuffer.reset();
                if (this.over != null) {
                    byteBuffer.append(' ');
                    byteBuffer.append(PdfContents.RESTORESTATE);
                    byteBuffer.append(PdfContents.SAVESTATE);
                    applyRotation(this.pageN, byteBuffer);
                    byteBuffer.append(this.over.getInternalBuffer());
                    byteBuffer.append(PdfContents.RESTORESTATE);
                    PdfStream pdfStream2 = new PdfStream(byteBuffer.toByteArray());
                    pdfStream2.flateCompress(this.cstp.getCompressionLevel());
                    pdfArray.add(this.cstp.addToBody(pdfStream2).getIndirectReference());
                }
                this.pageN.put(PdfName.RESOURCES, this.pageResources.getResources());
            }
        }

        /* access modifiers changed from: package-private */
        public void applyRotation(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
            if (this.cstp.rotateContents) {
                Rectangle pageSizeWithRotation = this.reader.getPageSizeWithRotation(pdfDictionary);
                int rotation = pageSizeWithRotation.getRotation();
                if (rotation == 90) {
                    byteBuffer.append(PdfContents.ROTATE90);
                    byteBuffer.append(pageSizeWithRotation.getTop());
                    byteBuffer.append(' ').append('0').append(PdfContents.ROTATEFINAL);
                } else if (rotation == 180) {
                    byteBuffer.append(PdfContents.ROTATE180);
                    byteBuffer.append(pageSizeWithRotation.getRight());
                    byteBuffer.append(' ');
                    byteBuffer.append(pageSizeWithRotation.getTop());
                    byteBuffer.append(PdfContents.ROTATEFINAL);
                } else if (rotation == 270) {
                    byteBuffer.append(PdfContents.ROTATE270);
                    byteBuffer.append('0').append(' ');
                    byteBuffer.append(pageSizeWithRotation.getRight());
                    byteBuffer.append(PdfContents.ROTATEFINAL);
                }
            }
        }

        private void addDocumentField(PdfIndirectReference pdfIndirectReference) {
            if (this.cstp.fieldArray == null) {
                this.cstp.fieldArray = new PdfArray();
            }
            this.cstp.fieldArray.add(pdfIndirectReference);
        }

        private void expandFields(PdfFormField pdfFormField, ArrayList<PdfAnnotation> arrayList) {
            arrayList.add(pdfFormField);
            ArrayList<PdfFormField> kids = pdfFormField.getKids();
            if (kids != null) {
                Iterator<PdfFormField> it2 = kids.iterator();
                while (it2.hasNext()) {
                    expandFields(it2.next(), arrayList);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:46:0x00d8 A[Catch:{ IOException -> 0x0170 }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0135 A[Catch:{ IOException -> 0x0170 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void addAnnotation(com.itextpdf.text.pdf.PdfAnnotation r11) {
            /*
                r10 = this;
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ IOException -> 0x0170 }
                r0.<init>()     // Catch:{ IOException -> 0x0170 }
                boolean r1 = r11.isForm()     // Catch:{ IOException -> 0x0170 }
                if (r1 == 0) goto L_0x0027
                com.itextpdf.text.pdf.PdfFormField r11 = (com.itextpdf.text.pdf.PdfFormField) r11     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfFormField r1 = r11.getParent()     // Catch:{ IOException -> 0x0170 }
                if (r1 == 0) goto L_0x0014
                return
            L_0x0014:
                r10.expandFields(r11, r0)     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfCopy r11 = r10.cstp     // Catch:{ IOException -> 0x0170 }
                java.util.HashSet<com.itextpdf.text.pdf.PdfTemplate> r11 = r11.fieldTemplates     // Catch:{ IOException -> 0x0170 }
                if (r11 != 0) goto L_0x002a
                com.itextpdf.text.pdf.PdfCopy r11 = r10.cstp     // Catch:{ IOException -> 0x0170 }
                java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IOException -> 0x0170 }
                r1.<init>()     // Catch:{ IOException -> 0x0170 }
                r11.fieldTemplates = r1     // Catch:{ IOException -> 0x0170 }
                goto L_0x002a
            L_0x0027:
                r0.add(r11)     // Catch:{ IOException -> 0x0170 }
            L_0x002a:
                r11 = 0
            L_0x002b:
                int r1 = r0.size()     // Catch:{ IOException -> 0x0170 }
                if (r11 >= r1) goto L_0x016f
                java.lang.Object r1 = r0.get(r11)     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfAnnotation r1 = (com.itextpdf.text.pdf.PdfAnnotation) r1     // Catch:{ IOException -> 0x0170 }
                boolean r2 = r1.isForm()     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x0060
                boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x0170 }
                if (r2 != 0) goto L_0x0050
                java.util.HashSet r2 = r1.getTemplates()     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x0050
                com.itextpdf.text.pdf.PdfCopy r3 = r10.cstp     // Catch:{ IOException -> 0x0170 }
                java.util.HashSet<com.itextpdf.text.pdf.PdfTemplate> r3 = r3.fieldTemplates     // Catch:{ IOException -> 0x0170 }
                r3.addAll(r2)     // Catch:{ IOException -> 0x0170 }
            L_0x0050:
                r2 = r1
                com.itextpdf.text.pdf.PdfFormField r2 = (com.itextpdf.text.pdf.PdfFormField) r2     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfFormField r3 = r2.getParent()     // Catch:{ IOException -> 0x0170 }
                if (r3 != 0) goto L_0x0060
                com.itextpdf.text.pdf.PdfIndirectReference r2 = r2.getIndirectReference()     // Catch:{ IOException -> 0x0170 }
                r10.addDocumentField(r2)     // Catch:{ IOException -> 0x0170 }
            L_0x0060:
                boolean r2 = r1.isAnnotation()     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x0159
                com.itextpdf.text.pdf.PdfDictionary r2 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.ANNOTS     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfObject r2 = r2.get(r3)     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfDictionary r3 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfObject r2 = com.itextpdf.text.pdf.PdfReader.getPdfObject(r2, r3)     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x0080
                boolean r3 = r2.isArray()     // Catch:{ IOException -> 0x0170 }
                if (r3 != 0) goto L_0x007d
                goto L_0x0080
            L_0x007d:
                com.itextpdf.text.pdf.PdfArray r2 = (com.itextpdf.text.pdf.PdfArray) r2     // Catch:{ IOException -> 0x0170 }
                goto L_0x008c
            L_0x0080:
                com.itextpdf.text.pdf.PdfArray r2 = new com.itextpdf.text.pdf.PdfArray     // Catch:{ IOException -> 0x0170 }
                r2.<init>()     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfDictionary r3 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.ANNOTS     // Catch:{ IOException -> 0x0170 }
                r3.put(r4, r2)     // Catch:{ IOException -> 0x0170 }
            L_0x008c:
                com.itextpdf.text.pdf.PdfIndirectReference r3 = r1.getIndirectReference()     // Catch:{ IOException -> 0x0170 }
                r2.add(r3)     // Catch:{ IOException -> 0x0170 }
                boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x0170 }
                if (r2 != 0) goto L_0x0159
                com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfObject r2 = r1.get(r2)     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfRectangle r2 = (com.itextpdf.text.pdf.PdfRectangle) r2     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x0159
                float r3 = r2.left()     // Catch:{ IOException -> 0x0170 }
                r4 = 0
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 != 0) goto L_0x00c4
                float r3 = r2.right()     // Catch:{ IOException -> 0x0170 }
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 != 0) goto L_0x00c4
                float r3 = r2.top()     // Catch:{ IOException -> 0x0170 }
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 != 0) goto L_0x00c4
                float r3 = r2.bottom()     // Catch:{ IOException -> 0x0170 }
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 == 0) goto L_0x0159
            L_0x00c4:
                com.itextpdf.text.pdf.PdfReader r3 = r10.reader     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfDictionary r4 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                int r3 = r3.getPageRotation(r4)     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfReader r4 = r10.reader     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfDictionary r5 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.Rectangle r4 = r4.getPageSizeWithRotation(r5)     // Catch:{ IOException -> 0x0170 }
                r5 = 90
                if (r3 == r5) goto L_0x0135
                r5 = 180(0xb4, float:2.52E-43)
                if (r3 == r5) goto L_0x0106
                r5 = 270(0x10e, float:3.78E-43)
                if (r3 == r5) goto L_0x00e1
                goto L_0x0159
            L_0x00e1:
                com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfRectangle r5 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0170 }
                float r6 = r2.bottom()     // Catch:{ IOException -> 0x0170 }
                float r7 = r4.getRight()     // Catch:{ IOException -> 0x0170 }
                float r8 = r2.left()     // Catch:{ IOException -> 0x0170 }
                float r7 = r7 - r8
                float r8 = r2.top()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4.getRight()     // Catch:{ IOException -> 0x0170 }
                float r2 = r2.right()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4 - r2
                r5.<init>(r6, r7, r8, r4)     // Catch:{ IOException -> 0x0170 }
                r1.put(r3, r5)     // Catch:{ IOException -> 0x0170 }
                goto L_0x0159
            L_0x0106:
                com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfRectangle r5 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0170 }
                float r6 = r4.getRight()     // Catch:{ IOException -> 0x0170 }
                float r7 = r2.left()     // Catch:{ IOException -> 0x0170 }
                float r6 = r6 - r7
                float r7 = r4.getTop()     // Catch:{ IOException -> 0x0170 }
                float r8 = r2.bottom()     // Catch:{ IOException -> 0x0170 }
                float r7 = r7 - r8
                float r8 = r4.getRight()     // Catch:{ IOException -> 0x0170 }
                float r9 = r2.right()     // Catch:{ IOException -> 0x0170 }
                float r8 = r8 - r9
                float r4 = r4.getTop()     // Catch:{ IOException -> 0x0170 }
                float r2 = r2.top()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4 - r2
                r5.<init>(r6, r7, r8, r4)     // Catch:{ IOException -> 0x0170 }
                r1.put(r3, r5)     // Catch:{ IOException -> 0x0170 }
                goto L_0x0159
            L_0x0135:
                com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfRectangle r5 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0170 }
                float r6 = r4.getTop()     // Catch:{ IOException -> 0x0170 }
                float r7 = r2.bottom()     // Catch:{ IOException -> 0x0170 }
                float r6 = r6 - r7
                float r7 = r2.left()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4.getTop()     // Catch:{ IOException -> 0x0170 }
                float r8 = r2.top()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4 - r8
                float r2 = r2.right()     // Catch:{ IOException -> 0x0170 }
                r5.<init>(r6, r7, r4, r2)     // Catch:{ IOException -> 0x0170 }
                r1.put(r3, r5)     // Catch:{ IOException -> 0x0170 }
            L_0x0159:
                boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x0170 }
                if (r2 != 0) goto L_0x016b
                r1.setUsed()     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfCopy r2 = r10.cstp     // Catch:{ IOException -> 0x0170 }
                com.itextpdf.text.pdf.PdfIndirectReference r3 = r1.getIndirectReference()     // Catch:{ IOException -> 0x0170 }
                r2.addToBody(r1, r3)     // Catch:{ IOException -> 0x0170 }
            L_0x016b:
                int r11 = r11 + 1
                goto L_0x002b
            L_0x016f:
                return
            L_0x0170:
                r11 = move-exception
                com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
                r0.<init>(r11)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfCopy.PageStamp.addAnnotation(com.itextpdf.text.pdf.PdfAnnotation):void");
        }
    }

    public static class StampContent extends PdfContentByte {
        PageResources pageResources;

        StampContent(PdfWriter pdfWriter, PageResources pageResources2) {
            super(pdfWriter);
            this.pageResources = pageResources2;
        }

        @Override // com.itextpdf.text.pdf.PdfContentByte
        public PdfContentByte getDuplicate() {
            return new StampContent(this.writer, this.pageResources);
        }

        /* access modifiers changed from: package-private */
        @Override // com.itextpdf.text.pdf.PdfContentByte
        public PageResources getPageResources() {
            return this.pageResources;
        }
    }
}
