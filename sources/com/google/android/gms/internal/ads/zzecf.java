package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzecf extends zzegb<zzecf, zza> implements zzehn {
    private static volatile zzehy<zzecf> zzel;
    /* access modifiers changed from: private */
    public static final zzecf zzhwq;

    private zzecf() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzecf, zza> implements zzehn {
        private zza() {
            super(zzecf.zzhwq);
        }

        /* synthetic */ zza(zzecg zzecg) {
            this();
        }
    }

    public static zzecf zzx(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzecf) zzegb.zza(zzhwq, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzecg.zzdv[i - 1]) {
            case 1:
                return new zzecf();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhwq, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzhwq;
            case 5:
                zzehy<zzecf> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzecf.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhwq);
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
        zzecf zzecf = new zzecf();
        zzhwq = zzecf;
        zzegb.zza(zzecf.class, zzecf);
    }
}
