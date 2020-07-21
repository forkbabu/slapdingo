package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzhw {
    public static final zzhw zzahs = new zzhw(1.0f, 1.0f);
    public final float zzaht;
    public final float zzahu;
    private final int zzahv;

    public zzhw(float f, float f2) {
        this.zzaht = f;
        this.zzahu = f2;
        this.zzahv = Math.round(f * 1000.0f);
    }

    public final long zzdu(long j) {
        return j * ((long) this.zzahv);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzhw zzhw = (zzhw) obj;
            return this.zzaht == zzhw.zzaht && this.zzahu == zzhw.zzahu;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzaht) + MetaDo.META_OFFSETWINDOWORG) * 31) + Float.floatToRawIntBits(this.zzahu);
    }
}
