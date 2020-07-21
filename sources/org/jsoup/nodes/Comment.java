package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class Comment extends LeafNode {
    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#comment";
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

    public Comment(String str) {
        this.value = str;
    }

    public String getData() {
        return coreValue();
    }

    public Comment setData(String str) {
        coreValue(str);
        return this;
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint() && ((siblingIndex() == 0 && (this.parentNode instanceof Element) && ((Element) this.parentNode).tag().formatAsBlock()) || outputSettings.outline())) {
            indent(appendable, i, outputSettings);
        }
        appendable.append("<!--").append(getData()).append("-->");
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.Node, java.lang.Object
    public Comment clone() {
        return (Comment) super.clone();
    }

    public boolean isXmlDeclaration() {
        String data = getData();
        return data.length() > 1 && (data.startsWith("!") || data.startsWith("?"));
    }

    public XmlDeclaration asXmlDeclaration() {
        String data = getData();
        Document parse = Jsoup.parse("<" + data.substring(1, data.length() - 1) + ">", baseUri(), Parser.xmlParser());
        if (parse.children().size() <= 0) {
            return null;
        }
        Element child = parse.child(0);
        XmlDeclaration xmlDeclaration = new XmlDeclaration(NodeUtils.parser(parse).settings().normalizeTag(child.tagName()), data.startsWith("!"));
        xmlDeclaration.attributes().addAll(child.attributes());
        return xmlDeclaration;
    }
}
