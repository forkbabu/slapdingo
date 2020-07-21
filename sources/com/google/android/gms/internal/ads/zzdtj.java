package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdtj extends zzdss<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzhmi;

    zzdtj(Object[] objArr, int i, int i2) {
        this.zzhmi = objArr;
        this.offset = i;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean zzawl() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdsh.zzs(i, this.size);
        return this.zzhmi[(i * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }
}
