package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbwj extends zzbwv<AppEventListener> implements zzagk {
    public zzbwj(Set<zzbyg<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzagk
    public final synchronized void onAppEvent(String str, String str2) {
        zza(new zzbwm(str, str2));
    }
}
