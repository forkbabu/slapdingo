package com.itextpdf.text.io;

import java.io.IOException;
import java.io.RandomAccessFile;

class RAFRandomAccessSource implements RandomAccessSource {
    private final long length;
    private final RandomAccessFile raf;

    public RAFRandomAccessSource(RandomAccessFile randomAccessFile) throws IOException {
        this.raf = randomAccessFile;
        this.length = randomAccessFile.length();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) throws IOException {
        if (j > this.raf.length()) {
            return -1;
        }
        this.raf.seek(j);
        return this.raf.read();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) throws IOException {
        if (j > this.length) {
            return -1;
        }
        this.raf.seek(j);
        return this.raf.read(bArr, i, i2);
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.length;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() throws IOException {
        this.raf.close();
    }
}
