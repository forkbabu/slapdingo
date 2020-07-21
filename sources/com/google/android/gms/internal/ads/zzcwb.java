package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcwb implements zze {
    private zze zzgoj;

    public final synchronized void zza(zze zze) {
        this.zzgoj = zze;
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final synchronized void zzh(View view) {
        if (this.zzgoj != null) {
            this.zzgoj.zzh(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final synchronized void zzjz() {
        if (this.zzgoj != null) {
            this.zzgoj.zzjz();
        }
    }

    @Override // com.google.android.gms.ads.internal.zze
    public final synchronized void zzka() {
        if (this.zzgoj != null) {
            this.zzgoj.zzka();
        }
    }
}
