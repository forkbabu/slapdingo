package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvk implements zzcqt<zzbnc> {
    private final zzdou zzfpw;
    private final zzbny zzgkn;
    private final zzdvi zzgnn;
    private final Context zzgns;
    private final zzabo zzgnt;

    public zzcvk(Context context, zzbny zzbny, zzdou zzdou, zzdvi zzdvi, zzabo zzabo) {
        this.zzgns = context;
        this.zzgkn = zzbny;
        this.zzfpw = zzdou;
        this.zzgnn = zzdvi;
        this.zzgnt = zzabo;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final boolean zza(zzdkw zzdkw, zzdkk zzdkk) {
        return (this.zzgnt == null || zzdkk.zzgzr == null || zzdkk.zzgzr.zzdoh == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final zzdvf<zzbnc> zzb(zzdkw zzdkw, zzdkk zzdkk) {
        zzbnf zza = this.zzgkn.zza(new zzbpr(zzdkw, zzdkk, null), new zzcvp(this, new View(this.zzgns), null, zzcvn.zzgnx, zzdkk.zzgzt.get(0)));
        return this.zzfpw.zzu(zzdor.CUSTOM_RENDER_SYN).zza(new zzcvm(this, new zzabl(zza.zzafp(), zzdkk.zzgzr.zzdof, zzdkk.zzgzr.zzdoh)), this.zzgnn).zzw(zzdor.CUSTOM_RENDER_ACK).zze(zzdux.zzaf(zza.zzafn())).zzaus();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzabl zzabl) throws Exception {
        this.zzgnt.zza(zzabl);
    }
}
