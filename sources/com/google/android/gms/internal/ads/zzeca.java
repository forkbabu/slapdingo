package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeca extends zzegb<zzeca, zza> implements zzehn {
    private static volatile zzehy<zzeca> zzel;
    /* access modifiers changed from: private */
    public static final zzeca zzhwo;
    private String zzhwm = "";
    private zzegm<zzebm> zzhwn = zzbfh();

    private zzeca() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeca, zza> implements zzehn {
        private zza() {
            super(zzeca.zzhwo);
        }

        /* synthetic */ zza(zzecc zzecc) {
            this();
        }
    }

    public final List<zzebm> zzbcd() {
        return this.zzhwn;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzecc.zzdv[i - 1]) {
            case 1:
                return new zzeca();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhwo, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzhwm", "zzhwn", zzebm.class});
            case 4:
                return zzhwo;
            case 5:
                zzehy<zzeca> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeca.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhwo);
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

    public static zzeca zzbce() {
        return zzhwo;
    }

    static {
        zzeca zzeca = new zzeca();
        zzhwo = zzeca;
        zzegb.zza(zzeca.class, zzeca);
    }
}
