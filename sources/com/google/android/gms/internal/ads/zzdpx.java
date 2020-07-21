package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzdqi;
import com.google.android.gms.internal.ads.zzdqm;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdpx {
    private final Looper zzhhy;
    private final Context zzvr;

    public zzdpx(Context context, Looper looper) {
        this.zzvr = context;
        this.zzhhy = looper;
    }

    public final void zzhb(String str) {
        new zzdqa(this.zzvr, this.zzhhy, (zzdqm) ((zzegb) zzdqm.zzavh().zzhe(this.zzvr.getPackageName()).zzb(zzdqm.zzb.BLOCKED_IMPRESSION).zza(zzdqi.zzavf().zzhd(str).zzb(zzdqi.zza.BLOCKED_REASON_BACKGROUND)).zzbfq())).zzavd();
    }
}
