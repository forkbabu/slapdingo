package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebc extends zzegb<zzebc, zza> implements zzehn {
    private static volatile zzehy<zzebc> zzel;
    /* access modifiers changed from: private */
    public static final zzebc zzhun;
    private int zzhsd;
    private int zzhum;

    private zzebc() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzebc, zza> implements zzehn {
        private zza() {
            super(zzebc.zzhun);
        }

        /* synthetic */ zza(zzebd zzebd) {
            this();
        }
    }

    public final zzeav zzbao() {
        zzeav zzfb = zzeav.zzfb(this.zzhum);
        return zzfb == null ? zzeav.UNRECOGNIZED : zzfb;
    }

    public final int zzayg() {
        return this.zzhsd;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebd.zzdv[i - 1]) {
            case 1:
                return new zzebc();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhun, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzhum", "zzhsd"});
            case 4:
                return zzhun;
            case 5:
                zzehy<zzebc> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebc.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhun);
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

    public static zzebc zzbap() {
        return zzhun;
    }

    static {
        zzebc zzebc = new zzebc();
        zzhun = zzebc;
        zzegb.zza(zzebc.class, zzebc);
    }
}
