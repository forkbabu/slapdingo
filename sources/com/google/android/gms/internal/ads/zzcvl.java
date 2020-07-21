package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzcvl extends zzamw {
    private final zzbtv zzfpa;
    private final zzbtl zzfpq;
    private final zzbss zzftu;
    private final zzbui zzfty;
    private final zzbtc zzfuv;
    private final zzbsk zzfuw;
    private final zzbwj zzgby;
    private final zzbwg zzgnk;
    private final zzbyz zzgnu;

    public zzcvl(zzbsk zzbsk, zzbtc zzbtc, zzbtl zzbtl, zzbtv zzbtv, zzbwj zzbwj, zzbui zzbui, zzbyz zzbyz, zzbwg zzbwg, zzbss zzbss) {
        this.zzfuw = zzbsk;
        this.zzfuv = zzbtc;
        this.zzfpq = zzbtl;
        this.zzfpa = zzbtv;
        this.zzgby = zzbwj;
        this.zzfty = zzbui;
        this.zzgnu = zzbyz;
        this.zzgnk = zzbwg;
        this.zzftu = zzbss;
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdFailedToLoad(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zza(zzaep zzaep, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zza(zzamy zzamy) {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public void zza(zzaud zzaud) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public void zzb(zzaub zzaub) {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzc(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzdm(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public void zztu() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdClicked() {
        this.zzfuw.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdClosed() {
        this.zzfty.zzud();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdLeftApplication() {
        this.zzfpq.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdOpened() {
        this.zzfty.zzue();
        this.zzgnk.zzajj();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAppEvent(String str, String str2) {
        this.zzgby.onAppEvent(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdLoaded() {
        this.zzfpa.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public void onAdImpression() {
        this.zzfuv.onAdImpression();
        this.zzgnk.zzaji();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onVideoPause() {
        this.zzgnu.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public void zztt() {
        this.zzgnu.onVideoStart();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public void onVideoEnd() {
        this.zzgnu.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onVideoPlay() throws RemoteException {
        this.zzgnu.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    @Deprecated
    public final void zzdc(int i) throws RemoteException {
        this.zzftu.zzc(new zzuy(i, "", ""));
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzdn(String str) {
        this.zzftu.zzc(new zzuy(0, str, ""));
    }
}
