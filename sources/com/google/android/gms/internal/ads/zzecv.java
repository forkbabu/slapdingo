package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzecv implements zzdwg {
    private static final byte[] zzhrd = new byte[0];
    private final ECPrivateKey zzhxj;
    private final zzecx zzhxk;
    private final String zzhxl;
    private final byte[] zzhxm;
    private final zzedd zzhxn;
    private final zzecw zzhxo;

    public zzecv(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzedd zzedd, zzecw zzecw) throws GeneralSecurityException {
        this.zzhxj = eCPrivateKey;
        this.zzhxk = new zzecx(eCPrivateKey);
        this.zzhxm = bArr;
        this.zzhxl = str;
        this.zzhxn = zzedd;
        this.zzhxo = zzecw;
    }
}
