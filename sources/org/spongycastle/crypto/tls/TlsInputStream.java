package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

class TlsInputStream extends InputStream {
    private byte[] buf = new byte[1];
    private TlsProtocol handler = null;

    TlsInputStream(TlsProtocol tlsProtocol) {
        this.handler = tlsProtocol;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.handler.applicationDataAvailable();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.handler.readApplicationData(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.buf) < 0) {
            return -1;
        }
        return this.buf[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        this.handler.close();
    }
}
