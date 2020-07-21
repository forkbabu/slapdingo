package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzduz<V> implements Runnable {
    private final Future<V> zzhon;
    private final zzduu<? super V> zzhoo;

    zzduz(Future<V> future, zzduu<? super V> zzduu) {
        this.zzhon = future;
        this.zzhoo = zzduu;
    }

    public final void run() {
        Throwable zza;
        Future<V> future = this.zzhon;
        if (!(future instanceof zzdwa) || (zza = zzdvz.zza((zzdwa) future)) == null) {
            try {
                this.zzhoo.onSuccess(zzdux.zza(this.zzhon));
            } catch (ExecutionException e) {
                this.zzhoo.zzb(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzhoo.zzb(e2);
            }
        } else {
            this.zzhoo.zzb(zza);
        }
    }

    public final String toString() {
        return zzdsa.zzx(this).zzy(this.zzhoo).toString();
    }
}
