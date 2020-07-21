package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgJBIG2;
import com.itextpdf.text.ImgWMF;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.io.TempFileCache;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.events.PdfPageEventForwarder;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.PdfAnnotations;
import com.itextpdf.text.pdf.interfaces.PdfDocumentActions;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfIsoConformance;
import com.itextpdf.text.pdf.interfaces.PdfPageActions;
import com.itextpdf.text.pdf.interfaces.PdfRunDirection;
import com.itextpdf.text.pdf.interfaces.PdfVersion;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.interfaces.PdfXConformance;
import com.itextpdf.text.pdf.internal.PdfVersionImp;
import com.itextpdf.text.pdf.internal.PdfXConformanceImp;
import com.itextpdf.text.xml.xmp.PdfProperties;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.options.PropertyOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class PdfWriter extends DocWriter implements PdfViewerPreferences, PdfEncryptionSettings, PdfVersion, PdfDocumentActions, PdfPageActions, PdfRunDirection, PdfAnnotations {
    public static final int ALLOW_ASSEMBLY = 1024;
    public static final int ALLOW_COPY = 16;
    public static final int ALLOW_DEGRADED_PRINTING = 4;
    public static final int ALLOW_FILL_IN = 256;
    public static final int ALLOW_MODIFY_ANNOTATIONS = 32;
    public static final int ALLOW_MODIFY_CONTENTS = 8;
    public static final int ALLOW_PRINTING = 2052;
    public static final int ALLOW_SCREENREADERS = 512;
    @Deprecated
    public static final int AllowAssembly = 1024;
    @Deprecated
    public static final int AllowCopy = 16;
    @Deprecated
    public static final int AllowDegradedPrinting = 4;
    @Deprecated
    public static final int AllowFillIn = 256;
    @Deprecated
    public static final int AllowModifyAnnotations = 32;
    @Deprecated
    public static final int AllowModifyContents = 8;
    @Deprecated
    public static final int AllowPrinting = 2052;
    @Deprecated
    public static final int AllowScreenReaders = 512;
    protected static Counter COUNTER = CounterFactory.getCounter(PdfWriter.class);
    public static final int CenterWindow = 65536;
    public static final PdfName DID_PRINT = PdfName.DP;
    public static final PdfName DID_SAVE = PdfName.DS;
    public static final PdfName DOCUMENT_CLOSE = PdfName.WC;
    public static final int DO_NOT_ENCRYPT_METADATA = 8;
    public static final int DirectionL2R = 4194304;
    public static final int DirectionR2L = 8388608;
    public static final int DisplayDocTitle = 131072;
    public static final int EMBEDDED_FILES_ONLY = 24;
    public static final int ENCRYPTION_AES_128 = 2;
    public static final int ENCRYPTION_AES_256 = 3;
    static final int ENCRYPTION_MASK = 7;
    public static final int FitWindow = 32768;
    public static final int GENERATION_MAX = 65535;
    public static final int HideMenubar = 8192;
    public static final int HideToolbar = 4096;
    public static final int HideWindowUI = 16384;
    public static final float NO_SPACE_CHAR_RATIO = 1.0E7f;
    public static final int NonFullScreenPageModeUseNone = 262144;
    public static final int NonFullScreenPageModeUseOC = 2097152;
    public static final int NonFullScreenPageModeUseOutlines = 524288;
    public static final int NonFullScreenPageModeUseThumbs = 1048576;
    public static final PdfName PAGE_CLOSE = PdfName.C;
    public static final PdfName PAGE_OPEN = PdfName.O;
    public static final int PDFX1A2001 = 1;
    public static final int PDFX32002 = 2;
    public static final int PDFXNONE = 0;
    public static final PdfName PDF_VERSION_1_2 = new PdfName("1.2");
    public static final PdfName PDF_VERSION_1_3 = new PdfName("1.3");
    public static final PdfName PDF_VERSION_1_4 = new PdfName("1.4");
    public static final PdfName PDF_VERSION_1_5 = new PdfName("1.5");
    public static final PdfName PDF_VERSION_1_6 = new PdfName("1.6");
    public static final PdfName PDF_VERSION_1_7 = new PdfName("1.7");
    public static final int PageLayoutOneColumn = 2;
    public static final int PageLayoutSinglePage = 1;
    public static final int PageLayoutTwoColumnLeft = 4;
    public static final int PageLayoutTwoColumnRight = 8;
    public static final int PageLayoutTwoPageLeft = 16;
    public static final int PageLayoutTwoPageRight = 32;
    public static final int PageModeFullScreen = 512;
    public static final int PageModeUseAttachments = 2048;
    public static final int PageModeUseNone = 64;
    public static final int PageModeUseOC = 1024;
    public static final int PageModeUseOutlines = 128;
    public static final int PageModeUseThumbs = 256;
    public static final int PrintScalingNone = 16777216;
    public static final int RUN_DIRECTION_DEFAULT = 0;
    public static final int RUN_DIRECTION_LTR = 2;
    public static final int RUN_DIRECTION_NO_BIDI = 1;
    public static final int RUN_DIRECTION_RTL = 3;
    public static final int SIGNATURE_APPEND_ONLY = 2;
    public static final int SIGNATURE_EXISTS = 1;
    public static final float SPACE_CHAR_RATIO_DEFAULT = 2.5f;
    public static final int STANDARD_ENCRYPTION_128 = 1;
    public static final int STANDARD_ENCRYPTION_40 = 0;
    @Deprecated
    public static final boolean STRENGTH128BITS = true;
    @Deprecated
    public static final boolean STRENGTH40BITS = false;
    public static final char VERSION_1_2 = '2';
    public static final char VERSION_1_3 = '3';
    public static final char VERSION_1_4 = '4';
    public static final char VERSION_1_5 = '5';
    public static final char VERSION_1_6 = '6';
    public static final char VERSION_1_7 = '7';
    public static final PdfName WILL_PRINT = PdfName.WP;
    public static final PdfName WILL_SAVE = PdfName.WS;
    public static final int markAll = 0;
    public static final int markInlineElementsOnly = 1;
    private static final List<PdfName> standardStructElems_1_4 = Arrays.asList(PdfName.DOCUMENT, PdfName.PART, PdfName.ART, PdfName.SECT, PdfName.DIV, PdfName.BLOCKQUOTE, PdfName.CAPTION, PdfName.TOC, PdfName.TOCI, PdfName.INDEX, PdfName.NONSTRUCT, PdfName.PRIVATE, PdfName.P, PdfName.H, PdfName.H1, PdfName.H2, PdfName.H3, PdfName.H4, PdfName.H5, PdfName.H6, PdfName.L, PdfName.LBL, PdfName.LI, PdfName.LBODY, PdfName.TABLE, PdfName.TR, PdfName.TH, PdfName.TD, PdfName.SPAN, PdfName.QUOTE, PdfName.NOTE, PdfName.REFERENCE, PdfName.BIBENTRY, PdfName.CODE, PdfName.LINK, PdfName.FIGURE, PdfName.FORMULA, PdfName.FORM);
    private static final List<PdfName> standardStructElems_1_7 = Arrays.asList(PdfName.DOCUMENT, PdfName.PART, PdfName.ART, PdfName.SECT, PdfName.DIV, PdfName.BLOCKQUOTE, PdfName.CAPTION, PdfName.TOC, PdfName.TOCI, PdfName.INDEX, PdfName.NONSTRUCT, PdfName.PRIVATE, PdfName.P, PdfName.H, PdfName.H1, PdfName.H2, PdfName.H3, PdfName.H4, PdfName.H5, PdfName.H6, PdfName.L, PdfName.LBL, PdfName.LI, PdfName.LBODY, PdfName.TABLE, PdfName.TR, PdfName.TH, PdfName.TD, PdfName.THEAD, PdfName.TBODY, PdfName.TFOOT, PdfName.SPAN, PdfName.QUOTE, PdfName.NOTE, PdfName.REFERENCE, PdfName.BIBENTRY, PdfName.CODE, PdfName.LINK, PdfName.ANNOT, PdfName.RUBY, PdfName.RB, PdfName.RT, PdfName.RP, PdfName.WARICHU, PdfName.WT, PdfName.WP, PdfName.FIGURE, PdfName.FORMULA, PdfName.FORM);
    protected HashMap<PdfStream, PdfIndirectReference> JBIG2Globals = new HashMap<>();
    protected PdfArray OCGLocked = new PdfArray();
    protected PdfArray OCGRadioGroup = new PdfArray();
    protected PdfOCProperties OCProperties;
    protected PdfBody body;
    protected int colorNumber = 1;
    protected ICC_Profile colorProfile;
    protected int compressionLevel = -1;
    protected PdfEncryption crypto;
    protected int currentPageNumber = 1;
    protected PdfReaderInstance currentPdfReaderInstance;
    protected PdfDictionary defaultColorspace = new PdfDictionary();
    protected PdfContentByte directContent;
    protected PdfContentByte directContentUnder;
    protected HashMap<ICachedColorSpace, ColorDetails> documentColors = new HashMap<>();
    protected HashMap<PdfDictionary, PdfObject[]> documentExtGState = new HashMap<>();
    protected LinkedHashMap<BaseFont, FontDetails> documentFonts = new LinkedHashMap<>();
    protected LinkedHashSet<PdfOCG> documentOCG = new LinkedHashSet<>();
    protected ArrayList<PdfOCG> documentOCGorder = new ArrayList<>();
    protected HashMap<PdfPatternPainter, PdfName> documentPatterns = new HashMap<>();
    protected HashMap<Object, PdfObject[]> documentProperties = new HashMap<>();
    protected HashSet<PdfShadingPattern> documentShadingPatterns = new HashSet<>();
    protected HashSet<PdfShading> documentShadings = new HashSet<>();
    protected HashMap<ColorDetails, ColorDetails> documentSpotPatterns = new HashMap<>();
    protected PdfDictionary extraCatalog;
    protected int fontNumber = 1;
    protected HashMap<PdfIndirectReference, Object[]> formXObjects = new HashMap<>();
    protected int formXObjectsCounter = 1;
    protected boolean fullCompression = false;
    protected PdfDictionary group;
    protected PdfDictionary imageDictionary = new PdfDictionary();
    private final HashMap<Long, PdfName> images = new HashMap<>();
    protected List<HashMap<String, Object>> newBookmarks;
    protected byte[] originalFileID = null;
    protected PdfDictionary pageDictEntries = new PdfDictionary();
    private PdfPageEvent pageEvent;
    protected ArrayList<PdfIndirectReference> pageReferences = new ArrayList<>();
    protected ColorDetails patternColorspaceCMYK;
    protected ColorDetails patternColorspaceGRAY;
    protected ColorDetails patternColorspaceRGB;
    protected int patternNumber = 1;
    protected PdfDocument pdf;
    protected PdfIsoConformance pdfIsoConformance = initPdfIsoConformance();
    protected PdfVersionImp pdf_version = new PdfVersionImp();
    protected long prevxref = 0;
    protected HashMap<PdfReader, PdfReaderInstance> readerInstances = new HashMap<>();
    private boolean rgbTransparencyBlending;
    protected PdfPages root = new PdfPages(this);
    protected int runDirection = 1;
    private float spaceCharRatio = 2.5f;
    protected PdfStructureTreeRoot structureTreeRoot;
    protected PdfName tabs = null;
    protected boolean tagged = false;
    protected int taggingMode = 1;
    protected TtfUnicodeWriter ttfUnicodeWriter = null;
    private boolean userProperties;
    protected byte[] xmpMetadata = null;
    protected XmpWriter xmpWriter = null;

    /* access modifiers changed from: protected */
    public void cacheObject(PdfIndirectObject pdfIndirectObject) {
    }

    /* access modifiers changed from: protected */
    public void flushAcroFields() throws IOException, BadPdfFormatException {
    }

    /* access modifiers changed from: protected */
    public void flushTaggedObjects() throws IOException {
    }

    public static class PdfBody {
        private static final int OBJSINSTREAM = 200;
        protected int currentObjNum;
        protected ByteBuffer index;
        protected int numObj = 0;
        protected long position;
        protected int refnum;
        protected ByteBuffer streamObjects;
        protected final PdfWriter writer;
        protected final TreeSet<PdfCrossReference> xrefs;

        public static class PdfCrossReference implements Comparable<PdfCrossReference> {
            private final int generation;
            private final long offset;
            private final int refnum;
            private final int type;

            public PdfCrossReference(int i, long j, int i2) {
                this.type = 0;
                this.offset = j;
                this.refnum = i;
                this.generation = i2;
            }

            public PdfCrossReference(int i, long j) {
                this.type = 1;
                this.offset = j;
                this.refnum = i;
                this.generation = 0;
            }

            public PdfCrossReference(int i, int i2, long j, int i3) {
                this.type = i;
                this.offset = j;
                this.refnum = i2;
                this.generation = i3;
            }

            public int getRefnum() {
                return this.refnum;
            }

            public void toPdf(OutputStream outputStream) throws IOException {
                StringBuffer stringBuffer = new StringBuffer("0000000000");
                stringBuffer.append(this.offset);
                stringBuffer.delete(0, stringBuffer.length() - 10);
                StringBuffer stringBuffer2 = new StringBuffer("00000");
                stringBuffer2.append(this.generation);
                stringBuffer2.delete(0, stringBuffer2.length() - 5);
                stringBuffer.append(' ');
                stringBuffer.append(stringBuffer2);
                stringBuffer.append(this.generation == 65535 ? " f \n" : " n \n");
                outputStream.write(DocWriter.getISOBytes(stringBuffer.toString()));
            }

            public void toPdf(int i, OutputStream outputStream) throws IOException {
                outputStream.write((byte) this.type);
                while (true) {
                    i--;
                    if (i >= 0) {
                        outputStream.write((byte) ((int) ((this.offset >>> (i * 8)) & 255)));
                    } else {
                        outputStream.write((byte) ((this.generation >>> 8) & 255));
                        outputStream.write((byte) (this.generation & 255));
                        return;
                    }
                }
            }

            public int compareTo(PdfCrossReference pdfCrossReference) {
                int i = this.refnum;
                int i2 = pdfCrossReference.refnum;
                if (i < i2) {
                    return -1;
                }
                return i == i2 ? 0 : 1;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof PdfCrossReference) || this.refnum != ((PdfCrossReference) obj).refnum) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return this.refnum;
            }
        }

        protected PdfBody(PdfWriter pdfWriter) {
            TreeSet<PdfCrossReference> treeSet = new TreeSet<>();
            this.xrefs = treeSet;
            treeSet.add(new PdfCrossReference(0, 0, 65535));
            this.position = pdfWriter.getOs().getCounter();
            this.refnum = 1;
            this.writer = pdfWriter;
        }

        /* access modifiers changed from: package-private */
        public void setRefnum(int i) {
            this.refnum = i;
        }

        /* access modifiers changed from: protected */
        public PdfCrossReference addToObjStm(PdfObject pdfObject, int i) throws IOException {
            if (this.numObj >= 200) {
                flushObjStm();
            }
            if (this.index == null) {
                this.index = new ByteBuffer();
                this.streamObjects = new ByteBuffer();
                this.currentObjNum = getIndirectReferenceNumber();
                this.numObj = 0;
            }
            int size = this.streamObjects.size();
            int i2 = this.numObj;
            this.numObj = i2 + 1;
            PdfEncryption pdfEncryption = this.writer.crypto;
            this.writer.crypto = null;
            pdfObject.toPdf(this.writer, this.streamObjects);
            this.writer.crypto = pdfEncryption;
            this.streamObjects.append(' ');
            this.index.append(i).append(' ').append(size).append(' ');
            return new PdfCrossReference(2, i, (long) this.currentObjNum, i2);
        }

        public void flushObjStm() throws IOException {
            if (this.numObj != 0) {
                int size = this.index.size();
                this.index.append(this.streamObjects);
                PdfStream pdfStream = new PdfStream(this.index.toByteArray());
                pdfStream.flateCompress(this.writer.getCompressionLevel());
                pdfStream.put(PdfName.TYPE, PdfName.OBJSTM);
                pdfStream.put(PdfName.N, new PdfNumber(this.numObj));
                pdfStream.put(PdfName.FIRST, new PdfNumber(size));
                add(pdfStream, this.currentObjNum);
                this.index = null;
                this.streamObjects = null;
                this.numObj = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject) throws IOException {
            return add(pdfObject, getIndirectReferenceNumber());
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, boolean z) throws IOException {
            return add(pdfObject, getIndirectReferenceNumber(), 0, z);
        }

        public PdfIndirectReference getPdfIndirectReference() {
            return new PdfIndirectReference(0, getIndirectReferenceNumber());
        }

        /* access modifiers changed from: protected */
        public int getIndirectReferenceNumber() {
            int i = this.refnum;
            this.refnum = i + 1;
            this.xrefs.add(new PdfCrossReference(i, 0, 65535));
            return i;
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) throws IOException {
            return add(pdfObject, pdfIndirectReference, true);
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
            return add(pdfObject, pdfIndirectReference.getNumber(), pdfIndirectReference.getGeneration(), z);
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, int i) throws IOException {
            return add(pdfObject, i, 0, true);
        }

        /* access modifiers changed from: protected */
        public PdfIndirectObject add(PdfObject pdfObject, int i, int i2, boolean z) throws IOException {
            if (z && pdfObject.canBeInObjStm() && this.writer.isFullCompression()) {
                PdfCrossReference addToObjStm = addToObjStm(pdfObject, i);
                PdfIndirectObject pdfIndirectObject = new PdfIndirectObject(i, pdfObject, this.writer);
                if (!this.xrefs.add(addToObjStm)) {
                    this.xrefs.remove(addToObjStm);
                    this.xrefs.add(addToObjStm);
                }
                return pdfIndirectObject;
            } else if (this.writer.isFullCompression()) {
                PdfIndirectObject pdfIndirectObject2 = new PdfIndirectObject(i, pdfObject, this.writer);
                write(pdfIndirectObject2, i);
                return pdfIndirectObject2;
            } else {
                PdfIndirectObject pdfIndirectObject3 = new PdfIndirectObject(i, i2, pdfObject, this.writer);
                write(pdfIndirectObject3, i, i2);
                return pdfIndirectObject3;
            }
        }

        /* access modifiers changed from: protected */
        public void write(PdfIndirectObject pdfIndirectObject, int i) throws IOException {
            PdfCrossReference pdfCrossReference = new PdfCrossReference(i, this.position);
            if (!this.xrefs.add(pdfCrossReference)) {
                this.xrefs.remove(pdfCrossReference);
                this.xrefs.add(pdfCrossReference);
            }
            pdfIndirectObject.writeTo(this.writer.getOs());
            this.position = this.writer.getOs().getCounter();
        }

        /* access modifiers changed from: protected */
        public void write(PdfIndirectObject pdfIndirectObject, int i, int i2) throws IOException {
            PdfCrossReference pdfCrossReference = new PdfCrossReference(i, this.position, i2);
            if (!this.xrefs.add(pdfCrossReference)) {
                this.xrefs.remove(pdfCrossReference);
                this.xrefs.add(pdfCrossReference);
            }
            pdfIndirectObject.writeTo(this.writer.getOs());
            this.position = this.writer.getOs().getCounter();
        }

        public long offset() {
            return this.position;
        }

        public int size() {
            return Math.max(this.xrefs.last().getRefnum() + 1, this.refnum);
        }

        public void writeCrossReferenceTable(OutputStream outputStream, PdfIndirectReference pdfIndirectReference, PdfIndirectReference pdfIndirectReference2, PdfIndirectReference pdfIndirectReference3, PdfObject pdfObject, long j) throws IOException {
            int i;
            int i2;
            if (this.writer.isFullCompression()) {
                flushObjStm();
                i = getIndirectReferenceNumber();
                this.xrefs.add(new PdfCrossReference(i, this.position));
            } else {
                i = 0;
            }
            int refnum2 = this.xrefs.first().getRefnum();
            ArrayList arrayList = new ArrayList();
            Iterator<PdfCrossReference> it2 = this.xrefs.iterator();
            int i3 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PdfCrossReference next = it2.next();
                if (refnum2 + i3 == next.getRefnum()) {
                    i3++;
                } else {
                    arrayList.add(Integer.valueOf(refnum2));
                    arrayList.add(Integer.valueOf(i3));
                    refnum2 = next.getRefnum();
                    i3 = 1;
                }
            }
            arrayList.add(Integer.valueOf(refnum2));
            arrayList.add(Integer.valueOf(i3));
            if (this.writer.isFullCompression()) {
                int i4 = 5;
                long j2 = 1095216660480L;
                for (i2 = 1; i4 > i2 && (this.position & j2) == 0; i2 = 1) {
                    j2 >>>= 8;
                    i4--;
                }
                ByteBuffer byteBuffer = new ByteBuffer();
                Iterator<PdfCrossReference> it3 = this.xrefs.iterator();
                while (it3.hasNext()) {
                    it3.next().toPdf(i4, byteBuffer);
                }
                PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
                pdfStream.flateCompress(this.writer.getCompressionLevel());
                pdfStream.put(PdfName.SIZE, new PdfNumber(size()));
                pdfStream.put(PdfName.ROOT, pdfIndirectReference);
                if (pdfIndirectReference2 != null) {
                    pdfStream.put(PdfName.INFO, pdfIndirectReference2);
                }
                if (pdfIndirectReference3 != null) {
                    pdfStream.put(PdfName.ENCRYPT, pdfIndirectReference3);
                }
                if (pdfObject != null) {
                    pdfStream.put(PdfName.ID, pdfObject);
                }
                pdfStream.put(PdfName.W, new PdfArray(new int[]{1, i4, 2}));
                pdfStream.put(PdfName.TYPE, PdfName.XREF);
                PdfArray pdfArray = new PdfArray();
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    pdfArray.add(new PdfNumber(((Integer) arrayList.get(i5)).intValue()));
                }
                pdfStream.put(PdfName.INDEX, pdfArray);
                if (j > 0) {
                    pdfStream.put(PdfName.PREV, new PdfNumber(j));
                }
                PdfEncryption pdfEncryption = this.writer.crypto;
                this.writer.crypto = null;
                new PdfIndirectObject(i, pdfStream, this.writer).writeTo(this.writer.getOs());
                this.writer.crypto = pdfEncryption;
                return;
            }
            outputStream.write(DocWriter.getISOBytes("xref\n"));
            Iterator<PdfCrossReference> it4 = this.xrefs.iterator();
            for (int i6 = 0; i6 < arrayList.size(); i6 += 2) {
                int intValue = ((Integer) arrayList.get(i6)).intValue();
                int intValue2 = ((Integer) arrayList.get(i6 + 1)).intValue();
                outputStream.write(DocWriter.getISOBytes(String.valueOf(intValue)));
                outputStream.write(DocWriter.getISOBytes(" "));
                outputStream.write(DocWriter.getISOBytes(String.valueOf(intValue2)));
                outputStream.write(10);
                while (true) {
                    int i7 = intValue2 - 1;
                    if (intValue2 <= 0) {
                        break;
                    }
                    it4.next().toPdf(outputStream);
                    intValue2 = i7;
                }
            }
        }
    }

    public static class PdfTrailer extends PdfDictionary {
        long offset;

        public PdfTrailer(int i, long j, PdfIndirectReference pdfIndirectReference, PdfIndirectReference pdfIndirectReference2, PdfIndirectReference pdfIndirectReference3, PdfObject pdfObject, long j2) {
            this.offset = j;
            put(PdfName.SIZE, new PdfNumber(i));
            put(PdfName.ROOT, pdfIndirectReference);
            if (pdfIndirectReference2 != null) {
                put(PdfName.INFO, pdfIndirectReference2);
            }
            if (pdfIndirectReference3 != null) {
                put(PdfName.ENCRYPT, pdfIndirectReference3);
            }
            if (pdfObject != null) {
                put(PdfName.ID, pdfObject);
            }
            if (j2 > 0) {
                put(PdfName.PREV, new PdfNumber(j2));
            }
        }

        @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
        public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
            PdfWriter.checkPdfIsoConformance(pdfWriter, 8, this);
            outputStream.write(DocWriter.getISOBytes("trailer\n"));
            super.toPdf(null, outputStream);
            outputStream.write(10);
            PdfWriter.writeKeyInfo(outputStream);
            outputStream.write(DocWriter.getISOBytes("startxref\n"));
            outputStream.write(DocWriter.getISOBytes(String.valueOf(this.offset)));
            outputStream.write(DocWriter.getISOBytes("\n%%EOF\n"));
        }
    }

    /* access modifiers changed from: protected */
    public Counter getCounter() {
        return COUNTER;
    }

    protected PdfWriter() {
    }

    protected PdfWriter(PdfDocument pdfDocument, OutputStream outputStream) {
        super(pdfDocument, outputStream);
        this.pdf = pdfDocument;
        PdfContentByte pdfContentByte = new PdfContentByte(this);
        this.directContentUnder = pdfContentByte;
        this.directContent = pdfContentByte.getDuplicate();
    }

    public static PdfWriter getInstance(Document document, OutputStream outputStream) throws DocumentException {
        PdfDocument pdfDocument = new PdfDocument();
        document.addDocListener(pdfDocument);
        PdfWriter pdfWriter = new PdfWriter(pdfDocument, outputStream);
        pdfDocument.addWriter(pdfWriter);
        return pdfWriter;
    }

    public static PdfWriter getInstance(Document document, OutputStream outputStream, DocListener docListener) throws DocumentException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.addDocListener(docListener);
        document.addDocListener(pdfDocument);
        PdfWriter pdfWriter = new PdfWriter(pdfDocument, outputStream);
        pdfDocument.addWriter(pdfWriter);
        return pdfWriter;
    }

    /* access modifiers changed from: package-private */
    public PdfDocument getPdfDocument() {
        return this.pdf;
    }

    public PdfDictionary getInfo() {
        return this.pdf.getInfo();
    }

    public float getVerticalPosition(boolean z) {
        return this.pdf.getVerticalPosition(z);
    }

    public void setInitialLeading(float f) throws DocumentException {
        if (!this.open) {
            this.pdf.setLeading(f);
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("you.can.t.set.the.initial.leading.if.the.document.is.already.open", new Object[0]));
    }

    public PdfContentByte getDirectContent() {
        if (this.open) {
            return this.directContent;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
    }

    public PdfContentByte getDirectContentUnder() {
        if (this.open) {
            return this.directContentUnder;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void resetContent() {
        this.directContent.reset();
        this.directContentUnder.reset();
    }

    public ICC_Profile getColorProfile() {
        return this.colorProfile;
    }

    /* access modifiers changed from: package-private */
    public void addLocalDestinations(TreeMap<String, PdfDocument.Destination> treeMap) throws IOException {
        for (Map.Entry<String, PdfDocument.Destination> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            PdfDocument.Destination value = entry.getValue();
            PdfDestination pdfDestination = value.destination;
            if (value.reference == null) {
                value.reference = getPdfIndirectReference();
            }
            if (pdfDestination == null) {
                addToBody(new PdfString("invalid_" + key), value.reference);
            } else {
                addToBody(pdfDestination, value.reference);
            }
        }
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject) throws IOException {
        PdfIndirectObject add = this.body.add(pdfObject);
        cacheObject(add);
        return add;
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, boolean z) throws IOException {
        PdfIndirectObject add = this.body.add(pdfObject, z);
        cacheObject(add);
        return add;
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) throws IOException {
        PdfIndirectObject add = this.body.add(pdfObject, pdfIndirectReference);
        cacheObject(add);
        return add;
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        PdfIndirectObject add = this.body.add(pdfObject, pdfIndirectReference, z);
        cacheObject(add);
        return add;
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, int i) throws IOException {
        PdfIndirectObject add = this.body.add(pdfObject, i);
        cacheObject(add);
        return add;
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, int i, boolean z) throws IOException {
        PdfIndirectObject add = this.body.add(pdfObject, i, 0, z);
        cacheObject(add);
        return add;
    }

    public PdfIndirectReference getPdfIndirectReference() {
        return this.body.getPdfIndirectReference();
    }

    /* access modifiers changed from: protected */
    public int getIndirectReferenceNumber() {
        return this.body.getIndirectReferenceNumber();
    }

    public OutputStreamCounter getOs() {
        return this.os;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
        buildStructTreeRootForTagged(catalog);
        if (!this.documentOCG.isEmpty()) {
            fillOCProperties(false);
            catalog.put(PdfName.OCPROPERTIES, this.OCProperties);
        }
        return catalog;
    }

    /* access modifiers changed from: protected */
    public void buildStructTreeRootForTagged(PdfDictionary pdfDictionary) {
        if (this.tagged) {
            try {
                getStructureTreeRoot().buildTree();
                for (AccessibleElementId accessibleElementId : this.pdf.getStructElements()) {
                    PdfStructureElement structElement = this.pdf.getStructElement(accessibleElementId, false);
                    addToBody(structElement, structElement.getReference());
                }
                pdfDictionary.put(PdfName.STRUCTTREEROOT, this.structureTreeRoot.getReference());
                PdfDictionary pdfDictionary2 = new PdfDictionary();
                pdfDictionary2.put(PdfName.MARKED, PdfBoolean.PDFTRUE);
                if (this.userProperties) {
                    pdfDictionary2.put(PdfName.USERPROPERTIES, PdfBoolean.PDFTRUE);
                }
                pdfDictionary.put(PdfName.MARKINFO, pdfDictionary2);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public PdfDictionary getExtraCatalog() {
        if (this.extraCatalog == null) {
            this.extraCatalog = new PdfDictionary();
        }
        return this.extraCatalog;
    }

    public void addPageDictEntry(PdfName pdfName, PdfObject pdfObject) {
        this.pageDictEntries.put(pdfName, pdfObject);
    }

    public PdfDictionary getPageDictEntries() {
        return this.pageDictEntries;
    }

    public void resetPageDictEntries() {
        this.pageDictEntries = new PdfDictionary();
    }

    public void setLinearPageMode() {
        this.root.setLinearMode(null);
    }

    public int reorderPages(int[] iArr) throws DocumentException {
        return this.root.reorderPages(iArr);
    }

    public PdfIndirectReference getPageReference(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(MessageLocalization.getComposedMessage("the.page.number.must.be.gt.eq.1", new Object[0]));
        } else if (i2 < this.pageReferences.size()) {
            PdfIndirectReference pdfIndirectReference = this.pageReferences.get(i2);
            if (pdfIndirectReference != null) {
                return pdfIndirectReference;
            }
            PdfIndirectReference pdfIndirectReference2 = this.body.getPdfIndirectReference();
            this.pageReferences.set(i2, pdfIndirectReference2);
            return pdfIndirectReference2;
        } else {
            int size = i2 - this.pageReferences.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.pageReferences.add(null);
            }
            PdfIndirectReference pdfIndirectReference3 = this.body.getPdfIndirectReference();
            this.pageReferences.add(pdfIndirectReference3);
            return pdfIndirectReference3;
        }
    }

    public int getPageNumber() {
        return this.pdf.getPageNumber();
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getCurrentPage() {
        return getPageReference(this.currentPageNumber);
    }

    public int getCurrentPageNumber() {
        return this.currentPageNumber;
    }

    public void setPageViewport(PdfArray pdfArray) {
        addPageDictEntry(PdfName.VP, pdfArray);
    }

    public void setTabs(PdfName pdfName) {
        this.tabs = pdfName;
    }

    public PdfName getTabs() {
        return this.tabs;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference add(PdfPage pdfPage, PdfContents pdfContents) throws PdfException {
        if (this.open) {
            try {
                pdfPage.add(addToBody(pdfContents).getIndirectReference());
                if (this.group != null) {
                    pdfPage.put(PdfName.GROUP, this.group);
                    this.group = null;
                } else if (this.rgbTransparencyBlending) {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    pdfDictionary.put(PdfName.TYPE, PdfName.GROUP);
                    pdfDictionary.put(PdfName.S, PdfName.TRANSPARENCY);
                    pdfDictionary.put(PdfName.CS, PdfName.DEVICERGB);
                    pdfPage.put(PdfName.GROUP, pdfDictionary);
                }
                this.root.addPage(pdfPage);
                this.currentPageNumber++;
                return null;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new PdfException(MessageLocalization.getComposedMessage("the.document.is.not.open", new Object[0]));
        }
    }

    public void setPageEvent(PdfPageEvent pdfPageEvent) {
        if (pdfPageEvent == null) {
            this.pageEvent = null;
            return;
        }
        PdfPageEvent pdfPageEvent2 = this.pageEvent;
        if (pdfPageEvent2 == null) {
            this.pageEvent = pdfPageEvent;
        } else if (pdfPageEvent2 instanceof PdfPageEventForwarder) {
            ((PdfPageEventForwarder) pdfPageEvent2).addPageEvent(pdfPageEvent);
        } else {
            PdfPageEventForwarder pdfPageEventForwarder = new PdfPageEventForwarder();
            pdfPageEventForwarder.addPageEvent(this.pageEvent);
            pdfPageEventForwarder.addPageEvent(pdfPageEvent);
            this.pageEvent = pdfPageEventForwarder;
        }
    }

    public PdfPageEvent getPageEvent() {
        return this.pageEvent;
    }

    @Override // com.itextpdf.text.DocWriter, com.itextpdf.text.DocListener
    public void open() {
        super.open();
        try {
            this.pdf_version.writeHeader(this.os);
            this.body = new PdfBody(this);
            if (isPdfX() && ((PdfXConformanceImp) this.pdfIsoConformance).isPdfX32002()) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.GAMMA, new PdfArray(new float[]{2.2f, 2.2f, 2.2f}));
                pdfDictionary.put(PdfName.MATRIX, new PdfArray(new float[]{0.4124f, 0.2126f, 0.0193f, 0.3576f, 0.7152f, 0.1192f, 0.1805f, 0.0722f, 0.9505f}));
                pdfDictionary.put(PdfName.WHITEPOINT, new PdfArray(new float[]{0.9505f, 1.0f, 1.089f}));
                PdfArray pdfArray = new PdfArray(PdfName.CALRGB);
                pdfArray.add(pdfDictionary);
                setDefaultColorspace(PdfName.DEFAULTRGB, addToBody(pdfArray).getIndirectReference());
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.DocWriter, com.itextpdf.text.DocListener
    public void close() {
        PdfObject pdfObject;
        if (this.open) {
            boolean z = true;
            if (this.currentPageNumber - 1 == this.pageReferences.size()) {
                this.pdf.close();
                try {
                    addSharedObjectsToBody();
                    Iterator<PdfOCG> it2 = this.documentOCG.iterator();
                    while (it2.hasNext()) {
                        PdfOCG next = it2.next();
                        addToBody(next.getPdfObject(), next.getRef());
                    }
                    PdfDictionary catalog = getCatalog(this.root.writePageTree());
                    if (!this.documentOCG.isEmpty()) {
                        checkPdfIsoConformance(this, 7, this.OCProperties);
                    }
                    PdfIndirectReference pdfIndirectReference = null;
                    if (this.xmpMetadata == null && this.xmpWriter != null) {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            this.xmpWriter.serialize(byteArrayOutputStream);
                            this.xmpWriter.close();
                            this.xmpMetadata = byteArrayOutputStream.toByteArray();
                        } catch (IOException unused) {
                            this.xmpWriter = null;
                        } catch (XMPException unused2) {
                            this.xmpWriter = null;
                        }
                    }
                    if (this.xmpMetadata != null) {
                        PdfStream pdfStream = new PdfStream(this.xmpMetadata);
                        pdfStream.put(PdfName.TYPE, PdfName.METADATA);
                        pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
                        if (this.crypto != null && !this.crypto.isMetadataEncrypted()) {
                            PdfArray pdfArray = new PdfArray();
                            pdfArray.add(PdfName.CRYPT);
                            pdfStream.put(PdfName.FILTER, pdfArray);
                        }
                        catalog.put(PdfName.METADATA, this.body.add(pdfStream).getIndirectReference());
                    }
                    if (isPdfX()) {
                        completeInfoDictionary(getInfo());
                        completeExtraCatalog(getExtraCatalog());
                    }
                    if (this.extraCatalog != null) {
                        catalog.mergeDifferent(this.extraCatalog);
                    }
                    writeOutlines(catalog, false);
                    PdfIndirectObject addToBody = addToBody((PdfObject) catalog, false);
                    PdfIndirectObject addToBody2 = addToBody((PdfObject) getInfo(), false);
                    this.body.flushObjStm();
                    if (this.originalFileID == null) {
                        z = false;
                    }
                    if (this.crypto != null) {
                        pdfIndirectReference = addToBody((PdfObject) this.crypto.getEncryptionDictionary(), false).getIndirectReference();
                        pdfObject = this.crypto.getFileID(z);
                    } else {
                        pdfObject = PdfEncryption.createInfoId(z ? this.originalFileID : PdfEncryption.createDocumentId(), z);
                    }
                    this.body.writeCrossReferenceTable(this.os, addToBody.getIndirectReference(), addToBody2.getIndirectReference(), pdfIndirectReference, pdfObject, this.prevxref);
                    if (this.fullCompression) {
                        writeKeyInfo(this.os);
                        this.os.write(getISOBytes("startxref\n"));
                        this.os.write(getISOBytes(String.valueOf(this.body.offset())));
                        this.os.write(getISOBytes("\n%%EOF\n"));
                    } else {
                        new PdfTrailer(this.body.size(), this.body.offset(), addToBody.getIndirectReference(), addToBody2.getIndirectReference(), pdfIndirectReference, pdfObject, this.prevxref).toPdf(this, this.os);
                    }
                    super.close();
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                } catch (Throwable th) {
                    super.close();
                    throw th;
                }
            } else {
                throw new RuntimeException("The page " + this.pageReferences.size() + " was requested but the document has only " + (this.currentPageNumber - 1) + " pages.");
            }
        }
        getCounter().written(this.os.getCounter());
    }

    /* access modifiers changed from: protected */
    public void addXFormsToBody() throws IOException {
        for (Object[] objArr : this.formXObjects.values()) {
            PdfTemplate pdfTemplate = (PdfTemplate) objArr[1];
            if ((pdfTemplate == null || !(pdfTemplate.getIndirectReference() instanceof PRIndirectReference)) && pdfTemplate != null && pdfTemplate.getType() == 1) {
                addToBody(pdfTemplate.getFormXObject(this.compressionLevel), pdfTemplate.getIndirectReference());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addSharedObjectsToBody() throws IOException {
        for (FontDetails fontDetails : this.documentFonts.values()) {
            fontDetails.writeFont(this);
        }
        addXFormsToBody();
        for (PdfReaderInstance pdfReaderInstance : this.readerInstances.values()) {
            this.currentPdfReaderInstance = pdfReaderInstance;
            pdfReaderInstance.writeAllPages();
        }
        this.currentPdfReaderInstance = null;
        for (ColorDetails colorDetails : this.documentColors.values()) {
            addToBody(colorDetails.getPdfObject(this), colorDetails.getIndirectReference());
        }
        for (PdfPatternPainter pdfPatternPainter : this.documentPatterns.keySet()) {
            addToBody(pdfPatternPainter.getPattern(this.compressionLevel), pdfPatternPainter.getIndirectReference());
        }
        Iterator<PdfShadingPattern> it2 = this.documentShadingPatterns.iterator();
        while (it2.hasNext()) {
            it2.next().addToBody();
        }
        Iterator<PdfShading> it3 = this.documentShadings.iterator();
        while (it3.hasNext()) {
            it3.next().addToBody();
        }
        for (Map.Entry<PdfDictionary, PdfObject[]> entry : this.documentExtGState.entrySet()) {
            addToBody(entry.getKey(), (PdfIndirectReference) entry.getValue()[1]);
        }
        for (Map.Entry<Object, PdfObject[]> entry2 : this.documentProperties.entrySet()) {
            Object key = entry2.getKey();
            PdfObject[] value = entry2.getValue();
            if (key instanceof PdfLayerMembership) {
                PdfLayerMembership pdfLayerMembership = (PdfLayerMembership) key;
                addToBody(pdfLayerMembership.getPdfObject(), pdfLayerMembership.getRef());
            } else if ((key instanceof PdfDictionary) && !(key instanceof PdfLayer)) {
                addToBody((PdfDictionary) key, (PdfIndirectReference) value[1]);
            }
        }
    }

    public PdfOutline getRootOutline() {
        return this.directContent.getRootOutline();
    }

    public void setOutlines(List<HashMap<String, Object>> list) {
        this.newBookmarks = list;
    }

    /* access modifiers changed from: protected */
    public void writeOutlines(PdfDictionary pdfDictionary, boolean z) throws IOException {
        List<HashMap<String, Object>> list = this.newBookmarks;
        if (list != null && !list.isEmpty()) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            PdfIndirectReference pdfIndirectReference = getPdfIndirectReference();
            Object[] iterateOutlines = SimpleBookmark.iterateOutlines(this, pdfIndirectReference, this.newBookmarks, z);
            pdfDictionary2.put(PdfName.FIRST, (PdfIndirectReference) iterateOutlines[0]);
            pdfDictionary2.put(PdfName.LAST, (PdfIndirectReference) iterateOutlines[1]);
            pdfDictionary2.put(PdfName.COUNT, new PdfNumber(((Integer) iterateOutlines[2]).intValue()));
            addToBody(pdfDictionary2, pdfIndirectReference);
            pdfDictionary.put(PdfName.OUTLINES, pdfIndirectReference);
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setPdfVersion(char c) {
        this.pdf_version.setPdfVersion(c);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setAtLeastPdfVersion(char c) {
        this.pdf_version.setAtLeastPdfVersion(c);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setPdfVersion(PdfName pdfName) {
        this.pdf_version.setPdfVersion(pdfName);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void addDeveloperExtension(PdfDeveloperExtension pdfDeveloperExtension) {
        this.pdf_version.addDeveloperExtension(pdfDeveloperExtension);
    }

    /* access modifiers changed from: package-private */
    public PdfVersionImp getPdfVersion() {
        return this.pdf_version;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.pdf.setViewerPreferences(i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.pdf.addViewerPreference(pdfName, pdfObject);
    }

    public void setPageLabels(PdfPageLabels pdfPageLabels) {
        this.pdf.setPageLabels(pdfPageLabels);
    }

    public void addNamedDestinations(Map<String, String> map, int i) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            int parseInt = Integer.parseInt(value.substring(0, value.indexOf(" ")));
            addNamedDestination(entry.getKey(), parseInt + i, new PdfDestination(value.substring(value.indexOf(" ") + 1)));
        }
    }

    public void addNamedDestination(String str, int i, PdfDestination pdfDestination) {
        PdfDestination pdfDestination2 = new PdfDestination(pdfDestination);
        pdfDestination2.addPage(getPageReference(i));
        this.pdf.localDestination(str, pdfDestination2);
    }

    public void addJavaScript(PdfAction pdfAction) {
        this.pdf.addJavaScript(pdfAction);
    }

    public void addJavaScript(String str, boolean z) {
        addJavaScript(PdfAction.javaScript(str, this, z));
    }

    public void addJavaScript(String str) {
        addJavaScript(str, false);
    }

    public void addJavaScript(String str, PdfAction pdfAction) {
        this.pdf.addJavaScript(str, pdfAction);
    }

    public void addJavaScript(String str, String str2, boolean z) {
        addJavaScript(str, PdfAction.javaScript(str2, this, z));
    }

    public void addJavaScript(String str, String str2) {
        addJavaScript(str, str2, false);
    }

    public void addFileAttachment(String str, byte[] bArr, String str2, String str3) throws IOException {
        addFileAttachment(str, PdfFileSpecification.fileEmbedded(this, str2, str3, bArr));
    }

    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        this.pdf.addFileAttachment(str, pdfFileSpecification);
    }

    public void addFileAttachment(PdfFileSpecification pdfFileSpecification) throws IOException {
        addFileAttachment(null, pdfFileSpecification);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setOpenAction(String str) {
        this.pdf.setOpenAction(str);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setOpenAction(PdfAction pdfAction) {
        this.pdf.setOpenAction(pdfAction);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setAdditionalAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException {
        if (pdfName.equals(DOCUMENT_CLOSE) || pdfName.equals(WILL_SAVE) || pdfName.equals(DID_SAVE) || pdfName.equals(WILL_PRINT) || pdfName.equals(DID_PRINT)) {
            this.pdf.addAdditionalAction(pdfName, pdfAction);
        } else {
            throw new DocumentException(MessageLocalization.getComposedMessage("invalid.additional.action.type.1", pdfName.toString()));
        }
    }

    public void setCollection(PdfCollection pdfCollection) {
        setAtLeastPdfVersion(VERSION_1_7);
        this.pdf.setCollection(pdfCollection);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public PdfAcroForm getAcroForm() {
        return this.pdf.getAcroForm();
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.pdf.addAnnotation(pdfAnnotation);
    }

    /* access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        addAnnotation(pdfAnnotation);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.pdf.addCalculationOrder(pdfFormField);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void setSigFlags(int i) {
        this.pdf.setSigFlags(i);
    }

    public void setLanguage(String str) {
        this.pdf.setLanguage(str);
    }

    public void setXmpMetadata(byte[] bArr) {
        this.xmpMetadata = bArr;
    }

    public void setPageXmpMetadata(byte[] bArr) throws IOException {
        this.pdf.setXmpMetadata(bArr);
    }

    public XmpWriter getXmpWriter() {
        return this.xmpWriter;
    }

    public void createXmpMetadata() {
        try {
            this.xmpWriter = createXmpWriter((ByteArrayOutputStream) null, this.pdf.getInfo());
            if (isTagged()) {
                try {
                    this.xmpWriter.getXmpMeta().setPropertyInteger(XMPConst.NS_PDFUA_ID, PdfProperties.PART, 1, new PropertyOptions(1073741824));
                } catch (XMPException e) {
                    throw new ExceptionConverter(e);
                }
            }
            this.xmpMetadata = null;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public PdfIsoConformance initPdfIsoConformance() {
        return new PdfXConformanceImp(this);
    }

    public void setPDFXConformance(int i) {
        PdfIsoConformance pdfIsoConformance2 = this.pdfIsoConformance;
        if (!(pdfIsoConformance2 instanceof PdfXConformanceImp) || ((PdfXConformance) pdfIsoConformance2).getPDFXConformance() == i) {
            return;
        }
        if (this.pdf.isOpen()) {
            throw new PdfXConformanceException(MessageLocalization.getComposedMessage("pdfx.conformance.can.only.be.set.before.opening.the.document", new Object[0]));
        } else if (this.crypto == null) {
            if (i != 0) {
                setPdfVersion(VERSION_1_3);
            }
            ((PdfXConformance) this.pdfIsoConformance).setPDFXConformance(i);
        } else {
            throw new PdfXConformanceException(MessageLocalization.getComposedMessage("a.pdfx.conforming.document.cannot.be.encrypted", new Object[0]));
        }
    }

    public int getPDFXConformance() {
        PdfIsoConformance pdfIsoConformance2 = this.pdfIsoConformance;
        if (pdfIsoConformance2 instanceof PdfXConformanceImp) {
            return ((PdfXConformance) pdfIsoConformance2).getPDFXConformance();
        }
        return 0;
    }

    public boolean isPdfX() {
        PdfIsoConformance pdfIsoConformance2 = this.pdfIsoConformance;
        if (pdfIsoConformance2 instanceof PdfXConformanceImp) {
            return ((PdfXConformance) pdfIsoConformance2).isPdfX();
        }
        return false;
    }

    public boolean isPdfIso() {
        return this.pdfIsoConformance.isPdfIso();
    }

    public void setOutputIntents(String str, String str2, String str3, String str4, ICC_Profile iCC_Profile) throws IOException {
        checkPdfIsoConformance(this, 19, iCC_Profile);
        getExtraCatalog();
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.OUTPUTINTENT);
        if (str2 != null) {
            pdfDictionary.put(PdfName.OUTPUTCONDITION, new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
        if (str != null) {
            pdfDictionary.put(PdfName.OUTPUTCONDITIONIDENTIFIER, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (str3 != null) {
            pdfDictionary.put(PdfName.REGISTRYNAME, new PdfString(str3, PdfObject.TEXT_UNICODE));
        }
        if (str4 != null) {
            pdfDictionary.put(PdfName.INFO, new PdfString(str4, PdfObject.TEXT_UNICODE));
        }
        if (iCC_Profile != null) {
            pdfDictionary.put(PdfName.DESTOUTPUTPROFILE, addToBody(new PdfICCBased(iCC_Profile, this.compressionLevel)).getIndirectReference());
        }
        pdfDictionary.put(PdfName.S, PdfName.GTS_PDFX);
        this.extraCatalog.put(PdfName.OUTPUTINTENTS, new PdfArray(pdfDictionary));
        this.colorProfile = iCC_Profile;
    }

    public void setOutputIntents(String str, String str2, String str3, String str4, byte[] bArr) throws IOException {
        setOutputIntents(str, str2, str3, str4, bArr == null ? null : ICC_Profile.getInstance(bArr));
    }

    public boolean setOutputIntents(PdfReader pdfReader, boolean z) throws IOException {
        PdfArray asArray = pdfReader.getCatalog().getAsArray(PdfName.OUTPUTINTENTS);
        boolean z2 = false;
        if (asArray == null || asArray.isEmpty()) {
            return false;
        }
        PdfDictionary asDict = asArray.getAsDict(0);
        PdfObject pdfObject = PdfReader.getPdfObject(asDict.get(PdfName.S));
        if (pdfObject != null && PdfName.GTS_PDFX.equals(pdfObject)) {
            z2 = true;
            if (z) {
                return true;
            }
            PRStream pRStream = (PRStream) PdfReader.getPdfObject(asDict.get(PdfName.DESTOUTPUTPROFILE));
            byte[] bArr = null;
            if (pRStream != null) {
                bArr = PdfReader.getStreamBytes(pRStream);
            }
            setOutputIntents(getNameString(asDict, PdfName.OUTPUTCONDITIONIDENTIFIER), getNameString(asDict, PdfName.OUTPUTCONDITION), getNameString(asDict, PdfName.REGISTRYNAME), getNameString(asDict, PdfName.INFO), bArr);
        }
        return z2;
    }

    protected static String getNameString(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName));
        if (pdfObject == null || !pdfObject.isString()) {
            return null;
        }
        return ((PdfString) pdfObject).toUnicodeString();
    }

    /* access modifiers changed from: package-private */
    public PdfEncryption getEncryption() {
        return this.crypto;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        if (!this.pdf.isOpen()) {
            PdfEncryption pdfEncryption = new PdfEncryption();
            this.crypto = pdfEncryption;
            pdfEncryption.setCryptoMode(i2, 0);
            this.crypto.setupAllKeys(bArr, bArr2, i);
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("encryption.can.only.be.added.before.opening.the.document", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        if (!this.pdf.isOpen()) {
            this.crypto = new PdfEncryption();
            if (certificateArr != null) {
                for (int i2 = 0; i2 < certificateArr.length; i2++) {
                    this.crypto.addRecipient(certificateArr[i2], iArr[i2]);
                }
            }
            this.crypto.setCryptoMode(i, 0);
            this.crypto.getEncryptionDictionary();
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("encryption.can.only.be.added.before.opening.the.document", new Object[0]));
    }

    @Deprecated
    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    @Deprecated
    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(getISOBytes(str), getISOBytes(str2), i, z ? 1 : 0);
    }

    @Deprecated
    public void setEncryption(int i, String str, String str2, int i2) throws DocumentException {
        setEncryption(getISOBytes(str), getISOBytes(str2), i2, i);
    }

    public boolean isFullCompression() {
        return this.fullCompression;
    }

    public void setFullCompression() throws DocumentException {
        if (!this.open) {
            this.fullCompression = true;
            setAtLeastPdfVersion(VERSION_1_5);
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("you.can.t.set.the.full.compression.if.the.document.is.already.open", new Object[0]));
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        if (i < 0 || i > 9) {
            this.compressionLevel = -1;
        } else {
            this.compressionLevel = i;
        }
    }

    /* access modifiers changed from: package-private */
    public FontDetails addSimple(BaseFont baseFont) {
        FontDetails fontDetails = this.documentFonts.get(baseFont);
        if (fontDetails == null) {
            checkPdfIsoConformance(this, 4, baseFont);
            if (baseFont.getFontType() == 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("F");
                int i = this.fontNumber;
                this.fontNumber = i + 1;
                sb.append(i);
                fontDetails = new FontDetails(new PdfName(sb.toString()), ((DocumentFont) baseFont).getIndirectReference(), baseFont);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("F");
                int i2 = this.fontNumber;
                this.fontNumber = i2 + 1;
                sb2.append(i2);
                fontDetails = new FontDetails(new PdfName(sb2.toString()), this.body.getPdfIndirectReference(), baseFont);
            }
            this.documentFonts.put(baseFont, fontDetails);
        }
        return fontDetails;
    }

    /* access modifiers changed from: package-private */
    public void eliminateFontSubset(PdfDictionary pdfDictionary) {
        for (FontDetails fontDetails : this.documentFonts.values()) {
            if (pdfDictionary.get(fontDetails.getFontName()) != null) {
                fontDetails.setSubset(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PdfName addDirectTemplateSimple(PdfTemplate pdfTemplate, PdfName pdfName) {
        PdfIndirectReference indirectReference = pdfTemplate.getIndirectReference();
        Object[] objArr = this.formXObjects.get(indirectReference);
        if (objArr != null) {
            return (PdfName) objArr[0];
        }
        if (pdfName == null) {
            try {
                pdfName = new PdfName("Xf" + this.formXObjectsCounter);
                this.formXObjectsCounter = this.formXObjectsCounter + 1;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
        if (pdfTemplate.getType() == 2) {
            PdfImportedPage pdfImportedPage = (PdfImportedPage) pdfTemplate;
            PdfReader reader = pdfImportedPage.getPdfReaderInstance().getReader();
            if (!this.readerInstances.containsKey(reader)) {
                this.readerInstances.put(reader, pdfImportedPage.getPdfReaderInstance());
            }
            pdfTemplate = null;
        }
        this.formXObjects.put(indirectReference, new Object[]{pdfName, pdfTemplate});
        return pdfName;
    }

    public void releaseTemplate(PdfTemplate pdfTemplate) throws IOException {
        Object[] objArr = this.formXObjects.get(pdfTemplate.getIndirectReference());
        if (objArr != null && objArr[1] != null) {
            PdfTemplate pdfTemplate2 = (PdfTemplate) objArr[1];
            if (!(pdfTemplate2.getIndirectReference() instanceof PRIndirectReference) && pdfTemplate2.getType() == 1) {
                addToBody(pdfTemplate2.getFormXObject(this.compressionLevel), pdfTemplate2.getIndirectReference());
                objArr[1] = null;
            }
        }
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        return getPdfReaderInstance(pdfReader).getImportedPage(i);
    }

    /* access modifiers changed from: protected */
    public PdfReaderInstance getPdfReaderInstance(PdfReader pdfReader) {
        PdfReaderInstance pdfReaderInstance = this.readerInstances.get(pdfReader);
        if (pdfReaderInstance != null) {
            return pdfReaderInstance;
        }
        PdfReaderInstance pdfReaderInstance2 = pdfReader.getPdfReaderInstance(this);
        this.readerInstances.put(pdfReader, pdfReaderInstance2);
        return pdfReaderInstance2;
    }

    public void freeReader(PdfReader pdfReader) throws IOException {
        PdfReaderInstance pdfReaderInstance = this.readerInstances.get(pdfReader);
        this.currentPdfReaderInstance = pdfReaderInstance;
        if (pdfReaderInstance != null) {
            pdfReaderInstance.writeAllPages();
            this.currentPdfReaderInstance = null;
            this.readerInstances.remove(pdfReader);
        }
    }

    public long getCurrentDocumentSize() {
        return this.body.offset() + ((long) (this.body.size() * 20)) + 72;
    }

    /* access modifiers changed from: protected */
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        PdfReaderInstance pdfReaderInstance = this.currentPdfReaderInstance;
        if (pdfReaderInstance == null || pdfReaderInstance.getReader() != pdfReader) {
            this.currentPdfReaderInstance = getPdfReaderInstance(pdfReader);
        }
        return this.currentPdfReaderInstance.getNewObjectNumber(i, i2);
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        return this.currentPdfReaderInstance.getReaderFile();
    }

    /* access modifiers changed from: package-private */
    public PdfName getColorspaceName() {
        StringBuilder sb = new StringBuilder();
        sb.append("CS");
        int i = this.colorNumber;
        this.colorNumber = i + 1;
        sb.append(i);
        return new PdfName(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public ColorDetails addSimple(ICachedColorSpace iCachedColorSpace) {
        ColorDetails colorDetails = this.documentColors.get(iCachedColorSpace);
        if (colorDetails == null) {
            colorDetails = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), iCachedColorSpace);
            if (iCachedColorSpace instanceof IPdfSpecialColorSpace) {
                ((IPdfSpecialColorSpace) iCachedColorSpace).getColorantDetails(this);
            }
            this.documentColors.put(iCachedColorSpace, colorDetails);
        }
        return colorDetails;
    }

    /* access modifiers changed from: package-private */
    public PdfName addSimplePattern(PdfPatternPainter pdfPatternPainter) {
        PdfName pdfName = this.documentPatterns.get(pdfPatternPainter);
        if (pdfName != null) {
            return pdfName;
        }
        try {
            PdfName pdfName2 = new PdfName("P" + this.patternNumber);
            this.patternNumber = this.patternNumber + 1;
            this.documentPatterns.put(pdfPatternPainter, pdfName2);
            return pdfName2;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void addSimpleShadingPattern(PdfShadingPattern pdfShadingPattern) {
        if (!this.documentShadingPatterns.contains(pdfShadingPattern)) {
            pdfShadingPattern.setName(this.patternNumber);
            this.patternNumber++;
            this.documentShadingPatterns.add(pdfShadingPattern);
            addSimpleShading(pdfShadingPattern.getShading());
        }
    }

    /* access modifiers changed from: package-private */
    public void addSimpleShading(PdfShading pdfShading) {
        if (!this.documentShadings.contains(pdfShading)) {
            this.documentShadings.add(pdfShading);
            pdfShading.setName(this.documentShadings.size());
        }
    }

    /* access modifiers changed from: package-private */
    public PdfObject[] addSimpleExtGState(PdfDictionary pdfDictionary) {
        if (!this.documentExtGState.containsKey(pdfDictionary)) {
            HashMap<PdfDictionary, PdfObject[]> hashMap = this.documentExtGState;
            hashMap.put(pdfDictionary, new PdfObject[]{new PdfName("GS" + (this.documentExtGState.size() + 1)), getPdfIndirectReference()});
        }
        return this.documentExtGState.get(pdfDictionary);
    }

    /* access modifiers changed from: package-private */
    public PdfObject[] addSimpleProperty(Object obj, PdfIndirectReference pdfIndirectReference) {
        if (!this.documentProperties.containsKey(obj)) {
            if (obj instanceof PdfOCG) {
                checkPdfIsoConformance(this, 7, obj);
            }
            HashMap<Object, PdfObject[]> hashMap = this.documentProperties;
            hashMap.put(obj, new PdfObject[]{new PdfName("Pr" + (this.documentProperties.size() + 1)), pdfIndirectReference});
        }
        return this.documentProperties.get(obj);
    }

    /* access modifiers changed from: package-private */
    public boolean propertyExists(Object obj) {
        return this.documentProperties.containsKey(obj);
    }

    public void setTagged() {
        setTagged(1);
    }

    public void setTagged(int i) {
        if (!this.open) {
            this.tagged = true;
            this.taggingMode = i;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("tagging.must.be.set.before.opening.the.document", new Object[0]));
    }

    public boolean needToBeMarkedInContent(IAccessibleElement iAccessibleElement) {
        if ((this.taggingMode & 1) == 0 || iAccessibleElement.isInline() || PdfName.ARTIFACT.equals(iAccessibleElement.getRole())) {
            return true;
        }
        return false;
    }

    public void checkElementRole(IAccessibleElement iAccessibleElement, IAccessibleElement iAccessibleElement2) {
        if (iAccessibleElement2 != null && (iAccessibleElement2.getRole() == null || PdfName.ARTIFACT.equals(iAccessibleElement2.getRole()))) {
            iAccessibleElement.setRole(null);
        } else if ((this.taggingMode & 1) != 0 && iAccessibleElement.isInline() && iAccessibleElement.getRole() == null) {
            if (iAccessibleElement2 == null || !iAccessibleElement2.isInline()) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("inline.elements.with.role.null.are.not.allowed", new Object[0]));
            }
        }
    }

    public boolean isTagged() {
        return this.tagged;
    }

    public PdfStructureTreeRoot getStructureTreeRoot() {
        if (this.tagged && this.structureTreeRoot == null) {
            this.structureTreeRoot = new PdfStructureTreeRoot(this);
        }
        return this.structureTreeRoot;
    }

    public PdfOCProperties getOCProperties() {
        fillOCProperties(true);
        return this.OCProperties;
    }

    public void addOCGRadioGroup(ArrayList<PdfLayer> arrayList) {
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < arrayList.size(); i++) {
            PdfLayer pdfLayer = arrayList.get(i);
            if (pdfLayer.getTitle() == null) {
                pdfArray.add(pdfLayer.getRef());
            }
        }
        if (pdfArray.size() != 0) {
            this.OCGRadioGroup.add(pdfArray);
        }
    }

    public void lockLayer(PdfLayer pdfLayer) {
        this.OCGLocked.add(pdfLayer.getRef());
    }

    private static void getOCGOrder(PdfArray pdfArray, PdfLayer pdfLayer) {
        if (pdfLayer.isOnPanel()) {
            if (pdfLayer.getTitle() == null) {
                pdfArray.add(pdfLayer.getRef());
            }
            ArrayList<PdfLayer> children = pdfLayer.getChildren();
            if (children != null) {
                PdfArray pdfArray2 = new PdfArray();
                if (pdfLayer.getTitle() != null) {
                    pdfArray2.add(new PdfString(pdfLayer.getTitle(), PdfObject.TEXT_UNICODE));
                }
                for (int i = 0; i < children.size(); i++) {
                    getOCGOrder(pdfArray2, children.get(i));
                }
                if (pdfArray2.size() > 0) {
                    pdfArray.add(pdfArray2);
                }
            }
        }
    }

    private void addASEvent(PdfName pdfName, PdfName pdfName2) {
        PdfArray pdfArray = new PdfArray();
        Iterator<PdfOCG> it2 = this.documentOCG.iterator();
        while (it2.hasNext()) {
            PdfLayer pdfLayer = (PdfLayer) it2.next();
            PdfDictionary asDict = pdfLayer.getAsDict(PdfName.USAGE);
            if (!(asDict == null || asDict.get(pdfName2) == null)) {
                pdfArray.add(pdfLayer.getRef());
            }
        }
        if (pdfArray.size() != 0) {
            PdfDictionary asDict2 = this.OCProperties.getAsDict(PdfName.D);
            PdfArray asArray = asDict2.getAsArray(PdfName.AS);
            if (asArray == null) {
                asArray = new PdfArray();
                asDict2.put(PdfName.AS, asArray);
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.EVENT, pdfName);
            pdfDictionary.put(PdfName.CATEGORY, new PdfArray(pdfName2));
            pdfDictionary.put(PdfName.OCGS, pdfArray);
            asArray.add(pdfDictionary);
        }
    }

    /* access modifiers changed from: protected */
    public void fillOCProperties(boolean z) {
        PdfString asString;
        if (this.OCProperties == null) {
            this.OCProperties = new PdfOCProperties();
        }
        if (z) {
            this.OCProperties.remove(PdfName.OCGS);
            this.OCProperties.remove(PdfName.D);
        }
        if (this.OCProperties.get(PdfName.OCGS) == null) {
            PdfArray pdfArray = new PdfArray();
            Iterator<PdfOCG> it2 = this.documentOCG.iterator();
            while (it2.hasNext()) {
                pdfArray.add(((PdfLayer) it2.next()).getRef());
            }
            this.OCProperties.put(PdfName.OCGS, pdfArray);
        }
        if (this.OCProperties.get(PdfName.D) == null) {
            ArrayList arrayList = new ArrayList(this.documentOCGorder);
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                if (((PdfLayer) it3.next()).getParent() != null) {
                    it3.remove();
                }
            }
            PdfArray pdfArray2 = new PdfArray();
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                getOCGOrder(pdfArray2, (PdfLayer) it4.next());
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            this.OCProperties.put(PdfName.D, pdfDictionary);
            pdfDictionary.put(PdfName.ORDER, pdfArray2);
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof PdfLayer) && (asString = ((PdfLayer) arrayList.get(0)).getAsString(PdfName.NAME)) != null) {
                pdfDictionary.put(PdfName.NAME, asString);
            }
            PdfArray pdfArray3 = new PdfArray();
            Iterator<PdfOCG> it5 = this.documentOCG.iterator();
            while (it5.hasNext()) {
                PdfLayer pdfLayer = (PdfLayer) it5.next();
                if (!pdfLayer.isOn()) {
                    pdfArray3.add(pdfLayer.getRef());
                }
            }
            if (pdfArray3.size() > 0) {
                pdfDictionary.put(PdfName.OFF, pdfArray3);
            }
            if (this.OCGRadioGroup.size() > 0) {
                pdfDictionary.put(PdfName.RBGROUPS, this.OCGRadioGroup);
            }
            if (this.OCGLocked.size() > 0) {
                pdfDictionary.put(PdfName.LOCKED, this.OCGLocked);
            }
            addASEvent(PdfName.VIEW, PdfName.ZOOM);
            addASEvent(PdfName.VIEW, PdfName.VIEW);
            addASEvent(PdfName.PRINT, PdfName.PRINT);
            addASEvent(PdfName.EXPORT, PdfName.EXPORT);
            pdfDictionary.put(PdfName.LISTMODE, PdfName.VISIBLEPAGES);
        }
    }

    /* access modifiers changed from: package-private */
    public void registerLayer(PdfOCG pdfOCG) {
        checkPdfIsoConformance(this, 7, pdfOCG);
        if (!(pdfOCG instanceof PdfLayer)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("only.pdflayer.is.accepted", new Object[0]));
        } else if (((PdfLayer) pdfOCG).getTitle() != null) {
            this.documentOCGorder.add(pdfOCG);
        } else if (!this.documentOCG.contains(pdfOCG)) {
            this.documentOCG.add(pdfOCG);
            this.documentOCGorder.add(pdfOCG);
        }
    }

    public Rectangle getPageSize() {
        return this.pdf.getPageSize();
    }

    public void setCropBoxSize(Rectangle rectangle) {
        this.pdf.setCropBoxSize(rectangle);
    }

    public void setBoxSize(String str, Rectangle rectangle) {
        this.pdf.setBoxSize(str, rectangle);
    }

    public Rectangle getBoxSize(String str) {
        return this.pdf.getBoxSize(str);
    }

    public Rectangle getBoxSize(String str, Rectangle rectangle) {
        Rectangle boxSize = this.pdf.getBoxSize(str);
        if (boxSize == null || rectangle == null) {
            return null;
        }
        com.itextpdf.awt.geom.Rectangle intersection = new com.itextpdf.awt.geom.Rectangle(boxSize).intersection(new com.itextpdf.awt.geom.Rectangle(rectangle));
        if (intersection.isEmpty()) {
            return null;
        }
        Rectangle rectangle2 = new Rectangle((float) intersection.getX(), (float) intersection.getY(), (float) (intersection.getX() + intersection.getWidth()), (float) (intersection.getY() + intersection.getHeight()));
        rectangle2.normalize();
        return rectangle2;
    }

    public void setPageEmpty(boolean z) {
        if (!z) {
            this.pdf.setPageEmpty(z);
        }
    }

    public boolean isPageEmpty() {
        return this.pdf.isPageEmpty();
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setPageAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException {
        if (pdfName.equals(PAGE_OPEN) || pdfName.equals(PAGE_CLOSE)) {
            this.pdf.setPageAction(pdfName, pdfAction);
        } else {
            throw new DocumentException(MessageLocalization.getComposedMessage("invalid.page.additional.action.type.1", pdfName.toString()));
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setDuration(int i) {
        this.pdf.setDuration(i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setTransition(PdfTransition pdfTransition) {
        this.pdf.setTransition(pdfTransition);
    }

    public void setThumbnail(Image image) throws PdfException, DocumentException {
        this.pdf.setThumbnail(image);
    }

    public PdfDictionary getGroup() {
        return this.group;
    }

    public void setGroup(PdfDictionary pdfDictionary) {
        this.group = pdfDictionary;
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public void setSpaceCharRatio(float f) {
        if (f < 0.001f) {
            this.spaceCharRatio = 0.001f;
        } else {
            this.spaceCharRatio = f;
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfRunDirection
    public void setRunDirection(int i) {
        if (i < 1 || i > 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfRunDirection
    public int getRunDirection() {
        return this.runDirection;
    }

    public void setUserunit(float f) throws DocumentException {
        if (f < 1.0f || f > 75000.0f) {
            throw new DocumentException(MessageLocalization.getComposedMessage("userunit.should.be.a.value.between.1.and.75000", new Object[0]));
        }
        addPageDictEntry(PdfName.USERUNIT, new PdfNumber(f));
        setAtLeastPdfVersion(VERSION_1_6);
    }

    public PdfDictionary getDefaultColorspace() {
        return this.defaultColorspace;
    }

    public void setDefaultColorspace(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            this.defaultColorspace.remove(pdfName);
        }
        this.defaultColorspace.put(pdfName, pdfObject);
    }

    /* access modifiers changed from: package-private */
    public ColorDetails addSimplePatternColorspace(BaseColor baseColor) {
        int type = ExtendedColor.getType(baseColor);
        if (type == 4 || type == 5) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("an.uncolored.tile.pattern.can.not.have.another.pattern.or.shading.as.color", new Object[0]));
        } else if (type == 0) {
            if (this.patternColorspaceRGB == null) {
                this.patternColorspaceRGB = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), null);
                PdfArray pdfArray = new PdfArray(PdfName.PATTERN);
                pdfArray.add(PdfName.DEVICERGB);
                addToBody(pdfArray, this.patternColorspaceRGB.getIndirectReference());
            }
            return this.patternColorspaceRGB;
        } else if (type == 1) {
            if (this.patternColorspaceGRAY == null) {
                this.patternColorspaceGRAY = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), null);
                PdfArray pdfArray2 = new PdfArray(PdfName.PATTERN);
                pdfArray2.add(PdfName.DEVICEGRAY);
                addToBody(pdfArray2, this.patternColorspaceGRAY.getIndirectReference());
            }
            return this.patternColorspaceGRAY;
        } else if (type == 2) {
            if (this.patternColorspaceCMYK == null) {
                this.patternColorspaceCMYK = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), null);
                PdfArray pdfArray3 = new PdfArray(PdfName.PATTERN);
                pdfArray3.add(PdfName.DEVICECMYK);
                addToBody(pdfArray3, this.patternColorspaceCMYK.getIndirectReference());
            }
            return this.patternColorspaceCMYK;
        } else if (type == 3) {
            try {
                ColorDetails addSimple = addSimple(((SpotColor) baseColor).getPdfSpotColor());
                ColorDetails colorDetails = this.documentSpotPatterns.get(addSimple);
                if (colorDetails != null) {
                    return colorDetails;
                }
                ColorDetails colorDetails2 = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), null);
                PdfArray pdfArray4 = new PdfArray(PdfName.PATTERN);
                pdfArray4.add(addSimple.getIndirectReference());
                addToBody(pdfArray4, colorDetails2.getIndirectReference());
                this.documentSpotPatterns.put(addSimple, colorDetails2);
                return colorDetails2;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.color.type", new Object[0]));
        }
    }

    public boolean isStrictImageSequence() {
        return this.pdf.isStrictImageSequence();
    }

    public void setStrictImageSequence(boolean z) {
        this.pdf.setStrictImageSequence(z);
    }

    public void clearTextWrap() throws DocumentException {
        this.pdf.clearTextWrap();
    }

    public PdfName addDirectImageSimple(Image image) throws PdfException, DocumentException {
        return addDirectImageSimple(image, null);
    }

    public PdfName addDirectImageSimple(Image image, PdfIndirectReference pdfIndirectReference) throws PdfException, DocumentException {
        PdfName pdfName;
        byte[] globalBytes;
        if (this.images.containsKey(image.getMySerialId())) {
            return this.images.get(image.getMySerialId());
        }
        if (image.isImgTemplate()) {
            pdfName = new PdfName(HtmlTags.IMG + this.images.size());
            if (image instanceof ImgWMF) {
                try {
                    ((ImgWMF) image).readWMF(PdfTemplate.createTemplate(this, 0.0f, 0.0f));
                } catch (Exception e) {
                    throw new DocumentException(e);
                }
            }
        } else {
            PdfObject directReference = image.getDirectReference();
            if (directReference != null) {
                PdfName pdfName2 = new PdfName(HtmlTags.IMG + this.images.size());
                this.images.put(image.getMySerialId(), pdfName2);
                this.imageDictionary.put(pdfName2, directReference);
                return pdfName2;
            }
            Image imageMask = image.getImageMask();
            PdfIndirectReference pdfIndirectReference2 = null;
            if (imageMask != null) {
                pdfIndirectReference2 = getImageReference(this.images.get(imageMask.getMySerialId()));
            }
            PdfImage pdfImage = new PdfImage(image, HtmlTags.IMG + this.images.size(), pdfIndirectReference2);
            if ((image instanceof ImgJBIG2) && (globalBytes = ((ImgJBIG2) image).getGlobalBytes()) != null) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.JBIG2GLOBALS, getReferenceJBIG2Globals(globalBytes));
                pdfImage.put(PdfName.DECODEPARMS, pdfDictionary);
            }
            if (image.hasICCProfile()) {
                PdfObject add = add(new PdfICCBased(image.getICCProfile(), image.getCompressionLevel()));
                PdfArray pdfArray = new PdfArray();
                pdfArray.add(PdfName.ICCBASED);
                pdfArray.add(add);
                PdfArray asArray = pdfImage.getAsArray(PdfName.COLORSPACE);
                if (asArray == null) {
                    pdfImage.put(PdfName.COLORSPACE, pdfArray);
                } else if (asArray.size() <= 1 || !PdfName.INDEXED.equals(asArray.getPdfObject(0))) {
                    pdfImage.put(PdfName.COLORSPACE, pdfArray);
                } else {
                    asArray.set(1, pdfArray);
                }
            }
            add(pdfImage, pdfIndirectReference);
            pdfName = pdfImage.name();
        }
        this.images.put(image.getMySerialId(), pdfName);
        return pdfName;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference add(PdfImage pdfImage, PdfIndirectReference pdfIndirectReference) throws PdfException {
        if (this.imageDictionary.contains(pdfImage.name())) {
            return (PdfIndirectReference) this.imageDictionary.get(pdfImage.name());
        }
        checkPdfIsoConformance(this, 5, pdfImage);
        if (pdfIndirectReference instanceof PRIndirectReference) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfIndirectReference;
            pdfIndirectReference = new PdfIndirectReference(0, getNewObjectNumber(pRIndirectReference.getReader(), pRIndirectReference.getNumber(), pRIndirectReference.getGeneration()));
        }
        if (pdfIndirectReference == null) {
            try {
                pdfIndirectReference = addToBody(pdfImage).getIndirectReference();
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            addToBody(pdfImage, pdfIndirectReference);
        }
        this.imageDictionary.put(pdfImage.name(), pdfIndirectReference);
        return pdfIndirectReference;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getImageReference(PdfName pdfName) {
        return (PdfIndirectReference) this.imageDictionary.get(pdfName);
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference add(PdfICCBased pdfICCBased) {
        try {
            return addToBody(pdfICCBased).getIndirectReference();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference getReferenceJBIG2Globals(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (PdfStream pdfStream : this.JBIG2Globals.keySet()) {
            if (Arrays.equals(bArr, pdfStream.getBytes())) {
                return this.JBIG2Globals.get(pdfStream);
            }
        }
        PdfStream pdfStream2 = new PdfStream(bArr);
        try {
            PdfIndirectObject addToBody = addToBody(pdfStream2);
            this.JBIG2Globals.put(pdfStream2, addToBody.getIndirectReference());
            return addToBody.getIndirectReference();
        } catch (IOException unused) {
            return null;
        }
    }

    public boolean isUserProperties() {
        return this.userProperties;
    }

    public void setUserProperties(boolean z) {
        this.userProperties = z;
    }

    public boolean isRgbTransparencyBlending() {
        return this.rgbTransparencyBlending;
    }

    public void setRgbTransparencyBlending(boolean z) {
        this.rgbTransparencyBlending = z;
    }

    protected static void writeKeyInfo(OutputStream outputStream) throws IOException {
        Version instance = Version.getInstance();
        String key = instance.getKey();
        if (key == null) {
            key = "iText";
        }
        outputStream.write(getISOBytes(String.format("%%%s-%s\n", key, instance.getRelease())));
    }

    /* access modifiers changed from: protected */
    public TtfUnicodeWriter getTtfUnicodeWriter() {
        if (this.ttfUnicodeWriter == null) {
            this.ttfUnicodeWriter = new TtfUnicodeWriter(this);
        }
        return this.ttfUnicodeWriter;
    }

    /* access modifiers changed from: protected */
    public XmpWriter createXmpWriter(ByteArrayOutputStream byteArrayOutputStream, PdfDictionary pdfDictionary) throws IOException {
        return new XmpWriter(byteArrayOutputStream, pdfDictionary);
    }

    /* access modifiers changed from: protected */
    public XmpWriter createXmpWriter(ByteArrayOutputStream byteArrayOutputStream, HashMap<String, String> hashMap) throws IOException {
        return new XmpWriter(byteArrayOutputStream, hashMap);
    }

    public PdfAnnotation createAnnotation(Rectangle rectangle, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, rectangle);
        if (pdfName != null) {
            pdfAnnotation.put(PdfName.SUBTYPE, pdfName);
        }
        return pdfAnnotation;
    }

    public PdfAnnotation createAnnotation(float f, float f2, float f3, float f4, PdfString pdfString, PdfString pdfString2, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, f, f2, f3, f4, pdfString, pdfString2);
        if (pdfName != null) {
            pdfAnnotation.put(PdfName.SUBTYPE, pdfName);
        }
        return pdfAnnotation;
    }

    public PdfAnnotation createAnnotation(float f, float f2, float f3, float f4, PdfAction pdfAction, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, f, f2, f3, f4, pdfAction);
        if (pdfName != null) {
            pdfAnnotation.put(PdfName.SUBTYPE, pdfName);
        }
        return pdfAnnotation;
    }

    public static void checkPdfIsoConformance(PdfWriter pdfWriter, int i, Object obj) {
        if (pdfWriter != null) {
            pdfWriter.checkPdfIsoConformance(i, obj);
        }
    }

    public void checkPdfIsoConformance(int i, Object obj) {
        this.pdfIsoConformance.checkPdfIsoConformance(i, obj);
    }

    private void completeInfoDictionary(PdfDictionary pdfDictionary) {
        if (isPdfX()) {
            if (pdfDictionary.get(PdfName.GTS_PDFXVERSION) == null) {
                if (((PdfXConformanceImp) this.pdfIsoConformance).isPdfX1A2001()) {
                    pdfDictionary.put(PdfName.GTS_PDFXVERSION, new PdfString("PDF/X-1:2001"));
                    pdfDictionary.put(new PdfName("GTS_PDFXConformance"), new PdfString("PDF/X-1a:2001"));
                } else if (((PdfXConformanceImp) this.pdfIsoConformance).isPdfX32002()) {
                    pdfDictionary.put(PdfName.GTS_PDFXVERSION, new PdfString("PDF/X-3:2002"));
                }
            }
            if (pdfDictionary.get(PdfName.TITLE) == null) {
                pdfDictionary.put(PdfName.TITLE, new PdfString("Pdf document"));
            }
            if (pdfDictionary.get(PdfName.CREATOR) == null) {
                pdfDictionary.put(PdfName.CREATOR, new PdfString("Unknown"));
            }
            if (pdfDictionary.get(PdfName.TRAPPED) == null) {
                pdfDictionary.put(PdfName.TRAPPED, new PdfName(XMPConst.FALSESTR));
            }
        }
    }

    private void completeExtraCatalog(PdfDictionary pdfDictionary) {
        if (isPdfX() && pdfDictionary.get(PdfName.OUTPUTINTENTS) == null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.OUTPUTINTENT);
            pdfDictionary2.put(PdfName.OUTPUTCONDITION, new PdfString("SWOP CGATS TR 001-1995"));
            pdfDictionary2.put(PdfName.OUTPUTCONDITIONIDENTIFIER, new PdfString("CGATS TR 001"));
            pdfDictionary2.put(PdfName.REGISTRYNAME, new PdfString("http://www.color.org"));
            pdfDictionary2.put(PdfName.INFO, new PdfString(""));
            pdfDictionary2.put(PdfName.S, PdfName.GTS_PDFX);
            pdfDictionary.put(PdfName.OUTPUTINTENTS, new PdfArray(pdfDictionary2));
        }
    }

    public List<PdfName> getStandardStructElems() {
        if (this.pdf_version.getVersion() < '7') {
            return standardStructElems_1_4;
        }
        return standardStructElems_1_7;
    }

    public void useExternalCacheForTagStructure(TempFileCache tempFileCache) {
        this.pdf.useExternalCache(tempFileCache);
    }
}
