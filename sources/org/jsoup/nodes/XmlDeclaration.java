package org.jsoup.nodes;

import java.io.IOException;
import java.util.Iterator;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

public class XmlDeclaration extends LeafNode {
    private final boolean isProcessingInstruction;

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#declaration";
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.LeafNode
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.LeafNode
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.LeafNode
    public /* bridge */ /* synthetic */ Node attr(String str, String str2) {
        return super.attr(str, str2);
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.LeafNode
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.LeafNode
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.LeafNode
    public /* bridge */ /* synthetic */ Node empty() {
        return super.empty();
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.LeafNode
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.LeafNode
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public XmlDeclaration(String str, boolean z) {
        Validate.notNull(str);
        this.value = str;
        this.isProcessingInstruction = z;
    }

    public String name() {
        return coreValue();
    }

    public String getWholeDeclaration() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            getWholeDeclaration(borrowBuilder, new Document.OutputSettings());
            return StringUtil.releaseBuilder(borrowBuilder).trim();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    private void getWholeDeclaration(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        Iterator<Attribute> it2 = attributes().iterator();
        while (it2.hasNext()) {
            Attribute next = it2.next();
            if (!next.getKey().equals(nodeName())) {
                appendable.append(' ');
                next.html(appendable, outputSettings);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        String str = "!";
        appendable.append("<").append(this.isProcessingInstruction ? str : "?").append(coreValue());
        getWholeDeclaration(appendable, outputSettings);
        if (!this.isProcessingInstruction) {
            str = "?";
        }
        appendable.append(str).append(">");
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.Node, java.lang.Object
    public XmlDeclaration clone() {
        return (XmlDeclaration) super.clone();
    }
}
