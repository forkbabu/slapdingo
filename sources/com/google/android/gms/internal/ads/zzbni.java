package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbni implements zzbua {
    private final Context zzclf;
    private final zzbbd zzfnt;
    private final zzdkk zzfnu;
    private final zzdla zzfnv;

    zzbni(Context context, zzbbd zzbbd, zzdkk zzdkk, zzdla zzdla) {
        this.zzclf = context;
        this.zzfnt = zzbbd;
        this.zzfnu = zzdkk;
        this.zzfnv = zzdla;
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void onAdLoaded() {
        zzq.zzlg().zzb(this.zzclf, this.zzfnt.zzbpn, this.zzfnu.zzgzw.toString(), this.zzfnv.zzhaz);
    }
}
