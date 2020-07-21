package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzaxv;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzk extends WebViewClient {
    private final /* synthetic */ zzl zzbox;

    zzk(zzl zzl) {
        this.zzbox = zzl;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zzbox.zzkn())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            if (this.zzbox.zzbpd != null) {
                try {
                    this.zzbox.zzbpd.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzaxv.zze("#007 Could not call remote method.", e);
                }
            }
            this.zzbox.zzbs(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            if (this.zzbox.zzbpd != null) {
                try {
                    this.zzbox.zzbpd.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzaxv.zze("#007 Could not call remote method.", e2);
                }
            }
            this.zzbox.zzbs(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            if (this.zzbox.zzbpd != null) {
                try {
                    this.zzbox.zzbpd.onAdLoaded();
                } catch (RemoteException e3) {
                    zzaxv.zze("#007 Could not call remote method.", e3);
                }
            }
            this.zzbox.zzbs(this.zzbox.zzbp(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.zzbox.zzbpd != null) {
                try {
                    this.zzbox.zzbpd.onAdLeftApplication();
                } catch (RemoteException e4) {
                    zzaxv.zze("#007 Could not call remote method.", e4);
                }
            }
            this.zzbox.zzbr(this.zzbox.zzbq(str));
            return true;
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.zzbox.zzbpd != null) {
            try {
                this.zzbox.zzbpd.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzaxv.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
