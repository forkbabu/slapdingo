package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzev extends zzeq<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzeq zzc;

    zzev(zzeq zzeq, int i, int i2) {
        this.zzc = zzeq;
        this.zza = i;
        this.zzb = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return true;
    }

    public final int size() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final Object[] zze() {
        return this.zzc.zze();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzf() {
        return this.zzc.zzf() + this.zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzg() {
        return this.zzc.zzf() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdq.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final zzeq<E> zza(int i, int i2) {
        zzdq.zza(i, i2, this.zzb);
        zzeq zzeq = this.zzc;
        int i3 = this.zza;
        return (zzeq) zzeq.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzeq
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
