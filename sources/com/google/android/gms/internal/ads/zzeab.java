package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeab extends zzegb<zzeab, zza> implements zzehn {
    private static volatile zzehy<zzeab> zzel;
    /* access modifiers changed from: private */
    public static final zzeab zzhsv;
    private int zzhrx;
    private int zzhsb;

    private zzeab() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeab, zza> implements zzehn {
        private zza() {
            super(zzeab.zzhsv);
        }

        /* synthetic */ zza(zzeaa zzeaa) {
            this();
        }
    }

    public final int getKeySize() {
        return this.zzhsb;
    }

    public static zzeab zzk(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzeab) zzegb.zza(zzhsv, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeaa.zzdv[i - 1]) {
            case 1:
                return new zzeab();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsv, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzhsb", "zzhrx"});
            case 4:
                return zzhsv;
            case 5:
                zzehy<zzeab> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeab.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsv);
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
        zzeab zzeab = new zzeab();
        zzhsv = zzeab;
        zzegb.zza(zzeab.class, zzeab);
    }
}
