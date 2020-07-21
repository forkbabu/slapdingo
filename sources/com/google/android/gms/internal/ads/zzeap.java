package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeap extends zzegb<zzeap, zza> implements zzehn {
    private static volatile zzehy<zzeap> zzel;
    /* access modifiers changed from: private */
    public static final zzeap zzhtn;
    private int zzhrx;
    private zzeer zzhry = zzeer.zzhzv;
    private zzeaq zzhtm;

    private zzeap() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzeap, zza> implements zzehn {
        private zza() {
            super(zzeap.zzhtn);
        }

        public final zza zzey(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeap) this.zziel).setVersion(0);
            return this;
        }

        public final zza zzb(zzeaq zzeaq) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeap) this.zziel).zza(zzeaq);
            return this;
        }

        public final zza zzaa(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzeap) this.zziel).zzs(zzeer);
            return this;
        }

        /* synthetic */ zza(zzeao zzeao) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzhrx;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhrx = i;
    }

    public final zzeaq zzazv() {
        zzeaq zzeaq = this.zzhtm;
        return zzeaq == null ? zzeaq.zzbab() : zzeaq;
    }

    /* access modifiers changed from: private */
    public final void zza(zzeaq zzeaq) {
        zzeaq.getClass();
        this.zzhtm = zzeaq;
    }

    public final zzeer zzayb() {
        return this.zzhry;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzeer zzeer) {
        zzeer.getClass();
        this.zzhry = zzeer;
    }

    public static zzeap zzo(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzeap) zzegb.zza(zzhtn, zzeer, zzefo);
    }

    public static zza zzazw() {
        return (zza) zzhtn.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeao.zzdv[i - 1]) {
            case 1:
                return new zzeap();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhtn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhrx", "zzhtm", "zzhry"});
            case 4:
                return zzhtn;
            case 5:
                zzehy<zzeap> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzeap.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhtn);
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
        zzeap zzeap = new zzeap();
        zzhtn = zzeap;
        zzegb.zza(zzeap.class, zzeap);
    }
}
