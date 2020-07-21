package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
final class zzz implements zzb {
    private final ExecutorService zza;

    zzz(ExecutorService executorService) {
        this.zza = executorService;
    }

    @Override // com.google.firebase.iid.zzb
    public final Task<Integer> zza(Intent intent) {
        return Tasks.call(this.zza, new zzy(intent));
    }
}
