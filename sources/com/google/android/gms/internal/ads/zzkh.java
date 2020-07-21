package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzkh {
    public final int zzaoz = 1;
    public final byte[] zzapa;

    public zzkh(int i, byte[] bArr) {
        this.zzapa = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzkh zzkh = (zzkh) obj;
            return this.zzaoz == zzkh.zzaoz && Arrays.equals(this.zzapa, zzkh.zzapa);
        }
    }

    public final int hashCode() {
        return (this.zzaoz * 31) + Arrays.hashCode(this.zzapa);
    }
}
