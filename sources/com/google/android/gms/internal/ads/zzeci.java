package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeci implements zzdwp {
    private final SecretKey zzhwv;
    private final int zzhww;
    private byte[] zzhwx;
    private byte[] zzhwy;

    private static Cipher zzbcj() throws GeneralSecurityException {
        return zzedf.zzhye.zzhq("AES/ECB/NoPadding");
    }

    public zzeci(byte[] bArr, int i) throws GeneralSecurityException {
        zzedv.zzfo(bArr.length);
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, min is 10 bytes");
        } else if (i <= 16) {
            this.zzhwv = new SecretKeySpec(bArr, "AES");
            this.zzhww = i;
            Cipher zzbcj = zzbcj();
            zzbcj.init(1, this.zzhwv);
            byte[] zzq = zzecq.zzq(zzbcj.doFinal(new byte[16]));
            this.zzhwx = zzq;
            this.zzhwy = zzecq.zzq(zzq);
        } else {
            throw new InvalidAlgorithmParameterException("tag size too large, max is 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwp
    public final byte[] zzl(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        Cipher zzbcj = zzbcj();
        zzbcj.init(1, this.zzhwv);
        int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
        if ((max << 4) == bArr.length) {
            bArr2 = zzecp.zza(bArr, (max - 1) << 4, this.zzhwx, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length < 16) {
                byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                copyOf[copyOfRange.length] = ByteCompanionObject.MIN_VALUE;
                bArr2 = zzecp.zzd(copyOf, this.zzhwy);
            } else {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
        }
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < max - 1; i++) {
            bArr3 = zzbcj.doFinal(zzecp.zza(bArr3, 0, bArr, i << 4, 16));
        }
        byte[] zzd = zzecp.zzd(bArr2, bArr3);
        byte[] bArr4 = new byte[this.zzhww];
        System.arraycopy(zzbcj.doFinal(zzd), 0, bArr4, 0, this.zzhww);
        return bArr4;
    }
}
