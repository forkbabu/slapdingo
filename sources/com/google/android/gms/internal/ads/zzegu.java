package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class zzegu {
    private static final zzefo zzhzj = zzefo.zzbeq();
    private zzeer zziga;
    private volatile zzehl zzigb;
    private volatile zzeer zzigc;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzegu)) {
            return false;
        }
        zzegu zzegu = (zzegu) obj;
        zzehl zzehl = this.zzigb;
        zzehl zzehl2 = zzegu.zzigb;
        if (zzehl == null && zzehl2 == null) {
            return zzbct().equals(zzegu.zzbct());
        }
        if (zzehl != null && zzehl2 != null) {
            return zzehl.equals(zzehl2);
        }
        if (zzehl != null) {
            return zzehl.equals(zzegu.zzm(zzehl.zzbfk()));
        }
        return zzm(zzehl2.zzbfk()).equals(zzehl2);
    }

    private final zzehl zzm(zzehl zzehl) {
        if (this.zzigb == null) {
            synchronized (this) {
                if (this.zzigb == null) {
                    try {
                        this.zzigb = zzehl;
                        this.zzigc = zzeer.zzhzv;
                    } catch (zzegl unused) {
                        this.zzigb = zzehl;
                        this.zzigc = zzeer.zzhzv;
                    }
                }
            }
        }
        return this.zzigb;
    }

    public final zzehl zzn(zzehl zzehl) {
        zzehl zzehl2 = this.zzigb;
        this.zziga = null;
        this.zzigc = null;
        this.zzigb = zzehl;
        return zzehl2;
    }

    public final int zzbfe() {
        if (this.zzigc != null) {
            return this.zzigc.size();
        }
        if (this.zzigb != null) {
            return this.zzigb.zzbfe();
        }
        return 0;
    }

    public final zzeer zzbct() {
        if (this.zzigc != null) {
            return this.zzigc;
        }
        synchronized (this) {
            if (this.zzigc != null) {
                zzeer zzeer = this.zzigc;
                return zzeer;
            }
            if (this.zzigb == null) {
                this.zzigc = zzeer.zzhzv;
            } else {
                this.zzigc = this.zzigb.zzbct();
            }
            zzeer zzeer2 = this.zzigc;
            return zzeer2;
        }
    }
}
