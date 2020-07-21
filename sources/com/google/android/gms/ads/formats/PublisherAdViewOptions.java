package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzafm;
import com.google.android.gms.internal.ads.zzafn;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzxd;
import com.google.android.gms.internal.ads.zzxe;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    private final boolean zzbnr;
    private final zzxe zzbns;
    private AppEventListener zzbnt;
    private final IBinder zzbnu;

    private PublisherAdViewOptions(Builder builder) {
        this.zzbnr = builder.zzbnr;
        AppEventListener zzb = builder.zzbnt;
        this.zzbnt = zzb;
        zzzy zzzy = null;
        this.zzbns = zzb != null ? new zzvl(this.zzbnt) : null;
        this.zzbnu = builder.zzbnv != null ? new zzzy(builder.zzbnv) : zzzy;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbnr = false;
        /* access modifiers changed from: private */
        public AppEventListener zzbnt;
        /* access modifiers changed from: private */
        public ShouldDelayBannerRenderingListener zzbnv;

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbnr = z;
            return this;
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzbnt = appEventListener;
            return this;
        }

        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzbnv = shouldDelayBannerRenderingListener;
            return this;
        }

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }
    }

    PublisherAdViewOptions(boolean z, IBinder iBinder, IBinder iBinder2) {
        this.zzbnr = z;
        this.zzbns = iBinder != null ? zzxd.zze(iBinder) : null;
        this.zzbnu = iBinder2;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnt;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbnr;
    }

    public final zzxe zzju() {
        return this.zzbns;
    }

    public final zzafn zzjv() {
        return zzafm.zzy(this.zzbnu);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzxe zzxe = this.zzbns;
        SafeParcelWriter.writeIBinder(parcel, 2, zzxe == null ? null : zzxe.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzbnu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
