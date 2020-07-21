package com.itextpdf.text.io;

import java.io.IOException;
import kotlin.UByte;

class ArrayRandomAccessSource implements RandomAccessSource {
    private byte[] array;

    public ArrayRandomAccessSource(byte[] bArr) {
        if (bArr != null) {
            this.array = bArr;
            return;
        }
        throw null;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) {
        byte[] bArr = this.array;
        if (j >= ((long) bArr.length)) {
            return -1;
        }
        return bArr[(int) j] & UByte.MAX_VALUE;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.array;
        if (bArr2 == null) {
            throw new IllegalStateException("Already closed");
        } else if (j >= ((long) bArr2.length)) {
            return -1;
        } else {
            if (((long) i2) + j > ((long) bArr2.length)) {
                i2 = (int) (((long) bArr2.length) - j);
            }
            System.arraycopy(this.array, (int) j, bArr, i, i2);
            return i2;
        }
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return (long) this.array.length;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() throws IOException {
        this.array = null;
    }
}
