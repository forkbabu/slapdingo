package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbsc implements zzela<String> {
    private final zzelj<zzbqk> zzexq;
    private final zzbrx zzfrj;

    private zzbsc(zzbrx zzbrx, zzelj<zzbqk> zzelj) {
        this.zzfrj = zzbrx;
        this.zzexq = zzelj;
    }

    public static zzbsc zzb(zzbrx zzbrx, zzelj<zzbqk> zzelj) {
        return new zzbsc(zzbrx, zzelj);
    }

    public static String zza(zzbrx zzbrx, zzbqk zzbqk) {
        return (String) zzelg.zza(zzbqk.zzvx(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfrj, this.zzexq.get());
    }
}
