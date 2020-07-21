package org.spongycastle.crypto.engines;

import com.itextpdf.text.pdf.BidiOrder;
import java.util.Enumeration;
import java.util.Hashtable;
import kotlin.UByte;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class GOST28147Engine implements BlockCipher {
    protected static final int BLOCK_SIZE = 8;
    private static byte[] DSbox_A = {10, 4, 5, 6, 8, 1, 3, 7, BidiOrder.NSM, BidiOrder.CS, BidiOrder.BN, 0, 9, 2, BidiOrder.AN, BidiOrder.B, 5, BidiOrder.B, 4, 0, 2, BidiOrder.NSM, BidiOrder.AN, 9, 1, 7, 6, 3, BidiOrder.CS, BidiOrder.BN, 10, 8, 7, BidiOrder.B, BidiOrder.CS, BidiOrder.BN, 9, 4, 1, 0, 3, BidiOrder.AN, 5, 2, 6, 10, 8, BidiOrder.NSM, 4, 10, 7, BidiOrder.CS, 0, BidiOrder.B, 2, 8, BidiOrder.BN, 1, 6, 5, BidiOrder.NSM, BidiOrder.AN, 9, 3, 7, 6, 4, BidiOrder.AN, 9, BidiOrder.CS, 2, 10, 1, 8, 0, BidiOrder.BN, BidiOrder.B, BidiOrder.NSM, 3, 5, 7, 6, 2, 4, BidiOrder.NSM, 9, BidiOrder.B, 0, 10, 1, 5, BidiOrder.AN, 8, BidiOrder.BN, BidiOrder.CS, 3, BidiOrder.NSM, BidiOrder.BN, 4, 1, 7, 0, 5, 10, 3, BidiOrder.CS, 8, BidiOrder.B, 6, 2, 9, BidiOrder.AN, 1, 3, 10, 9, 5, BidiOrder.AN, 4, BidiOrder.B, 8, 6, 7, BidiOrder.BN, BidiOrder.NSM, 0, 2, BidiOrder.CS};
    private static byte[] DSbox_Test = {4, 10, 9, 2, BidiOrder.NSM, 8, 0, BidiOrder.BN, 6, BidiOrder.AN, 1, BidiOrder.CS, 7, BidiOrder.B, 5, 3, BidiOrder.BN, BidiOrder.AN, 4, BidiOrder.CS, 6, BidiOrder.NSM, BidiOrder.B, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, BidiOrder.NSM, 10, 3, 4, 2, BidiOrder.BN, BidiOrder.B, BidiOrder.CS, 7, 6, 0, 9, BidiOrder.AN, 7, BidiOrder.NSM, 10, 1, 0, 8, 9, BidiOrder.B, BidiOrder.BN, 4, 6, BidiOrder.CS, BidiOrder.AN, 2, 5, 3, 6, BidiOrder.CS, 7, 1, 5, BidiOrder.B, BidiOrder.NSM, 8, 4, 10, 9, BidiOrder.BN, 0, 3, BidiOrder.AN, 2, 4, BidiOrder.AN, 10, 0, 7, 2, 1, BidiOrder.NSM, 3, 6, 8, 5, 9, BidiOrder.CS, BidiOrder.B, BidiOrder.BN, BidiOrder.NSM, BidiOrder.AN, 4, 1, 3, BidiOrder.B, 5, 9, 0, 10, BidiOrder.BN, 7, 6, 8, 2, BidiOrder.CS, 1, BidiOrder.B, BidiOrder.NSM, 0, 5, 7, 10, 4, 9, 2, 3, BidiOrder.BN, 6, BidiOrder.AN, 8, BidiOrder.CS};
    private static byte[] ESbox_A = {9, 6, 3, 2, 8, BidiOrder.AN, 1, 7, 10, 4, BidiOrder.BN, BidiOrder.B, BidiOrder.CS, 0, BidiOrder.NSM, 5, 3, 7, BidiOrder.BN, 9, 8, 10, BidiOrder.B, 0, 5, 2, 6, BidiOrder.CS, BidiOrder.AN, 4, BidiOrder.NSM, 1, BidiOrder.BN, 4, 6, 2, BidiOrder.AN, 3, BidiOrder.NSM, 8, BidiOrder.CS, BidiOrder.B, 5, 10, 0, 7, 1, 9, BidiOrder.BN, 7, 10, BidiOrder.CS, BidiOrder.NSM, 1, 3, 9, 0, 2, BidiOrder.AN, 4, BidiOrder.B, 8, 5, 6, BidiOrder.AN, 5, 1, 9, 8, BidiOrder.NSM, BidiOrder.B, 0, BidiOrder.BN, 4, 2, 3, BidiOrder.CS, 7, 10, 6, 3, 10, BidiOrder.NSM, BidiOrder.CS, 1, 2, 0, BidiOrder.AN, 7, 5, 9, 4, 8, BidiOrder.B, BidiOrder.BN, 6, 1, BidiOrder.NSM, 2, 9, 7, 10, 6, 0, 8, BidiOrder.CS, 4, 5, BidiOrder.B, 3, BidiOrder.AN, BidiOrder.BN, BidiOrder.AN, 10, BidiOrder.B, 5, 0, BidiOrder.CS, BidiOrder.BN, 8, 6, 2, 3, 9, 1, 7, BidiOrder.NSM, 4};
    private static byte[] ESbox_B = {8, 4, BidiOrder.AN, 1, 3, 5, 0, 9, 2, BidiOrder.BN, 10, BidiOrder.CS, BidiOrder.NSM, 6, 7, BidiOrder.B, 0, 1, 2, 10, 4, BidiOrder.NSM, 5, BidiOrder.CS, 9, 7, 3, BidiOrder.B, BidiOrder.AN, 8, 6, BidiOrder.BN, BidiOrder.BN, BidiOrder.CS, 0, 10, 9, 2, BidiOrder.NSM, BidiOrder.AN, 7, 5, 8, BidiOrder.B, 3, 6, 1, 4, 7, 5, 0, BidiOrder.NSM, BidiOrder.AN, 6, 1, 2, 3, 10, BidiOrder.CS, BidiOrder.B, 4, BidiOrder.BN, 9, 8, 2, 7, BidiOrder.CS, BidiOrder.B, 9, 5, 10, BidiOrder.AN, 1, 4, 0, BidiOrder.NSM, 6, 8, BidiOrder.BN, 3, 8, 3, 2, 6, 4, BidiOrder.NSM, BidiOrder.BN, BidiOrder.AN, BidiOrder.CS, 1, 7, BidiOrder.B, 10, 0, 9, 5, 5, 2, 10, BidiOrder.AN, 9, 1, BidiOrder.CS, 3, 7, 4, BidiOrder.NSM, 0, 6, BidiOrder.B, 8, BidiOrder.BN, 0, 4, BidiOrder.AN, BidiOrder.BN, 8, 3, 7, 1, 10, 2, 9, 6, BidiOrder.B, BidiOrder.NSM, 5, BidiOrder.CS};
    private static byte[] ESbox_C = {1, BidiOrder.AN, BidiOrder.CS, 2, 9, BidiOrder.NSM, 0, BidiOrder.B, 4, 5, 8, BidiOrder.BN, 10, 7, 6, 3, 0, 1, 7, BidiOrder.NSM, BidiOrder.AN, 4, 5, 2, 8, BidiOrder.BN, BidiOrder.B, BidiOrder.CS, 9, 10, 6, 3, 8, 2, 5, 0, 4, 9, BidiOrder.B, 10, 3, 7, BidiOrder.CS, BidiOrder.NSM, 6, BidiOrder.BN, 1, BidiOrder.AN, 3, 6, 0, 1, 5, BidiOrder.NSM, 10, 8, BidiOrder.AN, 2, 9, 7, BidiOrder.BN, BidiOrder.B, BidiOrder.CS, 4, 8, BidiOrder.NSM, BidiOrder.AN, 0, 4, 5, 1, 2, 9, 3, BidiOrder.CS, BidiOrder.BN, 6, BidiOrder.B, 10, 7, BidiOrder.CS, 9, BidiOrder.AN, 1, 8, BidiOrder.BN, 2, 4, 7, 3, 6, 5, 10, 0, BidiOrder.B, BidiOrder.NSM, 10, 9, 6, 8, BidiOrder.NSM, BidiOrder.BN, 2, 0, BidiOrder.B, 3, 5, BidiOrder.AN, 4, 1, BidiOrder.CS, 7, 7, 4, 0, 5, 10, 2, BidiOrder.B, BidiOrder.BN, BidiOrder.CS, 6, 1, BidiOrder.AN, BidiOrder.NSM, 9, 3, 8};
    private static byte[] ESbox_D = {BidiOrder.B, BidiOrder.CS, 2, 10, 6, 4, 5, 0, 7, 9, BidiOrder.BN, BidiOrder.NSM, 1, BidiOrder.AN, 8, 3, BidiOrder.AN, 6, 3, 4, BidiOrder.CS, BidiOrder.B, BidiOrder.BN, 2, 7, BidiOrder.NSM, 8, 0, 5, 10, 9, 1, 1, BidiOrder.CS, BidiOrder.AN, 0, BidiOrder.B, BidiOrder.BN, 6, 5, 10, BidiOrder.NSM, 4, 8, 9, 3, 7, 2, 1, 5, BidiOrder.BN, BidiOrder.CS, 10, 7, 0, BidiOrder.NSM, 6, 2, BidiOrder.AN, 4, 9, 3, BidiOrder.B, 8, 0, BidiOrder.CS, 8, 9, BidiOrder.NSM, 2, 10, BidiOrder.AN, 7, 3, 6, 5, 4, BidiOrder.BN, BidiOrder.B, 1, 8, 0, BidiOrder.B, 3, 2, 5, BidiOrder.BN, BidiOrder.AN, 1, 10, 4, 7, BidiOrder.CS, 9, BidiOrder.NSM, 6, 3, 0, 6, BidiOrder.B, 1, BidiOrder.BN, 9, 2, BidiOrder.NSM, 8, BidiOrder.CS, 4, BidiOrder.AN, 10, 5, 7, 1, 10, 6, 8, BidiOrder.B, BidiOrder.AN, 0, 4, BidiOrder.CS, 3, 5, 9, 7, BidiOrder.NSM, 2, BidiOrder.BN};
    private static byte[] ESbox_Test = {4, 2, BidiOrder.B, 5, 9, 1, 0, 8, BidiOrder.BN, 3, BidiOrder.AN, BidiOrder.CS, BidiOrder.NSM, 7, 10, 6, BidiOrder.CS, 9, BidiOrder.B, BidiOrder.BN, 8, 1, 3, 10, 2, 7, 4, BidiOrder.NSM, 6, 0, BidiOrder.AN, 5, BidiOrder.NSM, 8, BidiOrder.BN, BidiOrder.CS, 7, 3, 9, 10, 1, 5, 2, 4, 6, BidiOrder.B, 0, BidiOrder.AN, BidiOrder.BN, 9, BidiOrder.AN, 2, 5, BidiOrder.B, 7, 1, 0, BidiOrder.NSM, BidiOrder.CS, 6, 10, 4, 3, 8, 3, BidiOrder.BN, 5, 9, 6, 8, 0, BidiOrder.NSM, 10, BidiOrder.AN, 7, BidiOrder.CS, 2, 1, BidiOrder.B, 4, 8, BidiOrder.B, 6, BidiOrder.AN, 1, 9, BidiOrder.CS, 5, BidiOrder.NSM, 3, 7, 10, 0, BidiOrder.BN, 2, 4, 9, BidiOrder.AN, BidiOrder.CS, 0, 3, 6, 7, 5, 4, 8, BidiOrder.BN, BidiOrder.B, 1, 10, 2, BidiOrder.NSM, BidiOrder.CS, 6, 5, 2, BidiOrder.AN, 0, 9, BidiOrder.NSM, 3, BidiOrder.BN, 7, 10, BidiOrder.B, 4, 1, 8};
    private static byte[] Sbox_Default = {4, 10, 9, 2, BidiOrder.NSM, 8, 0, BidiOrder.BN, 6, BidiOrder.AN, 1, BidiOrder.CS, 7, BidiOrder.B, 5, 3, BidiOrder.BN, BidiOrder.AN, 4, BidiOrder.CS, 6, BidiOrder.NSM, BidiOrder.B, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, BidiOrder.NSM, 10, 3, 4, 2, BidiOrder.BN, BidiOrder.B, BidiOrder.CS, 7, 6, 0, 9, BidiOrder.AN, 7, BidiOrder.NSM, 10, 1, 0, 8, 9, BidiOrder.B, BidiOrder.BN, 4, 6, BidiOrder.CS, BidiOrder.AN, 2, 5, 3, 6, BidiOrder.CS, 7, 1, 5, BidiOrder.B, BidiOrder.NSM, 8, 4, 10, 9, BidiOrder.BN, 0, 3, BidiOrder.AN, 2, 4, BidiOrder.AN, 10, 0, 7, 2, 1, BidiOrder.NSM, 3, 6, 8, 5, 9, BidiOrder.CS, BidiOrder.B, BidiOrder.BN, BidiOrder.NSM, BidiOrder.AN, 4, 1, 3, BidiOrder.B, 5, 9, 0, 10, BidiOrder.BN, 7, 6, 8, 2, BidiOrder.CS, 1, BidiOrder.B, BidiOrder.NSM, 0, 5, 7, 10, 4, 9, 2, 3, BidiOrder.BN, 6, BidiOrder.AN, 8, BidiOrder.CS};
    private static Hashtable sBoxes = new Hashtable();
    private byte[] S = Sbox_Default;
    private boolean forEncryption;
    private int[] workingKey = null;

    @Override // org.spongycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "GOST28147";
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void reset() {
    }

    static {
        addSBox("Default", Sbox_Default);
        addSBox("E-TEST", ESbox_Test);
        addSBox("E-A", ESbox_A);
        addSBox("E-B", ESbox_B);
        addSBox("E-C", ESbox_C);
        addSBox("E-D", ESbox_D);
        addSBox("D-TEST", DSbox_Test);
        addSBox("D-A", DSbox_A);
    }

    private static void addSBox(String str, byte[] bArr) {
        sBoxes.put(Strings.toUpperCase(str), bArr);
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            byte[] sBox = parametersWithSBox.getSBox();
            if (sBox.length == Sbox_Default.length) {
                this.S = Arrays.clone(sBox);
                if (parametersWithSBox.getParameters() != null) {
                    this.workingKey = generateWorkingKey(z, ((KeyParameter) parametersWithSBox.getParameters()).getKey());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
        } else if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(z, ((KeyParameter) cipherParameters).getKey());
        } else if (cipherParameters != null) {
            throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + cipherParameters.getClass().getName());
        }
    }

    @Override // org.spongycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("GOST28147 engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            GOST28147Func(iArr, bArr, i, bArr2, i2);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    private int[] generateWorkingKey(boolean z, byte[] bArr) {
        this.forEncryption = z;
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i = 0; i != 8; i++) {
                iArr[i] = bytesToint(bArr, i * 4);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    private int GOST28147_mainStep(int i, int i2) {
        int i3 = i2 + i;
        byte[] bArr = this.S;
        int i4 = (bArr[((i3 >> 0) & 15) + 0] << 0) + (bArr[((i3 >> 4) & 15) + 16] << 4) + (bArr[((i3 >> 8) & 15) + 32] << 8) + (bArr[((i3 >> 12) & 15) + 48] << BidiOrder.CS) + (bArr[((i3 >> 16) & 15) + 64] << 16) + (bArr[((i3 >> 20) & 15) + 80] << 20) + (bArr[((i3 >> 24) & 15) + 96] << 24) + (bArr[((i3 >> 28) & 15) + 112] << 28);
        return (i4 << 11) | (i4 >>> 21);
    }

    private void GOST28147Func(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int i4;
        int bytesToint = bytesToint(bArr, i);
        int bytesToint2 = bytesToint(bArr, i + 4);
        int i5 = 7;
        if (this.forEncryption) {
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = 0;
                while (i7 < 8) {
                    i7++;
                    bytesToint = bytesToint2 ^ GOST28147_mainStep(bytesToint, iArr[i7]);
                    bytesToint2 = bytesToint;
                }
            }
            i3 = bytesToint2;
            i4 = bytesToint;
            while (i5 > 0) {
                int GOST28147_mainStep = i3 ^ GOST28147_mainStep(i4, iArr[i5]);
                i5--;
                i3 = i4;
                i4 = GOST28147_mainStep;
            }
        } else {
            int i8 = 0;
            while (i8 < 8) {
                i8++;
                bytesToint = bytesToint2 ^ GOST28147_mainStep(bytesToint, iArr[i8]);
                bytesToint2 = bytesToint;
            }
            i3 = bytesToint2;
            i4 = bytesToint;
            int i9 = 0;
            while (i9 < 3) {
                int i10 = 7;
                while (i10 >= 0 && (i9 != 2 || i10 != 0)) {
                    int GOST28147_mainStep2 = i3 ^ GOST28147_mainStep(i4, iArr[i10]);
                    i10--;
                    i3 = i4;
                    i4 = GOST28147_mainStep2;
                }
                i9++;
            }
        }
        intTobytes(i4, bArr2, i2);
        intTobytes(GOST28147_mainStep(i4, iArr[0]) ^ i3, bArr2, i2 + 4);
    }

    private int bytesToint(byte[] bArr, int i) {
        return ((bArr[i + 3] << 24) & -16777216) + ((bArr[i + 2] << 16) & 16711680) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & UByte.MAX_VALUE);
    }

    private void intTobytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }

    public static byte[] getSBox(String str) {
        byte[] bArr = (byte[]) sBoxes.get(Strings.toUpperCase(str));
        if (bArr != null) {
            return Arrays.clone(bArr);
        }
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"D-Test\", \"D-A\".");
    }

    public static String getSBoxName(byte[] bArr) {
        Enumeration keys = sBoxes.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            if (Arrays.areEqual((byte[]) sBoxes.get(str), bArr)) {
                return str;
            }
        }
        throw new IllegalArgumentException("SBOX provided did not map to a known one");
    }
}
