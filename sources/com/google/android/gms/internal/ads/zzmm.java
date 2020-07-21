package com.google.android.gms.internal.ads;

import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzmm implements zznn {
    private final zznn[] zzbdc;

    public zzmm(zznn[] zznnArr) {
        this.zzbdc = zznnArr;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final long zzhm() {
        long j = Long.MAX_VALUE;
        for (zznn zznn : this.zzbdc) {
            long zzhm = zznn.zzhm();
            if (zzhm != Long.MIN_VALUE) {
                j = Math.min(j, zzhm);
            }
        }
        if (j == LongCompanionObject.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final boolean zzee(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzhm = zzhm();
            if (zzhm == Long.MIN_VALUE) {
                break;
            }
            zznn[] zznnArr = this.zzbdc;
            z = false;
            for (zznn zznn : zznnArr) {
                if (zznn.zzhm() == zzhm) {
                    z |= zznn.zzee(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
