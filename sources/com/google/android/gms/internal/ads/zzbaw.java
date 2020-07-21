package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzbaw implements zzbax {
    private final int zzedb;
    private final Map zzedc;

    zzbaw(int i, Map map) {
        this.zzedb = i;
        this.zzedc = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbax
    public final void zzb(JsonWriter jsonWriter) {
        zzbau.zza(this.zzedb, this.zzedc, jsonWriter);
    }
}
