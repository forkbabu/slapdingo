package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class OpenTypeFontTableReader {
    protected static final Logger LOG = LoggerFactory.getLogger(OpenTypeFontTableReader.class);
    protected final RandomAccessFileOrArray rf;
    private List<String> supportedLanguages;
    protected final int tableLocation;

    /* access modifiers changed from: protected */
    public abstract void readSubTable(int i, int i2) throws IOException;

    public OpenTypeFontTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i) throws IOException {
        this.rf = randomAccessFileOrArray;
        this.tableLocation = i;
    }

    public Language getSupportedLanguage() throws FontReadingException {
        Language[] values = Language.values();
        for (String str : this.supportedLanguages) {
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Language language = values[i];
                    if (language.isSupported(str)) {
                        return language;
                    }
                    i++;
                }
            }
        }
        throw new FontReadingException("Unsupported languages " + this.supportedLanguages);
    }

    /* access modifiers changed from: protected */
    public final void startReadingTable() throws FontReadingException {
        try {
            TableHeader readHeader = readHeader();
            readScriptListTable(this.tableLocation + readHeader.scriptListOffset);
            readFeatureListTable(this.tableLocation + readHeader.featureListOffset);
            readLookupListTable(this.tableLocation + readHeader.lookupListOffset);
        } catch (IOException e) {
            throw new FontReadingException("Error reading font file", e);
        }
    }

    private void readLookupListTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readShort; i2++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        for (int i3 = 0; i3 < readShort; i3++) {
            readLookupTable(((Integer) arrayList.get(i3)).intValue() + i);
        }
    }

    private void readLookupTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        this.rf.skipBytes(2);
        short readShort2 = this.rf.readShort();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i2 = 0; i2 < readShort2; i2++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        for (Integer num : arrayList) {
            readSubTable(readShort, num.intValue() + i);
        }
    }

    /* access modifiers changed from: protected */
    public final List<Integer> readCoverageFormat(int i) throws IOException {
        ArrayList arrayList;
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        int i2 = 0;
        if (readShort == 1) {
            short readShort2 = this.rf.readShort();
            arrayList = new ArrayList(readShort2);
            while (i2 < readShort2) {
                arrayList.add(Integer.valueOf(this.rf.readShort()));
                i2++;
            }
        } else if (readShort == 2) {
            short readShort3 = this.rf.readShort();
            arrayList = new ArrayList();
            while (i2 < readShort3) {
                readRangeRecord(arrayList);
                i2++;
            }
        } else {
            throw new UnsupportedOperationException("Invalid coverage format: " + ((int) readShort));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private void readRangeRecord(List<Integer> list) throws IOException {
        short readShort = this.rf.readShort();
        this.rf.readShort();
        for (int readShort2 = this.rf.readShort(); readShort2 <= readShort; readShort2++) {
            list.add(Integer.valueOf(readShort2));
        }
    }

    private void readScriptListTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        HashMap hashMap = new HashMap(readShort);
        for (int i2 = 0; i2 < readShort; i2++) {
            readScriptRecord(i, hashMap);
        }
        ArrayList arrayList = new ArrayList(readShort);
        for (String str : hashMap.keySet()) {
            readScriptTable(hashMap.get(str).intValue());
            arrayList.add(str);
        }
        this.supportedLanguages = Collections.unmodifiableList(arrayList);
    }

    private void readScriptRecord(int i, Map<String, Integer> map) throws IOException {
        map.put(this.rf.readString(4, "utf-8"), Integer.valueOf(i + this.rf.readShort()));
    }

    private void readScriptTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        short readShort2 = this.rf.readShort();
        if (readShort2 > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(readShort2);
            for (int i2 = 0; i2 < readShort2; i2++) {
                readLangSysRecord(linkedHashMap);
            }
            for (String str : linkedHashMap.keySet()) {
                readLangSysTable(linkedHashMap.get(str).intValue() + i);
            }
        }
        readLangSysTable(i + readShort);
    }

    private void readLangSysRecord(Map<String, Integer> map) throws IOException {
        map.put(this.rf.readString(4, "utf-8"), Integer.valueOf(this.rf.readShort()));
    }

    private void readLangSysTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("lookupOrderOffset=" + ((int) readShort));
        short readShort2 = this.rf.readShort();
        Logger logger2 = LOG;
        logger2.debug("reqFeatureIndex=" + ((int) readShort2));
        short readShort3 = this.rf.readShort();
        ArrayList arrayList = new ArrayList(readShort3);
        for (int i2 = 0; i2 < readShort3; i2++) {
            arrayList.add(Short.valueOf(this.rf.readShort()));
        }
        Logger logger3 = LOG;
        logger3.debug("featureListIndices=" + arrayList);
    }

    private void readFeatureListTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("featureCount=" + ((int) readShort));
        LinkedHashMap linkedHashMap = new LinkedHashMap(readShort);
        for (int i2 = 0; i2 < readShort; i2++) {
            linkedHashMap.put(this.rf.readString(4, "utf-8"), Short.valueOf(this.rf.readShort()));
        }
        for (String str : linkedHashMap.keySet()) {
            Logger logger2 = LOG;
            logger2.debug("*************featureName=" + str);
            readFeatureTable(((Short) linkedHashMap.get(str)).shortValue() + i);
        }
    }

    private void readFeatureTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("featureParamsOffset=" + ((int) readShort));
        short readShort2 = this.rf.readShort();
        Logger logger2 = LOG;
        logger2.debug("lookupCount=" + ((int) readShort2));
        ArrayList arrayList = new ArrayList(readShort2);
        for (int i2 = 0; i2 < readShort2; i2++) {
            arrayList.add(Short.valueOf(this.rf.readShort()));
        }
    }

    private TableHeader readHeader() throws IOException {
        this.rf.seek((long) this.tableLocation);
        return new TableHeader(this.rf.readInt(), this.rf.readUnsignedShort(), this.rf.readUnsignedShort(), this.rf.readUnsignedShort());
    }
}
