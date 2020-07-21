package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzayt implements View.OnApplyWindowInsetsListener {
    private final zzayu zzead;
    private final Activity zzeae;

    zzayt(zzayu zzayu, Activity activity) {
        this.zzead = zzayu;
        this.zzeae = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzayu.zza(this.zzeae, view, windowInsets);
    }
}
