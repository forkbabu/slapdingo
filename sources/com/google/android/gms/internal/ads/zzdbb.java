package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbb implements zzddz<Bundle> {
    @Nullable
    private final Location zznb;

    public zzdbb(@Nullable Location location) {
        this.zznb = location;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.zznb != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", this.zznb.getAccuracy() * 1000.0f);
            bundle3.putLong("lat", (long) (this.zznb.getLatitude() * 1.0E7d));
            bundle3.putLong("long", (long) (this.zznb.getLongitude() * 1.0E7d));
            bundle3.putLong("time", this.zznb.getTime() * 1000);
            bundle2.putBundle("uule", bundle3);
        }
    }
}
