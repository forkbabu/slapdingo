package org.jsoup.safety;

import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.spongycastle.i18n.ErrorBundle;

public class Whitelist {
    private Map<TagName, Set<AttributeKey>> attributes = new HashMap();
    private Map<TagName, Map<AttributeKey, AttributeValue>> enforcedAttributes = new HashMap();
    private boolean preserveRelativeLinks = false;
    private Map<TagName, Map<AttributeKey, Set<Protocol>>> protocols = new HashMap();
    private Set<TagName> tagNames = new HashSet();

    public static Whitelist none() {
        return new Whitelist();
    }

    public static Whitelist simpleText() {
        return new Whitelist().addTags(HtmlTags.B, HtmlTags.EM, HtmlTags.I, HtmlTags.STRONG, HtmlTags.U);
    }

    public static Whitelist basic() {
        return new Whitelist().addTags(HtmlTags.A, HtmlTags.B, HtmlTags.BLOCKQUOTE, HtmlTags.BR, "cite", "code", "dd", "dl", "dt", HtmlTags.EM, HtmlTags.I, HtmlTags.LI, HtmlTags.OL, HtmlTags.P, HtmlTags.PRE, "q", "small", HtmlTags.SPAN, HtmlTags.STRIKE, HtmlTags.STRONG, HtmlTags.SUB, HtmlTags.SUP, HtmlTags.U, HtmlTags.UL).addAttributes(HtmlTags.A, HtmlTags.HREF).addAttributes(HtmlTags.BLOCKQUOTE, "cite").addAttributes("q", "cite").addProtocols(HtmlTags.A, HtmlTags.HREF, "ftp", "http", "https", "mailto").addProtocols(HtmlTags.BLOCKQUOTE, "cite", "http", "https").addProtocols("cite", "cite", "http", "https").addEnforcedAttribute(HtmlTags.A, "rel", "nofollow");
    }

    public static Whitelist basicWithImages() {
        return basic().addTags(HtmlTags.IMG).addAttributes(HtmlTags.IMG, HtmlTags.ALIGN, "alt", HtmlTags.HEIGHT, HtmlTags.SRC, "title", HtmlTags.WIDTH).addProtocols(HtmlTags.IMG, HtmlTags.SRC, "http", "https");
    }

    public static Whitelist relaxed() {
        return new Whitelist().addTags(HtmlTags.A, HtmlTags.B, HtmlTags.BLOCKQUOTE, HtmlTags.BR, "caption", "cite", "code", "col", "colgroup", "dd", HtmlTags.DIV, "dl", "dt", HtmlTags.EM, HtmlTags.H1, HtmlTags.H2, HtmlTags.H3, HtmlTags.H4, HtmlTags.H5, HtmlTags.H6, HtmlTags.I, HtmlTags.IMG, HtmlTags.LI, HtmlTags.OL, HtmlTags.P, HtmlTags.PRE, "q", "small", HtmlTags.SPAN, HtmlTags.STRIKE, HtmlTags.STRONG, HtmlTags.SUB, HtmlTags.SUP, HtmlTags.TABLE, "tbody", HtmlTags.TD, "tfoot", HtmlTags.TH, "thead", HtmlTags.TR, HtmlTags.U, HtmlTags.UL).addAttributes(HtmlTags.A, HtmlTags.HREF, "title").addAttributes(HtmlTags.BLOCKQUOTE, "cite").addAttributes("col", HtmlTags.SPAN, HtmlTags.WIDTH).addAttributes("colgroup", HtmlTags.SPAN, HtmlTags.WIDTH).addAttributes(HtmlTags.IMG, HtmlTags.ALIGN, "alt", HtmlTags.HEIGHT, HtmlTags.SRC, "title", HtmlTags.WIDTH).addAttributes(HtmlTags.OL, "start", "type").addAttributes("q", "cite").addAttributes(HtmlTags.TABLE, ErrorBundle.SUMMARY_ENTRY, HtmlTags.WIDTH).addAttributes(HtmlTags.TD, "abbr", "axis", HtmlTags.COLSPAN, HtmlTags.ROWSPAN, HtmlTags.WIDTH).addAttributes(HtmlTags.TH, "abbr", "axis", HtmlTags.COLSPAN, HtmlTags.ROWSPAN, "scope", HtmlTags.WIDTH).addAttributes(HtmlTags.UL, "type").addProtocols(HtmlTags.A, HtmlTags.HREF, "ftp", "http", "https", "mailto").addProtocols(HtmlTags.BLOCKQUOTE, "cite", "http", "https").addProtocols("cite", "cite", "http", "https").addProtocols(HtmlTags.IMG, HtmlTags.SRC, "http", "https").addProtocols("q", "cite", "http", "https");
    }

