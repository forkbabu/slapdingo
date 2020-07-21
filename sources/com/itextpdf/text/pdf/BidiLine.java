package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.languages.ArabicLigaturizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

public class BidiLine {
    protected static final IntHashtable mirrorChars;
    protected int arabicOptions;
    protected ArrayList<PdfChunk> chunks;
    protected int currentChar;
    protected PdfChunk[] detailChunks;
    protected int[] indexChars;
    protected int indexChunk;
    protected int indexChunkChar;
    protected boolean isWordSplit;
    protected byte[] orderLevels;
    protected int pieceSize;
    protected int runDirection;
    protected boolean shortStore;
    protected int storedCurrentChar;
    protected PdfChunk[] storedDetailChunks;
    protected int[] storedIndexChars;
    protected int storedIndexChunk;
    protected int storedIndexChunkChar;
    protected byte[] storedOrderLevels;
    protected int storedRunDirection;
    protected char[] storedText;
    protected int storedTotalTextLength;
    protected char[] text;
    protected int totalTextLength;

    public static boolean isWS(char c) {
        return c <= ' ';
    }

    static {
        IntHashtable intHashtable = new IntHashtable();
        mirrorChars = intHashtable;
        intHashtable.put(40, 41);
        mirrorChars.put(41, 40);
        mirrorChars.put(60, 62);
        mirrorChars.put(62, 60);
        mirrorChars.put(91, 93);
        mirrorChars.put(93, 91);
        mirrorChars.put(123, 125);
        mirrorChars.put(125, 123);
        mirrorChars.put(CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256);
        mirrorChars.put(CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384);
        mirrorChars.put(8249, 8250);
        mirrorChars.put(8250, 8249);
        mirrorChars.put(8261, 8262);
        mirrorChars.put(8262, 8261);
        mirrorChars.put(8317, 8318);
        mirrorChars.put(8318, 8317);
        mirrorChars.put(8333, 8334);
        mirrorChars.put(8334, 8333);
        mirrorChars.put(8712, 8715);
        mirrorChars.put(8713, 8716);
        mirrorChars.put(8714, 8717);
        mirrorChars.put(8715, 8712);
        mirrorChars.put(8716, 8713);
        mirrorChars.put(8717, 8714);
        mirrorChars.put(8725, 10741);
        mirrorChars.put(8764, 8765);
        mirrorChars.put(8765, 8764);
        mirrorChars.put(8771, 8909);
        mirrorChars.put(8786, 8787);
        mirrorChars.put(8787, 8786);
        mirrorChars.put(8788, 8789);
        mirrorChars.put(8789, 8788);
        mirrorChars.put(8804, 8805);
        mirrorChars.put(8805, 8804);
        mirrorChars.put(8806, 8807);
        mirrorChars.put(8807, 8806);
        mirrorChars.put(8808, 8809);
        mirrorChars.put(8809, 8808);
        mirrorChars.put(8810, 8811);
        mirrorChars.put(8811, 8810);
        mirrorChars.put(8814, 8815);
        mirrorChars.put(8815, 8814);
        mirrorChars.put(8816, 8817);
        mirrorChars.put(8817, 8816);
        mirrorChars.put(8818, 8819);
        mirrorChars.put(8819, 8818);
        mirrorChars.put(8820, 8821);
        mirrorChars.put(8821, 8820);
        mirrorChars.put(8822, 8823);
        mirrorChars.put(8823, 8822);
        mirrorChars.put(8824, 8825);
        mirrorChars.put(8825, 8824);
        mirrorChars.put(8826, 8827);
        mirrorChars.put(8827, 8826);
        mirrorChars.put(8828, 8829);
        mirrorChars.put(8829, 8828);
        mirrorChars.put(8830, 8831);
        mirrorChars.put(8831, 8830);
        mirrorChars.put(8832, 8833);
        mirrorChars.put(8833, 8832);
        mirrorChars.put(8834, 8835);
        mirrorChars.put(8835, 8834);
        mirrorChars.put(8836, 8837);
        mirrorChars.put(8837, 8836);
        mirrorChars.put(8838, 8839);
        mirrorChars.put(8839, 8838);
        mirrorChars.put(8840, 8841);
        mirrorChars.put(8841, 8840);
        mirrorChars.put(8842, 8843);
        mirrorChars.put(8843, 8842);
        mirrorChars.put(8847, 8848);
        mirrorChars.put(8848, 8847);
        mirrorChars.put(8849, 8850);
        mirrorChars.put(8850, 8849);
        mirrorChars.put(8856, 10680);
        mirrorChars.put(8866, 8867);
        mirrorChars.put(8867, 8866);
        mirrorChars.put(8870, 10974);
        mirrorChars.put(8872, 10980);
        mirrorChars.put(8873, 10979);
        mirrorChars.put(8875, 10981);
        mirrorChars.put(8880, 8881);
        mirrorChars.put(8881, 8880);
        mirrorChars.put(8882, 8883);
        mirrorChars.put(8883, 8882);
        mirrorChars.put(8884, 8885);
        mirrorChars.put(8885, 8884);
        mirrorChars.put(8886, 8887);
        mirrorChars.put(8887, 8886);
        mirrorChars.put(8905, 8906);
        mirrorChars.put(8906, 8905);
        mirrorChars.put(8907, 8908);
        mirrorChars.put(8908, 8907);
        mirrorChars.put(8909, 8771);
        mirrorChars.put(8912, 8913);
        mirrorChars.put(8913, 8912);
        mirrorChars.put(8918, 8919);
        mirrorChars.put(8919, 8918);
        mirrorChars.put(8920, 8921);
        mirrorChars.put(8921, 8920);
        mirrorChars.put(8922, 8923);
        mirrorChars.put(8923, 8922);
        mirrorChars.put(8924, 8925);
        mirrorChars.put(8925, 8924);
        mirrorChars.put(8926, 8927);
        mirrorChars.put(8927, 8926);
        mirrorChars.put(8928, 8929);
        mirrorChars.put(8929, 8928);
        mirrorChars.put(8930, 8931);
        mirrorChars.put(8931, 8930);
        mirrorChars.put(8932, 8933);
        mirrorChars.put(8933, 8932);
        mirrorChars.put(8934, 8935);
        mirrorChars.put(8935, 8934);
        mirrorChars.put(8936, 8937);
        mirrorChars.put(8937, 8936);
        mirrorChars.put(8938, 8939);
        mirrorChars.put(8939, 8938);
        mirrorChars.put(8940, 8941);
        mirrorChars.put(8941, 8940);
        mirrorChars.put(8944, 8945);
        mirrorChars.put(8945, 8944);
        mirrorChars.put(8946, 8954);
        mirrorChars.put(8947, 8955);
        mirrorChars.put(8948, 8956);
        mirrorChars.put(8950, 8957);
        mirrorChars.put(8951, 8958);
        mirrorChars.put(8954, 8946);
        mirrorChars.put(8955, 8947);
        mirrorChars.put(8956, 8948);
        mirrorChars.put(8957, 8950);
        mirrorChars.put(8958, 8951);
        mirrorChars.put(8968, 8969);
        mirrorChars.put(8969, 8968);
        mirrorChars.put(8970, 8971);
        mirrorChars.put(8971, 8970);
        mirrorChars.put(9001, 9002);
        mirrorChars.put(9002, 9001);
        mirrorChars.put(10088, 10089);
        mirrorChars.put(10089, 10088);
        mirrorChars.put(10090, 10091);
        mirrorChars.put(10091, 10090);
        mirrorChars.put(10092, 10093);
        mirrorChars.put(10093, 10092);
        mirrorChars.put(10094, 10095);
        mirrorChars.put(10095, 10094);
        mirrorChars.put(10096, 10097);
        mirrorChars.put(10097, 10096);
        mirrorChars.put(10098, 10099);
        mirrorChars.put(10099, 10098);
        mirrorChars.put(10100, 10101);
        mirrorChars.put(10101, 10100);
        mirrorChars.put(10197, 10198);
        mirrorChars.put(10198, 10197);
        mirrorChars.put(10205, 10206);
        mirrorChars.put(10206, 10205);
        mirrorChars.put(10210, 10211);
        mirrorChars.put(10211, 10210);
        mirrorChars.put(10212, 10213);
        mirrorChars.put(10213, 10212);
        mirrorChars.put(10214, 10215);
        mirrorChars.put(10215, 10214);
        mirrorChars.put(10216, 10217);
        mirrorChars.put(10217, 10216);
        mirrorChars.put(10218, 10219);
        mirrorChars.put(10219, 10218);
        mirrorChars.put(10627, 10628);
        mirrorChars.put(10628, 10627);
        mirrorChars.put(10629, 10630);
        mirrorChars.put(10630, 10629);
        mirrorChars.put(10631, 10632);
        mirrorChars.put(10632, 10631);
        mirrorChars.put(10633, 10634);
        mirrorChars.put(10634, 10633);
        mirrorChars.put(10635, 10636);
        mirrorChars.put(10636, 10635);
        mirrorChars.put(10637, 10640);
        mirrorChars.put(10638, 10639);
        mirrorChars.put(10639, 10638);
        mirrorChars.put(10640, 10637);
        mirrorChars.put(10641, 10642);
        mirrorChars.put(10642, 10641);
        mirrorChars.put(10643, 10644);
        mirrorChars.put(10644, 10643);
        mirrorChars.put(10645, 10646);
        mirrorChars.put(10646, 10645);
        mirrorChars.put(10647, 10648);
        mirrorChars.put(10648, 10647);
        mirrorChars.put(10680, 8856);
        mirrorChars.put(10688, 10689);
        mirrorChars.put(10689, 10688);
        mirrorChars.put(10692, 10693);
        mirrorChars.put(10693, 10692);
        mirrorChars.put(10703, 10704);
        mirrorChars.put(10704, 10703);
        mirrorChars.put(10705, 10706);
        mirrorChars.put(10706, 10705);
        mirrorChars.put(10708, 10709);
        mirrorChars.put(10709, 10708);
        mirrorChars.put(10712, 10713);
        mirrorChars.put(10713, 10712);
        mirrorChars.put(10714, 10715);
        mirrorChars.put(10715, 10714);
        mirrorChars.put(10741, 8725);
        mirrorChars.put(10744, 10745);
        mirrorChars.put(10745, 10744);
        mirrorChars.put(10748, 10749);
        mirrorChars.put(10749, 10748);
        mirrorChars.put(10795, 10796);
        mirrorChars.put(10796, 10795);
        mirrorChars.put(10797, 10796);
        mirrorChars.put(10798, 10797);
        mirrorChars.put(10804, 10805);
        mirrorChars.put(10805, 10804);
        mirrorChars.put(10812, 10813);
        mirrorChars.put(10813, 10812);
        mirrorChars.put(10852, 10853);
        mirrorChars.put(10853, 10852);
        mirrorChars.put(10873, 10874);
        mirrorChars.put(10874, 10873);
        mirrorChars.put(10877, 10878);
        mirrorChars.put(10878, 10877);
        mirrorChars.put(10879, 10880);
        mirrorChars.put(10880, 10879);
        mirrorChars.put(10881, 10882);
        mirrorChars.put(10882, 10881);
        mirrorChars.put(10883, 10884);
        mirrorChars.put(10884, 10883);
        mirrorChars.put(10891, 10892);
        mirrorChars.put(10892, 10891);
        mirrorChars.put(10897, 10898);
        mirrorChars.put(10898, 10897);
        mirrorChars.put(10899, 10900);
        mirrorChars.put(10900, 10899);
        mirrorChars.put(10901, 10902);
        mirrorChars.put(10902, 10901);
        mirrorChars.put(10903, 10904);
        mirrorChars.put(10904, 10903);
        mirrorChars.put(10905, 10906);
        mirrorChars.put(10906, 10905);
        mirrorChars.put(10907, 10908);
        mirrorChars.put(10908, 10907);
        mirrorChars.put(10913, 10914);
        mirrorChars.put(10914, 10913);
        mirrorChars.put(10918, 10919);
        mirrorChars.put(10919, 10918);
        mirrorChars.put(10920, 10921);
        mirrorChars.put(10921, 10920);
        mirrorChars.put(10922, 10923);
        mirrorChars.put(10923, 10922);
        mirrorChars.put(10924, 10925);
        mirrorChars.put(10925, 10924);
        mirrorChars.put(10927, 10928);
        mirrorChars.put(10928, 10927);
        mirrorChars.put(10931, 10932);
        mirrorChars.put(10932, 10931);
        mirrorChars.put(10939, 10940);
        mirrorChars.put(10940, 10939);
        mirrorChars.put(10941, 10942);
        mirrorChars.put(10942, 10941);
        mirrorChars.put(10943, 10944);
        mirrorChars.put(10944, 10943);
        mirrorChars.put(10945, 10946);
        mirrorChars.put(10946, 10945);
        mirrorChars.put(10947, 10948);
        mirrorChars.put(10948, 10947);
        mirrorChars.put(10949, 10950);
        mirrorChars.put(10950, 10949);
        mirrorChars.put(10957, 10958);
        mirrorChars.put(10958, 10957);
        mirrorChars.put(10959, 10960);
        mirrorChars.put(10960, 10959);
        mirrorChars.put(10961, 10962);
        mirrorChars.put(10962, 10961);
        mirrorChars.put(10963, 10964);
        mirrorChars.put(10964, 10963);
        mirrorChars.put(10965, 10966);
        mirrorChars.put(10966, 10965);
        mirrorChars.put(10974, 8870);
        mirrorChars.put(10979, 8873);
        mirrorChars.put(10980, 8872);
        mirrorChars.put(10981, 8875);
        mirrorChars.put(10988, 10989);
        mirrorChars.put(10989, 10988);
        mirrorChars.put(10999, 11000);
        mirrorChars.put(11000, 10999);
        mirrorChars.put(11001, 11002);
        mirrorChars.put(11002, 11001);
        mirrorChars.put(12296, 12297);
        mirrorChars.put(12297, 12296);
        mirrorChars.put(12298, 12299);
        mirrorChars.put(12299, 12298);
        mirrorChars.put(12300, 12301);
        mirrorChars.put(12301, 12300);
        mirrorChars.put(12302, 12303);
        mirrorChars.put(12303, 12302);
        mirrorChars.put(12304, 12305);
        mirrorChars.put(12305, 12304);
        mirrorChars.put(12308, 12309);
        mirrorChars.put(12309, 12308);
        mirrorChars.put(12310, 12311);
        mirrorChars.put(12311, 12310);
        mirrorChars.put(12312, 12313);
        mirrorChars.put(12313, 12312);
        mirrorChars.put(12314, 12315);
        mirrorChars.put(12315, 12314);
        mirrorChars.put(65288, 65289);
        mirrorChars.put(65289, 65288);
        mirrorChars.put(65308, 65310);
        mirrorChars.put(65310, 65308);
        mirrorChars.put(65339, 65341);
        mirrorChars.put(65341, 65339);
        mirrorChars.put(65371, 65373);
        mirrorChars.put(65373, 65371);
        mirrorChars.put(65375, 65376);
        mirrorChars.put(65376, 65375);
        mirrorChars.put(65378, 65379);
        mirrorChars.put(65379, 65378);
    }

