package com.google.android.gms.internal.p001authapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zzai  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
final class zzai extends IStatusCallback.Stub {
    private final /* synthetic */ TaskCompletionSource zzbk;

    zzai(zzaf zzaf, TaskCompletionSource taskCompletionSource) {
        this.zzbk = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) throws RemoteException {
        TaskUtil.setResultOrApiException(status, this.zzbk);
    }
}
