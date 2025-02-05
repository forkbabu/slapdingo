package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
final /* synthetic */ class zzr implements OnCompleteListener {
    private final boolean zza;
    private final BroadcastReceiver.PendingResult zzb;

    zzr(boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.zza = z;
        this.zzb = pendingResult;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        FirebaseInstanceIdReceiver.zza(this.zza, this.zzb, task);
    }
}
