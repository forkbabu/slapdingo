package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzclg implements zzela<zzclh> {
    private final zzelj<String> zzgew;
    private final zzelj<zzclc> zzgex;

    public zzclg(zzelj<String> zzelj, zzelj<zzclc> zzelj2) {
        this.zzgew = zzelj;
        this.zzgex = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzclh(this.zzgew.get(), this.zzgex.get());
    }
}
