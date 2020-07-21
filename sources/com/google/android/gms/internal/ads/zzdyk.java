package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzdyk implements zzdwt<zzdwg> {
    private static final Logger logger = Logger.getLogger(zzdyk.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static class zza implements zzdwg {
        private final zzdwr<zzdwg> zzhrl;

        public zza(zzdwr<zzdwg> zzdwr) {
            this.zzhrl = zzdwr;
        }
    }

    zzdyk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    public final Class<zzdwg> zzaxi() {
        return zzdwg.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdwr] */
    @Override // com.google.android.gms.internal.ads.zzdwt
    public final /* synthetic */ zzdwg zza(zzdwr<zzdwg> zzdwr) throws GeneralSecurityException {
        return new zza(zzdwr);
    }
}
