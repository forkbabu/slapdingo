package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
final class zzi extends zzd {
    private final /* synthetic */ zzj zzce;

    zzi(zzj zzj) {
        this.zzce = zzj;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzd, com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzc(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zzo.zzd(this.zzce.val$context).zzc(this.zzce.zzcf, googleSignInAccount);
        }
        this.zzce.setResult((Result) new GoogleSignInResult(googleSignInAccount, status));
    }
}
