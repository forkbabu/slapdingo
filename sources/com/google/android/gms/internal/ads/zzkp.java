package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzkp implements zzkk {
    private final /* synthetic */ zzkn zzasj;

    private zzkp(zzkn zzkn) {
        this.zzasj = zzkn;
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final int zzam(int i) {
        return zzkn.zzam(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final boolean zzan(int i) {
        return zzkn.zzan(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzd(int i, long j, long j2) throws zzht {
        this.zzasj.zzd(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzao(int i) throws zzht {
        this.zzasj.zzao(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzc(int i, long j) throws zzht {
        this.zzasj.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zza(int i, double d) throws zzht {
        this.zzasj.zza(i, d);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zza(int i, String str) throws zzht {
        this.zzasj.zza(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zza(int i, int i2, zzjw zzjw) throws IOException, InterruptedException {
        this.zzasj.zza(i, i2, zzjw);
    }

    /* synthetic */ zzkp(zzkn zzkn, zzkm zzkm) {
        this(zzkn);
    }
}
