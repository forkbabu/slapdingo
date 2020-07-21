package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzt extends zzegb<zzdzt, zza> implements zzehn {
    private static volatile zzehy<zzdzt> zzel;
    /* access modifiers changed from: private */
    public static final zzdzt zzhsr;
    private int zzhrx;
    private zzeer zzhry = zzeer.zzhzv;
    private zzdzx zzhsq;

    private zzdzt() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzt, zza> implements zzehn {
        private zza() {
            super(zzdzt.zzhsr);
        }

        public final zza zzeu(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzt) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzb(zzdzx zzdzx) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzt) this.zziel).zza(zzdzx);
            return this;
        }

        public final zza zzv(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzt) this.zziel).zzs(zzeer);
            return this;
        }

        /* synthetic */ zza(zzdzs zzdzs) {
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

    public final zzdzx zzayz() {
        zzdzx zzdzx = this.zzhsq;
        return zzdzx == null ? zzdzx.zzazd() : zzdzx;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdzx zzdzx) {
        zzdzx.getClass();
        this.zzhsq = zzdzx;
    }

    public final zzeer zzayb() {
        return this.zzhry;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzeer zzeer) {
        zzeer.getClass();
        this.zzhry = zzeer;
    }

    public static zzdzt zzh(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdzt) zzegb.zza(zzhsr, zzeer, zzefo);
    }

    public static zza zzaza() {
        return (zza) zzhsr.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzs.zzdv[i - 1]) {
            case 1:
                return new zzdzt();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhrx", "zzhsq", "zzhry"});
            case 4:
                return zzhsr;
            case 5:
                zzehy<zzdzt> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzt.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsr);
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
        zzdzt zzdzt = new zzdzt();
        zzhsr = zzdzt;
        zzegb.zza(zzdzt.class, zzdzt);
    }
}
