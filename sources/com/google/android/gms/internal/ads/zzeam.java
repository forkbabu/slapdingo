package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeam extends zzegb<zzeam, zza> implements zzehn {
    private static volatile zzehy<zzeam> zzel;
    /* access modifiers changed from: private */
    public static final zzeam zzhtl;
    private zzeat zzhti;
    private zzeah zzhtj;
    private int zzhtk;

    private zzeam() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeam, zza> implements zzehn {
        private zza() {
            super(zzeam.zzhtl);
        }

        /* synthetic */ zza(zzean zzean) {
            this();
        }
    }

    public final zzeat zzazq() {
        zzeat zzeat = this.zzhti;
        return zzeat == null ? zzeat.zzbag() : zzeat;
    }

    public final zzeah zzazr() {
        zzeah zzeah = this.zzhtj;
        return zzeah == null ? zzeah.zzazm() : zzeah;
    }

    public final zzeag zzazs() {
        zzeag zzex = zzeag.zzex(this.zzhtk);
        return zzex == null ? zzeag.UNRECOGNIZED : zzex;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzean.zzdv[i - 1]) {
            case 1:
                return new zzeam();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhtl, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzhti", "zzhtj", "zzhtk"});
            case 4:
                return zzhtl;
            case 5:
                zzehy<zzeam> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeam.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhtl);
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

    public static zzeam zzazt() {
        return zzhtl;
    }

    static {
        zzeam zzeam = new zzeam();
        zzhtl = zzeam;
        zzegb.zza(zzeam.class, zzeam);
    }
}
