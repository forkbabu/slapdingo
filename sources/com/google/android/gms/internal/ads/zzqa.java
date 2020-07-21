package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqa implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzpz zzbly;

    private zzqa(zzpz zzpz, MediaCodec mediaCodec) {
        this.zzbly = zzpz;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this == this.zzbly.zzblv) {
            this.zzbly.zzjj();
        }
    }
}
