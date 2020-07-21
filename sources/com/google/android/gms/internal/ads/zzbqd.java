package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbqd implements zzduu<Void> {
    private final /* synthetic */ zzbpz zzfqe;

    zzbqd(zzbpz zzbpz) {
        this.zzfqe = zzbpz;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        this.zzfqe.zzfpz.zzbh(false);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(@NullableDecl Void voidR) {
        this.zzfqe.zzfpz.zzbh(true);
    }
}
