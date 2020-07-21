package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcpb implements Callable {
    private final zzdvf zzfrf;
    private final zzdvf zzgay;

    zzcpb(zzdvf zzdvf, zzdvf zzdvf2) {
        this.zzgay = zzdvf;
        this.zzfrf = zzdvf2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new zzcpq((JSONObject) this.zzgay.get(), (zzass) this.zzfrf.get());
    }
}
