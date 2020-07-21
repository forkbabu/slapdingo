package com.google.android.gms.internal.vision;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final /* synthetic */ class zzbr implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzbo zzhn;

    zzbr(zzbo zzbo) {
        this.zzhn = zzbo;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zzhn.zza(sharedPreferences, str);
    }
}
