package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzedg implements zzdwc {
    private final zzedp zzhyo;
    private final zzdwp zzhyp;
    private final int zzhyq;

    public zzedg(zzedp zzedp, zzdwp zzdwp, int i) {
        this.zzhyo = zzedp;
        this.zzhyp = zzdwp;
        this.zzhyq = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdwc
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzo = this.zzhyo.zzo(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzecp.zza(zzo, this.zzhyp.zzl(zzecp.zza(bArr2, zzo, copyOf)));
    }
}
