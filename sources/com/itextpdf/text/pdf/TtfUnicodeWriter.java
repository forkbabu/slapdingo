package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TtfUnicodeWriter {
    protected PdfWriter writer = null;

    public TtfUnicodeWriter(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    public void writeFont(TrueTypeFontUnicode trueTypeFontUnicode, PdfIndirectReference pdfIndirectReference, Object[] objArr, byte[] bArr) throws DocumentException, IOException {
        PdfIndirectReference pdfIndirectReference2;
        byte[] bArr2;
        HashMap<Integer, int[]> hashMap = (HashMap) objArr[0];
        trueTypeFontUnicode.addRangeUni(hashMap, true, trueTypeFontUnicode.subset);
        int[][] iArr = (int[][]) hashMap.values().toArray(new int[0][]);
        Arrays.sort(iArr, trueTypeFontUnicode);
        if (trueTypeFontUnicode.cff) {
            byte[] readCffFont = trueTypeFontUnicode.readCffFont();
            if (trueTypeFontUnicode.subset || trueTypeFontUnicode.subsetRanges != null) {
                CFFFontSubset cFFFontSubset = new CFFFontSubset(new RandomAccessFileOrArray(readCffFont), hashMap);
                try {
                    readCffFont = cFFFontSubset.Process(cFFFontSubset.getNames()[0]);
                } catch (Exception e) {
                    LoggerFactory.getLogger(TtfUnicodeWriter.class).error("Issue in CFF font subsetting.Subsetting was disabled", e);
                    trueTypeFontUnicode.setSubset(false);
                    trueTypeFontUnicode.addRangeUni(hashMap, true, trueTypeFontUnicode.subset);
                    iArr = (int[][]) hashMap.values().toArray(new int[0][]);
                    Arrays.sort(iArr, trueTypeFontUnicode);
                }
            }
            pdfIndirectReference2 = this.writer.addToBody(new BaseFont.StreamFont(readCffFont, "CIDFontType0C", trueTypeFontUnicode.compressionLevel)).getIndirectReference();
        } else {
            if (trueTypeFontUnicode.subset || trueTypeFontUnicode.directoryOffset != 0) {
                synchronized (trueTypeFontUnicode.rf) {
                    bArr2 = new TrueTypeFontSubSet(trueTypeFontUnicode.fileName, new RandomAccessFileOrArray(trueTypeFontUnicode.rf), new HashSet(hashMap.keySet()), trueTypeFontUnicode.directoryOffset, true, false).process();
                }
            } else {
                bArr2 = trueTypeFontUnicode.getFullFont();
            }
            pdfIndirectReference2 = this.writer.addToBody(new BaseFont.StreamFont(bArr2, new int[]{bArr2.length}, trueTypeFontUnicode.compressionLevel)).getIndirectReference();
        }
        String str = "";
        if (trueTypeFontUnicode.subset) {
            str = TrueTypeFontUnicode.createSubsetPrefix();
        }
        PdfIndirectReference pdfIndirectReference3 = null;
        PdfIndirectReference indirectReference = this.writer.addToBody(trueTypeFontUnicode.getCIDFontType2(this.writer.addToBody(trueTypeFontUnicode.getFontDescriptor(pdfIndirectReference2, str, null)).getIndirectReference(), str, iArr)).getIndirectReference();
        PdfStream toUnicode = trueTypeFontUnicode.getToUnicode(iArr);
        if (toUnicode != null) {
            pdfIndirectReference3 = this.writer.addToBody(toUnicode).getIndirectReference();
        }
        this.writer.addToBody(trueTypeFontUnicode.getFontBaseType(indirectReference, str, pdfIndirectReference3), pdfIndirectReference);
    }
}
