package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctt implements zzela<zzctq> {
    private final zzelj<zzbif> zzfvj;
    private final zzelj<zzbrx.zza> zzfvk;
    private final zzelj<zzbxa> zzfvl;

    public zzctt(zzelj<zzbif> zzelj, zzelj<zzbrx.zza> zzelj2, zzelj<zzbxa> zzelj3) {
        this.zzfvj = zzelj;
        this.zzfvk = zzelj2;
        this.zzfvl = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzctq(this.zzfvj.get(), this.zzfvk.get(), this.zzfvl.get());
    }
}
