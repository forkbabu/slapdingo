package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzx extends zzegb<zzdzx, zza> implements zzehn {
    private static volatile zzehy<zzdzx> zzel;
    /* access modifiers changed from: private */
    public static final zzdzx zzhst;
    private int zzhso;

    private zzdzx() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzx, zza> implements zzehn {
        private zza() {
            super(zzdzx.zzhst);
        }

        /* synthetic */ zza(zzdzw zzdzw) {
            this();
        }
    }

    public final int zzayw() {
        return this.zzhso;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzw.zzdv[i - 1]) {
            case 1:
                return new zzdzx();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhst, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhso"});
            case 4:
                return zzhst;
            case 5:
                zzehy<zzdzx> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzx.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhst);
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

    public static zzdzx zzazd() {
        return zzhst;
    }

    static {
        zzdzx zzdzx = new zzdzx();
        zzhst = zzdzx;
        zzegb.zza(zzdzx.class, zzdzx);
    }
}
