package org.jsoup.nodes;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;

public class PseudoTextElement extends Element {
    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.Element
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node, org.jsoup.nodes.Element
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    public PseudoTextElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
    }
}
