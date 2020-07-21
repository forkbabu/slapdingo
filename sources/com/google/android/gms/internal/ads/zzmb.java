package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzmb implements zzlz {
    private final int zzbcx;
    private MediaCodecInfo[] zzbcy;

    public zzmb(boolean z) {
        this.zzbcx = z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final boolean zzhk() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final int getCodecCount() {
        zzhl();
        return this.zzbcy.length;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzhl();
        return this.zzbcy[i];
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void zzhl() {
        if (this.zzbcy == null) {
            this.zzbcy = new MediaCodecList(this.zzbcx).getCodecInfos();
        }
    }
}
