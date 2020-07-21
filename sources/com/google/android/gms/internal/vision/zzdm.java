package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzdm extends zzdk<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdk zzmf;

    zzdm(zzdk zzdk, int i, int i2) {
        this.zzmf = zzdk;
        this.offset = i;
        this.length = i2;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final Object[] zzca() {
        return this.zzmf.zzca();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final int zzcb() {
        return this.zzmf.zzcb() + this.offset;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final int zzcc() {
        return this.zzmf.zzcb() + this.offset + this.length;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzcy.zzd(i, this.length);
        return this.zzmf.get(i + this.offset);
    }

    @Override // com.google.android.gms.internal.vision.zzdk
    public final zzdk<E> zzf(int i, int i2) {
        zzcy.zza(i, i2, this.length);
        zzdk zzdk = this.zzmf;
        int i3 = this.offset;
        return (zzdk) zzdk.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List, com.google.android.gms.internal.vision.zzdk
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
