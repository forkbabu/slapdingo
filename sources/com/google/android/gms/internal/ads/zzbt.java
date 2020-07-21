package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbt extends zzekg {
    private ByteBuffer zzdd;

    public zzbt(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final void zzl(ByteBuffer byteBuffer) {
        this.zzdd = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
