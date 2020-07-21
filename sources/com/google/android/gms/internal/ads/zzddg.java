package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzddg implements zzduf {
    private final String zzdfg;
    private final zzdde zzgtp;
    private final List zzgtr;
    private final Bundle zzgts;

    zzddg(zzdde zzdde, String str, List list, Bundle bundle) {
        this.zzgtp = zzdde;
        this.zzdfg = str;
        this.zzgtr = list;
        this.zzgts = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzduf
    public final zzdvf zzaqx() {
        return this.zzgtp.zza(this.zzdfg, this.zzgtr, this.zzgts);
    }
}
