package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeky<T> implements zzela<T> {
    private zzelj<T> zzipu;

    @Override // com.google.android.gms.internal.ads.zzelj
    public final T get() {
        zzelj<T> zzelj = this.zzipu;
        if (zzelj != null) {
            return zzelj.get();
        }
        throw new IllegalStateException();
    }

    public static <T> void zzbk(zzelj<T> zzelj, zzelj<T> zzelj2) {
        zzelg.checkNotNull(zzelj2);
        zzeky zzeky = (zzeky) zzelj;
        if (zzeky.zzipu == null) {
            zzeky.zzipu = zzelj2;
            return;
        }
        throw new IllegalStateException();
    }
}
