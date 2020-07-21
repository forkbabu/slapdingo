package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzgd extends zzgm {
    public zzgd(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 51);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzabb) {
            zzey zzey = new zzey((String) this.zzabl.invoke(null, new Object[0]));
            this.zzabb.zzac(zzey.zzzh.longValue());
            this.zzabb.zzad(zzey.zzzi.longValue());
        }
    }
}
