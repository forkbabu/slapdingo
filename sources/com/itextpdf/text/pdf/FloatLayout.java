package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.PdfDiv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloatLayout {
    protected final ColumnText compositeColumn;
    protected final List<Element> content;
    protected float filledWidth;
    protected float floatLeftX;
    protected float floatRightX;
    protected float leftX;
    protected float maxY;
    protected float minY;
    protected float rightX;
    protected final boolean useAscender;
    protected float yLine;

    public float getYLine() {
        return this.yLine;
    }

    public void setYLine(float f) {
        this.yLine = f;
    }

    public float getFilledWidth() {
        return this.filledWidth;
    }

    public void setFilledWidth(float f) {
        this.filledWidth = f;
    }

    public int getRunDirection() {
        return this.compositeColumn.getRunDirection();
    }

    public void setRunDirection(int i) {
        this.compositeColumn.setRunDirection(i);
    }

    public FloatLayout(List<Element> list, boolean z) {
        ColumnText columnText = new ColumnText(null);
        this.compositeColumn = columnText;
        columnText.setUseAscender(z);
        this.useAscender = z;
        this.content = list;
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4) {
        this.leftX = Math.min(f, f3);
        this.maxY = Math.max(f2, f4);
        this.minY = Math.min(f2, f4);
        float max = Math.max(f, f3);
        this.rightX = max;
        this.floatLeftX = this.leftX;
        this.floatRightX = max;
        this.yLine = this.maxY;
        this.filledWidth = 0.0f;
    }

    public int layout(PdfContentByte pdfContentByte, boolean z) throws DocumentException {
        PdfDiv pdfDiv;
        this.compositeColumn.setCanvas(pdfContentByte);
        ArrayList arrayList = new ArrayList();
        List arrayList2 = z ? new ArrayList(this.content) : this.content;
        int i = 1;
        while (true) {
            if (arrayList2.isEmpty()) {
                break;
            } else if (arrayList2.get(0) instanceof PdfDiv) {
                pdfDiv = (PdfDiv) arrayList2.get(0);
                if (pdfDiv.getFloatType() == PdfDiv.FloatType.LEFT || pdfDiv.getFloatType() == PdfDiv.FloatType.RIGHT) {
                    arrayList.add(pdfDiv);
                    arrayList2.remove(0);
                } else {
                    if (!arrayList.isEmpty()) {
                        i = floatingLayout(arrayList, z);
                        if ((i & 1) == 0) {
                            break;
                        }
                    }
                    arrayList2.remove(0);
                    i = pdfDiv.layout(pdfContentByte, this.useAscender, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    if (!pdfDiv.getKeepTogether() || (i & 1) != 0 || (this.compositeColumn.getCanvas().getPdfDocument().currentHeight <= 0.0f && this.yLine == this.maxY)) {
                        if (!z) {
                            pdfContentByte.openMCBlock(pdfDiv);
                            i = pdfDiv.layout(pdfContentByte, this.useAscender, z, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                            pdfContentByte.closeMCBlock(pdfDiv);
                        }
                        if (pdfDiv.getActualWidth() > this.filledWidth) {
                            this.filledWidth = pdfDiv.getActualWidth();
                        }
                        if ((i & 1) == 0) {
                            arrayList2.add(0, pdfDiv);
                            this.yLine = pdfDiv.getYLine();
                            break;
                        }
                        this.yLine -= pdfDiv.getActualHeight();
                    }
                }
            } else {
                arrayList.add(arrayList2.get(0));
                arrayList2.remove(0);
            }
        }
        arrayList2.add(0, pdfDiv);
        if ((i & 1) != 0 && !arrayList.isEmpty()) {
            i = floatingLayout(arrayList, z);
        }
        arrayList2.addAll(0, arrayList);
        return i;
    }

    private int floatingLayout(List<Element> list, boolean z) throws DocumentException {
        Element element;
        boolean z2;
        float f;
        float f2;
        PdfDiv pdfDiv;
        float f3;
        List<Element> list2 = list;
        float f4 = this.yLine;
        ColumnText columnText = this.compositeColumn;
        if (z) {
            columnText = ColumnText.duplicate(columnText);
        }
        int i = 0;
        float f5 = f4;
        boolean z3 = this.maxY == this.yLine;
        int i2 = 1;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (true) {
            if (list.isEmpty()) {
                break;
            }
            Element element2 = list2.get(i);
            list2.remove(i);
            if (element2 instanceof PdfDiv) {
                PdfDiv pdfDiv2 = (PdfDiv) element2;
                i2 = pdfDiv2.layout(this.compositeColumn.getCanvas(), this.useAscender, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                if ((i2 & 1) == 0) {
                    this.yLine = f5;
                    this.floatLeftX = this.leftX;
                    this.floatRightX = this.rightX;
                    i2 = pdfDiv2.layout(this.compositeColumn.getCanvas(), this.useAscender, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    if ((i2 & 1) == 0) {
                        list2.add(i, pdfDiv2);
                        break;
                    }
                }
                if (pdfDiv2.getFloatType() == PdfDiv.FloatType.LEFT) {
                    pdfDiv = pdfDiv2;
                    element = element2;
                    f3 = f6;
                    i2 = pdfDiv2.layout(this.compositeColumn.getCanvas(), this.useAscender, z, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    this.floatLeftX += pdfDiv.getActualWidth();
                    f7 += pdfDiv.getActualWidth();
                } else {
                    pdfDiv = pdfDiv2;
                    element = element2;
                    f3 = f6;
                    if (pdfDiv.getFloatType() == PdfDiv.FloatType.RIGHT) {
                        i2 = pdfDiv.layout(this.compositeColumn.getCanvas(), this.useAscender, z, (this.floatRightX - pdfDiv.getActualWidth()) - 0.01f, this.minY, this.floatRightX, this.yLine);
                        this.floatRightX -= pdfDiv.getActualWidth();
                        f6 = f3 + pdfDiv.getActualWidth();
                        f7 = f7;
                        z2 = z;
                        f5 = Math.min(f5, this.yLine - pdfDiv.getActualHeight());
                    } else {
                        f7 = f7;
                    }
                }
                f6 = f3;
                z2 = z;
                f5 = Math.min(f5, this.yLine - pdfDiv.getActualHeight());
            } else {
                element = element2;
                if (this.minY > f5) {
                    i2 = 2;
                    list2.add(0, element);
                    if (columnText != null) {
                        columnText.setText(null);
                    }
                    f7 = f7;
                    f6 = f6;
                } else {
                    if ((element instanceof Spaceable) && (!z3 || !columnText.isIgnoreSpacingBefore() || ((Spaceable) element).getPaddingTop() != 0.0f)) {
                        this.yLine -= ((Spaceable) element).getSpacingBefore();
                    }
                    z2 = z;
                    if (!z2) {
                        columnText.addElement(element);
                    } else if (element instanceof PdfPTable) {
                        columnText.addElement(new PdfPTable((PdfPTable) element));
                    } else {
                        columnText.addElement(element);
                    }
                    float f8 = this.yLine;
                    if (f8 > f5) {
                        columnText.setSimpleColumn(this.floatLeftX, f8, this.floatRightX, f5);
                    } else {
                        columnText.setSimpleColumn(this.floatLeftX, f8, this.floatRightX, this.minY);
                    }
                    columnText.setFilledWidth(0.0f);
                    i2 = columnText.go(z2);
                    if (this.yLine <= f5 || ((this.floatLeftX <= this.leftX && this.floatRightX >= this.rightX) || (i2 & 1) != 0)) {
                        if (f6 > 0.0f) {
                            f2 = f6 + columnText.getFilledWidth();
                        } else if (f7 > 0.0f) {
                            f = f7 + columnText.getFilledWidth();
                            f2 = f6;
                            float min = Math.min(columnText.getYLine() + columnText.getDescender(), f5);
                            this.yLine = columnText.getYLine() + columnText.getDescender();
                            f5 = min;
                        } else {
                            if (columnText.getFilledWidth() > this.filledWidth) {
                                this.filledWidth = columnText.getFilledWidth();
                            }
                            f2 = f6;
                        }
                        f = f7;
                        float min2 = Math.min(columnText.getYLine() + columnText.getDescender(), f5);
                        this.yLine = columnText.getYLine() + columnText.getDescender();
                        f5 = min2;
                    } else {
                        this.yLine = f5;
                        float f9 = this.leftX;
                        this.floatLeftX = f9;
                        float f10 = this.rightX;
                        this.floatRightX = f10;
                        if (f7 == 0.0f || f6 == 0.0f) {
                            if (f7 > this.filledWidth) {
                                this.filledWidth = f7;
                            }
                            if (f6 > this.filledWidth) {
                                this.filledWidth = f6;
                            }
                        } else {
                            this.filledWidth = f10 - f9;
                        }
                        if (z2 && (element instanceof PdfPTable)) {
                            columnText.addElement(new PdfPTable((PdfPTable) element));
                        }
                        columnText.setSimpleColumn(this.floatLeftX, this.yLine, this.floatRightX, this.minY);
                        i2 = columnText.go(z2);
                        float yLine2 = columnText.getYLine() + columnText.getDescender();
                        this.yLine = yLine2;
                        if (columnText.getFilledWidth() > this.filledWidth) {
                            this.filledWidth = columnText.getFilledWidth();
                        }
                        f5 = yLine2;
                        f2 = 0.0f;
                        f = 0.0f;
                    }
                    if ((i2 & 1) != 0) {
                        columnText.setText(null);
                    } else if (!z2) {
                        list2.addAll(0, columnText.getCompositeElements());
                        columnText.getCompositeElements().clear();
                    } else {
                        list2.add(0, element);
                        columnText.setText(null);
                    }
                }
            }
            boolean z4 = element instanceof Paragraph;
            if (z4) {
                Iterator it2 = ((Paragraph) element).iterator();
                while (it2.hasNext()) {
                    Element element3 = (Element) it2.next();
                    if (element3 instanceof WritableDirectElement) {
                        WritableDirectElement writableDirectElement = (WritableDirectElement) element3;
                        if (writableDirectElement.getDirectElementType() == 1 && !z2) {
                            PdfWriter pdfWriter = this.compositeColumn.getCanvas().getPdfWriter();
                            PdfDocument pdfDocument = this.compositeColumn.getCanvas().getPdfDocument();
                            float f11 = pdfDocument.currentHeight;
                            pdfDocument.currentHeight = (pdfDocument.top() - this.yLine) - pdfDocument.indentation.indentTop;
                            writableDirectElement.write(pdfWriter, pdfDocument);
                            pdfDocument.currentHeight = f11;
                        }
                    }
                }
            }
            if (z3 && element.getChunks().size() == 0) {
                if (z4) {
                    Element element4 = (Element) ((Paragraph) element).get(0);
                    if (element4 instanceof WritableDirectElement) {
                        if (((WritableDirectElement) element4).getDirectElementType() == 1) {
                        }
                    }
                    list2 = list;
                    i = 0;
                } else if (!(element instanceof Spaceable)) {
                    list2 = list;
                    i = 0;
                }
            }
            z3 = false;
            list2 = list;
            i = 0;
        }
        if (f7 == 0.0f || f6 == 0.0f) {
            if (f7 > this.filledWidth) {
                this.filledWidth = f7;
            }
            if (f6 > this.filledWidth) {
                this.filledWidth = f6;
            }
        } else {
            this.filledWidth = this.rightX - this.leftX;
        }
        this.yLine = f5;
        this.floatLeftX = this.leftX;
        this.floatRightX = this.rightX;
        return i2;
    }
}
