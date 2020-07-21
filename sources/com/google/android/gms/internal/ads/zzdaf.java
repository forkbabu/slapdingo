package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdaf implements zzddz<Bundle> {
    private final boolean zzgsg = false;
    private final boolean zzgsh = false;
    private final boolean zzgsi;

    public zzdaf(boolean z, boolean z2, boolean z3) {
        this.zzgsi = z3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("c_pcbg", this.zzgsg);
        bundle2.putBoolean("c_phbg", this.zzgsh);
        bundle2.putBoolean("ar_lr", this.zzgsi);
    }
}
