package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbph {
    public final List<? extends zzdvf<? extends zzbpb>> zzfpg;

    public zzbph(List<? extends zzdvf<? extends zzbpb>> list) {
        this.zzfpg = list;
    }

    public zzbph(zzbpb zzbpb) {
        this.zzfpg = Collections.singletonList(zzdux.zzaf(zzbpb));
    }

    public static zzcqt<zzbph> zza(zzcsu<? extends zzbpb> zzcsu) {
        return new zzcqs(zzcsu, zzbpg.zzdvt);
    }

    public static zzcqt<zzbph> zza(zzcqt<? extends zzbpb> zzcqt) {
        return new zzcqs(zzcqt, zzbpj.zzdvt);
    }
}
