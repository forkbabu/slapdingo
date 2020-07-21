package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbui extends zzbwv<zzo> implements zzo {
    public zzbui(Set<zzbyg<zzo>> set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzud() {
        zza(zzbuh.zzfrq);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        zza(zzbuk.zzfrq);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        zza(zzbuj.zzfrq);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzue() {
        zza(zzbum.zzfrq);
    }
}
