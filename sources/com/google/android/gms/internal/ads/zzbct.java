package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbct extends zzbcl {
    @Override // com.google.android.gms.internal.ads.zzbcl
    public final zzbcm zza(Context context, zzbdb zzbdb, int i, boolean z, zzabi zzabi, zzbdc zzbdc) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        zzbde zzbde = new zzbde(context, zzbdb.zzzo(), zzbdb.getRequestId(), zzabi, zzbdb.zzzk());
        if (i == 2) {
            return new zzbdi(context, zzbde, zzbdb, z, zza(zzbdb), zzbdc);
        }
        return new zzbbz(context, z, zza(zzbdb), zzbdc, new zzbde(context, zzbdb.zzzo(), zzbdb.getRequestId(), zzabi, zzbdb.zzzk()));
    }
}
