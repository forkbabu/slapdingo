package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebu extends zzegb<zzebu, zza> implements zzehn {
    private static volatile zzehy<zzebu> zzel;
    /* access modifiers changed from: private */
    public static final zzebu zzhvz;
    private String zzhvy = "";

    private zzebu() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzebu, zza> implements zzehn {
        private zza() {
            super(zzebu.zzhvz);
        }

        /* synthetic */ zza(zzebt zzebt) {
            this();
        }
    }

    public final String zzbbt() {
        return this.zzhvy;
    }

    public static zzebu zzt(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzebu) zzegb.zza(zzhvz, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebt.zzdv[i - 1]) {
            case 1:
                return new zzebu();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhvz, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzhvy"});
            case 4:
                return zzhvz;
            case 5:
                zzehy<zzebu> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebu.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhvz);
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

    public static zzebu zzbbu() {
        return zzhvz;
    }

    static {
        zzebu zzebu = new zzebu();
        zzhvz = zzebu;
        zzegb.zza(zzebu.class, zzebu);
    }
}
