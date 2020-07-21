package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzagf extends zzafg {
    /* access modifiers changed from: private */
    public final OnPublisherAdViewLoadedListener zzddf;

    public zzagf(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzddf = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafh
    public final void zza(zzww zzww, IObjectWrapper iObjectWrapper) {
        if (zzww != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzww.zzkl() instanceof zzva) {
                    zzva zzva = (zzva) zzww.zzkl();
                    publisherAdView.setAdListener(zzva != null ? zzva.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzbba.zzc("", e);
            }
            try {
                if (zzww.zzkk() instanceof zzvl) {
                    zzvl zzvl = (zzvl) zzww.zzkk();
                    if (zzvl != null) {
                        appEventListener = zzvl.getAppEventListener();
                    }
                    publisherAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzbba.zzc("", e2);
            }
            zzbaq.zzaag.post(new zzage(this, publisherAdView, zzww));
        }
    }
}
