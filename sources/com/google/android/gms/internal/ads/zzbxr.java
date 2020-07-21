package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxr implements zzela<zzbxa> {
    private final zzbxa zzftd;

    private zzbxr(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxr zzx(zzbxa zzbxa) {
        return new zzbxr(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        zzbxa zzbxa = this.zzftd;
        if (zzbxa != null) {
            return (zzbxa) zzelg.zza(zzbxa, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
