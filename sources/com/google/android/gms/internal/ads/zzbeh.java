package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbeh implements zzekm {
    private final ByteBuffer zzamc;

    zzbeh(ByteBuffer byteBuffer) {
        this.zzamc = byteBuffer.duplicate();
    }

    @Override // java.io.Closeable, com.google.android.gms.internal.ads.zzekm, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzekm
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.zzamc.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zzamc.remaining());
        byte[] bArr = new byte[min];
        this.zzamc.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzekm
    public final long size() throws IOException {
        return (long) this.zzamc.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzekm
    public final long position() throws IOException {
        return (long) this.zzamc.position();
    }

    @Override // com.google.android.gms.internal.ads.zzekm
    public final void zzfc(long j) throws IOException {
        this.zzamc.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzekm
    public final ByteBuffer zzh(long j, long j2) throws IOException {
        int position = this.zzamc.position();
        this.zzamc.position((int) j);
        ByteBuffer slice = this.zzamc.slice();
        slice.limit((int) j2);
        this.zzamc.position(position);
        return slice;
    }
}
