package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbk implements zzccs {
    private final zzbbd zzboy;
    private final Clock zzbqd;
    private final zzeg zzemz;
    private final zzdpd zzfkp;
    private final zzccv zzfnj;
    private final zzdkk zzfol;
    private final zzdla zzfpv;
    private final JSONObject zzfus;
    private final zzcgr zzfut;
    private final zzcck zzfuu;
    /* access modifiers changed from: private */
    public final zzbtc zzfuv;
    /* access modifiers changed from: private */
    public final zzbsk zzfuw;
    private final zzblu zzfux;
    private final zzcdn zzfuy;
    private final zzbyj zzfuz;
    private boolean zzfva = false;
    private boolean zzfvb;
    private boolean zzfvc = false;
    private boolean zzfvd = false;
    private Point zzfve = new Point();
    private Point zzfvf = new Point();
    private long zzfvg = 0;
    private long zzfvh = 0;
    private zzxp zzfvi;
    private final Context zzvr;

    public zzcbk(Context context, zzccv zzccv, JSONObject jSONObject, zzcgr zzcgr, zzcck zzcck, zzeg zzeg, zzbtc zzbtc, zzbsk zzbsk, zzdkk zzdkk, zzbbd zzbbd, zzdla zzdla, zzblu zzblu, zzcdn zzcdn, Clock clock, zzbyj zzbyj, zzdpd zzdpd) {
        this.zzvr = context;
        this.zzfnj = zzccv;
        this.zzfus = jSONObject;
        this.zzfut = zzcgr;
        this.zzfuu = zzcck;
        this.zzemz = zzeg;
        this.zzfuv = zzbtc;
        this.zzfuw = zzbsk;
        this.zzfol = zzdkk;
        this.zzboy = zzbbd;
        this.zzfpv = zzdla;
        this.zzfux = zzblu;
        this.zzfuy = zzcdn;
        this.zzbqd = clock;
        this.zzfuz = zzbyj;
        this.zzfkp = zzdpd;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzfve = new Point();
        this.zzfvf = new Point();
        if (!this.zzfvb) {
            this.zzfuz.zzv(view);
            this.zzfvb = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzfux.zzo(this);
        boolean zzdg = zzbae.zzdg(this.zzboy.zzede);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view2 = entry.getValue().get();
                if (view2 != null) {
                    if (zzdg) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> entry2 : map2.entrySet()) {
                View view3 = entry2.getValue().get();
                if (view3 != null) {
                    if (zzdg) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        this.zzfve = new Point();
        this.zzfvf = new Point();
        this.zzfuz.zzw(view);
        this.zzfvb = false;
    }

    private final boolean zzfx(String str) {
        JSONObject optJSONObject = this.zzfus.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        JSONObject zza = zzbae.zza(this.zzvr, map, map2, view2);
        JSONObject zza2 = zzbae.zza(this.zzvr, view2);
        JSONObject zzt = zzbae.zzt(view2);
        JSONObject zzb = zzbae.zzb(this.zzvr, view2);
        String zzb2 = zzb(view, map);
        zza(view, zza2, zza, zzt, zzb, zzb2, zzbae.zza(zzb2, this.zzvr, this.zzfvf, this.zzfve), null, z, false);
    }

    private final String zzb(View view, Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
        }
        int zzalg = this.zzfuu.zzalg();
        if (zzalg == 1) {
            return "1099";
        }
        if (zzalg == 2) {
            return "2099";
        }
        if (zzalg != 6) {
            return null;
        }
        return "3099";
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzfy(String str) {
        zza(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzg(Bundle bundle) {
        if (bundle == null) {
            zzaxv.zzee("Click data is null. No click is reported.");
        } else if (!zzfx("click_reporting")) {
            zzaxv.zzfb("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, zzq.zzkw().zza(bundle, (JSONObject) null), false, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfvd) {
            zzaxv.zzee("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzaku()) {
            zzaxv.zzee("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            JSONObject zza = zzbae.zza(this.zzvr, map, map2, view);
            JSONObject zza2 = zzbae.zza(this.zzvr, view);
            JSONObject zzt = zzbae.zzt(view);
            JSONObject zzb = zzbae.zzb(this.zzvr, view);
            String zzb2 = zzb(null, map);
            zza(view, zza2, zza, zzt, zzb, zzb2, zzbae.zza(zzb2, this.zzvr, this.zzfvf, this.zzfve), null, z, true);
        }
    }

    private final boolean zzaku() {
        return this.zzfus.optBoolean("allow_custom_click_gesture", false);
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzsm() {
        this.zzfvd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean isCustomClickGestureEnabled() {
        return zzaku();
    }

    private final void zza(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzfus);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.zzfnj.zzgd(this.zzfuu.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zzfuu.zzalg());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.zzfpv.zzdkn != null && this.zzfpv.zzdkn.zzbnl);
            jSONObject8.put("custom_mute_enabled", !this.zzfuu.getMuteThisAdReasons().isEmpty() && this.zzfuu.zzalj() != null);
            if (this.zzfuy.zzamp() != null && this.zzfus.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbqd.currentTimeMillis());
            if (this.zzfvd && zzaku()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzfnj.zzgd(this.zzfuu.getCustomTemplateId()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            jSONObject8.put("click_signals", zzx(view));
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzbqd.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzfvg);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzfvh);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbbj.zza(this.zzfut.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzaxv.zzc("Unable to create click JSON.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzfve = zzbae.zza(motionEvent, view2);
        long currentTimeMillis = this.zzbqd.currentTimeMillis();
        this.zzfvh = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzfvg = currentTimeMillis;
            this.zzfvf = this.zzfve;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation((float) this.zzfve.x, (float) this.zzfve.y);
        this.zzemz.zza(obtain);
        obtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzh(Bundle bundle) {
        if (bundle == null) {
            zzaxv.zzee("Touch event data is null. No touch event is reported.");
        } else if (!zzfx("touch_reporting")) {
            zzaxv.zzfb("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzemz.zzcb().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzakv() {
        zza(null, null, null, null, null, null, false);
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void setClickConfirmingView(View view) {
        if (!this.zzfus.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzaxv.zzfd("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzcdn zzcdn = this.zzfuy;
        if (view != 0) {
            view.setOnClickListener(zzcdn);
            view.setClickable(true);
            zzcdn.zzfyy = new WeakReference<>(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(zzafo zzafo) {
        if (!this.zzfus.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzaxv.zzfd("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzfuy.zza(zzafo);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void cancelUnconfirmedClick() {
        if (this.zzfus.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzfuy.cancelUnconfirmedClick();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(zzxt zzxt) {
        try {
            if (!this.zzfvc) {
                if (zzxt != null || this.zzfuu.zzalj() == null) {
                    this.zzfvc = true;
                    this.zzfkp.zzer(zzxt.zzqg());
                    zzakw();
                    return;
                }
                this.zzfvc = true;
                this.zzfkp.zzer(this.zzfuu.zzalj().zzqg());
                zzakw();
            }
        } catch (RemoteException e) {
            zzaxv.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(zzxp zzxp) {
        this.zzfvi = zzxp;
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzakw() {
        try {
            if (this.zzfvi != null) {
                this.zzfvi.onAdMuted();
            }
        } catch (RemoteException e) {
            zzaxv.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        zza(zzbae.zza(this.zzvr, view), zzbae.zza(this.zzvr, map, map2, view), zzbae.zzt(view), zzbae.zzb(this.zzvr, view), zzy(view), null, zzbae.zza(this.zzfol));
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void zzakx() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzfus);
            zzbbj.zza(this.zzfut.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final boolean zzi(Bundle bundle) {
        if (zzfx("impression_reporting")) {
            return zza(null, null, null, null, null, zzq.zzkw().zza(bundle, (JSONObject) null), false);
        }
        zzaxv.zzfb("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
        return false;
    }

    private final boolean zza(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzfus);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqz)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put("screen", zzbae.zzbm(this.zzvr));
            this.zzfut.zza("/logScionEvent", new zzcbm(this));
            this.zzfut.zza("/nativeImpression", new zzcbp(this));
            zzbbj.zza(this.zzfut.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzfva || this.zzfol.zzgzw == null) {
                return true;
            }
            this.zzfva |= zzq.zzlg().zzb(this.zzvr, this.zzboy.zzbpn, this.zzfol.zzgzw.toString(), this.zzfpv.zzhaz);
            return true;
        } catch (JSONException e) {
            zzaxv.zzc("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final String zzx(View view) {
        try {
            JSONObject optJSONObject = this.zzfus.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.zzemz.zzcb().zza(this.zzvr, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzaxv.zzc("Exception obtaining click signals", e);
            return null;
        }
    }

    private final String zzy(View view) {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcqz)).booleanValue()) {
            return null;
        }
        try {
            return this.zzemz.zzcb().zza(this.zzvr, view, (Activity) null);
        } catch (Exception unused) {
            zzaxv.zzfb("Exception getting data.");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccs
    public final void destroy() {
        this.zzfut.destroy();
    }
}
