package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdqa implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzghi = false;
    private boolean zzghj = false;
    private final zzdqu zzhig;
    private final zzdqm zzhih;

    zzdqa(Context context, Looper looper, zzdqm zzdqm) {
        this.zzhih = zzdqm;
        this.zzhig = new zzdqu(context, looper, this, this, 12800000);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    /* access modifiers changed from: package-private */
    public final void zzavd() {
        synchronized (this.lock) {
            if (!this.zzghi) {
                this.zzghi = true;
                this.zzhig.checkAvailabilityAndConnect();
            }
        }
    }

    private final void zzape() {
        synchronized (this.lock) {
            if (this.zzhig.isConnected() || this.zzhig.isConnecting()) {
                this.zzhig.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.lock) {
            if (!this.zzghj) {
                this.zzghj = true;
                try {
                    this.zzhig.zzavm().zza(new zzdqs(this.zzhih.toByteArray()));
                } catch (Exception unused) {
                } finally {
                    zzape();
                }
            }
        }
    }
}
