package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzecy implements zzdwf {
    private static final byte[] zzhrd = new byte[0];
    private final String zzhxl;
    private final byte[] zzhxm;
    private final zzedd zzhxn;
    private final zzecw zzhxo;
    private final zzeda zzhxp;

    public zzecy(ECPublicKey eCPublicKey, byte[] bArr, String str, zzedd zzedd, zzecw zzecw) throws GeneralSecurityException {
        zzedc.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzhxp = new zzeda(eCPublicKey);
        this.zzhxm = bArr;
        this.zzhxl = str;
        this.zzhxn = zzedd;
        this.zzhxo = zzecw;
    }

    @Override // com.google.android.gms.internal.ads.zzdwf
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzecz zza = this.zzhxp.zza(this.zzhxl, this.zzhxm, bArr2, this.zzhxo.zzaya(), this.zzhxn);
        byte[] zzc = this.zzhxo.zzn(zza.zzbcn()).zzc(bArr, zzhrd);
        byte[] zzbcm = zza.zzbcm();
        return ByteBuffer.allocate(zzbcm.length + zzc.length).put(zzbcm).put(zzc).array();
    }
}
