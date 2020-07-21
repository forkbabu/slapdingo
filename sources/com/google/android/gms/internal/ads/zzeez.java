package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeez {
    private final byte[] buffer;
    private final zzefl zziaa;

    private zzeez(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zziaa = zzefl.zzw(bArr);
    }

    public final zzeer zzbdk() {
        this.zziaa.zzben();
        return new zzefb(this.buffer);
    }

    public final zzefl zzbdl() {
        return this.zziaa;
    }

    /* synthetic */ zzeez(int i, zzeeq zzeeq) {
        this(i);
    }
}
