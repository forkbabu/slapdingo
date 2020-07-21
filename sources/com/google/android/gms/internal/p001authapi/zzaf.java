package com.google.android.gms.internal.p001authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.SignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api.zzaf  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
public final class zzaf extends GoogleApi<SignInOptions> implements SignInClient {
    private static final Api<SignInOptions> API;
    private static final Api.ClientKey<zzak> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzak, SignInOptions> zzbj;

    public zzaf(Context context, SignInOptions signInOptions) {
        super(context, API, SignInOptions.Builder.zzc(signInOptions).zze(zzal.zzr()).build(), GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public zzaf(Activity activity, SignInOptions signInOptions) {
        super(activity, (Api) API, (Api.ApiOptions) SignInOptions.Builder.zzc(signInOptions).zze(zzal.zzr()).build(), GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final Task<BeginSignInResult> beginSignIn(BeginSignInRequest beginSignInRequest) {
        BeginSignInRequest build = BeginSignInRequest.zzc(beginSignInRequest).zzd(((SignInOptions) getApiOptions()).zzf()).build();
        return doRead(TaskApiCall.builder().setFeatures(zzam.zzcw).run(new zzae(this, build)).setAutoResolveMissingFeatures(false).build());
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        for (GoogleApiClient googleApiClient : GoogleApiClient.getAllClients()) {
            googleApiClient.maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
        return doRead(TaskApiCall.builder().setFeatures(zzam.zzcx).run(new zzah(this)).setAutoResolveMissingFeatures(false).build());
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final SignInCredential getSignInCredentialFromIntent(Intent intent) throws ApiException {
        if (intent != null) {
            Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, NotificationCompat.CATEGORY_STATUS, Status.CREATOR);
            if (status == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            } else if (status.isSuccess()) {
                SignInCredential signInCredential = (SignInCredential) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "sign_in_credential", SignInCredential.CREATOR);
                if (signInCredential != null) {
                    return signInCredential;
                }
                throw new ApiException(Status.RESULT_INTERNAL_ERROR);
            } else {
                throw new ApiException(status);
            }
        } else {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
    }

    static {
        zzag zzag = new zzag();
        zzbj = zzag;
        API = new Api<>("Auth.Api.Identity.SignIn.API", zzag, CLIENT_KEY);
    }
}
