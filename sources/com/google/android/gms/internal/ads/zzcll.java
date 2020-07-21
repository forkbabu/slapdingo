package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcll {
    public static Set<zzbyg<zzbtg>> zza(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    public static Set<zzbyg<AppEventListener>> zzb(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    public static Set<zzbyg<zzbua>> zzc(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    public static Set<zzbyg<zzbsq>> zzd(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    public static Set<zzbyg<zzbsl>> zze(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    public static Set<zzbyg<zzbtd>> zzf(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    public static Set<zzbyg<zzuu>> zzg(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    public static Set<zzbyg<zzdpa>> zzh(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    public static Set<zzbyg<zzbva>> zzi(zzclv zzclv, Executor executor) {
        return zzc((Object) zzclv, executor);
    }

    private static <T> Set<zzbyg<T>> zzc(T t, Executor executor) {
        if (zzack.zzdaj.get().booleanValue()) {
            return Collections.singleton(new zzbyg(t, executor));
        }
        return Collections.emptySet();
    }
}
