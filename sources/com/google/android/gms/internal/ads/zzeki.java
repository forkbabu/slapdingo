package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzeki extends zzekk implements zzbp {
    private String type;
    private long zzawn;
    private zzbs zzior;
    private boolean zzioz;

    public zzeki(String str) {
        this.type = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzbs zzbs) {
        this.zzior = zzbs;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzekm zzekm, ByteBuffer byteBuffer, long j, zzbo zzbo) throws IOException {
        this.zzawn = zzekm.position() - ((long) byteBuffer.remaining());
        this.zzioz = byteBuffer.remaining() == 16;
        zza(zzekm, j, zzbo);
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final void zza(zzekm zzekm, long j, zzbo zzbo) throws IOException {
        this.zziox = zzekm;
        this.zzipd = zzekm.position();
        this.zzbfs = this.zzipd - ((long) ((this.zzioz || 8 + j >= 4294967296L) ? 16 : 8));
        zzekm.zzfc(zzekm.position() + j);
        this.zzasm = zzekm.position();
        this.zzipb = zzbo;
    }
}
