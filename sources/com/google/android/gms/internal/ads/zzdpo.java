package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final /* synthetic */ class zzdpo implements Continuation {
    private final int zzeak;
    private final zzbw.zza.C0003zza zzhhr;

    zzdpo(zzbw.zza.C0003zza zza, int i) {
        this.zzhhr = zza;
        this.zzeak = i;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return zzdpm.zza(this.zzhhr, this.zzeak, task);
    }
}
