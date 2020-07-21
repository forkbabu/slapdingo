package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzabo;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzaqy;
import com.google.android.gms.internal.ads.zzatq;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzbaq;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbf;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzeg;
import com.google.android.gms.internal.ads.zzsg;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzvh;
import com.google.android.gms.internal.ads.zzvo;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwi;
import com.google.android.gms.internal.ads.zzwj;
import com.google.android.gms.internal.ads.zzwv;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzxe;
import com.google.android.gms.internal.ads.zzxk;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzyi;
import com.google.android.gms.internal.ads.zzyo;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzl extends zzwv {
    /* access modifiers changed from: private */
    public final zzbbd zzboy;
    private final zzvh zzboz;
    /* access modifiers changed from: private */
    public final Future<zzeg> zzbpa = zzbbf.zzedh.zze(new zzm(this));
    private final zzo zzbpb;
    /* access modifiers changed from: private */
    public WebView zzbpc = new WebView(this.zzvr);
    /* access modifiers changed from: private */
    public zzwj zzbpd;
    /* access modifiers changed from: private */
    public zzeg zzbpe;
    private AsyncTask<Void, Void, String> zzbpf;
    /* access modifiers changed from: private */
    public final Context zzvr;

    public zzl(Context context, zzvh zzvh, String str, zzbbd zzbbd) {
        this.zzvr = context;
        this.zzboy = zzbbd;
        this.zzboz = zzvh;
        this.zzbpb = new zzo(context, str);
        zzbs(0);
        this.zzbpc.setVerticalScrollBarEnabled(false);
        this.zzbpc.getSettings().setJavaScriptEnabled(true);
        this.zzbpc.setWebViewClient(new zzk(this));
        this.zzbpc.setOnTouchListener(new zzn(this));
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzyi getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzyc zzyc) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final String zzki() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzyd zzkj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final IObjectWrapper zzkf() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzbpc);
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbpf.cancel(true);
        this.zzbpa.cancel(true);
        this.zzbpc.destroy();
        this.zzbpc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final boolean zza(zzve zzve) throws RemoteException {
        Preconditions.checkNotNull(this.zzbpc, "This Search Ad has already been torn down");
        this.zzbpb.zza(zzve, this.zzboy);
        this.zzbpf = new zzp(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwj zzwj) throws RemoteException {
        this.zzbpd = zzwj;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzxe zzxe) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwz zzwz) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zzkg() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzvh zzkh() throws RemoteException {
        return this.zzboz;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzvh zzvh) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzaqs zzaqs) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzaqy zzaqy, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzxe zzkk() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzwj zzkl() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzabo zzabo) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwi zzwi) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzxk zzxk) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzatq zzatq) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zzbo(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzaaa zzaaa) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzyo zzyo) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzvo zzvo) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzsg zzsg) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final int zzbp(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter(HtmlTags.HEIGHT);
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzwg.zzps();
            return zzbaq.zzc(this.zzvr, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbs(int i) {
        if (this.zzbpc != null) {
            this.zzbpc.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzkm() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzacb.zzcza.get());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzbpb.getQuery());
        builder.appendQueryParameter("pubId", this.zzbpb.zzkp());
        Map<String, String> zzkq = this.zzbpb.zzkq();
        for (String str : zzkq.keySet()) {
            builder.appendQueryParameter(str, zzkq.get(str));
        }
        Uri build = builder.build();
        zzeg zzeg = this.zzbpe;
        if (zzeg != null) {
            try {
                build = zzeg.zza(build, this.zzvr);
            } catch (zzef e) {
                zzaxv.zzd("Unable to process ad data", e);
            }
        }
        String zzkn = zzkn();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(zzkn).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(zzkn);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zzkn() {
        String zzko = this.zzbpb.zzko();
        if (TextUtils.isEmpty(zzko)) {
            zzko = "www.google.com";
        }
        String str = zzacb.zzcza.get();
        StringBuilder sb = new StringBuilder(String.valueOf(zzko).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(zzko);
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final String zzbq(String str) {
        if (this.zzbpe == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzbpe.zza(parse, this.zzvr, null, null);
        } catch (zzef e) {
            zzaxv.zzd("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* access modifiers changed from: private */
    public final void zzbr(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.zzvr.startActivity(intent);
    }
}
