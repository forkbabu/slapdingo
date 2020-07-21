package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbgc extends FrameLayout implements zzbfn {
    /* access modifiers changed from: private */
    public final zzbfn zzemv;
    private final zzbcu zzemw;
    private final AtomicBoolean zzemx = new AtomicBoolean();

    public zzbgc(zzbfn zzbfn) {
        super(zzbfn.getContext());
        this.zzemv = zzbfn;
        this.zzemw = new zzbcu(zzbfn.zzaau(), this, this);
        if (!zzabq()) {
            addView(this.zzemv.getView());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbha, com.google.android.gms.internal.ads.zzbfn
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final zzbcu zzzi() {
        return this.zzemw;
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void onPause() {
        this.zzemw.onPause();
        this.zzemv.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabf() {
        this.zzemw.onDestroy();
        this.zzemv.zzabf();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabl() {
        setBackgroundColor(0);
        this.zzemv.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final int zzzp() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final int zzzq() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final void zzzr() {
        this.zzemv.zzzr();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final WebView getWebView() {
        return this.zzemv.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzajh
    public final void zza(String str, Map<String, ?> map) {
        this.zzemv.zza(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzajh
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzemv.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(String str, zzahc<? super zzbfn> zzahc) {
        this.zzemv.zza(str, zzahc);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzb(String str, zzahc<? super zzbfn> zzahc) {
        this.zzemv.zzb(str, zzahc);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(String str, Predicate<zzahc<? super zzbfn>> predicate) {
        this.zzemv.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzaas() {
        this.zzemv.zzaas();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzds(int i) {
        this.zzemv.zzds(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzuq() {
        this.zzemv.zzuq();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzaat() {
        this.zzemv.zzaat();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final void zza(boolean z, long j) {
        this.zzemv.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zzdb(String str) {
        this.zzemv.zzdb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zza(String str, JSONObject jSONObject) {
        this.zzemv.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbgq
    public final Activity zzzl() {
        return this.zzemv.zzzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final Context zzaau() {
        return this.zzemv.zzaau();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbfn
    public final zza zzzm() {
        return this.zzemv.zzzm();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final zzc zzaav() {
        return this.zzemv.zzaav();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final IObjectWrapper zzabd() {
        return this.zzemv.zzabd();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final zzc zzaaw() {
        return this.zzemv.zzaaw();
    }

    @Override // com.google.android.gms.internal.ads.zzbgv, com.google.android.gms.internal.ads.zzbfn
    public final zzbhg zzaax() {
        return this.zzemv.zzaax();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final String zzaay() {
        return this.zzemv.zzaay();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final zzbgz zzaaz() {
        return this.zzemv.zzaaz();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final WebViewClient zzaba() {
        return this.zzemv.zzaba();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzabb() {
        return this.zzemv.zzabb();
    }

    @Override // com.google.android.gms.internal.ads.zzbgy, com.google.android.gms.internal.ads.zzbfn
    public final zzeg zzabc() {
        return this.zzemv.zzabc();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbgx, com.google.android.gms.internal.ads.zzbfn
    public final zzbbd zzzo() {
        return this.zzemv.zzzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn, com.google.android.gms.internal.ads.zzbgp
    public final boolean zzabe() {
        return this.zzemv.zzabe();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean isDestroyed() {
        return this.zzemv.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzabg() {
        return this.zzemv.zzabg();
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final void zzke() {
        this.zzemv.zzke();
    }

    @Override // com.google.android.gms.ads.internal.zzi
    public final void zzkd() {
        this.zzemv.zzkd();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final String getRequestId() {
        return this.zzemv.getRequestId();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final zzabg zzzk() {
        return this.zzemv.zzzk();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbfn
    public final zzabj zzzn() {
        return this.zzemv.zzzn();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbfn
    public final zzbgh zzzj() {
        return this.zzemv.zzzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzc zzc) {
        this.zzemv.zza(zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzap(IObjectWrapper iObjectWrapper) {
        this.zzemv.zzap(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzbhg zzbhg) {
        this.zzemv.zza(zzbhg);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzax(boolean z) {
        this.zzemv.zzax(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabi() {
        this.zzemv.zzabi();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzbw(Context context) {
        this.zzemv.zzbw(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzal(boolean z) {
        this.zzemv.zzal(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void setRequestedOrientation(int i) {
        this.zzemv.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzb(zzc zzc) {
        this.zzemv.zzb(zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzay(boolean z) {
        this.zzemv.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbfn
    public final void zza(String str, zzbes zzbes) {
        this.zzemv.zza(str, zzbes);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final zzbes zzfi(String str) {
        return this.zzemv.zzfi(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabj() {
        this.zzemv.zzabj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void destroy() {
        IObjectWrapper zzabd = zzabd();
        if (zzabd != null) {
            zzaye.zzdzw.post(new zzbgb(zzabd));
            zzaye.zzdzw.postDelayed(new zzbge(this), (long) ((Integer) zzwg.zzpw().zzd(zzaav.zzctl)).intValue());
            return;
        }
        this.zzemv.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void loadData(String str, String str2, String str3) {
        this.zzemv.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzemv.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void loadUrl(String str) {
        this.zzemv.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzb(String str, String str2, String str3) {
        this.zzemv.zzb(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzemv.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzemv.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzemv.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzemv.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void onResume() {
        this.zzemv.onResume();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzabm() {
        TextView textView = new TextView(getContext());
        Resources resources = zzq.zzla().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzba(boolean z) {
        this.zzemv.zzba(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzadc zzadc) {
        this.zzemv.zza(zzadc);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzsa zzsa) {
        this.zzemv.zza(zzsa);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final zzsa zzabn() {
        return this.zzemv.zzabn();
    }

    @Override // com.google.android.gms.internal.ads.zzqs
    public final void zza(zzqt zzqt) {
        this.zzemv.zza(zzqt);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzadh zzadh) {
        this.zzemv.zza(zzadh);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final zzadh zzabk() {
        return this.zzemv.zzabk();
    }

    @Override // com.google.android.gms.internal.ads.zzbdb, com.google.android.gms.internal.ads.zzbfn
    public final void zza(zzbgh zzbgh) {
        this.zzemv.zza(zzbgh);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzabh() {
        return this.zzemv.zzabh();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zzaz(boolean z) {
        this.zzemv.zzaz(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final void zzav(boolean z) {
        this.zzemv.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdb
    public final void zzur() {
        this.zzemv.zzur();
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zza(zzd zzd) {
        this.zzemv.zza(zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzc(boolean z, int i) {
        this.zzemv.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zza(boolean z, int i, String str) {
        this.zzemv.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzemv.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzb(boolean z, int i) {
        if (!this.zzemx.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcns)).booleanValue()) {
            return false;
        }
        if (this.zzemv.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zzemv.getParent()).removeView(this.zzemv.getView());
        }
        return this.zzemv.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzabo() {
        return this.zzemx.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        this.zzemv.zza(this, activity, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final zzso zzabp() {
        return this.zzemv.zzabp();
    }

    @Override // com.google.android.gms.internal.ads.zzbfn
    public final boolean zzabq() {
        return this.zzemv.zzabq();
    }
}
