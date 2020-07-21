package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcoa extends zzcny {
    public zzcoa(Context context) {
        this.zzghl = new zzaru(context, zzq.zzlk().zzya(), this, this);
    }

    public final zzdvf<InputStream> zzj(zzasm zzasm) {
        synchronized (this.mLock) {
            if (this.zzghi) {
                zzbbn zzbbn = this.zzdhu;
                return zzbbn;
            }
            this.zzghi = true;
            this.zzghk = zzasm;
            ((zzcny) this).zzghl.checkAvailabilityAndConnect();
            this.zzdhu.addListener(new zzcod(this), zzbbf.zzedm);
            zzbbn zzbbn2 = this.zzdhu;
            return zzbbn2;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzghj) {
                this.zzghj = true;
                try {
                    this.zzghl.zzuw().zzb(this.zzghk, new zzcob(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdhu.setException(new zzcop(zzdls.zzhbq));
                } catch (Throwable th) {
                    zzq.zzla().zza(th, "RemoteSignalsClientTask.onConnected");
                    this.zzdhu.setException(new zzcop(zzdls.zzhbq));
                }
            }
        }
    }
}
