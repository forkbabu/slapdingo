package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdha extends zzwv implements zzy, zzbuf, zzsa {
    /* access modifiers changed from: private */
    public final zzbbd zzbov;
    private final String zzbum;
    /* access modifiers changed from: private */
    public final ViewGroup zzfng;
    private final zzbif zzgmd;
    private final Context zzgov;
    private AtomicBoolean zzgwm = new AtomicBoolean();
    private final zzdgr zzgwn;
    /* access modifiers changed from: private */
    public final zzdhi zzgwo;
    private long zzgwp;
    private zzbml zzgwq;
    protected zzbmw zzgwr;

    public zzdha(zzbif zzbif, Context context, String str, zzdgr zzdgr, zzdhi zzdhi, zzbbd zzbbd) {
        this.zzfng = new FrameLayout(context);
        this.zzgmd = zzbif;
        this.zzgov = context;
        this.zzbum = str;
        this.zzgwn = zzdgr;
        this.zzgwo = zzdhi;
        zzdhi.zza(this);
        this.zzbov = zzbbd;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzaqs zzaqs) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzaqy zzaqy, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzatq zzatq) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwi zzwi) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwj zzwj) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzwz zzwz) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzxe zzxe) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzyc zzyc) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzyo zzyo) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zzbo(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzxe zzkk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final zzwj zzkl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final IObjectWrapper zzkf() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfng);
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzvo zzvo) {
        this.zzgwn.zza(zzvo);
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized boolean zza(zzve zzve) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzq.zzkw();
        if (zzaye.zzbf(this.zzgov) && zzve.zzchg == null) {
            zzaxv.zzfb("Failed to load the ad because app ID is missing.");
            this.zzgwo.onAdFailedToLoad(8);
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.zzgwm = new AtomicBoolean();
            return this.zzgwn.zza(zzve, this.zzbum, new zzdhb(this), new zzdhe(this));
        }
    }

    /* access modifiers changed from: private */
    public final com.google.android.gms.ads.internal.overlay.zzq zza(zzbmw zzbmw) {
        boolean zzabs = zzbmw.zzabs();
        int intValue = ((Integer) zzwg.zzpw().zzd(zzaav.zzctd)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = zzabs ? intValue : 0;
        zzp.paddingRight = zzabs ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        return new com.google.android.gms.ads.internal.overlay.zzq(this.zzgov, zzp, this);
    }

    /* access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzbmw zzbmw) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbmw.zzabs() ? 11 : 9);
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzbmw zzbmw) {
        zzbmw.zza(this);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void zzuk() {
        zzaru();
    }

    @Override // com.google.android.gms.internal.ads.zzsa
    public final void zzms() {
        zzaru();
    }

    @Override // com.google.android.gms.internal.ads.zzbuf
    public final void zzajb() {
        if (this.zzgwr != null) {
            this.zzgwp = zzq.zzld().elapsedRealtime();
            int zzahc = this.zzgwr.zzahc();
            if (zzahc > 0) {
                zzbml zzbml = new zzbml(this.zzgmd.zzadf(), zzq.zzld());
                this.zzgwq = zzbml;
                zzbml.zza(zzahc, new zzdhc(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzarr */
    public final void zzaru() {
        if (this.zzgwm.compareAndSet(false, true)) {
            zzbmw zzbmw = this.zzgwr;
            if (!(zzbmw == null || zzbmw.zzahm() == null)) {
                this.zzgwo.zzb(this.zzgwr.zzahm());
            }
            this.zzgwo.onAdClosed();
            this.zzfng.removeAllViews();
            zzbml zzbml = this.zzgwq;
            if (zzbml != null) {
                zzq.zzkz().zzb(zzbml);
            }
            zzbmw zzbmw2 = this.zzgwr;
            if (zzbmw2 != null) {
                zzbmw2.zzfd(zzq.zzld().elapsedRealtime() - this.zzgwp);
            }
            destroy();
        }
    }

    /* access modifiers changed from: private */
    public final zzvh zzars() {
        return zzdld.zzb(this.zzgov, Collections.singletonList(this.zzgwr.zzahj()));
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgwr != null) {
            this.zzgwr.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zza(zzsg zzsg) {
        this.zzgwo.zzb(zzsg);
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized zzvh zzkh() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgwr == null) {
            return null;
        }
        return zzdld.zzb(this.zzgov, Collections.singletonList(this.zzgwr.zzahj()));
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void zza(zzvh zzvh) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized String zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized zzyd zzkj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized boolean isLoading() {
        return this.zzgwn.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized String getAdUnitId() {
        return this.zzbum;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void zzkg() {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void zza(zzxk zzxk) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized zzyi getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void zza(zzaaa zzaaa) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final synchronized void zza(zzabo zzabo) {
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzart() {
        this.zzgmd.zzade().execute(new zzdgz(this));
    }
}
