package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzech implements zzedp {
    private static final ThreadLocal<Cipher> zzhwr = new zzeck();
    private final SecretKeySpec zzhws;
    private final int zzhwt;
    private final int zzhwu;

    public zzech(byte[] bArr, int i) throws GeneralSecurityException {
        zzedv.zzfo(bArr.length);
        this.zzhws = new SecretKeySpec(bArr, "AES");
        int blockSize = zzhwr.get().getBlockSize();
        this.zzhwu = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzhwt = i;
    }

    @Override // com.google.android.gms.internal.ads.zzedp
    public final byte[] zzo(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzhwt;
        if (length <= Integer.MAX_VALUE - i) {
            byte[] bArr2 = new byte[(bArr.length + i)];
            byte[] zzfn = zzedu.zzfn(i);
            System.arraycopy(zzfn, 0, bArr2, 0, this.zzhwt);
            int length2 = bArr.length;
            int i2 = this.zzhwt;
            Cipher cipher = zzhwr.get();
            byte[] bArr3 = new byte[this.zzhwu];
            System.arraycopy(zzfn, 0, bArr3, 0, this.zzhwt);
            cipher.init(1, this.zzhws, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i2) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(Integer.MAX_VALUE - this.zzhwt);
        throw new GeneralSecurityException(sb.toString());
    }
}
