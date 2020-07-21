package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzbaq;
import com.google.android.gms.internal.ads.zzwg;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzq extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzdom;
    private final zzy zzdon;

    public zzq(Context context, zzp zzp, zzy zzy) {
        super(context);
        this.zzdon = zzy;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zzdom = imageButton;
        imageButton.setImageResource(17301527);
        this.zzdom.setBackgroundColor(0);
        this.zzdom.setOnClickListener(this);
        ImageButton imageButton2 = this.zzdom;
        zzwg.zzps();
        int zzc = zzbaq.zzc(context, zzp.paddingLeft);
        zzwg.zzps();
        int zzc2 = zzbaq.zzc(context, 0);
        zzwg.zzps();
        int zzc3 = zzbaq.zzc(context, zzp.paddingRight);
        zzwg.zzps();
        imageButton2.setPadding(zzc, zzc2, zzc3, zzbaq.zzc(context, zzp.paddingBottom));
        this.zzdom.setContentDescription("Interstitial close button");
        ImageButton imageButton3 = this.zzdom;
        zzwg.zzps();
        int zzc4 = zzbaq.zzc(context, zzp.size + zzp.paddingLeft + zzp.paddingRight);
        zzwg.zzps();
        addView(imageButton3, new FrameLayout.LayoutParams(zzc4, zzbaq.zzc(context, zzp.size + zzp.paddingBottom), 17));
    }

    public final void onClick(View view) {
        zzy zzy = this.zzdon;
        if (zzy != null) {
            zzy.zzuk();
        }
    }

    public final void zzal(boolean z) {
        if (z) {
            this.zzdom.setVisibility(8);
        } else {
            this.zzdom.setVisibility(0);
        }
    }
}
