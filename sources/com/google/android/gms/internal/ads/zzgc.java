package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzgc extends zzgm {
    private List<Long> zzabf = null;

    public zzgc(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 31);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzabb.zzq(-1);
        this.zzabb.zzr(-1);
        if (this.zzabf == null) {
            this.zzabf = (List) this.zzabl.invoke(null, this.zzwf.getContext());
        }
        List<Long> list = this.zzabf;
        if (list != null && list.size() == 2) {
            synchronized (this.zzabb) {
                this.zzabb.zzq(this.zzabf.get(0).longValue());
                this.zzabb.zzr(this.zzabf.get(1).longValue());
            }
        }
    }
}
