package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeha extends zzegv {
    private zzeha() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzegv
    public final <L> List<L> zza(Object obj, long j) {
        zzegm zzd = zzd(obj, j);
        if (zzd.zzbcy()) {
            return zzd;
        }
        int size = zzd.size();
        zzegm zzfs = zzd.zzfs(size == 0 ? 10 : size << 1);
        zzejf.zza(obj, j, zzfs);
        return zzfs;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzegv
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzbcz();
    }

    /* JADX DEBUG: Additional 1 move instruction added to help type inference */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.ads.zzegm] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzegv
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzegm zzd = zzd(obj, j);
        zzegm zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zzbcy()) {
                zzd = zzd.zzfs(size2 + size);
            }
            zzd.addAll(zzd2);
            zzd = zzd;
        }
        if (size > 0) {
            zzd2 = zzd;
        }
        zzejf.zza(obj, j, zzd2);
    }

    private static <E> zzegm<E> zzd(Object obj, long j) {
        return (zzegm) zzejf.zzp(obj, j);
    }
}
