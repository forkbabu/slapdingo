package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzaas implements zzacz {
    private final /* synthetic */ zzaar zzcle;

    zzaas(zzaar zzaar) {
        this.zzcle = zzaar;
    }

    @Override // com.google.android.gms.internal.ads.zzacz
    public final Boolean zze(String str, boolean z) {
        return Boolean.valueOf(this.zzcle.zzclb.getBoolean(str, z));
    }

    @Override // com.google.android.gms.internal.ads.zzacz
    public final Long getLong(String str, long j) {
        try {
            return Long.valueOf(this.zzcle.zzclb.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.zzcle.zzclb.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacz
    public final Double zza(String str, double d) {
        return Double.valueOf((double) this.zzcle.zzclb.getFloat(str, (float) d));
    }

    @Override // com.google.android.gms.internal.ads.zzacz
    public final String get(String str, String str2) {
        return this.zzcle.zzclb.getString(str, str2);
    }
}
