package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbei implements zzok {
    private Uri uri;
    private final zzok zzejw;
    private final long zzejx;
    private final zzok zzejy;
    private long zzejz;

    zzbei(zzok zzok, int i, zzok zzok2) {
        this.zzejw = zzok;
        this.zzejx = (long) i;
        this.zzejy = zzok2;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final long zza(zzop zzop) throws IOException {
        zzop zzop2;
        long j;
        this.uri = zzop.uri;
        zzop zzop3 = null;
        if (zzop.position >= this.zzejx) {
            zzop2 = null;
        } else {
            long j2 = zzop.position;
            if (zzop.zzcp != -1) {
                j = Math.min(zzop.zzcp, this.zzejx - j2);
            } else {
                j = this.zzejx - j2;
            }
            zzop2 = new zzop(zzop.uri, j2, j, null);
        }
        if (zzop.zzcp == -1 || zzop.position + zzop.zzcp > this.zzejx) {
            zzop3 = new zzop(zzop.uri, Math.max(this.zzejx, zzop.position), zzop.zzcp != -1 ? Math.min(zzop.zzcp, (zzop.position + zzop.zzcp) - this.zzejx) : -1, null);
        }
        long j3 = 0;
        long zza = zzop2 != null ? this.zzejw.zza(zzop2) : 0;
        if (zzop3 != null) {
            j3 = this.zzejy.zza(zzop3);
        }
        this.zzejz = zzop.position;
        if (zza == -1 || j3 == -1) {
            return -1;
        }
        return zza + j3;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzejz;
        long j2 = this.zzejx;
        if (j < j2) {
            i3 = this.zzejw.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.zzejz += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzejz < this.zzejx) {
            return i3;
        }
        int read = this.zzejy.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzejz += (long) read;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final void close() throws IOException {
        this.zzejw.close();
        this.zzejy.close();
    }
}
