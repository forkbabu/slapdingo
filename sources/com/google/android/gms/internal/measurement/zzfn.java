package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzfn<E> extends zzeq<E> {
    static final zzeq<Object> zza = new zzfn(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzfn(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzf() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return false;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final Object[] zze() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzg() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer, com.google.android.gms.internal.measurement.zzeq
    public final int zzb(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdq.zza(i, this.zzc);
        return this.zzb[i];
    }
}
