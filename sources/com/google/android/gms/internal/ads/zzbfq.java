package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbfq extends WebViewClient implements zzbgz {
    private final Object lock;
    private boolean zzbpo;
    private zzuu zzcgl;
    private zzagi zzddi;
    private zzagk zzddj;
    private zzc zzdee;
    private zzapt zzdef;
    private zzo zzdoe;
    private zzt zzdoi;
    private boolean zzdsh;
    protected zzbfn zzelj;
    private final zztm zzelk;
    private final HashMap<String, List<zzahc<? super zzbfn>>> zzell;
    private zzbhc zzelm;
    private zzbhb zzeln;
    private zzbhe zzelo;
    private boolean zzelp;
    private boolean zzelq;
    private boolean zzelr;
    private boolean zzels;
    private final zzaqa zzelt;
    protected zzavr zzelu;
    private boolean zzelv;
    private boolean zzelw;
    private int zzelx;
    private View.OnAttachStateChangeListener zzely;

    public zzbfq(zzbfn zzbfn, zztm zztm, boolean z) {
        this(zzbfn, zztm, z, new zzaqa(zzbfn, zzbfn.zzaau(), new zzaac(zzbfn.getContext())), null);
    }

    private zzbfq(zzbfn zzbfn, zztm zztm, boolean z, zzaqa zzaqa, zzapt zzapt) {
        this.zzell = new HashMap<>();
        this.lock = new Object();
        this.zzelp = false;
        this.zzelk = zztm;
        this.zzelj = zzbfn;
        this.zzbpo = z;
        this.zzelt = zzaqa;
        this.zzdef = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zza(int i, int i2, boolean z) {
        this.zzelt.zzj(i, i2);
        zzapt zzapt = this.zzdef;
        if (zzapt != null) {
            zzapt.zza(i, i2, false);
        }
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
        boolean z;
        synchronized (this.lock) {
            z = this.zzbpo;
        }
        return z;
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

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzso zzabp = this.zzelj.zzabp();
        if (zzabp != null && webView == zzabp.getWebView()) {
            zzabp.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zzta();
        r0.zzeln = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzacc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzelv = true;
        r1 = r0.zzeln;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbfn r2 = r0.zzelj     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.internal.ads.zzaxv.zzeh(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzbfn r2 = r0.zzelj     // Catch:{ all -> 0x0029 }
            r2.zzabf()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzelv = r1
            com.google.android.gms.internal.ads.zzbhb r1 = r0.zzeln
            if (r1 == 0) goto L_0x0025
            r1.zzta()
            r1 = 0
            r0.zzeln = r1
        L_0x0025:
            r0.zzacc()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfq.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzavr zzavr, int i) {
        if (zzavr.zzvj() && i > 0) {
            zzavr.zzl(view);
            if (zzavr.zzvj()) {
                zzaye.zzdzw.postDelayed(new zzbfr(this, view, zzavr, i), 100);
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
            this.zzely = new zzbfu(this, zzavr);
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
        zztm zztm = this.zzelk;
        if (zztm != null) {
            zztm.zza(zzto.zza.C0017zza.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzelw = true;
        zzacc();
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcuo)).booleanValue()) {
            this.zzelj.destroy();
        }
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
        zzbfw zzbfw;
        boolean zzabe = this.zzelj.zzabe();
        zzuu zzuu = (!zzabe || this.zzelj.zzaax().zzacs()) ? this.zzcgl : null;
        if (zzabe) {
            zzbfw = null;
        } else {
            zzbfw = new zzbfw(this.zzelj, this.zzdoe);
        }
        zzagi zzagi = this.zzddi;
        zzagk zzagk = this.zzddj;
        zzt zzt = this.zzdoi;
        zzbfn zzbfn = this.zzelj;
        zza(new AdOverlayInfoParcel(zzuu, zzbfw, zzagi, zzagk, zzt, zzbfn, z, i, str, zzbfn.zzzo()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbfw zzbfw;
        boolean zzabe = this.zzelj.zzabe();
        zzuu zzuu = (!zzabe || this.zzelj.zzaax().zzacs()) ? this.zzcgl : null;
        if (zzabe) {
            zzbfw = null;
        } else {
            zzbfw = new zzbfw(this.zzelj, this.zzdoe);
        }
        zzagi zzagi = this.zzddi;
        zzagk zzagk = this.zzddj;
        zzt zzt = this.zzdoi;
        zzbfn zzbfn = this.zzelj;
        zza(new AdOverlayInfoParcel(zzuu, zzbfw, zzagi, zzagk, zzt, zzbfn, z, i, str, str2, zzbfn.zzzo()));
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

    public final void zza(String str, zzahc<? super zzbfn> zzahc) {
        synchronized (this.lock) {
            List<zzahc<? super zzbfn>> list = this.zzell.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzell.put(str, list);
            }
            list.add(zzahc);
        }
    }

    public final void zzb(String str, zzahc<? super zzbfn> zzahc) {
        synchronized (this.lock) {
            List<zzahc<? super zzbfn>> list = this.zzell.get(str);
            if (list != null) {
                list.remove(zzahc);
            }
        }
    }

    public final void zza(String str, Predicate<zzahc<? super zzbfn>> predicate) {
        synchronized (this.lock) {
            List<zzahc<? super zzbfn>> list = this.zzell.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzahc<? super zzbfn> zzahc : list) {
                    if (predicate.apply(zzahc)) {
                        arrayList.add(zzahc);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void reset() {
        zzavr zzavr = this.zzelu;
        if (zzavr != null) {
            zzavr.zzvl();
            this.zzelu = null;
        }
        zzabx();
        synchronized (this.lock) {
            this.zzell.clear();
            this.zzcgl = null;
            this.zzdoe = null;
            this.zzelm = null;
            this.zzeln = null;
            this.zzddi = null;
            this.zzddj = null;
            this.zzelp = false;
            this.zzbpo = false;
            this.zzelq = false;
            this.zzels = false;
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

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzaxv.zzeh(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzaxv.zzeh(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzelp && webView == this.zzelj.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzuu zzuu = this.zzcgl;
                    if (zzuu != null) {
                        zzuu.onAdClicked();
                        zzavr zzavr = this.zzelu;
                        if (zzavr != null) {
                            zzavr.zzdz(str);
                        }
                        this.zzcgl = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzelj.getWebView().willNotDraw()) {
                try {
                    zzeg zzabc = this.zzelj.zzabc();
                    if (zzabc != null && zzabc.zzb(parse)) {
                        parse = zzabc.zza(parse, this.zzelj.getContext(), this.zzelj.getView(), this.zzelj.zzzl());
                    }
                } catch (zzef unused) {
                    String valueOf2 = String.valueOf(str);
                    zzaxv.zzfd(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                zzc zzc = this.zzdee;
                if (zzc == null || zzc.zzjy()) {
                    zza(new zzd("android.intent.action.VIEW", parse.toString(), null, null, null, null, null));
                } else {
                    this.zzdee.zzbn(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzaxv.zzfd(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        } else {
            zzh(parse);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzd(String str, Map<String, String> map) {
        zzsx zza;
        try {
            String zzc = zzawn.zzc(str, this.zzelj.getContext(), this.zzdsh);
            if (!zzc.equals(str)) {
                return zze(zzc, map);
            }
            zzsy zzbv = zzsy.zzbv(str);
            if (zzbv != null && (zza = zzq.zzlc().zza(zzbv)) != null && zza.zzmv()) {
                return new WebResourceResponse("", "", zza.zzmw());
            }
            if (!zzbau.isEnabled() || !zzacg.zzczr.get().booleanValue()) {
                return null;
            }
            return zze(str, map);
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

    private final WebResourceResponse zze(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry<String, String> entry : map.entrySet()) {
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
            zzbbf.zzedl.execute(new zzbfp(this));
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

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgz
    public final void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzahc<? super zzbfn>> list = this.zzell.get(path);
        if (list != null) {
            if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcuk)).booleanValue()) {
                zzq.zzkw();
                zza(zzaye.zzj(uri), list, path);
                return;
            }
            zzdux.zza(zzq.zzkw().zzi(uri), new zzbft(this, list, path), zzbbf.zzedm);
            return;
        }
        String valueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(valueOf);
        zzaxv.zzeh(sb.toString());
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcwp)).booleanValue() && zzq.zzla().zzvy() != null) {
            zzbbf.zzedh.execute(new zzbfs(path));
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Map<String, String> map, List<zzahc<? super zzbfn>> list, String str) {
        if (zzaxv.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzaxv.zzeh(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzaxv.zzeh(sb.toString());
            }
        }
        for (zzahc<? super zzbfn> zzahc : list) {
            zzahc.zza(this.zzelj, map);
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

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzelj.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
