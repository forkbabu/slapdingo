package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzekh extends zzekg implements zzbp {
    private int flags;
    private int version;

    protected zzekh(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zzios) {
            zzbjc();
        }
        return this.version;
    }

    /* access modifiers changed from: protected */
    public final long zzr(ByteBuffer byteBuffer) {
        this.version = zzbq.zza(byteBuffer.get());
        this.flags = (zzbq.zzg(byteBuffer) << 8) + 0 + zzbq.zza(byteBuffer.get());
        return 4;
    }
}
