package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzapc extends zzaow {
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdke;
    private final RtbAdapter zzdky;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzdkz;
    private String zzdla = "";

    public zzapc(RtbAdapter rtbAdapter) {
        this.zzdky = rtbAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zzy(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zza(String str, String str2, zzve zzve, IObjectWrapper iObjectWrapper, zzaol zzaol, zzamx zzamx, zzvh zzvh) throws RemoteException {
        try {
            this.zzdky.loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzds(str2), zzd(zzve), zzc(zzve), zzve.zznb, zzve.zzadg, zzve.zzadh, zza(str2, zzve), zzb.zza(zzvh.width, zzvh.height, zzvh.zzacv), this.zzdla), new zzapf(this, zzaol, zzamx));
        } catch (Throwable th) {
            zzbba.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zza(String str, String str2, zzve zzve, IObjectWrapper iObjectWrapper, zzaom zzaom, zzamx zzamx) throws RemoteException {
        try {
            this.zzdky.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzds(str2), zzd(zzve), zzc(zzve), zzve.zznb, zzve.zzadg, zzve.zzadh, zza(str2, zzve), this.zzdla), new zzape(this, zzaom, zzamx));
        } catch (Throwable th) {
            zzbba.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zza(String str, String str2, zzve zzve, IObjectWrapper iObjectWrapper, zzaos zzaos, zzamx zzamx) throws RemoteException {
        try {
            this.zzdky.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzds(str2), zzd(zzve), zzc(zzve), zzve.zznb, zzve.zzadg, zzve.zzadh, zza(str2, zzve), this.zzdla), zza(zzaos, zzamx));
        } catch (Throwable th) {
            zzbba.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zzb(String str, String str2, zzve zzve, IObjectWrapper iObjectWrapper, zzaos zzaos, zzamx zzamx) throws RemoteException {
        try {
            this.zzdky.loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzds(str2), zzd(zzve), zzc(zzve), zzve.zznb, zzve.zzadg, zzve.zzadh, zza(str2, zzve), this.zzdla), zza(zzaos, zzamx));
        } catch (Throwable th) {
            zzbba.zzc("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zza(String str, String str2, zzve zzve, IObjectWrapper iObjectWrapper, zzaor zzaor, zzamx zzamx) throws RemoteException {
        try {
            this.zzdky.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzds(str2), zzd(zzve), zzc(zzve), zzve.zznb, zzve.zzadg, zzve.zzadh, zza(str2, zzve), this.zzdla), new zzaph(this, zzaor, zzamx));
        } catch (Throwable th) {
            zzbba.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzdkz;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbba.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzdke;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbba.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final zzyi getVideoController() {
        RtbAdapter rtbAdapter = this.zzdky;
        if (!(rtbAdapter instanceof zza)) {
            return null;
        }
        try {
            return ((zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzbba.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvh zzvh, zzaoy zzaoy) throws RemoteException {
        AdFormat adFormat;
        try {
            zzapg zzapg = new zzapg(this, zzaoy);
            RtbAdapter rtbAdapter = this.zzdky;
            char c = 65535;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        c = 3;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (c == 3) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, zzb.zza(zzvh.width, zzvh.height, zzvh.zzacv)), zzapg);
        } catch (Throwable th) {
            zzbba.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final zzapl zztr() throws RemoteException {
        return zzapl.zza(this.zzdky.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final zzapl zzts() throws RemoteException {
        return zzapl.zza(this.zzdky.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaox
    public final void zzdq(String str) {
        this.zzdla = str;
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzaos zzaos, zzamx zzamx) {
        return new zzapj(this, zzaos, zzamx);
    }

    private static Bundle zzds(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbba.zzfd(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzbba.zzc("", e);
            throw new RemoteException();
        }
    }

    private static boolean zzc(zzve zzve) {
        if (zzve.zzcgv) {
            return true;
        }
        zzwg.zzps();
        return zzbaq.zzyh();
    }

    private static String zza(String str, zzve zzve) {
        String str2 = zzve.zzadi;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    private final Bundle zzd(zzve zzve) {
        Bundle bundle;
        if (zzve.zzcgz == null || (bundle = zzve.zzcgz.getBundle(this.zzdky.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }
}
