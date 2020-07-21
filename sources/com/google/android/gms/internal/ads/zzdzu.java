package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzu extends zzegb<zzdzu, zza> implements zzehn {
    private static volatile zzehy<zzdzu> zzel;
    /* access modifiers changed from: private */
    public static final zzdzu zzhss;
    private int zzhsb;
    private zzdzx zzhsq;

    private zzdzu() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzu, zza> implements zzehn {
        private zza() {
            super(zzdzu.zzhss);
        }

        /* synthetic */ zza(zzdzv zzdzv) {
            this();
        }
    }

    public final zzdzx zzayz() {
        zzdzx zzdzx = this.zzhsq;
        return zzdzx == null ? zzdzx.zzazd() : zzdzx;
    }

    public final int getKeySize() {
        return this.zzhsb;
    }

    public static zzdzu zzi(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdzu) zzegb.zza(zzhss, zzeer, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzv.zzdv[i - 1]) {
            case 1:
                return new zzdzu();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhss, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzhsq", "zzhsb"});
            case 4:
                return zzhss;
            case 5:
                zzehy<zzdzu> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzu.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhss);
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
        zzdzu zzdzu = new zzdzu();
        zzhss = zzdzu;
        zzegb.zza(zzdzu.class, zzdzu);
    }
}
