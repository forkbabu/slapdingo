package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
final /* synthetic */ class zzbf implements OnCompleteListener {
    private final zzbg zza;

    zzbf(zzbg zzbg) {
        this.zza = zzbg;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.zza.zzb();
    }
}
