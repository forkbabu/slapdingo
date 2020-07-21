package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzq;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbhu extends zzbhp implements zzbhv {
    private boolean zzenl;
    private boolean zzeoe;
    private final zzbhs zzepk;

    public zzbhu(Context context, zzbhs zzbhs) {
        super(context);
        zzq.zzla().zzwb();
        this.zzepk = zzbhs;
        super.setWebViewClient(zzbhs);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
    }

    /* access modifiers changed from: protected */
    public void zzbe(boolean z) {
    }

    public final synchronized boolean isDestroyed() {
        return this.zzenl;
    }

    public synchronized void destroy() {
        if (!this.zzenl) {
            this.zzenl = true;
            this.zzepk.zza(this);
            zzbe(false);
            zzaxv.zzeh("Initiating WebView self destruct sequence in 3...");
            zzaxv.zzeh("Loading blank page in WebView, 2...");
            try {
                super.loadUrl("about:blank");
            } catch (UnsatisfiedLinkError e) {
                zzq.zzla().zza(e, "AdWebViewImpl.loadUrlUnsafe");
                zzaxv.zze("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final synchronized void zza(zzbhr zzbhr) {
        zzaxv.zzeh("Blank page loaded, 1...");
        zzabf();
    }

    /* access modifiers changed from: protected */
    public synchronized void zzabf() {
        zzaxv.zzeh("Destroying WebView!");
        zzwc();
        zzbbf.zzedl.execute(new zzbht(this));
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    zzbe(true);
                }
                zzwc();
            }
        } finally {
            super.finalize();
        }
    }

    private final synchronized void zzwc() {
        if (!this.zzeoe) {
            this.zzeoe = true;
            zzq.zzla().zzwc();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @Override // android.webkit.WebView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.ads.zzaxv.zzfd(r2)     // Catch:{ all -> 0x0019 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhu.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            super.loadUrl(str);
        } else {
            zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzaxv.zzfd("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            super.onDraw(canvas);
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            super.onPause();
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            super.onResume();
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            super.stopLoading();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public /* bridge */ /* synthetic */ void zzdb(String str) {
        super.zzdb(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacw() {
        super.destroy();
    }
}
