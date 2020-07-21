package com.google.android.gms.internal.ads;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzayr extends zzays {
    @Override // com.google.android.gms.internal.ads.zzayj
    public final zzui zza(Context context, TelephonyManager telephonyManager) {
        zzq.zzkw();
        if (zzaye.zzr(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzui.ENUM_TRUE : zzui.ENUM_FALSE;
        }
        return zzui.ENUM_FALSE;
    }
}
