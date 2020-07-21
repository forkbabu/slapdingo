package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbjq implements zzbon {
    private zzelj<zzdkk> zzett;
    private zzelj<Set<zzbyg<zzbtg>>> zzeuf;
    private zzelj<zzbtf> zzeug;
    private zzelj<zzbuz> zzeuh;
    private zzelj<zzdkw> zzeuj;
    private zzelj<Set<zzbyg<zzbua>>> zzevp;
    private zzelj<zzbtv> zzevq;
    private zzelj<String> zzewg;
    private zzelj<zzbsg> zzewh;
    private zzelj<zzbpa> zzewi;
    private final /* synthetic */ zzbjo zzfgk;
    private final zzbom zzfhf;
    private zzelj<zzafn> zzfhg;
    private zzelj<Runnable> zzfhh;
    private zzelj<zzboi> zzfhi;

    private zzbjq(zzbjo zzbjo, zzbpr zzbpr, zzbom zzbom) {
        this.zzfgk = zzbjo;
        this.zzfhf = zzbom;
        this.zzeuj = zzbps.zzc(zzbpr);
        this.zzett = zzbpq.zza(zzbpr);
        zzelf zzbjh = zzelf.zzar(0, 2).zzav(this.zzfgk.zzfci).zzav(this.zzfgk.zzfcj).zzbjh();
        this.zzeuf = zzbjh;
        this.zzeug = zzekx.zzas(zzbtm.zzj(zzbjh));
        zzelf zzbjh2 = zzelf.zzar(4, 3).zzau(this.zzfgk.zzfcw).zzau(this.zzfgk.zzfcx).zzau(this.zzfgk.zzfcy).zzav(this.zzfgk.zzfcz).zzav(this.zzfgk.zzfda).zzav(this.zzfgk.zzfdb).zzau(this.zzfgk.zzfdc).zzbjh();
        this.zzevp = zzbjh2;
        this.zzevq = zzekx.zzas(zzbtx.zzl(zzbjh2));
        zzbpt zze = zzbpt.zze(zzbpr);
        this.zzewg = zze;
        this.zzewh = zzbsf.zzs(this.zzett, zze);
        this.zzeuh = zzekx.zzas(zzbwa.zzajh());
        this.zzewi = zzbqt.zza(this.zzeuj, this.zzett, this.zzeug, this.zzevq, this.zzfgk.zzfdk, this.zzewh, this.zzeuh);
        this.zzfhg = new zzboo(zzbom);
        zzbop zzbop = new zzbop(zzbom);
        this.zzfhh = zzbop;
        this.zzfhi = zzekx.zzas(new zzbor(this.zzewi, this.zzfhg, zzbop, this.zzfgk.zzeto.zzerj));
    }

    @Override // com.google.android.gms.internal.ads.zzbon
    public final zzbnc zzaft() {
        return (zzbnc) zzelg.zza(this.zzfhi.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
