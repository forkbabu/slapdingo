package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaab extends zzym {
    private final VideoController.VideoLifecycleCallbacks zzadn;

    public zzaab(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzadn = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void onVideoStart() {
        this.zzadn.onVideoStart();
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void onVideoPlay() {
        this.zzadn.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void onVideoPause() {
        this.zzadn.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void onVideoEnd() {
        this.zzadn.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void onVideoMute(boolean z) {
        this.zzadn.onVideoMute(z);
    }
}
