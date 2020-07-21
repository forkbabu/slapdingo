package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeaf extends zzegb<zzeaf, zza> implements zzehn {
    private static volatile zzehy<zzeaf> zzel;
    /* access modifiers changed from: private */
    public static final zzeaf zzhsx;

    private zzeaf() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeaf, zza> implements zzehn {
        private zza() {
            super(zzeaf.zzhsx);
        }

        /* synthetic */ zza(zzeae zzeae) {
            this();
        }
    }

    public static zzeaf zzm(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzeaf) zzegb.zza(zzhsx, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeae.zzdv[i - 1]) {
            case 1:
                return new zzeaf();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsx, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzhsx;
            case 5:
                zzehy<zzeaf> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeaf.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsx);
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
        zzeaf zzeaf = new zzeaf();
        zzhsx = zzeaf;
        zzegb.zza(zzeaf.class, zzeaf);
    }
}
