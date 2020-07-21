package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzaia implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbbn zzbvf;
    private final /* synthetic */ zzahw zzdeq;

    zzaia(zzahw zzahw, zzbbn zzbbn) {
        this.zzdeq = zzahw;
        this.zzbvf = zzbbn;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        try {
            this.zzbvf.set(this.zzdeq.zzdeo.zzss());
        } catch (DeadObjectException e) {
            this.zzbvf.setException(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbbn zzbbn = this.zzbvf;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbbn.setException(new RuntimeException(sb.toString()));
    }
}
