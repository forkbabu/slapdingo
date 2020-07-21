package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzfj extends zzgm {
    private final Activity zzaar;
    private final View zzaas;

    public zzfj(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2, View view, Activity activity) {
        super(zzex, str, str2, zza, i, 62);
        this.zzaas = view;
        this.zzaar = activity;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaas != null) {
            boolean booleanValue = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcqg)).booleanValue();
            Object[] objArr = (Object[]) this.zzabl.invoke(null, this.zzaas, this.zzaar, Boolean.valueOf(booleanValue));
            synchronized (this.zzabb) {
                this.zzabb.zzai(((Long) objArr[0]).longValue());
                this.zzabb.zzaj(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzabb.zzaa((String) objArr[2]);
                }
            }
        }
    }
}
