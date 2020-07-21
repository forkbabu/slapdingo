package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzdo<E> extends zzdh<E> implements Set<E> {
    @NullableDecl
    private transient zzdk<E> zzmi;

    zzdo() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzdt.zza(this, obj);
    }

    public int hashCode() {
        return zzdt.zza(this);
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    public zzdk<E> zzcd() {
        zzdk<E> zzdk = this.zzmi;
        if (zzdk != null) {
            return zzdk;
        }
        zzdk<E> zzci = zzci();
        this.zzmi = zzci;
        return zzci;
    }

    /* access modifiers changed from: package-private */
    public zzdk<E> zzci() {
        return zzdk.zza(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.google.android.gms.internal.vision.zzdh, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
