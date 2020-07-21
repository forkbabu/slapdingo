package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class UnifiedNativeAdMapper {
    private Bundle extras = new Bundle();
    private VideoController zzcjk;
    private String zzdrd;
    private View zzeps;
    private boolean zzept;
    private String zzepu;
    private List<NativeAd.Image> zzepv;
    private String zzepx;
    private String zzepy;
    private NativeAd.Image zzepz;
    private String zzeqb;
    private String zzeqc;
    private Double zzeqg;
    private View zzeqh;
    private Object zzeqi;
    private boolean zzeqj;
    private boolean zzeqk;
    private float zzeql;

    public float getCurrentTime() {
        return 0.0f;
    }

    public float getDuration() {
        return 0.0f;
    }

    public void handleClick(View view) {
    }

    public void recordImpression() {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

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

    public final void setAdvertiser(String str) {
        this.zzepy = str;
    }

    public final void setStarRating(Double d) {
        this.zzeqg = d;
    }

    public final void setStore(String str) {
        this.zzeqb = str;
    }

    public final void setPrice(String str) {
        this.zzeqc = str;
    }

    public final void zza(VideoController videoController) {
        this.zzcjk = videoController;
    }

    public void setHasVideoContent(boolean z) {
        this.zzept = z;
    }

    public void setAdChoicesContent(View view) {
        this.zzeqh = view;
    }

    public void setMediaView(View view) {
        this.zzeps = view;
    }

    public void setMediaContentAspectRatio(float f) {
        this.zzeql = f;
    }

    public final void zzn(Object obj) {
        this.zzeqi = obj;
    }

    public final void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.zzeqj = z;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.zzeqk = z;
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

    public final String getAdvertiser() {
        return this.zzepy;
    }

    public final Double getStarRating() {
        return this.zzeqg;
    }

    public final String getStore() {
        return this.zzeqb;
    }

    public final String getPrice() {
        return this.zzeqc;
    }

    public final VideoController getVideoController() {
        return this.zzcjk;
    }

    public boolean hasVideoContent() {
        return this.zzept;
    }

    public View getAdChoicesContent() {
        return this.zzeqh;
    }

    public final View zzacy() {
        return this.zzeps;
    }

    public float getMediaContentAspectRatio() {
        return this.zzeql;
    }

    public final Object zzjw() {
        return this.zzeqi;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzeqj;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzeqk;
    }
}
