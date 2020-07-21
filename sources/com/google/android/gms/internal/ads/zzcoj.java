package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcoj implements zzbva {
    private final zzavy zzbqt;
    private final Context zzvr;

    zzcoj(Context context, zzavy zzavy) {
        this.zzvr = context;
        this.zzbqt = zzavy;
    }

    @Override // com.google.android.gms.internal.ads.zzbva
    public final void zzd(zzasm zzasm) {
    }

    @Override // com.google.android.gms.internal.ads.zzbva
    public final void zzb(zzdkw zzdkw) {
        if (!TextUtils.isEmpty(zzdkw.zzhau.zzhar.zzdsg)) {
            this.zzbqt.zza(this.zzvr, zzdkw.zzhat.zzfpv.zzhay);
            this.zzbqt.zzk(this.zzvr, zzdkw.zzhau.zzhar.zzdsg);
        }
    }
}
