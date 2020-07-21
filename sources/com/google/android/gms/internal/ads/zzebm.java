package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebm extends zzegb<zzebm, zza> implements zzehn {
    private static volatile zzehy<zzebm> zzel;
    /* access modifiers changed from: private */
    public static final zzebm zzhvl;
    private String zzhuo = "";
    private String zzhvh = "";
    private int zzhvi;
    private boolean zzhvj;
    private String zzhvk = "";

    private zzebm() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzebm, zza> implements zzehn {
        private zza() {
            super(zzebm.zzhvl);
        }

        /* synthetic */ zza(zzebl zzebl) {
            this();
        }
    }

    public final String zzbaz() {
        return this.zzhvh;
    }

    public final String zzbar() {
        return this.zzhuo;
    }

    public final int zzbba() {
        return this.zzhvi;
    }

    public final boolean zzbbb() {
        return this.zzhvj;
    }

    public final String zzbbc() {
        return this.zzhvk;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebl.zzdv[i - 1]) {
            case 1:
                return new zzebm();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhvl, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzhvh", "zzhuo", "zzhvi", "zzhvj", "zzhvk"});
            case 4:
                return zzhvl;
            case 5:
                zzehy<zzebm> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebm.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhvl);
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
        zzebm zzebm = new zzebm();
        zzhvl = zzebm;
        zzegb.zza(zzebm.class, zzebm);
    }
}
