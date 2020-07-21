package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebv extends zzegb<zzebv, zza> implements zzehn {
    private static volatile zzehy<zzebv> zzel;
    /* access modifiers changed from: private */
    public static final zzebv zzhwb;
    private int zzhrx;
    private zzeby zzhwa;

    private zzebv() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzebv, zza> implements zzehn {
        private zza() {
            super(zzebv.zzhwb);
        }

        public final zza zzfk(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebv) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzb(zzeby zzeby) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebv) this.zziel).zza(zzeby);
            return this;
        }

        /* synthetic */ zza(zzebw zzebw) {
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

    public final zzeby zzbbw() {
        zzeby zzeby = this.zzhwa;
        return zzeby == null ? zzeby.zzbcb() : zzeby;
    }

    /* access modifiers changed from: private */
    public final void zza(zzeby zzeby) {
        zzeby.getClass();
        this.zzhwa = zzeby;
    }

    public static zzebv zzu(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzebv) zzegb.zza(zzhwb, zzeer, zzefo);
    }

    public static zza zzbbx() {
        return (zza) zzhwb.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebw.zzdv[i - 1]) {
            case 1:
                return new zzebv();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhwb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhrx", "zzhwa"});
            case 4:
                return zzhwb;
            case 5:
                zzehy<zzebv> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebv.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhwb);
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
        zzebv zzebv = new zzebv();
        zzhwb = zzebv;
        zzegb.zza(zzebv.class, zzebv);
    }
}
