package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.itextpdf.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzans implements NativeMediationAdRequest {
    private final String zzadi;
    private final int zzcgt;
    private final boolean zzche;
    private final int zzdjw;
    private final int zzdjx;
    private final zzadj zzdkn;
    private final List<String> zzdko = new ArrayList();
    private final Map<String, Boolean> zzdkp = new HashMap();
    private final Date zzmx;
    private final Set<String> zzmz;
    private final boolean zzna;
    private final Location zznb;

    public zzans(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzadj zzadj, List<String> list, boolean z2, int i3, String str) {
        this.zzmx = date;
        this.zzcgt = i;
        this.zzmz = set;
        this.zznb = location;
        this.zzna = z;
        this.zzdjw = i2;
        this.zzdkn = zzadj;
        this.zzche = z2;
        this.zzdjx = i3;
        this.zzadi = str;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if (PdfBoolean.TRUE.equals(split[2])) {
                            this.zzdkp.put(split[1], true);
                        } else if (PdfBoolean.FALSE.equals(split[2])) {
                            this.zzdkp.put(split[1], false);
                        }
                    }
                } else {
                    this.zzdko.add(str2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.zzmx;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.zzcgt;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzmz;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zznb;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzna;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzdjw;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        if (this.zzdkn == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzdkn.zzdcf).setImageOrientation(this.zzdkn.zzbng).setRequestMultipleImages(this.zzdkn.zzbni);
        if (this.zzdkn.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.zzdkn.zzbnj);
        }
        if (this.zzdkn.versionCode >= 3 && this.zzdkn.zzdcg != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(this.zzdkn.zzdcg));
        }
        return requestMultipleImages.build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAdMuted() {
        return zzyt.zzqs().zzqd();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final float getAdVolume() {
        return zzyt.zzqs().zzqc();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdko;
        if (list != null) {
            return list.contains(ExifInterface.GPS_MEASUREMENT_2D) || this.zzdko.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdko;
        return list != null && list.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.zzdko;
        if (list != null) {
            return list.contains("1") || this.zzdko.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzua() {
        List<String> list = this.zzdko;
        return list != null && list.contains(ExifInterface.GPS_MEASUREMENT_3D);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzub() {
        return this.zzdkp;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzche;
    }
}
