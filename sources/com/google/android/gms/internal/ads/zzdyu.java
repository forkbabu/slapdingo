package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyu extends zzdwl<zzdwp, zzdzd> {
    zzdyu(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdwl
    public final /* synthetic */ zzdwp zzag(zzdzd zzdzd) throws GeneralSecurityException {
        zzdzd zzdzd2 = zzdzd;
        return new zzeci(zzdzd2.zzayb().toByteArray(), zzdzd2.zzayc().zzayg());
    }
}
