package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzrb implements zzrd {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzyl;

    zzrb(zzqv zzqv, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzyl = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzrd
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzyl);
    }
}
