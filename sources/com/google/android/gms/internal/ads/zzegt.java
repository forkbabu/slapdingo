package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzegt extends zzeel<String> implements zzegw, RandomAccess {
    private static final zzegt zzifx;
    private static final zzegw zzify = zzifx;
    private final List<Object> zzifz;

    public zzegt() {
        this(10);
    }

    public zzegt(int i) {
        this(new ArrayList(i));
    }

    private zzegt(ArrayList<Object> arrayList) {
        this.zzifz = arrayList;
    }

    public final int size() {
        return this.zzifz.size();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.ads.zzeel
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbda();
        if (collection instanceof zzegw) {
            collection = ((zzegw) collection).zzbgg();
        }
        boolean addAll = this.zzifz.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final void clear() {
        zzbda();
        this.zzifz.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzegw
    public final void zzaj(zzeer zzeer) {
        zzbda();
        this.zzifz.add(zzeer);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzegw
    public final Object zzhd(int i) {
        return this.zzifz.get(i);
    }

    private static String zzal(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeer) {
            return ((zzeer) obj).zzbdc();
        }
        return zzegd.zzz((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzegw
    public final List<?> zzbgg() {
        return Collections.unmodifiableList(this.zzifz);
    }

    @Override // com.google.android.gms.internal.ads.zzegw
    public final zzegw zzbgh() {
        return zzbcy() ? new zzeje(this) : this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ String set(int i, String str) {
        zzbda();
        return zzal(this.zzifz.set(i, str));
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.ads.zzeel
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.ads.zzeel
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // java.util.List, com.google.android.gms.internal.ads.zzeel
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ String remove(int i) {
        zzbda();
        Object remove = this.zzifz.remove(i);
        this.modCount++;
        return zzal(remove);
    }

    @Override // com.google.android.gms.internal.ads.zzeel, com.google.android.gms.internal.ads.zzegm
    public final /* bridge */ /* synthetic */ boolean zzbcy() {
        return super.zzbcy();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ void add(int i, String str) {
        zzbda();
        this.zzifz.add(i, str);
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* bridge */ /* synthetic */ boolean add(String str) {
        return super.add(str);
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzegm
    public final /* synthetic */ zzegm zzfs(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzifz);
            return new zzegt(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzifz.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeer) {
            zzeer zzeer = (zzeer) obj;
            String zzbdc = zzeer.zzbdc();
            if (zzeer.zzbdd()) {
                this.zzifz.set(i, zzbdc);
            }
            return zzbdc;
        }
        byte[] bArr = (byte[]) obj;
        String zzz = zzegd.zzz(bArr);
        if (zzegd.zzy(bArr)) {
            this.zzifz.set(i, zzz);
        }
        return zzz;
    }

    static {
        zzegt zzegt = new zzegt();
        zzifx = zzegt;
        zzegt.zzbcz();
    }
}
