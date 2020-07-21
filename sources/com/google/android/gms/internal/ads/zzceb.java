package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzceb implements zzahc {
    private final zzcdw zzfzi;
    private final View zzfzl;
    private final WindowManager zzfzm;
    private final zzdkk zzfzn;

    zzceb(zzcdw zzcdw, View view, WindowManager windowManager, zzdkk zzdkk) {
        this.zzfzi = zzcdw;
        this.zzfzl = view;
        this.zzfzm = windowManager;
        this.zzfzn = zzdkk;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map map) {
        this.zzfzi.zza(this.zzfzl, this.zzfzm, this.zzfzn, (zzbfn) obj, map);
    }
}
