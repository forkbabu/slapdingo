package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
final class zzm extends zzd {
    private final /* synthetic */ zzn zzch;

    zzm(zzn zzn) {
        this.zzch = zzn;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzd, com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzf(Status status) throws RemoteException {
        this.zzch.setResult((Result) status);
    }
}
