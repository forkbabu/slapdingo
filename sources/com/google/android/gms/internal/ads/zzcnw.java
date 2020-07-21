package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcnw extends zzcny {
    public zzcnw(Context context) {
        this.zzghl = new zzaru(context, zzq.zzlk().zzya(), this, this);
    }

    public final zzdvf<InputStream> zzi(zzasm zzasm) {
        synchronized (this.mLock) {
            if (this.zzghi) {
                zzbbn zzbbn = this.zzdhu;
                return zzbbn;
            }
            this.zzghi = true;
            this.zzghk = zzasm;
            ((zzcny) this).zzghl.checkAvailabilityAndConnect();
            this.zzdhu.addListener(new zzcnz(this), zzbbf.zzedm);
            zzbbn zzbbn2 = this.zzdhu;
            return zzbbn2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcny, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzaxv.zzee("Cannot connect to remote service, fallback to local instance.");
        this.zzdhu.setException(new zzcop(zzdls.zzhbq));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzghj) {
                this.zzghj = true;
                try {
                    this.zzghl.zzuw().zza(this.zzghk, new zzcob(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdhu.setException(new zzcop(zzdls.zzhbq));
                } catch (Throwable th) {
                    zzq.zzla().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.zzdhu.setException(new zzcop(zzdls.zzhbq));
                }
            }
        }
    }
}
