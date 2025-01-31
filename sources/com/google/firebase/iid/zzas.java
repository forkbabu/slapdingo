package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
final /* synthetic */ class zzas implements Continuation {
    private final zzat zza;
    private final Pair zzb;

    zzas(zzat zzat, Pair pair) {
        this.zza = zzat;
        this.zzb = pair;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
