package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdzi extends zzegb<zzdzi, zza> implements zzehn {
    private static volatile zzehy<zzdzi> zzel;
    /* access modifiers changed from: private */
    public static final zzdzi zzhsh;
    private int zzhrx;
    private zzdzm zzhsf;
    private zzeax zzhsg;

    private zzdzi() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdzi, zza> implements zzehn {
        private zza() {
            super(zzdzi.zzhsh);
        }

        public final zza zzes(int i) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzi) this.zziel).setVersion(i);
            return this;
        }

        public final zza zzb(zzdzm zzdzm) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzi) this.zziel).zza(zzdzm);
            return this;
        }

        public final zza zzb(zzeax zzeax) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdzi) this.zziel).zza(zzeax);
            return this;
        }

        /* synthetic */ zza(zzdzj zzdzj) {
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

    public final zzdzm zzayj() {
        zzdzm zzdzm = this.zzhsf;
        return zzdzm == null ? zzdzm.zzays() : zzdzm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdzm zzdzm) {
        zzdzm.getClass();
        this.zzhsf = zzdzm;
    }

    public final zzeax zzayk() {
        zzeax zzeax = this.zzhsg;
        return zzeax == null ? zzeax.zzbak() : zzeax;
    }

    /* access modifiers changed from: private */
    public final void zza(zzeax zzeax) {
        zzeax.getClass();
        this.zzhsg = zzeax;
    }

    public static zzdzi zzd(zzeer zzeer, zzefo zzefo) throws zzegl {
        return (zzdzi) zzegb.zza(zzhsh, zzeer, zzefo);
    }

    public static zza zzayl() {
        return (zza) zzhsh.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdzj.zzdv[i - 1]) {
            case 1:
                return new zzdzi();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhsh, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzhrx", "zzhsf", "zzhsg"});
            case 4:
                return zzhsh;
            case 5:
                zzehy<zzdzi> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdzi.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhsh);
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
        zzdzi zzdzi = new zzdzi();
        zzhsh = zzdzi;
        zzegb.zza(zzdzi.class, zzdzi);
    }
}
