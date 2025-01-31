package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.4 */
final class zzd implements AppMeasurementSdk.OnEventListener {
    private final /* synthetic */ zze zza;

    public zzd(zze zze) {
        this.zza = zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzb.zze(str2));
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
