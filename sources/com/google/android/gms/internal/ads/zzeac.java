package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeac extends zzegb<zzeac, zza> implements zzehn {
    private static volatile zzehy<zzeac> zzel;
    /* access modifiers changed from: private */
    public static final zzeac zzhsw;
    private int zzhrx;
    private zzeer zzhry = zzeer.zzhzv;

    private zzeac() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeac, zza> implements zzehn {
        private zza() {
            super(zzeac.zzhsw);
        }

        public final zza zzew(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeac) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzx(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeac) this.zziel).zzs(zzeer);
            return this;
        }

        /* synthetic */ zza(zzead zzead) {
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

    public final zzeer zzayb() {
        return this.zzhry;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzeer zzeer) {
        zzeer.getClass();
        this.zzhry = zzeer;
    }

    public static zzeac zzl(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzeac) zzegb.zza(zzhsw, zzeer, zzefo);
    }

    public static zza zzazi() {
        return (zza) zzhsw.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzead.zzdv[i - 1]) {
            case 1:
                return new zzeac();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsw, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzhrx", "zzhry"});
            case 4:
                return zzhsw;
            case 5:
                zzehy<zzeac> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeac.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsw);
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
        zzeac zzeac = new zzeac();
        zzhsw = zzeac;
        zzegb.zza(zzeac.class, zzeac);
    }
}
