package com.google.android.gms.internal.vision;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzjs implements ListIterator<String> {
    private ListIterator<String> zzaba = this.zzabc.zzabd.listIterator(this.zzabb);
    private final /* synthetic */ int zzabb;
    private final /* synthetic */ zzjt zzabc;

    zzjs(zzjt zzjt, int i) {
        this.zzabc = zzjt;
        this.zzabb = i;
    }

    public final boolean hasNext() {
        return this.zzaba.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzaba.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzaba.nextIndex();
    }

    public final int previousIndex() {
        return this.zzaba.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzaba.previous();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.zzaba.next();
    }
}
