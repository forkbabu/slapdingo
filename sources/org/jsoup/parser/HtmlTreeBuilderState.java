package org.jsoup.parser;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.xmp.XmpBasicSchema;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.Typography;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;
import org.spongycastle.i18n.ErrorBundle;

enum HtmlTreeBuilderState {
    Initial {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                Token.Doctype asDoctype = token.asDoctype();
                DocumentType documentType = new DocumentType(htmlTreeBuilder.settings.normalizeTag(asDoctype.getName()), asDoctype.getPublicIdentifier(), asDoctype.getSystemIdentifier());
                documentType.setPubSysKey(asDoctype.getPubSysKey());
                htmlTreeBuilder.getDocument().appendChild(documentType);
                if (asDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(BeforeHtml);
            } else {
                htmlTreeBuilder.transition(BeforeHtml);
                return htmlTreeBuilder.process(token);
            }
            return true;
        }
    },
    BeforeHtml {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                htmlTreeBuilder.insert(token.asStartTag());
                htmlTreeBuilder.transition(BeforeHead);
                return true;
            } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (!token.isEndTag()) {
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(BeforeHead);
            return htmlTreeBuilder.process(token);
        }
    },
    BeforeHead {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return InBody.process(token, htmlTreeBuilder);
            } else {
                if (token.isStartTag() && token.asStartTag().normalName().equals("head")) {
                    htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                    htmlTreeBuilder.transition(InHead);
                    return true;
                } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                } else if (token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    InHead {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("html")) {
                    return InBody.process(token, htmlTreeBuilder);
                }
                if (StringUtil.inSorted(normalName, Constants.InHeadEmpty)) {
                    Element insertEmpty = htmlTreeBuilder.insertEmpty(asStartTag);
                    if (normalName.equals("base") && insertEmpty.hasAttr(HtmlTags.HREF)) {
                        htmlTreeBuilder.maybeSetBaseUri(insertEmpty);
                    }
                } else if (normalName.equals("meta")) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (normalName.equals("title")) {
                    HtmlTreeBuilderState.handleRcData(asStartTag, htmlTreeBuilder);
                } else if (StringUtil.inSorted(normalName, Constants.InHeadRaw)) {
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                } else if (normalName.equals("noscript")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InHeadNoscript);
                } else if (normalName.equals("script")) {
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                    htmlTreeBuilder.markInsertionMode();
                    htmlTreeBuilder.transition(Text);
                    htmlTreeBuilder.insert(asStartTag);
                } else if (!normalName.equals("head")) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (i != 4) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals("head")) {
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(AfterHead);
                } else if (StringUtil.inSorted(normalName2, Constants.InHeadEnd)) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag("head");
            return treeBuilder.process(token);
        }
    },
    InHeadNoscript {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().normalName().equals("noscript")) {
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InHead);
                    return true;
                } else if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoScriptHead))) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (token.isEndTag() && token.asEndTag().normalName().equals(HtmlTags.BR)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if ((!token.isStartTag() || !StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoscriptIgnore)) && !token.isEndTag()) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }
    },
    AfterHead {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("html")) {
                    return htmlTreeBuilder.process(token, InBody);
                }
                if (normalName.equals(HtmlTags.BODY)) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InBody);
                    return true;
                } else if (normalName.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InFrameset);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InBodyStartToHead)) {
                    htmlTreeBuilder.error(this);
                    Element headElement = htmlTreeBuilder.getHeadElement();
                    htmlTreeBuilder.push(headElement);
                    htmlTreeBuilder.process(token, InHead);
                    htmlTreeBuilder.removeFromStack(headElement);
                    return true;
                } else if (normalName.equals("head")) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
            } else if (!token.isEndTag()) {
                anythingElse(token, htmlTreeBuilder);
                return true;
            } else if (StringUtil.inSorted(token.asEndTag().normalName(), Constants.AfterHeadBody)) {
                anythingElse(token, htmlTreeBuilder);
                return true;
            } else {
                htmlTreeBuilder.error(this);
                return false;
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag(HtmlTags.BODY);
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }
    },
    InBody {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (i == 3) {
                return inBodyStartTag(token, htmlTreeBuilder);
            } else {
                if (i == 4) {
                    return inBodyEndTag(token, htmlTreeBuilder);
                }
                if (i == 5) {
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else if (!htmlTreeBuilder.framesetOk() || !HtmlTreeBuilderState.isWhitespace(asCharacter)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asCharacter);
                        htmlTreeBuilder.framesetOk(false);
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asCharacter);
                    }
                }
            }
            return true;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private boolean inBodyStartTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            char c;
            Token.StartTag asStartTag = token.asStartTag();
            String normalName = asStartTag.normalName();
            int hashCode = normalName.hashCode();
            switch (hashCode) {
                case -1644953643:
                    if (normalName.equals("frameset")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1377687758:
                    if (normalName.equals("button")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1191214428:
                    if (normalName.equals("iframe")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -1010136971:
                    if (normalName.equals("option")) {
                        c = '!';
                        break;
                    }
                    c = 65535;
                    break;
                case -1003243718:
                    if (normalName.equals("textarea")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -906021636:
                    if (normalName.equals("select")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case -80773204:
                    if (normalName.equals("optgroup")) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                case 97:
                    if (normalName.equals(HtmlTags.A)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3200:
                    if (normalName.equals("dd")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 3216:
                    if (normalName.equals("dt")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case 3338:
                    if (normalName.equals(HtmlTags.HR)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 3453:
                    if (normalName.equals(HtmlTags.LI)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3646:
                    if (normalName.equals("rp")) {
                        c = Typography.quote;
                        break;
                    }
                    c = 65535;
                    break;
                case 3650:
                    if (normalName.equals("rt")) {
                        c = '#';
                        break;
                    }
                    c = 65535;
                    break;
                case 111267:
                    if (normalName.equals(HtmlTags.PRE)) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 114276:
                    if (normalName.equals("svg")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 118811:
                    if (normalName.equals(XmpBasicSchema.DEFAULT_XPATH_ID)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 3029410:
                    if (normalName.equals(HtmlTags.BODY)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3148996:
                    if (normalName.equals("form")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3213227:
                    if (normalName.equals("html")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3344136:
                    if (normalName.equals("math")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 3386833:
                    if (normalName.equals("nobr")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 3536714:
                    if (normalName.equals(HtmlTags.SPAN)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 100313435:
                    if (normalName.equals("image")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 100358090:
                    if (normalName.equals("input")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 110115790:
                    if (normalName.equals(HtmlTags.TABLE)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 181975684:
                    if (normalName.equals("listing")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1973234167:
                    if (normalName.equals("plaintext")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 2091304424:
                    if (normalName.equals("isindex")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 2115613112:
                    if (normalName.equals("noembed")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 3273:
                            if (normalName.equals(HtmlTags.H1)) {
                                c = 22;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3274:
                            if (normalName.equals(HtmlTags.H2)) {
                                c = 23;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3275:
                            if (normalName.equals(HtmlTags.H3)) {
                                c = 24;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3276:
                            if (normalName.equals(HtmlTags.H4)) {
                                c = 25;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3277:
                            if (normalName.equals(HtmlTags.H5)) {
                                c = 26;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3278:
                            if (normalName.equals(HtmlTags.H6)) {
                                c = 27;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
            }
            switch (c) {
                case 0:
                    if (htmlTreeBuilder.getActiveFormattingElement(HtmlTags.A) != null) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag(HtmlTags.A);
                        Element fromStack = htmlTreeBuilder.getFromStack(HtmlTags.A);
                        if (fromStack != null) {
                            htmlTreeBuilder.removeFromActiveFormattingElements(fromStack);
                            htmlTreeBuilder.removeFromStack(fromStack);
                        }
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                    return true;
                case 1:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                case 2:
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack = htmlTreeBuilder.getStack();
                    int size = stack.size() - 1;
                    while (true) {
                        if (size > 0) {
                            Element element = stack.get(size);
                            if (element.normalName().equals(HtmlTags.LI)) {
                                htmlTreeBuilder.processEndTag(HtmlTags.LI);
                            } else if (!htmlTreeBuilder.isSpecial(element) || StringUtil.inSorted(element.normalName(), Constants.InBodyStartLiBreakers)) {
                                size--;
                            }
                        }
                    }
                    if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                case 3:
                    htmlTreeBuilder.error(this);
                    Element element2 = htmlTreeBuilder.getStack().get(0);
                    Iterator<Attribute> it2 = asStartTag.getAttributes().iterator();
                    while (it2.hasNext()) {
                        Attribute next = it2.next();
                        if (!element2.hasAttr(next.getKey())) {
                            element2.attributes().put(next);
                        }
                    }
                    return true;
                case 4:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack2 = htmlTreeBuilder.getStack();
                    if (stack2.size() == 1) {
                        return false;
                    }
                    if (stack2.size() > 2 && !stack2.get(1).normalName().equals(HtmlTags.BODY)) {
                        return false;
                    }
                    htmlTreeBuilder.framesetOk(false);
                    Element element3 = stack2.get(1);
                    Iterator<Attribute> it3 = asStartTag.getAttributes().iterator();
                    while (it3.hasNext()) {
                        Attribute next2 = it3.next();
                        if (!element3.hasAttr(next2.getKey())) {
                            element3.attributes().put(next2);
                        }
                    }
                    return true;
                case 5:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack3 = htmlTreeBuilder.getStack();
                    if (stack3.size() == 1) {
                        return false;
                    }
                    if ((stack3.size() > 2 && !stack3.get(1).normalName().equals(HtmlTags.BODY)) || !htmlTreeBuilder.framesetOk()) {
                        return false;
                    }
                    Element element4 = stack3.get(1);
                    if (element4.parent() != null) {
                        element4.remove();
                    }
                    for (int i = 1; stack3.size() > i; i = 1) {
                        stack3.remove(stack3.size() - i);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InFrameset);
                    return true;
                case 6:
                    if (htmlTreeBuilder.getFormElement() != null) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    htmlTreeBuilder.insertForm(asStartTag, true);
                    return true;
                case 7:
                    if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                    return true;
                case '\b':
                    if (htmlTreeBuilder.inButtonScope("button")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("button");
                        htmlTreeBuilder.process(asStartTag);
                        return true;
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case '\t':
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (htmlTreeBuilder.inScope("nobr")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("nobr");
                        htmlTreeBuilder.reconstructFormattingElements();
                    }
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                    return true;
                case '\n':
                    if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InTable);
                    return true;
                case 11:
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (htmlTreeBuilder.insertEmpty(asStartTag).attr("type").equalsIgnoreCase("hidden")) {
                        return true;
                    }
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case '\f':
                    if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    htmlTreeBuilder.insertEmpty(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case '\r':
                    if (htmlTreeBuilder.getFromStack("svg") == null) {
                        return htmlTreeBuilder.process(asStartTag.name(HtmlTags.IMG));
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                case 14:
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.getFormElement() != null) {
                        return false;
                    }
                    htmlTreeBuilder.processStartTag("form");
                    if (asStartTag.attributes.hasKey("action")) {
                        htmlTreeBuilder.getFormElement().attr("action", asStartTag.attributes.get("action"));
                    }
                    htmlTreeBuilder.processStartTag(HtmlTags.HR);
                    htmlTreeBuilder.processStartTag("label");
                    htmlTreeBuilder.process(new Token.Character().data(asStartTag.attributes.hasKey("prompt") ? asStartTag.attributes.get("prompt") : "This is a searchable index. Enter search keywords: "));
                    Attributes attributes = new Attributes();
                    Iterator<Attribute> it4 = asStartTag.attributes.iterator();
                    while (it4.hasNext()) {
                        Attribute next3 = it4.next();
                        if (!StringUtil.inSorted(next3.getKey(), Constants.InBodyStartInputAttribs)) {
                            attributes.put(next3);
                        }
                    }
                    attributes.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "isindex");
                    htmlTreeBuilder.processStartTag("input", attributes);
                    htmlTreeBuilder.processEndTag("label");
                    htmlTreeBuilder.processStartTag(HtmlTags.HR);
                    htmlTreeBuilder.processEndTag("form");
                    return true;
                case 15:
                    htmlTreeBuilder.insert(asStartTag);
                    if (asStartTag.isSelfClosing()) {
                        return true;
                    }
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
                    htmlTreeBuilder.markInsertionMode();
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(Text);
                    return true;
                case 16:
                    if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    return true;
                case 17:
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    return true;
                case 18:
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    return true;
                case 19:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState state = htmlTreeBuilder.state();
                    if (state.equals(InTable) || state.equals(InCaption) || state.equals(InTableBody) || state.equals(InRow) || state.equals(InCell)) {
                        htmlTreeBuilder.transition(InSelectInTable);
                        return true;
                    }
                    htmlTreeBuilder.transition(InSelect);
                    return true;
                case 20:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                case 21:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.pop();
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                case 28:
                case 29:
                    if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.reader.matchConsume("\n");
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case 30:
                case 31:
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack4 = htmlTreeBuilder.getStack();
                    int size2 = stack4.size() - 1;
                    while (true) {
                        if (size2 > 0) {
                            Element element5 = stack4.get(size2);
                            if (StringUtil.inSorted(element5.normalName(), Constants.DdDt)) {
                                htmlTreeBuilder.processEndTag(element5.normalName());
                            } else if (!htmlTreeBuilder.isSpecial(element5) || StringUtil.inSorted(element5.normalName(), Constants.InBodyStartLiBreakers)) {
                                size2--;
                            }
                        }
                    }
                    if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                        htmlTreeBuilder.processEndTag(HtmlTags.P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                case ' ':
                case '!':
                    if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                        htmlTreeBuilder.processEndTag("option");
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                case '\"':
                case '#':
                    if (!htmlTreeBuilder.inScope("ruby")) {
                        return true;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().normalName().equals("ruby")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.popStackToBefore("ruby");
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                default:
                    if (StringUtil.inSorted(normalName, Constants.InBodyStartEmptyFormatters)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        htmlTreeBuilder.framesetOk(false);
                        return true;
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartPClosers)) {
                        if (htmlTreeBuilder.inButtonScope(HtmlTags.P)) {
                            htmlTreeBuilder.processEndTag(HtmlTags.P);
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        return true;
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartToHead)) {
                        return htmlTreeBuilder.process(token, InHead);
                    } else {
                        if (StringUtil.inSorted(normalName, Constants.Formatters)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                            return true;
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartApplets)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.insertMarkerToFormattingElements();
                            htmlTreeBuilder.framesetOk(false);
                            return true;
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartMedia)) {
                            htmlTreeBuilder.insertEmpty(asStartTag);
                            return true;
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartDrop)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        } else {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            return true;
                        }
                    }
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private boolean inBodyEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            char c;
            Token.EndTag asEndTag = token.asEndTag();
            String normalName = asEndTag.normalName();
            int hashCode = normalName.hashCode();
            switch (hashCode) {
                case 112:
                    if (normalName.equals(HtmlTags.P)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3152:
                    if (normalName.equals(HtmlTags.BR)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 3200:
                    if (normalName.equals("dd")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 3216:
                    if (normalName.equals("dt")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 3453:
                    if (normalName.equals(HtmlTags.LI)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3029410:
                    if (normalName.equals(HtmlTags.BODY)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3148996:
                    if (normalName.equals("form")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3213227:
                    if (normalName.equals("html")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3536714:
                    if (normalName.equals(HtmlTags.SPAN)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1869063452:
                    if (normalName.equals("sarcasm")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 3273:
                            if (normalName.equals(HtmlTags.H1)) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3274:
                            if (normalName.equals(HtmlTags.H2)) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3275:
                            if (normalName.equals(HtmlTags.H3)) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3276:
                            if (normalName.equals(HtmlTags.H4)) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3277:
                            if (normalName.equals(HtmlTags.H5)) {
                                c = '\r';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3278:
                            if (normalName.equals(HtmlTags.H6)) {
                                c = 14;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
            }
            switch (c) {
                case 0:
                case 1:
                    return anyOtherEndTag(token, htmlTreeBuilder);
                case 2:
                    if (htmlTreeBuilder.inListItemScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags(normalName);
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(normalName);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 3:
                    if (htmlTreeBuilder.inScope(HtmlTags.BODY)) {
                        htmlTreeBuilder.transition(AfterBody);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 4:
                    if (htmlTreeBuilder.processEndTag(HtmlTags.BODY)) {
                        return htmlTreeBuilder.process(asEndTag);
                    }
                    break;
                case 5:
                    FormElement formElement = htmlTreeBuilder.getFormElement();
                    htmlTreeBuilder.setFormElement(null);
                    if (formElement != null && htmlTreeBuilder.inScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.removeFromStack(formElement);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 6:
                    if (htmlTreeBuilder.inButtonScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags(normalName);
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(normalName);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processStartTag(normalName);
                        return htmlTreeBuilder.process(asEndTag);
                    }
                case 7:
                case '\b':
                    if (htmlTreeBuilder.inScope(normalName)) {
                        htmlTreeBuilder.generateImpliedEndTags(normalName);
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(normalName);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                    if (htmlTreeBuilder.inScope(Constants.Headings)) {
                        htmlTreeBuilder.generateImpliedEndTags(normalName);
                        if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(Constants.Headings);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 15:
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag(HtmlTags.BR);
                    return false;
                default:
                    if (StringUtil.inSorted(normalName, Constants.InBodyEndAdoptionFormatters)) {
                        return inBodyEndTagAdoption(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(normalName, Constants.InBodyEndClosers)) {
                        if (htmlTreeBuilder.inScope(normalName)) {
                            htmlTreeBuilder.generateImpliedEndTags();
                            if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                                htmlTreeBuilder.error(this);
                            }
                            htmlTreeBuilder.popStackToClose(normalName);
                            break;
                        } else {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartApplets)) {
                        if (!htmlTreeBuilder.inScope(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                            if (htmlTreeBuilder.inScope(normalName)) {
                                htmlTreeBuilder.generateImpliedEndTags();
                                if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                                    htmlTreeBuilder.error(this);
                                }
                                htmlTreeBuilder.popStackToClose(normalName);
                                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                                break;
                            } else {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                        }
                    } else {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    }
                    break;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String str = token.asEndTag().normalName;
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            int size = stack.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = stack.get(size);
                if (element.normalName().equals(str)) {
                    htmlTreeBuilder.generateImpliedEndTags(str);
                    if (!str.equals(htmlTreeBuilder.currentElement().normalName())) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(str);
                } else if (htmlTreeBuilder.isSpecial(element)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }

        private boolean inBodyEndTagAdoption(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String normalName = token.asEndTag().normalName();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            int i = 0;
            while (i < 8) {
                Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(normalName);
                if (activeFormattingElement == null) {
                    return anyOtherEndTag(token, htmlTreeBuilder);
                }
                if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    return true;
                } else if (!htmlTreeBuilder.inScope(activeFormattingElement.normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                        htmlTreeBuilder.error(this);
                    }
                    int size = stack.size();
                    Element element = null;
                    element = null;
                    Element element2 = null;
                    int i2 = 0;
                    boolean z = false;
                    while (true) {
                        if (i2 >= size || i2 >= 64) {
                            break;
                        }
                        Element element3 = stack.get(i2);
                        if (element3 != activeFormattingElement) {
                            if (z && htmlTreeBuilder.isSpecial(element3)) {
                                element = element3;
                                break;
                            }
                        } else {
                            element2 = stack.get(i2 - 1);
                            z = true;
                        }
                        i2++;
                    }
                    if (element == null) {
                        htmlTreeBuilder.popStackToClose(activeFormattingElement.normalName());
                        htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                        return true;
                    }
                    Element element4 = element;
                    Element element5 = element4;
                    for (int i3 = 0; i3 < 3; i3++) {
                        if (htmlTreeBuilder.onStack(element4)) {
                            element4 = htmlTreeBuilder.aboveOnStack(element4);
                        }
                        if (!htmlTreeBuilder.isInActiveFormattingElements(element4)) {
                            htmlTreeBuilder.removeFromStack(element4);
                        } else if (element4 == activeFormattingElement) {
                            break;
                        } else {
                            Element element6 = new Element(Tag.valueOf(element4.nodeName(), ParseSettings.preserveCase), htmlTreeBuilder.getBaseUri());
                            htmlTreeBuilder.replaceActiveFormattingElement(element4, element6);
                            htmlTreeBuilder.replaceOnStack(element4, element6);
                            if (element5.parent() != null) {
                                element5.remove();
                            }
                            element6.appendChild(element5);
                            element4 = element6;
                            element5 = element4;
                        }
                    }
                    if (StringUtil.inSorted(element2.normalName(), Constants.InBodyEndTableFosters)) {
                        if (element5.parent() != null) {
                            element5.remove();
                        }
                        htmlTreeBuilder.insertInFosterParent(element5);
                    } else {
                        if (element5.parent() != null) {
                            element5.remove();
                        }
                        element2.appendChild(element5);
                    }
                    Element element7 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                    element7.attributes().addAll(activeFormattingElement.attributes());
                    for (Node node : (Node[]) element.childNodes().toArray(new Node[0])) {
                        element7.appendChild(node);
                    }
                    element.appendChild(element7);
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    htmlTreeBuilder.removeFromStack(activeFormattingElement);
                    htmlTreeBuilder.insertOnStackAfter(element, element7);
                    i++;
                }
            }
            return true;
        }
    },
    Text {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            } else if (!token.isEndTag()) {
                return true;
            } else {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return true;
            }
        }
    },
    InTable {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(InTableText);
                return htmlTreeBuilder.process(token);
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("caption")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InCaption);
                } else if (normalName.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InColumnGroup);
                } else if (normalName.equals("col")) {
                    htmlTreeBuilder.processStartTag("colgroup");
                    return htmlTreeBuilder.process(token);
                } else if (StringUtil.inSorted(normalName, Constants.InTableToBody)) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InTableBody);
                } else if (StringUtil.inSorted(normalName, Constants.InTableAddBody)) {
                    htmlTreeBuilder.processStartTag("tbody");
                    return htmlTreeBuilder.process(token);
                } else if (normalName.equals(HtmlTags.TABLE)) {
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.processEndTag(HtmlTags.TABLE)) {
                        return htmlTreeBuilder.process(token);
                    }
                } else if (StringUtil.inSorted(normalName, Constants.InTableToHead)) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (normalName.equals("input")) {
                        if (!asStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.insertEmpty(asStartTag);
                    } else if (!normalName.equals("form")) {
                        return anythingElse(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.getFormElement() != null) {
                            return false;
                        }
                        htmlTreeBuilder.insertForm(asStartTag, false);
                    }
                }
                return true;
            } else if (token.isEndTag()) {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals(HtmlTags.TABLE)) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.popStackToClose(HtmlTags.TABLE);
                    htmlTreeBuilder.resetInsertionMode();
                    return true;
                } else if (!StringUtil.inSorted(normalName2, Constants.InTableEndErr)) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (!token.isEOF()) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                    htmlTreeBuilder.error(this);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            if (!StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                return htmlTreeBuilder.process(token, InBody);
            }
            htmlTreeBuilder.setFosterInserts(true);
            boolean process = htmlTreeBuilder.process(token, InBody);
            htmlTreeBuilder.setFosterInserts(false);
            return process;
        }
    },
    InTableText {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.type == Token.TokenType.Character) {
                Token.Character asCharacter = token.asCharacter();
                if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.getPendingTableCharacters().add(asCharacter.getData());
                return true;
            }
            if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                    if (!HtmlTreeBuilderState.isWhitespace(str)) {
                        htmlTreeBuilder.error(this);
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                            htmlTreeBuilder.setFosterInserts(true);
                            htmlTreeBuilder.process(new Token.Character().data(str), InBody);
                            htmlTreeBuilder.setFosterInserts(false);
                        } else {
                            htmlTreeBuilder.process(new Token.Character().data(str), InBody);
                        }
                    } else {
                        htmlTreeBuilder.insert(new Token.Character().data(str));
                    }
                }
                htmlTreeBuilder.newPendingTableCharacters();
            }
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return htmlTreeBuilder.process(token);
        }
    },
    InCaption {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!token.isEndTag() || !token.asEndTag().normalName().equals("caption")) {
                if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) || (token.isEndTag() && token.asEndTag().normalName().equals(HtmlTags.TABLE))) {
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.processEndTag("caption")) {
                        return htmlTreeBuilder.process(token);
                    }
                    return true;
                } else if (!token.isEndTag() || !StringUtil.inSorted(token.asEndTag().normalName(), Constants.InCaptionIgnore)) {
                    return htmlTreeBuilder.process(token, InBody);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElement().normalName().equals("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(InTable);
                return true;
            }
        }
    },
    InColumnGroup {
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x008d, code lost:
            if (r2.equals("html") == false) goto L_0x009a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00a8  */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(org.jsoup.parser.Token r9, org.jsoup.parser.HtmlTreeBuilder r10) {
            /*
                r8 = this;
                boolean r0 = org.jsoup.parser.HtmlTreeBuilderState.isWhitespace(r9)
                r1 = 1
                if (r0 == 0) goto L_0x000f
                org.jsoup.parser.Token$Character r9 = r9.asCharacter()
                r10.insert(r9)
                return r1
            L_0x000f:
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType
                org.jsoup.parser.Token$TokenType r2 = r9.type
                int r2 = r2.ordinal()
                r0 = r0[r2]
                if (r0 == r1) goto L_0x00b3
                r2 = 2
                if (r0 == r2) goto L_0x00af
                r2 = 3
                r3 = 0
                java.lang.String r4 = "html"
                if (r0 == r2) goto L_0x0071
                r2 = 4
                if (r0 == r2) goto L_0x0043
                r2 = 6
                if (r0 == r2) goto L_0x002f
                boolean r9 = r8.anythingElse(r9, r10)
                return r9
            L_0x002f:
                org.jsoup.nodes.Element r0 = r10.currentElement()
                java.lang.String r0 = r0.normalName()
                boolean r0 = r0.equals(r4)
                if (r0 == 0) goto L_0x003e
                return r1
            L_0x003e:
                boolean r9 = r8.anythingElse(r9, r10)
                return r9
            L_0x0043:
                org.jsoup.parser.Token$EndTag r0 = r9.asEndTag()
                java.lang.String r0 = r0.normalName
                java.lang.String r2 = "colgroup"
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x006c
                org.jsoup.nodes.Element r9 = r10.currentElement()
                java.lang.String r9 = r9.normalName()
                boolean r9 = r9.equals(r4)
                if (r9 == 0) goto L_0x0063
                r10.error(r8)
                return r3
            L_0x0063:
                r10.pop()
                org.jsoup.parser.HtmlTreeBuilderState r9 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass12.InTable
                r10.transition(r9)
                goto L_0x00ba
            L_0x006c:
                boolean r9 = r8.anythingElse(r9, r10)
                return r9
            L_0x0071:
                org.jsoup.parser.Token$StartTag r0 = r9.asStartTag()
                java.lang.String r2 = r0.normalName()
                r5 = -1
                int r6 = r2.hashCode()
                r7 = 98688(0x18180, float:1.38291E-40)
                if (r6 == r7) goto L_0x0090
                r7 = 3213227(0x3107ab, float:4.50269E-39)
                if (r6 == r7) goto L_0x0089
                goto L_0x009a
            L_0x0089:
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L_0x009a
                goto L_0x009b
            L_0x0090:
                java.lang.String r3 = "col"
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L_0x009a
                r3 = 1
                goto L_0x009b
            L_0x009a:
                r3 = -1
            L_0x009b:
                if (r3 == 0) goto L_0x00a8
                if (r3 == r1) goto L_0x00a4
                boolean r9 = r8.anythingElse(r9, r10)
                return r9
            L_0x00a4:
                r10.insertEmpty(r0)
                goto L_0x00ba
            L_0x00a8:
                org.jsoup.parser.HtmlTreeBuilderState r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass12.InBody
                boolean r9 = r10.process(r9, r0)
                return r9
            L_0x00af:
                r10.error(r8)
                goto L_0x00ba
            L_0x00b3:
                org.jsoup.parser.Token$Comment r9 = r9.asComment()
                r10.insert(r9)
            L_0x00ba:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass12.process(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("colgroup")) {
                return treeBuilder.process(token);
            }
            return true;
        }
    },
    InTableBody {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("template")) {
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                } else if (normalName.equals(HtmlTags.TR)) {
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InRow);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag(HtmlTags.TR);
                    return htmlTreeBuilder.process(asStartTag);
                } else if (StringUtil.inSorted(normalName, Constants.InTableBodyExit)) {
                    return exitTableBody(token, htmlTreeBuilder);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (i != 4) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String normalName2 = token.asEndTag().normalName();
                if (StringUtil.inSorted(normalName2, Constants.InTableEndIgnore)) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTable);
                    return true;
                } else if (normalName2.equals(HtmlTags.TABLE)) {
                    return exitTableBody(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.inSorted(normalName2, Constants.InTableBodyEndIgnore)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("tbody") || htmlTreeBuilder.inTableScope("thead") || htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.clearStackToTableBodyContext();
                htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().normalName());
                return htmlTreeBuilder.process(token);
            }
            htmlTreeBuilder.error(this);
            return false;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }
    },
    InRow {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("template")) {
                    htmlTreeBuilder.insert(asStartTag);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InCell);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InRowMissing)) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (!token.isEndTag()) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals(HtmlTags.TR)) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTableBody);
                    return true;
                } else if (normalName2.equals(HtmlTags.TABLE)) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    if (StringUtil.inSorted(normalName2, Constants.InTableToBody)) {
                        if (!htmlTreeBuilder.inTableScope(normalName2)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.processEndTag(HtmlTags.TR);
                        return htmlTreeBuilder.process(token);
                    } else if (!StringUtil.inSorted(normalName2, Constants.InRowIgnore)) {
                        return anythingElse(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                }
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag(HtmlTags.TR)) {
                return treeBuilder.process(token);
            }
            return false;
        }
    },
    InCell {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String normalName = token.asEndTag().normalName();
                if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.transition(InRow);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElement().normalName().equals(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(InRow);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InCellBody)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!StringUtil.inSorted(normalName, Constants.InCellTable)) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                }
            } else if (!token.isStartTag() || !StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) {
                return anythingElse(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.inTableScope(HtmlTags.TD) || htmlTreeBuilder.inTableScope(HtmlTags.TH)) {
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope(HtmlTags.TD)) {
                htmlTreeBuilder.processEndTag(HtmlTags.TD);
            } else {
                htmlTreeBuilder.processEndTag(HtmlTags.TH);
            }
        }
    },
    InSelect {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    break;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag asStartTag = token.asStartTag();
                    String normalName = asStartTag.normalName();
                    if (normalName.equals("html")) {
                        return htmlTreeBuilder.process(asStartTag, InBody);
                    }
                    if (normalName.equals("option")) {
                        if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (normalName.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElement().normalName().equals("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (htmlTreeBuilder.currentElement().normalName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("optgroup");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (normalName.equals("select")) {
                        htmlTreeBuilder.error(this);
                        return htmlTreeBuilder.processEndTag("select");
                    } else if (StringUtil.inSorted(normalName, Constants.InSelectEnd)) {
                        htmlTreeBuilder.error(this);
                        if (!htmlTreeBuilder.inSelectScope("select")) {
                            return false;
                        }
                        htmlTreeBuilder.processEndTag("select");
                        return htmlTreeBuilder.process(asStartTag);
                    } else if (normalName.equals("script")) {
                        return htmlTreeBuilder.process(token, InHead);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                case 4:
                    String normalName2 = token.asEndTag().normalName();
                    char c = 65535;
                    int hashCode = normalName2.hashCode();
                    if (hashCode != -1010136971) {
                        if (hashCode != -906021636) {
                            if (hashCode == -80773204 && normalName2.equals("optgroup")) {
                                c = 0;
                            }
                        } else if (normalName2.equals("select")) {
                            c = 2;
                        }
                    } else if (normalName2.equals("option")) {
                        c = 1;
                    }
                    if (c != 0) {
                        if (c == 1) {
                            if (!htmlTreeBuilder.currentElement().normalName().equals("option")) {
                                htmlTreeBuilder.error(this);
                                break;
                            } else {
                                htmlTreeBuilder.pop();
                                break;
                            }
                        } else if (c == 2) {
                            if (htmlTreeBuilder.inSelectScope(normalName2)) {
                                htmlTreeBuilder.popStackToClose(normalName2);
                                htmlTreeBuilder.resetInsertionMode();
                                break;
                            } else {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                        } else {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                    } else {
                        if (htmlTreeBuilder.currentElement().normalName().equals("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).normalName().equals("optgroup")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (!htmlTreeBuilder.currentElement().normalName().equals("optgroup")) {
                            htmlTreeBuilder.error(this);
                            break;
                        } else {
                            htmlTreeBuilder.pop();
                            break;
                        }
                    }
                case 5:
                    Token.Character asCharacter = token.asCharacter();
                    if (!asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.insert(asCharacter);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 6:
                    if (!htmlTreeBuilder.currentElement().normalName().equals("html")) {
                        htmlTreeBuilder.error(this);
                        break;
                    }
                    break;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InSelectInTable {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InSelecTableEnd)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            } else if (!token.isEndTag() || !StringUtil.inSorted(token.asEndTag().normalName(), Constants.InSelecTableEnd)) {
                return htmlTreeBuilder.process(token, InSelect);
            } else {
                htmlTreeBuilder.error(this);
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    return false;
                }
                htmlTreeBuilder.processEndTag("select");
                return htmlTreeBuilder.process(token);
            }
        }
    },
    AfterBody {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (!token.isEndTag() || !token.asEndTag().normalName().equals("html")) {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                } else if (htmlTreeBuilder.isFragmentParsing()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.transition(AfterAfterBody);
                    return true;
                }
            }
        }
    },
    InFrameset {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                char c = 65535;
                switch (normalName.hashCode()) {
                    case -1644953643:
                        if (normalName.equals("frameset")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3213227:
                        if (normalName.equals("html")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 97692013:
                        if (normalName.equals("frame")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1192721831:
                        if (normalName.equals("noframes")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    return htmlTreeBuilder.process(asStartTag, InBody);
                }
                if (c == 1) {
                    htmlTreeBuilder.insert(asStartTag);
                } else if (c == 2) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (c == 3) {
                    return htmlTreeBuilder.process(asStartTag, InHead);
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else if (!token.isEndTag() || !token.asEndTag().normalName().equals("frameset")) {
                if (!token.isEOF()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (!htmlTreeBuilder.currentElement().normalName().equals("html")) {
                    htmlTreeBuilder.error(this);
                }
            } else if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                htmlTreeBuilder.pop();
                if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElement().normalName().equals("frameset")) {
                    htmlTreeBuilder.transition(AfterFrameset);
                }
            }
            return true;
        }
    },
    AfterFrameset {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().normalName().equals("html")) {
                    htmlTreeBuilder.transition(AfterAfterFrameset);
                    return true;
                } else if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }
    },
    AfterAfterBody {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || (token.isStartTag() && token.asStartTag().normalName().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    Element popStackToClose = htmlTreeBuilder.popStackToClose("html");
                    htmlTreeBuilder.insert(token.asCharacter());
                    htmlTreeBuilder.stack.add(popStackToClose);
                    htmlTreeBuilder.stack.add(popStackToClose.selectFirst(HtmlTags.BODY));
                    return true;
                } else if (token.isEOF()) {
                    return true;
                } else {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    AfterAfterFrameset {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().normalName().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEOF()) {
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
        }
    },
    ForeignContent {
        /* access modifiers changed from: package-private */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        public boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    /* access modifiers changed from: private */
    public static final String nullString = String.valueOf((char) 0);

    /* access modifiers changed from: package-private */
    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$24  reason: invalid class name */
    static /* synthetic */ class AnonymousClass24 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jsoup.parser.Token$TokenType[] r0 = org.jsoup.parser.Token.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType = r0
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Comment     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Doctype     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.$SwitchMap$org$jsoup$parser$Token$TokenType     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EOF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return StringUtil.isBlank(token.asCharacter().getData());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        return StringUtil.isBlank(str);
    }

    /* access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    /* access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    static final class Constants {
        static final String[] AfterHeadBody = {HtmlTags.BODY, "html"};
        static final String[] BeforeHtmlToHead = {HtmlTags.BODY, HtmlTags.BR, "head", "html"};
        static final String[] DdDt = {"dd", "dt"};
        static final String[] Formatters = {HtmlTags.B, "big", "code", HtmlTags.EM, HtmlTags.FONT, HtmlTags.I, HtmlTags.S, "small", HtmlTags.STRIKE, HtmlTags.STRONG, "tt", HtmlTags.U};
        static final String[] Headings = {HtmlTags.H1, HtmlTags.H2, HtmlTags.H3, HtmlTags.H4, HtmlTags.H5, HtmlTags.H6};
        static final String[] InBodyEndAdoptionFormatters = {HtmlTags.A, HtmlTags.B, "big", "code", HtmlTags.EM, HtmlTags.FONT, HtmlTags.I, "nobr", HtmlTags.S, "small", HtmlTags.STRIKE, HtmlTags.STRONG, "tt", HtmlTags.U};
        static final String[] InBodyEndClosers = {"address", "article", "aside", HtmlTags.BLOCKQUOTE, "button", HtmlTags.ALIGN_CENTER, ErrorBundle.DETAIL_ENTRY, "dir", HtmlTags.DIV, "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", HtmlTags.OL, HtmlTags.PRE, "section", ErrorBundle.SUMMARY_ENTRY, HtmlTags.UL};
        static final String[] InBodyEndTableFosters = {HtmlTags.TABLE, "tbody", "tfoot", "thead", HtmlTags.TR};
        static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        static final String[] InBodyStartDrop = {"caption", "col", "colgroup", "frame", "head", "tbody", HtmlTags.TD, "tfoot", HtmlTags.TH, "thead", HtmlTags.TR};
        static final String[] InBodyStartEmptyFormatters = {"area", HtmlTags.BR, "embed", HtmlTags.IMG, "keygen", "wbr"};
        static final String[] InBodyStartInputAttribs = {"action", AppMeasurementSdk.ConditionalUserProperty.NAME, "prompt"};
        static final String[] InBodyStartLiBreakers = {"address", HtmlTags.DIV, HtmlTags.P};
        static final String[] InBodyStartMedia = {"param", "source", "track"};
        static final String[] InBodyStartPClosers = {"address", "article", "aside", HtmlTags.BLOCKQUOTE, HtmlTags.ALIGN_CENTER, ErrorBundle.DETAIL_ENTRY, "dir", HtmlTags.DIV, "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", HtmlTags.OL, HtmlTags.P, "section", ErrorBundle.SUMMARY_ENTRY, HtmlTags.UL};
        static final String[] InBodyStartToHead = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", HtmlTags.STYLE, "title"};
        static final String[] InCaptionIgnore = {HtmlTags.BODY, "col", "colgroup", "html", "tbody", HtmlTags.TD, "tfoot", HtmlTags.TH, "thead", HtmlTags.TR};
        static final String[] InCellBody = {HtmlTags.BODY, "caption", "col", "colgroup", "html"};
        static final String[] InCellCol = {"caption", "col", "colgroup", "tbody", HtmlTags.TD, "tfoot", HtmlTags.TH, "thead", HtmlTags.TR};
        static final String[] InCellNames = {HtmlTags.TD, HtmlTags.TH};
        static final String[] InCellTable = {HtmlTags.TABLE, "tbody", "tfoot", "thead", HtmlTags.TR};
        static final String[] InHeadEmpty = {"base", "basefont", "bgsound", "command", "link"};
        static final String[] InHeadEnd = {HtmlTags.BODY, HtmlTags.BR, "html"};
        static final String[] InHeadNoScriptHead = {"basefont", "bgsound", "link", "meta", "noframes", HtmlTags.STYLE};
        static final String[] InHeadNoscriptIgnore = {"head", "noscript"};
        static final String[] InHeadRaw = {"noframes", HtmlTags.STYLE};
        static final String[] InRowIgnore = {HtmlTags.BODY, "caption", "col", "colgroup", "html", HtmlTags.TD, HtmlTags.TH};
        static final String[] InRowMissing = {"caption", "col", "colgroup", "tbody", "tfoot", "thead", HtmlTags.TR};
        static final String[] InSelecTableEnd = {"caption", HtmlTags.TABLE, "tbody", HtmlTags.TD, "tfoot", HtmlTags.TH, "thead", HtmlTags.TR};
        static final String[] InSelectEnd = {"input", "keygen", "textarea"};
        static final String[] InTableAddBody = {HtmlTags.TD, HtmlTags.TH, HtmlTags.TR};
        static final String[] InTableBodyEndIgnore = {HtmlTags.BODY, "caption", "col", "colgroup", "html", HtmlTags.TD, HtmlTags.TH, HtmlTags.TR};
        static final String[] InTableBodyExit = {"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
        static final String[] InTableEndErr = {HtmlTags.BODY, "caption", "col", "colgroup", "html", "tbody", HtmlTags.TD, "tfoot", HtmlTags.TH, "thead", HtmlTags.TR};
        static final String[] InTableEndIgnore = {"tbody", "tfoot", "thead"};
        static final String[] InTableFoster = {HtmlTags.TABLE, "tbody", "tfoot", "thead", HtmlTags.TR};
        static final String[] InTableToBody = {"tbody", "tfoot", "thead"};
        static final String[] InTableToHead = {"script", HtmlTags.STYLE};

        Constants() {
        }
    }
}
