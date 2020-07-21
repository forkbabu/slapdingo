package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzagl implements zzahc<Object> {
    private final zzagk zzddj;

    public zzagl(zzagk zzagk) {
        this.zzddj = zzagk;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (str == null) {
            zzaxv.zzfd("App event with no name parameter.");
        } else {
            this.zzddj.onAppEvent(str, map.get("info"));
        }
    }
}
