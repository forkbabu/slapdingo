package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzix implements zzig {
    private int zzahg = -1;
    private ByteBuffer zzalb = zzaiu;
    private int zzaly = -1;
    private int[] zzalz;
    private boolean zzama;
    private int[] zzamb;
    private ByteBuffer zzamc = zzaiu;
    private boolean zzamd;

    @Override // com.google.android.gms.internal.ads.zzig
    public final int zzfj() {
        return 2;
    }

    public final void zzb(int[] iArr) {
        this.zzalz = iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final boolean zzb(int i, int i2, int i3) throws zzif {
        boolean z = !Arrays.equals(this.zzalz, this.zzamb);
        int[] iArr = this.zzalz;
        this.zzamb = iArr;
        if (iArr == null) {
            this.zzama = false;
            return z;
        } else if (i3 != 2) {
            throw new zzif(i, i2, i3);
        } else if (!z && this.zzaly == i && this.zzahg == i2) {
            return false;
        } else {
            this.zzaly = i;
            this.zzahg = i2;
            this.zzama = i2 != this.zzamb.length;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.zzamb;
                if (i4 >= iArr2.length) {
                    return true;
                }
                int i5 = iArr2[i4];
                if (i5 < i2) {
                    this.zzama = (i5 != i4) | this.zzama;
                    i4++;
                } else {
                    throw new zzif(i, i2, i3);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final boolean isActive() {
        return this.zzama;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final int zzfi() {
        int[] iArr = this.zzamb;
        return iArr == null ? this.zzahg : iArr.length;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final void zzn(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzahg * 2)) * this.zzamb.length) << 1;
        if (this.zzamc.capacity() < length) {
            this.zzamc = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzamc.clear();
        }
        while (position < limit) {
            for (int i : this.zzamb) {
                this.zzamc.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.zzahg << 1;
        }
        byteBuffer.position(limit);
        this.zzamc.flip();
        this.zzalb = this.zzamc;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final void zzfk() {
        this.zzamd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final ByteBuffer zzfl() {
        ByteBuffer byteBuffer = this.zzalb;
        this.zzalb = zzaiu;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final boolean zzfd() {
        return this.zzamd && this.zzalb == zzaiu;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final void flush() {
        this.zzalb = zzaiu;
        this.zzamd = false;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final void reset() {
        flush();
        this.zzamc = zzaiu;
        this.zzahg = -1;
        this.zzaly = -1;
        this.zzamb = null;
        this.zzama = false;
    }
}
