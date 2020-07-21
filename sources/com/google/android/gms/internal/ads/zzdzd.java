package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzd extends zzegb<zzdzd, zza> implements zzehn {
    private static volatile zzehy<zzdzd> zzel;
    /* access modifiers changed from: private */
    public static final zzdzd zzhsa;
    private int zzhrx;
    private zzeer zzhry = zzeer.zzhzv;
    private zzdzh zzhrz;

    private zzdzd() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzd, zza> implements zzehn {
        private zza() {
            super(zzdzd.zzhsa);
        }

        public final zza zzer(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzd) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzt(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzd) this.zziel).zzs(zzeer);
            return this;
        }

        public final zza zzd(zzdzh zzdzh) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzd) this.zziel).zzc(zzdzh);
            return this;
        }

        /* synthetic */ zza(zzdzc zzdzc) {
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

    public final zzdzh zzayc() {
        zzdzh zzdzh = this.zzhrz;
        return zzdzh == null ? zzdzh.zzayh() : zzdzh;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzdzh zzdzh) {
        zzdzh.getClass();
        this.zzhrz = zzdzh;
    }

    public static zzdzd zzb(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdzd) zzegb.zza(zzhsa, zzeer, zzefo);
    }

    public static zza zzayd() {
        return (zza) zzhsa.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzc.zzdv[i - 1]) {
            case 1:
                return new zzdzd();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsa, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzhrx", "zzhry", "zzhrz"});
            case 4:
                return zzhsa;
            case 5:
                zzehy<zzdzd> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzd.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsa);
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
        zzdzd zzdzd = new zzdzd();
        zzhsa = zzdzd;
        zzegb.zza(zzdzd.class, zzdzd);
    }
}
