package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfName;
import java.util.List;

public class ListItem extends Paragraph {
    private static final long serialVersionUID = 1970670787169329006L;
    private ListBody listBody = null;
    private ListLabel listLabel = null;
    protected Chunk symbol;

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Paragraph, com.itextpdf.text.Phrase
    public int type() {
        return 15;
    }

    public ListItem() {
        setRole(PdfName.LI);
    }

    public ListItem(float f) {
        super(f);
        setRole(PdfName.LI);
    }

    public ListItem(Chunk chunk) {
        super(chunk);
        setRole(PdfName.LI);
    }

    public ListItem(String str) {
        super(str);
        setRole(PdfName.LI);
    }

    public ListItem(String str, Font font) {
        super(str, font);
        setRole(PdfName.LI);
    }

    public ListItem(float f, Chunk chunk) {
        super(f, chunk);
        setRole(PdfName.LI);
    }

    public ListItem(float f, String str) {
        super(f, str);
        setRole(PdfName.LI);
    }

    public ListItem(float f, String str, Font font) {
        super(f, str, font);
        setRole(PdfName.LI);
    }

    public ListItem(Phrase phrase) {
        super(phrase);
        setRole(PdfName.LI);
    }

    @Override // com.itextpdf.text.Paragraph
    public Paragraph cloneShallow(boolean z) {
        ListItem listItem = new ListItem();
        populateProperties(listItem, z);
        return listItem;
    }

    public void setListSymbol(Chunk chunk) {
        if (this.symbol == null) {
            this.symbol = chunk;
            if (chunk.getFont().isStandardFont()) {
                this.symbol.setFont(this.font);
            }
        }
    }

    public void setIndentationLeft(float f, boolean z) {
        if (z) {
            setIndentationLeft(getListSymbol().getWidthPoint());
        } else {
            setIndentationLeft(f);
        }
    }

    public void adjustListSymbolFont() {
        Chunk chunk;
        List<Chunk> chunks = getChunks();
        if (!chunks.isEmpty() && (chunk = this.symbol) != null) {
            chunk.setFont(chunks.get(0).getFont());
        }
    }

    public Chunk getListSymbol() {
        return this.symbol;
    }

    public ListBody getListBody() {
        if (this.listBody == null) {
            this.listBody = new ListBody(this);
        }
        return this.listBody;
    }

    public ListLabel getListLabel() {
        if (this.listLabel == null) {
            this.listLabel = new ListLabel(this);
        }
        return this.listLabel;
    }
}
