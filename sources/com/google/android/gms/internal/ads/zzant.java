package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzant extends zzane {
    private final NativeContentAdMapper zzdkq;

    public zzant(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdkq = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final zzadl zzsd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final IObjectWrapper zzse() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final String getHeadline() {
        return this.zzdkq.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdkq.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadf(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final String getBody() {
        return this.zzdkq.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final zzadt zzsf() {
        NativeAd.Image logo = this.zzdkq.getLogo();
        if (logo != null) {
            return new zzadf(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final String getCallToAction() {
        return this.zzdkq.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final String getAdvertiser() {
        return this.zzdkq.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final void recordImpression() {
        this.zzdkq.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdkq.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdkq.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdkq.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdkq.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final boolean getOverrideImpressionRecording() {
        return this.zzdkq.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final boolean getOverrideClickHandling() {
        return this.zzdkq.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final Bundle getExtras() {
        return this.zzdkq.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final IObjectWrapper zztv() {
        View adChoicesContent = this.zzdkq.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final zzyi getVideoController() {
        if (this.zzdkq.getVideoController() != null) {
            return this.zzdkq.getVideoController().zzdu();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanf
    public final IObjectWrapper zztw() {
        View zzacy = this.zzdkq.zzacy();
        if (zzacy == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzacy);
    }
}
