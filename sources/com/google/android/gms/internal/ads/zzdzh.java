package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzh extends zzegb<zzdzh, zza> implements zzehn {
    private static volatile zzehy<zzdzh> zzel;
    /* access modifiers changed from: private */
    public static final zzdzh zzhse;
    private int zzhsd;

    private zzdzh() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzh, zza> implements zzehn {
        private zza() {
            super(zzdzh.zzhse);
        }

        /* synthetic */ zza(zzdzg zzdzg) {
            this();
        }
    }

    public final int zzayg() {
        return this.zzhsd;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzg.zzdv[i - 1]) {
            case 1:
                return new zzdzh();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhse, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhsd"});
            case 4:
                return zzhse;
            case 5:
                zzehy<zzdzh> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzh.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhse);
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

    public static zzdzh zzayh() {
        return zzhse;
    }

    static {
        zzdzh zzdzh = new zzdzh();
        zzhse = zzdzh;
        zzegb.zza(zzdzh.class, zzdzh);
    }
}
