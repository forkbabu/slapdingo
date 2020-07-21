package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbs implements zzddz<Bundle> {
    private final String zzdqj;
    private final boolean zzdql;

    public zzdbs(String str, boolean z) {
        this.zzdqj = str;
        this.zzdql = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("gct", this.zzdqj);
        if (this.zzdql) {
            bundle2.putString("de", "1");
        }
    }
}
