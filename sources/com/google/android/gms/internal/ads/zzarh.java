package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzarh {
    /* access modifiers changed from: private */
    @Nonnull
    public View zzaas;
    /* access modifiers changed from: private */
    public final Map<String, WeakReference<View>> zzdow = new HashMap();

    public final zzarh zzk(View view) {
        this.zzaas = view;
        return this;
    }

    public final zzarh zzh(Map<String, View> map) {
        this.zzdow.clear();
        for (Map.Entry<String, View> entry : map.entrySet()) {
            View value = entry.getValue();
            if (value != null) {
                this.zzdow.put(entry.getKey(), new WeakReference<>(value));
            }
        }
        return this;
    }
}
