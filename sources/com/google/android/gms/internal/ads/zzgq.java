package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzgq extends zzegb<zzgq, zza> implements zzehn {
    /* access modifiers changed from: private */
    public static final zzgq zzaca;
    private static volatile zzehy<zzgq> zzel;
    private zzgr zzabx;
    private zzeer zzaby = zzeer.zzhzv;
    private zzeer zzabz = zzeer.zzhzv;
    private int zzdw;

    private zzgq() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzgq, zza> implements zzehn {
        private zza() {
            super(zzgq.zzaca);
        }

        /* synthetic */ zza(zzgp zzgp) {
            this();
        }
    }

    public final zzgr zzdd() {
        zzgr zzgr = this.zzabx;
        return zzgr == null ? zzgr.zzdn() : zzgr;
    }

    public final zzeer zzde() {
        return this.zzaby;
    }

    public final zzeer zzdf() {
        return this.zzabz;
    }

    public static zzgq zza(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzgq) zzegb.zza(zzaca, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgp.zzdv[i - 1]) {
            case 1:
                return new zzgq();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzaca, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdw", "zzabx", "zzaby", "zzabz"});
            case 4:
                return zzaca;
            case 5:
                zzehy<zzgq> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzgq.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzaca);
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
        zzgq zzgq = new zzgq();
        zzaca = zzgq;
        zzegb.zza(zzgq.class, zzgq);
    }
}
