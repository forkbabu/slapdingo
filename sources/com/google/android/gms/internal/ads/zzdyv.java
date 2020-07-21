package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyv extends zzdwl<zzdwp, zzeax> {
    zzdyv(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdwl
    public final /* synthetic */ zzdwp zzag(zzeax zzeax) throws GeneralSecurityException {
        zzeax zzeax2 = zzeax;
        zzeav zzbao = zzeax2.zzbai().zzbao();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzeax2.zzayb().toByteArray(), "HMAC");
        int zzayg = zzeax2.zzbai().zzayg();
        int i = zzdyx.zzhrm[zzbao.ordinal()];
        if (i == 1) {
            return new zzeds("HMACSHA1", secretKeySpec, zzayg);
        }
        if (i == 2) {
            return new zzeds("HMACSHA256", secretKeySpec, zzayg);
        }
        if (i == 3) {
            return new zzeds("HMACSHA512", secretKeySpec, zzayg);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
