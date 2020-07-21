package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeax extends zzegb<zzeax, zza> implements zzehn {
    private static volatile zzehy<zzeax> zzel;
    /* access modifiers changed from: private */
    public static final zzeax zzhuk;
    private int zzhrx;
    private zzeer zzhry = zzeer.zzhzv;
    private zzebc zzhuj;

    private zzeax() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeax, zza> implements zzehn {
        private zza() {
            super(zzeax.zzhuk);
        }

        public final zza zzfc(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeax) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzd(zzebc zzebc) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeax) this.zziel).zzc(zzebc);
            return this;
        }

        public final zza zzad(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeax) this.zziel).zzs(zzeer);
            return this;
        }

        /* synthetic */ zza(zzeaz zzeaz) {
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

    public final zzebc zzbai() {
        zzebc zzebc = this.zzhuj;
        return zzebc == null ? zzebc.zzbap() : zzebc;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzebc zzebc) {
        zzebc.getClass();
        this.zzhuj = zzebc;
    }

    public final zzeer zzayb() {
        return this.zzhry;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzeer zzeer) {
        zzeer.getClass();
        this.zzhry = zzeer;
    }

    public static zzeax zzq(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzeax) zzegb.zza(zzhuk, zzeer, zzefo);
    }

    public static zza zzbaj() {
        return (zza) zzhuk.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeaz.zzdv[i - 1]) {
            case 1:
                return new zzeax();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhuk, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhrx", "zzhuj", "zzhry"});
            case 4:
                return zzhuk;
            case 5:
                zzehy<zzeax> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeax.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhuk);
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

    public static zzeax zzbak() {
        return zzhuk;
    }

    static {
        zzeax zzeax = new zzeax();
        zzhuk = zzeax;
        zzegb.zza(zzeax.class, zzeax);
    }
}
