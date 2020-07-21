package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxo implements zzela<Set<zzbyg<AppEventListener>>> {
    private final zzbxa zzftd;

    private zzbxo(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxo zzu(zzbxa zzbxa) {
        return new zzbxo(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzajq(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
