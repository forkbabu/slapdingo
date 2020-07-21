package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdcx implements zzela<zzdcy> {
    private final zzelj<String> zzgdu;

    private zzdcx(zzelj<String> zzelj) {
        this.zzgdu = zzelj;
    }

    public static zzdcx zzap(zzelj<String> zzelj) {
        return new zzdcx(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdcy(this.zzgdu.get());
    }
}
