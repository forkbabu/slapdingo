package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;

public class CDataNode extends TextNode {
    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.TextNode
    public String nodeName() {
        return "#cdata";
    }

    public CDataNode(String str) {
        super(str);
    }

    @Override // org.jsoup.nodes.TextNode
    public String text() {
        return getWholeText();
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.TextNode
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append("<![CDATA[").append(getWholeText());
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.TextNode
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
        try {
            appendable.append("]]>");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.Node, org.jsoup.nodes.TextNode, org.jsoup.nodes.TextNode, org.jsoup.nodes.TextNode, java.lang.Object
    public CDataNode clone() {
        return (CDataNode) super.clone();
    }
}
