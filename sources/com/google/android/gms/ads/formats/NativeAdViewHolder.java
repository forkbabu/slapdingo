package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaea;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzwg;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbnp = new WeakHashMap<>();
    private zzaea zzbno;
    private WeakReference<View> zzbnq;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzbba.zzfb("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzbnp.get(view) != null) {
            zzbba.zzfb("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzbnp.put(view, this);
            this.zzbnq = new WeakReference<>(view);
            this.zzbno = zzwg.zzpt().zza(view, zzb(map), zzb(map2));
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zza((IObjectWrapper) nativeAd.zzjr());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zza((IObjectWrapper) unifiedNativeAd.zzjr());
    }

    private final void zza(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.zzbnq;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzbba.zzfd("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbnp.containsKey(view)) {
            zzbnp.put(view, this);
        }
        zzaea zzaea = this.zzbno;
        if (zzaea != null) {
            try {
                zzaea.zza(iObjectWrapper);
            } catch (RemoteException e) {
                zzbba.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void unregisterNativeAd() {
        zzaea zzaea = this.zzbno;
        if (zzaea != null) {
            try {
                zzaea.unregisterNativeAd();
            } catch (RemoteException e) {
                zzbba.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzbnq;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            zzbnp.remove(view);
        }
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbno.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbba.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }
}
