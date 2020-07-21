package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzekr {
    public static final zzekr zzipm = new zzekr(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzekr zzipn = new zzekr(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzekr zzipo = new zzekr(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzekr zzipp = new zzekr(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double w;
    private final double zzipi;
    private final double zzipj;
    private final double zzipk;
    private final double zzipl;

    private zzekr(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.zzipi = d6;
        this.zzipj = d7;
        this.w = d8;
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
        this.zzipk = d9;
        this.zzipl = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzekr zzekr = (zzekr) obj;
        return Double.compare(zzekr.a, this.a) == 0 && Double.compare(zzekr.b, this.b) == 0 && Double.compare(zzekr.c, this.c) == 0 && Double.compare(zzekr.d, this.d) == 0 && Double.compare(zzekr.zzipk, this.zzipk) == 0 && Double.compare(zzekr.zzipl, this.zzipl) == 0 && Double.compare(zzekr.zzipi, this.zzipi) == 0 && Double.compare(zzekr.zzipj, this.zzipj) == 0 && Double.compare(zzekr.w, this.w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzipi);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzipj);
        long doubleToLongBits3 = Double.doubleToLongBits(this.w);
        long doubleToLongBits4 = Double.doubleToLongBits(this.a);
        long doubleToLongBits5 = Double.doubleToLongBits(this.b);
        long doubleToLongBits6 = Double.doubleToLongBits(this.c);
        long doubleToLongBits7 = Double.doubleToLongBits(this.d);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzipk);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzipl);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zzipm)) {
            return "Rotate 0°";
        }
        if (equals(zzipn)) {
            return "Rotate 90°";
        }
        if (equals(zzipo)) {
            return "Rotate 180°";
        }
        if (equals(zzipp)) {
            return "Rotate 270°";
        }
        double d2 = this.zzipi;
        double d3 = this.zzipj;
        double d4 = this.w;
        double d5 = this.a;
        double d6 = this.b;
        double d7 = this.c;
        double d8 = this.d;
        double d9 = this.zzipk;
        double d10 = this.zzipl;
        StringBuilder sb = new StringBuilder((int) MetaDo.META_SETROP2);
        sb.append("Matrix{u=");
        sb.append(d2);
        sb.append(", v=");
        sb.append(d3);
        sb.append(", w=");
        sb.append(d4);
        sb.append(", a=");
        sb.append(d5);
        sb.append(", b=");
        sb.append(d6);
        sb.append(", c=");
        sb.append(d7);
        sb.append(", d=");
        sb.append(d8);
        sb.append(", tx=");
        sb.append(d9);
        sb.append(", ty=");
        sb.append(d10);
        sb.append("}");
        return sb.toString();
    }

    public static zzekr zzs(ByteBuffer byteBuffer) {
        double zzi = zzbq.zzi(byteBuffer);
        double zzi2 = zzbq.zzi(byteBuffer);
        double zzj = zzbq.zzj(byteBuffer);
        return new zzekr(zzi, zzi2, zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer), zzj, zzbq.zzj(byteBuffer), zzbq.zzj(byteBuffer), zzbq.zzi(byteBuffer), zzbq.zzi(byteBuffer));
    }
}
