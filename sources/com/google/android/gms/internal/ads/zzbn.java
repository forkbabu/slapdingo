package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbn extends zzekk implements Closeable {
    private static zzeks zzdc = zzeks.zzn(zzbn.class);

    public zzbn(zzekm zzekm, zzbo zzbo) throws IOException {
        zza(zzekm, zzekm.size(), zzbo);
    }

    @Override // com.google.android.gms.internal.ads.zzekk, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zziox.close();
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public String toString() {
        String obj = this.zziox.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 7);
        sb.append("model(");
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
