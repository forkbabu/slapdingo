package org.jsoup.parser;

import androidx.core.app.NotificationCompat;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.spongycastle.i18n.ErrorBundle;

public class Tag implements Cloneable {
    private static final String[] blockTags;
    private static final String[] emptyTags = {"meta", "link", "base", "frame", HtmlTags.IMG, HtmlTags.BR, "wbr", "embed", HtmlTags.HR, "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
    private static final String[] formListedTags = {"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
    private static final String[] formSubmitTags = {"input", "keygen", "object", "select", "textarea"};
    private static final String[] formatAsInlineTags = {"title", HtmlTags.A, HtmlTags.P, HtmlTags.H1, HtmlTags.H2, HtmlTags.H3, HtmlTags.H4, HtmlTags.H5, HtmlTags.H6, HtmlTags.PRE, "address", HtmlTags.LI, HtmlTags.TH, HtmlTags.TD, "script", HtmlTags.STYLE, "ins", "del", HtmlTags.S};
    private static final String[] inlineTags = {"object", "base", HtmlTags.FONT, "tt", HtmlTags.I, HtmlTags.B, HtmlTags.U, "big", "small", HtmlTags.EM, HtmlTags.STRONG, "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", HtmlTags.A, HtmlTags.IMG, HtmlTags.BR, "wbr", "map", "q", HtmlTags.SUB, HtmlTags.SUP, "bdo", "iframe", "embed", HtmlTags.SPAN, "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", NotificationCompat.CATEGORY_PROGRESS, "meter", "area", "param", "source", "track", ErrorBundle.SUMMARY_ENTRY, "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", HtmlTags.S};
    private static final String[] preserveWhitespaceTags = {HtmlTags.PRE, "plaintext", "title", "textarea"};
    private static final Map<String, Tag> tags = new HashMap();
    private boolean empty = false;
    private boolean formList = false;
    private boolean formSubmit = false;
    private boolean formatAsBlock = true;
    private boolean isBlock = true;
    private String normalName;
    private boolean preserveWhitespace = false;
    private boolean selfClosing = false;
    private String tagName;

    static {
        String[] strArr = {"html", "head", HtmlTags.BODY, "frameset", "script", "noscript", HtmlTags.STYLE, "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", HtmlTags.P, HtmlTags.H1, HtmlTags.H2, HtmlTags.H3, HtmlTags.H4, HtmlTags.H5, HtmlTags.H6, HtmlTags.UL, HtmlTags.OL, HtmlTags.PRE, HtmlTags.DIV, HtmlTags.BLOCKQUOTE, HtmlTags.HR, "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", HtmlTags.LI, HtmlTags.TABLE, "caption", "thead", "tfoot", "tbody", "colgroup", "col", HtmlTags.TR, HtmlTags.TH, HtmlTags.TD, "video", "audio", "canvas", ErrorBundle.DETAIL_ENTRY, "menu", "plaintext", "template", "article", "main", "svg", "math", HtmlTags.ALIGN_CENTER};
        blockTags = strArr;
        for (String str : strArr) {
            register(new Tag(str));
        }
        for (String str2 : inlineTags) {
            Tag tag = new Tag(str2);
            tag.isBlock = false;
            tag.formatAsBlock = false;
            register(tag);
        }
        for (String str3 : emptyTags) {
            Tag tag2 = tags.get(str3);
            Validate.notNull(tag2);
            tag2.empty = true;
        }
        for (String str4 : formatAsInlineTags) {
            Tag tag3 = tags.get(str4);
            Validate.notNull(tag3);
            tag3.formatAsBlock = false;
        }
        for (String str5 : preserveWhitespaceTags) {
            Tag tag4 = tags.get(str5);
            Validate.notNull(tag4);
            tag4.preserveWhitespace = true;
        }
        for (String str6 : formListedTags) {
            Tag tag5 = tags.get(str6);
            Validate.notNull(tag5);
            tag5.formList = true;
        }
        for (String str7 : formSubmitTags) {
            Tag tag6 = tags.get(str7);
            Validate.notNull(tag6);
            tag6.formSubmit = true;
        }
    }

    private Tag(String str) {
        this.tagName = str;
        this.normalName = Normalizer.lowerCase(str);
    }

    public String getName() {
        return this.tagName;
    }

    public String normalName() {
        return this.normalName;
    }

    public static Tag valueOf(String str, ParseSettings parseSettings) {
        Validate.notNull(str);
        Tag tag = tags.get(str);
        if (tag != null) {
            return tag;
        }
        String normalizeTag = parseSettings.normalizeTag(str);
        Validate.notEmpty(normalizeTag);
        String lowerCase = Normalizer.lowerCase(normalizeTag);
        Tag tag2 = tags.get(lowerCase);
        if (tag2 == null) {
            Tag tag3 = new Tag(normalizeTag);
            tag3.isBlock = false;
            return tag3;
        } else if (!parseSettings.preserveTagCase() || normalizeTag.equals(lowerCase)) {
            return tag2;
        } else {
            Tag clone = tag2.clone();
            clone.tagName = normalizeTag;
            return clone;
        }
    }

    public static Tag valueOf(String str) {
        return valueOf(str, ParseSettings.preserveCase);
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public boolean formatAsBlock() {
        return this.formatAsBlock;
    }

    public boolean isInline() {
        return !this.isBlock;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isSelfClosing() {
        return this.empty || this.selfClosing;
    }

    public boolean isKnownTag() {
        return tags.containsKey(this.tagName);
    }

    public static boolean isKnownTag(String str) {
        return tags.containsKey(str);
    }

    public boolean preserveWhitespace() {
        return this.preserveWhitespace;
    }

    public boolean isFormListed() {
        return this.formList;
    }

    public boolean isFormSubmittable() {
        return this.formSubmit;
    }

    /* access modifiers changed from: package-private */
    public Tag setSelfClosing() {
        this.selfClosing = true;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (this.tagName.equals(tag.tagName) && this.empty == tag.empty && this.formatAsBlock == tag.formatAsBlock && this.isBlock == tag.isBlock && this.preserveWhitespace == tag.preserveWhitespace && this.selfClosing == tag.selfClosing && this.formList == tag.formList && this.formSubmit == tag.formSubmit) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.tagName.hashCode() * 31) + (this.isBlock ? 1 : 0)) * 31) + (this.formatAsBlock ? 1 : 0)) * 31) + (this.empty ? 1 : 0)) * 31) + (this.selfClosing ? 1 : 0)) * 31) + (this.preserveWhitespace ? 1 : 0)) * 31) + (this.formList ? 1 : 0)) * 31) + (this.formSubmit ? 1 : 0);
    }

    public String toString() {
        return this.tagName;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public Tag clone() {
        try {
            return (Tag) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void register(Tag tag) {
        tags.put(tag.tagName, tag);
    }
}
