package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcmf implements Runnable {
    private final zzclx zzgff;
    private final zzbbn zzgfp;

    zzcmf(zzclx zzclx, zzbbn zzbbn) {
        this.zzgff = zzclx;
        this.zzgfp = zzbbn;
    }

    public final void run() {
        zzbbn zzbbn = this.zzgfp;
        String zzwk = zzq.zzla().zzwe().zzwz().zzwk();
        if (!TextUtils.isEmpty(zzwk)) {
            zzbbn.set(zzwk);
        } else {
            zzbbn.setException(new Exception());
        }
    }
}
