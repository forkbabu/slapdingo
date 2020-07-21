package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzdsg {
    private static final Logger logger = Logger.getLogger(zzdsg.class.getName());
    private static final zzdsd zzhkk = new zza();

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    static final class zza {
        private zza() {
        }
    }

    private zzdsg() {
    }

    static String zzhg(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    static boolean zzhf(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    static String emptyToNull(@NullableDecl String str) {
        if (zzhf(str)) {
            return null;
        }
        return str;
    }
}
