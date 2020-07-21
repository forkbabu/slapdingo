package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdwu<P> {
    private final P zzhpu;
    private final byte[] zzhpv;
    private final zzebg zzhpw;
    private final zzebz zzhpx;
    private final int zzhpy;

    zzdwu(P p, byte[] bArr, zzebg zzebg, zzebz zzebz, int i) {
        this.zzhpu = p;
        this.zzhpv = Arrays.copyOf(bArr, bArr.length);
        this.zzhpw = zzebg;
        this.zzhpx = zzebz;
        this.zzhpy = i;
    }

    public final P zzaxs() {
        return this.zzhpu;
    }

    public final zzebg zzaxt() {
        return this.zzhpw;
    }

    public final zzebz zzaxu() {
        return this.zzhpx;
    }

    public final byte[] zzaxv() {
        byte[] bArr = this.zzhpv;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
