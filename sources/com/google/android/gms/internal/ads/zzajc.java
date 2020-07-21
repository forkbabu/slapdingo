package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzajc {
    private final zzvf zzacq;
    private final zzwo zzacr;
    private final Context zzvr;

    zzajc(Context context, zzwo zzwo) {
        this(context, zzwo, zzvf.zzchh);
    }

    private zzajc(Context context, zzwo zzwo, zzvf zzvf) {
        this.zzvr = context;
        this.zzacr = zzwo;
        this.zzacq = zzvf;
    }

    private final void zza(zzyq zzyq) {
        try {
            this.zzacr.zzb(zzvf.zza(this.zzvr, zzyq));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdq());
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdq());
    }
}
