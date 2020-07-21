package com.google.android.gms.internal.ads;

import android.os.Build;
import com.itextpdf.text.DocWriter;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdpk {
    private static final byte[] zzhhn = {DocWriter.EQUALS, 122, 18, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, 63, 50, 108, -113, -103, 74};
    private static final byte[] zzhho = {16, 57, 56, -18, 69, 55, -27, -98, -114, -25, -110, -10, 84, 80, 79, -72, 52, 111, -58, -77, 70, -48, -69, -60, 65, 95, -61, 57, -4, -4, -114, -63};
    private final byte[] zzhhl = zzhho;
    private final byte[] zzhhm = zzhhn;

    public final boolean zzb(File file) throws GeneralSecurityException {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(zzgz(file.getAbsolutePath()).getEncoded());
        if (!Arrays.equals(this.zzhhm, digest)) {
            return !"user".equals(Build.TYPE) && Arrays.equals(this.zzhhl, digest);
        }
        return true;
    }

    private static X509Certificate zzgz(String str) throws GeneralSecurityException {
        try {
            X509Certificate[][] zza = zzb.zza(str);
            if (zza.length == 1) {
                return zza[0][0];
            }
            throw new GeneralSecurityException("APK has more than one signature.");
        } catch (zzh e) {
            throw new GeneralSecurityException("Package is not signed", e);
        } catch (IOException | RuntimeException e2) {
            throw new GeneralSecurityException("Failed to verify signatures", e2);
        }
    }
}
