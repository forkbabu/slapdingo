package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzarg {
    @Nonnull
    private final View zzaas;
    private final Map<String, WeakReference<View>> zzdow;
    private final zzawr zzdox;

    public zzarg(zzarh zzarh) {
        Map<String, WeakReference<View>> map;
        this.zzaas = zzarh.zzaas;
        this.zzdow = zzarh.zzdow;
        zzawr zzs = zzare.zzs(zzarh.zzaas.getContext());
        this.zzdox = zzs;
        if (zzs != null && (map = this.zzdow) != null && !map.isEmpty()) {
            try {
                this.zzdox.zza(new zzark(ObjectWrapper.wrap(this.zzaas).asBinder(), ObjectWrapper.wrap(this.zzdow).asBinder()));
            } catch (RemoteException unused) {
                zzbba.zzfb("Failed to call remote method.");
            }
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzdox == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdox.zza(list, ObjectWrapper.wrap(this.zzaas), new zzarf(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzdox == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdox.zzb(new ArrayList(Arrays.asList(uri)), ObjectWrapper.wrap(this.zzaas), new zzari(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzawr zzawr = this.zzdox;
        if (zzawr == null) {
            zzbba.zzee("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzawr.zzan(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzbba.zzfb("Failed to call remote method.");
        }
    }
}
