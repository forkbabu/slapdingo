package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import com.itextpdf.xmp.XMPError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.opencv.imgproc.Imgproc;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;

public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256, 118, 143, 7, 21, 63}, new int[]{CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, 13, 39, 117, 140, 209, 205}, new int[]{CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, 49, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 19, 57, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 91}, new int[]{62, CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, 136, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_PSK_WITH_AES_256_GCM_SHA384, 85, 44, 132}, new int[]{CipherSuite.TLS_RSA_PSK_WITH_NULL_SHA384, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 97, 80, 29, 87, 50}, new int[]{CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 28, 84, 41, 123, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 52, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256}, new int[]{46, 138, 203, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, 139, 206, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256}, new int[]{76, 17, 51, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, 37, 111, 122, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA}, new int[]{43, 129, CipherSuite.TLS_PSK_WITH_NULL_SHA256, 106, 107, 110, 119, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA}, new int[]{16, 48, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 10, 30, 90, 59, CipherSuite.TLS_PSK_WITH_NULL_SHA384}, new int[]{109, 116, 137, 200, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA256, 112, 125, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256}, new int[]{70, 210, 208, XMPError.BADRDF, 184, 130, 179, 115}, new int[]{134, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 31, 93, 68, 204, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256}, new int[]{CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA, 22, 66, 198, CipherSuite.TLS_RSA_PSK_WITH_AES_128_GCM_SHA256, 94, 71, 2}, new int[]{6, 18, 54, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, 64, 192, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 40}, new int[]{120, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 25, 75, 14, 42, 126, CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384}, new int[]{79, 26, 78, 23, 69, 207, 199, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA384}, new int[]{103, 98, 83, 38, 114, Imgproc.COLOR_RGB2YUV_YV12, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA256, 124}, new int[]{CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384, 61, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384, 127, CipherSuite.TLS_DHE_PSK_WITH_AES_128_GCM_SHA256, 88, 53, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384}, new int[]{55, CipherSuite.TLS_DH_DSS_WITH_AES_256_GCM_SHA384, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256, 58, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 100, 89}};
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i, bitArray));
        } catch (NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i, bitArray));
        }
    }

    @Override // com.google.zxing.Reader, com.google.zxing.oned.OneDReader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    /* access modifiers changed from: package-private */
    public List<ExpandedPair> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                } else if (checkChecksum()) {
                    return this.pairs;
                } else {
                    boolean z = !this.rows.isEmpty();
                    storeRow(i, false);
                    if (z) {
                        List<ExpandedPair> checkRows = checkRows(false);
                        if (checkRows != null) {
                            return checkRows;
                        }
                        List<ExpandedPair> checkRows2 = checkRows(true);
                        if (checkRows2 != null) {
                            return checkRows2;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    private List<ExpandedPair> checkRows(boolean z) {
        List<ExpandedPair> list = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z) {
            Collections.reverse(this.rows);
        }
        try {
            list = checkRows(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.rows);
        }
        return list;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            ExpandedRow expandedRow = this.rows.get(i);
            this.pairs.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pairs.addAll(list.get(i2).getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        boolean z;
        int[][] iArr = FINDER_PATTERN_SEQUENCES;
        for (int[] iArr2 : iArr) {
            if (list.size() <= iArr2.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i).getFinderPattern().getValue() != iArr2[i]) {
                        z = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void storeRow(int i, boolean z) {
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 >= this.rows.size()) {
                break;
            }
            ExpandedRow expandedRow = this.rows.get(i2);
            if (expandedRow.getRowNumber() > i) {
                z2 = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                z3 = expandedRow.isEquivalent(this.pairs);
                i2++;
            }
        }
        if (!z2 && !z3 && !isPartialRow(this.pairs, this.rows)) {
            this.rows.add(i2, new ExpandedRow(this.pairs, i, z));
            removePartialRows(this.pairs, this.rows);
        }
    }

    private static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        boolean z;
        Iterator<ExpandedRow> it2 = list2.iterator();
        while (it2.hasNext()) {
            ExpandedRow next = it2.next();
            if (next.getPairs().size() != list.size()) {
                Iterator<ExpandedPair> it3 = next.getPairs().iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (!it3.hasNext()) {
                        z = true;
                        break;
                    }
                    ExpandedPair next2 = it3.next();
                    Iterator<ExpandedPair> it4 = list.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            if (next2.equals(it4.next())) {
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
                if (z) {
                    it2.remove();
                }
            }
        }
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        boolean z;
        boolean z2;
        Iterator<ExpandedRow> it2 = iterable2.iterator();
        do {
            z = false;
            if (it2.hasNext()) {
                ExpandedRow next = it2.next();
                Iterator<ExpandedPair> it3 = iterable.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z = true;
                        continue;
                        break;
                    }
                    ExpandedPair next2 = it3.next();
                    Iterator<ExpandedPair> it4 = next.getPairs().iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            if (next2.equals(it4.next())) {
                                z2 = true;
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        return true;
    }

    /* access modifiers changed from: package-private */
    public List<ExpandedRow> getRows() {
        return this.rows;
    }

    static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int checksumPortion = rightChar.getChecksumPortion();
        int i = 2;
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            ExpandedPair expandedPair2 = this.pairs.get(i2);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i++;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i++;
            }
        }
        if (((i - 4) * Primes.SMALL_FACTOR_LIMIT) + (checksumPortion % Primes.SMALL_FACTOR_LIMIT) == leftChar.getValue()) {
            return true;
        }
        return false;
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        if (bitArray.get(i)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    /* access modifiers changed from: package-private */
    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        boolean z = list.size() % 2 == 0;
        if (this.startFromEven) {
            z = !z;
        }
        int i2 = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, list, i2);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (parseFoundFinderPattern == null) {
                i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, true);
        if (list.isEmpty() || !list.get(list.size() - 1).mustBeLast()) {
            try {
                dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, false);
            } catch (NotFoundException unused) {
                dataCharacter = null;
            }
            return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            if (list.isEmpty()) {
                i = 0;
            } else {
                i = list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
            }
        }
        boolean z = list.size() % 2 != 0;
        if (this.startFromEven) {
            z = !z;
        }
        boolean z2 = false;
        while (i < size) {
            z2 = !bitArray.get(i);
            if (!z2) {
                break;
            }
            i++;
        }
        boolean z3 = z2;
        int i2 = 0;
        int i3 = i;
        while (i < size) {
            if (bitArray.get(i) ^ z3) {
                decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                decodeFinderCounters[i2] = 1;
                z3 = !z3;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.startEnd[0] - 1;
            while (i5 >= 0 && !bitArray.get(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.startEnd;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.startEnd;
            int i7 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i2 = nextUnset;
            i3 = i7;
            i4 = nextUnset - this.startEnd[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i4;
        try {
            return new FinderPattern(parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i3, i2}, i3, i2, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z2) {
            recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i = 0;
            for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        float count = ((float) count(dataCharacterCounters)) / ((float) 17);
        float f = ((float) (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0])) / 15.0f;
        if (Math.abs(count - f) / f <= 0.3f) {
            int[] oddCounts = getOddCounts();
            int[] evenCounts = getEvenCounts();
            float[] oddRoundingErrors = getOddRoundingErrors();
            float[] evenRoundingErrors = getEvenRoundingErrors();
            for (int i3 = 0; i3 < dataCharacterCounters.length; i3++) {
                float f2 = (((float) dataCharacterCounters[i3]) * 1.0f) / count;
                int i4 = (int) (0.5f + f2);
                if (i4 < 1) {
                    if (f2 >= 0.3f) {
                        i4 = 1;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (i4 > 8) {
                    if (f2 <= 8.7f) {
                        i4 = 8;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i5 = i3 / 2;
                if ((i3 & 1) == 0) {
                    oddCounts[i5] = i4;
                    oddRoundingErrors[i5] = f2 - ((float) i4);
                } else {
                    evenCounts[i5] = i4;
                    evenRoundingErrors[i5] = f2 - ((float) i4);
                }
            }
            adjustOddEvenCounts(17);
            int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (!z2)) - 1;
            int i6 = 0;
            int i7 = 0;
            for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                if (isNotA1left(finderPattern, z, z2)) {
                    i6 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
                }
                i7 += oddCounts[length2];
            }
            int i8 = 0;
            for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                if (isNotA1left(finderPattern, z, z2)) {
                    i8 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
                }
            }
            int i9 = i6 + i8;
            if ((i7 & 1) != 0 || i7 > 13 || i7 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i10 = (13 - i7) / 2;
            int i11 = SYMBOL_WIDEST[i10];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i11, true) * EVEN_TOTAL_SUBSET[i10]) + RSSUtils.getRSSvalue(evenCounts, 9 - i11, false) + GSUM[i10], i9);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return finderPattern.getValue() != 0 || !z || !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void adjustOddEvenCounts(int r11) throws com.google.zxing.NotFoundException {
        /*
            r10 = this;
            int[] r0 = r10.getOddCounts()
            int r0 = count(r0)
            int[] r1 = r10.getEvenCounts()
            int r1 = count(r1)
            int r2 = r0 + r1
            int r2 = r2 - r11
            r11 = r0 & 1
            r3 = 0
            r4 = 1
            if (r11 != r4) goto L_0x001b
            r11 = 1
            goto L_0x001c
        L_0x001b:
            r11 = 0
        L_0x001c:
            r5 = r1 & 1
            if (r5 != 0) goto L_0x0022
            r5 = 1
            goto L_0x0023
        L_0x0022:
            r5 = 0
        L_0x0023:
            r6 = 4
            r7 = 13
            if (r0 <= r7) goto L_0x002b
            r8 = 0
            r9 = 1
            goto L_0x0031
        L_0x002b:
            if (r0 >= r6) goto L_0x002f
            r8 = 1
            goto L_0x0030
        L_0x002f:
            r8 = 0
        L_0x0030:
            r9 = 0
        L_0x0031:
            if (r1 <= r7) goto L_0x0035
            r6 = 1
            goto L_0x0039
        L_0x0035:
            if (r1 >= r6) goto L_0x0038
            r3 = 1
        L_0x0038:
            r6 = 0
        L_0x0039:
            if (r2 != r4) goto L_0x0051
            if (r11 == 0) goto L_0x0047
            if (r5 != 0) goto L_0x0042
            r4 = r8
        L_0x0040:
            r9 = 1
            goto L_0x007c
        L_0x0042:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0047:
            if (r5 == 0) goto L_0x004c
            r4 = r8
        L_0x004a:
            r6 = 1
            goto L_0x007c
        L_0x004c:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0051:
            r7 = -1
            if (r2 != r7) goto L_0x0068
            if (r11 == 0) goto L_0x005e
            if (r5 != 0) goto L_0x0059
            goto L_0x007c
        L_0x0059:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x005e:
            if (r5 == 0) goto L_0x0063
            r4 = r8
            r3 = 1
            goto L_0x007c
        L_0x0063:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0068:
            if (r2 != 0) goto L_0x00c6
            if (r11 == 0) goto L_0x0079
            if (r5 == 0) goto L_0x0074
            if (r0 >= r1) goto L_0x0071
            goto L_0x004a
        L_0x0071:
            r4 = r8
            r3 = 1
            goto L_0x0040
        L_0x0074:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0079:
            if (r5 != 0) goto L_0x00c1
            r4 = r8
        L_0x007c:
            if (r4 == 0) goto L_0x0091
            if (r9 != 0) goto L_0x008c
            int[] r11 = r10.getOddCounts()
            float[] r0 = r10.getOddRoundingErrors()
            increment(r11, r0)
            goto L_0x0091
        L_0x008c:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0091:
            if (r9 == 0) goto L_0x009e
            int[] r11 = r10.getOddCounts()
            float[] r0 = r10.getOddRoundingErrors()
            decrement(r11, r0)
        L_0x009e:
            if (r3 == 0) goto L_0x00b3
            if (r6 != 0) goto L_0x00ae
            int[] r11 = r10.getEvenCounts()
            float[] r0 = r10.getOddRoundingErrors()
            increment(r11, r0)
            goto L_0x00b3
        L_0x00ae:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00b3:
            if (r6 == 0) goto L_0x00c0
            int[] r11 = r10.getEvenCounts()
            float[] r0 = r10.getEvenRoundingErrors()
            decrement(r11, r0)
        L_0x00c0:
            return
        L_0x00c1:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00c6:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.adjustOddEvenCounts(int):void");
    }
}
