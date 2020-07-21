package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzadd extends RelativeLayout {
    private static final float[] zzdcb = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzdcc;

    public zzadd(Context context, zzada zzada, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzada);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzdcb, null, null));
        shapeDrawable.getPaint().setColor(zzada.getBackgroundColor());
        setLayoutParams(layoutParams);
        zzq.zzky();
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzada.getText())) {
            ViewGroup.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzada.getText());
            textView.setTextColor(zzada.getTextColor());
            textView.setTextSize((float) zzada.getTextSize());
            zzwg.zzps();
            int zzc = zzbaq.zzc(context, 4);
            zzwg.zzps();
            textView.setPadding(zzc, 0, zzbaq.zzc(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzadf> zzru = zzada.zzru();
        if (zzru != null && zzru.size() > 1) {
            this.zzdcc = new AnimationDrawable();
            for (zzadf zzadf : zzru) {
                try {
                    this.zzdcc.addFrame((Drawable) ObjectWrapper.unwrap(zzadf.zzry()), zzada.zzrv());
                } catch (Exception e) {
                    zzaxv.zzc("Error while getting drawable.", e);
                }
            }
            zzq.zzky();
            imageView.setBackground(this.zzdcc);
        } else if (zzru.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(zzru.get(0).zzry()));
            } catch (Exception e2) {
                zzaxv.zzc("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzdcc;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
