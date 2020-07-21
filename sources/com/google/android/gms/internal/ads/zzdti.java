package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdti<E> extends zzdsz<E> {
    static final zzdti<Object> zzhmn = new zzdti<>(new Object[0], 0, null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzahp;
    private final transient Object[] zzhmo;
    private final transient Object[] zzhmp;

    zzdti(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzhmo = objArr;
        this.zzhmp = objArr2;
        this.mask = i2;
        this.zzahp = i;
        this.size = i3;
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

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsz
    public final boolean zzawr() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean contains(@NullableDecl Object obj) {
        int i;
        Object[] objArr = this.zzhmp;
        if (obj == null || objArr == null) {
            return false;
        }
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        int zzek = zzdso.zzek(i);
        while (true) {
            int i2 = zzek & this.mask;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzek = i2 + 1;
        }
    }

    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final zzdtn<E> zzawg() {
        return (zzdtn) zzawk().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final Object[] zzawh() {
        return this.zzhmo;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zzawj() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhmo, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsz
    public final zzdss<E> zzaws() {
        return zzdss.zzb(this.zzhmo, this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzdsz
    public final int hashCode() {
        return this.zzahp;
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.ads.zzdsr, java.util.Collection, java.util.Set, java.lang.Iterable, com.google.android.gms.internal.ads.zzdsz
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
