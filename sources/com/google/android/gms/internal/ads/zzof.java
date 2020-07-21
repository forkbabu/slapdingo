package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzof {
    public final int length;
    private int zzahp;
    private final zzod[] zzbho;

    public zzof(zzod... zzodArr) {
        this.zzbho = zzodArr;
        this.length = zzodArr.length;
    }

    public final zzod zzbf(int i) {
        return this.zzbho[i];
    }

    public final zzod[] zzil() {
        return (zzod[]) this.zzbho.clone();
    }

    public final int hashCode() {
        if (this.zzahp == 0) {
            this.zzahp = Arrays.hashCode(this.zzbho) + MetaDo.META_OFFSETWINDOWORG;
        }
        return this.zzahp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbho, ((zzof) obj).zzbho);
    }
}
