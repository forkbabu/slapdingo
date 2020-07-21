package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zzae  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
final /* synthetic */ class zzae implements RemoteCall {
    private final zzaf zzbh;
    private final BeginSignInRequest zzbi;

    zzae(zzaf zzaf, BeginSignInRequest beginSignInRequest) {
        this.zzbh = zzaf;
        this.zzbi = beginSignInRequest;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzaf zzaf = this.zzbh;
        BeginSignInRequest beginSignInRequest = this.zzbi;
        ((zzad) ((zzak) obj).getService()).zzc(new zzaj(zzaf, (TaskCompletionSource) obj2), (BeginSignInRequest) Preconditions.checkNotNull(beginSignInRequest));
    }
}
