package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
final class zzko implements Callable<String> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzkk zzb;

    zzko(zzkk zzkk, zzn zzn) {
        this.zzb = zzkk;
        this.zza = zzn;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzf zzc = this.zzb.zzc(this.zza);
        if (zzc != null) {
            return zzc.zzd();
        }
        this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
        return null;
    }
}
