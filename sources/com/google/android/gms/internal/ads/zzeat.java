package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeat extends zzegb<zzeat, zza> implements zzehn {
    private static volatile zzehy<zzeat> zzel;
    /* access modifiers changed from: private */
    public static final zzeat zzhtu;
    private int zzhtr;
    private int zzhts;
    private zzeer zzhtt = zzeer.zzhzv;

    private zzeat() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeat, zza> implements zzehn {
        private zza() {
            super(zzeat.zzhtu);
        }

        /* synthetic */ zza(zzeas zzeas) {
            this();
        }
    }

    public final zzeau zzbad() {
        zzeau zzfa = zzeau.zzfa(this.zzhtr);
        return zzfa == null ? zzeau.UNRECOGNIZED : zzfa;
    }

    public final zzeav zzbae() {
        zzeav zzfb = zzeav.zzfb(this.zzhts);
        return zzfb == null ? zzeav.UNRECOGNIZED : zzfb;
    }

    public final zzeer zzbaf() {
        return this.zzhtt;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeas.zzdv[i - 1]) {
            case 1:
                return new zzeat();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhtu, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzhtr", "zzhts", "zzhtt"});
            case 4:
                return zzhtu;
            case 5:
                zzehy<zzeat> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeat.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhtu);
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

    public static zzeat zzbag() {
        return zzhtu;
    }

    static {
        zzeat zzeat = new zzeat();
        zzhtu = zzeat;
        zzegb.zza(zzeat.class, zzeat);
    }
}
