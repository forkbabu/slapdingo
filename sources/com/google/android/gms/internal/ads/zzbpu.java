package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbpu implements zzela<zzbpv> {
    private final zzelj<zzbtl> zzeuo;

    private zzbpu(zzelj<zzbtl> zzelj) {
        this.zzeuo = zzelj;
    }

    public static zzbpu zze(zzelj<zzbtl> zzelj) {
        return new zzbpu(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbpv(this.zzeuo.get());
    }
}
