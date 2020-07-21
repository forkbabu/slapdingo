package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzaxw extends zzaxr {
    private Context zzvr;

    zzaxw(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxr
    public final void zzut() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zzvr);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzaxv.zzc("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        zzbau.zzar(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzaxv.zzfd(sb.toString());
    }
}
