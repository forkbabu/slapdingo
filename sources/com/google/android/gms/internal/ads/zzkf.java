package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzkf implements zzkc {
    private final long zzaih;

    public zzkf(long j) {
        this.zzaih = j;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final boolean isSeekable() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final long zzdz(long j) {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final long getDurationUs() {
        return this.zzaih;
    }
}
