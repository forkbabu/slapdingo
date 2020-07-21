package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import org.spongycastle.asn1.cmc.BodyPartID;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
class zzis {
    private int zzahh;
    protected AudioTrack zzaju;
    private boolean zzalp;
    private long zzalq;
    private long zzalr;
    private long zzals;
    private long zzalt;
    private long zzalu;
    private long zzalv;

    private zzis() {
    }

    public boolean zzfx() {
        return false;
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzaju = audioTrack;
        this.zzalp = z;
        this.zzalt = -9223372036854775807L;
        this.zzalq = 0;
        this.zzalr = 0;
        this.zzals = 0;
        if (audioTrack != null) {
            this.zzahh = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j) {
        this.zzalu = zzga();
        this.zzalt = SystemClock.elapsedRealtime() * 1000;
        this.zzalv = j;
        this.zzaju.stop();
    }

    public final void pause() {
        if (this.zzalt == -9223372036854775807L) {
            this.zzaju.pause();
        }
    }

    public final long zzga() {
        if (this.zzalt != -9223372036854775807L) {
            return Math.min(this.zzalv, this.zzalu + ((((SystemClock.elapsedRealtime() * 1000) - this.zzalt) * ((long) this.zzahh)) / 1000000));
        }
        int playState = this.zzaju.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = BodyPartID.bodyIdMax & ((long) this.zzaju.getPlaybackHeadPosition());
        if (this.zzalp) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzals = this.zzalq;
            }
            playbackHeadPosition += this.zzals;
        }
        if (this.zzalq > playbackHeadPosition) {
            this.zzalr++;
        }
        this.zzalq = playbackHeadPosition;
        return playbackHeadPosition + (this.zzalr << 32);
    }

    public final long zzgb() {
        return (zzga() * 1000000) / ((long) this.zzahh);
    }

    public long zzfy() {
        throw new UnsupportedOperationException();
    }

    public long zzfz() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ zzis(zzip zzip) {
        this();
    }
}
