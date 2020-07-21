package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
public final class zzir extends zzgn<String> implements zziu, RandomAccess {
    private static final zzir zza;
    private static final zziu zzb = zza;
    private final List<Object> zzc;

    public zzir() {
        this(10);
    }

    public zzir(int i) {
        this(new ArrayList(i));
    }

    private zzir(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final int size() {
        return this.zzc.size();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.measurement.zzgn
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.measurement.zzgn
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zziu) {
            collection = ((zziu) collection).zzd();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final void zza(zzgt zzgt) {
        zzc();
        this.zzc.add(zzgt);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    private static String zza(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgt) {
            return ((zzgt) obj).zzb();
        }
        return zzie.zzb((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final List<?> zzd() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final zziu zze() {
        return zza() ? new zzkv(this) : this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ String set(int i, String str) {
        zzc();
        return zza(this.zzc.set(i, str));
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.measurement.zzgn
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.measurement.zzgn
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzgn
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ String remove(int i) {
        zzc();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zza(remove);
    }

    @Override // com.google.android.gms.internal.measurement.zzik, com.google.android.gms.internal.measurement.zzgn
    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ void add(int i, String str) {
        zzc();
        this.zzc.add(i, str);
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, com.google.android.gms.internal.measurement.zzgn
    public final /* bridge */ /* synthetic */ boolean add(String str) {
        return super.add(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzik
    public final /* synthetic */ zzik zza(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzir(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgt) {
            zzgt zzgt = (zzgt) obj;
            String zzb2 = zzgt.zzb();
            if (zzgt.zzc()) {
                this.zzc.set(i, zzb2);
            }
            return zzb2;
        }
        byte[] bArr = (byte[]) obj;
        String zzb3 = zzie.zzb(bArr);
        if (zzie.zza(bArr)) {
            this.zzc.set(i, zzb3);
        }
        return zzb3;
    }

    static {
        zzir zzir = new zzir();
        zza = zzir;
        zzir.zzb();
    }
}
