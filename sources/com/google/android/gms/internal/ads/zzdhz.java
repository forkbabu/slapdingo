package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdhz implements zzduu<Void> {
    zzdhz(zzdhy zzdhy) {
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        zzaxv.zzeh("Notification of cache hit failed.");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(@NullableDecl Void voidR) {
        zzaxv.zzeh("Notification of cache hit successful.");
    }
}
