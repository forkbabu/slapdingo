package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdip implements zzela<zzdil<zzbmq, zzbmw>> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdmi> zzetf;
    private final zzelj<zzdna> zzetg;

    public zzdip(zzelj<Context> zzelj, zzelj<zzdmi> zzelj2, zzelj<zzdna> zzelj3) {
        this.zzere = zzelj;
        this.zzetf = zzelj2;
        this.zzetg = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        Object obj;
        Context context = this.zzere.get();
        zzdmi zzdmi = this.zzetf.get();
        zzdna zzdna = this.zzetg.get();
        if (((Integer) zzwg.zzpw().zzd(zzaav.zzcwk)).intValue() > 0) {
            zzdmz zza = zzdna.zza(zzdmr.AppOpen, context, zzdmi, new zzdht(new zzdho()));
            obj = new zzdhp(new zzdig(new zzdid()), new zzdhy(zza.zzgxz, zzbbf.zzedh), zza.zzheg, zzbbf.zzedh);
        } else {
            obj = new zzdid();
        }
        return (zzdil) zzelg.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
