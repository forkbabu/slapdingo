package com.itextpdf.text;

import com.itextpdf.text.api.WriterOperation;
import java.util.ArrayList;
import java.util.List;

public abstract class WritableDirectElement implements Element, WriterOperation {
    public static final int DIRECT_ELEMENT_TYPE_HEADER = 1;
    public static final int DIRECT_ELEMENT_TYPE_UNKNOWN = 0;
    protected int directElementType = 0;

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return Element.WRITABLE_DIRECT;
    }

    public WritableDirectElement() {
    }

    public WritableDirectElement(int i) {
        this.directElementType = i;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        throw new UnsupportedOperationException();
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        throw new UnsupportedOperationException();
    }

    @Override // com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        return new ArrayList(0);
    }

    public int getDirectElementType() {
        return this.directElementType;
    }
}
