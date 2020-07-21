package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzlj {
    public final zzke zzash;
    public final zzlr zzazj = new zzlr();
    public zzlp zzazk;
    public zzld zzazl;
    public int zzazm;
    public int zzazn;
    public int zzazo;
    public zzkh zzazp;
    public zzlo zzazq;

    public zzlj(zzke zzke) {
        this.zzash = zzke;
    }

    public final void zza(zzlp zzlp, zzld zzld) {
        this.zzazk = (zzlp) zzpb.checkNotNull(zzlp);
        this.zzazl = (zzld) zzpb.checkNotNull(zzld);
        this.zzash.zze(zzlp.zzahr);
        reset();
    }

    public final void reset() {
        zzlr zzlr = this.zzazj;
        zzlr.zzbak = 0;
        zzlr.zzbax = 0;
        zzlr.zzbar = false;
        zzlr.zzbaw = false;
        zzlr.zzbat = null;
        this.zzazm = 0;
        this.zzazo = 0;
        this.zzazn = 0;
        this.zzazp = null;
        this.zzazq = null;
    }
}
