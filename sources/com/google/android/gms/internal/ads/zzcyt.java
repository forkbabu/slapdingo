package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcyt implements zzduh {
    private final zzasm zzfsc;

    zzcyt(zzasm zzasm) {
        this.zzfsc = zzasm;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        return zzdux.zzaf(new zzcyv(new JsonReader(new InputStreamReader((InputStream) obj))).zzo(this.zzfsc.zzdsq));
    }
}
