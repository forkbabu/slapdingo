package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbmm implements zzela<View> {
    private final zzbmn zzfmt;

    public zzbmm(zzbmn zzbmn) {
        this.zzfmt = zzbmn;
    }

    public static View zza(zzbmn zzbmn) {
        return (View) zzelg.zza(zzbmn.zzaha(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfmt);
    }
}
