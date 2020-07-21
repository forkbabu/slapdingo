package com.itextpdf.text.xml.simpleparser.handler;

import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.simpleparser.NewLineHandler;
import java.util.HashSet;
import java.util.Set;

public class HTMLNewLineHandler implements NewLineHandler {
    private final Set<String> newLineTags;

    public HTMLNewLineHandler() {
        HashSet hashSet = new HashSet();
        this.newLineTags = hashSet;
        hashSet.add(HtmlTags.P);
        this.newLineTags.add(HtmlTags.BLOCKQUOTE);
        this.newLineTags.add(HtmlTags.BR);
    }

    @Override // com.itextpdf.text.xml.simpleparser.NewLineHandler
    public boolean isNewLineTag(String str) {
        return this.newLineTags.contains(str);
    }
}
