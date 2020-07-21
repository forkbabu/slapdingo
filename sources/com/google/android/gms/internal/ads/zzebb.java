package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebb extends zzegb<zzebb, zza> implements zzehn {
    private static volatile zzehy<zzebb> zzel;
    /* access modifiers changed from: private */
    public static final zzebb zzhul;
    private int zzhrx;
    private int zzhsb;
    private zzebc zzhuj;

    private zzebb() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzebb, zza> implements zzehn {
        private zza() {
            super(zzebb.zzhul);
        }

        /* synthetic */ zza(zzeba zzeba) {
            this();
        }
    }

    public final zzebc zzbai() {
        zzebc zzebc = this.zzhuj;
        return zzebc == null ? zzebc.zzbap() : zzebc;
    }

    public final int getKeySize() {
        return this.zzhsb;
    }

    public static zzebb zzr(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzebb) zzegb.zza(zzhul, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeba.zzdv[i - 1]) {
            case 1:
                return new zzebb();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhul, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzhuj", "zzhsb", "zzhrx"});
            case 4:
                return zzhul;
            case 5:
                zzehy<zzebb> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebb.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhul);
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

    public static zzebb zzbam() {
        return zzhul;
    }

    static {
        zzebb zzebb = new zzebb();
        zzhul = zzebb;
        zzegb.zza(zzebb.class, zzebb);
    }
}
