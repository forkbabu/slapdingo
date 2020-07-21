package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzhp extends zzfc<String> implements zzho, RandomAccess {
    private static final zzhp zzyq;
    private static final zzho zzyr = zzyq;
    private final List<Object> zzys;

    public zzhp() {
        this(10);
    }

    public zzhp(int i) {
        this(new ArrayList(i));
    }

    private zzhp(ArrayList<Object> arrayList) {
        this.zzys = arrayList;
    }

    public final int size() {
        return this.zzys.size();
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzdr();
        if (collection instanceof zzho) {
            collection = ((zzho) collection).zzgy();
        }
        boolean addAll = this.zzys.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final void clear() {
        zzdr();
        this.zzys.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final void zzc(zzfm zzfm) {
        zzdr();
        this.zzys.add(zzfm);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final Object getRaw(int i) {
        return this.zzys.get(i);
    }

    private static String zzk(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfm) {
            return ((zzfm) obj).zzes();
        }
        return zzgy.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final List<?> zzgy() {
        return Collections.unmodifiableList(this.zzys);
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final zzho zzgz() {
        return zzdp() ? new zzjt(this) : this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ String set(int i, String str) {
        zzdr();
        return zzk(this.zzys.set(i, str));
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ String remove(int i) {
        zzdr();
        Object remove = this.zzys.remove(i);
        this.modCount++;
        return zzk(remove);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, com.google.android.gms.internal.vision.zzhe
    public final /* bridge */ /* synthetic */ boolean zzdp() {
        return super.zzdp();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ void add(int i, String str) {
        zzdr();
        this.zzys.add(i, str);
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection, java.util.AbstractList
    public final /* bridge */ /* synthetic */ boolean add(String str) {
        return super.add(str);
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe zzah(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzys);
            return new zzhp(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzys.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfm) {
            zzfm zzfm = (zzfm) obj;
            String zzes = zzfm.zzes();
            if (zzfm.zzet()) {
                this.zzys.set(i, zzes);
            }
            return zzes;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzgy.zzh(bArr);
        if (zzgy.zzg(bArr)) {
            this.zzys.set(i, zzh);
        }
        return zzh;
    }

    static {
        zzhp zzhp = new zzhp();
        zzyq = zzhp;
        zzhp.zzdq();
    }
}
