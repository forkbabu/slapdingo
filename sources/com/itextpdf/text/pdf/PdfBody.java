package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Rectangle;
import java.util.List;

public class PdfBody extends Rectangle implements Element {
    @Override // com.itextpdf.text.Element, com.itextpdf.text.Rectangle
    public List<Chunk> getChunks() {
        return null;
    }

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Rectangle
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Rectangle
    public boolean isNestable() {
        return false;
    }

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Rectangle
    public boolean process(ElementListener elementListener) {
        return false;
    }

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Rectangle
    public int type() {
        return 38;
    }

    public PdfBody(Rectangle rectangle) {
        super(rectangle);
    }
}
