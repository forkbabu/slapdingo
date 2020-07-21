package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzol implements zzok {
    private final byte[] data;
    private Uri uri;
    private int zzbht;
    private int zzbhu;

    public zzol(byte[] bArr) {
        zzpb.checkNotNull(bArr);
        zzpb.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final long zza(zzop zzop) throws IOException {
        this.uri = zzop.uri;
        this.zzbht = (int) zzop.position;
        int length = (int) (zzop.zzcp == -1 ? ((long) this.data.length) - zzop.position : zzop.zzcp);
        this.zzbhu = length;
        if (length > 0 && this.zzbht + length <= this.data.length) {
            return (long) length;
        }
        int i = this.zzbht;
        long j = zzop.zzcp;
        int length2 = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i);
        sb.append(", ");
        sb.append(j);
        sb.append("], length: ");
        sb.append(length2);
        throw new IOException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbhu;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbht, bArr, i, min);
        this.zzbht += min;
        this.zzbhu -= min;
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final void close() throws IOException {
        this.uri = null;
    }
}
