package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcfl implements zzdrx {
    static final zzdrx zzdvt = new zzcfl();

    private zzcfl() {
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzcfn zzcfn : (List) obj) {
            if (zzcfn != null) {
                arrayList.add(zzcfn);
            }
        }
        return arrayList;
    }
}
