package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzty;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcax implements zzela<zzcau> {
    private final zzelj<Context> zzere;
    private final zzelj<zzavy> zzfkb;
    private final zzelj<View> zzfky;
    private final zzelj<zzty.zza.C0018zza> zzfmi;
    private final zzelj<zzavv> zzfoy;

    private zzcax(zzelj<zzavv> zzelj, zzelj<Context> zzelj2, zzelj<zzavy> zzelj3, zzelj<View> zzelj4, zzelj<zzty.zza.C0018zza> zzelj5) {
        this.zzfoy = zzelj;
        this.zzere = zzelj2;
        this.zzfkb = zzelj3;
        this.zzfky = zzelj4;
        this.zzfmi = zzelj5;
    }

    public static zzcax zzd(zzelj<zzavv> zzelj, zzelj<Context> zzelj2, zzelj<zzavy> zzelj3, zzelj<View> zzelj4, zzelj<zzty.zza.C0018zza> zzelj5) {
        return new zzcax(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcau(this.zzfoy.get(), this.zzere.get(), this.zzfkb.get(), this.zzfky.get(), this.zzfmi.get());
    }
}
