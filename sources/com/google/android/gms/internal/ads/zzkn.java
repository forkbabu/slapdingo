package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzjl;
import com.google.firebase.FirebaseError;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;
import org.opencv.imgproc.Imgproc;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzkn implements zzjx {
    private static final zzjy zzapc = new zzkm();
    private static final byte[] zzapd = {49, 10, ByteBuffer.ZERO, ByteBuffer.ZERO, 58, ByteBuffer.ZERO, ByteBuffer.ZERO, 58, ByteBuffer.ZERO, ByteBuffer.ZERO, 44, ByteBuffer.ZERO, ByteBuffer.ZERO, ByteBuffer.ZERO, DocWriter.SPACE, 45, 45, DocWriter.GT, DocWriter.SPACE, ByteBuffer.ZERO, ByteBuffer.ZERO, 58, ByteBuffer.ZERO, ByteBuffer.ZERO, 58, ByteBuffer.ZERO, ByteBuffer.ZERO, 44, ByteBuffer.ZERO, ByteBuffer.ZERO, ByteBuffer.ZERO, 10};
    private static final byte[] zzape = {DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE, DocWriter.SPACE};
    /* access modifiers changed from: private */
    public static final UUID zzapf = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaih;
    private final zzkq zzaou;
    private final zzkl zzapg;
    private final SparseArray<zzko> zzaph;
    private final boolean zzapi;
    private final zzpi zzapj;
    private final zzpi zzapk;
    private final zzpi zzapl;
    private final zzpi zzapm;
    private final zzpi zzapn;
    private final zzpi zzapo;
    private final zzpi zzapp;
    private final zzpi zzapq;
    private final zzpi zzapr;
    private java.nio.ByteBuffer zzaps;
    private long zzapt;
    private long zzapu;
    private long zzapv;
    private long zzapw;
    private zzko zzapx;
    private boolean zzapy;
    private int zzapz;
    private long zzaqa;
    private boolean zzaqb;
    private long zzaqc;
    private long zzaqd;
    private long zzaqe;
    private zzpc zzaqf;
    private zzpc zzaqg;
    private boolean zzaqh;
    private int zzaqi;
    private long zzaqj;
    private long zzaqk;
    private int zzaql;
    private int zzaqm;
    private int[] zzaqn;
    private int zzaqo;
    private int zzaqp;
    private int zzaqq;
    private int zzaqr;
    private boolean zzaqs;
    private boolean zzaqt;
    private boolean zzaqu;
    private boolean zzaqv;
    private byte zzaqw;
    private int zzaqx;
    private int zzaqy;
    private int zzaqz;
    private boolean zzara;
    private boolean zzarb;
    private zzjz zzarc;

    public zzkn() {
        this(0);
    }

    static int zzam(int i) {
        switch (i) {
            case Imgproc.COLOR_RGB2YUV_YV12 /*{ENCODED_INT: 131}*/:
            case 136:
            case CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA /*{ENCODED_INT: 155}*/:
            case CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 /*{ENCODED_INT: 159}*/:
            case CipherSuite.TLS_PSK_WITH_NULL_SHA256 /*{ENCODED_INT: 176}*/:
            case 179:
            case CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256 /*{ENCODED_INT: 186}*/:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /*{ENCODED_INT: 17026}*/:
            case 2274716:
                return 3;
            case CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256 /*{ENCODED_INT: 160}*/:
            case CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256 /*{ENCODED_INT: 174}*/:
            case CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA384 /*{ENCODED_INT: 183}*/:
            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256 /*{ENCODED_INT: 187}*/:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case CipherSuite.TLS_DH_RSA_WITH_AES_256_GCM_SHA384 /*{ENCODED_INT: 161}*/:
            case CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 /*{ENCODED_INT: 163}*/:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA384 /*{ENCODED_INT: 181}*/:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean zzan(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void release() {
    }

    private zzkn(int i) {
        this(new zzkg(), 0);
    }

    private zzkn(zzkl zzkl, int i) {
        this.zzapu = -1;
        this.zzapv = -9223372036854775807L;
        this.zzapw = -9223372036854775807L;
        this.zzaih = -9223372036854775807L;
        this.zzaqc = -1;
        this.zzaqd = -1;
        this.zzaqe = -9223372036854775807L;
        this.zzapg = zzkl;
        zzkl.zza(new zzkp(this, null));
        this.zzapi = true;
        this.zzaou = new zzkq();
        this.zzaph = new SparseArray<>();
        this.zzapl = new zzpi(4);
        this.zzapm = new zzpi(java.nio.ByteBuffer.allocate(4).putInt(-1).array());
        this.zzapn = new zzpi(4);
        this.zzapj = new zzpi(zzph.zzbjk);
        this.zzapk = new zzpi(4);
        this.zzapo = new zzpi();
        this.zzapp = new zzpi();
        this.zzapq = new zzpi(8);
        this.zzapr = new zzpi();
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final boolean zza(zzjw zzjw) throws IOException, InterruptedException {
        return new zzkr().zza(zzjw);
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void zza(zzjz zzjz) {
        this.zzarc = zzjz;
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void zzc(long j, long j2) {
        this.zzaqe = -9223372036854775807L;
        this.zzaqi = 0;
        this.zzapg.reset();
        this.zzaou.reset();
        zzgt();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjx
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjw r9, com.google.android.gms.internal.ads.zzkd r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            r0 = 0
            r8.zzara = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003a
            boolean r3 = r8.zzara
            if (r3 != 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzkl r2 = r8.zzapg
            boolean r2 = r2.zzb(r9)
            if (r2 == 0) goto L_0x0005
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaqb
            if (r5 == 0) goto L_0x0025
            r8.zzaqd = r3
            long r3 = r8.zzaqc
            r10.position = r3
            r8.zzaqb = r0
        L_0x0023:
            r3 = 1
            goto L_0x0037
        L_0x0025:
            boolean r3 = r8.zzapy
            if (r3 == 0) goto L_0x0036
            long r3 = r8.zzaqd
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            r10.position = r3
            r8.zzaqd = r5
            goto L_0x0023
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003a:
            if (r2 == 0) goto L_0x003d
            return r0
        L_0x003d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkn.zza(com.google.android.gms.internal.ads.zzjw, com.google.android.gms.internal.ads.zzkd):int");
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j, long j2) throws zzht {
        if (i == 160) {
            this.zzarb = false;
        } else if (i == 174) {
            this.zzapx = new zzko(null);
        } else if (i == 187) {
            this.zzaqh = false;
        } else if (i == 19899) {
            this.zzapz = -1;
            this.zzaqa = -1;
        } else if (i == 20533) {
            this.zzapx.zzarf = true;
        } else if (i == 21968) {
            this.zzapx.zzarm = true;
        } else if (i == 408125543) {
            long j3 = this.zzapu;
            if (j3 == -1 || j3 == j) {
                this.zzapu = j;
                this.zzapt = j2;
                return;
            }
            throw new zzht("Multiple Segment elements not supported");
        } else if (i == 475249515) {
            this.zzaqf = new zzpc();
            this.zzaqg = new zzpc();
        } else if (i != 524531317 || this.zzapy) {
        } else {
            if (!this.zzapi || this.zzaqc == -1) {
                this.zzarc.zza(new zzkf(this.zzaih));
                this.zzapy = true;
                return;
            }
            this.zzaqb = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzao(int i) throws zzht {
        zzkc zzkc;
        zzpc zzpc;
        zzpc zzpc2;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.zzapx.zzard;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    zzko zzko = this.zzapx;
                    zzko.zza(this.zzarc, zzko.number);
                    this.zzaph.put(this.zzapx.number, this.zzapx);
                }
                this.zzapx = null;
            } else if (i == 19899) {
                int i4 = this.zzapz;
                if (i4 != -1) {
                    long j = this.zzaqa;
                    if (j != -1) {
                        if (i4 == 475249515) {
                            this.zzaqc = j;
                            return;
                        }
                        return;
                    }
                }
                throw new zzht("Mandatory element SeekID or SeekPosition not found");
            } else if (i != 25152) {
                if (i != 28032) {
                    if (i == 357149030) {
                        if (this.zzapv == -9223372036854775807L) {
                            this.zzapv = 1000000;
                        }
                        long j2 = this.zzapw;
                        if (j2 != -9223372036854775807L) {
                            this.zzaih = zzea(j2);
                        }
                    } else if (i != 374648427) {
                        if (i == 475249515 && !this.zzapy) {
                            zzjz zzjz = this.zzarc;
                            if (this.zzapu == -1 || this.zzaih == -9223372036854775807L || (zzpc = this.zzaqf) == null || zzpc.size() == 0 || (zzpc2 = this.zzaqg) == null || zzpc2.size() != this.zzaqf.size()) {
                                this.zzaqf = null;
                                this.zzaqg = null;
                                zzkc = new zzkf(this.zzaih);
                            } else {
                                int size = this.zzaqf.size();
                                int[] iArr = new int[size];
                                long[] jArr = new long[size];
                                long[] jArr2 = new long[size];
                                long[] jArr3 = new long[size];
                                for (int i5 = 0; i5 < size; i5++) {
                                    jArr3[i5] = this.zzaqf.get(i5);
                                    jArr[i5] = this.zzapu + this.zzaqg.get(i5);
                                }
                                while (true) {
                                    i2 = size - 1;
                                    if (i3 >= i2) {
                                        break;
                                    }
                                    int i6 = i3 + 1;
                                    iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                                    jArr2[i3] = jArr3[i6] - jArr3[i3];
                                    i3 = i6;
                                }
                                iArr[i2] = (int) ((this.zzapu + this.zzapt) - jArr[i2]);
                                jArr2[i2] = this.zzaih - jArr3[i2];
                                this.zzaqf = null;
                                this.zzaqg = null;
                                zzkc = new zzjv(iArr, jArr, jArr2, jArr3);
                            }
                            zzjz.zza(zzkc);
                            this.zzapy = true;
                        }
                    } else if (this.zzaph.size() != 0) {
                        this.zzarc.zzgr();
                    } else {
                        throw new zzht("No valid tracks were found");
                    }
                } else if (this.zzapx.zzarf && this.zzapx.zzarg != null) {
                    throw new zzht("Combining encryption and compression is not supported");
                }
            } else if (!this.zzapx.zzarf) {
            } else {
                if (this.zzapx.zzarh != null) {
                    this.zzapx.zzagz = new zzjl(new zzjl.zza(zzhc.UUID_NIL, "video/webm", this.zzapx.zzarh.zzapa));
                    return;
                }
                throw new zzht("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (this.zzaqi == 2) {
            if (!this.zzarb) {
                this.zzaqq |= 1;
            }
            zza(this.zzaph.get(this.zzaqo), this.zzaqj);
            this.zzaqi = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i, long j) throws zzht {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case Imgproc.COLOR_RGB2YUV_YV12 /*{ENCODED_INT: 131}*/:
                        this.zzapx.type = (int) j;
                        return;
                    case 136:
                        zzko zzko = this.zzapx;
                        if (j == 1) {
                            z = true;
                        }
                        zzko.zzasf = z;
                        return;
                    case CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA /*{ENCODED_INT: 155}*/:
                        this.zzaqk = zzea(j);
                        return;
                    case CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 /*{ENCODED_INT: 159}*/:
                        this.zzapx.zzahg = (int) j;
                        return;
                    case CipherSuite.TLS_PSK_WITH_NULL_SHA256 /*{ENCODED_INT: 176}*/:
                        this.zzapx.width = (int) j;
                        return;
                    case 179:
                        this.zzaqf.add(zzea(j));
                        return;
                    case CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256 /*{ENCODED_INT: 186}*/:
                        this.zzapx.height = (int) j;
                        return;
                    case 215:
                        this.zzapx.number = (int) j;
                        return;
                    case 231:
                        this.zzaqe = zzea(j);
                        return;
                    case 241:
                        if (!this.zzaqh) {
                            this.zzaqg.add(j);
                            this.zzaqh = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzarb = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(" not supported");
                            throw new zzht(sb.toString());
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(" not supported");
                            throw new zzht(sb2.toString());
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(" not supported");
                            throw new zzht(sb3.toString());
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(" not supported");
                            throw new zzht(sb4.toString());
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(" not supported");
                            throw new zzht(sb5.toString());
                        }
                        return;
                    case 21420:
                        this.zzaqa = j + this.zzapu;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.zzapx.zzahd = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzapx.zzahd = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzapx.zzahd = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzapx.zzahd = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.zzapx.zzarj = (int) j;
                        return;
                    case 21682:
                        this.zzapx.zzarl = (int) j;
                        return;
                    case 21690:
                        this.zzapx.zzark = (int) j;
                        return;
                    case 21930:
                        zzko zzko2 = this.zzapx;
                        if (j == 1) {
                            z = true;
                        }
                        zzko2.zzasg = z;
                        return;
                    case 22186:
                        this.zzapx.zzasd = j;
                        return;
                    case 22203:
                        this.zzapx.zzase = j;
                        return;
                    case 25188:
                        this.zzapx.zzasc = (int) j;
                        return;
                    case 2352003:
                        this.zzapx.zzare = (int) j;
                        return;
                    case 2807729:
                        this.zzapv = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.zzapx.zzarp = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.zzapx.zzarp = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.zzapx.zzaro = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.zzapx.zzaro = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.zzapx.zzaro = 3;
                                return;
                            case 21947:
                                this.zzapx.zzarm = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    this.zzapx.zzarn = 1;
                                    return;
                                } else if (i5 == 9) {
                                    this.zzapx.zzarn = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    this.zzapx.zzarn = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.zzapx.zzarq = (int) j;
                                return;
                            case 21949:
                                this.zzapx.zzarr = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzht(sb6.toString());
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(" not supported");
            throw new zzht(sb7.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, double d) {
        if (i == 181) {
            this.zzapx.zzahh = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzapx.zzars = (float) d;
                    return;
                case 21970:
                    this.zzapx.zzart = (float) d;
                    return;
                case 21971:
                    this.zzapx.zzaru = (float) d;
                    return;
                case 21972:
                    this.zzapx.zzarv = (float) d;
                    return;
                case 21973:
                    this.zzapx.zzarw = (float) d;
                    return;
                case 21974:
                    this.zzapx.zzarx = (float) d;
                    return;
                case 21975:
                    this.zzapx.zzary = (float) d;
                    return;
                case 21976:
                    this.zzapx.zzarz = (float) d;
                    return;
                case 21977:
                    this.zzapx.zzasa = (float) d;
                    return;
                case 21978:
                    this.zzapx.zzasb = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.zzapw = (long) d;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, String str) throws zzht {
        if (i == 134) {
            this.zzapx.zzard = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                String unused = this.zzapx.zzahn = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzht(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ff, code lost:
        throw new com.google.android.gms.internal.ads.zzht("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(int r22, int r23, com.google.android.gms.internal.ads.zzjw r24) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            if (r1 == r4) goto L_0x0097
            if (r1 == r5) goto L_0x0097
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0089
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x007a
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x005b
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x004d
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0034
            com.google.android.gms.internal.ads.zzko r1 = r0.zzapx
            byte[] r4 = new byte[r2]
            r1.zzahe = r4
            com.google.android.gms.internal.ads.zzko r1 = r0.zzapx
            byte[] r1 = r1.zzahe
            r3.readFully(r1, r6, r2)
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzht r2 = new com.google.android.gms.internal.ads.zzht
            r3 = 26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected id: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r2.<init>(r1)
            throw r2
        L_0x004d:
            com.google.android.gms.internal.ads.zzko r1 = r0.zzapx
            byte[] r4 = new byte[r2]
            r1.zzari = r4
            com.google.android.gms.internal.ads.zzko r1 = r0.zzapx
            byte[] r1 = r1.zzari
            r3.readFully(r1, r6, r2)
            return
        L_0x005b:
            com.google.android.gms.internal.ads.zzpi r1 = r0.zzapn
            byte[] r1 = r1.data
            java.util.Arrays.fill(r1, r6)
            com.google.android.gms.internal.ads.zzpi r1 = r0.zzapn
            byte[] r1 = r1.data
            int r4 = 4 - r2
            r3.readFully(r1, r4, r2)
            com.google.android.gms.internal.ads.zzpi r1 = r0.zzapn
            r1.zzbk(r6)
            com.google.android.gms.internal.ads.zzpi r1 = r0.zzapn
            long r1 = r1.zziw()
            int r2 = (int) r1
            r0.zzapz = r2
            return
        L_0x007a:
            byte[] r1 = new byte[r2]
            r3.readFully(r1, r6, r2)
            com.google.android.gms.internal.ads.zzko r2 = r0.zzapx
            com.google.android.gms.internal.ads.zzkh r3 = new com.google.android.gms.internal.ads.zzkh
            r3.<init>(r7, r1)
            r2.zzarh = r3
            return
        L_0x0089:
            com.google.android.gms.internal.ads.zzko r1 = r0.zzapx
            byte[] r4 = new byte[r2]
            r1.zzarg = r4
            com.google.android.gms.internal.ads.zzko r1 = r0.zzapx
            byte[] r1 = r1.zzarg
            r3.readFully(r1, r6, r2)
            return
        L_0x0097:
            int r4 = r0.zzaqi
            r8 = 8
            if (r4 != 0) goto L_0x00bc
            com.google.android.gms.internal.ads.zzkq r4 = r0.zzaou
            long r9 = r4.zza(r3, r6, r7, r8)
            int r4 = (int) r9
            r0.zzaqo = r4
            com.google.android.gms.internal.ads.zzkq r4 = r0.zzaou
            int r4 = r4.zzgv()
            r0.zzaqp = r4
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zzaqk = r9
            r0.zzaqi = r7
            com.google.android.gms.internal.ads.zzpi r4 = r0.zzapl
            r4.reset()
        L_0x00bc:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzko> r4 = r0.zzaph
            int r9 = r0.zzaqo
            java.lang.Object r4 = r4.get(r9)
            com.google.android.gms.internal.ads.zzko r4 = (com.google.android.gms.internal.ads.zzko) r4
            if (r4 != 0) goto L_0x00d2
            int r1 = r0.zzaqp
            int r1 = r2 - r1
            r3.zzah(r1)
            r0.zzaqi = r6
            return
        L_0x00d2:
            int r9 = r0.zzaqi
            if (r9 != r7) goto L_0x0285
            r9 = 3
            r0.zzb(r3, r9)
            com.google.android.gms.internal.ads.zzpi r10 = r0.zzapl
            byte[] r10 = r10.data
            r11 = 2
            byte r10 = r10[r11]
            r10 = r10 & 6
            int r10 = r10 >> r7
            r12 = 255(0xff, float:3.57E-43)
            if (r10 != 0) goto L_0x00fa
            r0.zzaqm = r7
            int[] r10 = r0.zzaqn
            int[] r10 = zza(r10, r7)
            r0.zzaqn = r10
            int r13 = r0.zzaqp
            int r2 = r2 - r13
            int r2 = r2 - r9
            r10[r6] = r2
            goto L_0x0213
        L_0x00fa:
            if (r1 != r5) goto L_0x027d
            r13 = 4
            r0.zzb(r3, r13)
            com.google.android.gms.internal.ads.zzpi r14 = r0.zzapl
            byte[] r14 = r14.data
            byte r14 = r14[r9]
            r14 = r14 & r12
            int r14 = r14 + r7
            r0.zzaqm = r14
            int[] r15 = r0.zzaqn
            int[] r14 = zza(r15, r14)
            r0.zzaqn = r14
            if (r10 != r11) goto L_0x0120
            int r9 = r0.zzaqp
            int r2 = r2 - r9
            int r2 = r2 - r13
            int r9 = r0.zzaqm
            int r2 = r2 / r9
            java.util.Arrays.fill(r14, r6, r9, r2)
            goto L_0x0213
        L_0x0120:
            if (r10 != r7) goto L_0x0157
            r9 = 0
            r10 = 0
        L_0x0124:
            int r14 = r0.zzaqm
            int r15 = r14 + -1
            if (r9 >= r15) goto L_0x014b
            int[] r14 = r0.zzaqn
            r14[r9] = r6
        L_0x012e:
            int r13 = r13 + r7
            r0.zzb(r3, r13)
            com.google.android.gms.internal.ads.zzpi r14 = r0.zzapl
            byte[] r14 = r14.data
            int r15 = r13 + -1
            byte r14 = r14[r15]
            r14 = r14 & r12
            int[] r15 = r0.zzaqn
            r16 = r15[r9]
            int r16 = r16 + r14
            r15[r9] = r16
            if (r14 == r12) goto L_0x012e
            r14 = r15[r9]
            int r10 = r10 + r14
            int r9 = r9 + 1
            goto L_0x0124
        L_0x014b:
            int[] r9 = r0.zzaqn
            int r14 = r14 - r7
            int r15 = r0.zzaqp
            int r2 = r2 - r15
            int r2 = r2 - r13
            int r2 = r2 - r10
            r9[r14] = r2
            goto L_0x0213
        L_0x0157:
            if (r10 != r9) goto L_0x0264
            r9 = 0
            r10 = 0
        L_0x015b:
            int r14 = r0.zzaqm
            int r15 = r14 + -1
            if (r9 >= r15) goto L_0x0208
            int[] r14 = r0.zzaqn
            r14[r9] = r6
            int r13 = r13 + 1
            r0.zzb(r3, r13)
            com.google.android.gms.internal.ads.zzpi r14 = r0.zzapl
            byte[] r14 = r14.data
            int r15 = r13 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x0200
            r16 = 0
            r14 = 0
        L_0x0177:
            if (r14 >= r8) goto L_0x01cb
            int r18 = 7 - r14
            int r5 = r7 << r18
            com.google.android.gms.internal.ads.zzpi r11 = r0.zzapl
            byte[] r11 = r11.data
            byte r11 = r11[r15]
            r11 = r11 & r5
            if (r11 == 0) goto L_0x01c1
            int r13 = r13 + r14
            r0.zzb(r3, r13)
            com.google.android.gms.internal.ads.zzpi r11 = r0.zzapl
            byte[] r11 = r11.data
            int r16 = r15 + 1
            byte r11 = r11[r15]
            r11 = r11 & r12
            int r5 = ~r5
            r5 = r5 & r11
            long r6 = (long) r5
            r5 = r16
            r16 = r6
        L_0x019a:
            if (r5 >= r13) goto L_0x01b3
            long r6 = r16 << r8
            com.google.android.gms.internal.ads.zzpi r15 = r0.zzapl
            byte[] r15 = r15.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            r5 = r5 & r12
            long r11 = (long) r5
            long r5 = r6 | r11
            r12 = 255(0xff, float:3.57E-43)
            r19 = r5
            r5 = r16
            r16 = r19
            goto L_0x019a
        L_0x01b3:
            if (r9 <= 0) goto L_0x01cb
            int r14 = r14 * 7
            int r14 = r14 + 6
            r5 = 1
            long r11 = r5 << r14
            long r11 = r11 - r5
            long r16 = r16 - r11
            goto L_0x01cb
        L_0x01c1:
            int r14 = r14 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0177
        L_0x01cb:
            r5 = r16
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x01f8
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x01f8
            int r6 = (int) r5
            int[] r5 = r0.zzaqn
            if (r9 != 0) goto L_0x01e1
            goto L_0x01e6
        L_0x01e1:
            int r7 = r9 + -1
            r7 = r5[r7]
            int r6 = r6 + r7
        L_0x01e6:
            r5[r9] = r6
            int[] r5 = r0.zzaqn
            r5 = r5[r9]
            int r10 = r10 + r5
            int r9 = r9 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x015b
        L_0x01f8:
            com.google.android.gms.internal.ads.zzht r1 = new com.google.android.gms.internal.ads.zzht
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>(r2)
            throw r1
        L_0x0200:
            com.google.android.gms.internal.ads.zzht r1 = new com.google.android.gms.internal.ads.zzht
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>(r2)
            throw r1
        L_0x0208:
            int[] r5 = r0.zzaqn
            r6 = 1
            int r14 = r14 - r6
            int r6 = r0.zzaqp
            int r2 = r2 - r6
            int r2 = r2 - r13
            int r2 = r2 - r10
            r5[r14] = r2
        L_0x0213:
            com.google.android.gms.internal.ads.zzpi r2 = r0.zzapl
            byte[] r2 = r2.data
            r5 = 0
            byte r2 = r2[r5]
            int r2 = r2 << r8
            com.google.android.gms.internal.ads.zzpi r5 = r0.zzapl
            byte[] r5 = r5.data
            r6 = 1
            byte r5 = r5[r6]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            r2 = r2 | r5
            long r5 = r0.zzaqe
            long r9 = (long) r2
            long r9 = r0.zzea(r9)
            long r5 = r5 + r9
            r0.zzaqj = r5
            com.google.android.gms.internal.ads.zzpi r2 = r0.zzapl
            byte[] r2 = r2.data
            r5 = 2
            byte r2 = r2[r5]
            r2 = r2 & r8
            if (r2 != r8) goto L_0x023c
            r2 = 1
            goto L_0x023d
        L_0x023c:
            r2 = 0
        L_0x023d:
            int r6 = r4.type
            if (r6 == r5) goto L_0x0253
            r6 = 163(0xa3, float:2.28E-43)
            if (r1 != r6) goto L_0x0251
            com.google.android.gms.internal.ads.zzpi r6 = r0.zzapl
            byte[] r6 = r6.data
            byte r6 = r6[r5]
            r5 = 128(0x80, float:1.794E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x0251
            goto L_0x0253
        L_0x0251:
            r5 = 0
            goto L_0x0254
        L_0x0253:
            r5 = 1
        L_0x0254:
            if (r2 == 0) goto L_0x0259
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x025a
        L_0x0259:
            r2 = 0
        L_0x025a:
            r2 = r2 | r5
            r0.zzaqq = r2
            r2 = 2
            r0.zzaqi = r2
            r2 = 0
            r0.zzaql = r2
            goto L_0x0285
        L_0x0264:
            com.google.android.gms.internal.ads.zzht r1 = new com.google.android.gms.internal.ads.zzht
            r2 = 36
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected lacing value: "
            r3.append(r2)
            r3.append(r10)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x027d:
            com.google.android.gms.internal.ads.zzht r1 = new com.google.android.gms.internal.ads.zzht
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>(r2)
            throw r1
        L_0x0285:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x02b0
        L_0x0289:
            int r1 = r0.zzaql
            int r2 = r0.zzaqm
            if (r1 >= r2) goto L_0x02ac
            int[] r2 = r0.zzaqn
            r1 = r2[r1]
            r0.zza(r3, r4, r1)
            long r1 = r0.zzaqj
            int r5 = r0.zzaql
            int r6 = r4.zzare
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.zza(r4, r1)
            int r1 = r0.zzaql
            r2 = 1
            int r1 = r1 + r2
            r0.zzaql = r1
            goto L_0x0289
        L_0x02ac:
            r1 = 0
            r0.zzaqi = r1
            return
        L_0x02b0:
            r1 = 0
            int[] r2 = r0.zzaqn
            r1 = r2[r1]
            r0.zza(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkn.zza(int, int, com.google.android.gms.internal.ads.zzjw):void");
    }

    private final void zza(zzko zzko, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzko.zzard)) {
            byte[] bArr2 = this.zzapp.data;
            long j2 = this.zzaqk;
            if (j2 == -9223372036854775807L) {
                bArr = zzape;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzpo.zzbj(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzke zzke = zzko.zzash;
            zzpi zzpi = this.zzapp;
            zzke.zza(zzpi, zzpi.limit());
            this.zzaqz += this.zzapp.limit();
        }
        zzko.zzash.zza(j, this.zzaqq, this.zzaqz, 0, zzko.zzarh);
        this.zzara = true;
        zzgt();
    }

    private final void zzgt() {
        this.zzaqr = 0;
        this.zzaqz = 0;
        this.zzaqy = 0;
        this.zzaqs = false;
        this.zzaqt = false;
        this.zzaqv = false;
        this.zzaqx = 0;
        this.zzaqw = 0;
        this.zzaqu = false;
        this.zzapo.reset();
    }

    private final void zzb(zzjw zzjw, int i) throws IOException, InterruptedException {
        if (this.zzapl.limit() < i) {
            if (this.zzapl.capacity() < i) {
                zzpi zzpi = this.zzapl;
                zzpi.zzc(Arrays.copyOf(zzpi.data, Math.max(this.zzapl.data.length << 1, i)), this.zzapl.limit());
            }
            zzjw.readFully(this.zzapl.data, this.zzapl.limit(), i - this.zzapl.limit());
            this.zzapl.zzbj(i);
        }
    }

    private final void zza(zzjw zzjw, zzko zzko, int i) throws IOException, InterruptedException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzko.zzard)) {
            int length = zzapd.length + i;
            if (this.zzapp.capacity() < length) {
                this.zzapp.data = Arrays.copyOf(zzapd, length + i);
            }
            zzjw.readFully(this.zzapp.data, zzapd.length, i);
            this.zzapp.zzbk(0);
            this.zzapp.zzbj(length);
            return;
        }
        zzke zzke = zzko.zzash;
        if (!this.zzaqs) {
            if (zzko.zzarf) {
                this.zzaqq &= -1073741825;
                int i3 = 128;
                if (!this.zzaqt) {
                    zzjw.readFully(this.zzapl.data, 0, 1);
                    this.zzaqr++;
                    if ((this.zzapl.data[0] & ByteCompanionObject.MIN_VALUE) != 128) {
                        this.zzaqw = this.zzapl.data[0];
                        this.zzaqt = true;
                    } else {
                        throw new zzht("Extension bit is set in signal byte");
                    }
                }
                byte b = this.zzaqw;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.zzaqq |= 1073741824;
                    if (!this.zzaqu) {
                        zzjw.readFully(this.zzapq.data, 0, 8);
                        this.zzaqr += 8;
                        this.zzaqu = true;
                        byte[] bArr = this.zzapl.data;
                        if (!z) {
                            i3 = 0;
                        }
                        bArr[0] = (byte) (i3 | 8);
                        this.zzapl.zzbk(0);
                        zzke.zza(this.zzapl, 1);
                        this.zzaqz++;
                        this.zzapq.zzbk(0);
                        zzke.zza(this.zzapq, 8);
                        this.zzaqz += 8;
                    }
                    if (z) {
                        if (!this.zzaqv) {
                            zzjw.readFully(this.zzapl.data, 0, 1);
                            this.zzaqr++;
                            this.zzapl.zzbk(0);
                            this.zzaqx = this.zzapl.readUnsignedByte();
                            this.zzaqv = true;
                        }
                        int i4 = this.zzaqx << 2;
                        this.zzapl.reset(i4);
                        zzjw.readFully(this.zzapl.data, 0, i4);
                        this.zzaqr += i4;
                        short s = (short) ((this.zzaqx / 2) + 1);
                        int i5 = (s * 6) + 2;
                        java.nio.ByteBuffer byteBuffer = this.zzaps;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.zzaps = java.nio.ByteBuffer.allocate(i5);
                        }
                        this.zzaps.position(0);
                        this.zzaps.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.zzaqx;
                            if (i6 >= i2) {
                                break;
                            }
                            int zziz = this.zzapl.zziz();
                            if (i6 % 2 == 0) {
                                this.zzaps.putShort((short) (zziz - i7));
                            } else {
                                this.zzaps.putInt(zziz - i7);
                            }
                            i6++;
                            i7 = zziz;
                        }
                        int i8 = (i - this.zzaqr) - i7;
                        if (i2 % 2 == 1) {
                            this.zzaps.putInt(i8);
                        } else {
                            this.zzaps.putShort((short) i8);
                            this.zzaps.putInt(0);
                        }
                        this.zzapr.zzc(this.zzaps.array(), i5);
                        zzke.zza(this.zzapr, i5);
                        this.zzaqz += i5;
                    }
                }
            } else if (zzko.zzarg != null) {
                this.zzapo.zzc(zzko.zzarg, zzko.zzarg.length);
            }
            this.zzaqs = true;
        }
        int limit = i + this.zzapo.limit();
        if (!"V_MPEG4/ISO/AVC".equals(zzko.zzard) && !"V_MPEGH/ISO/HEVC".equals(zzko.zzard)) {
            while (true) {
                int i9 = this.zzaqr;
                if (i9 >= limit) {
                    break;
                }
                zza(zzjw, zzke, limit - i9);
            }
        } else {
            byte[] bArr2 = this.zzapk.data;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i10 = zzko.zzasi;
            int i11 = 4 - zzko.zzasi;
            while (this.zzaqr < limit) {
                int i12 = this.zzaqy;
                if (i12 == 0) {
                    int min = Math.min(i10, this.zzapo.zziu());
                    zzjw.readFully(bArr2, i11 + min, i10 - min);
                    if (min > 0) {
                        this.zzapo.zze(bArr2, i11, min);
                    }
                    this.zzaqr += i10;
                    this.zzapk.zzbk(0);
                    this.zzaqy = this.zzapk.zziz();
                    this.zzapj.zzbk(0);
                    zzke.zza(this.zzapj, 4);
                    this.zzaqz += 4;
                } else {
                    this.zzaqy = i12 - zza(zzjw, zzke, i12);
                }
            }
        }
        if ("A_VORBIS".equals(zzko.zzard)) {
            this.zzapm.zzbk(0);
            zzke.zza(this.zzapm, 4);
            this.zzaqz += 4;
        }
    }

    private final int zza(zzjw zzjw, zzke zzke, int i) throws IOException, InterruptedException {
        int i2;
        int zziu = this.zzapo.zziu();
        if (zziu > 0) {
            i2 = Math.min(i, zziu);
            zzke.zza(this.zzapo, i2);
        } else {
            i2 = zzke.zza(zzjw, i, false);
        }
        this.zzaqr += i2;
        this.zzaqz += i2;
        return i2;
    }

    private final long zzea(long j) throws zzht {
        long j2 = this.zzapv;
        if (j2 != -9223372036854775807L) {
            return zzpo.zza(j, j2, 1000);
        }
        throw new zzht("Can't scale timecode prior to timecodeScale being set.");
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length << 1, i)];
    }
}
