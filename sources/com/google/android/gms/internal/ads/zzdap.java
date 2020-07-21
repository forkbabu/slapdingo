package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdap implements zzddz<Bundle> {
    private final double zzdtp;
    private final boolean zzdtq;

    public zzdap(double d, boolean z) {
        this.zzdtp = d;
        this.zzdtq = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdlf.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        Bundle zza2 = zzdlf.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdtq);
        zza2.putDouble("battery_level", this.zzdtp);
    }
}
