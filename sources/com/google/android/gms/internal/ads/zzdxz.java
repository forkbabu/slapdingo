package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdxz implements zzdwc {
    private static final byte[] zzhrd = new byte[0];
    private final zzebi zzhre;
    private final zzdwc zzhrf;

    public zzdxz(zzebi zzebi, zzdwc zzdwc) {
        this.zzhre = zzebi;
        this.zzhrf = zzdwc;
    }

    @Override // com.google.android.gms.internal.ads.zzdwc
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = zzdwy.zzb(this.zzhre).toByteArray();
        byte[] zzc = this.zzhrf.zzc(byteArray, zzhrd);
        byte[] zzc2 = ((zzdwc) zzdwy.zza(this.zzhre.zzbar(), byteArray, zzdwc.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
