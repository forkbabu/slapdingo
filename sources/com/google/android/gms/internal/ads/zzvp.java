package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class zzvp {
    /* access modifiers changed from: private */
    public final zzvc zzchr;
    /* access modifiers changed from: private */
    public final zzuz zzchs;
    /* access modifiers changed from: private */
    public final zzzf zzcht;
    /* access modifiers changed from: private */
    public final zzafx zzchu;
    /* access modifiers changed from: private */
    public final zzatu zzchv;
    private final zzauy zzchw;
    /* access modifiers changed from: private */
    public final zzaqg zzchx;
    /* access modifiers changed from: private */
    public final zzafw zzchy;

    public zzvp(zzvc zzvc, zzuz zzuz, zzzf zzzf, zzafx zzafx, zzatu zzatu, zzauy zzauy, zzaqg zzaqg, zzafw zzafw) {
        this.zzchr = zzvc;
        this.zzchs = zzuz;
        this.zzcht = zzzf;
        this.zzchu = zzafx;
        this.zzchv = zzatu;
        this.zzchw = zzauy;
        this.zzchx = zzaqg;
        this.zzchy = zzafw;
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzwg.zzps().zza(context, zzwg.zzpy().zzbpn, "gmob-apps", bundle, true);
    }

    public final zzww zza(Context context, zzvh zzvh, String str, zzamr zzamr) {
        return (zzww) new zzvv(this, context, zzvh, str, zzamr).zzd(context, false);
    }

    public final zzwp zzb(Context context, String str, zzamr zzamr) {
        return (zzwp) new zzwa(this, context, str, zzamr).zzd(context, false);
    }

    public final zzadx zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzadx) new zzwc(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzaea zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzaea) new zzwb(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzaui zzc(Context context, String str, zzamr zzamr) {
        return (zzaui) new zzvr(this, context, str, zzamr).zzd(context, false);
    }

    public final zzaqi zzb(Activity activity) {
        zzvu zzvu = new zzvu(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbba.zzfb("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzaqi) zzvu.zzd(activity, z);
    }

    public final zzawr zza(Context context, zzamr zzamr) {
        return (zzawr) new zzvt(this, context, zzamr).zzd(context, false);
    }
}
