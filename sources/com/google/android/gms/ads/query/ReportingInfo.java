package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzarh;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class ReportingInfo {
    private final zzarg zzhhf;

    private ReportingInfo(Builder builder) {
        this.zzhhf = new zzarg(builder.zzhhg);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzarh zzhhg;

        public Builder(View view) {
            zzarh zzarh = new zzarh();
            this.zzhhg = zzarh;
            zzarh.zzk(view);
        }

        public final Builder setAssetViews(Map<String, View> map) {
            this.zzhhg.zzh(map);
            return this;
        }

        public final ReportingInfo build() {
            return new ReportingInfo(this);
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzhhf.updateImpressionUrls(list, updateImpressionUrlsCallback);
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzhhf.updateClickUrl(uri, updateClickUrlCallback);
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        this.zzhhf.reportTouchEvent(motionEvent);
    }
}
