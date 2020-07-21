package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzky implements zzkw {
    private final zzpi zzawl;
    private final int zzawt = this.zzawl.zziz();
    private final int zzawu = this.zzawl.zziz();

    public zzky(zzkv zzkv) {
        zzpi zzpi = zzkv.zzawl;
        this.zzawl = zzpi;
        zzpi.zzbk(12);
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final int zzgw() {
        return this.zzawu;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final int zzgx() {
        int i = this.zzawt;
        return i == 0 ? this.zzawl.zziz() : i;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final boolean zzgy() {
        return this.zzawt != 0;
    }
}
