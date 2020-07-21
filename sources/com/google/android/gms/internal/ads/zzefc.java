package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzefc {
    int zziah;
    int zziai;
    int zziaj;
    zzefj zziak;
    private boolean zzial;

    static zzefc zzb(byte[] bArr, int i, int i2, boolean z) {
        zzefe zzefe = new zzefe(bArr, i, i2, z);
        try {
            zzefe.zzfz(i2);
            return zzefe;
        } catch (zzegl e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzfh(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzgb(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzbdm() throws IOException;

    public abstract long zzbdn() throws IOException;

    public abstract long zzbdo() throws IOException;

    public abstract int zzbdp() throws IOException;

    public abstract long zzbdq() throws IOException;

    public abstract int zzbdr() throws IOException;

    public abstract boolean zzbds() throws IOException;

    public abstract String zzbdt() throws IOException;

    public abstract zzeer zzbdu() throws IOException;

    public abstract int zzbdv() throws IOException;

    public abstract int zzbdw() throws IOException;

    public abstract int zzbdx() throws IOException;

    public abstract long zzbdy() throws IOException;

    public abstract int zzbdz() throws IOException;

    public abstract long zzbea() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzbeb() throws IOException;

    public abstract boolean zzbec() throws IOException;

    public abstract int zzbed();

    public abstract void zzfx(int i) throws zzegl;

    public abstract boolean zzfy(int i) throws IOException;

    public abstract int zzfz(int i) throws zzegl;

    public abstract void zzga(int i);

    private zzefc() {
        this.zziai = 100;
        this.zziaj = Integer.MAX_VALUE;
        this.zzial = false;
    }
}
