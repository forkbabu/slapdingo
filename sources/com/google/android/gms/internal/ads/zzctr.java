package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctr implements zzela<zzcto> {
    private final zzelj<zzbif> zzfvj;
    private final zzelj<zzbrx.zza> zzfvk;
    private final zzelj<zzbxa> zzfvl;
    private final zzelj<zzcvw> zzgmf;

    public zzctr(zzelj<zzbif> zzelj, zzelj<zzbrx.zza> zzelj2, zzelj<zzcvw> zzelj3, zzelj<zzbxa> zzelj4) {
        this.zzfvj = zzelj;
        this.zzfvk = zzelj2;
        this.zzgmf = zzelj3;
        this.zzfvl = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcto(this.zzfvj.get(), this.zzfvk.get(), this.zzgmf.get(), this.zzfvl.get());
    }
}
