package com.google.android.gms.internal.ads;

import android.util.JsonWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzbav implements zzbax {
    private final byte[] zzeda;

    zzbav(byte[] bArr) {
        this.zzeda = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbax
    public final void zzb(JsonWriter jsonWriter) {
        zzbau.zza(this.zzeda, jsonWriter);
    }
}
