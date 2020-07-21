package org.spongycastle.crypto.engines;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.ByteBuffer;
import java.lang.reflect.Array;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.crypto.tls.CipherSuite;

public class RijndaelEngine implements BlockCipher {
    private static final int MAXKC = 64;
    private static final int MAXROUNDS = 14;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, 111, -59, ByteBuffer.ZERO, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ByteCompanionObject.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, DocWriter.FORWARD, -124, 83, -47, 0, -19, DocWriter.SPACE, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, DocWriter.LT, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, BidiOrder.CS, 19, -20, 95, -105, 68, 23, -60, -89, 126, DocWriter.EQUALS, 100, 93, 25, 115, 96, -127, 79, -36, DocWriter.QUOTE, 42, -112, -120, 70, -18, -72, 20, -34, 94, BidiOrder.AN, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, DocWriter.GT, -75, 102, 72, 3, -10, BidiOrder.BN, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, BidiOrder.WS, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, BidiOrder.NSM, -65, -26, 66, 104, 65, -103, 45, BidiOrder.B, -80, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, ByteBuffer.ZERO, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, DocWriter.FORWARD, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, DocWriter.EQUALS, -18, 76, -107, BidiOrder.AN, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, BidiOrder.B, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, BidiOrder.WS, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, DocWriter.QUOTE, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, BidiOrder.BN, -86, 24, -66, 27, -4, 86, DocWriter.GT, 75, -58, -46, 121, DocWriter.SPACE, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, ByteCompanionObject.MIN_VALUE, -20, 95, 96, 81, ByteCompanionObject.MAX_VALUE, -87, 25, -75, 74, BidiOrder.NSM, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, DocWriter.LT, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, BidiOrder.CS, 125};
    private static final byte[] aLogtable = {0, 3, 5, BidiOrder.B, BidiOrder.WS, 51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, 30, DocWriter.QUOTE, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, BidiOrder.CS, 20, DocWriter.LT, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, ByteCompanionObject.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, ByteBuffer.ZERO, 80, -16, BidiOrder.AN, 29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 125, -121, -110, -83, -20, DocWriter.FORWARD, 113, -109, -82, -23, DocWriter.SPACE, 96, -96, -5, 22, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 94, -30, DocWriter.EQUALS, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, ByteCompanionObject.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, DocWriter.GT, 66, -58, 81, -13, BidiOrder.BN, 18, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, BidiOrder.NSM, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 1, 3, 5, BidiOrder.B, BidiOrder.WS, 51, 85, -1, 26, 46, 114, -106, -95, -8, 19, 53, 95, -31, 56, 72, -40, 115, -107, -92, -9, 2, 6, 10, 30, DocWriter.QUOTE, 102, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, 49, 83, -11, 4, BidiOrder.CS, 20, DocWriter.LT, 68, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, -32, 59, 77, -41, 98, -90, -15, 8, 24, 40, 120, -120, -125, -98, -71, -48, 107, -67, -36, ByteCompanionObject.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, ByteBuffer.ZERO, 80, -16, BidiOrder.AN, 29, 39, 105, -69, -42, 97, -93, -2, 25, 43, 125, -121, -110, -83, -20, DocWriter.FORWARD, 113, -109, -82, -23, DocWriter.SPACE, 96, -96, -5, 22, 58, 78, -46, 109, -73, -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 94, -30, DocWriter.EQUALS, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, 100, -84, -17, 42, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, ByteCompanionObject.MIN_VALUE, -101, -74, -63, 88, -24, 35, 101, -81, -22, 37, 111, -79, -56, 67, -59, 84, -4, 31, 33, 99, -91, -12, 7, 9, 27, 45, 119, -103, -80, -53, 70, -54, 69, -49, 74, -34, 121, -117, -122, -111, -88, -29, DocWriter.GT, 66, -58, 81, -13, BidiOrder.BN, 18, 54, 90, -18, 41, 123, -115, -116, -113, -118, -123, -108, -89, -14, BidiOrder.NSM, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, 36, 108, -76, -57, 82, -10, 1};
    private static final byte[] logtable = {0, 0, 25, 1, 50, 2, 26, -58, 75, -57, 27, 104, 51, -18, -33, 3, 100, 4, -32, BidiOrder.BN, 52, -115, -127, -17, 76, 113, 8, -56, -8, 105, 28, -63, 125, -62, 29, -75, -7, -71, 39, 106, 77, -28, -90, 114, -102, -55, 9, 120, 101, DocWriter.FORWARD, -118, 5, 33, BidiOrder.B, -31, 36, 18, -16, -126, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, 64, 70, -125, 56, 102, -35, -3, ByteBuffer.ZERO, -65, 6, -117, 98, -77, 37, -30, -104, DocWriter.QUOTE, -120, -111, 16, 126, 110, 72, -61, -93, -74, 30, 66, 58, 107, 40, 84, -6, -123, DocWriter.EQUALS, -70, 43, 121, 10, 21, -101, -97, 94, -54, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, 22, BidiOrder.AN, -11, 89, -53, 95, -80, -100, -87, 81, -96, ByteCompanionObject.MAX_VALUE, BidiOrder.CS, -10, 111, 23, -60, 73, -20, -40, 67, 31, 45, -92, 118, 123, -73, -52, -69, DocWriter.GT, 90, -5, 96, -79, -122, 59, 82, -95, 108, -86, 85, 41, -99, -105, -78, -121, -112, 97, -66, -36, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, 63, 91, -47, 83, 57, -124, DocWriter.LT, 65, -94, 109, 71, 20, 42, -98, 93, 86, -14, -45, -85, 68, BidiOrder.WS, -110, -39, 35, DocWriter.SPACE, 46, -119, -76, 124, -72, 38, 119, -103, -29, -91, 103, 74, -19, -34, -59, 49, -2, 24, BidiOrder.NSM, 99, -116, ByteCompanionObject.MIN_VALUE, -64, -9, 112, 7};
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 77, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 47, 94, 188, 99, 198, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 53, 106, 212, 179, 125, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 239, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA};
    static byte[][] shifts0 = {new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, 24}, new byte[]{0, 8, 16, DocWriter.SPACE}, new byte[]{0, 8, 24, DocWriter.SPACE}};
    static byte[][] shifts1 = {new byte[]{0, 24, 16, 8}, new byte[]{0, DocWriter.SPACE, 24, 16}, new byte[]{0, 40, DocWriter.SPACE, 24}, new byte[]{0, ByteBuffer.ZERO, 40, 24}, new byte[]{0, 56, 40, DocWriter.SPACE}};
    private long A0;
    private long A1;
    private long A2;
    private long A3;
    private int BC;
    private long BC_MASK;
    private int ROUNDS;
    private int blockBits;
    private boolean forEncryption;
    private byte[] shifts0SC;
    private byte[] shifts1SC;
    private long[][] workingKey;

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Rijndael";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    private byte mul0x2(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & UByte.MAX_VALUE) + 25];
        }
        return 0;
    }

    private byte mul0x3(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & UByte.MAX_VALUE) + 1];
        }
        return 0;
    }

    private byte mul0x9(int i) {
        if (i >= 0) {
            return aLogtable[i + 199];
        }
        return 0;
    }

    private byte mul0xb(int i) {
        if (i >= 0) {
            return aLogtable[i + 104];
        }
        return 0;
    }

    private byte mul0xd(int i) {
        if (i >= 0) {
            return aLogtable[i + Jpeg.M_APPE];
        }
        return 0;
    }

    private byte mul0xe(int i) {
        if (i >= 0) {
            return aLogtable[i + 223];
        }
        return 0;
    }

    private void KeyAddition(long[] jArr) {
        this.A0 ^= jArr[0];
        this.A1 ^= jArr[1];
        this.A2 ^= jArr[2];
        this.A3 ^= jArr[3];
    }

    private long shift(long j, int i) {
        return ((j << (this.BC - i)) | (j >>> i)) & this.BC_MASK;
    }

    private void ShiftRow(byte[] bArr) {
        this.A1 = shift(this.A1, bArr[1]);
        this.A2 = shift(this.A2, bArr[2]);
        this.A3 = shift(this.A3, bArr[3]);
    }

    private long applyS(long j, byte[] bArr) {
        long j2 = 0;
        for (int i = 0; i < this.BC; i += 8) {
            j2 |= ((long) (bArr[(int) ((j >> i) & 255)] & UByte.MAX_VALUE)) << i;
        }
        return j2;
    }

    private void Substitution(byte[] bArr) {
        this.A0 = applyS(this.A0, bArr);
        this.A1 = applyS(this.A1, bArr);
        this.A2 = applyS(this.A2, bArr);
        this.A3 = applyS(this.A3, bArr);
    }

    private void MixColumn() {
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < this.BC; i += 8) {
            int i2 = (int) ((this.A0 >> i) & 255);
            int i3 = (int) ((this.A1 >> i) & 255);
            int i4 = (int) ((this.A2 >> i) & 255);
            int i5 = (int) ((this.A3 >> i) & 255);
            j |= ((long) ((((mul0x2(i2) ^ mul0x3(i3)) ^ i4) ^ i5) & UByte.MAX_VALUE)) << i;
            j2 |= ((long) ((((mul0x2(i3) ^ mul0x3(i4)) ^ i5) ^ i2) & UByte.MAX_VALUE)) << i;
            j3 |= ((long) ((((mul0x2(i4) ^ mul0x3(i5)) ^ i2) ^ i3) & UByte.MAX_VALUE)) << i;
            j4 |= ((long) ((((mul0x2(i5) ^ mul0x3(i2)) ^ i3) ^ i4) & UByte.MAX_VALUE)) << i;
        }
        this.A0 = j;
        this.A1 = j2;
        this.A2 = j3;
        this.A3 = j4;
    }

    private void InvMixColumn() {
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < this.BC; i += 8) {
            int i2 = (int) ((this.A0 >> i) & 255);
            int i3 = (int) ((this.A1 >> i) & 255);
            int i4 = (int) ((this.A2 >> i) & 255);
            int i5 = (int) ((this.A3 >> i) & 255);
            byte b = -1;
            byte b2 = i2 != 0 ? logtable[i2 & 255] & UByte.MAX_VALUE : -1;
            byte b3 = i3 != 0 ? logtable[i3 & 255] & UByte.MAX_VALUE : -1;
            byte b4 = i4 != 0 ? logtable[i4 & 255] & UByte.MAX_VALUE : -1;
            if (i5 != 0) {
                b = logtable[i5 & 255] & UByte.MAX_VALUE;
            }
            j |= ((long) ((((mul0xe(b2) ^ mul0xb(b3)) ^ mul0xd(b4)) ^ mul0x9(b)) & UByte.MAX_VALUE)) << i;
            j2 |= ((long) ((((mul0xe(b3) ^ mul0xb(b4)) ^ mul0xd(b)) ^ mul0x9(b2)) & UByte.MAX_VALUE)) << i;
            j3 |= ((long) ((((mul0xe(b4) ^ mul0xb(b)) ^ mul0xd(b2)) ^ mul0x9(b3)) & UByte.MAX_VALUE)) << i;
            j4 |= ((long) ((((mul0xe(b) ^ mul0xb(b2)) ^ mul0xd(b3)) ^ mul0x9(b4)) & UByte.MAX_VALUE)) << i;
        }
        this.A0 = j;
        this.A1 = j2;
        this.A2 = j3;
        this.A3 = j4;
    }

    private long[][] generateWorkingKey(byte[] bArr) {
        int i;
        int i2;
        int i3 = 8;
        int length = bArr.length * 8;
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, 4, 64);
        long[][] jArr = (long[][]) Array.newInstance(long.class, 15, 4);
        int i4 = 4;
        if (length == 128) {
            i = 4;
        } else if (length == 160) {
            i = 5;
        } else if (length == 192) {
            i = 6;
        } else if (length == 224) {
            i = 7;
        } else if (length == 256) {
            i = 8;
        } else {
            throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
        }
        if (length >= this.blockBits) {
            this.ROUNDS = i + 6;
        } else {
            this.ROUNDS = (this.BC / 8) + 6;
        }
        char c = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < bArr.length) {
            bArr2[i5 % 4][i5 / 4] = bArr[i6];
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < i && i8 < (this.ROUNDS + 1) * (this.BC / 8)) {
            int i9 = 0;
            while (i9 < i4) {
                int i10 = this.BC;
                long[] jArr2 = jArr[i8 / (i10 / 8)];
                jArr2[i9] = (((long) (bArr2[i9][i7] & UByte.MAX_VALUE)) << ((i8 * 8) % i10)) | jArr2[i9];
                i9++;
                i4 = 4;
            }
            i7++;
            i8++;
            i4 = 4;
        }
        int i11 = 0;
        while (i8 < (this.ROUNDS + 1) * (this.BC / i3)) {
            int i12 = 0;
            while (i12 < 4) {
                byte[] bArr3 = bArr2[i12];
                i12++;
                bArr3[c] = (byte) (bArr3[c] ^ S[bArr2[i12 % 4][i - 1] & UByte.MAX_VALUE]);
            }
            byte[] bArr4 = bArr2[c];
            int i13 = i11 + 1;
            bArr4[c] = (byte) (rcon[i11] ^ bArr4[c]);
            if (i <= 6) {
                for (int i14 = 1; i14 < i; i14++) {
                    for (int i15 = 0; i15 < 4; i15++) {
                        byte[] bArr5 = bArr2[i15];
                        bArr5[i14] = (byte) (bArr5[i14] ^ bArr2[i15][i14 - 1]);
                    }
                }
            } else {
                int i16 = 1;
                while (true) {
                    i2 = 4;
                    if (i16 >= 4) {
                        break;
                    }
                    int i17 = 0;
                    while (i17 < i2) {
                        byte[] bArr6 = bArr2[i17];
                        bArr6[i16] = (byte) (bArr6[i16] ^ bArr2[i17][i16 - 1]);
                        i17++;
                        i2 = 4;
                    }
                    i16++;
                }
                for (int i18 = 0; i18 < 4; i18++) {
                    byte[] bArr7 = bArr2[i18];
                    bArr7[4] = (byte) (bArr7[4] ^ S[bArr2[i18][3] & UByte.MAX_VALUE]);
                }
                int i19 = 5;
                while (i19 < i) {
                    int i20 = 0;
                    while (i20 < i2) {
                        byte[] bArr8 = bArr2[i20];
                        bArr8[i19] = (byte) (bArr8[i19] ^ bArr2[i20][i19 - 1]);
                        i20++;
                        i2 = 4;
                    }
                    i19++;
                    i2 = 4;
                }
            }
            int i21 = 0;
            while (i21 < i && i8 < (this.ROUNDS + 1) * (this.BC / i3)) {
                for (int i22 = 0; i22 < 4; i22++) {
                    int i23 = this.BC;
                    long[] jArr3 = jArr[i8 / (i23 / 8)];
                    jArr3[i22] = (((long) (bArr2[i22][i21] & UByte.MAX_VALUE)) << ((i8 * 8) % i23)) | jArr3[i22];
                }
                i21++;
                i8++;
                i3 = 8;
            }
            i11 = i13;
            c = 0;
            i3 = 8;
        }
        return jArr;
    }

    public RijndaelEngine() {
        this(128);
    }

    public RijndaelEngine(int i) {
        if (i == 128) {
            this.BC = 32;
            this.BC_MASK = BodyPartID.bodyIdMax;
            this.shifts0SC = shifts0[0];
            this.shifts1SC = shifts1[0];
        } else if (i == 160) {
            this.BC = 40;
            this.BC_MASK = 1099511627775L;
            this.shifts0SC = shifts0[1];
            this.shifts1SC = shifts1[1];
        } else if (i == 192) {
            this.BC = 48;
            this.BC_MASK = 281474976710655L;
            this.shifts0SC = shifts0[2];
            this.shifts1SC = shifts1[2];
        } else if (i == 224) {
            this.BC = 56;
            this.BC_MASK = 72057594037927935L;
            this.shifts0SC = shifts0[3];
            this.shifts1SC = shifts1[3];
        } else if (i == 256) {
            this.BC = 64;
            this.BC_MASK = -1;
            this.shifts0SC = shifts0[4];
            this.shifts1SC = shifts1[4];
        } else {
            throw new IllegalArgumentException("unknown blocksize to Rijndael");
        }
        this.blockBits = i;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Rijndael init - " + cipherParameters.getClass().getName());
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.BC / 2;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey != null) {
            int i3 = this.BC;
            if ((i3 / 2) + i > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if ((i3 / 2) + i2 <= bArr2.length) {
                if (this.forEncryption) {
                    unpackBlock(bArr, i);
                    encryptBlock(this.workingKey);
                    packBlock(bArr2, i2);
                } else {
                    unpackBlock(bArr, i);
                    decryptBlock(this.workingKey);
                    packBlock(bArr2, i2);
                }
                return this.BC / 2;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
    }

    private void unpackBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        this.A0 = (long) (bArr[i] & UByte.MAX_VALUE);
        int i3 = i2 + 1;
        this.A1 = (long) (bArr[i2] & UByte.MAX_VALUE);
        int i4 = i3 + 1;
        this.A2 = (long) (bArr[i3] & UByte.MAX_VALUE);
        int i5 = i4 + 1;
        this.A3 = (long) (bArr[i4] & UByte.MAX_VALUE);
        for (int i6 = 8; i6 != this.BC; i6 += 8) {
            int i7 = i5 + 1;
            this.A0 |= ((long) (bArr[i5] & UByte.MAX_VALUE)) << i6;
            int i8 = i7 + 1;
            this.A1 |= ((long) (bArr[i7] & UByte.MAX_VALUE)) << i6;
            int i9 = i8 + 1;
            this.A2 |= ((long) (bArr[i8] & UByte.MAX_VALUE)) << i6;
            i5 = i9 + 1;
            this.A3 |= ((long) (bArr[i9] & UByte.MAX_VALUE)) << i6;
        }
    }

    private void packBlock(byte[] bArr, int i) {
        for (int i2 = 0; i2 != this.BC; i2 += 8) {
            int i3 = i + 1;
            bArr[i] = (byte) ((int) (this.A0 >> i2));
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) (this.A1 >> i2));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (this.A2 >> i2));
            i = i5 + 1;
            bArr[i5] = (byte) ((int) (this.A3 >> i2));
        }
    }

    private void encryptBlock(long[][] jArr) {
        KeyAddition(jArr[0]);
        for (int i = 1; i < this.ROUNDS; i++) {
            Substitution(S);
            ShiftRow(this.shifts0SC);
            MixColumn();
            KeyAddition(jArr[i]);
        }
        Substitution(S);
        ShiftRow(this.shifts0SC);
        KeyAddition(jArr[this.ROUNDS]);
    }

    private void decryptBlock(long[][] jArr) {
        KeyAddition(jArr[this.ROUNDS]);
        Substitution(Si);
        ShiftRow(this.shifts1SC);
        for (int i = this.ROUNDS - 1; i > 0; i--) {
            KeyAddition(jArr[i]);
            InvMixColumn();
            Substitution(Si);
            ShiftRow(this.shifts1SC);
        }
        KeyAddition(jArr[0]);
    }
}
