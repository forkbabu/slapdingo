package org.spongycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import kotlin.UByte;

public class GF2Matrix extends Matrix {
    private int length;
    private int[][] matrix;

    public GF2Matrix(byte[] bArr) {
        if (bArr.length >= 9) {
            this.numRows = LittleEndianConversions.OS2IP(bArr, 0);
            this.numColumns = LittleEndianConversions.OS2IP(bArr, 4);
            int i = ((this.numColumns + 7) >>> 3) * this.numRows;
            if (this.numRows > 0) {
                int i2 = 8;
                if (i == bArr.length - 8) {
                    this.length = (this.numColumns + 31) >>> 5;
                    int i3 = this.numRows;
                    int[] iArr = new int[2];
                    iArr[1] = this.length;
                    iArr[0] = i3;
                    this.matrix = (int[][]) Array.newInstance(int.class, iArr);
                    int i4 = this.numColumns >> 5;
                    int i5 = this.numColumns & 31;
                    for (int i6 = 0; i6 < this.numRows; i6++) {
                        int i7 = 0;
                        while (i7 < i4) {
                            this.matrix[i6][i7] = LittleEndianConversions.OS2IP(bArr, i2);
                            i7++;
                            i2 += 4;
                        }
                        int i8 = 0;
                        while (i8 < i5) {
                            int[] iArr2 = this.matrix[i6];
                            iArr2[i4] = ((bArr[i2] & UByte.MAX_VALUE) << i8) ^ iArr2[i4];
                            i8 += 8;
                            i2++;
                        }
                    }
                    return;
                }
            }
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public GF2Matrix(int i, int[][] iArr) {
        if (iArr[0].length == ((i + 31) >> 5)) {
            this.numColumns = i;
            this.numRows = iArr.length;
            this.length = iArr[0].length;
            int i2 = i & 31;
            int i3 = i2 == 0 ? -1 : (1 << i2) - 1;
            for (int i4 = 0; i4 < this.numRows; i4++) {
                int[] iArr2 = iArr[i4];
                int i5 = this.length - 1;
                iArr2[i5] = iArr2[i5] & i3;
            }
            this.matrix = iArr;
            return;
        }
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public GF2Matrix(int i, char c) {
        this(i, c, new SecureRandom());
    }

    public GF2Matrix(int i, char c, SecureRandom secureRandom) {
        if (i <= 0) {
            throw new ArithmeticException("Size of matrix is non-positive.");
        } else if (c == 'I') {
            assignUnitMatrix(i);
        } else if (c == 'L') {
            assignRandomLowerTriangularMatrix(i, secureRandom);
        } else if (c == 'R') {
            assignRandomRegularMatrix(i, secureRandom);
        } else if (c == 'U') {
            assignRandomUpperTriangularMatrix(i, secureRandom);
        } else if (c == 'Z') {
            assignZeroMatrix(i, i);
        } else {
            throw new ArithmeticException("Unknown matrix type.");
        }
    }

    public GF2Matrix(GF2Matrix gF2Matrix) {
        this.numColumns = gF2Matrix.getNumColumns();
        this.numRows = gF2Matrix.getNumRows();
        this.length = gF2Matrix.length;
        this.matrix = new int[gF2Matrix.matrix.length][];
        int i = 0;
        while (true) {
            int[][] iArr = this.matrix;
            if (i < iArr.length) {
                iArr[i] = IntUtils.clone(gF2Matrix.matrix[i]);
                i++;
            } else {
                return;
            }
        }
    }

    private GF2Matrix(int i, int i2) {
        if (i2 <= 0 || i <= 0) {
            throw new ArithmeticException("size of matrix is non-positive");
        }
        assignZeroMatrix(i, i2);
    }

    private void assignZeroMatrix(int i, int i2) {
        this.numRows = i;
        this.numColumns = i2;
        this.length = (i2 + 31) >>> 5;
        int i3 = this.numRows;
        int[] iArr = new int[2];
        iArr[1] = this.length;
        iArr[0] = i3;
        this.matrix = (int[][]) Array.newInstance(int.class, iArr);
        for (int i4 = 0; i4 < this.numRows; i4++) {
            for (int i5 = 0; i5 < this.length; i5++) {
                this.matrix[i4][i5] = 0;
            }
        }
    }

    private void assignUnitMatrix(int i) {
        this.numRows = i;
        this.numColumns = i;
        this.length = (i + 31) >>> 5;
        int i2 = this.numRows;
        int[] iArr = new int[2];
        iArr[1] = this.length;
        iArr[0] = i2;
        this.matrix = (int[][]) Array.newInstance(int.class, iArr);
        for (int i3 = 0; i3 < this.numRows; i3++) {
            for (int i4 = 0; i4 < this.length; i4++) {
                this.matrix[i3][i4] = 0;
            }
        }
        for (int i5 = 0; i5 < this.numRows; i5++) {
            this.matrix[i5][i5 >>> 5] = 1 << (i5 & 31);
        }
    }

    private void assignRandomLowerTriangularMatrix(int i, SecureRandom secureRandom) {
        this.numRows = i;
        this.numColumns = i;
        this.length = (i + 31) >>> 5;
        int i2 = this.numRows;
        int[] iArr = new int[2];
        iArr[1] = this.length;
        iArr[0] = i2;
        this.matrix = (int[][]) Array.newInstance(int.class, iArr);
        for (int i3 = 0; i3 < this.numRows; i3++) {
            int i4 = i3 >>> 5;
            int i5 = i3 & 31;
            int i6 = 31 - i5;
            int i7 = 1 << i5;
            for (int i8 = 0; i8 < i4; i8++) {
                this.matrix[i3][i8] = secureRandom.nextInt();
            }
            this.matrix[i3][i4] = i7 | (secureRandom.nextInt() >>> i6);
            while (true) {
                i4++;
                if (i4 >= this.length) {
                    break;
                }
                this.matrix[i3][i4] = 0;
            }
        }
    }

    private void assignRandomUpperTriangularMatrix(int i, SecureRandom secureRandom) {
        int i2;
        this.numRows = i;
        this.numColumns = i;
        this.length = (i + 31) >>> 5;
        int i3 = this.numRows;
        int[] iArr = new int[2];
        iArr[1] = this.length;
        iArr[0] = i3;
        this.matrix = (int[][]) Array.newInstance(int.class, iArr);
        int i4 = i & 31;
        int i5 = i4 == 0 ? -1 : (1 << i4) - 1;
        for (int i6 = 0; i6 < this.numRows; i6++) {
            int i7 = i6 >>> 5;
            int i8 = i6 & 31;
            int i9 = 1 << i8;
            for (int i10 = 0; i10 < i7; i10++) {
                this.matrix[i6][i10] = 0;
            }
            this.matrix[i6][i7] = (secureRandom.nextInt() << i8) | i9;
            while (true) {
                i7++;
                i2 = this.length;
                if (i7 >= i2) {
                    break;
                }
                this.matrix[i6][i7] = secureRandom.nextInt();
            }
            int[] iArr2 = this.matrix[i6];
            int i11 = i2 - 1;
            iArr2[i11] = iArr2[i11] & i5;
        }
    }

    private void assignRandomRegularMatrix(int i, SecureRandom secureRandom) {
        this.numRows = i;
        this.numColumns = i;
        this.length = (i + 31) >>> 5;
        int i2 = this.numRows;
        int[] iArr = new int[2];
        iArr[1] = this.length;
        iArr[0] = i2;
        this.matrix = (int[][]) Array.newInstance(int.class, iArr);
        GF2Matrix gF2Matrix = (GF2Matrix) new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_LT, secureRandom).rightMultiply(new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_UT, secureRandom));
        int[] vector = new Permutation(i, secureRandom).getVector();
        for (int i3 = 0; i3 < i; i3++) {
            System.arraycopy(gF2Matrix.matrix[i3], 0, this.matrix[vector[i3]], 0, this.length);
        }
    }

    public static GF2Matrix[] createRandomRegularMatrixAndItsInverse(int i, SecureRandom secureRandom) {
        GF2Matrix[] gF2MatrixArr = new GF2Matrix[2];
        int i2 = (i + 31) >> 5;
        GF2Matrix gF2Matrix = new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_LT, secureRandom);
        GF2Matrix gF2Matrix2 = new GF2Matrix(i, Matrix.MATRIX_TYPE_RANDOM_UT, secureRandom);
        GF2Matrix gF2Matrix3 = (GF2Matrix) gF2Matrix.rightMultiply(gF2Matrix2);
        Permutation permutation = new Permutation(i, secureRandom);
        int[] vector = permutation.getVector();
        int[] iArr = new int[2];
        iArr[1] = i2;
        iArr[0] = i;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        for (int i3 = 0; i3 < i; i3++) {
            System.arraycopy(gF2Matrix3.matrix[vector[i3]], 0, iArr2[i3], 0, i2);
        }
        gF2MatrixArr[0] = new GF2Matrix(i, iArr2);
        GF2Matrix gF2Matrix4 = new GF2Matrix(i, 'I');
        int i4 = 0;
        while (i4 < i) {
            int i5 = i4 >>> 5;
            int i6 = 1 << (i4 & 31);
            int i7 = i4 + 1;
            for (int i8 = i7; i8 < i; i8++) {
                if ((gF2Matrix.matrix[i8][i5] & i6) != 0) {
                    for (int i9 = 0; i9 <= i5; i9++) {
                        int[][] iArr3 = gF2Matrix4.matrix;
                        int[] iArr4 = iArr3[i8];
                        iArr4[i9] = iArr4[i9] ^ iArr3[i4][i9];
                    }
                }
            }
            i4 = i7;
        }
        GF2Matrix gF2Matrix5 = new GF2Matrix(i, 'I');
        for (int i10 = i - 1; i10 >= 0; i10--) {
            int i11 = i10 >>> 5;
            int i12 = 1 << (i10 & 31);
            for (int i13 = i10 - 1; i13 >= 0; i13--) {
                if ((gF2Matrix2.matrix[i13][i11] & i12) != 0) {
                    for (int i14 = i11; i14 < i2; i14++) {
                        int[][] iArr5 = gF2Matrix5.matrix;
                        int[] iArr6 = iArr5[i13];
                        iArr6[i14] = iArr5[i10][i14] ^ iArr6[i14];
                    }
                }
            }
        }
        gF2MatrixArr[1] = (GF2Matrix) gF2Matrix5.rightMultiply(gF2Matrix4.rightMultiply(permutation));
        return gF2MatrixArr;
    }

