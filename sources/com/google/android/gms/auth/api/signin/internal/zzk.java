package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
final class zzk extends zzd {
    private final /* synthetic */ zzl zzcg;

    zzk(zzl zzl) {
        this.zzcg = zzl;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzd, com.google.android.gms.auth.api.signin.internal.zzt
    public final void zze(Status status) throws RemoteException {
        this.zzcg.setResult((Result) status);
    }
}
