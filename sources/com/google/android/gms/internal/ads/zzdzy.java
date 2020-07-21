package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzy extends zzegb<zzdzy, zza> implements zzehn {
    private static volatile zzehy<zzdzy> zzel;
    /* access modifiers changed from: private */
    public static final zzdzy zzhsu;
    private int zzhrx;
    private zzeer zzhry = zzeer.zzhzv;

    private zzdzy() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzy, zza> implements zzehn {
        private zza() {
            super(zzdzy.zzhsu);
        }

        public final zza zzev(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzy) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzw(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzy) this.zziel).zzs(zzeer);
            return this;
        }

        /* synthetic */ zza(zzdzz zzdzz) {
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

    public static zzdzy zzj(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdzy) zzegb.zza(zzhsu, zzeer, zzefo);
    }

    public static zza zzazf() {
        return (zza) zzhsu.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzz.zzdv[i - 1]) {
            case 1:
                return new zzdzy();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsu, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhrx", "zzhry"});
            case 4:
                return zzhsu;
            case 5:
                zzehy<zzdzy> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzy.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsu);
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
        zzdzy zzdzy = new zzdzy();
        zzhsu = zzdzy;
        zzegb.zza(zzdzy.class, zzdzy);
    }
}
