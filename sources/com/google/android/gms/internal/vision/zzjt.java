package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzjt extends AbstractList<String> implements zzho, RandomAccess {
    /* access modifiers changed from: private */
    public final zzho zzabd;

    public zzjt(zzho zzho) {
        this.zzabd = zzho;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final zzho zzgz() {
        return this;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final Object getRaw(int i) {
        return this.zzabd.getRaw(i);
    }

    public final int size() {
        return this.zzabd.size();
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final void zzc(zzfm zzfm) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new zzjs(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzjv(this);
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final List<?> zzgy() {
        return this.zzabd.zzgy();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.zzabd.get(i);
    }
}
