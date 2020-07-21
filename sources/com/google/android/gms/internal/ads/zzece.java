package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzece extends zzegb<zzece, zza> implements zzehn {
    private static volatile zzehy<zzece> zzel;
    /* access modifiers changed from: private */
    public static final zzece zzhwp;
    private int zzhrx;
    private zzeer zzhry = zzeer.zzhzv;

    private zzece() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzece, zza> implements zzehn {
        private zza() {
            super(zzece.zzhwp);
        }

        public final zza zzfm(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzece) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzag(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzece) this.zziel).zzs(zzeer);
            return this;
        }

        /* synthetic */ zza(zzecd zzecd) {
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

    public static zzece zzw(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzece) zzegb.zza(zzhwp, zzeer, zzefo);
    }

    public static zza zzbcg() {
        return (zza) zzhwp.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzecd.zzdv[i - 1]) {
            case 1:
                return new zzece();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhwp, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhrx", "zzhry"});
            case 4:
                return zzhwp;
            case 5:
                zzehy<zzece> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzece.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhwp);
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
        zzece zzece = new zzece();
        zzhwp = zzece;
        zzegb.zza(zzece.class, zzece);
    }
}
