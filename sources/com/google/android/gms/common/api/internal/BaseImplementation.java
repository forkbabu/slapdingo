package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public class BaseImplementation {

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public interface ResultHolder<R> {
        void setFailedResult(Status status);

        void setResult(R r);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        private final Api<?> mApi;
        private final Api.AnyClientKey<A> mClientKey;

        @Deprecated
        protected ApiMethodImpl(Api.AnyClientKey<A> anyClientKey, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            this.mClientKey = (Api.AnyClientKey) Preconditions.checkNotNull(anyClientKey);
            this.mApi = null;
        }

        /* access modifiers changed from: protected */
        public abstract void doExecute(A a) throws RemoteException;

        /* access modifiers changed from: protected */
        public void onSetFailedResult(R r) {
        }

        /* JADX DEBUG: Type inference failed for r3v4. Raw type applied. Possible types: com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$AnyClientKey<A> */
        protected ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.checkNotNull(api, "Api must not be null");
            this.mClientKey = api.getClientKey();
            this.mApi = api;
        }

        protected ApiMethodImpl(BasePendingResult.CallbackHandler<R> callbackHandler) {
            super(callbackHandler);
            this.mClientKey = null;
            this.mApi = null;
        }

        public final Api.AnyClientKey<A> getClientKey() {
            return this.mClientKey;
        }

        public final Api<?> getApi() {
            return this.mApi;
        }

        public final void run(A a) throws DeadObjectException {
            if (a instanceof SimpleClientAdapter) {
                a = a.getClient();
            }
            try {
                doExecute(a);
            } catch (DeadObjectException e) {
                setFailedResult(e);
                throw e;
            } catch (RemoteException e2) {
                setFailedResult(e2);
            }
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public final void setFailedResult(Status status) {
            Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
            R createFailedResult = createFailedResult(status);
            setResult((Result) createFailedResult);
            onSetFailedResult(createFailedResult);
        }

        private void setFailedResult(RemoteException remoteException) {
            setFailedResult(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) ((Result) obj));
        }
    }
}
