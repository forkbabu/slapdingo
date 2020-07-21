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
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbho extends zzbhu implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzajp, zzbfn {
    private int maxHeight = -1;
    private int maxWidth = -1;
    private String zzacv;
    private final zzbbd zzboy;
    private final WindowManager zzbqy;
    private int zzdmt = -1;
    private int zzdmu = -1;
    private boolean zzdog;
    private String zzdpt = "";
    private zzabg zzehs;
    private final zztm zzelk;
    private final zzbhd zzemy;
    private final zzeg zzemz;
    private final zzi zzena;
    private final zza zzenb;
    private final zzso zzend;
    private final boolean zzene;
    private zzc zzeni;
    private zzbhg zzenk;
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
    private zzban zzeof;
    private Map<String, zzbes> zzeog;
    private final zzbhf zzepd;
    private final AtomicReference<IObjectWrapper> zzepe = new AtomicReference<>();
    private final DisplayMetrics zzxc;

    protected zzbho(zzbhd zzbhd, zzbhf zzbhf, zzbhg zzbhg, String str, boolean z, boolean z2, zzeg zzeg, zzbbd zzbbd, zzabi zzabi, zzi zzi, zza zza, zztm zztm, zzso zzso, boolean z3) {
        super(zzbhd, zzbhf);
        this.zzemy = zzbhd;
        this.zzepd = zzbhf;
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
        this.zzxc = zzaye.zza(this.zzbqy);
        this.zzelk = zztm;
        this.zzend = zzso;
        this.zzene = z3;
        this.zzeof = new zzban(this.zzemy.zzzl(), this, this, null);
        zzq.zzkw().zza(zzbhd, zzbbd.zzbpn, getSettings());
        setDownloadListener(this);
        zzaci();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbgm.zzc(this), "googleAdsJsInterface");
        }
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
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbha
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzajh
    public final void zza(String str, Map map) {
        zzajo.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zza(String str, JSONObject jSONObject) {
        zzajo.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbhu, com.google.android.gms.internal.ads.zzbfn
    public final void zzabf() {
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzabo() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzajp, com.google.android.gms.internal.ads.zzajh
    public final void zzb(String str, JSONObject jSONObject) {
        zzajo.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajp
    public final void zzj(String str, String str2) {
        zzajo.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final zzbcu zzzi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbdb
    public final zza zzzm() {
        return this.zzenb;
    }

    private final boolean zzacf() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzepd.zzabs() && !this.zzepd.zzabt()) {
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

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized void zzb(String str, String str2, String str3) {
        super.loadDataWithBaseURL(str, zzbgw.zzf(str2, zzbgw.zzaco()), "text/html", XmpWriter.UTF8, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzake, com.google.android.gms.internal.ads.zzbhu, com.google.android.gms.internal.ads.zzbhp, com.google.android.gms.internal.ads.zzajp
    public final synchronized void zzdb(String str) {
        if (!isDestroyed()) {
            super.zzdb(str);
        } else {
            zzaxv.zzfd("The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzaas() {
        zzach();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzboy.zzbpn);
        zzajo.zza(this, "onhide", hashMap);
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
        zzajo.zza(this, "onhide", hashMap);
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
        zzajo.zza(this, "onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzaat() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzq.zzlb().zzqd()));
        hashMap.put("app_volume", String.valueOf(zzq.zzlb().zzqc()));
        hashMap.put("device_volume", String.valueOf(zzayw.zzbi(getContext())));
        zzajo.zza(this, "volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zzajo.zza(this, "onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final synchronized zzc zzaav() {
        return this.zzeni;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final IObjectWrapper zzabd() {
        return this.zzepe.get();
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
        return this.zzepd;
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

    @Override // com.google.android.gms.internal.ads.zzbhu
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzepd.zzabt() || this.zzepd.zzabu()) {
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
    public final synchronized void onMeasure(int i, int i2) {
        int i3;
        if (isDestroyed()) {
            setMeasuredDimension(0, 0);
        } else if (isInEditMode() || this.zzenm || this.zzenk.zzact()) {
            super.onMeasure(i, i2);
        } else if (this.zzenk.zzacv()) {
            super.onMeasure(i, i2);
        } else if (this.zzenk.zzacu()) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcro)).booleanValue()) {
                super.onMeasure(i, i2);
                return;
            }
            zzbgh zzzj = zzzj();
            float aspectRatio = zzzj != null ? zzzj.getAspectRatio() : 0.0f;
            if (aspectRatio == 0.0f) {
                super.onMeasure(i, i2);
                return;
            }
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i4 = (int) (((float) size2) * aspectRatio);
            int i5 = (int) (((float) size) / aspectRatio);
            if (size2 == 0 && i5 != 0) {
                i4 = (int) (((float) i5) * aspectRatio);
                size2 = i5;
            } else if (size == 0 && i4 != 0) {
                i5 = (int) (((float) i4) / aspectRatio);
                size = i4;
            }
            setMeasuredDimension(Math.min(i4, size), Math.min(i5, size2));
        } else if (this.zzenk.isFluid()) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcrr)).booleanValue() || !PlatformVersion.isAtLeastJellyBeanMR1()) {
                super.onMeasure(i, i2);
                return;
            }
            zza("/contentHeight", new zzbhq(this));
            zzdb("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
            int size3 = View.MeasureSpec.getSize(i);
            if (this.zzeny != -1) {
                i3 = (int) (((float) this.zzeny) * this.zzxc.density);
            } else {
                i3 = View.MeasureSpec.getSize(i2);
            }
            setMeasuredDimension(size3, i3);
        } else if (this.zzenk.zzacs()) {
            setMeasuredDimension(this.zzxc.widthPixels, this.zzxc.heightPixels);
        } else {
            int mode = View.MeasureSpec.getMode(i);
            int size4 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size5 = View.MeasureSpec.getSize(i2);
            int i6 = Integer.MAX_VALUE;
            int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : Integer.MAX_VALUE;
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i6 = size5;
            }
            boolean z = true;
            boolean z2 = this.zzenk.widthPixels > i7 || this.zzenk.heightPixels > i6;
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzctz)).booleanValue()) {
                if (((float) this.zzenk.widthPixels) / this.zzxc.density > ((float) i7) / this.zzxc.density || ((float) this.zzenk.heightPixels) / this.zzxc.density > ((float) i6) / this.zzxc.density) {
                    z = false;
                }
                if (z2) {
                    z2 = z;
                }
            }
            if (z2) {
                StringBuilder sb = new StringBuilder(103);
                sb.append("Not enough space to show ad. Needs ");
                sb.append((int) (((float) this.zzenk.widthPixels) / this.zzxc.density));
                sb.append("x");
                sb.append((int) (((float) this.zzenk.heightPixels) / this.zzxc.density));
                sb.append(" dp, but only has ");
                sb.append((int) (((float) size4) / this.zzxc.density));
                sb.append("x");
                sb.append((int) (((float) size5) / this.zzxc.density));
                sb.append(" dp.");
                zzaxv.zzfd(sb.toString());
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
                return;
            }
            if (getVisibility() != 8) {
                setVisibility(0);
            }
            setMeasuredDimension(this.zzenk.widthPixels, this.zzenk.heightPixels);
        }
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
    public final void zzap(IObjectWrapper iObjectWrapper) {
        this.zzepe.set(iObjectWrapper);
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
        if (this.zzepd != null && this.zzepd.zzabt()) {
            if (!this.zzent) {
                this.zzepd.zzabv();
                this.zzepd.zzabw();
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
            if (this.zzent && this.zzepd != null && this.zzepd.zzabt() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzepd.zzabv();
                this.zzepd.zzabw();
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
            this.zzeni.zza(this.zzepd.zzabs(), z);
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

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbhu
    public final synchronized void zzbe(boolean z) {
        if (!z) {
            zzacm();
            this.zzeof.zzye();
            if (this.zzeni != null) {
                this.zzeni.close();
                this.zzeni.onDestroy();
                this.zzeni = null;
            }
        }
        this.zzepe.set(null);
        this.zzepd.destroy();
        zzq.zzls();
        zzbep.zzc(this);
        zzacl();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbhu
    public final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
            zzbhf zzbhf = this.zzepd;
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

    @Override // com.google.android.gms.internal.ads.zzbhu, com.google.android.gms.internal.ads.zzbfn
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzaxv.zzc("Could not pause webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhu, com.google.android.gms.internal.ads.zzbfn
    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            zzaxv.zzc("Could not resume webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabm() {
        zzaxv.zzeh("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzba(boolean z) {
        this.zzepd.zzba(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbhu
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzaxv.zzc("Could not stop loading webview.", e);
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
        this.zzepd.zzav(z);
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
        this.zzepd.zza(zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzc(boolean z, int i) {
        this.zzepd.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zza(boolean z, int i, String str) {
        this.zzepd.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzepd.zza(z, i, str, str2);
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
        zzajo.zza(this, "onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(String str, zzahc<? super zzbfn> zzahc) {
        zzbhf zzbhf = this.zzepd;
        if (zzbhf != null) {
            zzbhf.zza(str, zzahc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzb(String str, zzahc<? super zzbfn> zzahc) {
        zzbhf zzbhf = this.zzepd;
        if (zzbhf != null) {
            zzbhf.zzb(str, zzahc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(String str, Predicate<zzahc<? super zzbfn>> predicate) {
        zzbhf zzbhf = this.zzepd;
        if (zzbhf != null) {
            zzbhf.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzb(boolean z, int i) {
        destroy();
        this.zzelk.zza(new zzbhn(z, i));
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
        return this.zzepd;
    }

    static final /* synthetic */ void zza(boolean z, int i, zzty.zzi.zza zza) {
        zzty.zzae.zza zzpe = zzty.zzae.zzpe();
        if (zzpe.zzpd() != z) {
            zzpe.zzw(z);
        }
        zza.zzb((zzty.zzae) ((zzegb) zzpe.zzcw(i).zzbfq()));
    }
}
