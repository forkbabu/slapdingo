package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbu extends zzekh {
    private Date zzde;
    private Date zzdf;
    private long zzdg;
    private long zzdh;
    private double zzdi = 1.0d;
    private float zzdj = 1.0f;
    private zzekr zzdk = zzekr.zzipm;
    private long zzdl;
    private int zzdm;
    private int zzdn;
    private int zzdo;
    private int zzdp;
    private int zzdq;
    private int zzdr;

    public zzbu() {
        super("mvhd");
    }

    public final long zzs() {
        return this.zzdg;
    }

    public final long getDuration() {
        return this.zzdh;
    }

    @Override // com.google.android.gms.internal.ads.zzekg
    public final void zzl(ByteBuffer byteBuffer) {
        zzr(byteBuffer);
        if (getVersion() == 1) {
            this.zzde = zzeko.zzfv(zzbq.zzh(byteBuffer));
            this.zzdf = zzeko.zzfv(zzbq.zzh(byteBuffer));
            this.zzdg = zzbq.zzf(byteBuffer);
            this.zzdh = zzbq.zzh(byteBuffer);
        } else {
            this.zzde = zzeko.zzfv(zzbq.zzf(byteBuffer));
            this.zzdf = zzeko.zzfv(zzbq.zzf(byteBuffer));
            this.zzdg = zzbq.zzf(byteBuffer);
            this.zzdh = zzbq.zzf(byteBuffer);
        }
        this.zzdi = zzbq.zzi(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzdj = ((float) ((short) ((bArr[1] & UByte.MAX_VALUE) | ((short) (0 | ((bArr[0] << 8) & 65280)))))) / 256.0f;
        zzbq.zzg(byteBuffer);
        zzbq.zzf(byteBuffer);
        zzbq.zzf(byteBuffer);
        this.zzdk = zzekr.zzs(byteBuffer);
        this.zzdm = byteBuffer.getInt();
        this.zzdn = byteBuffer.getInt();
        this.zzdo = byteBuffer.getInt();
        this.zzdp = byteBuffer.getInt();
        this.zzdq = byteBuffer.getInt();
        this.zzdr = byteBuffer.getInt();
        this.zzdl = zzbq.zzf(byteBuffer);
    }

    public final String toString() {
        return "MovieHeaderBox[" + "creationTime=" + this.zzde + ";" + "modificationTime=" + this.zzdf + ";" + "timescale=" + this.zzdg + ";" + "duration=" + this.zzdh + ";" + "rate=" + this.zzdi + ";" + "volume=" + this.zzdj + ";" + "matrix=" + this.zzdk + ";" + "nextTrackId=" + this.zzdl + "]";
    }
}
