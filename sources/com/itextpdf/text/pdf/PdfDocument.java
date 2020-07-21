package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.ListLabel;
import com.itextpdf.text.MarkedObject;
import com.itextpdf.text.MarkedSection;
import com.itextpdf.text.Meta;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.Version;
import com.itextpdf.text.api.WriterOperation;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.TempFileCache;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.internal.PdfAnnotationsImp;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import com.itextpdf.text.xml.xmp.PdfProperties;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class PdfDocument extends Document {
    protected static final DecimalFormat SIXTEEN_DIGITS = new DecimalFormat("0000000000000000");
    static final String hangingPunctuation = ".,;:'";
    protected PdfDictionary additionalActions;
    protected int alignment = 0;
    protected PdfAction anchorAction = null;
    PdfAnnotationsImp annotationsImp;
    private PdfBody body;
    protected HashMap<String, PdfRectangle> boxSize = new HashMap<>();
    protected PdfCollection collection;
    protected float currentHeight = 0.0f;
    protected PdfOutline currentOutline;
    protected HashMap<String, PdfObject> documentFileAttachment = new HashMap<>();
    protected HashMap<String, PdfObject> documentLevelJS = new HashMap<>();
    private HashMap<AccessibleElementId, AccessibleElementId> elementsParents = new HashMap<>();
    private TempFileCache externalCache;
    private HashMap<AccessibleElementId, TempFileCache.ObjectPosition> externallyStoredStructElements = new HashMap<>();
    protected boolean firstPageEvent = true;
    private ArrayList<Element> floatingElements = new ArrayList<>();
    protected PdfContentByte graphics;
    protected float imageEnd = -1.0f;
    protected Image imageWait = null;
    protected Indentation indentation = new Indentation();
    protected PdfInfo info = new PdfInfo();
    protected boolean isSectionTitle = false;
    private boolean isToUseExternalCache = false;
    int jsCounter;
    protected PdfString language;
    protected int lastElementType = -1;
    protected float leading = 0.0f;
    private Stack<Float> leadingStack = new Stack<>();
    protected PdfLine line = null;
    protected ArrayList<PdfLine> lines = new ArrayList<>();
    protected TreeMap<String, Destination> localDestinations = new TreeMap<>();
    protected HashMap<Object, Integer> markPoints = new HashMap<>();
    protected float nextMarginBottom;
    protected float nextMarginLeft;
    protected float nextMarginRight;
    protected float nextMarginTop;
    protected Rectangle nextPageSize = null;
    protected PdfAction openActionAction;
    protected String openActionName;
    protected boolean openMCDocument = false;
    protected PdfDictionary pageAA = null;
    private boolean pageEmpty = true;
    protected PdfPageLabels pageLabels;
    protected PageResources pageResources;
    protected PdfOutline rootOutline;
    protected boolean strictImageSequence = false;
    private HashMap<AccessibleElementId, PdfStructureElement> structElements = new HashMap<>();
    protected HashMap<Object, int[]> structParentIndices = new HashMap<>();
    protected TabSettings tabSettings;
    protected PdfContentByte text;
    protected int textEmptySize;
    protected HashMap<String, PdfRectangle> thisBoxSize = new HashMap<>();
    protected PdfViewerPreferencesImp viewerPreferences = new PdfViewerPreferencesImp();
    protected PdfWriter writer;

    public static class Indentation {
        float imageIndentLeft = 0.0f;
        float imageIndentRight = 0.0f;
        float indentBottom = 0.0f;
        float indentLeft = 0.0f;
        float indentRight = 0.0f;
        float indentTop = 0.0f;
        float listIndentLeft = 0.0f;
        float sectionIndentLeft = 0.0f;
        float sectionIndentRight = 0.0f;
    }

    public static class PdfInfo extends PdfDictionary {
        PdfInfo() {
            addProducer();
            addCreationDate();
        }

        PdfInfo(String str, String str2, String str3) {
            this();
            addTitle(str2);
            addSubject(str3);
            addAuthor(str);
        }

        /* access modifiers changed from: package-private */
        public void addTitle(String str) {
            put(PdfName.TITLE, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addSubject(String str) {
            put(PdfName.SUBJECT, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addKeywords(String str) {
            put(PdfName.KEYWORDS, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addAuthor(String str) {
            put(PdfName.AUTHOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addCreator(String str) {
            put(PdfName.CREATOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addProducer() {
            put(PdfName.PRODUCER, new PdfString(Version.getInstance().getVersion()));
        }

        /* access modifiers changed from: package-private */
        public void addCreationDate() {
            PdfDate pdfDate = new PdfDate();
            put(PdfName.CREATIONDATE, pdfDate);
            put(PdfName.MODDATE, pdfDate);
        }

        /* access modifiers changed from: package-private */
        public void addkey(String str, String str2) {
            if (!str.equals(PdfProperties.PRODUCER) && !str.equals("CreationDate")) {
                put(new PdfName(str), new PdfString(str2, PdfObject.TEXT_UNICODE));
            }
        }
    }

    static class PdfCatalog extends PdfDictionary {
        PdfWriter writer;

        PdfCatalog(PdfIndirectReference pdfIndirectReference, PdfWriter pdfWriter) {
            super(CATALOG);
            this.writer = pdfWriter;
            put(PdfName.PAGES, pdfIndirectReference);
        }

        /* access modifiers changed from: package-private */
        public void addNames(TreeMap<String, Destination> treeMap, HashMap<String, PdfObject> hashMap, HashMap<String, PdfObject> hashMap2, PdfWriter pdfWriter) {
            if (!treeMap.isEmpty() || !hashMap.isEmpty() || !hashMap2.isEmpty()) {
                try {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    if (!treeMap.isEmpty()) {
                        HashMap hashMap3 = new HashMap();
                        for (Map.Entry<String, Destination> entry : treeMap.entrySet()) {
                            String key = entry.getKey();
                            Destination value = entry.getValue();
                            if (value.destination != null) {
                                hashMap3.put(key, value.reference);
                            }
                        }
                        if (hashMap3.size() > 0) {
                            pdfDictionary.put(PdfName.DESTS, pdfWriter.addToBody(PdfNameTree.writeTree(hashMap3, pdfWriter)).getIndirectReference());
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        pdfDictionary.put(PdfName.JAVASCRIPT, pdfWriter.addToBody(PdfNameTree.writeTree(hashMap, pdfWriter)).getIndirectReference());
                    }
                    if (!hashMap2.isEmpty()) {
                        pdfDictionary.put(PdfName.EMBEDDEDFILES, pdfWriter.addToBody(PdfNameTree.writeTree(hashMap2, pdfWriter)).getIndirectReference());
                    }
                    if (pdfDictionary.size() > 0) {
                        put(PdfName.NAMES, pdfWriter.addToBody(pdfDictionary).getIndirectReference());
                    }
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setOpenAction(PdfAction pdfAction) {
            put(PdfName.OPENACTION, pdfAction);
        }

        /* access modifiers changed from: package-private */
        public void setAdditionalActions(PdfDictionary pdfDictionary) {
            try {
                put(PdfName.AA, this.writer.addToBody(pdfDictionary).getIndirectReference());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public PdfDocument() {
        addProducer();
        addCreationDate();
    }

    public void addWriter(PdfWriter pdfWriter) throws DocumentException {
        if (this.writer == null) {
            this.writer = pdfWriter;
            this.annotationsImp = new PdfAnnotationsImp(pdfWriter);
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("you.can.only.add.a.writer.to.a.pdfdocument.once", new Object[0]));
    }

    public float getLeading() {
        return this.leading;
    }

    /* access modifiers changed from: package-private */
    public void setLeading(float f) {
        this.leading = f;
    }

    /* access modifiers changed from: protected */
    public void pushLeading() {
        this.leadingStack.push(Float.valueOf(this.leading));
    }

    /* access modifiers changed from: protected */
    public void popLeading() {
        this.leading = this.leadingStack.pop().floatValue();
        if (this.leadingStack.size() > 0) {
            this.leading = this.leadingStack.peek().floatValue();
        }
    }

    public TabSettings getTabSettings() {
        return this.tabSettings;
    }

    public void setTabSettings(TabSettings tabSettings2) {
        this.tabSettings = tabSettings2;
    }

    @Override // com.itextpdf.text.ElementListener, com.itextpdf.text.Document
    public boolean add(Element element) throws DocumentException {
        MarkedObject title;
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        try {
            if (element.type() != 37) {
                flushFloatingElements();
            }
            int type = element.type();
            if (type == 23) {
                PdfPTable pdfPTable = (PdfPTable) element;
                if (pdfPTable.size() > pdfPTable.getHeaderRows()) {
                    ensureNewLine();
                    flushLines();
                    addPTable(pdfPTable);
                    this.pageEmpty = false;
                    newLine();
                }
            } else if (type != 50) {
                float f = 0.0f;
                if (type == 55) {
                    DrawInterface drawInterface = (DrawInterface) element;
                    PdfContentByte pdfContentByte = this.graphics;
                    float indentLeft = indentLeft();
                    float indentBottom = indentBottom();
                    float indentRight = indentRight();
                    float indentTop = indentTop();
                    float indentTop2 = indentTop() - this.currentHeight;
                    if (this.leadingStack.size() > 0) {
                        f = this.leading;
                    }
                    drawInterface.draw(pdfContentByte, indentLeft, indentBottom, indentRight, indentTop, indentTop2 - f);
                    this.pageEmpty = false;
                } else if (type != 666) {
                    if (type == 29) {
                        if (this.line == null) {
                            carriageReturn();
                        }
                        Annotation annotation = (Annotation) element;
                        Rectangle rectangle = new Rectangle(0.0f, 0.0f);
                        if (this.line != null) {
                            rectangle = new Rectangle(annotation.llx(indentRight() - this.line.widthLeft()), annotation.ury((indentTop() - this.currentHeight) - 20.0f), annotation.urx((indentRight() - this.line.widthLeft()) + 20.0f), annotation.lly(indentTop() - this.currentHeight));
                        }
                        this.annotationsImp.addPlainAnnotation(PdfAnnotationsImp.convertAnnotation(this.writer, annotation, rectangle));
                        this.pageEmpty = false;
                    } else if (type != 30) {
                        switch (type) {
                            case 0:
                                this.info.addkey(((Meta) element).getName(), ((Meta) element).getContent());
                                break;
                            case 1:
                                this.info.addTitle(((Meta) element).getContent());
                                break;
                            case 2:
                                this.info.addSubject(((Meta) element).getContent());
                                break;
                            case 3:
                                this.info.addKeywords(((Meta) element).getContent());
                                break;
                            case 4:
                                this.info.addAuthor(((Meta) element).getContent());
                                break;
                            case 5:
                                this.info.addProducer();
                                break;
                            case 6:
                                this.info.addCreationDate();
                                break;
                            case 7:
                                this.info.addCreator(((Meta) element).getContent());
                                break;
                            case 8:
                                setLanguage(((Meta) element).getContent());
                                break;
                            default:
                                switch (type) {
                                    case 10:
                                        if (this.line == null) {
                                            carriageReturn();
                                        }
                                        PdfChunk pdfChunk = new PdfChunk((Chunk) element, this.anchorAction, this.tabSettings);
                                        while (true) {
                                            PdfChunk add = this.line.add(pdfChunk, this.leading);
                                            if (add == null) {
                                                this.pageEmpty = false;
                                                if (pdfChunk.isAttribute(Chunk.NEWPAGE)) {
                                                    newPage();
                                                    break;
                                                }
                                            } else {
                                                carriageReturn();
                                                if (!pdfChunk.isNewlineSplit()) {
                                                    add.trimFirstSpace();
                                                }
                                                pdfChunk = add;
                                            }
                                        }
                                        break;
                                    case 11:
                                        TabSettings tabSettings2 = this.tabSettings;
                                        if (((Phrase) element).getTabSettings() != null) {
                                            this.tabSettings = ((Phrase) element).getTabSettings();
                                        }
                                        this.leading = ((Phrase) element).getTotalLeading();
                                        pushLeading();
                                        element.process(this);
                                        this.tabSettings = tabSettings2;
                                        popLeading();
                                        break;
                                    case 12:
                                        TabSettings tabSettings3 = this.tabSettings;
                                        if (((Phrase) element).getTabSettings() != null) {
                                            this.tabSettings = ((Phrase) element).getTabSettings();
                                        }
                                        Paragraph paragraph = (Paragraph) element;
                                        if (isTagged(this.writer)) {
                                            flushLines();
                                            this.text.openMCBlock(paragraph);
                                        }
                                        addSpacing(paragraph.getSpacingBefore(), this.leading, paragraph.getFont());
                                        this.alignment = paragraph.getAlignment();
                                        this.leading = paragraph.getTotalLeading();
                                        pushLeading();
                                        carriageReturn();
                                        if (this.currentHeight + calculateLineHeight() > indentTop() - indentBottom()) {
                                            newPage();
                                        }
                                        this.indentation.indentLeft += paragraph.getIndentationLeft();
                                        this.indentation.indentRight += paragraph.getIndentationRight();
                                        carriageReturn();
                                        PdfPageEvent pageEvent = this.writer.getPageEvent();
                                        if (pageEvent != null && !this.isSectionTitle) {
                                            pageEvent.onParagraph(this.writer, this, indentTop() - this.currentHeight);
                                        }
                                        if (paragraph.getKeepTogether()) {
                                            carriageReturn();
                                            PdfPTable pdfPTable2 = new PdfPTable(1);
                                            pdfPTable2.setKeepTogether(paragraph.getKeepTogether());
                                            pdfPTable2.setWidthPercentage(100.0f);
                                            PdfPCell pdfPCell = new PdfPCell();
                                            pdfPCell.addElement(paragraph);
                                            pdfPCell.setBorder(0);
                                            pdfPCell.setPadding(0.0f);
                                            pdfPTable2.addCell(pdfPCell);
                                            this.indentation.indentLeft -= paragraph.getIndentationLeft();
                                            this.indentation.indentRight -= paragraph.getIndentationRight();
                                            add(pdfPTable2);
                                            this.indentation.indentLeft += paragraph.getIndentationLeft();
                                            this.indentation.indentRight += paragraph.getIndentationRight();
                                        } else {
                                            this.line.setExtraIndent(paragraph.getFirstLineIndent());
                                            float f2 = this.currentHeight;
                                            element.process(this);
                                            carriageReturn();
                                            if (f2 != this.currentHeight || this.lines.size() > 0) {
                                                addSpacing(paragraph.getSpacingAfter(), paragraph.getTotalLeading(), paragraph.getFont(), true);
                                            }
                                        }
                                        if (pageEvent != null && !this.isSectionTitle) {
                                            pageEvent.onParagraphEnd(this.writer, this, indentTop() - this.currentHeight);
                                        }
                                        this.alignment = 0;
                                        if (!(this.floatingElements == null || this.floatingElements.size() == 0)) {
                                            flushFloatingElements();
                                        }
                                        this.indentation.indentLeft -= paragraph.getIndentationLeft();
                                        this.indentation.indentRight -= paragraph.getIndentationRight();
                                        carriageReturn();
                                        this.tabSettings = tabSettings3;
                                        popLeading();
                                        if (isTagged(this.writer)) {
                                            flushLines();
                                            this.text.closeMCBlock(paragraph);
                                            break;
                                        }
                                        break;
                                    case 13:
                                    case 16:
                                        Section section = (Section) element;
                                        PdfPageEvent pageEvent2 = this.writer.getPageEvent();
                                        boolean z = section.isNotAddedYet() && section.getTitle() != null;
                                        if (section.isTriggerNewPage()) {
                                            newPage();
                                        }
                                        if (z) {
                                            float indentTop3 = indentTop() - this.currentHeight;
                                            int rotation = this.pageSize.getRotation();
                                            if (rotation == 90 || rotation == 180) {
                                                indentTop3 = this.pageSize.getHeight() - indentTop3;
                                            }
                                            PdfDestination pdfDestination = new PdfDestination(2, indentTop3);
                                            while (this.currentOutline.level() >= section.getDepth()) {
                                                this.currentOutline = this.currentOutline.parent();
                                            }
                                            this.currentOutline = new PdfOutline(this.currentOutline, pdfDestination, section.getBookmarkTitle(), section.isBookmarkOpen());
                                        }
                                        carriageReturn();
                                        this.indentation.sectionIndentLeft += section.getIndentationLeft();
                                        this.indentation.sectionIndentRight += section.getIndentationRight();
                                        if (section.isNotAddedYet() && pageEvent2 != null) {
                                            if (element.type() == 16) {
                                                pageEvent2.onChapter(this.writer, this, indentTop() - this.currentHeight, section.getTitle());
                                            } else {
                                                pageEvent2.onSection(this.writer, this, indentTop() - this.currentHeight, section.getDepth(), section.getTitle());
                                            }
                                        }
                                        if (z) {
                                            this.isSectionTitle = true;
                                            add(section.getTitle());
                                            this.isSectionTitle = false;
                                        }
                                        this.indentation.sectionIndentLeft += section.getIndentation();
                                        element.process(this);
                                        flushLines();
                                        this.indentation.sectionIndentLeft -= section.getIndentationLeft() + section.getIndentation();
                                        this.indentation.sectionIndentRight -= section.getIndentationRight();
                                        if (section.isComplete() && pageEvent2 != null) {
                                            if (element.type() != 16) {
                                                pageEvent2.onSectionEnd(this.writer, this, indentTop() - this.currentHeight);
                                                break;
                                            } else {
                                                pageEvent2.onChapterEnd(this.writer, this, indentTop() - this.currentHeight);
                                                break;
                                            }
                                        }
                                        break;
                                    case 14:
                                        List list = (List) element;
                                        if (isTagged(this.writer)) {
                                            flushLines();
                                            this.text.openMCBlock(list);
                                        }
                                        if (list.isAlignindent()) {
                                            list.normalizeIndentation();
                                        }
                                        this.indentation.listIndentLeft += list.getIndentationLeft();
                                        this.indentation.indentRight += list.getIndentationRight();
                                        element.process(this);
                                        this.indentation.listIndentLeft -= list.getIndentationLeft();
                                        this.indentation.indentRight -= list.getIndentationRight();
                                        carriageReturn();
                                        if (isTagged(this.writer)) {
                                            flushLines();
                                            this.text.closeMCBlock(list);
                                            break;
                                        }
                                        break;
                                    case 15:
                                        ListItem listItem = (ListItem) element;
                                        if (isTagged(this.writer)) {
                                            flushLines();
                                            this.text.openMCBlock(listItem);
                                        }
                                        addSpacing(listItem.getSpacingBefore(), this.leading, listItem.getFont());
                                        this.alignment = listItem.getAlignment();
                                        this.indentation.listIndentLeft += listItem.getIndentationLeft();
                                        this.indentation.indentRight += listItem.getIndentationRight();
                                        this.leading = listItem.getTotalLeading();
                                        pushLeading();
                                        carriageReturn();
                                        this.line.setListItem(listItem);
                                        element.process(this);
                                        addSpacing(listItem.getSpacingAfter(), listItem.getTotalLeading(), listItem.getFont(), true);
                                        if (this.line.hasToBeJustified()) {
                                            this.line.resetAlignment();
                                        }
                                        carriageReturn();
                                        this.indentation.listIndentLeft -= listItem.getIndentationLeft();
                                        this.indentation.indentRight -= listItem.getIndentationRight();
                                        popLeading();
                                        if (isTagged(this.writer)) {
                                            flushLines();
                                            this.text.closeMCBlock(listItem.getListBody());
                                            this.text.closeMCBlock(listItem);
                                            break;
                                        }
                                        break;
                                    case 17:
                                        Anchor anchor = (Anchor) element;
                                        String reference = anchor.getReference();
                                        this.leading = anchor.getLeading();
                                        pushLeading();
                                        if (reference != null) {
                                            this.anchorAction = new PdfAction(reference);
                                        }
                                        element.process(this);
                                        this.anchorAction = null;
                                        popLeading();
                                        break;
                                    default:
                                        switch (type) {
                                            case 32:
                                            case 33:
                                            case 34:
                                            case 35:
                                            case 36:
                                                if (isTagged(this.writer) && !((Image) element).isImgTemplate()) {
                                                    flushLines();
                                                    this.text.openMCBlock((Image) element);
                                                }
                                                add((Image) element);
                                                if (isTagged(this.writer) && !((Image) element).isImgTemplate()) {
                                                    flushLines();
                                                    this.text.closeMCBlock((Image) element);
                                                    break;
                                                }
                                            case 37:
                                                ensureNewLine();
                                                flushLines();
                                                addDiv((PdfDiv) element);
                                                this.pageEmpty = false;
                                                break;
                                            case 38:
                                                PdfBody pdfBody = (PdfBody) element;
                                                this.body = pdfBody;
                                                this.graphics.rectangle(pdfBody);
                                                return false;
                                            default:
                                                return false;
                                        }
                                }
                                break;
                        }
                    } else {
                        this.graphics.rectangle((Rectangle) element);
                        this.pageEmpty = false;
                    }
                } else if (this.writer != null) {
                    ((WriterOperation) element).write(this.writer, this);
                }
            } else {
                if ((element instanceof MarkedSection) && (title = ((MarkedSection) element).getTitle()) != null) {
                    title.process(this);
                }
                ((MarkedObject) element).process(this);
            }
            this.lastElementType = element.type();
            return true;
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void open() {
        if (!this.open) {
            super.open();
            this.writer.open();
            PdfOutline pdfOutline = new PdfOutline(this.writer);
            this.rootOutline = pdfOutline;
            this.currentOutline = pdfOutline;
        }
        try {
            if (isTagged(this.writer)) {
                this.openMCDocument = true;
            }
            initPage();
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void close() {
        int size;
        if (!this.close) {
            try {
                if (isTagged(this.writer)) {
                    flushFloatingElements();
                    flushLines();
                    this.writer.flushAcroFields();
                    this.writer.flushTaggedObjects();
                    if (isPageEmpty() && (size = this.writer.pageReferences.size()) > 0 && this.writer.currentPageNumber == size) {
                        this.writer.pageReferences.remove(size - 1);
                    }
                } else {
                    this.writer.flushAcroFields();
                }
                if (this.imageWait != null) {
                    newPage();
                }
                endPage();
                if (isTagged(this.writer)) {
                    this.writer.getDirectContent().closeMCBlock(this);
                }
                if (!this.annotationsImp.hasUnusedAnnotations()) {
                    PdfPageEvent pageEvent = this.writer.getPageEvent();
                    if (pageEvent != null) {
                        pageEvent.onCloseDocument(this.writer, this);
                    }
                    super.close();
                    this.writer.addLocalDestinations(this.localDestinations);
                    calculateOutlineCount();
                    writeOutlines();
                    this.writer.close();
                    return;
                }
                throw new RuntimeException(MessageLocalization.getComposedMessage("not.all.annotations.could.be.added.to.the.document.the.document.doesn.t.have.enough.pages", new Object[0]));
            } catch (Exception e) {
                throw ExceptionConverter.convertException(e);
            }
        }
    }

    public void setXmpMetadata(byte[] bArr) throws IOException {
        PdfStream pdfStream = new PdfStream(bArr);
        pdfStream.put(PdfName.TYPE, PdfName.METADATA);
        pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
        PdfEncryption encryption = this.writer.getEncryption();
        if (encryption != null && !encryption.isMetadataEncrypted()) {
            PdfArray pdfArray = new PdfArray();
            pdfArray.add(PdfName.CRYPT);
            pdfStream.put(PdfName.FILTER, pdfArray);
        }
        this.writer.addPageDictEntry(PdfName.METADATA, this.writer.addToBody(pdfStream).getIndirectReference());
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean newPage() {
        if (isPageEmpty()) {
            setNewPageSizeAndMargins();
            return false;
        } else if (!this.open || this.close) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
        } else {
            ArrayList<IAccessibleElement> endPage = endPage();
            super.newPage();
            this.indentation.imageIndentLeft = 0.0f;
            this.indentation.imageIndentRight = 0.0f;
            try {
                if (isTagged(this.writer)) {
                    flushStructureElementsOnNewPage();
                    this.writer.getDirectContentUnder().restoreMCBlocks(endPage);
                }
                initPage();
                if (this.body == null || this.body.getBackgroundColor() == null) {
                    return true;
                }
                this.graphics.rectangle(this.body);
                return true;
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList<IAccessibleElement> endPage() {
        PdfContentByte pdfContentByte = null;
        if (isPageEmpty()) {
            return null;
        }
        try {
            flushFloatingElements();
            this.lastElementType = -1;
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                pageEvent.onEndPage(this.writer, this);
            }
            try {
                flushLines();
                int rotation = this.pageSize.getRotation();
                if (this.writer.isPdfIso()) {
                    if (this.thisBoxSize.containsKey("art") && this.thisBoxSize.containsKey("trim")) {
                        throw new PdfXConformanceException(MessageLocalization.getComposedMessage("only.one.of.artbox.or.trimbox.can.exist.in.the.page", new Object[0]));
                    } else if (!this.thisBoxSize.containsKey("art") && !this.thisBoxSize.containsKey("trim")) {
                        if (this.thisBoxSize.containsKey("crop")) {
                            this.thisBoxSize.put("trim", this.thisBoxSize.get("crop"));
                        } else {
                            this.thisBoxSize.put("trim", new PdfRectangle(this.pageSize, this.pageSize.getRotation()));
                        }
                    }
                }
                this.pageResources.addDefaultColorDiff(this.writer.getDefaultColorspace());
                if (this.writer.isRgbTransparencyBlending()) {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    pdfDictionary.put(PdfName.CS, PdfName.DEVICERGB);
                    this.pageResources.addDefaultColorDiff(pdfDictionary);
                }
                PdfPage pdfPage = new PdfPage(new PdfRectangle(this.pageSize, rotation), this.thisBoxSize, this.pageResources.getResources(), rotation);
                if (isTagged(this.writer)) {
                    pdfPage.put(PdfName.TABS, PdfName.S);
                } else {
                    pdfPage.put(PdfName.TABS, this.writer.getTabs());
                }
                pdfPage.putAll(this.writer.getPageDictEntries());
                this.writer.resetPageDictEntries();
                if (this.pageAA != null) {
                    pdfPage.put(PdfName.AA, this.writer.addToBody(this.pageAA).getIndirectReference());
                    this.pageAA = null;
                }
                if (this.annotationsImp.hasUnusedAnnotations()) {
                    PdfArray rotateAnnotations = this.annotationsImp.rotateAnnotations(this.writer, this.pageSize);
                    if (rotateAnnotations.size() != 0) {
                        pdfPage.put(PdfName.ANNOTS, rotateAnnotations);
                    }
                }
                if (isTagged(this.writer)) {
                    pdfPage.put(PdfName.STRUCTPARENTS, new PdfNumber(getStructParentIndex(this.writer.getCurrentPage())));
                }
                if (this.text.size() > this.textEmptySize || isTagged(this.writer)) {
                    this.text.endText();
                } else {
                    this.text = null;
                }
                ArrayList<IAccessibleElement> saveMCBlocks = isTagged(this.writer) ? this.writer.getDirectContent().saveMCBlocks() : null;
                PdfWriter pdfWriter = this.writer;
                PdfContentByte directContentUnder = this.writer.getDirectContentUnder();
                PdfContentByte pdfContentByte2 = this.graphics;
                if (!isTagged(this.writer)) {
                    pdfContentByte = this.text;
                }
                pdfWriter.add(pdfPage, new PdfContents(directContentUnder, pdfContentByte2, pdfContentByte, this.writer.getDirectContent(), this.pageSize));
                this.annotationsImp.resetAnnotations();
                this.writer.resetContent();
                return saveMCBlocks;
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } catch (DocumentException e3) {
            throw new ExceptionConverter(e3);
        }
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        this.nextPageSize = new Rectangle(rectangle);
        return true;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        this.nextMarginLeft = f;
        this.nextMarginRight = f2;
        this.nextMarginTop = f3;
        this.nextMarginBottom = f4;
        return true;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            return super.setMarginMirroring(z);
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            return super.setMarginMirroringTopBottom(z);
        }
        return false;
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void setPageCount(int i) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.setPageCount(i);
        }
    }

    @Override // com.itextpdf.text.Document, com.itextpdf.text.DocListener
    public void resetPageCount() {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.resetPageCount();
        }
    }

    /* access modifiers changed from: protected */
    public void initPage() throws DocumentException {
        this.pageN++;
        this.pageResources = new PageResources();
        if (isTagged(this.writer)) {
            this.graphics = this.writer.getDirectContentUnder().getDuplicate();
            this.writer.getDirectContent().duplicatedFrom = this.graphics;
        } else {
            this.graphics = new PdfContentByte(this.writer);
        }
        setNewPageSizeAndMargins();
        this.imageEnd = -1.0f;
        this.indentation.imageIndentRight = 0.0f;
        this.indentation.imageIndentLeft = 0.0f;
        this.indentation.indentBottom = 0.0f;
        this.indentation.indentTop = 0.0f;
        this.currentHeight = 0.0f;
        this.thisBoxSize = new HashMap<>(this.boxSize);
        if (!(this.pageSize.getBackgroundColor() == null && !this.pageSize.hasBorders() && this.pageSize.getBorderColor() == null)) {
            add(this.pageSize);
        }
        float f = this.leading;
        int i = this.alignment;
        this.pageEmpty = true;
        try {
            if (this.imageWait != null) {
                add(this.imageWait);
                this.imageWait = null;
            }
            this.leading = f;
            this.alignment = i;
            carriageReturn();
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                if (this.firstPageEvent) {
                    pageEvent.onOpenDocument(this.writer, this);
                }
                pageEvent.onStartPage(this.writer, this);
            }
            this.firstPageEvent = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public void newLine() throws DocumentException {
        this.lastElementType = -1;
        carriageReturn();
        ArrayList<PdfLine> arrayList = this.lines;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.lines.add(this.line);
            this.currentHeight += this.line.height();
        }
        this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
    }

    /* access modifiers changed from: protected */
    public float calculateLineHeight() {
        float height = this.line.height();
        float f = this.leading;
        return height != f ? height + f : height;
    }

    /* access modifiers changed from: protected */
    public void carriageReturn() {
        if (this.lines == null) {
            this.lines = new ArrayList<>();
        }
        PdfLine pdfLine = this.line;
        if (pdfLine != null && pdfLine.size() > 0) {
            if (this.currentHeight + calculateLineHeight() > indentTop() - indentBottom() && this.currentHeight != 0.0f) {
                PdfLine pdfLine2 = this.line;
                this.line = null;
                newPage();
                this.line = pdfLine2;
                pdfLine2.left = indentLeft();
            }
            this.currentHeight += this.line.height();
            this.lines.add(this.line);
            this.pageEmpty = false;
        }
        float f = this.imageEnd;
        if (f > -1.0f && this.currentHeight > f) {
            this.imageEnd = -1.0f;
            this.indentation.imageIndentRight = 0.0f;
            this.indentation.imageIndentLeft = 0.0f;
        }
        this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
    }

    public float getVerticalPosition(boolean z) {
        if (z) {
            ensureNewLine();
        }
        return (top() - this.currentHeight) - this.indentation.indentTop;
    }

    /* access modifiers changed from: protected */
    public void ensureNewLine() {
        try {
            if (this.lastElementType == 11 || this.lastElementType == 10) {
                newLine();
                flushLines();
            }
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public float flushLines() throws DocumentException {
        ListLabel listLabel;
        if (this.lines == null) {
            return 0.0f;
        }
        PdfLine pdfLine = this.line;
        if (pdfLine != null && pdfLine.size() > 0) {
            this.lines.add(this.line);
            this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
        }
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        Object[] objArr = new Object[2];
        objArr[1] = new Float(0.0f);
        Iterator<PdfLine> it2 = this.lines.iterator();
        PdfFont pdfFont = null;
        float f = 0.0f;
        while (it2.hasNext()) {
            PdfLine next = it2.next();
            float indentLeft = (next.indentLeft() - indentLeft()) + this.indentation.indentLeft + this.indentation.listIndentLeft + this.indentation.sectionIndentLeft;
            this.text.moveText(indentLeft, -next.height());
            next.flush();
            if (next.listSymbol() != null) {
                Chunk listSymbol = next.listSymbol();
                if (isTagged(this.writer)) {
                    listLabel = next.listItem().getListLabel();
                    this.graphics.openMCBlock(listLabel);
                    Chunk chunk = new Chunk(listSymbol);
                    chunk.setRole(null);
                    listSymbol = chunk;
                } else {
                    listLabel = null;
                }
                ColumnText.showTextAligned(this.graphics, 0, new Phrase(listSymbol), this.text.getXTLM() - next.listIndent(), this.text.getYTLM(), 0.0f);
                if (listLabel != null) {
                    this.graphics.closeMCBlock(listLabel);
                }
            }
            objArr[0] = pdfFont;
            if (isTagged(this.writer) && next.listItem() != null) {
                this.text.openMCBlock(next.listItem().getListBody());
            }
            writeLineToContent(next, this.text, this.graphics, objArr, this.writer.getSpaceCharRatio());
            pdfFont = (PdfFont) objArr[0];
            f += next.height();
            this.text.moveText(-indentLeft, 0.0f);
        }
        this.lines = new ArrayList<>();
        return f;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03f2  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x055a  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x056d  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0576  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x05ab  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x05f8  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0601  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0605  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x060b  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x061e  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0647  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x064f  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x06f2  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x07a7  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x07e1  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x07e8  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x07ef  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x07f4  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x07fb  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0804  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0812  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0908  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x090e  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x0913  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0919  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0922  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x092d  */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x0942  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x098e  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x09a0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float writeLineToContent(com.itextpdf.text.pdf.PdfLine r61, com.itextpdf.text.pdf.PdfContentByte r62, com.itextpdf.text.pdf.PdfContentByte r63, java.lang.Object[] r64, float r65) throws com.itextpdf.text.DocumentException {
        /*
            r60 = this;
            r7 = r60
            r8 = r61
            r9 = r62
            r14 = r63
            r15 = 0
            r0 = r64[r15]
            com.itextpdf.text.pdf.PdfFont r0 = (com.itextpdf.text.pdf.PdfFont) r0
            r12 = 1
            r1 = r64[r12]
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            float r2 = r62.getXTLM()
            float r3 = r61.getOriginalWidth()
            float r2 = r2 + r3
            int r13 = r61.numberOfSpaces()
            int r3 = r61.getLineLengthUtf32()
            boolean r4 = r61.hasToBeJustified()
            if (r4 == 0) goto L_0x0034
            if (r13 != 0) goto L_0x0031
            if (r3 <= r12) goto L_0x0034
        L_0x0031:
            r26 = 1
            goto L_0x0036
        L_0x0034:
            r26 = 0
        L_0x0036:
            int r4 = r61.getSeparatorCount()
            r11 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            if (r4 <= 0) goto L_0x0050
            float r3 = r61.widthLeft()
            float r4 = (float) r4
            float r3 = r3 / r4
            r27 = r1
            r28 = r2
            r4 = r3
        L_0x004a:
            r5 = 0
            r6 = 0
        L_0x004c:
            r29 = 0
            goto L_0x00eb
        L_0x0050:
            if (r26 == 0) goto L_0x00d6
            if (r4 != 0) goto L_0x00d6
            boolean r4 = r61.isNewlineSplit()
            if (r4 == 0) goto L_0x0082
            float r4 = r61.widthLeft()
            float r5 = (float) r13
            float r5 = r5 * r65
            float r6 = (float) r3
            float r5 = r5 + r6
            float r5 = r5 - r11
            float r5 = r5 * r1
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0082
            boolean r3 = r61.isRTL()
            if (r3 == 0) goto L_0x0078
            float r3 = r61.widthLeft()
            float r3 = r3 - r5
            r9.moveText(r3, r10)
        L_0x0078:
            float r3 = r65 * r1
            r6 = r1
            r27 = r6
            r28 = r2
            r5 = r3
            r4 = 0
            goto L_0x004c
        L_0x0082:
            float r1 = r61.widthLeft()
            int r4 = r61.size()
            int r4 = r4 - r12
            com.itextpdf.text.pdf.PdfChunk r4 = r8.getChunk(r4)
            if (r4 == 0) goto L_0x00c2
            java.lang.String r5 = r4.toString()
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x00c2
            int r6 = r5.length()
            int r6 = r6 - r12
            char r5 = r5.charAt(r6)
            java.lang.String r6 = ".,;:'"
            int r6 = r6.indexOf(r5)
            if (r6 < 0) goto L_0x00c2
            com.itextpdf.text.pdf.PdfFont r4 = r4.font()
            float r4 = r4.width(r5)
            r5 = 1053609165(0x3ecccccd, float:0.4)
            float r4 = r4 * r5
            float r4 = r4 + r1
            float r1 = r4 - r1
            r59 = r4
            r4 = r1
            r1 = r59
            goto L_0x00c3
        L_0x00c2:
            r4 = 0
        L_0x00c3:
            float r5 = (float) r13
            float r5 = r5 * r65
            float r3 = (float) r3
            float r5 = r5 + r3
            float r5 = r5 - r11
            float r1 = r1 / r5
            float r3 = r65 * r1
            r6 = r1
            r27 = r6
            r28 = r2
            r5 = r3
            r29 = r4
            r4 = 0
            goto L_0x00eb
        L_0x00d6:
            int r3 = r8.alignment
            if (r3 == 0) goto L_0x00df
            int r3 = r8.alignment
            r4 = -1
            if (r3 != r4) goto L_0x00e4
        L_0x00df:
            float r3 = r61.widthLeft()
            float r2 = r2 - r3
        L_0x00e4:
            r27 = r1
            r28 = r2
            r4 = 0
            goto L_0x004a
        L_0x00eb:
            int r3 = r61.getLastStrokeChunk()
            float r30 = r62.getXTLM()
            float r2 = r62.getYTLM()
            java.util.Iterator r31 = r61.iterator()
            r1 = 2143289344(0x7fc00000, float:NaN)
            r1 = r0
            r16 = r30
            r0 = 0
            r17 = 0
            r18 = 0
            r32 = 2143289344(0x7fc00000, float:NaN)
            r33 = 0
        L_0x0109:
            boolean r19 = r31.hasNext()
            if (r19 == 0) goto L_0x0988
            java.lang.Object r19 = r31.next()
            r11 = r19
            com.itextpdf.text.pdf.PdfChunk r11 = (com.itextpdf.text.pdf.PdfChunk) r11
            com.itextpdf.text.pdf.PdfWriter r10 = r7.writer
            boolean r10 = isTagged(r10)
            if (r10 == 0) goto L_0x012b
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r10 = r11.accessibleElement
            if (r10 == 0) goto L_0x012b
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r10 = r11.accessibleElement
            r9.openMCBlock(r10)
            r34 = 1
            goto L_0x012d
        L_0x012b:
            r34 = r18
        L_0x012d:
            com.itextpdf.text.BaseColor r10 = r11.color()
            com.itextpdf.text.pdf.PdfFont r18 = r11.font()
            float r15 = r18.size()
            boolean r18 = r11.isImage()
            if (r18 == 0) goto L_0x014f
            float r15 = r11.height()
            float r18 = r11.height()
            r23 = r4
            r24 = r18
            r12 = 0
            r18 = r1
            goto L_0x0171
        L_0x014f:
            com.itextpdf.text.pdf.PdfFont r18 = r11.font()
            com.itextpdf.text.pdf.BaseFont r12 = r18.getFont()
            r18 = r1
            r1 = 1
            float r12 = r12.getFontDescriptor(r1, r15)
            com.itextpdf.text.pdf.PdfFont r1 = r11.font()
            com.itextpdf.text.pdf.BaseFont r1 = r1.getFont()
            r23 = r4
            r4 = 3
            float r1 = r1.getFontDescriptor(r4, r15)
            r24 = r15
            r15 = r12
            r12 = r1
        L_0x0171:
            java.lang.String r4 = "HSCALE"
            java.lang.String r1 = "SKEW"
            r25 = r13
            java.lang.String r13 = "WORD_SPACING"
            r35 = r10
            java.lang.String r10 = "CHAR_SPACING"
            r36 = r10
            if (r0 > r3) goto L_0x0742
            if (r26 == 0) goto L_0x0188
            float r37 = r11.getWidthCorrected(r6, r5)
            goto L_0x018c
        L_0x0188:
            float r37 = r11.width()
        L_0x018c:
            boolean r38 = r11.isStroked()
            if (r38 == 0) goto L_0x0716
            int r10 = r0 + 1
            com.itextpdf.text.pdf.PdfChunk r10 = r8.getChunk(r10)
            boolean r39 = r11.isSeparator()
            if (r39 == 0) goto L_0x020d
            r39 = r0
            java.lang.String r0 = "SEPARATOR"
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r21 = 0
            r37 = r0[r21]
            com.itextpdf.text.pdf.draw.DrawInterface r37 = (com.itextpdf.text.pdf.draw.DrawInterface) r37
            r22 = 1
            r0 = r0[r22]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01e9
            float r40 = r2 + r12
            float r0 = r61.getOriginalWidth()
            float r41 = r30 + r0
            float r42 = r15 - r12
            r0 = r37
            r8 = r1
            r43 = r18
            r1 = r63
            r44 = r2
            r2 = r30
            r45 = r3
            r3 = r40
            r46 = r4
            r18 = r13
            r13 = r23
            r4 = r41
            r47 = r5
            r5 = r42
            r48 = r6
            r6 = r44
            r0.draw(r1, r2, r3, r4, r5, r6)
            goto L_0x020a
        L_0x01e9:
            r8 = r1
            r45 = r3
            r46 = r4
            r47 = r5
            r48 = r6
            r43 = r18
            r6 = r2
            r18 = r13
            r13 = r23
            float r3 = r6 + r12
            float r4 = r16 + r13
            float r5 = r15 - r12
            r0 = r37
            r1 = r63
            r2 = r16
            r44 = r6
            r0.draw(r1, r2, r3, r4, r5, r6)
        L_0x020a:
            r37 = r13
            goto L_0x0220
        L_0x020d:
            r39 = r0
            r8 = r1
            r44 = r2
            r45 = r3
            r46 = r4
            r47 = r5
            r48 = r6
            r43 = r18
            r18 = r13
            r13 = r23
        L_0x0220:
            boolean r0 = r11.isTab()
            if (r0 == 0) goto L_0x0294
            java.lang.String r0 = "TABSETTINGS"
            boolean r0 = r11.isAttribute(r0)
            if (r0 == 0) goto L_0x0257
            com.itextpdf.text.TabStop r0 = r11.getTabStop()
            if (r0 == 0) goto L_0x0254
            float r1 = r0.getPosition()
            float r17 = r1 + r30
            com.itextpdf.text.pdf.draw.DrawInterface r1 = r0.getLeader()
            if (r1 == 0) goto L_0x028f
            com.itextpdf.text.pdf.draw.DrawInterface r0 = r0.getLeader()
            r6 = r44
            float r3 = r6 + r12
            float r5 = r15 - r12
            r1 = r63
            r2 = r16
            r4 = r17
            r0.draw(r1, r2, r3, r4, r5, r6)
            goto L_0x028f
        L_0x0254:
            r17 = r16
            goto L_0x028f
        L_0x0257:
            java.lang.String r0 = "TAB"
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r1 = 0
            r2 = r0[r1]
            r1 = r2
            com.itextpdf.text.pdf.draw.DrawInterface r1 = (com.itextpdf.text.pdf.draw.DrawInterface) r1
            r2 = 1
            r3 = r0[r2]
            java.lang.Float r3 = (java.lang.Float) r3
            float r2 = r3.floatValue()
            r3 = 3
            r0 = r0[r3]
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            float r17 = r2 + r0
            int r0 = (r17 > r16 ? 1 : (r17 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x028f
            r6 = r44
            float r3 = r6 + r12
            float r5 = r15 - r12
            r0 = r1
            r1 = r63
            r2 = r16
            r4 = r17
            r0.draw(r1, r2, r3, r4, r5, r6)
        L_0x028f:
            r40 = r16
            r6 = r17
            goto L_0x0298
        L_0x0294:
            r6 = r16
            r40 = r17
        L_0x0298:
            java.lang.String r0 = "BACKGROUND"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x032a
            java.lang.Object r1 = r11.getAttribute(r0)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r2 = 0
            r3 = r1[r2]
            if (r3 == 0) goto L_0x032a
            boolean r2 = r63.getInText()
            if (r2 == 0) goto L_0x02be
            com.itextpdf.text.pdf.PdfWriter r3 = r7.writer
            boolean r3 = isTagged(r3)
            if (r3 == 0) goto L_0x02be
            r63.endText()
        L_0x02be:
            r63.saveState()
            if (r10 == 0) goto L_0x02cb
            boolean r0 = r10.isAttribute(r0)
            if (r0 == 0) goto L_0x02cb
            r0 = 0
            goto L_0x02cd
        L_0x02cb:
            r0 = r27
        L_0x02cd:
            if (r10 != 0) goto L_0x02d1
            float r0 = r0 + r29
        L_0x02d1:
            r3 = 0
            r4 = r1[r3]
            com.itextpdf.text.BaseColor r4 = (com.itextpdf.text.BaseColor) r4
            r14.setColorFill(r4)
            r4 = 1
            r1 = r1[r4]
            float[] r1 = (float[]) r1
            float[] r1 = (float[]) r1
            r5 = r1[r3]
            float r5 = r6 - r5
            r3 = r44
            float r16 = r3 + r12
            r17 = r1[r4]
            float r16 = r16 - r17
            float r17 = r11.getTextRise()
            float r4 = r16 + r17
            float r0 = r37 - r0
            r16 = 0
            r17 = r1[r16]
            float r0 = r0 + r17
            r16 = 2
            r17 = r1[r16]
            float r0 = r0 + r17
            float r16 = r15 - r12
            r17 = 1
            r23 = r1[r17]
            float r16 = r16 + r23
            r17 = 3
            r1 = r1[r17]
            float r1 = r16 + r1
            r14.rectangle(r5, r4, r0, r1)
            r63.fill()
            r0 = 0
            r14.setGrayFill(r0)
            r63.restoreState()
            if (r2 == 0) goto L_0x032c
            com.itextpdf.text.pdf.PdfWriter r0 = r7.writer
            boolean r0 = isTagged(r0)
            if (r0 == 0) goto L_0x032c
            r0 = 1
            r14.beginText(r0)
            goto L_0x032c
        L_0x032a:
            r3 = r44
        L_0x032c:
            java.lang.String r0 = "UNDERLINE"
            boolean r1 = r11.isAttribute(r0)
            r16 = 4
            if (r1 == 0) goto L_0x03f2
            boolean r1 = r63.getInText()
            if (r1 == 0) goto L_0x0347
            com.itextpdf.text.pdf.PdfWriter r2 = r7.writer
            boolean r2 = isTagged(r2)
            if (r2 == 0) goto L_0x0347
            r63.endText()
        L_0x0347:
            if (r10 == 0) goto L_0x0351
            boolean r2 = r10.isAttribute(r0)
            if (r2 == 0) goto L_0x0351
            r2 = 0
            goto L_0x0353
        L_0x0351:
            r2 = r27
        L_0x0353:
            if (r10 != 0) goto L_0x0357
            float r2 = r2 + r29
        L_0x0357:
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.Object[][] r0 = (java.lang.Object[][]) r0
            java.lang.Object[][] r0 = (java.lang.Object[][]) r0
            r4 = 0
        L_0x0360:
            int r5 = r0.length
            if (r4 >= r5) goto L_0x03da
            r5 = r0[r4]
            r17 = 0
            r23 = r5[r17]
            com.itextpdf.text.BaseColor r23 = (com.itextpdf.text.BaseColor) r23
            r17 = 1
            r5 = r5[r17]
            float[] r5 = (float[]) r5
            float[] r5 = (float[]) r5
            r17 = r0
            if (r23 != 0) goto L_0x037a
            r0 = r35
            goto L_0x037c
        L_0x037a:
            r0 = r23
        L_0x037c:
            if (r0 == 0) goto L_0x0381
            r14.setColorStroke(r0)
        L_0x0381:
            r21 = 0
            r23 = r5[r21]
            com.itextpdf.text.pdf.PdfFont r41 = r11.font()
            float r41 = r41.size()
            r22 = 1
            r42 = r5[r22]
            float r41 = r41 * r42
            r42 = r13
            float r13 = r23 + r41
            r14.setLineWidth(r13)
            r13 = 2
            r23 = r5[r13]
            com.itextpdf.text.pdf.PdfFont r13 = r11.font()
            float r13 = r13.size()
            r41 = 3
            r44 = r5[r41]
            float r13 = r13 * r44
            float r23 = r23 + r13
            r5 = r5[r16]
            int r5 = (int) r5
            if (r5 == 0) goto L_0x03b5
            r14.setLineCap(r5)
        L_0x03b5:
            float r13 = r3 + r23
            r14.moveTo(r6, r13)
            float r23 = r6 + r37
            r41 = r8
            float r8 = r23 - r2
            r14.lineTo(r8, r13)
            r63.stroke()
            if (r0 == 0) goto L_0x03cb
            r63.resetGrayStroke()
        L_0x03cb:
            if (r5 == 0) goto L_0x03d1
            r0 = 0
            r14.setLineCap(r0)
        L_0x03d1:
            int r4 = r4 + 1
            r0 = r17
            r8 = r41
            r13 = r42
            goto L_0x0360
        L_0x03da:
            r41 = r8
            r42 = r13
            r8 = 1065353216(0x3f800000, float:1.0)
            r14.setLineWidth(r8)
            if (r1 == 0) goto L_0x03f8
            com.itextpdf.text.pdf.PdfWriter r0 = r7.writer
            boolean r0 = isTagged(r0)
            if (r0 == 0) goto L_0x03f8
            r0 = 1
            r14.beginText(r0)
            goto L_0x03f8
        L_0x03f2:
            r41 = r8
            r42 = r13
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x03f8:
            java.lang.String r0 = "ACTION"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x04b2
            if (r10 == 0) goto L_0x040a
            boolean r1 = r10.isAttribute(r0)
            if (r1 == 0) goto L_0x040a
            r1 = 0
            goto L_0x040c
        L_0x040a:
            r1 = r27
        L_0x040c:
            if (r10 != 0) goto L_0x0410
            float r1 = r1 + r29
        L_0x0410:
            boolean r2 = r11.isImage()
            if (r2 == 0) goto L_0x0446
            com.itextpdf.text.pdf.PdfWriter r2 = r7.writer
            float r4 = r11.getImageOffsetY()
            float r4 = r4 + r3
            float r5 = r6 + r37
            float r5 = r5 - r1
            float r1 = r11.getImageHeight()
            float r1 = r1 + r3
            float r13 = r11.getImageOffsetY()
            float r13 = r13 + r1
            java.lang.Object r0 = r11.getAttribute(r0)
            r17 = r0
            com.itextpdf.text.pdf.PdfAction r17 = (com.itextpdf.text.pdf.PdfAction) r17
            r20 = 0
            r0 = r2
            r1 = r6
            r2 = r4
            r4 = r3
            r3 = r5
            r5 = r4
            r4 = r13
            r13 = r5
            r5 = r17
            r8 = r6
            r6 = r20
            com.itextpdf.text.pdf.PdfAnnotation r0 = r0.createAnnotation(r1, r2, r3, r4, r5, r6)
            goto L_0x0471
        L_0x0446:
            r13 = r3
            r8 = r6
            com.itextpdf.text.pdf.PdfWriter r2 = r7.writer
            float r3 = r13 + r12
            float r4 = r11.getTextRise()
            float r3 = r3 + r4
            float r6 = r8 + r37
            float r4 = r6 - r1
            float r1 = r13 + r15
            float r5 = r11.getTextRise()
            float r5 = r5 + r1
            java.lang.Object r0 = r11.getAttribute(r0)
            r6 = r0
            com.itextpdf.text.pdf.PdfAction r6 = (com.itextpdf.text.pdf.PdfAction) r6
            r20 = 0
            r0 = r2
            r1 = r8
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r20
            com.itextpdf.text.pdf.PdfAnnotation r0 = r0.createAnnotation(r1, r2, r3, r4, r5, r6)
        L_0x0471:
            r1 = 1
            r9.addAnnotation(r0, r1)
            com.itextpdf.text.pdf.PdfWriter r1 = r7.writer
            boolean r1 = isTagged(r1)
            if (r1 == 0) goto L_0x04b4
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r1 = r11.accessibleElement
            if (r1 == 0) goto L_0x04b4
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r1 = r11.accessibleElement
            com.itextpdf.text.AccessibleElementId r1 = r1.getId()
            com.itextpdf.text.pdf.PdfStructureElement r1 = r7.getStructElement(r1)
            if (r1 == 0) goto L_0x04b4
            int r2 = r7.getStructParentIndex(r0)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.STRUCTPARENT
            com.itextpdf.text.pdf.PdfNumber r4 = new com.itextpdf.text.pdf.PdfNumber
            r4.<init>(r2)
            r0.put(r3, r4)
            com.itextpdf.text.pdf.PdfWriter r3 = r7.writer
            com.itextpdf.text.pdf.PdfIndirectReference r3 = r3.getCurrentPage()
            r1.setAnnotation(r0, r3)
            com.itextpdf.text.pdf.PdfWriter r0 = r7.writer
            com.itextpdf.text.pdf.PdfStructureTreeRoot r0 = r0.getStructureTreeRoot()
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r1.getReference()
            r0.setAnnotationMark(r2, r1)
            goto L_0x04b4
        L_0x04b2:
            r13 = r3
            r8 = r6
        L_0x04b4:
            java.lang.String r0 = "REMOTEGOTO"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x0525
            if (r10 == 0) goto L_0x04c6
            boolean r1 = r10.isAttribute(r0)
            if (r1 == 0) goto L_0x04c6
            r1 = 0
            goto L_0x04c8
        L_0x04c6:
            r1 = r27
        L_0x04c8:
            if (r10 != 0) goto L_0x04cc
            float r1 = r1 + r29
        L_0x04cc:
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r2 = 0
            r3 = r0[r2]
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
            r3 = 1
            r4 = r0[r3]
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x0502
            r0 = r0[r3]
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            float r0 = r13 + r12
            float r4 = r11.getTextRise()
            float r4 = r4 + r0
            float r6 = r8 + r37
            float r5 = r6 - r1
            float r0 = r13 + r15
            float r1 = r11.getTextRise()
            float r6 = r0 + r1
            r0 = r60
            r1 = r2
            r2 = r3
            r3 = r8
            r0.remoteGoto(r1, r2, r3, r4, r5, r6)
            goto L_0x0525
        L_0x0502:
            r0 = r0[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r3 = r0.intValue()
            float r0 = r13 + r12
            float r4 = r11.getTextRise()
            float r4 = r4 + r0
            float r6 = r8 + r37
            float r5 = r6 - r1
            float r0 = r13 + r15
            float r1 = r11.getTextRise()
            float r6 = r0 + r1
            r0 = r60
            r1 = r2
            r2 = r3
            r3 = r8
            r0.remoteGoto(r1, r2, r3, r4, r5, r6)
        L_0x0525:
            java.lang.String r0 = "LOCALGOTO"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x0552
            if (r10 == 0) goto L_0x0537
            boolean r1 = r10.isAttribute(r0)
            if (r1 == 0) goto L_0x0537
            r1 = 0
            goto L_0x0539
        L_0x0537:
            r1 = r27
        L_0x0539:
            if (r10 != 0) goto L_0x053d
            float r1 = r1 + r29
        L_0x053d:
            java.lang.Object r0 = r11.getAttribute(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            float r6 = r8 + r37
            float r4 = r6 - r1
            float r5 = r13 + r24
            r0 = r60
            r1 = r2
            r2 = r8
            r3 = r13
            r0.localGoto(r1, r2, r3, r4, r5)
        L_0x0552:
            java.lang.String r0 = "LOCALDESTINATION"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x056d
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.itextpdf.text.pdf.PdfDestination r1 = new com.itextpdf.text.pdf.PdfDestination
            float r2 = r13 + r24
            r3 = 0
            r6 = 0
            r1.<init>(r3, r8, r2, r6)
            r7.localDestination(r0, r1)
            goto L_0x056e
        L_0x056d:
            r6 = 0
        L_0x056e:
            java.lang.String r0 = "GENERICTAG"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x05a3
            if (r10 == 0) goto L_0x0580
            boolean r1 = r10.isAttribute(r0)
            if (r1 == 0) goto L_0x0580
            r1 = 0
            goto L_0x0582
        L_0x0580:
            r1 = r27
        L_0x0582:
            if (r10 != 0) goto L_0x0586
            float r1 = r1 + r29
        L_0x0586:
            com.itextpdf.text.Rectangle r2 = new com.itextpdf.text.Rectangle
            float r3 = r8 + r37
            float r3 = r3 - r1
            float r1 = r13 + r24
            r2.<init>(r8, r13, r3, r1)
            com.itextpdf.text.pdf.PdfWriter r1 = r7.writer
            com.itextpdf.text.pdf.PdfPageEvent r1 = r1.getPageEvent()
            if (r1 == 0) goto L_0x05a3
            com.itextpdf.text.pdf.PdfWriter r3 = r7.writer
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1.onGenericTag(r3, r7, r2, r0)
        L_0x05a3:
            java.lang.String r0 = "PDFANNOTATION"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x05da
            if (r10 == 0) goto L_0x05b5
            boolean r1 = r10.isAttribute(r0)
            if (r1 == 0) goto L_0x05b5
            r1 = 0
            goto L_0x05b7
        L_0x05b5:
            r1 = r27
        L_0x05b7:
            if (r10 != 0) goto L_0x05bb
            float r1 = r1 + r29
        L_0x05bb:
            java.lang.Object r0 = r11.getAttribute(r0)
            com.itextpdf.text.pdf.PdfAnnotation r0 = (com.itextpdf.text.pdf.PdfAnnotation) r0
            com.itextpdf.text.pdf.PdfAnnotation r0 = com.itextpdf.text.pdf.PdfFormField.shallowDuplicate(r0)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.RECT
            com.itextpdf.text.pdf.PdfRectangle r3 = new com.itextpdf.text.pdf.PdfRectangle
            float r4 = r13 + r12
            float r5 = r8 + r37
            float r5 = r5 - r1
            float r1 = r13 + r15
            r3.<init>(r8, r4, r5, r1)
            r0.put(r2, r3)
            r1 = 1
            r9.addAnnotation(r0, r1)
        L_0x05da:
            r15 = r41
            java.lang.Object r0 = r11.getAttribute(r15)
            float[] r0 = (float[]) r0
            float[] r0 = (float[]) r0
            r12 = r46
            java.lang.Object r1 = r11.getAttribute(r12)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r0 != 0) goto L_0x05f6
            if (r1 == 0) goto L_0x05f1
            goto L_0x05f6
        L_0x05f1:
            r0 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
            goto L_0x061a
        L_0x05f6:
            if (r0 == 0) goto L_0x0601
            r2 = 0
            r3 = r0[r2]
            r2 = 1
            r0 = r0[r2]
            r2 = r3
            r3 = r0
            goto L_0x0603
        L_0x0601:
            r2 = 0
            r3 = 0
        L_0x0603:
            if (r1 == 0) goto L_0x060b
            float r0 = r1.floatValue()
            r10 = r0
            goto L_0x060d
        L_0x060b:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x060d:
            r4 = 1065353216(0x3f800000, float:1.0)
            r0 = r62
            r1 = r10
            r5 = r8
            r19 = 0
            r6 = r13
            r0.setTextMatrix(r1, r2, r3, r4, r5, r6)
            r0 = r10
        L_0x061a:
            r1 = r18
            if (r26 != 0) goto L_0x0647
            boolean r2 = r11.isAttribute(r1)
            if (r2 == 0) goto L_0x0631
            java.lang.Object r2 = r11.getAttribute(r1)
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r9.setWordSpacing(r2)
        L_0x0631:
            r2 = r36
            boolean r3 = r11.isAttribute(r2)
            if (r3 == 0) goto L_0x0649
            java.lang.Object r3 = r11.getAttribute(r2)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r9.setCharacterSpacing(r3)
            goto L_0x0649
        L_0x0647:
            r2 = r36
        L_0x0649:
            boolean r3 = r11.isImage()
            if (r3 == 0) goto L_0x06f2
            com.itextpdf.text.Image r3 = r11.getImage()
            float r37 = r11.getImageWidth()
            float r4 = r11.getImageScalePercentage()
            float[] r4 = r3.matrix(r4)
            float r5 = r11.getImageOffsetX()
            float r6 = r8 + r5
            r5 = r4[r16]
            float r6 = r6 - r5
            r4[r16] = r6
            float r5 = r11.getImageOffsetY()
            float r5 = r5 + r13
            r6 = 5
            r10 = r4[r6]
            float r5 = r5 - r10
            r4[r6] = r5
            boolean r5 = r63.getInText()
            if (r5 == 0) goto L_0x0684
            boolean r5 = r3 instanceof com.itextpdf.text.ImgTemplate
            if (r5 != 0) goto L_0x0684
            r63.endText()
            r5 = 1
            goto L_0x0685
        L_0x0684:
            r5 = 0
        L_0x0685:
            r18 = 0
            r10 = r4[r18]
            double r6 = (double) r10
            r21 = 1
            r10 = r4[r21]
            r36 = r0
            r22 = r1
            double r0 = (double) r10
            r23 = r2
            r10 = 2
            r2 = r4[r10]
            r38 = r8
            double r8 = (double) r2
            r2 = 3
            r10 = r4[r2]
            r24 = r3
            double r2 = (double) r10
            r10 = r4[r16]
            r49 = r2
            double r2 = (double) r10
            r10 = 5
            r4 = r4[r10]
            r44 = r5
            double r4 = (double) r4
            r46 = 0
            r52 = r23
            r51 = r35
            r10 = r63
            r65 = r11
            r11 = r24
            r56 = r12
            r54 = r13
            r57 = r22
            r35 = r25
            r55 = r42
            r41 = 3
            r12 = r6
            r7 = r14
            r58 = r15
            r6 = 0
            r14 = r0
            r16 = r8
            r18 = r49
            r20 = r2
            r22 = r4
            r24 = r46
            r25 = r34
            r10.addImage(r11, r12, r14, r16, r18, r20, r22, r24, r25)
            r0 = 1
            if (r44 == 0) goto L_0x06df
            r7.beginText(r0)
        L_0x06df:
            float r1 = r38 + r27
            float r2 = r65.getImageWidth()
            float r1 = r1 + r2
            float r2 = r62.getXTLM()
            float r1 = r1 - r2
            r2 = r62
            r3 = 0
            r2.moveText(r1, r3)
            goto L_0x070f
        L_0x06f2:
            r36 = r0
            r57 = r1
            r52 = r2
            r38 = r8
            r2 = r9
            r65 = r11
            r56 = r12
            r54 = r13
            r7 = r14
            r58 = r15
            r51 = r35
            r55 = r42
            r0 = 1
            r3 = 0
            r6 = 0
            r41 = 3
            r35 = r25
        L_0x070f:
            r11 = r36
            r16 = r38
            r17 = r40
            goto L_0x073b
        L_0x0716:
            r39 = r0
            r58 = r1
            r54 = r2
            r45 = r3
            r56 = r4
            r47 = r5
            r48 = r6
            r2 = r9
            r65 = r11
            r57 = r13
            r7 = r14
            r43 = r18
            r55 = r23
            r51 = r35
            r52 = r36
            r0 = 1
            r3 = 0
            r6 = 0
            r41 = 3
            r35 = r25
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x073b:
            float r16 = r16 + r37
            int r1 = r39 + 1
            r4 = r16
            goto L_0x076b
        L_0x0742:
            r39 = r0
            r58 = r1
            r54 = r2
            r45 = r3
            r56 = r4
            r47 = r5
            r48 = r6
            r2 = r9
            r65 = r11
            r57 = r13
            r7 = r14
            r43 = r18
            r55 = r23
            r51 = r35
            r52 = r36
            r0 = 1
            r3 = 0
            r6 = 0
            r41 = 3
            r35 = r25
            r4 = r16
            r1 = r39
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x076b:
            boolean r5 = r65.isImage()
            if (r5 != 0) goto L_0x078d
            com.itextpdf.text.pdf.PdfFont r5 = r65.font()
            r8 = r43
            int r5 = r5.compareTo(r8)
            if (r5 == 0) goto L_0x078f
            com.itextpdf.text.pdf.PdfFont r5 = r65.font()
            com.itextpdf.text.pdf.BaseFont r8 = r5.getFont()
            float r9 = r5.size()
            r2.setFontAndSize(r8, r9)
            goto L_0x0790
        L_0x078d:
            r8 = r43
        L_0x078f:
            r5 = r8
        L_0x0790:
            java.lang.String r8 = "TEXTRENDERMODE"
            r9 = r65
            java.lang.Object r8 = r9.getAttribute(r8)
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            r10 = 0
            java.lang.String r12 = "SUBSUPSCRIPT"
            java.lang.Object r12 = r9.getAttribute(r12)
            java.lang.Float r12 = (java.lang.Float) r12
            if (r8 == 0) goto L_0x07e1
            r13 = r8[r6]
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            r15 = r13 & 3
            if (r15 == 0) goto L_0x07b6
            r2.setTextRenderingMode(r15)
        L_0x07b6:
            r13 = 2
            if (r15 == r0) goto L_0x07bf
            if (r15 != r13) goto L_0x07bc
            goto L_0x07bf
        L_0x07bc:
            r14 = 1065353216(0x3f800000, float:1.0)
            goto L_0x07e4
        L_0x07bf:
            r10 = r8[r0]
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            r14 = 1065353216(0x3f800000, float:1.0)
            int r16 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r16 == 0) goto L_0x07d0
            r2.setLineWidth(r10)
        L_0x07d0:
            r8 = r8[r13]
            com.itextpdf.text.BaseColor r8 = (com.itextpdf.text.BaseColor) r8
            if (r8 != 0) goto L_0x07d8
            r8 = r51
        L_0x07d8:
            if (r8 == 0) goto L_0x07dd
            r2.setColorStroke(r8)
        L_0x07dd:
            r53 = r10
            r10 = r8
            goto L_0x07e6
        L_0x07e1:
            r14 = 1065353216(0x3f800000, float:1.0)
            r15 = 0
        L_0x07e4:
            r53 = 1065353216(0x3f800000, float:1.0)
        L_0x07e6:
            if (r12 == 0) goto L_0x07ef
            float r8 = r12.floatValue()
            r12 = r51
            goto L_0x07f2
        L_0x07ef:
            r12 = r51
            r8 = 0
        L_0x07f2:
            if (r12 == 0) goto L_0x07f7
            r2.setColorFill(r12)
        L_0x07f7:
            int r13 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r13 == 0) goto L_0x07fe
            r2.setTextRise(r8)
        L_0x07fe:
            boolean r8 = r9.isImage()
            if (r8 == 0) goto L_0x0812
            r16 = r1
            r18 = r5
            r3 = r47
            r14 = r48
            r23 = r55
            r33 = 1
            goto L_0x0906
        L_0x0812:
            boolean r8 = r9.isHorizontalSeparator()
            r16 = 1148846080(0x447a0000, float:1000.0)
            if (r8 == 0) goto L_0x0833
            com.itextpdf.text.pdf.PdfTextArray r8 = new com.itextpdf.text.pdf.PdfTextArray
            r8.<init>()
            r0 = r55
            float r14 = -r0
            float r14 = r14 * r16
            com.itextpdf.text.pdf.PdfFont r3 = r9.font
            float r3 = r3.size()
            float r14 = r14 / r3
            float r14 = r14 / r11
            r8.add(r14)
            r2.showText(r8)
            goto L_0x0856
        L_0x0833:
            r0 = r55
            boolean r3 = r9.isTab()
            if (r3 == 0) goto L_0x0862
            int r3 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0862
            com.itextpdf.text.pdf.PdfTextArray r3 = new com.itextpdf.text.pdf.PdfTextArray
            r3.<init>()
            float r8 = r17 - r4
            float r8 = r8 * r16
            com.itextpdf.text.pdf.PdfFont r14 = r9.font
            float r14 = r14.size()
            float r8 = r8 / r14
            float r8 = r8 / r11
            r3.add(r8)
            r2.showText(r3)
        L_0x0856:
            r23 = r0
            r16 = r1
            r18 = r5
            r3 = r47
            r14 = r48
            goto L_0x0906
        L_0x0862:
            if (r26 == 0) goto L_0x08de
            if (r35 <= 0) goto L_0x08de
            boolean r3 = r9.isSpecialEncoding()
            if (r3 == 0) goto L_0x08de
            int r3 = (r11 > r32 ? 1 : (r11 == r32 ? 0 : -1))
            if (r3 == 0) goto L_0x0887
            r3 = r47
            float r8 = r3 / r11
            r2.setWordSpacing(r8)
            r14 = r48
            float r8 = r14 / r11
            float r18 = r62.getCharacterSpacing()
            float r8 = r8 + r18
            r2.setCharacterSpacing(r8)
            r32 = r11
            goto L_0x088b
        L_0x0887:
            r3 = r47
            r14 = r48
        L_0x088b:
            java.lang.String r8 = r9.toString()
            r6 = 32
            r23 = r0
            int r0 = r8.indexOf(r6)
            if (r0 >= 0) goto L_0x08a1
            r2.showText(r8)
            r16 = r1
            r18 = r5
            goto L_0x0906
        L_0x08a1:
            float r6 = -r3
            float r6 = r6 * r16
            r16 = r1
            com.itextpdf.text.pdf.PdfFont r1 = r9.font
            float r1 = r1.size()
            float r6 = r6 / r1
            float r6 = r6 / r11
            com.itextpdf.text.pdf.PdfTextArray r1 = new com.itextpdf.text.pdf.PdfTextArray
            r18 = r5
            r11 = 0
            java.lang.String r5 = r8.substring(r11, r0)
            r1.<init>(r5)
        L_0x08ba:
            int r5 = r0 + 1
            r11 = 32
            int r5 = r8.indexOf(r11, r5)
            if (r5 < 0) goto L_0x08d0
            r1.add(r6)
            java.lang.String r0 = r8.substring(r0, r5)
            r1.add(r0)
            r0 = r5
            goto L_0x08ba
        L_0x08d0:
            r1.add(r6)
            java.lang.String r0 = r8.substring(r0)
            r1.add(r0)
            r2.showText(r1)
            goto L_0x0906
        L_0x08de:
            r23 = r0
            r16 = r1
            r18 = r5
            r3 = r47
            r14 = r48
            if (r26 == 0) goto L_0x08ff
            int r0 = (r11 > r32 ? 1 : (r11 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x08ff
            float r5 = r3 / r11
            r2.setWordSpacing(r5)
            float r6 = r14 / r11
            float r0 = r62.getCharacterSpacing()
            float r6 = r6 + r0
            r2.setCharacterSpacing(r6)
            r32 = r11
        L_0x08ff:
            java.lang.String r0 = r9.toString()
            r2.showText(r0)
        L_0x0906:
            if (r13 == 0) goto L_0x090c
            r0 = 0
            r2.setTextRise(r0)
        L_0x090c:
            if (r12 == 0) goto L_0x0911
            r62.resetRGBColorFill()
        L_0x0911:
            if (r15 == 0) goto L_0x0917
            r0 = 0
            r2.setTextRenderingMode(r0)
        L_0x0917:
            if (r10 == 0) goto L_0x091c
            r62.resetRGBColorStroke()
        L_0x091c:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r53 > r0 ? 1 : (r53 == r0 ? 0 : -1))
            if (r1 == 0) goto L_0x0925
            r2.setLineWidth(r0)
        L_0x0925:
            r1 = r58
            boolean r1 = r9.isAttribute(r1)
            if (r1 != 0) goto L_0x0939
            r1 = r56
            boolean r1 = r9.isAttribute(r1)
            if (r1 == 0) goto L_0x0936
            goto L_0x0939
        L_0x0936:
            r1 = r54
            goto L_0x0940
        L_0x0939:
            r1 = r54
            r2.setTextMatrix(r4, r1)
            r33 = 1
        L_0x0940:
            if (r26 != 0) goto L_0x0958
            r5 = r52
            boolean r5 = r9.isAttribute(r5)
            if (r5 == 0) goto L_0x094d
            r2.setCharacterSpacing(r14)
        L_0x094d:
            r5 = r57
            boolean r5 = r9.isAttribute(r5)
            if (r5 == 0) goto L_0x0958
            r2.setWordSpacing(r3)
        L_0x0958:
            r5 = r60
            com.itextpdf.text.pdf.PdfWriter r6 = r5.writer
            boolean r6 = isTagged(r6)
            if (r6 == 0) goto L_0x096b
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r6 = r9.accessibleElement
            if (r6 == 0) goto L_0x096b
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r6 = r9.accessibleElement
            r2.closeMCBlock(r6)
        L_0x096b:
            r8 = r61
            r9 = r2
            r6 = r14
            r0 = r16
            r13 = r35
            r10 = 0
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 1
            r15 = 0
            r2 = r1
            r16 = r4
            r14 = r7
            r1 = r18
            r4 = r23
            r18 = r34
            r7 = r5
            r5 = r3
            r3 = r45
            goto L_0x0109
        L_0x0988:
            r8 = r1
            r5 = r7
            r2 = r9
            r0 = 0
            if (r26 == 0) goto L_0x099c
            r2.setWordSpacing(r0)
            r2.setCharacterSpacing(r0)
            boolean r1 = r61.isNewlineSplit()
            if (r1 == 0) goto L_0x099c
            r10 = 0
            goto L_0x099e
        L_0x099c:
            r10 = r27
        L_0x099e:
            if (r33 == 0) goto L_0x09a9
            float r1 = r62.getXTLM()
            float r1 = r30 - r1
            r2.moveText(r1, r0)
        L_0x09a9:
            r0 = 0
            r64[r0] = r8
            java.lang.Float r0 = new java.lang.Float
            r0.<init>(r10)
            r1 = 1
            r64[r1] = r0
            return r28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDocument.writeLineToContent(com.itextpdf.text.pdf.PdfLine, com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfContentByte, java.lang.Object[], float):float");
    }

    /* access modifiers changed from: protected */
    public float indentLeft() {
        return left(this.indentation.indentLeft + this.indentation.listIndentLeft + this.indentation.imageIndentLeft + this.indentation.sectionIndentLeft);
    }

    /* access modifiers changed from: protected */
    public float indentRight() {
        return right(this.indentation.indentRight + this.indentation.sectionIndentRight + this.indentation.imageIndentRight);
    }

    /* access modifiers changed from: protected */
    public float indentTop() {
        return top(this.indentation.indentTop);
    }

    /* access modifiers changed from: package-private */
    public float indentBottom() {
        return bottom(this.indentation.indentBottom);
    }

    /* access modifiers changed from: protected */
    public void addSpacing(float f, float f2, Font font) {
        addSpacing(f, f2, font, false);
    }

    /* access modifiers changed from: protected */
    public void addSpacing(float f, float f2, Font font, boolean z) {
        float f3;
        if (f != 0.0f && !this.pageEmpty) {
            if (z) {
                f3 = f;
            } else {
                f3 = calculateLineHeight();
            }
            if (this.currentHeight + f3 > indentTop() - indentBottom()) {
                newPage();
                return;
            }
            this.leading = f;
            carriageReturn();
            if (font.isUnderlined() || font.isStrikethru()) {
                Font font2 = new Font(font);
                font2.setStyle(font2.getStyle() & -5 & -9);
                font = font2;
            }
            Chunk chunk = new Chunk(" ", font);
            if (z && this.pageEmpty) {
                chunk = new Chunk("", font);
            }
            chunk.process(this);
            carriageReturn();
            this.leading = f2;
        }
    }

    /* access modifiers changed from: package-private */
    public PdfInfo getInfo() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public PdfCatalog getCatalog(PdfIndirectReference pdfIndirectReference) {
        PdfCatalog pdfCatalog = new PdfCatalog(pdfIndirectReference, this.writer);
        if (this.rootOutline.getKids().size() > 0) {
            pdfCatalog.put(PdfName.PAGEMODE, PdfName.USEOUTLINES);
            pdfCatalog.put(PdfName.OUTLINES, this.rootOutline.indirectReference());
        }
        this.writer.getPdfVersion().addToCatalog(pdfCatalog);
        this.viewerPreferences.addToCatalog(pdfCatalog);
        if (this.pageLabels != null) {
            pdfCatalog.put(PdfName.PAGELABELS, this.pageLabels.getDictionary(this.writer));
        }
        pdfCatalog.addNames(this.localDestinations, getDocumentLevelJS(), this.documentFileAttachment, this.writer);
        String str = this.openActionName;
        if (str != null) {
            pdfCatalog.setOpenAction(getLocalGotoAction(str));
        } else {
            PdfAction pdfAction = this.openActionAction;
            if (pdfAction != null) {
                pdfCatalog.setOpenAction(pdfAction);
            }
        }
        PdfDictionary pdfDictionary = this.additionalActions;
        if (pdfDictionary != null) {
            pdfCatalog.setAdditionalActions(pdfDictionary);
        }
        if (this.collection != null) {
            pdfCatalog.put(PdfName.COLLECTION, this.collection);
        }
        if (this.annotationsImp.hasValidAcroForm()) {
            try {
                pdfCatalog.put(PdfName.ACROFORM, this.writer.addToBody(this.annotationsImp.getAcroForm()).getIndirectReference());
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (this.language != null) {
            pdfCatalog.put(PdfName.LANG, this.language);
        }
        return pdfCatalog;
    }

    /* access modifiers changed from: package-private */
    public void addOutline(PdfOutline pdfOutline, String str) {
        localDestination(str, pdfOutline.getPdfDestination());
    }

    public PdfOutline getRootOutline() {
        return this.rootOutline;
    }

    /* access modifiers changed from: package-private */
    public void calculateOutlineCount() {
        if (this.rootOutline.getKids().size() != 0) {
            traverseOutlineCount(this.rootOutline);
        }
    }

    /* access modifiers changed from: package-private */
    public void traverseOutlineCount(PdfOutline pdfOutline) {
        ArrayList<PdfOutline> kids = pdfOutline.getKids();
        PdfOutline parent = pdfOutline.parent();
        if (!kids.isEmpty()) {
            for (int i = 0; i < kids.size(); i++) {
                traverseOutlineCount(kids.get(i));
            }
            if (parent == null) {
                return;
            }
            if (pdfOutline.isOpen()) {
                parent.setCount(pdfOutline.getCount() + parent.getCount() + 1);
                return;
            }
            parent.setCount(parent.getCount() + 1);
            pdfOutline.setCount(-pdfOutline.getCount());
        } else if (parent != null) {
            parent.setCount(parent.getCount() + 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeOutlines() throws IOException {
        if (this.rootOutline.getKids().size() != 0) {
            outlineTree(this.rootOutline);
            PdfWriter pdfWriter = this.writer;
            PdfOutline pdfOutline = this.rootOutline;
            pdfWriter.addToBody(pdfOutline, pdfOutline.indirectReference());
        }
    }

    /* access modifiers changed from: package-private */
    public void outlineTree(PdfOutline pdfOutline) throws IOException {
        pdfOutline.setIndirectReference(this.writer.getPdfIndirectReference());
        if (pdfOutline.parent() != null) {
            pdfOutline.put(PdfName.PARENT, pdfOutline.parent().indirectReference());
        }
        ArrayList<PdfOutline> kids = pdfOutline.getKids();
        int size = kids.size();
        for (int i = 0; i < size; i++) {
            outlineTree(kids.get(i));
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                kids.get(i2).put(PdfName.PREV, kids.get(i2 - 1).indirectReference());
            }
            if (i2 < size - 1) {
                kids.get(i2).put(PdfName.NEXT, kids.get(i2 + 1).indirectReference());
            }
        }
        if (size > 0) {
            pdfOutline.put(PdfName.FIRST, kids.get(0).indirectReference());
            pdfOutline.put(PdfName.LAST, kids.get(size - 1).indirectReference());
        }
        for (int i3 = 0; i3 < size; i3++) {
            PdfOutline pdfOutline2 = kids.get(i3);
            this.writer.addToBody(pdfOutline2, pdfOutline2.indirectReference());
        }
    }

    /* access modifiers changed from: package-private */
    public void setViewerPreferences(int i) {
        this.viewerPreferences.setViewerPreferences(i);
    }

    /* access modifiers changed from: package-private */
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
    }

    /* access modifiers changed from: package-private */
    public void setPageLabels(PdfPageLabels pdfPageLabels) {
        this.pageLabels = pdfPageLabels;
    }

    public PdfPageLabels getPageLabels() {
        return this.pageLabels;
    }

    /* access modifiers changed from: package-private */
    public void localGoto(String str, float f, float f2, float f3, float f4) {
        this.annotationsImp.addPlainAnnotation(this.writer.createAnnotation(f, f2, f3, f4, getLocalGotoAction(str), null));
    }

    /* access modifiers changed from: package-private */
    public void remoteGoto(String str, String str2, float f, float f2, float f3, float f4) {
        this.annotationsImp.addPlainAnnotation(this.writer.createAnnotation(f, f2, f3, f4, new PdfAction(str, str2), null));
    }

    /* access modifiers changed from: package-private */
    public void remoteGoto(String str, int i, float f, float f2, float f3, float f4) {
        addAnnotation(this.writer.createAnnotation(f, f2, f3, f4, new PdfAction(str, i), null));
    }

    /* access modifiers changed from: package-private */
    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        addAnnotation(this.writer.createAnnotation(f, f2, f3, f4, pdfAction, null));
    }

    /* access modifiers changed from: package-private */
    public PdfAction getLocalGotoAction(String str) {
        Destination destination = this.localDestinations.get(str);
        if (destination == null) {
            destination = new Destination();
        }
        if (destination.action != null) {
            return destination.action;
        }
        if (destination.reference == null) {
            destination.reference = this.writer.getPdfIndirectReference();
        }
        PdfAction pdfAction = new PdfAction(destination.reference);
        destination.action = pdfAction;
        this.localDestinations.put(str, destination);
        return pdfAction;
    }

    /* access modifiers changed from: package-private */
    public boolean localDestination(String str, PdfDestination pdfDestination) {
        Destination destination = this.localDestinations.get(str);
        if (destination == null) {
            destination = new Destination();
        }
        if (destination.destination != null) {
            return false;
        }
        destination.destination = pdfDestination;
        this.localDestinations.put(str, destination);
        if (pdfDestination.hasPage()) {
            return true;
        }
        pdfDestination.addPage(this.writer.getCurrentPage());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void addJavaScript(PdfAction pdfAction) {
        if (pdfAction.get(PdfName.JS) != null) {
            try {
                HashMap<String, PdfObject> hashMap = this.documentLevelJS;
                DecimalFormat decimalFormat = SIXTEEN_DIGITS;
                int i = this.jsCounter;
                this.jsCounter = i + 1;
                hashMap.put(decimalFormat.format((long) i), this.writer.addToBody(pdfAction).getIndirectReference());
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new RuntimeException(MessageLocalization.getComposedMessage("only.javascript.actions.are.allowed", new Object[0]));
        }
    }

    /* access modifiers changed from: package-private */
    public void addJavaScript(String str, PdfAction pdfAction) {
        if (pdfAction.get(PdfName.JS) != null) {
            try {
                this.documentLevelJS.put(str, this.writer.addToBody(pdfAction).getIndirectReference());
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new RuntimeException(MessageLocalization.getComposedMessage("only.javascript.actions.are.allowed", new Object[0]));
        }
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, PdfObject> getDocumentLevelJS() {
        return this.documentLevelJS;
    }

    /* access modifiers changed from: package-private */
    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        if (str == null) {
            PdfString pdfString = (PdfString) pdfFileSpecification.get(PdfName.DESC);
            if (pdfString == null) {
                str = "";
            } else {
                str = PdfEncodings.convertToString(pdfString.getBytes(), null);
            }
        }
        pdfFileSpecification.addDescription(str, true);
        if (str.length() == 0) {
            str = "Unnamed";
        }
        String convertToString = PdfEncodings.convertToString(new PdfString(str, PdfObject.TEXT_UNICODE).getBytes(), null);
        int i = 0;
        while (this.documentFileAttachment.containsKey(convertToString)) {
            i++;
            convertToString = PdfEncodings.convertToString(new PdfString(str + " " + i, PdfObject.TEXT_UNICODE).getBytes(), null);
        }
        this.documentFileAttachment.put(convertToString, pdfFileSpecification.getReference());
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, PdfObject> getDocumentFileAttachment() {
        return this.documentFileAttachment;
    }

    /* access modifiers changed from: package-private */
    public void setOpenAction(String str) {
        this.openActionName = str;
        this.openActionAction = null;
    }

    /* access modifiers changed from: package-private */
    public void setOpenAction(PdfAction pdfAction) {
        this.openActionAction = pdfAction;
        this.openActionName = null;
    }

    /* access modifiers changed from: package-private */
    public void addAdditionalAction(PdfName pdfName, PdfAction pdfAction) {
        if (this.additionalActions == null) {
            this.additionalActions = new PdfDictionary();
        }
        if (pdfAction == null) {
            this.additionalActions.remove(pdfName);
        } else {
            this.additionalActions.put(pdfName, pdfAction);
        }
        if (this.additionalActions.size() == 0) {
            this.additionalActions = null;
        }
    }

    public void setCollection(PdfCollection pdfCollection) {
        this.collection = pdfCollection;
    }

    /* access modifiers changed from: package-private */
    public PdfAcroForm getAcroForm() {
        return this.annotationsImp.getAcroForm();
    }

    /* access modifiers changed from: package-private */
    public void setSigFlags(int i) {
        this.annotationsImp.setSigFlags(i);
    }

    /* access modifiers changed from: package-private */
    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.annotationsImp.addCalculationOrder(pdfFormField);
    }

    /* access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.pageEmpty = false;
        this.annotationsImp.addAnnotation(pdfAnnotation);
    }

    /* access modifiers changed from: package-private */
    public void setLanguage(String str) {
        this.language = new PdfString(str);
    }

    /* access modifiers changed from: package-private */
    public void setCropBoxSize(Rectangle rectangle) {
        setBoxSize("crop", rectangle);
    }

    /* access modifiers changed from: package-private */
    public void setBoxSize(String str, Rectangle rectangle) {
        if (rectangle == null) {
            this.boxSize.remove(str);
        } else {
            this.boxSize.put(str, new PdfRectangle(rectangle));
        }
    }

    /* access modifiers changed from: protected */
    public void setNewPageSizeAndMargins() {
        this.pageSize = this.nextPageSize;
        if (!this.marginMirroring || (getPageNumber() & 1) != 0) {
            this.marginLeft = this.nextMarginLeft;
            this.marginRight = this.nextMarginRight;
        } else {
            this.marginRight = this.nextMarginLeft;
            this.marginLeft = this.nextMarginRight;
        }
        if (!this.marginMirroringTopBottom || (getPageNumber() & 1) != 0) {
            this.marginTop = this.nextMarginTop;
            this.marginBottom = this.nextMarginBottom;
        } else {
            this.marginTop = this.nextMarginBottom;
            this.marginBottom = this.nextMarginTop;
        }
        if (!isTagged(this.writer)) {
            PdfContentByte pdfContentByte = new PdfContentByte(this.writer);
            this.text = pdfContentByte;
            pdfContentByte.reset();
        } else {
            this.text = this.graphics;
        }
        this.text.beginText();
        this.text.moveText(left(), top());
        if (isTagged(this.writer)) {
            this.textEmptySize = this.text.size();
        }
    }

    /* access modifiers changed from: package-private */
    public Rectangle getBoxSize(String str) {
        PdfRectangle pdfRectangle = this.thisBoxSize.get(str);
        if (pdfRectangle != null) {
            return pdfRectangle.getRectangle();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void setPageEmpty(boolean z) {
        this.pageEmpty = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isPageEmpty() {
        if (isTagged(this.writer)) {
            PdfWriter pdfWriter = this.writer;
            if (pdfWriter == null) {
                return true;
            }
            if (pdfWriter.getDirectContent().size(false) == 0 && this.writer.getDirectContentUnder().size(false) == 0 && this.text.size(false) - this.textEmptySize == 0 && (this.pageEmpty || this.writer.isPaused())) {
                return true;
            }
            return false;
        }
        PdfWriter pdfWriter2 = this.writer;
        if (pdfWriter2 == null) {
            return true;
        }
        if (pdfWriter2.getDirectContent().size() == 0 && this.writer.getDirectContentUnder().size() == 0 && (this.pageEmpty || this.writer.isPaused())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setDuration(int i) {
        if (i > 0) {
            this.writer.addPageDictEntry(PdfName.DUR, new PdfNumber(i));
        }
    }

    /* access modifiers changed from: package-private */
    public void setTransition(PdfTransition pdfTransition) {
        this.writer.addPageDictEntry(PdfName.TRANS, pdfTransition.getTransitionDictionary());
    }

    /* access modifiers changed from: package-private */
    public void setPageAction(PdfName pdfName, PdfAction pdfAction) {
        if (this.pageAA == null) {
            this.pageAA = new PdfDictionary();
        }
        this.pageAA.put(pdfName, pdfAction);
    }

    /* access modifiers changed from: package-private */
    public void setThumbnail(Image image) throws PdfException, DocumentException {
        PdfWriter pdfWriter = this.writer;
        PdfName pdfName = PdfName.THUMB;
        PdfWriter pdfWriter2 = this.writer;
        pdfWriter.addPageDictEntry(pdfName, pdfWriter2.getImageReference(pdfWriter2.addDirectImageSimple(image)));
    }

    /* access modifiers changed from: package-private */
    public PageResources getPageResources() {
        return this.pageResources;
    }

    /* access modifiers changed from: package-private */
    public boolean isStrictImageSequence() {
        return this.strictImageSequence;
    }

    /* access modifiers changed from: package-private */
    public void setStrictImageSequence(boolean z) {
        this.strictImageSequence = z;
    }

    public void clearTextWrap() {
        float f = this.imageEnd - this.currentHeight;
        PdfLine pdfLine = this.line;
        if (pdfLine != null) {
            f += pdfLine.height();
        }
        if (this.imageEnd > -1.0f && f > 0.0f) {
            carriageReturn();
            this.currentHeight += f;
        }
    }

    public int getStructParentIndex(Object obj) {
        int[] iArr = this.structParentIndices.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.structParentIndices.size(), 0};
            this.structParentIndices.put(obj, iArr);
        }
        return iArr[0];
    }

    public int getNextMarkPoint(Object obj) {
        int[] iArr = this.structParentIndices.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.structParentIndices.size(), 0};
            this.structParentIndices.put(obj, iArr);
        }
        int i = iArr[1];
        iArr[1] = iArr[1] + 1;
        return i;
    }

    public int[] getStructParentIndexAndNextMarkPoint(Object obj) {
        int[] iArr = this.structParentIndices.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.structParentIndices.size(), 0};
            this.structParentIndices.put(obj, iArr);
        }
        int i = iArr[1];
        iArr[1] = iArr[1] + 1;
        return new int[]{iArr[0], i};
    }

    /* access modifiers changed from: protected */
    public void add(Image image) throws PdfException, DocumentException {
        float f;
        if (image.hasAbsoluteY()) {
            this.graphics.addImage(image);
            this.pageEmpty = false;
            return;
        }
        if (this.currentHeight != 0.0f && (indentTop() - this.currentHeight) - image.getScaledHeight() < indentBottom()) {
            if (this.strictImageSequence || this.imageWait != null) {
                newPage();
                if (this.currentHeight != 0.0f && (indentTop() - this.currentHeight) - image.getScaledHeight() < indentBottom()) {
                    this.imageWait = image;
                    return;
                }
            } else {
                this.imageWait = image;
                return;
            }
        }
        this.pageEmpty = false;
        if (image == this.imageWait) {
            this.imageWait = null;
        }
        boolean z = (image.getAlignment() & 4) == 4 && (image.getAlignment() & 1) != 1;
        boolean z2 = (image.getAlignment() & 8) == 8;
        float f2 = this.leading;
        float f3 = f2 / 2.0f;
        if (z) {
            f3 += f2;
        }
        float indentTop = ((indentTop() - this.currentHeight) - image.getScaledHeight()) - f3;
        float[] matrix = image.matrix();
        float indentLeft = indentLeft() - matrix[4];
        if ((image.getAlignment() & 2) == 2) {
            indentLeft = (indentRight() - image.getScaledWidth()) - matrix[4];
        }
        if ((image.getAlignment() & 1) == 1) {
            indentLeft = (indentLeft() + (((indentRight() - indentLeft()) - image.getScaledWidth()) / 2.0f)) - matrix[4];
        }
        if (image.hasAbsoluteX()) {
            indentLeft = image.getAbsoluteX();
        }
        if (z) {
            float f4 = this.imageEnd;
            if (f4 < 0.0f || f4 < this.currentHeight + image.getScaledHeight() + f3) {
                this.imageEnd = this.currentHeight + image.getScaledHeight() + f3;
            }
            if ((image.getAlignment() & 2) == 2) {
                this.indentation.imageIndentRight += image.getScaledWidth() + image.getIndentationLeft();
            } else {
                this.indentation.imageIndentLeft += image.getScaledWidth() + image.getIndentationRight();
            }
        } else if ((image.getAlignment() & 2) == 2) {
            indentLeft -= image.getIndentationRight();
        } else {
            if ((image.getAlignment() & 1) == 1) {
                f = image.getIndentationLeft() - image.getIndentationRight();
            } else {
                f = image.getIndentationLeft();
            }
            indentLeft += f;
        }
        this.graphics.addImage(image, matrix[0], matrix[1], matrix[2], matrix[3], indentLeft, indentTop - matrix[5]);
        if (!z && !z2) {
            this.currentHeight += image.getScaledHeight() + f3;
            flushLines();
            this.text.moveText(0.0f, -(image.getScaledHeight() + f3));
            newLine();
        }
    }

    /* access modifiers changed from: package-private */
    public void addPTable(PdfPTable pdfPTable) throws DocumentException {
        ColumnText columnText = new ColumnText(isTagged(this.writer) ? this.text : this.writer.getDirectContent());
        columnText.setRunDirection(pdfPTable.getRunDirection());
        if (pdfPTable.getKeepTogether() && !fitsPage(pdfPTable, 0.0f) && this.currentHeight > 0.0f) {
            newPage();
            if (isTagged(this.writer)) {
                columnText.setCanvas(this.text);
            }
        }
        if (this.currentHeight == 0.0f) {
            columnText.setAdjustFirstLine(false);
        }
        columnText.addElement(pdfPTable);
        boolean isHeadersInEvent = pdfPTable.isHeadersInEvent();
        pdfPTable.setHeadersInEvent(true);
        int i = 0;
        while (true) {
            columnText.setSimpleColumn(indentLeft(), indentBottom(), indentRight(), indentTop() - this.currentHeight);
            if ((columnText.go() & 1) != 0) {
                if (isTagged(this.writer)) {
                    this.text.setTextMatrix(indentLeft(), columnText.getYLine());
                } else {
                    this.text.moveText(0.0f, (columnText.getYLine() - indentTop()) + this.currentHeight);
                }
                this.currentHeight = indentTop() - columnText.getYLine();
                pdfPTable.setHeadersInEvent(isHeadersInEvent);
                return;
            }
            i = indentTop() - this.currentHeight == columnText.getYLine() ? i + 1 : 0;
            if (i != 3) {
                this.currentHeight = indentTop() - columnText.getYLine();
                newPage();
                if (isTagged(this.writer)) {
                    columnText.setCanvas(this.text);
                }
            } else {
                throw new DocumentException(MessageLocalization.getComposedMessage("infinite.table.loop", new Object[0]));
            }
        }
    }

    private void addDiv(PdfDiv pdfDiv) throws DocumentException {
        if (this.floatingElements == null) {
            this.floatingElements = new ArrayList<>();
        }
        this.floatingElements.add(pdfDiv);
    }

    private void flushFloatingElements() throws DocumentException {
        ArrayList<Element> arrayList = this.floatingElements;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<Element> arrayList2 = this.floatingElements;
            this.floatingElements = null;
            FloatLayout floatLayout = new FloatLayout(arrayList2, false);
            int i = 0;
            while (true) {
                indentLeft();
                floatLayout.setSimpleColumn(indentLeft(), indentBottom(), indentRight(), indentTop() - this.currentHeight);
                try {
                    if ((floatLayout.layout(isTagged(this.writer) ? this.text : this.writer.getDirectContent(), false) & 1) != 0) {
                        if (isTagged(this.writer)) {
                            this.text.setTextMatrix(indentLeft(), floatLayout.getYLine());
                        } else {
                            this.text.moveText(0.0f, (floatLayout.getYLine() - indentTop()) + this.currentHeight);
                        }
                        this.currentHeight = indentTop() - floatLayout.getYLine();
                        return;
                    }
                    i = (indentTop() - this.currentHeight == floatLayout.getYLine() || isPageEmpty()) ? i + 1 : 0;
                    if (i != 2) {
                        newPage();
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean fitsPage(PdfPTable pdfPTable, float f) {
        if (!pdfPTable.isLockedWidth()) {
            pdfPTable.setTotalWidth(((indentRight() - indentLeft()) * pdfPTable.getWidthPercentage()) / 100.0f);
        }
        ensureNewLine();
        float floatValue = Float.valueOf(pdfPTable.isSkipFirstHeader() ? pdfPTable.getTotalHeight() - pdfPTable.getHeaderHeight() : pdfPTable.getTotalHeight()).floatValue();
        float f2 = 0.0f;
        if (this.currentHeight > 0.0f) {
            f2 = pdfPTable.spacingBefore();
        }
        return floatValue + f2 <= ((indentTop() - this.currentHeight) - indentBottom()) - f;
    }

    private static boolean isTagged(PdfWriter pdfWriter) {
        return pdfWriter != null && pdfWriter.isTagged();
    }

    private PdfLine getLastLine() {
        if (this.lines.size() <= 0) {
            return null;
        }
        ArrayList<PdfLine> arrayList = this.lines;
        return arrayList.get(arrayList.size() - 1);
    }

    public class Destination {
        public PdfAction action;
        public PdfDestination destination;
        public PdfIndirectReference reference;

        public Destination() {
        }
    }

    /* access modifiers changed from: protected */
    public void useExternalCache(TempFileCache tempFileCache) {
        this.isToUseExternalCache = true;
        this.externalCache = tempFileCache;
    }

    /* access modifiers changed from: protected */
    public void saveStructElement(AccessibleElementId accessibleElementId, PdfStructureElement pdfStructureElement) {
        this.structElements.put(accessibleElementId, pdfStructureElement);
    }

    /* access modifiers changed from: protected */
    public PdfStructureElement getStructElement(AccessibleElementId accessibleElementId) {
        return getStructElement(accessibleElementId, true);
    }

    /* access modifiers changed from: protected */
    public PdfStructureElement getStructElement(AccessibleElementId accessibleElementId, boolean z) {
        TempFileCache.ObjectPosition objectPosition;
        PdfStructureElement pdfStructureElement = this.structElements.get(accessibleElementId);
        if (this.isToUseExternalCache && pdfStructureElement == null && (objectPosition = this.externallyStoredStructElements.get(accessibleElementId)) != null) {
            try {
                pdfStructureElement = (PdfStructureElement) this.externalCache.get(objectPosition);
                pdfStructureElement.setStructureTreeRoot(this.writer.getStructureTreeRoot());
                pdfStructureElement.setStructureElementParent(getStructElement(this.elementsParents.get(pdfStructureElement.getElementId()), z));
                if (z) {
                    this.externallyStoredStructElements.remove(accessibleElementId);
                    this.structElements.put(accessibleElementId, pdfStructureElement);
                }
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            } catch (ClassNotFoundException e2) {
                throw new ExceptionConverter(e2);
            }
        }
        return pdfStructureElement;
    }

    /* access modifiers changed from: protected */
    public void flushStructureElementsOnNewPage() {
        if (this.isToUseExternalCache) {
            Iterator<Map.Entry<AccessibleElementId, PdfStructureElement>> it2 = this.structElements.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<AccessibleElementId, PdfStructureElement> next = it2.next();
                if (!next.getValue().getStructureType().equals(PdfName.DOCUMENT)) {
                    try {
                        PdfStructureElement value = next.getValue();
                        PdfDictionary parent = value.getParent();
                        PdfStructureElement pdfStructureElement = null;
                        if (parent instanceof PdfStructureElement) {
                            pdfStructureElement = (PdfStructureElement) parent;
                        }
                        if (pdfStructureElement != null) {
                            this.elementsParents.put(next.getKey(), pdfStructureElement.getElementId());
                        }
                        this.externallyStoredStructElements.put(next.getKey(), this.externalCache.put(value));
                        it2.remove();
                    } catch (IOException e) {
                        throw new ExceptionConverter(e);
                    }
                }
            }
        }
    }

    public Set<AccessibleElementId> getStructElements() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.externallyStoredStructElements.keySet());
        hashSet.addAll(this.structElements.keySet());
        return hashSet;
    }
}
