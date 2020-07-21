package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzczo implements zzdec<zzddz<Bundle>> {
    private final Set<String> zzgrw;

    zzczo(Set<String> set) {
        this.zzgrw = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddz<Bundle>> zzaqm() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzgrw) {
            arrayList.add(str);
        }
        return zzdux.zzaf(new zzczn(arrayList));
    }
}
