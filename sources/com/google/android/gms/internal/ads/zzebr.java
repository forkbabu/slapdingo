package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebr extends zzegb<zzebr, zza> implements zzehn {
    private static volatile zzehy<zzebr> zzel;
    /* access modifiers changed from: private */
    public static final zzebr zzhvx;
    private int zzhrx;
    private zzebu zzhvw;

    private zzebr() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzebr, zza> implements zzehn {
        private zza() {
            super(zzebr.zzhvx);
        }

        public final zza zzfj(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebr) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzb(zzebu zzebu) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebr) this.zziel).zza(zzebu);
            return this;
        }

        /* synthetic */ zza(zzebs zzebs) {
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

    public final zzebu zzbbq() {
        zzebu zzebu = this.zzhvw;
        return zzebu == null ? zzebu.zzbbu() : zzebu;
    }

    /* access modifiers changed from: private */
    public final void zza(zzebu zzebu) {
        zzebu.getClass();
        this.zzhvw = zzebu;
    }

    public static zzebr zzs(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzebr) zzegb.zza(zzhvx, zzeer, zzefo);
    }

    public static zza zzbbr() {
        return (zza) zzhvx.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebs.zzdv[i - 1]) {
            case 1:
                return new zzebr();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhvx, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhrx", "zzhvw"});
            case 4:
                return zzhvx;
            case 5:
                zzehy<zzebr> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebr.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhvx);
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
        zzebr zzebr = new zzebr();
        zzhvx = zzebr;
        zzegb.zza(zzebr.class, zzebr);
    }
}
