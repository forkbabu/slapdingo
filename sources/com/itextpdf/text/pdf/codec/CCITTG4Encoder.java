package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import com.itextpdf.xmp.XMPError;
import kotlin.UByte;
import org.opencv.ml.DTrees;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.math.Primes;

public class CCITTG4Encoder {
    private static final int CODE = 1;
    private static final int EOL = 1;
    private static final int G3CODE_EOF = -3;
    private static final int G3CODE_EOL = -1;
    private static final int G3CODE_INCOMP = -4;
    private static final int G3CODE_INVALID = -2;
    private static final int LENGTH = 0;
    private static final int RUNLEN = 2;
    private static byte[] oneruns = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8};
    private static byte[] zeroruns = {8, 7, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[][] TIFFFaxBlackCodes = {new int[]{10, 55, 0}, new int[]{3, 2, 1}, new int[]{2, 3, 2}, new int[]{2, 2, 3}, new int[]{3, 3, 4}, new int[]{4, 3, 5}, new int[]{4, 2, 6}, new int[]{5, 3, 7}, new int[]{6, 5, 8}, new int[]{6, 4, 9}, new int[]{7, 4, 10}, new int[]{7, 5, 11}, new int[]{7, 7, 12}, new int[]{8, 4, 13}, new int[]{8, 7, 14}, new int[]{9, 24, 15}, new int[]{10, 23, 16}, new int[]{10, 24, 17}, new int[]{10, 8, 18}, new int[]{11, 103, 19}, new int[]{11, 104, 20}, new int[]{11, 108, 21}, new int[]{11, 55, 22}, new int[]{11, 40, 23}, new int[]{11, 23, 24}, new int[]{11, 24, 25}, new int[]{12, XMPError.BADRDF, 26}, new int[]{12, 203, 27}, new int[]{12, 204, 28}, new int[]{12, 205, 29}, new int[]{12, 104, 30}, new int[]{12, 105, 31}, new int[]{12, 106, 32}, new int[]{12, 107, 33}, new int[]{12, 210, 34}, new int[]{12, Primes.SMALL_FACTOR_LIMIT, 35}, new int[]{12, 212, 36}, new int[]{12, 213, 37}, new int[]{12, 214, 38}, new int[]{12, 215, 39}, new int[]{12, 108, 40}, new int[]{12, 109, 41}, new int[]{12, 218, 42}, new int[]{12, 219, 43}, new int[]{12, 84, 44}, new int[]{12, 85, 45}, new int[]{12, 86, 46}, new int[]{12, 87, 47}, new int[]{12, 100, 48}, new int[]{12, 101, 49}, new int[]{12, 82, 50}, new int[]{12, 83, 51}, new int[]{12, 36, 52}, new int[]{12, 55, 53}, new int[]{12, 56, 54}, new int[]{12, 39, 55}, new int[]{12, 40, 56}, new int[]{12, 88, 57}, new int[]{12, 89, 58}, new int[]{12, 43, 59}, new int[]{12, 44, 60}, new int[]{12, 90, 61}, new int[]{12, 102, 62}, new int[]{12, 103, 63}, new int[]{10, 15, 64}, new int[]{12, 200, 128}, new int[]{12, 201, 192}, new int[]{12, 91, 256}, new int[]{12, 51, TIFFConstants.TIFFTAG_COLORMAP}, new int[]{12, 52, 384}, new int[]{12, 53, 448}, new int[]{13, 108, 512}, new int[]{13, 109, 576}, new int[]{13, 74, 640}, new int[]{13, 75, 704}, new int[]{13, 76, DTrees.PREDICT_MASK}, new int[]{13, 77, 832}, new int[]{13, 114, 896}, new int[]{13, 115, 960}, new int[]{13, 116, 1024}, new int[]{13, 117, 1088}, new int[]{13, 118, 1152}, new int[]{13, 119, 1216}, new int[]{13, 82, 1280}, new int[]{13, 83, 1344}, new int[]{13, 84, 1408}, new int[]{13, 85, 1472}, new int[]{13, 90, 1536}, new int[]{13, 91, 1600}, new int[]{13, 100, 1664}, new int[]{13, 101, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, MetaDo.META_DIBBITBLT}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, new int[]{12, 0, -2}};
    private int[][] TIFFFaxWhiteCodes = {new int[]{8, 53, 0}, new int[]{6, 7, 1}, new int[]{4, 7, 2}, new int[]{4, 8, 3}, new int[]{4, 11, 4}, new int[]{4, 12, 5}, new int[]{4, 14, 6}, new int[]{4, 15, 7}, new int[]{5, 19, 8}, new int[]{5, 20, 9}, new int[]{5, 7, 10}, new int[]{5, 8, 11}, new int[]{6, 8, 12}, new int[]{6, 3, 13}, new int[]{6, 52, 14}, new int[]{6, 53, 15}, new int[]{6, 42, 16}, new int[]{6, 43, 17}, new int[]{7, 39, 18}, new int[]{7, 12, 19}, new int[]{7, 8, 20}, new int[]{7, 23, 21}, new int[]{7, 3, 22}, new int[]{7, 4, 23}, new int[]{7, 40, 24}, new int[]{7, 43, 25}, new int[]{7, 19, 26}, new int[]{7, 36, 27}, new int[]{7, 24, 28}, new int[]{8, 2, 29}, new int[]{8, 3, 30}, new int[]{8, 26, 31}, new int[]{8, 27, 32}, new int[]{8, 18, 33}, new int[]{8, 19, 34}, new int[]{8, 20, 35}, new int[]{8, 21, 36}, new int[]{8, 22, 37}, new int[]{8, 23, 38}, new int[]{8, 40, 39}, new int[]{8, 41, 40}, new int[]{8, 42, 41}, new int[]{8, 43, 42}, new int[]{8, 44, 43}, new int[]{8, 45, 44}, new int[]{8, 4, 45}, new int[]{8, 5, 46}, new int[]{8, 10, 47}, new int[]{8, 11, 48}, new int[]{8, 82, 49}, new int[]{8, 83, 50}, new int[]{8, 84, 51}, new int[]{8, 85, 52}, new int[]{8, 36, 53}, new int[]{8, 37, 54}, new int[]{8, 88, 55}, new int[]{8, 89, 56}, new int[]{8, 90, 57}, new int[]{8, 91, 58}, new int[]{8, 74, 59}, new int[]{8, 75, 60}, new int[]{8, 50, 61}, new int[]{8, 51, 62}, new int[]{8, 52, 63}, new int[]{5, 27, 64}, new int[]{5, 18, 128}, new int[]{6, 23, 192}, new int[]{7, 55, 256}, new int[]{8, 54, TIFFConstants.TIFFTAG_COLORMAP}, new int[]{8, 55, 384}, new int[]{8, 100, 448}, new int[]{8, 101, 512}, new int[]{8, 104, 576}, new int[]{8, 103, 640}, new int[]{9, 204, 704}, new int[]{9, 205, DTrees.PREDICT_MASK}, new int[]{9, 210, 832}, new int[]{9, Primes.SMALL_FACTOR_LIMIT, 896}, new int[]{9, 212, 960}, new int[]{9, 213, 1024}, new int[]{9, 214, 1088}, new int[]{9, 215, 1152}, new int[]{9, 216, 1216}, new int[]{9, 217, 1280}, new int[]{9, 218, 1344}, new int[]{9, 219, 1408}, new int[]{9, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 1472}, new int[]{9, CipherSuite.TLS_DHE_DSS_WITH_SEED_CBC_SHA, 1536}, new int[]{9, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 1600}, new int[]{6, 24, 1664}, new int[]{9, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, MetaDo.META_DIBBITBLT}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, new int[]{12, 0, -2}};
    private int bit = 8;
    private int data;
    private byte[] dataBp;
    private int[] horizcode = {3, 1, 0};
    private int[] msbmask = {0, 1, 3, 7, 15, 31, 63, 127, 255};
    private int offsetData;
    private ByteBuffer outBuf = new ByteBuffer(1024);
    private int[] passcode = {4, 1, 0};
    private byte[] refline;
    private int rowbytes;
    private int rowpixels;
    private int sizeData;
    private int[][] vcodes = {new int[]{7, 3, 0}, new int[]{6, 3, 0}, new int[]{3, 3, 0}, new int[]{1, 1, 0}, new int[]{3, 2, 0}, new int[]{6, 2, 0}, new int[]{7, 2, 0}};

    public CCITTG4Encoder(int i) {
        this.rowpixels = i;
        int i2 = (i + 7) / 8;
        this.rowbytes = i2;
        this.refline = new byte[i2];
    }

    public void fax4Encode(byte[] bArr, int i, int i2) {
        this.dataBp = bArr;
        this.offsetData = i;
        this.sizeData = i2;
        while (this.sizeData > 0) {
            Fax3Encode2DRow();
            System.arraycopy(this.dataBp, this.offsetData, this.refline, 0, this.rowbytes);
            int i3 = this.offsetData;
            int i4 = this.rowbytes;
            this.offsetData = i3 + i4;
            this.sizeData -= i4;
        }
    }

    public static byte[] compress(byte[] bArr, int i, int i2) {
        CCITTG4Encoder cCITTG4Encoder = new CCITTG4Encoder(i);
        cCITTG4Encoder.fax4Encode(bArr, 0, cCITTG4Encoder.rowbytes * i2);
        return cCITTG4Encoder.close();
    }

    public void fax4Encode(byte[] bArr, int i) {
        fax4Encode(bArr, 0, this.rowbytes * i);
    }

    private void putcode(int[] iArr) {
        putBits(iArr[1], iArr[0]);
    }

    private void putspan(int i, int[][] iArr) {
        while (i >= 2624) {
            int[] iArr2 = iArr[103];
            putBits(iArr2[1], iArr2[0]);
            i -= iArr2[2];
        }
        if (i >= 64) {
            int[] iArr3 = iArr[(i >> 6) + 63];
            putBits(iArr3[1], iArr3[0]);
            i -= iArr3[2];
        }
        putBits(iArr[i][1], iArr[i][0]);
    }

    private void putBits(int i, int i2) {
        int i3;
        while (true) {
            i3 = this.bit;
            if (i2 <= i3) {
                break;
            }
            int i4 = this.data | (i >> (i2 - i3));
            this.data = i4;
            i2 -= i3;
            this.outBuf.append((byte) i4);
            this.data = 0;
            this.bit = 8;
        }
        int i5 = ((i & this.msbmask[i2]) << (i3 - i2)) | this.data;
        this.data = i5;
        int i6 = i3 - i2;
        this.bit = i6;
        if (i6 == 0) {
            this.outBuf.append((byte) i5);
            this.data = 0;
            this.bit = 8;
        }
    }

    private void Fax3Encode2DRow() {
        int finddiff = pixel(this.dataBp, this.offsetData, 0) != 0 ? 0 : finddiff(this.dataBp, this.offsetData, 0, this.rowpixels, 0);
        int finddiff2 = pixel(this.refline, 0, 0) != 0 ? 0 : finddiff(this.refline, 0, 0, this.rowpixels, 0);
        int i = 0;
        while (true) {
            byte[] bArr = this.refline;
            int finddiff22 = finddiff2(bArr, 0, finddiff2, this.rowpixels, pixel(bArr, 0, finddiff2));
            if (finddiff22 >= finddiff) {
                int i2 = finddiff2 - finddiff;
                if (-3 > i2 || i2 > 3) {
                    byte[] bArr2 = this.dataBp;
                    int i3 = this.offsetData;
                    int finddiff23 = finddiff2(bArr2, i3, finddiff, this.rowpixels, pixel(bArr2, i3, finddiff));
                    putcode(this.horizcode);
                    if (i + finddiff == 0 || pixel(this.dataBp, this.offsetData, i) == 0) {
                        putspan(finddiff - i, this.TIFFFaxWhiteCodes);
                        putspan(finddiff23 - finddiff, this.TIFFFaxBlackCodes);
                    } else {
                        putspan(finddiff - i, this.TIFFFaxBlackCodes);
                        putspan(finddiff23 - finddiff, this.TIFFFaxWhiteCodes);
                    }
                    finddiff = finddiff23;
                } else {
                    putcode(this.vcodes[i2 + 3]);
                }
                i = finddiff;
            } else {
                putcode(this.passcode);
                i = finddiff22;
            }
            int i4 = this.rowpixels;
            if (i < i4) {
                byte[] bArr3 = this.dataBp;
                int i5 = this.offsetData;
                finddiff = finddiff(bArr3, i5, i, i4, pixel(bArr3, i5, i));
                finddiff2 = finddiff(this.refline, 0, finddiff(this.refline, 0, i, this.rowpixels, pixel(this.dataBp, this.offsetData, i) ^ 1), this.rowpixels, pixel(this.dataBp, this.offsetData, i));
            } else {
                return;
            }
        }
    }

    private void Fax4PostEncode() {
        putBits(1, 12);
        putBits(1, 12);
        if (this.bit != 8) {
            this.outBuf.append((byte) this.data);
            this.data = 0;
            this.bit = 8;
        }
    }

    public byte[] close() {
        Fax4PostEncode();
        return this.outBuf.toByteArray();
    }

    private int pixel(byte[] bArr, int i, int i2) {
        if (i2 >= this.rowpixels) {
            return 0;
        }
        return ((bArr[i + (i2 >> 3)] & UByte.MAX_VALUE) >> (7 - (i2 & 7))) & 1;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x001a */
    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int find1span(byte[] r3, int r4, int r5, int r6) {
        /*
            int r6 = r6 - r5
            int r0 = r5 >> 3
            int r4 = r4 + r0
            r0 = 8
            if (r6 <= 0) goto L_0x0023
            r5 = r5 & 7
            if (r5 == 0) goto L_0x0023
            byte[] r1 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.oneruns
            byte r2 = r3[r4]
            int r2 = r2 << r5
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r1 = r1[r2]
            int r2 = 8 - r5
            if (r1 <= r2) goto L_0x001a
            r1 = r2
        L_0x001a:
            if (r1 <= r6) goto L_0x001d
            r1 = r6
        L_0x001d:
            int r5 = r5 + r1
            if (r5 >= r0) goto L_0x0021
            return r1
        L_0x0021:
            int r6 = r6 - r1
            goto L_0x0039
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r6 < r0) goto L_0x003c
            byte r5 = r3[r4]
            r2 = -1
            if (r5 == r2) goto L_0x0035
            byte[] r5 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.oneruns
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            int r1 = r1 + r3
            return r1
        L_0x0035:
            int r1 = r1 + 8
            int r6 = r6 + -8
        L_0x0039:
            int r4 = r4 + 1
            goto L_0x0024
        L_0x003c:
            if (r6 <= 0) goto L_0x004b
            byte[] r5 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.oneruns
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            if (r3 <= r6) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r6 = r3
        L_0x004a:
            int r1 = r1 + r6
        L_0x004b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.CCITTG4Encoder.find1span(byte[], int, int, int):int");
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x001a */
    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int find0span(byte[] r3, int r4, int r5, int r6) {
        /*
            int r6 = r6 - r5
            int r0 = r5 >> 3
            int r4 = r4 + r0
            r0 = 8
            if (r6 <= 0) goto L_0x0023
            r5 = r5 & 7
            if (r5 == 0) goto L_0x0023
            byte[] r1 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.zeroruns
            byte r2 = r3[r4]
            int r2 = r2 << r5
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r1 = r1[r2]
            int r2 = 8 - r5
            if (r1 <= r2) goto L_0x001a
            r1 = r2
        L_0x001a:
            if (r1 <= r6) goto L_0x001d
            r1 = r6
        L_0x001d:
            int r5 = r5 + r1
            if (r5 >= r0) goto L_0x0021
            return r1
        L_0x0021:
            int r6 = r6 - r1
            goto L_0x0038
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r6 < r0) goto L_0x003b
            byte r5 = r3[r4]
            if (r5 == 0) goto L_0x0034
            byte[] r5 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.zeroruns
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            int r1 = r1 + r3
            return r1
        L_0x0034:
            int r1 = r1 + 8
            int r6 = r6 + -8
        L_0x0038:
            int r4 = r4 + 1
            goto L_0x0024
        L_0x003b:
            if (r6 <= 0) goto L_0x004a
            byte[] r5 = com.itextpdf.text.pdf.codec.CCITTG4Encoder.zeroruns
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            if (r3 <= r6) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r6 = r3
        L_0x0049:
            int r1 = r1 + r6
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.CCITTG4Encoder.find0span(byte[], int, int, int):int");
    }

    private static int finddiff(byte[] bArr, int i, int i2, int i3, int i4) {
        return i2 + (i4 != 0 ? find1span(bArr, i, i2, i3) : find0span(bArr, i, i2, i3));
    }

    private static int finddiff2(byte[] bArr, int i, int i2, int i3, int i4) {
        return i2 < i3 ? finddiff(bArr, i, i2, i3, i4) : i3;
    }
}
