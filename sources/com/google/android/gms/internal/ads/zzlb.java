package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzlb implements zzkw {
    private final zzpi zzawl;
    private final int zzawu = this.zzawl.zziz();
    private final int zzawx = (this.zzawl.zziz() & 255);
    private int zzawy;
    private int zzawz;

    public zzlb(zzkv zzkv) {
        zzpi zzpi = zzkv.zzawl;
        this.zzawl = zzpi;
        zzpi.zzbk(12);
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final boolean zzgy() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final int zzgw() {
        return this.zzawu;
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final int zzgx() {
        int i = this.zzawx;
        if (i == 8) {
            return this.zzawl.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzawl.readUnsignedShort();
        }
        int i2 = this.zzawy;
        this.zzawy = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzawz & 15;
        }
        int readUnsignedByte = this.zzawl.readUnsignedByte();
        this.zzawz = readUnsignedByte;
        return (readUnsignedByte & 240) >> 4;
    }
}
