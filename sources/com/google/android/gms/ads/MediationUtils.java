package com.google.android.gms.ads;

import android.content.Context;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    public static AdSize findClosestSize(Context context, AdSize adSize, List<AdSize> list) {
        AdSize adSize2 = null;
        if (!(list == null || adSize == null)) {
            if (!adSize.zzds()) {
                float f = context.getResources().getDisplayMetrics().density;
                adSize = new AdSize(Math.round(((float) adSize.getWidthInPixels(context)) / f), Math.round(((float) adSize.getHeightInPixels(context)) / f));
            }
            for (AdSize adSize3 : list) {
                boolean z = false;
                if (adSize3 != null) {
                    int width = adSize.getWidth();
                    int width2 = adSize3.getWidth();
                    int height = adSize.getHeight();
                    int height2 = adSize3.getHeight();
                    if (((double) width) * MIN_WIDTH_RATIO <= ((double) width2) && width >= width2 && (!adSize.zzds() ? !(((double) height) * MIN_HEIGHT_RATIO > ((double) height2) || height < height2) : adSize.zzdt() >= height2)) {
                        z = true;
                    }
                }
                if (z && (adSize2 == null || adSize2.getWidth() * adSize2.getHeight() <= adSize3.getWidth() * adSize3.getHeight())) {
                    adSize2 = adSize3;
                }
            }
        }
        return adSize2;
    }
}
