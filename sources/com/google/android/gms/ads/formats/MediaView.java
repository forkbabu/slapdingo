package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzade;
import com.google.android.gms.internal.ads.zzadg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class MediaView extends FrameLayout {
    private MediaContent zzbmz;
    private boolean zzbna;
    private zzade zzbnb;
    private ImageView.ScaleType zzbnc;
    private boolean zzbnd;
    private zzadg zzbne;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzbna = true;
        this.zzbmz = mediaContent;
        zzade zzade = this.zzbnb;
        if (zzade != null) {
            zzade.setMediaContent(mediaContent);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzade zzade) {
        this.zzbnb = zzade;
        if (this.zzbna) {
            zzade.setMediaContent(this.zzbmz);
        }
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbnd = true;
        this.zzbnc = scaleType;
        zzadg zzadg = this.zzbne;
        if (zzadg != null) {
            zzadg.setImageScaleType(scaleType);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzadg zzadg) {
        this.zzbne = zzadg;
        if (this.zzbnd) {
            zzadg.setImageScaleType(this.zzbnc);
        }
    }
}
