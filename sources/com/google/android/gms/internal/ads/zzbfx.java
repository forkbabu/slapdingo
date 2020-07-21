package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbfx implements zzdsl {
    private final Context zzclf;
    private final String zzdia;
    private final zzbhg zzemf;
    private final boolean zzemg;
    private final boolean zzemh;
    private final zzeg zzemi;
    private final zzbbd zzemj;
    private final zzabi zzemk = null;
    private final zzi zzeml;
    private final zza zzemm;
    private final zztm zzemn;
    private final zzso zzemo;
    private final boolean zzemp;

    zzbfx(Context context, zzbhg zzbhg, String str, boolean z, boolean z2, zzeg zzeg, zzbbd zzbbd, zzabi zzabi, zzi zzi, zza zza, zztm zztm, zzso zzso, boolean z3) {
        this.zzclf = context;
        this.zzemf = zzbhg;
        this.zzdia = str;
        this.zzemg = z;
        this.zzemh = z2;
        this.zzemi = zzeg;
        this.zzemj = zzbbd;
        this.zzeml = zzi;
        this.zzemm = zza;
        this.zzemn = zztm;
        this.zzemo = zzso;
        this.zzemp = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzdsl
    public final Object get() {
        Context context = this.zzclf;
        zzbhg zzbhg = this.zzemf;
        String str = this.zzdia;
        boolean z = this.zzemg;
        boolean z2 = this.zzemh;
        zzeg zzeg = this.zzemi;
        zzbbd zzbbd = this.zzemj;
        zzabi zzabi = this.zzemk;
        zzi zzi = this.zzeml;
        zza zza = this.zzemm;
        zztm zztm = this.zzemn;
        zzbgc zzbgc = new zzbgc(zzbgd.zzb(context, zzbhg, str, z, z2, zzeg, zzbbd, zzabi, zzi, zza, zztm, this.zzemo, this.zzemp));
        zzbgc.setWebViewClient(zzq.zzky().zza(zzbgc, zztm, z2));
        zzbgc.setWebChromeClient(new zzbff(zzbgc));
        return zzbgc;
    }
}
