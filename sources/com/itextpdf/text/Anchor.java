package com.itextpdf.text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Anchor extends Phrase {
    private static final long serialVersionUID = -852278536049236911L;
    protected String name = null;
    protected String reference = null;

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Phrase
    public int type() {
        return 17;
    }

    public Anchor() {
        super(16.0f);
    }

    public Anchor(float f) {
        super(f);
    }

    public Anchor(Chunk chunk) {
        super(chunk);
    }

    public Anchor(String str) {
        super(str);
    }

    public Anchor(String str, Font font) {
        super(str, font);
    }

    public Anchor(float f, Chunk chunk) {
        super(f, chunk);
    }

    public Anchor(float f, String str) {
        super(f, str);
    }

    public Anchor(float f, String str, Font font) {
        super(f, str, font);
    }

    public Anchor(Phrase phrase) {
        super(phrase);
        if (phrase instanceof Anchor) {
            Anchor anchor = (Anchor) phrase;
            setName(anchor.name);
            setReference(anchor.reference);
        }
    }

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Phrase
    public boolean process(ElementListener elementListener) {
        try {
            boolean z = this.reference != null && this.reference.startsWith("#");
            boolean z2 = true;
            for (Chunk chunk : getChunks()) {
                if (this.name != null && z2 && !chunk.isEmpty()) {
                    chunk.setLocalDestination(this.name);
                    z2 = false;
                }
                if (z) {
                    chunk.setLocalGoto(this.reference.substring(1));
                }
                elementListener.add(chunk);
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Phrase
    public List<Chunk> getChunks() {
        String str = this.reference;
        boolean z = true;
        boolean z2 = str != null && str.startsWith("#");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element instanceof Chunk) {
                Chunk chunk = (Chunk) element;
                z = applyAnchor(chunk, z, z2);
                arrayList.add(chunk);
            } else {
                for (Chunk chunk2 : element.getChunks()) {
                    z = applyAnchor(chunk2, z, z2);
                    arrayList.add(chunk2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public boolean applyAnchor(Chunk chunk, boolean z, boolean z2) {
        if (this.name != null && z && !chunk.isEmpty()) {
            chunk.setLocalDestination(this.name);
            z = false;
        }
        if (z2) {
            chunk.setLocalGoto(this.reference.substring(1));
        } else {
            String str = this.reference;
            if (str != null) {
                chunk.setAnchor(str);
            }
        }
        return z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public String getName() {
        return this.name;
    }

    public String getReference() {
        return this.reference;
    }

    public URL getUrl() {
        try {
            return new URL(this.reference);
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
