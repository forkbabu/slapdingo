package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebn extends zzegb<zzebn, zza> implements zzehn {
    private static volatile zzehy<zzebn> zzel;
    /* access modifiers changed from: private */
    public static final zzebn zzhvo;
    private int zzhvm;
    private zzegm<zzb> zzhvn = zzbfh();

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zzb extends zzegb<zzb, zza> implements zzehn {
        private static volatile zzehy<zzb> zzel;
        /* access modifiers changed from: private */
        public static final zzb zzhvs;
        private int zzhvf;
        private zzebf zzhvp;
        private int zzhvq;
        private int zzhvr;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
        public static final class zza extends zzegb.zzb<zzb, zza> implements zzehn {
            private zza() {
                super(zzb.zzhvs);
            }

            /* synthetic */ zza(zzebo zzebo) {
                this();
            }
        }

        public final boolean zzbbi() {
            return this.zzhvp != null;
        }

        public final zzebf zzbbj() {
            zzebf zzebf = this.zzhvp;
            return zzebf == null ? zzebf.zzbav() : zzebf;
        }

        public final zzebg zzaxt() {
            zzebg zzfe = zzebg.zzfe(this.zzhvq);
            return zzfe == null ? zzebg.UNRECOGNIZED : zzfe;
        }

        public final int zzbbk() {
            return this.zzhvr;
        }

        public final zzebz zzaxu() {
            zzebz zzfl = zzebz.zzfl(this.zzhvf);
            return zzfl == null ? zzebz.UNRECOGNIZED : zzfl;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzegb
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzebo.zzdv[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzhvs, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzhvp", "zzhvq", "zzhvr", "zzhvf"});
                case 4:
                    return zzhvs;
                case 5:
                    zzehy<zzb> zzehy = zzel;
                    if (zzehy == null) {
                        synchronized (zzb.class) {
                            zzehy = zzel;
                            if (zzehy == null) {
                                zzehy = new zzegb.zza<>(zzhvs);
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
            zzb zzb = new zzb();
            zzhvs = zzb;
            zzegb.zza(zzb.class, zzb);
        }
    }

    private zzebn() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzebn, zza> implements zzehn {
        private zza() {
            super(zzebn.zzhvo);
        }

        /* synthetic */ zza(zzebo zzebo) {
            this();
        }
    }

    public final int zzbbe() {
        return this.zzhvm;
    }

    public final List<zzb> zzbbf() {
        return this.zzhvn;
    }

    public final int zzbbg() {
        return this.zzhvn.size();
    }

    public static zzebn zzc(byte[] bArr, zzefo zzefo) throws zzegl {
        return (zzebn) zzegb.zza(zzhvo, bArr, zzefo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebo.zzdv[i - 1]) {
            case 1:
                return new zzebn();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhvo, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzhvm", "zzhvn", zzb.class});
            case 4:
                return zzhvo;
            case 5:
                zzehy<zzebn> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebn.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhvo);
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
        zzebn zzebn = new zzebn();
        zzhvo = zzebn;
        zzegb.zza(zzebn.class, zzebn);
    }
}
