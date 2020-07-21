package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzir extends zzis {
    private final AudioTimestamp zzall = new AudioTimestamp();
    private long zzalm;
    private long zzaln;
    private long zzalo;

    public zzir() {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzis
    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzalm = 0;
        this.zzaln = 0;
        this.zzalo = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzis
    public final boolean zzfx() {
        boolean timestamp = this.zzaju.getTimestamp(this.zzall);
        if (timestamp) {
            long j = this.zzall.framePosition;
            if (this.zzaln > j) {
                this.zzalm++;
            }
            this.zzaln = j;
            this.zzalo = j + (this.zzalm << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.zzis
    public final long zzfy() {
        return this.zzall.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.zzis
    public final long zzfz() {
        return this.zzalo;
    }
}
