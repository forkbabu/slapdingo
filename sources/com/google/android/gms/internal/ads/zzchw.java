package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzchw {
    private final zzbbd zzboy;
    private final zzbfv zzbpw;
    private final zztm zzelk;
    private final zzeg zzemz;
    private final zza zzenb;
    private final zzso zzend;
    private final zzdla zzfpv;
    /* access modifiers changed from: private */
    public final zzbus zzgcl;
    private final Context zzvr;

    public zzchw(zzbfv zzbfv, Context context, zzdla zzdla, zzeg zzeg, zzbbd zzbbd, zza zza, zztm zztm, zzbus zzbus, zzbze zzbze) {
        this.zzbpw = zzbfv;
        this.zzvr = context;
        this.zzfpv = zzdla;
        this.zzemz = zzeg;
        this.zzboy = zzbbd;
        this.zzenb = zza;
        this.zzelk = zztm;
        this.zzgcl = zzbus;
        this.zzend = zzbze;
    }

    public final zzbfn zzc(zzvh zzvh) throws zzbfz {
        return zza(zzvh, false);
    }

    public final zzbfn zza(zzvh zzvh, boolean z) throws zzbfz {
        return zzbfv.zza(this.zzvr, zzbhg.zzb(zzvh), zzvh.zzacv, false, false, this.zzemz, this.zzboy, null, new zzchz(this), this.zzenb, this.zzelk, this.zzend, z);
    }
}
