package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import com.google.android.gms.internal.ads.zzebn;
import java.security.GeneralSecurityException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdws {
    @Deprecated
    public static final zzdwo zzm(byte[] bArr) throws GeneralSecurityException {
        try {
            zzebn zzc = zzebn.zzc(bArr, zzefo.zzbeq());
            for (zzebn.zzb zzb : zzc.zzbbf()) {
                if (zzb.zzbbj().zzbat() == zzebf.zza.UNKNOWN_KEYMATERIAL || zzb.zzbbj().zzbat() == zzebf.zza.SYMMETRIC || zzb.zzbbj().zzbat() == zzebf.zza.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzdwo.zza(zzc);
        } catch (zzegl unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
