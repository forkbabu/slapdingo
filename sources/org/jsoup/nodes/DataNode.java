package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document;

public class DataNode extends LeafNode {
    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#data";
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

    public DataNode(String str) {
        this.value = str;
    }

    public String getWholeData() {
        return coreValue();
    }

    public DataNode setWholeData(String str) {
        coreValue(str);
        return this;
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(getWholeData());
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.Node, java.lang.Object
    public DataNode clone() {
        return (DataNode) super.clone();
    }

    public static DataNode createFromEncoded(String str, String str2) {
        return new DataNode(Entities.unescape(str));
    }
}
