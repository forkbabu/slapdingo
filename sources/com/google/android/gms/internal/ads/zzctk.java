package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctk implements zzela<zzctl> {
    private final zzelj<zzbif> zzfvj;
    private final zzelj<zzbrx.zza> zzfvk;
    private final zzelj<zzbxa> zzfvl;
    private final zzelj<zzcay> zzfvm;

    public zzctk(zzelj<zzbif> zzelj, zzelj<zzcay> zzelj2, zzelj<zzbrx.zza> zzelj3, zzelj<zzbxa> zzelj4) {
        this.zzfvj = zzelj;
        this.zzfvm = zzelj2;
        this.zzfvk = zzelj3;
        this.zzfvl = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzctl(this.zzfvj.get(), this.zzfvm.get(), this.zzfvk.get(), this.zzfvl.get());
    }
}
