package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzdrd;
    private String zzepu;
    private List<NativeAd.Image> zzepv;
    private String zzepx;
    private NativeAd.Image zzepz;
    private double zzeqa;
    private String zzeqb;
    private String zzeqc;

    public final void setHeadline(String str) {
        this.zzepu = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzepv = list;
    }

    public final void setBody(String str) {
        this.zzdrd = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzepz = image;
    }

    public final void setCallToAction(String str) {
        this.zzepx = str;
    }

    public final void setStarRating(double d) {
        this.zzeqa = d;
    }

    public final void setStore(String str) {
        this.zzeqb = str;
    }

    public final void setPrice(String str) {
        this.zzeqc = str;
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

    public final NativeAd.Image getIcon() {
        return this.zzepz;
    }

    public final String getCallToAction() {
        return this.zzepx;
    }

    public final double getStarRating() {
        return this.zzeqa;
    }

    public final String getStore() {
        return this.zzeqb;
    }

    public final String getPrice() {
        return this.zzeqc;
    }
}
