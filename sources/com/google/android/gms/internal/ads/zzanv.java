package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzanv<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzamv {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdkr;
    private final NETWORK_EXTRAS zzdks;

    public zzanv(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzdkr = mediationAdapter;
        this.zzdks = network_extras;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzyi getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzaie zzaie, List<zzaim> list) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzatx zzatx, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzve zzve, String str, zzatx zzatx, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzve zzve, String str, String str2, zzamx zzamx, zzadj zzadj, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(zzve zzve, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(zzve zzve, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzb(IObjectWrapper iObjectWrapper, zzve zzve, String str, zzamx zzamx) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzc(IObjectWrapper iObjectWrapper, zzve zzve, String str, zzamx zzamx) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzana zztk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzanf zztl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean zzto() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzaep zztp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzang zztq() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzapl zztr() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzapl zzts() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final IObjectWrapper zztj() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdkr;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbba.zzfd(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzbba.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzvh zzvh, zzve zzve, String str, zzamx zzamx) throws RemoteException {
        zza(iObjectWrapper, zzvh, zzve, str, null, zzamx);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzvh zzvh, zzve zzve, String str, String str2, zzamx zzamx) throws RemoteException {
        AdSize adSize;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdkr;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbba.zzfd(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbba.zzee("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdkr;
            zzanu zzanu = new zzanu(zzamx);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            SERVER_PARAMETERS zzdo = zzdo(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzvh.width && adSizeArr[i].getHeight() == zzvh.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(zzb.zza(zzvh.width, zzvh.height, zzvh.zzacv));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzanu, activity, zzdo, adSize, zzaog.zza(zzve, zzc(zzve)), this.zzdks);
        } catch (Throwable th) {
            zzbba.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zztm() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzve zzve, String str, zzamx zzamx) throws RemoteException {
        zza(iObjectWrapper, zzve, str, (String) null, zzamx);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzve zzve, String str, String str2, zzamx zzamx) throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdkr;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbba.zzfd(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbba.zzee("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdkr).requestInterstitialAd(new zzanu(zzamx), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzdo(str), zzaog.zza(zzve, zzc(zzve)), this.zzdks);
        } catch (Throwable th) {
            zzbba.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showInterstitial() throws RemoteException {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdkr;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbba.zzfd(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbba.zzee("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdkr).showInterstitial();
        } catch (Throwable th) {
            zzbba.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zztn() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void destroy() throws RemoteException {
        try {
            this.zzdkr.destroy();
        } catch (Throwable th) {
            zzbba.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    private final SERVER_PARAMETERS zzdo(String str) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzbba.zzc("", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zzdkr.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS newInstance = serverParametersType.newInstance();
        newInstance.load(hashMap);
        return newInstance;
    }

    private static boolean zzc(zzve zzve) {
        if (zzve.zzcgv) {
            return true;
        }
        zzwg.zzps();
        return zzbaq.zzyh();
    }
}
