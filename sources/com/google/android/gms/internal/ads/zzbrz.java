package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrz implements zzela<Bundle> {
    private final zzbrx zzfrj;

    private zzbrz(zzbrx zzbrx) {
        this.zzfrj = zzbrx;
    }

    public static zzbrz zzi(zzbrx zzbrx) {
        return new zzbrz(zzbrx);
    }

    public static Bundle zzj(zzbrx zzbrx) {
        return zzbrx.zzaix();
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return this.zzfrj.zzaix();
    }
}
