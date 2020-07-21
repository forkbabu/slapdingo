package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzaye;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzn {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzdoj == 4 && adOverlayInfoParcel.zzdoe == null) {
            if (adOverlayInfoParcel.zzcgl != null) {
                adOverlayInfoParcel.zzcgl.onAdClicked();
            }
            zzq.zzku();
            zzb.zza(context, adOverlayInfoParcel.zzdod, adOverlayInfoParcel.zzdoi);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzboy.zzedf);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzq.zzkw();
        zzaye.zza(context, intent);
    }
}
