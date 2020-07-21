package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyn implements zzdwf {
    private final zzdwr<zzdwf> zzhrl;

    public zzdyn(zzdwr<zzdwf> zzdwr) {
        this.zzhrl = zzdwr;
    }

    @Override // com.google.android.gms.internal.ads.zzdwf
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzecp.zza(this.zzhrl.zzaxr().zzaxv(), this.zzhrl.zzaxr().zzaxs().zzc(bArr, bArr2));
    }
}
