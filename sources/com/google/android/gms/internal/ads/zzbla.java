package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbla implements zzduh<zzdkw, zzdkw> {
    private Map<String, zzbld> zzfkj;

    public zzbla(Map<String, zzbld> map) {
        this.zzfkj = map;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdvf' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduh
    public final /* synthetic */ zzdvf<zzdkw> zzf(zzdkw zzdkw) throws Exception {
        zzdkw zzdkw2 = zzdkw;
        for (zzdkt zzdkt : zzdkw2.zzhau.zzhas) {
            if (this.zzfkj.containsKey(zzdkt.name)) {
                this.zzfkj.get(zzdkt.name).zzl(zzdkt.zzhap);
            }
        }
        return zzdux.zzaf(zzdkw2);
    }
}
