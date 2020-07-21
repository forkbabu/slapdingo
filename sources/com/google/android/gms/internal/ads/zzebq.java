package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebq extends zzegb<zzebq, zzb> implements zzehn {
    private static volatile zzehy<zzebq> zzel;
    /* access modifiers changed from: private */
    public static final zzebq zzhvu;
    private int zzhvm;
    private zzegm<zza> zzhvt = zzbfh();

    private zzebq() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb<zza, C0009zza> implements zzehn {
        private static volatile zzehy<zza> zzel;
        /* access modifiers changed from: private */
        public static final zza zzhvv;
        private String zzhuo = "";
        private int zzhvf;
        private int zzhvq;
        private int zzhvr;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzebq$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class C0009zza extends zzegb.zzb<zza, C0009zza> implements zzehn {
            private C0009zza() {
                super(zza.zzhvv);
            }

            public final C0009zza zzhp(String str) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzhn(str);
                return this;
            }

            public final C0009zza zzb(zzebg zzebg) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zza(zzebg);
                return this;
            }

            public final C0009zza zzfi(int i) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zzfg(i);
                return this;
            }

            public final C0009zza zzb(zzebz zzebz) {
                if (((zzegb.zzb) this).zziem) {
                    zzbfm();
                    ((zzegb.zzb) this).zziem = false;
                }
                ((zza) this.zziel).zza(zzebz);
                return this;
            }

            /* synthetic */ C0009zza(zzebp zzebp) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzhn(String str) {
            str.getClass();
            this.zzhuo = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzebg zzebg) {
            this.zzhvq = zzebg.zzw();
        }

        /* access modifiers changed from: private */
        public final void zzfg(int i) {
            this.zzhvr = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzebz zzebz) {
            this.zzhvf = zzebz.zzw();
        }

        public static C0009zza zzbbo() {
            return (C0009zza) zzhvv.zzbfc();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzebp.zzdv[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0009zza(null);
                case 3:
                    return zza(zzhvv, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzhuo", "zzhvq", "zzhvr", "zzhvf"});
                case 4:
                    return zzhvv;
                case 5:
                    zzehy<zza> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zza.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzhvv);
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
            zza zza = new zza();
            zzhvv = zza;
            zzegb.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zzb extends zzegb.zzb<zzebq, zzb> implements zzehn {
        private zzb() {
            super(zzebq.zzhvu);
        }

        public final zzb zzfh(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebq) this.zziel).zzff(i);
            return this;
        }

        public final zzb zzb(zza zza) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebq) this.zziel).zza(zza);
            return this;
        }

        /* synthetic */ zzb(zzebp zzebp) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzff(int i) {
        this.zzhvm = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        zza2.getClass();
        if (!this.zzhvt.zzbcy()) {
            this.zzhvt = zzegb.zza(this.zzhvt);
        }
        this.zzhvt.add(zza2);
    }

    public static zzb zzbbm() {
        return (zzb) zzhvu.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebp.zzdv[i - 1]) {
            case 1:
                return new zzebq();
            case 2:
                return new zzb(null);
            case 3:
                return zza(zzhvu, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzhvm", "zzhvt", zza.class});
            case 4:
                return zzhvu;
            case 5:
                zzehy<zzebq> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebq.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhvu);
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
        zzebq zzebq = new zzebq();
        zzhvu = zzebq;
        zzegb.zza(zzebq.class, zzebq);
    }
}
