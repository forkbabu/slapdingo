package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.itextpdf.text.Annotation;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zziz extends zzls implements zzpf {
    private int zzahg;
    private int zzahi;
    /* access modifiers changed from: private */
    public final zzih zzame;
    private final zziq zzamf;
    private boolean zzamg;
    private boolean zzamh;
    private MediaFormat zzami;
    private long zzamj;
    /* access modifiers changed from: private */
    public boolean zzamk;

    public zziz(zzlu zzlu) {
        this(zzlu, null, true);
    }

    protected static void zzb(int i, long j, long j2) {
    }

    protected static void zzgc() {
    }

    protected static void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzhv, com.google.android.gms.internal.ads.zzha
    public final zzpf zzdz() {
        return this;
    }

    private zziz(zzlu zzlu, zzjq<zzjs> zzjq, boolean z) {
        this(zzlu, null, true, null, null);
    }

    private zziz(zzlu zzlu, zzjq<zzjs> zzjq, boolean z, Handler handler, zzii zzii) {
        this(zzlu, null, true, null, null, null, new zzig[0]);
    }

    private zziz(zzlu zzlu, zzjq<zzjs> zzjq, boolean z, Handler handler, zzii zzii, zzid zzid, zzig... zzigArr) {
        super(1, zzlu, zzjq, z);
        this.zzamf = new zziq(null, zzigArr, new zzjb(this));
        this.zzame = new zzih(null, null);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final int zza(zzlu zzlu, zzhq zzhq) throws zzma {
        String str = zzhq.zzagw;
        boolean z = false;
        if (!zzpe.zzbe(str)) {
            return 0;
        }
        int i = zzpo.SDK_INT >= 21 ? 16 : 0;
        int i2 = 3;
        if (zzaz(str) && zzlu.zzhi() != null) {
            return i | 4 | 3;
        }
        zzlt zzb = zzlu.zzb(str, false);
        if (zzb == null) {
            return 1;
        }
        if (zzpo.SDK_INT < 21 || ((zzhq.zzahh == -1 || zzb.zzax(zzhq.zzahh)) && (zzhq.zzahg == -1 || zzb.zzay(zzhq.zzahg)))) {
            z = true;
        }
        if (!z) {
            i2 = 2;
        }
        return i | 4 | i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final zzlt zza(zzlu zzlu, zzhq zzhq, boolean z) throws zzma {
        zzlt zzhi;
        if (!zzaz(zzhq.zzagw) || (zzhi = zzlu.zzhi()) == null) {
            this.zzamg = false;
            return super.zza(zzlu, zzhq, z);
        }
        this.zzamg = true;
        return zzhi;
    }

    private final boolean zzaz(String str) {
        return this.zzamf.zzax(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zza(zzlt zzlt, MediaCodec mediaCodec, zzhq zzhq, MediaCrypto mediaCrypto) {
        this.zzamh = zzpo.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzlt.name) && "samsung".equals(zzpo.MANUFACTURER) && (zzpo.DEVICE.startsWith("zeroflte") || zzpo.DEVICE.startsWith("herolte") || zzpo.DEVICE.startsWith("heroqlte"));
        if (this.zzamg) {
            MediaFormat zzez = zzhq.zzez();
            this.zzami = zzez;
            zzez.setString(Annotation.MIMETYPE, "audio/raw");
            mediaCodec.configure(this.zzami, (Surface) null, (MediaCrypto) null, 0);
            this.zzami.setString(Annotation.MIMETYPE, zzhq.zzagw);
            return;
        }
        mediaCodec.configure(zzhq.zzez(), (Surface) null, (MediaCrypto) null, 0);
        this.zzami = null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zzc(String str, long j, long j2) {
        this.zzame.zza(str, j, j2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zzd(zzhq zzhq) throws zzhb {
        super.zzd(zzhq);
        this.zzame.zzb(zzhq);
        this.zzahi = "audio/raw".equals(zzhq.zzagw) ? zzhq.zzahi : 2;
        this.zzahg = zzhq.zzahg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhb {
        int[] iArr;
        int i;
        boolean z = this.zzami != null;
        String string = z ? this.zzami.getString(Annotation.MIMETYPE) : "audio/raw";
        if (z) {
            mediaFormat = this.zzami;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzamh || integer != 6 || (i = this.zzahg) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzahg; i2++) {
                iArr[i2] = i2;
            }
        }
        try {
            this.zzamf.zza(string, integer, integer2, this.zzahi, 0, iArr);
        } catch (zziu e) {
            throw zzhb.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void zze(boolean z) throws zzhb {
        super.zze(z);
        this.zzame.zza(this.zzbci);
        int i = zzeh().zzahx;
        if (i != 0) {
            this.zzamf.zzy(i);
        } else {
            this.zzamf.zzfs();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void zza(long j, boolean z) throws zzhb {
        super.zza(j, z);
        this.zzamf.reset();
        this.zzamj = j;
        this.zzamk = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void onStarted() {
        super.onStarted();
        this.zzamf.play();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void onStopped() {
        this.zzamf.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzls
    public final void zzeg() {
        try {
            this.zzamf.release();
            try {
                super.zzeg();
            } finally {
                this.zzbci.zzgm();
                this.zzame.zzb(this.zzbci);
            }
        } catch (Throwable th) {
            super.zzeg();
            throw th;
        } finally {
            this.zzbci.zzgm();
            this.zzame.zzb(this.zzbci);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhv, com.google.android.gms.internal.ads.zzls
    public final boolean zzfd() {
        return super.zzfd() && this.zzamf.zzfd();
    }

    @Override // com.google.android.gms.internal.ads.zzhv, com.google.android.gms.internal.ads.zzls
    public final boolean isReady() {
        return this.zzamf.zzfq() || super.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final long zzgb() {
        long zzj = this.zzamf.zzj(zzfd());
        if (zzj != Long.MIN_VALUE) {
            if (!this.zzamk) {
                zzj = Math.max(this.zzamj, zzj);
            }
            this.zzamj = zzj;
            this.zzamk = false;
        }
        return this.zzamj;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final zzhw zzb(zzhw zzhw) {
        return this.zzamf.zzb(zzhw);
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final zzhw zzfr() {
        return this.zzamf.zzfr();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhb {
        if (this.zzamg && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbci.zzanw++;
            this.zzamf.zzfn();
            return true;
        } else {
            try {
                if (!this.zzamf.zzb(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.zzbci.zzanv++;
                return true;
            } catch (zzit | zziy e) {
                throw zzhb.zza(e, getIndex());
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzls
    public final void zzgd() throws zzhb {
        try {
            this.zzamf.zzfo();
        } catch (zziy e) {
            throw zzhb.zza(e, getIndex());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhg, com.google.android.gms.internal.ads.zzha
    public final void zza(int i, Object obj) throws zzhb {
        if (i == 2) {
            this.zzamf.setVolume(((Float) obj).floatValue());
        } else if (i != 3) {
            super.zza(i, obj);
        } else {
            this.zzamf.setStreamType(((Integer) obj).intValue());
        }
    }
}
