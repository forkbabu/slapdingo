package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzge extends zzgm {
    private final StackTraceElement[] zzabg;

    public zzge(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzex, str, str2, zza, i, 45);
        this.zzabg = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        zzcn zzcn;
        if (this.zzabg != null) {
            zzet zzet = new zzet((String) this.zzabl.invoke(null, this.zzabg));
            synchronized (this.zzabb) {
                this.zzabb.zzab(zzet.zzym.longValue());
                if (zzet.zzyn.booleanValue()) {
                    zzcf.zza.C0006zza zza = this.zzabb;
                    if (zzet.zzyo.booleanValue()) {
                        zzcn = zzcn.ENUM_FALSE;
                    } else {
                        zzcn = zzcn.ENUM_TRUE;
                    }
                    zza.zzc(zzcn);
                } else {
                    this.zzabb.zzc(zzcn.ENUM_FAILURE);
                }
            }
        }
    }
}
