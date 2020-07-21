package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbtf extends zzbwv<zzbtg> {
    public zzbtf(Set<zzbyg<zzbtg>> set) {
        super(set);
    }

    public final void zzca(Context context) {
        zza(new zzbti(context));
    }

    public final void zzcb(Context context) {
        zza(new zzbth(context));
    }

    public final void zzcc(Context context) {
        zza(new zzbtk(context));
    }

    public final void zza(zzbyw zzbyw, Executor executor) {
        zza(zzbyg.zzb(new zzbtj(this, zzbyw), executor));
    }
}
