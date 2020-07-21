package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbyr implements zzela<zzbyo> {
    private final zzelj<zzdpd> zzfbe;
    private final zzelj<zzdkk> zzfkx;

    private zzbyr(zzelj<zzdkk> zzelj, zzelj<zzdpd> zzelj2) {
        this.zzfkx = zzelj;
        this.zzfbe = zzelj2;
    }

    public static zzbyr zzu(zzelj<zzdkk> zzelj, zzelj<zzdpd> zzelj2) {
        return new zzbyr(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbyo(this.zzfkx.get(), this.zzfbe.get());
    }
}
