package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzdsc {
    private final String className;
    private final zzdsb zzhkh;
    private zzdsb zzhki;
    private boolean zzhkj;

    private zzdsc(String str) {
        zzdsb zzdsb = new zzdsb();
        this.zzhkh = zzdsb;
        this.zzhki = zzdsb;
        this.zzhkj = false;
        this.className = (String) zzdsh.checkNotNull(str);
    }

    public final zzdsc zzy(@NullableDecl Object obj) {
        zzdsb zzdsb = new zzdsb();
        this.zzhki.zzhkg = zzdsb;
        this.zzhki = zzdsb;
        zzdsb.value = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdsb zzdsb = this.zzhkh.zzhkg;
        String str = "";
        while (zzdsb != null) {
            Object obj = zzdsb.value;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            }
            zzdsb = zzdsb.zzhkg;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
