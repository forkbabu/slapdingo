package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdub;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdul<V> extends zzdub<Object, V> {
    /* access modifiers changed from: private */
    public zzdun<?> zzhog;

    zzdul(zzdsr<? extends zzdvf<?>> zzdsr, boolean z, Executor executor, Callable<V> callable) {
        super(zzdsr, z, false);
        this.zzhog = new zzduk(this, callable, executor);
        zzaww();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdub
    public final void zzb(int i, @NullableDecl Object obj) {
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdub
    public final void zzawx() {
        zzdun<?> zzdun = this.zzhog;
        if (zzdun != null) {
            zzdun.execute();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdub
    public final void zza(zzdub.zza zza) {
        super.zza(zza);
        if (zza == zzdub.zza.OUTPUT_FUTURE_DONE) {
            this.zzhog = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdtu
    public final void interruptTask() {
        zzdun<?> zzdun = this.zzhog;
        if (zzdun != null) {
            zzdun.interruptTask();
        }
    }
}
