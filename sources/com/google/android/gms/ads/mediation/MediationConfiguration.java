package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class MediationConfiguration {
    private final Bundle zzepn;
    private final AdFormat zzepr;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.zzepr = adFormat;
        this.zzepn = bundle;
    }

    public AdFormat getFormat() {
        return this.zzepr;
    }

    public Bundle getServerParameters() {
        return this.zzepn;
    }
}
