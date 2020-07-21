package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbss extends zzbwv<zzbsp> implements zzbsp {
    public zzbss(zzbsw zzbsw, Set<zzbyg<zzbsp>> set, Executor executor) {
        super(set);
        zza(zzbsw, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzc(zzuy zzuy) {
        zza(new zzbsr(zzuy));
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zza(zzcap zzcap) {
        zza(new zzbsu(zzcap));
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzaja() {
        zza(zzbst.zzfrq);
    }
}
