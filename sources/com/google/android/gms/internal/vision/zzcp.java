package com.google.android.gms.internal.vision;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzcp<T> extends zzcs<T> {
    static final zzcp<Object> zzls = new zzcp<>();

    private zzcp() {
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.android.gms.internal.vision.zzcs
    public final boolean isPresent() {
        return false;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.vision.zzcs
    public final T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }
}
