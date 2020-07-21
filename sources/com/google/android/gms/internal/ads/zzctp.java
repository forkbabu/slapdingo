package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbrx;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctp implements zzela<zzctm> {
    private final zzelj<zzbus> zzfqt;
    private final zzelj<zzbif> zzfvj;
    private final zzelj<zzbrx.zza> zzfvk;
    private final zzelj<zzbxa> zzfvl;
    private final zzelj<zzcay> zzfvm;
    private final zzelj<zzcvw> zzgmf;
    private final zzelj<ViewGroup> zzgmg;

    public zzctp(zzelj<zzbif> zzelj, zzelj<zzbrx.zza> zzelj2, zzelj<zzcvw> zzelj3, zzelj<zzbxa> zzelj4, zzelj<zzcay> zzelj5, zzelj<zzbus> zzelj6, zzelj<ViewGroup> zzelj7) {
        this.zzfvj = zzelj;
        this.zzfvk = zzelj2;
        this.zzgmf = zzelj3;
        this.zzfvl = zzelj4;
        this.zzfvm = zzelj5;
        this.zzfqt = zzelj6;
        this.zzgmg = zzelj7;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzctm(this.zzfvj.get(), this.zzfvk.get(), this.zzgmf.get(), this.zzfvl.get(), this.zzfvm.get(), this.zzfqt.get(), this.zzgmg.get());
    }
}
