package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzdj<E> extends zzdg<E> {
    private final zzdk<E> zzlz;

    zzdj(zzdk<E> zzdk, int i) {
        super(zzdk.size(), i);
        this.zzlz = zzdk;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzdg
    public final E get(int i) {
        return this.zzlz.get(i);
    }
}
