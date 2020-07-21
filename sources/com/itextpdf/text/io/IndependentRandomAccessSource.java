package com.itextpdf.text.io;

import java.io.IOException;

public class IndependentRandomAccessSource implements RandomAccessSource {
    private final RandomAccessSource source;

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() throws IOException {
    }

    public IndependentRandomAccessSource(RandomAccessSource randomAccessSource) {
        this.source = randomAccessSource;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) throws IOException {
        return this.source.get(j);
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) throws IOException {
        return this.source.get(j, bArr, i, i2);
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.source.length();
    }
}
