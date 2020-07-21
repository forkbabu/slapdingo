package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebi extends zzegb<zzebi, zza> implements zzehn {
    private static volatile zzehy<zzebi> zzel;
    /* access modifiers changed from: private */
    public static final zzebi zzhvg;
    private String zzhuo = "";
    private zzeer zzhup = zzeer.zzhzv;
    private int zzhvf;

    private zzebi() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzebi, zza> implements zzehn {
        private zza() {
            super(zzebi.zzhvg);
        }

        /* synthetic */ zza(zzebk zzebk) {
            this();
        }
    }

    public final String zzbar() {
        return this.zzhuo;
    }

    public final zzeer zzbas() {
        return this.zzhup;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebk.zzdv[i - 1]) {
            case 1:
                return new zzebi();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhvg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhuo", "zzhup", "zzhvf"});
            case 4:
                return zzhvg;
            case 5:
                zzehy<zzebi> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebi.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhvg);
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

    public static zzebi zzbax() {
        return zzhvg;
    }

    static {
        zzebi zzebi = new zzebi();
        zzhvg = zzebi;
        zzegb.zza(zzebi.class, zzebi);
    }
}
