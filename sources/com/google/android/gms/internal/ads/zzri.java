package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.i18n.TextBundle;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzri extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbrw;
    private final int zzbry;
    private final boolean zzbrz;
    private boolean zzbsw;
    private boolean zzbsx;
    private final zzrf zzbsy;
    private final int zzbsz;
    private final int zzbta;
    private final int zzbtb;
    private final int zzbtc;
    private final int zzbtd;
    private final int zzbte;
    private final String zzbtf;
    private final boolean zzbtg;
    private final boolean zzbth;

    public zzri() {
        this(new zzrf());
    }

    private zzri(zzrf zzrf) {
        this.started = false;
        this.zzbsw = false;
        this.zzbsx = false;
        this.zzbsy = zzrf;
        this.lock = new Object();
        this.zzbrw = zzacf.zzczn.get().intValue();
        this.zzbta = zzacf.zzczk.get().intValue();
        this.zzbry = zzacf.zzczo.get().intValue();
        this.zzbtb = zzacf.zzczm.get().intValue();
        this.zzbtc = ((Integer) zzwg.zzpw().zzd(zzaav.zzcmr)).intValue();
        this.zzbtd = ((Integer) zzwg.zzpw().zzd(zzaav.zzcms)).intValue();
        this.zzbte = ((Integer) zzwg.zzpw().zzd(zzaav.zzcmt)).intValue();
        this.zzbsz = zzacf.zzczp.get().intValue();
        this.zzbtf = (String) zzwg.zzpw().zzd(zzaav.zzcmv);
        this.zzbtg = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcmw)).booleanValue();
        this.zzbrz = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcmx)).booleanValue();
        this.zzbth = ((Boolean) zzwg.zzpw().zzd(zzaav.zzcmy)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void zzmh() {
        synchronized (this.lock) {
            if (this.started) {
                zzaxv.zzee("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        com.google.android.gms.ads.internal.zzq.zzla().zza(r0, "ContentFetchTask.extractContent");
        com.google.android.gms.internal.ads.zzaxv.zzee("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        com.google.android.gms.internal.ads.zzaxv.zzc("Error in ContentFetchTask", r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0084 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b A[ExcHandler: InterruptedException (r0v1 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084 A[LOOP:1: B:28:0x0084->B:39:0x0084, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = zzmi()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzre r0 = com.google.android.gms.ads.internal.zzq.zzkz()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzaxv.zzee(r0)     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            r4.zzmk()     // Catch:{ InterruptedException -> 0x007b, Exception -> 0x006b }
            goto L_0x0062
        L_0x0019:
            if (r0 == 0) goto L_0x0062
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            if (r2 == 0) goto L_0x004c
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            if (r2 == 0) goto L_0x004c
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x007b }
            r1 = r0
            goto L_0x004c
        L_0x003d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzaxh r2 = com.google.android.gms.ads.internal.zzq.zzla()
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzaxv.zzee(r0)
        L_0x004c:
            if (r1 == 0) goto L_0x0062
            if (r1 != 0) goto L_0x0051
            goto L_0x0062
        L_0x0051:
            com.google.android.gms.internal.ads.zzrl r0 = new com.google.android.gms.internal.ads.zzrl
            r0.<init>(r4, r1)
            r1.post(r0)
            goto L_0x0062
        L_0x005a:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzaxv.zzee(r0)
            r4.zzmk()
        L_0x0062:
            int r0 = r4.zzbsz
            int r0 = r0 * 1000
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)
            goto L_0x0081
        L_0x006b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzaxv.zzc(r1, r0)
            com.google.android.gms.internal.ads.zzaxh r1 = com.google.android.gms.ads.internal.zzq.zzla()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L_0x0081
        L_0x007b:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzaxv.zzc(r1, r0)
        L_0x0081:
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
        L_0x0084:
            boolean r1 = r4.zzbsw     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x0093
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzaxv.zzee(r1)     // Catch:{ InterruptedException -> 0x0084 }
            java.lang.Object r1 = r4.lock     // Catch:{ InterruptedException -> 0x0084 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0084 }
            goto L_0x0084
        L_0x0093:
            monitor-exit(r0)
            goto L_0x0000
        L_0x0096:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzri.run():void");
    }

    /* access modifiers changed from: package-private */
    public final void zzj(View view) {
        try {
            zzrc zzrc = new zzrc(this.zzbrw, this.zzbta, this.zzbry, this.zzbtb, this.zzbtc, this.zzbtd, this.zzbte, this.zzbrz);
            Context context = zzq.zzkz().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbtf)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzwg.zzpw().zzd(zzaav.zzcmu), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbtf)) {
                    return;
                }
            }
            zzrm zza = zza(view, zzrc);
            zzrc.zzmf();
            if (zza.zzbto != 0 || zza.zzbtp != 0) {
                if (zza.zzbtp != 0 || zzrc.zzmg() != 0) {
                    if (zza.zzbtp != 0 || !this.zzbsy.zza(zzrc)) {
                        this.zzbsy.zzc(zzrc);
                    }
                }
            }
        } catch (Exception e) {
            zzaxv.zzc("Exception in fetchContentOnUIThread", e);
            zzq.zzla().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    private static boolean zzmi() {
        boolean z;
        try {
            Context context = zzq.zzkz().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null) {
                return false;
            }
            if (keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager == null) {
                        z = false;
                    } else {
                        z = powerManager.isScreenOn();
                    }
                    if (z) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzq.zzla().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final zzrm zza(View view, zzrc zzrc) {
        boolean z;
        if (view == null) {
            return new zzrm(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzrm(this, 0, 0);
            }
            zzrc.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzrm(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbfn)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzrc.zzmd();
                webView.post(new zzrk(this, zzrc, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new zzrm(this, 0, 1);
            }
            return new zzrm(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzrm(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzrm zza = zza(viewGroup.getChildAt(i3), zzrc);
                i += zza.zzbto;
                i2 += zza.zzbtp;
            }
            return new zzrm(this, i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzrc zzrc, WebView webView, String str, boolean z) {
        zzrc.zzmc();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(TextBundle.TEXT_ENTRY);
                if (this.zzbtg || TextUtils.isEmpty(webView.getTitle())) {
                    zzrc.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzrc.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzrc.zzlx()) {
                this.zzbsy.zzb(zzrc);
            }
        } catch (JSONException unused) {
            zzaxv.zzee("Json string may be malformed.");
        } catch (Throwable th) {
            zzaxv.zzb("Failed to get webview content.", th);
            zzq.zzla().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzrc zzmj() {
        return this.zzbsy.zzo(this.zzbth);
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbsw = false;
            this.lock.notifyAll();
            zzaxv.zzee("ContentFetchThread: wakeup");
        }
    }

    private final void zzmk() {
        synchronized (this.lock) {
            this.zzbsw = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            zzaxv.zzee(sb.toString());
        }
    }

    public final boolean zzml() {
        return this.zzbsw;
    }
}
