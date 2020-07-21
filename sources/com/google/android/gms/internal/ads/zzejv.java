package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzejv {

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb<zza, zzb> implements zzehn {
        private static volatile zzehy<zza> zzel;
        /* access modifiers changed from: private */
        public static final zza zzilm;
        private int zzdw;
        private int zzilf;
        private C0010zza zzilg;
        private zzeer zzilh = zzeer.zzhzv;
        private zzeer zzili = zzeer.zzhzv;
        private boolean zzilj;
        private boolean zzilk;
        private byte zzill = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzejv$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class C0010zza extends zzegb<C0010zza, C0011zza> implements zzehn {
            private static volatile zzehy<C0010zza> zzel;
            /* access modifiers changed from: private */
            public static final C0010zza zzilr;
            private int zzdw;
            private String zziln = "";
            private String zzilo = "";
            private String zzilp = "";
            private int zzilq;

            private C0010zza() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzejv$zza$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class C0011zza extends zzegb.zzb<C0010zza, C0011zza> implements zzehn {
                private C0011zza() {
                    super(C0010zza.zzilr);
                }

                /* synthetic */ C0011zza(zzejx zzejx) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzejx.zzdv[i - 1]) {
                    case 1:
                        return new C0010zza();
                    case 2:
                        return new C0011zza(null);
                    case 3:
                        return zza(zzilr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdw", "zziln", "zzilo", "zzilp", "zzilq"});
                    case 4:
                        return zzilr;
                    case 5:
                        zzehy<C0010zza> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (C0010zza.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzilr);
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
                C0010zza zza = new C0010zza();
                zzilr = zza;
                zzegb.zza(C0010zza.class, zza);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public enum zzc implements zzegg {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzegf<zzc> zzes = new zzejz();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzegg
            public final int zzw() {
                return this.value;
            }

            public static zzc zzhs(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            public static zzegi zzx() {
                return zzejy.zzeu;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzc(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zzb extends zzegb.zzb<zza, zzb> implements zzehn {
            private zzb() {
                super(zza.zzilm);
            }

            /* synthetic */ zzb(zzejx zzejx) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzejx.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza(zzilm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdw", "zzilf", zzc.zzx(), "zzilg", "zzilh", "zzili", "zzilj", "zzilk"});
                case 4:
                    return zzilm;
                case 5:
                    zzehy<zza> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zza.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzilm);
                                zzel = zzehy;
                            }
                        }
                    }
                    return zzehy;
                case 6:
                    return Byte.valueOf(this.zzill);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzill = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzilm = zza;
            zzegb.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zzb extends zzegb<zzb, zza> implements zzehn {
        private static volatile zzehy<zzb> zzel;
        /* access modifiers changed from: private */
        public static final zzb zzimn;
        private int zzbzv;
        private int zzdw;
        private zzeer zzilh = zzeer.zzhzv;
        private byte zzill = 2;
        private String zzilo = "";
        private int zzily;
        private String zzilz = "";
        private String zzima = "";
        private C0012zzb zzimb;
        private zzegm<zzh> zzimc = zzbfh();
        private String zzimd = "";
        private zzf zzime;
        private boolean zzimf;
        private zzegm<String> zzimg = zzegb.zzbfh();
        private String zzimh = "";
        private boolean zzimi;
        private boolean zzimj;
        private zzi zzimk;
        private zzegm<String> zziml = zzegb.zzbfh();
        private zzegm<String> zzimm = zzegb.zzbfh();

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zze extends zzegb<zze, zza> implements zzehn {
            private static volatile zzehy<zze> zzel;
            /* access modifiers changed from: private */
            public static final zze zzine;
            private int zzdw;
            private byte zzill = 2;
            private zzegm<zzc> zzimt = zzbfh();
            private zzeer zzimu = zzeer.zzhzv;
            private zzeer zzimv = zzeer.zzhzv;
            private int zzimw;
            private C0014zzb zzinc;
            private zzeer zzind = zzeer.zzhzv;

            /* renamed from: com.google.android.gms.internal.ads.zzejv$zzb$zze$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class C0014zzb extends zzegb<C0014zzb, zza> implements zzehn {
                private static volatile zzehy<C0014zzb> zzel;
                /* access modifiers changed from: private */
                public static final C0014zzb zzinh;
                private int zzdw;
                private zzeer zzina = zzeer.zzhzv;
                private int zzinf;
                private zzeer zzing = zzeer.zzhzv;

                private C0014zzb() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzejv$zzb$zze$zzb$zza */
                /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
                public static final class zza extends zzegb.zzb<C0014zzb, zza> implements zzehn {
                    private zza() {
                        super(C0014zzb.zzinh);
                    }

                    /* synthetic */ zza(zzejx zzejx) {
                        this();
                    }
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzegb
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzejx.zzdv[i - 1]) {
                        case 1:
                            return new C0014zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zza(zzinh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzinf", "zzing", "zzina"});
                        case 4:
                            return zzinh;
                        case 5:
                            zzehy<C0014zzb> zzehy = zzel;
                            if (zzehy == null) {
                                synchronized (C0014zzb.class) {
                                    zzehy = zzel;
                                    if (zzehy == null) {
                                        zzehy = new zzegb.zza<>(zzinh);
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
                    C0014zzb zzb = new C0014zzb();
                    zzinh = zzb;
                    zzegb.zza(C0014zzb.class, zzb);
                }
            }

            private zze() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class zza extends zzegb.zzb<zze, zza> implements zzehn {
                private zza() {
                    super(zze.zzine);
                }

                /* synthetic */ zza(zzejx zzejx) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzejx.zzdv[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzine, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdw", "zzinc", "zzimt", zzc.class, "zzimu", "zzimv", "zzimw", "zzind"});
                    case 4:
                        return zzine;
                    case 5:
                        zzehy<zze> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (zze.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzine);
                                    zzel = zzehy;
                                }
                            }
                        }
                        return zzehy;
                    case 6:
                        return Byte.valueOf(this.zzill);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzill = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zze zze = new zze();
                zzine = zze;
                zzegb.zza(zze.class, zze);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public enum zzg implements zzegg {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzegf<zzg> zzes = new zzekd();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzegg
            public final int zzw() {
                return this.value;
            }

            public static zzg zzhu(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzegi zzx() {
                return zzekc.zzeu;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzg(int i) {
                this.value = i;
            }
        }

        private zzb() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzejv$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class C0012zzb extends zzegb<C0012zzb, zza> implements zzehn {
            private static volatile zzehy<C0012zzb> zzel;
            /* access modifiers changed from: private */
            public static final C0012zzb zzimp;
            private int zzdw;
            private String zzimo = "";

            private C0012zzb() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzejv$zzb$zzb$zza */
            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class zza extends zzegb.zzb<C0012zzb, zza> implements zzehn {
                private zza() {
                    super(C0012zzb.zzimp);
                }

                public final zza zzia(String str) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((C0012zzb) this.zziel).zzib(str);
                    return this;
                }

                /* synthetic */ zza(zzejx zzejx) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzib(String str) {
                str.getClass();
                this.zzdw |= 1;
                this.zzimo = str;
            }

            public static zza zzbil() {
                return (zza) zzimp.zzbfc();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzejx.zzdv[i - 1]) {
                    case 1:
                        return new C0012zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzimp, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdw", "zzimo"});
                    case 4:
                        return zzimp;
                    case 5:
                        zzehy<C0012zzb> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (C0012zzb.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzimp);
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
                C0012zzb zzb = new C0012zzb();
                zzimp = zzb;
                zzegb.zza(C0012zzb.class, zzb);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zzc extends zzegb<zzc, zza> implements zzehn {
            private static volatile zzehy<zzc> zzel;
            /* access modifiers changed from: private */
            public static final zzc zzimr;
            private int zzdw;
            private zzeer zzhup = zzeer.zzhzv;
            private byte zzill = 2;
            private zzeer zzimq = zzeer.zzhzv;

            private zzc() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class zza extends zzegb.zzb<zzc, zza> implements zzehn {
                private zza() {
                    super(zzc.zzimr);
                }

                public final zza zzan(zzeer zzeer) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzc) this.zziel).zzap(zzeer);
                    return this;
                }

                public final zza zzao(zzeer zzeer) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzc) this.zziel).zzae(zzeer);
                    return this;
                }

                /* synthetic */ zza(zzejx zzejx) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzap(zzeer zzeer) {
                zzeer.getClass();
                this.zzdw |= 1;
                this.zzimq = zzeer;
            }

            /* access modifiers changed from: private */
            public final void zzae(zzeer zzeer) {
                zzeer.getClass();
                this.zzdw |= 2;
                this.zzhup = zzeer;
            }

            public static zza zzbin() {
                return (zza) zzimr.zzbfc();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzejx.zzdv[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzimr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdw", "zzimq", "zzhup"});
                    case 4:
                        return zzimr;
                    case 5:
                        zzehy<zzc> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (zzc.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzimr);
                                    zzel = zzehy;
                                }
                            }
                        }
                        return zzehy;
                    case 6:
                        return Byte.valueOf(this.zzill);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzill = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzc zzc = new zzc();
                zzimr = zzc;
                zzegb.zza(zzc.class, zzc);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zzd extends zzegb<zzd, zza> implements zzehn {
            private static volatile zzehy<zzd> zzel;
            /* access modifiers changed from: private */
            public static final zzd zzimx;
            private int zzdw;
            private byte zzill = 2;
            private C0013zzb zzims;
            private zzegm<zzc> zzimt = zzbfh();
            private zzeer zzimu = zzeer.zzhzv;
            private zzeer zzimv = zzeer.zzhzv;
            private int zzimw;

            /* renamed from: com.google.android.gms.internal.ads.zzejv$zzb$zzd$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class C0013zzb extends zzegb<C0013zzb, zza> implements zzehn {
                private static volatile zzehy<C0013zzb> zzel;
                /* access modifiers changed from: private */
                public static final C0013zzb zzinb;
                private int zzdw;
                private zzeer zzimy = zzeer.zzhzv;
                private zzeer zzimz = zzeer.zzhzv;
                private zzeer zzina = zzeer.zzhzv;

                private C0013zzb() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzejv$zzb$zzd$zzb$zza */
                /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
                public static final class zza extends zzegb.zzb<C0013zzb, zza> implements zzehn {
                    private zza() {
                        super(C0013zzb.zzinb);
                    }

                    /* synthetic */ zza(zzejx zzejx) {
                        this();
                    }
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzegb
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzejx.zzdv[i - 1]) {
                        case 1:
                            return new C0013zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zza(zzinb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzimy", "zzimz", "zzina"});
                        case 4:
                            return zzinb;
                        case 5:
                            zzehy<C0013zzb> zzehy = zzel;
                            if (zzehy == null) {
                                synchronized (C0013zzb.class) {
                                    zzehy = zzel;
                                    if (zzehy == null) {
                                        zzehy = new zzegb.zza<>(zzinb);
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
                    C0013zzb zzb = new C0013zzb();
                    zzinb = zzb;
                    zzegb.zza(C0013zzb.class, zzb);
                }
            }

            private zzd() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class zza extends zzegb.zzb<zzd, zza> implements zzehn {
                private zza() {
                    super(zzd.zzimx);
                }

                public final zza zza(zzc zzc) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzd) this.zziel).zzb(zzc);
                    return this;
                }

                /* synthetic */ zza(zzejx zzejx) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzb(zzc zzc) {
                zzc.getClass();
                if (!this.zzimt.zzbcy()) {
                    this.zzimt = zzegb.zza(this.zzimt);
                }
                this.zzimt.add(zzc);
            }

            public static zza zzbip() {
                return (zza) zzimx.zzbfc();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzejx.zzdv[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzimx, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdw", "zzims", "zzimt", zzc.class, "zzimu", "zzimv", "zzimw"});
                    case 4:
                        return zzimx;
                    case 5:
                        zzehy<zzd> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (zzd.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzimx);
                                    zzel = zzehy;
                                }
                            }
                        }
                        return zzehy;
                    case 6:
                        return Byte.valueOf(this.zzill);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzill = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzd zzd = new zzd();
                zzimx = zzd;
                zzegb.zza(zzd.class, zzd);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zzf extends zzegb<zzf, zza> implements zzehn {
            private static volatile zzehy<zzf> zzel;
            /* access modifiers changed from: private */
            public static final zzf zzink;
            private int zzbzv;
            private int zzdw;
            private String zzini = "";
            private zzeer zzinj = zzeer.zzhzv;

            /* renamed from: com.google.android.gms.internal.ads.zzejv$zzb$zzf$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public enum C0015zzb implements zzegg {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzegf<C0015zzb> zzes = new zzeka();
                private final int value;

                @Override // com.google.android.gms.internal.ads.zzegg
                public final int zzw() {
                    return this.value;
                }

                public static C0015zzb zzht(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                public static zzegi zzx() {
                    return zzekb.zzeu;
                }

                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
                }

                private C0015zzb(int i) {
                    this.value = i;
                }
            }

            private zzf() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class zza extends zzegb.zzb<zzf, zza> implements zzehn {
                private zza() {
                    super(zzf.zzink);
                }

                public final zza zza(C0015zzb zzb) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzf) this.zziel).zzb(zzb);
                    return this;
                }

                public final zza zzic(String str) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzf) this.zziel).setMimeType(str);
                    return this;
                }

                public final zza zzaq(zzeer zzeer) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzf) this.zziel).zzar(zzeer);
                    return this;
                }

                /* synthetic */ zza(zzejx zzejx) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzb(C0015zzb zzb) {
                this.zzbzv = zzb.zzw();
                this.zzdw |= 1;
            }

            /* access modifiers changed from: private */
            public final void setMimeType(String str) {
                str.getClass();
                this.zzdw |= 2;
                this.zzini = str;
            }

            /* access modifiers changed from: private */
            public final void zzar(zzeer zzeer) {
                zzeer.getClass();
                this.zzdw |= 4;
                this.zzinj = zzeer;
            }

            public static zza zzbiu() {
                return (zza) zzink.zzbfc();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzejx.zzdv[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzink, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzbzv", C0015zzb.zzx(), "zzini", "zzinj"});
                    case 4:
                        return zzink;
                    case 5:
                        zzehy<zzf> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (zzf.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzink);
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
                zzink = zzf;
                zzegb.zza(zzf.class, zzf);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zzh extends zzegb<zzh, C0016zzb> implements zzehn {
            private static volatile zzehy<zzh> zzel;
            /* access modifiers changed from: private */
            public static final zzh zziom;
            private int zzdw;
            private byte zzill = 2;
            private String zzilo = "";
            private int zzioe;
            private zzd zziof;
            private zze zziog;
            private int zzioh;
            private zzegh zzioi = zzbff();
            private String zzioj = "";
            private int zziok;
            private zzegm<String> zziol = zzegb.zzbfh();

            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public enum zza implements zzegg {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzegf<zza> zzes = new zzekf();
                private final int value;

                @Override // com.google.android.gms.internal.ads.zzegg
                public final int zzw() {
                    return this.value;
                }

                public static zza zzhv(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                public static zzegi zzx() {
                    return zzeke.zzeu;
                }

                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
                }

                private zza(int i) {
                    this.value = i;
                }
            }

            private zzh() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzejv$zzb$zzh$zzb  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class C0016zzb extends zzegb.zzb<zzh, C0016zzb> implements zzehn {
                private C0016zzb() {
                    super(zzh.zziom);
                }

                public final C0016zzb zzhw(int i) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzh) this.zziel).setId(i);
                    return this;
                }

                public final C0016zzb zzif(String str) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzh) this.zziel).setUrl(str);
                    return this;
                }

                public final C0016zzb zzb(zzd zzd) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzh) this.zziel).zza(zzd);
                    return this;
                }

                public final C0016zzb zzb(zza zza) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzh) this.zziel).zza(zza);
                    return this;
                }

                public final C0016zzb zzig(String str) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzh) this.zziel).zzid(str);
                    return this;
                }

                /* synthetic */ C0016zzb(zzejx zzejx) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void setId(int i) {
                this.zzdw |= 1;
                this.zzioe = i;
            }

            public final String getUrl() {
                return this.zzilo;
            }

            /* access modifiers changed from: private */
            public final void setUrl(String str) {
                str.getClass();
                this.zzdw |= 2;
                this.zzilo = str;
            }

            /* access modifiers changed from: private */
            public final void zza(zzd zzd) {
                zzd.getClass();
                this.zziof = zzd;
                this.zzdw |= 4;
            }

            /* access modifiers changed from: private */
            public final void zza(zza zza2) {
                this.zziok = zza2.zzw();
                this.zzdw |= 64;
            }

            public final int zzbiw() {
                return this.zziol.size();
            }

            /* access modifiers changed from: private */
            public final void zzid(String str) {
                str.getClass();
                if (!this.zziol.zzbcy()) {
                    this.zziol = zzegb.zza(this.zziol);
                }
                this.zziol.add(str);
            }

            public static C0016zzb zzbix() {
                return (C0016zzb) zziom.zzbfc();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 1;
                switch (zzejx.zzdv[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0016zzb(null);
                    case 3:
                        return zza(zziom, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdw", "zzioe", "zzilo", "zziof", "zziog", "zzioh", "zzioi", "zzioj", "zziok", zza.zzx(), "zziol"});
                    case 4:
                        return zziom;
                    case 5:
                        zzehy<zzh> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (zzh.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zziom);
                                    zzel = zzehy;
                                }
                            }
                        }
                        return zzehy;
                    case 6:
                        return Byte.valueOf(this.zzill);
                    case 7:
                        if (obj == null) {
                            i2 = 0;
                        }
                        this.zzill = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzh zzh = new zzh();
                zziom = zzh;
                zzegb.zza(zzh.class, zzh);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zzi extends zzegb<zzi, zza> implements zzehn {
            private static volatile zzehy<zzi> zzel;
            /* access modifiers changed from: private */
            public static final zzi zzioq;
            private int zzdw;
            private String zzion = "";
            private long zzioo;
            private boolean zziop;

            private zzi() {
            }

            /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
            public static final class zza extends zzegb.zzb<zzi, zza> implements zzehn {
                private zza() {
                    super(zzi.zzioq);
                }

                public final zza zzih(String str) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzi) this.zziel).zzie(str);
                    return this;
                }

                public final zza zzfu(long j) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzi) this.zziel).zzft(j);
                    return this;
                }

                public final zza zzbx(boolean z) {
                    if (((zzegb.zzb) this).zziem) {
                        zzbfm();
                        ((zzegb.zzb) this).zziem = false;
                    }
                    ((zzi) this.zziel).zzbw(z);
                    return this;
                }

                /* synthetic */ zza(zzejx zzejx) {
                    this();
                }
            }

            /* access modifiers changed from: private */
            public final void zzie(String str) {
                str.getClass();
                this.zzdw |= 1;
                this.zzion = str;
            }

            /* access modifiers changed from: private */
            public final void zzft(long j) {
                this.zzdw |= 2;
                this.zzioo = j;
            }

            /* access modifiers changed from: private */
            public final void zzbw(boolean z) {
                this.zzdw |= 4;
                this.zziop = z;
            }

            public static zza zzbiz() {
                return (zza) zzioq.zzbfc();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzegb
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzejx.zzdv[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzioq, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdw", "zzion", "zzioo", "zziop"});
                    case 4:
                        return zzioq;
                    case 5:
                        zzehy<zzi> zzehy = zzel;
                        if (zzehy == null) {
                            synchronized (zzi.class) {
                                zzehy = zzel;
                                if (zzehy == null) {
                                    zzehy = new zzegb.zza<>(zzioq);
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
                zzi zzi = new zzi();
                zzioq = zzi;
                zzegb.zza(zzi.class, zzi);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zza extends zzegb.zzb<zzb, zza> implements zzehn {
            private zza() {
                super(zzb.zzimn);
            }

            public final zza zza(zzg zzg) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzb(zzg);
                return this;
            }

            public final String getUrl() {
                return ((zzb) this.zziel).getUrl();
            }

            public final zza zzhw(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).setUrl(str);
                return this;
            }

            public final zza zzhx(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzhz(str);
                return this;
            }

            public final zza zza(C0012zzb zzb) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzb(zzb);
                return this;
            }

            public final List<zzh> zzbif() {
                return Collections.unmodifiableList(((zzb) this.zziel).zzbif());
            }

            public final zza zza(zzh zzh) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzb(zzh);
                return this;
            }

            public final String zzbig() {
                return ((zzb) this.zziel).zzbig();
            }

            public final zza zzhy(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzdz(str);
                return this;
            }

            public final zza zzbih() {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzbii();
                return this;
            }

            public final zza zza(zzf zzf) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzb(zzf);
                return this;
            }

            public final zza zza(zzi zzi) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzb(zzi);
                return this;
            }

            public final zza zzm(Iterable<String> iterable) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzo(iterable);
                return this;
            }

            public final zza zzn(Iterable<String> iterable) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zzb) this.zziel).zzp(iterable);
                return this;
            }

            /* synthetic */ zza(zzejx zzejx) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(zzg zzg2) {
            this.zzbzv = zzg2.zzw();
            this.zzdw |= 1;
        }

        public final String getUrl() {
            return this.zzilo;
        }

        /* access modifiers changed from: private */
        public final void setUrl(String str) {
            str.getClass();
            this.zzdw |= 4;
            this.zzilo = str;
        }

        /* access modifiers changed from: private */
        public final void zzhz(String str) {
            str.getClass();
            this.zzdw |= 8;
            this.zzilz = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(C0012zzb zzb) {
            zzb.getClass();
            this.zzimb = zzb;
            this.zzdw |= 32;
        }

        public final List<zzh> zzbif() {
            return this.zzimc;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzh zzh2) {
            zzh2.getClass();
            if (!this.zzimc.zzbcy()) {
                this.zzimc = zzegb.zza(this.zzimc);
            }
            this.zzimc.add(zzh2);
        }

        public final String zzbig() {
            return this.zzimd;
        }

        /* access modifiers changed from: private */
        public final void zzdz(String str) {
            str.getClass();
            this.zzdw |= 64;
            this.zzimd = str;
        }

        /* access modifiers changed from: private */
        public final void zzbii() {
            this.zzdw &= -65;
            this.zzimd = zzimn.zzimd;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzf zzf2) {
            zzf2.getClass();
            this.zzime = zzf2;
            this.zzdw |= 128;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzi zzi2) {
            zzi2.getClass();
            this.zzimk = zzi2;
            this.zzdw |= 8192;
        }

        /* access modifiers changed from: private */
        public final void zzo(Iterable<String> iterable) {
            if (!this.zziml.zzbcy()) {
                this.zziml = zzegb.zza(this.zziml);
            }
            zzeeh.zza(iterable, this.zziml);
        }

        /* access modifiers changed from: private */
        public final void zzp(Iterable<String> iterable) {
            if (!this.zzimm.zzbcy()) {
                this.zzimm = zzegb.zza(this.zzimm);
            }
            zzeeh.zza(iterable, this.zzimm);
        }

        public static zza zzbij() {
            return (zza) zzimn.zzbfc();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzejx.zzdv[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzimn, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdw", "zzilo", "zzilz", "zzima", "zzimc", zzh.class, "zzimf", "zzimg", "zzimh", "zzimi", "zzimj", "zzbzv", zzg.zzx(), "zzily", zza.zzc.zzx(), "zzimb", "zzimd", "zzime", "zzilh", "zzimk", "zziml", "zzimm"});
                case 4:
                    return zzimn;
                case 5:
                    zzehy<zzb> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zzb.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzimn);
                                zzel = zzehy;
                            }
                        }
                    }
                    return zzehy;
                case 6:
                    return Byte.valueOf(this.zzill);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzill = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzimn = zzb;
            zzegb.zza(zzb.class, zzb);
        }
    }
}
