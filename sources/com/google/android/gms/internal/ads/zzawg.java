package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzawg implements zzawo {
    private final Context zzclf;
    private final String zzdfg;

    zzawg(Context context, String str) {
        this.zzclf = context;
        this.zzdfg = str;
    }

    @Override // com.google.android.gms.internal.ads.zzawo
    public final void zza(zzbhy zzbhy) {
        Context context = this.zzclf;
        zzbhy.zzb(ObjectWrapper.wrap(context), this.zzdfg, context.getPackageName());
    }
}
