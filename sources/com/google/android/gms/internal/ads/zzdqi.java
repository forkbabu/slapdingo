package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdqi extends zzegb<zzdqi, zzb> implements zzehn {
    private static volatile zzehy<zzdqi> zzel;
    private static final zzegk<Integer, zza> zzhil = new zzdqh();
    /* access modifiers changed from: private */
    public static final zzdqi zzhip;
    private int zzdw;
    private zzegh zzhik = zzbff();
    private String zzhim = "";
    private String zzhin = "";
    private String zzhio = "";

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public enum zza implements zzegg {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzegf<zza> zzes = new zzdql();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzegg
        public final int zzw() {
            return this.value;
        }

        public static zza zzee(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        public static zzegi zzx() {
            return zzdqk.zzeu;
        }

        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
        }

        private zza(int i) {
            this.value = i;
        }
    }

    private zzdqi() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
    public static final class zzb extends zzegb.zzb<zzdqi, zzb> implements zzehn {
        private zzb() {
            super(zzdqi.zzhip);
        }

        public final zzb zzb(zza zza) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdqi) this.zziel).zza(zza);
            return this;
        }

        public final zzb zzhd(String str) {
            if (((zzegb.zzb) this).zziem) {
                zzbfm();
                ((zzegb.zzb) this).zziem = false;
            }
            ((zzdqi) this.zziel).zzhc(str);
            return this;
        }

        /* synthetic */ zzb(zzdqh zzdqh) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        zza2.getClass();
        if (!this.zzhik.zzbcy()) {
            this.zzhik = zzegb.zza(this.zzhik);
        }
        this.zzhik.zzhb(zza2.zzw());
    }

    /* access modifiers changed from: private */
    public final void zzhc(String str) {
        str.getClass();
        this.zzdw |= 1;
        this.zzhim = str;
    }

    public static zzb zzavf() {
        return (zzb) zzhip.zzbfc();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzegb
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdqj.zzdv[i - 1]) {
            case 1:
                return new zzdqi();
            case 2:
                return new zzb(null);
            case 3:
                return zza(zzhip, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdw", "zzhik", zza.zzx(), "zzhim", "zzhin", "zzhio"});
            case 4:
                return zzhip;
            case 5:
                zzehy<zzdqi> zzehy = zzel;
                if (zzehy == null) {
                    synchronized (zzdqi.class) {
                        zzehy = zzel;
                        if (zzehy == null) {
                            zzehy = new zzegb.zza<>(zzhip);
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
        zzdqi zzdqi = new zzdqi();
        zzhip = zzdqi;
        zzegb.zza(zzdqi.class, zzdqi);
    }
}
