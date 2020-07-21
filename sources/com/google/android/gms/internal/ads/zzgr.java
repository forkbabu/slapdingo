package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzgr extends zzegb<zzgr, zza> implements zzehn {
    /* access modifiers changed from: private */
    public static final zzgr zzacg;
    private static volatile zzehy<zzgr> zzel;
    private String zzacb = "";
    private String zzacc = "";
    private long zzacd;
    private long zzace;
    private long zzacf;
    private int zzdw;

    private zzgr() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzgr, zza> implements zzehn {
        private zza() {
            super(zzgr.zzacg);
        }

        public final zza zzav(String str) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzgr) this.zziel).zzat(str);
            return this;
        }

        public final zza zzaw(String str) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzgr) this.zziel).zzau(str);
            return this;
        }

        public final zza zzdj(long j) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzgr) this.zziel).zzdg(j);
            return this;
        }

        public final zza zzdk(long j) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzgr) this.zziel).zzdh(j);
            return this;
        }

        public final zza zzdl(long j) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzgr) this.zziel).zzdi(j);
            return this;
        }

        /* synthetic */ zza(zzgs zzgs) {
            this();
        }
    }

    public final String zzdh() {
        return this.zzacb;
    }

    /* access modifiers changed from: private */
    public final void zzat(String str) {
        str.getClass();
        this.zzdw |= 1;
        this.zzacb = str;
    }

    public final String zzdi() {
        return this.zzacc;
    }

    /* access modifiers changed from: private */
    public final void zzau(String str) {
        str.getClass();
        this.zzdw |= 2;
        this.zzacc = str;
    }

    public final long zzdj() {
        return this.zzacd;
    }

    /* access modifiers changed from: private */
    public final void zzdg(long j) {
        this.zzdw |= 4;
        this.zzacd = j;
    }

    public final long zzdk() {
        return this.zzace;
    }

    /* access modifiers changed from: private */
    public final void zzdh(long j) {
        this.zzdw |= 8;
        this.zzace = j;
    }

    public final long zzdl() {
        return this.zzacf;
    }

    /* access modifiers changed from: private */
    public final void zzdi(long j) {
        this.zzdw |= 16;
        this.zzacf = j;
    }

    public static zzgr zzl(zzeer zzeer) throws zzegl {
        return (zzgr) zzegb.zza(zzacg, zzeer);
    }

    public static zza zzdm() {
        return (zza) zzacg.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgs.zzdv[i - 1]) {
            case 1:
                return new zzgr();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzacg, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzdw", "zzacb", "zzacc", "zzacd", "zzace", "zzacf"});
            case 4:
                return zzacg;
            case 5:
                zzehy<zzgr> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzgr.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzacg);
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

    public static zzgr zzdn() {
        return zzacg;
    }

    static {
        zzgr zzgr = new zzgr();
        zzacg = zzgr;
        zzegb.zza(zzgr.class, zzgr);
    }
}
