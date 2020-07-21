package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzds implements zzdrh {
    private final /* synthetic */ zzdpk zzwd;

    zzds(zzdp zzdp, zzdpk zzdpk) {
        this.zzwd = zzdpk;
    }

    @Override // com.google.android.gms.internal.ads.zzdrh
    public final boolean zzb(File file) {
        try {
            return this.zzwd.zzb(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
