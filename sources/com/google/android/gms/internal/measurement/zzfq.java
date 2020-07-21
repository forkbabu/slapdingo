package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzfq extends zzeq<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzfq(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdq.zza(i, this.zzc);
        return this.zza[(i * 2) + this.zzb];
    }

    public final int size() {
        return this.zzc;
    }
}
