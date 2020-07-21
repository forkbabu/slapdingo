package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.itextpdf.text.html.HtmlTags;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzls extends zzha {
    private static final byte[] zzbay = zzpo.zzbl("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzhq zzahr;
    private ByteBuffer[] zzakz;
    private final zzlu zzbaz;
    private final zzjq<zzjs> zzbba;
    private final boolean zzbbb;
    private final zzjm zzbbc;
    private final zzjm zzbbd;
    private final zzhs zzbbe;
    private final List<Long> zzbbf;
    private final MediaCodec.BufferInfo zzbbg;
    private zzjo<zzjs> zzbbh;
    private zzjo<zzjs> zzbbi;
    private MediaCodec zzbbj;
    private zzlt zzbbk;
    private boolean zzbbl;
    private boolean zzbbm;
    private boolean zzbbn;
    private boolean zzbbo;
    private boolean zzbbp;
    private boolean zzbbq;
    private boolean zzbbr;
    private boolean zzbbs;
    private boolean zzbbt;
    private ByteBuffer[] zzbbu;
    private long zzbbv;
    private int zzbbw;
    private int zzbbx;
    private boolean zzbby;
    private boolean zzbbz;
    private int zzbca;
    private int zzbcb;
    private boolean zzbcc;
    private boolean zzbcd;
    private boolean zzbce;
    private boolean zzbcf;
    private boolean zzbcg;
    private boolean zzbch;
    protected zzjj zzbci;

    public zzls(int i, zzlu zzlu, zzjq<zzjs> zzjq, boolean z) {
        super(i);
        zzpb.checkState(zzpo.SDK_INT >= 16);
        this.zzbaz = (zzlu) zzpb.checkNotNull(zzlu);
        this.zzbba = zzjq;
        this.zzbbb = z;
        this.zzbbc = new zzjm(0);
        this.zzbbd = new zzjm(0);
        this.zzbbe = new zzhs();
        this.zzbbf = new ArrayList();
        this.zzbbg = new MediaCodec.BufferInfo();
        this.zzbca = 0;
        this.zzbcb = 0;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhb {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract int zza(zzlu zzlu, zzhq zzhq) throws zzma;

    /* access modifiers changed from: protected */
    public void zza(zzjm zzjm) {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzlt zzlt, MediaCodec mediaCodec, zzhq zzhq, MediaCrypto mediaCrypto) throws zzma;

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhb;

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzhq zzhq, zzhq zzhq2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzlt zzlt) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void zzc(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzha, com.google.android.gms.internal.ads.zzhy
    public final int zzef() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzgd() throws zzhb {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int zza(zzhq zzhq) throws zzhb {
        try {
            return zza(this.zzbaz, zzhq);
        } catch (zzma e) {
            throw zzhb.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public zzlt zza(zzlu zzlu, zzhq zzhq, boolean z) throws zzma {
        return zzlu.zzb(zzhq.zzagw, z);
    }

    /* access modifiers changed from: protected */
    public final void zzhb() throws zzhb {
        zzhq zzhq;
        if (this.zzbbj == null && (zzhq = this.zzahr) != null) {
            this.zzbbh = this.zzbbi;
            String str = zzhq.zzagw;
            zzjo<zzjs> zzjo = this.zzbbh;
            if (zzjo != null) {
                int state = zzjo.getState();
                if (state == 0) {
                    throw zzhb.zza(this.zzbbh.zzgo(), getIndex());
                } else if (state == 3 || state == 4) {
                    this.zzbbh.zzgn();
                    throw new NoSuchMethodError();
                }
            } else {
                if (this.zzbbk == null) {
                    try {
                        this.zzbbk = zza(this.zzbaz, this.zzahr, false);
                    } catch (zzma e) {
                        zza(new zzlv(this.zzahr, (Throwable) e, false, -49998));
                    }
                    if (this.zzbbk == null) {
                        zza(new zzlv(this.zzahr, (Throwable) null, false, -49999));
                    }
                }
                if (zza(this.zzbbk)) {
                    String str2 = this.zzbbk.name;
                    this.zzbbl = zzpo.SDK_INT < 21 && this.zzahr.zzagy.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                    this.zzbbm = zzpo.SDK_INT < 18 || (zzpo.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzpo.SDK_INT == 19 && zzpo.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                    this.zzbbn = zzpo.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzpo.DEVICE) || "flounder_lte".equals(zzpo.DEVICE) || "grouper".equals(zzpo.DEVICE) || "tilapia".equals(zzpo.DEVICE));
                    this.zzbbo = zzpo.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                    this.zzbbp = (zzpo.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzpo.SDK_INT <= 19 && "hb2000".equals(zzpo.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                    this.zzbbq = zzpo.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
                    this.zzbbr = zzpo.SDK_INT <= 18 && this.zzahr.zzahg == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        String valueOf = String.valueOf(str2);
                        zzpp.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                        this.zzbbj = MediaCodec.createByCodecName(str2);
                        zzpp.endSection();
                        zzpp.beginSection("configureCodec");
                        zza(this.zzbbk, this.zzbbj, this.zzahr, (MediaCrypto) null);
                        zzpp.endSection();
                        zzpp.beginSection("startCodec");
                        this.zzbbj.start();
                        zzpp.endSection();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        zzc(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.zzbbu = this.zzbbj.getInputBuffers();
                        this.zzakz = this.zzbbj.getOutputBuffers();
                    } catch (Exception e2) {
                        zza(new zzlv(this.zzahr, (Throwable) e2, false, str2));
                    }
                    this.zzbbv = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.zzbbw = -1;
                    this.zzbbx = -1;
                    this.zzbch = true;
                    this.zzbci.zzans++;
                }
            }
        }
    }

    private final void zza(zzlv zzlv) throws zzhb {
        throw zzhb.zza(zzlv, getIndex());
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzhc() {
        return this.zzbbj;
    }

    /* access modifiers changed from: protected */
    public final zzlt zzhd() {
        return this.zzbbk;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha
    public void zze(boolean z) throws zzhb {
        this.zzbci = new zzjj();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha
    public void zza(long j, boolean z) throws zzhb {
        this.zzbce = false;
        this.zzbcf = false;
        if (this.zzbbj != null) {
            this.zzbbv = -9223372036854775807L;
            this.zzbbw = -1;
            this.zzbbx = -1;
            this.zzbch = true;
            this.zzbcg = false;
            this.zzbby = false;
            this.zzbbf.clear();
            this.zzbbs = false;
            this.zzbbt = false;
            if (this.zzbbm || (this.zzbbp && this.zzbcd)) {
                zzhe();
                zzhb();
            } else if (this.zzbcb != 0) {
                zzhe();
                zzhb();
            } else {
                this.zzbbj.flush();
                this.zzbcc = false;
            }
            if (this.zzbbz && this.zzahr != null) {
                this.zzbca = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzha
    public void zzeg() {
        this.zzahr = null;
        try {
            zzhe();
            try {
                if (this.zzbbh != null) {
                    this.zzbba.zza(this.zzbbh);
                }
                try {
                    if (!(this.zzbbi == null || this.zzbbi == this.zzbbh)) {
                        this.zzbba.zza(this.zzbbi);
                    }
                } finally {
                    this.zzbbh = null;
                    this.zzbbi = null;
                }
            } catch (Throwable th) {
                if (!(this.zzbbi == null || this.zzbbi == this.zzbbh)) {
                    this.zzbba.zza(this.zzbbi);
                }
                throw th;
            } finally {
                this.zzbbh = null;
                this.zzbbi = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.zzbbi == null || this.zzbbi == this.zzbbh)) {
                    this.zzbba.zza(this.zzbbi);
                }
                throw th2;
            } finally {
                this.zzbbh = null;
                this.zzbbi = null;
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void zzhe() {
        this.zzbbv = -9223372036854775807L;
        this.zzbbw = -1;
        this.zzbbx = -1;
        this.zzbcg = false;
        this.zzbby = false;
        this.zzbbf.clear();
        this.zzbbu = null;
        this.zzakz = null;
        this.zzbbk = null;
        this.zzbbz = false;
        this.zzbcc = false;
        this.zzbbl = false;
        this.zzbbm = false;
        this.zzbbn = false;
        this.zzbbo = false;
        this.zzbbp = false;
        this.zzbbr = false;
        this.zzbbs = false;
        this.zzbbt = false;
        this.zzbcd = false;
        this.zzbca = 0;
        this.zzbcb = 0;
        this.zzbbc.zzdd = null;
        if (this.zzbbj != null) {
            this.zzbci.zzant++;
            try {
                this.zzbbj.stop();
                try {
                    this.zzbbj.release();
                    this.zzbbj = null;
                    zzjo<zzjs> zzjo = this.zzbbh;
                    if (zzjo != null && this.zzbbi != zzjo) {
                        try {
                            this.zzbba.zza(zzjo);
                        } finally {
                            this.zzbbh = null;
                        }
                    }
                } catch (Throwable th) {
                    this.zzbbj = null;
                    zzjo<zzjs> zzjo2 = this.zzbbh;
                    if (!(zzjo2 == null || this.zzbbi == zzjo2)) {
                        this.zzbba.zza(zzjo2);
                    }
                    throw th;
                } finally {
                    this.zzbbh = null;
                }
            } catch (Throwable th2) {
                this.zzbbj = null;
                zzjo<zzjs> zzjo3 = this.zzbbh;
                if (!(zzjo3 == null || this.zzbbi == zzjo3)) {
                    try {
                        this.zzbba.zza(zzjo3);
                    } finally {
                        this.zzbbh = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public final void zzb(long j, long j2) throws zzhb {
        if (this.zzbcf) {
            zzgd();
            return;
        }
        if (this.zzahr == null) {
            this.zzbbd.clear();
            int zza = zza(this.zzbbe, this.zzbbd, true);
            if (zza == -5) {
                zzd(this.zzbbe.zzahr);
            } else if (zza == -4) {
                zzpb.checkState(this.zzbbd.zzgh());
                this.zzbce = true;
                zzhg();
                return;
            } else {
                return;
            }
        }
        zzhb();
        if (this.zzbbj != null) {
            zzpp.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzhf());
            zzpp.endSection();
        } else {
            zzdn(j);
            this.zzbbd.clear();
            int zza2 = zza(this.zzbbe, this.zzbbd, false);
            if (zza2 == -5) {
                zzd(this.zzbbe.zzahr);
            } else if (zza2 == -4) {
                zzpb.checkState(this.zzbbd.zzgh());
                this.zzbce = true;
                zzhg();
            }
        }
        this.zzbci.zzgm();
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0149 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzhf() throws com.google.android.gms.internal.ads.zzhb {
        /*
            r14 = this;
            android.media.MediaCodec r0 = r14.zzbbj
            r1 = 0
            if (r0 == 0) goto L_0x01d4
            int r2 = r14.zzbcb
            r3 = 2
            if (r2 == r3) goto L_0x01d4
            boolean r2 = r14.zzbce
            if (r2 == 0) goto L_0x0010
            goto L_0x01d4
        L_0x0010:
            int r2 = r14.zzbbw
            if (r2 >= 0) goto L_0x002c
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r14.zzbbw = r0
            if (r0 >= 0) goto L_0x001f
            return r1
        L_0x001f:
            com.google.android.gms.internal.ads.zzjm r2 = r14.zzbbc
            java.nio.ByteBuffer[] r4 = r14.zzbbu
            r0 = r4[r0]
            r2.zzdd = r0
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            r0.clear()
        L_0x002c:
            int r0 = r14.zzbcb
            r2 = -1
            r4 = 1
            if (r0 != r4) goto L_0x0049
            boolean r0 = r14.zzbbo
            if (r0 != 0) goto L_0x0046
            r14.zzbcd = r4
            android.media.MediaCodec r5 = r14.zzbbj
            int r6 = r14.zzbbw
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzbbw = r2
        L_0x0046:
            r14.zzbcb = r3
            return r1
        L_0x0049:
            boolean r0 = r14.zzbbs
            if (r0 == 0) goto L_0x006b
            r14.zzbbs = r1
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            java.nio.ByteBuffer r0 = r0.zzdd
            byte[] r1 = com.google.android.gms.internal.ads.zzls.zzbay
            r0.put(r1)
            android.media.MediaCodec r5 = r14.zzbbj
            int r6 = r14.zzbbw
            r7 = 0
            byte[] r0 = com.google.android.gms.internal.ads.zzls.zzbay
            int r8 = r0.length
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzbbw = r2
            r14.zzbcc = r4
            return r4
        L_0x006b:
            boolean r0 = r14.zzbcg
            if (r0 == 0) goto L_0x0072
            r0 = -4
            r5 = 0
            goto L_0x00aa
        L_0x0072:
            int r0 = r14.zzbca
            if (r0 != r4) goto L_0x0097
            r0 = 0
        L_0x0077:
            com.google.android.gms.internal.ads.zzhq r5 = r14.zzahr
            java.util.List<byte[]> r5 = r5.zzagy
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x0095
            com.google.android.gms.internal.ads.zzhq r5 = r14.zzahr
            java.util.List<byte[]> r5 = r5.zzagy
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.google.android.gms.internal.ads.zzjm r6 = r14.zzbbc
            java.nio.ByteBuffer r6 = r6.zzdd
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x0077
        L_0x0095:
            r14.zzbca = r3
        L_0x0097:
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            java.nio.ByteBuffer r0 = r0.zzdd
            int r0 = r0.position()
            com.google.android.gms.internal.ads.zzhs r5 = r14.zzbbe
            com.google.android.gms.internal.ads.zzjm r6 = r14.zzbbc
            int r5 = r14.zza(r5, r6, r1)
            r13 = r5
            r5 = r0
            r0 = r13
        L_0x00aa:
            r6 = -3
            if (r0 != r6) goto L_0x00ae
            return r1
        L_0x00ae:
            r6 = -5
            if (r0 != r6) goto L_0x00c4
            int r0 = r14.zzbca
            if (r0 != r3) goto L_0x00bc
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            r0.clear()
            r14.zzbca = r4
        L_0x00bc:
            com.google.android.gms.internal.ads.zzhs r0 = r14.zzbbe
            com.google.android.gms.internal.ads.zzhq r0 = r0.zzahr
            r14.zzd(r0)
            return r4
        L_0x00c4:
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            boolean r0 = r0.zzgh()
            if (r0 == 0) goto L_0x0100
            int r0 = r14.zzbca
            if (r0 != r3) goto L_0x00d7
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            r0.clear()
            r14.zzbca = r4
        L_0x00d7:
            r14.zzbce = r4
            boolean r0 = r14.zzbcc
            if (r0 != 0) goto L_0x00e1
            r14.zzhg()
            return r1
        L_0x00e1:
            boolean r0 = r14.zzbbo     // Catch:{ CryptoException -> 0x00f6 }
            if (r0 != 0) goto L_0x00f5
            r14.zzbcd = r4     // Catch:{ CryptoException -> 0x00f6 }
            android.media.MediaCodec r5 = r14.zzbbj     // Catch:{ CryptoException -> 0x00f6 }
            int r6 = r14.zzbbw     // Catch:{ CryptoException -> 0x00f6 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00f6 }
            r14.zzbbw = r2     // Catch:{ CryptoException -> 0x00f6 }
        L_0x00f5:
            return r1
        L_0x00f6:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhb r0 = com.google.android.gms.internal.ads.zzhb.zza(r0, r1)
            throw r0
        L_0x0100:
            boolean r0 = r14.zzbch
            if (r0 == 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            boolean r0 = r0.zzgi()
            if (r0 != 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            r0.clear()
            int r0 = r14.zzbca
            if (r0 != r3) goto L_0x0117
            r14.zzbca = r4
        L_0x0117:
            return r4
        L_0x0118:
            r14.zzbch = r1
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc
            boolean r0 = r0.isEncrypted()
            com.google.android.gms.internal.ads.zzjo<com.google.android.gms.internal.ads.zzjs> r3 = r14.zzbbh
            if (r3 == 0) goto L_0x0144
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x0135
            r6 = 4
            if (r3 == r6) goto L_0x0144
            if (r0 != 0) goto L_0x0133
            boolean r3 = r14.zzbbb
            if (r3 != 0) goto L_0x0144
        L_0x0133:
            r3 = 1
            goto L_0x0145
        L_0x0135:
            com.google.android.gms.internal.ads.zzjo<com.google.android.gms.internal.ads.zzjs> r0 = r14.zzbbh
            com.google.android.gms.internal.ads.zzjr r0 = r0.zzgo()
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhb r0 = com.google.android.gms.internal.ads.zzhb.zza(r0, r1)
            throw r0
        L_0x0144:
            r3 = 0
        L_0x0145:
            r14.zzbcg = r3
            if (r3 == 0) goto L_0x014a
            return r1
        L_0x014a:
            boolean r3 = r14.zzbbl
            if (r3 == 0) goto L_0x0164
            if (r0 != 0) goto L_0x0164
            com.google.android.gms.internal.ads.zzjm r3 = r14.zzbbc
            java.nio.ByteBuffer r3 = r3.zzdd
            com.google.android.gms.internal.ads.zzph.zzp(r3)
            com.google.android.gms.internal.ads.zzjm r3 = r14.zzbbc
            java.nio.ByteBuffer r3 = r3.zzdd
            int r3 = r3.position()
            if (r3 != 0) goto L_0x0162
            return r4
        L_0x0162:
            r14.zzbbl = r1
        L_0x0164:
            com.google.android.gms.internal.ads.zzjm r3 = r14.zzbbc     // Catch:{ CryptoException -> 0x01ca }
            long r10 = r3.zzaod     // Catch:{ CryptoException -> 0x01ca }
            com.google.android.gms.internal.ads.zzjm r3 = r14.zzbbc     // Catch:{ CryptoException -> 0x01ca }
            boolean r3 = r3.zzgg()     // Catch:{ CryptoException -> 0x01ca }
            if (r3 == 0) goto L_0x0179
            java.util.List<java.lang.Long> r3 = r14.zzbbf     // Catch:{ CryptoException -> 0x01ca }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01ca }
            r3.add(r6)     // Catch:{ CryptoException -> 0x01ca }
        L_0x0179:
            com.google.android.gms.internal.ads.zzjm r3 = r14.zzbbc     // Catch:{ CryptoException -> 0x01ca }
            java.nio.ByteBuffer r3 = r3.zzdd     // Catch:{ CryptoException -> 0x01ca }
            r3.flip()     // Catch:{ CryptoException -> 0x01ca }
            com.google.android.gms.internal.ads.zzjm r3 = r14.zzbbc     // Catch:{ CryptoException -> 0x01ca }
            r14.zza(r3)     // Catch:{ CryptoException -> 0x01ca }
            if (r0 == 0) goto L_0x01ab
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc     // Catch:{ CryptoException -> 0x01ca }
            com.google.android.gms.internal.ads.zzji r0 = r0.zzaoc     // Catch:{ CryptoException -> 0x01ca }
            android.media.MediaCodec$CryptoInfo r9 = r0.zzgl()     // Catch:{ CryptoException -> 0x01ca }
            if (r5 != 0) goto L_0x0192
            goto L_0x01a1
        L_0x0192:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01ca }
            if (r0 != 0) goto L_0x019a
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01ca }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01ca }
        L_0x019a:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01ca }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01ca }
            int r3 = r3 + r5
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01ca }
        L_0x01a1:
            android.media.MediaCodec r6 = r14.zzbbj     // Catch:{ CryptoException -> 0x01ca }
            int r7 = r14.zzbbw     // Catch:{ CryptoException -> 0x01ca }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01ca }
            goto L_0x01bc
        L_0x01ab:
            android.media.MediaCodec r6 = r14.zzbbj     // Catch:{ CryptoException -> 0x01ca }
            int r7 = r14.zzbbw     // Catch:{ CryptoException -> 0x01ca }
            r8 = 0
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbbc     // Catch:{ CryptoException -> 0x01ca }
            java.nio.ByteBuffer r0 = r0.zzdd     // Catch:{ CryptoException -> 0x01ca }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01ca }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01ca }
        L_0x01bc:
            r14.zzbbw = r2     // Catch:{ CryptoException -> 0x01ca }
            r14.zzbcc = r4     // Catch:{ CryptoException -> 0x01ca }
            r14.zzbca = r1     // Catch:{ CryptoException -> 0x01ca }
            com.google.android.gms.internal.ads.zzjj r0 = r14.zzbci     // Catch:{ CryptoException -> 0x01ca }
            int r1 = r0.zzanu     // Catch:{ CryptoException -> 0x01ca }
            int r1 = r1 + r4
            r0.zzanu = r1     // Catch:{ CryptoException -> 0x01ca }
            return r4
        L_0x01ca:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhb r0 = com.google.android.gms.internal.ads.zzhb.zza(r0, r1)
            throw r0
        L_0x01d4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzls.zzhf():boolean");
    }

    /* access modifiers changed from: protected */
    public void zzd(zzhq zzhq) throws zzhb {
        zzjl zzjl;
        MediaCodec mediaCodec;
        zzhq zzhq2 = this.zzahr;
        this.zzahr = zzhq;
        zzjl zzjl2 = zzhq.zzagz;
        if (zzhq2 == null) {
            zzjl = null;
        } else {
            zzjl = zzhq2.zzagz;
        }
        boolean zza = zzpo.zza(zzjl2, zzjl);
        boolean z = true;
        if (!zza) {
            if (this.zzahr.zzagz != null) {
                zzjq<zzjs> zzjq = this.zzbba;
                if (zzjq != null) {
                    zzjo<zzjs> zza2 = zzjq.zza(Looper.myLooper(), this.zzahr.zzagz);
                    this.zzbbi = zza2;
                    if (zza2 == this.zzbbh) {
                        this.zzbba.zza(zza2);
                    }
                } else {
                    throw zzhb.zza(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
            } else {
                this.zzbbi = null;
            }
        }
        if (this.zzbbi == this.zzbbh && (mediaCodec = this.zzbbj) != null && zza(mediaCodec, this.zzbbk.zzbcj, zzhq2, this.zzahr)) {
            this.zzbbz = true;
            this.zzbca = 1;
            if (!(this.zzbbn && this.zzahr.width == zzhq2.width && this.zzahr.height == zzhq2.height)) {
                z = false;
            }
            this.zzbbs = z;
        } else if (this.zzbcc) {
            this.zzbcb = 1;
        } else {
            zzhe();
            zzhb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public boolean zzfd() {
        return this.zzbcf;
    }

    @Override // com.google.android.gms.internal.ads.zzhv
    public boolean isReady() {
        if (this.zzahr == null || this.zzbcg) {
            return false;
        }
        if (zzei() || this.zzbbx >= 0) {
            return true;
        }
        return this.zzbbv != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzbbv;
    }

    private final boolean zzd(long j, long j2) throws zzhb {
        boolean z;
        boolean z2;
        if (this.zzbbx < 0) {
            if (!this.zzbbq || !this.zzbcd) {
                this.zzbbx = this.zzbbj.dequeueOutputBuffer(this.zzbbg, 0);
            } else {
                try {
                    this.zzbbx = this.zzbbj.dequeueOutputBuffer(this.zzbbg, 0);
                } catch (IllegalStateException unused) {
                    zzhg();
                    if (this.zzbcf) {
                        zzhe();
                    }
                    return false;
                }
            }
            int i = this.zzbbx;
            if (i >= 0) {
                if (this.zzbbt) {
                    this.zzbbt = false;
                    this.zzbbj.releaseOutputBuffer(i, false);
                    this.zzbbx = -1;
                    return true;
                } else if ((this.zzbbg.flags & 4) != 0) {
                    zzhg();
                    this.zzbbx = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.zzakz[this.zzbbx];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.zzbbg.offset);
                        byteBuffer.limit(this.zzbbg.offset + this.zzbbg.size);
                    }
                    long j3 = this.zzbbg.presentationTimeUs;
                    int size = this.zzbbf.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z2 = false;
                            break;
                        } else if (this.zzbbf.get(i2).longValue() == j3) {
                            this.zzbbf.remove(i2);
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.zzbby = z2;
                }
            } else if (i == -2) {
                MediaFormat outputFormat = this.zzbbj.getOutputFormat();
                if (this.zzbbn && outputFormat.getInteger(HtmlTags.WIDTH) == 32 && outputFormat.getInteger(HtmlTags.HEIGHT) == 32) {
                    this.zzbbt = true;
                } else {
                    if (this.zzbbr) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzbbj, outputFormat);
                }
                return true;
            } else if (i == -3) {
                this.zzakz = this.zzbbj.getOutputBuffers();
                return true;
            } else {
                if (this.zzbbo && (this.zzbce || this.zzbcb == 2)) {
                    zzhg();
                }
                return false;
            }
        }
        if (!this.zzbbq || !this.zzbcd) {
            MediaCodec mediaCodec = this.zzbbj;
            ByteBuffer[] byteBufferArr = this.zzakz;
            int i3 = this.zzbbx;
            z = zza(j, j2, mediaCodec, byteBufferArr[i3], i3, this.zzbbg.flags, this.zzbbg.presentationTimeUs, this.zzbby);
        } else {
            try {
                z = zza(j, j2, this.zzbbj, this.zzakz[this.zzbbx], this.zzbbx, this.zzbbg.flags, this.zzbbg.presentationTimeUs, this.zzbby);
            } catch (IllegalStateException unused2) {
                zzhg();
                if (this.zzbcf) {
                    zzhe();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.zzbbg.presentationTimeUs;
        this.zzbbx = -1;
        return true;
    }

    private final void zzhg() throws zzhb {
        if (this.zzbcb == 2) {
            zzhe();
            zzhb();
            return;
        }
        this.zzbcf = true;
        zzgd();
    }
}
