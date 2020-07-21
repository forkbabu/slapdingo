package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.ads.internal.zzq;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbbz extends zzbcm implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzedz = new HashMap();
    private final zzbde zzeea;
    private final boolean zzeeb;
    private int zzeec = 0;
    private int zzeed = 0;
    private MediaPlayer zzeee;
    private Uri zzeef;
    private int zzeeg;
    private int zzeeh;
    private int zzeei;
    private int zzeej;
    private int zzeek;
    private zzbcz zzeel;
    private boolean zzeem;
    private int zzeen;
    /* access modifiers changed from: private */
    public zzbcj zzeeo;

    public zzbbz(Context context, boolean z, boolean z2, zzbdc zzbdc, zzbde zzbde) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzeea = zzbde;
        this.zzeem = z;
        this.zzeeb = z2;
        zzbde.zzb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final String zzyo() {
        String str = this.zzeem ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zza(zzbcj zzbcj) {
        this.zzeeo = zzbcj;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzsy zzd = zzsy.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.zzeef = parse;
            this.zzeen = 0;
            zzyp();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void stop() {
        zzaxv.zzeh("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzeee;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzeee.release();
            this.zzeee = null;
            zzdh(0);
            this.zzeed = 0;
        }
        this.zzeea.onStop();
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzaxv.zzeh(sb.toString());
        this.zzeeg = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzeeh = videoHeight;
        if (this.zzeeg != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzaxv.zzeh("AdMediaPlayerView prepared");
        zzdh(2);
        this.zzeea.zzfa();
        zzaye.zzdzw.post(new zzbcb(this));
        this.zzeeg = mediaPlayer.getVideoWidth();
        this.zzeeh = mediaPlayer.getVideoHeight();
        int i = this.zzeen;
        if (i != 0) {
            seekTo(i);
        }
        zzyq();
        int i2 = this.zzeeg;
        int i3 = this.zzeeh;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzaxv.zzfc(sb.toString());
        if (this.zzeed == 3) {
            play();
        }
        zzys();
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzaxv.zzeh("AdMediaPlayerView completion");
        zzdh(5);
        this.zzeed = 5;
        zzaye.zzdzw.post(new zzbce(this));
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzedz.get(Integer.valueOf(i));
        String str2 = zzedz.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaxv.zzeh(sb.toString());
        return true;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzedz.get(Integer.valueOf(i));
        String str2 = zzedz.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaxv.zzfd(sb.toString());
        zzdh(-1);
        this.zzeed = -1;
        zzaye.zzdzw.post(new zzbcd(this, str, str2));
        return true;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzeei = i;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaxv.zzeh("AdMediaPlayerView surface created");
        zzyp();
        zzaye.zzdzw.post(new zzbcg(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaxv.zzeh("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzeed == 3;
        if (!(this.zzeeg == i && this.zzeeh == i2)) {
            z = false;
        }
        if (this.zzeee != null && z2 && z) {
            int i3 = this.zzeen;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbcz zzbcz = this.zzeel;
        if (zzbcz != null) {
            zzbcz.zzm(i, i2);
        }
        zzaye.zzdzw.post(new zzbcf(this, i, i2));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzaxv.zzeh("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzeee;
        if (mediaPlayer != null && this.zzeen == 0) {
            this.zzeen = mediaPlayer.getCurrentPosition();
        }
        zzbcz zzbcz = this.zzeel;
        if (zzbcz != null) {
            zzbcz.zzzf();
        }
        zzaye.zzdzw.post(new zzbci(this));
        zzat(true);
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeea.zzc(this);
        this.zzeew.zza(surfaceTexture, this.zzeeo);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzaxv.zzeh(sb.toString());
        zzaye.zzdzw.post(new zzbcc(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int defaultSize = getDefaultSize(this.zzeeg, i);
        int defaultSize2 = getDefaultSize(this.zzeeh, i2);
        if (this.zzeeg > 0 && this.zzeeh > 0 && this.zzeel == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.zzeeg;
                int i6 = i5 * size2;
                int i7 = this.zzeeh;
                if (i6 < size * i7) {
                    defaultSize = (i5 * size2) / i7;
                    defaultSize2 = size2;
                } else {
                    if (i5 * size2 > size * i7) {
                        i4 = (i7 * size) / i5;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i8 = (this.zzeeh * size) / this.zzeeg;
                if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                    i4 = i8;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i9 = (this.zzeeg * size2) / this.zzeeh;
                if (mode != Integer.MIN_VALUE || i9 <= size) {
                    defaultSize = i9;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i10 = this.zzeeg;
                int i11 = this.zzeeh;
                if (mode2 != Integer.MIN_VALUE || i11 <= size2) {
                    defaultSize2 = i11;
                } else {
                    i10 = (i10 * size2) / i11;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i10 <= size) {
                    defaultSize = i10;
                } else {
                    i4 = (this.zzeeh * size) / this.zzeeg;
                }
            }
            defaultSize = size;
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        zzbcz zzbcz = this.zzeel;
        if (zzbcz != null) {
            zzbcz.zzm(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i12 = this.zzeej;
            if ((i12 > 0 && i12 != defaultSize) || ((i3 = this.zzeek) > 0 && i3 != defaultSize2)) {
                zzyq();
            }
            this.zzeej = defaultSize;
            this.zzeek = defaultSize2;
        }
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    private final void zzyp() {
        zzaxv.zzeh("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzeef != null && surfaceTexture != null) {
            zzat(false);
            try {
                zzq.zzlm();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.zzeee = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.zzeee.setOnCompletionListener(this);
                this.zzeee.setOnErrorListener(this);
                this.zzeee.setOnInfoListener(this);
                this.zzeee.setOnPreparedListener(this);
                this.zzeee.setOnVideoSizeChangedListener(this);
                this.zzeei = 0;
                if (this.zzeem) {
                    zzbcz zzbcz = new zzbcz(getContext());
                    this.zzeel = zzbcz;
                    zzbcz.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzeel.start();
                    SurfaceTexture zzzg = this.zzeel.zzzg();
                    if (zzzg != null) {
                        surfaceTexture = zzzg;
                    } else {
                        this.zzeel.zzzf();
                        this.zzeel = null;
                    }
                }
                this.zzeee.setDataSource(getContext(), this.zzeef);
                zzq.zzln();
                this.zzeee.setSurface(new Surface(surfaceTexture));
                this.zzeee.setAudioStreamType(3);
                this.zzeee.setScreenOnWhilePlaying(true);
                this.zzeee.prepareAsync();
                zzdh(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzeef);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzaxv.zzd(sb.toString(), e);
                onError(this.zzeee, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzyq() {
        /*
            r8 = this;
            boolean r0 = r8.zzeeb
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.zzyr()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r8.zzeee
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r8.zzeed
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.ads.zzaxv.zzeh(r0)
            r0 = 0
            r8.zzd(r0)
            android.media.MediaPlayer r0 = r8.zzeee
            r0.start()
            android.media.MediaPlayer r0 = r8.zzeee
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzld()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r8.zzyr()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r8.zzeee
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzq.zzld()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.zzeee
            r0.pause()
            r8.zzys()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbz.zzyq():void");
    }

    private final void zzat(boolean z) {
        zzaxv.zzeh("AdMediaPlayerView release");
        zzbcz zzbcz = this.zzeel;
        if (zzbcz != null) {
            zzbcz.zzzf();
            this.zzeel = null;
        }
        MediaPlayer mediaPlayer = this.zzeee;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzeee.release();
            this.zzeee = null;
            zzdh(0);
            if (z) {
                this.zzeed = 0;
                this.zzeed = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void play() {
        zzaxv.zzeh("AdMediaPlayerView play");
        if (zzyr()) {
            this.zzeee.start();
            zzdh(3);
            this.zzeew.zzyu();
            zzaye.zzdzw.post(new zzbch(this));
        }
        this.zzeed = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void pause() {
        zzaxv.zzeh("AdMediaPlayerView pause");
        if (zzyr() && this.zzeee.isPlaying()) {
            this.zzeee.pause();
            zzdh(4);
            zzaye.zzdzw.post(new zzbck(this));
        }
        this.zzeed = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final int getDuration() {
        if (zzyr()) {
            return this.zzeee.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final int getCurrentPosition() {
        if (zzyr()) {
            return this.zzeee.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzaxv.zzeh(sb.toString());
        if (zzyr()) {
            this.zzeee.seekTo(i);
            this.zzeen = 0;
            return;
        }
        this.zzeen = i;
    }

    private final boolean zzyr() {
        int i;
        return (this.zzeee == null || (i = this.zzeec) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zza(float f, float f2) {
        zzbcz zzbcz = this.zzeel;
        if (zzbcz != null) {
            zzbcz.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzeee;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzeee;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbcm
    public final void zzys() {
        zzd(this.zzeex.getVolume());
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzeee;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzaxv.zzfd("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzdh(int i) {
        if (i == 3) {
            this.zzeea.zzzt();
            this.zzeex.zzzt();
        } else if (this.zzeec == 3) {
            this.zzeea.zzzu();
            this.zzeex.zzzu();
        }
        this.zzeec = i;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdi(int i) {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzedz.put(-1004, "MEDIA_ERROR_IO");
            zzedz.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzedz.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzedz.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzedz.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzedz.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzedz.put(1, "MEDIA_ERROR_UNKNOWN");
        zzedz.put(1, "MEDIA_INFO_UNKNOWN");
        zzedz.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzedz.put(701, "MEDIA_INFO_BUFFERING_START");
        zzedz.put(702, "MEDIA_INFO_BUFFERING_END");
        zzedz.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzedz.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzedz.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzedz.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzedz.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
