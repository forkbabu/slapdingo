package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzduj<V> extends zzdug<V, List<V>> {
    zzduj(zzdsr<? extends zzdvf<? extends V>> zzdsr, boolean z) {
        super(zzdsr, true);
        zzaww();
    }

    @Override // com.google.android.gms.internal.ads.zzdug
    public final /* synthetic */ Object zzj(List list) {
        ArrayList zzeo = zzdta.zzeo(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzdui zzdui = (zzdui) it2.next();
            zzeo.add(zzdui != null ? zzdui.value : null);
        }
        return Collections.unmodifiableList(zzeo);
    }
}
