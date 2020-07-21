package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzcny implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final Object mLock = new Object();
    protected final zzbbn<InputStream> zzdhu = new zzbbn<>();
    protected boolean zzghi = false;
    protected boolean zzghj = false;
    protected zzasm zzghk;
    protected zzaru zzghl;

    /* access modifiers changed from: protected */
    public final void zzape() {
        synchronized (this.mLock) {
            this.zzghj = true;
            if (this.zzghl.isConnected() || this.zzghl.isConnecting()) {
                this.zzghl.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public void onConnectionSuspended(int i) {
        zzaxv.zzee("Cannot connect to remote service, fallback to local instance.");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzaxv.zzee("Disconnected from remote ad request service.");
        this.zzdhu.setException(new zzcop(zzdls.zzhbq));
    }
}
