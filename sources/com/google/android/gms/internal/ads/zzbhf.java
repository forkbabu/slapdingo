package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbhf extends zzbhs implements zzbgz {
    private final Object lock = new Object();
    private volatile boolean zzbpo;
    private zzuu zzcgl;
    private zzagi zzddi;
    private zzagk zzddj;
    private zzc zzdee;
    private zzapt zzdef;
    private zzo zzdoe;
    private zzt zzdoi;
    private boolean zzdsh;
    protected zzbfn zzelj;
    private zzbhc zzelm;
    private zzbhb zzeln;
    private zzbhe zzelo;
    private boolean zzelp = false;
    private boolean zzelq;
    private boolean zzelr;
    private boolean zzels;
    private zzaqa zzelt;
    private zzavr zzelu;
    private boolean zzelv;
    private boolean zzelw;
    private int zzelx;
    private View.OnAttachStateChangeListener zzely;
    private final zzajt<zzbfn> zzepa = new zzajt<>();

    /* access modifiers changed from: package-private */
    public final void zza(zzbfn zzbfn, boolean z) {
        zzaqa zzaqa = new zzaqa(zzbfn, zzbfn.zzaau(), new zzaac(zzbfn.getContext()));
        this.zzelj = zzbfn;
        this.zzbpo = z;
        this.zzelt = zzaqa;
        this.zzdef = null;
        this.zzepa.zzg(zzbfn);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(int i, int i2, boolean z) {
        this.zzelt.zzj(i, i2);
        zzapt zzapt = this.zzdef;
        if (zzapt != null) {
            zzapt.zza(i, i2, false);
        }
    }

    public final void zza(String str, zzahc<? super zzbfn> zzahc) {
        this.zzepa.zza(str, zzahc);
    }

    public final void zzb(String str, zzahc<? super zzbfn> zzahc) {
        this.zzepa.zzb(str, zzahc);
    }

    public final void zza(String str, Predicate<zzahc<? super zzbfn>> predicate) {
        this.zzepa.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(zzuu zzuu, zzagi zzagi, zzo zzo, zzagk zzagk, zzt zzt, boolean z, zzahf zzahf, zzc zzc, zzaqc zzaqc, zzavr zzavr) {
        if (zzc == null) {
            zzc = new zzc(this.zzelj.getContext(), zzavr, null);
        }
        this.zzdef = new zzapt(this.zzelj, zzaqc);
        this.zzelu = zzavr;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcoa)).booleanValue()) {
            zza("/adMetadata", new zzagj(zzagi));
        }
        zza("/appEvent", new zzagl(zzagk));
        zza("/backButton", zzagm.zzddu);
        zza("/refresh", zzagm.zzddv);
        zza("/canOpenApp", zzagm.zzddl);
        zza("/canOpenURLs", zzagm.zzddk);
        zza("/canOpenIntents", zzagm.zzddm);
        zza("/click", zzagm.zzddn);
        zza("/close", zzagm.zzddo);
        zza("/customClose", zzagm.zzddp);
        zza("/instrument", zzagm.zzddy);
        zza("/delayPageLoaded", zzagm.zzdea);
        zza("/delayPageClosed", zzagm.zzdeb);
        zza("/getLocationInfo", zzagm.zzdec);
        zza("/httpTrack", zzagm.zzddq);
        zza("/log", zzagm.zzddr);
        zza("/mraid", new zzahh(zzc, this.zzdef, zzaqc));
        zza("/mraidLoaded", this.zzelt);
        zza("/open", new zzahg(zzc, this.zzdef));
        zza("/precache", new zzbex());
        zza("/touch", zzagm.zzddt);
        zza("/video", zzagm.zzddw);
        zza("/videoMeta", zzagm.zzddx);
        if (zzq.zzlu().zzac(this.zzelj.getContext())) {
            zza("/logScionEvent", new zzahe(this.zzelj.getContext()));
        }
        this.zzcgl = zzuu;
        this.zzdoe = zzo;
        this.zzddi = zzagi;
        this.zzddj = zzagk;
        this.zzdoi = zzt;
        this.zzdee = zzc;
        this.zzelp = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final zzc zzabr() {
        return this.zzdee;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final boolean zzabs() {
        return this.zzbpo;
    }

    public final boolean zzabt() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzelq;
        }
        return z;
    }

    public final boolean zzabu() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzelr;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzabv() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzabw() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzso zzabp = this.zzelj.zzabp();
        if (zzabp != null && webView == zzabp.getWebView()) {
            zzabp.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.google.android.gms.internal.ads.zzbhs
    public final void zza(zzbhr zzbhr) {
        this.zzelv = true;
        zzbhb zzbhb = this.zzeln;
        if (zzbhb != null) {
            zzbhb.zzta();
            this.zzeln = null;
        }
        zzacc();
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzavr zzavr, int i) {
        if (zzavr.zzvj() && i > 0) {
            zzavr.zzl(view);
            if (zzavr.zzvj()) {
                zzaye.zzdzw.postDelayed(new zzbhh(this, view, zzavr, i), 100);
            }
        }
    }

    private final void zzabx() {
        if (this.zzely != null) {
            this.zzelj.getView().removeOnAttachStateChangeListener(this.zzely);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaby() {
        zzavr zzavr = this.zzelu;
        if (zzavr != null) {
            WebView webView = this.zzelj.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzavr, 10);
                return;
            }
            zzabx();
            this.zzely = new zzbhk(this, zzavr);
            this.zzelj.getView().addOnAttachStateChangeListener(this.zzely);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzabz() {
        synchronized (this.lock) {
            this.zzels = true;
        }
        this.zzelx++;
        zzacc();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzaca() {
        this.zzelx--;
        zzacc();
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzacb() {
        this.zzelw = true;
        zzacc();
    }

    private final void zzacc() {
        if (this.zzelm != null && ((this.zzelv && this.zzelx <= 0) || this.zzelw)) {
            this.zzelm.zzak(!this.zzelw);
            this.zzelm = null;
        }
        this.zzelj.zzabj();
    }

    public final void zza(zzd zzd) {
        zzo zzo;
        boolean zzabe = this.zzelj.zzabe();
        zzuu zzuu = (!zzabe || this.zzelj.zzaax().zzacs()) ? this.zzcgl : null;
        if (zzabe) {
            zzo = null;
        } else {
            zzo = this.zzdoe;
        }
        zza(new AdOverlayInfoParcel(zzd, zzuu, zzo, this.zzdoi, this.zzelj.zzzo()));
    }

    public final void zzc(boolean z, int i) {
        zzuu zzuu = (!this.zzelj.zzabe() || this.zzelj.zzaax().zzacs()) ? this.zzcgl : null;
        zzo zzo = this.zzdoe;
        zzt zzt = this.zzdoi;
        zzbfn zzbfn = this.zzelj;
        zza(new AdOverlayInfoParcel(zzuu, zzo, zzt, zzbfn, z, i, zzbfn.zzzo()));
    }

    public final void zza(boolean z, int i, String str) {
        zzbhj zzbhj;
        boolean zzabe = this.zzelj.zzabe();
        zzuu zzuu = (!zzabe || this.zzelj.zzaax().zzacs()) ? this.zzcgl : null;
        if (zzabe) {
            zzbhj = null;
        } else {
            zzbhj = new zzbhj(this.zzelj, this.zzdoe);
        }
        zzagi zzagi = this.zzddi;
        zzagk zzagk = this.zzddj;
        zzt zzt = this.zzdoi;
        zzbfn zzbfn = this.zzelj;
        zza(new AdOverlayInfoParcel(zzuu, zzbhj, zzagi, zzagk, zzt, zzbfn, z, i, str, zzbfn.zzzo()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbhj zzbhj;
        boolean zzabe = this.zzelj.zzabe();
        zzuu zzuu = (!zzabe || this.zzelj.zzaax().zzacs()) ? this.zzcgl : null;
        if (zzabe) {
            zzbhj = null;
        } else {
            zzbhj = new zzbhj(this.zzelj, this.zzdoe);
        }
        zzagi zzagi = this.zzddi;
        zzagk zzagk = this.zzddj;
        zzt zzt = this.zzdoi;
        zzbfn zzbfn = this.zzelj;
        zza(new AdOverlayInfoParcel(zzuu, zzbhj, zzagi, zzagk, zzt, zzbfn, z, i, str, str2, zzbfn.zzzo()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzapt zzapt = this.zzdef;
        boolean zzuf = zzapt != null ? zzapt.zzuf() : false;
        zzq.zzkv();
        zzn.zza(this.zzelj.getContext(), adOverlayInfoParcel, !zzuf);
        if (this.zzelu != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdod != null) {
                str = adOverlayInfoParcel.zzdod.url;
            }
            this.zzelu.zzdz(str);
        }
    }

    public final void destroy() {
        zzavr zzavr = this.zzelu;
        if (zzavr != null) {
            zzavr.zzvl();
            this.zzelu = null;
        }
        zzabx();
        this.zzepa.reset();
        this.zzepa.zzg((zzbfn) null);
        synchronized (this.lock) {
            this.zzcgl = null;
            this.zzdoe = null;
            this.zzelm = null;
            this.zzeln = null;
            this.zzddi = null;
            this.zzddj = null;
            this.zzdoi = null;
            this.zzelo = null;
            if (this.zzdef != null) {
                this.zzdef.zzac(true);
                this.zzdef = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(zzbhc zzbhc) {
        this.zzelm = zzbhc;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(zzbhb zzbhb) {
        this.zzeln = zzbhb;
    }

    @Override // com.google.android.gms.internal.ads.zzbhs
    public final void zzb(zzbhr zzbhr) {
        this.zzepa.zzg(zzbhr.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbhs
    public final boolean zzc(zzbhr zzbhr) {
        String valueOf = String.valueOf(zzbhr.url);
        zzaxv.zzeh(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbhr.uri;
        if (this.zzepa.zzg(uri)) {
            return true;
        }
        if (this.zzelp) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzuu zzuu = this.zzcgl;
                if (zzuu != null) {
                    zzuu.onAdClicked();
                    zzavr zzavr = this.zzelu;
                    if (zzavr != null) {
                        zzavr.zzdz(zzbhr.url);
                    }
                    this.zzcgl = null;
                }
                return false;
            }
        }
        if (!this.zzelj.getWebView().willNotDraw()) {
            try {
                zzeg zzabc = this.zzelj.zzabc();
                if (zzabc != null && zzabc.zzb(uri)) {
                    uri = zzabc.zza(uri, this.zzelj.getContext(), this.zzelj.getView(), this.zzelj.zzzl());
                }
            } catch (zzef unused) {
                String valueOf2 = String.valueOf(zzbhr.url);
                zzaxv.zzfd(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            zzc zzc = this.zzdee;
            if (zzc == null || zzc.zzjy()) {
                zza(new zzd("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzdee.zzbn(zzbhr.url);
            }
        } else {
            String valueOf3 = String.valueOf(zzbhr.url);
            zzaxv.zzfd(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbhs
    public final WebResourceResponse zzd(zzbhr zzbhr) {
        WebResourceResponse webResourceResponse;
        zzsx zza;
        String str;
        zzavr zzavr = this.zzelu;
        if (zzavr != null) {
            zzavr.zza(zzbhr.url, zzbhr.zzam, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzbhr.url).getName())) {
            webResourceResponse = null;
        } else {
            zzum();
            if (this.zzelj.zzaax().zzacs()) {
                str = (String) zzwg.zzpw().zzd(zzaav.zzcmn);
            } else if (this.zzelj.zzabe()) {
                str = (String) zzwg.zzpw().zzd(zzaav.zzcmm);
            } else {
                str = (String) zzwg.zzpw().zzd(zzaav.zzcml);
            }
            zzq.zzkw();
            webResourceResponse = zzaye.zzd(this.zzelj.getContext(), this.zzelj.zzzo().zzbpn, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzawn.zzc(zzbhr.url, this.zzelj.getContext(), this.zzdsh).equals(zzbhr.url)) {
                return zze(zzbhr);
            }
            zzsy zzbv = zzsy.zzbv(zzbhr.url);
            if (zzbv != null && (zza = zzq.zzlc().zza(zzbv)) != null && zza.zzmv()) {
                return new WebResourceResponse("", "", zza.zzmw());
            }
            if (!zzbau.isEnabled() || !zzacg.zzczr.get().booleanValue()) {
                return null;
            }
            return zze(zzbhr);
        } catch (Exception | NoClassDefFoundError e) {
            zzq.zzla().zza(e, "AdWebViewClient.interceptRequest");
            return zzacd();
        }
    }

    private static WebResourceResponse zzacd() {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnp)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zze(zzbhr zzbhr) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbhr.url);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry<String, String> entry : zzbhr.zzam.entrySet()) {
                    openConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    zzq.zzkw().zza(this.zzelj.getContext(), this.zzelj.zzzo().zzbpn, false, httpURLConnection);
                    zzbau zzbau = new zzbau();
                    zzbau.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzbau.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        zzq.zzkw();
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            throw new IOException("Missing Location header in redirect");
                        } else if (headerField.startsWith("tel:")) {
                            return null;
                        } else {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzaxv.zzfd("Protocol is null");
                                return zzacd();
                            } else if (protocol.equals("http") || protocol.equals("https")) {
                                String valueOf = String.valueOf(headerField);
                                zzaxv.zzee(valueOf.length() != 0 ? "Redirecting to ".concat(valueOf) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String valueOf2 = String.valueOf(protocol);
                                zzaxv.zzfd(valueOf2.length() != 0 ? "Unsupported scheme: ".concat(valueOf2) : new String("Unsupported scheme: "));
                                return zzacd();
                            }
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        zzq.zzkw();
        return zzaye.zzd(httpURLConnection);
    }

    public final void zzav(boolean z) {
        this.zzelp = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final zzavr zzace() {
        return this.zzelu;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzum() {
        synchronized (this.lock) {
            this.zzelp = false;
            this.zzbpo = true;
            zzbbf.zzedl.execute(new zzbhi(this));
        }
    }

    public final void zzba(boolean z) {
        this.zzdsh = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzi(int i, int i2) {
        zzapt zzapt = this.zzdef;
        if (zzapt != null) {
            zzapt.zzi(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzbb(boolean z) {
        synchronized (this.lock) {
            this.zzelq = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzbc(boolean z) {
        synchronized (this.lock) {
            this.zzelr = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzh(Uri uri) {
        this.zzepa.zzh(uri);
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzelj.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
