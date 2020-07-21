package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdrj extends Exception {
    private final int zzhjr;

    public zzdrj(int i, String str) {
        super(str);
        this.zzhjr = i;
    }

    public zzdrj(int i, Throwable th) {
        super(th);
        this.zzhjr = i;
    }

    public final int zzavz() {
        return this.zzhjr;
    }
}
