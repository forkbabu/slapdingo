package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
final class zzgr implements Callable<byte[]> {
    private final /* synthetic */ zzao zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzge zzc;

    zzgr(zzge zzge, zzao zzao, String str) {
        this.zzc = zzge;
        this.zza = zzao;
        this.zzb = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        this.zzc.zza.zzo();
        return this.zzc.zza.zzg().zza(this.zza, this.zzb);
    }
}
