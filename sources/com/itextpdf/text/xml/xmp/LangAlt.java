package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.xml.XMLUtil;
import java.util.Enumeration;
import java.util.Properties;

@Deprecated
public class LangAlt extends Properties {
    public static final String DEFAULT = "x-default";
    private static final long serialVersionUID = 4396971487200843099L;

    public LangAlt(String str) {
        addLanguage("x-default", str);
    }

    public LangAlt() {
    }

    public void addLanguage(String str, String str2) {
        setProperty(str, XMLUtil.escapeXML(str2, false));
    }

    /* access modifiers changed from: protected */
    public void process(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append("<rdf:li xml:lang=\"");
        stringBuffer.append(obj);
        stringBuffer.append("\" >");
        stringBuffer.append(get(obj));
        stringBuffer.append("</rdf:li>");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<rdf:Alt>");
        Enumeration<?> propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            process(stringBuffer, propertyNames.nextElement());
        }
        stringBuffer.append("</rdf:Alt>");
        return stringBuffer.toString();
    }
}
