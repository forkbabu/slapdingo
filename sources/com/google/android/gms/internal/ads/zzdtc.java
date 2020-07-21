package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdtc<E> extends zzdss<E> {
    static final zzdss<Object> zzhmf = new zzdtc(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzhmg;

    zzdtc(Object[] objArr, int i) {
        this.zzhmg = objArr;
        this.size = i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zzawi() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean zzawl() {
        return false;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final Object[] zzawh() {
        return this.zzhmg;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zzawj() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdss, com.google.android.gms.internal.ads.zzdsr
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhmg, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdsh.zzs(i, this.size);
        return this.zzhmg[i];
    }
}
