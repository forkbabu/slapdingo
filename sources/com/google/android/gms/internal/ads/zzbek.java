package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbek {
    private long zzdh;

    public final long zzq(ByteBuffer byteBuffer) {
        zzbu zzbu;
        zzbr zzbr;
        long j = this.zzdh;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbp> it2 = new zzbn(new zzbeh(duplicate), zzbem.zzekb).zzbjd().iterator();
            while (true) {
                zzbu = null;
                if (!it2.hasNext()) {
                    zzbr = null;
                    break;
                }
                zzbp next = it2.next();
                if (next instanceof zzbr) {
                    zzbr = (zzbr) next;
                    break;
                }
            }
            Iterator<zzbp> it3 = zzbr.zzbjd().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                zzbp next2 = it3.next();
                if (next2 instanceof zzbu) {
                    zzbu = (zzbu) next2;
                    break;
                }
            }
            long duration = (zzbu.getDuration() * 1000) / zzbu.zzs();
            this.zzdh = duration;
            return duration;
        } catch (IOException | RuntimeException unused) {
            return 0;
        }
    }
}
