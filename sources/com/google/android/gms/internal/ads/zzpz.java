package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.itextpdf.text.html.HtmlTags;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpz extends zzls {
    private static final int[] zzbku = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int zzahx;
    private boolean zzali;
    private final zzqd zzbkv;
    private final zzqe zzbkw;
    private final long zzbkx;
    private final int zzbky;
    private final boolean zzbkz;
    private final long[] zzbla;
    private zzhq[] zzblb;
    private zzqb zzblc;
    private Surface zzbld;
    private Surface zzble;
    private int zzblf;
    private boolean zzblg;
    private long zzblh;
    private long zzbli;
    private int zzblj;
    private int zzblk;
    private int zzbll;
    private float zzblm;
    private int zzbln;
    private int zzblo;
    private int zzblp;
    private float zzblq;
    private int zzblr;
    private int zzbls;
    private int zzblt;
    private float zzblu;
    zzqa zzblv;
    private long zzblw;
    private int zzblx;
    private final Context zzvr;

    public zzpz(Context context, zzlu zzlu, long j, Handler handler, zzqf zzqf, int i) {
        this(context, zzlu, 0, null, false, handler, zzqf, -1);
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzpz(Context context, zzlu zzlu, long j, zzjq<zzjs> zzjq, boolean z, Handler handler, zzqf zzqf, int i) {
        super(2, zzlu, null, false);
        boolean z2 = false;
        this.zzbkx = 0;
        this.zzbky = -1;
        this.zzvr = context.getApplicationContext();
        this.zzbkv = new zzqd(context);
        this.zzbkw = new zzqe(handler, zzqf);
        if (zzpo.SDK_INT <= 22 && "foster".equals(zzpo.DEVICE) && "NVIDIA".equals(zzpo.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbkz = z2;
        this.zzbla = new long[10];
        this.zzblw = -9223372036854775807L;
        this.zzblh = -9223372036854775807L;
        this.zzbln = -1;
        this.zzblo = -1;
        this.zzblq = -1.0f;
        this.zzblm = -1.0f;
        this.zzblf = 1;
        zzjk();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final int zza(zzlu zzlu, zzhq zzhq) throws zzma {
        boolean z;
        String str = zzhq.zzagw;
        int i = 0;
        if (!zzpe.zzbf(str)) {
            return 0;
        }
        zzjl zzjl = zzhq.zzagz;
        if (zzjl != null) {
            z = false;
            for (int i2 = 0; i2 < zzjl.zzaob; i2++) {
                z |= zzjl.zzad(i2).zzaof;
            }
        } else {
            z = false;
        }
        zzlt zzb = zzlu.zzb(str, z);
        boolean z2 = true;
        if (zzb == null) {
            return 1;
        }
        boolean zzbb = zzb.zzbb(zzhq.zzagt);
        if (zzbb && zzhq.width > 0 && zzhq.height > 0) {
            if (zzpo.SDK_INT >= 21) {
                zzbb = zzb.zza(zzhq.width, zzhq.height, (double) zzhq.zzaha);
            } else {
                if (zzhq.width * zzhq.height > zzlw.zzhj()) {
                    z2 = false;
                }
                if (!z2) {
                    int i3 = zzhq.width;
                    int i4 = zzhq.height;
                    String str2 = zzpo.zzbke;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i3);
                    sb.append("x");
                    sb.append(i4);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
                zzbb = z2;
            }
        }
        int i5 = zzb.zzbcj ? 8 : 4;
        if (zzb.zzali) {
            i = 16;
        }
        return (zzbb ? 3 : 2) | i5 | i;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void zze(boolean z) throws zzhb {
        super.zze(z);
        int i = zzeh().zzahx;
        this.zzahx = i;
        this.zzali = i != 0;
        this.zzbkw.zza(this.zzbci);
        this.zzbkv.enable();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha
    public final void zza(zzhq[] zzhqArr, long j) throws zzhb {
        this.zzblb = zzhqArr;
        if (this.zzblw == -9223372036854775807L) {
            this.zzblw = j;
        } else {
            int i = this.zzblx;
            long[] jArr = this.zzbla;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzblx = i + 1;
            }
            this.zzbla[this.zzblx - 1] = j;
        }
        super.zza(zzhqArr, j);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void zza(long j, boolean z) throws zzhb {
        super.zza(j, z);
        zzji();
        this.zzblk = 0;
        int i = this.zzblx;
        if (i != 0) {
            this.zzblw = this.zzbla[i - 1];
            this.zzblx = 0;
        }
        if (z) {
            zzjh();
        } else {
            this.zzblh = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhv, com.google.android.gms.internal.ads.zzls
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzblg || (((surface = this.zzble) != null && this.zzbld == surface) || zzhc() == null))) {
            this.zzblh = -9223372036854775807L;
            return true;
        } else if (this.zzblh == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzblh) {
                return true;
            }
            this.zzblh = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void onStarted() {
        super.onStarted();
        this.zzblj = 0;
        this.zzbli = SystemClock.elapsedRealtime();
        this.zzblh = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void onStopped() {
        zzjn();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void zzeg() {
        this.zzbln = -1;
        this.zzblo = -1;
        this.zzblq = -1.0f;
        this.zzblm = -1.0f;
        this.zzblw = -9223372036854775807L;
        this.zzblx = 0;
        zzjk();
        zzji();
        this.zzbkv.disable();
        this.zzblv = null;
        this.zzali = false;
        try {
            super.zzeg();
        } finally {
            this.zzbci.zzgm();
            this.zzbkw.zzb(this.zzbci);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhg, com.google.android.gms.internal.ads.zzha
    public final void zza(int i, Object obj) throws zzhb {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzble;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzlt zzhd = zzhd();
                    if (zzhd != null && zzn(zzhd.zzbck)) {
                        surface = zzpv.zzc(this.zzvr, zzhd.zzbck);
                        this.zzble = surface;
                    }
                }
            }
            if (this.zzbld != surface) {
                this.zzbld = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzhc = zzhc();
                    if (zzpo.SDK_INT < 23 || zzhc == null || surface == null) {
                        zzhe();
                        zzhb();
                    } else {
                        zzhc.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzble) {
                    zzjk();
                    zzji();
                    return;
                }
                zzjm();
                zzji();
                if (state == 2) {
                    zzjh();
                }
            } else if (surface != null && surface != this.zzble) {
                zzjm();
                if (this.zzblg) {
                    this.zzbkw.zza(this.zzbld);
                }
            }
        } else if (i == 4) {
            this.zzblf = ((Integer) obj).intValue();
            MediaCodec zzhc2 = zzhc();
            if (zzhc2 != null) {
                zzhc2.setVideoScalingMode(this.zzblf);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final boolean zza(zzlt zzlt) {
        return this.zzbld != null || zzn(zzlt.zzbck);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zza(zzlt zzlt, MediaCodec mediaCodec, zzhq zzhq, MediaCrypto mediaCrypto) throws zzma {
        zzqb zzqb;
        Point point;
        zzhq[] zzhqArr = this.zzblb;
        int i = zzhq.width;
        int i2 = zzhq.height;
        int zzi = zzi(zzhq);
        if (zzhqArr.length == 1) {
            zzqb = new zzqb(i, i2, zzi);
        } else {
            boolean z = false;
            for (zzhq zzhq2 : zzhqArr) {
                if (zza(zzlt.zzbcj, zzhq, zzhq2)) {
                    z |= zzhq2.width == -1 || zzhq2.height == -1;
                    i = Math.max(i, zzhq2.width);
                    i2 = Math.max(i2, zzhq2.height);
                    zzi = Math.max(zzi, zzi(zzhq2));
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzhq.height > zzhq.width;
                int i3 = z2 ? zzhq.height : zzhq.width;
                int i4 = z2 ? zzhq.width : zzhq.height;
                float f = ((float) i4) / ((float) i3);
                int[] iArr = zzbku;
                int length = iArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = iArr[i5];
                    int i7 = (int) (((float) i6) * f);
                    if (i6 <= i3 || i7 <= i4) {
                        break;
                    }
                    if (zzpo.SDK_INT >= 21) {
                        int i8 = z2 ? i7 : i6;
                        if (!z2) {
                            i6 = i7;
                        }
                        Point zzd = zzlt.zzd(i8, i6);
                        if (zzlt.zza(zzd.x, zzd.y, (double) zzhq.zzaha)) {
                            point = zzd;
                            break;
                        }
                    } else {
                        int zzf = zzpo.zzf(i6, 16) << 4;
                        int zzf2 = zzpo.zzf(i7, 16) << 4;
                        if (zzf * zzf2 <= zzlw.zzhj()) {
                            int i9 = z2 ? zzf2 : zzf;
                            if (!z2) {
                                zzf = zzf2;
                            }
                            point = new Point(i9, zzf);
                        }
                    }
                    i5++;
                    length = length;
                    iArr = iArr;
                    i3 = i3;
                    i4 = i4;
                }
                point = null;
                if (point != null) {
                    i = Math.max(i, point.x);
                    i2 = Math.max(i2, point.y);
                    zzi = Math.max(zzi, zza(zzhq.zzagw, i, i2));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i);
                    sb2.append("x");
                    sb2.append(i2);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zzqb = new zzqb(i, i2, zzi);
        }
        this.zzblc = zzqb;
        boolean z3 = this.zzbkz;
        int i10 = this.zzahx;
        MediaFormat zzez = zzhq.zzez();
        zzez.setInteger("max-width", zzqb.width);
        zzez.setInteger("max-height", zzqb.height);
        if (zzqb.zzblz != -1) {
            zzez.setInteger("max-input-size", zzqb.zzblz);
        }
        if (z3) {
            zzez.setInteger("auto-frc", 0);
        }
        if (i10 != 0) {
            zzez.setFeatureEnabled("tunneled-playback", true);
            zzez.setInteger("audio-session-id", i10);
        }
        if (this.zzbld == null) {
            zzpb.checkState(zzn(zzlt.zzbck));
            if (this.zzble == null) {
                this.zzble = zzpv.zzc(this.zzvr, zzlt.zzbck);
            }
            this.zzbld = this.zzble;
        }
        mediaCodec.configure(zzez, this.zzbld, (MediaCrypto) null, 0);
        if (zzpo.SDK_INT >= 23 && this.zzali) {
            this.zzblv = new zzqa(this, mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zzhe() {
        try {
            super.zzhe();
        } finally {
            Surface surface = this.zzble;
            if (surface != null) {
                if (this.zzbld == surface) {
                    this.zzbld = null;
                }
                this.zzble.release();
                this.zzble = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zzc(String str, long j, long j2) {
        this.zzbkw.zza(str, j, j2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zzd(zzhq zzhq) throws zzhb {
        super.zzd(zzhq);
        this.zzbkw.zzb(zzhq);
        this.zzblm = zzhq.zzahc == -1.0f ? 1.0f : zzhq.zzahc;
        this.zzbll = zzj(zzhq);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zza(zzjm zzjm) {
        if (zzpo.SDK_INT < 23 && this.zzali) {
            zzjj();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger(HtmlTags.WIDTH);
        }
        this.zzbln = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger(HtmlTags.HEIGHT);
        }
        this.zzblo = i2;
        this.zzblq = this.zzblm;
        if (zzpo.SDK_INT >= 21) {
            int i3 = this.zzbll;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzbln;
                this.zzbln = this.zzblo;
                this.zzblo = i4;
                this.zzblq = 1.0f / this.zzblq;
            }
        } else {
            this.zzblp = this.zzbll;
        }
        mediaCodec.setVideoScalingMode(this.zzblf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzhq zzhq, zzhq zzhq2) {
        return zza(z, zzhq, zzhq2) && zzhq2.width <= this.zzblc.width && zzhq2.height <= this.zzblc.height && zzhq2.zzagx <= this.zzblc.zzblz;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.zzblx;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.zzbla;
            if (j3 < jArr[0]) {
                break;
            }
            this.zzblw = jArr[0];
            int i4 = i3 - 1;
            this.zzblx = i4;
            System.arraycopy(jArr, 1, jArr, 0, i4);
        }
        long j4 = j3 - this.zzblw;
        if (z) {
            zza(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.zzbld == this.zzble) {
            if (!zzem(j5)) {
                return false;
            }
            zza(mediaCodec, i, j4);
            return true;
        } else if (!this.zzblg) {
            if (zzpo.SDK_INT >= 21) {
                zza(mediaCodec, i, j4, System.nanoTime());
            } else {
                zzb(mediaCodec, i, j4);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.zzbkv.zzf(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (zzf - nanoTime) / 1000;
            if (zzem(j6)) {
                zzpp.beginSection("dropVideoBuffer");
                mediaCodec.releaseOutputBuffer(i, false);
                zzpp.endSection();
                this.zzbci.zzanx++;
                this.zzblj++;
                this.zzblk++;
                this.zzbci.zzany = Math.max(this.zzblk, this.zzbci.zzany);
                if (this.zzblj == this.zzbky) {
                    zzjn();
                }
                return true;
            }
            if (zzpo.SDK_INT >= 21) {
                if (j6 < 50000) {
                    zza(mediaCodec, i, j4, zzf);
                    return true;
                }
            } else if (j6 < 30000) {
                if (j6 > 11000) {
                    try {
                        Thread.sleep((j6 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec, i, j4);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzpp.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzpp.endSection();
        this.zzbci.zzanw++;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjl();
        zzpp.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzpp.endSection();
        this.zzbci.zzanv++;
        this.zzblk = 0;
        zzjj();
    }

    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjl();
        zzpp.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzpp.endSection();
        this.zzbci.zzanv++;
        this.zzblk = 0;
        zzjj();
    }

    private final boolean zzn(boolean z) {
        if (zzpo.SDK_INT < 23 || this.zzali) {
            return false;
        }
        return !z || zzpv.zzc(this.zzvr);
    }

    private final void zzjh() {
        this.zzblh = this.zzbkx > 0 ? SystemClock.elapsedRealtime() + this.zzbkx : -9223372036854775807L;
    }

    private final void zzji() {
        MediaCodec zzhc;
        this.zzblg = false;
        if (zzpo.SDK_INT >= 23 && this.zzali && (zzhc = zzhc()) != null) {
            this.zzblv = new zzqa(this, zzhc);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzjj() {
        if (!this.zzblg) {
            this.zzblg = true;
            this.zzbkw.zza(this.zzbld);
        }
    }

    private final void zzjk() {
        this.zzblr = -1;
        this.zzbls = -1;
        this.zzblu = -1.0f;
        this.zzblt = -1;
    }

    private final void zzjl() {
        if (this.zzblr != this.zzbln || this.zzbls != this.zzblo || this.zzblt != this.zzblp || this.zzblu != this.zzblq) {
            this.zzbkw.zza(this.zzbln, this.zzblo, this.zzblp, this.zzblq);
            this.zzblr = this.zzbln;
            this.zzbls = this.zzblo;
            this.zzblt = this.zzblp;
            this.zzblu = this.zzblq;
        }
    }

    private final void zzjm() {
        if (this.zzblr != -1 || this.zzbls != -1) {
            this.zzbkw.zza(this.zzbln, this.zzblo, this.zzblp, this.zzblq);
        }
    }

    private final void zzjn() {
        if (this.zzblj > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbkw.zze(this.zzblj, elapsedRealtime - this.zzbli);
            this.zzblj = 0;
            this.zzbli = elapsedRealtime;
        }
    }

    private static int zzi(zzhq zzhq) {
        if (zzhq.zzagx != -1) {
            return zzhq.zzagx;
        }
        return zza(zzhq.zzagw, zzhq.width, zzhq.height);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zza(String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (!(c == 0 || c == 1)) {
            if (c != 2) {
                if (c != 3) {
                    if (c != 4 && c != 5) {
                        return -1;
                    }
                    i3 = i * i2;
                    return (i3 * 3) / (i4 * 2);
                }
            } else if ("BRAVIA 4K 2015".equals(zzpo.MODEL)) {
                return -1;
            } else {
                i3 = ((zzpo.zzf(i, 16) * zzpo.zzf(i2, 16)) << 4) << 4;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            }
        }
        i3 = i * i2;
        i4 = 2;
        return (i3 * 3) / (i4 * 2);
    }

    private static boolean zza(boolean z, zzhq zzhq, zzhq zzhq2) {
        if (!zzhq.zzagw.equals(zzhq2.zzagw) || zzj(zzhq) != zzj(zzhq2)) {
            return false;
        }
        if (!z) {
            return zzhq.width == zzhq2.width && zzhq.height == zzhq2.height;
        }
        return true;
    }

    private static int zzj(zzhq zzhq) {
        if (zzhq.zzahb == -1) {
            return 0;
        }
        return zzhq.zzahb;
    }
}
