package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcb implements zzela<zzdbz> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzdki> zzglc;

    private zzdcb(zzelj<zzdvi> zzelj, zzelj<zzdki> zzelj2) {
        this.zzerc = zzelj;
        this.zzglc = zzelj2;
    }

    public static zzdcb zzbc(zzelj<zzdvi> zzelj, zzelj<zzdki> zzelj2) {
        return new zzdcb(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdbz(this.zzerc.get(), this.zzglc.get());
    }
}
