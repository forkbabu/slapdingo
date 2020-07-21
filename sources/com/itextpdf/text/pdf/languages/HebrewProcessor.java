package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.BidiLine;

public class HebrewProcessor implements LanguageProcessor {
    protected int runDirection = 3;

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public boolean isRTL() {
        return true;
    }

    public HebrewProcessor() {
    }

    public HebrewProcessor(int i) {
        this.runDirection = i;
    }

    @Override // com.itextpdf.text.pdf.languages.LanguageProcessor
    public String process(String str) {
        return BidiLine.processLTR(str, this.runDirection, 0);
    }
}
