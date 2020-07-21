package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcwo extends zzwv {
    private final ViewGroup zzfng;
    private final zzdla zzfpv;
    private final zzwj zzfum;
    private final zzbnc zzgoq;
    private final Context zzvr;

    public zzcwo(Context context, zzwj zzwj, zzdla zzdla, zzbnc zzbnc) {
        this.zzvr = context;
        this.zzfum = zzwj;
        this.zzfpv = zzdla;
        this.zzgoq = zzbnc;
        FrameLayout frameLayout = new FrameLayout(this.zzvr);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzgoq.zzahk(), zzq.zzky().zzxo());
        frameLayout.setMinimumHeight(zzkh().heightPixels);
        frameLayout.setMinimumWidth(zzkh().widthPixels);
        this.zzfng = frameLayout;
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
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void showInterstitial() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzaqs zzaqs) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzaqy zzaqy, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzatq zzatq) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzsg zzsg) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzvo zzvo) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzyo zzyo) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zzbo(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final IObjectWrapper zzkf() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfng);
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgoq.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final boolean zza(zzve zzve) throws RemoteException {
        zzaxv.zzfc("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgoq.zzaig().zzca(null);
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgoq.zzaig().zzcb(null);
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zzkg() throws RemoteException {
        this.zzgoq.zzkg();
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzvh zzkh() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzdld.zzb(this.zzvr, Collections.singletonList(this.zzgoq.zzahj()));
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgoq.zzaih() != null) {
            return this.zzgoq.zzaih().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzyi getVideoController() throws RemoteException {
        return this.zzgoq.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final String getAdUnitId() throws RemoteException {
        return this.zzfpv.zzhaz;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzxe zzkk() throws RemoteException {
        return this.zzfpv.zzhbe;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzwj zzkl() throws RemoteException {
        return this.zzfum;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final String zzki() throws RemoteException {
        if (this.zzgoq.zzaih() != null) {
            return this.zzgoq.zzaih().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzyd zzkj() {
        return this.zzgoq.zzaih();
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzaaa zzaaa) throws RemoteException {
        zzaxv.zzfc("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzvh zzvh) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbnc zzbnc = this.zzgoq;
        if (zzbnc != null) {
            zzbnc.zza(this.zzfng, zzvh);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzabo zzabo) throws RemoteException {
        zzaxv.zzfc("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwi zzwi) throws RemoteException {
        zzaxv.zzfc("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzxk zzxk) throws RemoteException {
        zzaxv.zzfc("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        zzaxv.zzfc("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwj zzwj) throws RemoteException {
        zzaxv.zzfc("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzxe zzxe) throws RemoteException {
        zzaxv.zzfc("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwz zzwz) throws RemoteException {
        zzaxv.zzfc("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final Bundle getAdMetadata() throws RemoteException {
        zzaxv.zzfc("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzyc zzyc) {
        zzaxv.zzfc("setOnPaidEventListener is not supported in Publisher AdView returned by AdLoader.");
    }
}
