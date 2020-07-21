package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzafz;
import com.google.android.gms.internal.ads.zzagc;
import com.google.android.gms.internal.ads.zzagd;
import com.google.android.gms.internal.ads.zzagf;
import com.google.android.gms.internal.ads.zzagh;
import com.google.android.gms.internal.ads.zzamo;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzvf;
import com.google.android.gms.internal.ads.zzvh;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwo;
import com.google.android.gms.internal.ads.zzwp;
import com.google.android.gms.internal.ads.zzyq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class AdLoader {
    private final zzvf zzacq;
    private final zzwo zzacr;
    private final Context zzvr;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static class Builder {
        private final zzwp zzacp;
        private final Context zzvr;

        @Deprecated
        public Builder withCorrelator(Correlator correlator) {
            return this;
        }

        public Builder(Context context, String str) {
            this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzwg.zzpt().zzb(context, str, new zzamo()));
        }

        private Builder(Context context, zzwp zzwp) {
            this.zzvr = context;
            this.zzacp = zzwp;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzacp.zza(new zzagc(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzbba.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzacp.zza(new zzagd(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzbba.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzacp.zza(new zzagh(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbba.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzafz zzafz = new zzafz(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzacp.zza(str, zzafz.zzso(), zzafz.zzsp());
            } catch (RemoteException e) {
                zzbba.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzacp.zza(new zzagf(onPublisherAdViewLoadedListener), new zzvh(this.zzvr, adSizeArr));
            } catch (RemoteException e) {
                zzbba.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzacp.zzb(new zzva(adListener));
            } catch (RemoteException e) {
                zzbba.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzacp.zza(new zzadj(nativeAdOptions));
            } catch (RemoteException e) {
                zzbba.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzacp.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzbba.zzd("Failed to specify DFP banner ad options", e);
            }
            return this;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zzvr, this.zzacp.zzqb());
            } catch (RemoteException e) {
                zzbba.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    AdLoader(Context context, zzwo zzwo) {
        this(context, zzwo, zzvf.zzchh);
    }

    private AdLoader(Context context, zzwo zzwo, zzvf zzvf) {
        this.zzvr = context;
        this.zzacr = zzwo;
        this.zzacq = zzvf;
    }

    private final void zza(zzyq zzyq) {
        try {
            this.zzacr.zzb(zzvf.zza(this.zzvr, zzyq));
        } catch (RemoteException e) {
            zzbba.zzc("Failed to load ad.", e);
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdq());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzacr.zza(zzvf.zza(this.zzvr, adRequest.zzdq()), i);
        } catch (RemoteException e) {
            zzbba.zzc("Failed to load ads.", e);
        }
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdq());
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzacr.zzki();
        } catch (RemoteException e) {
            zzbba.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzacr.isLoading();
        } catch (RemoteException e) {
            zzbba.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }
}