    public int[][] getIntArray() {
        return this.matrix;
    }

    public int getLength() {
        return this.length;
    }

    public int[] getRow(int i) {
        return this.matrix[i];
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public byte[] getEncoded() {
        int i = 8;
        byte[] bArr = new byte[((((this.numColumns + 7) >>> 3) * this.numRows) + 8)];
        LittleEndianConversions.I2OSP(this.numRows, bArr, 0);
        LittleEndianConversions.I2OSP(this.numColumns, bArr, 4);
        int i2 = this.numColumns >>> 5;
        int i3 = this.numColumns & 31;
        for (int i4 = 0; i4 < this.numRows; i4++) {
            int i5 = 0;
            while (i5 < i2) {
                LittleEndianConversions.I2OSP(this.matrix[i4][i5], bArr, i);
                i5++;
                i += 4;
            }
            int i6 = 0;
            while (i6 < i3) {
                bArr[i] = (byte) ((this.matrix[i4][i2] >>> i6) & 255);
                i6 += 8;
                i++;
            }
        }
        return bArr;
    }

    public double getHammingWeight() {
        int i;
        int i2 = this.numColumns & 31;
        if (i2 == 0) {
            i = this.length;
        } else {
            i = this.length - 1;
        }
        double d = 0.0d;
        double d2 = 0.0d;
        for (int i3 = 0; i3 < this.numRows; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = this.matrix[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    d += (double) ((i5 >>> i6) & 1);
                    d2 += 1.0d;
                }
            }
            int i7 = this.matrix[i3][this.length - 1];
            for (int i8 = 0; i8 < i2; i8++) {
                d += (double) ((i7 >>> i8) & 1);
                d2 += 1.0d;
            }
        }
        return d / d2;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public boolean isZero() {
        for (int i = 0; i < this.numRows; i++) {
            for (int i2 = 0; i2 < this.length; i2++) {
                if (this.matrix[i][i2] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public GF2Matrix getLeftSubMatrix() {
        if (this.numColumns > this.numRows) {
            int i = (this.numRows + 31) >> 5;
            int i2 = this.numRows;
            int[] iArr = new int[2];
            iArr[1] = i;
            iArr[0] = i2;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            int i3 = (1 << (this.numRows & 31)) - 1;
            if (i3 == 0) {
                i3 = -1;
            }
            for (int i4 = this.numRows - 1; i4 >= 0; i4--) {
                System.arraycopy(this.matrix[i4], 0, iArr2[i4], 0, i);
                int[] iArr3 = iArr2[i4];
                int i5 = i - 1;
                iArr3[i5] = iArr3[i5] & i3;
            }
            return new GF2Matrix(this.numRows, iArr2);
        }
        throw new ArithmeticException("empty submatrix");
    }

    public GF2Matrix extendLeftCompactForm() {
        GF2Matrix gF2Matrix = new GF2Matrix(this.numRows, this.numColumns + this.numRows);
        int i = (this.numRows - 1) + this.numColumns;
        int i2 = this.numRows - 1;
        while (i2 >= 0) {
            System.arraycopy(this.matrix[i2], 0, gF2Matrix.matrix[i2], 0, this.length);
            int[] iArr = gF2Matrix.matrix[i2];
            int i3 = i >> 5;
            iArr[i3] = iArr[i3] | (1 << (i & 31));
            i2--;
            i--;
        }
        return gF2Matrix;
    }

    public GF2Matrix getRightSubMatrix() {
        int i;
        if (this.numColumns > this.numRows) {
            int i2 = this.numRows >> 5;
            int i3 = this.numRows & 31;
            GF2Matrix gF2Matrix = new GF2Matrix(this.numRows, this.numColumns - this.numRows);
            for (int i4 = this.numRows - 1; i4 >= 0; i4--) {
                int i5 = 0;
                if (i3 != 0) {
                    int i6 = i2;
                    while (true) {
                        i = gF2Matrix.length;
                        if (i5 >= i - 1) {
                            break;
                        }
                        int[] iArr = gF2Matrix.matrix[i4];
                        int[][] iArr2 = this.matrix;
                        int i7 = i6 + 1;
                        iArr[i5] = (iArr2[i4][i6] >>> i3) | (iArr2[i4][i7] << (32 - i3));
                        i5++;
                        i6 = i7;
                    }
                    int[][] iArr3 = gF2Matrix.matrix;
                    int[][] iArr4 = this.matrix;
                    int i8 = i6 + 1;
                    iArr3[i4][i - 1] = iArr4[i4][i6] >>> i3;
                    if (i8 < this.length) {
                        int[] iArr5 = iArr3[i4];
                        int i9 = i - 1;
                        iArr5[i9] = iArr5[i9] | (iArr4[i4][i8] << (32 - i3));
                    }
                } else {
                    System.arraycopy(this.matrix[i4], i2, gF2Matrix.matrix[i4], 0, gF2Matrix.length);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("empty submatrix");
    }

    public GF2Matrix extendRightCompactForm() {
        int i;
        GF2Matrix gF2Matrix = new GF2Matrix(this.numRows, this.numRows + this.numColumns);
        int i2 = this.numRows >> 5;
        int i3 = this.numRows & 31;
        for (int i4 = this.numRows - 1; i4 >= 0; i4--) {
            int[][] iArr = gF2Matrix.matrix;
            int[] iArr2 = iArr[i4];
            int i5 = i4 >> 5;
            iArr2[i5] = iArr2[i5] | (1 << (i4 & 31));
            int i6 = 0;
            if (i3 != 0) {
                int i7 = i2;
                while (true) {
                    i = this.length;
                    if (i6 >= i - 1) {
                        break;
                    }
                    int i8 = this.matrix[i4][i6];
                    int[][] iArr3 = gF2Matrix.matrix;
                    int[] iArr4 = iArr3[i4];
                    int i9 = i7 + 1;
                    iArr4[i7] = iArr4[i7] | (i8 << i3);
                    int[] iArr5 = iArr3[i4];
                    iArr5[i9] = (i8 >>> (32 - i3)) | iArr5[i9];
                    i6++;
                    i7 = i9;
                }
                int i10 = this.matrix[i4][i - 1];
                int[][] iArr6 = gF2Matrix.matrix;
                int[] iArr7 = iArr6[i4];
                int i11 = i7 + 1;
                iArr7[i7] = iArr7[i7] | (i10 << i3);
                if (i11 < gF2Matrix.length) {
                    int[] iArr8 = iArr6[i4];
                    iArr8[i11] = (i10 >>> (32 - i3)) | iArr8[i11];
                }
            } else {
                System.arraycopy(this.matrix[i4], 0, iArr[i4], i2, this.length);
            }
        }
        return gF2Matrix;
    }

    public Matrix computeTranspose() {
        int i = this.numColumns;
        int[] iArr = new int[2];
        iArr[1] = (this.numRows + 31) >>> 5;
        iArr[0] = i;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        for (int i2 = 0; i2 < this.numRows; i2++) {
            for (int i3 = 0; i3 < this.numColumns; i3++) {
                int i4 = i2 >>> 5;
                int i5 = i2 & 31;
                if (((this.matrix[i2][i3 >>> 5] >>> (i3 & 31)) & 1) == 1) {
                    int[] iArr3 = iArr2[i3];
                    iArr3[i4] = (1 << i5) | iArr3[i4];
                }
            }
        }
        return new GF2Matrix(this.numRows, iArr2);
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Matrix computeInverse() {
        if (this.numRows == this.numColumns) {
            int i = this.numRows;
            int[] iArr = new int[2];
            iArr[1] = this.length;
            iArr[0] = i;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            for (int i2 = this.numRows - 1; i2 >= 0; i2--) {
                iArr2[i2] = IntUtils.clone(this.matrix[i2]);
            }
            int i3 = this.numRows;
            int[] iArr3 = new int[2];
            iArr3[1] = this.length;
            iArr3[0] = i3;
            int[][] iArr4 = (int[][]) Array.newInstance(int.class, iArr3);
            for (int i4 = this.numRows - 1; i4 >= 0; i4--) {
                iArr4[i4][i4 >> 5] = 1 << (i4 & 31);
            }
            for (int i5 = 0; i5 < this.numRows; i5++) {
                int i6 = i5 >> 5;
                int i7 = 1 << (i5 & 31);
                if ((iArr2[i5][i6] & i7) == 0) {
                    int i8 = i5 + 1;
                    boolean z = false;
                    while (i8 < this.numRows) {
                        if ((iArr2[i8][i6] & i7) != 0) {
                            swapRows(iArr2, i5, i8);
                            swapRows(iArr4, i5, i8);
                            i8 = this.numRows;
                            z = true;
                        }
                        i8++;
                    }
                    if (!z) {
                        throw new ArithmeticException("Matrix is not invertible.");
                    }
                }
                for (int i9 = this.numRows - 1; i9 >= 0; i9--) {
                    if (!(i9 == i5 || (iArr2[i9][i6] & i7) == 0)) {
                        addToRow(iArr2[i5], iArr2[i9], i6);
                        addToRow(iArr4[i5], iArr4[i9], 0);
                    }
                }
            }
            return new GF2Matrix(this.numColumns, iArr4);
        }
        throw new ArithmeticException("Matrix is not invertible.");
    }

    public Matrix leftMultiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        if (vector.length == this.numRows) {
            int[][] iArr = new int[this.numRows][];
            for (int i = this.numRows - 1; i >= 0; i--) {
                iArr[i] = IntUtils.clone(this.matrix[vector[i]]);
            }
            return new GF2Matrix(this.numRows, iArr);
        }
        throw new ArithmeticException("length mismatch");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Vector leftMultiply(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[this.length];
            int i = this.numRows >> 5;
            int i2 = 1 << (this.numRows & 31);
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = 1;
                do {
                    if ((vecArray[i4] & i5) != 0) {
                        for (int i6 = 0; i6 < this.length; i6++) {
                            iArr[i6] = iArr[i6] ^ this.matrix[i3][i6];
                        }
                    }
                    i3++;
                    i5 <<= 1;
                } while (i5 != 0);
            }
            for (int i7 = 1; i7 != i2; i7 <<= 1) {
                if ((vecArray[i] & i7) != 0) {
                    for (int i8 = 0; i8 < this.length; i8++) {
                        iArr[i8] = iArr[i8] ^ this.matrix[i3][i8];
                    }
                }
                i3++;
            }
            return new GF2Vector(iArr, this.numColumns);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Vector leftMultiplyLeftCompactForm(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[(((this.numRows + this.numColumns) + 31) >>> 5)];
            int i = this.numRows >>> 5;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = 1;
                do {
                    if ((vecArray[i3] & i4) != 0) {
                        for (int i5 = 0; i5 < this.length; i5++) {
                            iArr[i5] = iArr[i5] ^ this.matrix[i2][i5];
                        }
                        int i6 = (this.numColumns + i2) >>> 5;
                        iArr[i6] = (1 << ((this.numColumns + i2) & 31)) | iArr[i6];
                    }
                    i2++;
                    i4 <<= 1;
                } while (i4 != 0);
            }
            int i7 = 1 << (this.numRows & 31);
            for (int i8 = 1; i8 != i7; i8 <<= 1) {
                if ((vecArray[i] & i8) != 0) {
                    for (int i9 = 0; i9 < this.length; i9++) {
                        iArr[i9] = iArr[i9] ^ this.matrix[i2][i9];
                    }
                    int i10 = (this.numColumns + i2) >>> 5;
                    iArr[i10] = (1 << ((this.numColumns + i2) & 31)) | iArr[i10];
                }
                i2++;
            }
            return new GF2Vector(iArr, this.numRows + this.numColumns);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Matrix rightMultiply(Matrix matrix2) {
        int i;
        if (!(matrix2 instanceof GF2Matrix)) {
            throw new ArithmeticException("matrix is not defined over GF(2)");
        } else if (matrix2.numRows == this.numColumns) {
            GF2Matrix gF2Matrix = (GF2Matrix) matrix2;
            GF2Matrix gF2Matrix2 = new GF2Matrix(this.numRows, matrix2.numColumns);
            int i2 = this.numColumns & 31;
            if (i2 == 0) {
                i = this.length;
            } else {
                i = this.length - 1;
            }
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = this.matrix[i3][i5];
                    for (int i7 = 0; i7 < 32; i7++) {
                        if (((1 << i7) & i6) != 0) {
                            for (int i8 = 0; i8 < gF2Matrix.length; i8++) {
                                int[] iArr = gF2Matrix2.matrix[i3];
                                iArr[i8] = iArr[i8] ^ gF2Matrix.matrix[i4][i8];
                            }
                        }
                        i4++;
                    }
                }
                int i9 = this.matrix[i3][this.length - 1];
                for (int i10 = 0; i10 < i2; i10++) {
                    if (((1 << i10) & i9) != 0) {
                        for (int i11 = 0; i11 < gF2Matrix.length; i11++) {
                            int[] iArr2 = gF2Matrix2.matrix[i3];
                            iArr2[i11] = iArr2[i11] ^ gF2Matrix.matrix[i4][i11];
                        }
                    }
                    i4++;
                }
            }
            return gF2Matrix2;
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Matrix rightMultiply(Permutation permutation) {
        int[] vector = permutation.getVector();
        if (vector.length == this.numColumns) {
            GF2Matrix gF2Matrix = new GF2Matrix(this.numRows, this.numColumns);
            for (int i = this.numColumns - 1; i >= 0; i--) {
                int i2 = i >>> 5;
                int i3 = i & 31;
                int i4 = vector[i] >>> 5;
                int i5 = vector[i] & 31;
                for (int i6 = this.numRows - 1; i6 >= 0; i6--) {
                    int[] iArr = gF2Matrix.matrix[i6];
                    iArr[i2] = iArr[i2] | (((this.matrix[i6][i4] >>> i5) & 1) << i3);
                }
            }
            return gF2Matrix;
        }
        throw new ArithmeticException("length mismatch");
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public Vector rightMultiply(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numColumns) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[((this.numRows + 31) >>> 5)];
            for (int i = 0; i < this.numRows; i++) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.length; i3++) {
                    i2 ^= this.matrix[i][i3] & vecArray[i3];
                }
                int i4 = 0;
                for (int i5 = 0; i5 < 32; i5++) {
                    i4 ^= (i2 >>> i5) & 1;
                }
                if (i4 == 1) {
                    int i6 = i >>> 5;
                    iArr[i6] = iArr[i6] | (1 << (i & 31));
                }
            }
            return new GF2Vector(iArr, this.numRows);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public Vector rightMultiplyRightCompactForm(Vector vector) {
        if (!(vector instanceof GF2Vector)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        } else if (vector.length == this.numColumns + this.numRows) {
            int[] vecArray = ((GF2Vector) vector).getVecArray();
            int[] iArr = new int[((this.numRows + 31) >>> 5)];
            int i = this.numRows >> 5;
            int i2 = this.numRows & 31;
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = i3 >> 5;
                int i5 = i3 & 31;
                int i6 = (vecArray[i4] >>> i5) & 1;
                if (i2 != 0) {
                    int i7 = i;
                    int i8 = 0;
                    while (i8 < this.length - 1) {
                        int i9 = i7 + 1;
                        i6 ^= ((vecArray[i7] >>> i2) | (vecArray[i9] << (32 - i2))) & this.matrix[i3][i8];
                        i8++;
                        i7 = i9;
                    }
                    int i10 = i7 + 1;
                    int i11 = vecArray[i7] >>> i2;
                    if (i10 < vecArray.length) {
                        i11 |= vecArray[i10] << (32 - i2);
                    }
                    i6 ^= this.matrix[i3][this.length - 1] & i11;
                } else {
                    int i12 = i;
                    int i13 = 0;
                    while (i13 < this.length) {
                        i6 ^= vecArray[i12] & this.matrix[i3][i13];
                        i13++;
                        i12++;
                    }
                }
                int i14 = 0;
                for (int i15 = 0; i15 < 32; i15++) {
                    i14 ^= i6 & 1;
                    i6 >>>= 1;
                }
                if (i14 == 1) {
                    iArr[i4] = iArr[i4] | (1 << i5);
                }
            }
            return new GF2Vector(iArr, this.numRows);
        } else {
            throw new ArithmeticException("length mismatch");
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2Matrix)) {
            return false;
        }
        GF2Matrix gF2Matrix = (GF2Matrix) obj;
        if (this.numRows != gF2Matrix.numRows || this.numColumns != gF2Matrix.numColumns || this.length != gF2Matrix.length) {
            return false;
        }
        for (int i = 0; i < this.numRows; i++) {
            if (!IntUtils.equals(this.matrix[i], gF2Matrix.matrix[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = (((this.numRows * 31) + this.numColumns) * 31) + this.length;
        for (int i2 = 0; i2 < this.numRows; i2++) {
            i = (i * 31) + this.matrix[i2].hashCode();
        }
        return i;
    }

    @Override // org.spongycastle.pqc.math.linearalgebra.Matrix
    public String toString() {
        int i;
        int i2 = this.numColumns & 31;
        if (i2 == 0) {
            i = this.length;
        } else {
            i = this.length - 1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.numRows; i3++) {
            stringBuffer.append(i3 + ": ");
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = this.matrix[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i7 = this.matrix[i3][this.length - 1];
            for (int i8 = 0; i8 < i2; i8++) {
                if (((i7 >>> i8) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    private static void swapRows(int[][] iArr, int i, int i2) {
        int[] iArr2 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = iArr2;
    }

    private static void addToRow(int[] iArr, int[] iArr2, int i) {
        for (int length2 = iArr2.length - 1; length2 >= i; length2--) {
            iArr2[length2] = iArr[length2] ^ iArr2[length2];
        }
    }
}
