package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class zzyt {
    private static zzyt zzcjq;
    private final Object lock = new Object();
    private zzxm zzcjr;
    private RewardedVideoAd zzcjs;
    private RequestConfiguration zzcjt = new RequestConfiguration.Builder().build();
    private InitializationStatus zzcju;
    private boolean zzxh = false;

    private zzyt() {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    class zza extends zzaii {
        private final OnInitializationCompleteListener zzcka;

        private zza(OnInitializationCompleteListener onInitializationCompleteListener) {
            this.zzcka = onInitializationCompleteListener;
        }

        @Override // com.google.android.gms.internal.ads.zzaij
        public final void zze(List<zzaic> list) throws RemoteException {
            this.zzcka.onInitializationComplete(zzyt.zzd(list));
        }

        /* synthetic */ zza(zzyt zzyt, OnInitializationCompleteListener onInitializationCompleteListener, zzyx zzyx) {
            this(onInitializationCompleteListener);
        }
    }

    public static zzyt zzqs() {
        zzyt zzyt;
        synchronized (zzyt.class) {
            if (zzcjq == null) {
                zzcjq = new zzyt();
            }
            zzyt = zzcjq;
        }
        return zzyt;
    }

    public final void zza(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.lock) {
            if (!this.zzxh) {
                if (context != null) {
                    try {
                        zzamj.zzti().zzd(context, str);
                        zzg(context);
                        this.zzxh = true;
                        if (onInitializationCompleteListener != null) {
                            this.zzcjr.zza(new zza(this, onInitializationCompleteListener, null));
                        }
                        this.zzcjr.zza(new zzamo());
                        this.zzcjr.initialize();
                        this.zzcjr.zza(str, ObjectWrapper.wrap(new zzyw(this, context)));
                        if (!(this.zzcjt.getTagForChildDirectedTreatment() == -1 && this.zzcjt.getTagForUnderAgeOfConsent() == -1)) {
                            zza(this.zzcjt);
                        }
                        zzaav.initialize(context);
                        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzctv)).booleanValue() && !getVersionString().endsWith("0")) {
                            zzbba.zzfb("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                            this.zzcju = new zzyy(this);
                            if (onInitializationCompleteListener != null) {
                                zzbaq.zzaag.post(new zzyv(this, onInitializationCompleteListener));
                            }
                        }
                    } catch (RemoteException e) {
                        zzbba.zzd("MobileAdsSettingManager initialization failed", e);
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            }
        }
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (this.lock) {
            if (this.zzcjs != null) {
                RewardedVideoAd rewardedVideoAd = this.zzcjs;
                return rewardedVideoAd;
            }
            zzaty zzaty = new zzaty(context, (zzatj) new zzwe(zzwg.zzpt(), context, new zzamo()).zzd(context, false));
            this.zzcjs = zzaty;
            return zzaty;
        }
    }

    public final void setAppVolume(float f) {
        boolean z = true;
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.lock) {
            if (this.zzcjr == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzcjr.setAppVolume(f);
            } catch (RemoteException e) {
                zzbba.zzc("Unable to set app volume.", e);
            }
        }
    }

    public final float zzqc() {
        float f;
        synchronized (this.lock) {
            f = 1.0f;
            if (this.zzcjr == null) {
                return 1.0f;
            }
            try {
                f = this.zzcjr.zzqc();
            } catch (RemoteException e) {
                zzbba.zzc("Unable to get app volume.", e);
            }
        }
        return f;
    }

    public final void setAppMuted(boolean z) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzcjr != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzcjr.setAppMuted(z);
            } catch (RemoteException e) {
                zzbba.zzc("Unable to set app mute state.", e);
            }
        }
    }

    public final boolean zzqd() {
        boolean z;
        synchronized (this.lock) {
            z = false;
            if (this.zzcjr == null) {
                return false;
            }
            try {
                z = this.zzcjr.zzqd();
            } catch (RemoteException e) {
                zzbba.zzc("Unable to get app mute state.", e);
            }
        }
        return z;
    }

    public final void openDebugMenu(Context context, String str) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzcjr != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzcjr.zzb(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                zzbba.zzc("Unable to open debug menu.", e);
            }
        }
    }

    public final String getVersionString() {
        String zzhg;
        synchronized (this.lock) {
            Preconditions.checkState(this.zzcjr != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzhg = zzdsi.zzhg(this.zzcjr.getVersionString());
            } catch (RemoteException e) {
                zzbba.zzc("Unable to get version string.", e);
                return "";
            }
        }
        return zzhg;
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        synchronized (this.lock) {
            try {
                this.zzcjr.zzch(cls.getCanonicalName());
            } catch (RemoteException e) {
                zzbba.zzc("Unable to register RtbAdapter", e);
            }
        }
    }

    public final InitializationStatus getInitializationStatus() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzcjr != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                if (this.zzcju != null) {
                    InitializationStatus initializationStatus = this.zzcju;
                    return initializationStatus;
                }
                InitializationStatus zzd = zzd(this.zzcjr.zzqe());
                return zzd;
            } catch (RemoteException unused) {
                zzbba.zzfb("Unable to get Initialization status.");
                return null;
            }
        }
    }

    public final void disableMediationAdapterInitialization(Context context) {
        synchronized (this.lock) {
            zzg(context);
            try {
                this.zzcjr.zzqf();
            } catch (RemoteException unused) {
                zzbba.zzfb("Unable to disable mediation adapter initialization.");
            }
        }
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzd(List<zzaic> list) {
        HashMap hashMap = new HashMap();
        for (zzaic zzaic : list) {
            hashMap.put(zzaic.zzder, new zzaik(zzaic.zzdes ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzaic.description, zzaic.zzdet));
        }
        return new zzain(hashMap);
    }

    public final RequestConfiguration getRequestConfiguration() {
        return this.zzcjt;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRequestConfiguration(com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.zzcjt     // Catch:{ all -> 0x0030 }
            r4.zzcjt = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzxm r2 = r4.zzcjr     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.zza(r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyt.setRequestConfiguration(com.google.android.gms.ads.RequestConfiguration):void");
    }

    private final void zza(RequestConfiguration requestConfiguration) {
        try {
            this.zzcjr.zza(new zzzu(requestConfiguration));
        } catch (RemoteException e) {
            zzbba.zzc("Unable to set request configuration parcel.", e);
        }
    }

    private final void zzg(Context context) {
        if (this.zzcjr == null) {
            this.zzcjr = (zzxm) new zzvz(zzwg.zzpt(), context).zzd(context, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzcju);
    }
}
