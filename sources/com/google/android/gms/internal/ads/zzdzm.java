package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzm extends zzegb<zzdzm, zza> implements zzehn {
    private static volatile zzehy<zzdzm> zzel;
    /* access modifiers changed from: private */
    public static final zzdzm zzhsm;
    private int zzhrx;
    private zzeer zzhry = zzeer.zzhzv;
    private zzdzq zzhsl;

    private zzdzm() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzm, zza> implements zzehn {
        private zza() {
            super(zzdzm.zzhsm);
        }

        public final zza zzet(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzm) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzc(zzdzq zzdzq) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzm) this.zziel).zzb(zzdzq);
            return this;
        }

        public final zza zzu(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzm) this.zziel).zzs(zzeer);
            return this;
        }

        /* synthetic */ zza(zzdzn zzdzn) {
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

    public final zzdzq zzayq() {
        zzdzq zzdzq = this.zzhsl;
        return zzdzq == null ? zzdzq.zzayx() : zzdzq;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdzq zzdzq) {
        zzdzq.getClass();
        this.zzhsl = zzdzq;
    }

    public final zzeer zzayb() {
        return this.zzhry;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzeer zzeer) {
        zzeer.getClass();
        this.zzhry = zzeer;
    }

    public static zzdzm zzf(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdzm) zzegb.zza(zzhsm, zzeer, zzefo);
    }

    public static zza zzayr() {
        return (zza) zzhsm.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzn.zzdv[i - 1]) {
            case 1:
                return new zzdzm();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsm, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhrx", "zzhsl", "zzhry"});
            case 4:
                return zzhsm;
            case 5:
                zzehy<zzdzm> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzm.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsm);
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

    public static zzdzm zzays() {
        return zzhsm;
    }

    static {
        zzdzm zzdzm = new zzdzm();
        zzhsm = zzdzm;
        zzegb.zza(zzdzm.class, zzdzm);
    }
}
