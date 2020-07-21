package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzeje extends AbstractList<String> implements zzegw, RandomAccess {
    /* access modifiers changed from: private */
    public final zzegw zzijc;

    public zzeje(zzegw zzegw) {
        this.zzijc = zzegw;
    }

    @Override // com.google.android.gms.internal.ads.zzegw
    public final zzegw zzbgh() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzegw
    public final Object zzhd(int i) {
        return this.zzijc.zzhd(i);
    }

    public final int size() {
        return this.zzijc.size();
    }

    @Override // com.google.android.gms.internal.ads.zzegw
    public final void zzaj(zzeer zzeer) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new zzejd(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzejg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzegw
    public final List<?> zzbgg() {
        return this.zzijc.zzbgg();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.zzijc.get(i);
    }
}
