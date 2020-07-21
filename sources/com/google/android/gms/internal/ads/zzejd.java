package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzejd implements ListIterator<String> {
    private final /* synthetic */ int zzhnr;
    private ListIterator<String> zzija = this.zzijb.zzijc.listIterator(this.zzhnr);
    private final /* synthetic */ zzeje zzijb;

    zzejd(zzeje zzeje, int i) {
        this.zzijb = zzeje;
        this.zzhnr = i;
    }

    public final boolean hasNext() {
        return this.zzija.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzija.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzija.nextIndex();
    }

    public final int previousIndex() {
        return this.zzija.previousIndex();
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
        return this.zzija.previous();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.zzija.next();
    }
}
