package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zznr {
    public static final zznr zzbgn = new zznr(new zzno[0]);
    public final int length;
    private int zzahp;
    private final zzno[] zzbgo;

    public zznr(zzno... zznoArr) {
        this.zzbgo = zznoArr;
        this.length = zznoArr.length;
    }

    public final zzno zzbd(int i) {
        return this.zzbgo[i];
    }

    public final int zza(zzno zzno) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbgo[i] == zzno) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.zzahp == 0) {
            this.zzahp = Arrays.hashCode(this.zzbgo);
        }
        return this.zzahp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznr zznr = (zznr) obj;
            return this.length == zznr.length && Arrays.equals(this.zzbgo, zznr.zzbgo);
        }
    }
}
