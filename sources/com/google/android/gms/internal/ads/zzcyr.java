package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcyr implements zzela<zzdvf<zzcyv>> {
    private final zzelj<zzdou> zzfoc;
    private final zzelj<zzcyu> zzgrc;
    private final zzelj<zzbrq> zzgrd;

    public zzcyr(zzelj<zzdou> zzelj, zzelj<zzcyu> zzelj2, zzelj<zzbrq> zzelj3) {
        this.zzfoc = zzelj;
        this.zzgrc = zzelj2;
        this.zzgrd = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzdvf) zzelg.zza(this.zzfoc.get().zza(zzdor.GENERATE_SIGNALS, this.zzgrd.get().zzait()).zza(this.zzgrc.get()).zza((long) ((Integer) zzwg.zzpw().zzd(zzaav.zzcug)).intValue(), TimeUnit.SECONDS).zzaus(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
