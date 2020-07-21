package com.itextpdf.text;

import org.spongycastle.crypto.tls.CipherSuite;

public class ZapfDingbatsNumberList extends List {
    protected int type;

    public ZapfDingbatsNumberList(int i) {
        super(true);
        this.type = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = " ";
    }

    public ZapfDingbatsNumberList(int i, int i2) {
        super(true, (float) i2);
        this.type = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = " ";
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    @Override // com.itextpdf.text.TextElementArray, com.itextpdf.text.List
    public boolean add(Element element) {
        if (element instanceof ListItem) {
            ListItem listItem = (ListItem) element;
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.setAttributes(this.symbol.getAttributes());
            int i = this.type;
            if (i == 0) {
                chunk.append(String.valueOf((char) (this.first + this.list.size() + CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384)));
            } else if (i == 1) {
                chunk.append(String.valueOf((char) (this.first + this.list.size() + CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384)));
            } else if (i != 2) {
                chunk.append(String.valueOf((char) (this.first + this.list.size() + 201)));
            } else {
                chunk.append(String.valueOf((char) (this.first + this.list.size() + CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256)));
            }
            chunk.append(this.postSymbol);
            listItem.setListSymbol(chunk);
            listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
            listItem.setIndentationRight(0.0f);
            this.list.add(listItem);
            return false;
        } else if (!(element instanceof List)) {
            return false;
        } else {
            List list = (List) element;
            list.setIndentationLeft(list.getIndentationLeft() + this.symbolIndent);
            this.first--;
            return this.list.add(list);
        }
    }

    @Override // com.itextpdf.text.List
    public List cloneShallow() {
        ZapfDingbatsNumberList zapfDingbatsNumberList = new ZapfDingbatsNumberList(this.type);
        populateProperties(zapfDingbatsNumberList);
        return zapfDingbatsNumberList;
    }
}