    public BidiLine() {
        this.pieceSize = 256;
        this.text = new char[256];
        this.detailChunks = new PdfChunk[256];
        this.totalTextLength = 0;
        this.orderLevels = new byte[256];
        this.indexChars = new int[256];
        this.chunks = new ArrayList<>();
        this.indexChunk = 0;
        this.indexChunkChar = 0;
        this.currentChar = 0;
        this.storedText = new char[0];
        this.storedDetailChunks = new PdfChunk[0];
        this.storedTotalTextLength = 0;
        this.storedOrderLevels = new byte[0];
        this.storedIndexChars = new int[0];
        this.storedIndexChunk = 0;
        this.storedIndexChunkChar = 0;
        this.storedCurrentChar = 0;
        this.isWordSplit = false;
    }

    public BidiLine(BidiLine bidiLine) {
        this.pieceSize = 256;
        this.text = new char[256];
        this.detailChunks = new PdfChunk[256];
        this.totalTextLength = 0;
        this.orderLevels = new byte[256];
        this.indexChars = new int[256];
        this.chunks = new ArrayList<>();
        this.indexChunk = 0;
        this.indexChunkChar = 0;
        this.currentChar = 0;
        this.storedText = new char[0];
        this.storedDetailChunks = new PdfChunk[0];
        this.storedTotalTextLength = 0;
        this.storedOrderLevels = new byte[0];
        this.storedIndexChars = new int[0];
        this.storedIndexChunk = 0;
        this.storedIndexChunkChar = 0;
        this.storedCurrentChar = 0;
        this.isWordSplit = false;
        this.runDirection = bidiLine.runDirection;
        this.pieceSize = bidiLine.pieceSize;
        this.text = (char[]) bidiLine.text.clone();
        this.detailChunks = (PdfChunk[]) bidiLine.detailChunks.clone();
        this.totalTextLength = bidiLine.totalTextLength;
        this.orderLevels = (byte[]) bidiLine.orderLevels.clone();
        this.indexChars = (int[]) bidiLine.indexChars.clone();
        this.chunks = new ArrayList<>(bidiLine.chunks);
        this.indexChunk = bidiLine.indexChunk;
        this.indexChunkChar = bidiLine.indexChunkChar;
        this.currentChar = bidiLine.currentChar;
        this.storedRunDirection = bidiLine.storedRunDirection;
        this.storedText = (char[]) bidiLine.storedText.clone();
        this.storedDetailChunks = (PdfChunk[]) bidiLine.storedDetailChunks.clone();
        this.storedTotalTextLength = bidiLine.storedTotalTextLength;
        this.storedOrderLevels = (byte[]) bidiLine.storedOrderLevels.clone();
        this.storedIndexChars = (int[]) bidiLine.storedIndexChars.clone();
        this.storedIndexChunk = bidiLine.storedIndexChunk;
        this.storedIndexChunkChar = bidiLine.storedIndexChunkChar;
        this.storedCurrentChar = bidiLine.storedCurrentChar;
        this.shortStore = bidiLine.shortStore;
        this.arabicOptions = bidiLine.arabicOptions;
    }

