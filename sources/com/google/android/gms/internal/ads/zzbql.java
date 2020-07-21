package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbql implements zzela<zzaxg> {
    private final zzelj<zzaxs> zzexn;
    private final zzelj<Clock> zzfmf;
    private final zzelj<zzdla> zzfnz;

    private zzbql(zzelj<Clock> zzelj, zzelj<zzaxs> zzelj2, zzelj<zzdla> zzelj3) {
        this.zzfmf = zzelj;
        this.zzexn = zzelj2;
        this.zzfnz = zzelj3;
    }

    public static zzbql zzg(zzelj<Clock> zzelj, zzelj<zzaxs> zzelj2, zzelj<zzdla> zzelj3) {
        return new zzbql(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzaxg) zzelg.zza(this.zzexn.get().zza(this.zzfmf.get(), this.zzfnz.get().zzhaz), "Cannot return null from a non-@Nullable @Provides method");
    }
}
