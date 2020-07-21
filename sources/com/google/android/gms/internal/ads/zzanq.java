package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzanq extends zzand {
    private final NativeAppInstallAdMapper zzdkl;

    public zzanq(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdkl = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzadl zzsd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper zzse() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getHeadline() {
        return this.zzdkl.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdkl.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadf(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getBody() {
        return this.zzdkl.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzadt zzsc() {
        NativeAd.Image icon = this.zzdkl.getIcon();
        if (icon != null) {
            return new zzadf(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getCallToAction() {
        return this.zzdkl.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final double getStarRating() {
        return this.zzdkl.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getStore() {
        return this.zzdkl.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getPrice() {
        return this.zzdkl.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void recordImpression() {
        this.zzdkl.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdkl.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdkl.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdkl.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdkl.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean getOverrideImpressionRecording() {
        return this.zzdkl.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean getOverrideClickHandling() {
        return this.zzdkl.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final Bundle getExtras() {
        return this.zzdkl.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzyi getVideoController() {
        if (this.zzdkl.getVideoController() != null) {
            return this.zzdkl.getVideoController().zzdu();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper zztv() {
        View adChoicesContent = this.zzdkl.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper zztw() {
        View zzacy = this.zzdkl.zzacy();
        if (zzacy == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacy);
    }
}
