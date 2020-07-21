package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcfb implements zzdrx {
    static final zzdrx zzdvt = new zzcfb();

    private zzcfb() {
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzadf zzadf : (List) obj) {
            if (zzadf != null) {
                arrayList.add(zzadf);
            }
        }
        return arrayList;
    }
}
