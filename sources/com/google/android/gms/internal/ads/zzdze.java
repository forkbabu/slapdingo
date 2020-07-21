package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdze extends zzegb<zzdze, zza> implements zzehn {
    private static volatile zzehy<zzdze> zzel;
    /* access modifiers changed from: private */
    public static final zzdze zzhsc;
    private zzdzh zzhrz;
    private int zzhsb;

    private zzdze() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdze, zza> implements zzehn {
        private zza() {
            super(zzdze.zzhsc);
        }

        /* synthetic */ zza(zzdzf zzdzf) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzhsb;
    }

    public final zzdzh zzayc() {
        zzdzh zzdzh = this.zzhrz;
        return zzdzh == null ? zzdzh.zzayh() : zzdzh;
    }

    public static zzdze zzc(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdze) zzegb.zza(zzhsc, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzf.zzdv[i - 1]) {
            case 1:
                return new zzdze();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhsb", "zzhrz"});
            case 4:
                return zzhsc;
            case 5:
                zzehy<zzdze> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdze.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsc);
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
        zzdze zzdze = new zzdze();
        zzhsc = zzdze;
        zzegb.zza(zzdze.class, zzdze);
    }
}
