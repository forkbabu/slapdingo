package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzp extends zzegb<zzdzp, zza> implements zzehn {
    private static volatile zzehy<zzdzp> zzel;
    /* access modifiers changed from: private */
    public static final zzdzp zzhsn;
    private int zzhsb;
    private zzdzq zzhsl;

    private zzdzp() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzp, zza> implements zzehn {
        private zza() {
            super(zzdzp.zzhsn);
        }

        /* synthetic */ zza(zzdzo zzdzo) {
            this();
        }
    }

    public final zzdzq zzayq() {
        zzdzq zzdzq = this.zzhsl;
        return zzdzq == null ? zzdzq.zzayx() : zzdzq;
    }

    public final int getKeySize() {
        return this.zzhsb;
    }

    public static zzdzp zzg(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdzp) zzegb.zza(zzhsn, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzo.zzdv[i - 1]) {
            case 1:
                return new zzdzp();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsn, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzhsl", "zzhsb"});
            case 4:
                return zzhsn;
            case 5:
                zzehy<zzdzp> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzp.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsn);
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

    public static zzdzp zzayu() {
        return zzhsn;
    }

    static {
        zzdzp zzdzp = new zzdzp();
        zzhsn = zzdzp;
        zzegb.zza(zzdzp.class, zzdzp);
    }
}
