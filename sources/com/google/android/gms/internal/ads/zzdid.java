package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrv;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdid<RequestComponentT extends zzbrv<AdT>, AdT> implements zzdil<RequestComponentT, AdT> {
    private RequestComponentT zzgxk;

    /* access modifiers changed from: private */
    /* renamed from: zzarw */
    public final synchronized RequestComponentT zzarv() {
        return this.zzgxk;
    }

    @Override // com.google.android.gms.internal.ads.zzdil
    public final synchronized zzdvf<AdT> zza(zzdiq zzdiq, zzdin<RequestComponentT> zzdin) {
        RequestComponentT zzaeg;
        zzaeg = zzdin.zzc(zzdiq.zzgyh).zzaeg();
        this.zzgxk = zzaeg;
        return zzaeg.zzaex().zzaiq();
    }
}
