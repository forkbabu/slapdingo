package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdub;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
abstract class zzdug<V, C> extends zzdub<V, C> {
    private List<zzdui<V>> zzhod;

    zzdug(zzdsr<? extends zzdvf<? extends V>> zzdsr, boolean z) {
        super(zzdsr, true, true);
        List<zzdui<V>> list;
        if (zzdsr.isEmpty()) {
            list = zzdss.zzawm();
        } else {
            list = zzdta.zzeo(zzdsr.size());
        }
        for (int i = 0; i < zzdsr.size(); i++) {
            list.add(null);
        }
        this.zzhod = list;
    }

    /* access modifiers changed from: package-private */
    public abstract C zzj(List<zzdui<V>> list);

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdub
    public final void zzb(int i, @NullableDecl V v) {
        List<zzdui<V>> list = this.zzhod;
        if (list != null) {
            list.set(i, new zzdui<>(v));
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdub
    public final void zzawx() {
        List<zzdui<V>> list = this.zzhod;
        if (list != null) {
            set(zzj(list));
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdub
    public final void zza(zzdub.zza zza) {
        super.zza(zza);
        this.zzhod = null;
    }
}
