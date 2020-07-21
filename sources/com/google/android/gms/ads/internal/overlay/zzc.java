package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzayj;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfv;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zztm;
import com.google.android.gms.internal.ads.zzwg;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzc extends zzaqh implements zzy {
    private static final int zzdna = Color.argb(0, 0, 0, 0);
    protected final Activity zzaar;
    private boolean zzboj = false;
    zzbfn zzdfp;
    AdOverlayInfoParcel zzdnb;
    private zzi zzdnc;
    private zzq zzdnd;
    private boolean zzdne = false;
    private FrameLayout zzdnf;
    private WebChromeClient.CustomViewCallback zzdng;
    private boolean zzdnh = false;
    private zzj zzdni;
    private boolean zzdnj = false;
    int zzdnk = 0;
    private final Object zzdnl = new Object();
    private Runnable zzdnm;
    private boolean zzdnn;
    private boolean zzdno;
    private boolean zzdnp = false;
    private boolean zzdnq = false;
    private boolean zzdnr = true;

    public zzc(Activity activity) {
        this.zzaar = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onRestart() {
    }

    public final void close() {
        this.zzdnk = 2;
        this.zzaar.finish();
    }

    public final void zzuj() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdnb;
        if (adOverlayInfoParcel != null && this.zzdne) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdnf != null) {
            this.zzaar.setContentView(this.zzdni);
            this.zzdno = true;
            this.zzdnf.removeAllViews();
            this.zzdnf = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdng;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdng = null;
        }
        this.zzdne = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void zzuk() {
        this.zzdnk = 1;
        this.zzaar.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onBackPressed() {
        this.zzdnk = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final boolean zzul() {
        this.zzdnk = 0;
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn == null) {
            return true;
        }
        boolean zzabg = zzbfn.zzabg();
        if (!zzabg) {
            this.zzdfp.zza("onbackblocked", Collections.emptyMap());
        }
        return zzabg;
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public void onCreate(Bundle bundle) {
        this.zzaar.requestWindowFeature(1);
        this.zzdnh = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(this.zzaar.getIntent());
            this.zzdnb = zzc;
            if (zzc != null) {
                if (zzc.zzboy.zzede > 7500000) {
                    this.zzdnk = 3;
                }
                if (this.zzaar.getIntent() != null) {
                    this.zzdnr = this.zzaar.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.zzdnb.zzdol != null) {
                    this.zzboj = this.zzdnb.zzdol.zzboj;
                } else {
                    this.zzboj = false;
                }
                if (this.zzboj && this.zzdnb.zzdol.zzboo != -1) {
                    new zzl(this).zzwq();
                }
                if (bundle == null) {
                    if (this.zzdnb.zzdoe != null && this.zzdnr) {
                        this.zzdnb.zzdoe.zzue();
                    }
                    if (!(this.zzdnb.zzdoj == 1 || this.zzdnb.zzcgl == null)) {
                        this.zzdnb.zzcgl.onAdClicked();
                    }
                }
                zzj zzj = new zzj(this.zzaar, this.zzdnb.zzdok, this.zzdnb.zzboy.zzbpn);
                this.zzdni = zzj;
                zzj.setId(1000);
                zzq.zzky().zzg(this.zzaar);
                int i = this.zzdnb.zzdoj;
                if (i == 1) {
                    zzaj(false);
                } else if (i == 2) {
                    this.zzdnc = new zzi(this.zzdnb.zzdfp);
                    zzaj(false);
                } else if (i == 3) {
                    zzaj(true);
                } else {
                    throw new zzg("Could not determine ad overlay type.");
                }
            } else {
                throw new zzg("Could not get info for ad overlay.");
            }
        } catch (zzg e) {
            zzaxv.zzfd(e.getMessage());
            this.zzdnk = 3;
            this.zzaar.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onStart() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzctb)).booleanValue()) {
            zzbfn zzbfn = this.zzdfp;
            if (zzbfn == null || zzbfn.isDestroyed()) {
                zzaxv.zzfd("The webview does not exist. Ignoring action.");
                return;
            }
            zzq.zzky();
            zzayj.zzb(this.zzdfp);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onResume() {
        if (this.zzdnb.zzdoe != null) {
            this.zzdnb.zzdoe.onResume();
        }
        zza(this.zzaar.getResources().getConfiguration());
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzctb)).booleanValue()) {
            zzbfn zzbfn = this.zzdfp;
            if (zzbfn == null || zzbfn.isDestroyed()) {
                zzaxv.zzfd("The webview does not exist. Ignoring action.");
                return;
            }
            zzq.zzky();
            zzayj.zzb(this.zzdfp);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onPause() {
        zzuj();
        if (this.zzdnb.zzdoe != null) {
            this.zzdnb.zzdoe.onPause();
        }
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzctb)).booleanValue() && this.zzdfp != null && (!this.zzaar.isFinishing() || this.zzdnc == null)) {
            zzq.zzky();
            zzayj.zza(this.zzdfp);
        }
        zzun();
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void zzad(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdnh);
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onStop() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzctb)).booleanValue() && this.zzdfp != null && (!this.zzaar.isFinishing() || this.zzdnc == null)) {
            zzq.zzky();
            zzayj.zza(this.zzdfp);
        }
        zzun();
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void onDestroy() {
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn != null) {
            try {
                this.zzdni.removeView(zzbfn.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzun();
    }

    private final void zzai(boolean z) {
        int intValue = ((Integer) zzwg.zzpw().zzd(zzaav.zzctd)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = z ? intValue : 0;
        zzp.paddingRight = z ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        this.zzdnd = new zzq(this.zzaar, zzp, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdnb.zzdog);
        this.zzdni.addView(this.zzdnd, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzaqi
    public final void zzdp() {
        this.zzdno = true;
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcoi)).booleanValue() && (adOverlayInfoParcel2 = this.zzdnb) != null && adOverlayInfoParcel2.zzdol != null && this.zzdnb.zzdol.zzboq;
        boolean z5 = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcoj)).booleanValue() && (adOverlayInfoParcel = this.zzdnb) != null && adOverlayInfoParcel.zzdol != null && this.zzdnb.zzdol.zzbor;
        if (z && z2 && z4 && !z5) {
            new zzaqd(this.zzdfp, "useCustomClose").zzdw("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzq zzq = this.zzdnd;
        if (zzq != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzq.zzal(z3);
        }
    }

    public final void zzum() {
        this.zzdni.removeView(this.zzdnd);
        zzai(true);
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaar.getApplicationInfo().targetSdkVersion >= ((Integer) zzwg.zzpw().zzd(zzaav.zzcvd)).intValue()) {
            if (this.zzaar.getApplicationInfo().targetSdkVersion <= ((Integer) zzwg.zzpw().zzd(zzaav.zzcve)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzwg.zzpw().zzd(zzaav.zzcvf)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzwg.zzpw().zzd(zzaav.zzcvg)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzaar.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzq.zzla().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzaar);
        this.zzdnf = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzdnf.addView(view, -1, -1);
        this.zzaar.setContentView(this.zzdnf);
        this.zzdno = true;
        this.zzdng = customViewCallback;
        this.zzdne = true;
    }

    private final void zzaj(boolean z) throws zzg {
        if (!this.zzdno) {
            this.zzaar.requestWindowFeature(1);
        }
        Window window = this.zzaar.getWindow();
        if (window != null) {
            zzbgz zzaaz = this.zzdnb.zzdfp != null ? this.zzdnb.zzdfp.zzaaz() : null;
            boolean z2 = false;
            boolean z3 = zzaaz != null && zzaaz.zzabs();
            this.zzdnj = false;
            if (z3) {
                int i = this.zzdnb.orientation;
                zzq.zzky();
                if (i == 6) {
                    if (this.zzaar.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzdnj = z2;
                } else {
                    int i2 = this.zzdnb.orientation;
                    zzq.zzky();
                    if (i2 == 7) {
                        if (this.zzaar.getResources().getConfiguration().orientation == 2) {
                            z2 = true;
                        }
                        this.zzdnj = z2;
                    }
                }
            }
            boolean z4 = this.zzdnj;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z4);
            zzaxv.zzee(sb.toString());
            setRequestedOrientation(this.zzdnb.orientation);
            zzq.zzky();
            window.setFlags(16777216, 16777216);
            zzaxv.zzee("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzboj) {
                this.zzdni.setBackgroundColor(-16777216);
            } else {
                this.zzdni.setBackgroundColor(zzdna);
            }
            this.zzaar.setContentView(this.zzdni);
            this.zzdno = true;
            if (z) {
                try {
                    zzq.zzkx();
                    zzbfn zza = zzbfv.zza(this.zzaar, this.zzdnb.zzdfp != null ? this.zzdnb.zzdfp.zzaax() : null, this.zzdnb.zzdfp != null ? this.zzdnb.zzdfp.zzaay() : null, true, z3, null, this.zzdnb.zzboy, null, null, this.zzdnb.zzdfp != null ? this.zzdnb.zzdfp.zzzm() : null, zztm.zzmz(), null, false);
                    this.zzdfp = zza;
                    zza.zzaaz().zza(null, this.zzdnb.zzddi, null, this.zzdnb.zzddj, this.zzdnb.zzdoi, true, null, this.zzdnb.zzdfp != null ? this.zzdnb.zzdfp.zzaaz().zzabr() : null, null, null);
                    this.zzdfp.zzaaz().zza(new zzf(this));
                    if (this.zzdnb.url != null) {
                        this.zzdfp.loadUrl(this.zzdnb.url);
                    } else if (this.zzdnb.zzdoh != null) {
                        this.zzdfp.loadDataWithBaseURL(this.zzdnb.zzdof, this.zzdnb.zzdoh, "text/html", XmpWriter.UTF8, null);
                    } else {
                        throw new zzg("No URL or HTML to display in ad overlay.");
                    }
                    if (this.zzdnb.zzdfp != null) {
                        this.zzdnb.zzdfp.zzb(this);
                    }
                } catch (Exception e) {
                    zzaxv.zzc("Error obtaining webview.", e);
                    throw new zzg("Could not obtain webview for the overlay.");
                }
            } else {
                zzbfn zzbfn = this.zzdnb.zzdfp;
                this.zzdfp = zzbfn;
                zzbfn.zzbw(this.zzaar);
            }
            this.zzdfp.zza(this);
            if (this.zzdnb.zzdfp != null) {
                zzc(this.zzdnb.zzdfp.zzabd(), this.zzdni);
            }
            ViewParent parent = this.zzdfp.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzdfp.getView());
            }
            if (this.zzboj) {
                this.zzdfp.zzabl();
            }
            this.zzdfp.zza((ViewGroup) null, this.zzaar, this.zzdnb.zzdof, this.zzdnb.zzdoh);
            this.zzdni.addView(this.zzdfp.getView(), -1, -1);
            if (!z && !this.zzdnj) {
                zzuq();
            }
            zzai(z3);
            if (this.zzdfp.zzabb()) {
                zza(z3, true);
                return;
            }
            return;
        }
        throw new zzg("Invalid activity, no window available.");
    }

    private final void zzun() {
        if (this.zzaar.isFinishing() && !this.zzdnp) {
            this.zzdnp = true;
            zzbfn zzbfn = this.zzdfp;
            if (zzbfn != null) {
                zzbfn.zzds(this.zzdnk);
                synchronized (this.zzdnl) {
                    if (!this.zzdnn && this.zzdfp.zzabh()) {
                        this.zzdnm = new zze(this);
                        zzaye.zzdzw.postDelayed(this.zzdnm, ((Long) zzwg.zzpw().zzd(zzaav.zzcoh)).longValue());
                        return;
                    }
                }
            }
            zzuo();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzuo() {
        if (!this.zzdnq) {
            this.zzdnq = true;
            zzbfn zzbfn = this.zzdfp;
            if (zzbfn != null) {
                this.zzdni.removeView(zzbfn.getView());
                zzi zzi = this.zzdnc;
                if (zzi != null) {
                    this.zzdfp.zzbw(zzi.zzvr);
                    this.zzdfp.zzax(false);
                    this.zzdnc.parent.addView(this.zzdfp.getView(), this.zzdnc.index, this.zzdnc.zzdnx);
                    this.zzdnc = null;
                } else if (this.zzaar.getApplicationContext() != null) {
                    this.zzdfp.zzbw(this.zzaar.getApplicationContext());
                }
                this.zzdfp = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdnb;
            if (!(adOverlayInfoParcel == null || adOverlayInfoParcel.zzdoe == null)) {
                this.zzdnb.zzdoe.zzud();
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdnb;
            if (adOverlayInfoParcel2 != null && adOverlayInfoParcel2.zzdfp != null) {
                zzc(this.zzdnb.zzdfp.zzabd(), this.zzdnb.zzdfp.getView());
            }
        }
    }

    private static void zzc(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper != null && view != null) {
            zzq.zzll().zza(iObjectWrapper, view);
        }
    }

    public final void zzup() {
        if (this.zzdnj) {
            this.zzdnj = false;
            zzuq();
        }
    }

    private final void zzuq() {
        this.zzdfp.zzuq();
    }

    public final void zzur() {
        this.zzdni.zzdnz = true;
    }

    public final void zzus() {
        synchronized (this.zzdnl) {
            this.zzdnn = true;
            if (this.zzdnm != null) {
                zzaye.zzdzw.removeCallbacks(this.zzdnm);
                zzaye.zzdzw.post(this.zzdnm);
            }
        }
    }

    private final void zza(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdnb;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || adOverlayInfoParcel2.zzdol == null || !this.zzdnb.zzdol.zzbok) ? false : true;
        boolean zza = zzq.zzky().zza(this.zzaar, configuration);
        if ((this.zzboj && !z3) || zza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && (adOverlayInfoParcel = this.zzdnb) != null && adOverlayInfoParcel.zzdol != null && this.zzdnb.zzdol.zzbop) {
            z2 = true;
        }
        Window window = this.zzaar.getWindow();
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcok)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = 5380;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
        } else if (z) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (Build.VERSION.SDK_INT >= 19 && z2) {
                window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            }
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }
}
