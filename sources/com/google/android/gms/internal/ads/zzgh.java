package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzgh extends zzgm {
    private final View zzaas;

    public zzgh(zzex zzex, String str, String str2, zzcf.zza.C0006zza zza, int i, int i2, View view) {
        super(zzex, str, str2, zza, i, 57);
        this.zzaas = view;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgm
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaas != null) {
            Boolean bool = (Boolean) zzwg.zzpw().zzd(zzaav.zzcqw);
            DisplayMetrics displayMetrics = this.zzwf.getContext().getResources().getDisplayMetrics();
            zzff zzff = new zzff((String) this.zzabl.invoke(null, this.zzaas, displayMetrics, bool));
            zzcf.zza.zzf.C0008zza zzay = zzcf.zza.zzf.zzay();
            zzay.zzcy(zzff.zzaaa.longValue()).zzcz(zzff.zzaab.longValue()).zzda(zzff.zzaac.longValue());
            if (bool.booleanValue()) {
                zzay.zzdb(zzff.zzaad.longValue());
            }
            this.zzabb.zza((zzcf.zza.zzf) ((zzegb) zzay.zzbfq()));
        }
    }
}
