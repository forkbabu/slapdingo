package org.spongycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private short[][] A1;
    private short[][] A1inv;
    private short[][] A2;
    private short[][] A2inv;
    private short[] b1;
    private short[] b2;
    private boolean initialized = false;
    private Layer[] layers;
    private int numOfLayers;
    private short[][] pub_quadratic;
    private short[] pub_scalar;
    private short[][] pub_singular;
    private RainbowKeyGenerationParameters rainbowParams;
    private SecureRandom sr;
    private int[] vi;

    public AsymmetricCipherKeyPair genKeyPair() {
        if (!this.initialized) {
            initializeDefault();
        }
        keygen();
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.A1inv, this.b1, this.A2inv, this.b2, this.vi, this.layers);
        int[] iArr = this.vi;
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RainbowPublicKeyParameters(iArr[iArr.length - 1] - iArr[0], this.pub_quadratic, this.pub_singular, this.pub_scalar), (AsymmetricKeyParameter) rainbowPrivateKeyParameters);
    }

    public void initialize(KeyGenerationParameters keyGenerationParameters) {
        RainbowKeyGenerationParameters rainbowKeyGenerationParameters = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.rainbowParams = rainbowKeyGenerationParameters;
        this.sr = rainbowKeyGenerationParameters.getRandom();
        this.vi = this.rainbowParams.getParameters().getVi();
        this.numOfLayers = this.rainbowParams.getParameters().getNumOfLayers();
        this.initialized = true;
    }

    private void initializeDefault() {
        initialize(new RainbowKeyGenerationParameters(new SecureRandom(), new RainbowParameters()));
    }

    private void keygen() {
        generateL1();
        generateL2();
        generateF();
        computePublicKey();
    }

    private void generateL1() {
        int[] iArr = this.vi;
        int i = iArr[iArr.length - 1] - iArr[0];
        int[] iArr2 = new int[2];
        iArr2[1] = i;
        iArr2[0] = i;
        this.A1 = (short[][]) Array.newInstance(short.class, iArr2);
        this.A1inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A1inv == null) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.A1[i2][i3] = (short) (this.sr.nextInt() & 255);
                }
            }
            this.A1inv = computeInField.inverse(this.A1);
        }
        this.b1 = new short[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.b1[i4] = (short) (this.sr.nextInt() & 255);
        }
    }

    private void generateL2() {
        int[] iArr = this.vi;
        int i = iArr[iArr.length - 1];
        int[] iArr2 = new int[2];
        iArr2[1] = i;
        iArr2[0] = i;
        this.A2 = (short[][]) Array.newInstance(short.class, iArr2);
        this.A2inv = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.A2inv == null) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.A2[i2][i3] = (short) (this.sr.nextInt() & 255);
                }
            }
            this.A2inv = computeInField.inverse(this.A2);
        }
        this.b2 = new short[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.b2[i4] = (short) (this.sr.nextInt() & 255);
        }
    }

    private void generateF() {
        this.layers = new Layer[this.numOfLayers];
        int i = 0;
        while (i < this.numOfLayers) {
            Layer[] layerArr = this.layers;
            int[] iArr = this.vi;
            int i2 = i + 1;
            layerArr[i] = new Layer(iArr[i], iArr[i2], this.sr);
            i = i2;
        }
    }

    private void computePublicKey() {
        Class<short> cls = short.class;
        ComputeInField computeInField = new ComputeInField();
        int[] iArr = this.vi;
        int i = 0;
        int i2 = iArr[iArr.length - 1] - iArr[0];
        int i3 = iArr[iArr.length - 1];
        int[] iArr2 = new int[3];
        iArr2[2] = i3;
        iArr2[1] = i3;
        iArr2[0] = i2;
        short[][][] sArr = (short[][][]) Array.newInstance((Class<?>) cls, iArr2);
        int[] iArr3 = new int[2];
        iArr3[1] = i3;
        iArr3[0] = i2;
        this.pub_singular = (short[][]) Array.newInstance((Class<?>) cls, iArr3);
        this.pub_scalar = new short[i2];
        short[] sArr2 = new short[i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            Layer[] layerArr = this.layers;
            if (i4 >= layerArr.length) {
                break;
            }
            short[][][] coeffAlpha = layerArr[i4].getCoeffAlpha();
            short[][][] coeffBeta = this.layers[i4].getCoeffBeta();
            short[][] coeffGamma = this.layers[i4].getCoeffGamma();
            short[] coeffEta = this.layers[i4].getCoeffEta();
            int length = coeffAlpha[i].length;
            int length2 = coeffBeta[i].length;
            while (i < length) {
                int i6 = 0;
                while (i6 < length) {
                    int i7 = 0;
                    while (i7 < length2) {
                        int i8 = i6 + length2;
                        short[] multVect = computeInField.multVect(coeffAlpha[i][i6][i7], this.A2[i8]);
                        int i9 = i5 + i;
                        sArr[i9] = computeInField.addSquareMatrix(sArr[i9], computeInField.multVects(multVect, this.A2[i7]));
                        short[] multVect2 = computeInField.multVect(this.b2[i7], multVect);
                        short[][] sArr3 = this.pub_singular;
                        sArr3[i9] = computeInField.addVect(multVect2, sArr3[i9]);
                        short[] multVect3 = computeInField.multVect(this.b2[i8], computeInField.multVect(coeffAlpha[i][i6][i7], this.A2[i7]));
                        short[][] sArr4 = this.pub_singular;
                        sArr4[i9] = computeInField.addVect(multVect3, sArr4[i9]);
                        short multElem = GF2Field.multElem(coeffAlpha[i][i6][i7], this.b2[i8]);
                        short[] sArr5 = this.pub_scalar;
                        sArr5[i9] = GF2Field.addElem(sArr5[i9], GF2Field.multElem(multElem, this.b2[i7]));
                        i7++;
                        i3 = i3;
                        i2 = i2;
                        coeffAlpha = coeffAlpha;
                        i4 = i4;
                        coeffEta = coeffEta;
                    }
                    i6++;
                    cls = cls;
                }
                for (int i10 = 0; i10 < length2; i10++) {
                    for (int i11 = 0; i11 < length2; i11++) {
                        short[] multVect4 = computeInField.multVect(coeffBeta[i][i10][i11], this.A2[i10]);
                        int i12 = i5 + i;
                        sArr[i12] = computeInField.addSquareMatrix(sArr[i12], computeInField.multVects(multVect4, this.A2[i11]));
                        short[] multVect5 = computeInField.multVect(this.b2[i11], multVect4);
                        short[][] sArr6 = this.pub_singular;
                        sArr6[i12] = computeInField.addVect(multVect5, sArr6[i12]);
                        short[] multVect6 = computeInField.multVect(this.b2[i10], computeInField.multVect(coeffBeta[i][i10][i11], this.A2[i11]));
                        short[][] sArr7 = this.pub_singular;
                        sArr7[i12] = computeInField.addVect(multVect6, sArr7[i12]);
                        short multElem2 = GF2Field.multElem(coeffBeta[i][i10][i11], this.b2[i10]);
                        short[] sArr8 = this.pub_scalar;
                        sArr8[i12] = GF2Field.addElem(sArr8[i12], GF2Field.multElem(multElem2, this.b2[i11]));
                    }
                }
                for (int i13 = 0; i13 < length2 + length; i13++) {
                    short[] multVect7 = computeInField.multVect(coeffGamma[i][i13], this.A2[i13]);
                    short[][] sArr9 = this.pub_singular;
                    int i14 = i5 + i;
                    sArr9[i14] = computeInField.addVect(multVect7, sArr9[i14]);
                    short[] sArr10 = this.pub_scalar;
                    sArr10[i14] = GF2Field.addElem(sArr10[i14], GF2Field.multElem(coeffGamma[i][i13], this.b2[i13]));
                }
                short[] sArr11 = this.pub_scalar;
                int i15 = i5 + i;
                sArr11[i15] = GF2Field.addElem(sArr11[i15], coeffEta[i]);
                i++;
                cls = cls;
                i3 = i3;
                i2 = i2;
                coeffAlpha = coeffAlpha;
                i4 = i4;
                coeffEta = coeffEta;
            }
            i5 += length;
            i4++;
            i = 0;
        }
        int[] iArr4 = new int[3];
        iArr4[2] = i3;
        iArr4[1] = i3;
        iArr4[0] = i2;
        short[][][] sArr12 = (short[][][]) Array.newInstance((Class<?>) cls, iArr4);
        int[] iArr5 = new int[2];
        iArr5[1] = i3;
        iArr5[0] = i2;
        short[][] sArr13 = (short[][]) Array.newInstance((Class<?>) cls, iArr5);
        short[] sArr14 = new short[i2];
        for (int i16 = 0; i16 < i2; i16++) {
            int i17 = 0;
            while (true) {
                short[][] sArr15 = this.A1;
                if (i17 >= sArr15.length) {
                    break;
                }
                sArr12[i16] = computeInField.addSquareMatrix(sArr12[i16], computeInField.multMatrix(sArr15[i16][i17], sArr[i17]));
                sArr13[i16] = computeInField.addVect(sArr13[i16], computeInField.multVect(this.A1[i16][i17], this.pub_singular[i17]));
                sArr14[i16] = GF2Field.addElem(sArr14[i16], GF2Field.multElem(this.A1[i16][i17], this.pub_scalar[i17]));
                i17++;
            }
            sArr14[i16] = GF2Field.addElem(sArr14[i16], this.b1[i16]);
        }
        this.pub_singular = sArr13;
        this.pub_scalar = sArr14;
        compactPublicKey(sArr12);
    }

    private void compactPublicKey(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = ((length2 + 1) * length2) / 2;
        iArr[0] = length;
        this.pub_quadratic = (short[][]) Array.newInstance(short.class, iArr);
        for (int i = 0; i < length; i++) {
            int i2 = 0;
            for (int i3 = 0; i3 < length2; i3++) {
                for (int i4 = i3; i4 < length2; i4++) {
                    if (i4 == i3) {
                        this.pub_quadratic[i][i2] = sArr[i][i3][i4];
                    } else {
                        this.pub_quadratic[i][i2] = GF2Field.addElem(sArr[i][i3][i4], sArr[i][i4][i3]);
                    }
                    i2++;
                }
            }
        }
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }
}
