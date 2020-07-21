package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzjk {
    private final MediaCodec.CryptoInfo zzanq;
    private final MediaCodec.CryptoInfo.Pattern zzanz;

    private zzjk(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzanq = cryptoInfo;
        this.zzanz = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzanz.set(i, i2);
        this.zzanq.setPattern(this.zzanz);
    }
}
