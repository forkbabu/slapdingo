package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzto;
import com.google.android.gms.internal.ads.zzty;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbgd extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbfn {
    private int maxHeight = -1;
    private int maxWidth = -1;
    private String zzacv;
    private final zzbbd zzboy;
    private final WindowManager zzbqy;
    private int zzdmt = -1;
    private int zzdmu = -1;
    private boolean zzdog;
    private String zzdpt = "";
    private Boolean zzdxn;
    private zzabg zzehs;
    private final zztm zzelk;
    private final zzbhd zzemy;
    private final zzeg zzemz;
    private final zzi zzena;
    private final zza zzenb;
    private final float zzenc;
    private final zzso zzend;
    private final boolean zzene;
    private boolean zzenf = false;
    private boolean zzeng = false;
    private zzbfq zzenh;
    private zzc zzeni;
    private IObjectWrapper zzenj;
    private zzbhg zzenk;
    private boolean zzenl;
    private boolean zzenm;
    private boolean zzenn;
    private int zzeno;
    private boolean zzenp = true;
    private boolean zzenq = false;
    private zzbgh zzenr;
    private boolean zzens;
    private boolean zzent;
    private zzadh zzenu;
    private zzadc zzenv;
    private zzsa zzenw;
    private int zzenx;
    /* access modifiers changed from: private */
    public int zzeny;
    private zzabg zzenz;
    private zzabg zzeoa;
    private zzabj zzeob;
    private WeakReference<View.OnClickListener> zzeoc;
    private zzc zzeod;
    private boolean zzeoe;
    private zzban zzeof;
    private Map<String, zzbes> zzeog;
    private final DisplayMetrics zzxc;

    static zzbgd zzb(Context context, zzbhg zzbhg, String str, boolean z, boolean z2, zzeg zzeg, zzbbd zzbbd, zzabi zzabi, zzi zzi, zza zza, zztm zztm, zzso zzso, boolean z3) {
        return new zzbgd(new zzbhd(context), zzbhg, str, z, z2, zzeg, zzbbd, zzabi, zzi, zza, zztm, zzso, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbha
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzabo() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final zzbcu zzzi() {
        return null;
    }

    private zzbgd(zzbhd zzbhd, zzbhg zzbhg, String str, boolean z, boolean z2, zzeg zzeg, zzbbd zzbbd, zzabi zzabi, zzi zzi, zza zza, zztm zztm, zzso zzso, boolean z3) {
        super(zzbhd);
        this.zzemy = zzbhd;
        this.zzenk = zzbhg;
        this.zzacv = str;
        this.zzenm = z;
        this.zzeno = -1;
        this.zzemz = zzeg;
        this.zzboy = zzbbd;
        this.zzena = zzi;
        this.zzenb = zza;
        this.zzbqy = (WindowManager) getContext().getSystemService("window");
        zzq.zzkw();
        DisplayMetrics zza2 = zzaye.zza(this.zzbqy);
        this.zzxc = zza2;
        this.zzenc = zza2.density;
        this.zzelk = zztm;
        this.zzend = zzso;
        this.zzene = z3;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzaxv.zzc("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzq.zzkw().zza(zzbhd, zzbbd.zzbpn, settings);
        zzq.zzky().zza(getContext(), settings);
        setDownloadListener(this);
        zzaci();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbgm.zzc(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzeof = new zzban(this.zzemy.zzzl(), this, this, null);
        zzacm();
        zzabj zzabj = new zzabj(new zzabi(true, "make_wv", this.zzacv));
        this.zzeob = zzabj;
        zzabj.zzrp().zzc(zzabi);
        zzabg zzb = zzabd.zzb(this.zzeob.zzrp());
        this.zzehs = zzb;
        this.zzeob.zza("native:view_create", zzb);
        this.zzeoa = null;
        this.zzenz = null;
        zzq.zzky().zzbg(zzbhd);
        zzq.zzla().zzwb();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbfq) {
            this.zzenh = (zzbfq) webViewClient;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbdb
    public final zza zzzm() {
        return this.zzenb;
    }

    private final boolean zzacf() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzenh.zzabs() && !this.zzenh.zzabt()) {
            return false;
        }
        zzwg.zzps();
        DisplayMetrics displayMetrics = this.zzxc;
        int zzb = zzbaq.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwg.zzps();
        DisplayMetrics displayMetrics2 = this.zzxc;
        int zzb2 = zzbaq.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzzl = this.zzemy.zzzl();
        if (zzzl == null || zzzl.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzq.zzkw();
            int[] zzd = zzaye.zzd(zzzl);
            zzwg.zzps();
            int zzb3 = zzbaq.zzb(this.zzxc, zzd[0]);
            zzwg.zzps();
            i = zzbaq.zzb(this.zzxc, zzd[1]);
            i2 = zzb3;
        }
        if (this.zzdmt == zzb && this.zzdmu == zzb2 && this.maxWidth == i2 && this.maxHeight == i) {
            return false;
        }
        if (!(this.zzdmt == zzb && this.zzdmu == zzb2)) {
            z = true;
        }
        this.zzdmt = zzb;
        this.zzdmu = zzb2;
        this.maxWidth = i2;
        this.maxHeight = i;
        new zzaqd(this).zza(zzb, zzb2, i2, i, this.zzxc.density, this.zzbqy.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzajh
    public final void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzq.zzkw().zzj(map));
        } catch (JSONException unused) {
            zzaxv.zzfd("Could not convert parameters to JSON.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @Override // android.webkit.WebView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.ads.zzaxv.zzff(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0012
            r2 = 0
            r3.onReceiveValue(r2)     // Catch:{ all -> 0x0019 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            super.evaluateJavascript(r2, r3)
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgd.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    private final synchronized void zzfq(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzq.zzla().zza(e, "AdWebViewImpl.loadUrl");
                zzaxv.zzd("Could not call loadUrl. ", e);
            }
        } else {
            zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final synchronized void zzfr(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzq.zzla().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzaxv.zzd("Could not call loadUrl. ", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzb(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, zzbgw.zzf(str2, zzbgw.zzaco()), "text/html", XmpWriter.UTF8, str3);
            return;
        }
        zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
    }

    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final void zzfs(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzvz() == null) {
                zzacg();
            }
            if (zzvz().booleanValue()) {
                zza(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzfq(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzfq(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zzdb(String str) {
        zzfs(str);
    }

    private final synchronized void zzacg() {
        Boolean zzvz = zzq.zzla().zzvz();
        this.zzdxn = zzvz;
        if (zzvz == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zza((Boolean) true);
            } catch (IllegalStateException unused) {
                zza((Boolean) false);
            }
        }
    }

    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzdxn = bool;
        }
        zzq.zzla().zza(bool);
    }

    private final synchronized Boolean zzvz() {
        return this.zzdxn;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        zzfs(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzajh
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzaxv.zzee(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzfs(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzaas() {
        zzach();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzboy.zzbpn);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzds(int i) {
        if (i == 0) {
            zzabd.zza(this.zzeob.zzrp(), this.zzehs, "aebb2");
        }
        zzach();
        if (this.zzeob.zzrp() != null) {
            this.zzeob.zzrp().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzboy.zzbpn);
        zza("onhide", hashMap);
    }

    private final void zzach() {
        zzabd.zza(this.zzeob.zzrp(), this.zzehs, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzuq() {
        if (this.zzenz == null) {
            zzabd.zza(this.zzeob.zzrp(), this.zzehs, "aes2");
            zzabg zzb = zzabd.zzb(this.zzeob.zzrp());
            this.zzenz = zzb;
            this.zzeob.zza("native:view_show", zzb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzboy.zzbpn);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzaat() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzq.zzlb().zzqd()));
        hashMap.put("app_volume", String.valueOf(zzq.zzlb().zzqc()));
        hashMap.put("device_volume", String.valueOf(zzayw.zzbi(getContext())));
        zza("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized zzc zzaav() {
        return this.zzeni;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized IObjectWrapper zzabd() {
        return this.zzenj;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized zzc zzaaw() {
        return this.zzeod;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbgv
    public final synchronized zzbhg zzaax() {
        return this.zzenk;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized String zzaay() {
        return this.zzacv;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final WebViewClient zzaba() {
        return this.zzenh;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized boolean zzabb() {
        return this.zzdog;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbgy
    public final zzeg zzabc() {
        return this.zzemz;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbgx
    public final zzbbd zzzo() {
        return this.zzboy;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbgp
    public final synchronized boolean zzabe() {
        return this.zzenm;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzq.zzkw();
            zzaye.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzaxv.zzee(sb.toString());
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzenh.zzabt() || this.zzenh.zzabu()) {
            zzeg zzeg = this.zzemz;
            if (zzeg != null) {
                zzeg.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                if (this.zzenu != null) {
                    this.zzenu.zzc(motionEvent);
                }
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isDestroyed()     // Catch:{ all -> 0x01fe }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r0 = r7.isInEditMode()
            if (r0 != 0) goto L_0x01f9
            boolean r0 = r7.zzenm
            if (r0 != 0) goto L_0x01f9
            com.google.android.gms.internal.ads.zzbhg r0 = r7.zzenk
            boolean r0 = r0.zzact()
            if (r0 == 0) goto L_0x0021
            goto L_0x01f9
        L_0x0021:
            com.google.android.gms.internal.ads.zzbhg r0 = r7.zzenk
            boolean r0 = r0.zzacv()
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r8, r9)
            monitor-exit(r7)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbhg r0 = r7.zzenk
            boolean r0 = r0.zzacu()
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcro
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r8, r9)
            monitor-exit(r7)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbgh r0 = r7.zzzj()
            r1 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.getAspectRatio()
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            super.onMeasure(r8, r9)
            monitor-exit(r7)
            return
        L_0x0063:
            int r8 = android.view.View.MeasureSpec.getSize(r8)
            int r9 = android.view.View.MeasureSpec.getSize(r9)
            float r1 = (float) r9
            float r1 = r1 * r0
            int r1 = (int) r1
            float r2 = (float) r8
            float r2 = r2 / r0
            int r2 = (int) r2
            if (r9 != 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            float r9 = (float) r2
            float r9 = r9 * r0
            int r1 = (int) r9
            r9 = r2
            goto L_0x0084
        L_0x007c:
            if (r8 != 0) goto L_0x0084
            if (r1 == 0) goto L_0x0084
            float r8 = (float) r1
            float r8 = r8 / r0
            int r2 = (int) r8
            r8 = r1
        L_0x0084:
            int r8 = java.lang.Math.min(r1, r8)
            int r9 = java.lang.Math.min(r2, r9)
            r7.setMeasuredDimension(r8, r9)
            monitor-exit(r7)
            return
        L_0x0091:
            com.google.android.gms.internal.ads.zzbhg r0 = r7.zzenk
            boolean r0 = r0.isFluid()
            if (r0 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaav.zzcrr
            com.google.android.gms.internal.ads.zzaar r1 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00de
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()
            if (r0 != 0) goto L_0x00b2
            goto L_0x00de
        L_0x00b2:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.zzbgf r1 = new com.google.android.gms.internal.ads.zzbgf
            r1.<init>(r7)
            r7.zza(r0, r1)
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r7.zzfs(r0)
            android.util.DisplayMetrics r0 = r7.zzxc
            float r0 = r0.density
            int r8 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r7.zzeny
            r2 = -1
            if (r1 == r2) goto L_0x00d5
            int r9 = r7.zzeny
            float r9 = (float) r9
            float r9 = r9 * r0
            int r9 = (int) r9
            goto L_0x00d9
        L_0x00d5:
            int r9 = android.view.View.MeasureSpec.getSize(r9)
        L_0x00d9:
            r7.setMeasuredDimension(r8, r9)
            monitor-exit(r7)
            return
        L_0x00de:
            super.onMeasure(r8, r9)
            monitor-exit(r7)
            return
        L_0x00e3:
            com.google.android.gms.internal.ads.zzbhg r0 = r7.zzenk
            boolean r0 = r0.zzacs()
            if (r0 == 0) goto L_0x00f8
            android.util.DisplayMetrics r8 = r7.zzxc
            int r8 = r8.widthPixels
            android.util.DisplayMetrics r9 = r7.zzxc
            int r9 = r9.heightPixels
            r7.setMeasuredDimension(r8, r9)
            monitor-exit(r7)
            return
        L_0x00f8:
            int r0 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.getSize(r8)
            int r2 = android.view.View.MeasureSpec.getMode(r9)
            int r9 = android.view.View.MeasureSpec.getSize(r9)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r4) goto L_0x0118
            if (r0 != r3) goto L_0x0114
            goto L_0x0118
        L_0x0114:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0119
        L_0x0118:
            r0 = r8
        L_0x0119:
            if (r2 == r4) goto L_0x011d
            if (r2 != r3) goto L_0x011e
        L_0x011d:
            r5 = r9
        L_0x011e:
            com.google.android.gms.internal.ads.zzbhg r2 = r7.zzenk
            int r2 = r2.widthPixels
            r3 = 1
            if (r2 > r0) goto L_0x012e
            com.google.android.gms.internal.ads.zzbhg r2 = r7.zzenk
            int r2 = r2.heightPixels
            if (r2 <= r5) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r2 = 0
            goto L_0x012f
        L_0x012e:
            r2 = 1
        L_0x012f:
            com.google.android.gms.internal.ads.zzaag<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzaav.zzctz
            com.google.android.gms.internal.ads.zzaar r6 = com.google.android.gms.internal.ads.zzwg.zzpw()
            java.lang.Object r4 = r6.zzd(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0167
            com.google.android.gms.internal.ads.zzbhg r4 = r7.zzenk
            int r4 = r4.widthPixels
            float r4 = (float) r4
            float r6 = r7.zzenc
            float r4 = r4 / r6
            float r0 = (float) r0
            float r6 = r7.zzenc
            float r0 = r0 / r6
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzbhg r0 = r7.zzenk
            int r0 = r0.heightPixels
            float r0 = (float) r0
            float r4 = r7.zzenc
            float r0 = r0 / r4
            float r4 = (float) r5
            float r5 = r7.zzenc
            float r4 = r4 / r5
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0163
            r0 = 1
            goto L_0x0164
        L_0x0163:
            r0 = 0
        L_0x0164:
            if (r2 == 0) goto L_0x0167
            r2 = r0
        L_0x0167:
            r0 = 8
            if (r2 == 0) goto L_0x01d6
            com.google.android.gms.internal.ads.zzbhg r2 = r7.zzenk
            int r2 = r2.widthPixels
            float r2 = (float) r2
            float r4 = r7.zzenc
            float r2 = r2 / r4
            int r2 = (int) r2
            com.google.android.gms.internal.ads.zzbhg r4 = r7.zzenk
            int r4 = r4.heightPixels
            float r4 = (float) r4
            float r5 = r7.zzenc
            float r4 = r4 / r5
            int r4 = (int) r4
            float r8 = (float) r8
            float r5 = r7.zzenc
            float r8 = r8 / r5
            int r8 = (int) r8
            float r9 = (float) r9
            float r5 = r7.zzenc
            float r9 = r9 / r5
            int r9 = (int) r9
            r5 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Not enough space to show ad. Needs "
            r6.append(r5)
            r6.append(r2)
            java.lang.String r2 = "x"
            r6.append(r2)
            r6.append(r4)
            java.lang.String r2 = " dp, but only has "
            r6.append(r2)
            r6.append(r8)
            java.lang.String r8 = "x"
            r6.append(r8)
            r6.append(r9)
            java.lang.String r8 = " dp."
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            com.google.android.gms.internal.ads.zzaxv.zzfd(r8)
            int r8 = r7.getVisibility()
            if (r8 == r0) goto L_0x01c4
            r8 = 4
            r7.setVisibility(r8)
        L_0x01c4:
            r7.setMeasuredDimension(r1, r1)
            boolean r8 = r7.zzenf
            if (r8 != 0) goto L_0x01f7
            com.google.android.gms.internal.ads.zztm r8 = r7.zzelk
            com.google.android.gms.internal.ads.zzto$zza$zza r9 = com.google.android.gms.internal.ads.zzto.zza.C0017zza.BANNER_SIZE_INVALID
            r8.zza(r9)
            r7.zzenf = r3
            monitor-exit(r7)
            return
        L_0x01d6:
            int r8 = r7.getVisibility()
            if (r8 == r0) goto L_0x01df
            r7.setVisibility(r1)
        L_0x01df:
            boolean r8 = r7.zzeng
            if (r8 != 0) goto L_0x01ec
            com.google.android.gms.internal.ads.zztm r8 = r7.zzelk
            com.google.android.gms.internal.ads.zzto$zza$zza r9 = com.google.android.gms.internal.ads.zzto.zza.C0017zza.BANNER_SIZE_VALID
            r8.zza(r9)
            r7.zzeng = r3
        L_0x01ec:
            com.google.android.gms.internal.ads.zzbhg r8 = r7.zzenk
            int r8 = r8.widthPixels
            com.google.android.gms.internal.ads.zzbhg r9 = r7.zzenk
            int r9 = r9.heightPixels
            r7.setMeasuredDimension(r8, r9)
        L_0x01f7:
            monitor-exit(r7)
            return
        L_0x01f9:
            super.onMeasure(r8, r9)
            monitor-exit(r7)
            return
        L_0x01fe:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgd.onMeasure(int, int):void");
    }

    public final void onGlobalLayout() {
        boolean zzacf = zzacf();
        zzc zzaav = zzaav();
        if (zzaav != null && zzacf) {
            zzaav.zzup();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zza(zzc zzc) {
        this.zzeni = zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzap(IObjectWrapper iObjectWrapper) {
        this.zzenj = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzb(zzc zzc) {
        this.zzeod = zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zza(zzbhg zzbhg) {
        this.zzenk = zzbhg;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzax(boolean z) {
        boolean z2 = z != this.zzenm;
        this.zzenm = z;
        zzaci();
        if (z2) {
            if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcmp)).booleanValue() || !this.zzenk.zzacs()) {
                new zzaqd(this).zzdy(z ? "expanded" : "default");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabi() {
        this.zzeof.zzyd();
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzeof.onAttachedToWindow();
        }
        boolean z = this.zzens;
        if (this.zzenh != null && this.zzenh.zzabt()) {
            if (!this.zzent) {
                this.zzenh.zzabv();
                this.zzenh.zzabw();
                this.zzent = true;
            }
            zzacf();
            z = true;
        }
        zzbd(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzeof.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzent && this.zzenh != null && this.zzenh.zzabt() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzenh.zzabv();
                this.zzenh.zzabw();
                this.zzent = false;
            }
        }
        zzbd(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzbw(Context context) {
        this.zzemy.setBaseContext(context);
        this.zzeof.zzh(this.zzemy.zzzl());
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzal(boolean z) {
        if (this.zzeni != null) {
            this.zzeni.zza(this.zzenh.zzabs(), z);
        } else {
            this.zzdog = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void setRequestedOrientation(int i) {
        this.zzeno = i;
        if (this.zzeni != null) {
            this.zzeni.setRequestedOrientation(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbgq
    public final Activity zzzl() {
        return this.zzemy.zzzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final Context zzaau() {
        return this.zzemy.zzaau();
    }

    private final synchronized void zzaci() {
        if (!this.zzenm) {
            if (!this.zzenk.zzacs()) {
                if (Build.VERSION.SDK_INT < 18) {
                    zzaxv.zzee("Disabling hardware acceleration on an AdView.");
                    zzacj();
                    return;
                }
                zzaxv.zzee("Enabling hardware acceleration on an AdView.");
                zzack();
                return;
            }
        }
        zzaxv.zzee("Enabling hardware acceleration on an overlay.");
        zzack();
    }

    private final synchronized void zzacj() {
        if (!this.zzenn) {
            zzq.zzky();
            setLayerType(1, null);
        }
        this.zzenn = true;
    }

    private final synchronized void zzack() {
        if (this.zzenn) {
            zzq.zzky();
            setLayerType(0, null);
        }
        this.zzenn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void destroy() {
        zzacm();
        this.zzeof.zzye();
        if (this.zzeni != null) {
            this.zzeni.close();
            this.zzeni.onDestroy();
            this.zzeni = null;
        }
        this.zzenj = null;
        this.zzenh.reset();
        if (!this.zzenl) {
            zzq.zzls();
            zzbep.zzc(this);
            zzacl();
            this.zzenl = true;
            zzaxv.zzeh("Initiating WebView self destruct sequence in 3...");
            zzaxv.zzeh("Loading blank page in WebView, 2...");
            zzfr("about:blank");
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzenl) {
                    this.zzenh.reset();
                    zzq.zzls();
                    zzbep.zzc(this);
                    zzacl();
                    zzwc();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzabf() {
        zzaxv.zzeh("Destroying WebView!");
        zzwc();
        zzaye.zzdzw.post(new zzbgi(this));
    }

    private final synchronized void zzwc() {
        if (!this.zzeoe) {
            this.zzeoe = true;
            zzq.zzla().zzwc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized boolean isDestroyed() {
        return this.zzenl;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                zzbfq zzbfq = this.zzenh;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabj() {
        if (this.zzeoa == null) {
            zzabg zzb = zzabd.zzb(this.zzeob.zzrp());
            this.zzeoa = zzb;
            this.zzeob.zza("native:view_load", zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzaxv.zzc("Could not pause webview.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzaxv.zzc("Could not resume webview.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabm() {
        zzaxv.zzeh("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzba(boolean z) {
        this.zzenh.zzba(z);
    }

    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzaxv.zzc("Could not stop loading webview.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzay(boolean z) {
        this.zzenp = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized boolean zzabg() {
        return this.zzenp;
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final synchronized void zzkd() {
        this.zzenq = true;
        if (this.zzena != null) {
            this.zzena.zzkd();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final synchronized void zzke() {
        this.zzenq = false;
        if (this.zzena != null) {
            this.zzena.zzke();
        }
    }

    private final synchronized void zzacl() {
        if (this.zzeog != null) {
            for (zzbes zzbes : this.zzeog.values()) {
                zzbes.release();
            }
        }
        this.zzeog = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbdb
    public final synchronized void zza(String str, zzbes zzbes) {
        if (this.zzeog == null) {
            this.zzeog = new HashMap();
        }
        this.zzeog.put(str, zzbes);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final synchronized zzbes zzfi(String str) {
        if (this.zzeog == null) {
            return null;
        }
        return this.zzeog.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final synchronized String getRequestId() {
        return this.zzdpt;
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final synchronized void zzzr() {
        if (this.zzenv != null) {
            this.zzenv.zzrx();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zza(zzadc zzadc) {
        this.zzenv = zzadc;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zza(zzsa zzsa) {
        this.zzenw = zzsa;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized zzsa zzabn() {
        return this.zzenw;
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final zzabg zzzk() {
        return this.zzehs;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbdb
    public final zzabj zzzn() {
        return this.zzeob;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzeoc = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zza(zzadh zzadh) {
        this.zzenu = zzadh;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized zzadh zzabk() {
        return this.zzenu;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbdb
    public final synchronized zzbgh zzzj() {
        return this.zzenr;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbdb
    public final synchronized void zza(zzbgh zzbgh) {
        if (this.zzenr != null) {
            zzaxv.zzfb("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzenr = zzbgh;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized boolean zzabh() {
        return this.zzenx > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzaz(boolean z) {
        int i = this.zzenx + (z ? 1 : -1);
        this.zzenx = i;
        if (i <= 0 && this.zzeni != null) {
            this.zzeni.zzus();
        }
    }

    private final void zzacm() {
        zzabi zzrp;
        zzabj zzabj = this.zzeob;
        if (zzabj != null && (zzrp = zzabj.zzrp()) != null && zzq.zzla().zzvy() != null) {
            zzq.zzla().zzvy().zza(zzrp);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabl() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final void zzav(boolean z) {
        this.zzenh.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final void zzur() {
        zzc zzaav = zzaav();
        if (zzaav != null) {
            zzaav.zzur();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final int zzzp() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final int zzzq() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zza(zzd zzd) {
        this.zzenh.zza(zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzc(boolean z, int i) {
        this.zzenh.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zza(boolean z, int i, String str) {
        this.zzenh.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzenh.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzqs
    public final void zza(zzqt zzqt) {
        synchronized (this) {
            this.zzens = zzqt.zzbrd;
        }
        zzbd(zzqt.zzbrd);
    }

    private final void zzbd(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(String str, zzahc<? super zzbfn> zzahc) {
        zzbfq zzbfq = this.zzenh;
        if (zzbfq != null) {
            zzbfq.zza(str, zzahc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzb(String str, zzahc<? super zzbfn> zzahc) {
        zzbfq zzbfq = this.zzenh;
        if (zzbfq != null) {
            zzbfq.zzb(str, zzahc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(String str, Predicate<zzahc<? super zzbfn>> predicate) {
        zzbfq zzbfq = this.zzenh;
        if (zzbfq != null) {
            zzbfq.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzb(boolean z, int i) {
        destroy();
        this.zzelk.zza(new zzbgg(z, i));
        this.zzelk.zza(zzto.zza.C0017zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!zzabq()) {
            zzaxv.zzeh("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        zzaxv.zzeh("Initializing ArWebView object.");
        this.zzend.zza(activity, this);
        this.zzend.zzc(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.zzend.getView());
        } else {
            zzaxv.zzfb("The FrameLayout object cannot be null.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final zzso zzabp() {
        return this.zzend;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzabq() {
        return ((Boolean) zzwg.zzpw().zzd(zzaav.zzcvu)).booleanValue() && this.zzend != null && this.zzene;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final /* synthetic */ zzbgz zzaaz() {
        return this.zzenh;
    }

    static final /* synthetic */ void zza(boolean z, int i, zzty.zzi.zza zza) {
        zzty.zzae.zza zzpe = zzty.zzae.zzpe();
        if (zzpe.zzpd() != z) {
            zzpe.zzw(z);
        }
        zza.zzb((zzty.zzae) ((zzegb) zzpe.zzcw(i).zzbfq()));
    }
}
