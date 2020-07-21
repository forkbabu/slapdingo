package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqi;
import com.google.android.gms.internal.ads.zzegb;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdqm extends zzegb<zzdqm, zza> implements zzehn {
    private static volatile zzehy<zzdqm> zzel;
    /* access modifiers changed from: private */
    public static final zzdqm zzhiw;
    private int zzdw;
    private String zzdx = "";
    private int zzhit;
    private String zzhiu = "";
    private zzdqi zzhiv;

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public enum zzb implements zzegg {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        
        private static final zzegf<zzb> zzes = new zzdqo();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzegg
        public final int zzw() {
            return this.value;
        }

        public static zzb zzef(int i) {
            if (i == 0) {
                return EVENT_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return BLOCKED_IMPRESSION;
        }

        public static zzegi zzx() {
            return zzdqq.zzeu;
        }

        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
        }

        private zzb(int i) {
            this.value = i;
        }
    }

    private zzdqm() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zza extends zzegb.zzb<zzdqm, zza> implements zzehn {
        private zza() {
            super(zzdqm.zzhiw);
        }

        public final zza zzb(zzb zzb) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdqm) this.zziel).zza(zzb);
            return this;
        }

        public final zza zzhe(String str) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdqm) this.zziel).zzo(str);
            return this;
        }

        public final zza zza(zzdqi.zzb zzb) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdqm) this.zziel).zza((zzdqi) ((zzegb) zzb.zzbfq()));
            return this;
        }

        /* synthetic */ zza(zzdqn zzdqn) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzhit = zzb2.zzw();
        this.zzdw |= 1;
    }

    /* access modifiers changed from: private */
    public final void zzo(String str) {
        str.getClass();
        this.zzdw |= 2;
        this.zzdx = str;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdqi zzdqi) {
        zzdqi.getClass();
        this.zzhiv = zzdqi;
        this.zzdw |= 8;
    }

    public static zza zzavh() {
        return (zza) zzhiw.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdqn.zzdv[i - 1]) {
            case 1:
                return new zzdqm();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzhiw, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzdw", "zzhit", zzb.zzx(), "zzdx", "zzhiu", "zzhiv"});
            case 4:
                return zzhiw;
            case 5:
                zzehy<zzdqm> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdqm.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhiw);
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
        zzdqm zzdqm = new zzdqm();
        zzhiw = zzdqm;
        zzegb.zza(zzdqm.class, zzdqm);
    }
}
