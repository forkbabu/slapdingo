package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzip extends Thread {
    private final /* synthetic */ AudioTrack zzajh;
    private final /* synthetic */ zziq zzaji;

    zzip(zziq zziq, AudioTrack audioTrack) {
        this.zzaji = zziq;
        this.zzajh = audioTrack;
    }

    public final void run() {
        try {
            this.zzajh.flush();
            this.zzajh.release();
        } finally {
            this.zzaji.zzajq.open();
        }
    }
}
