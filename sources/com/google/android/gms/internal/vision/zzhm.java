package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public class zzhm {
    private static final zzgi zzsa = zzgi.zzfm();
    private zzfm zzym;
    private volatile zzih zzyn;
    private volatile zzfm zzyo;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhm)) {
            return false;
        }
        zzhm zzhm = (zzhm) obj;
        zzih zzih = this.zzyn;
        zzih zzih2 = zzhm.zzyn;
        if (zzih == null && zzih2 == null) {
            return zzdl().equals(zzhm.zzdl());
        }
        if (zzih != null && zzih2 != null) {
            return zzih.equals(zzih2);
        }
        if (zzih != null) {
            return zzih.equals(zzhm.zzh(zzih.zzge()));
        }
        return zzh(zzih2.zzge()).equals(zzih2);
    }

    private final zzih zzh(zzih zzih) {
        if (this.zzyn == null) {
            synchronized (this) {
                if (this.zzyn == null) {
                    try {
                        this.zzyn = zzih;
                        this.zzyo = zzfm.zzsm;
                    } catch (zzhh unused) {
                        this.zzyn = zzih;
                        this.zzyo = zzfm.zzsm;
                    }
                }
            }
        }
        return this.zzyn;
    }

    public final zzih zzi(zzih zzih) {
        zzih zzih2 = this.zzyn;
        this.zzym = null;
        this.zzyo = null;
        this.zzyn = zzih;
        return zzih2;
    }

    public final int zzgg() {
        if (this.zzyo != null) {
            return this.zzyo.size();
        }
        if (this.zzyn != null) {
            return this.zzyn.zzgg();
        }
        return 0;
    }

    public final zzfm zzdl() {
        if (this.zzyo != null) {
            return this.zzyo;
        }
        synchronized (this) {
            if (this.zzyo != null) {
                zzfm zzfm = this.zzyo;
                return zzfm;
            }
            if (this.zzyn == null) {
                this.zzyo = zzfm.zzsm;
            } else {
                this.zzyo = this.zzyn.zzdl();
            }
            zzfm zzfm2 = this.zzyo;
            return zzfm2;
        }
    }
}
