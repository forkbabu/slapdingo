package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdld {
    public static zzdkj zza(List<zzdkj> list, zzdkj zzdkj) {
        return list.get(0);
    }

    public static zzvh zzb(Context context, List<zzdkj> list) {
        ArrayList arrayList = new ArrayList();
        for (zzdkj zzdkj : list) {
            if (zzdkj.zzgzj) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzdkj.width, zzdkj.height));
            }
        }
        return new zzvh(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzdkj zze(zzvh zzvh) {
        if (zzvh.zzchk) {
            return new zzdkj(-3, 0, true);
        }
        return new zzdkj(zzvh.width, zzvh.height, false);
    }
}
