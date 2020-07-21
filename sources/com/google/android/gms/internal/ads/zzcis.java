package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcis {
    private final Map<String, zzcit> zzgcy = new HashMap();

    zzcis() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzdlm zzdlm) {
        if (!this.zzgcy.containsKey(str)) {
            try {
                this.zzgcy.put(str, new zzcit(str, zzdlm.zztr(), zzdlm.zzts()));
            } catch (zzdlg unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzaox zzaox) {
        if (!this.zzgcy.containsKey(str)) {
            try {
                this.zzgcy.put(str, new zzcit(str, zzaox.zztr(), zzaox.zzts()));
            } catch (Throwable unused) {
            }
        }
    }

    @Nullable
    public final synchronized zzcit zzgf(String str) {
        return this.zzgcy.get(str);
    }
}
