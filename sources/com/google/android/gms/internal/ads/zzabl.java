package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzabl extends zzabm {
    private final zze zzcyl;
    private final String zzcym;
    private final String zzcyn;

    public zzabl(zze zze, String str, String str2) {
        this.zzcyl = zze;
        this.zzcym = str;
        this.zzcyn = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzabn
    public final String zzrq() {
        return this.zzcym;
    }

    @Override // com.google.android.gms.internal.ads.zzabn
    public final String getContent() {
        return this.zzcyn;
    }

    @Override // com.google.android.gms.internal.ads.zzabn
    public final void zzn(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzcyl.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabn
    public final void recordClick() {
        this.zzcyl.zzjz();
    }

    @Override // com.google.android.gms.internal.ads.zzabn
    public final void recordImpression() {
        this.zzcyl.zzka();
    }
}
