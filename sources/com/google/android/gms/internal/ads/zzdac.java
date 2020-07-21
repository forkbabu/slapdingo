package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdac implements zzddz {
    private final ArrayList zzgrv;

    zzdac(ArrayList arrayList) {
        this.zzgrv = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzddz
    public final void zzs(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zzgrv);
    }
}
