package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeaq extends zzegb<zzeaq, zza> implements zzehn {
    private static volatile zzehy<zzeaq> zzel;
    /* access modifiers changed from: private */
    public static final zzeaq zzhtq;
    private int zzhrx;
    private zzeam zzhtg;
    private zzeer zzhto = zzeer.zzhzv;
    private zzeer zzhtp = zzeer.zzhzv;

    private zzeaq() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeaq, zza> implements zzehn {
        private zza() {
            super(zzeaq.zzhtq);
        }

        public final zza zzez(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeaq) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzc(zzeam zzeam) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeaq) this.zziel).zzb(zzeam);
            return this;
        }

        public final zza zzab(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeaq) this.zziel).zzy(zzeer);
            return this;
        }

        public final zza zzac(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeaq) this.zziel).zzz(zzeer);
            return this;
        }

        /* synthetic */ zza(zzear zzear) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzhrx;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhrx = i;
    }

    public final zzeam zzazo() {
        zzeam zzeam = this.zzhtg;
        return zzeam == null ? zzeam.zzazt() : zzeam;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzeam zzeam) {
        zzeam.getClass();
        this.zzhtg = zzeam;
    }

    public final zzeer zzazy() {
        return this.zzhto;
    }

    /* access modifiers changed from: private */
    public final void zzy(zzeer zzeer) {
        zzeer.getClass();
        this.zzhto = zzeer;
    }

    public final zzeer zzazz() {
        return this.zzhtp;
    }

    /* access modifiers changed from: private */
    public final void zzz(zzeer zzeer) {
        zzeer.getClass();
        this.zzhtp = zzeer;
    }

    public static zzeaq zzp(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzeaq) zzegb.zza(zzhtq, zzeer, zzefo);
    }

    public static zza zzbaa() {
        return (zza) zzhtq.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzear.zzdv[i - 1]) {
            case 1:
                return new zzeaq();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhtq, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzhrx", "zzhtg", "zzhto", "zzhtp"});
            case 4:
                return zzhtq;
            case 5:
                zzehy<zzeaq> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeaq.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhtq);
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

    public static zzeaq zzbab() {
        return zzhtq;
    }

    static {
        zzeaq zzeaq = new zzeaq();
        zzhtq = zzeaq;
        zzegb.zza(zzeaq.class, zzeaq);
    }
}
