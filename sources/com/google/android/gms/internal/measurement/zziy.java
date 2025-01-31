package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zziy extends zzit {
    private zziy() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <L> List<L> zza(Object obj, long j) {
        zzik zzc = zzc(obj, j);
        if (zzc.zza()) {
            return zzc;
        }
        int size = zzc.size();
        zzik zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzla.zza(obj, j, zza);
        return zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX DEBUG: Additional 1 move instruction added to help type inference */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.measurement.zzik] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzit
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzik zzc = zzc(obj, j);
        zzik zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zza()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
            zzc = zzc;
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzla.zza(obj, j, zzc2);
    }

    private static <E> zzik<E> zzc(Object obj, long j) {
        return (zzik) zzla.zzf(obj, j);
    }
}
