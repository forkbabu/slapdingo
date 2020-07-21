package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbw implements zzddz<Bundle> {
    private final Bundle zzdqi;

    public zzdbw(Bundle bundle) {
        this.zzdqi = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdlf.zza(bundle2, "device");
        zza.putBundle("android_mem_info", this.zzdqi);
        bundle2.putBundle("device", zza);
    }
}
