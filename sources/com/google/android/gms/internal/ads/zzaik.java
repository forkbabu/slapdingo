package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaik implements AdapterStatus {
    private final String description;
    private final int zzdet;
    private final AdapterStatus.State zzdeu;

    public zzaik(AdapterStatus.State state, String str, int i) {
        this.zzdeu = state;
        this.description = str;
        this.zzdet = i;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final AdapterStatus.State getInitializationState() {
        return this.zzdeu;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return this.description;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final int getLatency() {
        return this.zzdet;
    }
}
