package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.4 */
final class zzgl implements Callable<List<zzkt>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzge zzd;

    zzgl(zzge zzge, String str, String str2, String str3) {
        this.zzd = zzge;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzkt> call() throws Exception {
        this.zzd.zza.zzo();
        return this.zzd.zza.zze().zza(this.zza, this.zzb, this.zzc);
    }
}
