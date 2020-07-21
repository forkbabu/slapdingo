package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzedu {
    private static final ThreadLocal<SecureRandom> zzhyv = new zzedt();

    /* access modifiers changed from: private */
    public static SecureRandom zzbco() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzfn(int i) {
        byte[] bArr = new byte[i];
        zzhyv.get().nextBytes(bArr);
        return bArr;
    }
}
