package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdvw extends zzdve<zzdvf<V>> {
    private final /* synthetic */ zzdvt zzhpg;
    private final zzduf<V> zzhph;

    zzdvw(zzdvt zzdvt, zzduf<V> zzduf) {
        this.zzhpg = zzdvt;
        this.zzhph = (zzduf) zzdsh.checkNotNull(zzduf);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final boolean isDone() {
        return this.zzhpg.isDone();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final String zzaxc() {
        return this.zzhph.toString();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final /* synthetic */ void zzb(Object obj, Throwable th) {
        zzdvf zzdvf = (zzdvf) obj;
        if (th == null) {
            this.zzhpg.setFuture(zzdvf);
        } else {
            this.zzhpg.setException(th);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdve
    public final /* synthetic */ Object zzaxb() throws Exception {
        return (zzdvf) zzdsh.zza(this.zzhph.zzaqx(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzhph);
    }
}
