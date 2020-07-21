package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdxl extends zzdwl<zzedp, zzdzm> {
    zzdxl(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdwl
    public final /* synthetic */ zzedp zzag(zzdzm zzdzm) throws GeneralSecurityException {
        zzdzm zzdzm2 = zzdzm;
        return new zzech(zzdzm2.zzayb().toByteArray(), zzdzm2.zzayq().zzayw());
    }
}
