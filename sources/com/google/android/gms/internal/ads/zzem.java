package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzem implements zzer {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzyl;

    zzem(zzej zzej, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzyl = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzer
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzyl);
    }
}
