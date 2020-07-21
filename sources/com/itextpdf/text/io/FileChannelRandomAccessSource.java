package com.itextpdf.text.io;

import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelRandomAccessSource implements RandomAccessSource {
    private final FileChannel channel;
    private final MappedChannelRandomAccessSource source;

    public FileChannelRandomAccessSource(FileChannel fileChannel) throws IOException {
        this.channel = fileChannel;
        if (fileChannel.size() != 0) {
            MappedChannelRandomAccessSource mappedChannelRandomAccessSource = new MappedChannelRandomAccessSource(fileChannel, 0, fileChannel.size());
            this.source = mappedChannelRandomAccessSource;
            mappedChannelRandomAccessSource.open();
            return;
        }
        throw new IOException("File size is 0 bytes");
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() throws IOException {
        this.source.close();
        this.channel.close();
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
