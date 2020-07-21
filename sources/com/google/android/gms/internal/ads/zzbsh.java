package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbsh implements zzela<zzavr> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdkk> zzfmg;
    private final zzbsi zzfrn;
    private final zzelj<zzbbd> zzfro;
    private final zzelj<zzavt> zzfrp;

    private zzbsh(zzbsi zzbsi, zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzdkk> zzelj3, zzelj<zzavt> zzelj4) {
        this.zzfrn = zzbsi;
        this.zzere = zzelj;
        this.zzfro = zzelj2;
        this.zzfmg = zzelj3;
        this.zzfrp = zzelj4;
    }

    public static zzbsh zza(zzbsi zzbsi, zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzdkk> zzelj3, zzelj<zzavt> zzelj4) {
        return new zzbsh(zzbsi, zzelj, zzelj2, zzelj3, zzelj4);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        Context context = this.zzere.get();
        zzbbd zzbbd = this.zzfro.get();
        zzdkk zzdkk = this.zzfmg.get();
        zzavt zzavt = this.zzfrp.get();
        if (zzdkk.zzgzv != null) {
            return new zzavi(context, zzbbd, zzdkk.zzgzv, zzdkk.zzgzr.zzdof, zzavt);
        }
        return null;
    }
}
