package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdla {
    public final zzvh zzboz;
    public final zzadj zzdkn;
    public final zzaio zzdra;
    public final int zzgqe;
    public final boolean zzgrs;
    public final zzxk zzhaw;
    public final zzaaa zzhax;
    public final zzve zzhay;
    public final String zzhaz;
    public final ArrayList<String> zzhba;
    public final ArrayList<String> zzhbb;
    public final zzvo zzhbc;
    public final PublisherAdViewOptions zzhbd;
    public final zzxe zzhbe;
    public final zzdkn zzhbf;

    private zzdla(zzdlc zzdlc) {
        zzaaa zzaaa;
        zzadj zzadj;
        this.zzboz = zzdlc.zzboz;
        this.zzhaz = zzdlc.zzhaz;
        this.zzhaw = zzdlc.zzhaw;
        this.zzhay = new zzve(zzdlc.zzhay.versionCode, zzdlc.zzhay.zzcgs, zzdlc.zzhay.extras, zzdlc.zzhay.zzcgt, zzdlc.zzhay.zzcgu, zzdlc.zzhay.zzcgv, zzdlc.zzhay.zzadg, zzdlc.zzhay.zzbnr || zzdlc.zzbnr, zzdlc.zzhay.zzcgw, zzdlc.zzhay.zzcgx, zzdlc.zzhay.zznb, zzdlc.zzhay.zzcgy, zzdlc.zzhay.zzcgz, zzdlc.zzhay.zzcha, zzdlc.zzhay.zzchb, zzdlc.zzhay.zzchc, zzdlc.zzhay.zzchd, zzdlc.zzhay.zzche, zzdlc.zzhay.zzchg, zzdlc.zzhay.zzadh, zzdlc.zzhay.zzadi, zzdlc.zzhay.zzchf);
        if (zzdlc.zzhax != null) {
            zzaaa = zzdlc.zzhax;
        } else {
            zzaaa = zzdlc.zzdkn != null ? zzdlc.zzdkn.zzdcg : null;
        }
        this.zzhax = zzaaa;
        this.zzhba = zzdlc.zzhba;
        this.zzhbb = zzdlc.zzhbb;
        if (zzdlc.zzhba == null) {
            zzadj = null;
        } else if (zzdlc.zzdkn == null) {
            zzadj = new zzadj(new NativeAdOptions.Builder().build());
        } else {
            zzadj = zzdlc.zzdkn;
        }
        this.zzdkn = zzadj;
        this.zzhbc = zzdlc.zzhbc;
        this.zzgqe = zzdlc.zzgqe;
        this.zzhbd = zzdlc.zzhbd;
        this.zzhbe = zzdlc.zzhbe;
        this.zzdra = zzdlc.zzdra;
        this.zzhbf = new zzdkn(zzdlc.zzhbg);
        this.zzgrs = zzdlc.zzgrs;
    }

    public final zzafn zzasj() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzhbd;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzjv();
    }
}
