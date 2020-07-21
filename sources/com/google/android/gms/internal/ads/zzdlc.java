package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdlc {
    /* access modifiers changed from: private */
    public boolean zzbnr;
    /* access modifiers changed from: private */
    public zzvh zzboz;
    /* access modifiers changed from: private */
    public zzadj zzdkn;
    /* access modifiers changed from: private */
    public zzaio zzdra;
    /* access modifiers changed from: private */
    public int zzgqe = 1;
    /* access modifiers changed from: private */
    public boolean zzgrs = false;
    /* access modifiers changed from: private */
    public zzxk zzhaw;
    /* access modifiers changed from: private */
    public zzaaa zzhax;
    /* access modifiers changed from: private */
    public zzve zzhay;
    /* access modifiers changed from: private */
    public String zzhaz;
    /* access modifiers changed from: private */
    public ArrayList<String> zzhba;
    /* access modifiers changed from: private */
    public ArrayList<String> zzhbb;
    /* access modifiers changed from: private */
    public zzvo zzhbc;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzhbd;
    /* access modifiers changed from: private */
    public zzxe zzhbe;
    /* access modifiers changed from: private */
    public zzdkp zzhbg = new zzdkp();

    public final zzdlc zzh(zzve zzve) {
        this.zzhay = zzve;
        return this;
    }

    public final zzve zzasl() {
        return this.zzhay;
    }

    public final zzdlc zzd(zzvh zzvh) {
        this.zzboz = zzvh;
        return this;
    }

    public final zzdlc zzbo(boolean z) {
        this.zzgrs = z;
        return this;
    }

    public final zzvh zzkh() {
        return this.zzboz;
    }

    public final zzdlc zzc(zzxk zzxk) {
        this.zzhaw = zzxk;
        return this;
    }

    public final zzdlc zzgs(String str) {
        this.zzhaz = str;
        return this;
    }

    public final String zzasm() {
        return this.zzhaz;
    }

    public final zzdlc zzc(zzaaa zzaaa) {
        this.zzhax = zzaaa;
        return this;
    }

    public final zzdkp zzasn() {
        return this.zzhbg;
    }

    public final zzdlc zzbp(boolean z) {
        this.zzbnr = z;
        return this;
    }

    public final zzdlc zzea(int i) {
        this.zzgqe = i;
        return this;
    }

    public final zzdlc zzc(ArrayList<String> arrayList) {
        this.zzhba = arrayList;
        return this;
    }

    public final zzdlc zzd(ArrayList<String> arrayList) {
        this.zzhbb = arrayList;
        return this;
    }

    public final zzdlc zzb(zzadj zzadj) {
        this.zzdkn = zzadj;
        return this;
    }

    public final zzdlc zzb(zzvo zzvo) {
        this.zzhbc = zzvo;
        return this;
    }

    public final zzdlc zzb(zzaio zzaio) {
        this.zzdra = zzaio;
        this.zzhax = new zzaaa(false, true, false);
        return this;
    }

    public final zzdlc zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzhbd = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbnr = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzhbe = publisherAdViewOptions.zzju();
        }
        return this;
    }

    public final zzdlc zzc(zzdla zzdla) {
        this.zzhbg.zza(zzdla.zzhbf);
        this.zzhay = zzdla.zzhay;
        this.zzboz = zzdla.zzboz;
        this.zzhaw = zzdla.zzhaw;
        this.zzhaz = zzdla.zzhaz;
        this.zzhax = zzdla.zzhax;
        this.zzhba = zzdla.zzhba;
        this.zzhbb = zzdla.zzhbb;
        this.zzdkn = zzdla.zzdkn;
        this.zzhbc = zzdla.zzhbc;
        zzdlc zzb = zzb(zzdla.zzhbd);
        zzb.zzgrs = zzdla.zzgrs;
        return zzb;
    }

    public final zzdla zzaso() {
        Preconditions.checkNotNull(this.zzhaz, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzboz, "ad size must not be null");
        Preconditions.checkNotNull(this.zzhay, "ad request must not be null");
        return new zzdla(this);
    }
}
