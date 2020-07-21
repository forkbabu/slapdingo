package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzrw {
    final long value;
    final int zzbtt;
    final String zzbua;

    zzrw(long j, String str, int i) {
        this.value = j;
        this.zzbua = str;
        this.zzbtt = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzrw)) {
            zzrw zzrw = (zzrw) obj;
            if (zzrw.value == this.value && zzrw.zzbtt == this.zzbtt) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
