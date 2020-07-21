package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzbat implements zzbax {
    private final String zzdfg;
    private final Map zzdfl;
    private final String zzdfo;
    private final byte[] zzecw;

    zzbat(String str, String str2, Map map, byte[] bArr) {
        this.zzdfo = str;
        this.zzdfg = str2;
        this.zzdfl = map;
        this.zzecw = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbax
    public final void zzb(JsonWriter jsonWriter) {
        zzbau.zza(this.zzdfo, this.zzdfg, this.zzdfl, this.zzecw, jsonWriter);
    }
}
