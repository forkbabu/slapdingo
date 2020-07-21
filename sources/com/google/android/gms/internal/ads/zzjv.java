package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzjv implements zzkc {
    private final int length;
    private final long zzaih;
    private final int[] zzaom;
    private final long[] zzaon;
    private final long[] zzaoo;
    private final long[] zzaop;

    public zzjv(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzaom = iArr;
        this.zzaon = jArr;
        this.zzaoo = jArr2;
        this.zzaop = jArr3;
        int length2 = iArr.length;
        this.length = length2;
        if (length2 > 0) {
            this.zzaih = jArr2[length2 - 1] + jArr3[length2 - 1];
        } else {
            this.zzaih = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final long getDurationUs() {
        return this.zzaih;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final long zzdz(long j) {
        return this.zzaon[zzpo.zza(this.zzaop, j, true, true)];
    }
}
