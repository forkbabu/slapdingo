package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    private static final zzc zzbm = new zzc(null);
    private static int zzbn = zzd.zzbq;

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    private static class zzc implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private zzc() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Result] */
        @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
        public final /* synthetic */ GoogleSignInAccount convert(GoogleSignInResult googleSignInResult) {
            return googleSignInResult.getSignInAccount();
        }

        /* synthetic */ zzc(zzc zzc) {
            this();
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    static final class zzd {
        public static final int zzbq = 1;
        public static final int zzbr = 2;
        public static final int zzbs = 3;
        public static final int zzbt = 4;
        private static final /* synthetic */ int[] zzbu = {1, 2, 3, 4};

        public static int[] zzh() {
            return (int[]) zzbu.clone();
        }
    }

    GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new ApiExceptionMapper());
    }

    GoogleSignInClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, (Api) Auth.GOOGLE_SIGN_IN_API, (Api.ApiOptions) googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    private final synchronized int zzg() {
        if (zzbn == zzd.zzbq) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0) {
                zzbn = zzd.zzbt;
            } else if (instance.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                zzbn = zzd.zzbr;
            } else {
                zzbn = zzd.zzbs;
            }
        }
        return zzbn;
    }

    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        int i = zzc.zzbo[zzg() - 1];
        if (i == 1) {
            return zzg.zzd(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
        if (i != 2) {
            return zzg.zze(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
        return zzg.zzc(applicationContext, (GoogleSignInOptions) getApiOptions());
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        return PendingResultUtil.toTask(zzg.zzc(asGoogleApiClient(), getApplicationContext(), (GoogleSignInOptions) getApiOptions(), zzg() == zzd.zzbs), zzbm);
    }

    public Task<Void> signOut() {
        return PendingResultUtil.toVoidTask(zzg.zzc(asGoogleApiClient(), getApplicationContext(), zzg() == zzd.zzbs));
    }

    public Task<Void> revokeAccess() {
        return PendingResultUtil.toVoidTask(zzg.zzd(asGoogleApiClient(), getApplicationContext(), zzg() == zzd.zzbs));
    }
}
