package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzafu extends UnifiedNativeAd {
    private final VideoController zzcjk = new VideoController();
    private final List<NativeAd.Image> zzdcm = new ArrayList();
    private final zzadu zzdcn;
    private final NativeAd.AdChoicesInfo zzdco;
    private final zzaft zzdcu;
    private final List<MuteThisAdReason> zzdcv = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[Catch:{ RemoteException -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzafu(com.google.android.gms.internal.ads.zzaft r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdcm = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzcjk = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdcv = r1
            r5.zzdcu = r6
            r1 = 0
            java.util.List r6 = r6.getImages()     // Catch:{ RemoteException -> 0x005a }
            if (r6 == 0) goto L_0x005e
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x005a }
        L_0x0027:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x005e
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x005a }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005a }
            if (r3 == 0) goto L_0x004c
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005a }
            if (r2 == 0) goto L_0x004c
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005a }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzadt     // Catch:{ RemoteException -> 0x005a }
            if (r4 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzadt r3 = (com.google.android.gms.internal.ads.zzadt) r3     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004d
        L_0x0046:
            com.google.android.gms.internal.ads.zzadv r3 = new com.google.android.gms.internal.ads.zzadv     // Catch:{ RemoteException -> 0x005a }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x004d
        L_0x004c:
            r3 = r1
        L_0x004d:
            if (r3 == 0) goto L_0x0027
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzdcm     // Catch:{ RemoteException -> 0x005a }
            com.google.android.gms.internal.ads.zzadu r4 = new com.google.android.gms.internal.ads.zzadu     // Catch:{ RemoteException -> 0x005a }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x005a }
            r2.add(r4)     // Catch:{ RemoteException -> 0x005a }
            goto L_0x0027
        L_0x005a:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbba.zzc(r0, r6)
        L_0x005e:
            com.google.android.gms.internal.ads.zzaft r6 = r5.zzdcu     // Catch:{ RemoteException -> 0x008d }
            java.util.List r6 = r6.getMuteThisAdReasons()     // Catch:{ RemoteException -> 0x008d }
            if (r6 == 0) goto L_0x0091
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x008d }
        L_0x006a:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x008d }
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x008d }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x008d }
            if (r3 == 0) goto L_0x007f
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzxt r2 = com.google.android.gms.internal.ads.zzxw.zzg(r2)     // Catch:{ RemoteException -> 0x008d }
            goto L_0x0080
        L_0x007f:
            r2 = r1
        L_0x0080:
            if (r2 == 0) goto L_0x006a
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzdcv     // Catch:{ RemoteException -> 0x008d }
            com.google.android.gms.internal.ads.zzxy r4 = new com.google.android.gms.internal.ads.zzxy     // Catch:{ RemoteException -> 0x008d }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x008d }
            r3.add(r4)     // Catch:{ RemoteException -> 0x008d }
            goto L_0x006a
        L_0x008d:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbba.zzc(r0, r6)
        L_0x0091:
            com.google.android.gms.internal.ads.zzaft r6 = r5.zzdcu     // Catch:{ RemoteException -> 0x009f }
            com.google.android.gms.internal.ads.zzadt r6 = r6.zzsc()     // Catch:{ RemoteException -> 0x009f }
            if (r6 == 0) goto L_0x00a3
            com.google.android.gms.internal.ads.zzadu r2 = new com.google.android.gms.internal.ads.zzadu     // Catch:{ RemoteException -> 0x009f }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x009f }
            goto L_0x00a4
        L_0x009f:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbba.zzc(r0, r6)
        L_0x00a3:
            r2 = r1
        L_0x00a4:
            r5.zzdcn = r2
            com.google.android.gms.internal.ads.zzaft r6 = r5.zzdcu     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzadl r6 = r6.zzsd()     // Catch:{ RemoteException -> 0x00bb }
            if (r6 == 0) goto L_0x00bf
            com.google.android.gms.internal.ads.zzadm r6 = new com.google.android.gms.internal.ads.zzadm     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzaft r2 = r5.zzdcu     // Catch:{ RemoteException -> 0x00bb }
            com.google.android.gms.internal.ads.zzadl r2 = r2.zzsd()     // Catch:{ RemoteException -> 0x00bb }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00bb }
            r1 = r6
            goto L_0x00bf
        L_0x00bb:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbba.zzc(r0, r6)
        L_0x00bf:
            r5.zzdco = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafu.<init>(com.google.android.gms.internal.ads.zzaft):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzsb */
    public final IObjectWrapper zzjr() {
        try {
            return this.zzdcu.zzsb();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzjw() {
        try {
            IObjectWrapper zzse = this.zzdcu.zzse();
            if (zzse != null) {
                return ObjectWrapper.unwrap(zzse);
            }
            return null;
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdcu.performClick(bundle);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdcu.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdcu.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.zzdcu.getHeadline();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdcm;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.zzdcu.getBody();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.zzdcn;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.zzdcu.getCallToAction();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdcu.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.zzdcu.getStore();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.zzdcu.getPrice();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdcu.getVideoController() != null) {
                this.zzcjk.zza(this.zzdcu.getVideoController());
            }
        } catch (RemoteException e) {
            zzbba.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcjk;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdco;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.zzdcu.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzdcu.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzdcu.zzsm();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzdcu.isCustomClickGestureEnabled();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzdcu.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdcv;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdcu.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.zzdcu.destroy();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdcu.zza(new zzagg(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzbba.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbba.zzfb("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzdcu.zza((zzxt) null);
            } else if (muteThisAdReason instanceof zzxy) {
                this.zzdcu.zza(((zzxy) muteThisAdReason).zzqh());
            } else {
                zzbba.zzfb("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdcu.zza(new zzxu(muteThisAdListener));
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzdcu.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzbba.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.zzdcu.getAdvertiser();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final MediaContent getMediaContent() {
        try {
            if (this.zzdcu.zzsn() != null) {
                return new zzzc(this.zzdcu.zzsn());
            }
            return null;
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final ResponseInfo getResponseInfo() {
        zzyd zzyd;
        try {
            zzyd = this.zzdcu.zzkj();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            zzyd = null;
        }
        return ResponseInfo.zza(zzyd);
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdcu.zza(new zzzv(onPaidEventListener));
        } catch (RemoteException e) {
            zzbba.zzc("Failed to setOnPaidEventListener", e);
        }
    }
}
