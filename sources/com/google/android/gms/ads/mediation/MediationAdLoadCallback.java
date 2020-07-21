package com.google.android.gms.ads.mediation;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface MediationAdLoadCallback<MediationAdT, MediationAdCallbackT> {
    void onFailure(String str);

    MediationAdCallbackT onSuccess(MediationAdT mediationadt);
}
