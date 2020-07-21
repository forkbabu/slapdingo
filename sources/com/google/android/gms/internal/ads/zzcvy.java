package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvy implements zzela<zzcvw> {
    private final zzcvw zzgoi;

    private zzcvy(zzcvw zzcvw) {
        this.zzgoi = zzcvw;
    }

    public static zzcvy zzc(zzcvw zzcvw) {
        return new zzcvy(zzcvw);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        zzcvw zzcvw = this.zzgoi;
        if (zzcvw != null) {
            return (zzcvw) zzelg.zza(zzcvw, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
