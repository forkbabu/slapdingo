package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.TabStop;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfLine {
    protected int alignment;
    protected float height;
    protected boolean isRTL = false;
    protected float left;
    protected ArrayList<PdfChunk> line;
    protected ListItem listItem = null;
    protected boolean newlineSplit = false;
    protected float originalWidth;
    protected float tabPosition = Float.NaN;
    protected TabStop tabStop = null;
    protected float tabStopAnchorPosition = Float.NaN;
    protected float width;

    PdfLine(float f, float f2, int i, float f3) {
        this.left = f;
        float f4 = f2 - f;
        this.width = f4;
        this.originalWidth = f4;
        this.alignment = i;
        this.height = f3;
        this.line = new ArrayList<>();
    }

    PdfLine(float f, float f2, float f3, int i, boolean z, ArrayList<PdfChunk> arrayList, boolean z2) {
        this.left = f;
        this.originalWidth = f2;
        this.width = f3;
        this.alignment = i;
        this.line = arrayList;
        this.newlineSplit = z;
        this.isRTL = z2;
    }

    /* access modifiers changed from: package-private */
    public PdfChunk add(PdfChunk pdfChunk, float f) {
        if (pdfChunk != null && !pdfChunk.toString().equals("") && !pdfChunk.toString().equals(" ") && (this.height < f || this.line.isEmpty())) {
            this.height = f;
        }
        return add(pdfChunk);
    }

    /* access modifiers changed from: package-private */
    public PdfChunk add(PdfChunk pdfChunk) {
        if (pdfChunk == null || pdfChunk.toString().equals("")) {
            return null;
        }
        PdfChunk split = pdfChunk.split(this.width);
        this.newlineSplit = pdfChunk.isNewlineSplit() || split == null;
        if (pdfChunk.isTab()) {
            Object[] objArr = (Object[]) pdfChunk.getAttribute(Chunk.TAB);
            if (pdfChunk.isAttribute(Chunk.TABSETTINGS)) {
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                if (booleanValue && this.line.isEmpty()) {
                    return null;
                }
                flush();
                this.tabStopAnchorPosition = Float.NaN;
                TabStop tabStop2 = PdfChunk.getTabStop(pdfChunk, this.originalWidth - this.width);
                this.tabStop = tabStop2;
                float position = tabStop2.getPosition();
                float f = this.originalWidth;
                if (position > f) {
                    if (!booleanValue) {
                        if (((double) Math.abs(f - this.width)) < 0.001d) {
                            addToLine(pdfChunk);
                        }
                        this.width = 0.0f;
                        return pdfChunk;
                    }
                    pdfChunk = null;
                    this.width = 0.0f;
                    return pdfChunk;
                }
                pdfChunk.setTabStop(this.tabStop);
                if (this.isRTL || this.tabStop.getAlignment() != TabStop.Alignment.LEFT) {
                    this.tabPosition = this.originalWidth - this.width;
                } else {
                    this.width = this.originalWidth - this.tabStop.getPosition();
                    this.tabStop = null;
                    this.tabPosition = Float.NaN;
                }
                addToLine(pdfChunk);
                return split;
            }
            Float valueOf = Float.valueOf(((Float) objArr[1]).floatValue());
            if (((Boolean) objArr[2]).booleanValue() && valueOf.floatValue() < this.originalWidth - this.width) {
                return pdfChunk;
            }
            pdfChunk.adjustLeft(this.left);
            this.width = this.originalWidth - valueOf.floatValue();
            addToLine(pdfChunk);
            return split;
        } else if (pdfChunk.length() > 0 || pdfChunk.isImage()) {
            if (split != null) {
                pdfChunk.trimLastSpace();
            }
            this.width -= pdfChunk.width();
            addToLine(pdfChunk);
            return split;
        } else if (this.line.size() < 1) {
            PdfChunk truncate = split.truncate(this.width);
            this.width -= split.width();
            if (split.length() > 0) {
                addToLine(split);
                return truncate;
            }
            if (truncate != null) {
                addToLine(truncate);
            }
            return null;
        } else {
            float f2 = this.width;
            ArrayList<PdfChunk> arrayList = this.line;
            this.width = f2 + arrayList.get(arrayList.size() - 1).trimLastSpace();
            return split;
        }
    }

    private void addToLine(PdfChunk pdfChunk) {
        String pdfChunk2;
        int indexOf;
        float f;
        if (pdfChunk.changeLeading) {
            if (pdfChunk.isImage()) {
                Image image = pdfChunk.getImage();
                f = pdfChunk.getImageHeight() + pdfChunk.getImageOffsetY() + image.getBorderWidthTop() + image.getSpacingBefore();
            } else {
                f = pdfChunk.getLeading();
            }
            if (f > this.height) {
                this.height = f;
            }
        }
        TabStop tabStop2 = this.tabStop;
        if (tabStop2 != null && tabStop2.getAlignment() == TabStop.Alignment.ANCHOR && Float.isNaN(this.tabStopAnchorPosition) && (indexOf = (pdfChunk2 = pdfChunk.toString()).indexOf(this.tabStop.getAnchorChar())) != -1) {
            this.tabStopAnchorPosition = (this.originalWidth - this.width) - pdfChunk.width(pdfChunk2.substring(indexOf, pdfChunk2.length()));
        }
        this.line.add(pdfChunk);
    }

    public int size() {
        return this.line.size();
    }

    public Iterator<PdfChunk> iterator() {
        return this.line.iterator();
    }

    /* access modifiers changed from: package-private */
    public float height() {
        return this.height;
    }

    /* access modifiers changed from: package-private */
    public float indentLeft() {
        if (this.isRTL) {
            int i = this.alignment;
            if (i == 1) {
                return this.left + (this.width / 2.0f);
            }
            if (i == 2) {
                return this.left;
            }
            if (i != 3) {
                return this.left + this.width;
            }
            return this.left + (hasToBeJustified() ? 0.0f : this.width);
        }
        if (getSeparatorCount() <= 0) {
            int i2 = this.alignment;
            if (i2 == 1) {
                return this.left + (this.width / 2.0f);
            }
            if (i2 == 2) {
                return this.left + this.width;
            }
        }
        return this.left;
    }

    public boolean hasToBeJustified() {
        return ((this.alignment == 3 && !this.newlineSplit) || this.alignment == 8) && this.width != 0.0f;
    }

    public void resetAlignment() {
        if (this.alignment == 3) {
            this.alignment = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void setExtraIndent(float f) {
        this.left += f;
        this.width -= f;
        this.originalWidth -= f;
    }

    /* access modifiers changed from: package-private */
    public float widthLeft() {
        return this.width;
    }

    /* access modifiers changed from: package-private */
    public int numberOfSpaces() {
        Iterator<PdfChunk> it2 = this.line.iterator();
        int i = 0;
        while (it2.hasNext()) {
            String pdfChunk = it2.next().toString();
            int length = pdfChunk.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (pdfChunk.charAt(i2) == ' ') {
                    i++;
                }
            }
        }
        return i;
    }

    public void setListItem(ListItem listItem2) {
        this.listItem = listItem2;
    }

    public Chunk listSymbol() {
        ListItem listItem2 = this.listItem;
        if (listItem2 != null) {
            return listItem2.getListSymbol();
        }
        return null;
    }

    public float listIndent() {
        ListItem listItem2 = this.listItem;
        if (listItem2 != null) {
            return listItem2.getIndentationLeft();
        }
        return 0.0f;
    }

    public ListItem listItem() {
        return this.listItem;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<PdfChunk> it2 = this.line.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(it2.next().toString());
        }
        return stringBuffer.toString();
    }

    public int getLineLengthUtf32() {
        Iterator<PdfChunk> it2 = this.line.iterator();
        int i = 0;
        while (it2.hasNext()) {
            i += it2.next().lengthUtf32();
        }
        return i;
    }

    public boolean isNewlineSplit() {
        return this.newlineSplit && this.alignment != 8;
    }

    public int getLastStrokeChunk() {
        int size = this.line.size() - 1;
        while (size >= 0 && !this.line.get(size).isStroked()) {
            size--;
        }
        return size;
    }

    public PdfChunk getChunk(int i) {
        if (i < 0 || i >= this.line.size()) {
            return null;
        }
        return this.line.get(i);
    }

    public float getOriginalWidth() {
        return this.originalWidth;
    }

    /* access modifiers changed from: package-private */
    public float[] getMaxSize(float f, float f2) {
        float f3 = -10000.0f;
        float f4 = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (pdfChunk.isImage()) {
                Image image = pdfChunk.getImage();
                if (pdfChunk.changeLeading()) {
                    f3 = Math.max(pdfChunk.getImageHeight() + pdfChunk.getImageOffsetY() + image.getSpacingBefore(), f3);
                }
            } else if (pdfChunk.changeLeading()) {
                f4 = Math.max(pdfChunk.getLeading(), f4);
            } else {
                f4 = Math.max((pdfChunk.font().size() * f2) + f, f4);
            }
        }
        float[] fArr = new float[2];
        if (f4 > 0.0f) {
            f = f4;
        }
        fArr[0] = f;
        fArr[1] = f3;
        return fArr;
    }

    /* access modifiers changed from: package-private */
    public boolean isRTL() {
        return this.isRTL;
    }

    /* access modifiers changed from: package-private */
    public int getSeparatorCount() {
        Iterator<PdfChunk> it2 = this.line.iterator();
        int i = 0;
        while (it2.hasNext()) {
            PdfChunk next = it2.next();
            if (next.isTab()) {
                if (!next.isAttribute(Chunk.TABSETTINGS)) {
                    return -1;
                }
            } else if (next.isHorizontalSeparator()) {
                i++;
            }
        }
        return i;
    }

    public float getWidthCorrected(float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            f3 += this.line.get(i).getWidthCorrected(f, f2);
        }
        return f3;
    }

    public float getAscender() {
        float f = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (pdfChunk.isImage()) {
                f = Math.max(f, pdfChunk.getImageHeight() + pdfChunk.getImageOffsetY());
            } else {
                PdfFont font = pdfChunk.font();
                float textRise = pdfChunk.getTextRise();
                if (textRise <= 0.0f) {
                    textRise = 0.0f;
                }
                f = Math.max(f, textRise + font.getFont().getFontDescriptor(1, font.size()));
            }
        }
        return f;
    }

    public float getDescender() {
        float f = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (pdfChunk.isImage()) {
                f = Math.min(f, pdfChunk.getImageOffsetY());
            } else {
                PdfFont font = pdfChunk.font();
                float textRise = pdfChunk.getTextRise();
                if (textRise >= 0.0f) {
                    textRise = 0.0f;
                }
                f = Math.min(f, textRise + font.getFont().getFontDescriptor(3, font.size()));
            }
        }
        return f;
    }

    public void flush() {
        TabStop tabStop2 = this.tabStop;
        if (tabStop2 != null) {
            float f = this.originalWidth;
            float f2 = this.width;
            float f3 = this.tabPosition;
            float position = tabStop2.getPosition(f3, f - f2, this.tabStopAnchorPosition);
            float f4 = (this.originalWidth - position) - ((f - f2) - f3);
            this.width = f4;
            if (f4 < 0.0f) {
                position += f4;
            }
            if (!this.isRTL) {
                this.tabStop.setPosition(position);
            } else {
                this.tabStop.setPosition((this.originalWidth - this.width) - this.tabPosition);
            }
            this.tabStop = null;
            this.tabPosition = Float.NaN;
        }
    }
}
