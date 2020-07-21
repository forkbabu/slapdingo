package com.google.android.gms.internal.clearcut;

final class zzdb extends zzcy {
    private zzdb() {
        super();
    }

    private static <E> zzcn<E> zzc(Object obj, long j) {
        return (zzcn) zzfd.zzo(obj, j);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.zzcy
    public final void zza(Object obj, long j) {
        zzc(obj, j).zzv();
    }

    /* JADX DEBUG: Additional 1 move instruction added to help type inference */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.clearcut.zzcn] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.clearcut.zzcy
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzcn zzc = zzc(obj, j);
        zzcn zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzu()) {
                zzc = zzc.zzi(size2 + size);
            }
            zzc.addAll(zzc2);
            zzc = zzc;
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzfd.zza(obj, j, zzc2);
    }
}
