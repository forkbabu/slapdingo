package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import com.itextpdf.text.io.PagedChannelRandomAccessSource;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzcf {

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zza extends zzegb<zza, C0006zza> implements zzehn {
        private static volatile zzehy<zza> zzel;
        /* access modifiers changed from: private */
        public static final zza zzik;
        private int zzdw;
        private String zzeg = "";
        private String zzfg = "";
        private String zzfi = "";
        private String zzfj = "D";
        private String zzfk = "D";
        private int zzfn;
        private int zzfo;
        private String zzfp = "";
        private long zzfq;
        private long zzfr;
        private long zzfs;
        private long zzft;
        private long zzfu;
        private long zzfv;
        private long zzfw;
        private long zzfx;
        private long zzfy;
        private long zzfz;
        private String zzga = "";
        private long zzgb;
        private long zzgc;
        private long zzgd;
        private long zzge;
        private long zzgf;
        private long zzgg;
        private long zzgh;
        private long zzgi;
        private long zzgj;
        private String zzgk = "D";
        private String zzgl = "";
        private long zzgm;
        private long zzgn;
        private long zzgo;
        private long zzgp;
        private long zzgq = -1;
        private long zzgr = -1;
        private zzb zzgs;
        private long zzgt = -1;
        private long zzgu = -1;
        private long zzgv = -1;
        private long zzgw = -1;
        private long zzgx = -1;
        private long zzgy = -1;
        private long zzgz = -1;
        private int zzha = 1000;
        private int zzhb = 1000;
        private long zzhc = -1;
        private long zzhd = -1;
        private long zzhe = -1;
        private long zzhf = -1;
        private long zzhg = -1;
        private int zzhh = 1000;
        private zze zzhi;
        private zzegm<zze> zzhj = zzbfh();
        private zzf zzhk;
        private long zzhl = -1;
        private long zzhm = -1;
        private long zzhn = -1;
        private long zzho = -1;
        private long zzhp = -1;
        private long zzhq = -1;
        private long zzhr = -1;
        private long zzhs = -1;
        private String zzht = "D";
        private long zzhu = -1;
        private int zzhv;
        private int zzhw;
        private int zzhx;
        private zze zzhy;
        private long zzhz = -1;
        private int zzia = 1000;
        private int zzib = 1000;
        private String zzic = "D";
        private long zzid;
        private String zzie = "";
        private int zzif = 2;
        private boolean zzig;
        private String zzih = "";
        private long zzii;
        private zzd zzij;

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public enum zzb implements zzegg {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3),
            DEBUGGER_STATE_ENVVAR(4),
            DEBUGGER_STATE_MACHPORT(5),
            DEBUGGER_STATE_ENVVAR_MACHPORT(6);
            
            private static final zzegf<zzb> zzes = new zzcg();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzegg
            public final int zzw() {
                return this.value;
            }

            public static zzb zzk(int i) {
                switch (i) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    case 4:
                        return DEBUGGER_STATE_ENVVAR;
                    case 5:
                        return DEBUGGER_STATE_MACHPORT;
                    case 6:
                        return DEBUGGER_STATE_ENVVAR_MACHPORT;
                    default:
                        return null;
                }
            }

            public static zzegi zzx() {
                return zzch.zzeu;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public enum zzc implements zzegg {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6);
            
            private static final zzegf<zzc> zzes = new zzcj();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzegg
            public final int zzw() {
                return this.value;
            }

            public static zzc zzl(int i) {
                switch (i) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    default:
                        return null;
                }
            }

            public static zzegi zzx() {
                return zzci.zzeu;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzc(int i) {
                this.value = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public enum zzd implements zzegg {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(512),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(2048),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(32768),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);
            
            private static final zzegf<zzd> zzes = new zzck();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzegg
            public final int zzw() {
                return this.value;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzd(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public static final class zze extends zzegb<zze, C0007zza> implements zzehn {
            private static volatile zzehy<zze> zzel;
            /* access modifiers changed from: private */
            public static final zze zzku;
            private int zzdw;
            private long zzgb = -1;
            private long zzgc = -1;
            private long zzkb = -1;
            private long zzkc = -1;
            private long zzkd = -1;
            private long zzke = -1;
            private int zzkf = 1000;
            private long zzkg = -1;
            private long zzkh = -1;
            private long zzki = -1;
            private int zzkj = 1000;
            private long zzkk = -1;
            private long zzkl = -1;
            private long zzkm = -1;
            private long zzkn = -1;
            private long zzko;
            private long zzkp;
            private long zzkq = -1;
            private long zzkr = -1;
            private long zzks = -1;
            private long zzkt = -1;

            private zze() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zze$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
            public static final class C0007zza extends zzegb.zzb<zze, C0007zza> implements zzehn {
                private C0007zza() {
                    super(zze.zzku);
                }

                public final C0007zza zzbs(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzaq(j);
                    return this;
                }

                public final C0007zza zzbt(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzar(j);
                    return this;
                }

                public final C0007zza zzbu(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcj(j);
                    return this;
                }

                public final C0007zza zzbv(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzck(j);
                    return this;
                }

                public final C0007zza zzau() {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzav();
                    return this;
                }

                public final C0007zza zzbw(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcl(j);
                    return this;
                }

                public final C0007zza zzbx(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcm(j);
                    return this;
                }

                public final C0007zza zzk(zzcn zzcn) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzm(zzcn);
                    return this;
                }

                public final C0007zza zzby(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcn(j);
                    return this;
                }

                public final C0007zza zzbz(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzco(j);
                    return this;
                }

                public final C0007zza zzca(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcp(j);
                    return this;
                }

                public final C0007zza zzl(zzcn zzcn) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzn(zzcn);
                    return this;
                }

                public final C0007zza zzcb(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcq(j);
                    return this;
                }

                public final C0007zza zzcc(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcr(j);
                    return this;
                }

                public final C0007zza zzcd(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcs(j);
                    return this;
                }

                public final C0007zza zzce(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzct(j);
                    return this;
                }

                public final C0007zza zzcf(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcu(j);
                    return this;
                }

                public final C0007zza zzcg(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcv(j);
                    return this;
                }

                public final C0007zza zzch(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcw(j);
                    return this;
                }

                public final C0007zza zzci(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zze) this.zziel).zzcx(j);
                    return this;
                }

                /* synthetic */ C0007zza(zzce zzce) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzaq(long j) {
                this.zzdw |= 1;
                this.zzgb = j;
            }

            /* access modifiers changed from: private */
            public final void zzar(long j) {
                this.zzdw |= 2;
                this.zzgc = j;
            }

            /* access modifiers changed from: private */
            public final void zzcj(long j) {
                this.zzdw |= 4;
                this.zzkb = j;
            }

            /* access modifiers changed from: private */
            public final void zzck(long j) {
                this.zzdw |= 8;
                this.zzkc = j;
            }

            /* access modifiers changed from: private */
            public final void zzav() {
                this.zzdw &= -9;
                this.zzkc = -1;
            }

            /* access modifiers changed from: private */
            public final void zzcl(long j) {
                this.zzdw |= 16;
                this.zzkd = j;
            }

            /* access modifiers changed from: private */
            public final void zzcm(long j) {
                this.zzdw |= 32;
                this.zzke = j;
            }

            /* access modifiers changed from: private */
            public final void zzm(zzcn zzcn) {
                this.zzkf = zzcn.zzw();
                this.zzdw |= 64;
            }

            /* access modifiers changed from: private */
            public final void zzcn(long j) {
                this.zzdw |= 128;
                this.zzkg = j;
            }

            /* access modifiers changed from: private */
            public final void zzco(long j) {
                this.zzdw |= 256;
                this.zzkh = j;
            }

            /* access modifiers changed from: private */
            public final void zzcp(long j) {
                this.zzdw |= 512;
                this.zzki = j;
            }

            /* access modifiers changed from: private */
            public final void zzn(zzcn zzcn) {
                this.zzkj = zzcn.zzw();
                this.zzdw |= 1024;
            }

            /* access modifiers changed from: private */
            public final void zzcq(long j) {
                this.zzdw |= 2048;
                this.zzkk = j;
            }

            /* access modifiers changed from: private */
            public final void zzcr(long j) {
                this.zzdw |= 4096;
                this.zzkl = j;
            }

            /* access modifiers changed from: private */
            public final void zzcs(long j) {
                this.zzdw |= 8192;
                this.zzkm = j;
            }

            /* access modifiers changed from: private */
            public final void zzct(long j) {
                this.zzdw |= 16384;
                this.zzkn = j;
            }

            /* access modifiers changed from: private */
            public final void zzcu(long j) {
                this.zzdw |= 32768;
                this.zzko = j;
            }

            /* access modifiers changed from: private */
            public final void zzcv(long j) {
                this.zzdw |= 65536;
                this.zzkp = j;
            }

            /* access modifiers changed from: private */
            public final void zzcw(long j) {
                this.zzdw |= 131072;
                this.zzkq = j;
            }

            /* access modifiers changed from: private */
            public final void zzcx(long j) {
                this.zzdw |= 262144;
                this.zzkr = j;
            }

            public static C0007zza zzaw() {
                return (C0007zza) zzku.zzbfc();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzce.zzdv[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0007zza(null);
                    case 3:
                        return zza(zzku, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzdw", "zzgb", "zzgc", "zzkb", "zzkc", "zzkd", "zzke", "zzkf", zzcn.zzx(), "zzkg", "zzkh", "zzki", "zzkj", zzcn.zzx(), "zzkk", "zzkl", "zzkm", "zzkn", "zzko", "zzkp", "zzkq", "zzkr", "zzks", "zzkt"});
                    case 4:
                        return zzku;
                    case 5:
                        zzehy<zze> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (zze.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzku);
                                    zzel = zzehy;
                                }
                            }
                        }
                        return zzehy;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zze zze = new zze();
                zzku = zze;
                zzegb.zza(zze.class, zze);
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public static final class zzf extends zzegb<zzf, C0008zza> implements zzehn {
            private static volatile zzehy<zzf> zzel;
            /* access modifiers changed from: private */
            public static final zzf zzkz;
            private int zzdw;
            private long zzhf = -1;
            private long zzhg = -1;
            private long zzkv = -1;
            private long zzkw = -1;
            private long zzkx = -1;
            private long zzky = -1;

            private zzf() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zzf$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
            public static final class C0008zza extends zzegb.zzb<zzf, C0008zza> implements zzehn {
                private C0008zza() {
                    super(zzf.zzkz);
                }

                public final C0008zza zzcy(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzf) this.zziel).zzdc(j);
                    return this;
                }

                public final C0008zza zzcz(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzf) this.zziel).zzdd(j);
                    return this;
                }

                public final C0008zza zzda(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzf) this.zziel).zzde(j);
                    return this;
                }

                public final C0008zza zzdb(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzf) this.zziel).zzdf(j);
                    return this;
                }

                /* synthetic */ C0008zza(zzce zzce) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzdc(long j) {
                this.zzdw |= 4;
                this.zzkv = j;
            }

            /* access modifiers changed from: private */
            public final void zzdd(long j) {
                this.zzdw |= 8;
                this.zzkw = j;
            }

            /* access modifiers changed from: private */
            public final void zzde(long j) {
                this.zzdw |= 16;
                this.zzkx = j;
            }

            /* access modifiers changed from: private */
            public final void zzdf(long j) {
                this.zzdw |= 32;
                this.zzky = j;
            }

            public static C0008zza zzay() {
                return (C0008zza) zzkz.zzbfc();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzce.zzdv[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0008zza(null);
                    case 3:
                        return zza(zzkz, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzdw", "zzhf", "zzhg", "zzkv", "zzkw", "zzkx", "zzky"});
                    case 4:
                        return zzkz;
                    case 5:
                        zzehy<zzf> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (zzf.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzkz);
                                    zzel = zzehy;
                                }
                            }
                        }
                        return zzehy;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzf zzf = new zzf();
                zzkz = zzf;
                zzegb.zza(zzf.class, zzf);
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzcf$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public static final class C0006zza extends zzegb.zzb<zza, C0006zza> implements zzehn {
            private C0006zza() {
                super(zza.zzik);
            }

            public final C0006zza zzt(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzac(str);
                return this;
            }

            public final C0006zza zzu(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzad(str);
                return this;
            }

            public final C0006zza zze(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzal(j);
                return this;
            }

            public final C0006zza zzf(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzam(j);
                return this;
            }

            public final C0006zza zzg(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzan(j);
                return this;
            }

            public final C0006zza zzh(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzao(j);
                return this;
            }

            public final C0006zza zzi(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzap(j);
                return this;
            }

            public final C0006zza zzj(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzaq(j);
                return this;
            }

            public final C0006zza zzk(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzar(j);
                return this;
            }

            public final C0006zza zzl(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzas(j);
                return this;
            }

            public final C0006zza zzm(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzat(j);
                return this;
            }

            public final C0006zza zzn(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzau(j);
                return this;
            }

            public final C0006zza zzo(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzav(j);
                return this;
            }

            public final C0006zza zzp(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzaw(j);
                return this;
            }

            public final C0006zza zzv(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzae(str);
                return this;
            }

            public final C0006zza zzw(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzaf(str);
                return this;
            }

            public final C0006zza zzq(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzax(j);
                return this;
            }

            public final C0006zza zzr(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzay(j);
                return this;
            }

            public final C0006zza zzs(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzaz(j);
                return this;
            }

            public final C0006zza zzx(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzag(str);
                return this;
            }

            public final C0006zza zzt(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzba(j);
                return this;
            }

            @Deprecated
            public final C0006zza zzu(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbb(j);
                return this;
            }

            public final C0006zza zzv(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbc(j);
                return this;
            }

            public final C0006zza zzw(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbd(j);
                return this;
            }

            public final C0006zza zzx(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbe(j);
                return this;
            }

            public final C0006zza zzy(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbf(j);
                return this;
            }

            public final C0006zza zzz(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbg(j);
                return this;
            }

            public final C0006zza zzaa(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbh(j);
                return this;
            }

            public final C0006zza zzab(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbi(j);
                return this;
            }

            public final C0006zza zzy(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzah(str);
                return this;
            }

            public final C0006zza zzz(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzai(str);
                return this;
            }

            public final C0006zza zza(zzcn zzcn) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzf(zzcn);
                return this;
            }

            public final C0006zza zzb(zzcn zzcn) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzg(zzcn);
                return this;
            }

            public final C0006zza zzac(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbj(j);
                return this;
            }

            public final C0006zza zzad(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbk(j);
                return this;
            }

            public final C0006zza zzae(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbl(j);
                return this;
            }

            public final C0006zza zzc(zzcn zzcn) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzh(zzcn);
                return this;
            }

            public final C0006zza zza(zze zze) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzc(zze);
                return this;
            }

            public final C0006zza zzb(zze zze) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzd(zze);
                return this;
            }

            public final C0006zza zzaj() {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzal();
                return this;
            }

            public final C0006zza zza(zzf zzf) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzb(zzf);
                return this;
            }

            public final C0006zza zzaf(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbm(j);
                return this;
            }

            public final C0006zza zzag(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbn(j);
                return this;
            }

            public final C0006zza zzah(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbo(j);
                return this;
            }

            public final C0006zza zzai(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbp(j);
                return this;
            }

            public final C0006zza zzaj(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbq(j);
                return this;
            }

            public final C0006zza zzaa(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzaj(str);
                return this;
            }

            public final C0006zza zzd(zzcn zzcn) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzi(zzcn);
                return this;
            }

            public final C0006zza zze(zzcn zzcn) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzj(zzcn);
                return this;
            }

            public final C0006zza zzab(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzak(str);
                return this;
            }

            public final C0006zza zza(zzc zzc) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzb(zzc);
                return this;
            }

            public final C0006zza zza(boolean z) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzb(z);
                return this;
            }

            public final C0006zza zzak(long j) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzbr(j);
                return this;
            }

            /* synthetic */ C0006zza(zzce zzce) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzac(String str) {
            str.getClass();
            this.zzdw |= 1;
            this.zzfp = str;
        }

        /* access modifiers changed from: private */
        public final void zzad(String str) {
            str.getClass();
            this.zzdw |= 2;
            this.zzeg = str;
        }

        /* access modifiers changed from: private */
        public final void zzal(long j) {
            this.zzdw |= 4;
            this.zzfq = j;
        }

        /* access modifiers changed from: private */
        public final void zzam(long j) {
            this.zzdw |= 16;
            this.zzfs = j;
        }

        /* access modifiers changed from: private */
        public final void zzan(long j) {
            this.zzdw |= 32;
            this.zzft = j;
        }

        /* access modifiers changed from: private */
        public final void zzao(long j) {
            this.zzdw |= 1024;
            this.zzfy = j;
        }

        /* access modifiers changed from: private */
        public final void zzap(long j) {
            this.zzdw |= 2048;
            this.zzfz = j;
        }

        /* access modifiers changed from: private */
        public final void zzaq(long j) {
            this.zzdw |= 8192;
            this.zzgb = j;
        }

        /* access modifiers changed from: private */
        public final void zzar(long j) {
            this.zzdw |= 16384;
            this.zzgc = j;
        }

        /* access modifiers changed from: private */
        public final void zzas(long j) {
            this.zzdw |= 32768;
            this.zzgd = j;
        }

        /* access modifiers changed from: private */
        public final void zzat(long j) {
            this.zzdw |= 65536;
            this.zzge = j;
        }

        /* access modifiers changed from: private */
        public final void zzau(long j) {
            this.zzdw |= 524288;
            this.zzgh = j;
        }

        /* access modifiers changed from: private */
        public final void zzav(long j) {
            this.zzdw |= 1048576;
            this.zzgi = j;
        }

        /* access modifiers changed from: private */
        public final void zzaw(long j) {
            this.zzdw |= 2097152;
            this.zzgj = j;
        }

        public final boolean zzak() {
            return (this.zzdw & 4194304) != 0;
        }

        public final String zzag() {
            return this.zzfg;
        }

        /* access modifiers changed from: private */
        public final void zzae(String str) {
            str.getClass();
            this.zzdw |= 4194304;
            this.zzfg = str;
        }

        /* access modifiers changed from: private */
        public final void zzaf(String str) {
            str.getClass();
            this.zzdw |= 16777216;
            this.zzgl = str;
        }

        /* access modifiers changed from: private */
        public final void zzax(long j) {
            this.zzdw |= 33554432;
            this.zzgm = j;
        }

        /* access modifiers changed from: private */
        public final void zzay(long j) {
            this.zzdw |= PagedChannelRandomAccessSource.DEFAULT_TOTAL_BUFSIZE;
            this.zzgn = j;
        }

        /* access modifiers changed from: private */
        public final void zzaz(long j) {
            this.zzdw |= 134217728;
            this.zzgo = j;
        }

        /* access modifiers changed from: private */
        public final void zzag(String str) {
            str.getClass();
            this.zzdw |= 268435456;
            this.zzfi = str;
        }

        /* access modifiers changed from: private */
        public final void zzba(long j) {
            this.zzdw |= 536870912;
            this.zzgp = j;
        }

        /* access modifiers changed from: private */
        public final void zzbb(long j) {
            this.zzdw |= 1073741824;
            this.zzgq = j;
        }

        /* access modifiers changed from: private */
        public final void zzbc(long j) {
            this.zzdw |= Integer.MIN_VALUE;
            this.zzgr = j;
        }

        /* access modifiers changed from: private */
        public final void zzbd(long j) {
            this.zzfn |= 2;
            this.zzgt = j;
        }

        /* access modifiers changed from: private */
        public final void zzbe(long j) {
            this.zzfn |= 4;
            this.zzgu = j;
        }

        /* access modifiers changed from: private */
        public final void zzbf(long j) {
            this.zzfn |= 8;
            this.zzgv = j;
        }

        /* access modifiers changed from: private */
        public final void zzbg(long j) {
            this.zzfn |= 16;
            this.zzgw = j;
        }

        /* access modifiers changed from: private */
        public final void zzbh(long j) {
            this.zzfn |= 32;
            this.zzgx = j;
        }

        /* access modifiers changed from: private */
        public final void zzbi(long j) {
            this.zzfn |= 64;
            this.zzgy = j;
        }

        /* access modifiers changed from: private */
        public final void zzah(String str) {
            str.getClass();
            this.zzfn |= 128;
            this.zzfj = str;
        }

        /* access modifiers changed from: private */
        public final void zzai(String str) {
            str.getClass();
            this.zzfn |= 256;
            this.zzfk = str;
        }

        /* access modifiers changed from: private */
        public final void zzf(zzcn zzcn) {
            this.zzha = zzcn.zzw();
            this.zzfn |= 1024;
        }

        /* access modifiers changed from: private */
        public final void zzg(zzcn zzcn) {
            this.zzhb = zzcn.zzw();
            this.zzfn |= 2048;
        }

        /* access modifiers changed from: private */
        public final void zzbj(long j) {
            this.zzfn |= 4096;
            this.zzhc = j;
        }

        /* access modifiers changed from: private */
        public final void zzbk(long j) {
            this.zzfn |= 8192;
            this.zzhd = j;
        }

        /* access modifiers changed from: private */
        public final void zzbl(long j) {
            this.zzfn |= 16384;
            this.zzhe = j;
        }

        /* access modifiers changed from: private */
        public final void zzh(zzcn zzcn) {
            this.zzhh = zzcn.zzw();
            this.zzfn |= 131072;
        }

        /* access modifiers changed from: private */
        public final void zzc(zze zze2) {
            zze2.getClass();
            this.zzhi = zze2;
            this.zzfn |= 262144;
        }

        /* access modifiers changed from: private */
        public final void zzd(zze zze2) {
            zze2.getClass();
            if (!this.zzhj.zzbcy()) {
                this.zzhj = zzegb.zza(this.zzhj);
            }
            this.zzhj.add(zze2);
        }

        /* access modifiers changed from: private */
        public final void zzal() {
            this.zzhj = zzbfh();
        }

        /* access modifiers changed from: private */
        public final void zzb(zzf zzf2) {
            zzf2.getClass();
            this.zzhk = zzf2;
            this.zzfn |= 524288;
        }

        /* access modifiers changed from: private */
        public final void zzbm(long j) {
            this.zzfn |= 2097152;
            this.zzhm = j;
        }

        /* access modifiers changed from: private */
        public final void zzbn(long j) {
            this.zzfn |= 4194304;
            this.zzhn = j;
        }

        /* access modifiers changed from: private */
        public final void zzbo(long j) {
            this.zzfn |= 8388608;
            this.zzho = j;
        }

        /* access modifiers changed from: private */
        public final void zzbp(long j) {
            this.zzfn |= PagedChannelRandomAccessSource.DEFAULT_TOTAL_BUFSIZE;
            this.zzhr = j;
        }

        /* access modifiers changed from: private */
        public final void zzbq(long j) {
            this.zzfn |= 134217728;
            this.zzhs = j;
        }

        /* access modifiers changed from: private */
        public final void zzaj(String str) {
            str.getClass();
            this.zzfn |= 268435456;
            this.zzht = str;
        }

        /* access modifiers changed from: private */
        public final void zzi(zzcn zzcn) {
            this.zzia = zzcn.zzw();
            this.zzfo |= 8;
        }

        /* access modifiers changed from: private */
        public final void zzj(zzcn zzcn) {
            this.zzib = zzcn.zzw();
            this.zzfo |= 16;
        }

        public final String zzam() {
            return this.zzie;
        }

        /* access modifiers changed from: private */
        public final void zzak(String str) {
            str.getClass();
            this.zzfo |= 128;
            this.zzie = str;
        }

        public final zzc zzan() {
            zzc zzl = zzc.zzl(this.zzif);
            return zzl == null ? zzc.DEVICE_IDENTIFIER_GLOBAL_ID : zzl;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzc zzc2) {
            this.zzif = zzc2.zzw();
            this.zzfo |= 256;
        }

        public final boolean zzao() {
            return this.zzig;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzfo |= 512;
            this.zzig = z;
        }

        /* access modifiers changed from: private */
        public final void zzbr(long j) {
            this.zzfo |= 2048;
            this.zzii = j;
        }

        public final boolean zzap() {
            return (this.zzfo & 4096) != 0;
        }

        public final zzd zzaq() {
            zzd zzd2 = this.zzij;
            return zzd2 == null ? zzd.zzbj() : zzd2;
        }

        public static zza zza(byte[] bArr, zzefo zzefo) throws zzegl {
            return (zza) zzegb.zza(zzik, bArr, zzefo);
        }

        public static C0006zza zzar() {
            return (C0006zza) zzik.zzbfc();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0006zza(null);
                case 3:
                    return zza(zzik, "\u0001N\u0000\u0003\u0001ÉN\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂF\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈG\u0019ဂK\u001aဌH\u001bဈ\u0016\u001cဇI\u001dဈ\u0018\u001eဈJ\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0ဌ*1ဌ+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08ဌ19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=Aဌ>Bဌ?Cဈ<Dဌ@EဉAFဂBGဂ8Hဂ9IဌCJဂ)Kဈ\u0017LဌDMဈEÉဉL", new Object[]{"zzdw", "zzfn", "zzfo", "zzfp", "zzeg", "zzfq", "zzfr", "zzfs", "zzft", "zzfu", "zzfv", "zzfw", "zzfx", "zzfy", "zzfz", "zzga", "zzgb", "zzgc", "zzgd", "zzge", "zzgf", "zzgg", "zzgh", "zzid", "zzgi", "zzgj", "zzie", "zzii", "zzif", zzc.zzx(), "zzfg", "zzig", "zzgl", "zzih", "zzgm", "zzgn", "zzgo", "zzfi", "zzgp", "zzgq", "zzgr", "zzgs", "zzgt", "zzgu", "zzgv", "zzgw", "zzhj", zze.class, "zzgx", "zzgy", "zzfj", "zzfk", "zzha", zzcn.zzx(), "zzhb", zzcn.zzx(), "zzhi", "zzhc", "zzhd", "zzhe", "zzhf", "zzhg", "zzhh", zzcn.zzx(), "zzhk", "zzhl", "zzhm", "zzhn", "zzho", "zzhr", "zzhs", "zzhu", "zzhv", zzcm.zzx(), "zzhw", zzcs.zzx(), "zzht", "zzhx", zzb.zzx(), "zzhy", "zzhz", "zzhp", "zzhq", "zzia", zzcn.zzx(), "zzgz", "zzgk", "zzib", zzcn.zzx(), "zzic", "zzij"});
                case 4:
                    return zzik;
                case 5:
                    zzehy<zza> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zza.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzik);
                                zzel = zzehy;
                            }
                        }
                    }
                    return zzehy;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zza zzas() {
            return zzik;
        }

        static {
            zza zza = new zza();
            zzik = zza;
            zzegb.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zzb extends zzegb<zzb, zza> implements zzehn {
        private static volatile zzehy<zzb> zzel;
        /* access modifiers changed from: private */
        public static final zzb zzlf;
        private int zzdw;
        private long zzla;
        private int zzlb;
        private boolean zzlc;
        private zzegh zzld = zzbff();
        private long zzle;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public static final class zza extends zzegb.zzb<zzb, zza> implements zzehn {
            private zza() {
                super(zzb.zzlf);
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzlf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzdw", "zzla", "zzlb", "zzlc", "zzld", "zzle"});
                case 4:
                    return zzlf;
                case 5:
                    zzehy<zzb> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zzb.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzlf);
                                zzel = zzehy;
                            }
                        }
                    }
                    return zzehy;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzlf = zzb;
            zzegb.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zzd extends zzegb<zzd, zza> implements zzehn {
        private static volatile zzehy<zzd> zzel;
        /* access modifiers changed from: private */
        public static final zzd zzme;
        private int zzdw;
        private long zzla;
        private String zzmc = "";
        private zzeer zzmd = zzeer.zzhzv;

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public static final class zza extends zzegb.zzb<zzd, zza> implements zzehn {
            private zza() {
                super(zzd.zzme);
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final boolean zzbh() {
            return (this.zzdw & 1) != 0;
        }

        public final long zzbi() {
            return this.zzla;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzme, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzdw", "zzla", "zzmc", "zzmd"});
                case 4:
                    return zzme;
                case 5:
                    zzehy<zzd> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zzd.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzme);
                                zzel = zzehy;
                            }
                        }
                    }
                    return zzehy;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzd zzbj() {
            return zzme;
        }

        static {
            zzd zzd = new zzd();
            zzme = zzd;
            zzegb.zza(zzd.class, zzd);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zze extends zzegb<zze, zza> implements zzehn {
        private static volatile zzehy<zze> zzel;
        /* access modifiers changed from: private */
        public static final zze zzmf;
        private int zzdw;
        private String zzfl = "";

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public static final class zza extends zzegb.zzb<zze, zza> implements zzehn {
            private zza() {
                super(zze.zzmf);
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzmf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdw", "zzfl"});
                case 4:
                    return zzmf;
                case 5:
                    zzehy<zze> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zze.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzmf);
                                zzel = zzehy;
                            }
                        }
                    }
                    return zzehy;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zze zze = new zze();
            zzmf = zze;
            zzegb.zza(zze.class, zze);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zzc extends zzegb<zzc, zza> implements zzehn {
        private static volatile zzehy<zzc> zzel;
        /* access modifiers changed from: private */
        public static final zzc zzlk;
        private int zzdw;
        private zzeer zzlg = zzeer.zzhzv;
        private zzeer zzlh = zzeer.zzhzv;
        private zzeer zzli = zzeer.zzhzv;
        private zzeer zzlj = zzeer.zzhzv;

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public static final class zza extends zzegb.zzb<zzc, zza> implements zzehn {
            private zza() {
                super(zzc.zzlk);
            }

            public final zza zza(zzeer zzeer) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzc) this.zziel).zze(zzeer);
                return this;
            }

            public final zza zzb(zzeer zzeer) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzc) this.zziel).zzf(zzeer);
                return this;
            }

            public final zza zzc(zzeer zzeer) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzc) this.zziel).zzg(zzeer);
                return this;
            }

            public final zza zzd(zzeer zzeer) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzc) this.zziel).zzh(zzeer);
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final zzeer zzbb() {
            return this.zzlg;
        }

        /* access modifiers changed from: private */
        public final void zze(zzeer zzeer) {
            zzeer.getClass();
            this.zzdw |= 1;
            this.zzlg = zzeer;
        }

        public final zzeer zzbc() {
            return this.zzlh;
        }

        /* access modifiers changed from: private */
        public final void zzf(zzeer zzeer) {
            zzeer.getClass();
            this.zzdw |= 2;
            this.zzlh = zzeer;
        }

        public final zzeer zzbd() {
            return this.zzli;
        }

        /* access modifiers changed from: private */
        public final void zzg(zzeer zzeer) {
            zzeer.getClass();
            this.zzdw |= 4;
            this.zzli = zzeer;
        }

        public final zzeer zzbe() {
            return this.zzlj;
        }

        /* access modifiers changed from: private */
        public final void zzh(zzeer zzeer) {
            zzeer.getClass();
            this.zzdw |= 8;
            this.zzlj = zzeer;
        }

        public static zzc zzb(byte[] bArr, zzefo zzefo) throws zzegl {
            return (zzc) zzegb.zza(zzlk, bArr, zzefo);
        }

        public static zza zzbf() {
            return (zza) zzlk.zzbfc();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzlk, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzdw", "zzlg", "zzlh", "zzli", "zzlj"});
                case 4:
                    return zzlk;
                case 5:
                    zzehy<zzc> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zzc.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzlk);
                                zzel = zzehy;
                            }
                        }
                    }
                    return zzehy;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzc zzc = new zzc();
            zzlk = zzc;
            zzegb.zza(zzc.class, zzc);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zzf extends zzegb<zzf, zza> implements zzehn {
        private static volatile zzehy<zzf> zzel;
        /* access modifiers changed from: private */
        public static final zzf zzmh;
        private int zzdw;
        private int zzhv = 1;
        private int zzhw = 1;
        private zzeer zzlh = zzeer.zzhzv;
        private zzegm<zzeer> zzmg = zzbfh();

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
        public static final class zza extends zzegb.zzb<zzf, zza> implements zzehn {
            private zza() {
                super(zzf.zzmh);
            }

            public final zza zzj(zzeer zzeer) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzf) this.zziel).zzi(zzeer);
                return this;
            }

            public final zza zzk(zzeer zzeer) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzf) this.zziel).zzf(zzeer);
                return this;
            }

            public final zza zzb(zzcm zzcm) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzf) this.zziel).zza(zzcm);
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzi(zzeer zzeer) {
            zzeer.getClass();
            if (!this.zzmg.zzbcy()) {
                this.zzmg = zzegb.zza(this.zzmg);
            }
            this.zzmg.add(zzeer);
        }

        /* access modifiers changed from: private */
        public final void zzf(zzeer zzeer) {
            zzeer.getClass();
            this.zzdw |= 1;
            this.zzlh = zzeer;
        }

        /* access modifiers changed from: private */
        public final void zza(zzcm zzcm) {
            this.zzhv = zzcm.zzw();
            this.zzdw |= 4;
        }

        public static zza zzbm() {
            return (zza) zzmh.zzbfc();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zzdv[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzmh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzdw", "zzmg", "zzlh", "zzhw", zzcs.zzx(), "zzhv", zzcm.zzx()});
                case 4:
                    return zzmh;
                case 5:
                    zzehy<zzf> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zzf.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzmh);
                                zzel = zzehy;
                            }
                        }
                    }
                    return zzehy;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzf zzf = new zzf();
            zzmh = zzf;
            zzegb.zza(zzf.class, zzf);
        }
    }
}
