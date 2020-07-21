package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzl extends zzegb<zzdzl, zza> implements zzehn {
    private static volatile zzehy<zzdzl> zzel;
    /* access modifiers changed from: private */
    public static final zzdzl zzhsk;
    private zzdzp zzhsi;
    private zzebb zzhsj;

    private zzdzl() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzl, zza> implements zzehn {
        private zza() {
            super(zzdzl.zzhsk);
        }

        /* synthetic */ zza(zzdzk zzdzk) {
            this();
        }
    }

    public final zzdzp zzayn() {
        zzdzp zzdzp = this.zzhsi;
        return zzdzp == null ? zzdzp.zzayu() : zzdzp;
    }

    public final zzebb zzayo() {
        zzebb zzebb = this.zzhsj;
        return zzebb == null ? zzebb.zzbam() : zzebb;
    }

    public static zzdzl zze(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdzl) zzegb.zza(zzhsk, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzk.zzdv[i - 1]) {
            case 1:
                return new zzdzl();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsk, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzhsi", "zzhsj"});
            case 4:
                return zzhsk;
            case 5:
                zzehy<zzdzl> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzl.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsk);
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
        zzdzl zzdzl = new zzdzl();
        zzhsk = zzdzl;
        zzegb.zza(zzdzl.class, zzdzl);
    }
}
