package com.itextpdf.text.xml.simpleparser.handler;

import com.itextpdf.text.xml.simpleparser.NewLineHandler;

public class NeverNewLineHandler implements NewLineHandler {
    @Override // com.itextpdf.text.xml.simpleparser.NewLineHandler
    public boolean isNewLineTag(String str) {
        return false;
    }
}
