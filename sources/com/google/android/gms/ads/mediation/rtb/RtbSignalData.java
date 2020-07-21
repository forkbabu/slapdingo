package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class RtbSignalData {
    private final Bundle zzcgz;
    private final AdSize zzdt;
    private final List<MediationConfiguration> zzeqv;
    private final Context zzvr;

    public RtbSignalData(Context context, List<MediationConfiguration> list, Bundle bundle, AdSize adSize) {
        this.zzvr = context;
        this.zzeqv = list;
        this.zzcgz = bundle;
        this.zzdt = adSize;
    }

    public Context getContext() {
        return this.zzvr;
    }

    @Deprecated
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.zzeqv;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.zzeqv.get(0);
    }

    public List<MediationConfiguration> getConfigurations() {
        return this.zzeqv;
    }

    public Bundle getNetworkExtras() {
        return this.zzcgz;
    }

    public AdSize getAdSize() {
        return this.zzdt;
    }
}
