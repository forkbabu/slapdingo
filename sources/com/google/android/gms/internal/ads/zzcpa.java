package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcpa implements Callable {
    private final zzdvf zzfpl;
    private final zzdvf zzfrf;
    private final zzdvf zzgay;

    zzcpa(zzdvf zzdvf, zzdvf zzdvf2, zzdvf zzdvf3) {
        this.zzgay = zzdvf;
        this.zzfrf = zzdvf2;
        this.zzfpl = zzdvf3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new zzcpm((zzcpt) this.zzgay.get(), (JSONObject) this.zzfrf.get(), (zzass) this.zzfpl.get());
    }
}
