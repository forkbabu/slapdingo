package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzga extends zzgm {
    public zzga(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2) {
        super(zzex, str, str2, zza, i, 3);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcqj)).booleanValue();
        zzek zzek = new zzek((String) this.zzabl.invoke(null, this.zzwf.getContext(), Boolean.valueOf(booleanValue)));
        synchronized (this.zzabb) {
            this.zzabb.zze(zzek.zzyj);
            this.zzabb.zzag(zzek.zzyk);
        }
    }
}
