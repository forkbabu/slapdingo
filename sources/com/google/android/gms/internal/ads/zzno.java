package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzno {
    public final int length;
    private int zzahp;
    private final zzhq[] zzbfj;

    public zzno(zzhq... zzhqArr) {
        zzpb.checkState(zzhqArr.length > 0);
        this.zzbfj = zzhqArr;
        this.length = zzhqArr.length;
    }

    public final zzhq zzbc(int i) {
        return this.zzbfj[i];
    }

    public final int zzh(zzhq zzhq) {
        int i = 0;
        while (true) {
            zzhq[] zzhqArr = this.zzbfj;
            if (i >= zzhqArr.length) {
                return -1;
            }
            if (zzhq == zzhqArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final int hashCode() {
        if (this.zzahp == 0) {
            this.zzahp = Arrays.hashCode(this.zzbfj) + MetaDo.META_OFFSETWINDOWORG;
        }
        return this.zzahp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzno zzno = (zzno) obj;
            return this.length == zzno.length && Arrays.equals(this.zzbfj, zzno.zzbfj);
        }
    }
}
