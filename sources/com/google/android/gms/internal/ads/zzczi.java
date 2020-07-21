package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzczi implements zzddz {
    private final String zzdfo;

    zzczi(String str) {
        this.zzdfo = str;
    }

    @Override // com.google.android.gms.internal.ads.zzddz
    public final void zzs(Object obj) {
        ((Bundle) obj).putString("ms", this.zzdfo);
    }
}
