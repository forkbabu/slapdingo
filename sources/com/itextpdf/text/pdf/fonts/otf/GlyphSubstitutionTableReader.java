package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.Glyph;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GlyphSubstitutionTableReader extends OpenTypeFontTableReader {
    private final Map<Integer, Character> glyphToCharacterMap;
    private final int[] glyphWidthsByIndex;
    private Map<Integer, List<Integer>> rawLigatureSubstitutionMap;

    public GlyphSubstitutionTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i, Map<Integer, Character> map, int[] iArr) throws IOException {
        super(randomAccessFileOrArray, i);
        this.glyphWidthsByIndex = iArr;
        this.glyphToCharacterMap = map;
    }

    public void read() throws FontReadingException {
        this.rawLigatureSubstitutionMap = new LinkedHashMap();
        startReadingTable();
    }

    public Map<String, Glyph> getGlyphSubstitutionMap() throws FontReadingException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : this.rawLigatureSubstitutionMap.keySet()) {
            List<Integer> list = this.rawLigatureSubstitutionMap.get(num);
            StringBuilder sb = new StringBuilder(list.size());
            for (Integer num2 : list) {
                sb.append(getTextFromGlyph(num2.intValue(), this.glyphToCharacterMap));
            }
            Glyph glyph = new Glyph(num.intValue(), this.glyphWidthsByIndex[num.intValue()], sb.toString());
            linkedHashMap.put(glyph.chars, glyph);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private String getTextFromGlyph(int i, Map<Integer, Character> map) throws FontReadingException {
        StringBuilder sb = new StringBuilder(1);
        Character ch = map.get(Integer.valueOf(i));
        if (ch == null) {
            List<Integer> list = this.rawLigatureSubstitutionMap.get(Integer.valueOf(i));
            if (list == null || list.isEmpty()) {
                throw new FontReadingException("No corresponding character or simple glyphs found for GlyphID=" + i);
            }
            for (Integer num : list) {
                sb.append(getTextFromGlyph(num.intValue(), map));
            }
        } else {
            sb.append(ch.charValue());
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.fonts.otf.OpenTypeFontTableReader
    public void readSubTable(int i, int i2) throws IOException {
        if (i == 1) {
            readSingleSubstitutionSubtable(i2);
        } else if (i == 4) {
            readLigatureSubstitutionSubtable(i2);
        } else {
            PrintStream printStream = System.err;
            printStream.println("LookupType " + i + " is not yet handled for " + GlyphSubstitutionTableReader.class.getSimpleName());
        }
    }

    private void readSingleSubstitutionSubtable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("substFormat=" + ((int) readShort));
        if (readShort == 1) {
            short readShort2 = this.rf.readShort();
            Logger logger2 = LOG;
            logger2.debug("coverage=" + ((int) readShort2));
            short readShort3 = this.rf.readShort();
            Logger logger3 = LOG;
            logger3.debug("deltaGlyphID=" + ((int) readShort3));
            for (Integer num : readCoverageFormat(i + readShort2)) {
                int intValue = num.intValue();
                this.rawLigatureSubstitutionMap.put(Integer.valueOf(intValue + readShort3), Arrays.asList(Integer.valueOf(intValue)));
            }
        } else if (readShort == 2) {
            short readShort4 = this.rf.readShort();
            Logger logger4 = LOG;
            logger4.debug("coverage=" + ((int) readShort4));
            int readUnsignedShort = this.rf.readUnsignedShort();
            int[] iArr = new int[readUnsignedShort];
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                iArr[i2] = this.rf.readUnsignedShort();
            }
            List<Integer> readCoverageFormat = readCoverageFormat(i + readShort4);
            for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                this.rawLigatureSubstitutionMap.put(Integer.valueOf(iArr[i3]), Arrays.asList(readCoverageFormat.get(i3)));
            }
        } else {
            throw new IllegalArgumentException("Bad substFormat: " + ((int) readShort));
        }
    }

    private void readLigatureSubstitutionSubtable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("substFormat=" + ((int) readShort));
        if (readShort == 1) {
            short readShort2 = this.rf.readShort();
            Logger logger2 = LOG;
            logger2.debug("coverage=" + ((int) readShort2));
            short readShort3 = this.rf.readShort();
            ArrayList arrayList = new ArrayList(readShort3);
            for (int i2 = 0; i2 < readShort3; i2++) {
                arrayList.add(Integer.valueOf(this.rf.readShort()));
            }
            List<Integer> readCoverageFormat = readCoverageFormat(readShort2 + i);
            if (readShort3 == readCoverageFormat.size()) {
                for (int i3 = 0; i3 < readShort3; i3++) {
                    int intValue = readCoverageFormat.get(i3).intValue();
                    int intValue2 = ((Integer) arrayList.get(i3)).intValue();
                    Logger logger3 = LOG;
                    logger3.debug("ligatureOffset=" + intValue2);
                    readLigatureSetTable(intValue2 + i, intValue);
                }
                return;
            }
            throw new IllegalArgumentException("According to the OpenTypeFont specifications, the coverage count should be equal to the no. of LigatureSetTables");
        }
        throw new IllegalArgumentException("The expected SubstFormat is 1");
    }

    private void readLigatureSetTable(int i, int i2) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("ligatureCount=" + ((int) readShort));
        ArrayList<Integer> arrayList = new ArrayList(readShort);
        for (int i3 = 0; i3 < readShort; i3++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        for (Integer num : arrayList) {
            readLigatureTable(num.intValue() + i, i2);
        }
    }

    private void readLigatureTable(int i, int i2) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("ligGlyph=" + ((int) readShort));
        short readShort2 = this.rf.readShort();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i2));
        for (int i3 = 0; i3 < readShort2 - 1; i3++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        Logger logger2 = LOG;
        logger2.debug("glyphIdList=" + arrayList);
        List<Integer> put = this.rawLigatureSubstitutionMap.put(Integer.valueOf(readShort), arrayList);
        if (put != null) {
            Logger logger3 = LOG;
            logger3.warn("!!!!!!!!!!glyphId=" + ((int) readShort) + ",\npreviousValue=" + put + ",\ncurrentVal=" + arrayList);
        }
    }
}
