package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcof extends zzcny {
    private String zzghq;
    private int zzghr = zzcog.zzghs;

    public zzcof(Context context) {
        this.zzghl = new zzaru(context, zzq.zzlk().zzya(), this, this);
    }

    public final zzdvf<InputStream> zzk(zzasm zzasm) {
        synchronized (this.mLock) {
            if (this.zzghr != zzcog.zzghs && this.zzghr != zzcog.zzght) {
                zzdvf<InputStream> immediateFailedFuture = zzdux.immediateFailedFuture(new zzcop(zzdls.zzhbr));
                return immediateFailedFuture;
            } else if (this.zzghi) {
                zzbbn zzbbn = this.zzdhu;
                return zzbbn;
            } else {
                this.zzghr = zzcog.zzght;
                this.zzghi = true;
                this.zzghk = zzasm;
                ((zzcny) this).zzghl.checkAvailabilityAndConnect();
                this.zzdhu.addListener(new zzcoe(this), zzbbf.zzedm);
                zzbbn zzbbn2 = this.zzdhu;
                return zzbbn2;
            }
        }
    }

    public final zzdvf<InputStream> zzgl(String str) {
        synchronized (this.mLock) {
            if (this.zzghr != zzcog.zzghs && this.zzghr != zzcog.zzghu) {
                zzdvf<InputStream> immediateFailedFuture = zzdux.immediateFailedFuture(new zzcop(zzdls.zzhbr));
                return immediateFailedFuture;
            } else if (this.zzghi) {
                zzbbn zzbbn = this.zzdhu;
                return zzbbn;
            } else {
                this.zzghr = zzcog.zzghu;
                this.zzghi = true;
                this.zzghq = str;
                ((zzcny) this).zzghl.checkAvailabilityAndConnect();
                this.zzdhu.addListener(new zzcoh(this), zzbbf.zzedm);
                zzbbn zzbbn2 = this.zzdhu;
                return zzbbn2;
            }
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
                    if (this.zzghr == zzcog.zzght) {
                        this.zzghl.zzuw().zzc(this.zzghk, new zzcob(this));
                    } else if (this.zzghr == zzcog.zzghu) {
                        this.zzghl.zzuw().zza(this.zzghq, new zzcob(this));
                    } else {
                        this.zzdhu.setException(new zzcop(zzdls.zzhbq));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdhu.setException(new zzcop(zzdls.zzhbq));
                } catch (Throwable th) {
                    zzq.zzla().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zzdhu.setException(new zzcop(zzdls.zzhbq));
                }
            }
        }
    }
}
