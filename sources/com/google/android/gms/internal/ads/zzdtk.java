package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdtk<E> extends zzdsz<E> {
    private final transient E zzhmq;
    private transient int zzhmr;

    zzdtk(E e) {
        this.zzhmq = zzdsh.checkNotNull(e);
    }

    public final int size() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean zzawl() {
        return false;
    }

    zzdtk(E e, int i) {
        this.zzhmq = e;
        this.zzhmr = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean contains(Object obj) {
        return this.zzhmq.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final zzdtn<E> zzawg() {
        return new zzdtb(this.zzhmq);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsz
    public final zzdss<E> zzaws() {
        return zzdss.zzac(this.zzhmq);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zzhmq;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzdsz
    public final int hashCode() {
        int i = this.zzhmr;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzhmq.hashCode();
        this.zzhmr = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsz
    public final boolean zzawr() {
        return this.zzhmr != 0;
    }

    public final String toString() {
        String obj = this.zzhmq.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.ads.zzdsr, java.util.Collection, java.util.Set, java.lang.Iterable, com.google.android.gms.internal.ads.zzdsz
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
