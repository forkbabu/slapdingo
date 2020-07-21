package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbtz extends zzbwv<AdMetadataListener> implements zzagi {
    private Bundle zzfrw = new Bundle();

    public zzbtz(Set<zzbyg<AdMetadataListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzagi
    public final synchronized void zza(String str, Bundle bundle) {
        this.zzfrw.putAll(bundle);
        zza(zzbuc.zzfrq);
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzfrw);
    }
}
