package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeii extends InputStream {
    private int mark;
    private final /* synthetic */ zzeie zzihr;
    private zzeif zziib;
    private zzeey zziic;
    private int zziid;
    private int zziie;
    private int zziif;

    public zzeii(zzeie zzeie) {
        this.zzihr = zzeie;
        initialize();
    }

    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw null;
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else {
            int zzl = zzl(bArr, i, i2);
            if (zzl == 0) {
                return -1;
            }
            return zzl;
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        if (j >= 0) {
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) zzl(null, 0, (int) j);
        }
        throw new IndexOutOfBoundsException();
    }

    private final int zzl(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            zzbhd();
            if (this.zziic == null) {
                break;
            }
            int min = Math.min(this.zziid - this.zziie, i3);
            if (bArr != null) {
                this.zziic.zza(bArr, this.zziie, i, min);
                i += min;
            }
            this.zziie += min;
            i3 -= min;
        }
        return i2 - i3;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        zzbhd();
        zzeey zzeey = this.zziic;
        if (zzeey == null) {
            return -1;
        }
        int i = this.zziie;
        this.zziie = i + 1;
        return zzeey.zzft(i) & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.zzihr.size() - (this.zziif + this.zziie);
    }

    public final void mark(int i) {
        this.mark = this.zziif + this.zziie;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        initialize();
        zzl(null, 0, this.mark);
    }

    private final void initialize() {
        zzeif zzeif = new zzeif(this.zzihr, null);
        this.zziib = zzeif;
        zzeey zzeey = (zzeey) zzeif.next();
        this.zziic = zzeey;
        this.zziid = zzeey.size();
        this.zziie = 0;
        this.zziif = 0;
    }

    private final void zzbhd() {
        int i;
        if (this.zziic != null && this.zziie == (i = this.zziid)) {
            this.zziif += i;
            this.zziie = 0;
            if (this.zziib.hasNext()) {
                zzeey zzeey = (zzeey) this.zziib.next();
                this.zziic = zzeey;
                this.zziid = zzeey.size();
                return;
            }
            this.zziic = null;
            this.zziid = 0;
        }
    }
}
