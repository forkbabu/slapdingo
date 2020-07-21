package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzjg implements zzig {
    private int zzahg = -1;
    private float zzaht = 1.0f;
    private float zzahu = 1.0f;
    private ByteBuffer zzalb;
    private int zzaly = -1;
    private ByteBuffer zzamc;
    private boolean zzamd;
    private zzjd zzank;
    private ShortBuffer zzanl;
    private long zzanm;
    private long zzann;

    public zzjg() {
        ByteBuffer byteBuffer = zzaiu;
        this.zzamc = byteBuffer;
        this.zzanl = byteBuffer.asShortBuffer();
        this.zzalb = zzaiu;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final int zzfj() {
        return 2;
    }

    public final float zzb(float f) {
        float zza = zzpo.zza(f, 0.1f, 8.0f);
        this.zzaht = zza;
        return zza;
    }

    public final float zzc(float f) {
        this.zzahu = zzpo.zza(f, 0.1f, 8.0f);
        return f;
    }

    public final long zzgj() {
        return this.zzanm;
    }

    public final long zzgk() {
        return this.zzann;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final boolean zzb(int i, int i2, int i3) throws zzif {
        if (i3 != 2) {
            throw new zzif(i, i2, i3);
        } else if (this.zzaly == i && this.zzahg == i2) {
            return false;
        } else {
            this.zzaly = i;
            this.zzahg = i2;
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final boolean isActive() {
        return Math.abs(this.zzaht - 1.0f) >= 0.01f || Math.abs(this.zzahu - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final int zzfi() {
        return this.zzahg;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final void zzn(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzanm += (long) remaining;
            this.zzank.zza(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zzge = (this.zzank.zzge() * this.zzahg) << 1;
        if (zzge > 0) {
            if (this.zzamc.capacity() < zzge) {
                ByteBuffer order = ByteBuffer.allocateDirect(zzge).order(ByteOrder.nativeOrder());
                this.zzamc = order;
                this.zzanl = order.asShortBuffer();
            } else {
                this.zzamc.clear();
                this.zzanl.clear();
            }
            this.zzank.zzb(this.zzanl);
            this.zzann += (long) zzge;
            this.zzamc.limit(zzge);
            this.zzalb = this.zzamc;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final void zzfk() {
        this.zzank.zzfk();
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
        if (!this.zzamd) {
            return false;
        }
        zzjd zzjd = this.zzank;
        return zzjd == null || zzjd.zzge() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final void flush() {
        zzjd zzjd = new zzjd(this.zzaly, this.zzahg);
        this.zzank = zzjd;
        zzjd.setSpeed(this.zzaht);
        this.zzank.zza(this.zzahu);
        this.zzalb = zzaiu;
        this.zzanm = 0;
        this.zzann = 0;
        this.zzamd = false;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final void reset() {
        this.zzank = null;
        ByteBuffer byteBuffer = zzaiu;
        this.zzamc = byteBuffer;
        this.zzanl = byteBuffer.asShortBuffer();
        this.zzalb = zzaiu;
        this.zzahg = -1;
        this.zzaly = -1;
        this.zzanm = 0;
        this.zzann = 0;
        this.zzamd = false;
    }
}
