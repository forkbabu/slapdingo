package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdwo {
    private zzebn zzhpq;

    private zzdwo(zzebn zzebn) {
        this.zzhpq = zzebn;
    }

    static final zzdwo zza(zzebn zzebn) throws GeneralSecurityException {
        if (zzebn != null && zzebn.zzbbg() > 0) {
            return new zzdwo(zzebn);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    /* access modifiers changed from: package-private */
    public final zzebn zzaxq() {
        return this.zzhpq;
    }

    public final String toString() {
        return zzdxc.zzb(this.zzhpq).toString();
    }
}
