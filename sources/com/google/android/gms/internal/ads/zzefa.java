package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzefa extends OutputStream {
    private static final byte[] zziab = new byte[0];
    private byte[] buffer = new byte[128];
    private final int zziac = 128;
    private final ArrayList<zzeer> zziad = new ArrayList<>();
    private int zziae;
    private int zziaf;

    zzefa(int i) {
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i) {
        if (this.zziaf == this.buffer.length) {
            zzfw(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.zziaf;
        this.zziaf = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (i2 <= this.buffer.length - this.zziaf) {
            System.arraycopy(bArr, i, this.buffer, this.zziaf, i2);
            this.zziaf += i2;
            return;
        }
        int length = this.buffer.length - this.zziaf;
        System.arraycopy(bArr, i, this.buffer, this.zziaf, length);
        int i3 = i2 - length;
        zzfw(i3);
        System.arraycopy(bArr, i + length, this.buffer, 0, i3);
        this.zziaf = i3;
    }

    public final synchronized zzeer zzbct() {
        if (this.zziaf >= this.buffer.length) {
            this.zziad.add(new zzefb(this.buffer));
            this.buffer = zziab;
        } else if (this.zziaf > 0) {
            byte[] bArr = this.buffer;
            int i = this.zziaf;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            this.zziad.add(new zzefb(bArr2));
        }
        this.zziae += this.zziaf;
        this.zziaf = 0;
        return zzeer.zzl(this.zziad);
    }

    private final synchronized int size() {
        return this.zziae + this.zziaf;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    private final void zzfw(int i) {
        this.zziad.add(new zzefb(this.buffer));
        int length = this.zziae + this.buffer.length;
        this.zziae = length;
        this.buffer = new byte[Math.max(this.zziac, Math.max(i, length >>> 1))];
        this.zziaf = 0;
    }
}
