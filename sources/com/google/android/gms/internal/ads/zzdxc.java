package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebf;
import com.google.android.gms.internal.ads.zzebn;
import com.google.android.gms.internal.ads.zzebq;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdxc {
    private static final Charset UTF_8 = Charset.forName(XmpWriter.UTF8);

    public static zzebq zzb(zzebn zzebn) {
        zzebq.zzb zzfh = zzebq.zzbbm().zzfh(zzebn.zzbbe());
        for (zzebn.zzb zzb : zzebn.zzbbf()) {
            zzfh.zzb((zzebq.zza) ((zzegb) zzebq.zza.zzbbo().zzhp(zzb.zzbbj().zzbar()).zzb(zzb.zzaxt()).zzb(zzb.zzaxu()).zzfi(zzb.zzbbk()).zzbfq()));
        }
        return (zzebq) ((zzegb) zzfh.zzbfq());
    }

    public static void zzc(zzebn zzebn) throws GeneralSecurityException {
        int zzbbe = zzebn.zzbbe();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzebn.zzb zzb : zzebn.zzbbf()) {
            if (zzb.zzaxt() == zzebg.ENABLED) {
                if (!zzb.zzbbi()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzb.zzbbk())));
                } else if (zzb.zzaxu() == zzebz.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzb.zzbbk())));
                } else if (zzb.zzaxt() != zzebg.UNKNOWN_STATUS) {
                    if (zzb.zzbbk() == zzbbe) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (zzb.zzbbj().zzbat() != zzebf.zza.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzb.zzbbk())));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
