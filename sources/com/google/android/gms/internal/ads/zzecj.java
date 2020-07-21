package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzecj implements zzdwc {
    private static final ThreadLocal<Cipher> zzhwz = new zzecm();
    private static final ThreadLocal<Cipher> zzhxa = new zzecl();
    private final SecretKeySpec zzhws;
    private final byte[] zzhxb;
    private final byte[] zzhxc;
    private final int zzhxd;

    public zzecj(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.zzhxd = i;
            zzedv.zzfo(bArr.length);
            this.zzhws = new SecretKeySpec(bArr, "AES");
            Cipher cipher = zzhwz.get();
            cipher.init(1, this.zzhws);
            byte[] zzp = zzp(cipher.doFinal(new byte[16]));
            this.zzhxb = zzp;
            this.zzhxc = zzp(zzp);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] zzp(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & UByte.MAX_VALUE) >>> 7));
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & ByteCompanionObject.MIN_VALUE) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzhxb));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzhxb);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzhxc, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ ByteCompanionObject.MIN_VALUE);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    @Override // com.google.android.gms.internal.ads.zzdwc
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzhxd;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr3 = new byte[(bArr.length + i + 16)];
            byte[] zzfn = zzedu.zzfn(i);
            System.arraycopy(zzfn, 0, bArr3, 0, this.zzhxd);
            Cipher cipher = zzhwz.get();
            cipher.init(1, this.zzhws);
            byte[] zza = zza(cipher, 0, zzfn, 0, zzfn.length);
            byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
            byte[] zza2 = zza(cipher, 1, bArr4, 0, bArr4.length);
            Cipher cipher2 = zzhxa.get();
            cipher2.init(1, this.zzhws, new IvParameterSpec(zza));
            cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.zzhxd);
            byte[] zza3 = zza(cipher, 2, bArr3, this.zzhxd, bArr.length);
            int length2 = bArr.length + this.zzhxd;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[length2 + i2] = (byte) ((zza2[i2] ^ zza[i2]) ^ zza3[i2]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
