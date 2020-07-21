package com.itextpdf.text;

import java.util.ArrayList;

public class Chapter extends Section {
    private static final long serialVersionUID = 1791000695779357361L;

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Section
    public boolean isNestable() {
        return false;
    }

    @Override // com.itextpdf.text.Element, com.itextpdf.text.Section
    public int type() {
        return 16;
    }

    public Chapter(int i) {
        super(null, 1);
        this.numbers = new ArrayList();
        this.numbers.add(Integer.valueOf(i));
        this.triggerNewPage = true;
    }

    public Chapter(Paragraph paragraph, int i) {
        super(paragraph, 1);
        this.numbers = new ArrayList();
        this.numbers.add(Integer.valueOf(i));
        this.triggerNewPage = true;
    }

    public Chapter(String str, int i) {
        this(new Paragraph(str), i);
    }
}
