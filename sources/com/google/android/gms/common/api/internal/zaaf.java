package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaaf implements zabb {
    /* access modifiers changed from: private */
    public final zabe zafv;
    private boolean zafw = false;

    public zaaf(zabe zabe) {
        this.zafv = zabe;
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return execute(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: A} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: A} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: A} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: A} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: A} */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.zabb
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        try {
            this.zafv.zaeh.zahj.zac(t);
            zaaw zaaw = this.zafv.zaeh;
            A a = zaaw.zahd.get(t.getClientKey());
            Preconditions.checkNotNull(a, "Appropriate Api was not requested.");
            if (a.isConnected() || !this.zafv.zaht.containsKey(t.getClientKey())) {
                if (a instanceof SimpleClientAdapter) {
                    a = a.getClient();
                }
                t.run(a);
                return t;
            }
            t.setFailedResult(new Status(17));
            return t;
        } catch (DeadObjectException unused) {
            this.zafv.zaa(new zaai(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final boolean disconnect() {
        if (this.zafw) {
            return false;
        }
        if (this.zafv.zaeh.zaav()) {
            this.zafw = true;
            for (zack zack : this.zafv.zaeh.zahi) {
                zack.zabt();
            }
            return false;
        }
        this.zafv.zaf(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void connect() {
        if (this.zafw) {
            this.zafw = false;
            this.zafv.zaa(new zaah(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void onConnectionSuspended(int i) {
        this.zafv.zaf(null);
        this.zafv.zahx.zab(i, this.zafw);
    }

    /* access modifiers changed from: package-private */
    public final void zaak() {
        if (this.zafw) {
            this.zafw = false;
            this.zafv.zaeh.zahj.release();
            disconnect();
        }
    }
}
