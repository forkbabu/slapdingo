package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzy extends zzafm {
    private final ShouldDelayBannerRenderingListener zzckp;

    public zzzy(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzckp = shouldDelayBannerRenderingListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        return this.zzckp.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
