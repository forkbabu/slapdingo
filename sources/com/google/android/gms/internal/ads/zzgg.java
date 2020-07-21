package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzgg extends zzgm {
    private long zzaaq;
    private final zzfi zzxm;

    public zzgg(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2, zzfi zzfi) {
        super(zzex, str, str2, zza, i, 53);
        this.zzxm = zzfi;
        if (zzfi != null) {
            this.zzaaq = zzfi.zzcv();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzxm != null) {
            this.zzabb.zzae(((Long) this.zzabl.invoke(null, Long.valueOf(this.zzaaq))).longValue());
        }
    }
}
