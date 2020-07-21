package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbhg {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    public static zzbhg zzb(zzvh zzvh) {
        if (zzvh.zzchi) {
            return new zzbhg(3, 0, 0);
        }
        if (zzvh.zzchk) {
            return new zzbhg(2, 0, 0);
        }
        if (zzvh.zzbpp) {
            return zzacp();
        }
        return zzq(zzvh.widthPixels, zzvh.heightPixels);
    }

    public static zzbhg zzacp() {
        return new zzbhg(0, 0, 0);
    }

    public static zzbhg zzq(int i, int i2) {
        return new zzbhg(1, i, i2);
    }

    public static zzbhg zzacq() {
        return new zzbhg(4, 0, 0);
    }

    public static zzbhg zzacr() {
        return new zzbhg(5, 0, 0);
    }

    private zzbhg(int i, int i2, int i3) {
        this.type = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zzacs() {
        return this.type == 3;
    }

    public final boolean zzact() {
        return this.type == 0;
    }

    public final boolean zzacu() {
        return this.type == 4;
    }

    public final boolean zzacv() {
        return this.type == 5;
    }
}
