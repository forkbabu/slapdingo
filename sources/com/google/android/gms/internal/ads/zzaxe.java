package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzaxe implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbbn zzdwy;

    zzaxe(zzaxb zzaxb, Context context, zzbbn zzbbn) {
        this.val$context = context;
        this.zzdwy = zzbbn;
    }

    public final void run() {
        try {
            this.zzdwy.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzdwy.setException(e);
            zzbba.zzc("Exception while getting advertising Id info", e);
        }
    }
}
