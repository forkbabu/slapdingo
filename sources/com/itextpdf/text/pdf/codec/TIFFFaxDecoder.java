package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidImageException;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.ByteBuffer;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.spongycastle.crypto.signers.PSSSigner;

public class TIFFFaxDecoder {
    static short[] additionalMakeup = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    static short[] black = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, 718, 718, 718, 718, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, 1200, 1200, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390};
    static byte[] flipTable = {0, ByteCompanionObject.MIN_VALUE, 64, -64, DocWriter.SPACE, -96, 96, -32, 16, -112, 80, -48, ByteBuffer.ZERO, -80, 112, -16, 8, -120, 72, -56, 40, -88, 104, -24, 24, -104, 88, -40, 56, -72, 120, -8, 4, -124, 68, -60, 36, -92, 100, -28, 20, -108, 84, -44, 52, -76, 116, -12, BidiOrder.CS, -116, 76, -52, 44, -84, 108, -20, 28, -100, 92, -36, DocWriter.LT, PSSSigner.TRAILER_IMPLICIT, 124, -4, 2, -126, 66, -62, DocWriter.QUOTE, -94, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, -118, 74, -54, 42, -86, 106, -22, 26, -102, 90, -38, 58, -70, 122, -6, 6, -122, 70, -58, 38, -90, 102, -26, 22, -106, 86, -42, 54, -74, 118, -10, BidiOrder.BN, -114, 78, -50, 46, -82, 110, -18, 30, -98, 94, -34, DocWriter.GT, -66, 126, -2, 1, -127, 65, -63, 33, -95, 97, -31, BidiOrder.WS, -111, 81, -47, 49, -79, 113, -15, 9, -119, 73, -55, 41, -87, 105, -23, 25, -103, 89, -39, 57, -71, 121, -7, 5, -123, 69, -59, 37, -91, 101, -27, 21, -107, 85, -43, 53, -75, 117, -11, BidiOrder.NSM, -115, 77, -51, 45, -83, 109, -19, 29, -99, 93, -35, DocWriter.EQUALS, -67, 125, -3, 3, -125, 67, -61, 35, -93, 99, -29, 19, -109, 83, -45, 51, -77, 115, -13, BidiOrder.AN, -117, 75, -53, 43, -85, 107, -21, 27, -101, 91, -37, 59, -69, 123, -5, 7, -121, 71, -57, 39, -89, 103, -25, 23, -105, 87, -41, 55, -73, 119, -9, BidiOrder.B, -113, 79, -49, DocWriter.FORWARD, -81, 111, -17, 31, -97, 95, -33, 63, -65, ByteCompanionObject.MAX_VALUE, -1};
    static short[] initBlack = {3226, 6412, 200, 168, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};
    static int[] table1 = {0, 1, 3, 7, 15, 31, 63, 127, 255};
    static int[] table2 = {0, 128, 192, 224, 240, 248, 252, TIFFConstants.TIFFTAG_SUBFILETYPE, 255};
    static short[] twoBitBlack = {292, 260, 226, 226};
    static byte[] twoDCodes = {80, 88, 23, 71, 30, 30, DocWriter.GT, DocWriter.GT, 4, 4, 4, 4, 4, 4, 4, 4, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, BidiOrder.AN, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41};
    static short[] white = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, 718, 718, 718, 718, 718, 718, 718, 718, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, 1200, 1200, 1200, 1200, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    private int bitPointer;
    private int bytePointer;
    private int changingElemSize = 0;
    private int compression = 2;
    private int[] currChangingElems;
    private byte[] data;
    private int fillBits = 0;
    private long fillOrder;
    private int h;
    private int lastChangingElement = 0;
    private int oneD;
    private int[] prevChangingElems;
    private boolean recoverFromImageError;
    private int uncompressedMode = 0;
    private int w;

    public TIFFFaxDecoder(long j, int i, int i2) {
        this.fillOrder = j;
        this.w = i;
        this.h = i2;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i3 = i * 2;
        this.prevChangingElems = new int[i3];
        this.currChangingElems = new int[i3];
    }

    public static void reverseBits(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = flipTable[bArr[i] & UByte.MAX_VALUE];
        }
    }

    public void decode1D(byte[] bArr, byte[] bArr2, int i, int i2) {
        this.data = bArr2;
        int i3 = (this.w + 7) / 8;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            decodeNextScanline(bArr, i4, i);
            i4 += i3;
        }
    }

    public void decodeNextScanline(byte[] bArr, int i, int i2) {
        this.changingElemSize = 0;
        boolean z = true;
        while (true) {
            if (i2 >= this.w) {
                break;
            }
            while (z) {
                int nextNBits = nextNBits(10);
                short s = white[nextNBits];
                short s2 = s & 1;
                int i3 = (s >>> 1) & 15;
                if (i3 == 12) {
                    short s3 = additionalMakeup[(12 & (nextNBits << 2)) | nextLesserThan8Bits(2)];
                    i2 += (s3 >>> 4) & 4095;
                    updatePointer(4 - ((s3 >>> 1) & 7));
                } else if (i3 == 0) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.encountered", new Object[0]));
                } else if (i3 != 15) {
                    i2 += (s >>> 5) & 2047;
                    updatePointer(10 - i3);
                    if (s2 == 0) {
                        int[] iArr = this.currChangingElems;
                        int i4 = this.changingElemSize;
                        this.changingElemSize = i4 + 1;
                        iArr[i4] = i2;
                        z = false;
                    }
                } else {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.white.run", new Object[0]));
                }
            }
            if (i2 != this.w) {
                while (!z) {
                    short s4 = initBlack[nextLesserThan8Bits(4)];
                    int i5 = (s4 >>> 1) & 15;
                    int i6 = (s4 >>> 5) & 2047;
                    if (i6 == 100) {
                        short s5 = black[nextNBits(9)];
                        short s6 = s5 & 1;
                        int i7 = (s5 >>> 1) & 15;
                        int i8 = (s5 >>> 5) & 2047;
                        if (i7 == 12) {
                            updatePointer(5);
                            short s7 = additionalMakeup[nextLesserThan8Bits(4)];
                            int i9 = (s7 >>> 4) & 4095;
                            setToBlack(bArr, i, i2, i9);
                            r14 = i2 + i9;
                            updatePointer(4 - ((s7 >>> 1) & 7));
                        } else if (i7 != 15) {
                            setToBlack(bArr, i, i2, i8);
                            r14 = i2 + i8;
                            updatePointer(9 - i7);
                            if (s6 == 0) {
                                int[] iArr2 = this.currChangingElems;
                                int i10 = this.changingElemSize;
                                this.changingElemSize = i10 + 1;
                                iArr2[i10] = r14;
                            }
                        } else {
                            throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.black.run", new Object[0]));
                        }
                    } else if (i6 == 200) {
                        short s8 = twoBitBlack[nextLesserThan8Bits(2)];
                        int i11 = (s8 >>> 5) & 2047;
                        setToBlack(bArr, i, i2, i11);
                        r14 = i2 + i11;
                        updatePointer(2 - ((s8 >>> 1) & 15));
                        int[] iArr3 = this.currChangingElems;
                        int i12 = this.changingElemSize;
                        this.changingElemSize = i12 + 1;
                        iArr3[i12] = r14;
                    } else {
                        setToBlack(bArr, i, i2, i6);
                        r14 = i2 + i6;
                        updatePointer(4 - i5);
                        int[] iArr4 = this.currChangingElems;
                        int i13 = this.changingElemSize;
                        this.changingElemSize = i13 + 1;
                        iArr4[i13] = r14;
                    }
                    z = true;
                }
                if (i2 == this.w) {
                    if (this.compression == 2) {
                        advancePointer();
                    }
                }
            } else if (this.compression == 2) {
                advancePointer();
            }
        }
        int[] iArr5 = this.currChangingElems;
        int i14 = this.changingElemSize;
        this.changingElemSize = i14 + 1;
        iArr5[i14] = i2;
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public void decode2D(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        char c;
        int i3;
        this.data = bArr2;
        this.compression = 3;
        ? r4 = 0;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = 7;
        int i5 = (this.w + 7) / 8;
        int[] iArr = new int[2];
        this.oneD = (int) (j & 1);
        char c2 = 1;
        this.uncompressedMode = (int) ((j & 2) >> 1);
        this.fillBits = (int) ((j & 4) >> 2);
        if (readEOL(true) == 1) {
            decodeNextScanline(bArr, 0, i);
            int i6 = i5 + 0;
            int i7 = 1;
            while (i7 < i2) {
                if (readEOL(r4) == 0) {
                    int[] iArr2 = this.prevChangingElems;
                    this.prevChangingElems = this.currChangingElems;
                    this.currChangingElems = iArr2;
                    int i8 = -1;
                    this.lastChangingElement = r4;
                    int i9 = i;
                    boolean z = true;
                    int i10 = 0;
                    char c3 = r4;
                    while (i9 < this.w) {
                        getNextChangingElement(i8, z, iArr);
                        int i11 = iArr[c3];
                        i8 = iArr[c2];
                        int i12 = twoDCodes[nextLesserThan8Bits(i4)] & 255;
                        int i13 = (i12 & 120) >>> 3;
                        int i14 = i12 & i4;
                        if (i13 == 0) {
                            if (!z) {
                                setToBlack(bArr, i6, i9, i8 - i9);
                            }
                            updatePointer(7 - i14);
                            i9 = i8;
                        } else if (i13 == 1) {
                            updatePointer(7 - i14);
                            if (z) {
                                int decodeWhiteCodeWord = i9 + decodeWhiteCodeWord();
                                int i15 = i10 + 1;
                                this.currChangingElems[i10] = decodeWhiteCodeWord;
                                int decodeBlackCodeWord = decodeBlackCodeWord();
                                setToBlack(bArr, i6, decodeWhiteCodeWord, decodeBlackCodeWord);
                                i9 = decodeWhiteCodeWord + decodeBlackCodeWord;
                                i3 = i15 + 1;
                                this.currChangingElems[i15] = i9;
                            } else {
                                int decodeBlackCodeWord2 = decodeBlackCodeWord();
                                setToBlack(bArr, i6, i9, decodeBlackCodeWord2);
                                int i16 = i9 + decodeBlackCodeWord2;
                                int i17 = i10 + 1;
                                this.currChangingElems[i10] = i16;
                                i9 = i16 + decodeWhiteCodeWord();
                                i3 = i17 + 1;
                                this.currChangingElems[i17] = i9;
                            }
                            i10 = i3;
                            i8 = i9;
                        } else if (i13 <= 8) {
                            int i18 = i11 + (i13 - 5);
                            int i19 = i10 + 1;
                            this.currChangingElems[i10] = i18;
                            if (!z) {
                                setToBlack(bArr, i6, i9, i18 - i9);
                            }
                            z = !z;
                            updatePointer(7 - i14);
                            i8 = i18;
                            i9 = i8;
                            i10 = i19;
                            c = 0;
                            i4 = 7;
                            c2 = 1;
                            c3 = c;
                        } else {
                            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.code.encountered.while.decoding.2d.group.3.compressed.data", new Object[0]));
                        }
                        c = 0;
                        c2 = 1;
                        c3 = c;
                    }
                    this.currChangingElems[i10] = i9;
                    this.changingElemSize = i10 + 1;
                } else {
                    decodeNextScanline(bArr, i6, i);
                }
                i6 += i5;
                i7++;
                r4 = 0;
                i4 = 7;
                c2 = 1;
            }
            return;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("first.scanline.must.be.1d.encoded", new Object[0]));
    }

    public void decodeT6(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        int[] iArr;
        int i3;
        boolean z;
        int i4;
        this.data = bArr2;
        this.compression = 4;
        int i5 = 0;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i6 = this.w;
        int i7 = (i6 + 7) / 8;
        int[] iArr2 = new int[2];
        char c = 1;
        this.uncompressedMode = (int) ((j & 2) >> 1);
        int[] iArr3 = this.currChangingElems;
        this.changingElemSize = 0;
        int i8 = 0 + 1;
        this.changingElemSize = i8;
        iArr3[0] = i6;
        this.changingElemSize = i8 + 1;
        iArr3[i8] = i6;
        int i9 = i2;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = -1;
            int[] iArr4 = this.prevChangingElems;
            this.prevChangingElems = this.currChangingElems;
            this.currChangingElems = iArr4;
            this.lastChangingElement = i5;
            int i13 = i;
            int i14 = 0;
            boolean z2 = true;
            while (i13 < this.w && this.bytePointer < this.data.length) {
                getNextChangingElement(i12, z2, iArr);
                int i15 = iArr[i5];
                int i16 = iArr[c];
                byte b = twoDCodes[nextLesserThan8Bits(7)] & UByte.MAX_VALUE;
                int i17 = (b & 120) >>> 3;
                byte b2 = b & 7;
                if (i17 == 0) {
                    if (!z2) {
                        setToBlack(bArr, i11, i13, i16 - i13);
                    }
                    updatePointer(7 - b2);
                    i12 = i16;
                } else {
                    if (i17 == 1) {
                        updatePointer(7 - b2);
                        if (z2) {
                            int decodeWhiteCodeWord = i13 + decodeWhiteCodeWord();
                            int i18 = i14 + 1;
                            iArr4[i14] = decodeWhiteCodeWord;
                            int decodeBlackCodeWord = decodeBlackCodeWord();
                            setToBlack(bArr, i11, decodeWhiteCodeWord, decodeBlackCodeWord);
                            i13 = decodeWhiteCodeWord + decodeBlackCodeWord;
                            i4 = i18 + 1;
                            iArr4[i18] = i13;
                        } else {
                            int decodeBlackCodeWord2 = decodeBlackCodeWord();
                            setToBlack(bArr, i11, i13, decodeBlackCodeWord2);
                            int i19 = i13 + decodeBlackCodeWord2;
                            int i20 = i14 + 1;
                            iArr4[i14] = i19;
                            i13 = i19 + decodeWhiteCodeWord();
                            i4 = i20 + 1;
                            iArr4[i20] = i13;
                        }
                        i14 = i4;
                        i12 = i13;
                    } else if (i17 <= 8) {
                        i12 = i15 + (i17 - 5);
                        int i21 = i14 + 1;
                        iArr4[i14] = i12;
                        if (!z2) {
                            setToBlack(bArr, i11, i13, i12 - i13);
                        }
                        z2 = !z2;
                        updatePointer(7 - b2);
                        i14 = i21;
                    } else if (i17 != 11) {
                        i5 = 0;
                        i13 = this.w;
                        updatePointer(7 - b2);
                        iArr = iArr;
                        c = 1;
                    } else if (nextLesserThan8Bits(3) == 7) {
                        boolean z3 = false;
                        int i22 = 0;
                        while (!z3) {
                            while (nextLesserThan8Bits(1) != 1) {
                                i22++;
                            }
                            if (i22 > 5) {
                                i22 -= 6;
                                if (!z2 && i22 > 0) {
                                    iArr4[i14] = i13;
                                    i14++;
                                }
                                i13 += i22;
                                if (i22 > 0) {
                                    z2 = true;
                                }
                                if (nextLesserThan8Bits(1) == 0) {
                                    if (!z2) {
                                        iArr4[i14] = i13;
                                        i14++;
                                    }
                                    z = true;
                                } else {
                                    if (z2) {
                                        iArr4[i14] = i13;
                                        i14++;
                                    }
                                    z = false;
                                }
                                z2 = z;
                                z3 = true;
                            }
                            if (i22 == 5) {
                                if (!z2) {
                                    iArr4[i14] = i13;
                                    i14++;
                                }
                                i3 = i13 + i22;
                                z2 = true;
                            } else {
                                int i23 = i13 + i22;
                                iArr4[i14] = i23;
                                setToBlack(bArr, i11, i23, 1);
                                i3 = i23 + 1;
                                i14++;
                                z2 = false;
                            }
                        }
                    } else {
                        throw new InvalidImageException(MessageLocalization.getComposedMessage("invalid.code.encountered.while.decoding.2d.group.4.compressed.data", new Object[0]));
                    }
                    iArr = iArr;
                    i5 = 0;
                    c = 1;
                }
                i13 = i12;
                iArr = iArr;
                i5 = 0;
                c = 1;
            }
            if (i14 < iArr4.length) {
                iArr4[i14] = i13;
                i14++;
            }
            this.changingElemSize = i14;
            i11 += i7;
            i10++;
            i9 = i2;
            iArr2 = iArr;
            c = 1;
        }
    }

    private void setToBlack(byte[] bArr, int i, int i2, int i3) {
        int i4 = (i * 8) + i2;
        int i5 = i3 + i4;
        int i6 = i4 >> 3;
        int i7 = i4 & 7;
        if (i7 > 0) {
            int i8 = 1 << (7 - i7);
            byte b = bArr[i6];
            while (i8 > 0 && i4 < i5) {
                b = (byte) (b | i8);
                i8 >>= 1;
                i4++;
            }
            bArr[i6] = b;
        }
        int i9 = i4 >> 3;
        while (i4 < i5 - 7) {
            bArr[i9] = -1;
            i4 += 8;
            i9++;
        }
        while (i4 < i5) {
            int i10 = i4 >> 3;
            if (!this.recoverFromImageError || i10 < bArr.length) {
                bArr[i10] = (byte) (bArr[i10] | (1 << (7 - (i4 & 7))));
            }
            i4++;
        }
    }

    private int decodeWhiteCodeWord() {
        boolean z = true;
        int i = 0;
        while (z) {
            int nextNBits = nextNBits(10);
            short s = white[nextNBits];
            short s2 = s & 1;
            int i2 = (s >>> 1) & 15;
            if (i2 == 12) {
                short s3 = additionalMakeup[((nextNBits << 2) & 12) | nextLesserThan8Bits(2)];
                i += (s3 >>> 4) & 4095;
                updatePointer(4 - ((s3 >>> 1) & 7));
            } else if (i2 != 0) {
                if (i2 != 15) {
                    i += (s >>> 5) & 2047;
                    updatePointer(10 - i2);
                    if (s2 != 0) {
                    }
                } else if (i != 0) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.white.run", new Object[0]));
                }
                z = false;
            } else {
                throw new InvalidImageException(MessageLocalization.getComposedMessage("invalid.code.encountered", new Object[0]));
            }
        }
        return i;
    }

    private int decodeBlackCodeWord() {
        boolean z = false;
        int i = 0;
        while (!z) {
            short s = initBlack[nextLesserThan8Bits(4)];
            int i2 = (s >>> 1) & 15;
            int i3 = (s >>> 5) & 2047;
            if (i3 == 100) {
                short s2 = black[nextNBits(9)];
                short s3 = s2 & 1;
                int i4 = (s2 >>> 1) & 15;
                int i5 = (s2 >>> 5) & 2047;
                if (i4 == 12) {
                    updatePointer(5);
                    short s4 = additionalMakeup[nextLesserThan8Bits(4)];
                    i += (s4 >>> 4) & 4095;
                    updatePointer(4 - ((s4 >>> 1) & 7));
                } else if (i4 != 15) {
                    i += i5;
                    updatePointer(9 - i4);
                    if (s3 != 0) {
                    }
                } else {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("eol.code.word.encountered.in.black.run", new Object[0]));
                }
            } else if (i3 == 200) {
                short s5 = twoBitBlack[nextLesserThan8Bits(2)];
                i += (s5 >>> 5) & 2047;
                updatePointer(2 - ((s5 >>> 1) & 15));
            } else {
                i += i3;
                updatePointer(4 - i2);
            }
            z = true;
        }
        return i;
    }

    private int readEOL(boolean z) {
        int nextNBits;
        int i = this.fillBits;
        if (i == 0) {
            int nextNBits2 = nextNBits(12);
            if (z && nextNBits2 == 0 && nextNBits(4) == 1) {
                this.fillBits = 1;
                return 1;
            } else if (nextNBits2 != 1) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("scanline.must.begin.with.eol.code.word", new Object[0]));
            }
        } else if (i == 1) {
            int i2 = 8 - this.bitPointer;
            if (nextNBits(i2) != 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            } else if (i2 >= 4 || nextNBits(8) == 0) {
                do {
                    nextNBits = nextNBits(8);
                    if (nextNBits != 1) {
                    }
                } while (nextNBits == 0);
                throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            } else {
                throw new RuntimeException(MessageLocalization.getComposedMessage("all.fill.bits.preceding.eol.code.must.be.0", new Object[0]));
            }
        }
        if (this.oneD == 0) {
            return 1;
        }
        return nextLesserThan8Bits(1);
    }

    private void getNextChangingElement(int i, boolean z, int[] iArr) {
        int[] iArr2 = this.prevChangingElems;
        int i2 = this.changingElemSize;
        int i3 = this.lastChangingElement;
        int i4 = i3 > 0 ? i3 - 1 : 0;
        int i5 = z ? i4 & -2 : i4 | 1;
        while (true) {
            if (i5 >= i2) {
                break;
            }
            int i6 = iArr2[i5];
            if (i6 > i) {
                this.lastChangingElement = i5;
                iArr[0] = i6;
                break;
            }
            i5 += 2;
        }
        int i7 = i5 + 1;
        if (i7 < i2) {
            iArr[1] = iArr2[i7];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextNBits(int r12) {
        /*
            r11 = this;
            byte[] r0 = r11.data
            int r1 = r0.length
            int r1 = r1 + -1
            int r2 = r11.bytePointer
            long r3 = r11.fillOrder
            r5 = 0
            r6 = 1
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0028
            byte r3 = r0[r2]
            if (r2 != r1) goto L_0x0017
        L_0x0014:
            r0 = 0
        L_0x0015:
            r1 = 0
            goto L_0x0056
        L_0x0017:
            int r4 = r2 + 1
            if (r4 != r1) goto L_0x001e
            byte r0 = r0[r4]
            goto L_0x0015
        L_0x001e:
            byte r1 = r0[r4]
            int r2 = r2 + 2
            byte r0 = r0[r2]
        L_0x0024:
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x0056
        L_0x0028:
            r6 = 2
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0099
            byte[] r3 = com.itextpdf.text.pdf.codec.TIFFFaxDecoder.flipTable
            byte r4 = r0[r2]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = r3[r4]
            if (r2 != r1) goto L_0x003a
            r3 = r4
            goto L_0x0014
        L_0x003a:
            int r6 = r2 + 1
            if (r6 != r1) goto L_0x0046
            byte r0 = r0[r6]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r3[r0]
            r3 = r4
            goto L_0x0015
        L_0x0046:
            byte r1 = r0[r6]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = r3[r1]
            int r2 = r2 + 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r3[r0]
            r3 = r4
            goto L_0x0024
        L_0x0056:
            int r2 = r11.bitPointer
            r4 = 8
            int r2 = 8 - r2
            int r12 = r12 - r2
            if (r12 <= r4) goto L_0x0064
            int r6 = r12 + -8
            r7 = 8
            goto L_0x0066
        L_0x0064:
            r7 = r12
            r6 = 0
        L_0x0066:
            int r8 = r11.bytePointer
            int r8 = r8 + 1
            r11.bytePointer = r8
            int[] r9 = com.itextpdf.text.pdf.codec.TIFFFaxDecoder.table1
            r2 = r9[r2]
            r2 = r2 & r3
            int r12 = r2 << r12
            int[] r2 = com.itextpdf.text.pdf.codec.TIFFFaxDecoder.table2
            r3 = r2[r7]
            r0 = r0 & r3
            int r3 = 8 - r7
            int r0 = r0 >>> r3
            if (r6 == 0) goto L_0x008c
            int r0 = r0 << r6
            r2 = r2[r6]
            r1 = r1 & r2
            int r2 = 8 - r6
            int r1 = r1 >>> r2
            r0 = r0 | r1
            int r8 = r8 + 1
            r11.bytePointer = r8
            r11.bitPointer = r6
            goto L_0x0097
        L_0x008c:
            if (r7 != r4) goto L_0x0095
            r11.bitPointer = r5
            int r8 = r8 + 1
            r11.bytePointer = r8
            goto L_0x0097
        L_0x0095:
            r11.bitPointer = r7
        L_0x0097:
            r12 = r12 | r0
            return r12
        L_0x0099:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "tiff.fill.order.tag.must.be.either.1.or.2"
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r0)
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFFaxDecoder.nextNBits(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextLesserThan8Bits(int r10) {
        /*
            r9 = this;
            byte[] r0 = r9.data
            int r1 = r0.length
            int r1 = r1 + -1
            int r2 = r9.bytePointer
            long r3 = r9.fillOrder
            r5 = 0
            r6 = 1
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x001b
            byte r3 = r0[r2]
            if (r2 != r1) goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            int r2 = r2 + 1
            byte r0 = r0[r2]
            goto L_0x0042
        L_0x001b:
            r6 = 2
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x007b
            boolean r3 = r9.recoverFromImageError
            if (r3 == 0) goto L_0x002b
            int r0 = r0.length
            if (r2 < r0) goto L_0x002b
            r0 = 0
            r3 = 0
            goto L_0x0042
        L_0x002b:
            byte[] r0 = com.itextpdf.text.pdf.codec.TIFFFaxDecoder.flipTable
            byte[] r3 = r9.data
            byte r4 = r3[r2]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = r0[r4]
            if (r2 != r1) goto L_0x0039
            r3 = r4
            goto L_0x0014
        L_0x0039:
            int r2 = r2 + 1
            byte r1 = r3[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = r0[r1]
            r3 = r4
        L_0x0042:
            int r1 = r9.bitPointer
            int r2 = 8 - r1
            int r4 = r10 - r2
            int r6 = r2 - r10
            if (r6 < 0) goto L_0x0062
            int[] r0 = com.itextpdf.text.pdf.codec.TIFFFaxDecoder.table1
            r0 = r0[r2]
            r0 = r0 & r3
            int r0 = r0 >>> r6
            int r1 = r1 + r10
            r9.bitPointer = r1
            r10 = 8
            if (r1 != r10) goto L_0x007a
            r9.bitPointer = r5
            int r10 = r9.bytePointer
            int r10 = r10 + 1
            r9.bytePointer = r10
            goto L_0x007a
        L_0x0062:
            int[] r10 = com.itextpdf.text.pdf.codec.TIFFFaxDecoder.table1
            r10 = r10[r2]
            r10 = r10 & r3
            int r1 = -r6
            int r10 = r10 << r1
            int[] r1 = com.itextpdf.text.pdf.codec.TIFFFaxDecoder.table2
            r1 = r1[r4]
            r0 = r0 & r1
            int r1 = 8 - r4
            int r0 = r0 >>> r1
            r0 = r0 | r10
            int r10 = r9.bytePointer
            int r10 = r10 + 1
            r9.bytePointer = r10
            r9.bitPointer = r4
        L_0x007a:
            return r0
        L_0x007b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "tiff.fill.order.tag.must.be.either.1.or.2"
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r1, r0)
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFFaxDecoder.nextLesserThan8Bits(int):int");
    }

    private void updatePointer(int i) {
        int i2 = this.bitPointer - i;
        if (i2 < 0) {
            this.bytePointer--;
            this.bitPointer = i2 + 8;
            return;
        }
        this.bitPointer = i2;
    }

    private boolean advancePointer() {
        if (this.bitPointer != 0) {
            this.bytePointer++;
            this.bitPointer = 0;
        }
        return true;
    }

    public void setRecoverFromImageError(boolean z) {
        this.recoverFromImageError = z;
    }
}
