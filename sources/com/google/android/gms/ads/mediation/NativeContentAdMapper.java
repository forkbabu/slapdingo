package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class NativeContentAdMapper extends NativeAdMapper {
    private String zzdrd;
    private String zzepu;
    private List<NativeAd.Image> zzepv;
    private NativeAd.Image zzepw;
    private String zzepx;
    private String zzepy;

    public final void setHeadline(String str) {
        this.zzepu = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzepv = list;
    }

    public final void setBody(String str) {
        this.zzdrd = str;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzepw = image;
    }

    public final void setCallToAction(String str) {
        this.zzepx = str;
    }

    public final void setAdvertiser(String str) {
        this.zzepy = str;
    }

    public final String getHeadline() {
        return this.zzepu;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzepv;
    }

    public final String getBody() {
        return this.zzdrd;
    }

    public final NativeAd.Image getLogo() {
        return this.zzepw;
    }

    public final String getCallToAction() {
        return this.zzepx;
    }

    public final String getAdvertiser() {
        return this.zzepy;
    }
}
