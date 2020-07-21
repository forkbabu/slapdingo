package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzkx {
    public int index;
    public final int length;
    public int zzawm;
    public long zzawn;
    private final boolean zzawo;
    private final zzpi zzawp;
    private final zzpi zzawq;
    private int zzawr;
    private int zzaws;

    public zzkx(zzpi zzpi, zzpi zzpi2, boolean z) {
        this.zzawq = zzpi;
        this.zzawp = zzpi2;
        this.zzawo = z;
        zzpi2.zzbk(12);
        this.length = zzpi2.zziz();
        zzpi.zzbk(12);
        this.zzaws = zzpi.zziz();
        zzpb.checkState(zzpi.readInt() != 1 ? false : true, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzgz() {
        long j;
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        if (this.zzawo) {
            j = this.zzawp.zzja();
        } else {
            j = this.zzawp.zziw();
        }
        this.zzawn = j;
        if (this.index == this.zzawr) {
            this.zzawm = this.zzawq.zziz();
            this.zzawq.zzbl(4);
            int i2 = this.zzaws - 1;
            this.zzaws = i2;
            this.zzawr = i2 > 0 ? this.zzawq.zziz() - 1 : -1;
        }
        return true;
    }
}
