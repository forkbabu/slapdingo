package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnn implements zzela<View> {
    private final zzbnj zzfnw;

    public zzbnn(zzbnj zzbnj) {
        this.zzfnw = zzbnj;
    }

    public static View zzb(zzbnj zzbnj) {
        return (View) zzelg.zza(zzbnj.zzahk(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzfnw);
    }
}
