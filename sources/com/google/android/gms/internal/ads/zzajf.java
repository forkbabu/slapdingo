package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzajf {
    private final zzwp zzacp;
    private final Context zzvr;

    public zzajf(Context context, String str) {
        this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzwg.zzpt().zzb(context, str, new zzamo()));
    }

    private zzajf(Context context, zzwp zzwp) {
        this.zzvr = context;
        this.zzacp = zzwp;
    }

    public final zzajf zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.zzacp.zza(new zzajd(instreamAdLoadCallback));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzajf zza(zzaja zzaja) {
        try {
            this.zzacp.zza(new zzaio(zzaja));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzajc zzsx() {
        try {
            return new zzajc(this.zzvr, this.zzacp.zzqb());
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
