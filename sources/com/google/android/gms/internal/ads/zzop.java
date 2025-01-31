package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzop {
    public final int flags;
    public final long position;
    public final Uri uri;
    public final byte[] zzbid;
    public final long zzbie;
    public final String zzcn;
    public final long zzcp;

    public zzop(Uri uri2) {
        this(uri2, 0);
    }

    private zzop(Uri uri2, int i) {
        this(uri2, 0, -1, null, 0);
    }

    public zzop(Uri uri2, long j, long j2, String str) {
        this(uri2, j, j, j2, str, 0);
    }

    private zzop(Uri uri2, long j, long j2, String str, int i) {
        this(uri2, 0, 0, -1, null, 0);
    }

    private zzop(Uri uri2, long j, long j2, long j3, String str, int i) {
        this(uri2, null, j, j2, j3, str, i);
    }

    public zzop(Uri uri2, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzpb.checkArgument(j >= 0);
        zzpb.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzpb.checkArgument(z);
        this.uri = uri2;
        this.zzbid = bArr;
        this.zzbie = j;
        this.position = j2;
        this.zzcp = j3;
        this.zzcn = str;
        this.flags = i;
    }

    public final boolean isFlagSet(int i) {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        String arrays = Arrays.toString(this.zzbid);
        long j = this.zzbie;
        long j2 = this.position;
        long j3 = this.zzcp;
        String str = this.zzcn;
        int i = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(arrays);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
