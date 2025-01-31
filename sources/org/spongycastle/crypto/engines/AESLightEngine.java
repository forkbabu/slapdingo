package org.spongycastle.crypto.engines;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.ByteBuffer;
import java.lang.reflect.Array;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.util.Pack;

public class AESLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, 111, -59, ByteBuffer.ZERO, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ByteCompanionObject.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, DocWriter.FORWARD, -124, 83, -47, 0, -19, DocWriter.SPACE, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, DocWriter.LT, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, BidiOrder.CS, 19, -20, 95, -105, 68, 23, -60, -89, 126, DocWriter.EQUALS, 100, 93, 25, 115, 96, -127, 79, -36, DocWriter.QUOTE, 42, -112, -120, 70, -18, -72, 20, -34, 94, BidiOrder.AN, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, DocWriter.GT, -75, 102, 72, 3, -10, BidiOrder.BN, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, BidiOrder.WS, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, BidiOrder.NSM, -65, -26, 66, 104, 65, -103, 45, BidiOrder.B, -80, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, ByteBuffer.ZERO, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, DocWriter.FORWARD, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, DocWriter.EQUALS, -18, 76, -107, BidiOrder.AN, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, BidiOrder.B, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, BidiOrder.WS, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, DocWriter.QUOTE, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, BidiOrder.BN, -86, 24, -66, 27, -4, 86, DocWriter.GT, 75, -58, -46, 121, DocWriter.SPACE, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, ByteCompanionObject.MIN_VALUE, -20, 95, 96, 81, ByteCompanionObject.MAX_VALUE, -87, 25, -75, 74, BidiOrder.NSM, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, DocWriter.LT, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, BidiOrder.CS, 125};
    private static final int m1 = -2139062144;
    private static final int m2 = 2139062143;
    private static final int m3 = 27;
    private static final int m4 = -1061109568;
    private static final int m5 = 1061109567;
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 77, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 47, 94, 188, 99, 198, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 53, 106, 212, 179, 125, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 239, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA};
    private int C0;
    private int C1;
    private int C2;
    private int C3;
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    private static int FFmulX(int i) {
        return (((i & m1) >>> 7) * 27) ^ ((m2 & i) << 1);
    }

    private static int FFmulX2(int i) {
        int i2 = i & m4;
        int i3 = i2 ^ (i2 >>> 1);
        return (i3 >>> 5) ^ (((m5 & i) << 2) ^ (i3 >>> 2));
    }

    private static int shift(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "AES";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    private static int mcol(int i) {
        int shift = shift(i, 8);
        int i2 = i ^ shift;
        return FFmulX(i2) ^ (shift ^ shift(i2, 16));
    }

    private static int inv_mcol(int i) {
        int shift = shift(i, 8) ^ i;
        int FFmulX = i ^ FFmulX(shift);
        int FFmulX2 = shift ^ FFmulX2(FFmulX);
        return FFmulX ^ (FFmulX2 ^ shift(FFmulX2, 16));
    }

    private static int subWord(int i) {
        byte[] bArr = S;
        return (bArr[(i >> 24) & 255] << 24) | (bArr[i & 255] & UByte.MAX_VALUE) | ((bArr[(i >> 8) & 255] & UByte.MAX_VALUE) << 8) | ((bArr[(i >> 16) & 255] & UByte.MAX_VALUE) << 16);
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z) {
        int length = bArr.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i = length >> 2;
        int i2 = i + 6;
        this.ROUNDS = i2;
        int[] iArr = new int[2];
        iArr[1] = 4;
        iArr[0] = i2 + 1;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        if (i == 4) {
            int littleEndianToInt = Pack.littleEndianToInt(bArr, 0);
            iArr2[0][0] = littleEndianToInt;
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
            iArr2[0][1] = littleEndianToInt2;
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
            iArr2[0][2] = littleEndianToInt3;
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
            iArr2[0][3] = littleEndianToInt4;
            for (int i3 = 1; i3 <= 10; i3++) {
                littleEndianToInt ^= subWord(shift(littleEndianToInt4, 8)) ^ rcon[i3 - 1];
                iArr2[i3][0] = littleEndianToInt;
                littleEndianToInt2 ^= littleEndianToInt;
                iArr2[i3][1] = littleEndianToInt2;
                littleEndianToInt3 ^= littleEndianToInt2;
                iArr2[i3][2] = littleEndianToInt3;
                littleEndianToInt4 ^= littleEndianToInt3;
                iArr2[i3][3] = littleEndianToInt4;
            }
        } else if (i == 6) {
            int littleEndianToInt5 = Pack.littleEndianToInt(bArr, 0);
            iArr2[0][0] = littleEndianToInt5;
            int littleEndianToInt6 = Pack.littleEndianToInt(bArr, 4);
            iArr2[0][1] = littleEndianToInt6;
            int littleEndianToInt7 = Pack.littleEndianToInt(bArr, 8);
            iArr2[0][2] = littleEndianToInt7;
            int littleEndianToInt8 = Pack.littleEndianToInt(bArr, 12);
            iArr2[0][3] = littleEndianToInt8;
            int littleEndianToInt9 = Pack.littleEndianToInt(bArr, 16);
            iArr2[1][0] = littleEndianToInt9;
            int littleEndianToInt10 = Pack.littleEndianToInt(bArr, 20);
            iArr2[1][1] = littleEndianToInt10;
            int subWord = littleEndianToInt5 ^ (subWord(shift(littleEndianToInt10, 8)) ^ 1);
            iArr2[1][2] = subWord;
            int i4 = littleEndianToInt6 ^ subWord;
            iArr2[1][3] = i4;
            int i5 = littleEndianToInt7 ^ i4;
            iArr2[2][0] = i5;
            int i6 = littleEndianToInt8 ^ i5;
            iArr2[2][1] = i6;
            int i7 = littleEndianToInt9 ^ i6;
            iArr2[2][2] = i7;
            int i8 = littleEndianToInt10 ^ i7;
            iArr2[2][3] = i8;
            int i9 = 2;
            for (int i10 = 3; i10 < 12; i10 += 3) {
                int subWord2 = subWord(shift(i8, 8)) ^ i9;
                int i11 = i9 << 1;
                int i12 = subWord ^ subWord2;
                iArr2[i10][0] = i12;
                int i13 = i4 ^ i12;
                iArr2[i10][1] = i13;
                int i14 = i5 ^ i13;
                iArr2[i10][2] = i14;
                int i15 = i6 ^ i14;
                iArr2[i10][3] = i15;
                int i16 = i7 ^ i15;
                int i17 = i10 + 1;
                iArr2[i17][0] = i16;
                int i18 = i8 ^ i16;
                iArr2[i17][1] = i18;
                int subWord3 = subWord(shift(i18, 8)) ^ i11;
                i9 = i11 << 1;
                subWord = i12 ^ subWord3;
                iArr2[i17][2] = subWord;
                i4 = i13 ^ subWord;
                iArr2[i17][3] = i4;
                i5 = i14 ^ i4;
                int i19 = i10 + 2;
                iArr2[i19][0] = i5;
                i6 = i15 ^ i5;
                iArr2[i19][1] = i6;
                i7 = i16 ^ i6;
                iArr2[i19][2] = i7;
                i8 = i18 ^ i7;
                iArr2[i19][3] = i8;
            }
            int subWord4 = (subWord(shift(i8, 8)) ^ i9) ^ subWord;
            iArr2[12][0] = subWord4;
            int i20 = subWord4 ^ i4;
            iArr2[12][1] = i20;
            int i21 = i20 ^ i5;
            iArr2[12][2] = i21;
            iArr2[12][3] = i21 ^ i6;
        } else if (i == 8) {
            int littleEndianToInt11 = Pack.littleEndianToInt(bArr, 0);
            iArr2[0][0] = littleEndianToInt11;
            int littleEndianToInt12 = Pack.littleEndianToInt(bArr, 4);
            iArr2[0][1] = littleEndianToInt12;
            int littleEndianToInt13 = Pack.littleEndianToInt(bArr, 8);
            iArr2[0][2] = littleEndianToInt13;
            int littleEndianToInt14 = Pack.littleEndianToInt(bArr, 12);
            iArr2[0][3] = littleEndianToInt14;
            int littleEndianToInt15 = Pack.littleEndianToInt(bArr, 16);
            iArr2[1][0] = littleEndianToInt15;
            int littleEndianToInt16 = Pack.littleEndianToInt(bArr, 20);
            iArr2[1][1] = littleEndianToInt16;
            int littleEndianToInt17 = Pack.littleEndianToInt(bArr, 24);
            iArr2[1][2] = littleEndianToInt17;
            int littleEndianToInt18 = Pack.littleEndianToInt(bArr, 28);
            iArr2[1][3] = littleEndianToInt18;
            int i22 = 1;
            for (int i23 = 2; i23 < 14; i23 += 2) {
                int subWord5 = subWord(shift(littleEndianToInt18, 8)) ^ i22;
                i22 <<= 1;
                littleEndianToInt11 ^= subWord5;
                iArr2[i23][0] = littleEndianToInt11;
                littleEndianToInt12 ^= littleEndianToInt11;
                iArr2[i23][1] = littleEndianToInt12;
                littleEndianToInt13 ^= littleEndianToInt12;
                iArr2[i23][2] = littleEndianToInt13;
                littleEndianToInt14 ^= littleEndianToInt13;
                iArr2[i23][3] = littleEndianToInt14;
                littleEndianToInt15 ^= subWord(littleEndianToInt14);
                int i24 = i23 + 1;
                iArr2[i24][0] = littleEndianToInt15;
                littleEndianToInt16 ^= littleEndianToInt15;
                iArr2[i24][1] = littleEndianToInt16;
                littleEndianToInt17 ^= littleEndianToInt16;
                iArr2[i24][2] = littleEndianToInt17;
                littleEndianToInt18 ^= littleEndianToInt17;
                iArr2[i24][3] = littleEndianToInt18;
            }
            int subWord6 = (subWord(shift(littleEndianToInt18, 8)) ^ i22) ^ littleEndianToInt11;
            iArr2[14][0] = subWord6;
            int i25 = subWord6 ^ littleEndianToInt12;
            iArr2[14][1] = i25;
            int i26 = i25 ^ littleEndianToInt13;
            iArr2[14][2] = i26;
            iArr2[14][3] = i26 ^ littleEndianToInt14;
        } else {
            throw new IllegalStateException("Should never get here");
        }
        if (!z) {
            for (int i27 = 1; i27 < this.ROUNDS; i27++) {
                for (int i28 = 0; i28 < 4; i28++) {
                    iArr2[i27][i28] = inv_mcol(iArr2[i27][i28]);
                }
            }
        }
        return iArr2;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z);
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.WorkingKey == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.forEncryption) {
            unpackBlock(bArr, i);
            encryptBlock(this.WorkingKey);
            packBlock(bArr2, i2);
            return 16;
        } else {
            unpackBlock(bArr, i);
            decryptBlock(this.WorkingKey);
            packBlock(bArr2, i2);
            return 16;
        }
    }

    private void unpackBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        byte b = bArr[i] & UByte.MAX_VALUE;
        this.C0 = b;
        int i3 = i2 + 1;
        byte b2 = b | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        this.C0 = b2;
        int i4 = i3 + 1;
        byte b3 = b2 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        this.C0 = b3;
        int i5 = i4 + 1;
        this.C0 = b3 | (bArr[i4] << 24);
        int i6 = i5 + 1;
        byte b4 = bArr[i5] & UByte.MAX_VALUE;
        this.C1 = b4;
        int i7 = i6 + 1;
        byte b5 = ((bArr[i6] & UByte.MAX_VALUE) << 8) | b4;
        this.C1 = b5;
        int i8 = i7 + 1;
        byte b6 = b5 | ((bArr[i7] & UByte.MAX_VALUE) << 16);
        this.C1 = b6;
        int i9 = i8 + 1;
        this.C1 = b6 | (bArr[i8] << 24);
        int i10 = i9 + 1;
        byte b7 = bArr[i9] & UByte.MAX_VALUE;
        this.C2 = b7;
        int i11 = i10 + 1;
        byte b8 = ((bArr[i10] & UByte.MAX_VALUE) << 8) | b7;
        this.C2 = b8;
        int i12 = i11 + 1;
        byte b9 = b8 | ((bArr[i11] & UByte.MAX_VALUE) << 16);
        this.C2 = b9;
        int i13 = i12 + 1;
        this.C2 = b9 | (bArr[i12] << 24);
        int i14 = i13 + 1;
        byte b10 = bArr[i13] & UByte.MAX_VALUE;
        this.C3 = b10;
        int i15 = i14 + 1;
        byte b11 = ((bArr[i14] & UByte.MAX_VALUE) << 8) | b10;
        this.C3 = b11;
        byte b12 = b11 | ((bArr[i15] & UByte.MAX_VALUE) << 16);
        this.C3 = b12;
        this.C3 = (bArr[i15 + 1] << 24) | b12;
    }

    private void packBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = this.C0;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.C1;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.C2;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.C3;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    private void encryptBlock(int[][] iArr) {
        int i = this.C0 ^ iArr[0][0];
        int i2 = this.C1 ^ iArr[0][1];
        int i3 = this.C2 ^ iArr[0][2];
        int i4 = this.C3 ^ iArr[0][3];
        int i5 = 1;
        while (i5 < this.ROUNDS - 1) {
            byte[] bArr = S;
            int mcol = mcol((bArr[(i4 >> 24) & 255] << 24) ^ (((bArr[i & 255] & UByte.MAX_VALUE) ^ ((bArr[(i2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i3 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i5][0];
            byte[] bArr2 = S;
            int mcol2 = mcol((bArr2[(i >> 24) & 255] << 24) ^ (((bArr2[i2 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(i3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(i4 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i5][1];
            byte[] bArr3 = S;
            int mcol3 = mcol((bArr3[(i2 >> 24) & 255] << 24) ^ (((bArr3[i3 & 255] & UByte.MAX_VALUE) ^ ((bArr3[(i4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr3[(i >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i5][2];
            byte[] bArr4 = S;
            int i6 = i5 + 1;
            int mcol4 = mcol(((((bArr4[(i >> 8) & 255] & UByte.MAX_VALUE) << 8) ^ (bArr4[i4 & 255] & UByte.MAX_VALUE)) ^ ((bArr4[(i2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr4[(i3 >> 24) & 255] << 24)) ^ iArr[i5][3];
            byte[] bArr5 = S;
            int mcol5 = mcol((bArr5[(mcol4 >> 24) & 255] << 24) ^ (((bArr5[mcol & 255] & UByte.MAX_VALUE) ^ ((bArr5[(mcol2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr5[(mcol3 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][0];
            byte[] bArr6 = S;
            int mcol6 = mcol((bArr6[(mcol >> 24) & 255] << 24) ^ (((bArr6[mcol2 & 255] & UByte.MAX_VALUE) ^ ((bArr6[(mcol3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr6[(mcol4 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][1];
            byte[] bArr7 = S;
            int mcol7 = mcol((bArr7[(mcol2 >> 24) & 255] << 24) ^ (((bArr7[mcol3 & 255] & UByte.MAX_VALUE) ^ ((bArr7[(mcol4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr7[(mcol >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][2];
            byte[] bArr8 = S;
            int i7 = i6 + 1;
            int mcol8 = mcol((((bArr8[mcol4 & 255] & UByte.MAX_VALUE) ^ ((bArr8[(mcol >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr8[(mcol2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr8[(mcol3 >> 24) & 255] << 24)) ^ iArr[i6][3];
            i2 = mcol6;
            i4 = mcol8;
            i = mcol5;
            i3 = mcol7;
            i5 = i7;
        }
        byte[] bArr9 = S;
        int mcol9 = mcol((bArr9[(i4 >> 24) & 255] << 24) ^ (((bArr9[i & 255] & UByte.MAX_VALUE) ^ ((bArr9[(i2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr9[(i3 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i5][0];
        byte[] bArr10 = S;
        int mcol10 = mcol((bArr10[(i >> 24) & 255] << 24) ^ (((bArr10[i2 & 255] & UByte.MAX_VALUE) ^ ((bArr10[(i3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr10[(i4 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i5][1];
        byte[] bArr11 = S;
        int mcol11 = mcol((bArr11[(i2 >> 24) & 255] << 24) ^ (((bArr11[i3 & 255] & UByte.MAX_VALUE) ^ ((bArr11[(i4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr11[(i >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i5][2];
        byte[] bArr12 = S;
        int i8 = i5 + 1;
        int mcol12 = mcol(((((bArr12[(i >> 8) & 255] & UByte.MAX_VALUE) << 8) ^ (bArr12[i4 & 255] & UByte.MAX_VALUE)) ^ ((bArr12[(i2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr12[(i3 >> 24) & 255] << 24)) ^ iArr[i5][3];
        byte[] bArr13 = S;
        this.C0 = iArr[i8][0] ^ ((((bArr13[mcol9 & 255] & UByte.MAX_VALUE) ^ ((bArr13[(mcol10 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr13[(mcol11 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr13[(mcol12 >> 24) & 255] << 24));
        this.C1 = ((((bArr13[mcol10 & 255] & UByte.MAX_VALUE) ^ ((bArr13[(mcol11 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr13[(mcol12 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr13[(mcol9 >> 24) & 255] << 24)) ^ iArr[i8][1];
        this.C2 = ((((bArr13[mcol11 & 255] & UByte.MAX_VALUE) ^ ((bArr13[(mcol12 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr13[(mcol9 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr13[(mcol10 >> 24) & 255] << 24)) ^ iArr[i8][2];
        this.C3 = iArr[i8][3] ^ ((((bArr13[mcol12 & 255] & UByte.MAX_VALUE) ^ ((bArr13[(mcol9 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr13[(mcol10 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr13[(mcol11 >> 24) & 255] << 24));
    }

    private void decryptBlock(int[][] iArr) {
        int i = this.C0;
        int i2 = this.ROUNDS;
        int i3 = i ^ iArr[i2][0];
        int i4 = this.C1 ^ iArr[i2][1];
        int i5 = this.C2 ^ iArr[i2][2];
        int i6 = i2 - 1;
        int i7 = iArr[i2][3] ^ this.C3;
        while (i6 > 1) {
            byte[] bArr = Si;
            int inv_mcol = inv_mcol((bArr[(i4 >> 24) & 255] << 24) ^ (((bArr[i3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i7 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i5 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][0];
            byte[] bArr2 = Si;
            int inv_mcol2 = inv_mcol((bArr2[(i5 >> 24) & 255] << 24) ^ (((bArr2[i4 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(i3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(i7 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][1];
            byte[] bArr3 = Si;
            int inv_mcol3 = inv_mcol((bArr3[(i7 >> 24) & 255] << 24) ^ (((bArr3[i5 & 255] & UByte.MAX_VALUE) ^ ((bArr3[(i4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr3[(i3 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][2];
            byte[] bArr4 = Si;
            int i8 = i6 - 1;
            int inv_mcol4 = inv_mcol((bArr4[(i3 >> 24) & 255] << 24) ^ (((bArr4[i7 & 255] & UByte.MAX_VALUE) ^ ((bArr4[(i5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr4[(i4 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][3];
            byte[] bArr5 = Si;
            int inv_mcol5 = inv_mcol((bArr5[(inv_mcol2 >> 24) & 255] << 24) ^ (((bArr5[inv_mcol & 255] & UByte.MAX_VALUE) ^ ((bArr5[(inv_mcol4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr5[(inv_mcol3 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i8][0];
            byte[] bArr6 = Si;
            int inv_mcol6 = inv_mcol((bArr6[(inv_mcol3 >> 24) & 255] << 24) ^ (((bArr6[inv_mcol2 & 255] & UByte.MAX_VALUE) ^ ((bArr6[(inv_mcol >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr6[(inv_mcol4 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i8][1];
            byte[] bArr7 = Si;
            int inv_mcol7 = inv_mcol((bArr7[(inv_mcol4 >> 24) & 255] << 24) ^ (((bArr7[inv_mcol3 & 255] & UByte.MAX_VALUE) ^ ((bArr7[(inv_mcol2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr7[(inv_mcol >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i8][2];
            byte[] bArr8 = Si;
            int inv_mcol8 = inv_mcol((((bArr8[inv_mcol4 & 255] & UByte.MAX_VALUE) ^ ((bArr8[(inv_mcol3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr8[(inv_mcol2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr8[(inv_mcol >> 24) & 255] << 24));
            int i9 = i8 - 1;
            i7 = iArr[i8][3] ^ inv_mcol8;
            i3 = inv_mcol5;
            i4 = inv_mcol6;
            i5 = inv_mcol7;
            i6 = i9;
        }
        byte[] bArr9 = Si;
        int inv_mcol9 = inv_mcol((bArr9[(i4 >> 24) & 255] << 24) ^ (((bArr9[i3 & 255] & UByte.MAX_VALUE) ^ ((bArr9[(i7 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr9[(i5 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][0];
        byte[] bArr10 = Si;
        int inv_mcol10 = inv_mcol((bArr10[(i5 >> 24) & 255] << 24) ^ (((bArr10[i4 & 255] & UByte.MAX_VALUE) ^ ((bArr10[(i3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr10[(i7 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][1];
        byte[] bArr11 = Si;
        int inv_mcol11 = inv_mcol((bArr11[(i7 >> 24) & 255] << 24) ^ (((bArr11[i5 & 255] & UByte.MAX_VALUE) ^ ((bArr11[(i4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr11[(i3 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][2];
        byte[] bArr12 = Si;
        int inv_mcol12 = inv_mcol((bArr12[(i3 >> 24) & 255] << 24) ^ (((bArr12[i7 & 255] & UByte.MAX_VALUE) ^ ((bArr12[(i5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr12[(i4 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][3];
        byte[] bArr13 = Si;
        this.C0 = ((((bArr13[inv_mcol9 & 255] & UByte.MAX_VALUE) ^ ((bArr13[(inv_mcol12 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr13[(inv_mcol11 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr13[(inv_mcol10 >> 24) & 255] << 24)) ^ iArr[0][0];
        this.C1 = ((((bArr13[inv_mcol10 & 255] & UByte.MAX_VALUE) ^ ((bArr13[(inv_mcol9 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr13[(inv_mcol12 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr13[(inv_mcol11 >> 24) & 255] << 24)) ^ iArr[0][1];
        this.C2 = ((((bArr13[inv_mcol11 & 255] & UByte.MAX_VALUE) ^ ((bArr13[(inv_mcol10 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr13[(inv_mcol9 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr13[(inv_mcol12 >> 24) & 255] << 24)) ^ iArr[0][2];
        this.C3 = iArr[0][3] ^ ((((bArr13[inv_mcol12 & 255] & UByte.MAX_VALUE) ^ ((bArr13[(inv_mcol11 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr13[(inv_mcol10 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr13[(inv_mcol9 >> 24) & 255] << 24));
    }
}