    public boolean isEmpty() {
        return this.currentChar >= this.totalTextLength && this.indexChunk >= this.chunks.size();
    }

    public void clearChunks() {
        this.chunks.clear();
        this.totalTextLength = 0;
        this.currentChar = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0061, code lost:
        r1 = r11.indexChunkChar + 1;
        r11.indexChunkChar = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (r1 < r6) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r11.indexChunkChar = 0;
        r11.indexChunk++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        if (r11.totalTextLength != 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r11.detailChunks[0] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getParagraph(int r12) {
        /*
            r11 = this;
            r11.runDirection = r12
            r0 = 0
            r11.currentChar = r0
            r11.totalTextLength = r0
            r1 = 0
        L_0x0008:
            int r2 = r11.indexChunk
            java.util.ArrayList<com.itextpdf.text.pdf.PdfChunk> r3 = r11.chunks
            int r3 = r3.size()
            r4 = 1
            if (r2 >= r3) goto L_0x0083
            java.util.ArrayList<com.itextpdf.text.pdf.PdfChunk> r2 = r11.chunks
            int r3 = r11.indexChunk
            java.lang.Object r2 = r2.get(r3)
            com.itextpdf.text.pdf.PdfChunk r2 = (com.itextpdf.text.pdf.PdfChunk) r2
            com.itextpdf.text.pdf.PdfFont r3 = r2.font()
            com.itextpdf.text.pdf.BaseFont r3 = r3.getFont()
            java.lang.String r5 = r2.toString()
            int r6 = r5.length()
        L_0x002d:
            int r7 = r11.indexChunkChar
            if (r7 >= r6) goto L_0x0078
            char r7 = r5.charAt(r7)
            int r8 = r3.getUnicodeEquivalent(r7)
            char r8 = (char) r8
            r9 = 10
            r10 = 13
            if (r8 == r10) goto L_0x004c
            if (r8 != r9) goto L_0x0043
            goto L_0x004c
        L_0x0043:
            r11.addPiece(r7, r2)
            int r7 = r11.indexChunkChar
            int r7 = r7 + r4
            r11.indexChunkChar = r7
            goto L_0x002d
        L_0x004c:
            if (r8 != r10) goto L_0x0061
            int r1 = r11.indexChunkChar
            int r3 = r1 + 1
            if (r3 >= r6) goto L_0x0061
            int r1 = r1 + 1
            char r1 = r5.charAt(r1)
            if (r1 != r9) goto L_0x0061
            int r1 = r11.indexChunkChar
            int r1 = r1 + r4
            r11.indexChunkChar = r1
        L_0x0061:
            int r1 = r11.indexChunkChar
            int r1 = r1 + r4
            r11.indexChunkChar = r1
            if (r1 < r6) goto L_0x006f
            r11.indexChunkChar = r0
            int r1 = r11.indexChunk
            int r1 = r1 + r4
            r11.indexChunk = r1
        L_0x006f:
            int r1 = r11.totalTextLength
            if (r1 != 0) goto L_0x0077
            com.itextpdf.text.pdf.PdfChunk[] r1 = r11.detailChunks
            r1[r0] = r2
        L_0x0077:
            r1 = 1
        L_0x0078:
            if (r1 == 0) goto L_0x007b
            goto L_0x0083
        L_0x007b:
            r11.indexChunkChar = r0
            int r2 = r11.indexChunk
            int r2 = r2 + r4
            r11.indexChunk = r2
            goto L_0x0008
        L_0x0083:
            int r2 = r11.totalTextLength
            if (r2 != 0) goto L_0x0088
            return r1
        L_0x0088:
            int r2 = r2 - r4
            int r1 = r11.trimRight(r0, r2)
            int r1 = r1 + r4
            r11.totalTextLength = r1
            if (r1 != 0) goto L_0x0093
            return r4
        L_0x0093:
            if (r12 == r4) goto L_0x00dd
            byte[] r2 = r11.orderLevels
            int r2 = r2.length
            if (r2 >= r1) goto L_0x00a4
            int r1 = r11.pieceSize
            byte[] r2 = new byte[r1]
            r11.orderLevels = r2
            int[] r1 = new int[r1]
            r11.indexChars = r1
        L_0x00a4:
            char[] r1 = r11.text
            int r2 = r11.totalTextLength
            int r3 = r11.arabicOptions
            com.itextpdf.text.pdf.languages.ArabicLigaturizer.processNumbers(r1, r0, r2, r3)
            r1 = 2
            if (r12 == r1) goto L_0x00b7
            r1 = 3
            if (r12 == r1) goto L_0x00b5
            r12 = -1
            goto L_0x00b8
        L_0x00b5:
            r12 = 1
            goto L_0x00b8
        L_0x00b7:
            r12 = 0
        L_0x00b8:
            com.itextpdf.text.pdf.BidiOrder r1 = new com.itextpdf.text.pdf.BidiOrder
            char[] r2 = r11.text
            int r3 = r11.totalTextLength
            r1.<init>(r2, r0, r3, r12)
            byte[] r12 = r1.getLevels()
            r1 = 0
        L_0x00c6:
            int r2 = r11.totalTextLength
            if (r1 >= r2) goto L_0x00d7
            byte[] r2 = r11.orderLevels
            byte r3 = r12[r1]
            r2[r1] = r3
            int[] r2 = r11.indexChars
            r2[r1] = r1
            int r1 = r1 + 1
            goto L_0x00c6
        L_0x00d7:
            r11.doArabicShapping()
            r11.mirrorGlyphs()
        L_0x00dd:
            int r12 = r11.totalTextLength
            int r12 = r12 - r4
            int r12 = r11.trimRightEx(r0, r12)
            int r12 = r12 + r4
            r11.totalTextLength = r12
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BidiLine.getParagraph(int):boolean");
    }

    public void addChunk(PdfChunk pdfChunk) {
        this.chunks.add(pdfChunk);
    }

    public void addChunks(ArrayList<PdfChunk> arrayList) {
        this.chunks.addAll(arrayList);
    }

    public void addPiece(char c, PdfChunk pdfChunk) {
        int i = this.totalTextLength;
        int i2 = this.pieceSize;
        if (i >= i2) {
            char[] cArr = this.text;
            PdfChunk[] pdfChunkArr = this.detailChunks;
            int i3 = i2 * 2;
            this.pieceSize = i3;
            char[] cArr2 = new char[i3];
            this.text = cArr2;
            this.detailChunks = new PdfChunk[i3];
            System.arraycopy(cArr, 0, cArr2, 0, i);
            System.arraycopy(pdfChunkArr, 0, this.detailChunks, 0, this.totalTextLength);
        }
        char[] cArr3 = this.text;
        int i4 = this.totalTextLength;
        cArr3[i4] = c;
        PdfChunk[] pdfChunkArr2 = this.detailChunks;
        this.totalTextLength = i4 + 1;
        pdfChunkArr2[i4] = pdfChunk;
    }

    public void save() {
        int i = this.indexChunk;
        if (i > 0) {
            if (i < this.chunks.size()) {
                while (true) {
                    this.indexChunk--;
                    int i2 = this.indexChunk;
                    if (i2 < 0) {
                        break;
                    }
                    this.chunks.remove(i2);
                }
            } else {
                this.chunks.clear();
            }
            this.indexChunk = 0;
        }
        this.storedRunDirection = this.runDirection;
        int i3 = this.totalTextLength;
        this.storedTotalTextLength = i3;
        this.storedIndexChunk = this.indexChunk;
        this.storedIndexChunkChar = this.indexChunkChar;
        int i4 = this.currentChar;
        this.storedCurrentChar = i4;
        boolean z = i4 < i3;
        this.shortStore = z;
        if (!z) {
            int length = this.storedText.length;
            int i5 = this.totalTextLength;
            if (length < i5) {
                this.storedText = new char[i5];
                this.storedDetailChunks = new PdfChunk[i5];
            }
            System.arraycopy(this.text, 0, this.storedText, 0, this.totalTextLength);
            System.arraycopy(this.detailChunks, 0, this.storedDetailChunks, 0, this.totalTextLength);
        }
        if (this.runDirection != 1) {
            int length2 = this.storedOrderLevels.length;
            int i6 = this.totalTextLength;
            if (length2 < i6) {
                this.storedOrderLevels = new byte[i6];
                this.storedIndexChars = new int[i6];
            }
            byte[] bArr = this.orderLevels;
            int i7 = this.currentChar;
            System.arraycopy(bArr, i7, this.storedOrderLevels, i7, this.totalTextLength - i7);
            int[] iArr = this.indexChars;
            int i8 = this.currentChar;
            System.arraycopy(iArr, i8, this.storedIndexChars, i8, this.totalTextLength - i8);
        }
    }

    public void restore() {
        this.runDirection = this.storedRunDirection;
        int i = this.storedTotalTextLength;
        this.totalTextLength = i;
        this.indexChunk = this.storedIndexChunk;
        this.indexChunkChar = this.storedIndexChunkChar;
        this.currentChar = this.storedCurrentChar;
        if (!this.shortStore) {
            System.arraycopy(this.storedText, 0, this.text, 0, i);
            System.arraycopy(this.storedDetailChunks, 0, this.detailChunks, 0, this.totalTextLength);
        }
        if (this.runDirection != 1) {
            byte[] bArr = this.storedOrderLevels;
            int i2 = this.currentChar;
            System.arraycopy(bArr, i2, this.orderLevels, i2, this.totalTextLength - i2);
            int[] iArr = this.storedIndexChars;
            int i3 = this.currentChar;
            System.arraycopy(iArr, i3, this.indexChars, i3, this.totalTextLength - i3);
        }
    }

    public void mirrorGlyphs() {
        int i;
        for (int i2 = 0; i2 < this.totalTextLength; i2++) {
            if ((this.orderLevels[i2] & 1) == 1 && (i = mirrorChars.get(this.text[i2])) != 0) {
                this.text[i2] = (char) i;
            }
        }
    }

    public void doArabicShapping() {
        char c;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i < this.totalTextLength && ((c = this.text[i]) < 1536 || c > 1791)) {
                if (i != i2) {
                    char[] cArr = this.text;
                    cArr[i2] = cArr[i];
                    PdfChunk[] pdfChunkArr = this.detailChunks;
                    pdfChunkArr[i2] = pdfChunkArr[i];
                    byte[] bArr = this.orderLevels;
                    bArr[i2] = bArr[i];
                }
                i++;
                i2++;
            } else if (i >= this.totalTextLength) {
                this.totalTextLength = i2;
                return;
            } else {
                int i3 = i + 1;
                while (i3 < this.totalTextLength && (r1 = this.text[i3]) >= 1536 && r1 <= 1791) {
                    i3++;
                }
                int i4 = i3 - i;
                char[] cArr2 = this.text;
                int arabic_shape = ArabicLigaturizer.arabic_shape(cArr2, i, i4, cArr2, i2, i4, this.arabicOptions);
                if (i != i2) {
                    int i5 = 0;
                    while (i5 < arabic_shape) {
                        PdfChunk[] pdfChunkArr2 = this.detailChunks;
                        pdfChunkArr2[i2] = pdfChunkArr2[i];
                        byte[] bArr2 = this.orderLevels;
                        bArr2[i2] = bArr2[i];
                        i5++;
                        i2++;
                        i++;
                    }
                } else {
                    i2 += arabic_shape;
                }
                i = i3;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfLine processLine(float r27, float r28, int r29, int r30, int r31, float r32, float r33, float r34) {
        /*
            r26 = this;
            r8 = r26
            r9 = r28
            r0 = r30
            r10 = 0
            r8.isWordSplit = r10
            r1 = r31
            r8.arabicOptions = r1
            r26.save()
            r11 = 1
            r1 = 3
            if (r0 != r1) goto L_0x0016
            r12 = 1
            goto L_0x0017
        L_0x0016:
            r12 = 0
        L_0x0017:
            int r1 = r8.currentChar
            int r2 = r8.totalTextLength
            r13 = 0
            if (r1 < r2) goto L_0x004b
            boolean r0 = r8.getParagraph(r0)
            if (r0 != 0) goto L_0x0025
            return r13
        L_0x0025:
            int r0 = r8.totalTextLength
            if (r0 != 0) goto L_0x004b
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.itextpdf.text.pdf.PdfChunk r0 = new com.itextpdf.text.pdf.PdfChunk
            com.itextpdf.text.pdf.PdfChunk[] r1 = r8.detailChunks
            r1 = r1[r10]
            java.lang.String r2 = ""
            r0.<init>(r2, r1)
            r6.add(r0)
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            r1 = 0
            r2 = 0
            r5 = 1
            r0 = r10
            r3 = r28
            r4 = r29
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x004b:
            int r0 = r8.currentChar
            if (r0 == 0) goto L_0x0058
            int r1 = r8.totalTextLength
            int r1 = r1 - r11
            int r0 = r8.trimLeftEx(r0, r1)
            r8.currentChar = r0
        L_0x0058:
            int r14 = r8.currentChar
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r7 = -1
            r16 = 2143289344(0x7fc00000, float:NaN)
            r19 = r9
            r6 = r13
            r17 = r6
            r0 = -1
            r1 = 0
            r18 = 2143289344(0x7fc00000, float:NaN)
            r20 = 2143289344(0x7fc00000, float:NaN)
        L_0x006d:
            int r2 = r8.currentChar
            int r3 = r8.totalTextLength
            if (r2 >= r3) goto L_0x0284
            com.itextpdf.text.pdf.PdfChunk[] r1 = r8.detailChunks
            r5 = r1[r2]
            boolean r1 = r5.isImage()
            if (r1 == 0) goto L_0x00b9
            int r1 = (r32 > r33 ? 1 : (r32 == r33 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b9
            com.itextpdf.text.Image r1 = r5.getImage()
            boolean r2 = r1.isScaleToFitHeight()
            if (r2 == 0) goto L_0x00b9
            r2 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 * r34
            float r2 = r33 + r2
            float r3 = r1.getScaledHeight()
            float r3 = r2 - r3
            float r4 = r5.getImageOffsetY()
            float r3 = r3 - r4
            float r4 = r1.getSpacingBefore()
            float r3 = r3 - r4
            int r3 = (r3 > r32 ? 1 : (r3 == r32 ? 0 : -1))
            if (r3 >= 0) goto L_0x00b9
            float r3 = r5.getImageOffsetY()
            float r2 = r2 - r3
            float r3 = r1.getSpacingBefore()
            float r2 = r2 - r3
            float r2 = r2 - r32
            float r1 = r1.getScaledHeight()
            float r2 = r2 / r1
            r5.setImageScalePercentage(r2)
        L_0x00b9:
            char[] r1 = r8.text
            int r2 = r8.currentChar
            boolean r21 = com.itextpdf.text.Utilities.isSurrogatePair(r1, r2)
            if (r21 == 0) goto L_0x00d0
            char[] r1 = r8.text
            int r2 = r8.currentChar
            int r1 = com.itextpdf.text.Utilities.convertToUtf32(r1, r2)
            int r1 = r5.getUnicodeEquivalent(r1)
            goto L_0x00da
        L_0x00d0:
            char[] r1 = r8.text
            int r2 = r8.currentChar
            char r1 = r1[r2]
            int r1 = r5.getUnicodeEquivalent(r1)
        L_0x00da:
            r4 = r1
            boolean r1 = com.itextpdf.text.pdf.PdfChunk.noPrint(r4)
            if (r1 == 0) goto L_0x00e5
            r7 = r27
            goto L_0x0278
        L_0x00e5:
            if (r21 == 0) goto L_0x00ec
            float r1 = r5.getCharWidth(r4)
            goto L_0x0101
        L_0x00ec:
            boolean r1 = r5.isImage()
            if (r1 == 0) goto L_0x00f7
            float r1 = r5.getImageWidth()
            goto L_0x0101
        L_0x00f7:
            char[] r1 = r8.text
            int r2 = r8.currentChar
            char r1 = r1[r2]
            float r1 = r5.getCharWidth(r1)
        L_0x0101:
            float r2 = r19 - r1
            r22 = 0
            int r2 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r2 >= 0) goto L_0x0127
            if (r6 != 0) goto L_0x0127
            boolean r2 = r5.isImage()
            if (r2 == 0) goto L_0x0127
            com.itextpdf.text.Image r2 = r5.getImage()
            boolean r3 = r2.isScaleToFitLineWhenOverflow()
            if (r3 == 0) goto L_0x0127
            float r1 = r2.getWidth()
            float r1 = r19 / r1
            r5.setImageScalePercentage(r1)
            r23 = r19
            goto L_0x0129
        L_0x0127:
            r23 = r1
        L_0x0129:
            boolean r1 = r5.isTab()
            if (r1 == 0) goto L_0x01e8
            java.lang.String r1 = "TABSETTINGS"
            boolean r1 = r5.isAttribute(r1)
            if (r1 == 0) goto L_0x019c
            int r4 = r8.currentChar
            if (r17 == 0) goto L_0x0153
            r0 = r26
            r1 = r17
            r2 = r18
            r3 = r28
            r17 = r4
            r4 = r19
            r13 = r5
            r5 = r20
            r24 = r6
            r6 = r12
            r7 = r15
            float r19 = r0.processTabStop(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0158
        L_0x0153:
            r17 = r4
            r13 = r5
            r24 = r6
        L_0x0158:
            float r0 = r9 - r19
            com.itextpdf.text.TabStop r1 = com.itextpdf.text.pdf.PdfChunk.getTabStop(r13, r0)
            float r2 = r1.getPosition()
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x016f
            r10 = r17
            r4 = r19
            r13 = r24
            r1 = 0
            goto L_0x028c
        L_0x016f:
            r13.setTabStop(r1)
            if (r12 != 0) goto L_0x0190
            com.itextpdf.text.TabStop$Alignment r2 = r1.getAlignment()
            com.itextpdf.text.TabStop$Alignment r3 = com.itextpdf.text.TabStop.Alignment.LEFT
            if (r2 != r3) goto L_0x0190
            float r0 = r1.getPosition()
            float r0 = r9 - r0
            r7 = r27
            r19 = r0
            r0 = r17
            r17 = 0
            r18 = 2143289344(0x7fc00000, float:NaN)
            r20 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0270
        L_0x0190:
            r7 = r27
            r18 = r0
            r0 = r17
            r20 = 2143289344(0x7fc00000, float:NaN)
            r17 = r1
            goto L_0x0270
        L_0x019c:
            r13 = r5
            java.lang.String r1 = "TAB"
            java.lang.Object r1 = r13.getAttribute(r1)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r2 = r1[r11]
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r3 = 2
            r1 = r1[r3]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x01d7
            float r1 = r9 - r19
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x01d7
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            r1 = 0
            r5 = 1
            int r0 = r8.currentChar
            int r0 = r0 - r11
            java.util.ArrayList r6 = r8.createArrayOfPdfChunks(r14, r0)
            r0 = r10
            r2 = r28
            r3 = r19
            r4 = r29
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x01d7:
            com.itextpdf.text.pdf.PdfChunk[] r1 = r8.detailChunks
            int r3 = r8.currentChar
            r1 = r1[r3]
            r7 = r27
            r1.adjustLeft(r7)
            float r1 = r9 - r2
            r19 = r1
            goto L_0x0270
        L_0x01e8:
            r7 = r27
            r13 = r5
            r24 = r6
            boolean r1 = r13.isSeparator()
            if (r1 == 0) goto L_0x0223
            java.lang.String r1 = "SEPARATOR"
            java.lang.Object r1 = r13.getAttribute(r1)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r2 = r1[r10]
            com.itextpdf.text.pdf.draw.DrawInterface r2 = (com.itextpdf.text.pdf.draw.DrawInterface) r2
            r1 = r1[r11]
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0270
            boolean r1 = r2 instanceof com.itextpdf.text.pdf.draw.LineSeparator
            if (r1 == 0) goto L_0x0270
            com.itextpdf.text.pdf.draw.LineSeparator r2 = (com.itextpdf.text.pdf.draw.LineSeparator) r2
            float r1 = r2.getPercentage()
            float r1 = r1 * r9
            r2 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r2
            float r19 = r19 - r1
            int r1 = (r19 > r22 ? 1 : (r19 == r22 ? 0 : -1))
            if (r1 >= 0) goto L_0x0270
            r19 = 0
            goto L_0x0270
        L_0x0223:
            int r3 = r8.currentChar
            int r5 = r8.totalTextLength
            char[] r6 = r8.text
            com.itextpdf.text.pdf.PdfChunk[] r2 = r8.detailChunks
            r1 = r13
            r25 = r2
            r2 = r14
            r10 = r4
            r4 = r5
            r5 = r6
            r6 = r25
            boolean r1 = r1.isExtSplitCharacter(r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x0243
            char r2 = (char) r10
            boolean r2 = java.lang.Character.isWhitespace(r2)
            if (r2 == 0) goto L_0x0243
            int r0 = r8.currentChar
        L_0x0243:
            float r2 = r19 - r23
            int r3 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r3 >= 0) goto L_0x0251
            r10 = r0
            r1 = r17
            r4 = r19
            r13 = r24
            goto L_0x028c
        L_0x0251:
            if (r17 == 0) goto L_0x026a
            com.itextpdf.text.TabStop$Alignment r3 = r17.getAlignment()
            com.itextpdf.text.TabStop$Alignment r4 = com.itextpdf.text.TabStop.Alignment.ANCHOR
            if (r3 != r4) goto L_0x026a
            boolean r3 = java.lang.Float.isNaN(r20)
            if (r3 == 0) goto L_0x026a
            char r3 = r17.getAnchorChar()
            char r4 = (char) r10
            if (r3 != r4) goto L_0x026a
            float r20 = r9 - r19
        L_0x026a:
            if (r1 == 0) goto L_0x026e
            int r0 = r8.currentChar
        L_0x026e:
            r19 = r2
        L_0x0270:
            if (r21 == 0) goto L_0x0277
            int r1 = r8.currentChar
            int r1 = r1 + r11
            r8.currentChar = r1
        L_0x0277:
            r6 = r13
        L_0x0278:
            int r1 = r8.currentChar
            int r1 = r1 + r11
            r8.currentChar = r1
            r1 = r21
            r7 = -1
            r10 = 0
            r13 = 0
            goto L_0x006d
        L_0x0284:
            r10 = r0
            r21 = r1
            r13 = r6
            r1 = r17
            r4 = r19
        L_0x028c:
            if (r13 != 0) goto L_0x02b0
            int r0 = r8.currentChar
            int r0 = r0 + r11
            r8.currentChar = r0
            if (r21 == 0) goto L_0x0298
            int r0 = r0 + r11
            r8.currentChar = r0
        L_0x0298:
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            r1 = 0
            r3 = 0
            r5 = 0
            int r0 = r8.currentChar
            int r2 = r0 + -1
            int r0 = r0 - r11
            java.util.ArrayList r6 = r8.createArrayOfPdfChunks(r2, r0)
            r0 = r10
            r2 = r28
            r4 = r29
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x02b0:
            if (r1 == 0) goto L_0x02c2
            r0 = r26
            r2 = r18
            r3 = r28
            r5 = r20
            r6 = r12
            r7 = r15
            float r0 = r0.processTabStop(r1, r2, r3, r4, r5, r6, r7)
            r3 = r0
            goto L_0x02c3
        L_0x02c2:
            r3 = r4
        L_0x02c3:
            java.util.Iterator r0 = r15.iterator()
        L_0x02c7:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02de
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.TabStop r1 = (com.itextpdf.text.TabStop) r1
            float r2 = r9 - r3
            float r4 = r1.getPosition()
            float r2 = r2 - r4
            r1.setPosition(r2)
            goto L_0x02c7
        L_0x02de:
            int r0 = r8.currentChar
            int r1 = r8.totalTextLength
            if (r0 < r1) goto L_0x02f8
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            r2 = 0
            r5 = 1
            int r1 = r1 - r11
            java.util.ArrayList r6 = r8.createArrayOfPdfChunks(r14, r1)
            r0 = r10
            r1 = r2
            r2 = r28
            r4 = r29
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x02f8:
            int r0 = r0 - r11
            int r0 = r8.trimRightEx(r14, r0)
            if (r0 >= r14) goto L_0x0314
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            r1 = 0
            r5 = 0
            int r0 = r8.currentChar
            int r0 = r0 - r11
            java.util.ArrayList r6 = r8.createArrayOfPdfChunks(r14, r0)
            r0 = r10
            r2 = r28
            r4 = r29
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x0314:
            int r1 = r8.currentChar
            int r1 = r1 - r11
            if (r0 != r1) goto L_0x038b
            java.lang.String r1 = "HYPHENATION"
            java.lang.Object r1 = r13.getAttribute(r1)
            com.itextpdf.text.pdf.HyphenationEvent r1 = (com.itextpdf.text.pdf.HyphenationEvent) r1
            if (r1 == 0) goto L_0x038b
            int[] r2 = r8.getWord(r14, r0)
            if (r2 == 0) goto L_0x038b
            r4 = 0
            r5 = r2[r4]
            int r6 = r8.currentChar
            int r6 = r6 - r11
            float r5 = r8.getWidth(r5, r6)
            float r5 = r5 + r3
            java.lang.String r6 = new java.lang.String
            char[] r7 = r8.text
            r15 = r2[r4]
            r16 = r2[r11]
            r17 = r2[r4]
            int r4 = r16 - r17
            r6.<init>(r7, r15, r4)
            com.itextpdf.text.pdf.PdfFont r4 = r13.font()
            com.itextpdf.text.pdf.BaseFont r4 = r4.getFont()
            com.itextpdf.text.pdf.PdfFont r7 = r13.font()
            float r7 = r7.size()
            java.lang.String r4 = r1.getHyphenatedWordPre(r6, r4, r7, r5)
            java.lang.String r1 = r1.getHyphenatedWordPost()
            int r6 = r4.length()
            if (r6 <= 0) goto L_0x038b
            com.itextpdf.text.pdf.PdfChunk r0 = new com.itextpdf.text.pdf.PdfChunk
            r0.<init>(r4, r13)
            r3 = r2[r11]
            int r1 = r1.length()
            int r3 = r3 - r1
            r8.currentChar = r3
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            r1 = 0
            float r3 = r13.width(r4)
            float r3 = r5 - r3
            r5 = 0
            r4 = 0
            r2 = r2[r4]
            int r2 = r2 - r11
            java.util.ArrayList r6 = r8.createArrayOfPdfChunks(r14, r2, r0)
            r0 = r10
            r2 = r28
            r4 = r29
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x038b:
            r1 = -1
            if (r10 != r1) goto L_0x0390
            r8.isWordSplit = r11
        L_0x0390:
            if (r10 == r1) goto L_0x03ba
            if (r10 < r0) goto L_0x0395
            goto L_0x03ba
        L_0x0395:
            int r0 = r10 + 1
            r8.currentChar = r0
            int r0 = r8.trimRightEx(r14, r10)
            if (r0 >= r14) goto L_0x03a2
            int r0 = r8.currentChar
            int r0 = r0 - r11
        L_0x03a2:
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            r1 = 0
            float r2 = r8.getWidth(r14, r0, r9)
            float r3 = r9 - r2
            r5 = 0
            java.util.ArrayList r6 = r8.createArrayOfPdfChunks(r14, r0)
            r0 = r10
            r2 = r28
            r4 = r29
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x03ba:
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            r1 = 0
            int r2 = r0 + 1
            int r4 = r8.currentChar
            int r4 = r4 - r11
            float r2 = r8.getWidth(r2, r4, r9)
            float r3 = r3 + r2
            r5 = 0
            java.util.ArrayList r6 = r8.createArrayOfPdfChunks(r14, r0)
            r0 = r10
            r2 = r28
            r4 = r29
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BidiLine.processLine(float, float, int, int, int, float, float, float):com.itextpdf.text.pdf.PdfLine");
    }

    private float processTabStop(TabStop tabStop, float f, float f2, float f3, float f4, boolean z, List<TabStop> list) {
        float position = tabStop.getPosition(f, f2 - f3, f4);
        float f5 = f3 - (position - f);
        if (f5 < 0.0f) {
            position += f5;
            f5 = 0.0f;
        }
        if (!z) {
            tabStop.setPosition(position);
        } else {
            tabStop.setPosition(f);
            list.add(tabStop);
        }
        return f5;
    }

    public boolean isWordSplit() {
        return this.isWordSplit;
    }

    public float getWidth(int i, int i2) {
        return getWidth(i, i2, 0.0f);
    }

    public float getWidth(int i, int i2, float f) {
        float f2 = 0.0f;
        TabStop tabStop = null;
        float f3 = Float.NaN;
        float f4 = Float.NaN;
        while (i <= i2) {
            boolean isSurrogatePair = Utilities.isSurrogatePair(this.text, i);
            if (this.detailChunks[i].isTab() && this.detailChunks[i].isAttribute(Chunk.TABSETTINGS)) {
                if (tabStop != null) {
                    float position = tabStop.getPosition(f3, f2, f4);
                    f2 = (f2 - f3) + position;
                    tabStop.setPosition(position);
                }
                TabStop tabStop2 = this.detailChunks[i].getTabStop();
                if (tabStop2 == null) {
                    tabStop = PdfChunk.getTabStop(this.detailChunks[i], f2);
                    f3 = f2;
                } else {
                    if (this.runDirection == 3) {
                        f2 = f - tabStop2.getPosition();
                    } else {
                        f2 = tabStop2.getPosition();
                    }
                    tabStop = null;
                    f3 = Float.NaN;
                }
                f4 = Float.NaN;
            } else if (isSurrogatePair) {
                f2 += this.detailChunks[i].getCharWidth(Utilities.convertToUtf32(this.text, i));
                i++;
            } else {
                char c = this.text[i];
                PdfChunk pdfChunk = this.detailChunks[i];
                if (!PdfChunk.noPrint(pdfChunk.getUnicodeEquivalent(c))) {
                    if (tabStop != null && tabStop.getAlignment() != TabStop.Alignment.ANCHOR && Float.isNaN(f4) && tabStop.getAnchorChar() == ((char) pdfChunk.getUnicodeEquivalent(c))) {
                        f4 = f2;
                    }
                    f2 += this.detailChunks[i].getCharWidth(c);
                }
            }
            i++;
        }
        if (tabStop == null) {
            return f2;
        }
        float position2 = tabStop.getPosition(f3, f2, f4);
        float f5 = (f2 - f3) + position2;
        tabStop.setPosition(position2);
        return f5;
    }

    public ArrayList<PdfChunk> createArrayOfPdfChunks(int i, int i2) {
        return createArrayOfPdfChunks(i, i2, null);
    }

    public ArrayList<PdfChunk> createArrayOfPdfChunks(int i, int i2, PdfChunk pdfChunk) {
        boolean z = true;
        if (this.runDirection == 1) {
            z = false;
        }
        if (z) {
            reorder(i, i2);
        }
        ArrayList<PdfChunk> arrayList = new ArrayList<>();
        PdfChunk pdfChunk2 = this.detailChunks[i];
        StringBuffer stringBuffer = new StringBuffer();
        while (i <= i2) {
            int i3 = z ? this.indexChars[i] : i;
            char c = this.text[i3];
            PdfChunk pdfChunk3 = this.detailChunks[i3];
            if (!PdfChunk.noPrint(pdfChunk3.getUnicodeEquivalent(c))) {
                if (pdfChunk3.isImage() || pdfChunk3.isSeparator() || pdfChunk3.isTab()) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
                        stringBuffer = new StringBuffer();
                    }
                    arrayList.add(pdfChunk3);
                } else if (pdfChunk3 == pdfChunk2) {
                    stringBuffer.append(c);
                } else {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
                        stringBuffer = new StringBuffer();
                    }
                    if (!pdfChunk3.isImage() && !pdfChunk3.isSeparator() && !pdfChunk3.isTab()) {
                        stringBuffer.append(c);
                    }
                    pdfChunk2 = pdfChunk3;
                }
            }
            i++;
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
        }
        if (pdfChunk != null) {
            arrayList.add(pdfChunk);
        }
        return arrayList;
    }

    public int[] getWord(int i, int i2) {
        int i3 = i2;
        while (i3 < this.totalTextLength && (Character.isLetter(this.text[i3]) || Character.isDigit(this.text[i3]) || this.text[i3] == 173)) {
            i3++;
        }
        if (i3 == i2) {
            return null;
        }
        while (i2 >= i && (Character.isLetter(this.text[i2]) || Character.isDigit(this.text[i2]) || this.text[i2] == 173)) {
            i2--;
        }
        return new int[]{i2 + 1, i3};
    }

    public int trimRight(int i, int i2) {
        while (i2 >= i && isWS((char) this.detailChunks[i2].getUnicodeEquivalent(this.text[i2]))) {
            i2--;
        }
        return i2;
    }

    public int trimLeft(int i, int i2) {
        while (i <= i2 && isWS((char) this.detailChunks[i].getUnicodeEquivalent(this.text[i]))) {
            i++;
        }
        return i;
    }

    public int trimRightEx(int i, int i2) {
        while (i2 >= i) {
            char unicodeEquivalent = (char) this.detailChunks[i2].getUnicodeEquivalent(this.text[i2]);
            if (!isWS(unicodeEquivalent) && !PdfChunk.noPrint(unicodeEquivalent) && (!this.detailChunks[i2].isTab() || !this.detailChunks[i2].isAttribute(Chunk.TABSETTINGS) || !((Boolean) ((Object[]) this.detailChunks[i2].getAttribute(Chunk.TAB))[1]).booleanValue())) {
                break;
            }
            i2--;
        }
        return i2;
    }

    public int trimLeftEx(int i, int i2) {
        while (i <= i2) {
            char unicodeEquivalent = (char) this.detailChunks[i].getUnicodeEquivalent(this.text[i]);
            if (!isWS(unicodeEquivalent) && !PdfChunk.noPrint(unicodeEquivalent) && (!this.detailChunks[i].isTab() || !this.detailChunks[i].isAttribute(Chunk.TABSETTINGS) || !((Boolean) ((Object[]) this.detailChunks[i].getAttribute(Chunk.TAB))[1]).booleanValue())) {
                break;
            }
            i++;
        }
        return i;
    }

    public void reorder(int i, int i2) {
        byte b = this.orderLevels[i];
        byte b2 = b;
        byte b3 = b2;
        byte b4 = b3;
        for (int i3 = i + 1; i3 <= i2; i3++) {
            byte b5 = this.orderLevels[i3];
            if (b5 > b4) {
                b4 = b5;
            } else if (b5 < b3) {
                b3 = b5;
            }
            b2 = (byte) (b2 & b5);
            b = (byte) (b | b5);
        }
        if ((b & 1) != 0) {
            if ((b2 & 1) == 1) {
                flip(i, i2 + 1);
                return;
            }
            byte b6 = (byte) (b3 | 1);
            while (b4 >= b6) {
                int i4 = i;
                while (true) {
                    if (i4 <= i2 && this.orderLevels[i4] < b4) {
                        i4++;
                    } else if (i4 > i2) {
                        break;
                    } else {
                        int i5 = i4 + 1;
                        while (i5 <= i2 && this.orderLevels[i5] >= b4) {
                            i5++;
                        }
                        flip(i4, i5);
                        i4 = i5 + 1;
                    }
                }
                b4 = (byte) (b4 - 1);
            }
        }
    }

    public void flip(int i, int i2) {
        int i3 = (i + i2) / 2;
        while (true) {
            i2--;
            if (i < i3) {
                int[] iArr = this.indexChars;
                int i4 = iArr[i];
                iArr[i] = iArr[i2];
                iArr[i2] = i4;
                i++;
            } else {
                return;
            }
        }
    }

    public static String processLTR(String str, int i, int i2) {
        BidiLine bidiLine = new BidiLine();
        bidiLine.addChunk(new PdfChunk(new Chunk(str), (PdfAction) null));
        bidiLine.arabicOptions = i2;
        bidiLine.getParagraph(i);
        ArrayList<PdfChunk> createArrayOfPdfChunks = bidiLine.createArrayOfPdfChunks(0, bidiLine.totalTextLength - 1);
        StringBuilder sb = new StringBuilder();
        Iterator<PdfChunk> it2 = createArrayOfPdfChunks.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().toString());
        }
        return sb.toString();
    }
}
