package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzdn<E> extends zzdk<E> {
    static final zzdk<Object> zzmg = new zzdn(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzmh;

    zzdn(Object[] objArr, int i) {
        this.zzmh = objArr;
        this.size = i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final int zzcb() {
        return 0;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final Object[] zzca() {
        return this.zzmh;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final int zzcc() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdk, com.google.android.gms.internal.vision.zzdh
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzmh, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzcy.zzd(i, this.size);
        return this.zzmh[i];
    }
}
