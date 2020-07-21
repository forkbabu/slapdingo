package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbff extends WebChromeClient {
    private final zzbfn zzdfp;

    public zzbff(zzbfn zzbfn) {
        this.zzdfp = zzbfn;
    }

    private final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zzc zzabr;
        try {
            if (this.zzdfp == null || this.zzdfp.zzaaz() == null || this.zzdfp.zzaaz().zzabr() == null || (zzabr = this.zzdfp.zzaaz().zzabr()) == null || zzabr.zzjy()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new zzbfl(jsPromptResult, editText)).setNegativeButton(17039360, new zzbfm(jsPromptResult)).setOnCancelListener(new zzbfj(jsPromptResult)).create().show();
                } else {
                    builder.setMessage(str3).setPositiveButton(17039370, new zzbfk(jsResult)).setNegativeButton(17039360, new zzbfh(jsResult)).setOnCancelListener(new zzbfi(jsResult)).create().show();
                }
                return true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzabr.zzbn(sb.toString());
            return false;
        } catch (WindowManager.BadTokenException e) {
            zzaxv.zzd("Fail to display Dialog.", e);
        }
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zzdfp.zzaba() != null) {
            webView2.setWebViewClient(this.zzdfp.zzaba());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbfn)) {
            zzaxv.zzfd("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzc zzaav = ((zzbfn) webView).zzaav();
        if (zzaav == null) {
            zzaxv.zzfd("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzaav.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        sb.append("JS: ");
        sb.append(message);
        sb.append(" (");
        sb.append(sourceId);
        sb.append(":");
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzbfo.zzelh[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            zzaxv.zzfb(sb2);
        } else if (i == 2) {
            zzaxv.zzfd(sb2);
        } else if (i == 3 || i == 4) {
            zzaxv.zzfc(sb2);
        } else if (i != 5) {
            zzaxv.zzfc(sb2);
        } else {
            zzaxv.zzee(sb2);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(j + Math.min((long) PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4), (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            } else if (j2 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzc zzaav = this.zzdfp.zzaav();
        if (zzaav == null) {
            zzaxv.zzfd("Could not get ad overlay when hiding custom view.");
        } else {
            zzaav.zzuj();
        }
    }

    private static Context zza(WebView webView) {
        if (!(webView instanceof zzbfn)) {
            return webView.getContext();
        }
        zzbfn zzbfn = (zzbfn) webView;
        Activity zzzl = zzbfn.zzzl();
        if (zzzl != null) {
            return zzzl;
        }
        return zzbfn.getContext();
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "alert", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = j + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzc zzaav = this.zzdfp.zzaav();
        if (zzaav == null) {
            zzaxv.zzfd("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzaav.zza(view, customViewCallback);
        zzaav.setRequestedOrientation(i);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzq.zzkw();
            if (!zzaye.zzr(this.zzdfp.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzq.zzkw();
                if (!zzaye.zzr(this.zzdfp.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (!PlatformVersion.isAtLeastLollipop() || zzacw.zzdbl.get().booleanValue()) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        zzbfn zzbfn = this.zzdfp;
        if (zzbfn == null || zzbfn.zzaaz() == null || this.zzdfp.zzaaz().zzace() == null) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        String[] zza = this.zzdfp.zzaaz().zzace().zza(permissionRequest.getResources());
        if (zza.length > 0) {
            permissionRequest.grant(zza);
        } else {
            permissionRequest.deny();
        }
    }
}
