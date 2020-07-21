package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbaj implements Callable<String> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Context zzecd;

    zzbaj(zzbah zzbah, Context context, Context context2) {
        this.zzecd = context;
        this.val$context = context2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzecd != null) {
            zzaxv.zzeh("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzecd.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzaxv.zzeh("Attempting to read user agent from local cache.");
            sharedPreferences = this.val$context.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzaxv.zzeh("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzaxv.zzeh("Persisting user agent.");
            }
        }
        return string;
    }
}
