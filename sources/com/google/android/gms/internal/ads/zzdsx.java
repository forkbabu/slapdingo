package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdsx extends zzdss<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdss zzhma;

    zzdsx(zzdss zzdss, int i, int i2) {
        this.zzhma = zzdss;
        this.offset = i;
        this.length = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean zzawl() {
        return true;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final Object[] zzawh() {
        return this.zzhma.zzawh();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zzawi() {
        return this.zzhma.zzawi() + this.offset;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zzawj() {
        return this.zzhma.zzawi() + this.offset + this.length;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdsh.zzs(i, this.length);
        return this.zzhma.get(i + this.offset);
    }

    @Override // com.google.android.gms.internal.ads.zzdss
    public final zzdss<E> zzu(int i, int i2) {
        zzdsh.zzf(i, i2, this.length);
        zzdss zzdss = this.zzhma;
        int i3 = this.offset;
        return (zzdss) zzdss.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List, com.google.android.gms.internal.ads.zzdss
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
