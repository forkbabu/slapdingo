package org.jsoup.parser;

import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.xmp.XmpBasicSchema;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;
import org.jsoup.select.Elements;
import org.spongycastle.i18n.ErrorBundle;

public class HtmlTreeBuilder extends TreeBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MaxScopeSearchDepth = 100;
    static final String[] TagSearchButton = {"button"};
    static final String[] TagSearchEndTags = {"dd", "dt", HtmlTags.LI, "optgroup", "option", HtmlTags.P, "rp", "rt"};
    static final String[] TagSearchList = {HtmlTags.OL, HtmlTags.UL};
    static final String[] TagSearchSelectScope = {"optgroup", "option"};
    static final String[] TagSearchSpecial = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", HtmlTags.BLOCKQUOTE, HtmlTags.BODY, HtmlTags.BR, "button", "caption", HtmlTags.ALIGN_CENTER, "col", "colgroup", "command", "dd", ErrorBundle.DETAIL_ENTRY, "dir", HtmlTags.DIV, "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", HtmlTags.H1, HtmlTags.H2, HtmlTags.H3, HtmlTags.H4, HtmlTags.H5, HtmlTags.H6, "head", "header", "hgroup", HtmlTags.HR, "html", "iframe", HtmlTags.IMG, "input", "isindex", HtmlTags.LI, "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", HtmlTags.OL, HtmlTags.P, "param", "plaintext", HtmlTags.PRE, "script", "section", "select", HtmlTags.STYLE, ErrorBundle.SUMMARY_ENTRY, HtmlTags.TABLE, "tbody", HtmlTags.TD, "textarea", "tfoot", HtmlTags.TH, "thead", "title", HtmlTags.TR, HtmlTags.UL, "wbr", XmpBasicSchema.DEFAULT_XPATH_ID};
    static final String[] TagSearchTableScope = {"html", HtmlTags.TABLE};
    static final String[] TagsSearchInScope = {"applet", "caption", "html", "marquee", "object", HtmlTags.TABLE, HtmlTags.TD, HtmlTags.TH};
    private boolean baseUriSetFromDoc;
    private Element contextElement;
    private Token.EndTag emptyEnd;
    private FormElement formElement;
    private ArrayList<Element> formattingElements;
    private boolean fosterInserts;
    private boolean fragmentParsing;
    private boolean framesetOk;
    private Element headElement;
    private HtmlTreeBuilderState originalState;
    private List<String> pendingTableCharacters;
    private String[] specificScopeTarget = {null};
    private HtmlTreeBuilderState state;

    @Override // org.jsoup.parser.TreeBuilder
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.parser.TreeBuilder
    public ParseSettings defaultSettings() {
        return ParseSettings.htmlDefault;
    }

    /* access modifiers changed from: protected */
    @Override // org.jsoup.parser.TreeBuilder
    public void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.state = HtmlTreeBuilderState.Initial;
        this.originalState = null;
        this.baseUriSetFromDoc = false;
        this.headElement = null;
        this.formElement = null;
        this.contextElement = null;
        this.formattingElements = new ArrayList<>();
        this.pendingTableCharacters = new ArrayList();
        this.emptyEnd = new Token.EndTag();
        this.framesetOk = true;
        this.fosterInserts = false;
        this.fragmentParsing = false;
    }

    /* access modifiers changed from: package-private */
    @Override // org.jsoup.parser.TreeBuilder
    public List<Node> parseFragment(String str, Element element, String str2, Parser parser) {
        Element element2;
        this.state = HtmlTreeBuilderState.Initial;
        initialiseParse(new StringReader(str), str2, parser);
        this.contextElement = element;
        this.fragmentParsing = true;
        if (element != null) {
            if (element.ownerDocument() != null) {
                this.doc.quirksMode(element.ownerDocument().quirksMode());
            }
            String normalName = element.normalName();
            if (StringUtil.in(normalName, "title", "textarea")) {
                this.tokeniser.transition(TokeniserState.Rcdata);
            } else if (StringUtil.in(normalName, "iframe", "noembed", "noframes", HtmlTags.STYLE, XmpBasicSchema.DEFAULT_XPATH_ID)) {
                this.tokeniser.transition(TokeniserState.Rawtext);
            } else if (normalName.equals("script")) {
                this.tokeniser.transition(TokeniserState.ScriptData);
            } else if (normalName.equals("noscript")) {
                this.tokeniser.transition(TokeniserState.Data);
            } else if (normalName.equals("plaintext")) {
                this.tokeniser.transition(TokeniserState.Data);
            } else {
                this.tokeniser.transition(TokeniserState.Data);
            }
            element2 = new Element(Tag.valueOf("html", this.settings), str2);
            this.doc.appendChild(element2);
            this.stack.add(element2);
            resetInsertionMode();
            Elements parents = element.parents();
            parents.add(0, element);
            Iterator it2 = parents.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Element element3 = (Element) it2.next();
                if (element3 instanceof FormElement) {
                    this.formElement = (FormElement) element3;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        runParser();
        if (element != null) {
            return element2.childNodes();
        }
        return this.doc.childNodes();
    }

    /* access modifiers changed from: protected */
    @Override // org.jsoup.parser.TreeBuilder
    public boolean process(Token token) {
        this.currentToken = token;
        return this.state.process(token, this);
    }

    /* access modifiers changed from: package-private */
    public boolean process(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.currentToken = token;
        return htmlTreeBuilderState.process(token, this);
    }

    /* access modifiers changed from: package-private */
    public void transition(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.state = htmlTreeBuilderState;
    }

    /* access modifiers changed from: package-private */
    public HtmlTreeBuilderState state() {
        return this.state;
    }

    /* access modifiers changed from: package-private */
    public void markInsertionMode() {
        this.originalState = this.state;
    }

    /* access modifiers changed from: package-private */
    public HtmlTreeBuilderState originalState() {
        return this.originalState;
    }

    /* access modifiers changed from: package-private */
    public void framesetOk(boolean z) {
        this.framesetOk = z;
    }

    /* access modifiers changed from: package-private */
    public boolean framesetOk() {
        return this.framesetOk;
    }

    /* access modifiers changed from: package-private */
    public Document getDocument() {
        return this.doc;
    }

    /* access modifiers changed from: package-private */
    public String getBaseUri() {
        return this.baseUri;
    }

    /* access modifiers changed from: package-private */
    public void maybeSetBaseUri(Element element) {
        if (!this.baseUriSetFromDoc) {
            String absUrl = element.absUrl(HtmlTags.HREF);
            if (absUrl.length() != 0) {
                this.baseUri = absUrl;
                this.baseUriSetFromDoc = true;
                this.doc.setBaseUri(absUrl);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isFragmentParsing() {
        return this.fragmentParsing;
    }

    /* access modifiers changed from: package-private */
    public void error(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.parser.getErrors().canAddError()) {
            this.parser.getErrors().add(new ParseError(this.reader.pos(), "Unexpected token [%s] when in state [%s]", this.currentToken.tokenType(), htmlTreeBuilderState));
        }
    }

    /* access modifiers changed from: package-private */
    public Element insert(Token.StartTag startTag) {
        if (startTag.attributes != null && !startTag.attributes.isEmpty() && startTag.attributes.deduplicate(this.settings) > 0) {
            error("Duplicate attribute");
        }
        if (startTag.isSelfClosing()) {
            Element insertEmpty = insertEmpty(startTag);
            this.stack.add(insertEmpty);
            this.tokeniser.transition(TokeniserState.Data);
            this.tokeniser.emit(this.emptyEnd.reset().name(insertEmpty.tagName()));
            return insertEmpty;
        }
        Element element = new Element(Tag.valueOf(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        insert(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    public Element insertStartTag(String str) {
        Element element = new Element(Tag.valueOf(str, this.settings), null);
        insert(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    public void insert(Element element) {
        insertNode(element);
        this.stack.add(element);
    }

    /* access modifiers changed from: package-private */
    public Element insertEmpty(Token.StartTag startTag) {
        Tag valueOf = Tag.valueOf(startTag.name(), this.settings);
        Element element = new Element(valueOf, null, this.settings.normalizeAttributes(startTag.attributes));
        insertNode(element);
        if (startTag.isSelfClosing()) {
            if (!valueOf.isKnownTag()) {
                valueOf.setSelfClosing();
            } else if (!valueOf.isEmpty()) {
                this.tokeniser.error("Tag cannot be self closing; not a void tag");
            }
        }
        return element;
    }

    /* access modifiers changed from: package-private */
    public FormElement insertForm(Token.StartTag startTag, boolean z) {
        FormElement formElement2 = new FormElement(Tag.valueOf(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        setFormElement(formElement2);
        insertNode(formElement2);
        if (z) {
            this.stack.add(formElement2);
        }
        return formElement2;
    }

    /* access modifiers changed from: package-private */
    public void insert(Token.Comment comment) {
        insertNode(new Comment(comment.getData()));
    }

    /* access modifiers changed from: package-private */
    public void insert(Token.Character character) {
        Node node;
        Element currentElement = currentElement();
        if (currentElement == null) {
            currentElement = this.doc;
        }
        String normalName = currentElement.normalName();
        String data = character.getData();
        if (character.isCData()) {
            node = new CDataNode(data);
        } else if (normalName.equals("script") || normalName.equals(HtmlTags.STYLE)) {
            node = new DataNode(data);
        } else {
            node = new TextNode(data);
        }
        currentElement.appendChild(node);
    }

    private void insertNode(Node node) {
        FormElement formElement2;
        if (this.stack.isEmpty()) {
            this.doc.appendChild(node);
        } else if (isFosterInserts()) {
            insertInFosterParent(node);
        } else {
            currentElement().appendChild(node);
        }
        if (node instanceof Element) {
            Element element = (Element) node;
            if (element.tag().isFormListed() && (formElement2 = this.formElement) != null) {
                formElement2.addElement(element);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Element pop() {
        return (Element) this.stack.remove(this.stack.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public void push(Element element) {
        this.stack.add(element);
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Element> getStack() {
        return this.stack;
    }

    /* access modifiers changed from: package-private */
    public boolean onStack(Element element) {
        return isElementInQueue(this.stack, element);
    }

    private boolean isElementInQueue(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Element getFromStack(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = (Element) this.stack.get(size);
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean removeFromStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (((Element) this.stack.get(size)) == element) {
                this.stack.remove(size);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Element popStackToClose(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = (Element) this.stack.get(size);
            this.stack.remove(size);
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void popStackToClose(String... strArr) {
        int size = this.stack.size() - 1;
        while (size >= 0) {
            this.stack.remove(size);
            if (!StringUtil.inSorted(((Element) this.stack.get(size)).normalName(), strArr)) {
                size--;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void popStackToBefore(String str) {
        int size = this.stack.size() - 1;
        while (size >= 0 && !((Element) this.stack.get(size)).normalName().equals(str)) {
            this.stack.remove(size);
            size--;
        }
    }

    /* access modifiers changed from: package-private */
    public void clearStackToTableContext() {
        clearStackToContext(HtmlTags.TABLE);
    }

    /* access modifiers changed from: package-private */
    public void clearStackToTableBodyContext() {
        clearStackToContext("tbody", "tfoot", "thead", "template");
    }

    /* access modifiers changed from: package-private */
    public void clearStackToTableRowContext() {
        clearStackToContext(HtmlTags.TR, "template");
    }

    private void clearStackToContext(String... strArr) {
        int size = this.stack.size() - 1;
        while (size >= 0) {
            Element element = (Element) this.stack.get(size);
            if (!StringUtil.in(element.normalName(), strArr) && !element.normalName().equals("html")) {
                this.stack.remove(size);
                size--;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Element aboveOnStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (((Element) this.stack.get(size)) == element) {
                return (Element) this.stack.get(size - 1);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void insertOnStackAfter(Element element, Element element2) {
        int lastIndexOf = this.stack.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        this.stack.add(lastIndexOf + 1, element2);
    }

    /* access modifiers changed from: package-private */
    public void replaceOnStack(Element element, Element element2) {
        replaceInQueue(this.stack, element, element2);
    }

    private void replaceInQueue(ArrayList<Element> arrayList, Element element, Element element2) {
        int lastIndexOf = arrayList.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        arrayList.set(lastIndexOf, element2);
    }

    /* access modifiers changed from: package-private */
    public void resetInsertionMode() {
        int size = this.stack.size() - 1;
        boolean z = false;
        while (size >= 0) {
            Element element = (Element) this.stack.get(size);
            if (size == 0) {
                element = this.contextElement;
                z = true;
            }
            String normalName = element.normalName();
            if ("select".equals(normalName)) {
                transition(HtmlTreeBuilderState.InSelect);
                return;
            } else if (HtmlTags.TD.equals(normalName) || (HtmlTags.TH.equals(normalName) && !z)) {
                transition(HtmlTreeBuilderState.InCell);
                return;
            } else if (HtmlTags.TR.equals(normalName)) {
                transition(HtmlTreeBuilderState.InRow);
                return;
            } else if ("tbody".equals(normalName) || "thead".equals(normalName) || "tfoot".equals(normalName)) {
                transition(HtmlTreeBuilderState.InTableBody);
                return;
            } else if ("caption".equals(normalName)) {
                transition(HtmlTreeBuilderState.InCaption);
                return;
            } else if ("colgroup".equals(normalName)) {
                transition(HtmlTreeBuilderState.InColumnGroup);
                return;
            } else if (HtmlTags.TABLE.equals(normalName)) {
                transition(HtmlTreeBuilderState.InTable);
                return;
            } else if ("head".equals(normalName)) {
                transition(HtmlTreeBuilderState.InBody);
                return;
            } else if (HtmlTags.BODY.equals(normalName)) {
                transition(HtmlTreeBuilderState.InBody);
                return;
            } else if ("frameset".equals(normalName)) {
                transition(HtmlTreeBuilderState.InFrameset);
                return;
            } else if ("html".equals(normalName)) {
                transition(HtmlTreeBuilderState.BeforeHead);
                return;
            } else if (z) {
                transition(HtmlTreeBuilderState.InBody);
                return;
            } else {
                size--;
            }
        }
    }

    private boolean inSpecificScope(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.specificScopeTarget;
        strArr3[0] = str;
        return inSpecificScope(strArr3, strArr, strArr2);
    }

    private boolean inSpecificScope(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.stack.size() - 1;
        int i = size > 100 ? size - 100 : 0;
        while (size >= i) {
            String normalName = ((Element) this.stack.get(size)).normalName();
            if (StringUtil.inSorted(normalName, strArr)) {
                return true;
            }
            if (StringUtil.inSorted(normalName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.inSorted(normalName, strArr3)) {
                return false;
            }
            size--;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean inScope(String[] strArr) {
        return inSpecificScope(strArr, TagsSearchInScope, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean inScope(String str) {
        return inScope(str, null);
    }

    /* access modifiers changed from: package-private */
    public boolean inScope(String str, String[] strArr) {
        return inSpecificScope(str, TagsSearchInScope, strArr);
    }

    /* access modifiers changed from: package-private */
    public boolean inListItemScope(String str) {
        return inScope(str, TagSearchList);
    }

    /* access modifiers changed from: package-private */
    public boolean inButtonScope(String str) {
        return inScope(str, TagSearchButton);
    }

    /* access modifiers changed from: package-private */
    public boolean inTableScope(String str) {
        return inSpecificScope(str, TagSearchTableScope, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean inSelectScope(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String normalName = ((Element) this.stack.get(size)).normalName();
            if (normalName.equals(str)) {
                return true;
            }
            if (!StringUtil.inSorted(normalName, TagSearchSelectScope)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setHeadElement(Element element) {
        this.headElement = element;
    }

    /* access modifiers changed from: package-private */
    public Element getHeadElement() {
        return this.headElement;
    }

    /* access modifiers changed from: package-private */
    public boolean isFosterInserts() {
        return this.fosterInserts;
    }

    /* access modifiers changed from: package-private */
    public void setFosterInserts(boolean z) {
        this.fosterInserts = z;
    }

    /* access modifiers changed from: package-private */
    public FormElement getFormElement() {
        return this.formElement;
    }

    /* access modifiers changed from: package-private */
    public void setFormElement(FormElement formElement2) {
        this.formElement = formElement2;
    }

    /* access modifiers changed from: package-private */
    public void newPendingTableCharacters() {
        this.pendingTableCharacters = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public List<String> getPendingTableCharacters() {
        return this.pendingTableCharacters;
    }

    /* access modifiers changed from: package-private */
    public void generateImpliedEndTags(String str) {
        while (str != null && !currentElement().normalName().equals(str) && StringUtil.inSorted(currentElement().normalName(), TagSearchEndTags)) {
            pop();
        }
    }

    /* access modifiers changed from: package-private */
    public void generateImpliedEndTags() {
        generateImpliedEndTags(null);
    }

    /* access modifiers changed from: package-private */
    public boolean isSpecial(Element element) {
        return StringUtil.inSorted(element.normalName(), TagSearchSpecial);
    }

    /* access modifiers changed from: package-private */
    public Element lastFormattingElement() {
        if (this.formattingElements.size() <= 0) {
            return null;
        }
        ArrayList<Element> arrayList = this.formattingElements;
        return arrayList.get(arrayList.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public Element removeLastFormattingElement() {
        int size = this.formattingElements.size();
        if (size > 0) {
            return this.formattingElements.remove(size - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void pushActiveFormattingElements(Element element) {
        int size = this.formattingElements.size() - 1;
        int i = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.formattingElements.get(size);
                if (element2 == null) {
                    break;
                }
                if (isSameFormattingElement(element, element2)) {
                    i++;
                }
                if (i == 3) {
                    this.formattingElements.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.formattingElements.add(element);
    }

    private boolean isSameFormattingElement(Element element, Element element2) {
        return element.normalName().equals(element2.normalName()) && element.attributes().equals(element2.attributes());
    }

    /* access modifiers changed from: package-private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:63)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:32)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    public void reconstructFormattingElements() {
        /*
            r7 = this;
            org.jsoup.nodes.Element r0 = r7.lastFormattingElement()
            if (r0 == 0) goto L_0x0056
            boolean r1 = r7.onStack(r0)
            if (r1 == 0) goto L_0x000d
            goto L_0x0056
        L_0x000d:
            java.util.ArrayList<org.jsoup.nodes.Element> r1 = r7.formattingElements
            int r1 = r1.size()
            r2 = 1
            int r1 = r1 - r2
            r3 = r1
        L_0x0016:
            r4 = 0
            if (r3 != 0) goto L_0x001a
            goto L_0x002d
        L_0x001a:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.formattingElements
            int r3 = r3 + -1
            java.lang.Object r0 = r0.get(r3)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            if (r0 == 0) goto L_0x002c
            boolean r5 = r7.onStack(r0)
            if (r5 == 0) goto L_0x0016
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 != 0) goto L_0x0039
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.formattingElements
            int r3 = r3 + 1
            java.lang.Object r0 = r0.get(r3)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
        L_0x0039:
            org.jsoup.helper.Validate.notNull(r0)
            java.lang.String r2 = r0.normalName()
            org.jsoup.nodes.Element r2 = r7.insertStartTag(r2)
            org.jsoup.nodes.Attributes r5 = r2.attributes()
            org.jsoup.nodes.Attributes r6 = r0.attributes()
            r5.addAll(r6)
            java.util.ArrayList<org.jsoup.nodes.Element> r5 = r7.formattingElements
            r5.set(r3, r2)
            if (r3 != r1) goto L_0x002c
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.reconstructFormattingElements():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0008  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clearFormattingElementsToLastMarker() {
        /*
            r1 = this;
        L_0x0000:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r1.formattingElements
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x000e
            org.jsoup.nodes.Element r0 = r1.removeLastFormattingElement()
            if (r0 != 0) goto L_0x0000
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.clearFormattingElementsToLastMarker():void");
    }

    /* access modifiers changed from: package-private */
    public void removeFromActiveFormattingElements(Element element) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            if (this.formattingElements.get(size) == element) {
                this.formattingElements.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isInActiveFormattingElements(Element element) {
        return isElementInQueue(this.formattingElements, element);
    }

    /* access modifiers changed from: package-private */
    public Element getActiveFormattingElement(String str) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            Element element = this.formattingElements.get(size);
            if (element == null) {
                return null;
            }
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void replaceActiveFormattingElement(Element element, Element element2) {
        replaceInQueue(this.formattingElements, element, element2);
    }

    /* access modifiers changed from: package-private */
    public void insertMarkerToFormattingElements() {
        this.formattingElements.add(null);
    }

    /* access modifiers changed from: package-private */
    public void insertInFosterParent(Node node) {
        Element element;
        Element fromStack = getFromStack(HtmlTags.TABLE);
        boolean z = false;
        if (fromStack == null) {
            element = (Element) this.stack.get(0);
        } else if (fromStack.parent() != null) {
            element = fromStack.parent();
            z = true;
        } else {
            element = aboveOnStack(fromStack);
        }
        if (z) {
            Validate.notNull(fromStack);
            fromStack.before(node);
            return;
        }
        element.appendChild(node);
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
    }
}
