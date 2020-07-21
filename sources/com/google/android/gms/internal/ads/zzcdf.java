package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcdf extends zzaed implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcee {
    private zzccd zzfya;
    private zzqo zzfyb;
    private final WeakReference<View> zzfye;
    private final Map<String, WeakReference<View>> zzfyf = new HashMap();
    private final Map<String, WeakReference<View>> zzfyg = new HashMap();
    private final Map<String, WeakReference<View>> zzfyh = new HashMap();

    public zzcdf(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzq.zzlt();
        zzbbv.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzq.zzlt();
        zzbbv.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzfye = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzfyf.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.zzfyh.putAll(this.zzfyf);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.zzfyg.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.zzfyh.putAll(this.zzfyg);
        this.zzfyb = new zzqo(view.getContext(), view);
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final FrameLayout zzaml() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final synchronized void unregisterNativeAd() {
        if (this.zzfya != null) {
            this.zzfya.zzb(this);
            this.zzfya = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzccd)) {
            zzaxv.zzfd("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzfya != null) {
            this.zzfya.zzb(this);
        }
        if (((zzccd) unwrap).zzalb()) {
            zzccd zzccd = (zzccd) unwrap;
            this.zzfya = zzccd;
            zzccd.zza(this);
            this.zzfya.zzaa(zzahk());
            return;
        }
        zzaxv.zzfb("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final View zzahk() {
        return this.zzfye.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final zzqo zzamm() {
        return this.zzfyb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzcee
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfyh     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfyf     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzfyg     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0014:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfyh
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r4.put(r2, r0)
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0045
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzfyf
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r4.put(r2, r0)
            r2 = 1
            r3.setClickable(r2)
            r3.setOnClickListener(r1)
            r3.setOnTouchListener(r1)
            monitor-exit(r1)
            return
        L_0x0045:
            monitor-exit(r1)
            return
        L_0x0047:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdf.zza(java.lang.String, android.view.View, boolean):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final synchronized Map<String, WeakReference<View>> zzamh() {
        return this.zzfyh;
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final synchronized Map<String, WeakReference<View>> zzami() {
        return this.zzfyf;
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final synchronized Map<String, WeakReference<View>> zzamj() {
        return this.zzfyg;
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final synchronized View zzge(String str) {
        WeakReference<View> weakReference = this.zzfyh.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final synchronized String zzamk() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Override // com.google.android.gms.internal.ads.zzcee
    public final synchronized IObjectWrapper zzamn() {
        return null;
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzfya != null) {
            this.zzfya.zza(view, motionEvent, zzahk());
        }
        return false;
    }

    public final synchronized void onClick(View view) {
        if (this.zzfya != null) {
            this.zzfya.zza(view, zzahk(), zzamh(), zzami(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzfya != null) {
            this.zzfya.zzb(zzahk(), zzamh(), zzami(), zzccd.zzz(zzahk()));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzfya != null) {
            this.zzfya.zzb(zzahk(), zzamh(), zzami(), zzccd.zzz(zzahk()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.zzfya != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzaxv.zzfd("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzfya.setClickConfirmingView((View) unwrap);
        }
    }
}
