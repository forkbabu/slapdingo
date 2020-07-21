package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzlr {
    public int zzawu;
    public zzld zzbag;
    public long zzbah;
    public long zzbai;
    public long zzbaj;
    public int zzbak;
    public long[] zzbal;
    public int[] zzbam;
    public int[] zzban;
    public int[] zzbao;
    public long[] zzbap;
    public boolean[] zzbaq;
    public boolean zzbar;
    public boolean[] zzbas;
    public zzlo zzbat;
    public int zzbau;
    public zzpi zzbav;
    public boolean zzbaw;
    public long zzbax;

    zzlr() {
    }

    public final void zzav(int i) {
        zzpi zzpi = this.zzbav;
        if (zzpi == null || zzpi.limit() < i) {
            this.zzbav = new zzpi(i);
        }
        this.zzbau = i;
        this.zzbar = true;
        this.zzbaw = true;
    }

    public final long zzaw(int i) {
        return this.zzbap[i] + ((long) this.zzbao[i]);
    }
}
