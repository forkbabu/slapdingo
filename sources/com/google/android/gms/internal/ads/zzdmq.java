package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdmq {
    private final zzdmp zzhcv = new zzdmp();
    private int zzhcw;
    private int zzhcx;
    private int zzhcy;
    private int zzhcz;
    private int zzhda;

    zzdmq() {
    }

    public final void zzatg() {
        this.zzhcy++;
    }

    public final void zzath() {
        this.zzhcz++;
    }

    public final void zzati() {
        this.zzhcw++;
        this.zzhcv.zzhct = true;
    }

    public final void zzatj() {
        this.zzhcx++;
        this.zzhcv.zzhcu = true;
    }

    public final void zzatk() {
        this.zzhda++;
    }

    public final zzdmp zzatl() {
        zzdmp zzdmp = (zzdmp) this.zzhcv.clone();
        zzdmp zzdmp2 = this.zzhcv;
        zzdmp2.zzhct = false;
        zzdmp2.zzhcu = false;
        return zzdmp;
    }

    public final String zzatm() {
        return "\n\tPool does not exist: " + this.zzhcy + "\n\tNew pools created: " + this.zzhcw + "\n\tPools removed: " + this.zzhcx + "\n\tEntries added: " + this.zzhda + "\n\tNo entries retrieved: " + this.zzhcz + "\n";
    }
}
