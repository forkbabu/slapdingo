package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public interface zzbfn extends zzi, zzajh, zzake, zzbdb, zzbgp, zzbgq, zzbgt, zzbgx, zzbgy, zzbha, zzqs {
    void destroy();

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbgq
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    @Override // com.google.android.gms.internal.ads.zzbha
    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzbdb
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(ViewGroup viewGroup, Activity activity, String str, String str2);

    void zza(zzc zzc);

    void zza(zzadc zzadc);

    void zza(zzadh zzadh);

    @Override // com.google.android.gms.internal.ads.zzbdb
    void zza(zzbgh zzbgh);

    void zza(zzbhg zzbhg);

    void zza(zzsa zzsa);

    void zza(String str, Predicate<zzahc<? super zzbfn>> predicate);

    void zza(String str, zzahc<? super zzbfn> zzahc);

    @Override // com.google.android.gms.internal.ads.zzbdb
    void zza(String str, zzbes zzbes);

    void zzaas();

    void zzaat();

    Context zzaau();

    zzc zzaav();

    zzc zzaaw();

    @Override // com.google.android.gms.internal.ads.zzbgv
    zzbhg zzaax();

    String zzaay();

    zzbgz zzaaz();

    WebViewClient zzaba();

    boolean zzabb();

    @Override // com.google.android.gms.internal.ads.zzbgy
    zzeg zzabc();

    IObjectWrapper zzabd();

    @Override // com.google.android.gms.internal.ads.zzbgp
    boolean zzabe();

    void zzabf();

    boolean zzabg();

    boolean zzabh();

    void zzabi();

    void zzabj();

    zzadh zzabk();

    void zzabl();

    void zzabm();

    zzsa zzabn();

    boolean zzabo();

    zzso zzabp();

    boolean zzabq();

    void zzal(boolean z);

    void zzap(IObjectWrapper iObjectWrapper);

    void zzax(boolean z);

    void zzay(boolean z);

    void zzaz(boolean z);

    void zzb(zzc zzc);

    void zzb(String str, zzahc<? super zzbfn> zzahc);

    void zzb(String str, String str2, String str3);

    boolean zzb(boolean z, int i);

    void zzba(boolean z);

    void zzbw(Context context);

    void zzds(int i);

    void zzuq();

    @Override // com.google.android.gms.internal.ads.zzbdb
    zzbgh zzzj();

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbgq
    Activity zzzl();

    @Override // com.google.android.gms.internal.ads.zzbdb
    zza zzzm();

    @Override // com.google.android.gms.internal.ads.zzbdb
    zzabj zzzn();

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbgx
    zzbbd zzzo();
}
