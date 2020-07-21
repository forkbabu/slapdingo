package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.applex.snaplingo.util.Constants;
import com.google.android.gms.ads.internal.zzq;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbdi extends zzbcm implements TextureView.SurfaceTextureListener, zzbef {
    private Surface zzbld;
    private final zzbde zzeea;
    private final boolean zzeeb;
    private int zzeeg;
    private int zzeeh;
    private int zzeej;
    private int zzeek;
    private zzbcz zzeel;
    private final boolean zzeem;
    private zzbcj zzeeo;
    private final zzbdb zzeez;
    private String[] zzefm;
    private final zzbdc zzeij;
    private zzbdy zzeik;
    private String zzeil;
    private boolean zzeim;
    private int zzein = 1;
    private boolean zzeio;
    private boolean zzeip;
    private float zzeiq;

    public zzbdi(Context context, zzbde zzbde, zzbdb zzbdb, boolean z, boolean z2, zzbdc zzbdc) {
        super(context);
        this.zzeeb = z2;
        this.zzeez = zzbdb;
        this.zzeea = zzbde;
        this.zzeem = z;
        this.zzeij = zzbdc;
        setSurfaceTextureListener(this);
        this.zzeea.zzb(this);
    }

    private final zzbdy zzzw() {
        return new zzbdy(this.zzeez.getContext(), this.zzeij);
    }

    private final String zzzx() {
        return zzq.zzkw().zzs(this.zzeez.getContext(), this.zzeez.zzzo().zzbpn);
    }

    private final boolean zzzy() {
        zzbdy zzbdy = this.zzeik;
        return (zzbdy == null || zzbdy.zzaal() == null || this.zzeim) ? false : true;
    }

    private final boolean zzzz() {
        return zzzy() && this.zzein != 1;
    }

    private final void zzaaa() {
        String str;
        if (this.zzeik == null && (str = this.zzeil) != null && this.zzbld != null) {
            if (str.startsWith("cache:")) {
                zzbes zzfi = this.zzeez.zzfi(this.zzeil);
                if (zzfi instanceof zzbfd) {
                    zzbdy zzaaq = ((zzbfd) zzfi).zzaaq();
                    this.zzeik = zzaaq;
                    if (zzaaq.zzaal() == null) {
                        zzaxv.zzfd("Precached video player has been released.");
                        return;
                    }
                } else if (zzfi instanceof zzbfe) {
                    zzbfe zzbfe = (zzbfe) zzfi;
                    String zzzx = zzzx();
                    ByteBuffer byteBuffer = zzbfe.getByteBuffer();
                    boolean zzaar = zzbfe.zzaar();
                    String url = zzbfe.getUrl();
                    if (url == null) {
                        zzaxv.zzfd("Stream cache URL is null.");
                        return;
                    }
                    zzbdy zzzw = zzzw();
                    this.zzeik = zzzw;
                    zzzw.zza(new Uri[]{Uri.parse(url)}, zzzx, byteBuffer, zzaar);
                } else {
                    String valueOf = String.valueOf(this.zzeil);
                    zzaxv.zzfd(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.zzeik = zzzw();
                String zzzx2 = zzzx();
                Uri[] uriArr = new Uri[this.zzefm.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzefm;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzeik.zza(uriArr, zzzx2);
            }
            this.zzeik.zza(this);
            zza(this.zzbld, false);
            if (this.zzeik.zzaal() != null) {
                int playbackState = this.zzeik.zzaal().getPlaybackState();
                this.zzein = playbackState;
                if (playbackState == 3) {
                    zzaab();
                }
            }
        }
    }

    private final void zza(Surface surface, boolean z) {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zza(surface, z);
        } else {
            zzaxv.zzfd("Trying to set surface before player is initalized.");
        }
    }

    private final void zza(float f, boolean z) {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zzb(f, z);
        } else {
            zzaxv.zzfd("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbcm
    public final void zzys() {
        zza(this.zzeex.getVolume(), false);
    }

    private final void zzaab() {
        if (!this.zzeio) {
            this.zzeio = true;
            zzaye.zzdzw.post(new zzbdh(this));
            zzys();
            this.zzeea.zzfa();
            if (this.zzeip) {
                play();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final String zzyo() {
        String str = this.zzeem ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zza(zzbcj zzbcj) {
        this.zzeeo = zzbcj;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzeil = str;
            this.zzefm = new String[]{str};
            zzaaa();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzeil = str;
            this.zzefm = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzaaa();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void play() {
        if (zzzz()) {
            if (this.zzeij.zzehh) {
                zzaad();
            }
            this.zzeik.zzaal().zzg(true);
            this.zzeea.zzzt();
            this.zzeex.zzzt();
            this.zzeew.zzyu();
            zzaye.zzdzw.post(new zzbdm(this));
            return;
        }
        this.zzeip = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void stop() {
        if (zzzy()) {
            this.zzeik.zzaal().stop();
            if (this.zzeik != null) {
                zza((Surface) null, true);
                zzbdy zzbdy = this.zzeik;
                if (zzbdy != null) {
                    zzbdy.zza((zzbef) null);
                    this.zzeik.release();
                    this.zzeik = null;
                }
                this.zzein = 1;
                this.zzeim = false;
                this.zzeio = false;
                this.zzeip = false;
            }
        }
        this.zzeea.zzzu();
        this.zzeex.zzzu();
        this.zzeea.onStop();
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void pause() {
        if (zzzz()) {
            if (this.zzeij.zzehh) {
                zzaae();
            }
            this.zzeik.zzaal().zzg(false);
            this.zzeea.zzzu();
            this.zzeex.zzzu();
            zzaye.zzdzw.post(new zzbdl(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void seekTo(int i) {
        if (zzzz()) {
            this.zzeik.zzaal().seekTo((long) i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzdj(int i) {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zzaao().zzdq(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzdk(int i) {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zzaao().zzdr(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzdl(int i) {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zzaao().zzdl(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzdm(int i) {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zzaao().zzdm(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zzdn(int i) {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zzdn(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final void zza(float f, float f2) {
        zzbcz zzbcz = this.zzeel;
        if (zzbcz != null) {
            zzbcz.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final int getCurrentPosition() {
        if (zzzz()) {
            return (int) this.zzeik.zzaal().zzem();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final int getDuration() {
        if (zzzz()) {
            return (int) this.zzeik.zzaal().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final int getVideoWidth() {
        return this.zzeeg;
    }

    @Override // com.google.android.gms.internal.ads.zzbcm
    public final int getVideoHeight() {
        return this.zzeeh;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            super.onMeasure(r11, r12)
            int r11 = r10.getMeasuredWidth()
            int r12 = r10.getMeasuredHeight()
            float r0 = r10.zzeiq
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbcz r2 = r10.zzeel
            if (r2 != 0) goto L_0x002a
            float r2 = (float) r11
            float r3 = (float) r12
            float r3 = r2 / r3
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0020
            float r2 = r2 / r0
            int r12 = (int) r2
        L_0x0020:
            float r0 = r10.zzeiq
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x002a
            float r11 = (float) r12
            float r11 = r11 * r0
            int r11 = (int) r11
        L_0x002a:
            r10.setMeasuredDimension(r11, r12)
            com.google.android.gms.internal.ads.zzbcz r0 = r10.zzeel
            if (r0 == 0) goto L_0x0034
            r0.zzm(r11, r12)
        L_0x0034:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 != r2) goto L_0x00a2
            int r0 = r10.zzeej
            if (r0 <= 0) goto L_0x0040
            if (r0 != r11) goto L_0x0046
        L_0x0040:
            int r0 = r10.zzeek
            if (r0 <= 0) goto L_0x009e
            if (r0 == r12) goto L_0x009e
        L_0x0046:
            boolean r0 = r10.zzeeb
            if (r0 == 0) goto L_0x009e
            boolean r0 = r10.zzzy()
            if (r0 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzbdy r0 = r10.zzeik
            com.google.android.gms.internal.ads.zzhe r0 = r0.zzaal()
            long r2 = r0.zzem()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x009e
            boolean r2 = r0.zzek()
            if (r2 == 0) goto L_0x0067
            goto L_0x009e
        L_0x0067:
            r2 = 1
            r10.zza(r1, r2)
            r0.zzg(r2)
            long r1 = r0.zzem()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzq.zzld()
            long r3 = r3.currentTimeMillis()
        L_0x007a:
            boolean r5 = r10.zzzy()
            if (r5 == 0) goto L_0x0097
            long r5 = r0.zzem()
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0097
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzq.zzld()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            r7 = 250(0xfa, double:1.235E-321)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x007a
        L_0x0097:
            r1 = 0
            r0.zzg(r1)
            r10.zzys()
        L_0x009e:
            r10.zzeej = r11
            r10.zzeek = r12
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdi.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzeem) {
            zzbcz zzbcz = new zzbcz(getContext());
            this.zzeel = zzbcz;
            zzbcz.zza(surfaceTexture, i, i2);
            this.zzeel.start();
            SurfaceTexture zzzg = this.zzeel.zzzg();
            if (zzzg != null) {
                surfaceTexture = zzzg;
            } else {
                this.zzeel.zzzf();
                this.zzeel = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzbld = surface;
        if (this.zzeik == null) {
            zzaaa();
        } else {
            zza(surface, true);
            if (!this.zzeij.zzehh) {
                zzaad();
            }
        }
        if (this.zzeeg == 0 || this.zzeeh == 0) {
            zzo(i, i2);
        } else {
            zzaac();
        }
        zzaye.zzdzw.post(new zzbdo(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbcz zzbcz = this.zzeel;
        if (zzbcz != null) {
            zzbcz.zzm(i, i2);
        }
        zzaye.zzdzw.post(new zzbdn(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeea.zzc(this);
        this.zzeew.zza(surfaceTexture, this.zzeeo);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbcz zzbcz = this.zzeel;
        if (zzbcz != null) {
            zzbcz.zzzf();
            this.zzeel = null;
        }
        if (this.zzeik != null) {
            zzaae();
            Surface surface = this.zzbld;
            if (surface != null) {
                surface.release();
            }
            this.zzbld = null;
            zza((Surface) null, true);
        }
        zzaye.zzdzw.post(new zzbdq(this));
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzaxv.zzeh(sb.toString());
        zzaye.zzdzw.post(new zzbdp(this, i));
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    public final void zzb(boolean z, long j) {
        if (this.zzeez != null) {
            zzbbf.zzedl.execute(new zzbds(this, z, j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    public final void zzdo(int i) {
        if (this.zzein != i) {
            this.zzein = i;
            if (i == 3) {
                zzaab();
            } else if (i == 4) {
                if (this.zzeij.zzehh) {
                    zzaae();
                }
                this.zzeea.zzzu();
                this.zzeex.zzzu();
                zzaye.zzdzw.post(new zzbdk(this));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    public final void zzn(int i, int i2) {
        this.zzeeg = i;
        this.zzeeh = i2;
        zzaac();
    }

    @Override // com.google.android.gms.internal.ads.zzbef
    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append(Constants.PATH_SEPERATOR);
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzaxv.zzfd(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzeim = true;
        if (this.zzeij.zzehh) {
            zzaae();
        }
        zzaye.zzdzw.post(new zzbdj(this, sb2));
    }

    private final void zzaac() {
        zzo(this.zzeeg, this.zzeeh);
    }

    private final void zzo(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzeiq != f) {
            this.zzeiq = f;
            requestLayout();
        }
    }

    private final void zzaad() {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zzaw(true);
        }
    }

    private final void zzaae() {
        zzbdy zzbdy = this.zzeik;
        if (zzbdy != null) {
            zzbdy.zzaw(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzeez.zza(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzdp(int i) {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaaf() {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.zzyw();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(int i, int i2) {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.zzk(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaag() {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.zzyt();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaah() {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaai() {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.zzyu();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfj(String str) {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.zzm("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaaj() {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.zzyv();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaak() {
        zzbcj zzbcj = this.zzeeo;
        if (zzbcj != null) {
            zzbcj.zzfa();
        }
    }
}
