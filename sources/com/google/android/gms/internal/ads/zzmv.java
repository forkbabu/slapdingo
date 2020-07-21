package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzmv {
    private final zzjz zzarc;
    private final zzjx[] zzbek;
    private zzjx zzbel;

    public zzmv(zzjx[] zzjxArr, zzjz zzjz) {
        this.zzbek = zzjxArr;
        this.zzarc = zzjz;
    }

    public final zzjx zza(zzjw zzjw, Uri uri) throws IOException, InterruptedException {
        zzjx zzjx = this.zzbel;
        if (zzjx != null) {
            return zzjx;
        }
        zzjx[] zzjxArr = this.zzbek;
        int length = zzjxArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzjx zzjx2 = zzjxArr[i];
            try {
                if (zzjx2.zza(zzjw)) {
                    this.zzbel = zzjx2;
                    zzjw.zzgp();
                    break;
                }
                i++;
            } catch (EOFException unused) {
            } finally {
                zzjw.zzgp();
            }
        }
        zzjx zzjx3 = this.zzbel;
        if (zzjx3 != null) {
            zzjx3.zza(this.zzarc);
            return this.zzbel;
        }
        String zza = zzpo.zza(this.zzbek);
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zza);
        sb.append(") could read the stream.");
        throw new zznq(sb.toString(), uri);
    }

    public final void release() {
        zzjx zzjx = this.zzbel;
        if (zzjx != null) {
            zzjx.release();
            this.zzbel = null;
        }
    }
}
