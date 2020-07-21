package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcdy implements zzahc {
    private final zzcdw zzfzi;
    private final WindowManager zzfzj;
    private final View zzfzk;

    zzcdy(zzcdw zzcdw, WindowManager windowManager, View view) {
        this.zzfzi = zzcdw;
        this.zzfzj = windowManager;
        this.zzfzk = view;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map map) {
        this.zzfzi.zza(this.zzfzj, this.zzfzk, (zzbfn) obj, map);
    }
}
