package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GlyphPositioningTableReader extends OpenTypeFontTableReader {
    public GlyphPositioningTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i) throws IOException {
        super(randomAccessFileOrArray, i);
    }

    public void read() throws FontReadingException {
        startReadingTable();
    }

    /* access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.fonts.otf.OpenTypeFontTableReader
    public void readSubTable(int i, int i2) throws IOException {
        if (i == 1) {
            readLookUpType_1(i2);
        } else if (i == 4) {
            readLookUpType_4(i2);
        } else if (i == 8) {
            readLookUpType_8(i2);
        } else {
            PrintStream printStream = System.err;
            printStream.println("The lookupType " + i + " is not yet supported by " + GlyphPositioningTableReader.class.getSimpleName());
        }
    }

    private void readLookUpType_1(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        if (readShort == 1) {
            LOG.debug("Reading `Look Up Type 1, Format 1` ....");
            short readShort2 = this.rf.readShort();
            short readShort3 = this.rf.readShort();
            if ((readShort3 & 1) == 1) {
                short readShort4 = this.rf.readShort();
                Logger logger = LOG;
                logger.debug("xPlacement=" + ((int) readShort4));
            }
            if ((readShort3 & 2) == 2) {
                short readShort5 = this.rf.readShort();
                Logger logger2 = LOG;
                logger2.debug("yPlacement=" + ((int) readShort5));
            }
            List<Integer> readCoverageFormat = readCoverageFormat(i + readShort2);
            Logger logger3 = LOG;
            logger3.debug("glyphCodes=" + readCoverageFormat);
            return;
        }
        PrintStream printStream = System.err;
        printStream.println("The PosFormat " + ((int) readShort) + " for `LookupType 1` is not yet supported by " + GlyphPositioningTableReader.class.getSimpleName());
    }

    private void readLookUpType_4(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        if (readShort == 1) {
            LOG.debug("Reading `Look Up Type 4, Format 1` ....");
            short readShort2 = this.rf.readShort();
            short readShort3 = this.rf.readShort();
            short readShort4 = this.rf.readShort();
            short readShort5 = this.rf.readShort();
            short readShort6 = this.rf.readShort();
            List<Integer> readCoverageFormat = readCoverageFormat(readShort2 + i);
            Logger logger = LOG;
            logger.debug("markCoverages=" + readCoverageFormat);
            List<Integer> readCoverageFormat2 = readCoverageFormat(readShort3 + i);
            Logger logger2 = LOG;
            logger2.debug("baseCoverages=" + readCoverageFormat2);
            readMarkArrayTable(readShort5 + i);
            readBaseArrayTable(i + readShort6, readShort4);
            return;
        }
        PrintStream printStream = System.err;
        printStream.println("The posFormat " + ((int) readShort) + " is not supported by " + GlyphPositioningTableReader.class.getSimpleName());
    }

    private void readLookUpType_8(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        if (readShort == 3) {
            LOG.debug("Reading `Look Up Type 8, Format 3` ....");
            readChainingContextPositioningFormat_3(i);
            return;
        }
        PrintStream printStream = System.err;
        printStream.println("The posFormat " + ((int) readShort) + " for `Look Up Type 8` is not supported by " + GlyphPositioningTableReader.class.getSimpleName());
    }

    private void readChainingContextPositioningFormat_3(int i) throws IOException {
        short readShort = this.rf.readShort();
        Logger logger = LOG;
        logger.debug("backtrackGlyphCount=" + ((int) readShort));
        ArrayList<Integer> arrayList = new ArrayList(readShort);
        for (int i2 = 0; i2 < readShort; i2++) {
            arrayList.add(Integer.valueOf(this.rf.readShort()));
        }
        short readShort2 = this.rf.readShort();
        Logger logger2 = LOG;
        logger2.debug("inputGlyphCount=" + ((int) readShort2));
        ArrayList<Integer> arrayList2 = new ArrayList(readShort2);
        for (int i3 = 0; i3 < readShort2; i3++) {
            arrayList2.add(Integer.valueOf(this.rf.readShort()));
        }
        short readShort3 = this.rf.readShort();
        Logger logger3 = LOG;
        logger3.debug("lookaheadGlyphCount=" + ((int) readShort3));
        ArrayList<Integer> arrayList3 = new ArrayList(readShort3);
        for (int i4 = 0; i4 < readShort3; i4++) {
            arrayList3.add(Integer.valueOf(this.rf.readShort()));
        }
        short readShort4 = this.rf.readShort();
        Logger logger4 = LOG;
        logger4.debug("posCount=" + ((int) readShort4));
        ArrayList arrayList4 = new ArrayList(readShort4);
        for (int i5 = 0; i5 < readShort4; i5++) {
            short readShort5 = this.rf.readShort();
            short readShort6 = this.rf.readShort();
            Logger logger5 = LOG;
            logger5.debug("sequenceIndex=" + ((int) readShort5) + ", lookupListIndex=" + ((int) readShort6));
            arrayList4.add(new PosLookupRecord(readShort5, readShort6));
        }
        for (Integer num : arrayList) {
            List<Integer> readCoverageFormat = readCoverageFormat(num.intValue() + i);
            Logger logger6 = LOG;
            logger6.debug("backtrackGlyphs=" + readCoverageFormat);
        }
        for (Integer num2 : arrayList2) {
            List<Integer> readCoverageFormat2 = readCoverageFormat(num2.intValue() + i);
            Logger logger7 = LOG;
            logger7.debug("inputGlyphs=" + readCoverageFormat2);
        }
        for (Integer num3 : arrayList3) {
            List<Integer> readCoverageFormat3 = readCoverageFormat(num3.intValue() + i);
            Logger logger8 = LOG;
            logger8.debug("lookaheadGlyphs=" + readCoverageFormat3);
        }
    }

    private void readMarkArrayTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        ArrayList<MarkRecord> arrayList = new ArrayList();
        for (int i2 = 0; i2 < readShort; i2++) {
            arrayList.add(readMarkRecord());
        }
        for (MarkRecord markRecord : arrayList) {
            readAnchorTable(markRecord.markAnchorOffset + i);
        }
    }

    private MarkRecord readMarkRecord() throws IOException {
        return new MarkRecord(this.rf.readShort(), this.rf.readShort());
    }

    private void readAnchorTable(int i) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        if (readShort != 1) {
            PrintStream printStream = System.err;
            printStream.println("The extra features of the AnchorFormat " + ((int) readShort) + " will not be used");
        }
        this.rf.readShort();
        this.rf.readShort();
    }

    private void readBaseArrayTable(int i, int i2) throws IOException {
        this.rf.seek((long) i);
        short readShort = this.rf.readShort();
        HashSet<Integer> hashSet = new HashSet();
        for (int i3 = 0; i3 < readShort; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                hashSet.add(Integer.valueOf(this.rf.readShort()));
            }
        }
        for (Integer num : hashSet) {
            readAnchorTable(num.intValue() + i);
        }
    }

    static class MarkRecord {
        final int markAnchorOffset;
        final int markClass;

        public MarkRecord(int i, int i2) {
            this.markClass = i;
            this.markAnchorOffset = i2;
        }
    }

    static class PosLookupRecord {
        final int lookupListIndex;
        final int sequenceIndex;

        public PosLookupRecord(int i, int i2) {
            this.sequenceIndex = i;
            this.lookupListIndex = i2;
        }
    }
}
