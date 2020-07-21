package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzfq extends zzgm {
    public zzfq(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 5);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzabb.zzf(-1);
        this.zzabb.zzg(-1);
        int[] iArr = (int[]) this.zzabl.invoke(null, this.zzwf.getContext());
        synchronized (this.zzabb) {
            this.zzabb.zzf((long) iArr[0]);
            this.zzabb.zzg((long) iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzabb.zzaf((long) iArr[2]);
            }
        }
    }
}
