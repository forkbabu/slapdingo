package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdsu<E> extends zzdsn<E> {
    private final zzdss<E> zzhlv;

    zzdsu(zzdss<E> zzdss, int i) {
        super(zzdss.size(), i);
        this.zzhlv = zzdss;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdsn
    public final E get(int i) {
        return this.zzhlv.get(i);
    }
}
