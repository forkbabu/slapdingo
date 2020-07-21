package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeds implements zzdwp {
    private final Mac zzhyr;
    private final int zzhys;
    private final String zzhyt;
    private final Key zzhyu;

    public zzeds(String str, Key key, int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        } else if (key.getEncoded().length >= 16) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        String valueOf = String.valueOf(str);
                        throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
                    } else if (i > 64) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                } else if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
            } else if (i > 20) {
                throw new InvalidAlgorithmParameterException("tag size too big");
            }
            this.zzhyt = str;
            this.zzhys = i;
            this.zzhyu = key;
            Mac zzhq = zzedf.zzhyf.zzhq(str);
            this.zzhyr = zzhq;
            zzhq.init(key);
        } else {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwp
    public final byte[] zzl(byte[] bArr) throws GeneralSecurityException {
        Mac mac;
        try {
            mac = (Mac) this.zzhyr.clone();
        } catch (CloneNotSupportedException unused) {
            mac = zzedf.zzhyf.zzhq(this.zzhyt);
            mac.init(this.zzhyu);
        }
        mac.update(bArr);
        byte[] bArr2 = new byte[this.zzhys];
        System.arraycopy(mac.doFinal(), 0, bArr2, 0, this.zzhys);
        return bArr2;
    }
}
