package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
public final class zzkv extends AbstractList<String> implements zziu, RandomAccess {
    /* access modifiers changed from: private */
    public final zziu zza;

    public zzkv(zziu zziu) {
        this.zza = zziu;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final zziu zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final void zza(zzgt zzgt) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new zzky(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzkx(this);
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final List<?> zzd() {
        return this.zza.zzd();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.zza.get(i);
    }
}
