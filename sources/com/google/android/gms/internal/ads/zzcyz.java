package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcyz implements zzela<zzcyx> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<ViewGroup> zzgmg;
    private final zzelj<zzdvi> zzgrl;

    public zzcyz(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2, zzelj<zzdla> zzelj3, zzelj<ViewGroup> zzelj4) {
        this.zzgrl = zzelj;
        this.zzere = zzelj2;
        this.zzfnz = zzelj3;
        this.zzgmg = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcyx(this.zzgrl.get(), this.zzere.get(), this.zzfnz.get(), this.zzgmg.get());
    }
}
