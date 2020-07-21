package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxv implements zzela<zzcts> {
    private final zzelj<zzctu> zzeyy;
    private final zzelj<Clock> zzfmf;
    private final zzbxa zzftd;

    private zzbxv(zzbxa zzbxa, zzelj<Clock> zzelj, zzelj<zzctu> zzelj2) {
        this.zzftd = zzbxa;
        this.zzfmf = zzelj;
        this.zzeyy = zzelj2;
    }

    public static zzbxv zza(zzbxa zzbxa, zzelj<Clock> zzelj, zzelj<zzctu> zzelj2) {
        return new zzbxv(zzbxa, zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzcts) zzelg.zza(this.zzftd.zza(this.zzfmf.get(), this.zzeyy.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