    public Whitelist addTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            this.tagNames.add(TagName.valueOf(str));
        }
        return this;
    }

    public Whitelist removeTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            TagName valueOf = TagName.valueOf(str);
            if (this.tagNames.remove(valueOf)) {
                this.attributes.remove(valueOf);
                this.enforcedAttributes.remove(valueOf);
                this.protocols.remove(valueOf);
            }
        }
        return this;
    }

    public Whitelist addAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attribute names supplied.");
        TagName valueOf = TagName.valueOf(str);
        this.tagNames.add(valueOf);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(AttributeKey.valueOf(str2));
        }
        if (this.attributes.containsKey(valueOf)) {
            this.attributes.get(valueOf).addAll(hashSet);
        } else {
            this.attributes.put(valueOf, hashSet);
        }
        return this;
    }

    public Whitelist removeAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attribute names supplied.");
        TagName valueOf = TagName.valueOf(str);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(AttributeKey.valueOf(str2));
        }
        if (this.tagNames.contains(valueOf) && this.attributes.containsKey(valueOf)) {
            Set<AttributeKey> set = this.attributes.get(valueOf);
            set.removeAll(hashSet);
            if (set.isEmpty()) {
                this.attributes.remove(valueOf);
            }
        }
        if (str.equals(":all")) {
            for (TagName tagName : this.attributes.keySet()) {
                Set<AttributeKey> set2 = this.attributes.get(tagName);
                set2.removeAll(hashSet);
                if (set2.isEmpty()) {
                    this.attributes.remove(tagName);
                }
            }
        }
        return this;
    }

    public Whitelist addEnforcedAttribute(String str, String str2, String str3) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notEmpty(str3);
        TagName valueOf = TagName.valueOf(str);
        this.tagNames.add(valueOf);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        AttributeValue valueOf3 = AttributeValue.valueOf(str3);
        if (this.enforcedAttributes.containsKey(valueOf)) {
            this.enforcedAttributes.get(valueOf).put(valueOf2, valueOf3);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(valueOf2, valueOf3);
            this.enforcedAttributes.put(valueOf, hashMap);
        }
        return this;
    }

    public Whitelist removeEnforcedAttribute(String str, String str2) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        TagName valueOf = TagName.valueOf(str);
        if (this.tagNames.contains(valueOf) && this.enforcedAttributes.containsKey(valueOf)) {
            AttributeKey valueOf2 = AttributeKey.valueOf(str2);
            Map<AttributeKey, AttributeValue> map = this.enforcedAttributes.get(valueOf);
            map.remove(valueOf2);
            if (map.isEmpty()) {
                this.enforcedAttributes.remove(valueOf);
            }
        }
        return this;
    }

    public Whitelist preserveRelativeLinks(boolean z) {
        this.preserveRelativeLinks = z;
        return this;
    }

    public Whitelist addProtocols(String str, String str2, String... strArr) {
        Map<AttributeKey, Set<Protocol>> map;
        Set<Protocol> set;
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        if (this.protocols.containsKey(valueOf)) {
            map = this.protocols.get(valueOf);
        } else {
            HashMap hashMap = new HashMap();
            this.protocols.put(valueOf, hashMap);
            map = hashMap;
        }
        if (map.containsKey(valueOf2)) {
            set = map.get(valueOf2);
        } else {
            HashSet hashSet = new HashSet();
            map.put(valueOf2, hashSet);
            set = hashSet;
        }
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.add(Protocol.valueOf(str3));
        }
        return this;
    }

    public Whitelist removeProtocols(String str, String str2, String... strArr) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        Validate.isTrue(this.protocols.containsKey(valueOf), "Cannot remove a protocol that is not set.");
        Map<AttributeKey, Set<Protocol>> map = this.protocols.get(valueOf);
        Validate.isTrue(map.containsKey(valueOf2), "Cannot remove a protocol that is not set.");
        Set<Protocol> set = map.get(valueOf2);
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.remove(Protocol.valueOf(str3));
        }
        if (set.isEmpty()) {
            map.remove(valueOf2);
            if (map.isEmpty()) {
                this.protocols.remove(valueOf);
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean isSafeTag(String str) {
        return this.tagNames.contains(TagName.valueOf(str));
    }

    /* access modifiers changed from: protected */
    public boolean isSafeAttribute(String str, Element element, Attribute attribute) {
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(attribute.getKey());
        Set<AttributeKey> set = this.attributes.get(valueOf);
        if (set == null || !set.contains(valueOf2)) {
            if (this.enforcedAttributes.get(valueOf) != null) {
                Attributes enforcedAttributes2 = getEnforcedAttributes(str);
                String key = attribute.getKey();
                if (enforcedAttributes2.hasKeyIgnoreCase(key)) {
                    return enforcedAttributes2.getIgnoreCase(key).equals(attribute.getValue());
                }
            }
            if (str.equals(":all") || !isSafeAttribute(":all", element, attribute)) {
                return false;
            }
            return true;
        } else if (!this.protocols.containsKey(valueOf)) {
            return true;
        } else {
            Map<AttributeKey, Set<Protocol>> map = this.protocols.get(valueOf);
            if (!map.containsKey(valueOf2) || testValidProtocol(element, attribute, map.get(valueOf2))) {
                return true;
            }
            return false;
        }
    }

    private boolean testValidProtocol(Element element, Attribute attribute, Set<Protocol> set) {
        String absUrl = element.absUrl(attribute.getKey());
        if (absUrl.length() == 0) {
            absUrl = attribute.getValue();
        }
        if (!this.preserveRelativeLinks) {
            attribute.setValue(absUrl);
        }
        for (Protocol protocol : set) {
            String protocol2 = protocol.toString();
            if (!protocol2.equals("#")) {
                if (Normalizer.lowerCase(absUrl).startsWith(protocol2 + ":")) {
                    return true;
                }
            } else if (isValidAnchor(absUrl)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidAnchor(String str) {
        return str.startsWith("#") && !str.matches(".*\\s.*");
    }

    /* access modifiers changed from: package-private */
    public Attributes getEnforcedAttributes(String str) {
        Attributes attributes2 = new Attributes();
        TagName valueOf = TagName.valueOf(str);
        if (this.enforcedAttributes.containsKey(valueOf)) {
            for (Map.Entry<AttributeKey, AttributeValue> entry : this.enforcedAttributes.get(valueOf).entrySet()) {
                attributes2.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return attributes2;
    }

    static class TagName extends TypedValue {
        TagName(String str) {
            super(str);
        }

        static TagName valueOf(String str) {
            return new TagName(str);
        }
    }

    static class AttributeKey extends TypedValue {
        AttributeKey(String str) {
            super(str);
        }

        static AttributeKey valueOf(String str) {
            return new AttributeKey(str);
        }
    }

    static class AttributeValue extends TypedValue {
        AttributeValue(String str) {
            super(str);
        }

        static AttributeValue valueOf(String str) {
            return new AttributeValue(str);
        }
    }

    static class Protocol extends TypedValue {
        Protocol(String str) {
            super(str);
        }

        static Protocol valueOf(String str) {
            return new Protocol(str);
        }
    }

    static abstract class TypedValue {
        private String value;

        TypedValue(String str) {
            Validate.notNull(str);
            this.value = str;
        }

        public int hashCode() {
            String str = this.value;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TypedValue typedValue = (TypedValue) obj;
            String str = this.value;
            if (str != null) {
                return str.equals(typedValue.value);
            }
            if (typedValue.value == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.value;
        }
    }
}
