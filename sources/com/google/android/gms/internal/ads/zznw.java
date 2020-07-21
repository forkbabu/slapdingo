package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zznw {
    public final int viewportHeight;
    public final int viewportWidth;
    public final String zzbgs;
    public final String zzbgt;
    public final boolean zzbgu;
    public final boolean zzbgv;
    public final int zzbgw;
    public final int zzbgx;
    public final int zzbgy;
    public final boolean zzbgz;
    public final boolean zzbha;
    public final boolean zzbhb;

    public zznw() {
        this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    private zznw(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.zzbgs = null;
        this.zzbgt = null;
        this.zzbgu = false;
        this.zzbgv = true;
        this.zzbgw = Integer.MAX_VALUE;
        this.zzbgx = Integer.MAX_VALUE;
        this.zzbgy = Integer.MAX_VALUE;
        this.zzbgz = true;
        this.zzbha = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbhb = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznw zznw = (zznw) obj;
            return this.zzbgv == zznw.zzbgv && this.zzbgw == zznw.zzbgw && this.zzbgx == zznw.zzbgx && this.zzbgz == zznw.zzbgz && this.zzbha == zznw.zzbha && this.zzbhb == zznw.zzbhb && this.viewportWidth == zznw.viewportWidth && this.viewportHeight == zznw.viewportHeight && this.zzbgy == zznw.zzbgy && TextUtils.equals(null, null) && TextUtils.equals(null, null);
        }
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.zzbgv ? 1 : 0)) * 31) + this.zzbgw) * 31) + this.zzbgx) * 31) + this.zzbgy) * 31) + (this.zzbgz ? 1 : 0)) * 31) + (this.zzbha ? 1 : 0)) * 31) + (this.zzbhb ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
    }
}
