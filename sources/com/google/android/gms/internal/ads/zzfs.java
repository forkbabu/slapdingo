package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzfs extends zzgm {
    private long startTime;

    public zzfs(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, long j, int i, int i2) {
        super(zzex, str, str2, zza, i, 25);
        this.startTime = j;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzabl.invoke(null, new Object[0])).longValue();
        synchronized (this.zzabb) {
            this.zzabb.zzak(longValue);
            if (this.startTime != 0) {
                this.zzabb.zzm(longValue - this.startTime);
                this.zzabb.zzp(this.startTime);
            }
        }
    }
}
