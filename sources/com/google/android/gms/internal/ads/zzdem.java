package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdem implements zzdec<zzdej> {
    private final zzdvi zzgad;
    private final Context zzvr;

    public zzdem(zzdvi zzdvi, Context context) {
        this.zzgad = zzdvi;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzdej> zzaqm() {
        return this.zzgad.zze(new zzdel(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdej zzare() throws Exception {
        int i;
        boolean z;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzvr.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        zzq.zzkw();
        int i4 = -1;
        if (zzaye.zzr(this.zzvr, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzvr.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                i4 = activeNetworkInfo.getType();
                i3 = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                i3 = -1;
            }
            z = connectivityManager.isActiveNetworkMetered();
            i = i3;
            i2 = i4;
        } else {
            i2 = -2;
            z = false;
            i = -1;
        }
        return new zzdej(networkOperator, i2, networkType, phoneType, z, i);
    }
}
