package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeal extends zzegb<zzeal, zza> implements zzehn {
    private static volatile zzehy<zzeal> zzel;
    /* access modifiers changed from: private */
    public static final zzeal zzhth;
    private zzeam zzhtg;

    private zzeal() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeal, zza> implements zzehn {
        private zza() {
            super(zzeal.zzhth);
        }

        /* synthetic */ zza(zzeak zzeak) {
            this();
        }
    }

    public final zzeam zzazo() {
        zzeam zzeam = this.zzhtg;
        return zzeam == null ? zzeam.zzazt() : zzeam;
    }

    public static zzeal zzn(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzeal) zzegb.zza(zzhth, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeak.zzdv[i - 1]) {
            case 1:
                return new zzeal();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhth, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzhtg"});
            case 4:
                return zzhth;
            case 5:
                zzehy<zzeal> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeal.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhth);
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
        zzeal zzeal = new zzeal();
        zzhth = zzeal;
        zzegb.zza(zzeal.class, zzeal);
    }
}
