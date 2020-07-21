package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzhs extends zzhr {
    private zzhs() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzhr
    public final <L> List<L> zza(Object obj, long j) {
        zzhe zzc = zzc(obj, j);
        if (zzc.zzdp()) {
            return zzc;
        }
        int size = zzc.size();
        zzhe zzah = zzc.zzah(size == 0 ? 10 : size << 1);
        zzju.zza(obj, j, zzah);
        return zzah;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzhr
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzdq();
    }

    /* JADX DEBUG: Additional 1 move instruction added to help type inference */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.vision.zzhe] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzhr
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzhe zzc = zzc(obj, j);
        zzhe zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzdp()) {
                zzc = zzc.zzah(size2 + size);
            }
            zzc.addAll(zzc2);
            zzc = zzc;
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzju.zza(obj, j, zzc2);
    }

    private static <E> zzhe<E> zzc(Object obj, long j) {
        return (zzhe) zzju.zzp(obj, j);
    }
}
