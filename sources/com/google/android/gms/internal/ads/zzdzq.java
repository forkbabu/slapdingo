package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzq extends zzegb<zzdzq, zza> implements zzehn {
    private static volatile zzehy<zzdzq> zzel;
    /* access modifiers changed from: private */
    public static final zzdzq zzhsp;
    private int zzhso;

    private zzdzq() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzq, zza> implements zzehn {
        private zza() {
            super(zzdzq.zzhsp);
        }

        /* synthetic */ zza(zzdzr zzdzr) {
            this();
        }
    }

    public final int zzayw() {
        return this.zzhso;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzr.zzdv[i - 1]) {
            case 1:
                return new zzdzq();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsp, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhso"});
            case 4:
                return zzhsp;
            case 5:
                zzehy<zzdzq> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzq.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsp);
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

    public static zzdzq zzayx() {
        return zzhsp;
    }

    static {
        zzdzq zzdzq = new zzdzq();
        zzhsp = zzdzq;
        zzegb.zza(zzdzq.class, zzdzq);
    }
}
