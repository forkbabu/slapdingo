package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.DrawInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ColumnText {
    public static final int AR_COMPOSEDTASHKEEL = 4;
    public static final int AR_LIG = 8;
    public static final int AR_NOVOWEL = 1;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final float GLOBAL_SPACE_CHAR_RATIO = 0.0f;
    protected static final int LINE_STATUS_NOLINE = 2;
    protected static final int LINE_STATUS_OFFLIMITS = 1;
    protected static final int LINE_STATUS_OK = 0;
    public static final int NO_MORE_COLUMN = 2;
    public static final int NO_MORE_TEXT = 1;
    public static final int START_COLUMN = 0;
    private final Logger LOGGER = LoggerFactory.getLogger(ColumnText.class);
    private boolean adjustFirstLine = true;
    protected int alignment = 0;
    private int arabicOptions = 0;
    protected BidiLine bidiLine;
    protected PdfContentByte canvas;
    protected PdfContentByte[] canvases;
    protected boolean composite = false;
    protected ColumnText compositeColumn;
    protected LinkedList<Element> compositeElements;
    protected float currentLeading = 16.0f;
    protected float descender;
    protected float extraParagraphSpace = 0.0f;
    private float filledWidth;
    private float firstLineY;
    private boolean firstLineYDone = false;
    protected float fixedLeading = 16.0f;
    protected float followingIndent = 0.0f;
    private boolean ignoreSpacingBefore = true;
    protected float indent = 0.0f;
    private boolean inheritGraphicState = false;
    protected boolean isWordSplit;
    private boolean lastWasNewline = true;
    protected float lastX;
    protected ArrayList<float[]> leftWall;
    protected float leftX;
    protected int lineStatus;
    private int linesWritten;
    protected int listIdx = 0;
    protected float maxY;
    protected float minY;
    protected float multipliedLeading = 0.0f;
    protected boolean rectangularMode = false;
    protected float rectangularWidth = -1.0f;
    private boolean repeatFirstLineIndent = true;
    protected float rightIndent = 0.0f;
    protected ArrayList<float[]> rightWall;
    protected float rightX;
    protected int rowIdx = 0;
    protected int runDirection = 1;
    private float spaceCharRatio = 0.0f;
    private int splittedRow = -2;
    private boolean useAscender = false;
    protected Phrase waitPhrase;
    protected float yLine;

    public static boolean hasMoreText(int i) {
        return (i & 1) == 0;
    }

    public ColumnText(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
    }

    public static ColumnText duplicate(ColumnText columnText) {
        ColumnText columnText2 = new ColumnText(null);
        columnText2.setACopy(columnText);
        return columnText2;
    }

    public ColumnText setACopy(ColumnText columnText) {
        if (columnText != null) {
            setSimpleVars(columnText);
            if (columnText.bidiLine != null) {
                this.bidiLine = new BidiLine(columnText.bidiLine);
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void setSimpleVars(ColumnText columnText) {
        this.maxY = columnText.maxY;
        this.minY = columnText.minY;
        this.alignment = columnText.alignment;
        this.leftWall = null;
        if (columnText.leftWall != null) {
            this.leftWall = new ArrayList<>(columnText.leftWall);
        }
        this.rightWall = null;
        if (columnText.rightWall != null) {
            this.rightWall = new ArrayList<>(columnText.rightWall);
        }
        this.yLine = columnText.yLine;
        this.currentLeading = columnText.currentLeading;
        this.fixedLeading = columnText.fixedLeading;
        this.multipliedLeading = columnText.multipliedLeading;
        this.canvas = columnText.canvas;
        this.canvases = columnText.canvases;
        this.lineStatus = columnText.lineStatus;
        this.indent = columnText.indent;
        this.followingIndent = columnText.followingIndent;
        this.rightIndent = columnText.rightIndent;
        this.extraParagraphSpace = columnText.extraParagraphSpace;
        this.rectangularWidth = columnText.rectangularWidth;
        this.rectangularMode = columnText.rectangularMode;
        this.spaceCharRatio = columnText.spaceCharRatio;
        this.lastWasNewline = columnText.lastWasNewline;
        this.repeatFirstLineIndent = columnText.repeatFirstLineIndent;
        this.linesWritten = columnText.linesWritten;
        this.arabicOptions = columnText.arabicOptions;
        this.runDirection = columnText.runDirection;
        this.descender = columnText.descender;
        this.composite = columnText.composite;
        this.splittedRow = columnText.splittedRow;
        if (columnText.composite) {
            this.compositeElements = new LinkedList<>();
            Iterator<Element> it2 = columnText.compositeElements.iterator();
            while (it2.hasNext()) {
                Element next = it2.next();
                if (next instanceof PdfPTable) {
                    this.compositeElements.add(new PdfPTable((PdfPTable) next));
                } else {
                    this.compositeElements.add(next);
                }
            }
            ColumnText columnText2 = columnText.compositeColumn;
            if (columnText2 != null) {
                this.compositeColumn = duplicate(columnText2);
            }
        }
        this.listIdx = columnText.listIdx;
        this.rowIdx = columnText.rowIdx;
        this.firstLineY = columnText.firstLineY;
        this.leftX = columnText.leftX;
        this.rightX = columnText.rightX;
        this.firstLineYDone = columnText.firstLineYDone;
        this.waitPhrase = columnText.waitPhrase;
        this.useAscender = columnText.useAscender;
        this.filledWidth = columnText.filledWidth;
        this.adjustFirstLine = columnText.adjustFirstLine;
        this.inheritGraphicState = columnText.inheritGraphicState;
        this.ignoreSpacingBefore = columnText.ignoreSpacingBefore;
    }

    private void addWaitingPhrase() {
        if (this.bidiLine == null && this.waitPhrase != null) {
            this.bidiLine = new BidiLine();
            for (Chunk chunk : this.waitPhrase.getChunks()) {
                this.bidiLine.addChunk(new PdfChunk(chunk, null, this.waitPhrase.getTabSettings()));
            }
            this.waitPhrase = null;
        }
    }

    public void addText(Phrase phrase) {
        if (phrase != null && !this.composite) {
            addWaitingPhrase();
            if (this.bidiLine == null) {
                this.waitPhrase = phrase;
                return;
            }
            for (Chunk chunk : phrase.getChunks()) {
                this.bidiLine.addChunk(new PdfChunk(chunk, null, phrase.getTabSettings()));
            }
        }
    }

    public void setText(Phrase phrase) {
        this.bidiLine = null;
        this.composite = false;
        this.compositeColumn = null;
        this.compositeElements = null;
        this.listIdx = 0;
        this.rowIdx = 0;
        this.splittedRow = -1;
        this.waitPhrase = phrase;
    }

    public void addText(Chunk chunk) {
        if (chunk != null && !this.composite) {
            addText(new Phrase(chunk));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addElement(com.itextpdf.text.Paragraph r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = r7 instanceof com.itextpdf.text.Image
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0071
            com.itextpdf.text.Image r7 = (com.itextpdf.text.Image) r7
            com.itextpdf.text.pdf.PdfPTable r0 = new com.itextpdf.text.pdf.PdfPTable
            r0.<init>(r2)
            float r3 = r7.getWidthPercentage()
            r4 = 0
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x0024
            float r3 = r7.getScaledWidth()
            r0.setTotalWidth(r3)
            r0.setLockedWidth(r2)
            goto L_0x0027
        L_0x0024:
            r0.setWidthPercentage(r3)
        L_0x0027:
            float r3 = r7.getSpacingAfter()
            r0.setSpacingAfter(r3)
            float r3 = r7.getSpacingBefore()
            r0.setSpacingBefore(r3)
            int r3 = r7.getAlignment()
            if (r3 == 0) goto L_0x0046
            r5 = 2
            if (r3 == r5) goto L_0x0042
            r0.setHorizontalAlignment(r2)
            goto L_0x0049
        L_0x0042:
            r0.setHorizontalAlignment(r5)
            goto L_0x0049
        L_0x0046:
            r0.setHorizontalAlignment(r1)
        L_0x0049:
            com.itextpdf.text.pdf.PdfPCell r3 = new com.itextpdf.text.pdf.PdfPCell
            r3.<init>(r7, r2)
            r3.setPadding(r4)
            int r4 = r7.getBorder()
            r3.setBorder(r4)
            com.itextpdf.text.BaseColor r4 = r7.getBorderColor()
            r3.setBorderColor(r4)
            float r4 = r7.getBorderWidth()
            r3.setBorderWidth(r4)
            com.itextpdf.text.BaseColor r7 = r7.getBackgroundColor()
            r3.setBackgroundColor(r7)
            r0.addCell(r3)
            r7 = r0
        L_0x0071:
            int r0 = r7.type()
            r3 = 10
            r4 = 23
            if (r0 != r3) goto L_0x0084
            com.itextpdf.text.Paragraph r0 = new com.itextpdf.text.Paragraph
            com.itextpdf.text.Chunk r7 = (com.itextpdf.text.Chunk) r7
            r0.<init>(r7)
        L_0x0082:
            r7 = r0
            goto L_0x00a0
        L_0x0084:
            int r0 = r7.type()
            r3 = 11
            if (r0 != r3) goto L_0x0094
            com.itextpdf.text.Paragraph r0 = new com.itextpdf.text.Paragraph
            com.itextpdf.text.Phrase r7 = (com.itextpdf.text.Phrase) r7
            r0.<init>(r7)
            goto L_0x0082
        L_0x0094:
            int r0 = r7.type()
            if (r0 != r4) goto L_0x00a0
            r0 = r7
            com.itextpdf.text.pdf.PdfPTable r0 = (com.itextpdf.text.pdf.PdfPTable) r0
            r0.init()
        L_0x00a0:
            int r0 = r7.type()
            r3 = 12
            if (r0 == r3) goto L_0x00d5
            int r0 = r7.type()
            r5 = 14
            if (r0 == r5) goto L_0x00d5
            int r0 = r7.type()
            if (r0 == r4) goto L_0x00d5
            int r0 = r7.type()
            r4 = 55
            if (r0 == r4) goto L_0x00d5
            int r0 = r7.type()
            r4 = 37
            if (r0 != r4) goto L_0x00c7
            goto L_0x00d5
        L_0x00c7:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "element.not.allowed"
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r0)
            r7.<init>(r0)
            throw r7
        L_0x00d5:
            boolean r0 = r6.composite
            if (r0 != 0) goto L_0x00e7
            r6.composite = r2
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r6.compositeElements = r0
            r0 = 0
            r6.bidiLine = r0
            r6.waitPhrase = r0
        L_0x00e7:
            int r0 = r7.type()
            if (r0 != r3) goto L_0x00f9
            com.itextpdf.text.Paragraph r7 = (com.itextpdf.text.Paragraph) r7
            java.util.LinkedList<com.itextpdf.text.Element> r0 = r6.compositeElements
            java.util.List r7 = r7.breakUp()
            r0.addAll(r7)
            return
        L_0x00f9:
            java.util.LinkedList<com.itextpdf.text.Element> r0 = r6.compositeElements
            r0.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.addElement(com.itextpdf.text.Element):void");
    }

    public static boolean isAllowedElement(Element element) {
        int type = element.type();
        if (type == 10 || type == 11 || type == 37 || type == 12 || type == 14 || type == 55 || type == 23 || (element instanceof Image)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ArrayList<float[]> convertColumn(float[] fArr) {
        if (fArr.length >= 4) {
            ArrayList<float[]> arrayList = new ArrayList<>();
            int i = 0;
            while (i < fArr.length - 2) {
                float f = fArr[i];
                float f2 = fArr[i + 1];
                int i2 = i + 2;
                float f3 = fArr[i2];
                float f4 = fArr[i + 3];
                if (f2 != f4) {
                    float f5 = (f - f3) / (f2 - f4);
                    float[] fArr2 = {Math.min(f2, f4), Math.max(f2, f4), f5, f - (f5 * f2)};
                    arrayList.add(fArr2);
                    this.maxY = Math.max(this.maxY, fArr2[1]);
                    this.minY = Math.min(this.minY, fArr2[0]);
                }
                i = i2;
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new RuntimeException(MessageLocalization.getComposedMessage("no.valid.column.line.found", new Object[0]));
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("no.valid.column.line.found", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public float findLimitsPoint(ArrayList<float[]> arrayList) {
        this.lineStatus = 0;
        float f = this.yLine;
        if (f < this.minY || f > this.maxY) {
            this.lineStatus = 1;
            return 0.0f;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            float[] fArr = arrayList.get(i);
            float f2 = this.yLine;
            if (f2 >= fArr[0] && f2 <= fArr[1]) {
                return (fArr[2] * f2) + fArr[3];
            }
        }
        this.lineStatus = 2;
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public float[] findLimitsOneLine() {
        float findLimitsPoint = findLimitsPoint(this.leftWall);
        int i = this.lineStatus;
        if (i == 1 || i == 2) {
            return null;
        }
        float findLimitsPoint2 = findLimitsPoint(this.rightWall);
        if (this.lineStatus == 2) {
            return null;
        }
        return new float[]{findLimitsPoint, findLimitsPoint2};
    }

    /* access modifiers changed from: protected */
    public float[] findLimitsTwoLines() {
        boolean z = false;
        while (true) {
            if (z && this.currentLeading == 0.0f) {
                return null;
            }
            float[] findLimitsOneLine = findLimitsOneLine();
            int i = this.lineStatus;
            if (i == 1) {
                return null;
            }
            this.yLine -= this.currentLeading;
            if (i != 2) {
                float[] findLimitsOneLine2 = findLimitsOneLine();
                int i2 = this.lineStatus;
                if (i2 == 1) {
                    return null;
                }
                if (i2 == 2) {
                    this.yLine -= this.currentLeading;
                } else if (findLimitsOneLine[0] < findLimitsOneLine2[1] && findLimitsOneLine2[0] < findLimitsOneLine[1]) {
                    return new float[]{findLimitsOneLine[0], findLimitsOneLine[1], findLimitsOneLine2[0], findLimitsOneLine2[1]};
                }
            }
            z = true;
        }
    }

    public void setColumns(float[] fArr, float[] fArr2) {
        this.maxY = -1.0E21f;
        this.minY = 1.0E21f;
        setYLine(Math.max(fArr[1], fArr[fArr.length - 1]));
        this.rightWall = convertColumn(fArr2);
        this.leftWall = convertColumn(fArr);
        this.rectangularWidth = -1.0f;
        this.rectangularMode = false;
    }

    public void setSimpleColumn(Phrase phrase, float f, float f2, float f3, float f4, float f5, int i) {
        addText(phrase);
        setSimpleColumn(f, f2, f3, f4, f5, i);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4, float f5, int i) {
        setLeading(f5);
        this.alignment = i;
        setSimpleColumn(f, f2, f3, f4);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4) {
        this.leftX = Math.min(f, f3);
        this.maxY = Math.max(f2, f4);
        this.minY = Math.min(f2, f4);
        float max = Math.max(f, f3);
        this.rightX = max;
        this.yLine = this.maxY;
        float f5 = max - this.leftX;
        this.rectangularWidth = f5;
        if (f5 < 0.0f) {
            this.rectangularWidth = 0.0f;
        }
        this.rectangularMode = true;
    }

    public void setSimpleColumn(Rectangle rectangle) {
        setSimpleColumn(rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop());
    }

    public void setLeading(float f) {
        this.fixedLeading = f;
        this.multipliedLeading = 0.0f;
    }

    public void setLeading(float f, float f2) {
        this.fixedLeading = f;
        this.multipliedLeading = f2;
    }

    public float getLeading() {
        return this.fixedLeading;
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    public void setYLine(float f) {
        this.yLine = f;
    }

    public float getYLine() {
        return this.yLine;
    }

    public int getRowsDrawn() {
        return this.rowIdx;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setIndent(float f) {
        setIndent(f, true);
    }

    public void setIndent(float f, boolean z) {
        this.indent = f;
        this.lastWasNewline = true;
        this.repeatFirstLineIndent = z;
    }

    public float getIndent() {
        return this.indent;
    }

    public void setFollowingIndent(float f) {
        this.followingIndent = f;
        this.lastWasNewline = true;
    }

    public float getFollowingIndent() {
        return this.followingIndent;
    }

    public void setRightIndent(float f) {
        this.rightIndent = f;
        this.lastWasNewline = true;
    }

    public float getRightIndent() {
        return this.rightIndent;
    }

    public float getCurrentLeading() {
        return this.currentLeading;
    }

    public boolean getInheritGraphicState() {
        return this.inheritGraphicState;
    }

    public void setInheritGraphicState(boolean z) {
        this.inheritGraphicState = z;
    }

    public boolean isIgnoreSpacingBefore() {
        return this.ignoreSpacingBefore;
    }

    public void setIgnoreSpacingBefore(boolean z) {
        this.ignoreSpacingBefore = z;
    }

    public int go() throws DocumentException {
        return go(false);
    }

    public int go(boolean z) throws DocumentException {
        return go(z, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d9, code lost:
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a4, code lost:
        r30.bidiLine.restore();
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d7, code lost:
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d9, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0322  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int go(boolean r31, com.itextpdf.text.pdf.interfaces.IAccessibleElement r32) throws com.itextpdf.text.DocumentException {
        /*
            r30 = this;
            r0 = r30
            r1 = r32
            r2 = 0
            r0.isWordSplit = r2
            boolean r3 = r0.composite
            if (r3 == 0) goto L_0x0010
            int r1 = r30.goComposite(r31)
            return r1
        L_0x0010:
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.canvas
            boolean r3 = isTagged(r3)
            if (r3 == 0) goto L_0x0024
            boolean r3 = r1 instanceof com.itextpdf.text.ListItem
            if (r3 == 0) goto L_0x0024
            r3 = r1
            com.itextpdf.text.ListItem r3 = (com.itextpdf.text.ListItem) r3
            com.itextpdf.text.ListBody r3 = r3.getListBody()
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            r30.addWaitingPhrase()
            com.itextpdf.text.pdf.BidiLine r5 = r0.bidiLine
            r6 = 1
            if (r5 != 0) goto L_0x002e
            return r6
        L_0x002e:
            r5 = 0
            r0.descender = r5
            r0.linesWritten = r2
            r0.lastX = r5
            float r7 = r0.spaceCharRatio
            r8 = 2
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.Float r9 = new java.lang.Float
            r9.<init>(r5)
            r15[r6] = r9
            r9 = 2143289344(0x7fc00000, float:NaN)
            r0.firstLineY = r9
            int r14 = r0.runDirection
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            if (r9 == 0) goto L_0x0068
            com.itextpdf.text.pdf.PdfDocument r10 = r9.getPdfDocument()
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.canvas
            boolean r11 = isTagged(r11)
            if (r11 != 0) goto L_0x0060
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.canvas
            boolean r12 = r0.inheritGraphicState
            com.itextpdf.text.pdf.PdfContentByte r11 = r11.getDuplicate(r12)
            goto L_0x0062
        L_0x0060:
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.canvas
        L_0x0062:
            r25 = r9
            r26 = r10
            r13 = r11
            goto L_0x006f
        L_0x0068:
            if (r31 == 0) goto L_0x0338
            r13 = 0
            r25 = 0
            r26 = 0
        L_0x006f:
            r9 = 981668463(0x3a83126f, float:0.001)
            if (r31 != 0) goto L_0x0088
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x0081
            com.itextpdf.text.pdf.PdfWriter r7 = r13.getPdfWriter()
            float r7 = r7.getSpaceCharRatio()
            goto L_0x0088
        L_0x0081:
            int r10 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r10 >= 0) goto L_0x0088
            r7 = 981668463(0x3a83126f, float:0.001)
        L_0x0088:
            boolean r9 = r0.rectangularMode
            if (r9 != 0) goto L_0x00b3
            com.itextpdf.text.pdf.BidiLine r9 = r0.bidiLine
            java.util.ArrayList<com.itextpdf.text.pdf.PdfChunk> r9 = r9.chunks
            java.util.Iterator r9 = r9.iterator()
            r10 = 0
        L_0x0095:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00aa
            java.lang.Object r11 = r9.next()
            com.itextpdf.text.pdf.PdfChunk r11 = (com.itextpdf.text.pdf.PdfChunk) r11
            float r11 = r11.height()
            float r10 = java.lang.Math.max(r10, r11)
            goto L_0x0095
        L_0x00aa:
            float r9 = r0.fixedLeading
            float r11 = r0.multipliedLeading
            float r10 = r10 * r11
            float r9 = r9 + r10
            r0.currentLeading = r9
        L_0x00b3:
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x00b6:
            boolean r12 = r0.lastWasNewline
            if (r12 == 0) goto L_0x00bd
            float r12 = r0.indent
            goto L_0x00bf
        L_0x00bd:
            float r12 = r0.followingIndent
        L_0x00bf:
            boolean r5 = r0.rectangularMode
            r16 = 3
            if (r5 == 0) goto L_0x01ad
            float r5 = r0.rectangularWidth
            float r4 = r0.rightIndent
            float r4 = r4 + r12
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00dc
            com.itextpdf.text.pdf.BidiLine r1 = r0.bidiLine
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00d9
            r6 = 3
            goto L_0x024e
        L_0x00d9:
            r6 = 2
            goto L_0x024e
        L_0x00dc:
            com.itextpdf.text.pdf.BidiLine r4 = r0.bidiLine
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00e6
            goto L_0x024e
        L_0x00e6:
            com.itextpdf.text.pdf.BidiLine r4 = r0.bidiLine
            float r5 = r0.leftX
            float r8 = r0.rectangularWidth
            float r8 = r8 - r12
            float r6 = r0.rightIndent
            float r18 = r8 - r6
            int r6 = r0.alignment
            int r8 = r0.arabicOptions
            float r2 = r0.minY
            r27 = r10
            float r10 = r0.yLine
            r28 = r7
            float r7 = r0.descender
            r16 = r4
            r17 = r5
            r19 = r6
            r20 = r14
            r21 = r8
            r22 = r2
            r23 = r10
            r24 = r7
            com.itextpdf.text.pdf.PdfLine r2 = r16.processLine(r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r4 = r0.isWordSplit
            com.itextpdf.text.pdf.BidiLine r5 = r0.bidiLine
            boolean r5 = r5.isWordSplit()
            r4 = r4 | r5
            r0.isWordSplit = r4
            if (r2 != 0) goto L_0x0122
            goto L_0x01d7
        L_0x0122:
            float r4 = r0.fixedLeading
            float r5 = r0.multipliedLeading
            float[] r4 = r2.getMaxSize(r4, r5)
            boolean r5 = r30.isUseAscender()
            if (r5 == 0) goto L_0x013f
            float r5 = r0.firstLineY
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 == 0) goto L_0x013f
            float r4 = r2.getAscender()
            r0.currentLeading = r4
            goto L_0x014e
        L_0x013f:
            r5 = 0
            r6 = r4[r5]
            r5 = 1
            r4 = r4[r5]
            float r5 = r0.descender
            float r4 = r4 - r5
            float r4 = java.lang.Math.max(r6, r4)
            r0.currentLeading = r4
        L_0x014e:
            float r4 = r0.yLine
            float r5 = r0.maxY
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x01a4
            float r5 = r0.currentLeading
            float r6 = r4 - r5
            float r7 = r0.minY
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0161
            goto L_0x01a4
        L_0x0161:
            float r4 = r4 - r5
            r0.yLine = r4
            if (r31 != 0) goto L_0x0184
            if (r9 != 0) goto L_0x0184
            boolean r4 = r2.isRTL
            if (r4 == 0) goto L_0x017d
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.canvas
            boolean r4 = r4.isTagged()
            if (r4 == 0) goto L_0x017d
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.canvas
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.REVERSEDCHARS
            r4.beginMarkedContentSequence(r5)
            r10 = 1
            goto L_0x017f
        L_0x017d:
            r10 = r27
        L_0x017f:
            r13.beginText()
            r9 = 1
            goto L_0x0186
        L_0x0184:
            r10 = r27
        L_0x0186:
            float r4 = r0.firstLineY
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 == 0) goto L_0x0192
            float r4 = r0.yLine
            r0.firstLineY = r4
        L_0x0192:
            float r4 = r0.rectangularWidth
            float r5 = r2.widthLeft()
            float r4 = r4 - r5
            r0.updateFilledWidth(r4)
            float r4 = r0.leftX
            r5 = r9
            r6 = r10
            r29 = r12
            goto L_0x026e
        L_0x01a4:
            com.itextpdf.text.pdf.BidiLine r1 = r0.bidiLine
            r1.restore()
            r10 = r27
            goto L_0x00d9
        L_0x01ad:
            r28 = r7
            r27 = r10
            float r2 = r0.yLine
            float r4 = r0.currentLeading
            float r2 = r2 - r4
            float[] r4 = r30.findLimitsTwoLines()
            if (r4 != 0) goto L_0x01cd
            com.itextpdf.text.pdf.BidiLine r1 = r0.bidiLine
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x01c6
            r6 = 3
            goto L_0x01c7
        L_0x01c6:
            r6 = 2
        L_0x01c7:
            r0.yLine = r2
            r10 = r27
            goto L_0x024e
        L_0x01cd:
            com.itextpdf.text.pdf.BidiLine r5 = r0.bidiLine
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x01dc
            r0.yLine = r2
        L_0x01d7:
            r10 = r27
        L_0x01d9:
            r6 = 1
            goto L_0x024e
        L_0x01dc:
            r5 = 0
            r6 = r4[r5]
            r5 = 2
            r7 = r4[r5]
            float r6 = java.lang.Math.max(r6, r7)
            r7 = 1
            r8 = r4[r7]
            r4 = r4[r16]
            float r4 = java.lang.Math.min(r8, r4)
            float r4 = r4 - r6
            float r7 = r0.rightIndent
            float r8 = r12 + r7
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x0202
            r10 = r27
        L_0x01fa:
            r7 = r28
            r2 = 0
            r5 = 0
            r6 = 1
            r8 = 2
            goto L_0x00b6
        L_0x0202:
            com.itextpdf.text.pdf.BidiLine r8 = r0.bidiLine
            float r4 = r4 - r12
            float r18 = r4 - r7
            int r4 = r0.alignment
            int r7 = r0.arabicOptions
            float r10 = r0.minY
            float r5 = r0.yLine
            r29 = r12
            float r12 = r0.descender
            r16 = r8
            r17 = r6
            r19 = r4
            r20 = r14
            r21 = r7
            r22 = r10
            r23 = r5
            r24 = r12
            com.itextpdf.text.pdf.PdfLine r4 = r16.processLine(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r31 != 0) goto L_0x0247
            if (r9 != 0) goto L_0x0247
            boolean r5 = r4.isRTL
            if (r5 == 0) goto L_0x0240
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.canvas
            boolean r5 = r5.isTagged()
            if (r5 == 0) goto L_0x0240
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.canvas
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.REVERSEDCHARS
            r5.beginMarkedContentSequence(r7)
            r10 = 1
            goto L_0x0242
        L_0x0240:
            r10 = r27
        L_0x0242:
            r13.beginText()
            r9 = 1
            goto L_0x0249
        L_0x0247:
            r10 = r27
        L_0x0249:
            if (r4 != 0) goto L_0x026a
            r0.yLine = r2
            goto L_0x01d9
        L_0x024e:
            if (r9 == 0) goto L_0x0269
            r13.endText()
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.canvas
            if (r1 == r13) goto L_0x025a
            r1.add(r13)
        L_0x025a:
            if (r10 == 0) goto L_0x0269
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.canvas
            boolean r1 = r1.isTagged()
            if (r1 == 0) goto L_0x0269
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.canvas
            r1.endMarkedContentSequence()
        L_0x0269:
            return r6
        L_0x026a:
            r2 = r4
            r4 = r6
            r5 = r9
            r6 = r10
        L_0x026e:
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.canvas
            boolean r7 = isTagged(r7)
            if (r7 == 0) goto L_0x02ca
            boolean r7 = r1 instanceof com.itextpdf.text.ListItem
            if (r7 == 0) goto L_0x02ca
            float r7 = r0.firstLineY
            boolean r7 = java.lang.Float.isNaN(r7)
            if (r7 != 0) goto L_0x02ca
            boolean r7 = r0.firstLineYDone
            if (r7 != 0) goto L_0x02ca
            if (r31 != 0) goto L_0x02c5
            r7 = r1
            com.itextpdf.text.ListItem r7 = (com.itextpdf.text.ListItem) r7
            com.itextpdf.text.ListLabel r8 = r7.getListLabel()
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            r9.openMCBlock(r8)
            com.itextpdf.text.Chunk r9 = new com.itextpdf.text.Chunk
            com.itextpdf.text.Chunk r7 = r7.getListSymbol()
            r9.<init>(r7)
            r7 = 0
            r9.setRole(r7)
            com.itextpdf.text.pdf.PdfContentByte r10 = r0.canvas
            r17 = 0
            com.itextpdf.text.Phrase r12 = new com.itextpdf.text.Phrase
            r12.<init>(r9)
            float r9 = r0.leftX
            float r16 = r8.getIndentation()
            float r19 = r9 + r16
            float r9 = r0.firstLineY
            r21 = 0
            r16 = r10
            r18 = r12
            r20 = r9
            showTextAligned(r16, r17, r18, r19, r20, r21)
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.canvas
            r9.closeMCBlock(r8)
            goto L_0x02c6
        L_0x02c5:
            r7 = 0
        L_0x02c6:
            r8 = 1
            r0.firstLineYDone = r8
            goto L_0x02cb
        L_0x02ca:
            r7 = 0
        L_0x02cb:
            if (r31 != 0) goto L_0x0306
            if (r3 == 0) goto L_0x02d5
            com.itextpdf.text.pdf.PdfContentByte r8 = r0.canvas
            r8.openMCBlock(r3)
            r3 = r7
        L_0x02d5:
            r8 = 0
            r15[r8] = r11
            boolean r8 = r2.isRTL()
            if (r8 == 0) goto L_0x02e1
            float r12 = r0.rightIndent
            goto L_0x02e3
        L_0x02e1:
            r12 = r29
        L_0x02e3:
            float r4 = r4 + r12
            float r8 = r2.indentLeft()
            float r4 = r4 + r8
            float r8 = r0.yLine
            r13.setTextMatrix(r4, r8)
            r9 = r26
            r10 = r2
            r11 = r13
            r12 = r25
            r4 = r13
            r13 = r15
            r8 = r14
            r14 = r28
            float r9 = r9.writeLineToContent(r10, r11, r12, r13, r14)
            r0.lastX = r9
            r9 = 0
            r10 = r15[r9]
            com.itextpdf.text.pdf.PdfFont r10 = (com.itextpdf.text.pdf.PdfFont) r10
            r11 = r10
            goto L_0x0308
        L_0x0306:
            r4 = r13
            r8 = r14
        L_0x0308:
            boolean r9 = r0.repeatFirstLineIndent
            if (r9 == 0) goto L_0x0314
            boolean r9 = r2.isNewlineSplit()
            if (r9 == 0) goto L_0x0314
            r9 = 1
            goto L_0x0315
        L_0x0314:
            r9 = 0
        L_0x0315:
            r0.lastWasNewline = r9
            float r9 = r0.yLine
            boolean r10 = r2.isNewlineSplit()
            if (r10 == 0) goto L_0x0322
            float r10 = r0.extraParagraphSpace
            goto L_0x0323
        L_0x0322:
            r10 = 0
        L_0x0323:
            float r9 = r9 - r10
            r0.yLine = r9
            int r9 = r0.linesWritten
            r10 = 1
            int r9 = r9 + r10
            r0.linesWritten = r9
            float r2 = r2.getDescender()
            r0.descender = r2
            r13 = r4
            r9 = r5
            r10 = r6
            r14 = r8
            goto L_0x01fa
        L_0x0338:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "columntext.go.with.simulate.eq.eq.false.and.text.eq.eq.null"
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r3, r2)
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.go(boolean, com.itextpdf.text.pdf.interfaces.IAccessibleElement):int");
    }

    public boolean isWordSplit() {
        return this.isWordSplit;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public void clearChunks() {
        BidiLine bidiLine2 = this.bidiLine;
        if (bidiLine2 != null) {
            bidiLine2.clearChunks();
        }
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public void setSpaceCharRatio(float f) {
        this.spaceCharRatio = f;
    }

    public void setRunDirection(int i) {
        if (i < 0 || i > 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public int getLinesWritten() {
        return this.linesWritten;
    }

    public float getLastX() {
        return this.lastX;
    }

    public int getArabicOptions() {
        return this.arabicOptions;
    }

    public void setArabicOptions(int i) {
        this.arabicOptions = i;
    }

    public float getDescender() {
        return this.descender;
    }

    public static float getWidth(Phrase phrase, int i, int i2) {
        ColumnText columnText = new ColumnText(null);
        columnText.addText(phrase);
        columnText.addWaitingPhrase();
        PdfLine processLine = columnText.bidiLine.processLine(0.0f, 20000.0f, 0, i, i2, 0.0f, 0.0f, 0.0f);
        if (processLine == null) {
            return 0.0f;
        }
        return 20000.0f - processLine.widthLeft();
    }

    public static float getWidth(Phrase phrase) {
        return getWidth(phrase, 1, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        if (r15 == 2) goto L_0x008a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void showTextAligned(com.itextpdf.text.pdf.PdfContentByte r18, int r19, com.itextpdf.text.Phrase r20, float r21, float r22, float r23, int r24, int r25) {
        /*
            r0 = r19
            r1 = r23
            r7 = r24
            r8 = 0
            r9 = 2
            if (r0 == 0) goto L_0x0011
            r2 = 1
            if (r0 == r2) goto L_0x0011
            if (r0 == r9) goto L_0x0011
            r15 = 0
            goto L_0x0012
        L_0x0011:
            r15 = r0
        L_0x0012:
            r18.saveState()
            com.itextpdf.text.pdf.ColumnText r14 = new com.itextpdf.text.pdf.ColumnText
            r13 = r18
            r14.<init>(r13)
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = 1073741824(0x40000000, float:2.0)
            r0 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r2 = 1184645120(0x469c4000, float:20000.0)
            r3 = 0
            if (r15 == 0) goto L_0x0035
            if (r15 == r9) goto L_0x002f
            r12 = -962838528(0xffffffffc69c4000, float:-20000.0)
            goto L_0x0036
        L_0x002f:
            r12 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r16 = 0
            goto L_0x0039
        L_0x0035:
            r12 = 0
        L_0x0036:
            r16 = 1184645120(0x469c4000, float:20000.0)
        L_0x0039:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0046
            float r12 = r12 + r21
            float r0 = r22 + r10
            float r16 = r16 + r21
            float r1 = r22 + r11
            goto L_0x006d
        L_0x0046:
            double r0 = (double) r1
            r2 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r0 = r0 * r2
            r2 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r0 = r0 / r2
            double r2 = java.lang.Math.cos(r0)
            float r4 = (float) r2
            double r0 = java.lang.Math.sin(r0)
            float r2 = (float) r0
            float r3 = -r2
            r0 = r18
            r1 = r4
            r5 = r21
            r6 = r22
            r0.concatCTM(r1, r2, r3, r4, r5, r6)
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x006d:
            r2 = 1073741824(0x40000000, float:2.0)
            r10 = r14
            r11 = r20
            r13 = r0
            r0 = r14
            r14 = r16
            r3 = r15
            r15 = r1
            r16 = r2
            r17 = r3
            r10.setSimpleColumn(r11, r12, r13, r14, r15, r16, r17)
            r1 = 3
            if (r7 != r1) goto L_0x0089
            if (r3 != 0) goto L_0x0086
            r8 = 2
            goto L_0x008a
        L_0x0086:
            if (r3 != r9) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r8 = r3
        L_0x008a:
            r0.setAlignment(r8)
            r1 = r25
            r0.setArabicOptions(r1)
            r0.setRunDirection(r7)
            r0.go()     // Catch:{ DocumentException -> 0x009c }
            r18.restoreState()
            return
        L_0x009c:
            r0 = move-exception
            r1 = r0
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.showTextAligned(com.itextpdf.text.pdf.PdfContentByte, int, com.itextpdf.text.Phrase, float, float, float, int, int):void");
    }

    public static void showTextAligned(PdfContentByte pdfContentByte, int i, Phrase phrase, float f, float f2, float f3) {
        showTextAligned(pdfContentByte, i, phrase, f, f2, f3, 1, 0);
    }

    public static float fitText(Font font, String str, Rectangle rectangle, float f, int i) {
        float f2;
        if (f <= 0.0f) {
            try {
                char[] charArray = str.toCharArray();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < charArray.length; i4++) {
                    if (charArray[i4] == '\n') {
                        i3++;
                    } else if (charArray[i4] == '\r') {
                        i2++;
                    }
                }
                f2 = (Math.abs(rectangle.getHeight()) / ((float) (Math.max(i2, i3) + 1))) - 0.001f;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            f2 = f;
        }
        font.setSize(f2);
        Phrase phrase = new Phrase(str, font);
        ColumnText columnText = new ColumnText(null);
        columnText.setSimpleColumn(phrase, rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), f2, 0);
        columnText.setRunDirection(i);
        if ((columnText.go(true) & 1) != 0) {
            return f2;
        }
        float f3 = f2;
        float f4 = 0.0f;
        for (int i5 = 0; i5 < 50; i5++) {
            f2 = (f4 + f3) / 2.0f;
            ColumnText columnText2 = new ColumnText(null);
            font.setSize(f2);
            columnText2.setSimpleColumn(new Phrase(str, font), rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), f2, 0);
            columnText2.setRunDirection(i);
            if ((columnText2.go(true) & 1) == 0) {
                f3 = f2;
            } else if (f3 - f4 < f2 * 0.1f) {
                return f2;
            } else {
                f4 = f2;
            }
        }
        return f2;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:172:0x03b1 */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:451:0x001e */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:466:0x001e */
    /* JADX DEBUG: Additional 6 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: com.itextpdf.text.pdf.ColumnText} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: com.itextpdf.text.pdf.ColumnText} */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r3v33, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r3v74 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* access modifiers changed from: protected */
    public int goComposite(boolean z) throws DocumentException {
        boolean z2;
        float f;
        PdfPTable.FittingRows fittingRows;
        float f2;
        boolean z3;
        float f3;
        boolean z4;
        float f4;
        float f5;
        ListItem listItem;
        boolean z5;
        int go;
        ColumnText columnText;
        ColumnText columnText2;
        boolean z6;
        boolean z7;
        int go2;
        PdfContentByte pdfContentByte = this.canvas;
        if (pdfContentByte != null) {
            PdfDocument pdfDocument = pdfContentByte.pdf;
        }
        ? r3 = 0;
        if (this.rectangularMode) {
            this.linesWritten = 0;
            float f6 = 0.0f;
            this.descender = 0.0f;
            int i = 3;
            ? r6 = 1;
            boolean z8 = this.runDirection == 3;
            boolean z9 = true;
            while (!this.compositeElements.isEmpty()) {
                Element first = this.compositeElements.getFirst();
                if (first.type() == 12) {
                    Paragraph paragraph = (Paragraph) first;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        if (i2 >= 2) {
                            break;
                        }
                        float f7 = this.yLine;
                        if (this.compositeColumn == null) {
                            ColumnText columnText3 = new ColumnText(this.canvas);
                            this.compositeColumn = columnText3;
                            columnText3.setAlignment(paragraph.getAlignment());
                            this.compositeColumn.setIndent(paragraph.getIndentationLeft() + paragraph.getFirstLineIndent(), r3);
                            this.compositeColumn.setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
                            this.compositeColumn.setFollowingIndent(paragraph.getIndentationLeft());
                            this.compositeColumn.setRightIndent(paragraph.getIndentationRight());
                            this.compositeColumn.setLeading(paragraph.getLeading(), paragraph.getMultipliedLeading());
                            this.compositeColumn.setRunDirection(this.runDirection);
                            this.compositeColumn.setArabicOptions(this.arabicOptions);
                            this.compositeColumn.setSpaceCharRatio(this.spaceCharRatio);
                            this.compositeColumn.addText(paragraph);
                            if (!z9 || !this.adjustFirstLine) {
                                this.yLine -= paragraph.getSpacingBefore();
                            }
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        this.compositeColumn.setUseAscender(((z9 || this.descender == f6) && this.adjustFirstLine) ? this.useAscender : false);
                        this.compositeColumn.setInheritGraphicState(this.inheritGraphicState);
                        ColumnText columnText4 = this.compositeColumn;
                        columnText4.leftX = this.leftX;
                        columnText4.rightX = this.rightX;
                        columnText4.yLine = this.yLine;
                        columnText4.rectangularWidth = this.rectangularWidth;
                        columnText4.rectangularMode = this.rectangularMode;
                        columnText4.minY = this.minY;
                        columnText4.maxY = this.maxY;
                        boolean z10 = paragraph.getKeepTogether() && z7 && (!z9 || !this.adjustFirstLine);
                        boolean z11 = z || (z10 && i2 == 0);
                        if (isTagged(this.canvas) && !z11) {
                            this.canvas.openMCBlock(paragraph);
                        }
                        go2 = this.compositeColumn.go(z11);
                        if (isTagged(this.canvas) && !z11) {
                            this.canvas.closeMCBlock(paragraph);
                        }
                        this.lastX = this.compositeColumn.getLastX();
                        updateFilledWidth(this.compositeColumn.filledWidth);
                        if ((go2 & 1) == 0 && z10) {
                            this.compositeColumn = null;
                            this.yLine = f7;
                            return 2;
                        } else if (z || !z10) {
                            i3 = go2;
                        } else {
                            if (i2 == 0) {
                                this.compositeColumn = null;
                                this.yLine = f7;
                            }
                            i2++;
                            i3 = go2;
                            f6 = 0.0f;
                        }
                    }
                    i3 = go2;
                    if (this.compositeColumn.getLinesWritten() > 0) {
                        ColumnText columnText5 = this.compositeColumn;
                        this.yLine = columnText5.yLine;
                        this.linesWritten += columnText5.linesWritten;
                        this.descender = columnText5.descender;
                        this.isWordSplit = columnText5.isWordSplit() | this.isWordSplit;
                    }
                    this.currentLeading = this.compositeColumn.currentLeading;
                    if ((i3 & 1) != 0) {
                        this.compositeColumn = null;
                        this.compositeElements.removeFirst();
                        this.yLine -= paragraph.getSpacingAfter();
                    }
                    if ((i3 & 2) != 0) {
                        return 2;
                    }
                } else {
                    if (first.type() == 14) {
                        List list = (List) first;
                        ArrayList<Element> items = list.getItems();
                        float indentationLeft = list.getIndentationLeft();
                        Stack stack = new Stack();
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            if (i4 >= items.size()) {
                                listItem = null;
                                break;
                            }
                            Element element = items.get(i4);
                            if (!(element instanceof ListItem)) {
                                if (element instanceof List) {
                                    Object[] objArr = new Object[i];
                                    objArr[r3] = list;
                                    objArr[r6] = Integer.valueOf(i4);
                                    objArr[2] = new Float(indentationLeft);
                                    stack.push(objArr);
                                    List list2 = (List) element;
                                    items = list2.getItems();
                                    indentationLeft += list2.getIndentationLeft();
                                    list = list2;
                                    i4 = -1;
                                }
                                while (i4 == items.size() - r6) {
                                    Object[] objArr2 = (Object[]) stack.pop();
                                    list = (List) objArr2[r3];
                                    ArrayList<Element> items2 = list.getItems();
                                    i4 = ((Integer) objArr2[r6]).intValue();
                                    indentationLeft = ((Float) objArr2[2]).floatValue();
                                    items = items2;
                                }
                            } else if (i5 == this.listIdx) {
                                listItem = (ListItem) element;
                                break;
                            } else {
                                i5++;
                                while (i4 == items.size() - r6 && !stack.isEmpty()) {
                                    Object[] objArr22 = (Object[]) stack.pop();
                                    list = (List) objArr22[r3];
                                    ArrayList<Element> items22 = list.getItems();
                                    i4 = ((Integer) objArr22[r6]).intValue();
                                    indentationLeft = ((Float) objArr22[2]).floatValue();
                                    items = items22;
                                }
                            }
                            i4 += r6;
                        }
                        int i6 = 0;
                        boolean z12 = false;
                        int i7 = 0;
                        ? r32 = r3;
                        while (true) {
                            if (i6 >= 2) {
                                break;
                            }
                            float f8 = this.yLine;
                            if (this.compositeColumn != null) {
                                z5 = false;
                            } else if (listItem == null) {
                                this.listIdx = r32;
                                this.compositeElements.removeFirst();
                                break;
                            } else {
                                ColumnText columnText6 = new ColumnText(this.canvas);
                                this.compositeColumn = columnText6;
                                columnText6.setUseAscender(((z9 || this.descender == 0.0f) && this.adjustFirstLine) ? this.useAscender : false);
                                this.compositeColumn.setInheritGraphicState(this.inheritGraphicState);
                                this.compositeColumn.setAlignment(listItem.getAlignment());
                                this.compositeColumn.setIndent(listItem.getIndentationLeft() + indentationLeft + listItem.getFirstLineIndent(), r32);
                                this.compositeColumn.setExtraParagraphSpace(listItem.getExtraParagraphSpace());
                                ColumnText columnText7 = this.compositeColumn;
                                columnText7.setFollowingIndent(columnText7.getIndent());
                                this.compositeColumn.setRightIndent(listItem.getIndentationRight() + list.getIndentationRight());
                                this.compositeColumn.setLeading(listItem.getLeading(), listItem.getMultipliedLeading());
                                this.compositeColumn.setRunDirection(this.runDirection);
                                this.compositeColumn.setArabicOptions(this.arabicOptions);
                                this.compositeColumn.setSpaceCharRatio(this.spaceCharRatio);
                                this.compositeColumn.addText(listItem);
                                if (!z9 || !this.adjustFirstLine) {
                                    this.yLine -= listItem.getSpacingBefore();
                                }
                                z5 = true;
                            }
                            ColumnText columnText8 = this.compositeColumn;
                            columnText8.leftX = this.leftX;
                            columnText8.rightX = this.rightX;
                            columnText8.yLine = this.yLine;
                            columnText8.rectangularWidth = this.rectangularWidth;
                            columnText8.rectangularMode = this.rectangularMode;
                            columnText8.minY = this.minY;
                            columnText8.maxY = this.maxY;
                            boolean z13 = listItem.getKeepTogether() && z5 && (!z9 || !this.adjustFirstLine);
                            boolean z14 = z || (z13 && i6 == 0);
                            if (isTagged(this.canvas) && !z14) {
                                listItem.getListLabel().setIndentation(indentationLeft);
                                if (list.getFirstItem() == listItem || !((columnText2 = this.compositeColumn) == null || columnText2.bidiLine == null)) {
                                    this.canvas.openMCBlock(list);
                                }
                                this.canvas.openMCBlock(listItem);
                            }
                            go = this.compositeColumn.go(z14, listItem);
                            if (isTagged(this.canvas) && !z14) {
                                this.canvas.closeMCBlock(listItem.getListBody());
                                this.canvas.closeMCBlock(listItem);
                            }
                            this.lastX = this.compositeColumn.getLastX();
                            updateFilledWidth(this.compositeColumn.filledWidth);
                            if ((go & 1) != 0 || !z13) {
                                columnText = null;
                            } else {
                                columnText = null;
                                this.compositeColumn = null;
                                this.yLine = f8;
                                z12 = true;
                            }
                            if (z || !z13 || z12) {
                                i7 = go;
                            } else {
                                if (i6 == 0) {
                                    this.compositeColumn = columnText;
                                    this.yLine = f8;
                                }
                                i6++;
                                i7 = go;
                                r32 = 0;
                            }
                        }
                        i7 = go;
                        if (isTagged(this.canvas) && !z && (listItem == null || ((list.getLastItem() == listItem && (i7 & 1) != 0) || (i7 & 2) != 0))) {
                            this.canvas.closeMCBlock(list);
                        }
                        if (z12) {
                            return 2;
                        }
                        if (listItem != null) {
                            ColumnText columnText9 = this.compositeColumn;
                            this.yLine = columnText9.yLine;
                            this.linesWritten += columnText9.linesWritten;
                            this.descender = columnText9.descender;
                            this.currentLeading = columnText9.currentLeading;
                            if (!isTagged(this.canvas) && !Float.isNaN(this.compositeColumn.firstLineY) && !this.compositeColumn.firstLineYDone) {
                                if (!z) {
                                    if (z8) {
                                        showTextAligned(this.canvas, 2, new Phrase(listItem.getListSymbol()), this.compositeColumn.lastX + listItem.getIndentationLeft(), this.compositeColumn.firstLineY, 0.0f, this.runDirection, this.arabicOptions);
                                    } else {
                                        PdfContentByte pdfContentByte2 = this.canvas;
                                        Phrase phrase = new Phrase(listItem.getListSymbol());
                                        ColumnText columnText10 = this.compositeColumn;
                                        showTextAligned(pdfContentByte2, 0, phrase, columnText10.leftX + indentationLeft, columnText10.firstLineY, 0.0f);
                                    }
                                }
                                this.compositeColumn.firstLineYDone = r6;
                            }
                            if ((i7 & 1) != 0) {
                                this.compositeColumn = null;
                                this.listIdx += r6;
                                this.yLine -= listItem.getSpacingAfter();
                            }
                            if ((i7 & 2) != 0) {
                                return 2;
                            }
                        }
                    } else if (first.type() == 23) {
                        PdfPTable pdfPTable = (PdfPTable) first;
                        int i8 = this.runDirection;
                        int runDirection2 = pdfPTable.getRunDirection();
                        this.runDirection = runDirection2;
                        z8 = runDirection2 == 3;
                        if (pdfPTable.size() <= pdfPTable.getHeaderRows()) {
                            this.compositeElements.removeFirst();
                            z2 = z9;
                        } else {
                            float f9 = this.yLine + this.descender;
                            if (this.rowIdx == 0 && this.adjustFirstLine) {
                                f9 -= pdfPTable.spacingBefore();
                            }
                            if (f9 < this.minY || f9 > this.maxY) {
                                return 2;
                            }
                            float f10 = this.leftX;
                            this.currentLeading = 0.0f;
                            if (pdfPTable.isLockedWidth()) {
                                f = pdfPTable.getTotalWidth();
                                updateFilledWidth(f);
                            } else {
                                f = (this.rectangularWidth * pdfPTable.getWidthPercentage()) / 100.0f;
                                pdfPTable.setTotalWidth(f);
                            }
                            pdfPTable.normalizeHeadersFooters();
                            int headerRows = pdfPTable.getHeaderRows();
                            int footerRows = pdfPTable.getFooterRows();
                            int i9 = headerRows - footerRows;
                            float footerHeight = pdfPTable.getFooterHeight();
                            float headerHeight = pdfPTable.getHeaderHeight() - footerHeight;
                            boolean z15 = pdfPTable.isSkipFirstHeader() && this.rowIdx <= i9 && (pdfPTable.isComplete() || this.rowIdx != i9);
                            float f11 = !z15 ? f9 - headerHeight : f9;
                            if (this.rowIdx < headerRows) {
                                this.rowIdx = headerRows;
                            }
                            PdfPTable.FittingRows fittingRows2 = pdfPTable.isSkipLastFooter() ? pdfPTable.getFittingRows(f11 - this.minY, this.rowIdx) : null;
                            if (!pdfPTable.isSkipLastFooter() || fittingRows2.lastRow < pdfPTable.size() - 1) {
                                f11 -= footerHeight;
                                fittingRows = pdfPTable.getFittingRows(f11 - this.minY, this.rowIdx);
                            } else {
                                fittingRows = fittingRows2;
                            }
                            if (f11 < this.minY || f11 > this.maxY) {
                                return 2;
                            }
                            int i10 = fittingRows.lastRow + 1;
                            z2 = z9;
                            float f12 = f11 - fittingRows.height;
                            this.LOGGER.info("Want to split at row " + i10);
                            int i11 = i10;
                            while (i11 > this.rowIdx && i11 < pdfPTable.size() && pdfPTable.getRow(i11).isMayNotBreak()) {
                                i11--;
                            }
                            if (i11 < pdfPTable.size() - 1 && !pdfPTable.getRow(i11).isMayNotBreak()) {
                                i11++;
                            }
                            if ((i11 <= this.rowIdx || i11 >= i10) && (i11 != headerRows || !pdfPTable.getRow(headerRows).isMayNotBreak() || !pdfPTable.isLoopCheck())) {
                                f2 = f12;
                            } else {
                                f2 = this.minY;
                                pdfPTable.setLoopCheck(false);
                                i10 = i11;
                            }
                            this.LOGGER.info("Will split at row " + i10);
                            if (pdfPTable.isSplitLate() && i10 > 0) {
                                fittingRows.correctLastRowChosen(pdfPTable, i10 - 1);
                            }
                            if (!pdfPTable.isComplete()) {
                                f2 += footerHeight;
                            }
                            if (!pdfPTable.isSplitRows()) {
                                this.splittedRow = -1;
                                if (i10 == this.rowIdx) {
                                    if (i10 == pdfPTable.size()) {
                                        this.compositeElements.removeFirst();
                                    } else if (!pdfPTable.isComplete() && i10 == 1) {
                                        return 2;
                                    } else {
                                        pdfPTable.getRows().remove(i10);
                                        return 2;
                                    }
                                }
                            } else if (pdfPTable.isSplitLate() && (this.rowIdx < i10 || (this.splittedRow == -2 && (pdfPTable.getHeaderRows() == 0 || pdfPTable.isSkipFirstHeader())))) {
                                this.splittedRow = -1;
                            } else if (i10 < pdfPTable.size()) {
                                f2 -= fittingRows.completedRowsHeight - fittingRows.height;
                                PdfPRow splitRow = pdfPTable.getRow(i10).splitRow(pdfPTable, i10, f2 - this.minY);
                                if (splitRow == null) {
                                    this.LOGGER.info("Didn't split row!");
                                    this.splittedRow = -1;
                                    if (this.rowIdx == i10) {
                                        return 2;
                                    }
                                } else {
                                    if (i10 != this.splittedRow) {
                                        this.splittedRow = i10 + 1;
                                        PdfPTable pdfPTable2 = new PdfPTable(pdfPTable);
                                        this.compositeElements.set(0, pdfPTable2);
                                        ArrayList<PdfPRow> rows = pdfPTable2.getRows();
                                        for (int i12 = headerRows; i12 < this.rowIdx; i12++) {
                                            rows.set(i12, null);
                                        }
                                        pdfPTable = pdfPTable2;
                                    }
                                    f2 = this.minY;
                                    i10++;
                                    pdfPTable.getRows().add(i10, splitRow);
                                    this.LOGGER.info("Inserting row at position " + i10);
                                }
                            }
                            if (!z) {
                                int horizontalAlignment = pdfPTable.getHorizontalAlignment();
                                if (horizontalAlignment != 1) {
                                    if (horizontalAlignment != 2) {
                                        if (z8) {
                                            f5 = this.rectangularWidth;
                                        }
                                    } else if (!z8) {
                                        f5 = this.rectangularWidth;
                                    }
                                    f3 = f5 - f;
                                    f10 += f3;
                                } else {
                                    f3 = (this.rectangularWidth - f) / 2.0f;
                                    f10 += f3;
                                }
                                PdfPTable shallowCopy = PdfPTable.shallowCopy(pdfPTable);
                                ArrayList<PdfPRow> rows2 = shallowCopy.getRows();
                                if (z15 || i9 <= 0) {
                                    shallowCopy.setHeaderRows(footerRows);
                                } else {
                                    ArrayList<PdfPRow> rows3 = pdfPTable.getRows(0, i9);
                                    if (isTagged(this.canvas)) {
                                        shallowCopy.getHeader().rows = rows3;
                                    }
                                    rows2.addAll(rows3);
                                }
                                ArrayList<PdfPRow> rows4 = pdfPTable.getRows(this.rowIdx, i10);
                                if (isTagged(this.canvas)) {
                                    shallowCopy.getBody().rows = rows4;
                                }
                                rows2.addAll(rows4);
                                boolean z16 = !pdfPTable.isSkipLastFooter();
                                if (i10 < pdfPTable.size()) {
                                    shallowCopy.setComplete(true);
                                    z4 = true;
                                    z16 = true;
                                } else {
                                    z4 = false;
                                }
                                if (footerRows <= 0 || !shallowCopy.isComplete() || !z16) {
                                    footerRows = 0;
                                } else {
                                    ArrayList<PdfPRow> rows5 = pdfPTable.getRows(i9, i9 + footerRows);
                                    if (isTagged(this.canvas)) {
                                        shallowCopy.getFooter().rows = rows5;
                                    }
                                    rows2.addAll(rows5);
                                }
                                if (rows2.size() > 0) {
                                    z3 = true;
                                    z3 = true;
                                    z3 = true;
                                    int size = (rows2.size() - 1) - footerRows;
                                    PdfPRow pdfPRow = rows2.get(size);
                                    if (pdfPTable.isExtendLastRow(z4)) {
                                        f4 = pdfPRow.getMaxHeights();
                                        pdfPRow.setMaxHeights((f2 - this.minY) + f4);
                                        f2 = this.minY;
                                    } else {
                                        f4 = 0.0f;
                                    }
                                    if (z4) {
                                        PdfPTableEvent tableEvent = pdfPTable.getTableEvent();
                                        if (tableEvent instanceof PdfPTableEventSplit) {
                                            ((PdfPTableEventSplit) tableEvent).splitTable(pdfPTable);
                                        }
                                    }
                                    PdfContentByte[] pdfContentByteArr = this.canvases;
                                    if (pdfContentByteArr != null) {
                                        if (isTagged(pdfContentByteArr[3])) {
                                            this.canvases[3].openMCBlock(pdfPTable);
                                        }
                                        shallowCopy.writeSelectedRows(0, -1, 0, -1, f10, f9, this.canvases, false);
                                        if (isTagged(this.canvases[3])) {
                                            this.canvases[3].closeMCBlock(pdfPTable);
                                        }
                                    } else {
                                        if (isTagged(this.canvas)) {
                                            this.canvas.openMCBlock(pdfPTable);
                                        }
                                        shallowCopy.writeSelectedRows(0, -1, 0, -1, f10, f9, this.canvas, false);
                                        if (isTagged(this.canvas)) {
                                            this.canvas.closeMCBlock(pdfPTable);
                                        }
                                    }
                                    if (!pdfPTable.isComplete()) {
                                        pdfPTable.addNumberOfRowsWritten(i10);
                                    }
                                    if (this.splittedRow == i10 && i10 < pdfPTable.size()) {
                                        pdfPTable.getRows().get(i10).copyRowContent(shallowCopy, size);
                                    } else if (i10 > 0 && i10 < pdfPTable.size()) {
                                        pdfPTable.getRow(i10).splitRowspans(pdfPTable, i10 - 1, shallowCopy, size);
                                    }
                                    if (pdfPTable.isExtendLastRow(z4)) {
                                        pdfPRow.setMaxHeights(f4);
                                    }
                                    if (z4) {
                                        PdfPTableEvent tableEvent2 = pdfPTable.getTableEvent();
                                        if (tableEvent2 instanceof PdfPTableEventAfterSplit) {
                                            ((PdfPTableEventAfterSplit) tableEvent2).afterSplitTable(pdfPTable, pdfPTable.getRow(i10), i10);
                                        }
                                    }
                                } else {
                                    z3 = true;
                                }
                            } else {
                                z3 = true;
                                z3 = true;
                                z3 = true;
                                if (pdfPTable.isExtendLastRow()) {
                                    float f13 = this.minY;
                                    if (f13 > -1.07374182E9f) {
                                        f2 = f13;
                                    }
                                }
                            }
                            this.yLine = f2;
                            this.descender = 0.0f;
                            this.currentLeading = 0.0f;
                            if (!z15 && !pdfPTable.isComplete()) {
                                this.yLine += footerHeight;
                            }
                            while (i10 < pdfPTable.size() && pdfPTable.getRowHeight(i10) <= 0.0f && !pdfPTable.hasRowspan(i10)) {
                                i10++;
                            }
                            if (i10 >= pdfPTable.size()) {
                                float spacingAfter = this.yLine - pdfPTable.spacingAfter();
                                float f14 = this.minY;
                                if (spacingAfter < f14) {
                                    this.yLine = f14;
                                } else {
                                    this.yLine -= pdfPTable.spacingAfter();
                                }
                                this.compositeElements.removeFirst();
                                this.splittedRow = -1;
                                this.rowIdx = 0;
                                this.runDirection = i8;
                                z8 = i8 == 3;
                                z6 = z3;
                                z9 = false;
                                r6 = z6;
                            } else {
                                if (this.splittedRow > -1) {
                                    ArrayList<PdfPRow> rows6 = pdfPTable.getRows();
                                    for (int i13 = this.rowIdx; i13 < i10; i13++) {
                                        rows6.set(i13, null);
                                    }
                                }
                                this.rowIdx = i10;
                                return 2;
                            }
                        }
                        z9 = z2;
                        f6 = 0.0f;
                        r3 = 0;
                        i = 3;
                        r6 = 1;
                    } else {
                        if (first.type() == 55) {
                            if (!z) {
                                ((DrawInterface) first).draw(this.canvas, this.leftX, this.minY, this.rightX, this.maxY, this.yLine);
                            }
                            this.compositeElements.removeFirst();
                        } else if (first.type() == 37) {
                            ArrayList arrayList = new ArrayList();
                            do {
                                arrayList.add(first);
                                this.compositeElements.removeFirst();
                                first = !this.compositeElements.isEmpty() ? this.compositeElements.getFirst() : null;
                                if (first == null) {
                                    break;
                                }
                            } while (first.type() == 37);
                            FloatLayout floatLayout = new FloatLayout(arrayList, this.useAscender);
                            floatLayout.setSimpleColumn(this.leftX, this.minY, this.rightX, this.yLine);
                            floatLayout.compositeColumn.setIgnoreSpacingBefore(isIgnoreSpacingBefore());
                            int layout = floatLayout.layout(this.canvas, z);
                            this.yLine = floatLayout.getYLine();
                            this.descender = 0.0f;
                            if ((layout & 1) == 0) {
                                this.compositeElements.addAll(arrayList);
                                return layout;
                            }
                        } else {
                            this.compositeElements.removeFirst();
                        }
                        z9 = z9;
                        r6 = r6;
                    }
                    f6 = 0.0f;
                    r3 = 0;
                    i = 3;
                }
                z6 = r6;
                z9 = false;
                r6 = z6;
                f6 = 0.0f;
                r3 = 0;
                i = 3;
            }
            return r6;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("irregular.columns.are.not.supported.in.composite.mode", new Object[0]));
    }

    public PdfContentByte getCanvas() {
        return this.canvas;
    }

    public void setCanvas(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
        this.canvases = null;
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvas(pdfContentByte);
        }
    }

    public void setCanvases(PdfContentByte[] pdfContentByteArr) {
        this.canvases = pdfContentByteArr;
        this.canvas = pdfContentByteArr[3];
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvases(pdfContentByteArr);
        }
    }

    public PdfContentByte[] getCanvases() {
        return this.canvases;
    }

    public boolean zeroHeightElement() {
        return this.composite && !this.compositeElements.isEmpty() && this.compositeElements.getFirst().type() == 55;
    }

    public java.util.List<Element> getCompositeElements() {
        return this.compositeElements;
    }

    public boolean isUseAscender() {
        return this.useAscender;
    }

    public void setUseAscender(boolean z) {
        this.useAscender = z;
    }

    public float getFilledWidth() {
        return this.filledWidth;
    }

    public void setFilledWidth(float f) {
        this.filledWidth = f;
    }

    public void updateFilledWidth(float f) {
        if (f > this.filledWidth) {
            this.filledWidth = f;
        }
    }

    public boolean isAdjustFirstLine() {
        return this.adjustFirstLine;
    }

    public void setAdjustFirstLine(boolean z) {
        this.adjustFirstLine = z;
    }

    private static boolean isTagged(PdfContentByte pdfContentByte) {
        return (pdfContentByte == null || pdfContentByte.pdf == null || pdfContentByte.writer == null || !pdfContentByte.writer.isTagged()) ? false : true;
    }
}
