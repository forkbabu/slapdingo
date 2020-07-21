package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdna {
    private HashMap<zzdmr, zzdmz<? extends zzbpb>> zzheh = new HashMap<>();

    public final <AdT extends zzbpb> zzdmz<AdT> zza(zzdmr zzdmr, Context context, zzdmi zzdmi, zzdnh<AdT> zzdnh) {
        zzdmz<AdT> zzdmz = this.zzheh.get(zzdmr);
        if (zzdmz != null) {
            return zzdmz;
        }
        zzdmo zzdmo = new zzdmo(zzdms.zza(zzdmr, context));
        zzdmz<AdT> zzdmz2 = new zzdmz<>(zzdmo, new zzdne(zzdmo, zzdmi, zzdnh));
        this.zzheh.put(zzdmr, zzdmz2);
        return zzdmz2;
    }
}
