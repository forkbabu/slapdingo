package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zziq {
    private static boolean zzajj = false;
    private static boolean zzajk = false;
    private int streamType;
    private zzhw zzaez;
    private int zzahh;
    private final zzid zzajl = null;
    private final zzix zzajm;
    private final zzjg zzajn;
    private final zzig[] zzajo;
    private final zziw zzajp;
    /* access modifiers changed from: private */
    public final ConditionVariable zzajq;
    private final long[] zzajr;
    private final zzis zzajs;
    private final LinkedList<zziv> zzajt;
    private AudioTrack zzaju;
    private int zzajv;
    private int zzajw;
    private int zzajx;
    private boolean zzajy;
    private int zzajz;
    private long zzaka;
    private zzhw zzakb;
    private long zzakc;
    private long zzakd;
    private ByteBuffer zzake;
    private int zzakf;
    private int zzakg;
    private int zzakh;
    private long zzaki;
    private long zzakj;
    private boolean zzakk;
    private long zzakl;
    private Method zzakm;
    private int zzakn;
    private long zzako;
    private long zzakp;
    private int zzakq;
    private long zzakr;
    private long zzaks;
    private int zzakt;
    private int zzaku;
    private long zzakv;
    private long zzakw;
    private long zzakx;
    private zzig[] zzaky;
    private ByteBuffer[] zzakz;
    private ByteBuffer zzala;
    private ByteBuffer zzalb;
    private byte[] zzalc;
    private int zzald;
    private int zzale;
    private boolean zzalf;
    private boolean zzalg;
    private int zzalh;
    private boolean zzali;
    private boolean zzalj;
    private long zzalk;
    private float zzdj;

    public zziq(zzid zzid, zzig[] zzigArr, zziw zziw) {
        this.zzajp = zziw;
        this.zzajq = new ConditionVariable(true);
        if (zzpo.SDK_INT >= 18) {
            try {
                this.zzakm = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpo.SDK_INT >= 19) {
            this.zzajs = new zzir();
        } else {
            this.zzajs = new zzis(null);
        }
        this.zzajm = new zzix();
        this.zzajn = new zzjg();
        zzig[] zzigArr2 = new zzig[(zzigArr.length + 3)];
        this.zzajo = zzigArr2;
        zzigArr2[0] = new zzje();
        zzig[] zzigArr3 = this.zzajo;
        zzigArr3[1] = this.zzajm;
        System.arraycopy(zzigArr, 0, zzigArr3, 2, zzigArr.length);
        this.zzajo[zzigArr.length + 2] = this.zzajn;
        this.zzajr = new long[10];
        this.zzdj = 1.0f;
        this.zzaku = 0;
        this.streamType = 3;
        this.zzalh = 0;
        this.zzaez = zzhw.zzahs;
        this.zzale = -1;
        this.zzaky = new zzig[0];
        this.zzakz = new ByteBuffer[0];
        this.zzajt = new LinkedList<>();
    }

    public final boolean zzax(String str) {
        zzid zzid = this.zzajl;
        return zzid != null && zzid.zzv(zzay(str));
    }

    public final long zzj(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (!(isInitialized() && this.zzaku != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzaju.getPlayState() == 3) {
            long zzgb = this.zzajs.zzgb();
            if (zzgb != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzakj >= 30000) {
                    long[] jArr = this.zzajr;
                    int i = this.zzakg;
                    jArr[i] = zzgb - nanoTime;
                    this.zzakg = (i + 1) % 10;
                    int i2 = this.zzakh;
                    if (i2 < 10) {
                        this.zzakh = i2 + 1;
                    }
                    this.zzakj = nanoTime;
                    this.zzaki = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzakh;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzaki += this.zzajr[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzfw() && nanoTime - this.zzakl >= 500000) {
                    boolean zzfx = this.zzajs.zzfx();
                    this.zzakk = zzfx;
                    if (zzfx) {
                        long zzfy = this.zzajs.zzfy() / 1000;
                        long zzfz = this.zzajs.zzfz();
                        if (zzfy < this.zzakw) {
                            this.zzakk = false;
                        } else if (Math.abs(zzfy - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(zzfz);
                            sb.append(", ");
                            sb.append(zzfy);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zzgb);
                            Log.w("AudioTrack", sb.toString());
                            this.zzakk = false;
                        } else if (Math.abs(zzdw(zzfz) - zzgb) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(zzfz);
                            sb2.append(", ");
                            sb2.append(zzfy);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(zzgb);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzakk = false;
                        }
                    }
                    Method method = this.zzakm;
                    if (method != null && !this.zzajy) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.zzaju, null)).intValue()) * 1000) - this.zzaka;
                            this.zzakx = intValue;
                            long max = Math.max(intValue, 0L);
                            this.zzakx = max;
                            if (max > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(max);
                                Log.w("AudioTrack", sb3.toString());
                                this.zzakx = 0;
                            }
                        } catch (Exception unused) {
                            this.zzakm = null;
                        }
                    }
                    this.zzakl = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzakk) {
            j = zzdw(this.zzajs.zzfz() + zzdx(nanoTime2 - (this.zzajs.zzfy() / 1000)));
        } else {
            if (this.zzakh == 0) {
                j = this.zzajs.zzgb();
            } else {
                j = nanoTime2 + this.zzaki;
            }
            if (!z) {
                j -= this.zzakx;
            }
        }
        long j5 = this.zzakv;
        while (!this.zzajt.isEmpty() && j >= this.zzajt.getFirst().zzagb) {
            zziv remove = this.zzajt.remove();
            this.zzaez = remove.zzaez;
            this.zzakd = remove.zzagb;
            this.zzakc = remove.zzalx - this.zzakv;
        }
        if (this.zzaez.zzaht == 1.0f) {
            j2 = (j + this.zzakc) - this.zzakd;
        } else {
            if (!this.zzajt.isEmpty() || this.zzajn.zzgk() < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                j3 = this.zzakc;
                j4 = (long) (((double) this.zzaez.zzaht) * ((double) (j - this.zzakd)));
            } else {
                j3 = this.zzakc;
                j4 = zzpo.zza(j - this.zzakd, this.zzajn.zzgj(), this.zzajn.zzgk());
            }
            j2 = j4 + j3;
        }
        return j5 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zziu {
        /*
            r7 = this;
            java.lang.String r12 = "audio/raw"
            boolean r12 = r12.equals(r8)
            r0 = 1
            r12 = r12 ^ r0
            if (r12 == 0) goto L_0x000f
            int r8 = zzay(r8)
            goto L_0x0010
        L_0x000f:
            r8 = r11
        L_0x0010:
            r1 = 0
            if (r12 != 0) goto L_0x004a
            int r11 = com.google.android.gms.internal.ads.zzpo.zzg(r11, r9)
            r7.zzakn = r11
            com.google.android.gms.internal.ads.zzix r11 = r7.zzajm
            r11.zzb(r13)
            com.google.android.gms.internal.ads.zzig[] r11 = r7.zzajo
            int r13 = r11.length
            r2 = 0
            r3 = 0
        L_0x0023:
            if (r2 >= r13) goto L_0x0044
            r4 = r11[r2]
            boolean r5 = r4.zzb(r10, r9, r8)     // Catch:{ zzif -> 0x003d }
            r3 = r3 | r5
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x003a
            int r9 = r4.zzfi()
            int r8 = r4.zzfj()
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0023
        L_0x003d:
            r8 = move-exception
            com.google.android.gms.internal.ads.zziu r9 = new com.google.android.gms.internal.ads.zziu
            r9.<init>(r8)
            throw r9
        L_0x0044:
            if (r3 == 0) goto L_0x004b
            r7.zzfm()
            goto L_0x004b
        L_0x004a:
            r3 = 0
        L_0x004b:
            r11 = 252(0xfc, float:3.53E-43)
            r13 = 12
            switch(r9) {
                case 1: goto L_0x0080;
                case 2: goto L_0x007d;
                case 3: goto L_0x007a;
                case 4: goto L_0x0077;
                case 5: goto L_0x0074;
                case 6: goto L_0x0071;
                case 7: goto L_0x006e;
                case 8: goto L_0x006b;
                default: goto L_0x0052;
            }
        L_0x0052:
            com.google.android.gms.internal.ads.zziu r8 = new com.google.android.gms.internal.ads.zziu
            r10 = 38
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            java.lang.String r10 = "Unsupported channel count: "
            r11.append(r10)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r8.<init>(r9)
            throw r8
        L_0x006b:
            int r2 = com.google.android.gms.internal.ads.zzhc.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x0081
        L_0x006e:
            r2 = 1276(0x4fc, float:1.788E-42)
            goto L_0x0081
        L_0x0071:
            r2 = 252(0xfc, float:3.53E-43)
            goto L_0x0081
        L_0x0074:
            r2 = 220(0xdc, float:3.08E-43)
            goto L_0x0081
        L_0x0077:
            r2 = 204(0xcc, float:2.86E-43)
            goto L_0x0081
        L_0x007a:
            r2 = 28
            goto L_0x0081
        L_0x007d:
            r2 = 12
            goto L_0x0081
        L_0x0080:
            r2 = 4
        L_0x0081:
            int r4 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            r5 = 23
            r6 = 5
            if (r4 > r5) goto L_0x00a8
            java.lang.String r4 = com.google.android.gms.internal.ads.zzpo.DEVICE
            java.lang.String r5 = "foster"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00a8
            java.lang.String r4 = com.google.android.gms.internal.ads.zzpo.MANUFACTURER
            java.lang.String r5 = "NVIDIA"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00a8
            r4 = 3
            if (r9 == r4) goto L_0x00a9
            if (r9 == r6) goto L_0x00a9
            r11 = 7
            if (r9 == r11) goto L_0x00a5
            goto L_0x00a8
        L_0x00a5:
            int r11 = com.google.android.gms.internal.ads.zzhc.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00a9
        L_0x00a8:
            r11 = r2
        L_0x00a9:
            int r2 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            r4 = 25
            if (r2 > r4) goto L_0x00be
            java.lang.String r2 = com.google.android.gms.internal.ads.zzpo.DEVICE
            java.lang.String r4 = "fugu"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x00be
            if (r12 == 0) goto L_0x00be
            if (r9 != r0) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r13 = r11
        L_0x00bf:
            if (r3 != 0) goto L_0x00d4
            boolean r11 = r7.isInitialized()
            if (r11 == 0) goto L_0x00d4
            int r11 = r7.zzajw
            if (r11 != r8) goto L_0x00d4
            int r11 = r7.zzahh
            if (r11 != r10) goto L_0x00d4
            int r11 = r7.zzajv
            if (r11 != r13) goto L_0x00d4
            return
        L_0x00d4:
            r7.reset()
            r7.zzajw = r8
            r7.zzajy = r12
            r7.zzahh = r10
            r7.zzajv = r13
            r11 = 2
            if (r12 == 0) goto L_0x00e3
            goto L_0x00e4
        L_0x00e3:
            r8 = 2
        L_0x00e4:
            r7.zzajx = r8
            int r8 = com.google.android.gms.internal.ads.zzpo.zzg(r11, r9)
            r7.zzakq = r8
            if (r12 == 0) goto L_0x00fd
            int r8 = r7.zzajx
            if (r8 == r6) goto L_0x00fa
            r9 = 6
            if (r8 != r9) goto L_0x00f6
            goto L_0x00fa
        L_0x00f6:
            r8 = 49152(0xc000, float:6.8877E-41)
            goto L_0x0133
        L_0x00fa:
            r8 = 20480(0x5000, float:2.8699E-41)
            goto L_0x0133
        L_0x00fd:
            int r8 = r7.zzajx
            int r8 = android.media.AudioTrack.getMinBufferSize(r10, r13, r8)
            r9 = -2
            if (r8 == r9) goto L_0x0107
            goto L_0x0108
        L_0x0107:
            r0 = 0
        L_0x0108:
            com.google.android.gms.internal.ads.zzpb.checkState(r0)
            int r9 = r8 << 2
            r10 = 250000(0x3d090, double:1.235164E-318)
            long r10 = r7.zzdx(r10)
            int r11 = (int) r10
            int r10 = r7.zzakq
            int r10 = r10 * r11
            long r0 = (long) r8
            r2 = 750000(0xb71b0, double:3.70549E-318)
            long r2 = r7.zzdx(r2)
            int r8 = r7.zzakq
            long r4 = (long) r8
            long r2 = r2 * r4
            long r0 = java.lang.Math.max(r0, r2)
            int r8 = (int) r0
            if (r9 >= r10) goto L_0x012f
            r8 = r10
            goto L_0x0133
        L_0x012f:
            if (r9 <= r8) goto L_0x0132
            goto L_0x0133
        L_0x0132:
            r8 = r9
        L_0x0133:
            r7.zzajz = r8
            if (r12 == 0) goto L_0x013d
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0145
        L_0x013d:
            int r9 = r7.zzakq
            int r8 = r8 / r9
            long r8 = (long) r8
            long r8 = r7.zzdw(r8)
        L_0x0145:
            r7.zzaka = r8
            com.google.android.gms.internal.ads.zzhw r8 = r7.zzaez
            r7.zzb(r8)
            return
            switch-data {1->0x0080, 2->0x007d, 3->0x007a, 4->0x0077, 5->0x0074, 6->0x0071, 7->0x006e, 8->0x006b, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zziq.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    private final void zzfm() {
        ArrayList arrayList = new ArrayList();
        zzig[] zzigArr = this.zzajo;
        for (zzig zzig : zzigArr) {
            if (zzig.isActive()) {
                arrayList.add(zzig);
            } else {
                zzig.flush();
            }
        }
        int size = arrayList.size();
        this.zzaky = (zzig[]) arrayList.toArray(new zzig[size]);
        this.zzakz = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzig zzig2 = this.zzaky[i];
            zzig2.flush();
            this.zzakz[i] = zzig2.zzfl();
        }
    }

    public final void play() {
        this.zzalg = true;
        if (isInitialized()) {
            this.zzakw = System.nanoTime() / 1000;
            this.zzaju.play();
        }
    }

    public final void zzfn() {
        if (this.zzaku == 1) {
            this.zzaku = 2;
        }
    }

    public final boolean zzb(ByteBuffer byteBuffer, long j) throws zzit, zziy {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = this.zzala;
        zzpb.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!isInitialized()) {
            this.zzajq.block();
            if (this.zzali) {
                this.zzaju = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzajv).setEncoding(this.zzajx).setSampleRate(this.zzahh).build(), this.zzajz, 1, this.zzalh);
            } else if (this.zzalh == 0) {
                this.zzaju = new AudioTrack(this.streamType, this.zzahh, this.zzajv, this.zzajx, this.zzajz, 1);
            } else {
                this.zzaju = new AudioTrack(this.streamType, this.zzahh, this.zzajv, this.zzajx, this.zzajz, 1, this.zzalh);
            }
            int state = this.zzaju.getState();
            if (state == 1) {
                int audioSessionId = this.zzaju.getAudioSessionId();
                if (this.zzalh != audioSessionId) {
                    this.zzalh = audioSessionId;
                    this.zzajp.zzx(audioSessionId);
                }
                this.zzajs.zza(this.zzaju, zzfw());
                zzft();
                this.zzalj = false;
                if (this.zzalg) {
                    play();
                }
            } else {
                try {
                    this.zzaju.release();
                } catch (Exception unused) {
                } finally {
                    this.zzaju = null;
                }
                throw new zzit(state, this.zzahh, this.zzajv, this.zzajz);
            }
        }
        if (zzfw()) {
            if (this.zzaju.getPlayState() == 2) {
                this.zzalj = false;
                return false;
            } else if (this.zzaju.getPlayState() == 1 && this.zzajs.zzga() != 0) {
                return false;
            }
        }
        boolean z = this.zzalj;
        boolean zzfq = zzfq();
        this.zzalj = zzfq;
        if (z && !zzfq && this.zzaju.getPlayState() != 1) {
            this.zzajp.zzc(this.zzajz, zzhc.zzdo(this.zzaka), SystemClock.elapsedRealtime() - this.zzalk);
        }
        if (this.zzala == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzajy && this.zzakt == 0) {
                int i3 = this.zzajx;
                if (i3 == 7 || i3 == 8) {
                    i2 = zzja.zzo(byteBuffer);
                } else if (i3 == 5) {
                    i2 = zzie.zzfh();
                } else if (i3 == 6) {
                    i2 = zzie.zzm(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzakt = i2;
            }
            if (this.zzakb != null) {
                if (!zzfp()) {
                    return false;
                }
                this.zzajt.add(new zziv(this.zzakb, Math.max(0L, j), zzdw(zzfu()), null));
                this.zzakb = null;
                zzfm();
            }
            if (this.zzaku == 0) {
                this.zzakv = Math.max(0L, j);
                this.zzaku = 1;
            } else {
                long zzdw = this.zzakv + zzdw(this.zzajy ? this.zzakp : this.zzako / ((long) this.zzakn));
                if (this.zzaku != 1 || Math.abs(zzdw - j) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzdw);
                    sb2.append(", got ");
                    sb2.append(j);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.zzaku = 2;
                }
                if (this.zzaku == i) {
                    this.zzakv += j - zzdw;
                    this.zzaku = 1;
                    this.zzajp.zzej();
                }
            }
            if (this.zzajy) {
                this.zzakp += (long) this.zzakt;
            } else {
                this.zzako += (long) byteBuffer.remaining();
            }
            this.zzala = byteBuffer;
        }
        if (this.zzajy) {
            zzc(this.zzala, j);
        } else {
            zzdv(j);
        }
        if (this.zzala.hasRemaining()) {
            return false;
        }
        this.zzala = null;
        return true;
    }

    private final void zzdv(long j) throws zziy {
        ByteBuffer byteBuffer;
        int length = this.zzaky.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzakz[i - 1];
            } else {
                byteBuffer = this.zzala;
                if (byteBuffer == null) {
                    byteBuffer = zzig.zzaiu;
                }
            }
            if (i == length) {
                zzc(byteBuffer, j);
            } else {
                zzig zzig = this.zzaky[i];
                zzig.zzn(byteBuffer);
                ByteBuffer zzfl = zzig.zzfl();
                this.zzakz[i] = zzfl;
                if (zzfl.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r11 < r10) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzc(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zziy {
        /*
            r8 = this;
            boolean r0 = r9.hasRemaining()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.nio.ByteBuffer r0 = r8.zzalb
            r2 = 21
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r9) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.google.android.gms.internal.ads.zzpb.checkArgument(r0)
            goto L_0x003b
        L_0x0018:
            r8.zzalb = r9
            int r0 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            if (r0 >= r2) goto L_0x003b
            int r0 = r9.remaining()
            byte[] r4 = r8.zzalc
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r8.zzalc = r4
        L_0x002d:
            int r4 = r9.position()
            byte[] r5 = r8.zzalc
            r9.get(r5, r3, r0)
            r9.position(r4)
            r8.zzald = r3
        L_0x003b:
            int r0 = r9.remaining()
            int r4 = com.google.android.gms.internal.ads.zzpo.SDK_INT
            if (r4 >= r2) goto L_0x0079
            long r10 = r8.zzakr
            com.google.android.gms.internal.ads.zzis r2 = r8.zzajs
            long r4 = r2.zzga()
            int r2 = r8.zzakq
            long r6 = (long) r2
            long r4 = r4 * r6
            long r10 = r10 - r4
            int r11 = (int) r10
            int r10 = r8.zzajz
            int r10 = r10 - r11
            if (r10 <= 0) goto L_0x0076
            int r10 = java.lang.Math.min(r0, r10)
            android.media.AudioTrack r11 = r8.zzaju
            byte[] r2 = r8.zzalc
            int r4 = r8.zzald
            int r10 = r11.write(r2, r4, r10)
            if (r10 <= 0) goto L_0x00f0
            int r11 = r8.zzald
            int r11 = r11 + r10
            r8.zzald = r11
            int r11 = r9.position()
            int r11 = r11 + r10
            r9.position(r11)
            goto L_0x00f0
        L_0x0076:
            r10 = 0
            goto L_0x00f0
        L_0x0079:
            boolean r2 = r8.zzali
            if (r2 == 0) goto L_0x00ea
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            com.google.android.gms.internal.ads.zzpb.checkState(r2)
            android.media.AudioTrack r2 = r8.zzaju
            java.nio.ByteBuffer r4 = r8.zzake
            if (r4 != 0) goto L_0x00a7
            r4 = 16
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r8.zzake = r4
            java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN
            r4.order(r5)
            java.nio.ByteBuffer r4 = r8.zzake
            r5 = 1431633921(0x55550001, float:1.46372496E13)
            r4.putInt(r5)
        L_0x00a7:
            int r4 = r8.zzakf
            if (r4 != 0) goto L_0x00c3
            java.nio.ByteBuffer r4 = r8.zzake
            r5 = 4
            r4.putInt(r5, r0)
            java.nio.ByteBuffer r4 = r8.zzake
            r5 = 8
            r6 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r6
            r4.putLong(r5, r10)
            java.nio.ByteBuffer r10 = r8.zzake
            r10.position(r3)
            r8.zzakf = r0
        L_0x00c3:
            java.nio.ByteBuffer r10 = r8.zzake
            int r10 = r10.remaining()
            if (r10 <= 0) goto L_0x00da
            java.nio.ByteBuffer r11 = r8.zzake
            int r11 = r2.write(r11, r10, r1)
            if (r11 >= 0) goto L_0x00d7
            r8.zzakf = r3
            r10 = r11
            goto L_0x00f0
        L_0x00d7:
            if (r11 >= r10) goto L_0x00da
            goto L_0x0076
        L_0x00da:
            int r9 = r2.write(r9, r0, r1)
            if (r9 >= 0) goto L_0x00e3
            r8.zzakf = r3
            goto L_0x00e8
        L_0x00e3:
            int r10 = r8.zzakf
            int r10 = r10 - r9
            r8.zzakf = r10
        L_0x00e8:
            r10 = r9
            goto L_0x00f0
        L_0x00ea:
            android.media.AudioTrack r10 = r8.zzaju
            int r10 = r10.write(r9, r0, r1)
        L_0x00f0:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r8.zzalk = r4
            if (r10 < 0) goto L_0x0115
            boolean r9 = r8.zzajy
            if (r9 != 0) goto L_0x0102
            long r4 = r8.zzakr
            long r6 = (long) r10
            long r4 = r4 + r6
            r8.zzakr = r4
        L_0x0102:
            if (r10 != r0) goto L_0x0114
            boolean r9 = r8.zzajy
            if (r9 == 0) goto L_0x0110
            long r9 = r8.zzaks
            int r11 = r8.zzakt
            long r2 = (long) r11
            long r9 = r9 + r2
            r8.zzaks = r9
        L_0x0110:
            r9 = 0
            r8.zzalb = r9
            return r1
        L_0x0114:
            return r3
        L_0x0115:
            com.google.android.gms.internal.ads.zziy r9 = new com.google.android.gms.internal.ads.zziy
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zziq.zzc(java.nio.ByteBuffer, long):boolean");
    }

    public final void zzfo() throws zziy {
        if (!this.zzalf && isInitialized() && zzfp()) {
            this.zzajs.zzdy(zzfu());
            this.zzakf = 0;
            this.zzalf = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzfp() throws com.google.android.gms.internal.ads.zziy {
        /*
            r9 = this;
            int r0 = r9.zzale
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzajy
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzig[] r0 = r9.zzaky
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.zzale = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.zzale
            com.google.android.gms.internal.ads.zzig[] r5 = r9.zzaky
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzfk()
        L_0x0028:
            r9.zzdv(r7)
            boolean r0 = r4.zzfd()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzale
            int r0 = r0 + r2
            r9.zzale = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzalb
            if (r0 == 0) goto L_0x0044
            r9.zzc(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzalb
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.zzale = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zziq.zzfp():boolean");
    }

    public final boolean zzfd() {
        if (isInitialized()) {
            return this.zzalf && !zzfq();
        }
        return true;
    }

    public final boolean zzfq() {
        if (isInitialized()) {
            if (zzfu() <= this.zzajs.zzga()) {
                if (zzfw() && this.zzaju.getPlayState() == 2 && this.zzaju.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final zzhw zzb(zzhw zzhw) {
        if (this.zzajy) {
            zzhw zzhw2 = zzhw.zzahs;
            this.zzaez = zzhw2;
            return zzhw2;
        }
        zzhw zzhw3 = new zzhw(this.zzajn.zzb(zzhw.zzaht), this.zzajn.zzc(zzhw.zzahu));
        zzhw zzhw4 = this.zzakb;
        if (zzhw4 == null) {
            if (!this.zzajt.isEmpty()) {
                zzhw4 = this.zzajt.getLast().zzaez;
            } else {
                zzhw4 = this.zzaez;
            }
        }
        if (!zzhw3.equals(zzhw4)) {
            if (isInitialized()) {
                this.zzakb = zzhw3;
            } else {
                this.zzaez = zzhw3;
            }
        }
        return this.zzaez;
    }

    public final zzhw zzfr() {
        return this.zzaez;
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            if (!this.zzali) {
                reset();
                this.zzalh = 0;
            }
        }
    }

    public final void zzy(int i) {
        zzpb.checkState(zzpo.SDK_INT >= 21);
        if (!this.zzali || this.zzalh != i) {
            this.zzali = true;
            this.zzalh = i;
            reset();
        }
    }

    public final void zzfs() {
        if (this.zzali) {
            this.zzali = false;
            this.zzalh = 0;
            reset();
        }
    }

    public final void setVolume(float f) {
        if (this.zzdj != f) {
            this.zzdj = f;
            zzft();
        }
    }

    private final void zzft() {
        if (!isInitialized()) {
            return;
        }
        if (zzpo.SDK_INT >= 21) {
            this.zzaju.setVolume(this.zzdj);
            return;
        }
        AudioTrack audioTrack = this.zzaju;
        float f = this.zzdj;
        audioTrack.setStereoVolume(f, f);
    }

    public final void pause() {
        this.zzalg = false;
        if (isInitialized()) {
            zzfv();
            this.zzajs.pause();
        }
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzako = 0;
            this.zzakp = 0;
            this.zzakr = 0;
            this.zzaks = 0;
            this.zzakt = 0;
            zzhw zzhw = this.zzakb;
            if (zzhw != null) {
                this.zzaez = zzhw;
                this.zzakb = null;
            } else if (!this.zzajt.isEmpty()) {
                this.zzaez = this.zzajt.getLast().zzaez;
            }
            this.zzajt.clear();
            this.zzakc = 0;
            this.zzakd = 0;
            this.zzala = null;
            this.zzalb = null;
            int i = 0;
            while (true) {
                zzig[] zzigArr = this.zzaky;
                if (i >= zzigArr.length) {
                    break;
                }
                zzig zzig = zzigArr[i];
                zzig.flush();
                this.zzakz[i] = zzig.zzfl();
                i++;
            }
            this.zzalf = false;
            this.zzale = -1;
            this.zzake = null;
            this.zzakf = 0;
            this.zzaku = 0;
            this.zzakx = 0;
            zzfv();
            if (this.zzaju.getPlayState() == 3) {
                this.zzaju.pause();
            }
            AudioTrack audioTrack = this.zzaju;
            this.zzaju = null;
            this.zzajs.zza(null, false);
            this.zzajq.close();
            new zzip(this, audioTrack).start();
        }
    }

    public final void release() {
        reset();
        for (zzig zzig : this.zzajo) {
            zzig.reset();
        }
        this.zzalh = 0;
        this.zzalg = false;
    }

    private final boolean isInitialized() {
        return this.zzaju != null;
    }

    private final long zzdw(long j) {
        return (j * 1000000) / ((long) this.zzahh);
    }

    private final long zzdx(long j) {
        return (j * ((long) this.zzahh)) / 1000000;
    }

    private final long zzfu() {
        return this.zzajy ? this.zzaks : this.zzakr / ((long) this.zzakq);
    }

    private final void zzfv() {
        this.zzaki = 0;
        this.zzakh = 0;
        this.zzakg = 0;
        this.zzakj = 0;
        this.zzakk = false;
        this.zzakl = 0;
    }

    private final boolean zzfw() {
        if (zzpo.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzajx;
        return i == 5 || i == 6;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zzay(String str) {
        char c;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 5;
        }
        if (c == 1) {
            return 6;
        }
        if (c != 2) {
            return c != 3 ? 0 : 8;
        }
        return 7;
    }
}
