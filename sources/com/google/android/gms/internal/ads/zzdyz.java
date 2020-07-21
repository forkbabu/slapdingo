package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
class zzdyz implements zzdwt<zzdwp> {
    private static final Logger logger = Logger.getLogger(zzdyz.class.getName());

    zzdyz() {
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    public final Class<zzdwp> zzaxi() {
        return zzdwp.class;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    static class zza implements zzdwp {
        private final zzdwr<zzdwp> zzhrl;
        private final byte[] zzhrw;

        private zza(zzdwr<zzdwp> zzdwr) {
            this.zzhrw = new byte[]{0};
            this.zzhrl = zzdwr;
        }

        @Override // com.google.android.gms.internal.ads.zzdwp
        public final byte[] zzl(byte[] bArr) throws GeneralSecurityException {
            if (this.zzhrl.zzaxr().zzaxu().equals(zzebz.LEGACY)) {
                return zzecp.zza(this.zzhrl.zzaxr().zzaxv(), this.zzhrl.zzaxr().zzaxs().zzl(zzecp.zza(bArr, this.zzhrw)));
            }
            return zzecp.zza(this.zzhrl.zzaxr().zzaxv(), this.zzhrl.zzaxr().zzaxs().zzl(bArr));
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdwr] */
    @Override // com.google.android.gms.internal.ads.zzdwt
    public final /* synthetic */ zzdwp zza(zzdwr<zzdwp> zzdwr) throws GeneralSecurityException {
        return new zza(zzdwr);
    }
}
