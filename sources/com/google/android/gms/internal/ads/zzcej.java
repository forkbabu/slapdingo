package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcej implements zzccs {
    private final zzbbd zzboy;
    private final zzdkk zzfol;
    private final zzdla zzfpv;
    private final zzbtc zzfuv;
    private final zzbsk zzfuw;
    private boolean zzfva = false;
    private boolean zzfvd = false;
    private final zzana zzfzv;
    private final zzanf zzfzw;
    private final zzang zzfzx;
    private final Context zzvr;

    public zzcej(zzana zzana, zzanf zzanf, zzang zzang, zzbtc zzbtc, zzbsk zzbsk, Context context, zzdkk zzdkk, zzbbd zzbbd, zzdla zzdla) {
        this.zzfzv = zzana;
        this.zzfzw = zzanf;
        this.zzfzx = zzang;
        this.zzfuv = zzbtc;
        this.zzfuw = zzbsk;
        this.zzvr = context;
        this.zzfol = zzdkk;
        this.zzboy = zzbbd;
        this.zzfpv = zzdla;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void cancelUnconfirmedClick() {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void setClickConfirmingView(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(zzafo zzafo) {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzakv() {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzakx() {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzfy(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzg(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzh(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean zzi(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            if (this.zzfzx != null) {
                this.zzfzx.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
            } else if (this.zzfzv != null) {
                this.zzfzv.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzfzv.zzv(wrap);
            } else if (this.zzfzw != null) {
                this.zzfzw.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzfzw.zzv(wrap);
            }
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to call trackView", e);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            if (this.zzfzx != null) {
                this.zzfzx.zzw(wrap);
            } else if (this.zzfzv != null) {
                this.zzfzv.zzw(wrap);
            } else if (this.zzfzw != null) {
                this.zzfzw.zzw(wrap);
            }
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfvd || !this.zzfol.zzdiu) {
            zzad(view);
        }
    }

    private final void zzad(View view) {
        try {
            if (this.zzfzx != null && !this.zzfzx.getOverrideClickHandling()) {
                this.zzfzx.zzu(ObjectWrapper.wrap(view));
                this.zzfuw.onAdClicked();
            } else if (this.zzfzv != null && !this.zzfzv.getOverrideClickHandling()) {
                this.zzfzv.zzu(ObjectWrapper.wrap(view));
                this.zzfuw.onAdClicked();
            } else if (this.zzfzw != null && !this.zzfzw.getOverrideClickHandling()) {
                this.zzfzw.zzu(ObjectWrapper.wrap(view));
                this.zzfuw.onAdClicked();
            }
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to call handleClick", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfvd) {
            zzaxv.zzfd("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzfol.zzdiu) {
            zzaxv.zzfd("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            zzad(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzsm() {
        this.zzfvd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean isCustomClickGestureEnabled() {
        return this.zzfol.zzdiu;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzfva && this.zzfol.zzgzw != null) {
                this.zzfva |= zzq.zzlg().zzb(this.zzvr, this.zzboy.zzbpn, this.zzfol.zzgzw.toString(), this.zzfpv.zzhaz);
            }
            if (this.zzfzx != null && !this.zzfzx.getOverrideImpressionRecording()) {
                this.zzfzx.recordImpression();
                this.zzfuv.onAdImpression();
            } else if (this.zzfzv != null && !this.zzfzv.getOverrideImpressionRecording()) {
                this.zzfzv.recordImpression();
                this.zzfuv.onAdImpression();
            } else if (this.zzfzw != null && !this.zzfzw.getOverrideImpressionRecording()) {
                this.zzfzw.recordImpression();
                this.zzfuv.onAdImpression();
            }
        } catch (RemoteException e) {
            zzaxv.zzd("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(zzxt zzxt) {
        zzaxv.zzfd("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(zzxp zzxp) {
        zzaxv.zzfd("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzakw() {
        zzaxv.zzfd("Mute This Ad is not supported for 3rd party ads");
    }
}
