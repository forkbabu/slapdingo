package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzro {
    private static MessageDigest zzbtr;
    protected Object mLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract byte[] zzbs(String str);

    /* access modifiers changed from: protected */
    public final MessageDigest zzmm() {
        synchronized (this.mLock) {
            if (zzbtr != null) {
                MessageDigest messageDigest = zzbtr;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbtr = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = zzbtr;
            return messageDigest2;
        }
    }
}
