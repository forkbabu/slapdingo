package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfr implements zzela<zzdfp> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzawz> zzesg;
    private final zzelj<String> zzfqz;

    public zzdfr(zzelj<zzawz> zzelj, zzelj<zzdvi> zzelj2, zzelj<String> zzelj3) {
        this.zzesg = zzelj;
        this.zzerc = zzelj2;
        this.zzfqz = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdfp(this.zzesg.get(), this.zzerc.get(), this.zzfqz.get());
    }
}
