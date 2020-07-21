package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzty;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcje implements zzela<zztm> {
    private final zzelj<Context> zzere;
    private final zzelj<zzty.zza.C0018zza> zzfmi;
    private final zzelj<String> zzfqz;
    private final zzelj<zzbbd> zzfro;
    private final zzelj<String> zzgdh;

    private zzcje(zzelj<Context> zzelj, zzelj<String> zzelj2, zzelj<zzbbd> zzelj3, zzelj<zzty.zza.C0018zza> zzelj4, zzelj<String> zzelj5) {
        this.zzere = zzelj;
        this.zzfqz = zzelj2;
        this.zzfro = zzelj3;
        this.zzfmi = zzelj4;
        this.zzgdh = zzelj5;
    }

    public static zzcje zze(zzelj<Context> zzelj, zzelj<String> zzelj2, zzelj<zzbbd> zzelj3, zzelj<zzty.zza.C0018zza> zzelj4, zzelj<String> zzelj5) {
        return new zzcje(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        String str = this.zzfqz.get();
        zzbbd zzbbd = this.zzfro.get();
        zzty.zza.C0018zza zza = this.zzfmi.get();
        String str2 = this.zzgdh.get();
        zztm zztm = new zztm(new zztr(this.zzere.get()));
        zztm.zza(new zzcjf(zza, str, (zzty.zzu) ((zzegb) zzty.zzu.zzos().zzcs(zzbbd.zzedd).zzct(zzbbd.zzede).zzcu(zzbbd.zzedf ? 0 : 2).zzbfq()), str2));
        return (zztm) zzelg.zza(zztm, "Cannot return null from a non-@Nullable @Provides method");
    }
}
