package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class CustomEventServerParameters extends MediationServerParameters {
    @MediationServerParameters.Parameter(name = "class_name", required = true)
    public String className;
    @MediationServerParameters.Parameter(name = "label", required = true)
    public String label;
    @MediationServerParameters.Parameter(name = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, required = false)
    public String parameter = null;
}
