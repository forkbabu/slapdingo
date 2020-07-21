package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzbnf;
    private final int zzbng;
    private final int zzbnh;
    private final boolean zzbni;
    private final int zzbnj;
    private final VideoOptions zzbnk;
    private final boolean zzbnl;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.zzbnf = builder.zzbnf;
        this.zzbng = builder.zzbng;
        this.zzbnh = builder.zzbnh;
        this.zzbni = builder.zzbni;
        this.zzbnj = builder.zzbnj;
        this.zzbnk = builder.zzbnk;
        this.zzbnl = builder.zzbnl;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbnf = false;
        /* access modifiers changed from: private */
        public int zzbng = -1;
        /* access modifiers changed from: private */
        public int zzbnh = 0;
        /* access modifiers changed from: private */
        public boolean zzbni = false;
        /* access modifiers changed from: private */
        public int zzbnj = 1;
        /* access modifiers changed from: private */
        public VideoOptions zzbnk;
        /* access modifiers changed from: private */
        public boolean zzbnl = false;

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzbnf = z;
            return this;
        }

        @Deprecated
        public final Builder setImageOrientation(int i) {
            this.zzbng = i;
            return this;
        }

        public final Builder setMediaAspectRatio(int i) {
            this.zzbnh = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzbni = z;
            return this;
        }

        public final Builder setAdChoicesPlacement(int i) {
            this.zzbnj = i;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzbnk = videoOptions;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzbnl = z;
            return this;
        }

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzbnf;
    }

    @Deprecated
    public final int getImageOrientation() {
        return this.zzbng;
    }

    public final int getMediaAspectRatio() {
        return this.zzbnh;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzbni;
    }

    public final int getAdChoicesPlacement() {
        return this.zzbnj;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbnk;
    }

    public final boolean zzjs() {
        return this.zzbnl;
    }
}
