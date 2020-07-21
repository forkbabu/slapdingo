package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzebf extends zzegb<zzebf, zzb> implements zzehn {
    private static volatile zzehy<zzebf> zzel;
    /* access modifiers changed from: private */
    public static final zzebf zzhur;
    private String zzhuo = "";
    private zzeer zzhup = zzeer.zzhzv;
    private int zzhuq;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public enum zza implements zzegg {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzegf<zza> zzes = new zzebh();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzegg
        public final int zzw() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zza zzfd(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzw());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append(Typography.greater);
            return sb.toString();
        }

        private zza(int i) {
            this.value = i;
        }
    }

    private zzebf() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static final class zzb extends zzegb.zzb<zzebf, zzb> implements zzehn {
        private zzb() {
            super(zzebf.zzhur);
        }

        public final zzb zzho(String str) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebf) this.zziel).zzhn(str);
            return this;
        }

        public final zzb zzaf(zzeer zzeer) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebf) this.zziel).zzae(zzeer);
            return this;
        }

        public final zzb zzb(zza zza) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzebf) this.zziel).zza(zza);
            return this;
        }

        /* synthetic */ zzb(zzebe zzebe) {
            this();
        }
    }

    public final String zzbar() {
        return this.zzhuo;
    }

    /* access modifiers changed from: private */
    public final void zzhn(String str) {
        str.getClass();
        this.zzhuo = str;
    }

    public final zzeer zzbas() {
        return this.zzhup;
    }

    /* access modifiers changed from: private */
    public final void zzae(zzeer zzeer) {
        zzeer.getClass();
        this.zzhup = zzeer;
    }

    public final zza zzbat() {
        zza zzfd = zza.zzfd(this.zzhuq);
        return zzfd == null ? zza.UNRECOGNIZED : zzfd;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        this.zzhuq = zza2.zzw();
    }

    public static zzb zzbau() {
        return (zzb) zzhur.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzebe.zzdv[i - 1]) {
            case 1:
                return new zzebf();
            case 2:
                return new zzb(null);
            case 3:
                return zza(zzhur, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhuo", "zzhup", "zzhuq"});
            case 4:
                return zzhur;
            case 5:
                zzehy<zzebf> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzebf.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhur);
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

    public static zzebf zzbav() {
        return zzhur;
    }

    static {
        zzebf zzebf = new zzebf();
        zzhur = zzebf;
        zzegb.zza(zzebf.class, zzebf);
    }
}
